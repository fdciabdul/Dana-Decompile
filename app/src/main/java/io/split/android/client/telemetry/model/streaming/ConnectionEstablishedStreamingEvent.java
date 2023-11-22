package io.split.android.client.telemetry.model.streaming;

import io.split.android.client.telemetry.model.EventTypeEnum;

/* loaded from: classes9.dex */
public class ConnectionEstablishedStreamingEvent extends StreamingEvent {
    public ConnectionEstablishedStreamingEvent(long j) {
        super(EventTypeEnum.CONNECTION_ESTABLISHED, null, j);
    }
}
