package io.opentelemetry.sdk.metrics.internal.debug;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;

/* loaded from: classes6.dex */
public interface SourceInfo {
    String multiLineDebugString();

    String shortDebugString();

    /* renamed from: io.opentelemetry.sdk.metrics.internal.debug.SourceInfo$-CC  reason: invalid class name */
    /* loaded from: classes6.dex */
    public final /* synthetic */ class CC {
        public static final byte[] MyBillsEntityDataFactory = {125, -100, 71, Ascii.FS, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 4, -13, 35, -31, Ascii.NAK, 0, -6, Ascii.EM, -28, 19, 0, 0, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
        public static final int getAuthRequestContext = 175;

        /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x002e). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void a(short r6, int r7, byte r8, java.lang.Object[] r9) {
            /*
                int r7 = r7 * 12
                int r7 = 28 - r7
                byte[] r0 = io.opentelemetry.sdk.metrics.internal.debug.SourceInfo.CC.MyBillsEntityDataFactory
                int r6 = r6 * 3
                int r6 = r6 + 13
                int r8 = r8 + 99
                byte[] r1 = new byte[r6]
                int r6 = r6 + (-1)
                r2 = 0
                if (r0 != 0) goto L18
                r8 = r7
                r3 = r8
                r4 = 0
                r7 = r6
                goto L2e
            L18:
                r3 = 0
            L19:
                byte r4 = (byte) r8
                r1[r3] = r4
                int r4 = r3 + 1
                if (r3 != r6) goto L28
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L28:
                r3 = r0[r7]
                r5 = r7
                r7 = r6
                r6 = r8
                r8 = r5
            L2e:
                int r3 = -r3
                int r6 = r6 + r3
                int r8 = r8 + 1
                int r6 = r6 + 2
                r3 = r4
                r5 = r8
                r8 = r6
                r6 = r7
                r7 = r5
                goto L19
            */
            throw new UnsupportedOperationException("Method not decompiled: io.opentelemetry.sdk.metrics.internal.debug.SourceInfo.CC.a(short, int, byte, java.lang.Object[]):void");
        }

        public static SourceInfo noSourceInfo() {
            return NoSourceInfo.INSTANCE;
        }

        public static SourceInfo fromCurrentStack() {
            if (!DebugConfig.isMetricsDebugEnabled()) {
                return noSourceInfo();
            }
            try {
                Object[] objArr = new Object[1];
                a((byte) (-MyBillsEntityDataFactory[15]), MyBillsEntityDataFactory[21], (byte) (-MyBillsEntityDataFactory[8]), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                a(MyBillsEntityDataFactory[21], MyBillsEntityDataFactory[6], MyBillsEntityDataFactory[21], objArr2);
                Object invoke = cls.getMethod((String) objArr2[0], null).invoke(null, null);
                try {
                    Object[] objArr3 = new Object[1];
                    a((byte) (-MyBillsEntityDataFactory[15]), MyBillsEntityDataFactory[21], (byte) (-MyBillsEntityDataFactory[8]), objArr3);
                    Class<?> cls2 = Class.forName((String) objArr3[0]);
                    Object[] objArr4 = new Object[1];
                    a(MyBillsEntityDataFactory[21], (byte) (-MyBillsEntityDataFactory[15]), MyBillsEntityDataFactory[16], objArr4);
                    return new StackTraceSourceInfo((StackTraceElement[]) cls2.getMethod((String) objArr4[0], null).invoke(invoke, null));
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
    }
}
