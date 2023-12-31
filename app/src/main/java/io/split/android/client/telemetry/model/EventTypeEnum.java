package io.split.android.client.telemetry.model;

/* loaded from: classes6.dex */
public enum EventTypeEnum {
    CONNECTION_ESTABLISHED(0),
    OCCUPANCY_PRI(10),
    OCCUPANCY_SEC(20),
    STREAMING_STATUS(30),
    SSE_CONNECTION_ERROR(40),
    TOKEN_REFRESH(50),
    ABLY_ERROR(60),
    SYNC_MODE_UPDATE(70);

    private final int numericValue;

    EventTypeEnum(int i) {
        this.numericValue = i;
    }

    public final int getNumericValue() {
        return this.numericValue;
    }
}
