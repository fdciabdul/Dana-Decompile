package com.alipay.iap.android.aplog.monitor.util;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes6.dex */
public class APMUtil {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f6937a = false;
    private static boolean b = true;
    private static SharedPreferences c;

    public static SharedPreferences a(Context context) {
        if (context == null) {
            return null;
        }
        if (c == null) {
            synchronized (APMUtil.class) {
                if (c == null) {
                    c = context.getSharedPreferences("APMSPStore", 4);
                }
            }
        }
        return c;
    }
}
