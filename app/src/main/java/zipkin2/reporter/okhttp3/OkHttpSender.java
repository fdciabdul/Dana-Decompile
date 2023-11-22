package zipkin2.reporter.okhttp3;

import com.alipay.imobile.network.quake.transport.http.constant.HeaderConstant;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Dispatcher;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;
import zipkin2.Call;
import zipkin2.codec.Encoding;
import zipkin2.reporter.ClosedSenderException;
import zipkin2.reporter.Sender;

/* loaded from: classes2.dex */
public final class OkHttpSender extends Sender {
    public static final byte[] lookAheadTest = {112, -20, -94, -81, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int scheduleImpl = 107;
    final Encoding BuiltInFictitiousFunctionClassFactory;
    final RequestBodyMessageEncoder KClassImpl$Data$declaredNonStaticMembers$2;
    final boolean MyBillsEntityDataFactory;
    final int NetworkUserEntityData$$ExternalSyntheticLambda0;
    final OkHttpClient PlaceComponentResult;
    volatile boolean getAuthRequestContext;
    final HttpUrl getErrorConfigVersion;
    final int moveToNextValue;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r7, int r8, int r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 + 4
            int r9 = r9 * 7
            int r9 = 106 - r9
            int r7 = r7 * 3
            int r7 = 16 - r7
            byte[] r0 = zipkin2.reporter.okhttp3.OkHttpSender.lookAheadTest
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r8
            goto L34
        L17:
            r3 = 0
            r6 = r9
            r9 = r8
            r8 = r6
        L1b:
            int r4 = r3 + 1
            byte r5 = (byte) r8
            int r9 = r9 + 1
            r1[r3] = r5
            if (r4 != r7) goto L2c
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2c:
            r3 = r0[r9]
            r6 = r10
            r10 = r9
            r9 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L34:
            int r8 = r8 + r9
            int r8 = r8 + 2
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: zipkin2.reporter.okhttp3.OkHttpSender.a(int, int, int, java.lang.Object[]):void");
    }

    public static Builder getAuthRequestContext() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        InstrumentInjector.okhttp_addInterceptors(builder);
        return new Builder(builder);
    }

    /* loaded from: classes2.dex */
    public static final class Builder {
        public final OkHttpClient.Builder BuiltInFictitiousFunctionClassFactory;
        HttpUrl getAuthRequestContext;
        Encoding KClassImpl$Data$declaredNonStaticMembers$2 = Encoding.JSON;
        boolean MyBillsEntityDataFactory = true;
        int PlaceComponentResult = 64;
        int getErrorConfigVersion = 500000;

        Builder(OkHttpClient.Builder builder) {
            this.BuiltInFictitiousFunctionClassFactory = builder;
        }

        public final Builder BuiltInFictitiousFunctionClassFactory(String str) {
            if (str == null) {
                throw new NullPointerException("endpoint == null");
            }
            HttpUrl parse = HttpUrl.parse(str);
            if (parse != null) {
                if (parse == null) {
                    throw new NullPointerException("endpoint == null");
                }
                this.getAuthRequestContext = parse;
                return this;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("invalid POST url: ");
            sb.append(str);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public OkHttpSender(Builder builder) {
        if (builder.getAuthRequestContext == null) {
            throw new NullPointerException("endpoint == null");
        }
        this.getErrorConfigVersion = builder.getAuthRequestContext;
        Encoding encoding = builder.KClassImpl$Data$declaredNonStaticMembers$2;
        this.BuiltInFictitiousFunctionClassFactory = encoding;
        int i = AnonymousClass1.getAuthRequestContext[encoding.ordinal()];
        if (i == 1) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = RequestBodyMessageEncoder.JSON;
        } else if (i == 2) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = RequestBodyMessageEncoder.THRIFT;
        } else if (i == 3) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = RequestBodyMessageEncoder.PROTO3;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Unsupported encoding: ");
            sb.append(encoding.name());
            throw new UnsupportedOperationException(sb.toString());
        }
        int i2 = builder.PlaceComponentResult;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i2;
        this.moveToNextValue = builder.getErrorConfigVersion;
        this.MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory;
        Dispatcher dispatcher = new Dispatcher(new ThreadPoolExecutor(0, i2, 60L, TimeUnit.SECONDS, new SynchronousQueue(), OkHttpSenderThreadFactory.INSTANCE));
        dispatcher.setMaxRequests(i2);
        dispatcher.setMaxRequestsPerHost(i2);
        this.PlaceComponentResult = builder.BuiltInFictitiousFunctionClassFactory.build().newBuilder().dispatcher(dispatcher).build();
    }

    /* renamed from: zipkin2.reporter.okhttp3.OkHttpSender$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[Encoding.values().length];
            getAuthRequestContext = iArr;
            try {
                iArr[Encoding.JSON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                getAuthRequestContext[Encoding.THRIFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                getAuthRequestContext[Encoding.PROTO3.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes6.dex */
    enum OkHttpSenderThreadFactory implements ThreadFactory {
        INSTANCE;

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "OkHttpSender Dispatcher");
        }
    }

    @Override // zipkin2.reporter.Sender
    public final int PlaceComponentResult(List<byte[]> list) {
        return this.BuiltInFictitiousFunctionClassFactory.listSizeInBytes(list);
    }

    @Override // zipkin2.reporter.Sender
    public final Encoding KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // zipkin2.reporter.Sender
    public final Call<Void> MyBillsEntityDataFactory(List<byte[]> list) {
        if (this.getAuthRequestContext) {
            throw new ClosedSenderException();
        }
        try {
            RequestBody encode = this.KClassImpl$Data$declaredNonStaticMembers$2.encode(list);
            Request.Builder url = new Request.Builder().url(this.getErrorConfigVersion);
            url.addHeader("b3", "0");
            if (this.MyBillsEntityDataFactory) {
                url.addHeader("Content-Encoding", HeaderConstant.HEADER_VALUE_CONTENT_ENCODING_GZIP);
                Buffer buffer = new Buffer();
                BufferedSink BuiltInFictitiousFunctionClassFactory = Okio.BuiltInFictitiousFunctionClassFactory(new GzipSink(buffer));
                encode.writeTo(BuiltInFictitiousFunctionClassFactory);
                BuiltInFictitiousFunctionClassFactory.close();
                encode = new BufferRequestBody(encode.contentType(), buffer);
            }
            url.post(encode);
            return new HttpCall(this.PlaceComponentResult.newCall(url.build()));
        } catch (IOException e) {
            throw Platform.MyBillsEntityDataFactory().PlaceComponentResult(e);
        }
    }

    @Override // zipkin2.Component, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this) {
            if (this.getAuthRequestContext) {
                return;
            }
            this.getAuthRequestContext = true;
            Dispatcher dispatcher = this.PlaceComponentResult.dispatcher();
            dispatcher.executorService().shutdown();
            try {
                try {
                    if (!dispatcher.executorService().awaitTermination(1L, TimeUnit.SECONDS)) {
                        dispatcher.cancelAll();
                    }
                } catch (InterruptedException unused) {
                    Object[] objArr = new Object[1];
                    a((byte) (lookAheadTest[15] - 1), lookAheadTest[22], (byte) (lookAheadTest[15] - 1), objArr);
                    Class<?> cls = Class.forName((String) objArr[0]);
                    byte b = lookAheadTest[15];
                    Object[] objArr2 = new Object[1];
                    a(b, (byte) (-b), lookAheadTest[15], objArr2);
                    ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).interrupt();
                }
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OkHttpSender{");
        sb.append(this.getErrorConfigVersion);
        sb.append("}");
        return sb.toString();
    }

    /* loaded from: classes6.dex */
    static final class BufferRequestBody extends RequestBody {
        final Buffer KClassImpl$Data$declaredNonStaticMembers$2;
        final MediaType MyBillsEntityDataFactory;

        BufferRequestBody(MediaType mediaType, Buffer buffer) {
            this.MyBillsEntityDataFactory = mediaType;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = buffer;
        }

        @Override // okhttp3.RequestBody
        public final long contentLength() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext;
        }

        @Override // okhttp3.RequestBody
        public final MediaType contentType() {
            return this.MyBillsEntityDataFactory;
        }

        @Override // okhttp3.RequestBody
        public final void writeTo(BufferedSink bufferedSink) throws IOException {
            Buffer buffer = this.KClassImpl$Data$declaredNonStaticMembers$2;
            bufferedSink.write(buffer, buffer.getAuthRequestContext);
        }
    }
}
