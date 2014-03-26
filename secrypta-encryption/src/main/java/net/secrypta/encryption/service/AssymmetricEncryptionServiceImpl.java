package net.secrypta.encryption.service;

import static org.apache.commons.codec.binary.Base64.encodeBase64String;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import net.secrypta.encryption.model.AssymmetricKeyPairData;
import net.secrypta.encryption.model.PrivateKeyData;
import net.secrypta.encryption.model.PublicKeyData;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.google.common.base.Throwables;

/**
 * 
 * @author hgeraldino
 * 
 */
public class AssymmetricEncryptionServiceImpl implements AssymmetricEncryptionService {

    static final Logger LOG = LoggerFactory.getLogger(AssymmetricEncryptionServiceImpl.class);

    @Autowired
    private CipherFactory cipherFactory;

    @Value("")
    private String xform;

    @Override
    public String encrypt(String plainText, PublicKey encryptionKey) {
        String result = null;

        Cipher cipher;
        try {
            cipher = cipherFactory.getCipher(encryptionKey, Cipher.ENCRYPT_MODE, xform);
            byte[] encryptedValue = cipher.doFinal(plainText.getBytes());
            result = encodeBase64String(encryptedValue);

        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e) {
            LOG.error("Error: ", e);
            Throwables.propagate(e);
        }

        return result;
    }

    @Override
    public String encrypt(String plainText, PublicKeyData publicKeyDataO) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String decrypt(String encryptedText, PrivateKey encryptionKey) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String decrypt(String encryptedText, PrivateKeyData privateKeyData, String passPhrase) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AssymmetricKeyPairData getKey(String passPhrase) {
        // TODO Auto-generated method stub
        return null;
    }

}
