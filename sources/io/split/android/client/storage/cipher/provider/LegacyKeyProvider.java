package io.split.android.client.storage.cipher.provider;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes6.dex */
public class LegacyKeyProvider implements KeyProvider {
    private static final String ALGORITHM = "AES";
    private static final int KEY_LENGTH = 16;
    private final SecretKey mSecretKey;

    public LegacyKeyProvider(String str) {
        this.mSecretKey = new SecretKeySpec(sanitizeKey(str).getBytes(), "AES");
    }

    @Override // io.split.android.client.storage.cipher.provider.KeyProvider
    public SecretKey getKey() {
        return this.mSecretKey;
    }

    private static String sanitizeKey(String str) {
        if (str.length() < 16) {
            return keyFilled(str);
        }
        return str.length() > 16 ? str.substring(0, 16) : str;
    }

    private static String keyFilled(String str) {
        int length = 16 - str.length();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append("0");
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append((Object) sb);
        return sb2.toString();
    }
}
