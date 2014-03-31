package net.secrypta.encryption.service;

import java.security.KeyPair;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan(basePackages = { "net.secrypta.encryption" })
@SpringApplicationConfiguration(classes = AssymmetricEncryptionTests.class)
public class AssymmetricEncryptionTests {

    static final Logger LOG = LoggerFactory.getLogger(AssymmetricEncryptionTests.class);

    @Autowired
    private AsymmetricEncryptionService encryptionService;

    @Test
    public void testAsymmetricEncryption() {
        KeyPair kp = encryptionService.generateKeyPair();
    }

}
