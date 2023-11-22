package io.split.android.client.storage.cipher;

/* loaded from: classes6.dex */
public class SplitCipherFactory {
    public static SplitCipher create(String str, boolean z) {
        if (z) {
            try {
                return new CBCCipher(str);
            } catch (Exception unused) {
                return null;
            }
        }
        return new NoOpCipher();
    }

    public static SplitCipher create(String str, SplitEncryptionLevel splitEncryptionLevel) {
        if (splitEncryptionLevel == SplitEncryptionLevel.AES_128_CBC) {
            try {
                return new CBCCipher(str);
            } catch (Exception unused) {
                return null;
            }
        }
        return new NoOpCipher();
    }
}
