package io.opentelemetry.sdk.trace;

import io.opentelemetry.sdk.common.Clock;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.resources.Resource;
import io.opentelemetry.sdk.trace.SpanProcessor;
import io.opentelemetry.sdk.trace.samplers.Sampler;
import j$.util.function.Supplier;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class TracerSharedState {
    private final SpanProcessor activeSpanProcessor;
    private final Clock clock;
    private final IdGenerator idGenerator;
    private final boolean idGeneratorSafeToSkipIdValidation;
    private final Resource resource;
    private final Sampler sampler;
    private final Supplier<SpanLimits> spanLimitsSupplier;
    private final Object lock = new Object();
    @Nullable
    private volatile CompletableResultCode shutdownResult = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TracerSharedState(Clock clock, IdGenerator idGenerator, Resource resource, Supplier<SpanLimits> supplier, Sampler sampler, List<SpanProcessor> list) {
        this.clock = clock;
        this.idGenerator = idGenerator;
        this.idGeneratorSafeToSkipIdValidation = idGenerator instanceof RandomIdGenerator;
        this.resource = resource;
        this.spanLimitsSupplier = supplier;
        this.sampler = sampler;
        this.activeSpanProcessor = SpanProcessor.CC.composite(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Clock getClock() {
        return this.clock;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final IdGenerator getIdGenerator() {
        return this.idGenerator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isIdGeneratorSafeToSkipIdValidation() {
        return this.idGeneratorSafeToSkipIdValidation;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Resource getResource() {
        return this.resource;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SpanLimits getSpanLimits() {
        return this.spanLimitsSupplier.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Sampler getSampler() {
        return this.sampler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SpanProcessor getActiveSpanProcessor() {
        return this.activeSpanProcessor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean hasBeenShutdown() {
        return this.shutdownResult != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final CompletableResultCode shutdown() {
        synchronized (this.lock) {
            if (this.shutdownResult != null) {
                return this.shutdownResult;
            }
            this.shutdownResult = this.activeSpanProcessor.shutdown();
            return this.shutdownResult;
        }
    }
}
