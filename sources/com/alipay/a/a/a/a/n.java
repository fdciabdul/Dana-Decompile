package com.alipay.a.a.a.a;

import android.content.Context;
import com.fullstory.instrumentation.InstrumentInjector;
import com.iap.ac.android.common.utils.MiscUtils;

/* loaded from: classes3.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    private static Boolean f6839a;

    public static final boolean a(Context context) {
        Boolean bool = f6839a;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            Boolean valueOf = Boolean.valueOf((context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).flags & 2) != 0);
            f6839a = valueOf;
            return valueOf.booleanValue();
        } catch (Exception e) {
            InstrumentInjector.log_e(MiscUtils.TAG, "", e);
            return false;
        }
    }
}
