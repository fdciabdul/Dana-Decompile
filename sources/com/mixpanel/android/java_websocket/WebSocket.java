package com.mixpanel.android.java_websocket;

import com.mixpanel.android.java_websocket.framing.Framedata;
import java.net.InetSocketAddress;

/* loaded from: classes3.dex */
public interface WebSocket {

    /* loaded from: classes3.dex */
    public enum READYSTATE {
        NOT_YET_CONNECTED,
        CONNECTING,
        OPEN,
        CLOSING,
        CLOSED
    }

    /* loaded from: classes3.dex */
    public enum Role {
        CLIENT,
        SERVER
    }

    InetSocketAddress BuiltInFictitiousFunctionClassFactory();

    void getAuthRequestContext(Framedata framedata);
}
