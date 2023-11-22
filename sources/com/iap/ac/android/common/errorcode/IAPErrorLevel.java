package com.iap.ac.android.common.errorcode;

/* loaded from: classes8.dex */
public enum IAPErrorLevel {
    information(1),
    warning(3),
    error(5),
    fatal(7);

    public int value;

    IAPErrorLevel(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
