package com.mixpanel.android.java_websocket.drafts;

import com.google.common.net.HttpHeaders;
import com.mixpanel.android.java_websocket.drafts.Draft;
import com.mixpanel.android.java_websocket.exceptions.InvalidHandshakeException;
import com.mixpanel.android.java_websocket.handshake.ClientHandshake;
import com.mixpanel.android.java_websocket.handshake.ClientHandshakeBuilder;

/* loaded from: classes3.dex */
public class Draft_17 extends Draft_10 {
    @Override // com.mixpanel.android.java_websocket.drafts.Draft_10, com.mixpanel.android.java_websocket.drafts.Draft
    public final Draft.HandshakeState getAuthRequestContext(ClientHandshake clientHandshake) throws InvalidHandshakeException {
        if (KClassImpl$Data$declaredNonStaticMembers$2(clientHandshake) == 13) {
            return Draft.HandshakeState.MATCHED;
        }
        return Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft_10, com.mixpanel.android.java_websocket.drafts.Draft
    public final ClientHandshakeBuilder getAuthRequestContext(ClientHandshakeBuilder clientHandshakeBuilder) {
        super.getAuthRequestContext(clientHandshakeBuilder);
        clientHandshakeBuilder.PlaceComponentResult(HttpHeaders.SEC_WEBSOCKET_VERSION, "13");
        return clientHandshakeBuilder;
    }

    @Override // com.mixpanel.android.java_websocket.drafts.Draft_10, com.mixpanel.android.java_websocket.drafts.Draft
    public final Draft getAuthRequestContext() {
        return new Draft_17();
    }
}
