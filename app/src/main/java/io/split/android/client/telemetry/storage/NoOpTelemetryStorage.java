package io.split.android.client.telemetry.storage;

import io.split.android.client.telemetry.model.EventsDataRecordsEnum;
import io.split.android.client.telemetry.model.HttpErrors;
import io.split.android.client.telemetry.model.HttpLatencies;
import io.split.android.client.telemetry.model.ImpressionsDataType;
import io.split.android.client.telemetry.model.LastSync;
import io.split.android.client.telemetry.model.Method;
import io.split.android.client.telemetry.model.MethodExceptions;
import io.split.android.client.telemetry.model.MethodLatencies;
import io.split.android.client.telemetry.model.OperationType;
import io.split.android.client.telemetry.model.UpdatesFromSSE;
import io.split.android.client.telemetry.model.streaming.StreamingEvent;
import io.split.android.client.telemetry.model.streaming.UpdatesFromSSEEnum;
import java.util.List;

/* loaded from: classes6.dex */
public class NoOpTelemetryStorage implements TelemetryStorage {
    @Override // io.split.android.client.telemetry.storage.TelemetryRuntimeProducer
    public void addTag(String str) {
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryInitConsumer
    public long getActiveFactories() {
        return 0L;
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryRuntimeConsumer
    public long getEventsStats(EventsDataRecordsEnum eventsDataRecordsEnum) {
        return 0L;
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryRuntimeConsumer
    public long getImpressionsStats(ImpressionsDataType impressionsDataType) {
        return 0L;
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryRuntimeConsumer
    public LastSync getLastSynchronization() {
        return null;
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryInitConsumer
    public long getNonReadyUsage() {
        return 0L;
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryInitConsumer
    public long getRedundantFactories() {
        return 0L;
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryRuntimeConsumer
    public long getSessionLength() {
        return 0L;
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryInitConsumer
    public long getTimeUntilReady() {
        return 0L;
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryInitConsumer
    public long getTimeUntilReadyFromCache() {
        return 0L;
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryRuntimeConsumer
    public long popAuthRejections() {
        return 0L;
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryEvaluationConsumer
    public MethodExceptions popExceptions() {
        return null;
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryRuntimeConsumer
    public HttpErrors popHttpErrors() {
        return null;
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryRuntimeConsumer
    public HttpLatencies popHttpLatencies() {
        return null;
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryEvaluationConsumer
    public MethodLatencies popLatencies() {
        return null;
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryRuntimeConsumer
    public List<StreamingEvent> popStreamingEvents() {
        return null;
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryRuntimeConsumer
    public List<String> popTags() {
        return null;
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryRuntimeConsumer
    public long popTokenRefreshes() {
        return 0L;
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryRuntimeConsumer
    public UpdatesFromSSE popUpdatesFromSSE() {
        return null;
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryInitProducer
    public void recordActiveFactories(int i) {
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryRuntimeProducer
    public void recordAuthRejections() {
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryRuntimeProducer
    public void recordEventStats(EventsDataRecordsEnum eventsDataRecordsEnum, long j) {
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryEvaluationProducer
    public void recordException(Method method) {
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryRuntimeProducer
    public void recordImpressionStats(ImpressionsDataType impressionsDataType, long j) {
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryEvaluationProducer
    public void recordLatency(Method method, long j) {
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryInitProducer
    public void recordNonReadyUsage() {
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryInitProducer
    public void recordRedundantFactories(int i) {
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryRuntimeProducer
    public void recordSessionLength(long j) {
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryRuntimeProducer
    public void recordStreamingEvents(StreamingEvent streamingEvent) {
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryRuntimeProducer
    public void recordSuccessfulSync(OperationType operationType, long j) {
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryRuntimeProducer
    public void recordSyncError(OperationType operationType, Integer num) {
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryRuntimeProducer
    public void recordSyncLatency(OperationType operationType, long j) {
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryInitProducer
    public void recordTimeUntilReady(long j) {
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryInitProducer
    public void recordTimeUntilReadyFromCache(long j) {
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryRuntimeProducer
    public void recordTokenRefreshes() {
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryRuntimeProducer
    public void recordUpdatesFromSSE(UpdatesFromSSEEnum updatesFromSSEEnum) {
    }
}
