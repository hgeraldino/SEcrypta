package net.secrypta.encryption.service;

import java.util.Map;

import javax.crypto.SecretKey;

/**
 * 
 * @author hgeraldino
 * 
 */
public interface SymmetricEncryptionService extends EncryptionService {

    /**
     * 
     * @param plainText
     * @param encryptionKey
     * @return
     */
    Map.Entry<String, String> symmetricEncryption(String plainText, SecretKey encryptionKey);

    /**
     * 
     * @param encryptedText
     * @param encryptionKey
     * @return
     */
    String symmetricDecryption(String encryptedText, SecretKey encryptionKey);

    /**
     * 
     * @return
     */
    SecretKey newSymmetricKey();

}
