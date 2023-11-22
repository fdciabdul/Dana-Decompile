package okhttp3.internal.ws;

import java.io.IOException;
import java.util.Random;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.Sink;
import okio.Timeout;

/* loaded from: classes9.dex */
final class WebSocketWriter {
    boolean activeWriter;
    final Buffer buffer = new Buffer();
    final FrameSink frameSink = new FrameSink();
    final boolean isClient;
    private final Buffer.UnsafeCursor maskCursor;
    private final byte[] maskKey;
    final Random random;
    final BufferedSink sink;
    final Buffer sinkBuffer;
    boolean writerClosed;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSocketWriter(boolean z, BufferedSink bufferedSink, Random random) {
        if (bufferedSink == null) {
            throw new NullPointerException("sink == null");
        }
        if (random == null) {
            throw new NullPointerException("random == null");
        }
        this.isClient = z;
        this.sink = bufferedSink;
        this.sinkBuffer = bufferedSink.KClassImpl$Data$declaredNonStaticMembers$2();
        this.random = random;
        this.maskKey = z ? new byte[4] : null;
        this.maskCursor = z ? new Buffer.UnsafeCursor() : null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void writePing(ByteString byteString) throws IOException {
        writeControlFrame(9, byteString);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void writePong(ByteString byteString) throws IOException {
        writeControlFrame(10, byteString);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void writeClose(int i, ByteString byteString) throws IOException {
        ByteString byteString2 = ByteString.EMPTY;
        if (i != 0 || byteString != null) {
            if (i != 0) {
                WebSocketProtocol.validateCloseCode(i);
            }
            Buffer buffer = new Buffer();
            buffer.moveToNextValue(i);
            if (byteString != null) {
                if (byteString == null) {
                    throw new IllegalArgumentException("byteString == null");
                }
                byteString.write(buffer);
            }
            byteString2 = new ByteString(buffer.NetworkUserEntityData$$ExternalSyntheticLambda1());
        }
        try {
            writeControlFrame(8, byteString2);
        } finally {
            this.writerClosed = true;
        }
    }

    private void writeControlFrame(int i, ByteString byteString) throws IOException {
        if (this.writerClosed) {
            throw new IOException("closed");
        }
        int size = byteString.size();
        if (size > 125) {
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        this.sinkBuffer.PlaceComponentResult(i | 128);
        if (this.isClient) {
            this.sinkBuffer.PlaceComponentResult(size | 128);
            this.random.nextBytes(this.maskKey);
            Buffer buffer = this.sinkBuffer;
            byte[] bArr = this.maskKey;
            if (bArr == null) {
                throw new IllegalArgumentException("source == null");
            }
            buffer.MyBillsEntityDataFactory(bArr, 0, bArr.length);
            if (size > 0) {
                long j = this.sinkBuffer.getAuthRequestContext;
                Buffer buffer2 = this.sinkBuffer;
                if (byteString == null) {
                    throw new IllegalArgumentException("byteString == null");
                }
                byteString.write(buffer2);
                Buffer buffer3 = this.sinkBuffer;
                Buffer.UnsafeCursor unsafeCursor = this.maskCursor;
                if (unsafeCursor.PlaceComponentResult != null) {
                    throw new IllegalStateException("already attached to a buffer");
                }
                unsafeCursor.PlaceComponentResult = buffer3;
                unsafeCursor.BuiltInFictitiousFunctionClassFactory = true;
                this.maskCursor.MyBillsEntityDataFactory(j);
                WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        } else {
            this.sinkBuffer.PlaceComponentResult(size);
            Buffer buffer4 = this.sinkBuffer;
            if (byteString == null) {
                throw new IllegalArgumentException("byteString == null");
            }
            byteString.write(buffer4);
        }
        this.sink.flush();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Sink newMessageSink(int i, long j) {
        if (this.activeWriter) {
            throw new IllegalStateException("Another message writer is active. Did you call close()?");
        }
        this.activeWriter = true;
        this.frameSink.formatOpcode = i;
        this.frameSink.contentLength = j;
        this.frameSink.isFirstFrame = true;
        this.frameSink.closed = false;
        return this.frameSink;
    }

    final void writeMessageFrame(int i, long j, boolean z, boolean z2) throws IOException {
        if (this.writerClosed) {
            throw new IOException("closed");
        }
        if (!z) {
            i = 0;
        }
        if (z2) {
            i |= 128;
        }
        this.sinkBuffer.PlaceComponentResult(i);
        int i2 = this.isClient ? 128 : 0;
        if (j <= 125) {
            this.sinkBuffer.PlaceComponentResult(i2 | ((int) j));
        } else if (j <= 65535) {
            this.sinkBuffer.PlaceComponentResult(i2 | 126);
            this.sinkBuffer.moveToNextValue((int) j);
        } else {
            this.sinkBuffer.PlaceComponentResult(i2 | 127);
            this.sinkBuffer.initRecordTimeStamp(j);
        }
        if (this.isClient) {
            this.random.nextBytes(this.maskKey);
            Buffer buffer = this.sinkBuffer;
            byte[] bArr = this.maskKey;
            if (bArr == null) {
                throw new IllegalArgumentException("source == null");
            }
            buffer.MyBillsEntityDataFactory(bArr, 0, bArr.length);
            if (j > 0) {
                long j2 = this.sinkBuffer.getAuthRequestContext;
                this.sinkBuffer.write(this.buffer, j);
                Buffer buffer2 = this.sinkBuffer;
                Buffer.UnsafeCursor unsafeCursor = this.maskCursor;
                if (unsafeCursor.PlaceComponentResult != null) {
                    throw new IllegalStateException("already attached to a buffer");
                }
                unsafeCursor.PlaceComponentResult = buffer2;
                unsafeCursor.BuiltInFictitiousFunctionClassFactory = true;
                this.maskCursor.MyBillsEntityDataFactory(j2);
                WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        } else {
            this.sinkBuffer.write(this.buffer, j);
        }
        this.sink.PlaceComponentResult();
    }

    /* loaded from: classes9.dex */
    final class FrameSink implements Sink {
        boolean closed;
        long contentLength;
        int formatOpcode;
        boolean isFirstFrame;

        FrameSink() {
        }

        @Override // okio.Sink
        public final void write(Buffer buffer, long j) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            }
            WebSocketWriter.this.buffer.write(buffer, j);
            boolean z = this.isFirstFrame && this.contentLength != -1 && WebSocketWriter.this.buffer.getAuthRequestContext > this.contentLength - 8192;
            long MyBillsEntityDataFactory = WebSocketWriter.this.buffer.MyBillsEntityDataFactory();
            if (MyBillsEntityDataFactory <= 0 || z) {
                return;
            }
            WebSocketWriter.this.writeMessageFrame(this.formatOpcode, MyBillsEntityDataFactory, this.isFirstFrame, false);
            this.isFirstFrame = false;
        }

        @Override // okio.Sink, java.io.Flushable
        public final void flush() throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            }
            WebSocketWriter webSocketWriter = WebSocketWriter.this;
            webSocketWriter.writeMessageFrame(this.formatOpcode, webSocketWriter.buffer.getAuthRequestContext, this.isFirstFrame, false);
            this.isFirstFrame = false;
        }

        @Override // okio.Sink
        public final Timeout timeout() {
            return WebSocketWriter.this.sink.timeout();
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            }
            WebSocketWriter webSocketWriter = WebSocketWriter.this;
            webSocketWriter.writeMessageFrame(this.formatOpcode, webSocketWriter.buffer.getAuthRequestContext, this.isFirstFrame, true);
            this.closed = true;
            WebSocketWriter.this.activeWriter = false;
        }
    }
}
