package com.alipay.a.a.a.a;

import android.net.SSLCertificateSocketFactory;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import com.alipay.android.phone.mobilesdk.socketcraft.WebSocket;
import com.alipay.imobile.network.quake.transport.http.constant.HeaderConstant;
import com.alipay.mobile.verifyidentity.business.securitycommon.widget.ConvertUtils;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.net.HttpHeaders;
import com.google.firebase.perf.network.FirebasePerfHttpClient;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URI;
import java.security.Security;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultRedirectHandler;
import org.apache.http.impl.client.RequestWrapper;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.HttpContext;

/* loaded from: classes3.dex */
public final class b implements HttpClient {

    /* renamed from: a  reason: collision with root package name */
    public static long f6820a = 160;
    private static String[] c = {"text/", "application/xml", "application/json"};
    private static final HttpRequestInterceptor d = new HttpRequestInterceptor() { // from class: com.alipay.a.a.a.a.b.1
        @Override // org.apache.http.HttpRequestInterceptor
        public final void process(HttpRequest httpRequest, HttpContext httpContext) {
            if (Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper()) {
                throw new RuntimeException("This thread forbids HTTP requests");
            }
        }
    };
    final HttpClient b;
    private RuntimeException e = new IllegalStateException("AndroidHttpClient created and never closed");
    private volatile C0053b f;

    /* renamed from: com.alipay.a.a.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static final class C0053b {

        /* renamed from: a  reason: collision with root package name */
        final String f6825a;
        final int b;
    }

    private b(ClientConnectionManager clientConnectionManager, HttpParams httpParams) {
        this.b = new DefaultHttpClient(clientConnectionManager, httpParams) { // from class: com.alipay.a.a.a.a.b.2
            @Override // org.apache.http.impl.client.DefaultHttpClient, org.apache.http.impl.client.AbstractHttpClient
            protected final BasicHttpProcessor createHttpProcessor() {
                BasicHttpProcessor createHttpProcessor = super.createHttpProcessor();
                createHttpProcessor.addRequestInterceptor(b.d);
                createHttpProcessor.addRequestInterceptor(new a(b.this, (byte) 0));
                return createHttpProcessor;
            }

            @Override // org.apache.http.impl.client.DefaultHttpClient, org.apache.http.impl.client.AbstractHttpClient
            protected final HttpContext createHttpContext() {
                BasicHttpContext basicHttpContext = new BasicHttpContext();
                basicHttpContext.setAttribute("http.authscheme-registry", getAuthSchemes());
                basicHttpContext.setAttribute("http.cookiespec-registry", getCookieSpecs());
                basicHttpContext.setAttribute("http.auth.credentials-provider", getCredentialsProvider());
                return basicHttpContext;
            }

            @Override // org.apache.http.impl.client.DefaultHttpClient, org.apache.http.impl.client.AbstractHttpClient
            protected final RedirectHandler createRedirectHandler() {
                return new DefaultRedirectHandler() { // from class: com.alipay.a.a.a.a.b.2.1

                    /* renamed from: a  reason: collision with root package name */
                    int f6822a;

                    @Override // org.apache.http.impl.client.DefaultRedirectHandler, org.apache.http.client.RedirectHandler
                    public final boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
                        int statusCode;
                        this.f6822a++;
                        boolean isRedirectRequested = super.isRedirectRequested(httpResponse, httpContext);
                        if (isRedirectRequested || this.f6822a >= 5 || !((statusCode = httpResponse.getStatusLine().getStatusCode()) == 301 || statusCode == 302)) {
                            return isRedirectRequested;
                        }
                        return true;
                    }
                };
            }

            @Override // org.apache.http.impl.client.DefaultHttpClient, org.apache.http.impl.client.AbstractHttpClient
            protected final ConnectionKeepAliveStrategy createConnectionKeepAliveStrategy() {
                return new ConnectionKeepAliveStrategy() { // from class: com.alipay.a.a.a.a.b.2.2
                    @Override // org.apache.http.conn.ConnectionKeepAliveStrategy
                    public final long getKeepAliveDuration(HttpResponse httpResponse, HttpContext httpContext) {
                        return 180000L;
                    }
                };
            }
        };
    }

    public static void a(HttpRequest httpRequest) {
        httpRequest.addHeader(HttpHeaders.ACCEPT_ENCODING, HeaderConstant.HEADER_VALUE_CONTENT_ENCODING_GZIP);
    }

    public static void b(HttpRequest httpRequest) {
        httpRequest.addHeader(HttpHeaders.CONNECTION, HttpHeaders.KEEP_ALIVE);
    }

    public static InputStream a(HttpEntity httpEntity) {
        Header contentEncoding;
        String value;
        InputStream content = httpEntity.getContent();
        return (content == null || (contentEncoding = httpEntity.getContentEncoding()) == null || (value = contentEncoding.getValue()) == null || !value.contains(HeaderConstant.HEADER_VALUE_CONTENT_ENCODING_GZIP)) ? content : new GZIPInputStream(content);
    }

    @Override // org.apache.http.client.HttpClient
    public final HttpParams getParams() {
        return this.b.getParams();
    }

    @Override // org.apache.http.client.HttpClient
    public final ClientConnectionManager getConnectionManager() {
        return this.b.getConnectionManager();
    }

    @Override // org.apache.http.client.HttpClient
    public final HttpResponse execute(HttpUriRequest httpUriRequest) {
        return FirebasePerfHttpClient.execute(this.b, httpUriRequest);
    }

    @Override // org.apache.http.client.HttpClient
    public final HttpResponse execute(HttpUriRequest httpUriRequest, HttpContext httpContext) {
        return FirebasePerfHttpClient.execute(this.b, httpUriRequest, httpContext);
    }

    @Override // org.apache.http.client.HttpClient
    public final HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest) {
        return FirebasePerfHttpClient.execute(this.b, httpHost, httpRequest);
    }

    @Override // org.apache.http.client.HttpClient
    public final HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) {
        return FirebasePerfHttpClient.execute(this.b, httpHost, httpRequest, httpContext);
    }

    @Override // org.apache.http.client.HttpClient
    public final <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler) {
        return (T) FirebasePerfHttpClient.execute(this.b, httpUriRequest, responseHandler);
    }

    @Override // org.apache.http.client.HttpClient
    public final <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) {
        return (T) FirebasePerfHttpClient.execute(this.b, httpUriRequest, responseHandler, httpContext);
    }

    @Override // org.apache.http.client.HttpClient
    public final <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) {
        return (T) FirebasePerfHttpClient.execute(this.b, httpHost, httpRequest, responseHandler);
    }

    @Override // org.apache.http.client.HttpClient
    public final <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) {
        return (T) FirebasePerfHttpClient.execute(this.b, httpHost, httpRequest, responseHandler, httpContext);
    }

    public static AbstractHttpEntity a(byte[] bArr) {
        InstrumentInjector.log_i("RPC_PERF", "gzip...");
        if (bArr.length < f6820a) {
            return new ByteArrayEntity(bArr);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(bArr);
        gZIPOutputStream.close();
        ByteArrayEntity byteArrayEntity = new ByteArrayEntity(byteArrayOutputStream.toByteArray());
        byteArrayEntity.setContentEncoding(HeaderConstant.HEADER_VALUE_CONTENT_ENCODING_GZIP);
        StringBuilder sb = new StringBuilder("gzip size:");
        sb.append(bArr.length);
        sb.append("->");
        sb.append(byteArrayEntity.getContentLength());
        InstrumentInjector.log_i("RPC_PERF", sb.toString());
        return byteArrayEntity;
    }

    /* loaded from: classes6.dex */
    final class a implements HttpRequestInterceptor {
        private a() {
        }

        /* synthetic */ a(b bVar, byte b) {
            this();
        }

        @Override // org.apache.http.HttpRequestInterceptor
        public final void process(HttpRequest httpRequest, HttpContext httpContext) {
            C0053b c0053b = b.this.f;
            if (c0053b != null && Log.isLoggable(c0053b.f6825a, c0053b.b) && (httpRequest instanceof HttpUriRequest)) {
                b.a((HttpUriRequest) httpRequest);
                int i = c0053b.b;
                String str = c0053b.f6825a;
            }
        }
    }

    private static boolean b(HttpUriRequest httpUriRequest) {
        Header[] headers = httpUriRequest.getHeaders("content-encoding");
        if (headers != null) {
            for (Header header : headers) {
                if (HeaderConstant.HEADER_VALUE_CONTENT_ENCODING_GZIP.equalsIgnoreCase(header.getValue())) {
                    return true;
                }
            }
        }
        Header[] headers2 = httpUriRequest.getHeaders("content-type");
        if (headers2 != null) {
            for (Header header2 : headers2) {
                for (String str : c) {
                    if (header2.getValue().startsWith(str)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static long b(String str) {
        return f.a(str);
    }

    public static b a(String str) {
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setUseExpectContinue(basicHttpParams, false);
        HttpConnectionParams.setStaleCheckingEnabled(basicHttpParams, true);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 20000);
        HttpConnectionParams.setSoTimeout(basicHttpParams, 30000);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
        HttpClientParams.setRedirecting(basicHttpParams, true);
        HttpClientParams.setAuthenticating(basicHttpParams, false);
        HttpProtocolParams.setUserAgent(basicHttpParams, str);
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme(SemanticAttributes.FaasTriggerValues.HTTP, PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLCertificateSocketFactory.getHttpSocketFactory(30000, null), WebSocket.DEFAULT_WSS_PORT));
        ThreadSafeClientConnManager threadSafeClientConnManager = new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry);
        ConnManagerParams.setTimeout(basicHttpParams, 60000L);
        ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRouteBean(10));
        ConnManagerParams.setMaxTotalConnections(basicHttpParams, 50);
        Security.setProperty("networkaddress.cache.ttl", "-1");
        HttpsURLConnection.setDefaultHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        return new b(threadSafeClientConnManager, basicHttpParams);
    }

    static /* synthetic */ String a(HttpUriRequest httpUriRequest) {
        HttpEntity entity;
        StringBuilder sb = new StringBuilder();
        sb.append("curl ");
        for (Header header : httpUriRequest.getAllHeaders()) {
            if (!header.getName().equals("Authorization") && !header.getName().equals("Cookie")) {
                sb.append("--header \"");
                sb.append(header.toString().trim());
                sb.append("\" ");
            }
        }
        URI uri = httpUriRequest.getURI();
        if (httpUriRequest instanceof RequestWrapper) {
            HttpRequest original = ((RequestWrapper) httpUriRequest).getOriginal();
            if (original instanceof HttpUriRequest) {
                uri = ((HttpUriRequest) original).getURI();
            }
        }
        sb.append("\"");
        sb.append(uri);
        sb.append("\"");
        if ((httpUriRequest instanceof HttpEntityEnclosingRequest) && (entity = ((HttpEntityEnclosingRequest) httpUriRequest).getEntity()) != null && entity.isRepeatable()) {
            if (entity.getContentLength() < ConvertUtils.KB) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                entity.writeTo(byteArrayOutputStream);
                if (b(httpUriRequest)) {
                    String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                    StringBuilder sb2 = new StringBuilder("echo '");
                    sb2.append(encodeToString);
                    sb2.append("' | base64 -d > /tmp/$$.bin; ");
                    sb.insert(0, sb2.toString());
                    sb.append(" --data-binary @/tmp/$$.bin");
                } else {
                    String obj = byteArrayOutputStream.toString();
                    sb.append(" --data-ascii \"");
                    sb.append(obj);
                    sb.append("\"");
                }
            } else {
                sb.append(" [TOO MUCH DATA TO INCLUDE]");
            }
        }
        return sb.toString();
    }
}
