package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class ProviderInstaller {
    public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
    public static final byte[] MyBillsEntityDataFactory = {113, -101, 105, Ascii.SUB, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
    public static final int getAuthRequestContext = 211;
    private static final GoogleApiAvailabilityLight zza = GoogleApiAvailabilityLight.getInstance();
    private static final Object zzb = new Object();
    private static Method zzc = null;
    private static Method zzd = null;

    /* loaded from: classes.dex */
    public interface ProviderInstallListener {
        void onProviderInstallFailed(int i, Intent intent);

        void onProviderInstalled();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x001f -> B:11:0x0027). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(java.lang.Object[] r8) {
        /*
            byte[] r0 = com.google.android.gms.security.ProviderInstaller.MyBillsEntityDataFactory
            r1 = 23
            byte[] r1 = new byte[r1]
            r2 = 97
            r3 = 4
            r4 = 0
            if (r0 != 0) goto Lf
            r5 = 4
            r6 = 0
            goto L27
        Lf:
            r5 = 0
        L10:
            byte r6 = (byte) r2
            r1[r5] = r6
            r6 = 22
            if (r5 != r6) goto L1f
            java.lang.String r0 = new java.lang.String
            r0.<init>(r1, r4)
            r8[r4] = r0
            return
        L1f:
            int r5 = r5 + 1
            r6 = r0[r3]
            r7 = r5
            r5 = r3
            r3 = r6
            r6 = r7
        L27:
            int r3 = -r3
            int r2 = r2 + r3
            int r3 = r5 + 1
            int r2 = r2 + (-8)
            r5 = r6
            goto L10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.security.ProviderInstaller.a(java.lang.Object[]):void");
    }

    public static void installIfNeeded(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        Context context2;
        Preconditions.checkNotNull(context, "Context must not be null");
        zza.verifyGooglePlayServicesIsAvailable(context, 11925000);
        synchronized (zzb) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                context2 = DynamiteModule.load(context, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "com.google.android.gms.providerinstaller.dynamite").getModuleContext();
            } catch (DynamiteModule.LoadingException e) {
                InstrumentInjector.log_w("ProviderInstaller", "Failed to load providerinstaller module: ".concat(String.valueOf(e.getMessage())));
                context2 = null;
            }
            if (context2 == null) {
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
                if (remoteContext != null) {
                    try {
                        if (zzd == null) {
                            Object[] objArr = new Object[1];
                            a(objArr);
                            zzd = zzb(remoteContext, "com.google.android.gms.common.security.ProviderInstallerImpl", "reportRequestStats", new Class[]{Class.forName((String) objArr[0]), Long.TYPE, Long.TYPE});
                        }
                        zzd.invoke(null, context, Long.valueOf(elapsedRealtime), Long.valueOf(elapsedRealtime2));
                    } catch (Exception e2) {
                        InstrumentInjector.log_w("ProviderInstaller", "Failed to report request stats: ".concat(String.valueOf(e2.getMessage())));
                    }
                }
                if (remoteContext != null) {
                    zzc(remoteContext, context, "com.google.android.gms.common.security.ProviderInstallerImpl");
                    return;
                } else {
                    InstrumentInjector.log_e("ProviderInstaller", "Failed to get remote context");
                    throw new GooglePlayServicesNotAvailableException(8);
                }
            }
            zzc(context2, context, "com.google.android.gms.providerinstaller.ProviderInstallerImpl");
        }
    }

    public static void installIfNeededAsync(Context context, ProviderInstallListener providerInstallListener) {
        Preconditions.checkNotNull(context, "Context must not be null");
        Preconditions.checkNotNull(providerInstallListener, "Listener must not be null");
        Preconditions.checkMainThread("Must be called on the UI thread");
        new zza(context, providerInstallListener).execute(new Void[0]);
    }

    private static Method zzb(Context context, String str, String str2, Class[] clsArr) throws ClassNotFoundException, NoSuchMethodException {
        return context.getClassLoader().loadClass(str).getMethod(str2, clsArr);
    }

    private static void zzc(Context context, Context context2, String str) throws GooglePlayServicesNotAvailableException {
        try {
            if (zzc == null) {
                Object[] objArr = new Object[1];
                a(objArr);
                zzc = zzb(context, str, "insertProvider", new Class[]{Class.forName((String) objArr[0])});
            }
            zzc.invoke(null, context);
        } catch (Exception e) {
            Throwable cause = e.getCause();
            if (Log.isLoggable("ProviderInstaller", 6)) {
                InstrumentInjector.log_e("ProviderInstaller", "Failed to install provider: ".concat(String.valueOf(cause == null ? e.getMessage() : cause.getMessage())));
            }
            throw new GooglePlayServicesNotAvailableException(8);
        }
    }
}
