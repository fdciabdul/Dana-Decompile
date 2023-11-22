package com.alipay.plus.android.config.sdk.fetcher;

/* loaded from: classes7.dex */
public class FetchException extends Exception {
    public String errorCode;
    public String errorMessage;

    public FetchException(String str) {
        this("Unknown", str);
    }

    public FetchException(String str, String str2) {
        super(String.format("errorCode = %s, errorMessage = %s", str, str2));
        this.errorCode = str;
        this.errorMessage = str2;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return String.format("errorCode = %s, errorMessage = %s", this.errorCode, this.errorMessage);
    }
}
