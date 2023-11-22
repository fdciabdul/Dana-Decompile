package com.alipay.iap.android.common.log;

import java.util.Map;

/* loaded from: classes.dex */
public class MonitorWrapper {
    private static IMonitor sMonitor = new IMonitor() { // from class: com.alipay.iap.android.common.log.MonitorWrapper.1
        @Override // com.alipay.iap.android.common.log.IMonitor
        public final void aliveReport() {
        }

        @Override // com.alipay.iap.android.common.log.IMonitor
        public final void behaviour(String str, String str2, Map<String, String> map) {
        }

        @Override // com.alipay.iap.android.common.log.IMonitor
        public final void behaviour(String str, Map<String, String> map) {
        }

        @Override // com.alipay.iap.android.common.log.IMonitor
        public final void exception(String str, String str2, Map<String, String> map) {
        }

        @Override // com.alipay.iap.android.common.log.IMonitor
        public final void exception(String str, Map<String, String> map) {
        }

        @Override // com.alipay.iap.android.common.log.IMonitor
        public final void flush() {
        }

        @Override // com.alipay.iap.android.common.log.IMonitor
        public final void pageOnDestroy(Object obj) {
        }

        @Override // com.alipay.iap.android.common.log.IMonitor
        public final void pageOnEnd(Object obj, String str, String str2, Map<String, String> map) {
        }

        @Override // com.alipay.iap.android.common.log.IMonitor
        public final void pageOnStart(Object obj, String str) {
        }

        @Override // com.alipay.iap.android.common.log.IMonitor
        public final void performance(String str, String str2, String str3, Map<String, String> map) {
        }

        @Override // com.alipay.iap.android.common.log.IMonitor
        public final void performance(String str, String str2, Map<String, String> map) {
        }

        @Override // com.alipay.iap.android.common.log.IMonitor
        public final void spmClick(Object obj, String str, String str2, Map<String, String> map) {
        }

        @Override // com.alipay.iap.android.common.log.IMonitor
        public final void spmExpose(Object obj, String str, String str2, Map<String, String> map) {
        }
    };

    public static void customizeMonitor(IMonitor iMonitor) {
        if (iMonitor != null) {
            sMonitor = iMonitor;
        }
    }

    @Deprecated
    public static void performance(String str, String str2, String str3, Map<String, String> map) {
        sMonitor.performance(str, str2, str3, map);
    }

    public static void aliveReport() {
        sMonitor.aliveReport();
    }

    public static void behaviour(String str, Map<String, String> map) {
        sMonitor.behaviour(str, map);
    }

    public static void behaviour(String str, String str2, Map<String, String> map) {
        sMonitor.behaviour(str, str2, map);
    }

    public static void flush() {
        sMonitor.flush();
    }

    public static void pageOnStart(Object obj, String str) {
        sMonitor.pageOnStart(obj, str);
    }

    public static void pageOnEnd(Object obj, String str, String str2, Map<String, String> map) {
        sMonitor.pageOnEnd(obj, str, str2, map);
    }

    public static void pageOnDestroy(Object obj) {
        sMonitor.pageOnDestroy(obj);
    }

    public static void spmClick(Object obj, String str, String str2, Map<String, String> map) {
        sMonitor.spmClick(obj, str, str2, map);
    }

    public static void spmExpose(Object obj, String str, String str2, Map<String, String> map) {
        sMonitor.spmExpose(obj, str, str2, map);
    }

    @Deprecated
    public static void exception(String str, String str2, Map<String, String> map) {
        sMonitor.exception(str, str2, map);
    }

    public static void exception(String str, Map<String, String> map) {
        sMonitor.exception(str, map);
    }

    public static void performance(String str, String str2, Map<String, String> map) {
        sMonitor.performance(str, str2, map);
    }
}
