package net.secrypta.encryption.model;

import java.math.BigInteger;

/**
 * 
 * @author hgeraldino
 * 
 */
public class PrivateKeyData implements AsymmetricKeyData {

    private static final long serialVersionUID = 1L;

    private BigInteger modulus;

    private BigInteger exponent;

    public BigInteger getModulus() {
        return modulus;
    }

    public void setModulus(BigInteger modulus) {
        this.modulus = modulus;
    }

    public BigInteger getExponent() {
        return exponent;
    }

    public void setExponent(BigInteger exponent) {
        this.exponent = exponent;
    }

}
