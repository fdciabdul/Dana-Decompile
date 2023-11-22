package com.alipay.plus.android.config.sdk.listener.commonconfig;

/* loaded from: classes7.dex */
public abstract class NumberConfigListener extends AbstractTypedConfigListener<Number> {
    public NumberConfigListener() {
        super(Number.class);
    }

    protected Number getDefaultNumber() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.plus.android.config.sdk.listener.commonconfig.AbstractTypedConfigListener
    public void onConfigChangedInternal(String str, Number number) {
        if (number == null) {
            number = getDefaultNumber();
        }
        onNumberConfigChanged(str, number);
    }

    protected abstract void onNumberConfigChanged(String str, Number number);
}
