package com.iap.ac.android.rpc.http.error;

/* loaded from: classes3.dex */
public enum HttpError {
    Unknown("Unknown"),
    UrlIsEmpty("UrlIsEmpty"),
    RetrieveStatusCodeError("RetrieveStatusCodeError"),
    NoHttpReqUrlAnnotation("NoHttpReqUrlAnnotation"),
    ResponseIsNull("ResponseIsNull"),
    ParseResponseJsonFailed("ParseResponseJsonFailed"),
    ParseResponseFailed("ParseResponseFailed");

    public String errorCode;

    HttpError(String str) {
        this.errorCode = str;
    }

    public final String getErrorCode() {
        return this.errorCode;
    }
}
