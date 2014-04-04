package net.secrypta.encryption.service;

import static org.apache.commons.codec.binary.Base64.decodeBase64;
import static org.apache.commons.codec.binary.Base64.encodeBase64String;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

import javax.annotation.PostConstruct;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import net.secrypta.encryption.builder.EncryptionMode;
import net.secrypta.encryption.model.AsymmetricKeyData;
import net.secrypta.encryption.model.AsymmetricKeyPairData;
import net.secrypta.encryption.model.PrivateKeyData;
import net.secrypta.encryption.model.PublicKeyData;

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
public class AsymmetricEncryptionServiceImpl extends AbstractEncryptionService implements AsymmetricEncryptionService {

    static final Logger LOG = LoggerFactory.getLogger(AsymmetricEncryptionServiceImpl.class);

    private KeyPairGenerator keyPairGenerator;

    private KeyFactory keyFactory;

    @Autowired
    private CipherFactory cipherFactory;

    // @Value("")
    private String xform = "RSA/NONE/PKCS1PADDING";

    // @Value("")
    private int keySize = 1024;

    public void setKeyPairGenerator(KeyPairGenerator keyPairGenerator) {
        this.keyPairGenerator = keyPairGenerator;
    }

    public void setCipherFactory(CipherFactory cipherFactory) {
        this.cipherFactory = cipherFactory;
    }

    public void setXform(String xform) {
        this.xform = xform;
    }

    @PostConstruct
    public void init() {
        try {
            super.init();
            keyPairGenerator = KeyPairGenerator.getInstance(EncryptionMode.ASYMMETRIC.getAlgorithm(), "BC");
            keyPairGenerator.initialize(keySize);

            keyFactory = KeyFactory.getInstance(EncryptionMode.ASYMMETRIC.getAlgorithm(), "BC");
        } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
            LOG.error("Error initializing the KPG: ", e);
            Throwables.propagate(e);
        }

    }

    @Override
    public String encrypt(SecretKey key, PublicKey encryptionKey) {
        String result = null;
        Cipher cipher;
        try {
            cipher = cipherFactory.getCipher(encryptionKey, Cipher.ENCRYPT_MODE, xform);
            byte[] encryptedValue = cipher.doFinal(key.getEncoded());
            result = encodeBase64String(encryptedValue);
        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e) {
            LOG.error("Error: ", e);
            Throwables.propagate(e);
        }

        return result;
    }

    @Override
    public SecretKey decrypt(String encryptedText, PrivateKey encryptionKey) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SecretKey decrypt(String encryptedText, PrivateKeyData privateKeyData) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AsymmetricKeyPairData generateKeyPairData() {
        AsymmetricKeyPairData result = null;
        RSAPublicKeySpec publicKey;
        RSAPrivateKeySpec privateKey;

        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        try {

            publicKey = keyFactory.getKeySpec(keyPair.getPublic(), RSAPublicKeySpec.class);
            privateKey = keyFactory.getKeySpec(keyPair.getPrivate(), RSAPrivateKeySpec.class);

            PublicKeyData publicKeyData = new PublicKeyData(publicKey);
            PrivateKeyData privateKeyData = new PrivateKeyData(privateKey);

            result = new AsymmetricKeyPairData(publicKeyData, privateKeyData);

        } catch (InvalidKeySpecException e) {
            LOG.error("Error: ", e);
            Throwables.propagate(e);
        }

        return result;
    }

    @Override
    public String encrypt(byte[] contents, PublicKey publicKey) {
        String result = null;
        Cipher cipher;

        try {
            cipher = cipherFactory.getCipher(publicKey, Cipher.ENCRYPT_MODE, xform);
            byte[] encryptedValue = cipher.doFinal(contents);
            result = encodeBase64String(encryptedValue);
        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e) {
            LOG.error("Error: ", e);
            Throwables.propagate(e);
        }

        return result;
    }

    @Override
    public Key loadKeySpec(AsymmetricKeyData keyData) {
        Key key = null;
        KeySpec keySpec;

        BigInteger modulus = new BigInteger(decodeBase64(keyData.getModulus()));
        BigInteger exponent = new BigInteger(decodeBase64(keyData.getExponent()));

        try {
            if (keyData instanceof PublicKeyData) {
                keySpec = new RSAPublicKeySpec(modulus, exponent);
                key = keyFactory.generatePublic(keySpec);
            } else if (keyData instanceof PrivateKeyData) {
                keySpec = new RSAPrivateKeySpec(modulus, exponent);
                key = keyFactory.generatePrivate(keySpec);
            }
        } catch (InvalidKeySpecException e) {
            LOG.error("Error: ", e);
            Throwables.propagate(e);
        }

        return key;
    }

}
