package com.appsflyer.internal;

import android.content.Context;

/* loaded from: classes.dex */
public abstract class bf extends g {
    public boolean onConversionDataFail;
    private final boolean onDeepLinkingNative;
    private final boolean onInstallConversionDataLoadedNative;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf() {
        this(null, null, null, null, null, null);
    }

    public bf(String str, String str2, Boolean bool, Boolean bool2, Boolean bool3, Context context) {
        super(str, str2, Boolean.valueOf(bool3 != null ? bool3.booleanValue() : false), context);
        this.onDeepLinkingNative = bool != null ? bool.booleanValue() : true;
        this.onInstallConversionDataLoadedNative = bool2 != null ? bool2.booleanValue() : true;
    }

    public final boolean AppsFlyer2dXConversionCallback() {
        return this.onConversionDataFail;
    }

    public final boolean init() {
        return this.onDeepLinkingNative;
    }

    public final boolean getLevel() {
        return this.onInstallConversionDataLoadedNative;
    }

    public String AFLogger$LogLevel() {
        return m.AFInAppEventType(AFInAppEventType()).toString();
    }
}
