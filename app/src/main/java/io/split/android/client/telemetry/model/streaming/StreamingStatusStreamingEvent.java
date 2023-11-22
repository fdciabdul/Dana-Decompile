package io.split.android.client.telemetry.model.streaming;

import io.split.android.client.telemetry.model.EventTypeEnum;

/* loaded from: classes6.dex */
public class StreamingStatusStreamingEvent extends StreamingEvent {
    public StreamingStatusStreamingEvent(Status status, long j) {
        super(EventTypeEnum.STREAMING_STATUS, Long.valueOf(status.getNumericValue()), j);
    }

    /* loaded from: classes6.dex */
    public enum Status {
        DISABLED(0),
        ENABLED(1),
        PAUSED(2);

        private final int numericValue;

        Status(int i) {
            this.numericValue = i;
        }

        public final int getNumericValue() {
            return this.numericValue;
        }
    }
}
