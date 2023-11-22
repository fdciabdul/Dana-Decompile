package com.alipay.iap.android.f2fpay.client;

import android.app.Application;
import android.content.Context;
import com.alipay.iap.android.f2fpay.client.callback.IF2FPayOpenCallback;
import com.alipay.iap.android.f2fpay.client.callback.IF2FPayResultCallback;
import com.alipay.iap.android.f2fpay.client.callback.IF2FPaymentCodeCallback;
import com.alipay.iap.android.f2fpay.common.IF2FPayCallbackHolder;
import com.alipay.iap.android.f2fpay.components.IF2FPayBaseComponent;

/* loaded from: classes3.dex */
public interface IF2FPayClient {
    IF2FPayCallbackHolder addPayOpenCallback(IF2FPayOpenCallback iF2FPayOpenCallback);

    IF2FPayCallbackHolder addPaymentCodeCallback(IF2FPaymentCodeCallback iF2FPaymentCodeCallback);

    void closeF2FPay();

    void deleteOtpSeed();

    F2FPayClientContext getClientContext();

    <T extends IF2FPayBaseComponent> T getComponent(Class<T> cls);

    Context getContext();

    String getSeedExtra();

    boolean getStartRefreshFlag();

    void initialize(Application application, F2FPayClientContext f2FPayClientContext);

    boolean isInitialized();

    void onDestroy();

    void refreshPaymentCode(int i);

    void setPayResultCallback(IF2FPayResultCallback iF2FPayResultCallback);

    void setSeedExtra(String str);

    void setStartRefreshFlag(boolean z);

    void startF2FPay();

    void startRefreshTask();

    void stopRefreshTask();
}
