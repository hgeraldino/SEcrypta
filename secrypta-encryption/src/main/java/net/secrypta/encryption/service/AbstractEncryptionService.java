package net.secrypta.encryption.service;

import java.security.Security;

import javax.annotation.PostConstruct;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 * 
 * @author hgeraldino
 * 
 */
public abstract class AbstractEncryptionService implements EncryptionService {

    @PostConstruct
    public void init() {
        if (Security.getProvider("BC") == null) {
            synchronized (this) {
                if (Security.getProvider("BC") == null) {
                    Security.insertProviderAt(new BouncyCastleProvider(), 1);
                }
            }
        }

    }

}
