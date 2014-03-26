package net.secrypta.encryption.service;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;

import org.springframework.stereotype.Service;

@Service
public class CipherFactory {

    public Cipher getCipher(Key encryptionKey, int mode, String xform) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        Cipher cipher = Cipher.getInstance(xform);
        cipher.init(mode, encryptionKey);
        return cipher;
    }

    protected Cipher getCipher(Key encryptionKey, byte[] iv, int mode, String xform) throws NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeyException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance(xform);
        cipher.init(mode, encryptionKey, new IvParameterSpec(iv));
        return cipher;
    }

}