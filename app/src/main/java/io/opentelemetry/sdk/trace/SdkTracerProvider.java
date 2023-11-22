package io.opentelemetry.sdk.trace;

import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.api.trace.TracerBuilder;
import io.opentelemetry.api.trace.TracerProvider;
import io.opentelemetry.sdk.common.Clock;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.internal.ComponentRegistry;
import io.opentelemetry.sdk.resources.Resource;
import io.opentelemetry.sdk.trace.samplers.Sampler;
import j$.util.function.Function;
import j$.util.function.Supplier;
import java.io.Closeable;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class SdkTracerProvider implements TracerProvider, Closeable {
    static final String DEFAULT_TRACER_NAME = "";
    private static final Logger logger = Logger.getLogger(SdkTracerProvider.class.getName());
    private final TracerSharedState sharedState;
    private final ComponentRegistry<SdkTracer> tracerSdkComponentRegistry = new ComponentRegistry<>(new Function() { // from class: io.opentelemetry.sdk.trace.SdkTracerProvider$$ExternalSyntheticLambda0
        @Override // j$.util.function.Function
        /* renamed from: andThen */
        public final /* synthetic */ Function mo3169andThen(Function function) {
            return Function.CC.getAuthRequestContext(this, function);
        }

        @Override // j$.util.function.Function
        public final Object apply(Object obj) {
            return SdkTracerProvider.this.m3162lambda$new$0$ioopentelemetrysdktraceSdkTracerProvider((InstrumentationScopeInfo) obj);
        }

        @Override // j$.util.function.Function
        public final /* synthetic */ Function compose(Function function) {
            return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
        }
    });

    public static SdkTracerProviderBuilder builder() {
        return new SdkTracerProviderBuilder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SdkTracerProvider(Clock clock, IdGenerator idGenerator, Resource resource, Supplier<SpanLimits> supplier, Sampler sampler, List<SpanProcessor> list) {
        this.sharedState = new TracerSharedState(clock, idGenerator, resource, supplier, sampler, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$io-opentelemetry-sdk-trace-SdkTracerProvider  reason: not valid java name */
    public final /* synthetic */ SdkTracer m3162lambda$new$0$ioopentelemetrysdktraceSdkTracerProvider(InstrumentationScopeInfo instrumentationScopeInfo) {
        return new SdkTracer(this.sharedState, instrumentationScopeInfo);
    }

    @Override // io.opentelemetry.api.trace.TracerProvider
    public final Tracer get(String str) {
        return tracerBuilder(str).build();
    }

    @Override // io.opentelemetry.api.trace.TracerProvider
    public final Tracer get(String str, String str2) {
        return tracerBuilder(str).setInstrumentationVersion(str2).build();
    }

    @Override // io.opentelemetry.api.trace.TracerProvider
    public final TracerBuilder tracerBuilder(@Nullable String str) {
        if (str == null || str.isEmpty()) {
            logger.fine("Tracer requested without instrumentation scope name.");
            str = "";
        }
        return new SdkTracerBuilder(this.tracerSdkComponentRegistry, str);
    }

    public final SpanLimits getSpanLimits() {
        return this.sharedState.getSpanLimits();
    }

    public final Sampler getSampler() {
        return this.sharedState.getSampler();
    }

    public final CompletableResultCode shutdown() {
        if (this.sharedState.hasBeenShutdown()) {
            logger.log(Level.WARNING, "Calling shutdown() multiple times.");
            return CompletableResultCode.ofSuccess();
        }
        return this.sharedState.shutdown();
    }

    public final CompletableResultCode forceFlush() {
        return this.sharedState.getActiveSpanProcessor().forceFlush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        shutdown().join(10L, TimeUnit.SECONDS);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SdkTracerProvider{clock=");
        sb.append(this.sharedState.getClock());
        sb.append(", idGenerator=");
        sb.append(this.sharedState.getIdGenerator());
        sb.append(", resource=");
        sb.append(this.sharedState.getResource());
        sb.append(", spanLimitsSupplier=");
        sb.append(this.sharedState.getSpanLimits());
        sb.append(", sampler=");
        sb.append(this.sharedState.getSampler());
        sb.append(", spanProcessor=");
        sb.append(this.sharedState.getActiveSpanProcessor());
        sb.append('}');
        return sb.toString();
    }
}
