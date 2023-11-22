package com.alibaba.griver.base.resource.predownload;

import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.api.common.network.DownloadCallback;
import com.alibaba.griver.api.common.network.DownloadRequest;
import com.alibaba.griver.base.appxng.GriverAppxNgRuntimeChecker;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.network.GriverTransport;
import com.alibaba.griver.base.common.utils.AppInfoUtils;
import com.alibaba.griver.base.common.utils.GriverConfigUtils;
import java.io.File;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes3.dex */
public class AppPreDownloadPackageManager {
    public static final String TAG = "AppPreDownloadPackageManager";

    public static void downloadPackageWithURLString(List<AppModel> list) {
        for (AppModel appModel : list) {
            if (!AppInfoUtils.isInstalled(appModel) && !AppPreDownloadManager.isPreDownloadFileAvailable(appModel)) {
                AppInfoUtils.deletePreDownloadFile(appModel);
                int transferStringConfigToInt = GriverConfigUtils.transferStringConfigToInt(GriverConfigConstants.KEY_DOWNLOAD_APP_RETRY_TIME, 2);
                DownloadRequest downloadRequest = new DownloadRequest();
                downloadRequest.downloadUrl = GriverAppxNgRuntimeChecker.getPackageUrl(appModel);
                File preDownloadFile = AppInfoUtils.getPreDownloadFile(appModel);
                if (preDownloadFile != null) {
                    downloadRequest.downloadFilePath = preDownloadFile.getAbsolutePath();
                    downloadRequest.retryTime = transferStringConfigToInt;
                    downloadRequest.appId = appModel.getAppId();
                    downloadRequest.version = AppInfoUtils.getDeveloperVersion(appModel);
                    downloadRequest.deployVersion = appModel.getAppVersion();
                    downloadRequest.urgent = false;
                    final CountDownLatch countDownLatch = new CountDownLatch(1);
                    GriverTransport.download(downloadRequest, new DownloadCallback() { // from class: com.alibaba.griver.base.resource.predownload.AppPreDownloadPackageManager.1
                        @Override // com.alibaba.griver.api.common.network.DownloadCallback
                        public final void onPrepare(String str) {
                        }

                        @Override // com.alibaba.griver.api.common.network.DownloadCallback
                        public final void onProgress(String str, int i) {
                        }

                        @Override // com.alibaba.griver.api.common.network.DownloadCallback
                        public final void onCancel(String str) {
                            countDownLatch.countDown();
                        }

                        @Override // com.alibaba.griver.api.common.network.DownloadCallback
                        public final void onFinish(String str) {
                            countDownLatch.countDown();
                        }

                        @Override // com.alibaba.griver.api.common.network.DownloadCallback
                        public final void onFailed(String str, int i, String str2) {
                            countDownLatch.countDown();
                            StringBuilder sb = new StringBuilder();
                            sb.append("download onFailed , release countdown, path: ");
                            sb.append(str);
                            GriverLogger.w(AppPreDownloadPackageManager.TAG, sb.toString());
                        }
                    });
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException unused) {
                        GriverLogger.w(TAG, "download countdown latch release");
                    }
                }
            }
        }
    }
}
