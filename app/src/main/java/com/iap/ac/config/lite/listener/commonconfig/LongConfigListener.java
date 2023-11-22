package com.iap.ac.config.lite.listener.commonconfig;

/* loaded from: classes8.dex */
public abstract class LongConfigListener extends NumberConfigListener {
    protected abstract void onLongConfigChanged(String str, long j);

    @Override // com.iap.ac.config.lite.listener.commonconfig.NumberConfigListener
    protected void onNumberConfigChanged(String str, Number number) {
        onLongConfigChanged(str, number.longValue());
    }
}
