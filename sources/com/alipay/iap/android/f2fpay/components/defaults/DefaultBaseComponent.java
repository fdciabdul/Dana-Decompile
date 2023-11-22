package com.alipay.iap.android.f2fpay.components.defaults;

import android.content.Context;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.common.product.delegate.IAPUserDelegate;
import com.alipay.iap.android.f2fpay.client.F2FPayClientContext;
import com.alipay.iap.android.f2fpay.client.F2FPayDefaultClient;
import com.alipay.iap.android.f2fpay.client.IF2FPayClient;
import com.alipay.iap.android.f2fpay.common.F2FPayConstants;
import com.alipay.iap.android.f2fpay.common.KeyValueAccessor;
import com.alipay.iap.android.f2fpay.common.KeyValueRegistry;
import com.alipay.iap.android.f2fpay.components.IF2FPayBaseComponent;
import com.alipay.iap.android.f2fpay.components.IF2FPayInitializeComponent;
import com.alipay.iap.android.f2fpay.components.IF2FPayOpenComponent;
import com.alipay.iap.android.f2fpay.util.ConvertUtils;

/* loaded from: classes3.dex */
public abstract class DefaultBaseComponent implements IF2FPayBaseComponent {
    protected IF2FPayClient mPayClient;

    /* JADX INFO: Access modifiers changed from: protected */
    public String generateTerminalIdentifier() {
        return getClientContext().getDeviceIdGenerator().generateDeviceId(getContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String generateUserIdentity() {
        F2FPayClientContext clientContext = getClientContext();
        return ConvertUtils.getIdentity(clientContext.getUserDelegate().getUserId(), generateTerminalIdentifier());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public F2FPayClientContext getClientContext() {
        return this.mPayClient.getClientContext();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T extends IF2FPayBaseComponent> T getComponent(Class<T> cls) {
        IF2FPayClient iF2FPayClient = this.mPayClient;
        if (iF2FPayClient == null) {
            return null;
        }
        return (T) iF2FPayClient.getComponent(cls);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getContext() {
        return this.mPayClient.getContext();
    }

    public boolean getStartRefreshFlag() {
        IF2FPayClient iF2FPayClient = this.mPayClient;
        if (iF2FPayClient == null) {
            LoggerWrapper.e(F2FPayConstants.TAG, "getStartRefreshFlag error, with null mPayClient");
            return false;
        }
        return iF2FPayClient.getStartRefreshFlag();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IAPUserDelegate getUserDelegate() {
        return getClientContext().getUserDelegate();
    }

    @Override // com.alipay.iap.android.f2fpay.components.IF2FPayBaseComponent
    public void initialize(IF2FPayClient iF2FPayClient) {
        this.mPayClient = iF2FPayClient;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initializeOtpInfo() {
        ((IF2FPayInitializeComponent) getComponent(IF2FPayInitializeComponent.class)).asyncInitializeOtpInfo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isF2FPayOpen() {
        IF2FPayOpenComponent iF2FPayOpenComponent = (IF2FPayOpenComponent) getComponent(IF2FPayOpenComponent.class);
        return iF2FPayOpenComponent == null || iF2FPayOpenComponent.isOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public KeyValueAccessor keyValueAccessor() {
        KeyValueRegistry keyValueRegistry;
        String str;
        if (this.mPayClient instanceof F2FPayDefaultClient) {
            keyValueRegistry = KeyValueRegistry.getInstance();
            str = ((F2FPayDefaultClient) this.mPayClient).getBizType();
        } else {
            keyValueRegistry = KeyValueRegistry.getInstance();
            str = null;
        }
        return keyValueRegistry.accessor(str);
    }

    public void setStartRefreshFlag(boolean z) {
        IF2FPayClient iF2FPayClient = this.mPayClient;
        if (iF2FPayClient == null) {
            LoggerWrapper.e(F2FPayConstants.TAG, "setStartRefreshFlag error, with null mPayClient");
        } else {
            iF2FPayClient.setStartRefreshFlag(z);
        }
    }
}
