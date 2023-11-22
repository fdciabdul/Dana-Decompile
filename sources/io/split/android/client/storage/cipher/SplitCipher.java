package io.split.android.client.storage.cipher;

import javax.annotation.Nullable;

/* loaded from: classes6.dex */
public interface SplitCipher {
    @Nullable
    String decrypt(@Nullable String str);

    @Nullable
    String encrypt(@Nullable String str);
}
