package com.google.firebase.crashlytics.internal.stacktrace;

import com.google.common.base.Ascii;

/* loaded from: classes7.dex */
public class MiddleOutStrategy implements StackTraceTrimmingStrategy {
    private final int trimmedSize;
    public static final byte[] PlaceComponentResult = {82, -89, -124, -60, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, Ascii.US, -21, 0, 6, -25, Ascii.FS, -19, 0, 0, -34, 37, -9, 6, -10, 7, 4};
    public static final int BuiltInFictitiousFunctionClassFactory = 209;

    public MiddleOutStrategy(int i) {
        this.trimmedSize = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x004c -> B:14:0x0053). Please submit an issue!!! */
    @Override // com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.StackTraceElement[] getTrimmedStackTrace(java.lang.StackTraceElement[] r13) {
        /*
            r12 = this;
            int r0 = r13.length
            int r1 = r12.trimmedSize
            if (r0 > r1) goto L6
            return r13
        L6:
            int r0 = r1 / 2
            int r2 = r1 - r0
            byte[] r3 = com.google.firebase.crashlytics.internal.stacktrace.MiddleOutStrategy.PlaceComponentResult
            r4 = 16
            r4 = r3[r4]
            byte r4 = (byte) r4
            byte r5 = (byte) r4
            byte r6 = (byte) r5
            int r4 = r4 * 4
            int r4 = r4 + 27
            int r5 = r5 * 2
            int r5 = 106 - r5
            int r6 = r6 * 2
            int r6 = 3 - r6
            byte[] r7 = new byte[r4]
            int r4 = r4 + (-1)
            r8 = 0
            if (r3 != 0) goto L2a
            r9 = r7
            r10 = 0
            r7 = r6
            goto L53
        L2a:
            r9 = 0
        L2b:
            byte r10 = (byte) r5
            r7[r9] = r10
            int r6 = r6 + 1
            int r10 = r9 + 1
            if (r9 != r4) goto L4c
            java.lang.String r3 = new java.lang.String
            r3.<init>(r7, r8)
            java.lang.Class r3 = java.lang.Class.forName(r3)
            java.lang.Object r1 = java.lang.reflect.Array.newInstance(r3, r1)
            java.lang.StackTraceElement[] r1 = (java.lang.StackTraceElement[]) r1
            java.lang.System.arraycopy(r13, r8, r1, r8, r2)
            int r3 = r13.length
            int r3 = r3 - r0
            java.lang.System.arraycopy(r13, r3, r1, r2, r0)
            return r1
        L4c:
            r9 = r3[r6]
            r11 = r6
            r6 = r5
            r5 = r9
            r9 = r7
            r7 = r11
        L53:
            int r6 = r6 + r5
            int r5 = r6 + 2
            r6 = r7
            r7 = r9
            r9 = r10
            goto L2b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.stacktrace.MiddleOutStrategy.getTrimmedStackTrace(java.lang.StackTraceElement[]):java.lang.StackTraceElement[]");
    }
}
