package com.alipay.plus.android.transport.sdk;

/* loaded from: classes7.dex */
public enum HttpError {
    Unknown("Unknown"),
    UrlIsEmpty("UrlIsEmpty"),
    RetrieveStatusCodeError("UrlIsEmpty"),
    NoHttpReqUrlAnnotation("NoHttpReqUrlAnnotation"),
    ResponseIsNull("ResponseIsNull"),
    StatusCodeNot200("StatusCodeNot200"),
    ParseResponseJsonFailed("ParseResponseJsonFailed"),
    ParseResponseFailed("ParseResponseFailed");

    protected String errorCode;

    HttpError(String str) {
        this.errorCode = str;
    }

    public final String getErrorCode() {
        return this.errorCode;
    }
}
