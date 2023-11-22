package com.mixpanel.android.java_websocket;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;

/* loaded from: classes8.dex */
public class AbstractWrappedByteChannel implements WrappedByteChannel {
    private final ByteChannel MyBillsEntityDataFactory;

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        return this.MyBillsEntityDataFactory.read(byteBuffer);
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.MyBillsEntityDataFactory.isOpen();
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.MyBillsEntityDataFactory.close();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        return this.MyBillsEntityDataFactory.write(byteBuffer);
    }
}
