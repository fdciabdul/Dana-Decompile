package com.huawei.hms.base.log;

import android.os.Process;
import android.util.Log;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.sendmoney.summary.SummaryActivity;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: classes7.dex */
public class c {
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {112, 117, 112, -122, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -4, 13, -35, Ascii.US, -21, 0, 6, -25, Ascii.FS, -19, 0, 0, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int PlaceComponentResult = TarHeader.USTAR_FILENAME_PREFIX;
    public String b;
    public String c;
    public int d;
    public String g;
    public int h;
    public int i;
    public int j;

    /* renamed from: a  reason: collision with root package name */
    public final StringBuilder f7465a = new StringBuilder();
    public long e = 0;
    public long f = 0;

    public c(int i, String str, int i2, String str2) {
        this.c = "HMS";
        this.j = i;
        this.b = str;
        this.d = i2;
        if (str2 != null) {
            this.c = str2;
        }
        b();
    }

    public static String a(int i) {
        return i != 3 ? i != 4 ? i != 5 ? i != 6 ? String.valueOf(i) : "E" : "W" : "I" : SummaryActivity.DAYS;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002d -> B:11:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void k(byte r7, int r8, int r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 * 3
            int r8 = 16 - r8
            byte[] r0 = com.huawei.hms.base.log.c.BuiltInFictitiousFunctionClassFactory
            int r9 = r9 * 12
            int r9 = 27 - r9
            int r7 = r7 + 99
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L18
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            goto L37
        L18:
            r3 = 0
        L19:
            r6 = r8
            r8 = r7
            r7 = r6
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            int r9 = r9 + 1
            if (r4 != r7) goto L2d
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2d:
            r3 = r0[r9]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r6
        L37:
            int r9 = r9 + r7
            int r7 = r9 + 2
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.base.log.c.k(byte, int, int, java.lang.Object[]):void");
    }

    public final c b() {
        this.e = System.currentTimeMillis();
        try {
            byte b = BuiltInFictitiousFunctionClassFactory[8];
            byte b2 = BuiltInFictitiousFunctionClassFactory[21];
            Object[] objArr = new Object[1];
            k(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            k(BuiltInFictitiousFunctionClassFactory[21], BuiltInFictitiousFunctionClassFactory[15], (byte) (-BuiltInFictitiousFunctionClassFactory[6]), objArr2);
            Thread thread = (Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null);
            this.f = thread.getId();
            this.h = Process.myPid();
            try {
                byte b3 = BuiltInFictitiousFunctionClassFactory[8];
                byte b4 = BuiltInFictitiousFunctionClassFactory[21];
                Object[] objArr3 = new Object[1];
                k(b3, b4, b4, objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                byte b5 = BuiltInFictitiousFunctionClassFactory[9];
                byte b6 = BuiltInFictitiousFunctionClassFactory[15];
                Object[] objArr4 = new Object[1];
                k(b5, b6, b6, objArr4);
                StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) cls2.getMethod((String) objArr4[0], null).invoke(thread, null);
                int length = stackTraceElementArr.length;
                int i = this.j;
                if (length > i) {
                    StackTraceElement stackTraceElement = stackTraceElementArr[i];
                    this.g = stackTraceElement.getFileName();
                    this.i = stackTraceElement.getLineNumber();
                }
                return this;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        } catch (Throwable th2) {
            Throwable cause2 = th2.getCause();
            if (cause2 != null) {
                throw cause2;
            }
            throw th2;
        }
    }

    public String c() {
        StringBuilder sb = new StringBuilder();
        b(sb);
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        b(sb);
        a(sb);
        return sb.toString();
    }

    public <T> c a(T t) {
        this.f7465a.append(t);
        return this;
    }

    public c a(Throwable th) {
        a((c) '\n').a((c) Log.getStackTraceString(th));
        return this;
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        a(sb);
        return sb.toString();
    }

    public final StringBuilder a(StringBuilder sb) {
        sb.append(InputCardNumberView.DIVIDER);
        sb.append(this.f7465a.toString());
        return sb;
    }

    public final StringBuilder b(StringBuilder sb) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
        sb.append('[');
        sb.append(simpleDateFormat.format(Long.valueOf(this.e)));
        String a2 = a(this.d);
        sb.append(InputCardNumberView.DIVIDER);
        sb.append(a2);
        sb.append('/');
        sb.append(this.c);
        sb.append('/');
        sb.append(this.b);
        sb.append(InputCardNumberView.DIVIDER);
        sb.append(this.h);
        sb.append(':');
        sb.append(this.f);
        sb.append(InputCardNumberView.DIVIDER);
        sb.append(this.g);
        sb.append(':');
        sb.append(this.i);
        sb.append(']');
        return sb;
    }
}
