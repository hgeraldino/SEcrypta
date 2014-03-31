package net.secrypta.encryption;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.crypto.SecretKey;

import net.secrypta.encryption.model.SymmetricEncryptionResult;
import net.secrypta.encryption.model.SymmetricKeyData;
import net.secrypta.encryption.service.SymmetricEncryptionService;

import org.apache.commons.codec.CharEncoding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Throwables;

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

    private SecretKey key;

    public SymmetricBuilder() {
    }

    public SymmetricBuilder(SymmetricEncryptionService symmetricEncryptionService) {
        this.symmetricEncryptionService = symmetricEncryptionService;
    }

    public SymmetricBuilder usingKey(SecretKey key) {
        this.key = key;
        return this;
    }

    public SymmetricBuilder usingKeyData(SymmetricKeyData keydata) {
        return this;
    }

    public SecretKey getNewKey() {
        return symmetricEncryptionService.newSymmetricKey();
    }

    public SymmetricEncryptionResult encrypt(String input) {
        validate();

        try {
            return encrypt(input.getBytes(CharEncoding.UTF_16));
        } catch (UnsupportedEncodingException e) {
            LOG.error("Error: ", e);
            Throwables.propagate(e);
        }
        return null;
    }

    public SymmetricEncryptionResult encrypt(File inputFile) {
        validate();

        try {
            return encrypt(new FileInputStream(inputFile));
        } catch (FileNotFoundException e) {
            LOG.error("Error: ", e);
            Throwables.propagate(e);
        }

        return null;
    }

    public SymmetricEncryptionResult encrypt(byte[] contents) {
        validate();
        return symmetricEncryptionService.encrypt(contents, this.key);
    }

    public SymmetricEncryptionResult encrypt(InputStream stream) {
        validate();
        return symmetricEncryptionService.encrypt(new BufferedInputStream(stream), this.key);
    }

    private void validate() {
        if (this.key == null) {
            this.key = getNewKey();
        }
    }
}
