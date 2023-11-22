package com.alibaba.ariver.kernel.common.utils;

import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;

/* loaded from: classes2.dex */
public class RVLogger {

    /* renamed from: a  reason: collision with root package name */
    private static final int f6165a = 7;
    public static final byte[] getAuthRequestContext = {45, -61, Ascii.ETB, 105, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 27;
    private static Proxy b = new Proxy() { // from class: com.alibaba.ariver.kernel.common.utils.RVLogger.1
        @Override // com.alibaba.ariver.kernel.common.utils.RVLogger.Proxy
        public final void debug(String str, String str2) {
            InstrumentInjector.log_d(str, str2);
        }

        @Override // com.alibaba.ariver.kernel.common.utils.RVLogger.Proxy
        public final void e(String str, String str2, Throwable th) {
            InstrumentInjector.log_e(str, str2, th);
        }

        @Override // com.alibaba.ariver.kernel.common.utils.RVLogger.Proxy
        public final void w(String str, String str2, Throwable th) {
            InstrumentInjector.log_w(str, str2, th);
        }

        @Override // com.alibaba.ariver.kernel.common.utils.RVLogger.Proxy
        public final void d(String str, String str2) {
            InstrumentInjector.log_d(str, str2);
        }
    };

    /* loaded from: classes3.dex */
    public interface Proxy extends Proxiable {
        void d(String str, String str2);

        void debug(String str, String str2);

        void e(String str, String str2, Throwable th);

        void w(String str, String str2, Throwable th);
    }

    private static void c(int i, byte b2, byte b3, Object[] objArr) {
        int i2 = (i * 3) + 13;
        int i3 = (b2 * 7) + 99;
        byte[] bArr = getAuthRequestContext;
        int i4 = 16 - (b3 * 12);
        byte[] bArr2 = new byte[i2];
        int i5 = -1;
        int i6 = i2 - 1;
        if (bArr == null) {
            i4++;
            i3 = i6 + i4 + 2;
            i6 = i6;
        }
        while (true) {
            i5++;
            bArr2[i5] = (byte) i3;
            if (i5 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            byte b4 = bArr[i4];
            i4++;
            i3 = i3 + b4 + 2;
            i6 = i6;
        }
    }

    public static String makeLogTag(String str) {
        int length = str.length();
        int i = 23 - f6165a;
        if (length > i) {
            StringBuilder sb = new StringBuilder();
            sb.append("Ariver_");
            sb.append(str.substring(0, i - 1));
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Ariver_");
        sb2.append(str);
        return sb2.toString();
    }

    public static void printPerformanceLog(String str, String str2) {
        Proxy proxy = (Proxy) RVProxy.get(Proxy.class, true);
        if (proxy != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("[Thread:");
            try {
                byte b2 = getAuthRequestContext[15];
                byte b3 = b2;
                Object[] objArr = new Object[1];
                c(b2, b3, (byte) (b3 - 1), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b4 = (byte) (getAuthRequestContext[15] - 1);
                Object[] objArr2 = new Object[1];
                c(b4, b4, getAuthRequestContext[15], objArr2);
                sb.append(((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getName());
                sb.append("] [Stage:");
                sb.append(str);
                sb.append("] [Info:");
                sb.append(str2);
                sb.append("] [TimeStamp:");
                sb.append(System.currentTimeMillis());
                sb.append("]");
                proxy.e("AriverPerformance", sb.toString(), null);
                return;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[Thread:");
        try {
            byte b5 = getAuthRequestContext[15];
            byte b6 = b5;
            Object[] objArr3 = new Object[1];
            c(b5, b6, (byte) (b6 - 1), objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            byte b7 = (byte) (getAuthRequestContext[15] - 1);
            Object[] objArr4 = new Object[1];
            c(b7, b7, getAuthRequestContext[15], objArr4);
            sb2.append(((Thread) cls2.getMethod((String) objArr4[0], null).invoke(null, null)).getName());
            sb2.append("] [Stage:");
            sb2.append(str);
            sb2.append("] [Info:");
            sb2.append(str2);
            sb2.append("] [TimeStamp:");
            sb2.append(System.currentTimeMillis());
            sb2.append("]");
            InstrumentInjector.log_e("AriverPerformance", sb2.toString());
        } catch (Throwable th2) {
            Throwable cause2 = th2.getCause();
            if (cause2 == null) {
                throw th2;
            }
            throw cause2;
        }
    }

    public static String makeLogTag(Class cls) {
        return makeLogTag(cls.getSimpleName());
    }

    private static Proxy a() {
        Proxy proxy = (Proxy) RVProxy.get(Proxy.class, true);
        return proxy == null ? b : proxy;
    }

    public static void d(String str) {
        try {
            d("RVLogger", str);
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
            w("RVLogger", str);
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
                e("RVLogger", str, null);
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
            e("RVLogger", str, th);
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

    public static void debug(String str, String str2) {
        if (isEmpty(str2)) {
            return;
        }
        try {
            a().debug(str, str2);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("RVLogger exception: ");
            sb.append(th);
            e(sb.toString());
        }
    }

    public static boolean isEmpty(String str) {
        return str == null || "".equals(str);
    }
}
