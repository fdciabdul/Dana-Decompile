package io.split.android.client.telemetry.model.streaming;

import io.split.android.client.telemetry.model.EventTypeEnum;

/* loaded from: classes6.dex */
public class SseConnectionErrorStreamingEvent extends StreamingEvent {
    public SseConnectionErrorStreamingEvent(Status status, long j) {
        super(EventTypeEnum.SSE_CONNECTION_ERROR, Long.valueOf(status.getNumericValue()), j);
    }

    /* loaded from: classes6.dex */
    public enum Status {
        REQUESTED(0),
        NON_REQUESTED(1);

        private final int numericValue;

        Status(int i) {
            this.numericValue = i;
        }

        public final int getNumericValue() {
            return this.numericValue;
        }
    }
}
