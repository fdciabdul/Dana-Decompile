package com.appsflyer.internal;

/* loaded from: classes.dex */
public final class bg extends g {
    public bg() {
        super(null, null, Boolean.FALSE, null);
    }

    @Override // com.appsflyer.internal.g
    public final g AFInAppEventParameterName(String str) {
        return super.AFInAppEventParameterName(AFKeystoreWrapper(str));
    }
}
