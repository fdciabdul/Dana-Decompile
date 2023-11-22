package com.alipay.iap.android.aplog.core.uploader;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import com.alipay.iap.android.aplog.core.LoggerFactory;
import com.alipay.iap.android.aplog.core.filter.ConfigChangeBroadCastReceiver;
import com.alipay.iap.android.aplog.core.logger.TraceLogger;
import java.io.File;
import java.util.Comparator;

/* loaded from: classes3.dex */
public class UploadManager {
    private static UploadManager INSTANCE = null;
    public static final String LOG_FILE_PATH = "/mdap/";
    public static final int MIN_CLEAN_FILE_SCOPE = 4;
    public static final String STATISTICS_URL_PATH = "/loggw/logUpload.do";
    public static final String TAG = "UploadManager";
    public static final String UPLOAD_FILE_PATH = "/mdap/upload/";
    private Context context;
    private ConfigChangeBroadCastReceiver mConfigChangeBroadCastReceiver;
    private File uploadFileDir;
    public static final Comparator<File> CLEAN_FILE_COMPARATOR = new Comparator<File>() { // from class: com.alipay.iap.android.aplog.core.uploader.UploadManager.1
        @Override // java.util.Comparator
        public final int compare(File file, File file2) {
            return file.getName().compareTo(file2.getName());
        }
    };
    public static int MAX_UPLOAD_FILE_SIZE = 10485760;

    private UploadManager(Context context) {
        this.context = context;
        StringBuilder sb = new StringBuilder();
        sb.append(context.getFilesDir().getAbsolutePath());
        sb.append(UPLOAD_FILE_PATH);
        File file = new File(sb.toString());
        this.uploadFileDir = file;
        if (!file.exists()) {
            this.uploadFileDir.mkdirs();
        }
        registerConfigChangeBroadCastReceiver();
    }

    public static UploadManager createInstancecreateInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new UploadManager(context);
        }
        return INSTANCE;
    }

    public static UploadManager getIntance() {
        return INSTANCE;
    }

    public void setMaxUploadFileSize(int i) {
        MAX_UPLOAD_FILE_SIZE = i;
    }

    private void registerConfigChangeBroadCastReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.alipay.mobile.client.multi.CONFIG_CHANGE");
        this.mConfigChangeBroadCastReceiver = new ConfigChangeBroadCastReceiver();
        if (this.context != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                this.context.registerReceiver(this.mConfigChangeBroadCastReceiver, intentFilter, 2);
            } else {
                this.context.registerReceiver(this.mConfigChangeBroadCastReceiver, intentFilter);
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:39|40|(3:41|42|(1:44))|46|47|48|(1:52)) */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0075, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0076, code lost:
    
        r1 = com.alipay.iap.android.aplog.core.LoggerFactory.getTraceLogger();
        r5 = new java.lang.StringBuilder();
        r5.append("syncLog logFileDir: ");
        r5.append(r0);
        r1.error(com.alipay.iap.android.aplog.core.uploader.UploadManager.TAG, r5.toString());
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0091 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0092 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void syncLog() {
        /*
            Method dump skipped, instructions count: 296
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.aplog.core.uploader.UploadManager.syncLog():void");
    }

    public void uploadLog(String str, String str2, Bundle bundle) {
        synchronized (this) {
            if (LoggerFactory.getLogContext().getUploader() != null) {
                LoggerFactory.getLogContext().getUploader().upload(str, str2, bundle);
            } else {
                TraceLogger traceLogger = LoggerFactory.getTraceLogger();
                StringBuilder sb = new StringBuilder();
                sb.append("http upload logCategory = ");
                sb.append(str);
                sb.append(" uploadFileDir: ");
                sb.append(this.uploadFileDir);
                traceLogger.debug(TAG, sb.toString());
                new HttpUploader(this.uploadFileDir, this.context).upload(str, str2, bundle);
            }
        }
    }
}
