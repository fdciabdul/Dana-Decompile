package com.alipay.android.phone.mobilesdk.socketcraft.client;

import com.alipay.android.phone.mobilesdk.socketcraft.AbstractWrappedByteChannel;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;

/* loaded from: classes6.dex */
public abstract class AbstractClientProxyChannel extends AbstractWrappedByteChannel {
    protected final ByteBuffer proxyHandshake;

    public abstract String buildHandShake();

    public AbstractClientProxyChannel(ByteChannel byteChannel) {
        super(byteChannel);
        try {
            this.proxyHandshake = ByteBuffer.wrap(buildHandShake().getBytes("ASCII"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.AbstractWrappedByteChannel, java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        if (!this.proxyHandshake.hasRemaining()) {
            return super.write(byteBuffer);
        }
        return super.write(this.proxyHandshake);
    }
}
