package net.secrypta.encryption.service;

import javax.crypto.SecretKey;

import net.secrypta.encryption.builder.EncryptionBuilder;
import net.secrypta.encryption.builder.SymmetricBuilder;
import net.secrypta.encryption.model.SymmetricEncryptionResult;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan(basePackages = { "net.secrypta.encryption" })
@SpringApplicationConfiguration(classes = SymmetricEncryptionTests.class)
@Configuration
public class SymmetricEncryptionTests {

    static final Logger LOG = LoggerFactory.getLogger(SymmetricEncryptionTests.class);

    private SymmetricBuilder builder;

    @Autowired
    private EncryptionBuilder encryptionBuilder;

    @Before
    public void init() {
        builder = encryptionBuilder.symmetricBuilder();
    }

    @Test
    public void testKeyCreation() {
        SecretKey key = builder.getNewKey();

        Assert.assertNotNull(key);
        Assert.assertEquals(key.getAlgorithm(), "AES");
    }

    @Test
    public void testStringEncryption() {
        String textToEncrypt = "Encrypt this text";
        SecretKey key = builder.getNewKey();

        SymmetricEncryptionResult result = builder.usingKey(key).encrypt(textToEncrypt);
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getKeyData());

        String decryptedText = builder.usingKeyData(result.getKeyData()).decrypt(result.getEncryptedValue());

        Assert.assertEquals(textToEncrypt, decryptedText);
    }

}
