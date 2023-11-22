package com.iap.ac.android.rpc.ssl.api;

import com.iap.ac.android.rpc.ssl.task.RemoteCertificateDownloadPinnerException;

/* loaded from: classes8.dex */
public interface OnAddRemoteCertificatesListener {
    void onFailure(RemoteCertificateDownloadPinnerException remoteCertificateDownloadPinnerException);

    void onSuccess();
}
