package com.iap.ac.android.biz.common.http;

import com.iap.ac.android.biz.common.model.http.HttpRequest;
import com.iap.ac.android.biz.common.model.http.HttpResponse;

/* loaded from: classes8.dex */
public interface HttpInterceptor {

    /* loaded from: classes8.dex */
    public interface Chain {
        HttpResponse proceed(HttpRequest httpRequest) throws Exception;

        HttpRequest request();
    }

    HttpResponse intercept(Chain chain) throws Exception;
}
