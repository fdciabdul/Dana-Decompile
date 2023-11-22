package com.iap.ac.android.diagnoselog.storage;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.iap.android.aplog.core.appender.MdapFileLogAppender;
import com.alipay.iap.android.aplog.core.layout.mas.MasLog;
import com.iap.ac.android.diagnoselog.core.DiagnoseLogContext;
import com.iap.ac.android.diagnoselog.core.TraceLog;
import com.iap.ac.android.loglite.core.AnalyticsContext;
import com.iap.ac.android.loglite.utils.FileUtil;
import com.iap.ac.android.loglite.utils.LoggerWrapper;
import id.dana.cashier.view.InputCardNumberView;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import o.VerifyPinStateManager$executeRiskChallenge$2$2;

/* loaded from: classes3.dex */
public class DiagnoseFileStorage implements DiagnoseStorage {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char[] KClassImpl$Data$declaredNonStaticMembers$2 = null;
    private static int MyBillsEntityDataFactory = 0;
    public static final long g;
    private static int getAuthRequestContext = 1;
    public static final long h;
    public static final Comparator<File> i;

    /* renamed from: a  reason: collision with root package name */
    public Context f7574a;
    public ThreadPoolExecutor b;
    public File c;
    public StringBuilder d = new StringBuilder(8192);
    public File e;
    public String f;

    /* loaded from: classes3.dex */
    public static final class a implements Comparator<File> {
        @Override // java.util.Comparator
        public final int compare(File file, File file2) {
            return file.getName().compareTo(file2.getName());
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TraceLog f7575a;

        public b(TraceLog traceLog) {
            this.f7575a = traceLog;
        }

        @Override // java.lang.Runnable
        public void run() {
            TraceLog traceLog = this.f7575a;
            if (traceLog == null) {
                return;
            }
            StringBuilder sb = DiagnoseFileStorage.this.d;
            try {
                sb.append(TraceLog.h.format(new Date()));
                sb.append(",");
                sb.append(traceLog.b);
                sb.append(",");
                sb.append(traceLog.f7569a);
                sb.append(",");
                sb.append(traceLog.g);
                sb.append(",");
                sb.append(traceLog.e);
                sb.append(":");
                sb.append(traceLog.f);
                sb.append(",");
                sb.append(traceLog.c);
                sb.append(MasLog.Constant.GAP);
                if (traceLog.d != null) {
                    sb.append(InputCardNumberView.DIVIDER);
                    sb.append(traceLog.d.getMessage());
                }
            } catch (Exception e) {
                LoggerWrapper.w("TraceLog", e);
                sb.setLength(0);
            }
            if (DiagnoseFileStorage.this.d.length() > 8192) {
                DiagnoseFileStorage diagnoseFileStorage = DiagnoseFileStorage.this;
                diagnoseFileStorage.a(diagnoseFileStorage.d.toString(), DiagnoseFileStorage.this.b());
            }
        }
    }

    static {
        MyBillsEntityDataFactory();
        g = TimeUnit.HOURS.toMillis(1L);
        h = TimeUnit.DAYS.toMillis(7L);
        i = new a();
        int i2 = getAuthRequestContext + 67;
        MyBillsEntityDataFactory = i2 % 128;
        if ((i2 % 2 != 0 ? '\b' : 'Y') != 'Y') {
            int i3 = 91 / 0;
        }
    }

    public DiagnoseFileStorage(Context context, String str, ThreadPoolExecutor threadPoolExecutor) {
        this.f7574a = context;
        this.b = threadPoolExecutor;
        this.f = str;
    }

    static void MyBillsEntityDataFactory() {
        KClassImpl$Data$declaredNonStaticMembers$2 = new char[]{35508, 35530, 35539, 35495, 35500};
    }

    public void a(TraceLog traceLog) {
        int i2 = MyBillsEntityDataFactory + 61;
        getAuthRequestContext = i2 % 128;
        if ((i2 % 2 == 0 ? 'P' : ',') != 'P') {
            if (!DiagnoseLogContext.b().e) {
                return;
            }
        } else {
            boolean z = DiagnoseLogContext.b().e;
            Object obj = null;
            obj.hashCode();
            if (!z) {
                return;
            }
        }
        this.b.execute(new b(traceLog));
        int i3 = MyBillsEntityDataFactory + 33;
        getAuthRequestContext = i3 % 128;
        int i4 = i3 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0043, code lost:
    
        if (android.text.TextUtils.equals(r5.c.getName(), r0) == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.io.File b() {
        /*
            r5 = this;
            long r0 = java.lang.System.currentTimeMillis()
            long r2 = com.iap.ac.android.diagnoselog.storage.DiagnoseFileStorage.g
            long r0 = r0 / r2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            long r0 = r0 * r2
            r4.append(r0)
            java.lang.String r0 = "_"
            r4.append(r0)
            java.lang.String r0 = r5.f
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            java.io.File r1 = r5.c
            if (r1 == 0) goto L48
            boolean r1 = r1.exists()
            r2 = 1
            if (r1 == 0) goto L2c
            r1 = 0
            goto L2d
        L2c:
            r1 = 1
        L2d:
            if (r1 == r2) goto L48
            int r1 = com.iap.ac.android.diagnoselog.storage.DiagnoseFileStorage.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L46
            int r1 = r1 + 33
            int r2 = r1 % 128
            com.iap.ac.android.diagnoselog.storage.DiagnoseFileStorage.getAuthRequestContext = r2     // Catch: java.lang.Exception -> L46
            int r1 = r1 % 2
            java.io.File r1 = r5.c
            java.lang.String r1 = r1.getName()
            boolean r1 = android.text.TextUtils.equals(r1, r0)
            if (r1 != 0) goto Lb7
            goto L48
        L46:
            r0 = move-exception
            throw r0
        L48:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "checkAndRollFile: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "DiagnoseFileStorage"
            com.iap.ac.android.loglite.utils.LoggerWrapper.i(r2, r1)
            java.io.File r1 = r5.e
            if (r1 != 0) goto L82
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L7c
            android.content.Context r3 = r5.f7574a     // Catch: java.lang.Throwable -> L7c
            java.io.File r3 = r3.getFilesDir()     // Catch: java.lang.Throwable -> L7c
            java.lang.String r4 = "diagnoseLogs"
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> L7c
            r5.e = r1     // Catch: java.lang.Throwable -> L7c
            int r1 = com.iap.ac.android.diagnoselog.storage.DiagnoseFileStorage.MyBillsEntityDataFactory
            int r1 = r1 + 21
            int r2 = r1 % 128
            com.iap.ac.android.diagnoselog.storage.DiagnoseFileStorage.getAuthRequestContext = r2
            int r1 = r1 % 2
            goto L82
        L7c:
            r1 = move-exception
            java.lang.String r3 = "getCurrentLogsDir"
            com.iap.ac.android.loglite.utils.LoggerWrapper.e(r2, r3, r1)
        L82:
            java.io.File r1 = r5.e     // Catch: java.lang.Throwable -> La6
            r2 = 39
            if (r1 == 0) goto L8b
            r3 = 39
            goto L8d
        L8b:
            r3 = 71
        L8d:
            if (r3 == r2) goto L90
            goto La7
        L90:
            int r2 = com.iap.ac.android.diagnoselog.storage.DiagnoseFileStorage.MyBillsEntityDataFactory
            int r2 = r2 + 23
            int r3 = r2 % 128
            com.iap.ac.android.diagnoselog.storage.DiagnoseFileStorage.getAuthRequestContext = r3
            int r2 = r2 % 2
            boolean r1 = r1.exists()     // Catch: java.lang.Throwable -> La6
            if (r1 != 0) goto La7
            java.io.File r1 = r5.e     // Catch: java.lang.Throwable -> La6
            r1.mkdirs()     // Catch: java.lang.Throwable -> La6
            goto La7
        La6:
        La7:
            java.io.File r1 = r5.e
            if (r1 != 0) goto Lad
            r0 = 0
            return r0
        Lad:
            r5.a(r1)     // Catch: java.lang.Throwable -> Lb0
        Lb0:
            java.io.File r2 = new java.io.File
            r2.<init>(r1, r0)
            r5.c = r2
        Lb7:
            java.io.File r0 = r5.c
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.diagnoselog.storage.DiagnoseFileStorage.b():java.io.File");
    }

    public final void a(String str, File file) {
        int i2 = getAuthRequestContext + 65;
        MyBillsEntityDataFactory = i2 % 128;
        int i3 = i2 % 2;
        if (file != null) {
            int i4 = getAuthRequestContext + 47;
            MyBillsEntityDataFactory = i4 % 128;
            int i5 = i4 % 2;
            try {
                if ((AnalyticsContext.getInstance().isNeedEncryptLog() ? ',' : '3') != '3') {
                    int i6 = getAuthRequestContext + 41;
                    MyBillsEntityDataFactory = i6 % 128;
                    int i7 = i6 % 2;
                    String encrypt = AnalyticsContext.getInstance().getLogEncryptClient().encrypt(str);
                    if (!TextUtils.isEmpty(encrypt)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(MdapFileLogAppender.ENCRYPT_SIGN);
                        sb.append(encrypt);
                        sb.append(MasLog.Constant.GAP);
                        str = sb.toString();
                    }
                }
                Object[] objArr = new Object[1];
                j(new int[]{0, 5, 0, 0}, false, new byte[]{1, 1, 0, 1, 1}, objArr);
                FileUtil.writeFile(file, str.getBytes(((String) objArr[0]).intern()), true);
                int i8 = MyBillsEntityDataFactory + 125;
                getAuthRequestContext = i8 % 128;
                int i9 = i8 % 2;
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0027, code lost:
    
        if (r2.d.length() == 0) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0029, code lost:
    
        r0 = com.iap.ac.android.diagnoselog.storage.DiagnoseFileStorage.getAuthRequestContext + 99;
        com.iap.ac.android.diagnoselog.storage.DiagnoseFileStorage.MyBillsEntityDataFactory = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0034, code lost:
    
        r0 = new java.lang.StringBuilder();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
    
        r0.append(" appender flush: ");
        r0.append(r2.d.length());
        com.iap.ac.android.loglite.utils.LoggerWrapper.v("DiagnoseFileStorage", r0.toString());
        a(r2.d.toString(), b());
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005d, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005e, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005f, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001c, code lost:
    
        if (r0 == 0) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a() {
        /*
            r2 = this;
            int r0 = com.iap.ac.android.diagnoselog.storage.DiagnoseFileStorage.getAuthRequestContext
            int r0 = r0 + 63
            int r1 = r0 % 128
            com.iap.ac.android.diagnoselog.storage.DiagnoseFileStorage.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            r1 = 1
            if (r0 == 0) goto Lf
            r0 = 0
            goto L10
        Lf:
            r0 = 1
        L10:
            if (r0 == r1) goto L21
            java.lang.StringBuilder r0 = r2.d
            int r0 = r0.length()
            r1 = 0
            r1.hashCode()     // Catch: java.lang.Throwable -> L1f
            if (r0 != 0) goto L34
            goto L29
        L1f:
            r0 = move-exception
            throw r0
        L21:
            java.lang.StringBuilder r0 = r2.d
            int r0 = r0.length()
            if (r0 != 0) goto L34
        L29:
            int r0 = com.iap.ac.android.diagnoselog.storage.DiagnoseFileStorage.getAuthRequestContext
            int r0 = r0 + 99
            int r1 = r0 % 128
            com.iap.ac.android.diagnoselog.storage.DiagnoseFileStorage.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            return
        L34:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = " appender flush: "
            r0.append(r1)     // Catch: java.lang.Exception -> L5e
            java.lang.StringBuilder r1 = r2.d     // Catch: java.lang.Exception -> L5e
            int r1 = r1.length()     // Catch: java.lang.Exception -> L5e
            r0.append(r1)     // Catch: java.lang.Exception -> L5e
            java.lang.String r1 = "DiagnoseFileStorage"
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L5e
            com.iap.ac.android.loglite.utils.LoggerWrapper.v(r1, r0)     // Catch: java.lang.Exception -> L5e
            java.lang.StringBuilder r0 = r2.d     // Catch: java.lang.Exception -> L5e
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L5e
            java.io.File r1 = r2.b()     // Catch: java.lang.Exception -> L5e
            r2.a(r0, r1)     // Catch: java.lang.Exception -> L5e
            return
        L5e:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.diagnoselog.storage.DiagnoseFileStorage.a():void");
    }

    public void a(File file) {
        if (file.isDirectory()) {
            File[] fileArr = null;
            try {
                fileArr = file.listFiles();
            } catch (Throwable th) {
                LoggerWrapper.e("DiagnoseFileStorage", "cleanExpiresFile", th);
            }
            try {
                int i2 = MyBillsEntityDataFactory + 101;
                getAuthRequestContext = i2 % 128;
                int i3 = i2 % 2;
                if (fileArr != null) {
                    if (!(fileArr.length == 0)) {
                        int i4 = getAuthRequestContext + 19;
                        MyBillsEntityDataFactory = i4 % 128;
                        int i5 = i4 % 2;
                        long currentTimeMillis = System.currentTimeMillis();
                        long j = h;
                        for (File file2 : fileArr) {
                            if (file2 != null) {
                                try {
                                    if (file2.exists() && file2.isFile()) {
                                        try {
                                            String str = file2.getName().split("_")[0];
                                            if (TextUtils.isDigitsOnly(str)) {
                                                long parseLong = Long.parseLong(str);
                                                if (parseLong < currentTimeMillis - j || parseLong > currentTimeMillis + j) {
                                                    file2.delete();
                                                    StringBuilder sb = new StringBuilder();
                                                    sb.append("cleanExpiresFile: ");
                                                    sb.append(file2.getName());
                                                    sb.append(" is too old !");
                                                    LoggerWrapper.e("DiagnoseFileStorage", sb.toString());
                                                }
                                            }
                                        } catch (Throwable unused) {
                                        }
                                    }
                                } catch (Exception e) {
                                    throw e;
                                }
                            }
                        }
                        if (FileUtil.getFolderSize(file) < 33554432) {
                            return;
                        }
                        try {
                            try {
                                a(file.listFiles());
                            } catch (Throwable unused2) {
                            }
                        } catch (Throwable unused3) {
                        }
                    }
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
    }

    public final void a(File[] fileArr) {
        File file;
        if (fileArr == null) {
            return;
        }
        try {
            int i2 = getAuthRequestContext + 13;
            try {
                MyBillsEntityDataFactory = i2 % 128;
                int i3 = i2 % 2;
                if (fileArr.length <= 0) {
                    return;
                }
                Arrays.sort(fileArr, i);
                double length = fileArr.length;
                Double.isNaN(length);
                int floor = (int) Math.floor(length * 0.25d);
                int i4 = 0;
                while (true) {
                    if ((i4 < floor ? 'P' : (char) 17) != 'P') {
                        return;
                    }
                    int i5 = getAuthRequestContext + 67;
                    MyBillsEntityDataFactory = i5 % 128;
                    if (i5 % 2 != 0) {
                        file = fileArr[i4];
                        Object[] objArr = null;
                        int length2 = objArr.length;
                        if (!(file != null)) {
                            continue;
                            i4++;
                        }
                    } else {
                        file = fileArr[i4];
                        if (!(file != null)) {
                            continue;
                            i4++;
                        }
                    }
                    if ((file.exists() ? (char) 15 : 'B') != 15) {
                        continue;
                    } else if (file.isFile()) {
                        try {
                            file.delete();
                            StringBuilder sb = new StringBuilder();
                            sb.append("cleanExpiresFile: ");
                            sb.append(file.getName());
                            sb.append(" is too large !");
                            LoggerWrapper.e("DiagnoseFileStorage", sb.toString());
                            int i6 = getAuthRequestContext + 21;
                            MyBillsEntityDataFactory = i6 % 128;
                            int i7 = i6 % 2;
                        } catch (Throwable unused) {
                        }
                    }
                    i4++;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static void j(int[] iArr, boolean z, byte[] bArr, Object[] objArr) {
        VerifyPinStateManager$executeRiskChallenge$2$2 verifyPinStateManager$executeRiskChallenge$2$2 = new VerifyPinStateManager$executeRiskChallenge$2$2();
        int i2 = iArr[0];
        int i3 = iArr[1];
        int i4 = iArr[2];
        int i5 = iArr[3];
        char[] cArr = KClassImpl$Data$declaredNonStaticMembers$2;
        if (cArr != null) {
            int i6 = $11 + 121;
            $10 = i6 % 128;
            int i7 = i6 % 2;
            int length = cArr.length;
            char[] cArr2 = new char[length];
            int i8 = 0;
            while (true) {
                if (!(i8 < length)) {
                    break;
                }
                int i9 = $11 + 47;
                $10 = i9 % 128;
                if ((i9 % 2 != 0 ? (char) 29 : (char) 30) != 30) {
                    cArr2[i8] = (char) (cArr[i8] | 5097613533456403102L);
                } else {
                    cArr2[i8] = (char) (cArr[i8] ^ 5097613533456403102L);
                }
                i8++;
            }
            cArr = cArr2;
        }
        char[] cArr3 = new char[i3];
        System.arraycopy(cArr, i2, cArr3, 0, i3);
        if (bArr != null) {
            char[] cArr4 = new char[i3];
            try {
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                char c = 0;
                while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i3) {
                    int i10 = $10 + 107;
                    $11 = i10 % 128;
                    int i11 = i10 % 2;
                    if (bArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] == 1) {
                        cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - c);
                    } else {
                        cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) ((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) - c);
                    }
                    c = cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory];
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                }
                cArr3 = cArr4;
            } catch (Exception e) {
                throw e;
            }
        }
        if (i5 > 0) {
            char[] cArr5 = new char[i3];
            System.arraycopy(cArr3, 0, cArr5, 0, i3);
            int i12 = i3 - i5;
            System.arraycopy(cArr5, 0, cArr3, i12, i5);
            System.arraycopy(cArr5, i5, cArr3, 0, i12);
        }
        if (z) {
            char[] cArr6 = new char[i3];
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i3) {
                cArr6[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr3[(i3 - verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory) - 1];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                int i13 = $10 + 115;
                $11 = i13 % 128;
                int i14 = i13 % 2;
            }
            cArr3 = cArr6;
        }
        if (i4 > 0) {
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            while (true) {
                if ((verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i3 ? '\r' : 'S') != '\r') {
                    break;
                }
                int i15 = $11 + 1;
                $10 = i15 % 128;
                int i16 = i15 % 2;
                cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] - iArr[2]);
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
            }
        }
        String str = new String(cArr3);
        int i17 = $11 + 97;
        $10 = i17 % 128;
        int i18 = i17 % 2;
        objArr[0] = str;
    }
}
