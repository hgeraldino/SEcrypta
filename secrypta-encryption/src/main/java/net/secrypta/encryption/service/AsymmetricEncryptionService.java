package net.secrypta.encryption.service;

import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.SecretKey;

import net.secrypta.encryption.model.AsymmetricKeyData;
import net.secrypta.encryption.model.AsymmetricKeyPairData;
import net.secrypta.encryption.model.PrivateKeyData;

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
     * @param contents
     * @param publicKey
     * @return
     */
    String encrypt(byte[] contents, PublicKey publicKey);

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
     * @return
     */
    AsymmetricKeyPairData generateKeyPairData();

    /**
     * 
     * @param keyData
     * @return
     */
    Key loadKeySpec(AsymmetricKeyData keyData);

}
