package io.split.android.client.storage.cipher;

/* loaded from: classes6.dex */
public class NoOpCipher implements SplitCipher {
    @Override // io.split.android.client.storage.cipher.SplitCipher
    public String decrypt(String str) {
        return str;
    }

    @Override // io.split.android.client.storage.cipher.SplitCipher
    public String encrypt(String str) {
        return str;
    }
}
