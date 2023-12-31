package com.alipay.iap.android.f2fpay.components;

import com.alipay.iap.android.f2fpay.client.callback.IF2FPaymentCodeCallback;
import com.alipay.iap.android.f2fpay.common.IF2FPayCallbackHolder;
import java.util.List;

/* loaded from: classes3.dex */
public interface IF2FPayPaymentCodeComponent extends IF2FPayBaseComponent {
    IF2FPayCallbackHolder addPaymentCodeCallback(IF2FPaymentCodeCallback iF2FPaymentCodeCallback);

    void clearWaitingResultPaymentCodes();

    long getPollingTimeStamp(String str);

    int getRefreshTimeSeconds();

    List<String> getWaitingResultPaymentCodes();

    int paymentCodeResultHasHandled(String str);

    void requestRefresh(int i);

    void setRefreshTimeSeconds(int i);

    void startRefreshTask();

    void stopRefreshTask();
}
