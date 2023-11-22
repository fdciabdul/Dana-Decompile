package io.opentelemetry.sdk;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.api.metrics.MeterBuilder;
import io.opentelemetry.api.metrics.MeterProvider;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.api.trace.TracerBuilder;
import io.opentelemetry.api.trace.TracerProvider;
import io.opentelemetry.context.propagation.ContextPropagators;
import io.opentelemetry.sdk.logs.SdkLoggerProvider;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.trace.SdkTracerProvider;

/* loaded from: classes.dex */
public final class OpenTelemetrySdk implements OpenTelemetry {
    private final SdkLoggerProvider loggerProvider;
    private final ObfuscatedMeterProvider meterProvider;
    private final ContextPropagators propagators;
    private final ObfuscatedTracerProvider tracerProvider;

    @Override // io.opentelemetry.api.OpenTelemetry
    public final /* synthetic */ Meter getMeter(String str) {
        Meter meter;
        meter = getMeterProvider().get(str);
        return meter;
    }

    @Override // io.opentelemetry.api.OpenTelemetry
    public final /* synthetic */ Tracer getTracer(String str) {
        Tracer tracer;
        tracer = getTracerProvider().get(str);
        return tracer;
    }

    @Override // io.opentelemetry.api.OpenTelemetry
    public final /* synthetic */ Tracer getTracer(String str, String str2) {
        Tracer tracer;
        tracer = getTracerProvider().get(str, str2);
        return tracer;
    }

    @Override // io.opentelemetry.api.OpenTelemetry
    public final /* synthetic */ MeterBuilder meterBuilder(String str) {
        MeterBuilder meterBuilder;
        meterBuilder = getMeterProvider().meterBuilder(str);
        return meterBuilder;
    }

    @Override // io.opentelemetry.api.OpenTelemetry
    public final /* synthetic */ TracerBuilder tracerBuilder(String str) {
        TracerBuilder tracerBuilder;
        tracerBuilder = getTracerProvider().tracerBuilder(str);
        return tracerBuilder;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenTelemetrySdk(SdkTracerProvider sdkTracerProvider, SdkMeterProvider sdkMeterProvider, SdkLoggerProvider sdkLoggerProvider, ContextPropagators contextPropagators) {
        this.tracerProvider = new ObfuscatedTracerProvider(sdkTracerProvider);
        this.meterProvider = new ObfuscatedMeterProvider(sdkMeterProvider);
        this.loggerProvider = sdkLoggerProvider;
        this.propagators = contextPropagators;
    }

    public static OpenTelemetrySdkBuilder builder() {
        return new OpenTelemetrySdkBuilder();
    }

    @Override // io.opentelemetry.api.OpenTelemetry
    public final TracerProvider getTracerProvider() {
        return this.tracerProvider;
    }

    public final SdkTracerProvider getSdkTracerProvider() {
        return this.tracerProvider.unobfuscate();
    }

    @Override // io.opentelemetry.api.OpenTelemetry
    public final MeterProvider getMeterProvider() {
        return this.meterProvider;
    }

    public final SdkMeterProvider getSdkMeterProvider() {
        return this.meterProvider.unobfuscate();
    }

    public final SdkLoggerProvider getSdkLoggerProvider() {
        return this.loggerProvider;
    }

    @Override // io.opentelemetry.api.OpenTelemetry
    public final ContextPropagators getPropagators() {
        return this.propagators;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OpenTelemetrySdk{tracerProvider=");
        sb.append(this.tracerProvider.unobfuscate());
        sb.append(", meterProvider=");
        sb.append(this.meterProvider.unobfuscate());
        sb.append("}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ObfuscatedTracerProvider implements TracerProvider {
        private final SdkTracerProvider delegate;

        ObfuscatedTracerProvider(SdkTracerProvider sdkTracerProvider) {
            this.delegate = sdkTracerProvider;
        }

        @Override // io.opentelemetry.api.trace.TracerProvider
        public Tracer get(String str) {
            return this.delegate.get(str);
        }

        @Override // io.opentelemetry.api.trace.TracerProvider
        public Tracer get(String str, String str2) {
            return this.delegate.get(str, str2);
        }

        @Override // io.opentelemetry.api.trace.TracerProvider
        public TracerBuilder tracerBuilder(String str) {
            return this.delegate.tracerBuilder(str);
        }

        public SdkTracerProvider unobfuscate() {
            return this.delegate;
        }
    }

    /* loaded from: classes.dex */
    static class ObfuscatedMeterProvider implements MeterProvider {
        private final SdkMeterProvider delegate;

        @Override // io.opentelemetry.api.metrics.MeterProvider
        public /* synthetic */ Meter get(String str) {
            Meter build;
            build = meterBuilder(str).build();
            return build;
        }

        ObfuscatedMeterProvider(SdkMeterProvider sdkMeterProvider) {
            this.delegate = sdkMeterProvider;
        }

        @Override // io.opentelemetry.api.metrics.MeterProvider
        public MeterBuilder meterBuilder(String str) {
            return this.delegate.meterBuilder(str);
        }

        public SdkMeterProvider unobfuscate() {
            return this.delegate;
        }
    }
}
