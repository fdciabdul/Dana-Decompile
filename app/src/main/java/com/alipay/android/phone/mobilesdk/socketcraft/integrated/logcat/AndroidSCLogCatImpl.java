package com.alipay.android.phone.mobilesdk.socketcraft.integrated.logcat;

import android.os.Process;
import com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatInterface;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes6.dex */
public class AndroidSCLogCatImpl implements SCLogCatInterface {
    public static final byte[] PlaceComponentResult = {121, 107, -47, -24, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int MyBillsEntityDataFactory = 75;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(byte r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 + 4
            int r8 = r8 * 3
            int r8 = 16 - r8
            byte[] r0 = com.alipay.android.phone.mobilesdk.socketcraft.integrated.logcat.AndroidSCLogCatImpl.PlaceComponentResult
            int r7 = r7 * 7
            int r7 = r7 + 99
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L34
        L19:
            r3 = 0
        L1a:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r8) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            int r3 = r3 + 1
            int r6 = r6 + 1
            r4 = r0[r6]
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L34:
            int r7 = r7 + r8
            int r7 = r7 + 2
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.android.phone.mobilesdk.socketcraft.integrated.logcat.AndroidSCLogCatImpl.b(byte, byte, short, java.lang.Object[]):void");
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatInterface
    public void info(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(a());
        sb.append(str2);
        InstrumentInjector.log_i(str, sb.toString());
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatInterface
    public void verbose(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(a());
        sb.append(str2);
        InstrumentInjector.log_v(str, sb.toString());
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatInterface
    public void debug(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(a());
        sb.append(str2);
        InstrumentInjector.log_d(str, sb.toString());
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatInterface
    public void warn(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(a());
        sb.append(str2);
        InstrumentInjector.log_w(str, sb.toString());
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatInterface
    public void warn(String str, Throwable th) {
        InstrumentInjector.log_w(str, th);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatInterface
    public void warn(String str, String str2, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(a());
        sb.append(str2);
        InstrumentInjector.log_w(str, sb.toString(), th);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatInterface
    public void error(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(a());
        sb.append(str2);
        InstrumentInjector.log_e(str, sb.toString());
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatInterface
    public void error(String str, Throwable th) {
        InstrumentInjector.log_e(str, a(), th);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatInterface
    public void error(String str, String str2, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(a());
        sb.append(str2);
        InstrumentInjector.log_e(str, sb.toString(), th);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatInterface
    public void printInfo(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(a());
        sb.append(str2);
        InstrumentInjector.log_i(str, sb.toString());
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatInterface
    public void printError(String str, Throwable th) {
        InstrumentInjector.log_e(str, a(), th);
    }

    private static final String a() {
        StringBuilder sb = new StringBuilder(" [");
        sb.append(Process.myPid());
        sb.append(":");
        try {
            byte b = PlaceComponentResult[22];
            byte b2 = PlaceComponentResult[15];
            Object[] objArr = new Object[1];
            b(b, b2, (byte) (b2 - 1), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (-PlaceComponentResult[15]);
            Object[] objArr2 = new Object[1];
            b(b3, (byte) (b3 + 1), PlaceComponentResult[15], objArr2);
            sb.append(((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getId());
            sb.append("] ");
            return sb.toString();
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }
}
