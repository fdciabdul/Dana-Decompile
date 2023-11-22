package com.iap.ac.android.diagnoselog.core;

import android.os.Process;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: classes3.dex */
public class TraceLog {

    /* renamed from: a  reason: collision with root package name */
    public String f7569a;
    public String b;
    public String c;
    public Throwable d;
    public int e = Process.myTid();
    public String f;
    public String g;
    public static final byte[] getAuthRequestContext = {71, Ascii.US, 113, 39, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int PlaceComponentResult = 246;
    public static SimpleDateFormat h = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.getDefault());

    public TraceLog(String str, String str2, String str3, Throwable th) {
        this.f7569a = str;
        this.b = str2;
        this.c = str3;
        this.d = th;
        try {
            Object[] objArr = new Object[1];
            i((byte) (getAuthRequestContext[15] + 1), (byte) (-getAuthRequestContext[15]), getAuthRequestContext[16], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b = (byte) (-getAuthRequestContext[15]);
            Object[] objArr2 = new Object[1];
            i(b, (byte) (b - 1), getAuthRequestContext[15], objArr2);
            this.f = ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getName();
            this.g = DiagnoseLogContext.b().c();
        } catch (Throwable th2) {
            Throwable cause = th2.getCause();
            if (cause == null) {
                throw th2;
            }
            throw cause;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:11:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void i(byte r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.iap.ac.android.diagnoselog.core.TraceLog.getAuthRequestContext
            int r8 = r8 + 4
            int r6 = r6 * 7
            int r6 = 106 - r6
            int r7 = r7 * 3
            int r7 = r7 + 13
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r6 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L36
        L1a:
            r3 = 0
        L1b:
            int r8 = r8 + 1
            byte r4 = (byte) r6
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L2c
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2c:
            r3 = r0[r8]
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L36:
            int r7 = -r7
            int r8 = r8 + r7
            int r7 = r8 + 2
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.diagnoselog.core.TraceLog.i(byte, byte, short, java.lang.Object[]):void");
    }
}
