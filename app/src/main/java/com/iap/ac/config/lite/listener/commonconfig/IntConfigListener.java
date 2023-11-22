package com.iap.ac.config.lite.listener.commonconfig;

/* loaded from: classes8.dex */
public abstract class IntConfigListener extends NumberConfigListener {
    protected abstract void onIntConfigChanged(String str, int i);

    @Override // com.iap.ac.config.lite.listener.commonconfig.NumberConfigListener
    protected void onNumberConfigChanged(String str, Number number) {
        onIntConfigChanged(str, number.intValue());
    }
}
