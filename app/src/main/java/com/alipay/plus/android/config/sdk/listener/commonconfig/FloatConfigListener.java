package com.alipay.plus.android.config.sdk.listener.commonconfig;

/* loaded from: classes7.dex */
public abstract class FloatConfigListener extends NumberConfigListener {
    protected abstract void onFloatConfigChanged(String str, float f);

    @Override // com.alipay.plus.android.config.sdk.listener.commonconfig.NumberConfigListener
    protected void onNumberConfigChanged(String str, Number number) {
        onFloatConfigChanged(str, number.floatValue());
    }
}
