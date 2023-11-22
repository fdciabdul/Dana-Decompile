package com.appsflyer.internal;

import com.zoloz.android.phone.zdoc.BuildConfig;

/* loaded from: classes7.dex */
public enum b$d {
    HOOKING(BuildConfig.PORT),
    DEBUGGABLE("dbg");

    public String AFKeystoreWrapper;

    b$d(String str) {
        this.AFKeystoreWrapper = str;
    }
}
