package net.secrypta.encryption.service;

import java.io.InputStream;
import java.security.Key;

import javax.crypto.SecretKey;

import net.secrypta.encryption.model.SymmetricEncryptionResult;

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
    SymmetricEncryptionResult encrypt(InputStream stream, SecretKey encryptionKey);

    /**
     * 
     * @param contents
     * @param encryptionKey
     * @return
     */
    SymmetricEncryptionResult encrypt(byte[] contents, SecretKey encryptionKey);

    /**
     * 
     * @param encryptedText
     * @param keySpec
     * @param initVector
     * @return
     */
    String decrypt(String encryptedText, Key keySpec, byte[] initVector);

    /**
     * 
     * @return
     */
    SecretKey newSymmetricKey();

}
