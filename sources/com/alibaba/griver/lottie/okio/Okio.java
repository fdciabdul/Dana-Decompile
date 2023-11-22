package com.alibaba.griver.lottie.okio;

import id.dana.twilio.identityverification.TwilioIdentityVerificationActivity;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes6.dex */
public final class Okio {
    static final Logger logger = Logger.getLogger(Okio.class.getName());

    private Okio() {
    }

    public static BufferedSource buffer(Source source) {
        return new RealBufferedSource(source);
    }

    public static BufferedSink buffer(Sink sink) {
        return new RealBufferedSink(sink);
    }

    public static Sink sink(OutputStream outputStream) {
        return sink(outputStream, new Timeout());
    }

    private static Sink sink(final OutputStream outputStream, final Timeout timeout) {
        if (outputStream != null) {
            if (timeout == null) {
                throw new IllegalArgumentException("timeout == null");
            }
            return new Sink() { // from class: com.alibaba.griver.lottie.okio.Okio.1
                @Override // com.alibaba.griver.lottie.okio.Sink
                public final void write(Buffer buffer, long j) throws IOException {
                    Util.checkOffsetAndCount(buffer.size, 0L, j);
                    while (j > 0) {
                        Timeout.this.throwIfReached();
                        Segment segment = buffer.head;
                        int min = (int) Math.min(j, segment.limit - segment.pos);
                        outputStream.write(segment.data, segment.pos, min);
                        segment.pos += min;
                        long j2 = min;
                        j -= j2;
                        buffer.size -= j2;
                        if (segment.pos == segment.limit) {
                            buffer.head = segment.pop();
                            SegmentPool.recycle(segment);
                        }
                    }
                }

                @Override // com.alibaba.griver.lottie.okio.Sink, java.io.Flushable
                public final void flush() throws IOException {
                    outputStream.flush();
                }

                @Override // com.alibaba.griver.lottie.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
                public final void close() throws IOException {
                    outputStream.close();
                }

                @Override // com.alibaba.griver.lottie.okio.Sink
                public final Timeout timeout() {
                    return Timeout.this;
                }

                public final String toString() {
                    StringBuilder sb = new StringBuilder();
                    sb.append("sink(");
                    sb.append(outputStream);
                    sb.append(")");
                    return sb.toString();
                }
            };
        }
        throw new IllegalArgumentException("out == null");
    }

    public static Sink sink(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getOutputStream() == null) {
            throw new IOException("socket's output stream == null");
        }
        AsyncTimeout timeout = timeout(socket);
        return timeout.sink(sink(socket.getOutputStream(), timeout));
    }

    public static Source source(InputStream inputStream) {
        return source(inputStream, new Timeout());
    }

    private static Source source(final InputStream inputStream, final Timeout timeout) {
        if (inputStream != null) {
            if (timeout == null) {
                throw new IllegalArgumentException("timeout == null");
            }
            return new Source() { // from class: com.alibaba.griver.lottie.okio.Okio.2
                @Override // com.alibaba.griver.lottie.okio.Source
                public final long read(Buffer buffer, long j) throws IOException {
                    if (j < 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("byteCount < 0: ");
                        sb.append(j);
                        throw new IllegalArgumentException(sb.toString());
                    } else if (j == 0) {
                        return 0L;
                    } else {
                        try {
                            Timeout.this.throwIfReached();
                            Segment writableSegment = buffer.writableSegment(1);
                            int read = inputStream.read(writableSegment.data, writableSegment.limit, (int) Math.min(j, 8192 - writableSegment.limit));
                            if (read == -1) {
                                return -1L;
                            }
                            writableSegment.limit += read;
                            long j2 = read;
                            buffer.size += j2;
                            return j2;
                        } catch (AssertionError e) {
                            if (Okio.isAndroidGetsocknameError(e)) {
                                throw new IOException(e);
                            }
                            throw e;
                        }
                    }
                }

                @Override // com.alibaba.griver.lottie.okio.Source, java.io.Closeable, java.lang.AutoCloseable
                public final void close() throws IOException {
                    inputStream.close();
                }

                @Override // com.alibaba.griver.lottie.okio.Source
                public final Timeout timeout() {
                    return Timeout.this;
                }

                public final String toString() {
                    StringBuilder sb = new StringBuilder();
                    sb.append("source(");
                    sb.append(inputStream);
                    sb.append(")");
                    return sb.toString();
                }
            };
        }
        throw new IllegalArgumentException("in == null");
    }

    public static Source source(File file) throws FileNotFoundException {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        return source(new FileInputStream(file));
    }

    public static Source source(Path path, OpenOption... openOptionArr) throws IOException {
        if (path == null) {
            throw new IllegalArgumentException("path == null");
        }
        return source(Files.newInputStream(path, openOptionArr));
    }

    public static Sink sink(File file) throws FileNotFoundException {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        return sink(new FileOutputStream(file));
    }

    public static Sink appendingSink(File file) throws FileNotFoundException {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        return sink(new FileOutputStream(file, true));
    }

    public static Sink sink(Path path, OpenOption... openOptionArr) throws IOException {
        if (path == null) {
            throw new IllegalArgumentException("path == null");
        }
        return sink(Files.newOutputStream(path, openOptionArr));
    }

    public static Sink blackhole() {
        return new Sink() { // from class: com.alibaba.griver.lottie.okio.Okio.3
            @Override // com.alibaba.griver.lottie.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public final void close() throws IOException {
            }

            @Override // com.alibaba.griver.lottie.okio.Sink, java.io.Flushable
            public final void flush() throws IOException {
            }

            @Override // com.alibaba.griver.lottie.okio.Sink
            public final void write(Buffer buffer, long j) throws IOException {
                buffer.skip(j);
            }

            @Override // com.alibaba.griver.lottie.okio.Sink
            public final Timeout timeout() {
                return Timeout.NONE;
            }
        };
    }

    public static Source source(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getInputStream() == null) {
            throw new IOException("socket's input stream == null");
        }
        AsyncTimeout timeout = timeout(socket);
        return timeout.source(source(socket.getInputStream(), timeout));
    }

    private static AsyncTimeout timeout(final Socket socket) {
        return new AsyncTimeout() { // from class: com.alibaba.griver.lottie.okio.Okio.4
            @Override // com.alibaba.griver.lottie.okio.AsyncTimeout
            protected final IOException newTimeoutException(IOException iOException) {
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException(TwilioIdentityVerificationActivity.CHALLENGE_INFO_TIMEOUT);
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }

            @Override // com.alibaba.griver.lottie.okio.AsyncTimeout
            protected final void timedOut() {
                try {
                    socket.close();
                } catch (AssertionError e) {
                    if (Okio.isAndroidGetsocknameError(e)) {
                        Logger logger2 = Okio.logger;
                        Level level = Level.WARNING;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Failed to close timed out socket ");
                        sb.append(socket);
                        logger2.log(level, sb.toString(), (Throwable) e);
                        return;
                    }
                    throw e;
                } catch (Exception e2) {
                    Logger logger3 = Okio.logger;
                    Level level2 = Level.WARNING;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Failed to close timed out socket ");
                    sb2.append(socket);
                    logger3.log(level2, sb2.toString(), (Throwable) e2);
                }
            }
        };
    }

    static boolean isAndroidGetsocknameError(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
