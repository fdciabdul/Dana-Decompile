package io.split.android.client.storage.cipher;

import android.os.Build;
import io.split.android.client.storage.cipher.provider.KeyProvider;
import io.split.android.client.storage.cipher.provider.LegacyKeyProvider;
import io.split.android.client.storage.cipher.provider.SecureKeyStorageProvider;
import io.split.android.client.utils.logger.Logger;
import javax.annotation.Nullable;
import javax.crypto.SecretKey;

/* loaded from: classes6.dex */
public class KeyManager {
    private final KeyProvider mProvider;

    public KeyManager(KeyProvider keyProvider) {
        this.mProvider = keyProvider;
    }

    public KeyManager(String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            Logger.d("Using SecureKeyStorageProvider");
            this.mProvider = new SecureKeyStorageProvider(str);
            return;
        }
        Logger.d("Using LegacyKeyProvider");
        this.mProvider = new LegacyKeyProvider(str);
    }

    @Nullable
    public SecretKey getKey() {
        return this.mProvider.getKey();
    }
}
