package com.google.android.gms.auth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.common.BlockingServiceConnection;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesIncorrectManifestValueException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.auth.zzbw;
import com.google.android.gms.internal.auth.zzby;
import com.google.android.gms.internal.auth.zzdc;
import com.google.android.gms.internal.auth.zzhs;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/* loaded from: classes7.dex */
public class zzl {
    public static final int CHANGE_TYPE_ACCOUNT_ADDED = 1;
    public static final int CHANGE_TYPE_ACCOUNT_REMOVED = 2;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_FROM = 3;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_TO = 4;
    public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
    public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";
    public static final String WORK_ACCOUNT_TYPE = "com.google.work";
    public static final byte[] MyBillsEntityDataFactory = {45, -61, Ascii.ETB, 105, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4, -6, -23, 43, -55, -8, -4, -5, -2, -6, -27, 3, -14, -7, Ascii.GS, -45, 0, -17};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 13;
    public static final String[] zza = {"com.google", "com.google.work", "cn.google"};
    public static final String zzb = "androidPackageName";
    private static final ComponentName zzc = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
    private static final Logger zzd = zzd.zza("GoogleAuthUtil");

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002d -> B:11:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r5, short r6, short r7, java.lang.Object[] r8) {
        /*
            byte[] r0 = com.google.android.gms.auth.zzl.MyBillsEntityDataFactory
            int r5 = r5 * 5
            int r5 = r5 + 18
            int r6 = r6 + 4
            int r7 = r7 * 6
            int r7 = 103 - r7
            byte[] r1 = new byte[r5]
            r2 = -1
            int r5 = r5 + r2
            if (r0 != 0) goto L18
            r2 = r1
            r3 = -1
            r1 = r0
            r0 = r8
            r8 = r6
            goto L36
        L18:
            r4 = r7
            r7 = r6
            r6 = r4
        L1b:
            int r2 = r2 + 1
            byte r3 = (byte) r6
            r1[r2] = r3
            int r7 = r7 + 1
            if (r2 != r5) goto L2d
            java.lang.String r5 = new java.lang.String
            r6 = 0
            r5.<init>(r1, r6)
            r8[r6] = r5
            return
        L2d:
            r3 = r0[r7]
            r4 = r8
            r8 = r7
            r7 = r3
            r3 = r2
            r2 = r1
            r1 = r0
            r0 = r4
        L36:
            int r7 = -r7
            int r6 = r6 + r7
            int r6 = r6 + (-8)
            r7 = r8
            r8 = r0
            r0 = r1
            r1 = r2
            r2 = r3
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.zzl.a(int, short, short, java.lang.Object[]):void");
    }

    public static void clearToken(Context context, String str) throws GoogleAuthException, IOException {
        zze(context, str, 0L);
    }

    public static List<AccountChangeEvent> getAccountChangeEvents(Context context, int i, String str) throws GoogleAuthException, IOException {
        Preconditions.checkNotEmpty(str, "accountName must be provided");
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        zzk(context, 8400000);
        AccountChangeEventsRequest accountChangeEventsRequest = new AccountChangeEventsRequest();
        accountChangeEventsRequest.setAccountName(str);
        accountChangeEventsRequest.setEventIndex(i);
        zzdc.zze(context);
        if (zzhs.zzd() && zzo(context)) {
            try {
                AccountChangeEventsResponse accountChangeEventsResponse = (AccountChangeEventsResponse) zzi(com.google.android.gms.internal.auth.zzh.zza(context).zzb(accountChangeEventsRequest), "account change events retrieval");
                zzj(accountChangeEventsResponse);
                return accountChangeEventsResponse.getEvents();
            } catch (ApiException e) {
                zzl(e, "account change events retrieval");
            }
        }
        return (List) zzh(context, zzc, new zzi(accountChangeEventsRequest), 0L);
    }

    public static String getAccountId(Context context, String str) throws GoogleAuthException, IOException {
        Preconditions.checkNotEmpty(str, "accountName must be provided");
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        zzk(context, 8400000);
        return getToken(context, str, "^^_account_id_^^", new Bundle());
    }

    public static String getToken(Context context, Account account, String str) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return getToken(context, account, str, new Bundle());
    }

    @Deprecated
    public static void invalidateToken(Context context, String str) {
        AccountManager.get(context).invalidateAuthToken("com.google", str);
    }

    public static Bundle removeAccount(Context context, final Account account) throws GoogleAuthException, IOException {
        Preconditions.checkNotNull(context);
        zzn(account);
        zzk(context, 8400000);
        zzdc.zze(context);
        if (zzhs.zze() && zzo(context)) {
            try {
                Bundle bundle = (Bundle) zzi(com.google.android.gms.internal.auth.zzh.zza(context).zzd(account), "account removal");
                zzj(bundle);
                return bundle;
            } catch (ApiException e) {
                zzl(e, "account removal");
            }
        }
        return (Bundle) zzh(context, zzc, new zzk() { // from class: com.google.android.gms.auth.zzg
            @Override // com.google.android.gms.auth.zzk
            public final Object zza(IBinder iBinder) {
                Bundle zzf = com.google.android.gms.internal.auth.zze.zzb(iBinder).zzf(account);
                if (zzf != null) {
                    return zzf;
                }
                throw new IOException("Service call returned null.");
            }
        }, 0L);
    }

    public static Boolean requestGoogleAccountsAccess(Context context) throws GoogleAuthException, IOException {
        Preconditions.checkNotNull(context);
        zzk(context, 11400000);
        try {
            byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2 & 3);
            byte b2 = (byte) (-b);
            Object[] objArr = new Object[1];
            a(b, b2, (byte) (-b2), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(MyBillsEntityDataFactory[41], (byte) (-MyBillsEntityDataFactory[4]), MyBillsEntityDataFactory[41], objArr2);
            String str = ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(context, null)).packageName;
            zzdc.zze(context);
            if (zzhs.zze() && zzo(context)) {
                try {
                    Bundle bundle = (Bundle) zzi(com.google.android.gms.internal.auth.zzh.zza(context).zze(str), "google accounts access request");
                    String string = bundle.getString("Error");
                    Intent intent = (Intent) bundle.getParcelable("userRecoveryIntent");
                    zzby zza2 = zzby.zza(string);
                    if (zzby.SUCCESS.equals(zza2)) {
                        return true;
                    }
                    if (!zzby.zzb(zza2)) {
                        throw new GoogleAuthException(string);
                    }
                    zzd.w("isUserRecoverableError status: " + String.valueOf(zza2), new Object[0]);
                    throw new UserRecoverableAuthException(string, intent);
                } catch (ApiException e) {
                    zzl(e, "google accounts access request");
                }
            }
            return (Boolean) zzh(context, zzc, new zzj(str), 0L);
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public static TokenData zza(Context context, final Account account, final String str, Bundle bundle) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        Preconditions.checkNotEmpty(str, "Scope cannot be empty or null.");
        zzn(account);
        zzk(context, 8400000);
        final Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        zzm(context, bundle2);
        zzdc.zze(context);
        if (zzhs.zze() && zzo(context)) {
            try {
                Bundle bundle3 = (Bundle) zzi(com.google.android.gms.internal.auth.zzh.zza(context).zzc(account, str, bundle2), "token retrieval");
                zzj(bundle3);
                return zzg(bundle3);
            } catch (ApiException e) {
                zzl(e, "token retrieval");
            }
        }
        return (TokenData) zzh(context, zzc, new zzk() { // from class: com.google.android.gms.auth.zzf
            @Override // com.google.android.gms.auth.zzk
            public final Object zza(IBinder iBinder) {
                return zzl.zzb(account, str, bundle2, iBinder);
            }
        }, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TokenData zzb(Account account, String str, Bundle bundle, IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
        Bundle zze = com.google.android.gms.internal.auth.zze.zzb(iBinder).zze(account, str, bundle);
        if (zze == null) {
            throw new IOException("Service call returned null");
        }
        return zzg(zze);
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException
        */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ java.lang.Object zzd(java.lang.Object r0) {
        /*
            zzj(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.zzl.zzd(java.lang.Object):java.lang.Object");
    }

    public static void zze(Context context, String str, long j) throws GoogleAuthException, IOException {
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        zzk(context, 8400000);
        Bundle bundle = new Bundle();
        zzm(context, bundle);
        zzdc.zze(context);
        if (zzhs.zze() && zzo(context)) {
            com.google.android.gms.internal.auth.zzg zza2 = com.google.android.gms.internal.auth.zzh.zza(context);
            zzbw zzbwVar = new zzbw();
            zzbwVar.zza(str);
            try {
                zzi(zza2.zza(zzbwVar), "clear token");
                return;
            } catch (ApiException e) {
                zzl(e, "clear token");
            }
        }
        zzh(context, zzc, new zzh(str, bundle), 0L);
    }

    private static TokenData zzg(Bundle bundle) throws GoogleAuthException, IOException {
        TokenData tokenData;
        Parcelable.Creator<TokenData> creator = TokenData.CREATOR;
        ClassLoader classLoader = TokenData.class.getClassLoader();
        if (classLoader != null) {
            bundle.setClassLoader(classLoader);
        }
        Bundle bundle2 = bundle.getBundle("tokenDetails");
        if (bundle2 == null) {
            tokenData = null;
        } else {
            if (classLoader != null) {
                bundle2.setClassLoader(classLoader);
            }
            tokenData = (TokenData) bundle2.getParcelable("TokenData");
        }
        if (tokenData != null) {
            return tokenData;
        }
        String string = bundle.getString("Error");
        Preconditions.checkNotNull(string);
        Intent intent = (Intent) bundle.getParcelable("userRecoveryIntent");
        zzby zza2 = zzby.zza(string);
        if (!zzby.zzb(zza2)) {
            if (zzby.NETWORK_ERROR.equals(zza2) || zzby.SERVICE_UNAVAILABLE.equals(zza2) || zzby.INTNERNAL_ERROR.equals(zza2) || zzby.AUTH_SECURITY_ERROR.equals(zza2) || zzby.ACCOUNT_NOT_PRESENT.equals(zza2)) {
                throw new IOException(string);
            }
            throw new GoogleAuthException(string);
        }
        zzd.w("isUserRecoverableError status: ".concat(String.valueOf(String.valueOf(zza2))), new Object[0]);
        throw new UserRecoverableAuthException(string, intent);
    }

    private static Object zzh(Context context, ComponentName componentName, zzk zzkVar, long j) throws IOException, GoogleAuthException {
        BlockingServiceConnection blockingServiceConnection = new BlockingServiceConnection();
        GmsClientSupervisor gmsClientSupervisor = GmsClientSupervisor.getInstance(context);
        try {
            try {
                if (gmsClientSupervisor.bindService(componentName, blockingServiceConnection, "GoogleAuthUtil")) {
                    try {
                        return zzkVar.zza(blockingServiceConnection.getService());
                    } catch (RemoteException | InterruptedException | TimeoutException e) {
                        InstrumentInjector.log_i("GoogleAuthUtil", "Error on service connection.", e);
                        throw new IOException("Error on service connection.", e);
                    }
                }
                throw new IOException("Could not bind to service.");
            } finally {
                gmsClientSupervisor.unbindService(componentName, blockingServiceConnection, "GoogleAuthUtil");
            }
        } catch (SecurityException e2) {
            InstrumentInjector.log_w("GoogleAuthUtil", String.format("SecurityException while bind to auth service: %s", e2.getMessage()));
            throw new IOException("SecurityException while binding to Auth service.", e2);
        }
    }

    private static Object zzi(Task task, String str) throws IOException, ApiException {
        try {
            return Tasks.await(task);
        } catch (InterruptedException e) {
            String format = String.format("Interrupted while waiting for the task of %s to finish.", str);
            zzd.w(format, new Object[0]);
            throw new IOException(format, e);
        } catch (CancellationException e2) {
            String format2 = String.format("Canceled while waiting for the task of %s to finish.", str);
            zzd.w(format2, new Object[0]);
            throw new IOException(format2, e2);
        } catch (ExecutionException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof ApiException) {
                throw ((ApiException) cause);
            }
            String format3 = String.format("Unable to get a result for %s due to ExecutionException.", str);
            zzd.w(format3, new Object[0]);
            throw new IOException(format3, e3);
        }
    }

    private static Object zzj(Object obj) throws IOException {
        if (obj != null) {
            return obj;
        }
        zzd.w("Service call returned null.", new Object[0]);
        throw new IOException("Service unavailable.");
    }

    private static void zzk(Context context, int i) throws GoogleAuthException {
        try {
            GooglePlayServicesUtilLight.ensurePlayServicesAvailable(context.getApplicationContext(), i);
        } catch (GooglePlayServicesIncorrectManifestValueException e) {
            e = e;
            throw new GoogleAuthException(e.getMessage(), e);
        } catch (GooglePlayServicesNotAvailableException e2) {
            e = e2;
            throw new GoogleAuthException(e.getMessage(), e);
        } catch (GooglePlayServicesRepairableException e3) {
            throw new GooglePlayServicesAvailabilityException(e3.getConnectionStatusCode(), e3.getMessage(), e3.getIntent());
        }
    }

    private static void zzl(ApiException apiException, String str) {
        zzd.w("%s failed via GoogleAuthServiceClient, falling back to previous approach:\n%s", str, Log.getStackTraceString(apiException));
    }

    private static void zzm(Context context, Bundle bundle) {
        try {
            byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2 & 3);
            byte b2 = (byte) (-b);
            Object[] objArr = new Object[1];
            a(b, b2, (byte) (-b2), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(MyBillsEntityDataFactory[41], (byte) (-MyBillsEntityDataFactory[4]), MyBillsEntityDataFactory[41], objArr2);
            String str = ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(context, null)).packageName;
            bundle.putString("clientPackageName", str);
            String str2 = zzb;
            if (TextUtils.isEmpty(bundle.getString(str2))) {
                bundle.putString(str2, str);
            }
            bundle.putLong("service_connection_start_time_millis", SystemClock.elapsedRealtime());
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    private static boolean zzo(Context context) {
        if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context, 17895000) != 0) {
            return false;
        }
        List zzl = zzhs.zzb().zzl();
        try {
            byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2 & 3);
            byte b2 = (byte) (-b);
            Object[] objArr = new Object[1];
            a(b, b2, (byte) (-b2), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(MyBillsEntityDataFactory[41], (byte) (-MyBillsEntityDataFactory[4]), MyBillsEntityDataFactory[41], objArr2);
            String str = ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(context, null)).packageName;
            Iterator it = zzl.iterator();
            while (it.hasNext()) {
                if (((String) it.next()).equals(str)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public static String getToken(Context context, Account account, String str, Bundle bundle) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        zzn(account);
        return zza(context, account, str, bundle).zza();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzf(Intent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("Callback cannot be null.");
        }
        try {
            Intent.parseUri(intent.toUri(1), 1);
        } catch (URISyntaxException unused) {
            throw new IllegalArgumentException("Parameter callback contains invalid data. It must be serializable using toUri() and parseUri().");
        }
    }

    private static void zzn(Account account) {
        if (account == null) {
            throw new IllegalArgumentException("Account cannot be null");
        }
        if (!TextUtils.isEmpty(account.name)) {
            String[] strArr = zza;
            for (int i = 0; i < 3; i++) {
                if (strArr[i].equals(account.type)) {
                    return;
                }
            }
            throw new IllegalArgumentException("Account type not supported");
        }
        throw new IllegalArgumentException("Account name cannot be empty!");
    }

    @Deprecated
    public static String getToken(Context context, String str, String str2) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return getToken(context, new Account(str, "com.google"), str2);
    }

    @Deprecated
    public static String getToken(Context context, String str, String str2, Bundle bundle) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return getToken(context, new Account(str, "com.google"), str2, bundle);
    }
}
