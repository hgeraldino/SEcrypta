package net.secrypta.encryption.service;

import static org.apache.commons.codec.binary.Base64.encodeBase64String;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.annotation.PostConstruct;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import net.secrypta.encryption.EncryptionMode;
import net.secrypta.encryption.model.AsymmetricKeyPairData;
import net.secrypta.encryption.model.PrivateKeyData;
import net.secrypta.encryption.model.PublicKeyData;

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
public class AsymmetricEncryptionServiceImpl extends AbstractEncryptionServiceImpl implements AsymmetricEncryptionService {

    static final Logger LOG = LoggerFactory.getLogger(AsymmetricEncryptionServiceImpl.class);

    private KeyPairGenerator keyPairGenerator;

    @Autowired
    private CipherFactory cipherFactory;

    // @Value("")
    private String xform = "RSA/NONE/PKCS1PADDING";

    // @Value("")
    private int keySize = 1024;

    public void setKeyPairGenerator(KeyPairGenerator keyPairGenerator) {
        this.keyPairGenerator = keyPairGenerator;
    }

    public void setCipherFactory(CipherFactory cipherFactory) {
        this.cipherFactory = cipherFactory;
    }

    public void setXform(String xform) {
        this.xform = xform;
    }

    @PostConstruct
    public void init() {
        try {
            super.init();
            keyPairGenerator = KeyPairGenerator.getInstance(EncryptionMode.ASYMMETRIC.getAlgorithm(), "BC");
            keyPairGenerator.initialize(keySize);
        } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
            LOG.error("Error initializing the KPG: ", e);
            Throwables.propagate(e);
        }

    }

    @Override
    public String encrypt(SecretKey key, PublicKey encryptionKey) {
        String result = null;
        Cipher cipher;
        try {
            cipher = cipherFactory.getCipher(encryptionKey, Cipher.ENCRYPT_MODE, xform);
            byte[] encryptedValue = cipher.doFinal(key.getEncoded());
            result = encodeBase64String(encryptedValue);
        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e) {
            LOG.error("Error: ", e);
            Throwables.propagate(e);
        }

        return result;
    }

    @Override
    public String encrypt(SecretKey key, PublicKeyData publicKeyData) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SecretKey decrypt(String encryptedText, PrivateKey encryptionKey) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SecretKey decrypt(String encryptedText, PrivateKeyData privateKeyData) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AsymmetricKeyPairData serialize(PublicKey publicKey, PrivateKey privateKey, String passPhrase) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public KeyPair generateKeyPair() {
        // TODO Auto-generated method stub
        return null;
    }

    // @Override
    // public OutputStream encrypt(byte[] contents, PublicKey encryptionKey) {
    // Cipher cipher;
    // try (OutputStream stream = new ByteArrayOutputStream()) {
    //
    // cipher = cipherFactory.getCipher(encryptionKey, Cipher.ENCRYPT_MODE,
    // xform);
    // byte[] encryptedValue = cipher.doFinal(contents);
    //
    // stream.write(encryptedValue);
    // return stream;
    // } catch (IOException | InvalidKeyException | NoSuchAlgorithmException |
    // NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException
    // e) {
    // LOG.error("Error: ", e);
    // Throwables.propagate(e);
    //
    // }
    // return null;
    // }

}
