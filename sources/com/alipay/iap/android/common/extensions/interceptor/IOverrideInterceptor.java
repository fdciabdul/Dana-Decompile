package com.alipay.iap.android.common.extensions.interceptor;

/* loaded from: classes3.dex */
public interface IOverrideInterceptor<Request, Response> {
    Response afterExecute(Response response);

    Request beforeExecute(Request request);
}
