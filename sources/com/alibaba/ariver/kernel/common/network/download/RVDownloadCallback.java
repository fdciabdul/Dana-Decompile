package com.alibaba.ariver.kernel.common.network.download;

/* loaded from: classes6.dex */
public interface RVDownloadCallback {
    void onCancel(String str);

    void onFailed(String str, int i, String str2);

    void onFinish(String str);

    void onPrepare(String str);

    void onProgress(String str, int i);
}
