package com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.google.firebase.perf.metrics.resource.ResourceType;
import id.dana.sendmoney.summary.SummaryActivity;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

/* loaded from: classes6.dex */
public class JavaSCLogCatImpl implements SCLogCatInterface {
    public static final byte[] $$a = {14, -73, -90, 103, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int $$b = 40;
    public static final byte[] PlaceComponentResult = {40, 6, -7, -65, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int BuiltInFictitiousFunctionClassFactory = 236;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(int r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 3
            int r8 = r8 + 13
            int r7 = r7 * 12
            int r7 = 16 - r7
            int r6 = r6 * 7
            int r6 = 106 - r6
            byte[] r0 = com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.JavaSCLogCatImpl.PlaceComponentResult
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
            int r3 = r3 + 1
            r4 = r0[r7]
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
            int r7 = -r7
            int r8 = r8 + r7
            int r7 = r8 + 2
            int r6 = r6 + 1
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.JavaSCLogCatImpl.b(int, int, byte, java.lang.Object[]):void");
    }

    private static void c(byte b, byte b2, byte b3, Object[] objArr) {
        int i = 4 - (b * 4);
        byte[] bArr = $$a;
        int i2 = (b2 * 4) + 16;
        int i3 = 106 - (b3 * 2);
        byte[] bArr2 = new byte[i2];
        int i4 = -1;
        int i5 = i2 - 1;
        if (bArr == null) {
            int i6 = i3 + (-i);
            i++;
            int i7 = i6 + 2;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i4 = -1;
            i3 = i7;
            i5 = i5;
        }
        while (true) {
            int i8 = i4 + 1;
            bArr2[i8] = (byte) i3;
            if (i8 == i5) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            byte b4 = bArr[i];
            int i9 = i5;
            i++;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i4 = i8;
            i3 = i3 + (-b4) + 2;
            i5 = i9;
        }
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatInterface
    public void info(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(a(str, "I"));
        sb.append(":");
        sb.append(str2);
        a(sb.toString());
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatInterface
    public void verbose(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(a(str, "V"));
        sb.append(":");
        sb.append(str2);
        a(sb.toString());
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatInterface
    public void debug(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(a(str, SummaryActivity.DAYS));
        sb.append(":");
        sb.append(str2);
        a(sb.toString());
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatInterface
    public void warn(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(a(str, "W"));
        sb.append(":");
        sb.append(str2);
        a(sb.toString());
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatInterface
    public void warn(String str, Throwable th) {
        a(a(str, "W"), th);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatInterface
    public void warn(String str, String str2, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(a(str, "W"));
        sb.append(":");
        sb.append(str2);
        a(sb.toString(), th);
    }

    private void a(String str) {
        try {
            byte b = (byte) ($$a[16] - 1);
            byte b2 = b;
            Object[] objArr = new Object[1];
            c(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object obj = cls.getField("out").get(cls);
            obj.getClass().getMethod("println", String.class).invoke(obj, str);
        } catch (Throwable unused) {
        }
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatInterface
    public void error(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(a(str, "E"));
        sb.append(":");
        sb.append(str2);
        a(sb.toString(), (Throwable) null);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatInterface
    public void error(String str, Throwable th) {
        a(a(str, "E"), th);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatInterface
    public void error(String str, String str2, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(a(str, "E"));
        sb.append(":");
        sb.append(str2);
        a(sb.toString(), th);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatInterface
    public void printInfo(String str, String str2) {
        info(str, str2);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatInterface
    public void printError(String str, Throwable th) {
        error(str, th);
    }

    private String a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(new Date().toLocaleString());
        sb.append(" ");
        try {
            byte b = (byte) (PlaceComponentResult[15] + 1);
            Object[] objArr = new Object[1];
            b(b, b, (byte) (-PlaceComponentResult[15]), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = (byte) (-PlaceComponentResult[15]);
            byte b3 = b2;
            Object[] objArr2 = new Object[1];
            b(b2, b3, (byte) (b3 - 1), objArr2);
            sb.append(((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getId());
            sb.append(" ");
            try {
                byte b4 = (byte) (PlaceComponentResult[15] + 1);
                Object[] objArr3 = new Object[1];
                b(b4, b4, (byte) (-PlaceComponentResult[15]), objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                byte b5 = (byte) (-PlaceComponentResult[15]);
                byte b6 = b5;
                Object[] objArr4 = new Object[1];
                b(b5, b6, (byte) (b6 - 1), objArr4);
                sb.append(((Thread) cls2.getMethod((String) objArr4[0], null).invoke(null, null)).getName());
                sb.append(" ");
                sb.append(str2);
                sb.append(" ");
                sb.append(str);
                sb.append(" ");
                return sb.toString();
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

    private void a(String str, Throwable th) {
        if (th != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" ");
            sb.append(exception2String(th));
            str = sb.toString();
        }
        a(str);
    }

    protected String exception2String(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            th.getClass().getMethod(String.format("%s%s%s", "print", "Stack", ResourceType.TRACE), PrintWriter.class).invoke(th, printWriter);
            printWriter.flush();
        } catch (Throwable unused) {
        }
        return stringWriter.toString();
    }
}
