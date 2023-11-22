package com.alibaba.ariver.resource.api.content;

import com.alibaba.ariver.engine.api.resources.Resource;

/* loaded from: classes2.dex */
public interface ResourceProvider {
    public static final String H5_BRIDGE = "https://a.alipayobjects.com/bridgeapi/1.0/jsready.js";
    public static final String UN_SAFE = "https://alipay.com/h5container/un_safe.html";

    Resource getContent(ResourceQuery resourceQuery);

    Resource getContent(String str);

    String getFallbackUrl(String str);

    Resource getLocalResource(String str);

    Resource getRawResource(ResourceQuery resourceQuery);

    boolean hasInputException();

    boolean isLocal();

    void mapContent(String str, Resource resource);

    void releaseContent();

    void setFallbackCache(String str, byte[] bArr);
}
