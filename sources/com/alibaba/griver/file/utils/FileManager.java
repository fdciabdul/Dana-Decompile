package com.alibaba.griver.file.utils;

import android.text.TextUtils;
import com.alibaba.griver.api.common.network.DownloadCallback;
import com.alibaba.griver.api.common.network.DownloadRequest;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.network.GriverTransport;
import com.alibaba.griver.base.common.utils.AOMPFileTinyAppUtils;
import com.alibaba.griver.base.common.utils.TinyAppFileUtils;
import com.alibaba.griver.image.photo.PhotoContext;
import java.io.File;

/* loaded from: classes2.dex */
public class FileManager {
    public static void downloadFileByHttp(String str, String str2, String str3, final DownloadCallback downloadCallback) {
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, str3);
        if (file2.exists()) {
            file2.delete();
        }
        try {
            DownloadRequest downloadRequest = new DownloadRequest();
            downloadRequest.retryTime = 0;
            downloadRequest.downloadUrl = str;
            downloadRequest.downloadFilePath = file2.getAbsolutePath();
            GriverLogger.d("FileManager", "start download file");
            GriverTransport.download(downloadRequest, new DownloadCallback() { // from class: com.alibaba.griver.file.utils.FileManager.1
                @Override // com.alibaba.griver.api.common.network.DownloadCallback
                public final void onPrepare(String str4) {
                    DownloadCallback.this.onPrepare(str4);
                }

                @Override // com.alibaba.griver.api.common.network.DownloadCallback
                public final void onProgress(String str4, int i) {
                    DownloadCallback.this.onProgress(str4, i);
                }

                @Override // com.alibaba.griver.api.common.network.DownloadCallback
                public final void onCancel(String str4) {
                    DownloadCallback.this.onCancel(str4);
                }

                @Override // com.alibaba.griver.api.common.network.DownloadCallback
                public final void onFinish(String str4) {
                    DownloadCallback.this.onFinish(str4);
                }

                @Override // com.alibaba.griver.api.common.network.DownloadCallback
                public final void onFailed(String str4, int i, String str5) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("download file failed, path=");
                    sb.append(str4);
                    sb.append(",errorCode=");
                    sb.append(i);
                    sb.append(",errorMsg=");
                    sb.append(str5);
                    GriverLogger.e("FileManager", sb.toString());
                    DownloadCallback.this.onFailed(str4, i, str5);
                }
            });
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("download file failed, path=");
            sb.append(str2);
            sb.append(",e=");
            sb.append(th);
            GriverLogger.e("FileManager", sb.toString());
            downloadCallback.onFailed(str2, -1, th.getMessage());
        }
    }

    public static String getFilePath(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith(PhotoContext.FILE_SCHEME)) {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            str = AOMPFileTinyAppUtils.getLocalPathFromId(str);
        }
        if (TinyAppFileUtils.containsRelativeParentPath(str) || TextUtils.isEmpty(str)) {
            return null;
        }
        return str;
    }
}
