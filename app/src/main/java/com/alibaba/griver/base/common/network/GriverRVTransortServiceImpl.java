package com.alibaba.griver.base.common.network;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.network.RVTransportService;
import com.alibaba.ariver.kernel.common.network.download.RVDownloadCallback;
import com.alibaba.ariver.kernel.common.network.download.RVDownloadRequest;
import com.alibaba.ariver.kernel.common.network.http.RVHttpRequest;
import com.alibaba.ariver.kernel.common.network.http.RVHttpResponse;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.api.common.network.DownloadCallback;
import com.alibaba.griver.api.common.network.DownloadRequest;
import com.alibaba.griver.api.common.network.HttpRequest;
import com.alibaba.griver.api.common.network.HttpResponse;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

/* loaded from: classes6.dex */
public class GriverRVTransortServiceImpl implements RVTransportService {
    @Override // com.alibaba.ariver.kernel.common.network.RVTransportService
    public RVHttpResponse httpRequest(RVHttpRequest rVHttpRequest) throws InterruptedException, ExecutionException, IOException {
        if (rVHttpRequest == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(GriverMonitorConstants.KEY_EXCEPTION_MESSAGE, "rvHttpRequest is empty");
            GriverMonitor.event(GriverMonitorConstants.ERROR_HTTP_FAILED, "GriverAppContainer", hashMap);
            return null;
        } else if (TextUtils.isEmpty(rVHttpRequest.getUrl())) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put(GriverMonitorConstants.KEY_EXCEPTION_MESSAGE, "rvHttpRequest url is empty");
            GriverMonitor.event(GriverMonitorConstants.ERROR_HTTP_FAILED, "GriverAppContainer", hashMap2);
            return null;
        } else {
            HttpRequest httpRequest = new HttpRequest();
            httpRequest.setUrl(rVHttpRequest.getUrl());
            httpRequest.setMethod(rVHttpRequest.getMethod());
            httpRequest.setRequestData(rVHttpRequest.getRequestData());
            httpRequest.setHeaders(rVHttpRequest.getHeaders());
            HttpResponse request = GriverTransport.request(httpRequest);
            if (request == null) {
                GriverLogger.w("GriverRVTransportServiceImpl", "response is null, return null");
                return null;
            }
            RVHttpResponse rVHttpResponse = new RVHttpResponse();
            rVHttpResponse.setStatusCode(request.getStatusCode());
            rVHttpResponse.setHeaders(request.getHeaders());
            rVHttpResponse.setResStream(request.getInputStream());
            return rVHttpResponse;
        }
    }

    @Override // com.alibaba.ariver.kernel.common.network.RVTransportService
    public void addDownload(RVDownloadRequest rVDownloadRequest, final RVDownloadCallback rVDownloadCallback) {
        String substring;
        if (rVDownloadRequest == null) {
            GriverLogger.e("GriverRVTransportServiceImpl", "download request is null");
            if (rVDownloadCallback != null) {
                rVDownloadCallback.onCancel("request is null");
                return;
            }
            return;
        }
        DownloadRequest downloadRequest = new DownloadRequest();
        downloadRequest.downloadUrl = rVDownloadRequest.getDownloadUrl();
        String downloadFileName = rVDownloadRequest.getDownloadFileName();
        if (downloadFileName == null || "".equals(downloadFileName.trim())) {
            substring = rVDownloadRequest.getDownloadUrl().substring(rVDownloadRequest.getDownloadUrl().lastIndexOf("/"));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("/");
            sb.append(downloadFileName);
            substring = sb.toString();
        }
        downloadRequest.downloadFilePath = FileUtils.combinePath(rVDownloadRequest.getDownloadDir(), substring);
        GriverTransport.download(downloadRequest, new DownloadCallback() { // from class: com.alibaba.griver.base.common.network.GriverRVTransortServiceImpl.1
            @Override // com.alibaba.griver.api.common.network.DownloadCallback
            public void onCancel(String str) {
            }

            @Override // com.alibaba.griver.api.common.network.DownloadCallback
            public void onPrepare(String str) {
            }

            @Override // com.alibaba.griver.api.common.network.DownloadCallback
            public void onProgress(String str, int i) {
            }

            @Override // com.alibaba.griver.api.common.network.DownloadCallback
            public void onFinish(String str) {
                RVDownloadCallback rVDownloadCallback2 = rVDownloadCallback;
                if (rVDownloadCallback2 != null) {
                    rVDownloadCallback2.onFinish(str);
                }
            }

            @Override // com.alibaba.griver.api.common.network.DownloadCallback
            public void onFailed(String str, int i, String str2) {
                RVDownloadCallback rVDownloadCallback2 = rVDownloadCallback;
                if (rVDownloadCallback2 != null) {
                    rVDownloadCallback2.onFailed(null, i, str2);
                }
            }
        });
    }
}
