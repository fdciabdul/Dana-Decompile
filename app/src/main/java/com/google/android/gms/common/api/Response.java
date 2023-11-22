package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Result;

/* loaded from: classes7.dex */
public class Response<T extends Result> {
    private Result zza;

    public Response() {
    }

    public Response(T t) {
        this.zza = t;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public T getResult() {
        return (T) this.zza;
    }

    public void setResult(T t) {
        this.zza = t;
    }
}
