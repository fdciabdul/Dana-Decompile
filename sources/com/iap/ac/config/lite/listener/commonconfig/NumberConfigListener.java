package com.iap.ac.config.lite.listener.commonconfig;

/* loaded from: classes8.dex */
public abstract class NumberConfigListener extends AbstractTypedConfigListener<Number> {
    public NumberConfigListener() {
        super(Number.class);
    }

    protected Number getDefaultNumber() {
        return 0;
    }

    protected abstract void onNumberConfigChanged(String str, Number number);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.iap.ac.config.lite.listener.commonconfig.AbstractTypedConfigListener
    public void onConfigChangedInternal(String str, Number number) {
        if (number == null) {
            number = getDefaultNumber();
        }
        onNumberConfigChanged(str, number);
    }
}
