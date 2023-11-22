package com.alipay.plus.android.config.sdk.listener.commonconfig;

/* loaded from: classes7.dex */
public abstract class LongConfigListener extends NumberConfigListener {
    protected abstract void onLongConfigChanged(String str, long j);

    @Override // com.alipay.plus.android.config.sdk.listener.commonconfig.NumberConfigListener
    protected void onNumberConfigChanged(String str, Number number) {
        onLongConfigChanged(str, number.longValue());
    }
}
