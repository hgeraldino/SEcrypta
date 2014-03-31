package net.secrypta.encryption;

import java.security.Key;

import javax.crypto.SecretKey;

import net.secrypta.encryption.model.AsymmetricKeyData;
import net.secrypta.encryption.service.SymmetricEncryptionService;

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
public class SymmetricBuilder {

    static final Logger LOG = LoggerFactory.getLogger(SymmetricBuilder.class);

    @Autowired
    private SymmetricEncryptionService symmetricEncryptionService;

    public void setSymmetricEncryptionService(SymmetricEncryptionService symmetricEncryptionService) {
        this.symmetricEncryptionService = symmetricEncryptionService;
    }

    private Key key;

    public SymmetricBuilder() {
    }

    public SymmetricBuilder(SymmetricEncryptionService symmetricEncryptionService) {
        this.symmetricEncryptionService = symmetricEncryptionService;
    }

    public SymmetricBuilder usingKey(Key key) {
        this.key = key;
        return this;
    }

    public SecretKey newKey() {
        return symmetricEncryptionService.newSymmetricKey();
    }

    public String encrypt(byte[] contents) {
        validate();

        return "";
    }

    private void validate() {

    }

}
