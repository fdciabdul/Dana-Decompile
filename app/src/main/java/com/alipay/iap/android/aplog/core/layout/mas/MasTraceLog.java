package com.alipay.iap.android.aplog.core.layout.mas;

import android.os.Process;
import com.alipay.iap.android.aplog.log.TraceLog;
import id.dana.cashier.view.InputCardNumberView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public class MasTraceLog implements MasLog<TraceLog> {
    private SimpleDateFormat TRACE_LOG_DATA_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.getDefault());
    public static final byte[] PlaceComponentResult = {4, -20, -33, -123, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int BuiltInFictitiousFunctionClassFactory = 42;
    private static ThreadLocal<StringBuilder> threadBuilder = new ThreadLocal<>();

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 7
            int r7 = r7 + 99
            byte[] r0 = com.alipay.iap.android.aplog.core.layout.mas.MasTraceLog.PlaceComponentResult
            int r6 = r6 * 3
            int r6 = 16 - r6
            int r8 = r8 * 12
            int r8 = 16 - r8
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1c
            r7 = r6
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L36
        L1c:
            r3 = 0
        L1d:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r6) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L36:
            int r8 = r8 + 1
            int r9 = r9 + r6
            int r6 = r9 + 2
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.aplog.core.layout.mas.MasTraceLog.a(byte, short, byte, java.lang.Object[]):void");
    }

    @Override // com.alipay.iap.android.aplog.core.layout.mas.MasLog
    public String getLayout(TraceLog traceLog) {
        StringBuilder sb = threadBuilder.get();
        if (sb == null) {
            sb = new StringBuilder();
            threadBuilder.set(sb);
        }
        String format = this.TRACE_LOG_DATA_FORMAT.format(new Date(System.currentTimeMillis()));
        int myTid = Process.myTid();
        try {
            byte b = (byte) (PlaceComponentResult[15] - 1);
            byte b2 = PlaceComponentResult[15];
            Object[] objArr = new Object[1];
            a(b, b2, (byte) (b2 - 1), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = PlaceComponentResult[15];
            Object[] objArr2 = new Object[1];
            a(b3, (byte) (b3 - 1), PlaceComponentResult[15], objArr2);
            String name = ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getName();
            sb.append(format);
            sb.append(InputCardNumberView.DIVIDER);
            sb.append(traceLog.getLevel());
            sb.append('/');
            sb.append(traceLog.getTag());
            sb.append(':');
            sb.append('[');
            sb.append(myTid);
            sb.append(':');
            sb.append(name);
            sb.append("] ");
            sb.append(traceLog.getMsg());
            if (traceLog.getTr() != null) {
                sb.append(" ");
                sb.append(traceLog.getTr());
            }
            String obj = sb.toString();
            sb.setLength(0);
            return obj;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }
}
