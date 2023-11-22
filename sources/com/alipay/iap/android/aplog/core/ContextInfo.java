package com.alipay.iap.android.aplog.core;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;

/* loaded from: classes3.dex */
public class ContextInfo {
    private Context context;
    private String productVersion;
    private String releaseType = "release";

    public ContextInfo(Context context) {
        this.context = context;
        initProductInfo();
    }

    private void initProductInfo() {
        if (this.productVersion == null) {
            PackageInfo packageInfo = null;
            try {
                Context context = this.context;
                if (context != null) {
                    packageInfo = context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0);
                }
            } catch (Throwable unused) {
            }
            if (packageInfo != null) {
                this.productVersion = packageInfo.versionName;
            }
        }
    }

    public String getProductVersion() {
        return this.productVersion;
    }

    public String getReleaseType() {
        return this.releaseType;
    }

    public void setReleaseType(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.releaseType = str;
    }
}
