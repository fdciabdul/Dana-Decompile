package com.alipay.iap.android.common.errorcode;

/* loaded from: classes6.dex */
public enum IAPErrorLevel {
    information(1),
    warning(3),
    error(5),
    fatal(7);

    int value;

    IAPErrorLevel(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
