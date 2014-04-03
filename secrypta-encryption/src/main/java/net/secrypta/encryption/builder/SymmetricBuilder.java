package net.secrypta.encryption.builder;

import static org.apache.commons.codec.binary.Base64.decodeBase64;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.Key;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

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

    private static final Logger LOG = LoggerFactory.getLogger(SymmetricBuilder.class);

    @Autowired
    private SymmetricEncryptionService encryptionService;

    public void setSymmetricEncryptionService(SymmetricEncryptionService symmetricEncryptionService) {
        this.encryptionService = symmetricEncryptionService;
    }

    private SecretKey key;

    private SymmetricKeyData keyData;

    public SymmetricBuilder() {
    }

    public SymmetricBuilder(SymmetricEncryptionService symmetricEncryptionService) {
        this.encryptionService = symmetricEncryptionService;
    }

    public SymmetricBuilder usingKey(SecretKey key) {
        this.key = key;
        return this;
    }

    public SymmetricBuilder usingKeyData(SymmetricKeyData keyData) {
        this.keyData = keyData;
        return this;
    }

    public SecretKey getNewKey() {
        return encryptionService.newSymmetricKey();
    }

    public SymmetricEncryptionResult encrypt(String plainText) {
        validateEncryptOp();

        try {
            return encrypt(plainText.getBytes(CharEncoding.UTF_8));
        } catch (UnsupportedEncodingException e) {
            LOG.error("Error: ", e);
            Throwables.propagate(e);
        }
        return null;
    }

    public SymmetricEncryptionResult encrypt(File inputFile) {
        validateEncryptOp();

        try {
            return encrypt(new FileInputStream(inputFile));
        } catch (FileNotFoundException e) {
            LOG.error("Error: ", e);
            Throwables.propagate(e);
        }

        return null;
    }

    public SymmetricEncryptionResult encrypt(byte[] contents) {
        validateEncryptOp();
        return encryptionService.encrypt(contents, this.key);
    }

    public SymmetricEncryptionResult encrypt(InputStream stream) {
        validateEncryptOp();
        return encryptionService.encrypt(new BufferedInputStream(stream), this.key);
    }

    public String decrypt(String encryptedText) {
        validateDecryptOp();
        Key key = new SecretKeySpec(decodeBase64(keyData.getEncodedKey()), EncryptionMode.SYMMETRIC.getAlgorithm());
        byte[] initVector = decodeBase64(keyData.getInitVector());

        return encryptionService.decrypt(encryptedText, key, initVector);
    }

    private void validateEncryptOp() {
        if (this.key == null) {
            this.key = getNewKey();
        }
    }

    private void validateDecryptOp() {
    }

}
