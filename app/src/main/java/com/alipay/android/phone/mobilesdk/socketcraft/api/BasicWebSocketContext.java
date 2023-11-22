package com.alipay.android.phone.mobilesdk.socketcraft.api;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class BasicWebSocketContext implements WebSocketContext {

    /* renamed from: a  reason: collision with root package name */
    private final WebSocketContext f6897a;
    private Map b;

    public BasicWebSocketContext() {
        this(null);
    }

    public BasicWebSocketContext(WebSocketContext webSocketContext) {
        this.b = null;
        this.f6897a = webSocketContext;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.api.WebSocketContext
    public Object getAttribute(String str) {
        WebSocketContext webSocketContext;
        if (str == null) {
            throw new IllegalArgumentException("Id may not be null");
        }
        Map map = this.b;
        Object obj = map != null ? map.get(str) : null;
        return (obj != null || (webSocketContext = this.f6897a) == null) ? obj : webSocketContext.getAttribute(str);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.api.WebSocketContext
    public void setAttribute(String str, Object obj) {
        if (str == null) {
            throw new IllegalArgumentException("Id may not be null");
        }
        if (this.b == null) {
            this.b = new HashMap();
        }
        this.b.put(str, obj);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.api.WebSocketContext
    public Object removeAttribute(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Id may not be null");
        }
        Map map = this.b;
        if (map != null) {
            return map.remove(str);
        }
        return null;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.api.WebSocketContext
    public void clear() {
        Map map = this.b;
        if (map != null) {
            map.clear();
        }
        WebSocketContext webSocketContext = this.f6897a;
        if (webSocketContext != null) {
            webSocketContext.clear();
        }
    }
}
