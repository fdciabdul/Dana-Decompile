package com.iap.ac.android.biz.common.callback;

import com.iap.ac.android.biz.common.model.InitErrorCode;

/* loaded from: classes3.dex */
public interface InitCallback {
    void onFailure(InitErrorCode initErrorCode, String str);

    void onSuccess();
}
