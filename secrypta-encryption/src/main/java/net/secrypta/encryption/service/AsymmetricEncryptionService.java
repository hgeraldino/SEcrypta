package net.secrypta.encryption.service;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.SecretKey;

import net.secrypta.encryption.model.AsymmetricKeyPairData;
import net.secrypta.encryption.model.PrivateKeyData;
import net.secrypta.encryption.model.PublicKeyData;

/**
 * 
 * @author hgeraldino
 * 
 */
public interface AsymmetricEncryptionService extends EncryptionService {

    /**
     * 
     * @param plainText
     * @param encryptionKey
     * @return
     */
    String encrypt(SecretKey key, PublicKey encryptionKey);

    /**
     * 
     * @param plainText
     * @param encryptionKey
     * @return
     */
    String encrypt(SecretKey key, PublicKeyData publicKeyData);

    /**
     * 
     * @param encryptedText
     * @param encryptionKey
     * @return
     */
    SecretKey decrypt(String encryptedText, PrivateKey encryptionKey);

    /**
     * 
     * @param encryptedText
     * @param encryptionKey
     * @return
     */
    SecretKey decrypt(String encryptedText, PrivateKeyData privateKeyData);

    /**
     * 
     * @param publicKey
     * @param privateKey
     * @param passPhrase
     * @return
     */
    AsymmetricKeyPairData serialize(PublicKey publicKey, PrivateKey privateKey, String passPhrase);

    /**
     * 
     * @return
     */
    KeyPair generateKeyPair();

}
