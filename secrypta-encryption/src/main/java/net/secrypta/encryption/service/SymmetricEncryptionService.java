package net.secrypta.encryption.service;

import java.io.InputStream;

import javax.crypto.SecretKey;

import net.secrypta.encryption.model.SymmetricEncryptionResult;
import net.secrypta.encryption.model.SymmetricKeyData;

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
     * @param encryptionKey
     * @return
     */
    String decrypt(String encryptedText, SymmetricKeyData keyData);

    /**
     * 
     * @return
     */
    SecretKey newSymmetricKey();

}
