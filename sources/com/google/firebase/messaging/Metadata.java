package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.firebase.FirebaseApp;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class Metadata {
    private static final String ACTION_C2DM_REGISTER = "com.google.android.c2dm.intent.REGISTER";
    private static final String ACTION_IID_TOKEN_REQUEST = "com.google.iid.TOKEN_REQUEST";
    static final int GMSCORE_NOT_FOUND = 0;
    private static final String GMSCORE_SEND_PERMISSION = "com.google.android.c2dm.permission.SEND";
    static final String GMS_PACKAGE = "com.google.android.gms";
    static final int IID_VIA_RECEIVER = 2;
    static final int IID_VIA_SERVICE = 1;
    private String appVersionCode;
    private String appVersionName;
    private final Context context;
    private int gmsVersionCode;
    private int iidImplementation = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Metadata(Context context) {
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isGmscorePresent() {
        return getIidImplementation() != 0;
    }

    int getIidImplementation() {
        synchronized (this) {
            int i = this.iidImplementation;
            if (i != 0) {
                return i;
            }
            PackageManager packageManager = this.context.getPackageManager();
            if (packageManager.checkPermission(GMSCORE_SEND_PERMISSION, "com.google.android.gms") == -1) {
                InstrumentInjector.log_e(Constants.TAG, "Google Play services missing or without correct permission.");
                return 0;
            }
            if (!PlatformVersion.isAtLeastO()) {
                Intent intent = new Intent(ACTION_C2DM_REGISTER);
                intent.setPackage("com.google.android.gms");
                List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
                if (queryIntentServices != null && queryIntentServices.size() > 0) {
                    this.iidImplementation = 1;
                    return 1;
                }
            }
            Intent intent2 = new Intent(ACTION_IID_TOKEN_REQUEST);
            intent2.setPackage("com.google.android.gms");
            List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
            if (queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0) {
                this.iidImplementation = 2;
                return 2;
            }
            InstrumentInjector.log_w(Constants.TAG, "Failed to resolve IID implementation package, falling back");
            if (PlatformVersion.isAtLeastO()) {
                this.iidImplementation = 2;
            } else {
                this.iidImplementation = 1;
            }
            return this.iidImplementation;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getDefaultSenderId(FirebaseApp firebaseApp) {
        String gcmSenderId = firebaseApp.getOptions().getGcmSenderId();
        if (gcmSenderId != null) {
            return gcmSenderId;
        }
        String applicationId = firebaseApp.getOptions().getApplicationId();
        if (applicationId.startsWith("1:")) {
            String[] split = applicationId.split(":");
            if (split.length < 2) {
                return null;
            }
            String str = split[1];
            if (str.isEmpty()) {
                return null;
            }
            return str;
        }
        return applicationId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getAppVersionCode() {
        String str;
        synchronized (this) {
            if (this.appVersionCode == null) {
                populateAppVersionInfo();
            }
            str = this.appVersionCode;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getAppVersionName() {
        String str;
        synchronized (this) {
            if (this.appVersionName == null) {
                populateAppVersionInfo();
            }
            str = this.appVersionName;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getGmsVersionCode() {
        int i;
        PackageInfo packageInfo;
        synchronized (this) {
            if (this.gmsVersionCode == 0 && (packageInfo = getPackageInfo("com.google.android.gms")) != null) {
                this.gmsVersionCode = packageInfo.versionCode;
            }
            i = this.gmsVersionCode;
        }
        return i;
    }

    private void populateAppVersionInfo() {
        synchronized (this) {
            PackageInfo packageInfo = getPackageInfo(this.context.getPackageName());
            if (packageInfo != null) {
                this.appVersionCode = Integer.toString(packageInfo.versionCode);
                this.appVersionName = packageInfo.versionName;
            }
        }
    }

    private PackageInfo getPackageInfo(String str) {
        try {
            return this.context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to find package ");
            sb.append(e);
            InstrumentInjector.log_w(Constants.TAG, sb.toString());
            return null;
        }
    }
}
