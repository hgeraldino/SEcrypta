package net.secrypta.encryption.model;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * 
 * @author hgeraldino
 * 
 */
public interface AsymmetricKeyData extends Serializable {

    public BigInteger getModulus();

    public BigInteger getExponent();

}
