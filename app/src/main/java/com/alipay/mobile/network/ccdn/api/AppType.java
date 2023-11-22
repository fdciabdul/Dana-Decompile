package com.alipay.mobile.network.ccdn.api;

/* loaded from: classes6.dex */
public enum AppType {
    TYPE_APP(1),
    TYPE_PLUGIN(2),
    TYPE_H5_APP(3);

    private int mValue;

    AppType(int i) {
        this.mValue = i;
    }

    public final int value() {
        return this.mValue;
    }
}
