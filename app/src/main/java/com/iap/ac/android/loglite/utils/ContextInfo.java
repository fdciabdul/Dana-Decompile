package com.iap.ac.android.loglite.utils;

import android.content.Context;
import android.content.pm.PackageInfo;

/* loaded from: classes3.dex */
public class ContextInfo {

    /* renamed from: a  reason: collision with root package name */
    public Context f7601a;
    public String b;

    public ContextInfo(Context context) {
        this.f7601a = context;
        a();
    }

    public final void a() {
        if (this.b == null) {
            PackageInfo packageInfo = null;
            try {
                Context context = this.f7601a;
                if (context != null) {
                    packageInfo = context.getPackageManager().getPackageInfo(this.f7601a.getPackageName(), 0);
                }
            } catch (Throwable unused) {
            }
            if (packageInfo != null) {
                this.b = packageInfo.versionName;
            }
        }
    }
}
