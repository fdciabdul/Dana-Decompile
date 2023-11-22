package io.opentelemetry.sdk.trace;

import io.opentelemetry.sdk.common.Clock;
import io.opentelemetry.sdk.resources.Resource;
import io.opentelemetry.sdk.trace.IdGenerator;
import io.opentelemetry.sdk.trace.samplers.Sampler;
import j$.util.function.Supplier;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class SdkTracerProviderBuilder {
    private static final Sampler DEFAULT_SAMPLER = Sampler.CC.parentBased(Sampler.CC.alwaysOn());
    private final List<SpanProcessor> spanProcessors = new ArrayList();
    private Clock clock = Clock.CC.getDefault();
    private IdGenerator idsGenerator = IdGenerator.CC.random();
    private Resource resource = Resource.getDefault();
    private Supplier<SpanLimits> spanLimitsSupplier = new Supplier() { // from class: io.opentelemetry.sdk.trace.SdkTracerProviderBuilder$$ExternalSyntheticLambda1
        @Override // j$.util.function.Supplier
        public final Object get() {
            return SpanLimits.getDefault();
        }
    };
    private Sampler sampler = DEFAULT_SAMPLER;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ SpanLimits lambda$setSpanLimits$0(SpanLimits spanLimits) {
        return spanLimits;
    }

    public final SdkTracerProviderBuilder setClock(Clock clock) {
        Objects.requireNonNull(clock, "clock");
        this.clock = clock;
        return this;
    }

    public final SdkTracerProviderBuilder setIdGenerator(IdGenerator idGenerator) {
        Objects.requireNonNull(idGenerator, "idGenerator");
        this.idsGenerator = idGenerator;
        return this;
    }

    public final SdkTracerProviderBuilder setResource(Resource resource) {
        Objects.requireNonNull(resource, "resource");
        this.resource = resource;
        return this;
    }

    public final SdkTracerProviderBuilder setSpanLimits(final SpanLimits spanLimits) {
        Objects.requireNonNull(spanLimits, "spanLimits");
        this.spanLimitsSupplier = new Supplier() { // from class: io.opentelemetry.sdk.trace.SdkTracerProviderBuilder$$ExternalSyntheticLambda0
            @Override // j$.util.function.Supplier
            public final Object get() {
                return SdkTracerProviderBuilder.lambda$setSpanLimits$0(SpanLimits.this);
            }
        };
        return this;
    }

    public final SdkTracerProviderBuilder setSpanLimits(Supplier<SpanLimits> supplier) {
        Objects.requireNonNull(supplier, "spanLimitsSupplier");
        this.spanLimitsSupplier = supplier;
        return this;
    }

    public final SdkTracerProviderBuilder setSampler(Sampler sampler) {
        Objects.requireNonNull(sampler, "sampler");
        this.sampler = sampler;
        return this;
    }

    public final SdkTracerProviderBuilder addSpanProcessor(SpanProcessor spanProcessor) {
        this.spanProcessors.add(spanProcessor);
        return this;
    }

    public final SdkTracerProvider build() {
        return new SdkTracerProvider(this.clock, this.idsGenerator, this.resource, this.spanLimitsSupplier, this.sampler, this.spanProcessors);
    }
}
