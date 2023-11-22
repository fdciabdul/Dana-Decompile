package fsimpl;

import android.security.keystore.KeyGenParameterSpec;
import com.google.android.gms.stats.CodePackage;
import io.split.android.client.storage.cipher.provider.SecureKeyStorageProvider;
import java.security.Key;
import java.security.KeyStore;
import javax.crypto.KeyGenerator;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: fsimpl.er  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0347er extends AbstractC0345ep {
    private C0347er(Key key) {
        super(key);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(KeyStore keyStore) {
        keyStore.deleteEntry("fullstory-modern");
    }

    static boolean b(KeyStore keyStore) {
        return keyStore.containsAlias("fullstory-modern");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AbstractC0345ep c(KeyStore keyStore) {
        if (!b(keyStore)) {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(SecureKeyStorageProvider.ALGORITHM, "AndroidKeyStore");
            keyGenerator.init(new KeyGenParameterSpec.Builder("fullstory-modern", 3).setBlockModes(CodePackage.GCM).setEncryptionPaddings("NoPadding").build());
            keyGenerator.generateKey();
        }
        return new C0347er(keyStore.getKey("fullstory-modern", null));
    }
}
