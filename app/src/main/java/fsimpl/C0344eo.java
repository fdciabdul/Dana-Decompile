package fsimpl;

import android.content.Context;
import com.fullstory.util.Log;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: fsimpl.eo  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0344eo {
    private static AbstractC0345ep b;

    /* renamed from: a  reason: collision with root package name */
    static final SecureRandom f7974a = new SecureRandom();
    private static final CountDownLatch c = new CountDownLatch(1);

    public static AbstractC0345ep a() {
        try {
            if (!c.await(5L, TimeUnit.SECONDS)) {
                Log.e("Timed out waiting to initialize encryption");
            }
        } catch (InterruptedException e) {
            Log.e("Interrupted waiting to initialize encryption", e);
        }
        return b;
    }

    private static void a(Context context, KeyStore keyStore) {
        b = a(keyStore) ? C0346eq.a(context, keyStore) : C0347er.c(keyStore);
    }

    public static boolean a(Context context) {
        boolean z;
        synchronized (C0344eo.class) {
            if (c.getCount() == 1) {
                b(context);
            }
            z = b != null;
        }
        return z;
    }

    private static boolean a(KeyStore keyStore) {
        return C0346eq.b(keyStore);
    }

    private static void b(Context context) {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            try {
                a(context, keyStore);
            } catch (UnrecoverableKeyException e) {
                Log.logAlways("Attempting to recover from key exception");
                Log.e("Attempting to recover from key exception", e);
                b(keyStore);
                a(context, keyStore);
            }
            if (b != null) {
                Log.d("Successfully initialized encryption");
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    private static void b(KeyStore keyStore) {
        if (a(keyStore)) {
            C0346eq.a(keyStore);
        } else {
            C0347er.a(keyStore);
        }
    }
}
