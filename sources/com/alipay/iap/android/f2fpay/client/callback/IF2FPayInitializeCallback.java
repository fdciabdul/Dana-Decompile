package com.alipay.iap.android.f2fpay.client.callback;

import com.alipay.iap.android.f2fpay.otp.OtpInitResult;

/* loaded from: classes3.dex */
public interface IF2FPayInitializeCallback {
    void onInitializeFailed(String str);

    void onInitializeOtpSucceed();

    void onOtpInfoChanged(OtpInitResult otpInitResult);
}
