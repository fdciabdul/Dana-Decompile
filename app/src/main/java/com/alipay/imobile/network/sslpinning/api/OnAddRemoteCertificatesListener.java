package com.alipay.imobile.network.sslpinning.api;

/* loaded from: classes3.dex */
public interface OnAddRemoteCertificatesListener {
    void onFailure(RemoteCertificateDownloadException remoteCertificateDownloadException);

    void onSuccess();
}
