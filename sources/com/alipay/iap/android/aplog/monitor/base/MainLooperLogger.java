package com.alipay.iap.android.aplog.monitor.base;

import android.os.Looper;
import android.util.Printer;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class MainLooperLogger implements Printer {

    /* renamed from: a  reason: collision with root package name */
    private static MainLooperLogger f6932a;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {8, 83, -102, TarHeader.LF_SYMLINK, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int getAuthRequestContext = 66;
    private boolean c = false;
    private List<Printer> b = new ArrayList();
    private List<Printer> d = new ArrayList();

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:11:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void e(short r5, byte r6, byte r7, java.lang.Object[] r8) {
        /*
            byte[] r0 = com.alipay.iap.android.aplog.monitor.base.MainLooperLogger.KClassImpl$Data$declaredNonStaticMembers$2
            int r6 = r6 * 3
            int r6 = r6 + 13
            int r5 = r5 * 12
            int r5 = 16 - r5
            int r7 = r7 * 7
            int r7 = r7 + 99
            byte[] r1 = new byte[r6]
            r2 = -1
            int r6 = r6 + r2
            if (r0 != 0) goto L18
            r7 = r6
            r3 = r7
            r6 = r5
            goto L2e
        L18:
            r4 = r6
            r6 = r5
            r5 = r7
            r7 = r4
        L1c:
            int r2 = r2 + 1
            byte r3 = (byte) r5
            r1[r2] = r3
            if (r2 != r7) goto L2c
            java.lang.String r5 = new java.lang.String
            r6 = 0
            r5.<init>(r1, r6)
            r8[r6] = r5
            return
        L2c:
            r3 = r0[r6]
        L2e:
            int r3 = -r3
            int r5 = r5 + r3
            int r5 = r5 + 2
            int r6 = r6 + 1
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.aplog.monitor.base.MainLooperLogger.e(short, byte, byte, java.lang.Object[]):void");
    }

    public static MainLooperLogger a() {
        if (f6932a == null) {
            synchronized (MainLooperLogger.class) {
                if (f6932a == null) {
                    f6932a = new MainLooperLogger();
                }
            }
        }
        return f6932a;
    }

    private MainLooperLogger() {
    }

    public void a(Printer printer) {
        try {
            byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] + 1);
            byte b2 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[15]);
            Object[] objArr = new Object[1];
            e(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[15]);
            byte b4 = (byte) (b3 - 1);
            Object[] objArr2 = new Object[1];
            e(b3, b4, b4, objArr2);
            if (cls.getMethod((String) objArr2[0], null).invoke(null, null) != Looper.getMainLooper().getThread()) {
                throw new RuntimeException("calling addMessageLogging not in main thread.");
            }
            if (!this.b.contains(printer)) {
                this.c = true;
                this.b.add(printer);
            }
            if (this.b.size() > 0) {
                Looper.getMainLooper().setMessageLogging(this);
            }
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    public void b(Printer printer) {
        try {
            byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] + 1);
            byte b2 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[15]);
            Object[] objArr = new Object[1];
            e(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[15]);
            byte b4 = (byte) (b3 - 1);
            Object[] objArr2 = new Object[1];
            e(b3, b4, b4, objArr2);
            if (cls.getMethod((String) objArr2[0], null).invoke(null, null) != Looper.getMainLooper().getThread()) {
                throw new RuntimeException("calling removeMessageLogging not in main thread.");
            }
            if (this.b.contains(printer)) {
                this.c = true;
            }
            this.b.remove(printer);
            if (this.b.size() <= 0) {
                Looper.getMainLooper().setMessageLogging(null);
            }
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    @Override // android.util.Printer
    public void println(String str) {
        if (this.c) {
            this.d.clear();
            this.d.addAll(this.b);
            this.c = false;
        }
        for (int i = 0; i < this.d.size(); i++) {
            Printer printer = this.d.get(i);
            if (printer != null) {
                printer.println(str);
            }
        }
    }
}
