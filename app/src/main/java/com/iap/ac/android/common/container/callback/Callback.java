package com.iap.ac.android.common.container.callback;

/* loaded from: classes3.dex */
public interface Callback<T> {
    void onResultFailed(int i, String str);

    void onResultSuccess(T t);
}
