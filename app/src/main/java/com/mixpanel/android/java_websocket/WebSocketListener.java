package com.mixpanel.android.java_websocket;

import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.framing.Framedata;
import com.mixpanel.android.java_websocket.handshake.Handshakedata;
import com.mixpanel.android.java_websocket.handshake.ServerHandshakeBuilder;
import java.net.InetSocketAddress;

/* loaded from: classes3.dex */
public interface WebSocketListener {
    void BuiltInFictitiousFunctionClassFactory(Handshakedata handshakedata);

    void KClassImpl$Data$declaredNonStaticMembers$2(int i, String str);

    void KClassImpl$Data$declaredNonStaticMembers$2(WebSocket webSocket, Framedata framedata);

    ServerHandshakeBuilder PlaceComponentResult() throws InvalidDataException;

    void PlaceComponentResult(String str);

    String getAuthRequestContext(WebSocket webSocket) throws InvalidDataException;

    InetSocketAddress getAuthRequestContext();

    void getAuthRequestContext(Exception exc);
}
