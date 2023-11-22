package com.alipay.iap.android.aplog.core.uploader;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.alipay.iap.android.aplog.core.LoggerFactory;
import com.alipay.iap.android.aplog.core.logger.TraceLogger;
import com.alipay.iap.android.aplog.core.uploader.UserDiagnostician;
import com.alipay.iap.android.aplog.monitor.analysis.diagnose.UploadTaskStatusCallback;
import com.alipay.iap.android.aplog.util.APMTimer;
import com.alipay.iap.android.aplog.util.FileUtil;
import com.alipay.iap.android.aplog.util.LoggingUtil;
import com.alipay.iap.android.aplog.util.NetUtil;
import com.alipay.iap.android.aplog.util.ZipUtil;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.text.Typography;
import o.getOnBoardingScenario;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class IAPLogUploader {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static final String COMPRESS_TYPE_7Z = "7z";
    private static final String COMPRESS_TYPE_KEY = "CompressType";
    private static final String COMPRESS_TYPE_ZIP = "zip";
    private static long MyBillsEntityDataFactory = 0;
    private static int PlaceComponentResult = 1;
    private static final long SEVEN_ZIP_LENGTH = 3145728;
    private static final String SUFFIX_NORMAL_ZIP = ".zip";
    private static final String SUFFIX_SEVEN_ZIP = ".7z";
    private static final String TAG = "IAPLogUploader";
    private Context mContext;
    private SimpleDateFormat mDateHourFormat = new SimpleDateFormat("yyyyMMddHH", Locale.getDefault());
    private UserDiagnostician.DiagnoseTask mDiagnoseTask;
    private long mFileMaxTime;
    private long mFileMinTime;
    private long mFileTotalLength;
    private UploadTaskStatusCallback mTaskCallBack;
    private Set<String> mUploadFileNames;
    private ArrayList<File> mUploadFiles;

    static {
        PlaceComponentResult();
        int i = BuiltInFictitiousFunctionClassFactory + 33;
        PlaceComponentResult = i % 128;
        if ((i % 2 == 0 ? 'H' : Typography.greater) != 'H') {
            return;
        }
        int i2 = 41 / 0;
    }

    static void PlaceComponentResult() {
        MyBillsEntityDataFactory = 3663645998008845537L;
    }

    static /* synthetic */ SimpleDateFormat access$000(IAPLogUploader iAPLogUploader) {
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 25;
            try {
                PlaceComponentResult = i % 128;
                char c = i % 2 == 0 ? (char) 31 : (char) 24;
                SimpleDateFormat simpleDateFormat = iAPLogUploader.mDateHourFormat;
                if (c == 31) {
                    Object obj = null;
                    obj.hashCode();
                }
                return simpleDateFormat;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    static /* synthetic */ String access$100() {
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 79;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            String str = TAG;
            int i3 = BuiltInFictitiousFunctionClassFactory + 15;
            PlaceComponentResult = i3 % 128;
            if (i3 % 2 != 0) {
                return str;
            }
            int i4 = 95 / 0;
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    public IAPLogUploader(Context context, UserDiagnostician.DiagnoseTask diagnoseTask) {
        this.mContext = context;
        this.mDiagnoseTask = diagnoseTask;
    }

    public void setUploadTaskStatus(UploadTaskStatusCallback uploadTaskStatusCallback) {
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 49;
            PlaceComponentResult = i % 128;
            boolean z = i % 2 == 0;
            this.mTaskCallBack = uploadTaskStatusCallback;
            if (z) {
                Object[] objArr = null;
                int length = objArr.length;
            }
            int i2 = BuiltInFictitiousFunctionClassFactory + 87;
            PlaceComponentResult = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public void uploadLog() {
        synchronized (this) {
            this.mUploadFiles = new ArrayList<>();
            this.mUploadFileNames = new HashSet();
            this.mFileMinTime = LongCompanionObject.MAX_VALUE;
            this.mFileMaxTime = Long.MIN_VALUE;
            this.mFileTotalLength = 0L;
            final StringBuilder sb = new StringBuilder("[AlipayLogUpload.uploadLog] ");
            fillUploadFileListByReleaseType();
            if (this.mUploadFiles.isEmpty()) {
                TraceLogger traceLogger = LoggerFactory.getTraceLogger();
                String str = TAG;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.mDiagnoseTask.taskType);
                sb2.append(" [no files to upload] ");
                sb2.append(this.mDiagnoseTask.isPositive);
                traceLogger.warn(str, sb2.toString());
                if (this.mTaskCallBack != null && !this.mDiagnoseTask.isPositive) {
                    String format = this.mDateHourFormat.format(new Date(this.mDiagnoseTask.fromTime));
                    String format2 = this.mDateHourFormat.format(new Date(this.mDiagnoseTask.toTime));
                    sb.append("( ");
                    sb.append(format);
                    sb.append(" ~ ");
                    sb.append(format2);
                    sb.append(" ) ");
                    sb.append("this period contains none file !");
                    this.mTaskCallBack.onFail(UploadTaskStatusCallback.Code.NO_TARGET_FILE, sb.toString());
                }
                return;
            }
            sb.append(" files count:");
            sb.append(this.mUploadFiles.size());
            sb.append(", files length: ");
            sb.append(this.mFileTotalLength);
            final File zipLogFiles = zipLogFiles(sb);
            if (zipLogFiles == null) {
                return;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(COMPRESS_TYPE_KEY, COMPRESS_TYPE_ZIP);
            if (LoggerFactory.getLogContext().isZipAndSevenZip() && zipLogFiles.length() > SEVEN_ZIP_LENGTH && !NetUtil.isNetworkUseWifi()) {
                zipLogFiles = zipTo7z(zipLogFiles, sb, hashMap);
            }
            if (zipLogFiles.length() > this.mDiagnoseTask.maxFileSize) {
                sb.append(",zip file is larger than 10M: ");
                sb.append(zipLogFiles.length());
                UploadTaskStatusCallback uploadTaskStatusCallback = this.mTaskCallBack;
                if (uploadTaskStatusCallback != null) {
                    uploadTaskStatusCallback.onFail(UploadTaskStatusCallback.Code.FILE_ZIPPING, sb.toString());
                }
                FileUtil.deleteFileNotDir(zipLogFiles);
                return;
            }
            uploadCoreForRetry(zipLogFiles, new UploadTaskStatusCallback() { // from class: com.alipay.iap.android.aplog.core.uploader.IAPLogUploader.1
                {
                    IAPLogUploader.this = this;
                }

                @Override // com.alipay.iap.android.aplog.monitor.analysis.diagnose.UploadTaskStatusCallback
                public void onSuccess(String str2) {
                    IAPLogUploader.this.handUploadSuccess(sb, str2, zipLogFiles);
                }

                @Override // com.alipay.iap.android.aplog.monitor.analysis.diagnose.UploadTaskStatusCallback
                public void onFail(UploadTaskStatusCallback.Code code, String str2) {
                    IAPLogUploader.this.handUploadFail(code, str2, sb, zipLogFiles);
                }
            }, hashMap, sb.toString());
        }
    }

    void handUploadFail(UploadTaskStatusCallback.Code code, String str, StringBuilder sb, File file) {
        if (this.mTaskCallBack != null) {
            int i = PlaceComponentResult + 25;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            if (i % 2 == 0) {
                try {
                    sb.append(", upload message: ");
                    sb.append(str);
                    this.mTaskCallBack.onFail(code, sb.toString());
                } catch (Exception e) {
                    throw e;
                }
            } else {
                sb.append(", upload message: ");
                sb.append(str);
                this.mTaskCallBack.onFail(code, sb.toString());
                Object obj = null;
                obj.hashCode();
            }
        }
        FileUtil.deleteFileNotDir(file);
        int i2 = PlaceComponentResult + 103;
        BuiltInFictitiousFunctionClassFactory = i2 % 128;
        int i3 = i2 % 2;
    }

    void handUploadSuccess(StringBuilder sb, String str, File file) {
        try {
            int i = PlaceComponentResult + 123;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
            try {
                if (!(this.mTaskCallBack == null)) {
                    int i3 = PlaceComponentResult + 7;
                    BuiltInFictitiousFunctionClassFactory = i3 % 128;
                    if (i3 % 2 == 0) {
                        sb.append(", ");
                        sb.append(str);
                        this.mTaskCallBack.onSuccess(sb.toString());
                    } else {
                        sb.append(", ");
                        sb.append(str);
                        this.mTaskCallBack.onSuccess(sb.toString());
                        Object[] objArr = null;
                        int length = objArr.length;
                    }
                }
                FileUtil.deleteFileNotDir(file);
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    java.io.File zipTo7z(java.io.File r15, java.lang.StringBuilder r16, java.util.HashMap<java.lang.String, java.lang.String> r17) {
        /*
            r14 = this;
            r6 = r16
            r8 = r17
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r15.getAbsolutePath()
            r0.append(r1)
            java.lang.String r1 = ".7z"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.io.File r9 = new java.io.File
            r9.<init>(r0)
            long r1 = android.os.SystemClock.uptimeMillis()
            r10 = 1
            r11 = 0
            java.lang.String r3 = r15.getAbsolutePath()     // Catch: java.lang.Throwable -> L5f
            boolean r3 = com.alipay.iap.android.aplog.util.zip.LzmaAlone.sevenZipFile(r10, r11, r3, r0)     // Catch: java.lang.Throwable -> L5f
            long r4 = android.os.SystemClock.uptimeMillis()     // Catch: java.lang.Throwable -> L5b
            long r4 = r4 - r1
            java.lang.String r0 = ", 7Zing spend: "
            r6.append(r0)     // Catch: java.lang.Throwable -> L58
            r6.append(r4)     // Catch: java.lang.Throwable -> L58
            java.lang.String r0 = ", 7Zed length: "
            r6.append(r0)     // Catch: java.lang.Throwable -> L58
            long r0 = r9.length()     // Catch: java.lang.Throwable -> L58
            r6.append(r0)     // Catch: java.lang.Throwable -> L58
            java.lang.String r0 = ", 7Z success: "
            r6.append(r0)     // Catch: java.lang.Throwable -> L58
            r6.append(r3)     // Catch: java.lang.Throwable -> L58
            int r0 = com.alipay.iap.android.aplog.core.uploader.IAPLogUploader.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> Lb4
            int r0 = r0 + 79
            int r1 = r0 % 128
            com.alipay.iap.android.aplog.core.uploader.IAPLogUploader.PlaceComponentResult = r1     // Catch: java.lang.Exception -> Lb4
            int r0 = r0 % 2
            goto L74
        L58:
            r0 = move-exception
            r1 = r4
            goto L5c
        L5b:
            r0 = move-exception
        L5c:
            r7 = r0
            r0 = r3
            goto L62
        L5f:
            r0 = move-exception
            r7 = r0
            r0 = 0
        L62:
            long r3 = android.os.SystemClock.uptimeMillis()     // Catch: java.lang.Exception -> Lb4
            long r3 = r3 - r1
            long r12 = r9.length()     // Catch: java.lang.Exception -> Lb4
            r1 = r14
            r2 = r3
            r4 = r12
            r6 = r16
            r1.handleZipTo7zFail(r2, r4, r6, r7)     // Catch: java.lang.Exception -> Lb4
            r3 = r0
        L74:
            if (r3 == 0) goto Laf
            long r0 = r9.length()
            r2 = 0
            r4 = 91
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 <= 0) goto L85
            r0 = 15
            goto L87
        L85:
            r0 = 91
        L87:
            if (r0 == r4) goto Laf
            int r0 = com.alipay.iap.android.aplog.core.uploader.IAPLogUploader.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + r4
            int r1 = r0 % 128
            com.alipay.iap.android.aplog.core.uploader.IAPLogUploader.PlaceComponentResult = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L95
            r10 = 0
        L95:
            java.lang.String r0 = "7z"
            java.lang.String r1 = "CompressType"
            if (r10 == 0) goto La2
            com.alipay.iap.android.aplog.util.FileUtil.deleteFileNotDir(r15)
            r8.put(r1, r0)
            goto Lb3
        La2:
            com.alipay.iap.android.aplog.util.FileUtil.deleteFileNotDir(r15)
            r8.put(r1, r0)
            r0 = 86
            int r0 = r0 / r11
            goto Lb3
        Lac:
            r0 = move-exception
            r1 = r0
            throw r1
        Laf:
            com.alipay.iap.android.aplog.util.FileUtil.deleteFileNotDir(r9)
            r9 = r15
        Lb3:
            return r9
        Lb4:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.aplog.core.uploader.IAPLogUploader.zipTo7z(java.io.File, java.lang.StringBuilder, java.util.HashMap):java.io.File");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:42:0x004f
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    void handleZipTo7zFail(long r3, long r5, java.lang.StringBuilder r7, java.lang.Throwable r8) {
        /*
            r2 = this;
            int r0 = com.alipay.iap.android.aplog.core.uploader.IAPLogUploader.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 39
            int r1 = r0 % 128
            com.alipay.iap.android.aplog.core.uploader.IAPLogUploader.PlaceComponentResult = r1
            int r0 = r0 % 2
            java.lang.String r0 = ", 7Zing spend: "
            r7.append(r0)     // Catch: java.lang.Exception -> L4d
            r7.append(r3)     // Catch: java.lang.Exception -> L4d
            java.lang.String r3 = ", 7Zed length: "
            r7.append(r3)     // Catch: java.lang.Exception -> L4d
            r7.append(r5)     // Catch: java.lang.Exception -> L4d
            java.lang.String r3 = ", catch throwable: "
            r7.append(r3)     // Catch: java.lang.Exception -> L4d
            java.lang.String r3 = android.util.Log.getStackTraceString(r8)     // Catch: java.lang.Exception -> L4d
            r7.append(r3)     // Catch: java.lang.Exception -> L4d
            com.alipay.iap.android.aplog.core.logger.TraceLogger r3 = com.alipay.iap.android.aplog.core.LoggerFactory.getTraceLogger()     // Catch: java.lang.Exception -> L4d
            java.lang.String r4 = com.alipay.iap.android.aplog.core.uploader.IAPLogUploader.TAG     // Catch: java.lang.Exception -> L4d
            java.lang.String r5 = r7.toString()     // Catch: java.lang.Exception -> L4d
            r3.error(r4, r5)     // Catch: java.lang.Exception -> L4d
            int r3 = com.alipay.iap.android.aplog.core.uploader.IAPLogUploader.BuiltInFictitiousFunctionClassFactory
            int r3 = r3 + 85
            int r4 = r3 % 128
            com.alipay.iap.android.aplog.core.uploader.IAPLogUploader.PlaceComponentResult = r4
            int r3 = r3 % 2
            r4 = 0
            r5 = 1
            if (r3 != 0) goto L43
            r3 = 0
            goto L44
        L43:
            r3 = 1
        L44:
            if (r3 == r5) goto L4c
            r3 = 87
            int r3 = r3 / r4
            return
        L4a:
            r3 = move-exception
            throw r3
        L4c:
            return
        L4d:
            r3 = move-exception
            throw r3
        L4f:
            r3 = move-exception
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.aplog.core.uploader.IAPLogUploader.handleZipTo7zFail(long, long, java.lang.StringBuilder, java.lang.Throwable):void");
    }

    private void uploadCoreForRetry(File file, UploadTaskStatusCallback uploadTaskStatusCallback, Map<String, String> map, String str) {
        TraceLogger traceLogger = LoggerFactory.getTraceLogger();
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("uploadCoreForRetry: ");
        sb.append(file);
        traceLogger.info(str2, sb.toString());
        try {
            String requestUploadFileUrl = UploadConstants.requestUploadFileUrl(this.mDiagnoseTask);
            if (!(!TextUtils.isEmpty(requestUploadFileUrl))) {
                int i = PlaceComponentResult + 25;
                BuiltInFictitiousFunctionClassFactory = i % 128;
                int i2 = i % 2;
                UploadTaskStatusCallback uploadTaskStatusCallback2 = this.mTaskCallBack;
                if (uploadTaskStatusCallback2 != null) {
                    UploadTaskStatusCallback.Code code = UploadTaskStatusCallback.Code.NETWORK_ERROR;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append(",request upload url fail");
                    uploadTaskStatusCallback2.onFail(code, sb2.toString());
                    return;
                }
                return;
            }
            HttpUploadRunnable httpUploadRunnable = new HttpUploadRunnable(file.getAbsolutePath(), requestUploadFileUrl, this.mDiagnoseTask, uploadTaskStatusCallback);
            httpUploadRunnable.setHeaderParameters(map);
            APMTimer.getInstance().post(httpUploadRunnable);
            try {
                int i3 = PlaceComponentResult + 15;
                BuiltInFictitiousFunctionClassFactory = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Throwable th) {
            LoggerFactory.getTraceLogger().error(TAG, "uploadCoreForRetry", th);
        }
    }

    private void fillUploadFileListByReleaseType() {
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 69;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            if (!LoggingUtil.isDebuggable()) {
                try {
                    fillUploadFileList(new File(this.mContext.getFilesDir(), this.mDiagnoseTask.taskType));
                    int i3 = BuiltInFictitiousFunctionClassFactory + 97;
                    PlaceComponentResult = i3 % 128;
                    if (!(i3 % 2 != 0)) {
                        Object obj = null;
                        obj.hashCode();
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    LoggerFactory.getTraceLogger().warn(TAG, "uploadLog", th);
                    return;
                }
            }
            try {
                fillUploadFileList(new File(new File(LoggingUtil.getCommonExternalStorageDir(), this.mContext.getPackageName()), this.mDiagnoseTask.taskType));
            } catch (Throwable th2) {
                LoggerFactory.getTraceLogger().warn(TAG, "uploadLog", th2);
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private File zipLogFiles(StringBuilder sb) {
        ZipUtil.ZipFileHandler zipFileHandler;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.mDiagnoseTask.fileName);
        sb2.append('_');
        sb2.append(System.currentTimeMillis());
        sb2.append(SUFFIX_NORMAL_ZIP);
        File file = new File(this.mContext.getCacheDir(), sb2.toString());
        Object[] objArr = null;
        if ("applog".equalsIgnoreCase(this.mDiagnoseTask.taskType)) {
            zipFileHandler = new ZipUtil.ZipFileHandler() { // from class: com.alipay.iap.android.aplog.core.uploader.IAPLogUploader.2
                {
                    IAPLogUploader.this = this;
                }

                @Override // com.alipay.iap.android.aplog.util.ZipUtil.ZipFileHandler
                public String handleFileNameInZip(File file2) {
                    if (file2 == null) {
                        return null;
                    }
                    String name = file2.getName();
                    try {
                        String str = name.split("_")[0];
                        return name.replace(str, IAPLogUploader.access$000(IAPLogUploader.this).format(new Date(Long.parseLong(str))));
                    } catch (Throwable th) {
                        TraceLogger traceLogger = LoggerFactory.getTraceLogger();
                        String access$100 = IAPLogUploader.access$100();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(name);
                        sb3.append(" handleFileNameInZip");
                        traceLogger.warn(access$100, sb3.toString(), th);
                        return name;
                    }
                }
            };
            try {
                int i = BuiltInFictitiousFunctionClassFactory + 39;
                PlaceComponentResult = i % 128;
                int i2 = i % 2;
            } catch (Exception e) {
                throw e;
            }
        } else {
            zipFileHandler = null;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            ZipUtil.zipFile(this.mUploadFiles, file.getAbsolutePath(), null, zipFileHandler);
            long uptimeMillis2 = SystemClock.uptimeMillis();
            sb.append(", zipping spend: ");
            sb.append(uptimeMillis2 - uptimeMillis);
            sb.append(", zipped length: ");
            sb.append(file.length());
            if (file.exists()) {
                try {
                    if (file.isFile()) {
                        int i3 = PlaceComponentResult + 29;
                        BuiltInFictitiousFunctionClassFactory = i3 % 128;
                        if (i3 % 2 == 0 ? file.length() != 0 : file.length() != 0) {
                            if (this.mDiagnoseTask.isForceUpload) {
                                if ((this.mDiagnoseTask.zippedLenLimit > 0 ? 'Z' : 'K') != 'K') {
                                    if ((file.length() > this.mDiagnoseTask.zippedLenLimit ? 'F' : 'L') == 'F') {
                                        if (this.mTaskCallBack != null) {
                                            sb.append(", zipped limit: ");
                                            sb.append(this.mDiagnoseTask.zippedLenLimit);
                                            this.mTaskCallBack.onFail(UploadTaskStatusCallback.Code.TRAFIC_LIMIT, sb.toString());
                                        }
                                        return null;
                                    }
                                }
                            }
                            return file;
                        }
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            }
            if ((this.mTaskCallBack != null ? 'N' : ':') == 'N') {
                int i4 = BuiltInFictitiousFunctionClassFactory + 31;
                PlaceComponentResult = i4 % 128;
                if (i4 % 2 != 0) {
                    sb.append(", not exist: ");
                    sb.append(file.getAbsolutePath());
                    this.mTaskCallBack.onFail(UploadTaskStatusCallback.Code.ZIPPING_ERROR, sb.toString());
                } else {
                    sb.append(", not exist: ");
                    sb.append(file.getAbsolutePath());
                    this.mTaskCallBack.onFail(UploadTaskStatusCallback.Code.ZIPPING_ERROR, sb.toString());
                    int length = objArr.length;
                }
            }
            return null;
        } catch (Throwable th) {
            handException(uptimeMillis, sb, file, th);
            return null;
        }
    }

    void handException(long j, StringBuilder sb, File file, Throwable th) {
        int i = BuiltInFictitiousFunctionClassFactory + 103;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        long uptimeMillis = SystemClock.uptimeMillis();
        sb.append(", zipping spend: ");
        sb.append(uptimeMillis - j);
        sb.append(", zipped length: ");
        sb.append(file.length());
        sb.append(", catch throwable: ");
        sb.append(Log.getStackTraceString(th));
        String obj = sb.toString();
        UploadTaskStatusCallback uploadTaskStatusCallback = this.mTaskCallBack;
        if (uploadTaskStatusCallback != null) {
            int i3 = BuiltInFictitiousFunctionClassFactory + 99;
            PlaceComponentResult = i3 % 128;
            if ((i3 % 2 == 0 ? (char) 28 : (char) 7) != 7) {
                uploadTaskStatusCallback.onFail(UploadTaskStatusCallback.Code.ZIPPING_ERROR, obj);
                Object obj2 = null;
                obj2.hashCode();
            } else {
                uploadTaskStatusCallback.onFail(UploadTaskStatusCallback.Code.ZIPPING_ERROR, obj);
            }
        }
        try {
            int i4 = BuiltInFictitiousFunctionClassFactory + 57;
            try {
                PlaceComponentResult = i4 % 128;
                int i5 = i4 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private void fillUploadFileList(File file) {
        File[] listFiles;
        if ((file != null ? '_' : 'Y') == '_' && file.exists()) {
            if ((!file.isDirectory()) || (listFiles = file.listFiles()) == null) {
                return;
            }
            int i = BuiltInFictitiousFunctionClassFactory + 53;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            if (listFiles.length != 0) {
                int length = listFiles.length;
                for (int i3 = 0; i3 < length; i3++) {
                    try {
                        int i4 = BuiltInFictitiousFunctionClassFactory + 61;
                        PlaceComponentResult = i4 % 128;
                        int i5 = i4 % 2;
                        File file2 = listFiles[i3];
                        if (!(file2 == null)) {
                            try {
                                if ((file2.exists()) && file2.isFile()) {
                                    int i6 = BuiltInFictitiousFunctionClassFactory + 55;
                                    PlaceComponentResult = i6 % 128;
                                    if (i6 % 2 == 0) {
                                        if (file2.length() == 1) {
                                        }
                                    } else if (file2.length() == 0) {
                                    }
                                    String name = file2.getName();
                                    long parseLong = Long.parseLong(name.split("_")[0]);
                                    if (parseLong >= this.mDiagnoseTask.fromTime && parseLong < this.mDiagnoseTask.toTime) {
                                        if ((!this.mUploadFileNames.contains(name) ? '^' : '0') != '^') {
                                            continue;
                                        } else {
                                            int i7 = PlaceComponentResult + 83;
                                            try {
                                                BuiltInFictitiousFunctionClassFactory = i7 % 128;
                                                int i8 = i7 % 2;
                                                this.mUploadFiles.add(file2);
                                                this.mUploadFileNames.add(name);
                                                this.mFileTotalLength += file2.length();
                                                this.mFileMinTime = Math.min(parseLong, this.mFileMinTime);
                                                this.mFileMaxTime = Math.max(parseLong, this.mFileMaxTime);
                                            } catch (Exception e) {
                                                throw e;
                                            }
                                        }
                                    }
                                }
                            } catch (Throwable unused) {
                                TraceLogger traceLogger = LoggerFactory.getTraceLogger();
                                String str = TAG;
                                StringBuilder sb = new StringBuilder();
                                sb.append("fillUploadFileList: ");
                                sb.append(file2.getAbsolutePath());
                                traceLogger.error(str, sb.toString());
                            }
                        }
                    } catch (Exception e2) {
                        throw e2;
                    }
                }
                if (this.mUploadFiles.size() > 0) {
                    addDeviceInfoFile();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:90:0x00c9, code lost:
    
        if (r7.length > 32767) goto L91;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void addDeviceInfoFile() {
        /*
            Method dump skipped, instructions count: 271
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.aplog.core.uploader.IAPLogUploader.addDeviceInfoFile():void");
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        int i2;
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        try {
            getonboardingscenario.MyBillsEntityDataFactory = i;
            int length = cArr.length;
            long[] jArr = new long[length];
            getonboardingscenario.getAuthRequestContext = 0;
            int i3 = $10 + 107;
            $11 = i3 % 128;
            int i4 = i3 % 2;
            while (getonboardingscenario.getAuthRequestContext < cArr.length) {
                int i5 = $11 + 33;
                $10 = i5 % 128;
                if (i5 % 2 != 0) {
                    jArr[getonboardingscenario.getAuthRequestContext] = cArr[getonboardingscenario.getAuthRequestContext] & (getonboardingscenario.getAuthRequestContext + getonboardingscenario.MyBillsEntityDataFactory) & (MyBillsEntityDataFactory - 4796183387843776835L);
                    i2 = getonboardingscenario.getAuthRequestContext * 1;
                } else {
                    jArr[getonboardingscenario.getAuthRequestContext] = (4796183387843776835L ^ MyBillsEntityDataFactory) ^ (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory));
                    i2 = getonboardingscenario.getAuthRequestContext + 1;
                }
                getonboardingscenario.getAuthRequestContext = i2;
            }
            char[] cArr2 = new char[length];
            try {
                getonboardingscenario.getAuthRequestContext = 0;
                while (true) {
                    if ((getonboardingscenario.getAuthRequestContext < cArr.length ? '^' : (char) 19) == 19) {
                        objArr[0] = new String(cArr2);
                        return;
                    }
                    int i6 = $10 + 119;
                    $11 = i6 % 128;
                    int i7 = i6 % 2;
                    cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
                    getonboardingscenario.getAuthRequestContext++;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }
}
