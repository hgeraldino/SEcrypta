package net.secrypta.encryption.model;

import static org.apache.commons.codec.binary.Base64.encodeBase64String;

import java.security.spec.RSAPublicKeySpec;

/**
 * 
 * @author hgeraldino
 * 
 */
public class PublicKeyData implements AsymmetricKeyData {

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

    public PublicKeyData() {
    }

    public PublicKeyData(RSAPublicKeySpec publicKeySpec) {
        this.modulus =  encodeBase64String(publicKeySpec.getModulus().toByteArray());
        this.exponent = encodeBase64String(publicKeySpec.getPublicExponent().toByteArray());
    }
}
