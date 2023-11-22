package com.alibaba.ariver.resource.api;

/* loaded from: classes3.dex */
public interface PackageDownloadCallback {
    void onCancel(String str);

    void onFailed(String str, int i, String str2);

    void onFinish(String str);

    void onPrepare(String str);

    void onProgress(String str, int i);
}
