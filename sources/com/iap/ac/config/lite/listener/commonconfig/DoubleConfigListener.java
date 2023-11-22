package com.iap.ac.config.lite.listener.commonconfig;

/* loaded from: classes8.dex */
public abstract class DoubleConfigListener extends NumberConfigListener {
    protected abstract void onDoubleConfigChanged(String str, double d);

    @Override // com.iap.ac.config.lite.listener.commonconfig.NumberConfigListener
    protected void onNumberConfigChanged(String str, Number number) {
        onDoubleConfigChanged(str, number.doubleValue());
    }
}
