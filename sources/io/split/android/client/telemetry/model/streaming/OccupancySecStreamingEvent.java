package io.split.android.client.telemetry.model.streaming;

import io.split.android.client.telemetry.model.EventTypeEnum;

/* loaded from: classes6.dex */
public class OccupancySecStreamingEvent extends StreamingEvent {
    public OccupancySecStreamingEvent(long j, long j2) {
        super(EventTypeEnum.OCCUPANCY_SEC, Long.valueOf(j), j2);
    }
}
