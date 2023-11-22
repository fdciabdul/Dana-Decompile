package okhttp3.internal.http1;

import com.google.common.net.HttpHeaders;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* loaded from: classes6.dex */
public final class Http1Codec implements HttpCodec {
    private static final int HEADER_LIMIT = 262144;
    private static final int STATE_CLOSED = 6;
    private static final int STATE_IDLE = 0;
    private static final int STATE_OPEN_REQUEST_BODY = 1;
    private static final int STATE_OPEN_RESPONSE_BODY = 4;
    private static final int STATE_READING_RESPONSE_BODY = 5;
    private static final int STATE_READ_RESPONSE_HEADERS = 3;
    private static final int STATE_WRITING_REQUEST_BODY = 2;
    final OkHttpClient client;
    final BufferedSink sink;
    final BufferedSource source;
    final StreamAllocation streamAllocation;
    int state = 0;
    private long headerLimit = 262144;

    public Http1Codec(OkHttpClient okHttpClient, StreamAllocation streamAllocation, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        this.client = okHttpClient;
        this.streamAllocation = streamAllocation;
        this.source = bufferedSource;
        this.sink = bufferedSink;
    }

    @Override // okhttp3.internal.http.HttpCodec
    public final Sink createRequestBody(Request request, long j) {
        if ("chunked".equalsIgnoreCase(request.header(HttpHeaders.TRANSFER_ENCODING))) {
            return newChunkedSink();
        }
        if (j != -1) {
            return newFixedLengthSink(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // okhttp3.internal.http.HttpCodec
    public final void cancel() {
        RealConnection connection = this.streamAllocation.connection();
        if (connection != null) {
            connection.cancel();
        }
    }

    @Override // okhttp3.internal.http.HttpCodec
    public final void writeRequestHeaders(Request request) throws IOException {
        writeRequest(request.headers(), RequestLine.get(request, this.streamAllocation.connection().route().proxy().type()));
    }

    @Override // okhttp3.internal.http.HttpCodec
    public final ResponseBody openResponseBody(Response response) throws IOException {
        this.streamAllocation.eventListener.responseBodyStart(this.streamAllocation.call);
        String header = response.header("Content-Type");
        if (!okhttp3.internal.http.HttpHeaders.hasBody(response)) {
            return new RealResponseBody(header, 0L, Okio.KClassImpl$Data$declaredNonStaticMembers$2(newFixedLengthSource(0L)));
        }
        if ("chunked".equalsIgnoreCase(response.header(HttpHeaders.TRANSFER_ENCODING))) {
            return new RealResponseBody(header, -1L, Okio.KClassImpl$Data$declaredNonStaticMembers$2(newChunkedSource(response.request().url())));
        }
        long contentLength = okhttp3.internal.http.HttpHeaders.contentLength(response);
        if (contentLength != -1) {
            return new RealResponseBody(header, contentLength, Okio.KClassImpl$Data$declaredNonStaticMembers$2(newFixedLengthSource(contentLength)));
        }
        return new RealResponseBody(header, -1L, Okio.KClassImpl$Data$declaredNonStaticMembers$2(newUnknownLengthSource()));
    }

    public final boolean isClosed() {
        return this.state == 6;
    }

    @Override // okhttp3.internal.http.HttpCodec
    public final void flushRequest() throws IOException {
        this.sink.flush();
    }

    @Override // okhttp3.internal.http.HttpCodec
    public final void finishRequest() throws IOException {
        this.sink.flush();
    }

    public final void writeRequest(Headers headers, String str) throws IOException {
        if (this.state != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("state: ");
            sb.append(this.state);
            throw new IllegalStateException(sb.toString());
        }
        this.sink.BuiltInFictitiousFunctionClassFactory(str).BuiltInFictitiousFunctionClassFactory("\r\n");
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            this.sink.BuiltInFictitiousFunctionClassFactory(headers.name(i)).BuiltInFictitiousFunctionClassFactory(": ").BuiltInFictitiousFunctionClassFactory(headers.value(i)).BuiltInFictitiousFunctionClassFactory("\r\n");
        }
        this.sink.BuiltInFictitiousFunctionClassFactory("\r\n");
        this.state = 1;
    }

    @Override // okhttp3.internal.http.HttpCodec
    public final Response.Builder readResponseHeaders(boolean z) throws IOException {
        int i = this.state;
        if (i != 1 && i != 3) {
            StringBuilder sb = new StringBuilder();
            sb.append("state: ");
            sb.append(this.state);
            throw new IllegalStateException(sb.toString());
        }
        try {
            StatusLine parse = StatusLine.parse(readHeaderLine());
            Response.Builder headers = new Response.Builder().protocol(parse.protocol).code(parse.code).message(parse.message).headers(readHeaders());
            if (z && parse.code == 100) {
                return null;
            }
            if (parse.code == 100) {
                this.state = 3;
                return headers;
            }
            this.state = 4;
            return headers;
        } catch (EOFException e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("unexpected end of stream on ");
            sb2.append(this.streamAllocation);
            IOException iOException = new IOException(sb2.toString());
            iOException.initCause(e);
            throw iOException;
        }
    }

    private String readHeaderLine() throws IOException {
        String BuiltInFictitiousFunctionClassFactory = this.source.BuiltInFictitiousFunctionClassFactory(this.headerLimit);
        this.headerLimit -= BuiltInFictitiousFunctionClassFactory.length();
        return BuiltInFictitiousFunctionClassFactory;
    }

    public final Headers readHeaders() throws IOException {
        Headers.Builder builder = new Headers.Builder();
        while (true) {
            String readHeaderLine = readHeaderLine();
            if (readHeaderLine.length() != 0) {
                Internal.instance.addLenient(builder, readHeaderLine);
            } else {
                return builder.build();
            }
        }
    }

    public final Sink newChunkedSink() {
        if (this.state != 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("state: ");
            sb.append(this.state);
            throw new IllegalStateException(sb.toString());
        }
        this.state = 2;
        return new ChunkedSink();
    }

    public final Sink newFixedLengthSink(long j) {
        if (this.state != 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("state: ");
            sb.append(this.state);
            throw new IllegalStateException(sb.toString());
        }
        this.state = 2;
        return new FixedLengthSink(j);
    }

    public final Source newFixedLengthSource(long j) throws IOException {
        if (this.state != 4) {
            StringBuilder sb = new StringBuilder();
            sb.append("state: ");
            sb.append(this.state);
            throw new IllegalStateException(sb.toString());
        }
        this.state = 5;
        return new FixedLengthSource(j);
    }

    public final Source newChunkedSource(HttpUrl httpUrl) throws IOException {
        if (this.state != 4) {
            StringBuilder sb = new StringBuilder();
            sb.append("state: ");
            sb.append(this.state);
            throw new IllegalStateException(sb.toString());
        }
        this.state = 5;
        return new ChunkedSource(httpUrl);
    }

    public final Source newUnknownLengthSource() throws IOException {
        if (this.state != 4) {
            StringBuilder sb = new StringBuilder();
            sb.append("state: ");
            sb.append(this.state);
            throw new IllegalStateException(sb.toString());
        }
        StreamAllocation streamAllocation = this.streamAllocation;
        if (streamAllocation == null) {
            throw new IllegalStateException("streamAllocation == null");
        }
        this.state = 5;
        streamAllocation.noNewStreams();
        return new UnknownLengthSource();
    }

    /* loaded from: classes6.dex */
    public final class FixedLengthSink implements Sink {
        private long bytesRemaining;
        private boolean closed;
        private final ForwardingTimeout timeout;

        FixedLengthSink(long j) {
            Http1Codec.this = r2;
            this.timeout = new ForwardingTimeout(r2.sink.timeout());
            this.bytesRemaining = j;
        }

        @Override // okio.Sink
        public final Timeout timeout() {
            return this.timeout;
        }

        @Override // okio.Sink
        public final void write(Buffer buffer, long j) throws IOException {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            Util.checkOffsetAndCount(buffer.getAuthRequestContext, 0L, j);
            if (j > this.bytesRemaining) {
                StringBuilder sb = new StringBuilder();
                sb.append("expected ");
                sb.append(this.bytesRemaining);
                sb.append(" bytes but received ");
                sb.append(j);
                throw new ProtocolException(sb.toString());
            }
            Http1Codec.this.sink.write(buffer, j);
            this.bytesRemaining -= j;
        }

        @Override // okio.Sink, java.io.Flushable
        public final void flush() throws IOException {
            if (this.closed) {
                return;
            }
            Http1Codec.this.sink.flush();
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            if (this.bytesRemaining > 0) {
                throw new ProtocolException("unexpected end of stream");
            }
            Http1Codec.this.detachTimeout(this.timeout);
            Http1Codec.this.state = 3;
        }
    }

    /* loaded from: classes6.dex */
    public final class ChunkedSink implements Sink {
        private boolean closed;
        private final ForwardingTimeout timeout;

        ChunkedSink() {
            Http1Codec.this = r2;
            this.timeout = new ForwardingTimeout(r2.sink.timeout());
        }

        @Override // okio.Sink
        public final Timeout timeout() {
            return this.timeout;
        }

        @Override // okio.Sink
        public final void write(Buffer buffer, long j) throws IOException {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            if (j == 0) {
                return;
            }
            Http1Codec.this.sink.GetContactSyncConfig(j);
            Http1Codec.this.sink.BuiltInFictitiousFunctionClassFactory("\r\n");
            Http1Codec.this.sink.write(buffer, j);
            Http1Codec.this.sink.BuiltInFictitiousFunctionClassFactory("\r\n");
        }

        @Override // okio.Sink, java.io.Flushable
        public final void flush() throws IOException {
            synchronized (this) {
                if (this.closed) {
                    return;
                }
                Http1Codec.this.sink.flush();
            }
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            synchronized (this) {
                if (this.closed) {
                    return;
                }
                this.closed = true;
                Http1Codec.this.sink.BuiltInFictitiousFunctionClassFactory("0\r\n\r\n");
                Http1Codec.this.detachTimeout(this.timeout);
                Http1Codec.this.state = 3;
            }
        }
    }

    /* loaded from: classes6.dex */
    public abstract class AbstractSource implements Source {
        protected long bytesRead;
        protected boolean closed;
        protected final ForwardingTimeout timeout;

        private AbstractSource() {
            Http1Codec.this = r3;
            this.timeout = new ForwardingTimeout(r3.source.timeout());
            this.bytesRead = 0L;
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.timeout;
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            try {
                long read = Http1Codec.this.source.read(buffer, j);
                if (read > 0) {
                    this.bytesRead += read;
                }
                return read;
            } catch (IOException e) {
                endOfInput(false, e);
                throw e;
            }
        }

        protected final void endOfInput(boolean z, IOException iOException) throws IOException {
            if (Http1Codec.this.state == 6) {
                return;
            }
            if (Http1Codec.this.state != 5) {
                StringBuilder sb = new StringBuilder();
                sb.append("state: ");
                sb.append(Http1Codec.this.state);
                throw new IllegalStateException(sb.toString());
            }
            Http1Codec.this.detachTimeout(this.timeout);
            Http1Codec.this.state = 6;
            if (Http1Codec.this.streamAllocation != null) {
                Http1Codec.this.streamAllocation.streamFinished(!z, Http1Codec.this, this.bytesRead, iOException);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class FixedLengthSource extends AbstractSource {
        private long bytesRemaining;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        FixedLengthSource(long j) throws IOException {
            super();
            Http1Codec.this = r4;
            this.bytesRemaining = j;
            if (j == 0) {
                endOfInput(true, null);
            }
        }

        @Override // okhttp3.internal.http1.Http1Codec.AbstractSource, okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("byteCount < 0: ");
                sb.append(j);
                throw new IllegalArgumentException(sb.toString());
            } else if (this.closed) {
                throw new IllegalStateException("closed");
            } else {
                long j2 = this.bytesRemaining;
                if (j2 == 0) {
                    return -1L;
                }
                long read = super.read(buffer, Math.min(j2, j));
                if (read == -1) {
                    ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                    endOfInput(false, protocolException);
                    throw protocolException;
                }
                long j3 = this.bytesRemaining - read;
                this.bytesRemaining = j3;
                if (j3 == 0) {
                    endOfInput(true, null);
                }
                return read;
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            if (this.bytesRemaining != 0 && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                endOfInput(false, null);
            }
            this.closed = true;
        }
    }

    /* loaded from: classes6.dex */
    public class ChunkedSource extends AbstractSource {
        private static final long NO_CHUNK_YET = -1;
        private long bytesRemainingInChunk;
        private boolean hasMoreChunks;
        private final HttpUrl url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        ChunkedSource(HttpUrl httpUrl) {
            super();
            Http1Codec.this = r3;
            this.bytesRemainingInChunk = -1L;
            this.hasMoreChunks = true;
            this.url = httpUrl;
        }

        @Override // okhttp3.internal.http1.Http1Codec.AbstractSource, okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("byteCount < 0: ");
                sb.append(j);
                throw new IllegalArgumentException(sb.toString());
            } else if (this.closed) {
                throw new IllegalStateException("closed");
            } else {
                if (this.hasMoreChunks) {
                    long j2 = this.bytesRemainingInChunk;
                    if (j2 == 0 || j2 == -1) {
                        readChunkSize();
                        if (!this.hasMoreChunks) {
                            return -1L;
                        }
                    }
                    long read = super.read(buffer, Math.min(j, this.bytesRemainingInChunk));
                    if (read == -1) {
                        ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                        endOfInput(false, protocolException);
                        throw protocolException;
                    }
                    this.bytesRemainingInChunk -= read;
                    return read;
                }
                return -1L;
            }
        }

        private void readChunkSize() throws IOException {
            if (this.bytesRemainingInChunk != -1) {
                Http1Codec.this.source.NetworkUserEntityData$$ExternalSyntheticLambda5();
            }
            try {
                this.bytesRemainingInChunk = Http1Codec.this.source.DatabaseTableConfigUtil();
                String trim = Http1Codec.this.source.NetworkUserEntityData$$ExternalSyntheticLambda5().trim();
                if (this.bytesRemainingInChunk < 0 || !(trim.isEmpty() || trim.startsWith(";"))) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("expected chunk size and optional extensions but was \"");
                    sb.append(this.bytesRemainingInChunk);
                    sb.append(trim);
                    sb.append("\"");
                    throw new ProtocolException(sb.toString());
                } else if (this.bytesRemainingInChunk == 0) {
                    this.hasMoreChunks = false;
                    okhttp3.internal.http.HttpHeaders.receiveHeaders(Http1Codec.this.client.cookieJar(), this.url, Http1Codec.this.readHeaders());
                    endOfInput(true, null);
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            if (this.hasMoreChunks && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                endOfInput(false, null);
            }
            this.closed = true;
        }
    }

    /* loaded from: classes6.dex */
    public class UnknownLengthSource extends AbstractSource {
        private boolean inputExhausted;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        UnknownLengthSource() {
            super();
            Http1Codec.this = r2;
        }

        @Override // okhttp3.internal.http1.Http1Codec.AbstractSource, okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("byteCount < 0: ");
                sb.append(j);
                throw new IllegalArgumentException(sb.toString());
            } else if (this.closed) {
                throw new IllegalStateException("closed");
            } else {
                if (this.inputExhausted) {
                    return -1L;
                }
                long read = super.read(buffer, j);
                if (read == -1) {
                    this.inputExhausted = true;
                    endOfInput(true, null);
                    return -1L;
                }
                return read;
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            if (!this.inputExhausted) {
                endOfInput(false, null);
            }
            this.closed = true;
        }
    }

    final void detachTimeout(ForwardingTimeout forwardingTimeout) {
        Timeout timeout = forwardingTimeout.getAuthRequestContext;
        Timeout timeout2 = Timeout.NONE;
        if (timeout2 == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        forwardingTimeout.getAuthRequestContext = timeout2;
        timeout.clearDeadline();
        timeout.clearTimeout();
    }
}
