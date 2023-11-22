package com.alipay.plus.android.config.sdk.retry;

import com.alipay.plus.android.transport.proxy.HttpReqMethod;
import com.alipay.plus.android.transport.proxy.HttpReqUrl;
import com.alipay.plus.android.transport.sdk.HttpMethod;

/* loaded from: classes2.dex */
public interface b {
    @HttpReqUrl("fromDelegate")
    @HttpReqMethod(HttpMethod.GET)
    a a() throws Throwable;
}
