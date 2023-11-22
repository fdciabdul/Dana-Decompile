package com.alipay.android.phone.mobilesdk.socketcraft;

import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;

/* loaded from: classes6.dex */
public interface WrappedByteChannel extends ByteChannel {
    boolean isBlocking();

    boolean isNeedRead();

    boolean isNeedWrite();

    int readMore(ByteBuffer byteBuffer);

    void writeMore();
}
