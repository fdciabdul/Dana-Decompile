package com.alipay.iap.android.aplog.core.appender;

import com.alipay.iap.android.aplog.api.LogContext;
import com.alipay.iap.android.aplog.core.LoggerFactory;
import com.alipay.iap.android.aplog.core.logger.TraceLogger;
import com.alipay.iap.android.aplog.util.FileUtil;
import com.alipay.iap.android.aplog.util.LoggingUtil;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/* loaded from: classes3.dex */
public abstract class AnalyticsLogAppender extends EncryptAppender {
    private static final String TAG = "com.alipay.iap.android.aplog.core.appender.AnalyticsLogAppender";

    public AnalyticsLogAppender(LogContext logContext, String str) {
        super(logContext, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.iap.android.aplog.core.appender.Appender
    public boolean writeFile(String str) {
        try {
            File file = getFile();
            TraceLogger innerTraceLogger = LoggerFactory.getInnerTraceLogger();
            String str2 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("the saveFile is: ");
            sb.append(file.getAbsolutePath());
            innerTraceLogger.debug(str2, sb.toString());
            if (file != null) {
                FileUtil.writeFile(file, str, true);
            }
            return true;
        } catch (Throwable th) {
            if (this.isAppendStringError) {
                return false;
            }
            this.isAppendStringError = true;
            InstrumentInjector.log_e(TAG, this.logCategory, th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.iap.android.aplog.core.appender.Appender
    public boolean onAppend(byte[] bArr, int i, int i2) {
        byte[] bArr2;
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream;
        DataOutputStream dataOutputStream;
        synchronized (this) {
            DataOutputStream dataOutputStream2 = null;
            try {
                bArr2 = LoggingUtil.gzipDataByBytes(bArr, i, i2);
            } catch (Throwable th) {
                if (!this.isGzipBytesError) {
                    this.isGzipBytesError = true;
                    InstrumentInjector.log_e(TAG, this.logCategory, th);
                }
                bArr2 = null;
            }
            if (bArr2 == null) {
                return false;
            }
            File file = getFile();
            try {
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                fileOutputStream = new FileOutputStream(file, true);
                try {
                    bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                    try {
                        dataOutputStream = new DataOutputStream(bufferedOutputStream);
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedOutputStream = null;
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedOutputStream = null;
                fileOutputStream = null;
            }
            try {
                dataOutputStream.write(bArr2);
                dataOutputStream.flush();
                FileUtil.safeClose(dataOutputStream);
                FileUtil.safeClose(bufferedOutputStream);
                FileUtil.safeClose(fileOutputStream);
                return true;
            } catch (Throwable th5) {
                th = th5;
                dataOutputStream2 = dataOutputStream;
                try {
                    if (!this.isAppendBytesError) {
                        this.isAppendBytesError = true;
                        InstrumentInjector.log_e(TAG, this.logCategory, th);
                    }
                    return false;
                } finally {
                    FileUtil.safeClose(dataOutputStream2);
                    FileUtil.safeClose(bufferedOutputStream);
                    FileUtil.safeClose(fileOutputStream);
                }
            }
        }
    }
}
