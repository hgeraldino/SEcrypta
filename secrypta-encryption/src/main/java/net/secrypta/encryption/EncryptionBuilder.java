package net.secrypta.encryption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

/**
 * 
 * @author hgeraldino
 * 
 */
@Service
@Configuration
public class EncryptionBuilder {

    static final Logger LOG = LoggerFactory.getLogger(EncryptionBuilder.class);

    @Bean
    public AsymmetricBuilder asymmetricBuilder() {
        return new AsymmetricBuilder();
    }

    @Bean
    public SymmetricBuilder symmetricBuilder() {
        return new SymmetricBuilder();
    }
}
