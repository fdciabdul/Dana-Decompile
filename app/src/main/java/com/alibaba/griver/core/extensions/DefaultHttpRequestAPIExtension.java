package com.alibaba.griver.core.extensions;

import com.alibaba.griver.api.common.network.HttpRequest;
import com.alibaba.griver.api.common.network.HttpResponse;
import com.alibaba.griver.base.common.bridge.GriverHttpRequestAPIExtension;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.network.GriverTransport;

/* loaded from: classes6.dex */
public class DefaultHttpRequestAPIExtension implements GriverHttpRequestAPIExtension {
    @Override // com.alibaba.griver.base.common.bridge.GriverHttpRequestAPIExtension
    public HttpResponse performRequest(HttpRequest httpRequest) {
        GriverLogger.d("DefaultHttpRequestAPIExtension", "perform http request");
        return GriverTransport.request(httpRequest);
    }

    @Override // com.alibaba.griver.base.common.bridge.GriverHttpRequestAPIExtension
    public HttpResponse performRequest(GriverHttpRequestAPIExtension.RequestContext requestContext, HttpRequest httpRequest) {
        GriverLogger.d("DefaultHttpRequestAPIExtension", "perform http request");
        return GriverTransport.request(httpRequest);
    }
}
