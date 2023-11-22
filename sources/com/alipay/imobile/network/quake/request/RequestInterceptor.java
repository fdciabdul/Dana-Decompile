package com.alipay.imobile.network.quake.request;

import com.alipay.imobile.network.quake.NetworkResponse;
import com.alipay.imobile.network.quake.Request;

/* loaded from: classes.dex */
public interface RequestInterceptor {
    void afterReceiveResponse(Request request, NetworkResponse networkResponse);

    void beforeSendRequest(Request request);
}
