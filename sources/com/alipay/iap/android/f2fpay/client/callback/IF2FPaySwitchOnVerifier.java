package com.alipay.iap.android.f2fpay.client.callback;

import com.alipayplus.mobile.component.f2fpay.service.request.F2fpaySwitchOnRequest;
import com.alipayplus.mobile.component.f2fpay.service.result.F2fpayCheckOpenResult;

/* loaded from: classes3.dex */
public interface IF2FPaySwitchOnVerifier {

    /* loaded from: classes3.dex */
    public interface Callback {
        void onVerifyCallback(F2fpaySwitchOnRequest f2fpaySwitchOnRequest);

        void onVerifyCanceled();
    }

    void verifySwitchOnF2FPay(F2fpayCheckOpenResult f2fpayCheckOpenResult, Callback callback);
}
