package com.alipay.plus.android.config.sdk.listener.commonconfig;

/* loaded from: classes7.dex */
public abstract class IntConfigListener extends NumberConfigListener {
    protected abstract void onIntConfigChanged(String str, int i);

    @Override // com.alipay.plus.android.config.sdk.listener.commonconfig.NumberConfigListener
    protected void onNumberConfigChanged(String str, Number number) {
        onIntConfigChanged(str, number.intValue());
    }
}
