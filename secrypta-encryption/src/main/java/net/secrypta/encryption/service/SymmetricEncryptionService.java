package net.secrypta.encryption.service;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Map;

import javax.crypto.SecretKey;

/**
 * 
 * @author hgeraldino
 * 
 */
public interface SymmetricEncryptionService {

    /**
     * 
     * @param plainText
     * @return
     */
    byte[] getSHAMessageDigest(String plainText);

    /**
     * 
     * @param plainText
     * @param encryptionKey
     * @return
     */
    String passwordBasedEncryption(String plainText, String encryptionKey);

    /**
     * 
     * @param encryptedText
     * @param encryptionKey
     * @return
     */
    String passwordBasedDecryption(String encryptedText, String encryptionKey);

    /**
     * 
     * @param plainText
     * @param encryptionKey
     * @return
     */
    String asymmetricEncryption(String plainText, PublicKey encryptionKey);

    /**
     * 
     * @param encryptedText
     * @param encryptionKey
     * @return
     */
    String asymmetricDecryption(String encryptedText, PrivateKey encryptionKey);

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

}
