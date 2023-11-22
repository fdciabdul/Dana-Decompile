package com.alibaba.griver.image.framework.api;

import com.alibaba.griver.image.framework.meta.APImageDownloadRsp;

/* loaded from: classes6.dex */
public interface APImageDownLoadCallback {
    void onError(APImageDownloadRsp aPImageDownloadRsp, Exception exc);

    void onProcess(String str, int i);

    void onSucc(APImageDownloadRsp aPImageDownloadRsp);
}
