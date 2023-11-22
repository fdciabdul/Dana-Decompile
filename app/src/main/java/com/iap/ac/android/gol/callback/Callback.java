package com.iap.ac.android.gol.callback;

/* loaded from: classes3.dex */
public interface Callback<T> {
    void onFailure(String str, String str2);

    void onSuccess(T t);
}
