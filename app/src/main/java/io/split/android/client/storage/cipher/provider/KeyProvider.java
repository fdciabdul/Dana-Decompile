package io.split.android.client.storage.cipher.provider;

import javax.annotation.Nullable;
import javax.crypto.SecretKey;

/* loaded from: classes6.dex */
public interface KeyProvider {
    @Nullable
    SecretKey getKey();
}
