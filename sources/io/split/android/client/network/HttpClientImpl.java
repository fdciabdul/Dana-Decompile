package io.split.android.client.network;

import android.content.Context;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Strings;
import io.split.android.client.utils.logger.Logger;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URI;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

/* loaded from: classes6.dex */
public class HttpClientImpl implements HttpClient {
    private static final String PROXY_AUTHORIZATION_HEADER = "Proxy-Authorization";
    private static final long STREAMING_READ_TIMEOUT_IN_MILLISECONDS = 80000;
    private final Map<String, String> mCommonHeaders;
    private final OkHttpClient mOkHttpClient;
    private final OkHttpClient mOkHttpClientStreaming;
    private final Map<String, String> mStreamingHeaders;

    private HttpClientImpl(OkHttpClient okHttpClient, OkHttpClient okHttpClient2) {
        this.mCommonHeaders = new HashMap();
        this.mStreamingHeaders = new HashMap();
        this.mOkHttpClient = okHttpClient;
        this.mOkHttpClientStreaming = okHttpClient2;
    }

    @Override // io.split.android.client.network.HttpClient
    public HttpRequest request(URI uri, HttpMethod httpMethod, String str, Map<String, String> map) {
        HashMap hashMap = new HashMap(this.mCommonHeaders);
        if (map != null) {
            hashMap.putAll(map);
        }
        return new HttpRequestImpl(this.mOkHttpClient, uri, httpMethod, str, hashMap);
    }

    @Override // io.split.android.client.network.HttpClient
    public HttpRequest request(URI uri, HttpMethod httpMethod) {
        return request(uri, httpMethod, null);
    }

    @Override // io.split.android.client.network.HttpClient
    public HttpRequest request(URI uri, HttpMethod httpMethod, String str) {
        return request(uri, httpMethod, str, null);
    }

    @Override // io.split.android.client.network.HttpClient
    public HttpStreamRequest streamRequest(URI uri) {
        return new HttpStreamRequestImpl(this.mOkHttpClientStreaming, uri, this.mStreamingHeaders);
    }

    @Override // io.split.android.client.network.HttpClient
    public void setHeader(String str, String str2) {
        if (str == null || str2 == null) {
            throw new IllegalArgumentException(String.format("Invalid value for header %s: %s", str, str2));
        }
        this.mCommonHeaders.put(str, str2);
    }

    @Override // io.split.android.client.network.HttpClient
    public void setStreamingHeader(String str, String str2) {
        if (str == null || str2 == null) {
            throw new IllegalArgumentException(String.format("Invalid value for streaming header %s: %s", str, str2));
        }
        this.mStreamingHeaders.put(str, str2);
    }

    @Override // io.split.android.client.network.HttpClient
    public void addHeaders(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            setHeader(entry.getKey(), entry.getValue());
        }
    }

    @Override // io.split.android.client.network.HttpClient
    public void addStreamingHeaders(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            setStreamingHeader(entry.getKey(), entry.getValue());
        }
    }

    @Override // io.split.android.client.network.HttpClient
    public void close() {
        this.mOkHttpClient.connectionPool().evictAll();
        this.mOkHttpClientStreaming.connectionPool().evictAll();
    }

    /* loaded from: classes6.dex */
    public static class Builder {
        private Context mHostAppContext;
        private HttpProxy mProxy;
        private Authenticator mProxyAuthenticator;
        private long readTimeout = -1;
        private long connectionTimeout = -1;
        private DevelopmentSslConfig developmentSslConfig = null;

        public Builder setContext(Context context) {
            this.mHostAppContext = context;
            return this;
        }

        public Builder setProxy(HttpProxy httpProxy) {
            this.mProxy = httpProxy;
            return this;
        }

        public Builder setProxyAuthenticator(Authenticator authenticator) {
            this.mProxyAuthenticator = authenticator;
            return this;
        }

        public Builder setReadTimeout(long j) {
            this.readTimeout = j;
            return this;
        }

        public Builder setConnectionTimeout(long j) {
            this.connectionTimeout = j;
            return this;
        }

        public Builder setDevelopmentSslConfig(DevelopmentSslConfig developmentSslConfig) {
            this.developmentSslConfig = developmentSslConfig;
            return this;
        }

        public HttpClient build() {
            Proxy proxy;
            Authenticator authenticator;
            HttpProxy httpProxy = this.mProxy;
            if (httpProxy != null) {
                proxy = createProxy(httpProxy);
                authenticator = this.mProxyAuthenticator;
                if (authenticator == null) {
                    authenticator = !Strings.isNullOrEmpty(this.mProxy.getUsername()) ? createBasicAuthenticator(this.mProxy.getUsername(), this.mProxy.getPassword()) : null;
                }
            } else {
                proxy = null;
                authenticator = null;
            }
            return new HttpClientImpl(createOkHttpClient(proxy, authenticator, Long.valueOf(this.readTimeout), Long.valueOf(this.connectionTimeout), this.developmentSslConfig, this.mHostAppContext), createOkHttpClient(proxy, authenticator, Long.valueOf((long) HttpClientImpl.STREAMING_READ_TIMEOUT_IN_MILLISECONDS), Long.valueOf(this.connectionTimeout), this.developmentSslConfig, this.mHostAppContext));
        }

        private OkHttpClient createOkHttpClient(Proxy proxy, Authenticator authenticator, Long l, Long l2, DevelopmentSslConfig developmentSslConfig, Context context) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            InstrumentInjector.okhttp_addInterceptors(builder);
            if (proxy != null) {
                builder.proxy(proxy);
            }
            if (authenticator != null) {
                builder.proxyAuthenticator(authenticator);
            }
            if (l != null && l.longValue() > 0) {
                builder.readTimeout(l.longValue(), TimeUnit.MILLISECONDS);
            }
            if (l2 != null && l2.longValue() > 0) {
                builder.connectTimeout(l2.longValue(), TimeUnit.MILLISECONDS);
            }
            if (developmentSslConfig != null) {
                builder.sslSocketFactory(developmentSslConfig.getSslSocketFactory(), developmentSslConfig.getTrustManager());
                builder.hostnameVerifier(developmentSslConfig.getHostnameVerifier());
            } else if (LegacyTlsUpdater.couldBeOld()) {
                forceTls12OnOldAndroid(builder, context);
            }
            return builder.build();
        }

        private Proxy createProxy(HttpProxy httpProxy) {
            if (httpProxy == null) {
                return null;
            }
            return new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(httpProxy.getHost(), httpProxy.getPort()));
        }

        private Authenticator createBasicAuthenticator(final String str, final String str2) {
            return new Authenticator() { // from class: io.split.android.client.network.HttpClientImpl.Builder.1
                @Override // okhttp3.Authenticator
                public Request authenticate(Route route, Response response) throws IOException {
                    return response.request().newBuilder().header("Proxy-Authorization", Credentials.basic(str, str2)).build();
                }
            };
        }

        private void forceTls12OnOldAndroid(OkHttpClient.Builder builder, Context context) {
            LegacyTlsUpdater.update(context);
            try {
                Tls12OnlySocketFactory tls12OnlySocketFactory = new Tls12OnlySocketFactory();
                builder.sslSocketFactory(tls12OnlySocketFactory, tls12OnlySocketFactory.defaultTrustManager());
            } catch (KeyManagementException e) {
                e = e;
                StringBuilder sb = new StringBuilder();
                sb.append("TLS v12 algorithm not available: ");
                sb.append(e.getLocalizedMessage());
                Logger.e(sb.toString());
            } catch (NoSuchAlgorithmException e2) {
                e = e2;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("TLS v12 algorithm not available: ");
                sb2.append(e.getLocalizedMessage());
                Logger.e(sb2.toString());
            } catch (GeneralSecurityException e3) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("TLS v12 security error: ");
                sb3.append(e3.getLocalizedMessage());
                Logger.e(sb3.toString());
            } catch (Exception e4) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Unknown TLS v12 error: ");
                sb4.append(e4.getLocalizedMessage());
                Logger.e(sb4.toString());
            }
        }
    }
}
