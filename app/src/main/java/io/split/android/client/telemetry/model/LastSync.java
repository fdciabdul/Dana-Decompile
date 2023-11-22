package io.split.android.client.telemetry.model;

import com.alibaba.ariver.kernel.RVParams;
import com.google.gson.annotations.SerializedName;
import id.dana.data.foundation.logger.log.LoginTrackingConstants;

/* loaded from: classes6.dex */
public class LastSync {
    @SerializedName("ev")
    private long lastEventSync;
    @SerializedName("ic")
    private long lastImpressionCountSync;
    @SerializedName("im")
    private long lastImpressionSync;
    @SerializedName("ms")
    private long lastMySegmentSync;
    @SerializedName(RVParams.SHOW_PROGRESS)
    private long lastSplitSync;
    @SerializedName("te")
    private long lastTelemetrySync;
    @SerializedName(LoginTrackingConstants.LoginParam.TO)
    private long lastTokenRefresh;

    public long getLastSplitSync() {
        return this.lastSplitSync;
    }

    public void setLastSplitSync(long j) {
        this.lastSplitSync = j;
    }

    public long getLastMySegmentSync() {
        return this.lastMySegmentSync;
    }

    public void setLastMySegmentSync(long j) {
        this.lastMySegmentSync = j;
    }

    public long getLastImpressionSync() {
        return this.lastImpressionSync;
    }

    public void setLastImpressionSync(long j) {
        this.lastImpressionSync = j;
    }

    public long getLastImpressionCountSync() {
        return this.lastImpressionCountSync;
    }

    public void setLastImpressionCountSync(long j) {
        this.lastImpressionCountSync = j;
    }

    public long getLastEventSync() {
        return this.lastEventSync;
    }

    public void setLastEventSync(long j) {
        this.lastEventSync = j;
    }

    public long getLastTelemetrySync() {
        return this.lastTelemetrySync;
    }

    public void setLastTelemetrySync(long j) {
        this.lastTelemetrySync = j;
    }

    public long getLastTokenRefresh() {
        return this.lastTokenRefresh;
    }

    public void setLastTokenRefresh(long j) {
        this.lastTokenRefresh = j;
    }
}
