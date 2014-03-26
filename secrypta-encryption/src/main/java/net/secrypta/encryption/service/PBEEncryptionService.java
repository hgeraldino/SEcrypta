package net.secrypta.encryption.service;


/**
 * 
 * @author hgeraldino
 * 
 */
public interface PBEEncryptionService {

    /**
     * 
     * @param plainText
     * @param encryptionKey
     * @return
     */
    String encrypt(String plainText, String encryptionKey);

    /**
     * 
     * @param encryptedText
     * @param encryptionKey
     * @return
     */
    String decrypt(String encryptedText, String encryptionKey);

}
