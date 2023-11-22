package com.alipay.iap.android.common.task.async;

import com.alipay.iap.android.common.errorcode.IAPError;

/* loaded from: classes3.dex */
public interface IAPAsyncCallback<T> {
    void onFailure(IAPError iAPError);

    void onSuccess(T t);
}
