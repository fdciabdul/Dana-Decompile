package com.mixpanel.android.java_websocket.handshake;

/* loaded from: classes3.dex */
public class HandshakeImpl1Client extends HandshakedataImpl1 implements ClientHandshakeBuilder {
    public String PlaceComponentResult = "*";

    @Override // com.mixpanel.android.java_websocket.handshake.ClientHandshakeBuilder
    public final void PlaceComponentResult(String str) throws IllegalArgumentException {
        if (str == null) {
            throw new IllegalArgumentException("http resource descriptor must not be null");
        }
        this.PlaceComponentResult = str;
    }

    @Override // com.mixpanel.android.java_websocket.handshake.ClientHandshake
    public final String getAuthRequestContext() {
        return this.PlaceComponentResult;
    }
}
