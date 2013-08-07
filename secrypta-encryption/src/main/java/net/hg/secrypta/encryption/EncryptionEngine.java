package net.hg.secrypta.encryption;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Map;

import javax.crypto.SecretKey;

public interface EncryptionEngine {

	String getMessageDigest(String plainText);

	String encryptValueWithPassword(String plainText, String encryptionKey);

	String decryptValueWithPassword(String encryptedText, String encryptionKey);

	String asymmetricEncryption(String plainText, PublicKey encryptionKey);

	String asymmetricDecryption(String encryptedText, PrivateKey encryptionKey);

	Map.Entry<String, String> symmetricEncryption(String plainText,
			SecretKey encryptionKey);

	String symmetricDecryption(String encryptedText, SecretKey encryptionKey);

}
