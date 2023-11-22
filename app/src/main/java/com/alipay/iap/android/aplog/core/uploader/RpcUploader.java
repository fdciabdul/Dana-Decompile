package com.alipay.iap.android.aplog.core.uploader;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.iap.android.aplog.api.LogEncryptClient;
import com.alipay.iap.android.aplog.core.LoggerFactory;
import com.alipay.iap.android.aplog.core.appender.MdapFileLogAppender;
import com.alipay.iap.android.aplog.core.filter.StrategyManager;
import com.alipay.iap.android.aplog.core.logger.TraceLogger;
import com.alipay.iap.android.aplog.core.uploader.rpc.LogRpcResult;
import com.alipay.iap.android.aplog.core.uploader.rpc.RpcClient;
import com.alipay.iap.android.aplog.core.uploader.rpc.RpcLogData;
import com.alipay.iap.android.aplog.core.uploader.rpc.RpcLogRequestParam;
import com.alipay.iap.android.aplog.util.FileUtil;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public class RpcUploader extends BaseUploader {
    public static final String TAG = "RpcUploader";

    public RpcUploader(File file, Context context) {
        super(file, context);
    }

    public void upload(String str, String str2, Bundle bundle) {
        try {
            cleanExpiresFile();
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("cleanExpiresFile: ");
            sb.append(th);
            InstrumentInjector.log_w(TAG, sb.toString());
        }
        File[] listFiles = this.mUploadFileDir.listFiles();
        if (listFiles == null || listFiles.length == 0) {
            TraceLogger traceLogger = LoggerFactory.getTraceLogger();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(" do not need upload RpcUploader");
            traceLogger.info(TAG, sb2.toString());
            return;
        }
        TraceLogger traceLogger2 = LoggerFactory.getTraceLogger();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append(" will upload, count of all mdap files: ");
        sb3.append(listFiles.length);
        sb3.append(" isMerge = ");
        sb3.append(false);
        traceLogger2.info(TAG, sb3.toString());
        uploadByCategory(str, listFiles, bundle);
    }

    private void uploadByCategory(String str, File[] fileArr, Bundle bundle) {
        String str2;
        String string;
        int i = 0;
        for (File file : fileArr) {
            if (file != null && file.exists() && file.isFile()) {
                String name = file.getName();
                try {
                    str2 = StrategyManager.getInstance().isLogSend(name, str);
                    if (str2 != null) {
                        if (bundle != null) {
                            try {
                                if (!TextUtils.isEmpty(bundle.getString("event"))) {
                                    string = bundle.getString("event");
                                    uploadFile(file, str2, string, bundle);
                                    TraceLogger traceLogger = LoggerFactory.getTraceLogger();
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(str2);
                                    sb.append(" uploadByCategory upload success: ");
                                    sb.append(name);
                                    sb.append(" event = ");
                                    sb.append(string);
                                    traceLogger.info(TAG, sb.toString());
                                    i++;
                                }
                            } catch (Throwable th) {
                                th = th;
                                String obj = th.toString();
                                TraceLogger traceLogger2 = LoggerFactory.getTraceLogger();
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(str2);
                                sb2.append(" uploadByCategory failed: ");
                                sb2.append(name);
                                sb2.append(" at ");
                                sb2.append(obj);
                                traceLogger2.error(TAG, sb2.toString());
                            }
                        }
                        string = "default";
                        uploadFile(file, str2, string, bundle);
                        TraceLogger traceLogger3 = LoggerFactory.getTraceLogger();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(str2);
                        sb3.append(" uploadByCategory upload success: ");
                        sb3.append(name);
                        sb3.append(" event = ");
                        sb3.append(string);
                        traceLogger3.info(TAG, sb3.toString());
                        i++;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    str2 = str;
                }
            }
        }
        TraceLogger traceLogger4 = LoggerFactory.getTraceLogger();
        StringBuilder sb4 = new StringBuilder();
        sb4.append("uploadByCategory end, realUploadCount: ");
        sb4.append(i);
        traceLogger4.info(TAG, sb4.toString());
    }

    private void uploadFile(File file, String str, String str2, Bundle bundle) throws IllegalStateException {
        if (file == null) {
            throw new IllegalStateException("file object is NULL");
        }
        try {
            String readFile = FileUtil.readFile(file);
            if (TextUtils.isEmpty(readFile)) {
                file.delete();
                throw new IllegalStateException("file content is empty");
            }
            RpcClient logUploadRpcClient = LoggerFactory.getLogContext().getLogUploadRpcClient();
            if (logUploadRpcClient != null) {
                try {
                    ArrayList arrayList = new ArrayList();
                    RpcLogData rpcLogData = new RpcLogData();
                    rpcLogData.bizCode = str;
                    ArrayList arrayList2 = new ArrayList();
                    for (String str3 : readFile.split(LoggerFactory.LOG_SPLITER)) {
                        arrayList2.add(decryptItem(str3));
                    }
                    rpcLogData.log = arrayList2;
                    arrayList.add(rpcLogData);
                    RpcLogRequestParam rpcLogRequestParam = new RpcLogRequestParam();
                    rpcLogRequestParam.logs = arrayList;
                    LogRpcResult uploadLog = logUploadRpcClient.uploadLog(rpcLogRequestParam, str2, bundle);
                    if (uploadLog == null) {
                        LoggerFactory.getTraceLogger().info(TAG, "rpc upload fail result is null");
                        doDegradeUploadByLogCategory(bundle, str);
                        return;
                    } else if (uploadLog.respCode == 1000) {
                        TraceLogger traceLogger = LoggerFactory.getTraceLogger();
                        StringBuilder sb = new StringBuilder();
                        sb.append("rpc upload success category = ");
                        sb.append(str);
                        traceLogger.info(TAG, sb.toString());
                        try {
                            file.delete();
                            return;
                        } catch (Throwable th) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("delete file error: ");
                            sb2.append(th);
                            throw new IllegalStateException(sb2.toString(), th);
                        }
                    } else {
                        TraceLogger traceLogger2 = LoggerFactory.getTraceLogger();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("rpc upload fail respCode = ");
                        sb3.append(uploadLog.respCode);
                        sb3.append(" resp des = ");
                        sb3.append(uploadLog.errorMsg);
                        traceLogger2.info(TAG, sb3.toString());
                        doDegradeUploadByLogCategory(bundle, str);
                        return;
                    }
                } catch (Throwable th2) {
                    LoggerFactory.getTraceLogger().error(TAG, "rpc upload error,do upload by http", th2);
                    doDegradeUploadByLogCategory(bundle, str);
                    return;
                }
            }
            doDegradeUploadByLogCategory(bundle, str);
        } catch (Throwable th3) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("read file error: ");
            sb4.append(th3);
            throw new IllegalStateException(sb4.toString(), th3);
        }
    }

    private String decryptItem(String str) {
        LogEncryptClient logEncryptClient;
        if (!TextUtils.isEmpty(str) && (logEncryptClient = LoggerFactory.getLogContext().getLogEncryptClient()) != null && str.startsWith(MdapFileLogAppender.ENCRYPT_SIGN)) {
            String decrypt = logEncryptClient.decrypt(str.substring(2));
            if (!TextUtils.isEmpty(decrypt)) {
                return decrypt;
            }
        }
        return str;
    }

    private void doDegradeUploadByLogCategory(Bundle bundle, String str) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        TraceLogger traceLogger = LoggerFactory.getTraceLogger();
        StringBuilder sb = new StringBuilder();
        sb.append("doDegradeUploadByLogCategory logCategory = ");
        sb.append(str);
        traceLogger.info(TAG, sb.toString());
        LoggerFactory.getLogContext().getUploader();
        new HttpUploader(this.mUploadFileDir, this.mContext).upload(str, null, bundle);
    }
}
