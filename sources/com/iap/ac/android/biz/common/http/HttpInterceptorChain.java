package com.iap.ac.android.biz.common.http;

import com.iap.ac.android.biz.common.http.HttpInterceptor;
import com.iap.ac.android.biz.common.model.http.HttpRequest;
import com.iap.ac.android.biz.common.model.http.HttpResponse;
import java.util.List;

/* loaded from: classes8.dex */
public class HttpInterceptorChain implements HttpInterceptor.Chain {
    public final Call call;
    public final int index;
    public final List<HttpInterceptor> interceptors;
    public final HttpRequest request;

    public HttpInterceptorChain(List<HttpInterceptor> list, int i, HttpRequest httpRequest, Call call) {
        this.interceptors = list;
        this.index = i;
        this.request = httpRequest;
        this.call = call;
    }

    @Override // com.iap.ac.android.biz.common.http.HttpInterceptor.Chain
    public HttpResponse proceed(HttpRequest httpRequest) throws Exception {
        if (this.index >= this.interceptors.size()) {
            return this.call.call();
        }
        return this.interceptors.get(this.index).intercept(new HttpInterceptorChain(this.interceptors, this.index + 1, httpRequest, this.call));
    }

    @Override // com.iap.ac.android.biz.common.http.HttpInterceptor.Chain
    public HttpRequest request() {
        return this.request;
    }
}
