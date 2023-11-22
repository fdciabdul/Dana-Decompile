package io.split.android.client.telemetry.model.streaming;

import io.split.android.client.telemetry.model.EventTypeEnum;

/* loaded from: classes6.dex */
public class TokenRefreshStreamingEvent extends StreamingEvent {
    public TokenRefreshStreamingEvent(long j, long j2) {
        super(EventTypeEnum.TOKEN_REFRESH, Long.valueOf(j), j2);
    }
}
