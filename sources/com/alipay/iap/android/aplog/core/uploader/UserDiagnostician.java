package com.alipay.iap.android.aplog.core.uploader;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.iap.android.aplog.core.LoggerFactory;
import com.alipay.iap.android.aplog.core.logger.TraceLogger;
import com.alipay.iap.android.aplog.monitor.analysis.diagnose.UploadTaskStatusCallback;
import com.alipay.iap.android.aplog.rpc.TaskInstanceRpcFacade;
import com.alipay.iap.android.aplog.rpc.TaskReportRpcRequest;
import com.alipay.iap.android.aplog.util.APMTimer;
import com.alipay.iap.android.aplog.util.CommonUtils;
import com.alipay.iap.android.aplog.util.NetUtil;
import com.alipay.iap.android.common.rpcintegration.RPCProxyHost;
import com.google.common.base.Ascii;
import java.util.List;

/* loaded from: classes.dex */
public class UserDiagnostician {
    private static UserDiagnostician INSTANCE = null;
    private static final String MAX_FILE_SIZE_KEY = "maxFileSize";
    private static final long MAX_UPLOAD_SIZE = 10485760;
    private static final String TAG = "UserDiagnostician";
    private String appId;
    private Context mContext;
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {1, -107, Ascii.ESC, -41, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int PlaceComponentResult = 141;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 3
            int r7 = 16 - r7
            int r6 = r6 * 7
            int r6 = 106 - r6
            int r8 = r8 * 12
            int r8 = 16 - r8
            byte[] r0 = com.alipay.iap.android.aplog.core.uploader.UserDiagnostician.BuiltInFictitiousFunctionClassFactory
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L34
        L1b:
            r3 = 0
        L1c:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            r3 = r0[r8]
            r5 = r8
            r8 = r6
            r6 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L34:
            int r8 = r8 + r6
            int r6 = r8 + 2
            int r8 = r9 + 1
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.aplog.core.uploader.UserDiagnostician.a(short, byte, byte, java.lang.Object[]):void");
    }

    /* loaded from: classes3.dex */
    public static final class DiagnoseTask {
        String fileName;
        long fromTime;
        boolean isForceUpload;
        boolean isPositive;
        long maxFileSize;
        String networkCondition;
        String retrieveFilePath;
        String submitId;
        String taskID;
        String taskType;
        long toTime;
        String userID;
        long zippedLenLimit;

        public final String toString() {
            return CommonUtils.concatArray(",", this.userID, this.taskID, this.submitId, this.taskType, this.fileName, this.networkCondition, Boolean.valueOf(this.isForceUpload), Long.valueOf(this.fromTime), Long.valueOf(this.toTime), Long.valueOf(this.maxFileSize), this.retrieveFilePath, Boolean.valueOf(this.isPositive), Long.valueOf(this.zippedLenLimit));
        }
    }

    private UserDiagnostician(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static UserDiagnostician createInstance(Context context) {
        UserDiagnostician userDiagnostician;
        synchronized (UserDiagnostician.class) {
            if (INSTANCE == null) {
                UserDiagnostician userDiagnostician2 = new UserDiagnostician(context);
                INSTANCE = userDiagnostician2;
                userDiagnostician2.appId = UploadConstants.getAppId();
            }
            userDiagnostician = INSTANCE;
        }
        return userDiagnostician;
    }

    public static UserDiagnostician createInstance(Context context, String str) {
        UserDiagnostician userDiagnostician;
        synchronized (UserDiagnostician.class) {
            if (INSTANCE == null) {
                UserDiagnostician userDiagnostician2 = new UserDiagnostician(context);
                INSTANCE = userDiagnostician2;
                userDiagnostician2.appId = str;
            }
            userDiagnostician = INSTANCE;
        }
        return userDiagnostician;
    }

    public static UserDiagnostician getInstance() {
        UserDiagnostician userDiagnostician = INSTANCE;
        if (userDiagnostician != null) {
            return userDiagnostician;
        }
        throw new IllegalStateException("need createInstance befor use");
    }

    public void processPushMsgInWorkThread(final String str) {
        APMTimer.getInstance().post(new Runnable() { // from class: com.alipay.iap.android.aplog.core.uploader.UserDiagnostician.1
            @Override // java.lang.Runnable
            public void run() {
                LoggerFactory.getLogContext().flush(true);
                UserDiagnostician.this.processPushMsg(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void processPushMsg(java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.aplog.core.uploader.UserDiagnostician.processPushMsg(java.lang.String):void");
    }

    private boolean isForceUpload(String str) {
        return TextUtils.isEmpty(str) || UploadTaskStatusCallback.NETWORK_MOBILE.equalsIgnoreCase(str) || "any".equalsIgnoreCase(str);
    }

    private void startDiagnose(List<DiagnoseTask> list) {
        int size = list.size();
        if (size == 0) {
            return;
        }
        for (DiagnoseTask diagnoseTask : list) {
            try {
                UploadTaskStatusCallback.UploadStatus uploadStatus = UploadTaskStatusCallback.UploadStatus.CLIENT_SUBMIT_RECEIVED;
                StringBuilder sb = new StringBuilder();
                sb.append("tasks count: ");
                sb.append(size);
                asyncAckResult(diagnoseTask, uploadStatus, sb.toString());
                if ("applog".equalsIgnoreCase(diagnoseTask.taskType)) {
                    uploadLog(diagnoseTask, new UploadTaskStatusCallback() { // from class: com.alipay.iap.android.aplog.core.uploader.UserDiagnostician.2
                        @Override // com.alipay.iap.android.aplog.monitor.analysis.diagnose.UploadTaskStatusCallback
                        public void onSuccess(String str) {
                            TraceLogger innerTraceLogger = LoggerFactory.getInnerTraceLogger();
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("upload success,");
                            sb2.append(str);
                            innerTraceLogger.info(UserDiagnostician.TAG, sb2.toString());
                        }

                        @Override // com.alipay.iap.android.aplog.monitor.analysis.diagnose.UploadTaskStatusCallback
                        public void onFail(UploadTaskStatusCallback.Code code, String str) {
                            TraceLogger innerTraceLogger = LoggerFactory.getInnerTraceLogger();
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("upload fail,");
                            sb2.append(str);
                            innerTraceLogger.info(UserDiagnostician.TAG, sb2.toString());
                        }
                    });
                }
            } catch (Throwable th) {
                LoggerFactory.getTraceLogger().error(TAG, "startDiagnose", th);
                UploadTaskStatusCallback.UploadStatus uploadStatus2 = UploadTaskStatusCallback.UploadStatus.CLIENT_SUBMIT_UPLOAD_FAIL;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("[UserDiagnostician.startDiagnose] ");
                sb2.append(th);
                asyncAckResult(diagnoseTask, uploadStatus2, sb2.toString());
            }
        }
        list.clear();
    }

    void asyncAckResult(final DiagnoseTask diagnoseTask, final UploadTaskStatusCallback.UploadStatus uploadStatus, final String str) {
        try {
            byte b = (byte) (BuiltInFictitiousFunctionClassFactory[0] - 1);
            byte b2 = b;
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = BuiltInFictitiousFunctionClassFactory[0];
            byte b4 = b3;
            Object[] objArr2 = new Object[1];
            a(b3, b4, b4, objArr2);
            if (((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getName().equals("APMTimer")) {
                ackResult(diagnoseTask, uploadStatus, str);
            } else {
                APMTimer.getInstance().post(new Runnable() { // from class: com.alipay.iap.android.aplog.core.uploader.UserDiagnostician.3
                    @Override // java.lang.Runnable
                    public void run() {
                        UserDiagnostician.this.ackResult(diagnoseTask, uploadStatus, str);
                    }
                });
            }
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    void ackResult(DiagnoseTask diagnoseTask, UploadTaskStatusCallback.UploadStatus uploadStatus, String str) {
        if (diagnoseTask == null) {
            TraceLogger traceLogger = LoggerFactory.getTraceLogger();
            StringBuilder sb = new StringBuilder();
            sb.append("ackResult: ");
            sb.append("diagnoseTask is null");
            traceLogger.error(TAG, sb.toString());
            return;
        }
        String name = uploadStatus.name();
        String networkType = NetUtil.getNetworkType();
        String productVersion = LoggerFactory.getLogContext().getProductVersion();
        String processAlias = LoggerFactory.getProcessInfo().getProcessAlias();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("type: ");
        sb2.append(diagnoseTask.taskType);
        sb2.append(", process: ");
        sb2.append(processAlias);
        sb2.append(", network: ");
        sb2.append(networkType);
        sb2.append(", product: ");
        sb2.append(productVersion);
        sb2.append(", status: ");
        sb2.append(name);
        sb2.append(" # ");
        sb2.append(str);
        String obj = sb2.toString();
        sb2.setLength(0);
        sb2.append("diagnoseStatus: ");
        sb2.append(name);
        sb2.append(", diagnoseMsg: ");
        sb2.append(obj);
        sb2.append(", diagnoseTask: ");
        sb2.append(diagnoseTask);
        String obj2 = sb2.toString();
        TraceLogger traceLogger2 = LoggerFactory.getTraceLogger();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("ackResult: ");
        sb3.append(obj2);
        traceLogger2.info(TAG, sb3.toString());
        try {
            TaskInstanceRpcFacade taskInstanceRpcFacade = (TaskInstanceRpcFacade) RPCProxyHost.getInterfaceProxy(TaskInstanceRpcFacade.class);
            if (taskInstanceRpcFacade != null) {
                TaskReportRpcRequest taskReportRpcRequest = new TaskReportRpcRequest();
                taskReportRpcRequest.taskId = diagnoseTask.taskID;
                taskReportRpcRequest.submitId = diagnoseTask.submitId;
                taskReportRpcRequest.submitStatus = uploadStatus.name();
                taskReportRpcRequest.submitStatusMsg = obj2;
                taskReportRpcRequest.appId = this.appId;
                if (taskInstanceRpcFacade.report(taskReportRpcRequest).success) {
                    LoggerFactory.getInnerTraceLogger().info(TAG, "report success");
                }
            }
        } catch (Exception e) {
            LoggerFactory.getTraceLogger().error(TAG, e);
        }
    }

    private void uploadLog(final DiagnoseTask diagnoseTask, final UploadTaskStatusCallback uploadTaskStatusCallback) {
        UploadTaskStatusCallback uploadTaskStatusCallback2 = new UploadTaskStatusCallback() { // from class: com.alipay.iap.android.aplog.core.uploader.UserDiagnostician.4
            @Override // com.alipay.iap.android.aplog.monitor.analysis.diagnose.UploadTaskStatusCallback
            public void onSuccess(String str) {
                UserDiagnostician.this.asyncAckResult(diagnoseTask, UploadTaskStatusCallback.UploadStatus.CLIENT_SUBMIT_UPLOAD_SUCCESS, str);
                UploadTaskStatusCallback uploadTaskStatusCallback3 = uploadTaskStatusCallback;
                if (uploadTaskStatusCallback3 != null) {
                    try {
                        uploadTaskStatusCallback3.onSuccess(str);
                    } catch (Throwable th) {
                        LoggerFactory.getTraceLogger().error(UserDiagnostician.TAG, th);
                    }
                }
            }

            @Override // com.alipay.iap.android.aplog.monitor.analysis.diagnose.UploadTaskStatusCallback
            public void onFail(UploadTaskStatusCallback.Code code, String str) {
                UserDiagnostician.this.asyncAckResult(diagnoseTask, UploadTaskStatusCallback.UploadStatus.CLIENT_SUBMIT_UPLOAD_FAIL, str);
                UploadTaskStatusCallback uploadTaskStatusCallback3 = uploadTaskStatusCallback;
                if (uploadTaskStatusCallback3 != null) {
                    try {
                        uploadTaskStatusCallback3.onFail(code, str);
                    } catch (Throwable th) {
                        LoggerFactory.getTraceLogger().error(UserDiagnostician.TAG, th);
                    }
                }
            }
        };
        IAPLogUploader iAPLogUploader = new IAPLogUploader(this.mContext, diagnoseTask);
        iAPLogUploader.setUploadTaskStatus(uploadTaskStatusCallback2);
        iAPLogUploader.uploadLog();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getAppId() {
        return this.appId;
    }
}
