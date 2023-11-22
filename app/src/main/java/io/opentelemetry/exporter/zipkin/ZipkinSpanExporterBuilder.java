package io.opentelemetry.exporter.zipkin;

import id.dana.data.config.source.amcs.result.OTCAcceptExpiryTimeConfigResult;
import id.dana.twilio.identityverification.TwilioIdentityVerificationActivity;
import io.opentelemetry.api.internal.Utils;
import io.opentelemetry.api.metrics.MeterProvider;
import io.split.android.client.service.ServiceConstants;
import j$.time.Duration;
import j$.util.function.Supplier;
import java.net.InetAddress;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import zipkin2.Span;
import zipkin2.codec.BytesEncoder;
import zipkin2.codec.SpanBytesEncoder;
import zipkin2.reporter.Sender;
import zipkin2.reporter.okhttp3.OkHttpSender;

/* loaded from: classes2.dex */
public final class ZipkinSpanExporterBuilder {
    @Nullable
    private Sender sender;
    private BytesEncoder<Span> encoder = SpanBytesEncoder.JSON_V2;
    private Supplier<InetAddress> localIpAddressSupplier = LocalInetAddressSupplier.getInstance();
    private String endpoint = ZipkinSpanExporter.DEFAULT_ENDPOINT;
    private long readTimeoutMillis = TimeUnit.SECONDS.toMillis(10);
    private MeterProvider meterProvider = MeterProvider.CC.noop();

    public final ZipkinSpanExporterBuilder setSender(Sender sender) {
        Objects.requireNonNull(sender, "sender");
        this.sender = sender;
        return this;
    }

    public final ZipkinSpanExporterBuilder setEncoder(BytesEncoder<Span> bytesEncoder) {
        Objects.requireNonNull(bytesEncoder, "encoder");
        this.encoder = bytesEncoder;
        return this;
    }

    public final ZipkinSpanExporterBuilder setLocalIpAddressSupplier(Supplier<InetAddress> supplier) {
        Objects.requireNonNull(supplier, "encoder");
        this.localIpAddressSupplier = supplier;
        return this;
    }

    public final ZipkinSpanExporterBuilder setEndpoint(String str) {
        Objects.requireNonNull(str, ServiceConstants.WORKER_PARAM_ENDPOINT);
        this.endpoint = str;
        return this;
    }

    public final ZipkinSpanExporterBuilder setReadTimeout(long j, TimeUnit timeUnit) {
        Objects.requireNonNull(timeUnit, OTCAcceptExpiryTimeConfigResult.JsonKey.UNIT);
        Utils.checkArgument(j >= 0, "timeout must be non-negative");
        this.readTimeoutMillis = timeUnit.toMillis(j);
        return this;
    }

    public final ZipkinSpanExporterBuilder setReadTimeout(Duration duration) {
        Objects.requireNonNull(duration, TwilioIdentityVerificationActivity.CHALLENGE_INFO_TIMEOUT);
        setReadTimeout(duration.toMillis(), TimeUnit.MILLISECONDS);
        return this;
    }

    public final ZipkinSpanExporterBuilder setMeterProvider(MeterProvider meterProvider) {
        Objects.requireNonNull(meterProvider, "meterProvider");
        this.meterProvider = meterProvider;
        return this;
    }

    public final ZipkinSpanExporter build() {
        Sender sender = this.sender;
        if (sender == null) {
            OkHttpSender.Builder BuiltInFictitiousFunctionClassFactory = OkHttpSender.getAuthRequestContext().BuiltInFictitiousFunctionClassFactory(this.endpoint);
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory.readTimeout((int) this.readTimeoutMillis, TimeUnit.MILLISECONDS);
            sender = new OkHttpSender(BuiltInFictitiousFunctionClassFactory);
        }
        return new ZipkinSpanExporter(this.encoder, sender, this.meterProvider, OtelToZipkinSpanTransformer.create(this.localIpAddressSupplier));
    }
}
