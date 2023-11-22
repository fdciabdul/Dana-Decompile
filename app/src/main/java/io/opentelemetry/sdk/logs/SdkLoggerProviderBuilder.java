package io.opentelemetry.sdk.logs;

import io.opentelemetry.sdk.common.Clock;
import io.opentelemetry.sdk.resources.Resource;
import j$.util.function.Supplier;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes6.dex */
public final class SdkLoggerProviderBuilder {
    private final List<LogRecordProcessor> logRecordProcessors = new ArrayList();
    private Resource resource = Resource.getDefault();
    private Supplier<LogLimits> logLimitsSupplier = new Supplier() { // from class: io.opentelemetry.sdk.logs.SdkLoggerProviderBuilder$$ExternalSyntheticLambda0
        @Override // j$.util.function.Supplier
        public final Object get() {
            return LogLimits.getDefault();
        }
    };
    private Clock clock = Clock.CC.getDefault();

    public final SdkLoggerProviderBuilder setResource(Resource resource) {
        Objects.requireNonNull(resource, "resource");
        this.resource = resource;
        return this;
    }

    public final SdkLoggerProviderBuilder setLogLimits(Supplier<LogLimits> supplier) {
        Objects.requireNonNull(supplier, "logLimitsSupplier");
        this.logLimitsSupplier = supplier;
        return this;
    }

    public final SdkLoggerProviderBuilder addLogRecordProcessor(LogRecordProcessor logRecordProcessor) {
        Objects.requireNonNull(logRecordProcessor, "processor");
        this.logRecordProcessors.add(logRecordProcessor);
        return this;
    }

    public final SdkLoggerProviderBuilder setClock(Clock clock) {
        Objects.requireNonNull(clock, "clock");
        this.clock = clock;
        return this;
    }

    public final SdkLoggerProvider build() {
        return new SdkLoggerProvider(this.resource, this.logLimitsSupplier, this.logRecordProcessors, this.clock);
    }
}
