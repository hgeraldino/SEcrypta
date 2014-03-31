package net.secrypta.encryption.model;

import static org.apache.commons.codec.binary.Base64.encodeBase64String;

import java.io.Serializable;

/**
 * 
 * @author hgeraldino
 * 
 */
public class SymmetricEncryptionResult implements Serializable {

    private static final long serialVersionUID = 1L;

    private String encryptedValue;

    private SymmetricKeyData keyData = new SymmetricKeyData();

    public String getEncryptedValue() {
        return encryptedValue;
    }

    public void setEncryptedValue(String encryptedValue) {
        this.encryptedValue = encryptedValue;
    }

    public SymmetricKeyData getKeyData() {
        return keyData;
    }

    public void setKeyData(SymmetricKeyData keyData) {
        this.keyData = keyData;
    }

    public SymmetricEncryptionResult() {
    }

    public SymmetricEncryptionResult(byte[] encryptedContents, byte[] encodedKey, byte[] initVector) {
        this.encryptedValue = encodeBase64String(encryptedContents);
        this.getKeyData().setEncodedKey(encodeBase64String(encodedKey));
        this.getKeyData().setInitVector(encodeBase64String(initVector));
    }
}
