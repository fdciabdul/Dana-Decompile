package com.alipay.iap.android.f2fpay.client.callback;

import com.alipay.iap.android.f2fpay.paymentcode.F2FPaymentCodeInfo;

/* loaded from: classes3.dex */
public interface IF2FPaymentCodeCallback {
    void onPaymentCodeGenerateFailed();

    void onPaymentCodeUpdated(F2FPaymentCodeInfo f2FPaymentCodeInfo);
}
