package net.secrypta.encryption.service;

import java.security.SecureRandom;
import java.util.Map.Entry;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

//    @Value("")
    private String xform;

    @Override
    public SecretKey newSymmetricKey() {
        byte[] key = new byte[16];
        secureRandom.nextBytes(key);
        return new SecretKeySpec(key, "AES");
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