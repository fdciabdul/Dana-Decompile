package io.branch.referral;

import android.app.UiModeManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.common.primitives.SignedBytes;
import io.branch.referral.Defines;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class SystemObserver {
    String MyBillsEntityDataFactory = null;
    int KClassImpl$Data$declaredNonStaticMembers$2 = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface GAdsParamsFetchEvents {
        void getErrorConfigVersion();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String BuiltInFictitiousFunctionClassFactory() {
        return "Android";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static UniqueId getAuthRequestContext(Context context, boolean z) {
        return new UniqueId(context, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String BuiltInFictitiousFunctionClassFactory(Context context) {
        if (context != null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
            } catch (Exception e) {
                PrefHelper.KClassImpl$Data$declaredNonStaticMembers$2("Error obtaining PackageName", e);
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0020 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String MyBillsEntityDataFactory(android.content.Context r2) {
        /*
            if (r2 == 0) goto L18
            android.content.pm.PackageManager r0 = r2.getPackageManager()     // Catch: java.lang.Exception -> L12
            java.lang.String r2 = r2.getPackageName()     // Catch: java.lang.Exception -> L12
            r1 = 0
            android.content.pm.PackageInfo r2 = r0.getPackageInfo(r2, r1)     // Catch: java.lang.Exception -> L12
            java.lang.String r2 = r2.versionName     // Catch: java.lang.Exception -> L12
            goto L1a
        L12:
            r2 = move-exception
            java.lang.String r0 = "Error obtaining AppVersion"
            io.branch.referral.PrefHelper.KClassImpl$Data$declaredNonStaticMembers$2(r0, r2)
        L18:
            java.lang.String r2 = ""
        L1a:
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 == 0) goto L22
            java.lang.String r2 = "bnc_no_value"
        L22:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.SystemObserver.MyBillsEntityDataFactory(android.content.Context):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long KClassImpl$Data$declaredNonStaticMembers$2(Context context) {
        if (context != null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
            } catch (Exception e) {
                PrefHelper.KClassImpl$Data$declaredNonStaticMembers$2("Error obtaining FirstInstallTime", e);
            }
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean scheduleImpl(Context context) {
        List<ResolveInfo> queryIntentActivities;
        if (context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
                if (launchIntentForPackage == null || (queryIntentActivities = packageManager.queryIntentActivities(launchIntentForPackage, 65536)) == null) {
                    return false;
                }
                return queryIntentActivities.size() > 0;
            } catch (Exception e) {
                PrefHelper.KClassImpl$Data$declaredNonStaticMembers$2("Error obtaining PackageInfo", e);
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getAuthRequestContext(Context context) {
        if (context != null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
            } catch (Exception e) {
                PrefHelper.KClassImpl$Data$declaredNonStaticMembers$2("Error obtaining LastUpdateTime", e);
            }
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String moveToNextValue() {
        return Build.MANUFACTURER;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String lookAheadTest() {
        return Build.MODEL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getAuthRequestContext() {
        return Locale.getDefault() != null ? Locale.getDefault().getCountry() : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String MyBillsEntityDataFactory() {
        return Locale.getDefault() != null ? Locale.getDefault().getLanguage() : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int PlaceComponentResult() {
        return Build.VERSION.SDK_INT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DisplayMetrics getErrorConfigVersion(Context context) {
        WindowManager windowManager;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (context != null && (windowManager = (WindowManager) context.getSystemService("window")) != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean lookAheadTest(Context context) {
        if (context != null && context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo networkInfo = connectivityManager != null ? connectivityManager.getNetworkInfo(1) : null;
            if (networkInfo != null && networkInfo.isConnected()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean BuiltInFictitiousFunctionClassFactory(Context context, GAdsParamsFetchEvents gAdsParamsFetchEvents) {
        if (TextUtils.isEmpty(this.MyBillsEntityDataFactory)) {
            new GAdsPrefetchTask(context, gAdsParamsFetchEvents).KClassImpl$Data$declaredNonStaticMembers$2(new Void[0]);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class GAdsPrefetchTask extends BranchAsyncTask<Void, Void, Void> {
        private WeakReference<Context> BuiltInFictitiousFunctionClassFactory;
        private final GAdsParamsFetchEvents KClassImpl$Data$declaredNonStaticMembers$2;
        public static final byte[] getAuthRequestContext = {SignedBytes.MAX_POWER_OF_TWO, 19, 79, -17, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
        public static final int PlaceComponentResult = 130;

        @Override // android.os.AsyncTask
        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            Void[] voidArr = (Void[]) objArr;
            return KClassImpl$Data$declaredNonStaticMembers$2();
        }

        @Override // android.os.AsyncTask
        protected /* synthetic */ void onPostExecute(Object obj) {
            super.onPostExecute((Void) obj);
            GAdsParamsFetchEvents gAdsParamsFetchEvents = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (gAdsParamsFetchEvents != null) {
                gAdsParamsFetchEvents.getErrorConfigVersion();
            }
        }

        public GAdsPrefetchTask(Context context, GAdsParamsFetchEvents gAdsParamsFetchEvents) {
            this.BuiltInFictitiousFunctionClassFactory = new WeakReference<>(context);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = gAdsParamsFetchEvents;
        }

        private Void KClassImpl$Data$declaredNonStaticMembers$2() {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            new Thread(new Runnable() { // from class: io.branch.referral.SystemObserver.GAdsPrefetchTask.1
                @Override // java.lang.Runnable
                public void run() {
                    Context context = (Context) GAdsPrefetchTask.this.BuiltInFictitiousFunctionClassFactory.get();
                    if (context != null) {
                        Process.setThreadPriority(-19);
                        Object MyBillsEntityDataFactory = GAdsPrefetchTask.MyBillsEntityDataFactory(context);
                        GAdsPrefetchTask.KClassImpl$Data$declaredNonStaticMembers$2(GAdsPrefetchTask.this, MyBillsEntityDataFactory);
                        GAdsPrefetchTask.MyBillsEntityDataFactory(GAdsPrefetchTask.this, MyBillsEntityDataFactory);
                    }
                    countDownLatch.countDown();
                }
            }).start();
            try {
                countDownLatch.await(1500L, TimeUnit.MILLISECONDS);
                return null;
            } catch (InterruptedException unused) {
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:10:0x002e A[Catch: all -> 0x0057, TryCatch #0 {all -> 0x0057, blocks: (B:4:0x0003, B:8:0x0028, B:10:0x002e, B:11:0x0049), top: B:16:0x0003 }] */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0049 A[Catch: all -> 0x0057, TRY_LEAVE, TryCatch #0 {all -> 0x0057, blocks: (B:4:0x0003, B:8:0x0028, B:10:0x002e, B:11:0x0049), top: B:16:0x0003 }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x004b -> B:13:0x004e). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static java.lang.Object MyBillsEntityDataFactory(android.content.Context r13) {
            /*
                r0 = 0
                if (r13 == 0) goto L57
                java.lang.String r1 = "com.google.android.gms.ads.identifier.AdvertisingIdClient"
                java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.Throwable -> L57
                r2 = 1
                java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch: java.lang.Throwable -> L57
                r4 = 97
                r5 = -1
                byte[] r6 = io.branch.referral.SystemObserver.GAdsPrefetchTask.getAuthRequestContext     // Catch: java.lang.Throwable -> L57
                r7 = 23
                byte[] r7 = new byte[r7]     // Catch: java.lang.Throwable -> L57
                r8 = 22
                r9 = 4
                r4 = r3
                if (r6 != 0) goto L22
                r5 = r7
                r10 = 4
                r11 = 22
                r7 = r6
                r6 = -1
                goto L4e
            L22:
                r9 = r7
                r5 = 97
                r10 = 4
                r7 = r6
                r6 = -1
            L28:
                int r6 = r6 + r2
                byte r11 = (byte) r5     // Catch: java.lang.Throwable -> L57
                r9[r6] = r11     // Catch: java.lang.Throwable -> L57
                if (r6 != r8) goto L49
                java.lang.String r5 = new java.lang.String     // Catch: java.lang.Throwable -> L57
                r6 = 0
                r5.<init>(r9, r6)     // Catch: java.lang.Throwable -> L57
                java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch: java.lang.Throwable -> L57
                r3[r6] = r5     // Catch: java.lang.Throwable -> L57
                java.lang.String r3 = "getAdvertisingIdInfo"
                java.lang.reflect.Method r1 = r1.getMethod(r3, r4)     // Catch: java.lang.Throwable -> L57
                java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L57
                r2[r6] = r13     // Catch: java.lang.Throwable -> L57
                java.lang.Object r0 = r1.invoke(r0, r2)     // Catch: java.lang.Throwable -> L57
                goto L57
            L49:
                r11 = r7[r10]     // Catch: java.lang.Throwable -> L57
                r12 = r9
                r9 = r5
                r5 = r12
            L4e:
                int r11 = -r11
                int r9 = r9 + r11
                int r9 = r9 + (-8)
                int r10 = r10 + r2
                r12 = r9
                r9 = r5
                r5 = r12
                goto L28
            L57:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.SystemObserver.GAdsPrefetchTask.MyBillsEntityDataFactory(android.content.Context):java.lang.Object");
        }

        static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(GAdsPrefetchTask gAdsPrefetchTask, Object obj) {
            try {
                Method method = obj.getClass().getMethod("getId", new Class[0]);
                SystemObserver.this.MyBillsEntityDataFactory = (String) method.invoke(obj, new Object[0]);
            } catch (Exception unused) {
            }
        }

        static /* synthetic */ void MyBillsEntityDataFactory(GAdsPrefetchTask gAdsPrefetchTask, Object obj) {
            try {
                Method method = obj.getClass().getMethod("isLimitAdTrackingEnabled", new Class[0]);
                SystemObserver.this.KClassImpl$Data$declaredNonStaticMembers$2 = ((Boolean) method.invoke(obj, new Object[0])).booleanValue() ? 1 : 0;
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String KClassImpl$Data$declaredNonStaticMembers$2() {
        String str = "";
        try {
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                Iterator it2 = Collections.list(((NetworkInterface) it.next()).getInetAddresses()).iterator();
                while (true) {
                    if (it2.hasNext()) {
                        InetAddress inetAddress = (InetAddress) it2.next();
                        if (!inetAddress.isLoopbackAddress()) {
                            String hostAddress = inetAddress.getHostAddress();
                            if (hostAddress.indexOf(58) < 0) {
                                str = hostAddress;
                                break;
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String NetworkUserEntityData$$ExternalSyntheticLambda0(Context context) {
        UiModeManager uiModeManager;
        if (context != null) {
            try {
                uiModeManager = (UiModeManager) context.getSystemService("uimode");
            } catch (Exception unused) {
            }
        } else {
            uiModeManager = null;
        }
        if (uiModeManager != null) {
            switch (uiModeManager.getCurrentModeType()) {
                case 1:
                    return "UI_MODE_TYPE_NORMAL";
                case 2:
                    return "UI_MODE_TYPE_DESK";
                case 3:
                    return "UI_MODE_TYPE_CAR";
                case 4:
                    return "UI_MODE_TYPE_TELEVISION";
                case 5:
                    return "UI_MODE_TYPE_APPLIANCE";
                case 6:
                    return "UI_MODE_TYPE_WATCH";
            }
        }
        return "UI_MODE_TYPE_UNDEFINED";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class UniqueId {
        private boolean BuiltInFictitiousFunctionClassFactory;
        String PlaceComponentResult;

        UniqueId(Context context, boolean z) {
            this.BuiltInFictitiousFunctionClassFactory = !z;
            this.PlaceComponentResult = "bnc_no_value";
            String str = null;
            if (context != null && !z && !Branch.moveToNextValue()) {
                str = Settings.Secure.getString(context.getContentResolver(), "android_id");
            }
            if (str == null) {
                str = UUID.randomUUID().toString();
                this.BuiltInFictitiousFunctionClassFactory = false;
            }
            this.PlaceComponentResult = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final boolean getAuthRequestContext() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                UniqueId uniqueId = (UniqueId) obj;
                return this.PlaceComponentResult.equals(uniqueId.PlaceComponentResult) && this.BuiltInFictitiousFunctionClassFactory == uniqueId.BuiltInFictitiousFunctionClassFactory;
            }
            return false;
        }

        public int hashCode() {
            boolean z = this.BuiltInFictitiousFunctionClassFactory;
            String str = this.PlaceComponentResult;
            return (((z ? 1 : 0) + 1) * 31) + (str == null ? 0 : str.hashCode());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String PlaceComponentResult(Context context) {
        String moveToNextValue = PrefHelper.BuiltInFictitiousFunctionClassFactory(context).moveToNextValue(Defines.ModuleNameKeys.imei.getKey());
        if (TextUtils.isEmpty(moveToNextValue)) {
            return null;
        }
        return moveToNextValue;
    }
}
