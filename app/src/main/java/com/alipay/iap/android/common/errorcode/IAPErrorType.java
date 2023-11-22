package com.alipay.iap.android.common.errorcode;

/* loaded from: classes6.dex */
public enum IAPErrorType {
    system(0),
    biz(1),
    library(2);

    private int value;

    IAPErrorType(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
