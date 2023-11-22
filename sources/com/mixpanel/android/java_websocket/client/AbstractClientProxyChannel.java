package com.mixpanel.android.java_websocket.client;

import com.mixpanel.android.java_websocket.AbstractWrappedByteChannel;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public abstract class AbstractClientProxyChannel extends AbstractWrappedByteChannel {
    protected final ByteBuffer KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // com.mixpanel.android.java_websocket.AbstractWrappedByteChannel, java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (!this.KClassImpl$Data$declaredNonStaticMembers$2.hasRemaining()) {
            return super.write(byteBuffer);
        }
        return super.write(this.KClassImpl$Data$declaredNonStaticMembers$2);
    }
}
