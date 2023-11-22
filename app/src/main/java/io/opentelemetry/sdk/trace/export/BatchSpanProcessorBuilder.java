package io.opentelemetry.sdk.trace.export;

import id.dana.data.config.source.amcs.result.OTCAcceptExpiryTimeConfigResult;
import id.dana.twilio.identityverification.TwilioIdentityVerificationActivity;
import io.opentelemetry.api.internal.Utils;
import io.opentelemetry.api.metrics.MeterProvider;
import j$.time.Duration;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class BatchSpanProcessorBuilder {
    static final int DEFAULT_EXPORT_TIMEOUT_MILLIS = 30000;
    static final int DEFAULT_MAX_EXPORT_BATCH_SIZE = 512;
    static final int DEFAULT_MAX_QUEUE_SIZE = 2048;
    static final long DEFAULT_SCHEDULE_DELAY_MILLIS = 5000;
    private final SpanExporter spanExporter;
    private long scheduleDelayNanos = TimeUnit.MILLISECONDS.toNanos(5000);
    private int maxQueueSize = DEFAULT_MAX_QUEUE_SIZE;
    private int maxExportBatchSize = 512;
    private long exporterTimeoutNanos = TimeUnit.MILLISECONDS.toNanos(30000);
    private MeterProvider meterProvider = MeterProvider.CC.noop();

    /* JADX INFO: Access modifiers changed from: package-private */
    public BatchSpanProcessorBuilder(SpanExporter spanExporter) {
        this.spanExporter = (SpanExporter) Objects.requireNonNull(spanExporter, "spanExporter");
    }

    public final BatchSpanProcessorBuilder setScheduleDelay(long j, TimeUnit timeUnit) {
        Objects.requireNonNull(timeUnit, OTCAcceptExpiryTimeConfigResult.JsonKey.UNIT);
        Utils.checkArgument(j >= 0, "delay must be non-negative");
        this.scheduleDelayNanos = timeUnit.toNanos(j);
        return this;
    }

    public final BatchSpanProcessorBuilder setScheduleDelay(Duration duration) {
        Objects.requireNonNull(duration, "delay");
        return setScheduleDelay(duration.toNanos(), TimeUnit.NANOSECONDS);
    }

    final long getScheduleDelayNanos() {
        return this.scheduleDelayNanos;
    }

    public final BatchSpanProcessorBuilder setExporterTimeout(long j, TimeUnit timeUnit) {
        Objects.requireNonNull(timeUnit, OTCAcceptExpiryTimeConfigResult.JsonKey.UNIT);
        Utils.checkArgument(j >= 0, "timeout must be non-negative");
        this.exporterTimeoutNanos = timeUnit.toNanos(j);
        return this;
    }

    public final BatchSpanProcessorBuilder setExporterTimeout(Duration duration) {
        Objects.requireNonNull(duration, TwilioIdentityVerificationActivity.CHALLENGE_INFO_TIMEOUT);
        return setExporterTimeout(duration.toNanos(), TimeUnit.NANOSECONDS);
    }

    final long getExporterTimeoutNanos() {
        return this.exporterTimeoutNanos;
    }

    public final BatchSpanProcessorBuilder setMaxQueueSize(int i) {
        this.maxQueueSize = i;
        return this;
    }

    final int getMaxQueueSize() {
        return this.maxQueueSize;
    }

    public final BatchSpanProcessorBuilder setMaxExportBatchSize(int i) {
        Utils.checkArgument(i > 0, "maxExportBatchSize must be positive.");
        this.maxExportBatchSize = i;
        return this;
    }

    public final BatchSpanProcessorBuilder setMeterProvider(MeterProvider meterProvider) {
        Objects.requireNonNull(meterProvider, "meterProvider");
        this.meterProvider = meterProvider;
        return this;
    }

    final int getMaxExportBatchSize() {
        return this.maxExportBatchSize;
    }

    public final BatchSpanProcessor build() {
        return new BatchSpanProcessor(this.spanExporter, this.meterProvider, this.scheduleDelayNanos, this.maxQueueSize, this.maxExportBatchSize, this.exporterTimeoutNanos);
    }
}
