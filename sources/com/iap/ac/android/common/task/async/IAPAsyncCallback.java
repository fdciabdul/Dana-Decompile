package com.iap.ac.android.common.task.async;

/* loaded from: classes3.dex */
public interface IAPAsyncCallback<T> {
    void onFailure(Exception exc);

    void onSuccess(T t);
}
