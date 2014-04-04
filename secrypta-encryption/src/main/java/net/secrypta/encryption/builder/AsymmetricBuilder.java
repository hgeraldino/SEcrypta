package net.secrypta.encryption.builder;

import java.security.PrivateKey;
import java.security.PublicKey;

import net.secrypta.encryption.model.AsymmetricKeyPairData;
import net.secrypta.encryption.model.SymmetricKeyData;
import net.secrypta.encryption.service.AsymmetricEncryptionService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;

/**
 * 
 * @author hgeraldino
 * 
 */
@Service
public class AsymmetricBuilder {

    static final Logger LOG = LoggerFactory.getLogger(AsymmetricBuilder.class);

    @Autowired
    private AsymmetricEncryptionService encryptionService;

    private PublicKey publicKey;

    private PrivateKey privateKey;

    private AsymmetricKeyPairData keyPairData;

    private String passPhrase;

    public AsymmetricBuilder usingKeys(PublicKey publicKey, PrivateKey privateKey) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
        return this;
    }

    public AsymmetricBuilder usingKeyData(AsymmetricKeyPairData keyData) {
        this.keyPairData = keyData;
        return this;
    }

    public AsymmetricBuilder usingKeyData(AsymmetricKeyPairData keyData, String passPhrase) {
        this.keyPairData = keyData;
        this.passPhrase = passPhrase;
        return this;
    }

    public AsymmetricKeyPairData getNewKeyPair(String passPhrase) {
        AsymmetricKeyPairData keyPairData = encryptionService.generateKeyPairData();
        return keyPairData;
    }

    public String encrypt(SymmetricKeyData keyData) {
        validateEncryptionOp();
        return "";
    }

    public String encrypt(String plainText) {
        return encrypt(plainText.getBytes());
    }

    public String encrypt(byte[] contents) {
        validateEncryptionOp();
        return encryptionService.encrypt(contents, publicKey);
    }

    private void validateEncryptionOp() {
        if (publicKey == null) {
            Preconditions.checkNotNull(keyPairData);
            publicKey = (PublicKey) encryptionService.loadKeySpec(keyPairData.getPublicKeyData());
        }
    }

}
