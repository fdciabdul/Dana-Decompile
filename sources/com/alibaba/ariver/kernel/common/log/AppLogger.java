package com.alibaba.ariver.kernel.common.log;

import com.alibaba.ariver.kernel.common.RVProxy;

/* loaded from: classes2.dex */
public class AppLogger {
    private static AppLoggerProxy a() {
        return (AppLoggerProxy) RVProxy.get(AppLoggerProxy.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getBizType() {
        return a().getBizType();
    }

    public static void log(BaseAppLog baseAppLog) {
        a().log(baseAppLog);
    }

    public static int getQosLevel() {
        return a().getQosLevel();
    }
}
