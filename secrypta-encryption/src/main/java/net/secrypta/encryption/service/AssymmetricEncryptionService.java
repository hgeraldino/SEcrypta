package net.secrypta.encryption.service;

import java.security.PrivateKey;
import java.security.PublicKey;

import net.secrypta.encryption.model.AssymmetricKeyPairData;
import net.secrypta.encryption.model.PrivateKeyData;
import net.secrypta.encryption.model.PublicKeyData;

/**
 * 
 * @author hgeraldino
 * 
 */
public interface AssymmetricEncryptionService {

    /**
     * 
     * @param plainText
     * @param encryptionKey
     * @return
     */
    String encrypt(String plainText, PublicKey encryptionKey);

    /**
     * 
     * @param plainText
     * @param encryptionKey
     * @return
     */
    String encrypt(String plainText, PublicKeyData publicKeyDataO);

    /**
     * 
     * @param encryptedText
     * @param encryptionKey
     * @return
     */
    String decrypt(String encryptedText, PrivateKey encryptionKey);

    /**
     * 
     * @param encryptedText
     * @param privateKeyData
     * @param passPhrase
     * @return
     */
    String decrypt(String encryptedText, PrivateKeyData privateKeyData, String passPhrase);
    
    /**
     * 
     * @param passPhrase
     * @return
     */
    AssymmetricKeyPairData getKey(String passPhrase);
    

}
