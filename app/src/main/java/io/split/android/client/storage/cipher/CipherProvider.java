package io.split.android.client.storage.cipher;

import javax.crypto.Cipher;

/* loaded from: classes6.dex */
public interface CipherProvider {
    Cipher getDecryptionCipher();

    Cipher getEncryptionCipher();

    void release(Cipher cipher);
}
