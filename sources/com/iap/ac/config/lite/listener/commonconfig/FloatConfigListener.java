package com.iap.ac.config.lite.listener.commonconfig;

/* loaded from: classes8.dex */
public abstract class FloatConfigListener extends NumberConfigListener {
    protected abstract void onFloatConfigChanged(String str, float f);

    @Override // com.iap.ac.config.lite.listener.commonconfig.NumberConfigListener
    protected void onNumberConfigChanged(String str, Number number) {
        onFloatConfigChanged(str, number.floatValue());
    }
}
