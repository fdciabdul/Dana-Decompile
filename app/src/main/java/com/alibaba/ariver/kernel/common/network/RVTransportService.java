package com.alibaba.ariver.kernel.common.network;

import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.ariver.kernel.common.network.download.RVDownloadCallback;
import com.alibaba.ariver.kernel.common.network.download.RVDownloadRequest;
import com.alibaba.ariver.kernel.common.network.http.RVHttpRequest;
import com.alibaba.ariver.kernel.common.network.http.RVHttpResponse;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

/* loaded from: classes6.dex */
public interface RVTransportService extends Proxiable {
    void addDownload(RVDownloadRequest rVDownloadRequest, RVDownloadCallback rVDownloadCallback);

    RVHttpResponse httpRequest(RVHttpRequest rVHttpRequest) throws InterruptedException, ExecutionException, IOException;
}
