package com.iap.ac.android.biz.common.http;

import com.iap.ac.android.biz.common.model.http.HttpRequest;
import com.iap.ac.android.biz.common.model.http.HttpResponse;
import java.util.List;

/* loaded from: classes8.dex */
public class RealCall<T> implements Call {
    public final HttpClient client;
    public final List<HttpInterceptor> interceptors;
    public final HttpRequest request;

    public RealCall(HttpClient httpClient, HttpRequest httpRequest, List<HttpInterceptor> list) {
        this.client = httpClient;
        this.request = httpRequest;
        this.interceptors = list;
    }

    public static Call newRealCall(HttpClient httpClient, HttpRequest httpRequest, List<HttpInterceptor> list) {
        return new RealCall(httpClient, httpRequest, list);
    }

    @Override // com.iap.ac.android.biz.common.http.Call
    public HttpResponse call() throws Exception {
        return this.client.executed(this);
    }

    @Override // com.iap.ac.android.biz.common.http.Call
    public HttpResponse execute() throws Exception {
        return new HttpInterceptorChain(this.interceptors, 0, this.request, this).proceed(this.request);
    }
}
