package com.alipay.iap.android.f2fpay.client;

import android.content.Context;
import com.alipay.iap.android.common.product.delegate.IAPUserDelegate;
import com.alipay.iap.android.common.product.delegate.UserInfoManager;
import com.alipay.iap.android.f2fpay.extension.IF2FPayDeviceIdGenerator;
import com.alipay.iap.android.f2fpay.extension.IF2FPayLogger;
import com.alipay.iap.android.f2fpay.extension.IF2FPayPaymentCodeGenerator;
import com.alipay.iap.android.f2fpay.extension.IF2FPaySecureStorage;

/* loaded from: classes3.dex */
public abstract class F2FPayClientContext {

    /* renamed from: a  reason: collision with root package name */
    private CheckOpenStrategy f6950a;
    protected IF2FPayDeviceIdGenerator mDeviceIdGenerator;
    protected IF2FPayLogger mPayLogger;
    protected IF2FPayPaymentCodeGenerator mPaymentCodeGenerator;
    protected IF2FPaySecureStorage mSecureStorage;
    protected IAPUserDelegate mUserDelegate;

    public F2FPayClientContext(Context context) {
        this(context, UserInfoManager.instance());
    }

    public F2FPayClientContext(Context context, IAPUserDelegate iAPUserDelegate) {
        this(context, iAPUserDelegate, CheckOpenStrategy.DEFAULT);
    }

    public F2FPayClientContext(Context context, IAPUserDelegate iAPUserDelegate, CheckOpenStrategy checkOpenStrategy) {
        this.mUserDelegate = iAPUserDelegate;
        this.mSecureStorage = createSecureStorage();
        this.mDeviceIdGenerator = createDeviceIdGenerator();
        this.mPaymentCodeGenerator = createPaymentCodeGenerator();
        this.f6950a = checkOpenStrategy;
        initializeProviders(context);
    }

    public F2FPayClientContext(Context context, CheckOpenStrategy checkOpenStrategy) {
        this(context, UserInfoManager.instance(), checkOpenStrategy);
    }

    protected abstract IF2FPayDeviceIdGenerator createDeviceIdGenerator();

    @Deprecated
    protected IF2FPayLogger createPayLogger() {
        return null;
    }

    protected abstract IF2FPayPaymentCodeGenerator createPaymentCodeGenerator();

    protected abstract IF2FPaySecureStorage createSecureStorage();

    public CheckOpenStrategy getCheckOpenStrategy() {
        return this.f6950a;
    }

    public IF2FPayDeviceIdGenerator getDeviceIdGenerator() {
        return this.mDeviceIdGenerator;
    }

    @Deprecated
    public IF2FPayLogger getPayLogger() {
        return this.mPayLogger;
    }

    public IF2FPayPaymentCodeGenerator getPaymentCodeGenerator() {
        return this.mPaymentCodeGenerator;
    }

    public IF2FPaySecureStorage getSecureStorage() {
        return this.mSecureStorage;
    }

    public IAPUserDelegate getUserDelegate() {
        return this.mUserDelegate;
    }

    protected void initializeProviders(Context context) {
        this.mSecureStorage.initialize(context);
    }
}
