package com.iap.ac.android.mpm.base.interfaces;

import com.iap.ac.android.biz.common.model.Result;

/* loaded from: classes3.dex */
public interface IDecodeCallback {
    void dismissLoading();

    void onResult(Result result);

    void showLoading();
}
