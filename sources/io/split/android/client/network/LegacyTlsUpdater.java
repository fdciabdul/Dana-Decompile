package io.split.android.client.network;

import android.content.Context;
import android.os.Build;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.security.ProviderInstaller;
import io.split.android.client.utils.logger.Logger;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;

/* loaded from: classes6.dex */
public class LegacyTlsUpdater {
    private static final String TLS_VERSION = "TLSv1.2";

    public static boolean couldBeOld() {
        return Build.VERSION.SDK_INT < 22;
    }

    public static void update(Context context) {
        if (context == null) {
            return;
        }
        try {
            try {
                SSLContext.getInstance(TLS_VERSION);
            } catch (GooglePlayServicesNotAvailableException unused) {
                Logger.e("Couldn't update TLS version. Google Play Services is not available.");
            } catch (GooglePlayServicesRepairableException unused2) {
                Logger.e("Couldn't install TLS v1.2 Google Play Services version is very old.");
            }
        } catch (NoSuchAlgorithmException unused3) {
            Logger.i("TLS v1.2 is not available, installing...");
            ProviderInstaller.installIfNeeded(context.getApplicationContext());
        }
    }
}
