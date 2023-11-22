package com.alibaba.ariver.kernel.api.extension;

import com.alibaba.exthub.common.ExtHubLogger;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class ExtensionOpt {
    public static final String TAG = "AriverKernel:ExtensionOpt";

    /* renamed from: a  reason: collision with root package name */
    private static Map<Class<? extends Extension>, MethodInvokeOptimizer> f6081a = new ConcurrentHashMap();
    private static Map<Class<? extends Extension>, MethodInvokeOptimizer> b = new ConcurrentHashMap();
    private static ExceptionHandler c;

    /* loaded from: classes3.dex */
    public interface ExceptionHandler {
        void reportException(Throwable th, String str, String str2, String str3, Map<String, String> map);

        boolean shouldThrowOut(Throwable th, String str, String str2);
    }

    /* loaded from: classes3.dex */
    public interface MethodInvokeOptimizer {
        Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable;
    }

    /* loaded from: classes3.dex */
    public static class MismatchMethodException extends Exception {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public MismatchMethodException(java.lang.String r3) {
            /*
                r2 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "mismatched method to invoke: "
                r0.append(r1)
                r0.append(r3)
                java.lang.String r3 = r0.toString()
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MismatchMethodException.<init>(java.lang.String):void");
        }
    }

    public static void setupMethodInvokeOptimizer(Class<? extends Extension> cls, MethodInvokeOptimizer methodInvokeOptimizer) {
        if (cls == null || methodInvokeOptimizer == null) {
            return;
        }
        if (f6081a.put(cls, methodInvokeOptimizer) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("setupMethodInvokeOptimizer, duplicate: ");
            sb.append(cls.getName());
            ExtHubLogger.d(TAG, sb.toString());
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("setupMethodInvokeOptimizer: ");
        sb2.append(cls.getName());
        ExtHubLogger.d(TAG, sb2.toString());
    }

    public static void setupMethodInvokeOptimizerForBridge(Class<? extends Extension> cls, MethodInvokeOptimizer methodInvokeOptimizer) {
        if (cls == null || methodInvokeOptimizer == null) {
            return;
        }
        if (b.put(cls, methodInvokeOptimizer) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("setupMethodInvokeOptimizerForBridge, duplicate: ");
            sb.append(cls.getName());
            ExtHubLogger.d(TAG, sb.toString());
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("setupMethodInvokeOptimizerForBridge: ");
        sb2.append(cls.getName());
        ExtHubLogger.d(TAG, sb2.toString());
    }

    public static void clearAllMethodInvokeOptimizer() {
        if (f6081a.size() > 0) {
            f6081a = new ConcurrentHashMap();
        }
        if (b.size() > 0) {
            b = new ConcurrentHashMap();
        }
        ExtHubLogger.d(TAG, "clearAllMethodInvokeOptimizer");
    }

    public static MethodInvokeOptimizer getMethodInvokeOptimizer(Class<? extends Extension> cls, boolean z) {
        if (cls == null) {
            return null;
        }
        Map<Class<? extends Extension>, MethodInvokeOptimizer> map = z ? b : f6081a;
        if (map.size() == 0) {
            return null;
        }
        return map.get(cls);
    }

    public static void setupExceptionHandler(ExceptionHandler exceptionHandler) {
        StringBuilder sb = new StringBuilder();
        sb.append("setupExceptionHandler, old: ");
        sb.append(c);
        sb.append(", new: ");
        sb.append(exceptionHandler);
        ExtHubLogger.d(TAG, sb.toString());
        c = exceptionHandler;
    }

    public static void reportException(Throwable th, String str, String str2, String str3, Map<String, String> map) {
        ExceptionHandler exceptionHandler = c;
        if (exceptionHandler == null) {
            return;
        }
        try {
            exceptionHandler.reportException(th, str, str2, str3, map);
        } catch (Throwable th2) {
            StringBuilder sb = new StringBuilder();
            sb.append("reportException, occur error: ");
            sb.append(th2);
            ExtHubLogger.e(TAG, sb.toString());
        }
    }

    public static boolean shouldThrowOut(Throwable th, String str, String str2) {
        boolean z = "doMethodInvoke".equals(str) && "FinalCatch".equals(str2);
        StringBuilder sb = new StringBuilder();
        sb.append("shouldThrowOut, t: ");
        sb.append(th);
        sb.append(", s: ");
        sb.append(str);
        sb.append(", f: ");
        sb.append(str2);
        sb.append(", r: ");
        sb.append(z);
        ExtHubLogger.d(TAG, sb.toString());
        return z;
    }
}
