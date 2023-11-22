package com.alipay.plus.android.ab.sdk.trigger;

import android.content.Context;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.plus.android.ab.sdk.AbTestingContext;
import com.alipay.plus.android.ab.sdk.AbTestingSdk;
import com.alipay.plus.android.config.sdk.a.e;

/* loaded from: classes7.dex */
public abstract class AbTestingTrigger {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7348a = e.a("AbTestingTrigger");

    public void initialize(Context context) {
        LoggerWrapper.d(f7348a, "initialize now.");
    }

    public abstract void startTrigger(AbTestingContext abTestingContext);

    public void updateABVariation(String str, String str2) {
        LoggerWrapper.d(f7348a, "update ABVariation with trigger.");
        AbTestingSdk.getInstance().updateAbVariation(str, str2);
    }
}
