package com.alibaba.griver.lottie.okio;

import java.io.IOException;

/* loaded from: classes6.dex */
public final class Pipe {
    private Sink foldedSink;
    final long maxBufferSize;
    boolean sinkClosed;
    boolean sourceClosed;
    final Buffer buffer = new Buffer();
    private final Sink sink = new PipeSink();
    private final Source source = new PipeSource();

    public Pipe(long j) {
        if (j < 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("maxBufferSize < 1: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        }
        this.maxBufferSize = j;
    }

    public final Source source() {
        return this.source;
    }

    public final Sink sink() {
        return this.sink;
    }

    public final void fold(Sink sink) throws IOException {
        Buffer buffer;
        while (true) {
            synchronized (this.buffer) {
                if (this.foldedSink != null) {
                    throw new IllegalStateException("sink already folded");
                }
                if (this.buffer.exhausted()) {
                    this.sourceClosed = true;
                    this.foldedSink = sink;
                    return;
                }
                buffer = new Buffer();
                Buffer buffer2 = this.buffer;
                buffer.write(buffer2, buffer2.size);
                this.buffer.notifyAll();
            }
            try {
                sink.write(buffer, buffer.size);
                sink.flush();
            } catch (Throwable th) {
                synchronized (this.buffer) {
                    this.sourceClosed = true;
                    this.buffer.notifyAll();
                    throw th;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    final class PipeSink implements Sink {
        final PushableTimeout timeout = new PushableTimeout();

        PipeSink() {
        }

        @Override // com.alibaba.griver.lottie.okio.Sink
        public final void write(Buffer buffer, long j) throws IOException {
            Sink sink;
            synchronized (Pipe.this.buffer) {
                if (!Pipe.this.sinkClosed) {
                    while (true) {
                        if (j <= 0) {
                            sink = null;
                            break;
                        } else if (Pipe.this.foldedSink != null) {
                            sink = Pipe.this.foldedSink;
                            break;
                        } else if (Pipe.this.sourceClosed) {
                            throw new IOException("source is closed");
                        } else {
                            long size = Pipe.this.maxBufferSize - Pipe.this.buffer.size();
                            if (size == 0) {
                                this.timeout.waitUntilNotified(Pipe.this.buffer);
                            } else {
                                long min = Math.min(size, j);
                                Pipe.this.buffer.write(buffer, min);
                                j -= min;
                                Pipe.this.buffer.notifyAll();
                            }
                        }
                    }
                } else {
                    throw new IllegalStateException("closed");
                }
            }
            if (sink != null) {
                this.timeout.push(sink.timeout());
                try {
                    sink.write(buffer, j);
                } finally {
                    this.timeout.pop();
                }
            }
        }

        @Override // com.alibaba.griver.lottie.okio.Sink, java.io.Flushable
        public final void flush() throws IOException {
            Sink sink;
            synchronized (Pipe.this.buffer) {
                if (!Pipe.this.sinkClosed) {
                    if (Pipe.this.foldedSink != null) {
                        sink = Pipe.this.foldedSink;
                    } else {
                        if (Pipe.this.sourceClosed && Pipe.this.buffer.size() > 0) {
                            throw new IOException("source is closed");
                        }
                        sink = null;
                    }
                } else {
                    throw new IllegalStateException("closed");
                }
            }
            if (sink != null) {
                this.timeout.push(sink.timeout());
                try {
                    sink.flush();
                } finally {
                    this.timeout.pop();
                }
            }
        }

        @Override // com.alibaba.griver.lottie.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            Sink sink;
            synchronized (Pipe.this.buffer) {
                if (Pipe.this.sinkClosed) {
                    return;
                }
                if (Pipe.this.foldedSink != null) {
                    sink = Pipe.this.foldedSink;
                } else {
                    if (Pipe.this.sourceClosed && Pipe.this.buffer.size() > 0) {
                        throw new IOException("source is closed");
                    }
                    Pipe.this.sinkClosed = true;
                    Pipe.this.buffer.notifyAll();
                    sink = null;
                }
                if (sink != null) {
                    this.timeout.push(sink.timeout());
                    try {
                        sink.close();
                    } finally {
                        this.timeout.pop();
                    }
                }
            }
        }

        @Override // com.alibaba.griver.lottie.okio.Sink
        public final Timeout timeout() {
            return this.timeout;
        }
    }

    /* loaded from: classes6.dex */
    final class PipeSource implements Source {
        final Timeout timeout = new Timeout();

        PipeSource() {
        }

        @Override // com.alibaba.griver.lottie.okio.Source
        public final long read(Buffer buffer, long j) throws IOException {
            synchronized (Pipe.this.buffer) {
                if (Pipe.this.sourceClosed) {
                    throw new IllegalStateException("closed");
                }
                while (Pipe.this.buffer.size() == 0) {
                    if (Pipe.this.sinkClosed) {
                        return -1L;
                    }
                    this.timeout.waitUntilNotified(Pipe.this.buffer);
                }
                long read = Pipe.this.buffer.read(buffer, j);
                Pipe.this.buffer.notifyAll();
                return read;
            }
        }

        @Override // com.alibaba.griver.lottie.okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            synchronized (Pipe.this.buffer) {
                Pipe.this.sourceClosed = true;
                Pipe.this.buffer.notifyAll();
            }
        }

        @Override // com.alibaba.griver.lottie.okio.Source
        public final Timeout timeout() {
            return this.timeout;
        }
    }
}
