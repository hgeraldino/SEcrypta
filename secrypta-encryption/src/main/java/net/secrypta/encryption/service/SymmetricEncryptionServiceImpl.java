package net.secrypta.encryption.service;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Map.Entry;

import javax.crypto.SecretKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * 
 * @author hgeraldino
 * 
 */
public class SymmetricEncryptionServiceImpl implements SymmetricEncryptionService {

    static final Logger LOG = LoggerFactory.getLogger(SymmetricEncryptionServiceImpl.class);

    @Autowired
    private CipherFactory cipherFactory;

    @Value("")
    private String xform;

    @Override
    public byte[] getSHAMessageDigest(String plainText) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String passwordBasedEncryption(String plainText, String encryptionKey) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String passwordBasedDecryption(String encryptedText, String encryptionKey) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String asymmetricEncryption(String plainText, PublicKey encryptionKey) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String asymmetricDecryption(String encryptedText, PrivateKey encryptionKey) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Entry<String, String> symmetricEncryption(String plainText, SecretKey encryptionKey) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String symmetricDecryption(String encryptedText, SecretKey encryptionKey) {
        // TODO Auto-generated method stub
        return null;
    }

}
