package com.iap.ac.android.rpc.http.error;

/* loaded from: classes3.dex */
public class HttpException extends Exception {
    public String errorCode;
    public String errorMessage;

    public HttpException(String str, String str2) {
        this.errorCode = str;
        this.errorMessage = str2;
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HttpException{errorCode='");
        sb.append(this.errorCode);
        sb.append('\'');
        sb.append(", errorMessage='");
        sb.append(this.errorMessage);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
