package com.appsflyer.internal;

import android.content.Context;
import com.appsflyer.AFInAppEventType;

/* loaded from: classes7.dex */
public final class bn extends bk {
    public bn(Context context) {
        super(AFInAppEventType.PURCHASE, Boolean.TRUE, context);
    }

    @Override // com.appsflyer.internal.g
    public final g AFInAppEventParameterName(String str) {
        return super.AFInAppEventParameterName(AFKeystoreWrapper(str));
    }
}
