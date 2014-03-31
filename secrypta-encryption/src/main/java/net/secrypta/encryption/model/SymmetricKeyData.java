package net.secrypta.encryption.model;

import java.io.Serializable;

/**
 * 
 * @author hgeraldino
 * 
 */
public class SymmetricKeyData implements Serializable {

    private static final long serialVersionUID = 1L;

    private String encodedKey;

    private String initVector;

    public String getEncodedKey() {
        return encodedKey;
    }

    public void setEncodedKey(String encodedKey) {
        this.encodedKey = encodedKey;
    }

    public String getInitVector() {
        return initVector;
    }

    public void setInitVector(String initVector) {
        this.initVector = initVector;
    }

}
