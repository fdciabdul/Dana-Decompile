package io.split.android.client.telemetry.model.streaming;

import io.split.android.client.telemetry.model.EventTypeEnum;

/* loaded from: classes6.dex */
public class SyncModeUpdateStreamingEvent extends StreamingEvent {
    public SyncModeUpdateStreamingEvent(Mode mode, long j) {
        super(EventTypeEnum.SYNC_MODE_UPDATE, Long.valueOf(mode.getNumericValue()), j);
    }

    /* loaded from: classes6.dex */
    public enum Mode {
        STREAMING(0),
        POLLING(1);

        private final int numericValue;

        Mode(int i) {
            this.numericValue = i;
        }

        public final int getNumericValue() {
            return this.numericValue;
        }
    }
}
