package net.secrypta.encryption.model;

import static org.apache.commons.codec.binary.Base64.encodeBase64String;

import java.security.spec.RSAPrivateKeySpec;

/**
 * 
 * @author hgeraldino
 * 
 */
public class PrivateKeyData implements AsymmetricKeyData {

    private static final long serialVersionUID = 1L;

    private String modulus;

    private String exponent;

    public String getModulus() {
        return modulus;
    }

    public void setModulus(String modulus) {
        this.modulus = modulus;
    }

    public String getExponent() {
        return exponent;
    }

    public void setExponent(String exponent) {
        this.exponent = exponent;
    }

    public PrivateKeyData() {
    }

    public PrivateKeyData(RSAPrivateKeySpec privateKeySpec) {
        this.modulus = encodeBase64String(privateKeySpec.getModulus().toByteArray());
        this.exponent = encodeBase64String(privateKeySpec.getPrivateExponent().toByteArray());
    }

}
