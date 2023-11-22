package com.alibaba.griver.base.common.bridge;

import com.alibaba.griver.api.appinfo.GriverAppTypeEnum;
import com.alibaba.griver.api.common.GriverExtension;
import com.alibaba.griver.api.common.network.HttpRequest;
import com.alibaba.griver.api.common.network.HttpResponse;

/* loaded from: classes.dex */
public interface GriverHttpRequestAPIExtension extends GriverExtension {

    /* loaded from: classes2.dex */
    public static class RequestContext {
        public String appId;
        public GriverAppTypeEnum appType;
    }

    @Deprecated
    HttpResponse performRequest(HttpRequest httpRequest);

    HttpResponse performRequest(RequestContext requestContext, HttpRequest httpRequest);
}
