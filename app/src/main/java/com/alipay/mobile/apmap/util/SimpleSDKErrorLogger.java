package com.alipay.mobile.apmap.util;

import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* loaded from: classes6.dex */
public class SimpleSDKErrorLogger {
    public static void setEnabled(boolean z) {
    }

    public static void log(Throwable th) {
        RVLogger.e("SimpleSDKErrorLogger", th);
    }
}
