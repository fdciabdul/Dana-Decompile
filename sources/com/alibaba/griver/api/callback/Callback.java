package com.alibaba.griver.api.callback;

/* loaded from: classes6.dex */
public interface Callback<T> {
    void onResultFailed(int i, String str);

    void onResultSuccess(T t);
}
