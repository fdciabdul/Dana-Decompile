package com.alipay.iap.android.aplog.core.appender;

import android.text.TextUtils;
import android.view.ViewConfiguration;
import com.alipay.iap.android.aplog.api.LogContext;
import com.alipay.iap.android.aplog.core.LoggerFactory;
import com.alipay.iap.android.aplog.core.logger.TraceLogger;
import com.alipay.iap.android.aplog.util.FileUtil;
import com.alipay.iap.android.aplog.util.HybridEncryption;
import com.alipay.iap.android.aplog.util.LoggingUtil;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.File;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
import kotlin.text.Typography;
import o.C;

/* loaded from: classes3.dex */
public class DiagnoseLogAppender extends EncryptAppender {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char BuiltInFictitiousFunctionClassFactory = 0;
    private static final Comparator<File> CLEAN_FILE_COMPARATOR;
    private static final int CLEAN_FILE_SCOPE = 4;
    private static final String DEFAULT_CHARSET;
    private static char KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static char MyBillsEntityDataFactory = 0;
    private static int PlaceComponentResult = 0;
    private static final String SEPARATOR_DATA = "$$";
    private static final int SEPARATOR_DATA_LEN = 2;
    private static char getAuthRequestContext = 0;
    private static int moveToNextValue = 1;
    private volatile double cleaningRate;
    private File currentLogFile;
    private long currentLogRoll;
    private int eventBufferLength;
    private StringBuilder eventDataBuffer;
    private volatile long expiredSize;
    private volatile long expiredTime;
    private long fileRollTime;
    private boolean isBufferToBytesError;
    private boolean isHybridEncryptError;
    private File mCurrentLogsDir;

    static void KClassImpl$Data$declaredNonStaticMembers$2() {
        KClassImpl$Data$declaredNonStaticMembers$2 = (char) 21390;
        BuiltInFictitiousFunctionClassFactory = (char) 29388;
        MyBillsEntityDataFactory = (char) 57485;
        getAuthRequestContext = (char) 42254;
    }

    static {
        KClassImpl$Data$declaredNonStaticMembers$2();
        Object[] objArr = new Object[1];
        a((ViewConfiguration.getJumpTapTimeout() >> 16) + 5, new char[]{53293, 42186, 58618, 36726, 63473, 63470}, objArr);
        DEFAULT_CHARSET = ((String) objArr[0]).intern();
        CLEAN_FILE_COMPARATOR = new Comparator<File>() { // from class: com.alipay.iap.android.aplog.core.appender.DiagnoseLogAppender.1
            @Override // java.util.Comparator
            public final int compare(File file, File file2) {
                return file.getName().compareTo(file2.getName());
            }
        };
        int i = PlaceComponentResult + 41;
        moveToNextValue = i % 128;
        if ((i % 2 == 0 ? (char) 23 : 'Q') != 'Q') {
            int i2 = 32 / 0;
        }
    }

    public DiagnoseLogAppender(LogContext logContext, String str, long j, long j2, long j3, int i) {
        super(logContext, str);
        this.cleaningRate = 0.25d;
        this.fileRollTime = j;
        this.expiredTime = j2;
        this.expiredSize = j3;
        int i2 = i / 2;
        this.eventBufferLength = i2;
        this.eventDataBuffer = new StringBuilder(i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0069, code lost:
    
        if (r12.currentLogFile.getName().equals(r1) == false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a7, code lost:
    
        if ((!r2) != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b0, code lost:
    
        if (r2.exists() != false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b2, code lost:
    
        flush();
     */
    @Override // com.alipay.iap.android.aplog.core.appender.Appender
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.io.File getFile() {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.aplog.core.appender.DiagnoseLogAppender.getFile():java.io.File");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.iap.android.aplog.core.appender.Appender
    public void flush() {
        synchronized (this) {
            if (this.eventDataBuffer.length() == 0) {
                return;
            }
            TraceLogger innerTraceLogger = LoggerFactory.getInnerTraceLogger();
            StringBuilder sb = new StringBuilder();
            sb.append(this.logCategory);
            sb.append(" appender flush: ");
            sb.append(this.eventDataBuffer.length());
            innerTraceLogger.verbose("Appender", sb.toString());
            appendBufferToFile();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.iap.android.aplog.core.appender.Appender
    public void onAppend(String str) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int length = this.eventDataBuffer.length();
            int length2 = str.length();
            int i = SEPARATOR_DATA_LEN;
            if (length + length2 + i > this.eventBufferLength) {
                appendBufferToFile();
                if (this.eventDataBuffer.length() + str.length() + i > this.eventBufferLength) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append("$$");
                    String obj = sb.toString();
                    try {
                        Object[] objArr = new Object[1];
                        a((ViewConfiguration.getEdgeSlop() >> 16) + 5, new char[]{53293, 42186, 58618, 36726, 63473, 63470}, objArr);
                        byte[] bytes = obj.getBytes(((String) objArr[0]).intern());
                        onAppend(bytes, 0, bytes.length);
                    } catch (Throwable th) {
                        if (!this.isBufferToBytesError) {
                            this.isBufferToBytesError = true;
                            LoggerFactory.getInnerTraceLogger().error("Appender", "appendLogEvent", th);
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.iap.android.aplog.core.appender.Appender
    public boolean writeFile(String str) {
        try {
            File file = getFile();
            if ((file != null ? 'U' : (char) 22) != 22) {
                FileUtil.writeFile(file, str, true);
                int i = PlaceComponentResult + 65;
                moveToNextValue = i % 128;
                int i2 = i % 2;
            }
            return true;
        } catch (Throwable th) {
            if (!this.isAppendStringError) {
                this.isAppendStringError = true;
                LoggerFactory.getInnerTraceLogger().error("Appender", this.logCategory, th);
            }
            int i3 = moveToNextValue + 73;
            PlaceComponentResult = i3 % 128;
            if (i3 % 2 != 0) {
                Object[] objArr = null;
                int length = objArr.length;
                return false;
            }
            return false;
        }
    }

    @Override // com.alipay.iap.android.aplog.core.appender.Appender
    protected boolean onAppend(byte[] bArr, int i, int i2) {
        byte[] bArr2;
        int i3 = PlaceComponentResult + 47;
        moveToNextValue = i3 % 128;
        int i4 = i3 % 2;
        Object obj = null;
        try {
            bArr2 = LoggingUtil.gzipDataByBytes(bArr, i, i2);
        } catch (Throwable th) {
            if (!this.isGzipBytesError) {
                this.isGzipBytesError = true;
                LoggerFactory.getInnerTraceLogger().error("Appender", this.logCategory, th);
            }
            bArr2 = null;
        }
        if (bArr2 == null) {
            return false;
        }
        byte[] encrypt = HybridEncryption.getInstance().encrypt(bArr2, 0, bArr2.length);
        byte[] secureSeed = HybridEncryption.getInstance().getSecureSeed();
        if (encrypt == null || secureSeed == null) {
            if (!this.isHybridEncryptError) {
                int i5 = PlaceComponentResult + 81;
                moveToNextValue = i5 % 128;
                if (i5 % 2 != 0) {
                }
                this.isHybridEncryptError = true;
                LoggerFactory.getInnerTraceLogger().error("Appender", "HybridEncryption.encrypt occured error");
            }
            return false;
        } else if (secureSeed.length > 32767) {
            try {
                TraceLogger innerTraceLogger = LoggerFactory.getInnerTraceLogger();
                StringBuilder sb = new StringBuilder();
                try {
                    sb.append("the length of secure seed is too long: ");
                    sb.append(secureSeed.length);
                    innerTraceLogger.error("Appender", sb.toString());
                    int i6 = moveToNextValue + 103;
                    PlaceComponentResult = i6 % 128;
                    if ((i6 % 2 == 0 ? '3' : (char) 23) != '3') {
                        obj.hashCode();
                        return false;
                    }
                    return false;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        } else {
            return FileUtil.writeEncryptedContent(encrypt, secureSeed, getFile());
        }
    }

    private File getCurrentLogsDir() {
        int i = moveToNextValue + 115;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        if ((this.mCurrentLogsDir == null ? 'Z' : '6') == 'Z') {
            int i3 = PlaceComponentResult + 125;
            moveToNextValue = i3 % 128;
            try {
                if ((i3 % 2 == 0 ? '`' : '6') != '6') {
                    this.mCurrentLogsDir = LoggingUtil.getStorageFilesDir(this.appContext, this.logCategory);
                    Object[] objArr = null;
                    int length = objArr.length;
                } else {
                    this.mCurrentLogsDir = LoggingUtil.getStorageFilesDir(this.appContext, this.logCategory);
                }
            } catch (Throwable th) {
                LoggerFactory.getInnerTraceLogger().error("Appender", "getCurrentLogsDir", th);
            }
        }
        try {
            File file = this.mCurrentLogsDir;
            if (file != null) {
                if ((!file.exists() ? '[' : 'Z') != 'Z') {
                    int i4 = PlaceComponentResult + 61;
                    moveToNextValue = i4 % 128;
                    int i5 = i4 % 2;
                    this.mCurrentLogsDir.mkdirs();
                    int i6 = moveToNextValue + 97;
                    PlaceComponentResult = i6 % 128;
                    int i7 = i6 % 2;
                }
            }
        } catch (Throwable th2) {
            LoggerFactory.getInnerTraceLogger().error("Appender", "getCurrentLogsDir", th2);
        }
        return this.mCurrentLogsDir;
    }

    private void cleanExpiresFile(File file, long j, long j2) {
        File[] fileArr;
        String str;
        File[] listFiles;
        if ((file != null ? (char) 3 : 'T') == 3 && file.isDirectory()) {
            int i = PlaceComponentResult + 103;
            moveToNextValue = i % 128;
            Object[] objArr = null;
            try {
                if (i % 2 == 0) {
                    listFiles = file.listFiles();
                    objArr.hashCode();
                } else {
                    listFiles = file.listFiles();
                }
                fileArr = listFiles;
            } catch (Throwable th) {
                LoggerFactory.getInnerTraceLogger().error("Appender", "cleanExpiresFile", th);
                fileArr = null;
            }
            if (fileArr == null || fileArr.length == 0) {
                return;
            }
            try {
                int i2 = moveToNextValue + 39;
                PlaceComponentResult = i2 % 128;
                if (i2 % 2 != 0) {
                }
                long currentTimeMillis = System.currentTimeMillis();
                int i3 = PlaceComponentResult + 63;
                moveToNextValue = i3 % 128;
                int i4 = i3 % 2;
                for (File file2 : fileArr) {
                    if (file2 != null) {
                        if ((file2.exists() ? 'A' : '#') != 'A') {
                            continue;
                        } else {
                            int i5 = PlaceComponentResult + 33;
                            moveToNextValue = i5 % 128;
                            if ((i5 % 2 == 0 ? '0' : '?') != '?') {
                                boolean isFile = file2.isFile();
                                int length = objArr.length;
                                if (!isFile) {
                                }
                            } else if (!(file2.isFile())) {
                            }
                            int i6 = PlaceComponentResult + 7;
                            moveToNextValue = i6 % 128;
                            if (i6 % 2 == 0) {
                                try {
                                    str = file2.getName().split("_")[0];
                                    if (!(!TextUtils.isDigitsOnly(str))) {
                                    }
                                } catch (Throwable th2) {
                                    LoggerFactory.getInnerTraceLogger().error("Appender", file2.getName(), th2);
                                }
                            } else {
                                str = file2.getName().split("_")[0];
                                if (!TextUtils.isDigitsOnly(str)) {
                                }
                            }
                            long parseLong = Long.parseLong(str);
                            if (parseLong < currentTimeMillis - j || parseLong > currentTimeMillis + j) {
                                file2.delete();
                                StringBuilder sb = new StringBuilder();
                                sb.append("cleanExpiresFile: ");
                                sb.append(file2.getName());
                                sb.append(" is too old !");
                                InstrumentInjector.log_e("Appender", sb.toString());
                            }
                        }
                    }
                }
                if (FileUtil.getFolderSize(file) < j2) {
                    return;
                }
                try {
                } catch (Throwable th3) {
                    th = th3;
                }
                try {
                    cleanExcessFiles(file.listFiles());
                } catch (Throwable th4) {
                    th = th4;
                    LoggerFactory.getInnerTraceLogger().warn("Appender", "cleanExpiresFile", th);
                }
            } catch (Exception e) {
                throw e;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0056, code lost:
    
        if ((r4.exists()) != true) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0060, code lost:
    
        if (r4.exists() != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0075, code lost:
    
        if (r4.isFile() != false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x007e, code lost:
    
        if (r4.isFile() != false) goto L57;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void cleanExcessFiles(java.io.File[] r9) {
        /*
            Method dump skipped, instructions count: 216
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.aplog.core.appender.DiagnoseLogAppender.cleanExcessFiles(java.io.File[]):void");
    }

    boolean appendBufferToFile() {
        int i = PlaceComponentResult + 41;
        moveToNextValue = i % 128;
        int i2 = i % 2;
        try {
            String obj = this.eventDataBuffer.toString();
            Object[] objArr = new Object[1];
            a(TextUtils.getTrimmedLength("") + 5, new char[]{53293, 42186, 58618, 36726, 63473, 63470}, objArr);
            byte[] bytes = obj.getBytes(((String) objArr[0]).intern());
            boolean onAppend = onAppend(bytes, 0, bytes.length);
            this.eventDataBuffer.setLength(0);
            int i3 = moveToNextValue + 95;
            PlaceComponentResult = i3 % 128;
            if ((i3 % 2 != 0 ? 'R' : 'c') != 'R') {
                return onAppend;
            }
            int i4 = 1 / 0;
            return onAppend;
        } catch (Throwable th) {
            try {
                if (!this.isBufferToBytesError) {
                    this.isBufferToBytesError = true;
                    LoggerFactory.getInnerTraceLogger().error("Appender", "appendLogEvent", th);
                }
                return false;
            } finally {
                this.eventDataBuffer.setLength(0);
            }
        }
    }

    private void appendDataToBuffer(String str) {
        try {
            int i = moveToNextValue + 121;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            StringBuilder sb = this.eventDataBuffer;
            sb.append(str);
            sb.append("$$");
            try {
                int i3 = PlaceComponentResult + 85;
                moveToNextValue = i3 % 128;
                if ((i3 % 2 == 0 ? '#' : 'G') != '#') {
                    return;
                }
                Object obj = null;
                obj.hashCode();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public void setExpiredTime(int i) {
        if (i > 0) {
            int i2 = PlaceComponentResult + 21;
            moveToNextValue = i2 % 128;
            if (i2 % 2 == 0) {
                this.expiredTime = TimeUnit.DAYS.toMillis(i);
                Object obj = null;
                obj.hashCode();
            } else {
                try {
                    this.expiredTime = TimeUnit.DAYS.toMillis(i);
                } catch (Exception e) {
                    throw e;
                }
            }
            int i3 = PlaceComponentResult + 121;
            try {
                moveToNextValue = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e2) {
                throw e2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:
    
        if ((r5 > 0 ? 'K' : 'R') != 'K') goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0021, code lost:
    
        r0 = com.alipay.iap.android.aplog.core.appender.DiagnoseLogAppender.PlaceComponentResult + 9;
        com.alipay.iap.android.aplog.core.appender.DiagnoseLogAppender.moveToNextValue = r0 % 128;
        r0 = r0 % 2;
        r4.expiredSize = (r5 * 1024) * 1024;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0010, code lost:
    
        if (r5 > 0) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setExpiredSize(int r5) {
        /*
            r4 = this;
            int r0 = com.alipay.iap.android.aplog.core.appender.DiagnoseLogAppender.moveToNextValue
            int r0 = r0 + 105
            int r1 = r0 % 128
            com.alipay.iap.android.aplog.core.appender.DiagnoseLogAppender.PlaceComponentResult = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 == 0) goto L15
            r0 = 52
            int r0 = r0 / r1
            if (r5 <= 0) goto L32
            goto L21
        L13:
            r5 = move-exception
            throw r5
        L15:
            r0 = 75
            if (r5 <= 0) goto L1c
            r2 = 75
            goto L1e
        L1c:
            r2 = 82
        L1e:
            if (r2 == r0) goto L21
            goto L32
        L21:
            int r0 = com.alipay.iap.android.aplog.core.appender.DiagnoseLogAppender.PlaceComponentResult
            int r0 = r0 + 9
            int r2 = r0 % 128
            com.alipay.iap.android.aplog.core.appender.DiagnoseLogAppender.moveToNextValue = r2
            int r0 = r0 % 2
            int r5 = r5 * 1024
            int r5 = r5 * 1024
            long r2 = (long) r5
            r4.expiredSize = r2
        L32:
            int r5 = com.alipay.iap.android.aplog.core.appender.DiagnoseLogAppender.PlaceComponentResult
            int r5 = r5 + 13
            int r0 = r5 % 128
            com.alipay.iap.android.aplog.core.appender.DiagnoseLogAppender.moveToNextValue = r0
            int r5 = r5 % 2
            r0 = 1
            if (r5 != 0) goto L40
            r1 = 1
        L40:
            if (r1 == r0) goto L43
            return
        L43:
            r5 = 0
            r5.hashCode()     // Catch: java.lang.Throwable -> L48
            return
        L48:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.aplog.core.appender.DiagnoseLogAppender.setExpiredSize(int):void");
    }

    public void setCleaningRate(double d) {
        try {
            int i = PlaceComponentResult + 93;
            moveToNextValue = i % 128;
            if (!(i % 2 != 0)) {
                if ((d > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? (char) 5 : Typography.greater) != 5) {
                    return;
                }
            } else {
                if ((d > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? (char) 16 : 'Q') == 'Q') {
                    return;
                }
            }
            this.cleaningRate = d;
            int i2 = PlaceComponentResult + 17;
            moveToNextValue = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        C c = new C();
        char[] cArr2 = new char[cArr.length];
        c.BuiltInFictitiousFunctionClassFactory = 0;
        char[] cArr3 = new char[2];
        int i2 = $10 + 101;
        $11 = i2 % 128;
        int i3 = i2 % 2;
        while (true) {
            if (c.BuiltInFictitiousFunctionClassFactory < cArr.length) {
                cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
                cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory + 1];
                int i4 = 58224;
                int i5 = $11 + 1;
                $10 = i5 % 128;
                int i6 = i5 % 2;
                int i7 = 0;
                while (i7 < 16) {
                    int i8 = $11 + 23;
                    $10 = i8 % 128;
                    int i9 = i8 % 2;
                    cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i4) ^ ((cArr3[0] << 4) + ((char) (getAuthRequestContext ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (MyBillsEntityDataFactory ^ 6353485791441662354L)))));
                    cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i4) ^ ((cArr3[1] << 4) + ((char) (BuiltInFictitiousFunctionClassFactory ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 6353485791441662354L)))));
                    i4 -= 40503;
                    i7++;
                    int i10 = $11 + 19;
                    $10 = i10 % 128;
                    int i11 = i10 % 2;
                }
                cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
                cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
                c.BuiltInFictitiousFunctionClassFactory += 2;
            } else {
                objArr[0] = new String(cArr2, 0, i);
                return;
            }
        }
    }
}
