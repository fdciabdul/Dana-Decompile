package io.split.android.client.telemetry.storage;

import io.split.android.client.telemetry.model.EventsDataRecordsEnum;
import io.split.android.client.telemetry.model.ImpressionsDataType;
import io.split.android.client.telemetry.model.OperationType;
import io.split.android.client.telemetry.model.streaming.StreamingEvent;
import io.split.android.client.telemetry.model.streaming.UpdatesFromSSEEnum;

/* loaded from: classes6.dex */
public interface TelemetryRuntimeProducer {
    void addTag(String str);

    void recordAuthRejections();

    void recordEventStats(EventsDataRecordsEnum eventsDataRecordsEnum, long j);

    void recordImpressionStats(ImpressionsDataType impressionsDataType, long j);

    void recordSessionLength(long j);

    void recordStreamingEvents(StreamingEvent streamingEvent);

    void recordSuccessfulSync(OperationType operationType, long j);

    void recordSyncError(OperationType operationType, Integer num);

    void recordSyncLatency(OperationType operationType, long j);

    void recordTokenRefreshes();

    void recordUpdatesFromSSE(UpdatesFromSSEEnum updatesFromSSEEnum);
}
