package com.alibaba.ariver.websocket.core;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.websocket.proxy.RVWebSocketProxy;
import java.net.URI;
import java.util.Map;

/* loaded from: classes6.dex */
public class DefaultWebSocketProxyImpl implements RVWebSocketProxy {
    @Override // com.alibaba.ariver.websocket.proxy.RVWebSocketProxy
    public RVWebSocketClient createWebSocketClient(String str, String str2, Map<String, String> map, RVWebSocketCallback rVWebSocketCallback) {
        URI uri;
        try {
            uri = URI.create(str2);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("URI create error! url: ");
            sb.append(str2);
            RVLogger.e("AriverWebSocket:DefaultWebSocketProxyImpl", sb.toString(), e);
            uri = null;
        }
        if (uri == null) {
            return null;
        }
        return new DefaultRVWebSocketClient(str, uri, map, rVWebSocketCallback);
    }
}
