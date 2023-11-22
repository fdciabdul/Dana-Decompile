package io.opentelemetry.sdk;

import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.context.propagation.ContextPropagators;
import io.opentelemetry.sdk.logs.SdkLoggerProvider;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public final class OpenTelemetrySdkBuilder {
    @Nullable
    private SdkLoggerProvider loggerProvider;
    @Nullable
    private SdkMeterProvider meterProvider;
    private ContextPropagators propagators = ContextPropagators.CC.noop();
    @Nullable
    private SdkTracerProvider tracerProvider;

    public final OpenTelemetrySdkBuilder setTracerProvider(SdkTracerProvider sdkTracerProvider) {
        this.tracerProvider = sdkTracerProvider;
        return this;
    }

    public final OpenTelemetrySdkBuilder setMeterProvider(SdkMeterProvider sdkMeterProvider) {
        this.meterProvider = sdkMeterProvider;
        return this;
    }

    public final OpenTelemetrySdkBuilder setLoggerProvider(SdkLoggerProvider sdkLoggerProvider) {
        this.loggerProvider = sdkLoggerProvider;
        return this;
    }

    public final OpenTelemetrySdkBuilder setPropagators(ContextPropagators contextPropagators) {
        this.propagators = contextPropagators;
        return this;
    }

    public final OpenTelemetrySdk buildAndRegisterGlobal() {
        OpenTelemetrySdk build = build();
        GlobalOpenTelemetry.set(build);
        return build;
    }

    public final OpenTelemetrySdk build() {
        SdkTracerProvider sdkTracerProvider = this.tracerProvider;
        if (sdkTracerProvider == null) {
            sdkTracerProvider = SdkTracerProvider.builder().build();
        }
        SdkMeterProvider sdkMeterProvider = this.meterProvider;
        if (sdkMeterProvider == null) {
            sdkMeterProvider = SdkMeterProvider.builder().build();
        }
        SdkLoggerProvider sdkLoggerProvider = this.loggerProvider;
        if (sdkLoggerProvider == null) {
            sdkLoggerProvider = SdkLoggerProvider.builder().build();
        }
        return new OpenTelemetrySdk(sdkTracerProvider, sdkMeterProvider, sdkLoggerProvider, this.propagators);
    }
}
