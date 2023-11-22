package io.opentelemetry.sdk.logs;

import io.opentelemetry.sdk.common.Clock;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.resources.Resource;
import j$.util.function.Supplier;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
final class LoggerSharedState {
    private final Clock clock;
    private final Supplier<LogLimits> logLimitsSupplier;
    private final LogRecordProcessor logRecordProcessor;
    private final Resource resource;
    private final Object lock = new Object();
    @Nullable
    private volatile CompletableResultCode shutdownResult = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LoggerSharedState(Resource resource, Supplier<LogLimits> supplier, LogRecordProcessor logRecordProcessor, Clock clock) {
        this.resource = resource;
        this.logLimitsSupplier = supplier;
        this.logRecordProcessor = logRecordProcessor;
        this.clock = clock;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Resource getResource() {
        return this.resource;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final LogLimits getLogLimits() {
        return this.logLimitsSupplier.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final LogRecordProcessor getLogRecordProcessor() {
        return this.logRecordProcessor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Clock getClock() {
        return this.clock;
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
            this.shutdownResult = this.logRecordProcessor.shutdown();
            return this.shutdownResult;
        }
    }
}
