package com.alibaba.ariver.integration.proxy.impl;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes6.dex */
public class DefaultLoggerProxyImpl implements RVLogger.Proxy {
    public static final byte[] PlaceComponentResult = {45, -79, -67, -1, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int BuiltInFictitiousFunctionClassFactory = 246;

    private static void a(short s, int i, int i2, Object[] objArr) {
        int i3 = (i * 7) + 99;
        byte[] bArr = PlaceComponentResult;
        int i4 = 16 - (s * 12);
        int i5 = (i2 * 3) + 13;
        byte[] bArr2 = new byte[i5];
        int i6 = i5 - 1;
        int i7 = 0;
        if (bArr == null) {
            i4++;
            i3 = i4 + i3 + 2;
        }
        while (true) {
            bArr2[i7] = (byte) i3;
            if (i7 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            i7++;
            byte b = bArr[i4];
            i4++;
            i3 = i3 + b + 2;
        }
    }

    @Override // com.alibaba.ariver.kernel.common.utils.RVLogger.Proxy
    public void debug(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        try {
            byte b = (byte) (PlaceComponentResult[15] - 1);
            byte b2 = PlaceComponentResult[15];
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = PlaceComponentResult[15];
            byte b4 = (byte) (b3 - 1);
            Object[] objArr2 = new Object[1];
            a(b3, b4, b4, objArr2);
            sb.append(((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getName());
            sb.append("] ");
            sb.append(str2);
            InstrumentInjector.log_d(str, sb.toString());
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    @Override // com.alibaba.ariver.kernel.common.utils.RVLogger.Proxy
    public void e(String str, String str2, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        try {
            byte b = (byte) (PlaceComponentResult[15] - 1);
            byte b2 = PlaceComponentResult[15];
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = PlaceComponentResult[15];
            byte b4 = (byte) (b3 - 1);
            Object[] objArr2 = new Object[1];
            a(b3, b4, b4, objArr2);
            sb.append(((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getName());
            sb.append("] ");
            sb.append(str2);
            InstrumentInjector.log_e(str, sb.toString(), th);
        } catch (Throwable th2) {
            Throwable cause = th2.getCause();
            if (cause == null) {
                throw th2;
            }
            throw cause;
        }
    }

    @Override // com.alibaba.ariver.kernel.common.utils.RVLogger.Proxy
    public void w(String str, String str2, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        try {
            byte b = (byte) (PlaceComponentResult[15] - 1);
            byte b2 = PlaceComponentResult[15];
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = PlaceComponentResult[15];
            byte b4 = (byte) (b3 - 1);
            Object[] objArr2 = new Object[1];
            a(b3, b4, b4, objArr2);
            sb.append(((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getName());
            sb.append("] ");
            sb.append(str2);
            InstrumentInjector.log_w(str, sb.toString(), th);
        } catch (Throwable th2) {
            Throwable cause = th2.getCause();
            if (cause == null) {
                throw th2;
            }
            throw cause;
        }
    }

    @Override // com.alibaba.ariver.kernel.common.utils.RVLogger.Proxy
    public void d(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        try {
            byte b = (byte) (PlaceComponentResult[15] - 1);
            byte b2 = PlaceComponentResult[15];
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = PlaceComponentResult[15];
            byte b4 = (byte) (b3 - 1);
            Object[] objArr2 = new Object[1];
            a(b3, b4, b4, objArr2);
            sb.append(((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getName());
            sb.append("] ");
            sb.append(str2);
            InstrumentInjector.log_d(str, sb.toString());
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }
}
