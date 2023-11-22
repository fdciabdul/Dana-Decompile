package com.alipay.android.phone.mobilesdk.socketcraft;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLSession;

/* loaded from: classes6.dex */
public class SSLSocketChannel2 implements WrappedByteChannel, ByteChannel {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected int bufferallocations = 0;
    protected ExecutorService exec;
    protected ByteBuffer inCrypt;
    protected ByteBuffer inData;
    protected ByteBuffer outCrypt;
    protected SSLEngineResult readEngineResult;
    protected SelectionKey selectionKey;
    protected SocketChannel socketChannel;
    protected SSLEngine sslEngine;
    protected List<Future<?>> tasks;
    protected SSLEngineResult writeEngineResult;
    public static final byte[] MyBillsEntityDataFactory = {37, 81, 122, 15, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int BuiltInFictitiousFunctionClassFactory = 208;
    protected static ByteBuffer emptybuffer = ByteBuffer.allocate(0);

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void d(int r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 + 4
            int r6 = r6 * 7
            int r6 = r6 + 99
            int r7 = r7 * 3
            int r7 = 16 - r7
            byte[] r0 = com.alipay.android.phone.mobilesdk.socketcraft.SSLSocketChannel2.MyBillsEntityDataFactory
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L34
        L19:
            r3 = 0
        L1a:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r7) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            int r3 = r3 + 1
            int r8 = r8 + 1
            r4 = r0[r8]
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L34:
            int r8 = -r8
            int r6 = r6 + r8
            int r6 = r6 + 2
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.android.phone.mobilesdk.socketcraft.SSLSocketChannel2.d(int, short, int, java.lang.Object[]):void");
    }

    public SSLSocketChannel2(SocketChannel socketChannel, SSLEngine sSLEngine, ExecutorService executorService, SelectionKey selectionKey) {
        if (socketChannel == null || sSLEngine == null || executorService == null) {
            throw new IllegalArgumentException("parameter must not be null");
        }
        this.socketChannel = socketChannel;
        this.sslEngine = sSLEngine;
        this.exec = executorService;
        SSLEngineResult sSLEngineResult = new SSLEngineResult(SSLEngineResult.Status.BUFFER_UNDERFLOW, sSLEngine.getHandshakeStatus(), 0, 0);
        this.writeEngineResult = sSLEngineResult;
        this.readEngineResult = sSLEngineResult;
        this.tasks = new ArrayList(3);
        if (selectionKey != null) {
            selectionKey.interestOps(selectionKey.interestOps() | 4);
            this.selectionKey = selectionKey;
        }
        createBuffers(sSLEngine.getSession());
        this.socketChannel.write(a(emptybuffer));
        a();
    }

    private void a(Future<?> future) {
        boolean z = false;
        while (true) {
            try {
                try {
                    future.get();
                    break;
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }
            } catch (InterruptedException unused) {
                z = true;
            }
        }
        if (z) {
            try {
                byte b = (byte) (-MyBillsEntityDataFactory[15]);
                Object[] objArr = new Object[1];
                d(b, (byte) (b - 1), MyBillsEntityDataFactory[16], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                d((byte) (MyBillsEntityDataFactory[15] + 1), (byte) (-MyBillsEntityDataFactory[15]), MyBillsEntityDataFactory[15], objArr2);
                ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).interrupt();
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
    }

    private void a() {
        synchronized (this) {
            if (this.sslEngine.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING) {
                return;
            }
            if (!this.tasks.isEmpty()) {
                Iterator<Future<?>> it = this.tasks.iterator();
                while (it.hasNext()) {
                    Future<?> next = it.next();
                    if (next.isDone()) {
                        it.remove();
                    } else {
                        if (isBlocking()) {
                            a(next);
                        }
                        return;
                    }
                }
            }
            if (this.sslEngine.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NEED_UNWRAP) {
                if (!isBlocking() || this.readEngineResult.getStatus() == SSLEngineResult.Status.BUFFER_UNDERFLOW) {
                    this.inCrypt.compact();
                    if (this.socketChannel.read(this.inCrypt) == -1) {
                        throw new IOException("connection closed unexpectedly by peer");
                    }
                    this.inCrypt.flip();
                }
                this.inData.compact();
                b();
                if (this.readEngineResult.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.FINISHED) {
                    createBuffers(this.sslEngine.getSession());
                    return;
                }
            }
            consumeDelegatedTasks();
            if (this.tasks.isEmpty() || this.sslEngine.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NEED_WRAP) {
                this.socketChannel.write(a(emptybuffer));
                if (this.writeEngineResult.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.FINISHED) {
                    createBuffers(this.sslEngine.getSession());
                    return;
                }
            }
            this.bufferallocations = 1;
        }
    }

    private ByteBuffer a(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        synchronized (this) {
            this.outCrypt.compact();
            this.writeEngineResult = this.sslEngine.wrap(byteBuffer, this.outCrypt);
            this.outCrypt.flip();
            byteBuffer2 = this.outCrypt;
        }
        return byteBuffer2;
    }

    private ByteBuffer b() {
        ByteBuffer byteBuffer;
        synchronized (this) {
            while (true) {
                int remaining = this.inData.remaining();
                SSLEngineResult unwrap = this.sslEngine.unwrap(this.inCrypt, this.inData);
                this.readEngineResult = unwrap;
                if (unwrap.getStatus() != SSLEngineResult.Status.OK || (remaining == this.inData.remaining() && this.sslEngine.getHandshakeStatus() != SSLEngineResult.HandshakeStatus.NEED_UNWRAP)) {
                    break;
                }
            }
            this.inData.flip();
            byteBuffer = this.inData;
        }
        return byteBuffer;
    }

    protected void consumeDelegatedTasks() {
        while (true) {
            Runnable delegatedTask = this.sslEngine.getDelegatedTask();
            if (delegatedTask == null) {
                return;
            }
            this.tasks.add(this.exec.submit(delegatedTask));
        }
    }

    protected void createBuffers(SSLSession sSLSession) {
        int packetBufferSize = sSLSession.getPacketBufferSize();
        int max = Math.max(sSLSession.getApplicationBufferSize(), packetBufferSize);
        ByteBuffer byteBuffer = this.inData;
        if (byteBuffer == null) {
            this.inData = ByteBuffer.allocate(max);
            this.outCrypt = ByteBuffer.allocate(packetBufferSize);
            this.inCrypt = ByteBuffer.allocate(packetBufferSize);
        } else {
            if (byteBuffer.capacity() != max) {
                this.inData = ByteBuffer.allocate(max);
            }
            if (this.outCrypt.capacity() != packetBufferSize) {
                this.outCrypt = ByteBuffer.allocate(packetBufferSize);
            }
            if (this.inCrypt.capacity() != packetBufferSize) {
                this.inCrypt = ByteBuffer.allocate(packetBufferSize);
            }
        }
        this.inData.rewind();
        this.inData.flip();
        this.inCrypt.rewind();
        this.inCrypt.flip();
        this.outCrypt.rewind();
        this.outCrypt.flip();
        this.bufferallocations++;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        if (!c()) {
            a();
            return 0;
        }
        int write = this.socketChannel.write(a(byteBuffer));
        if (this.writeEngineResult.getStatus() != SSLEngineResult.Status.CLOSED) {
            return write;
        }
        throw new EOFException("Connection is closed");
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            if (!c()) {
                if (isBlocking()) {
                    while (!c()) {
                        a();
                    }
                } else {
                    a();
                    if (!c()) {
                        return 0;
                    }
                }
            }
            int b = b(byteBuffer);
            if (b != 0) {
                return b;
            }
            this.inData.clear();
            if (!this.inCrypt.hasRemaining()) {
                this.inCrypt.clear();
            } else {
                this.inCrypt.compact();
            }
            if ((isBlocking() || this.readEngineResult.getStatus() == SSLEngineResult.Status.BUFFER_UNDERFLOW) && this.socketChannel.read(this.inCrypt) == -1) {
                return -1;
            }
            this.inCrypt.flip();
            b();
            int a2 = a(this.inData, byteBuffer);
            return (a2 == 0 && isBlocking()) ? read(byteBuffer) : a2;
        }
        return 0;
    }

    private int b(ByteBuffer byteBuffer) {
        if (this.inData.hasRemaining()) {
            return a(this.inData, byteBuffer);
        }
        if (!this.inData.hasRemaining()) {
            this.inData.clear();
        }
        if (this.inCrypt.hasRemaining()) {
            b();
            int a2 = a(this.inData, byteBuffer);
            if (this.readEngineResult.getStatus() == SSLEngineResult.Status.CLOSED) {
                return -1;
            }
            if (a2 > 0) {
                return a2;
            }
            return 0;
        }
        return 0;
    }

    public boolean isConnected() {
        return this.socketChannel.isConnected();
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.sslEngine.closeOutbound();
        this.sslEngine.getSession().invalidate();
        if (this.socketChannel.isOpen()) {
            this.socketChannel.write(a(emptybuffer));
        }
        this.socketChannel.close();
        this.exec.shutdownNow();
    }

    private boolean c() {
        SSLEngineResult.HandshakeStatus handshakeStatus = this.sslEngine.getHandshakeStatus();
        return handshakeStatus == SSLEngineResult.HandshakeStatus.FINISHED || handshakeStatus == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
    }

    public SelectableChannel configureBlocking(boolean z) {
        return this.socketChannel.configureBlocking(z);
    }

    public boolean connect(SocketAddress socketAddress) {
        return this.socketChannel.connect(socketAddress);
    }

    public boolean finishConnect() {
        return this.socketChannel.finishConnect();
    }

    public Socket socket() {
        return this.socketChannel.socket();
    }

    public boolean isInboundDone() {
        return this.sslEngine.isInboundDone();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.socketChannel.isOpen();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WrappedByteChannel
    public boolean isNeedWrite() {
        return this.outCrypt.hasRemaining() || !c();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WrappedByteChannel
    public void writeMore() {
        write(this.outCrypt);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WrappedByteChannel
    public boolean isNeedRead() {
        if (this.inData.hasRemaining()) {
            return true;
        }
        return (!this.inCrypt.hasRemaining() || this.readEngineResult.getStatus() == SSLEngineResult.Status.BUFFER_UNDERFLOW || this.readEngineResult.getStatus() == SSLEngineResult.Status.CLOSED) ? false : true;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WrappedByteChannel
    public int readMore(ByteBuffer byteBuffer) {
        return b(byteBuffer);
    }

    private int a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        int remaining = byteBuffer.remaining();
        int remaining2 = byteBuffer2.remaining();
        if (remaining > remaining2) {
            int min = Math.min(remaining, remaining2);
            for (int i = 0; i < min; i++) {
                byteBuffer2.put(byteBuffer.get());
            }
            return min;
        }
        byteBuffer2.put(byteBuffer);
        return remaining;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WrappedByteChannel
    public boolean isBlocking() {
        return this.socketChannel.isBlocking();
    }
}
