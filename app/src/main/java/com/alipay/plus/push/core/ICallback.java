package com.alipay.plus.push.core;

/* loaded from: classes7.dex */
public interface ICallback<T> {
    void onFailed(String str, String str2);

    void onSuccess(T t);
}
