package net.secrypta.encryption;

/**
 * 
 * @author hgeraldino
 * 
 */
public enum EncryptionMode {
    PBE("PBE"), SYMMETRIC("AES"), ASYMMETRIC("RSA");

    private String algorithm;

    private EncryptionMode(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getAlgorithm() {
        return algorithm;
    }

}
