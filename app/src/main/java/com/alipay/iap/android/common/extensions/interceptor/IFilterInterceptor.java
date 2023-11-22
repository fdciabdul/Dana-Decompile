package com.alipay.iap.android.common.extensions.interceptor;

import com.alipay.iap.android.common.errorcode.IAPError;

/* loaded from: classes6.dex */
public interface IFilterInterceptor<Request, Response> {
    IAPError afterExecute(Response response);

    IAPError beforeExecute(Request request);
}
