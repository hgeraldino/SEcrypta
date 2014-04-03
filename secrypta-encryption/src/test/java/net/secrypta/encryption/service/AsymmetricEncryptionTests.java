package net.secrypta.encryption.service;

import net.secrypta.encryption.builder.AsymmetricBuilder;
import net.secrypta.encryption.builder.EncryptionBuilder;
import net.secrypta.encryption.model.AsymmetricKeyPairData;

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
@SpringApplicationConfiguration(classes = AsymmetricEncryptionTests.class)
@Configuration
public class AsymmetricEncryptionTests {

    static final Logger LOG = LoggerFactory.getLogger(AsymmetricEncryptionTests.class);

    private final String pbeEncryptionPassPhrase = "n3t.53crYpt@/g/s";

    private AsymmetricBuilder builder;

    @Autowired
    private EncryptionBuilder encryptionBuilder;

    @Before
    public void init() {
        builder = encryptionBuilder.asymmetricBuilder();
    }

    @Test
    public void testAsymmetricEncryption() {
        String textToEncrypt = "Encrypt this text";
        AsymmetricKeyPairData keyPairData = builder.getNewKeyPair(pbeEncryptionPassPhrase);

        String encryptedText = builder.usingKeyData(keyPairData).encrypt(textToEncrypt);

        Assert.assertNotNull(encryptedText);
        Assert.assertNotEquals(encryptedText, textToEncrypt);

        System.out.println(encryptedText);
        
    }

}
