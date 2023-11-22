package com.alipay.mobile.zebra.internal;

import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* loaded from: classes7.dex */
public class ZebraLog {
    public static void w(String str, String str2) {
        RVLogger.w(str, str2);
    }

    public static void d(String str, String str2) {
        RVLogger.d(str, str2);
    }

    public static void e(String str, String str2) {
        RVLogger.e(str, str2);
    }

    public static void e(String str, Throwable th) {
        RVLogger.e(str, th);
    }
}
