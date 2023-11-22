package com.mixpanel.android.java_websocket;

import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.exceptions.InvalidHandshakeException;
import com.mixpanel.android.java_websocket.framing.Framedata;
import com.mixpanel.android.java_websocket.framing.FramedataImpl1;
import com.mixpanel.android.java_websocket.handshake.HandshakeImpl1Server;
import com.mixpanel.android.java_websocket.handshake.ServerHandshakeBuilder;
import java.net.InetSocketAddress;

/* loaded from: classes3.dex */
public abstract class WebSocketAdapter implements WebSocketListener {
    @Override // com.mixpanel.android.java_websocket.WebSocketListener
    public final ServerHandshakeBuilder PlaceComponentResult() throws InvalidDataException {
        return new HandshakeImpl1Server();
    }

    @Override // com.mixpanel.android.java_websocket.WebSocketListener
    public final void KClassImpl$Data$declaredNonStaticMembers$2(WebSocket webSocket, Framedata framedata) {
        FramedataImpl1 framedataImpl1 = new FramedataImpl1(framedata);
        framedataImpl1.getAuthRequestContext(Framedata.Opcode.PONG);
        webSocket.getAuthRequestContext(framedataImpl1);
    }

    @Override // com.mixpanel.android.java_websocket.WebSocketListener
    public final String getAuthRequestContext(WebSocket webSocket) throws InvalidDataException {
        InetSocketAddress BuiltInFictitiousFunctionClassFactory = webSocket.BuiltInFictitiousFunctionClassFactory();
        if (BuiltInFictitiousFunctionClassFactory == null) {
            throw new InvalidHandshakeException("socket not bound");
        }
        StringBuffer stringBuffer = new StringBuffer(90);
        stringBuffer.append("<cross-domain-policy><allow-access-from domain=\"*\" to-ports=\"");
        stringBuffer.append(BuiltInFictitiousFunctionClassFactory.getPort());
        stringBuffer.append("\" /></cross-domain-policy>\u0000");
        return stringBuffer.toString();
    }
}
