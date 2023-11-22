package com.alipay.iap.android.aplog.core.appender;

import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.aplog.api.LogContext;
import com.alipay.iap.android.aplog.core.LoggerFactory;
import com.alipay.iap.android.aplog.core.logger.TraceLogger;
import com.alipay.iap.android.aplog.util.FileUtil;
import com.alipay.iap.android.aplog.util.LoggingUtil;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
import o.getOnBoardingScenario;

@Deprecated
/* loaded from: classes3.dex */
public class LogFileLogAppender extends AnalyticsLogAppender {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    protected static final Comparator<File> CLEAN_FILE_COMPARATOR;
    protected static final int CLEAN_FILE_SCOPE = 4;
    protected static final String DEFAULT_CHARSET;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    public static final int MyBillsEntityDataFactory;
    private static long PlaceComponentResult = 0;
    protected static final String SEPARATOR_DATA = "$$";
    protected static final int SEPARATOR_DATA_LEN = 2;
    public static final String TAG = "LogFileAppender";
    public static final byte[] getAuthRequestContext;
    protected File currentLogFile;
    protected long currentLogRoll;
    protected int eventBufferLength;
    protected StringBuilder eventDataBuffer;
    protected long expiredSize;
    protected long expiredTime;
    protected long fileRollTime;
    protected boolean isAppendBytesError;
    protected boolean isBufferToBytesError;
    protected boolean isGzipBytesError;
    protected boolean isHybridEncryptError;
    String logCategory;
    protected File mCurrentLogsDir;

    static void MyBillsEntityDataFactory() {
        PlaceComponentResult = 2491498803940496030L;
    }

    private static void b(int i, short s, byte b, Object[] objArr) {
        int i2 = 106 - (b * 7);
        int i3 = (s * 3) + 13;
        int i4 = 15 - (i * 12);
        try {
            byte[] bArr = getAuthRequestContext;
            byte[] bArr2 = new byte[i3];
            int i5 = -1;
            int i6 = i3 - 1;
            if ((bArr == null ? 'E' : (char) 22) != 22) {
                int i7 = BuiltInFictitiousFunctionClassFactory + 25;
                KClassImpl$Data$declaredNonStaticMembers$2 = i7 % 128;
                if (i7 % 2 != 0) {
                    Object obj = null;
                    obj.hashCode();
                }
                int i8 = BuiltInFictitiousFunctionClassFactory + 27;
                KClassImpl$Data$declaredNonStaticMembers$2 = i8 % 128;
                int i9 = i8 % 2;
                i2 = i6 + (-i2) + 2;
                i6 = i6;
            }
            while (true) {
                i5++;
                bArr2[i5] = (byte) i2;
                i4++;
                if (i5 == i6) {
                    objArr[0] = new String(bArr2, 0);
                    return;
                }
                int i10 = i2;
                int i11 = i6;
                i2 = i10 + (-bArr[i4]) + 2;
                i6 = i11;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    static {
        MyBillsEntityDataFactory();
        getAuthRequestContext = new byte[]{59, -103, 22, 57, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
        MyBillsEntityDataFactory = 7;
        Object[] objArr = new Object[1];
        a((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 58363, new char[]{50056, 8306, 1133, 26625, 19465}, objArr);
        DEFAULT_CHARSET = ((String) objArr[0]).intern();
        CLEAN_FILE_COMPARATOR = new Comparator<File>() { // from class: com.alipay.iap.android.aplog.core.appender.LogFileLogAppender.1
            @Override // java.util.Comparator
            public final int compare(File file, File file2) {
                return file.getName().compareTo(file2.getName());
            }
        };
        int i = BuiltInFictitiousFunctionClassFactory + 33;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
    }

    public LogFileLogAppender(LogContext logContext, String str, long j, long j2, long j3, int i) {
        super(logContext, str);
        this.fileRollTime = j;
        this.expiredTime = j2;
        this.expiredSize = j3;
        this.logCategory = str;
        int i2 = i / 2;
        this.eventBufferLength = i2;
        this.eventDataBuffer = new StringBuilder(i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0052, code lost:
    
        if (r9.currentLogFile.getName().equals(r0) == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0061, code lost:
    
        if (r9.currentLogFile.getName().equals(r0) == false) goto L23;
     */
    @Override // com.alipay.iap.android.aplog.core.appender.Appender
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.io.File getFile() {
        /*
            Method dump skipped, instructions count: 227
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.aplog.core.appender.LogFileLogAppender.getFile():java.io.File");
    }

    protected void handleExtrasOnGetNewFile() {
        StringBuilder sb = new StringBuilder();
        sb.append("handleExtrasOnGetNewFile, priority: ");
        try {
            byte b = (byte) (getAuthRequestContext[15] + 1);
            byte b2 = (byte) (-getAuthRequestContext[15]);
            Object[] objArr = new Object[1];
            b(b, b2, (byte) (b2 - 1), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (-getAuthRequestContext[15]);
            Object[] objArr2 = new Object[1];
            b(b3, (byte) (b3 - 1), (byte) (-getAuthRequestContext[15]), objArr2);
            sb.append(((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getPriority());
            InstrumentInjector.log_i(TAG, sb.toString());
            int i = BuiltInFictitiousFunctionClassFactory + 99;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            try {
                byte b4 = (byte) (getAuthRequestContext[15] + 1);
                byte b5 = (byte) (-getAuthRequestContext[15]);
                Object[] objArr3 = new Object[1];
                b(b4, b5, (byte) (b5 - 1), objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                byte b6 = (byte) (-getAuthRequestContext[15]);
                Object[] objArr4 = new Object[1];
                b(b6, (byte) (b6 - 1), (byte) (-getAuthRequestContext[15]), objArr4);
                ((Thread) cls2.getMethod((String) objArr4[0], null).invoke(null, null)).setPriority(5);
                SystemClock.sleep(TimeUnit.SECONDS.toMillis(20L));
                try {
                    int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 103;
                    try {
                        BuiltInFictitiousFunctionClassFactory = i3 % 128;
                        if (i3 % 2 != 0) {
                            return;
                        }
                        int i4 = 75 / 0;
                    } catch (Exception e) {
                        throw e;
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        } catch (Throwable th2) {
            Throwable cause2 = th2.getCause();
            if (cause2 == null) {
                throw th2;
            }
            throw cause2;
        }
    }

    protected File getCurrentLogsDir() {
        if ((this.mCurrentLogsDir == null ? (char) 1 : 'B') != 'B') {
            try {
                this.mCurrentLogsDir = LoggingUtil.getStorageFilesDir(this.appContext, this.logCategory);
            } catch (Throwable th) {
                InstrumentInjector.log_e(TAG, "getCurrentLogsDir", th);
            }
        }
        try {
            File file = this.mCurrentLogsDir;
            if ((file != null ? '5' : (char) 19) == '5') {
                try {
                    int i = BuiltInFictitiousFunctionClassFactory + 31;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                    int i2 = i % 2;
                    if (!file.exists()) {
                        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 117;
                        BuiltInFictitiousFunctionClassFactory = i3 % 128;
                        int i4 = i3 % 2;
                        this.mCurrentLogsDir.mkdirs();
                    }
                } catch (Exception e) {
                    throw e;
                }
            }
        } catch (Throwable th2) {
            InstrumentInjector.log_e(TAG, "getCurrentLogsDir", th2);
        }
        return this.mCurrentLogsDir;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.iap.android.aplog.core.appender.Appender
    public void flush() {
        synchronized (this) {
            if (this.eventDataBuffer.length() == 0) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.logCategory);
            sb.append(" appender flush: ");
            sb.append(this.eventDataBuffer.length());
            InstrumentInjector.log_v(TAG, sb.toString());
            appendDataToFile();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.iap.android.aplog.core.appender.Appender
    public void onAppend(String str) {
        synchronized (this) {
            TraceLogger traceLogger = LoggerFactory.getTraceLogger();
            StringBuilder sb = new StringBuilder();
            sb.append("LogFileAppender write log: ");
            sb.append(str);
            traceLogger.debug(TAG, sb.toString());
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int length = this.eventDataBuffer.length();
            int length2 = str.length();
            int i = SEPARATOR_DATA_LEN;
            if (length + length2 + i > this.eventBufferLength) {
                appendDataToFile();
                if (this.eventDataBuffer.length() + str.length() + i > this.eventBufferLength) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append("$$");
                    String obj = sb2.toString();
                    try {
                        Object[] objArr = new Object[1];
                        a(Color.argb(0, 0, 0, 0) + 58363, new char[]{50056, 8306, 1133, 26625, 19465}, objArr);
                        byte[] bytes = obj.getBytes(((String) objArr[0]).intern());
                        onAppend(bytes, 0, bytes.length);
                    } catch (Throwable th) {
                        if (!this.isBufferToBytesError) {
                            this.isBufferToBytesError = true;
                            InstrumentInjector.log_e(TAG, "appendLogEvent", th);
                        }
                    }
                } else {
                    appendDataToBuffer(str);
                }
            } else {
                appendDataToBuffer(str);
            }
        }
    }

    private void appendDataToBuffer(String str) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 51;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if ((i % 2 == 0 ? '=' : '\\') != '=') {
            try {
                StringBuilder sb = this.eventDataBuffer;
                sb.append(str);
                sb.append("$$");
            } catch (Exception e) {
                throw e;
            }
        } else {
            StringBuilder sb2 = this.eventDataBuffer;
            sb2.append(str);
            sb2.append("$$");
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 53;
        BuiltInFictitiousFunctionClassFactory = i2 % 128;
        if (!(i2 % 2 == 0)) {
            return;
        }
        int i3 = 72 / 0;
    }

    private boolean appendDataToFile() {
        int i = BuiltInFictitiousFunctionClassFactory + 101;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        try {
            if ((i % 2 != 0 ? (char) 29 : '[') == '[') {
                String obj = this.eventDataBuffer.toString();
                Object[] objArr = new Object[1];
                a(58363 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), new char[]{50056, 8306, 1133, 26625, 19465}, objArr);
                byte[] bytes = obj.getBytes(((String) objArr[0]).intern());
                return onAppend(bytes, 0, bytes.length);
            }
            String obj2 = this.eventDataBuffer.toString();
            Object[] objArr2 = new Object[1];
            a(58363 - (ViewConfiguration.getMaximumDrawingCacheSize() + 56), new char[]{50056, 8306, 1133, 26625, 19465}, objArr2);
            byte[] bytes2 = obj2.getBytes(((String) objArr2[0]).intern());
            boolean onAppend = onAppend(bytes2, 1, bytes2.length);
            this.eventDataBuffer.setLength(1);
            return onAppend;
        } catch (Throwable th) {
            try {
                if (!this.isBufferToBytesError) {
                    this.isBufferToBytesError = true;
                    InstrumentInjector.log_e(TAG, "appendLogEvent", th);
                }
                this.eventDataBuffer.setLength(0);
                int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 101;
                BuiltInFictitiousFunctionClassFactory = i2 % 128;
                int i3 = i2 % 2;
                return false;
            } finally {
                this.eventDataBuffer.setLength(0);
            }
        }
    }

    protected void cleanExpiresFile(File file, long j, long j2) {
        File[] fileArr;
        long currentTimeMillis;
        int length;
        int i;
        int length2;
        if (file == null || !file.isDirectory()) {
            return;
        }
        File[] fileArr2 = null;
        try {
            File[] listFiles = file.listFiles();
            int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 89;
            BuiltInFictitiousFunctionClassFactory = i2 % 128;
            int i3 = i2 % 2;
            fileArr = listFiles;
        } catch (Throwable th) {
            InstrumentInjector.log_w(TAG, "cleanExpiresFile", th);
            fileArr = null;
        }
        if (fileArr == null || fileArr.length == 0) {
            return;
        }
        try {
            int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 43;
            BuiltInFictitiousFunctionClassFactory = i4 % 128;
            if (i4 % 2 == 0) {
                currentTimeMillis = System.currentTimeMillis();
                length = fileArr.length;
                i = 1;
            } else {
                currentTimeMillis = System.currentTimeMillis();
                length = fileArr.length;
                i = 0;
            }
            for (int i5 = i; i5 < length; i5++) {
                File file2 = fileArr[i5];
                if (file2 != null) {
                    if ((file2.exists()) && file2.isFile()) {
                        int i6 = BuiltInFictitiousFunctionClassFactory + 35;
                        KClassImpl$Data$declaredNonStaticMembers$2 = i6 % 128;
                        int i7 = i6 % 2;
                        try {
                            long parseLong = Long.parseLong(file2.getName().split("_")[0]);
                            if (parseLong >= currentTimeMillis - j) {
                                try {
                                    int i8 = KClassImpl$Data$declaredNonStaticMembers$2 + 115;
                                    BuiltInFictitiousFunctionClassFactory = i8 % 128;
                                    int i9 = i8 % 2;
                                    if (parseLong <= currentTimeMillis + j) {
                                    }
                                } catch (Exception e) {
                                    throw e;
                                }
                            }
                            file2.delete();
                            StringBuilder sb = new StringBuilder();
                            sb.append("cleanExpiresFile: ");
                            sb.append(file2.getName());
                            sb.append(" is too old !");
                            InstrumentInjector.log_e(TAG, sb.toString());
                        } catch (Throwable th2) {
                            InstrumentInjector.log_e(TAG, file2.getName(), th2);
                        }
                    }
                }
            }
            if (FileUtil.getFolderSize(file) < j2) {
                int i10 = BuiltInFictitiousFunctionClassFactory + 3;
                KClassImpl$Data$declaredNonStaticMembers$2 = i10 % 128;
                int i11 = i10 % 2;
                return;
            }
            try {
                fileArr2 = file.listFiles();
            } catch (Throwable th3) {
                InstrumentInjector.log_w(TAG, "cleanExpiresFile", th3);
            }
            if ((fileArr2 != null ? '!' : ']') != '!' || fileArr2.length < 4) {
                return;
            }
            int i12 = BuiltInFictitiousFunctionClassFactory + 91;
            KClassImpl$Data$declaredNonStaticMembers$2 = i12 % 128;
            if ((i12 % 2 != 0 ? '8' : (char) 31) != 31) {
                Arrays.sort(fileArr2, CLEAN_FILE_COMPARATOR);
                length2 = fileArr2.length >> 3;
            } else {
                Arrays.sort(fileArr2, CLEAN_FILE_COMPARATOR);
                length2 = fileArr2.length / 4;
            }
            int i13 = length2;
            int i14 = 0;
            while (true) {
                if (i14 >= i13) {
                    return;
                }
                File file3 = fileArr2[i14];
                if (file3 != null && file3.exists()) {
                    if (file3.isFile()) {
                        try {
                            file3.delete();
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("cleanExpiresFile: ");
                            sb2.append(file3.getName());
                            sb2.append(" is too large !");
                            InstrumentInjector.log_e(TAG, sb2.toString());
                        } catch (Throwable th4) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(file3.getName());
                            sb3.append(" cleanExpiresFile");
                            InstrumentInjector.log_w(TAG, sb3.toString(), th4);
                        }
                    }
                }
                i14++;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        getonboardingscenario.MyBillsEntityDataFactory = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (true) {
            try {
                if (getonboardingscenario.getAuthRequestContext >= cArr.length) {
                    break;
                }
                jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory)) ^ (PlaceComponentResult ^ 4796183387843776835L);
                getonboardingscenario.getAuthRequestContext++;
                int i2 = $10 + 1;
                $11 = i2 % 128;
                int i3 = i2 % 2;
            } catch (Exception e) {
                throw e;
            }
        }
        char[] cArr2 = new char[length];
        getonboardingscenario.getAuthRequestContext = 0;
        int i4 = $10 + 21;
        $11 = i4 % 128;
        int i5 = i4 % 2;
        while (true) {
            if (getonboardingscenario.getAuthRequestContext >= cArr.length) {
                objArr[0] = new String(cArr2);
                return;
            }
            try {
                cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
                getonboardingscenario.getAuthRequestContext++;
            } catch (Exception e2) {
                throw e2;
            }
        }
    }
}
