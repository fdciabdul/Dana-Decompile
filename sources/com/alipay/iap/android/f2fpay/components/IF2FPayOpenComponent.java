package com.alipay.iap.android.f2fpay.components;

import com.alipay.iap.android.f2fpay.client.callback.IF2FPayOpenCallback;
import com.alipay.iap.android.f2fpay.client.callback.IF2FPaySwitchOnVerifier;
import com.alipay.iap.android.f2fpay.common.IF2FPayCallbackHolder;

/* loaded from: classes3.dex */
public interface IF2FPayOpenComponent extends IF2FPayBaseComponent {
    IF2FPayCallbackHolder addOpenCallback(IF2FPayOpenCallback iF2FPayOpenCallback);

    void checkOpen();

    boolean isOpen();

    void setLocalOpenFlag(boolean z);

    void setSwitchOnVerifier(IF2FPaySwitchOnVerifier iF2FPaySwitchOnVerifier);

    void switchOff();

    void switchOn();
}
