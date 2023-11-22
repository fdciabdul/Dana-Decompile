package com.alipay.plus.android.config.sdk.listener.commonconfig;

/* loaded from: classes7.dex */
public abstract class BooleanConfigListener extends AbstractTypedConfigListener<Boolean> {
    public BooleanConfigListener() {
        super(Boolean.class);
    }

    protected boolean getDefaultBoolean() {
        return false;
    }

    protected abstract void onBooleanConfigChanged(String str, boolean z);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.plus.android.config.sdk.listener.commonconfig.AbstractTypedConfigListener
    public void onConfigChangedInternal(String str, Boolean bool) {
        onBooleanConfigChanged(str, bool != null ? bool.booleanValue() : getDefaultBoolean());
    }
}
