package com.alipay.iap.android.aplog.core.uploader;

import android.content.Context;
import com.alipay.iap.android.aplog.api.Uploader;
import com.alipay.iap.android.aplog.core.filter.LogCustomizeControl;
import com.alipay.iap.android.aplog.core.filter.LogUploadInfo;
import com.alipay.iap.android.aplog.core.filter.UploadResultInfo;
import java.io.File;

/* loaded from: classes3.dex */
public class HttpUploader extends BaseUploader implements Uploader {
    public static final String TAG = "HttpUploader";

    public HttpUploader(File file, Context context) {
        super(file, context);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:(3:65|66|(11:68|23|24|25|(4:27|28|29|(1:31)(1:35))(1:61)|36|37|(1:39)(2:(1:43)(1:45)|44)|40|41|34))|22|23|24|25|(0)(0)|36|37|(0)(0)|40|41|34) */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0102, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0104, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ee A[Catch: all -> 0x0102, TryCatch #0 {all -> 0x0102, blocks: (B:44:0x00b8, B:46:0x00ee, B:48:0x00f4, B:50:0x00fe, B:49:0x00fb), top: B:89:0x00b8 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0142  */
    @Override // com.alipay.iap.android.aplog.api.Uploader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void upload(java.lang.String r21, java.lang.String r22, android.os.Bundle r23) {
        /*
            Method dump skipped, instructions count: 485
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.aplog.core.uploader.HttpUploader.upload(java.lang.String, java.lang.String, android.os.Bundle):void");
    }

    private UploadResultInfo getUploadControlResult(File file, String str, LogCustomizeControl logCustomizeControl) {
        if (logCustomizeControl == null) {
            return null;
        }
        LogUploadInfo logUploadInfo = new LogUploadInfo();
        logUploadInfo.logCategory = str;
        logUploadInfo.logFile = file;
        return logCustomizeControl.isLogUpload(logUploadInfo);
    }
}
