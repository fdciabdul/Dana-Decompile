package io.opentelemetry.api;

import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.api.metrics.MeterBuilder;
import io.opentelemetry.api.metrics.MeterProvider;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.api.trace.TracerBuilder;
import io.opentelemetry.api.trace.TracerProvider;
import io.opentelemetry.context.propagation.ContextPropagators;

/* loaded from: classes.dex */
public interface OpenTelemetry {
    Meter getMeter(String str);

    MeterProvider getMeterProvider();

    ContextPropagators getPropagators();

    Tracer getTracer(String str);

    Tracer getTracer(String str, String str2);

    TracerProvider getTracerProvider();

    MeterBuilder meterBuilder(String str);

    TracerBuilder tracerBuilder(String str);

    /* renamed from: io.opentelemetry.api.OpenTelemetry$-CC  reason: invalid class name */
    /* loaded from: classes2.dex */
    public final /* synthetic */ class CC {
        public static OpenTelemetry noop() {
            return DefaultOpenTelemetry.getNoop();
        }

        public static OpenTelemetry propagating(ContextPropagators contextPropagators) {
            return DefaultOpenTelemetry.getPropagating(contextPropagators);
        }
    }
}
