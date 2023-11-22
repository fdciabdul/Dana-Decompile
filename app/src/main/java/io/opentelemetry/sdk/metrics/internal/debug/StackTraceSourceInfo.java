package io.opentelemetry.sdk.metrics.internal.debug;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;

/* loaded from: classes6.dex */
final class StackTraceSourceInfo implements SourceInfo {
    public static final byte[] PlaceComponentResult = {95, 85, -94, TarHeader.LF_SYMLINK, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, Ascii.US, -21, 0, 6, -25, Ascii.FS, -19, 0, 0, -34, 37, -9, 6, -10, 7, 4, -4, 13, -51, 39, -13, 16, -2, -39, 17, 10, -10};
    public static final int getAuthRequestContext = 211;
    private final StackTraceElement[] stackTraceElements;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = io.opentelemetry.sdk.metrics.internal.debug.StackTraceSourceInfo.PlaceComponentResult
            int r6 = r6 * 3
            int r6 = 106 - r6
            int r7 = r7 * 26
            int r7 = r7 + 4
            int r8 = r8 * 15
            int r8 = r8 + 12
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L1c
            r6 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L37
        L1c:
            r3 = 0
        L1d:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r8) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            r4 = r0[r7]
            int r3 = r3 + 1
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L37:
            int r8 = r8 + r7
            int r7 = r6 + 1
            int r6 = r8 + 2
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: io.opentelemetry.sdk.metrics.internal.debug.StackTraceSourceInfo.a(int, short, short, java.lang.Object[]):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StackTraceSourceInfo(StackTraceElement[] stackTraceElementArr) {
        this.stackTraceElements = stackTraceElementArr;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.debug.SourceInfo
    public final String shortDebugString() {
        StackTraceElement[] stackTraceElementArr = this.stackTraceElements;
        if (stackTraceElementArr.length > 0) {
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                if (isInterestingStackTrace(stackTraceElement)) {
                    return String.format("%s:%d", stackTraceElement.getFileName(), Integer.valueOf(stackTraceElement.getLineNumber()));
                }
            }
            return "unknown source";
        }
        return "unknown source";
    }

    @Override // io.opentelemetry.sdk.metrics.internal.debug.SourceInfo
    public final String multiLineDebugString() {
        if (this.stackTraceElements.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (StackTraceElement stackTraceElement : this.stackTraceElements) {
                if (isInterestingStackTrace(stackTraceElement)) {
                    sb.append("\tat ");
                    sb.append(stackTraceElement);
                    sb.append("\n");
                }
            }
            return sb.toString();
        }
        return "\tat unknown source";
    }

    private static boolean isInterestingStackTrace(StackTraceElement stackTraceElement) {
        try {
            byte b = PlaceComponentResult[16];
            byte b2 = b;
            Object[] objArr = new Object[1];
            a(b, b2, (byte) (b2 + 1), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (getAuthRequestContext & 5);
            Object[] objArr2 = new Object[1];
            a(b3, b3, PlaceComponentResult[16], objArr2);
            if (!((String) cls.getMethod((String) objArr2[0], null).invoke(stackTraceElement, null)).startsWith("io.opentelemetry.sdk.metrics")) {
                try {
                    byte b4 = PlaceComponentResult[16];
                    byte b5 = b4;
                    Object[] objArr3 = new Object[1];
                    a(b4, b5, (byte) (b5 + 1), objArr3);
                    Class<?> cls2 = Class.forName((String) objArr3[0]);
                    byte b6 = (byte) (getAuthRequestContext & 5);
                    Object[] objArr4 = new Object[1];
                    a(b6, b6, PlaceComponentResult[16], objArr4);
                    if (!((String) cls2.getMethod((String) objArr4[0], null).invoke(stackTraceElement, null)).startsWith("java.lang")) {
                        return true;
                    }
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        throw cause;
                    }
                    throw th;
                }
            }
            return false;
        } catch (Throwable th2) {
            Throwable cause2 = th2.getCause();
            if (cause2 != null) {
                throw cause2;
            }
            throw th2;
        }
    }
}
