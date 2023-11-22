package com.alipay.iap.android.f2fpay.components;

import com.alipay.iap.android.f2fpay.client.callback.IF2FPayResultCallback;
import com.alipay.iap.android.f2fpay.client.pay.F2fPayOrderInfo;

/* loaded from: classes3.dex */
public interface IF2FPayResultHandleComponent extends IF2FPayBaseComponent {

    /* loaded from: classes3.dex */
    public interface IPayResultDecoder<T> {
        F2fPayOrderInfo convertF2fPayOrderInfo(T t);

        Class<T> getPayOrderInfoClass();
    }

    void setPayResultCallback(IF2FPayResultCallback iF2FPayResultCallback);

    <T> void setPayResultDecoder(IPayResultDecoder<T> iPayResultDecoder);

    void setRefreshCodeWhenLastCodePayed(boolean z);

    void startHandleResult();

    void stopHandleResult();
}
