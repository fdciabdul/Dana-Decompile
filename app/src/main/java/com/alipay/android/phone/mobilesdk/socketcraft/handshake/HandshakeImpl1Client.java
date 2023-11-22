package com.alipay.android.phone.mobilesdk.socketcraft.handshake;

/* loaded from: classes6.dex */
public class HandshakeImpl1Client extends HandshakedataImpl1 implements ClientHandshakeBuilder {

    /* renamed from: a  reason: collision with root package name */
    private String f6906a = "*";

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.handshake.ClientHandshakeBuilder
    public void setResourceDescriptor(String str) {
        if (str == null) {
            throw new IllegalArgumentException("http resource descriptor must not be null");
        }
        this.f6906a = str;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.handshake.ClientHandshake
    public String getResourceDescriptor() {
        return this.f6906a;
    }
}
