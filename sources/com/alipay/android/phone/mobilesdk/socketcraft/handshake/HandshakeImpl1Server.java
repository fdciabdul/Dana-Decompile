package com.alipay.android.phone.mobilesdk.socketcraft.handshake;

/* loaded from: classes6.dex */
public class HandshakeImpl1Server extends HandshakedataImpl1 implements ServerHandshakeBuilder {

    /* renamed from: a  reason: collision with root package name */
    private short f6907a;
    private String b;

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.handshake.ServerHandshake
    public String getHttpStatusMessage() {
        return this.b;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.handshake.ServerHandshake
    public short getHttpStatus() {
        return this.f6907a;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.handshake.ServerHandshakeBuilder
    public void setHttpStatusMessage(String str) {
        this.b = str;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.handshake.ServerHandshakeBuilder
    public void setHttpStatus(short s) {
        this.f6907a = s;
    }
}
