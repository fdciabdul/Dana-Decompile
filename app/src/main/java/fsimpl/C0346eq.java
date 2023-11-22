package fsimpl;

import android.content.Context;
import android.content.SharedPreferences;
import android.security.KeyPairGeneratorSpec;
import android.util.Base64;
import com.iap.ac.android.common.utils.security.RSAHelper;
import io.split.android.client.storage.cipher.provider.SecureKeyStorageProvider;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Calendar;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: fsimpl.eq  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0346eq extends AbstractC0345ep {
    private C0346eq(Key key) {
        super(key);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AbstractC0345ep a(Context context, KeyStore keyStore) {
        if (!b(keyStore)) {
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.add(1, 30);
            KeyPairGeneratorSpec build = new KeyPairGeneratorSpec.Builder(context).setAlias("fullstory-legacy").setSubject(new X500Principal("CN=fullstory-legacy")).setSerialNumber(BigInteger.TEN).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).build();
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSAHelper.DEFAULT_ALGORITHM, "AndroidKeyStore");
            keyPairGenerator.initialize(build);
            keyPairGenerator.generateKeyPair();
        }
        return new C0346eq(a(keyStore, b(context, keyStore)));
    }

    private static String a(SharedPreferences sharedPreferences, KeyStore keyStore) {
        byte[] bArr = new byte[16];
        C0344eo.f7974a.nextBytes(bArr);
        byte[] a2 = a(keyStore, bArr);
        StringBuilder sb = new StringBuilder();
        sb.append("fskey-");
        sb.append(Base64.encodeToString(a2, 0));
        String obj = sb.toString();
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("fullstory-key-encrypted", obj);
        edit.commit();
        return obj;
    }

    private static Key a(KeyStore keyStore, String str) {
        return new SecretKeySpec(b(keyStore, Base64.decode(str, 0)), SecureKeyStorageProvider.ALGORITHM);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(KeyStore keyStore) {
        keyStore.deleteEntry("fullstory-legacy");
    }

    private static byte[] a(KeyStore keyStore, byte[] bArr) {
        KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) keyStore.getEntry("fullstory-legacy", null);
        Cipher cipher = Cipher.getInstance(RSAHelper.DEFAULT_TRANSFORMATION, b());
        cipher.init(1, privateKeyEntry.getCertificate().getPublicKey());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        CipherOutputStream cipherOutputStream = new CipherOutputStream(byteArrayOutputStream, cipher);
        cipherOutputStream.write(bArr);
        cipherOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    private static String b() {
        return "AndroidKeyStoreBCWorkaround";
    }

    private static String b(Context context, KeyStore keyStore) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("fullstory-key-prefs", 0);
        String string = sharedPreferences.getString("fullstory-key-encrypted", null);
        if (string == null) {
            string = a(sharedPreferences, keyStore);
        }
        if (string.startsWith("fskey-")) {
            return string.substring(6);
        }
        throw new GeneralSecurityException("Unknown key prefix");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(KeyStore keyStore) {
        return keyStore.containsAlias("fullstory-legacy");
    }

    private static byte[] b(KeyStore keyStore, byte[] bArr) {
        KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) keyStore.getEntry("fullstory-legacy", null);
        Cipher cipher = Cipher.getInstance(RSAHelper.DEFAULT_TRANSFORMATION, b());
        cipher.init(2, privateKeyEntry.getPrivateKey());
        CipherInputStream cipherInputStream = new CipherInputStream(new ByteArrayInputStream(bArr), cipher);
        ArrayList arrayList = new ArrayList();
        while (true) {
            int read = cipherInputStream.read();
            if (read == -1) {
                break;
            }
            arrayList.add(Byte.valueOf((byte) read));
        }
        int size = arrayList.size();
        byte[] bArr2 = new byte[size];
        for (int i = 0; i < size; i++) {
            bArr2[i] = ((Byte) arrayList.get(i)).byteValue();
        }
        return bArr2;
    }
}
