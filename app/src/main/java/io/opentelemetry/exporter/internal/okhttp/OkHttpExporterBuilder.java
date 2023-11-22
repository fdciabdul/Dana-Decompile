package io.opentelemetry.exporter.internal.okhttp;

import com.alipay.imobile.network.quake.transport.http.constant.HeaderConstant;
import com.fullstory.instrumentation.InstrumentInjector;
import io.opentelemetry.api.metrics.MeterProvider;
import io.opentelemetry.exporter.internal.ExporterBuilderUtil;
import io.opentelemetry.exporter.internal.TlsUtil;
import io.opentelemetry.exporter.internal.auth.Authenticator;
import io.opentelemetry.exporter.internal.marshal.Marshaler;
import io.opentelemetry.exporter.internal.retry.RetryInterceptor;
import io.opentelemetry.exporter.internal.retry.RetryPolicy;
import j$.time.Duration;
import j$.util.Map;
import j$.util.function.BiConsumer;
import j$.util.function.Function;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.SSLException;
import javax.net.ssl.X509TrustManager;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

/* loaded from: classes9.dex */
public final class OkHttpExporterBuilder<T extends Marshaler> {
    public static final long DEFAULT_TIMEOUT_SECS = 10;
    @Nullable
    private Authenticator authenticator;
    @Nullable
    private byte[] certificatePem;
    private String endpoint;
    private final String exporterName;
    @Nullable
    private Headers.Builder headersBuilder;
    @Nullable
    private byte[] privateKeyPem;
    @Nullable
    private RetryPolicy retryPolicy;
    @Nullable
    private byte[] trustedCertificatesPem;
    private final String type;
    private long timeoutNanos = TimeUnit.SECONDS.toNanos(10);
    private boolean compressionEnabled = false;
    private boolean exportAsJson = false;
    private MeterProvider meterProvider = MeterProvider.CC.noop();

    public OkHttpExporterBuilder(String str, String str2, String str3) {
        this.exporterName = str;
        this.type = str2;
        this.endpoint = str3;
    }

    public final OkHttpExporterBuilder<T> setTimeout(long j, TimeUnit timeUnit) {
        this.timeoutNanos = timeUnit.toNanos(j);
        return this;
    }

    public final OkHttpExporterBuilder<T> setTimeout(Duration duration) {
        return setTimeout(duration.toNanos(), TimeUnit.NANOSECONDS);
    }

    public final OkHttpExporterBuilder<T> setEndpoint(String str) {
        this.endpoint = ExporterBuilderUtil.validateEndpoint(str).toString();
        return this;
    }

    public final OkHttpExporterBuilder<T> setCompression(String str) {
        if (str.equals(HeaderConstant.HEADER_VALUE_CONTENT_ENCODING_GZIP)) {
            this.compressionEnabled = true;
        }
        return this;
    }

    public final OkHttpExporterBuilder<T> addHeader(String str, String str2) {
        if (this.headersBuilder == null) {
            this.headersBuilder = new Headers.Builder();
        }
        this.headersBuilder.add(str, str2);
        return this;
    }

    public final OkHttpExporterBuilder<T> setAuthenticator(Authenticator authenticator) {
        this.authenticator = authenticator;
        return this;
    }

    public final OkHttpExporterBuilder<T> setTrustedCertificates(byte[] bArr) {
        this.trustedCertificatesPem = bArr;
        return this;
    }

    public final OkHttpExporterBuilder<T> setClientTls(byte[] bArr, byte[] bArr2) {
        this.privateKeyPem = bArr;
        this.certificatePem = bArr2;
        return this;
    }

    public final OkHttpExporterBuilder<T> setMeterProvider(MeterProvider meterProvider) {
        this.meterProvider = meterProvider;
        return this;
    }

    public final OkHttpExporterBuilder<T> setRetryPolicy(RetryPolicy retryPolicy) {
        this.retryPolicy = retryPolicy;
        return this;
    }

    public final OkHttpExporterBuilder<T> exportAsJson() {
        this.exportAsJson = true;
        return this;
    }

    public final OkHttpExporter<T> build() {
        byte[] bArr;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        InstrumentInjector.okhttp_addInterceptors(builder);
        OkHttpClient.Builder callTimeout = builder.dispatcher(OkHttpUtil.newDispatcher()).callTimeout(Duration.ofNanos(this.timeoutNanos));
        byte[] bArr2 = this.trustedCertificatesPem;
        if (bArr2 != null) {
            try {
                X509TrustManager trustManager = TlsUtil.trustManager(bArr2);
                byte[] bArr3 = this.privateKeyPem;
                callTimeout.sslSocketFactory(TlsUtil.sslSocketFactory((bArr3 == null || (bArr = this.certificatePem) == null) ? null : TlsUtil.keyManager(bArr3, bArr), trustManager), trustManager);
            } catch (SSLException e) {
                throw new IllegalStateException("Could not set trusted certificate for OTLP HTTP connection, are they valid X.509 in PEM format?", e);
            }
        }
        Headers.Builder builder2 = this.headersBuilder;
        Headers build = builder2 != null ? builder2.build() : null;
        RetryPolicy retryPolicy = this.retryPolicy;
        if (retryPolicy != null) {
            callTimeout.addInterceptor(new RetryInterceptor(retryPolicy, new Function() { // from class: io.opentelemetry.exporter.internal.okhttp.OkHttpExporterBuilder$$ExternalSyntheticLambda0
                @Override // j$.util.function.Function
                /* renamed from: andThen */
                public final /* synthetic */ Function mo3169andThen(Function function) {
                    return Function.CC.getAuthRequestContext(this, function);
                }

                @Override // j$.util.function.Function
                public final Object apply(Object obj) {
                    return Boolean.valueOf(OkHttpExporter.isRetryable((Response) obj));
                }

                @Override // j$.util.function.Function
                public final /* synthetic */ Function compose(Function function) {
                    return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
                }
            }));
        }
        final Authenticator authenticator = this.authenticator;
        if (authenticator != null) {
            callTimeout.authenticator(new okhttp3.Authenticator() { // from class: io.opentelemetry.exporter.internal.okhttp.OkHttpExporterBuilder$$ExternalSyntheticLambda1
                @Override // okhttp3.Authenticator
                public final Request authenticate(Route route, Response response) {
                    return OkHttpExporterBuilder.lambda$build$0(Authenticator.this, route, response);
                }
            });
        }
        return new OkHttpExporter<>(this.exporterName, this.type, callTimeout.build(), this.meterProvider, this.endpoint, build, this.compressionEnabled, this.exportAsJson);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Request lambda$build$0(Authenticator authenticator, Route route, Response response) throws IOException {
        final Request.Builder newBuilder = response.request().newBuilder();
        Map<String, String> headers = authenticator.getHeaders();
        Objects.requireNonNull(newBuilder);
        Map.EL.KClassImpl$Data$declaredNonStaticMembers$2(headers, new BiConsumer() { // from class: io.opentelemetry.exporter.internal.okhttp.OkHttpExporterBuilder$$ExternalSyntheticLambda2
            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                Request.Builder.this.header((String) obj, (String) obj2);
            }

            @Override // j$.util.function.BiConsumer
            public final /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer.CC.getAuthRequestContext(this, biConsumer);
            }
        });
        return newBuilder.build();
    }
}
