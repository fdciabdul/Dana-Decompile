package com.alipay.mobile.security.bio.service.local.transfer;

/* loaded from: classes7.dex */
public interface ProgressCallback<Source, Result> {
    void onError(Source source, Result result);

    void onFinish(Source source, Result result);

    void onProgress(Source source, int i, long j, long j2);

    void onStart(Source source);
}
