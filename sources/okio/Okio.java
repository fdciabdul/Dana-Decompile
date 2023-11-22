package okio;

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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public final class Okio {
    static final Logger PlaceComponentResult = Logger.getLogger(Okio.class.getName());

    private Okio() {
    }

    public static BufferedSource KClassImpl$Data$declaredNonStaticMembers$2(Source source) {
        return new RealBufferedSource(source);
    }

    public static BufferedSink BuiltInFictitiousFunctionClassFactory(Sink sink) {
        return new RealBufferedSink(sink);
    }

    public static Sink MyBillsEntityDataFactory(OutputStream outputStream) {
        Timeout timeout = new Timeout();
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        return new AnonymousClass1(timeout, outputStream);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: okio.Okio$1 */
    /* loaded from: classes2.dex */
    public final class AnonymousClass1 implements Sink {
        final /* synthetic */ Timeout KClassImpl$Data$declaredNonStaticMembers$2;
        final /* synthetic */ OutputStream MyBillsEntityDataFactory;

        AnonymousClass1(Timeout timeout, OutputStream outputStream) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = timeout;
            this.MyBillsEntityDataFactory = outputStream;
        }

        @Override // okio.Sink
        public final void write(Buffer buffer, long j) throws IOException {
            Util.MyBillsEntityDataFactory(buffer.getAuthRequestContext, 0L, j);
            while (j > 0) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.throwIfReached();
                Segment segment = buffer.BuiltInFictitiousFunctionClassFactory;
                int min = (int) Math.min(j, segment.MyBillsEntityDataFactory - segment.PlaceComponentResult);
                this.MyBillsEntityDataFactory.write(segment.BuiltInFictitiousFunctionClassFactory, segment.PlaceComponentResult, min);
                segment.PlaceComponentResult += min;
                long j2 = min;
                j -= j2;
                buffer.getAuthRequestContext -= j2;
                if (segment.PlaceComponentResult == segment.MyBillsEntityDataFactory) {
                    buffer.BuiltInFictitiousFunctionClassFactory = segment.MyBillsEntityDataFactory();
                    SegmentPool.getAuthRequestContext(segment);
                }
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public final void flush() throws IOException {
            this.MyBillsEntityDataFactory.flush();
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            this.MyBillsEntityDataFactory.close();
        }

        @Override // okio.Sink
        public final Timeout timeout() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("sink(");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(")");
            return sb.toString();
        }
    }

    public static Sink getAuthRequestContext(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getOutputStream() == null) {
            throw new IOException("socket's output stream == null");
        }
        AnonymousClass4 anonymousClass4 = new AnonymousClass4(socket);
        OutputStream outputStream = socket.getOutputStream();
        if (outputStream != null) {
            return anonymousClass4.sink(new AnonymousClass1(anonymousClass4, outputStream));
        }
        throw new IllegalArgumentException("out == null");
    }

    public static Source getAuthRequestContext(InputStream inputStream) {
        Timeout timeout = new Timeout();
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        return new AnonymousClass2(timeout, inputStream);
    }

    /* renamed from: okio.Okio$2 */
    /* loaded from: classes2.dex */
    public final class AnonymousClass2 implements Source {
        final /* synthetic */ Timeout MyBillsEntityDataFactory;
        final /* synthetic */ InputStream getAuthRequestContext;

        AnonymousClass2(Timeout timeout, InputStream inputStream) {
            this.MyBillsEntityDataFactory = timeout;
            this.getAuthRequestContext = inputStream;
        }

        @Override // okio.Source
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
                    this.MyBillsEntityDataFactory.throwIfReached();
                    Segment MyBillsEntityDataFactory = buffer.MyBillsEntityDataFactory(1);
                    int read = this.getAuthRequestContext.read(MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory, MyBillsEntityDataFactory.MyBillsEntityDataFactory, (int) Math.min(j, 8192 - MyBillsEntityDataFactory.MyBillsEntityDataFactory));
                    if (read == -1) {
                        return -1L;
                    }
                    MyBillsEntityDataFactory.MyBillsEntityDataFactory += read;
                    long j2 = read;
                    buffer.getAuthRequestContext += j2;
                    return j2;
                } catch (AssertionError e) {
                    if (Okio.getAuthRequestContext(e)) {
                        throw new IOException(e);
                    }
                    throw e;
                }
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            this.getAuthRequestContext.close();
        }

        @Override // okio.Source
        public final Timeout timeout() {
            return this.MyBillsEntityDataFactory;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("source(");
            sb.append(this.getAuthRequestContext);
            sb.append(")");
            return sb.toString();
        }
    }

    public static Source PlaceComponentResult(File file) throws FileNotFoundException {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        return new AnonymousClass2(new Timeout(), new FileInputStream(file));
    }

    public static Sink MyBillsEntityDataFactory(File file) throws FileNotFoundException {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        return new AnonymousClass1(new Timeout(), new FileOutputStream(file));
    }

    public static Sink getAuthRequestContext(File file) throws FileNotFoundException {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        return new AnonymousClass1(new Timeout(), new FileOutputStream(file, true));
    }

    public static Sink MyBillsEntityDataFactory() {
        return new Sink() { // from class: okio.Okio.3
            @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public final void close() throws IOException {
            }

            @Override // okio.Sink, java.io.Flushable
            public final void flush() throws IOException {
            }

            @Override // okio.Sink
            public final void write(Buffer buffer, long j) throws IOException {
                buffer.NetworkUserEntityData$$ExternalSyntheticLambda0(j);
            }

            @Override // okio.Sink
            public final Timeout timeout() {
                return Timeout.NONE;
            }
        };
    }

    public static Source PlaceComponentResult(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getInputStream() == null) {
            throw new IOException("socket's input stream == null");
        }
        AnonymousClass4 anonymousClass4 = new AnonymousClass4(socket);
        InputStream inputStream = socket.getInputStream();
        if (inputStream != null) {
            return anonymousClass4.source(new AnonymousClass2(anonymousClass4, inputStream));
        }
        throw new IllegalArgumentException("in == null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: okio.Okio$4 */
    /* loaded from: classes2.dex */
    public final class AnonymousClass4 extends AsyncTimeout {
        final /* synthetic */ Socket PlaceComponentResult;

        AnonymousClass4(Socket socket) {
            this.PlaceComponentResult = socket;
        }

        @Override // okio.AsyncTimeout
        protected final IOException newTimeoutException(@Nullable IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException(TwilioIdentityVerificationActivity.CHALLENGE_INFO_TIMEOUT);
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // okio.AsyncTimeout
        protected final void timedOut() {
            try {
                this.PlaceComponentResult.close();
            } catch (AssertionError e) {
                if (Okio.getAuthRequestContext(e)) {
                    Logger logger = Okio.PlaceComponentResult;
                    Level level = Level.WARNING;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to close timed out socket ");
                    sb.append(this.PlaceComponentResult);
                    logger.log(level, sb.toString(), (Throwable) e);
                    return;
                }
                throw e;
            } catch (Exception e2) {
                Logger logger2 = Okio.PlaceComponentResult;
                Level level2 = Level.WARNING;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed to close timed out socket ");
                sb2.append(this.PlaceComponentResult);
                logger2.log(level2, sb2.toString(), (Throwable) e2);
            }
        }
    }

    static boolean getAuthRequestContext(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
