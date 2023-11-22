package io.opentelemetry.sdk.metrics.export;

import id.dana.data.config.source.amcs.result.OTCAcceptExpiryTimeConfigResult;
import io.opentelemetry.api.internal.Utils;
import io.opentelemetry.sdk.internal.DaemonThreadFactory;
import j$.time.Duration;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* loaded from: classes9.dex */
public final class PeriodicMetricReaderBuilder {
    static final long DEFAULT_SCHEDULE_DELAY_MINUTES = 1;
    @Nullable
    private ScheduledExecutorService executor;
    private long intervalNanos = TimeUnit.MINUTES.toNanos(1);
    private final MetricExporter metricExporter;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PeriodicMetricReaderBuilder(MetricExporter metricExporter) {
        this.metricExporter = metricExporter;
    }

    public final PeriodicMetricReaderBuilder setInterval(long j, TimeUnit timeUnit) {
        Objects.requireNonNull(timeUnit, OTCAcceptExpiryTimeConfigResult.JsonKey.UNIT);
        Utils.checkArgument(j > 0, "interval must be positive");
        this.intervalNanos = timeUnit.toNanos(j);
        return this;
    }

    public final PeriodicMetricReaderBuilder setInterval(Duration duration) {
        Objects.requireNonNull(duration, "interval");
        return setInterval(duration.toNanos(), TimeUnit.NANOSECONDS);
    }

    public final PeriodicMetricReaderBuilder setExecutor(ScheduledExecutorService scheduledExecutorService) {
        Objects.requireNonNull(scheduledExecutorService, "executor");
        this.executor = scheduledExecutorService;
        return this;
    }

    public final PeriodicMetricReader build() {
        ScheduledExecutorService scheduledExecutorService = this.executor;
        if (scheduledExecutorService == null) {
            scheduledExecutorService = Executors.newScheduledThreadPool(1, new DaemonThreadFactory("PeriodicMetricReader"));
        }
        return new PeriodicMetricReader(this.metricExporter, this.intervalNanos, scheduledExecutorService);
    }
}
