package io.opentelemetry.api;

import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.api.metrics.MeterBuilder;
import io.opentelemetry.api.metrics.MeterProvider;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.api.trace.TracerBuilder;
import io.opentelemetry.api.trace.TracerProvider;
import io.opentelemetry.context.propagation.ContextPropagators;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class DefaultOpenTelemetry implements OpenTelemetry {
    private static final OpenTelemetry NO_OP = new DefaultOpenTelemetry(ContextPropagators.CC.noop());
    private final ContextPropagators propagators;

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
    public static OpenTelemetry getNoop() {
        return NO_OP;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static OpenTelemetry getPropagating(ContextPropagators contextPropagators) {
        return new DefaultOpenTelemetry(contextPropagators);
    }

    DefaultOpenTelemetry(ContextPropagators contextPropagators) {
        this.propagators = contextPropagators;
    }

    @Override // io.opentelemetry.api.OpenTelemetry
    public final TracerProvider getTracerProvider() {
        return TracerProvider.CC.noop();
    }

    @Override // io.opentelemetry.api.OpenTelemetry
    public final MeterProvider getMeterProvider() {
        return MeterProvider.CC.noop();
    }

    @Override // io.opentelemetry.api.OpenTelemetry
    public final ContextPropagators getPropagators() {
        return this.propagators;
    }
}
