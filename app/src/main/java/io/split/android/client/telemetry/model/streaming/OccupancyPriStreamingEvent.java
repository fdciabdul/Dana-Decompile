package io.split.android.client.telemetry.model.streaming;

import io.split.android.client.telemetry.model.EventTypeEnum;

/* loaded from: classes6.dex */
public class OccupancyPriStreamingEvent extends StreamingEvent {
    public OccupancyPriStreamingEvent(long j, long j2) {
        super(EventTypeEnum.OCCUPANCY_PRI, Long.valueOf(j), j2);
    }
}
