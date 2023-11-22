package com.alipay.iap.android.aplog.core.appender;

import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.iap.android.aplog.api.LogContext;
import com.alipay.iap.android.aplog.api.LogEventType;
import com.alipay.iap.android.aplog.core.LoggerFactory;
import com.alipay.iap.android.aplog.core.filter.StrategyManager;
import com.alipay.iap.android.aplog.core.logger.TraceLogger;
import com.alipay.iap.android.aplog.core.os.LogLifecycleCallback;
import com.alipay.iap.android.aplog.util.FileUtil;
import com.alipay.iap.android.aplog.util.LoggingUtil;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.File;

/* loaded from: classes3.dex */
public class MdapFileLogAppender extends AnalyticsLogAppender {
    public static final String ENCRYPT_SIGN = "1_";
    protected static final int MAX_APPEND_BUFFER_COUNT = 3;
    protected static final String MDAP_FILE_DIR = "mdap";
    public static final String TAG = "MdapFileAppender";
    protected static final String UPLOAD_FILE_DIR = "upload";
    protected static final String UPLOAD_FILE_PATH;
    protected StringBuffer appendBuffer;
    protected int appendCount;
    protected int bufferCount;
    protected File currentMdapFile;
    protected boolean isFirstAppend;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(MDAP_FILE_DIR);
        sb.append(File.separatorChar);
        sb.append(UPLOAD_FILE_DIR);
        UPLOAD_FILE_PATH = sb.toString();
    }

    public MdapFileLogAppender(LogContext logContext, String str) {
        super(logContext, str);
        this.isFirstAppend = true;
        this.appendBuffer = new StringBuffer();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.iap.android.aplog.core.appender.Appender
    public File getFile() {
        if (this.currentMdapFile == null && LoggingUtil.isDebuggable()) {
            File file = null;
            try {
                file = this.appContext.getExternalFilesDir(MDAP_FILE_DIR);
            } catch (Throwable th) {
                InstrumentInjector.log_e(TAG, "getFile", th);
            }
            if (file != null) {
                try {
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.processTag);
                    sb.append("_");
                    sb.append(this.logCategory);
                    this.currentMdapFile = new File(file, sb.toString());
                } catch (Throwable th2) {
                    InstrumentInjector.log_e(TAG, "getFile", th2);
                }
            }
        }
        TraceLogger innerTraceLogger = LoggerFactory.getInnerTraceLogger();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("currentMdapFile debug: ");
        sb2.append(this.currentMdapFile);
        innerTraceLogger.debug(TAG, sb2.toString());
        if (this.currentMdapFile == null) {
            File file2 = new File(this.appContext.getFilesDir(), MDAP_FILE_DIR);
            try {
                if (!file2.exists()) {
                    file2.mkdirs();
                }
            } catch (Throwable th3) {
                InstrumentInjector.log_e(TAG, "getFile", th3);
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this.processTag);
            sb3.append("_");
            sb3.append(this.logCategory);
            this.currentMdapFile = new File(file2, sb3.toString());
        }
        TraceLogger innerTraceLogger2 = LoggerFactory.getInnerTraceLogger();
        StringBuilder sb4 = new StringBuilder();
        sb4.append("currentMdapFile ");
        sb4.append(this.currentMdapFile);
        innerTraceLogger2.debug(TAG, sb4.toString());
        return this.currentMdapFile;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.iap.android.aplog.core.appender.Appender
    public void flush() {
        synchronized (this) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(LogContext.NEED_MOVE, true);
            flush(bundle);
        }
    }

    protected void flush(Bundle bundle) {
        synchronized (this) {
            if (this.bufferCount > 0) {
                TraceLogger innerTraceLogger = LoggerFactory.getInnerTraceLogger();
                StringBuilder sb = new StringBuilder();
                sb.append(this.logCategory);
                sb.append(" appender flush: ");
                sb.append(this.bufferCount);
                innerTraceLogger.info(TAG, sb.toString());
            }
            if (this.appendBuffer.length() == 0) {
                moveFileByBundle(bundle);
                return;
            }
            onAppend(this.appendBuffer.toString(), StrategyManager.getInstance().needEncrypt(this.logCategory));
            this.appendBuffer.setLength(0);
            this.appendCount += this.bufferCount;
            this.bufferCount = 0;
            moveFileByBundle(bundle);
        }
    }

    private void moveFileByBundle(Bundle bundle) {
        File file;
        if (bundle == null || !bundle.getBoolean(LogContext.NEED_MOVE, false)) {
            return;
        }
        try {
            file = getFile();
        } catch (Throwable unused) {
        }
        if (file.exists()) {
            FileUtil.moveFile(file, getUploadFile());
            TraceLogger innerTraceLogger = LoggerFactory.getInnerTraceLogger();
            StringBuilder sb = new StringBuilder();
            sb.append(this.logCategory);
            sb.append(" appender flush move ");
            sb.append(this.appendCount);
            innerTraceLogger.info(TAG, sb.toString());
            this.appendCount = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.iap.android.aplog.core.appender.Appender
    public void onAppend(String str) {
        synchronized (this) {
            TraceLogger innerTraceLogger = LoggerFactory.getInnerTraceLogger();
            StringBuilder sb = new StringBuilder();
            sb.append("write log: ");
            sb.append(str);
            innerTraceLogger.debug(TAG, sb.toString());
            if (this.isFirstAppend) {
                LoggerFactory.getInnerTraceLogger().debug(TAG, " isFirstAppend ");
                this.isFirstAppend = false;
                try {
                    String readFile = FileUtil.readFile(getFile());
                    if (!TextUtils.isEmpty(readFile)) {
                        this.appendCount = readFile.split(LoggerFactory.LOG_SPLITER).length;
                    }
                } catch (Throwable th) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(this.logCategory);
                    sb2.append(" first append: [just check, not a real error] ");
                    sb2.append(th);
                    InstrumentInjector.log_e(TAG, sb2.toString());
                }
            }
            this.appendBuffer.append(str);
            this.bufferCount++;
            if (!LoggerFactory.getProcessInfo().isMainProcess() || LogLifecycleCallback.isBackground || this.bufferCount >= 3 || LoggingUtil.isDebuggable() || LoggerFactory.getLogContext().getFilter().shouldUpload(this.logCategory, this.bufferCount)) {
                boolean needEncrypt = StrategyManager.getInstance().needEncrypt(this.logCategory);
                TraceLogger innerTraceLogger2 = LoggerFactory.getInnerTraceLogger();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("isEncrypt ");
                sb3.append(needEncrypt);
                innerTraceLogger2.debug(TAG, sb3.toString());
                onAppend(this.appendBuffer.toString(), needEncrypt);
                this.appendCount += this.bufferCount;
                this.appendBuffer.setLength(0);
                this.bufferCount = 0;
            }
            if (LoggerFactory.getLogContext().getFilter().shouldUpload(this.logCategory, this.appendCount)) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("upload: ");
                sb4.append(this.logCategory);
                InstrumentInjector.log_w(TAG, sb4.toString());
                Bundle bundle = new Bundle();
                bundle.putString("event", LogEventType.CATEGOTY_MAX_LOG_COUNT);
                upload(null, bundle);
                this.appendCount = 0;
            }
        }
    }

    protected void upload() {
        upload(null);
    }

    protected void upload(String str) {
        upload(str, null);
    }

    protected void upload(String str, Bundle bundle) {
        try {
            if (this.appendCount == 0) {
                return;
            }
            try {
                TraceLogger innerTraceLogger = LoggerFactory.getInnerTraceLogger();
                StringBuilder sb = new StringBuilder();
                sb.append("move file form: ");
                sb.append(getFile());
                sb.append(" to: ");
                sb.append(getUploadFile());
                innerTraceLogger.debug(TAG, sb.toString());
                FileUtil.moveFile(getFile(), getUploadFile());
            } catch (Throwable th) {
                LoggerFactory.getInnerTraceLogger().error(TAG, th.getMessage());
            }
            this.appendCount = 0;
            this.logContext.upload(this.logCategory, str, bundle);
        } catch (Throwable th2) {
            LoggerFactory.getInnerTraceLogger().error(TAG, this.logCategory, th2);
        }
    }

    protected File getUploadFile() {
        File file = new File(this.appContext.getFilesDir(), UPLOAD_FILE_PATH);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, LoggingUtil.getMdapStyleName(getFile().getName()));
        TraceLogger innerTraceLogger = LoggerFactory.getInnerTraceLogger();
        StringBuilder sb = new StringBuilder();
        sb.append("file to upload: ");
        sb.append(file2.getAbsolutePath());
        innerTraceLogger.debug(TAG, sb.toString());
        return file2;
    }
}
