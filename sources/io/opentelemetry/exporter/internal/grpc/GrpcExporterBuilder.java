package io.opentelemetry.exporter.internal.grpc;

import com.alipay.imobile.network.quake.transport.http.constant.HeaderConstant;
import com.fullstory.instrumentation.InstrumentInjector;
import io.grpc.Channel;
import io.grpc.ClientInterceptor;
import io.grpc.ClientInterceptors;
import io.grpc.Codec;
import io.grpc.ManagedChannel;
import io.grpc.Metadata;
import io.grpc.stub.MetadataUtils;
import io.opentelemetry.api.metrics.MeterProvider;
import io.opentelemetry.exporter.internal.ExporterBuilderUtil;
import io.opentelemetry.exporter.internal.TlsUtil;
import io.opentelemetry.exporter.internal.marshal.Marshaler;
import io.opentelemetry.exporter.internal.okhttp.OkHttpUtil;
import io.opentelemetry.exporter.internal.retry.RetryInterceptor;
import io.opentelemetry.exporter.internal.retry.RetryPolicy;
import j$.time.Duration;
import j$.util.Map;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import j$.util.function.Supplier;
import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.SSLException;
import javax.net.ssl.X509TrustManager;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Response;

/* loaded from: classes9.dex */
public class GrpcExporterBuilder<T extends Marshaler> {
    @Nullable
    private byte[] certificatePem;
    private URI endpoint;
    private final String exporterName;
    @Nullable
    private Object grpcChannel;
    private final String grpcEndpointPath;
    private final Supplier<BiFunction<Channel, String, MarshalerServiceStub<T, ?, ?>>> grpcStubFactory;
    @Nullable
    private byte[] privateKeyPem;
    @Nullable
    private RetryPolicy retryPolicy;
    private long timeoutNanos;
    @Nullable
    private byte[] trustedCertificatesPem;
    private final String type;
    private boolean compressionEnabled = false;
    private final Map<String, String> headers = new HashMap();
    private MeterProvider meterProvider = MeterProvider.CC.noop();

    /* JADX INFO: Access modifiers changed from: package-private */
    public GrpcExporterBuilder(String str, String str2, long j, URI uri, Supplier<BiFunction<Channel, String, MarshalerServiceStub<T, ?, ?>>> supplier, String str3) {
        this.exporterName = str;
        this.type = str2;
        this.grpcEndpointPath = str3;
        this.timeoutNanos = TimeUnit.SECONDS.toNanos(j);
        this.endpoint = uri;
        this.grpcStubFactory = supplier;
    }

    public GrpcExporterBuilder<T> setChannel(ManagedChannel managedChannel) {
        this.grpcChannel = managedChannel;
        return this;
    }

    public GrpcExporterBuilder<T> setTimeout(long j, TimeUnit timeUnit) {
        this.timeoutNanos = timeUnit.toNanos(j);
        return this;
    }

    public GrpcExporterBuilder<T> setTimeout(Duration duration) {
        return setTimeout(duration.toNanos(), TimeUnit.NANOSECONDS);
    }

    public GrpcExporterBuilder<T> setEndpoint(String str) {
        this.endpoint = ExporterBuilderUtil.validateEndpoint(str);
        return this;
    }

    public GrpcExporterBuilder<T> setCompression(String str) {
        this.compressionEnabled = true;
        return this;
    }

    public GrpcExporterBuilder<T> setTrustedCertificates(byte[] bArr) {
        this.trustedCertificatesPem = bArr;
        return this;
    }

    public GrpcExporterBuilder<T> setClientTls(byte[] bArr, byte[] bArr2) {
        this.privateKeyPem = bArr;
        this.certificatePem = bArr2;
        return this;
    }

    public GrpcExporterBuilder<T> addHeader(String str, String str2) {
        this.headers.put(str, str2);
        return this;
    }

    public GrpcExporterBuilder<T> setRetryPolicy(RetryPolicy retryPolicy) {
        this.retryPolicy = retryPolicy;
        return this;
    }

    public GrpcExporterBuilder<T> setMeterProvider(MeterProvider meterProvider) {
        this.meterProvider = meterProvider;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [io.opentelemetry.exporter.internal.grpc.GrpcExporterBuilder$1] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v2, types: [javax.net.ssl.KeyManager] */
    public GrpcExporter<T> build() {
        byte[] bArr;
        ?? r1 = 0;
        r1 = 0;
        if (this.grpcChannel == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            InstrumentInjector.okhttp_addInterceptors(builder);
            OkHttpClient.Builder dispatcher = builder.dispatcher(OkHttpUtil.newDispatcher());
            dispatcher.callTimeout(Duration.ofNanos(this.timeoutNanos));
            byte[] bArr2 = this.trustedCertificatesPem;
            if (bArr2 != null) {
                try {
                    X509TrustManager trustManager = TlsUtil.trustManager(bArr2);
                    byte[] bArr3 = this.privateKeyPem;
                    if (bArr3 != null && (bArr = this.certificatePem) != null) {
                        r1 = TlsUtil.keyManager(bArr3, bArr);
                    }
                    dispatcher.sslSocketFactory(TlsUtil.sslSocketFactory(r1, trustManager), trustManager);
                } catch (SSLException e) {
                    throw new IllegalStateException("Could not set trusted certificates, are they valid X.509 in PEM format?", e);
                }
            }
            String obj = this.endpoint.resolve(this.grpcEndpointPath).toString();
            if (obj.startsWith("http://")) {
                dispatcher.protocols(Collections.singletonList(Protocol.H2_PRIOR_KNOWLEDGE));
            } else {
                dispatcher.protocols(Arrays.asList(Protocol.HTTP_2, Protocol.HTTP_1_1));
            }
            final Headers.Builder builder2 = new Headers.Builder();
            Map.EL.KClassImpl$Data$declaredNonStaticMembers$2(this.headers, new BiConsumer() { // from class: io.opentelemetry.exporter.internal.grpc.GrpcExporterBuilder$$ExternalSyntheticLambda0
                @Override // j$.util.function.BiConsumer
                public final void accept(Object obj2, Object obj3) {
                    Headers.Builder.this.add((String) obj2, (String) obj3);
                }

                @Override // j$.util.function.BiConsumer
                public final /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                    return BiConsumer.CC.getAuthRequestContext(this, biConsumer);
                }
            });
            builder2.add("te", "trailers");
            if (this.compressionEnabled) {
                builder2.add("grpc-encoding", HeaderConstant.HEADER_VALUE_CONTENT_ENCODING_GZIP);
            }
            if (this.retryPolicy != null) {
                dispatcher.addInterceptor(new RetryInterceptor(this.retryPolicy, new Function() { // from class: io.opentelemetry.exporter.internal.grpc.GrpcExporterBuilder$$ExternalSyntheticLambda1
                    @Override // j$.util.function.Function
                    /* renamed from: andThen */
                    public final /* synthetic */ Function mo3169andThen(Function function) {
                        return Function.CC.getAuthRequestContext(this, function);
                    }

                    @Override // j$.util.function.Function
                    public final Object apply(Object obj2) {
                        return Boolean.valueOf(OkHttpGrpcExporter.isRetryable((Response) obj2));
                    }

                    @Override // j$.util.function.Function
                    public final /* synthetic */ Function compose(Function function) {
                        return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
                    }
                }));
            }
            return new OkHttpGrpcExporter(this.exporterName, this.type, dispatcher.build(), this.meterProvider, obj, builder2.build(), this.compressionEnabled);
        }
        return new UpstreamGrpcExporterFactory().buildWithChannel((Channel) this.grpcChannel);
    }

    /* loaded from: classes9.dex */
    class UpstreamGrpcExporterFactory {
        private UpstreamGrpcExporterFactory() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GrpcExporter<T> buildWithChannel(Channel channel) {
            Metadata metadata = new Metadata();
            String str = null;
            for (Map.Entry entry : GrpcExporterBuilder.this.headers.entrySet()) {
                String str2 = (String) entry.getKey();
                String str3 = (String) entry.getValue();
                if (str2.equals("host")) {
                    str = str3;
                } else {
                    metadata.put(Metadata.Key.of(str2, Metadata.ASCII_STRING_MARSHALLER), str3);
                }
            }
            return new UpstreamGrpcExporter(GrpcExporterBuilder.this.exporterName, GrpcExporterBuilder.this.type, ((MarshalerServiceStub) ((BiFunction) GrpcExporterBuilder.this.grpcStubFactory.get()).apply(ClientInterceptors.intercept(channel, new ClientInterceptor[]{MetadataUtils.newAttachHeadersInterceptor(metadata)}), str)).withCompression((GrpcExporterBuilder.this.compressionEnabled ? new Codec.Gzip() : Codec.Identity.NONE).getMessageEncoding()), GrpcExporterBuilder.this.meterProvider, GrpcExporterBuilder.this.timeoutNanos);
        }
    }
}
