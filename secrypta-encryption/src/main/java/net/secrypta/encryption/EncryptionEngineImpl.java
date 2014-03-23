package net.secrypta.encryption;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Map.Entry;

import javax.crypto.SecretKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author hgeraldino
 * 
 */
public class EncryptionEngineImpl implements EncryptionEngine {

    static final Logger LOG = LoggerFactory.getLogger(EncryptionEngineImpl.class);

    @Override
    public byte[] getSHAMessageDigest(String plainText) {
        byte[] result = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(plainText.getBytes("UTF-16"));

            return md.digest();
        } catch (NoSuchAlgorithmException e) {
            LOG.error("Error: ", e);
        } catch (UnsupportedEncodingException e) {
            LOG.error("Error: ", e);
        }
        return result;
    }

    public String passwordBasedEncryption(String plainText, String encryptionKey) {
        // TODO Auto-generated method stub
        return null;
    }

    public String passwordBasedDecryption(String encryptedText, String encryptionKey) {
        // TODO Auto-generated method stub
        return null;
    }

    public String asymmetricEncryption(String plainText, PublicKey encryptionKey) {
        // TODO Auto-generated method stub
        return null;
    }

    public String asymmetricDecryption(String encryptedText, PrivateKey encryptionKey) {
        // TODO Auto-generated method stub
        return null;
    }

    public Entry<String, String> symmetricEncryption(String plainText, SecretKey encryptionKey) {
        // TODO Auto-generated method stub
        return null;
    }

    public String symmetricDecryption(String encryptedText, SecretKey encryptionKey) {
        // TODO Auto-generated method stub
        return null;
    }

}
