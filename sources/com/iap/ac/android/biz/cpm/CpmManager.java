package com.iap.ac.android.biz.cpm;

import android.app.Activity;
import com.alipay.iap.android.f2fpay.widgets.widget.F2FPayCompositePaymentCodeView;

/* loaded from: classes8.dex */
public interface CpmManager {
    F2FPayCompositePaymentCodeView buildCompositePaymentCodeView(Activity activity);

    void getPaymentCode();

    void startRefreshPaymentCode();

    void stopRefreshPaymentCode();

    void updateOption(CpmOption cpmOption);
}
