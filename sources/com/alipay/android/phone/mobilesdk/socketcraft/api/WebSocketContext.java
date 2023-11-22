package com.alipay.android.phone.mobilesdk.socketcraft.api;

/* loaded from: classes6.dex */
public interface WebSocketContext {
    public static final String RESERVED_PREFIX = "ws.";

    void clear();

    Object getAttribute(String str);

    Object removeAttribute(String str);

    void setAttribute(String str, Object obj);
}
