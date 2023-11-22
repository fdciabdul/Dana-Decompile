package io.split.android.client.telemetry.storage;

import io.split.android.client.telemetry.model.EventsDataRecordsEnum;
import io.split.android.client.telemetry.model.HttpErrors;
import io.split.android.client.telemetry.model.HttpLatencies;
import io.split.android.client.telemetry.model.ImpressionsDataType;
import io.split.android.client.telemetry.model.LastSync;
import io.split.android.client.telemetry.model.UpdatesFromSSE;
import io.split.android.client.telemetry.model.streaming.StreamingEvent;
import java.util.List;

/* loaded from: classes6.dex */
public interface TelemetryRuntimeConsumer {
    long getEventsStats(EventsDataRecordsEnum eventsDataRecordsEnum);

    long getImpressionsStats(ImpressionsDataType impressionsDataType);

    LastSync getLastSynchronization();

    long getSessionLength();

    long popAuthRejections();

    HttpErrors popHttpErrors();

    HttpLatencies popHttpLatencies();

    List<StreamingEvent> popStreamingEvents();

    List<String> popTags();

    long popTokenRefreshes();

    UpdatesFromSSE popUpdatesFromSSE();
}
