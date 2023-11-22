package com.google.zxing;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;

/* loaded from: classes3.dex */
public abstract class ReaderException extends Exception {
    protected static final StackTraceElement[] NO_TRACE;
    protected static final boolean isStackTrace;
    public static final byte[] getAuthRequestContext = {107, 78, -84, 46, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -31, Ascii.NAK, 0, -6, Ascii.EM, -28, 19, 0, 0, 34, -37, 9, -6, 10, -7, -4};
    public static final int BuiltInFictitiousFunctionClassFactory = 71;

    /* JADX WARN: Removed duplicated region for block: B:12:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0057  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0057 -> B:15:0x0060). Please submit an issue!!! */
    static {
        /*
            r0 = 30
            byte[] r0 = new byte[r0]
            r0 = {x006a: FILL_ARRAY_DATA , data: [107, 78, -84, 46, 11, -19, 23, 53, -60, 13, -11, 9, 59, -35, -31, 21, 0, -6, 25, -28, 19, 0, 0, 34, -37, 9, -6, 10, -7, -4} // fill-array
            com.google.zxing.ReaderException.getAuthRequestContext = r0
            r0 = 71
            com.google.zxing.ReaderException.BuiltInFictitiousFunctionClassFactory = r0
            java.lang.String r0 = "surefire.test.class.path"
            java.lang.String r0 = java.lang.System.getProperty(r0)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L1a
            r0 = 1
            goto L1b
        L1a:
            r0 = 0
        L1b:
            com.google.zxing.ReaderException.isStackTrace = r0
            byte[] r0 = com.google.zxing.ReaderException.getAuthRequestContext
            r3 = 16
            r3 = r0[r3]
            byte r3 = (byte) r3
            byte r4 = (byte) r3
            byte r5 = (byte) r4
            int r4 = r4 * 2
            int r4 = r4 + 27
            int r3 = r3 * 3
            int r3 = 106 - r3
            int r5 = r5 * 2
            int r5 = 4 - r5
            byte[] r6 = new byte[r4]
            if (r0 != 0) goto L3b
            r7 = r6
            r8 = 0
            r6 = r5
            r5 = r4
            goto L60
        L3b:
            r7 = 0
        L3c:
            r9 = r4
            r4 = r3
            r3 = r9
            byte r8 = (byte) r4
            r6[r7] = r8
            int r7 = r7 + r1
            if (r7 != r3) goto L57
            java.lang.String r0 = new java.lang.String
            r0.<init>(r6, r2)
            java.lang.Class r0 = java.lang.Class.forName(r0)
            java.lang.Object r0 = java.lang.reflect.Array.newInstance(r0, r2)
            java.lang.StackTraceElement[] r0 = (java.lang.StackTraceElement[]) r0
            com.google.zxing.ReaderException.NO_TRACE = r0
            return
        L57:
            r8 = r0[r5]
            r9 = r4
            r4 = r3
            r3 = r8
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r9
        L60:
            int r3 = -r3
            int r5 = r5 + r3
            int r3 = r5 + 2
            int r5 = r6 + 1
            r6 = r7
            r7 = r8
            goto L3c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.ReaderException.<clinit>():void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReaderException() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReaderException(Throwable th) {
        super(th);
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        synchronized (this) {
        }
        return null;
    }
}
