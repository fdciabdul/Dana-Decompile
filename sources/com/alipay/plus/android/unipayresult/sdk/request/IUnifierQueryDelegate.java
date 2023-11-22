package com.alipay.plus.android.unipayresult.sdk.request;

import com.alipay.plus.android.unipayresult.sdk.executor.UnifierPayResultInfo;

/* loaded from: classes3.dex */
public interface IUnifierQueryDelegate {
    IUnifierRequest generateRequest();

    void parseBizResultInfo(String str, UnifierPayResultInfo unifierPayResultInfo);
}
