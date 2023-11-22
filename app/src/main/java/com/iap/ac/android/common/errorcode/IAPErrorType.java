package com.iap.ac.android.common.errorcode;

/* loaded from: classes8.dex */
public enum IAPErrorType {
    system(0),
    biz(1),
    library(2);

    public int value;

    IAPErrorType(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
