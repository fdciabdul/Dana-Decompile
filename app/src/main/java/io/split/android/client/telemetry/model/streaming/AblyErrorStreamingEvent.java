package io.split.android.client.telemetry.model.streaming;

import io.split.android.client.telemetry.model.EventTypeEnum;

/* loaded from: classes6.dex */
public class AblyErrorStreamingEvent extends StreamingEvent {
    public AblyErrorStreamingEvent(long j, long j2) {
        super(EventTypeEnum.ABLY_ERROR, Long.valueOf(j), j2);
    }
}
