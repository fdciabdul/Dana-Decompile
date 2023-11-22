package com.mixpanel.android.java_websocket.handshake;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

/* loaded from: classes3.dex */
public class HandshakedataImpl1 implements HandshakeBuilder {
    private byte[] MyBillsEntityDataFactory;
    public TreeMap<String, String> getAuthRequestContext = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    @Override // com.mixpanel.android.java_websocket.handshake.Handshakedata
    public final Iterator<String> BuiltInFictitiousFunctionClassFactory() {
        return Collections.unmodifiableSet(this.getAuthRequestContext.keySet()).iterator();
    }

    @Override // com.mixpanel.android.java_websocket.handshake.Handshakedata
    public final String MyBillsEntityDataFactory(String str) {
        String str2 = this.getAuthRequestContext.get(str);
        return str2 == null ? "" : str2;
    }

    @Override // com.mixpanel.android.java_websocket.handshake.Handshakedata
    public final byte[] PlaceComponentResult() {
        return this.MyBillsEntityDataFactory;
    }

    @Override // com.mixpanel.android.java_websocket.handshake.HandshakeBuilder
    public final void BuiltInFictitiousFunctionClassFactory(byte[] bArr) {
        this.MyBillsEntityDataFactory = bArr;
    }

    @Override // com.mixpanel.android.java_websocket.handshake.HandshakeBuilder
    public final void PlaceComponentResult(String str, String str2) {
        this.getAuthRequestContext.put(str, str2);
    }

    @Override // com.mixpanel.android.java_websocket.handshake.Handshakedata
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        return this.getAuthRequestContext.containsKey(str);
    }
}
