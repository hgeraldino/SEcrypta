package net.secrypta.encryption;

import java.security.Key;

import javax.crypto.SecretKey;

import net.secrypta.encryption.model.AsymmetricKeyData;
import net.secrypta.encryption.service.AsymmetricEncryptionService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author hgeraldino
 * 
 */
@Service
public class AsymmetricBuilder {

    static final Logger LOG = LoggerFactory.getLogger(AsymmetricBuilder.class);

    @Autowired
    private AsymmetricEncryptionService asymmetricEncryptionService;

    private Key key;

    public AsymmetricBuilder usingKey(Key key) {
        this.key = key;
        return this;
    }

    public AsymmetricBuilder usingKeyData(String keyData) {

        return this;
    }

    public AsymmetricBuilder usingKeyData(AsymmetricKeyData keyData) {
        return this;
    }

    public String encrypt(byte[] contents) {
        validate();

        return "";
    }

    public String encrypt(SecretKey key) {
        validate();

        return "";
    }

    private void validate() {

    }

}
