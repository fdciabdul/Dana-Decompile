package com.iap.ac.android.biz.common.model;

/* loaded from: classes8.dex */
public interface ScanCallback {
    void onFailure(ScanErrorCode scanErrorCode, String str);

    void onSuccess(String str);
}
