package com.alipay.android.phone.mobilesdk.socketcraft.api;

import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public interface WebSocketCallback {
    void onSocketClose();

    void onSocketError(String str);

    void onSocketMessage(String str);

    void onSocketMessage(ByteBuffer byteBuffer);

    void onSocketOpen();
}
