package com.splunk.rum;

import android.webkit.JavascriptInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class NativeRumSessionId {
    private final SplunkRum MyBillsEntityDataFactory;

    public NativeRumSessionId(SplunkRum splunkRum) {
        this.MyBillsEntityDataFactory = splunkRum;
    }

    @JavascriptInterface
    public String getNativeSessionId() {
        return this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
    }
}
