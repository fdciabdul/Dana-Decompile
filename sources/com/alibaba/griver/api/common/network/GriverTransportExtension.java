package com.alibaba.griver.api.common.network;

import com.alibaba.griver.api.common.GriverExtension;

/* loaded from: classes3.dex */
public interface GriverTransportExtension extends GriverExtension {
    HttpResponse request(HttpRequest httpRequest) throws Exception;
}
