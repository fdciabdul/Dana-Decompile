package com.iap.ac.android.common.errorcode;

/* loaded from: classes8.dex */
public class IAPException extends Exception {
    public IAPError error;

    public IAPException(IAPError iAPError) {
        this.error = iAPError;
    }

    public IAPError getError() {
        return this.error;
    }

    public IAPException(IAPError iAPError, String str) {
        super(str);
        this.error = iAPError;
    }

    public IAPException(IAPError iAPError, String str, Throwable th) {
        super(str, th);
        this.error = iAPError;
    }
}
