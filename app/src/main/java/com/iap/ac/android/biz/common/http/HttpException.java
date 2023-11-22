package com.iap.ac.android.biz.common.http;

/* loaded from: classes8.dex */
public class HttpException extends Exception {
    public HttpException() {
    }

    public HttpException(String str) {
        super(str);
    }

    public HttpException(String str, Throwable th) {
        super(str, th);
    }

    public HttpException(Throwable th) {
        super(th);
    }
}
