package net.secrypta.encryption.service;

import static org.apache.commons.codec.binary.Base64.decodeBase64;

import java.io.InputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import net.secrypta.encryption.model.SymmetricEncryptionResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Throwables;

/**
 * 
 * @author hgeraldino
 * 
 */
@Service
public class SymmetricEncryptionServiceImpl extends AbstractEncryptionServiceImpl implements SymmetricEncryptionService {

    static final Logger LOG = LoggerFactory.getLogger(SymmetricEncryptionServiceImpl.class);

    private static final SecureRandom secureRandom = new SecureRandom();

    @Autowired
    private CipherFactory cipherFactory;

    // @Value("")
    private String xform = "AES/CBC/PKCS5Padding";

    @Override
    public SecretKey newSymmetricKey() {
        byte[] key = new byte[16];
        secureRandom.nextBytes(key);
        return new SecretKeySpec(key, "AES");
    }

    @Override
    public SymmetricEncryptionResult encrypt(InputStream stream, SecretKey encryptionKey) {
        Throwables.propagate(new UnsupportedOperationException("not implemented"));
        return null;
    }

    @Override
    public SymmetricEncryptionResult encrypt(byte[] contents, SecretKey encryptionKey) {
        SymmetricEncryptionResult result = null;

        Cipher cipher;
        try {
            cipher = cipherFactory.getCipher(encryptionKey, Cipher.ENCRYPT_MODE, xform);
            byte[] encryptedValue = cipher.doFinal(contents);

            result = new SymmetricEncryptionResult(encryptedValue, encryptionKey.getEncoded(), cipher.getIV());
        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e) {
            LOG.error("Error: ", e);
            Throwables.propagate(e);
        }

        return result;

    }

    @Override
    public String decrypt(String encryptedText, Key keySpec, byte[] initVector) {
        String result = null;

        Cipher cipher;
        try {
            cipher = cipherFactory.getCipher(keySpec, initVector, Cipher.DECRYPT_MODE, xform);
            result = new String(cipher.doFinal(decodeBase64(encryptedText)));
        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException
                | BadPaddingException e) {
            LOG.error("Error: ", e);
            Throwables.propagate(e);
        }

        return result;
    }
}