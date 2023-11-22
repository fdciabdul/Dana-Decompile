package com.alibaba.exthub.common;

import com.alibaba.ariver.kernel.api.annotation.DefaultImpl;
import com.alibaba.ariver.kernel.common.Proxiable;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes3.dex */
public class ExtHubLogger {

    /* renamed from: a  reason: collision with root package name */
    private static Proxy f6263a = new Proxy() { // from class: com.alibaba.exthub.common.ExtHubLogger.1
        @Override // com.alibaba.exthub.common.ExtHubLogger.Proxy
        public final void debug(String str, String str2) {
            InstrumentInjector.log_d(str, str2);
        }

        @Override // com.alibaba.exthub.common.ExtHubLogger.Proxy
        public final void e(String str, String str2, Throwable th) {
            InstrumentInjector.log_e(str, str2, th);
        }

        @Override // com.alibaba.exthub.common.ExtHubLogger.Proxy
        public final void w(String str, String str2, Throwable th) {
            InstrumentInjector.log_w(str, str2, th);
        }

        @Override // com.alibaba.exthub.common.ExtHubLogger.Proxy
        public final void d(String str, String str2) {
            InstrumentInjector.log_d(str, str2);
        }
    };

    @DefaultImpl("com.alibaba.exthub.ExtHubLoggerImpl")
    /* loaded from: classes3.dex */
    public interface Proxy extends Proxiable {
        void d(String str, String str2);

        void debug(String str, String str2);

        void e(String str, String str2, Throwable th);

        void w(String str, String str2, Throwable th);
    }

    private static Proxy a() {
        Proxy proxy = (Proxy) ExtHubProxy.get(Proxy.class);
        return proxy == null ? f6263a : proxy;
    }

    public static void d(String str) {
        try {
            d("ExtHubLogger", str);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("RVLogger exception: ");
            sb.append(th);
            e(sb.toString());
        }
    }

    public static void d(String str, String str2) {
        if (isEmpty(str2)) {
            return;
        }
        try {
            a().d(str, str2);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("RVLogger exception: ");
            sb.append(th);
            e(sb.toString());
        }
    }

    public static void w(String str) {
        try {
            w("ExtHubLogger", str);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("RVLogger exception: ");
            sb.append(th);
            e(sb.toString());
        }
    }

    public static void w(String str, String str2) {
        if (isEmpty(str2)) {
            return;
        }
        try {
            a().w(str, str2, null);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("RVLogger exception: ");
            sb.append(th);
            e(sb.toString());
        }
    }

    public static void w(String str, String str2, Throwable th) {
        try {
            a().w(str, str2, th);
        } catch (Throwable th2) {
            StringBuilder sb = new StringBuilder();
            sb.append("RVLogger exception: ");
            sb.append(th2);
            e(sb.toString());
        }
    }

    public static void e(String str) {
        while (true) {
            try {
                e("ExtHubLogger", str, null);
                return;
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("RVLogger exception: ");
                sb.append(th);
                str = sb.toString();
            }
        }
    }

    public static void e(String str, String str2) {
        try {
            e(str, str2, null);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("RVLogger exception: ");
            sb.append(th);
            e(sb.toString());
        }
    }

    public static void e(String str, Throwable th) {
        try {
            e("ExtHubLogger", str, th);
        } catch (Throwable th2) {
            StringBuilder sb = new StringBuilder();
            sb.append("RVLogger exception: ");
            sb.append(th2);
            e(sb.toString());
        }
    }

    public static void e(String str, String str2, Throwable th) {
        try {
            a().e(str, str2, th);
        } catch (Throwable th2) {
            StringBuilder sb = new StringBuilder();
            sb.append("RVLogger exception: ");
            sb.append(th2);
            e(sb.toString());
        }
    }

    public static boolean isEmpty(String str) {
        return str == null || "".equals(str);
    }
}
