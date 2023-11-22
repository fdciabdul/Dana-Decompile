package io.split.android.client.telemetry.model;

import com.alibaba.ariver.kernel.RVParams;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class RefreshRates {
    @SerializedName("ev")
    private long events;
    @SerializedName("im")
    private long impressions;
    @SerializedName("ms")
    private long mySegments;
    @SerializedName(RVParams.SHOW_PROGRESS)
    private long splits;
    @SerializedName("te")
    private long telemetry;

    public long getSplits() {
        return this.splits;
    }

    public void setSplits(long j) {
        this.splits = j;
    }

    public long getMySegments() {
        return this.mySegments;
    }

    public void setMySegments(long j) {
        this.mySegments = j;
    }

    public long getImpressions() {
        return this.impressions;
    }

    public void setImpressions(long j) {
        this.impressions = j;
    }

    public long getEvents() {
        return this.events;
    }

    public void setEvents(long j) {
        this.events = j;
    }

    public long getTelemetry() {
        return this.telemetry;
    }

    public void setTelemetry(long j) {
        this.telemetry = j;
    }
}
