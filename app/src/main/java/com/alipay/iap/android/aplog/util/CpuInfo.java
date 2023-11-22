package com.alipay.iap.android.aplog.util;

import android.os.Build;
import com.google.common.primitives.SignedBytes;
import id.dana.cashier.view.InputCardNumberView;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: classes6.dex */
public class CpuInfo {
    private static final int BUFFER_SIZE = 1000;
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {SignedBytes.MAX_POWER_OF_TWO, 34, -50, 73, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 198;
    private static final int MAX_ENTRY_COUNT = 10;
    private final LinkedHashMap<Long, String> mCpuInfoEntries = new LinkedHashMap<Long, String>() { // from class: com.alipay.iap.android.aplog.util.CpuInfo.1
        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<Long, String> entry) {
            return size() > 10;
        }
    };
    private SimpleDateFormat TIME_FORMATTER = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.getDefault());
    private int mPid = 0;
    private long mUserLast = 0;
    private long mSystemLast = 0;
    private long mIdleLast = 0;
    private long mIoWaitLast = 0;
    private long mTotalLast = 0;
    private long mAppCpuTimeLast = 0;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002d -> B:11:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r7, short r8, short r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 * 12
            int r7 = 15 - r7
            byte[] r0 = com.alipay.iap.android.aplog.util.CpuInfo.BuiltInFictitiousFunctionClassFactory
            int r8 = r8 * 7
            int r8 = r8 + 99
            int r9 = r9 * 3
            int r9 = 16 - r9
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L1a
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r7
            goto L38
        L1a:
            r3 = 0
            r6 = r8
            r8 = r7
            r7 = r6
        L1e:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r9) goto L2d
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2d:
            int r8 = r8 + 1
            r3 = r0[r8]
            r6 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L38:
            int r7 = r7 + r8
            int r7 = r7 + 2
            r8 = r9
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.aplog.util.CpuInfo.a(byte, short, short, java.lang.Object[]):void");
    }

    public String getCpuRateInfo() {
        if (Build.VERSION.SDK_INT >= 26) {
            return "";
        }
        doSample();
        try {
            try {
                TimeUnit.MILLISECONDS.sleep(500L);
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        } catch (InterruptedException unused) {
            byte b = (byte) (BuiltInFictitiousFunctionClassFactory[15] - 1);
            byte b2 = BuiltInFictitiousFunctionClassFactory[15];
            Object[] objArr = new Object[1];
            a(b, b2, (byte) (b2 - 1), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = BuiltInFictitiousFunctionClassFactory[15];
            Object[] objArr2 = new Object[1];
            a(b3, (byte) (b3 - 1), BuiltInFictitiousFunctionClassFactory[15], objArr2);
            ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).interrupt();
        }
        doSample();
        StringBuilder sb = new StringBuilder();
        synchronized (this.mCpuInfoEntries) {
            for (Map.Entry<Long, String> entry : this.mCpuInfoEntries.entrySet()) {
                sb.append(this.TIME_FORMATTER.format(Long.valueOf(entry.getKey().longValue())));
                sb.append(InputCardNumberView.DIVIDER);
                sb.append(entry.getValue());
            }
        }
        reset();
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0092 A[Catch: all -> 0x0095, TRY_LEAVE, TryCatch #1 {all -> 0x0095, blocks: (B:38:0x008d, B:40:0x0092), top: B:46:0x008d }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void doSample() {
        /*
            r11 = this;
            r0 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L6a
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L6a
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L6a
            java.lang.String r4 = "/proc/stat"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L6a
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L6a
            r3 = 1000(0x3e8, float:1.401E-42)
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L6a
            java.lang.String r2 = r1.readLine()     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L63
            java.lang.String r4 = ""
            if (r2 != 0) goto L1d
            r2 = r4
        L1d:
            int r5 = r11.mPid     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L63
            if (r5 != 0) goto L27
            int r5 = android.os.Process.myPid()     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L63
            r11.mPid = r5     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L63
        L27:
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L63
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L63
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L63
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L63
            r8.<init>()     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L63
            java.lang.String r9 = "/proc/"
            r8.append(r9)     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L63
            int r9 = r11.mPid     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L63
            r8.append(r9)     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L63
            java.lang.String r9 = "/stat"
            r8.append(r9)     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L63
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L63
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L63
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L63
            r5.<init>(r6, r3)     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L63
            java.lang.String r0 = r5.readLine()     // Catch: java.lang.Exception -> L5c java.lang.Throwable -> L87
            if (r0 == 0) goto L55
            r4 = r0
        L55:
            r11.parse(r2, r4)     // Catch: java.lang.Exception -> L5c java.lang.Throwable -> L87
            r1.close()     // Catch: java.lang.Throwable -> L86
            goto L83
        L5c:
            r0 = move-exception
            goto L6e
        L5e:
            r2 = move-exception
            r5 = r0
            r0 = r1
            r1 = r2
            goto L8b
        L63:
            r2 = move-exception
            r5 = r0
            r0 = r2
            goto L6e
        L67:
            r1 = move-exception
            r5 = r0
            goto L8b
        L6a:
            r1 = move-exception
            r5 = r0
            r0 = r1
            r1 = r5
        L6e:
            com.alipay.iap.android.aplog.core.logger.TraceLogger r2 = com.alipay.iap.android.aplog.core.LoggerFactory.getTraceLogger()     // Catch: java.lang.Throwable -> L87
            java.lang.String r3 = "CpuInfo"
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> L87
            r2.error(r3, r0)     // Catch: java.lang.Throwable -> L87
            if (r1 == 0) goto L80
            r1.close()     // Catch: java.lang.Throwable -> L86
        L80:
            if (r5 != 0) goto L83
            return
        L83:
            r5.close()     // Catch: java.lang.Throwable -> L86
        L86:
            return
        L87:
            r0 = move-exception
            r10 = r1
            r1 = r0
            r0 = r10
        L8b:
            if (r0 == 0) goto L90
            r0.close()     // Catch: java.lang.Throwable -> L95
        L90:
            if (r5 == 0) goto L95
            r5.close()     // Catch: java.lang.Throwable -> L95
        L95:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.aplog.util.CpuInfo.doSample():void");
    }

    private void reset() {
        this.mUserLast = 0L;
        this.mSystemLast = 0L;
        this.mIdleLast = 0L;
        this.mIoWaitLast = 0L;
        this.mTotalLast = 0L;
        this.mAppCpuTimeLast = 0L;
    }

    void parse(String str, String str2) {
        long j;
        long j2;
        String[] split = str.split(" ");
        if (split.length < 9) {
            return;
        }
        long parseLong = Long.parseLong(split[2]);
        long parseLong2 = Long.parseLong(split[3]);
        long parseLong3 = Long.parseLong(split[4]);
        long parseLong4 = Long.parseLong(split[5]);
        long parseLong5 = Long.parseLong(split[6]);
        long parseLong6 = parseLong2 + parseLong + parseLong3 + parseLong4 + parseLong5 + Long.parseLong(split[7]) + Long.parseLong(split[8]);
        String[] split2 = str2.split(" ");
        if (split2.length < 17) {
            return;
        }
        long parseLong7 = Long.parseLong(split2[13]);
        long parseLong8 = Long.parseLong(split2[14]);
        long parseLong9 = parseLong7 + parseLong8 + Long.parseLong(split2[15]) + Long.parseLong(split2[16]);
        if (this.mTotalLast != 0) {
            StringBuilder sb = new StringBuilder();
            long j3 = this.mIdleLast;
            j2 = parseLong5;
            long j4 = parseLong6 - this.mTotalLast;
            j = parseLong6;
            sb.append("cpu:");
            sb.append(((j4 - (parseLong4 - j3)) * 100) / j4);
            sb.append("% ");
            sb.append("app:");
            sb.append(((parseLong9 - this.mAppCpuTimeLast) * 100) / j4);
            sb.append("% ");
            sb.append("user:");
            sb.append(((parseLong - this.mUserLast) * 100) / j4);
            sb.append("% ");
            sb.append("system:");
            sb.append(((parseLong3 - this.mSystemLast) * 100) / j4);
            sb.append("% ");
            sb.append("ioWait:");
            sb.append(((j2 - this.mIoWaitLast) * 100) / j4);
            sb.append("% ");
            synchronized (this.mCpuInfoEntries) {
                this.mCpuInfoEntries.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
            }
        } else {
            j = parseLong6;
            j2 = parseLong5;
        }
        this.mUserLast = parseLong;
        this.mSystemLast = parseLong3;
        this.mIdleLast = parseLong4;
        this.mIoWaitLast = j2;
        this.mTotalLast = j;
        this.mAppCpuTimeLast = parseLong9;
    }
}
