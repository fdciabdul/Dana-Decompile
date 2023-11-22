package com.alipay.android.phone.mobilesdk.socketcraft;

import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SocketChannel;

/* loaded from: classes6.dex */
public class AbstractWrappedByteChannel implements WrappedByteChannel {

    /* renamed from: a  reason: collision with root package name */
    private final ByteChannel f6895a;

    public AbstractWrappedByteChannel(ByteChannel byteChannel) {
        this.f6895a = byteChannel;
    }

    public AbstractWrappedByteChannel(WrappedByteChannel wrappedByteChannel) {
        this.f6895a = wrappedByteChannel;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        return this.f6895a.read(byteBuffer);
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.f6895a.isOpen();
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f6895a.close();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        return this.f6895a.write(byteBuffer);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WrappedByteChannel
    public boolean isNeedWrite() {
        ByteChannel byteChannel = this.f6895a;
        if (byteChannel instanceof WrappedByteChannel) {
            return ((WrappedByteChannel) byteChannel).isNeedWrite();
        }
        return false;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WrappedByteChannel
    public void writeMore() {
        ByteChannel byteChannel = this.f6895a;
        if (byteChannel instanceof WrappedByteChannel) {
            ((WrappedByteChannel) byteChannel).writeMore();
        }
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WrappedByteChannel
    public boolean isNeedRead() {
        ByteChannel byteChannel = this.f6895a;
        if (byteChannel instanceof WrappedByteChannel) {
            return ((WrappedByteChannel) byteChannel).isNeedRead();
        }
        return false;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WrappedByteChannel
    public int readMore(ByteBuffer byteBuffer) {
        ByteChannel byteChannel = this.f6895a;
        if (byteChannel instanceof WrappedByteChannel) {
            return ((WrappedByteChannel) byteChannel).readMore(byteBuffer);
        }
        return 0;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WrappedByteChannel
    public boolean isBlocking() {
        ByteChannel byteChannel = this.f6895a;
        if (byteChannel instanceof SocketChannel) {
            return ((SocketChannel) byteChannel).isBlocking();
        }
        if (byteChannel instanceof WrappedByteChannel) {
            return ((WrappedByteChannel) byteChannel).isBlocking();
        }
        return false;
    }
}
