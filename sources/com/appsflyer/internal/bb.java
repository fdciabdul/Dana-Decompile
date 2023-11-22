package com.appsflyer.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.alibaba.griver.api.jsapi.diagnostic.RecordReportConstants;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.FirebaseMessagingServiceListener;
import com.appsflyer.internal.d;
import id.dana.lib.gcontainer.app.bridge.logging.H5GetLogInfoBridge;
import id.dana.oauth.OauthConstant;
import id.dana.sendmoney.summary.SummaryActivity;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class bb extends bf {
    private static String onDeepLinkingNative;
    private final SharedPreferences onInstallConversionDataLoadedNative;

    static {
        StringBuilder sb = new StringBuilder("https://%sregister.%s/api/v");
        sb.append(ae.AFKeystoreWrapper);
        onDeepLinkingNative = sb.toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public bb(android.content.Context r10) {
        /*
            r9 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = com.appsflyer.internal.bb.onDeepLinkingNative
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            com.appsflyer.AppsFlyerLib r3 = com.appsflyer.AppsFlyerLib.getInstance()
            java.lang.String r3 = r3.getHostPrefix()
            r4 = 0
            r2[r4] = r3
            com.appsflyer.internal.ae r3 = com.appsflyer.internal.ae.values()
            java.lang.String r3 = r3.getHostName()
            r4 = 1
            r2[r4] = r3
            java.lang.String r1 = java.lang.String.format(r1, r2)
            r0.append(r1)
            java.lang.String r1 = r10.getPackageName()
            r0.append(r1)
            java.lang.String r4 = r0.toString()
            r3 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r2 = r9
            r8 = r10
            r2.<init>(r3, r4, r5, r6, r7, r8)
            android.content.SharedPreferences r10 = com.appsflyer.internal.ae.values(r10)
            r9.onInstallConversionDataLoadedNative = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.bb.<init>(android.content.Context):void");
    }

    public static boolean values(Context context) {
        if (AppsFlyerLib.getInstance().isStopped()) {
            return false;
        }
        try {
            Class.forName("com.google.firebase.messaging.FirebaseMessagingService");
        } catch (ClassNotFoundException unused) {
        } catch (Throwable th) {
            AFLogger.AFInAppEventType("An error occurred while trying to verify manifest declarations: ", th);
        }
        return aa.AFInAppEventParameterName(context, new Intent("com.google.firebase.MESSAGING_EVENT", null, context, FirebaseMessagingServiceListener.class));
    }

    public static boolean AFInAppEventParameterName(SharedPreferences sharedPreferences) {
        return sharedPreferences.getBoolean("sentRegisterRequestToAF", false);
    }

    public final void valueOf(String str) {
        if (str != null) {
            AFLogger.AFKeystoreWrapper("Firebase Refreshed Token = ".concat(String.valueOf(str)));
            l valueOf = valueOf();
            if (valueOf == null || !str.equals(valueOf.values)) {
                long currentTimeMillis = System.currentTimeMillis();
                boolean z = ae.values(this.onInstallConversionDataLoadedNative) && (valueOf == null || currentTimeMillis - valueOf.valueOf > TimeUnit.SECONDS.toMillis(2L));
                AFInAppEventParameterName(new l(str, currentTimeMillis, !z));
                if (z) {
                    AFInAppEventType(str);
                }
            }
        }
    }

    public final l valueOf() {
        String string;
        String string2;
        String string3 = this.onInstallConversionDataLoadedNative.getString("afUninstallToken", null);
        long j = this.onInstallConversionDataLoadedNative.getLong("afUninstallToken_received_time", 0L);
        boolean z = this.onInstallConversionDataLoadedNative.getBoolean("afUninstallToken_queued", false);
        this.onInstallConversionDataLoadedNative.edit().putBoolean("afUninstallToken_queued", false).apply();
        if (string3 == null && (string2 = AppsFlyerProperties.getInstance().getString("afUninstallToken")) != null) {
            string3 = string2.split(",")[r0.length - 1];
        }
        if (j == 0 && (string = AppsFlyerProperties.getInstance().getString("afUninstallToken")) != null) {
            String[] split = string.split(",");
            if (split.length >= 2) {
                try {
                    j = Long.parseLong(split[split.length - 2]);
                } catch (NumberFormatException unused) {
                }
            }
        }
        if (string3 != null) {
            return new l(string3, j, z);
        }
        return null;
    }

    private void AFInAppEventParameterName(l lVar) {
        this.onInstallConversionDataLoadedNative.edit().putString("afUninstallToken", lVar.values).putLong("afUninstallToken_received_time", lVar.valueOf).putBoolean("afUninstallToken_queued", lVar.AFInAppEventParameterName()).apply();
    }

    public final void AFInAppEventType(String str) {
        Application application = this.valueOf;
        final ae values = ae.values();
        if (ae.valueOf()) {
            AFLogger.AFInAppEventType("CustomerUserId not set, Tracking is disabled", true);
            return;
        }
        String AFKeystoreWrapper = ae.AFKeystoreWrapper(AppsFlyerProperties.AF_KEY);
        if (AFKeystoreWrapper == null) {
            AFLogger.init("[registerUninstall] AppsFlyer's SDK cannot send any event without providing DevKey.");
            return;
        }
        PackageManager packageManager = application.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(application.getPackageName(), 0);
            this.AFInAppEventType.put("app_version_code", Integer.toString(packageInfo.versionCode));
            this.AFInAppEventType.put("app_version_name", packageInfo.versionName);
            this.AFInAppEventType.put(RecordReportConstants.APP_NAME, packageManager.getApplicationLabel(packageInfo.applicationInfo).toString());
            long j = packageInfo.firstInstallTime;
            this.AFInAppEventType.put("installDate", ae.AFInAppEventParameterName(new SimpleDateFormat("yyyy-MM-dd_HHmmssZ", Locale.US), j));
        } catch (Throwable th) {
            AFLogger.AFInAppEventType("Exception while collecting application version info.", th);
        }
        ae.valueOf(application, this.AFInAppEventType);
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.APP_USER_ID);
        if (string != null) {
            this.AFInAppEventType.put("appUserId", string);
        }
        try {
            this.AFInAppEventType.put(H5GetLogInfoBridge.RESULT_MODEL, Build.MODEL);
            this.AFInAppEventType.put(H5GetLogInfoBridge.RESULT_BRAND, Build.BRAND);
        } catch (Throwable th2) {
            AFLogger.AFInAppEventType("Exception while collecting device brand and model.", th2);
        }
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, false)) {
            this.AFInAppEventType.put(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, SummaryActivity.CHECKED);
        }
        d.e.C0089d AFInAppEventParameterName = ab.AFInAppEventParameterName(application.getContentResolver());
        if (AFInAppEventParameterName != null) {
            this.AFInAppEventType.put("amazon_aid", AFInAppEventParameterName.values);
            this.AFInAppEventType.put("amazon_aid_limit", String.valueOf(AFInAppEventParameterName.valueOf));
        }
        String string2 = AppsFlyerProperties.getInstance().getString("advertiserId");
        if (string2 != null) {
            this.AFInAppEventType.put("advertiserId", string2);
        }
        this.AFInAppEventType.put("devkey", AFKeystoreWrapper);
        this.AFInAppEventType.put("uid", an.AFKeystoreWrapper(new WeakReference(application)));
        this.AFInAppEventType.put("af_gcm_token", str);
        this.AFInAppEventType.put("launch_counter", Integer.toString(ae.valueOf(this.onInstallConversionDataLoadedNative, "appsFlyerCount", false)));
        this.AFInAppEventType.put(OauthConstant.OauthType.SDK_TYPE, Integer.toString(Build.VERSION.SDK_INT));
        String valueOf = values.valueOf(application);
        if (valueOf != null) {
            this.AFInAppEventType.put("channel", valueOf);
        }
        new Thread(new Runnable() { // from class: com.appsflyer.internal.bb.4
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    bb bbVar = bb.this;
                    bbVar.onConversionDataFail = values.isStopped();
                    HttpURLConnection AFInAppEventType = new m(bbVar).AFInAppEventType();
                    if (AFInAppEventType != null) {
                        if (AFInAppEventType.getResponseCode() == 200) {
                            bb.AFInAppEventType(bb.this);
                        }
                        AFInAppEventType.disconnect();
                    }
                } catch (Throwable th3) {
                    AFLogger.AFInAppEventType(th3.getMessage(), th3);
                }
            }
        }).start();
    }

    static /* synthetic */ void AFInAppEventType(bb bbVar) {
        bbVar.onInstallConversionDataLoadedNative.edit().putBoolean("sentRegisterRequestToAF", true).apply();
        AFLogger.values("Successfully registered for Uninstall Tracking");
    }
}
