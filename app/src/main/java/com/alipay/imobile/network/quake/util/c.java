package com.alipay.imobile.network.quake.util;

import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.imobile.network.quake.Quake;

/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static long f7078a = -1;

    private c() {
    }

    public static String a() {
        return d.a(b());
    }

    public static long b() {
        long currentTimeMillis;
        long currentTimeMillis2 = System.currentTimeMillis();
        if (currentTimeMillis2 != f7078a) {
            f7078a = currentTimeMillis2;
            return currentTimeMillis2;
        }
        synchronized (c.class) {
            try {
                Thread.sleep(5L);
            } catch (InterruptedException e) {
                LoggerWrapper.e(Quake.TAG, "", e);
            }
            currentTimeMillis = System.currentTimeMillis();
            f7078a = currentTimeMillis;
        }
        return currentTimeMillis;
    }
}
