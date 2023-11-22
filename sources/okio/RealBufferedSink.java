package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class RealBufferedSink implements BufferedSink {
    public final Buffer MyBillsEntityDataFactory = new Buffer();
    public final Sink PlaceComponentResult;
    boolean getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RealBufferedSink(Sink sink) {
        if (sink == null) {
            throw new NullPointerException("sink == null");
        }
        this.PlaceComponentResult = sink;
    }

    @Override // okio.BufferedSink
    public final Buffer KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }

    @Override // okio.Sink
    public final void write(Buffer buffer, long j) throws IOException {
        if (this.getAuthRequestContext) {
            throw new IllegalStateException("closed");
        }
        this.MyBillsEntityDataFactory.write(buffer, j);
        BuiltInFictitiousFunctionClassFactory();
    }

    @Override // okio.BufferedSink
    public final BufferedSink getAuthRequestContext(ByteString byteString) throws IOException {
        if (this.getAuthRequestContext) {
            throw new IllegalStateException("closed");
        }
        Buffer buffer = this.MyBillsEntityDataFactory;
        if (byteString == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        byteString.write(buffer);
        return BuiltInFictitiousFunctionClassFactory();
    }

    @Override // okio.BufferedSink
    public final BufferedSink BuiltInFictitiousFunctionClassFactory(String str) throws IOException {
        if (this.getAuthRequestContext) {
            throw new IllegalStateException("closed");
        }
        this.MyBillsEntityDataFactory.PlaceComponentResult(str, 0, str.length());
        return BuiltInFictitiousFunctionClassFactory();
    }

    @Override // okio.BufferedSink
    public final BufferedSink PlaceComponentResult(String str, int i, int i2) throws IOException {
        if (this.getAuthRequestContext) {
            throw new IllegalStateException("closed");
        }
        this.MyBillsEntityDataFactory.PlaceComponentResult(str, i, i2);
        return BuiltInFictitiousFunctionClassFactory();
    }

    @Override // okio.BufferedSink
    public final BufferedSink MyBillsEntityDataFactory(byte[] bArr) throws IOException {
        if (this.getAuthRequestContext) {
            throw new IllegalStateException("closed");
        }
        Buffer buffer = this.MyBillsEntityDataFactory;
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        buffer.MyBillsEntityDataFactory(bArr, 0, bArr.length);
        return BuiltInFictitiousFunctionClassFactory();
    }

    @Override // okio.BufferedSink
    public final BufferedSink MyBillsEntityDataFactory(byte[] bArr, int i, int i2) throws IOException {
        if (this.getAuthRequestContext) {
            throw new IllegalStateException("closed");
        }
        this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(bArr, i, i2);
        return BuiltInFictitiousFunctionClassFactory();
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) throws IOException {
        if (this.getAuthRequestContext) {
            throw new IllegalStateException("closed");
        }
        int write = this.MyBillsEntityDataFactory.write(byteBuffer);
        BuiltInFictitiousFunctionClassFactory();
        return write;
    }

    @Override // okio.BufferedSink
    public final long BuiltInFictitiousFunctionClassFactory(Source source) throws IOException {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long read = source.read(this.MyBillsEntityDataFactory, 8192L);
            if (read == -1) {
                return j;
            }
            j += read;
            BuiltInFictitiousFunctionClassFactory();
        }
    }

    @Override // okio.BufferedSink
    public final BufferedSink PlaceComponentResult(int i) throws IOException {
        if (this.getAuthRequestContext) {
            throw new IllegalStateException("closed");
        }
        this.MyBillsEntityDataFactory.PlaceComponentResult(i);
        return BuiltInFictitiousFunctionClassFactory();
    }

    @Override // okio.BufferedSink
    public final BufferedSink moveToNextValue(int i) throws IOException {
        if (this.getAuthRequestContext) {
            throw new IllegalStateException("closed");
        }
        this.MyBillsEntityDataFactory.moveToNextValue(i);
        return BuiltInFictitiousFunctionClassFactory();
    }

    @Override // okio.BufferedSink
    public final BufferedSink BuiltInFictitiousFunctionClassFactory(int i) throws IOException {
        if (this.getAuthRequestContext) {
            throw new IllegalStateException("closed");
        }
        this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(i);
        return BuiltInFictitiousFunctionClassFactory();
    }

    @Override // okio.BufferedSink
    public final BufferedSink scheduleImpl(int i) throws IOException {
        if (this.getAuthRequestContext) {
            throw new IllegalStateException("closed");
        }
        this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(Util.MyBillsEntityDataFactory(i));
        return BuiltInFictitiousFunctionClassFactory();
    }

    @Override // okio.BufferedSink
    public final BufferedSink moveToNextValue(long j) throws IOException {
        if (this.getAuthRequestContext) {
            throw new IllegalStateException("closed");
        }
        this.MyBillsEntityDataFactory.moveToNextValue(j);
        return BuiltInFictitiousFunctionClassFactory();
    }

    @Override // okio.BufferedSink
    public final BufferedSink GetContactSyncConfig(long j) throws IOException {
        if (this.getAuthRequestContext) {
            throw new IllegalStateException("closed");
        }
        this.MyBillsEntityDataFactory.GetContactSyncConfig(j);
        return BuiltInFictitiousFunctionClassFactory();
    }

    @Override // okio.BufferedSink
    public final BufferedSink BuiltInFictitiousFunctionClassFactory() throws IOException {
        if (this.getAuthRequestContext) {
            throw new IllegalStateException("closed");
        }
        long MyBillsEntityDataFactory = this.MyBillsEntityDataFactory.MyBillsEntityDataFactory();
        if (MyBillsEntityDataFactory > 0) {
            this.PlaceComponentResult.write(this.MyBillsEntityDataFactory, MyBillsEntityDataFactory);
        }
        return this;
    }

    @Override // okio.BufferedSink
    public final BufferedSink PlaceComponentResult() throws IOException {
        if (this.getAuthRequestContext) {
            throw new IllegalStateException("closed");
        }
        long j = this.MyBillsEntityDataFactory.getAuthRequestContext;
        if (j > 0) {
            this.PlaceComponentResult.write(this.MyBillsEntityDataFactory, j);
        }
        return this;
    }

    @Override // okio.BufferedSink
    public final OutputStream moveToNextValue() {
        return new OutputStream() { // from class: okio.RealBufferedSink.1
            @Override // java.io.OutputStream
            public void write(int i) throws IOException {
                if (RealBufferedSink.this.getAuthRequestContext) {
                    throw new IOException("closed");
                }
                RealBufferedSink.this.MyBillsEntityDataFactory.PlaceComponentResult((int) ((byte) i));
                RealBufferedSink.this.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) throws IOException {
                if (RealBufferedSink.this.getAuthRequestContext) {
                    throw new IOException("closed");
                }
                RealBufferedSink.this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(bArr, i, i2);
                RealBufferedSink.this.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() throws IOException {
                if (RealBufferedSink.this.getAuthRequestContext) {
                    return;
                }
                RealBufferedSink.this.flush();
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                RealBufferedSink.this.close();
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append(RealBufferedSink.this);
                sb.append(".outputStream()");
                return sb.toString();
            }
        };
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public final void flush() throws IOException {
        if (this.getAuthRequestContext) {
            throw new IllegalStateException("closed");
        }
        if (this.MyBillsEntityDataFactory.getAuthRequestContext > 0) {
            Sink sink = this.PlaceComponentResult;
            Buffer buffer = this.MyBillsEntityDataFactory;
            sink.write(buffer, buffer.getAuthRequestContext);
        }
        this.PlaceComponentResult.flush();
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.getAuthRequestContext;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.getAuthRequestContext) {
            return;
        }
        Throwable th = null;
        try {
            if (this.MyBillsEntityDataFactory.getAuthRequestContext > 0) {
                Sink sink = this.PlaceComponentResult;
                Buffer buffer = this.MyBillsEntityDataFactory;
                sink.write(buffer, buffer.getAuthRequestContext);
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.PlaceComponentResult.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.getAuthRequestContext = true;
        if (th != null) {
            Util.PlaceComponentResult(th);
        }
    }

    @Override // okio.Sink
    public final Timeout timeout() {
        return this.PlaceComponentResult.timeout();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("buffer(");
        sb.append(this.PlaceComponentResult);
        sb.append(")");
        return sb.toString();
    }
}
