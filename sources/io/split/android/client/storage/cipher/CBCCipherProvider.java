package io.split.android.client.storage.cipher;

import io.split.android.client.utils.logger.Logger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/* loaded from: classes6.dex */
public class CBCCipherProvider implements CipherProvider {
    private static final int DECRYPT_MODE = 2;
    private static final int ENCRYPT_MODE = 1;
    public static final int IV_LENGTH = 16;
    public static final int MAX_POOL_SIZE = 4;
    private static final String SPEC = "AES/CBC/PKCS7Padding";
    private final ObjectPool<Cipher> mCipherPool;
    private final IvParameterSpec mIvParameterSpec;
    private final SecretKey mKey;

    public CBCCipherProvider(String str) {
        this.mKey = new KeyManager(str).getKey();
        byte[] bArr = new byte[16];
        System.arraycopy(str.getBytes(), 0, bArr, 0, 16);
        this.mIvParameterSpec = new IvParameterSpec(bArr);
        this.mCipherPool = new ObjectPool<>(4, new CipherFactory());
    }

    @Override // io.split.android.client.storage.cipher.CipherProvider
    public Cipher getEncryptionCipher() {
        return getInitializedCipher(1);
    }

    @Override // io.split.android.client.storage.cipher.CipherProvider
    public Cipher getDecryptionCipher() {
        return getInitializedCipher(2);
    }

    @Override // io.split.android.client.storage.cipher.CipherProvider
    public void release(Cipher cipher) {
        this.mCipherPool.release(cipher);
    }

    private Cipher getInitializedCipher(int i) {
        try {
            Cipher acquire = this.mCipherPool.acquire();
            acquire.init(i, this.mKey, this.mIvParameterSpec);
            return acquire;
        } catch (InvalidAlgorithmParameterException | InvalidKeyException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Error initializing cipher: ");
            sb.append(e.getMessage());
            Logger.e(sb.toString());
            return null;
        }
    }

    /* loaded from: classes6.dex */
    static class CipherFactory implements ObjectPoolFactory<Cipher> {
        private CipherFactory() {
        }

        @Override // io.split.android.client.storage.cipher.ObjectPoolFactory
        public Cipher createObject() {
            try {
                return Cipher.getInstance(CBCCipherProvider.SPEC);
            } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Error creating cipher: ");
                sb.append(e.getMessage());
                Logger.e(sb.toString());
                return null;
            }
        }
    }
}
