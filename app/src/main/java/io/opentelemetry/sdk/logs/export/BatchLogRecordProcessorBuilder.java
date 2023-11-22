package io.opentelemetry.sdk.logs.export;

import id.dana.data.config.source.amcs.result.OTCAcceptExpiryTimeConfigResult;
import id.dana.twilio.identityverification.TwilioIdentityVerificationActivity;
import io.opentelemetry.api.internal.Utils;
import io.opentelemetry.api.metrics.MeterProvider;
import j$.time.Duration;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* loaded from: classes9.dex */
public final class BatchLogRecordProcessorBuilder {
    static final int DEFAULT_EXPORT_TIMEOUT_MILLIS = 30000;
    static final int DEFAULT_MAX_EXPORT_BATCH_SIZE = 512;
    static final int DEFAULT_MAX_QUEUE_SIZE = 2048;
    static final long DEFAULT_SCHEDULE_DELAY_MILLIS = 200;
    private final LogRecordExporter logRecordExporter;
    private long scheduleDelayNanos = TimeUnit.MILLISECONDS.toNanos(DEFAULT_SCHEDULE_DELAY_MILLIS);
    private int maxQueueSize = DEFAULT_MAX_QUEUE_SIZE;
    private int maxExportBatchSize = 512;
    private long exporterTimeoutNanos = TimeUnit.MILLISECONDS.toNanos(30000);
    private MeterProvider meterProvider = MeterProvider.CC.noop();

    /* JADX INFO: Access modifiers changed from: package-private */
    public BatchLogRecordProcessorBuilder(LogRecordExporter logRecordExporter) {
        this.logRecordExporter = (LogRecordExporter) Objects.requireNonNull(logRecordExporter, "logRecordExporter");
    }

    public final BatchLogRecordProcessorBuilder setScheduleDelay(long j, TimeUnit timeUnit) {
        Objects.requireNonNull(timeUnit, OTCAcceptExpiryTimeConfigResult.JsonKey.UNIT);
        Utils.checkArgument(j >= 0, "delay must be non-negative");
        this.scheduleDelayNanos = timeUnit.toNanos(j);
        return this;
    }

    public final BatchLogRecordProcessorBuilder setScheduleDelay(Duration duration) {
        Objects.requireNonNull(duration, "delay");
        return setScheduleDelay(duration.toNanos(), TimeUnit.NANOSECONDS);
    }

    final long getScheduleDelayNanos() {
        return this.scheduleDelayNanos;
    }

    public final BatchLogRecordProcessorBuilder setExporterTimeout(long j, TimeUnit timeUnit) {
        Objects.requireNonNull(timeUnit, OTCAcceptExpiryTimeConfigResult.JsonKey.UNIT);
        Utils.checkArgument(j >= 0, "timeout must be non-negative");
        this.exporterTimeoutNanos = timeUnit.toNanos(j);
        return this;
    }

    public final BatchLogRecordProcessorBuilder setExporterTimeout(Duration duration) {
        Objects.requireNonNull(duration, TwilioIdentityVerificationActivity.CHALLENGE_INFO_TIMEOUT);
        return setExporterTimeout(duration.toNanos(), TimeUnit.NANOSECONDS);
    }

    final long getExporterTimeoutNanos() {
        return this.exporterTimeoutNanos;
    }

    public final BatchLogRecordProcessorBuilder setMaxQueueSize(int i) {
        this.maxQueueSize = i;
        return this;
    }

    final int getMaxQueueSize() {
        return this.maxQueueSize;
    }

    public final BatchLogRecordProcessorBuilder setMaxExportBatchSize(int i) {
        Utils.checkArgument(i > 0, "maxExportBatchSize must be positive.");
        this.maxExportBatchSize = i;
        return this;
    }

    public final BatchLogRecordProcessorBuilder setMeterProvider(MeterProvider meterProvider) {
        Objects.requireNonNull(meterProvider, "meterProvider");
        this.meterProvider = meterProvider;
        return this;
    }

    final int getMaxExportBatchSize() {
        return this.maxExportBatchSize;
    }

    public final BatchLogRecordProcessor build() {
        return new BatchLogRecordProcessor(this.logRecordExporter, this.meterProvider, this.scheduleDelayNanos, this.maxQueueSize, this.maxExportBatchSize, this.exporterTimeoutNanos);
    }
}
