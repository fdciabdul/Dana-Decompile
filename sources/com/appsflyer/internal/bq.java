package com.appsflyer.internal;

import android.content.Context;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class bq extends bt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(String str, Runnable runnable) {
        super(str, runnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void AFInAppEventParameterName(Context context, aw<Map<String, Object>> awVar) {
        ae.values();
        if (ae.valueOf(ae.values(context), "appsFlyerCount", false) > 0 || !awVar.values()) {
            return;
        }
        new Thread(awVar.AFInAppEventParameterName).start();
        AFInAppEventParameterName();
    }
}
