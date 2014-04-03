package net.secrypta.encryption.model;

import java.io.Serializable;

/**
 * 
 * @author hgeraldino
 * 
 */
public interface AsymmetricKeyData extends Serializable {

    public String getModulus();

    public String getExponent();

}
