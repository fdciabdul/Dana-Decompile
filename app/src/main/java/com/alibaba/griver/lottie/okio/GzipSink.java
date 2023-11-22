package com.alibaba.griver.lottie.okio;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

/* loaded from: classes6.dex */
public final class GzipSink implements Sink {
    private boolean closed;
    private final CRC32 crc = new CRC32();
    private final Deflater deflater;
    private final DeflaterSink deflaterSink;
    private final BufferedSink sink;

    public GzipSink(Sink sink) {
        if (sink == null) {
            throw new IllegalArgumentException("sink == null");
        }
        Deflater deflater = new Deflater(-1, true);
        this.deflater = deflater;
        BufferedSink buffer = Okio.buffer(sink);
        this.sink = buffer;
        this.deflaterSink = new DeflaterSink(buffer, deflater);
        writeHeader();
    }

    @Override // com.alibaba.griver.lottie.okio.Sink
    public final void write(Buffer buffer, long j) throws IOException {
        if (j < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        } else if (j == 0) {
        } else {
            updateCrc(buffer, j);
            this.deflaterSink.write(buffer, j);
        }
    }

    @Override // com.alibaba.griver.lottie.okio.Sink, java.io.Flushable
    public final void flush() throws IOException {
        this.deflaterSink.flush();
    }

    @Override // com.alibaba.griver.lottie.okio.Sink
    public final Timeout timeout() {
        return this.sink.timeout();
    }

    @Override // com.alibaba.griver.lottie.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.closed) {
            return;
        }
        Throwable th = null;
        try {
            this.deflaterSink.finishDeflate();
            writeFooter();
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.deflater.end();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        try {
            this.sink.close();
        } catch (Throwable th4) {
            if (th == null) {
                th = th4;
            }
        }
        this.closed = true;
        if (th != null) {
            Util.sneakyRethrow(th);
        }
    }

    public final Deflater deflater() {
        return this.deflater;
    }

    private void writeHeader() {
        Buffer buffer = this.sink.buffer();
        buffer.writeShort(8075);
        buffer.writeByte(8);
        buffer.writeByte(0);
        buffer.writeInt(0);
        buffer.writeByte(0);
        buffer.writeByte(0);
    }

    private void writeFooter() throws IOException {
        this.sink.writeIntLe((int) this.crc.getValue());
        this.sink.writeIntLe((int) this.deflater.getBytesRead());
    }

    private void updateCrc(Buffer buffer, long j) {
        Segment segment = buffer.head;
        while (j > 0) {
            int min = (int) Math.min(j, segment.limit - segment.pos);
            this.crc.update(segment.data, segment.pos, min);
            j -= min;
            segment = segment.next;
        }
    }
}
