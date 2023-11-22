package com.alipay.plus.android.config.sdk.listener.commonconfig;

/* loaded from: classes7.dex */
public abstract class DoubleConfigListener extends NumberConfigListener {
    protected abstract void onDoubleConfigChanged(String str, double d);

    @Override // com.alipay.plus.android.config.sdk.listener.commonconfig.NumberConfigListener
    protected void onNumberConfigChanged(String str, Number number) {
        onDoubleConfigChanged(str, number.doubleValue());
    }
}
