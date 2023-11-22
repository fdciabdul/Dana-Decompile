package okhttp3;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* loaded from: classes2.dex */
public final class Cache implements Closeable, Flushable {
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
    private static final int ENTRY_METADATA = 0;
    private static final int VERSION = 201105;
    final DiskLruCache cache;
    private int hitCount;
    final InternalCache internalCache;
    private int networkCount;
    private int requestCount;
    int writeAbortCount;
    int writeSuccessCount;

    public Cache(File file, long j) {
        this(file, j, FileSystem.SYSTEM);
    }

    Cache(File file, long j, FileSystem fileSystem) {
        this.internalCache = new InternalCache() { // from class: okhttp3.Cache.1
            {
                Cache.this = this;
            }

            @Override // okhttp3.internal.cache.InternalCache
            public Response get(Request request) throws IOException {
                return Cache.this.get(request);
            }

            @Override // okhttp3.internal.cache.InternalCache
            public CacheRequest put(Response response) throws IOException {
                return Cache.this.put(response);
            }

            @Override // okhttp3.internal.cache.InternalCache
            public void remove(Request request) throws IOException {
                Cache.this.remove(request);
            }

            @Override // okhttp3.internal.cache.InternalCache
            public void update(Response response, Response response2) {
                Cache.this.update(response, response2);
            }

            @Override // okhttp3.internal.cache.InternalCache
            public void trackConditionalCacheHit() {
                Cache.this.trackConditionalCacheHit();
            }

            @Override // okhttp3.internal.cache.InternalCache
            public void trackResponse(CacheStrategy cacheStrategy) {
                Cache.this.trackResponse(cacheStrategy);
            }
        };
        this.cache = DiskLruCache.create(fileSystem, file, VERSION, 2, j);
    }

    public static String key(HttpUrl httpUrl) {
        return ByteString.encodeUtf8(httpUrl.toString()).md5().hex();
    }

    @Nullable
    final Response get(Request request) {
        try {
            DiskLruCache.Snapshot snapshot = this.cache.get(key(request.url()));
            if (snapshot == null) {
                return null;
            }
            try {
                Entry entry = new Entry(snapshot.getSource(0));
                Response response = entry.response(snapshot);
                if (entry.matches(request, response)) {
                    return response;
                }
                Util.closeQuietly(response.body());
                return null;
            } catch (IOException unused) {
                Util.closeQuietly(snapshot);
                return null;
            }
        } catch (IOException unused2) {
        }
    }

    @Nullable
    final CacheRequest put(Response response) {
        DiskLruCache.Editor editor;
        String method = response.request().method();
        if (HttpMethod.invalidatesCache(response.request().method())) {
            try {
                remove(response.request());
            } catch (IOException unused) {
            }
            return null;
        } else if (!method.equals("GET") || HttpHeaders.hasVaryAll(response)) {
            return null;
        } else {
            Entry entry = new Entry(response);
            try {
                editor = this.cache.edit(key(response.request().url()));
                if (editor == null) {
                    return null;
                }
                try {
                    entry.writeTo(editor);
                    return new CacheRequestImpl(editor);
                } catch (IOException unused2) {
                    abortQuietly(editor);
                    return null;
                }
            } catch (IOException unused3) {
                editor = null;
            }
        }
    }

    final void remove(Request request) throws IOException {
        this.cache.remove(key(request.url()));
    }

    final void update(Response response, Response response2) {
        DiskLruCache.Editor editor;
        Entry entry = new Entry(response2);
        try {
            editor = ((CacheResponseBody) response.body()).snapshot.edit();
            if (editor != null) {
                try {
                    entry.writeTo(editor);
                    editor.commit();
                } catch (IOException unused) {
                    abortQuietly(editor);
                }
            }
        } catch (IOException unused2) {
            editor = null;
        }
    }

    private void abortQuietly(@Nullable DiskLruCache.Editor editor) {
        if (editor != null) {
            try {
                editor.abort();
            } catch (IOException unused) {
            }
        }
    }

    public final void initialize() throws IOException {
        this.cache.initialize();
    }

    public final void delete() throws IOException {
        this.cache.delete();
    }

    public final void evictAll() throws IOException {
        this.cache.evictAll();
    }

    /* renamed from: okhttp3.Cache$2 */
    /* loaded from: classes2.dex */
    class AnonymousClass2 implements Iterator<String>, j$.util.Iterator {
        boolean canRemove;
        final Iterator<DiskLruCache.Snapshot> delegate;
        @Nullable
        String nextUrl;

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.getAuthRequestContext(this, consumer);
        }

        @Override // java.util.Iterator
        public /* synthetic */ void forEachRemaining(java.util.function.Consumer<? super String> consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
        }

        AnonymousClass2() throws IOException {
            Cache.this = r1;
            this.delegate = r1.cache.snapshots();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nextUrl != null) {
                return true;
            }
            this.canRemove = false;
            while (this.delegate.hasNext()) {
                DiskLruCache.Snapshot next = this.delegate.next();
                try {
                    this.nextUrl = Okio.KClassImpl$Data$declaredNonStaticMembers$2(next.getSource(0)).NetworkUserEntityData$$ExternalSyntheticLambda5();
                    return true;
                } catch (IOException unused) {
                } finally {
                    next.close();
                }
            }
            return false;
        }

        @Override // java.util.Iterator
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String str = this.nextUrl;
            this.nextUrl = null;
            this.canRemove = true;
            return str;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.canRemove) {
                throw new IllegalStateException("remove() before next()");
            }
            this.delegate.remove();
        }
    }

    public final java.util.Iterator<String> urls() throws IOException {
        return new AnonymousClass2();
    }

    public final int writeAbortCount() {
        int i;
        synchronized (this) {
            i = this.writeAbortCount;
        }
        return i;
    }

    public final int writeSuccessCount() {
        int i;
        synchronized (this) {
            i = this.writeSuccessCount;
        }
        return i;
    }

    public final long size() throws IOException {
        return this.cache.size();
    }

    public final long maxSize() {
        return this.cache.getMaxSize();
    }

    @Override // java.io.Flushable
    public final void flush() throws IOException {
        this.cache.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.cache.close();
    }

    public final File directory() {
        return this.cache.getDirectory();
    }

    public final boolean isClosed() {
        return this.cache.isClosed();
    }

    final void trackResponse(CacheStrategy cacheStrategy) {
        synchronized (this) {
            this.requestCount++;
            if (cacheStrategy.networkRequest != null) {
                this.networkCount++;
            } else if (cacheStrategy.cacheResponse != null) {
                this.hitCount++;
            }
        }
    }

    final void trackConditionalCacheHit() {
        synchronized (this) {
            this.hitCount++;
        }
    }

    public final int networkCount() {
        int i;
        synchronized (this) {
            i = this.networkCount;
        }
        return i;
    }

    public final int hitCount() {
        int i;
        synchronized (this) {
            i = this.hitCount;
        }
        return i;
    }

    public final int requestCount() {
        int i;
        synchronized (this) {
            i = this.requestCount;
        }
        return i;
    }

    /* loaded from: classes6.dex */
    public final class CacheRequestImpl implements CacheRequest {
        private Sink body;
        private Sink cacheOut;
        boolean done;
        private final DiskLruCache.Editor editor;

        CacheRequestImpl(final DiskLruCache.Editor editor) {
            Cache.this = r3;
            this.editor = editor;
            this.cacheOut = editor.newSink(1);
            this.body = new ForwardingSink(this.cacheOut) { // from class: okhttp3.Cache.CacheRequestImpl.1
                {
                    CacheRequestImpl.this = this;
                }

                @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    synchronized (Cache.this) {
                        if (CacheRequestImpl.this.done) {
                            return;
                        }
                        CacheRequestImpl.this.done = true;
                        Cache.this.writeSuccessCount++;
                        super.close();
                        editor.commit();
                    }
                }
            };
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public final void abort() {
            synchronized (Cache.this) {
                if (this.done) {
                    return;
                }
                this.done = true;
                Cache.this.writeAbortCount++;
                Util.closeQuietly(this.cacheOut);
                try {
                    this.editor.abort();
                } catch (IOException unused) {
                }
            }
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public final Sink body() {
            return this.body;
        }
    }

    /* loaded from: classes6.dex */
    public static final class Entry {
        private static final String RECEIVED_MILLIS;
        private static final String SENT_MILLIS;
        private final int code;
        @Nullable
        private final Handshake handshake;
        private final String message;
        private final Protocol protocol;
        private final long receivedResponseMillis;
        private final String requestMethod;
        private final Headers responseHeaders;
        private final long sentRequestMillis;
        private final String url;
        private final Headers varyHeaders;

        static {
            StringBuilder sb = new StringBuilder();
            sb.append(Platform.get().getPrefix());
            sb.append("-Sent-Millis");
            SENT_MILLIS = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Platform.get().getPrefix());
            sb2.append("-Received-Millis");
            RECEIVED_MILLIS = sb2.toString();
        }

        Entry(Source source) throws IOException {
            TlsVersion tlsVersion;
            try {
                BufferedSource KClassImpl$Data$declaredNonStaticMembers$2 = Okio.KClassImpl$Data$declaredNonStaticMembers$2(source);
                this.url = KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda5();
                this.requestMethod = KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda5();
                Headers.Builder builder = new Headers.Builder();
                int readInt = Cache.readInt(KClassImpl$Data$declaredNonStaticMembers$2);
                for (int i = 0; i < readInt; i++) {
                    builder.addLenient(KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda5());
                }
                this.varyHeaders = builder.build();
                StatusLine parse = StatusLine.parse(KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda5());
                this.protocol = parse.protocol;
                this.code = parse.code;
                this.message = parse.message;
                Headers.Builder builder2 = new Headers.Builder();
                int readInt2 = Cache.readInt(KClassImpl$Data$declaredNonStaticMembers$2);
                for (int i2 = 0; i2 < readInt2; i2++) {
                    builder2.addLenient(KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda5());
                }
                String str = SENT_MILLIS;
                String str2 = builder2.get(str);
                String str3 = RECEIVED_MILLIS;
                String str4 = builder2.get(str3);
                builder2.removeAll(str);
                builder2.removeAll(str3);
                this.sentRequestMillis = str2 != null ? Long.parseLong(str2) : 0L;
                this.receivedResponseMillis = str4 != null ? Long.parseLong(str4) : 0L;
                this.responseHeaders = builder2.build();
                if (isHttps()) {
                    String NetworkUserEntityData$$ExternalSyntheticLambda5 = KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda5();
                    if (NetworkUserEntityData$$ExternalSyntheticLambda5.length() > 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("expected \"\" but was \"");
                        sb.append(NetworkUserEntityData$$ExternalSyntheticLambda5);
                        sb.append("\"");
                        throw new IOException(sb.toString());
                    }
                    CipherSuite forJavaName = CipherSuite.forJavaName(KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda5());
                    List<Certificate> readCertificateList = readCertificateList(KClassImpl$Data$declaredNonStaticMembers$2);
                    List<Certificate> readCertificateList2 = readCertificateList(KClassImpl$Data$declaredNonStaticMembers$2);
                    if (!KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest()) {
                        tlsVersion = TlsVersion.forJavaName(KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda5());
                    } else {
                        tlsVersion = TlsVersion.SSL_3_0;
                    }
                    this.handshake = Handshake.get(tlsVersion, forJavaName, readCertificateList, readCertificateList2);
                } else {
                    this.handshake = null;
                }
            } finally {
                source.close();
            }
        }

        Entry(Response response) {
            this.url = response.request().url().toString();
            this.varyHeaders = HttpHeaders.varyHeaders(response);
            this.requestMethod = response.request().method();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.responseHeaders = response.headers();
            this.handshake = response.handshake();
            this.sentRequestMillis = response.sentRequestAtMillis();
            this.receivedResponseMillis = response.receivedResponseAtMillis();
        }

        public final void writeTo(DiskLruCache.Editor editor) throws IOException {
            BufferedSink BuiltInFictitiousFunctionClassFactory = Okio.BuiltInFictitiousFunctionClassFactory(editor.newSink(0));
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(this.url).PlaceComponentResult(10);
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(this.requestMethod).PlaceComponentResult(10);
            BuiltInFictitiousFunctionClassFactory.moveToNextValue(this.varyHeaders.size()).PlaceComponentResult(10);
            int size = this.varyHeaders.size();
            for (int i = 0; i < size; i++) {
                BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(this.varyHeaders.name(i)).BuiltInFictitiousFunctionClassFactory(": ").BuiltInFictitiousFunctionClassFactory(this.varyHeaders.value(i)).PlaceComponentResult(10);
            }
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(new StatusLine(this.protocol, this.code, this.message).toString()).PlaceComponentResult(10);
            BuiltInFictitiousFunctionClassFactory.moveToNextValue(this.responseHeaders.size() + 2).PlaceComponentResult(10);
            int size2 = this.responseHeaders.size();
            for (int i2 = 0; i2 < size2; i2++) {
                BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(this.responseHeaders.name(i2)).BuiltInFictitiousFunctionClassFactory(": ").BuiltInFictitiousFunctionClassFactory(this.responseHeaders.value(i2)).PlaceComponentResult(10);
            }
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(SENT_MILLIS).BuiltInFictitiousFunctionClassFactory(": ").moveToNextValue(this.sentRequestMillis).PlaceComponentResult(10);
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(RECEIVED_MILLIS).BuiltInFictitiousFunctionClassFactory(": ").moveToNextValue(this.receivedResponseMillis).PlaceComponentResult(10);
            if (isHttps()) {
                BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(10);
                BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(this.handshake.cipherSuite().javaName()).PlaceComponentResult(10);
                writeCertList(BuiltInFictitiousFunctionClassFactory, this.handshake.peerCertificates());
                writeCertList(BuiltInFictitiousFunctionClassFactory, this.handshake.localCertificates());
                BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(this.handshake.tlsVersion().javaName()).PlaceComponentResult(10);
            }
            BuiltInFictitiousFunctionClassFactory.close();
        }

        private boolean isHttps() {
            return this.url.startsWith("https://");
        }

        private List<Certificate> readCertificateList(BufferedSource bufferedSource) throws IOException {
            int readInt = Cache.readInt(bufferedSource);
            if (readInt == -1) {
                return Collections.emptyList();
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(readInt);
                for (int i = 0; i < readInt; i++) {
                    String NetworkUserEntityData$$ExternalSyntheticLambda5 = bufferedSource.NetworkUserEntityData$$ExternalSyntheticLambda5();
                    Buffer buffer = new Buffer();
                    ByteString decodeBase64 = ByteString.decodeBase64(NetworkUserEntityData$$ExternalSyntheticLambda5);
                    if (decodeBase64 == null) {
                        throw new IllegalArgumentException("byteString == null");
                    }
                    decodeBase64.write(buffer);
                    arrayList.add(certificateFactory.generateCertificate(new Buffer.AnonymousClass2()));
                }
                return arrayList;
            } catch (CertificateException e) {
                throw new IOException(e.getMessage());
            }
        }

        private void writeCertList(BufferedSink bufferedSink, List<Certificate> list) throws IOException {
            try {
                bufferedSink.moveToNextValue(list.size()).PlaceComponentResult(10);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    bufferedSink.BuiltInFictitiousFunctionClassFactory(ByteString.of(list.get(i).getEncoded()).base64()).PlaceComponentResult(10);
                }
            } catch (CertificateEncodingException e) {
                throw new IOException(e.getMessage());
            }
        }

        public final boolean matches(Request request, Response response) {
            return this.url.equals(request.url().toString()) && this.requestMethod.equals(request.method()) && HttpHeaders.varyMatches(response, this.varyHeaders, request);
        }

        public final Response response(DiskLruCache.Snapshot snapshot) {
            String str = this.responseHeaders.get("Content-Type");
            String str2 = this.responseHeaders.get(com.google.common.net.HttpHeaders.CONTENT_LENGTH);
            return new Response.Builder().request(new Request.Builder().url(this.url).method(this.requestMethod, null).headers(this.varyHeaders).build()).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body(new CacheResponseBody(snapshot, str, str2)).handshake(this.handshake).sentRequestAtMillis(this.sentRequestMillis).receivedResponseAtMillis(this.receivedResponseMillis).build();
        }
    }

    static int readInt(BufferedSource bufferedSource) throws IOException {
        try {
            long NetworkUserEntityData$$ExternalSyntheticLambda2 = bufferedSource.NetworkUserEntityData$$ExternalSyntheticLambda2();
            String NetworkUserEntityData$$ExternalSyntheticLambda5 = bufferedSource.NetworkUserEntityData$$ExternalSyntheticLambda5();
            if (NetworkUserEntityData$$ExternalSyntheticLambda2 < 0 || NetworkUserEntityData$$ExternalSyntheticLambda2 > 2147483647L || !NetworkUserEntityData$$ExternalSyntheticLambda5.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                sb.append("expected an int but was \"");
                sb.append(NetworkUserEntityData$$ExternalSyntheticLambda2);
                sb.append(NetworkUserEntityData$$ExternalSyntheticLambda5);
                sb.append("\"");
                throw new IOException(sb.toString());
            }
            return (int) NetworkUserEntityData$$ExternalSyntheticLambda2;
        } catch (NumberFormatException e) {
            throw new IOException(e.getMessage());
        }
    }

    /* loaded from: classes6.dex */
    public static class CacheResponseBody extends ResponseBody {
        private final BufferedSource bodySource;
        @Nullable
        private final String contentLength;
        @Nullable
        private final String contentType;
        final DiskLruCache.Snapshot snapshot;

        CacheResponseBody(final DiskLruCache.Snapshot snapshot, String str, String str2) {
            this.snapshot = snapshot;
            this.contentType = str;
            this.contentLength = str2;
            this.bodySource = Okio.KClassImpl$Data$declaredNonStaticMembers$2(new ForwardingSource(snapshot.getSource(1)) { // from class: okhttp3.Cache.CacheResponseBody.1
                {
                    CacheResponseBody.this = this;
                }

                @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    snapshot.close();
                    super.close();
                }
            });
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            String str = this.contentType;
            if (str != null) {
                return MediaType.parse(str);
            }
            return null;
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            try {
                String str = this.contentLength;
                if (str != null) {
                    return Long.parseLong(str);
                }
                return -1L;
            } catch (NumberFormatException unused) {
                return -1L;
            }
        }

        @Override // okhttp3.ResponseBody
        public BufferedSource source() {
            return this.bodySource;
        }
    }
}
