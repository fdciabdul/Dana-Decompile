package com.alipay.android.phone.mobilesdk.socketcraft.framing;

import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public interface Framedata {

    /* loaded from: classes6.dex */
    public enum Opcode {
        CONTINUOUS,
        TEXT,
        BINARY,
        PING,
        PONG,
        CLOSING
    }

    void append(Framedata framedata);

    Opcode getOpcode();

    ByteBuffer getPayloadData();

    boolean getTransfereMasked();

    boolean isFin();
}
