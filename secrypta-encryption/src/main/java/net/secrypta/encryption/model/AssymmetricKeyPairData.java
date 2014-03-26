package net.secrypta.encryption.model;

import java.io.Serializable;

/**
 * 
 * @author hgeraldino
 * 
 */
public class AssymmetricKeyPairData implements Serializable {

    private static final long serialVersionUID = 1L;

    private PrivateKeyData privateKeyData;

    private PublicKeyData publicKeyData;

    public PrivateKeyData getPrivateKeyData() {
        return privateKeyData;
    }

    public void setPrivateKeyData(PrivateKeyData privateKeyData) {
        this.privateKeyData = privateKeyData;
    }

    public PublicKeyData getPublicKeyData() {
        return publicKeyData;
    }

    public void setPublicKeyData(PublicKeyData publicKeyData) {
        this.publicKeyData = publicKeyData;
    }

}
