package io.split.android.client.storage.cipher.provider;

import android.security.keystore.KeyGenParameterSpec;
import io.split.android.client.utils.logger.Logger;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/* loaded from: classes6.dex */
public class SecureKeyStorageProvider implements KeyProvider {
    public static final String ALGORITHM = "AES";
    private static final String KEYSTORE_PROVIDER = "AndroidKeyStore";
    private static final String KEY_ALIAS_PREFIX = "split_key_";
    public static final int KEY_SIZE = 128;
    private final String mAlias;

    public SecureKeyStorageProvider(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(KEY_ALIAS_PREFIX);
        sb.append(str);
        this.mAlias = sb.toString();
    }

    @Override // io.split.android.client.storage.cipher.provider.KeyProvider
    public SecretKey getKey() {
        try {
            return getKeyFromKeystore();
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Error while getting key from Android KeyStore: ");
            sb.append(e.getMessage());
            Logger.e(sb.toString());
            return null;
        }
    }

    private SecretKey getKeyFromKeystore() throws KeyStoreException, CertificateException, IOException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchProviderException, UnrecoverableKeyException {
        KeyStore keyStore = KeyStore.getInstance(KEYSTORE_PROVIDER);
        keyStore.load(null);
        if (!keyStore.containsAlias(this.mAlias)) {
            return generateSecretKey(this.mAlias);
        }
        return (SecretKey) keyStore.getKey(this.mAlias, null);
    }

    private SecretKey generateSecretKey(String str) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM, KEYSTORE_PROVIDER);
        keyGenerator.init(new KeyGenParameterSpec.Builder(str, 3).setKeySize(128).setBlockModes("CBC").setRandomizedEncryptionRequired(false).setEncryptionPaddings("PKCS7Padding").build());
        return keyGenerator.generateKey();
    }
}
