package io.split.android.client.telemetry.model;

import com.alibaba.ariver.kernel.RVParams;
import com.google.gson.annotations.SerializedName;
import id.dana.data.foundation.logger.log.LoginTrackingConstants;
import java.util.Map;

/* loaded from: classes6.dex */
public class HttpErrors {
    @SerializedName("ev")
    private Map<Long, Long> eventsSyncErrs;
    @SerializedName("ic")
    private Map<Long, Long> impressionCountSyncErrs;
    @SerializedName("im")
    private Map<Long, Long> impressionSyncErrs;
    @SerializedName("ms")
    private Map<Long, Long> mySegmentSyncErrs;
    @SerializedName(RVParams.SHOW_PROGRESS)
    private Map<Long, Long> splitSyncErrs;
    @SerializedName("te")
    private Map<Long, Long> telemetrySyncErrs;
    @SerializedName(LoginTrackingConstants.LoginParam.TO)
    private Map<Long, Long> tokenGetErrs;

    public Map<Long, Long> getSplitSyncErrs() {
        return this.splitSyncErrs;
    }

    public void setSplitSyncErrs(Map<Long, Long> map) {
        this.splitSyncErrs = map;
    }

    public Map<Long, Long> getMySegmentSyncErrs() {
        return this.mySegmentSyncErrs;
    }

    public void setMySegmentSyncErrs(Map<Long, Long> map) {
        this.mySegmentSyncErrs = map;
    }

    public Map<Long, Long> getImpressionSyncErrs() {
        return this.impressionSyncErrs;
    }

    public void setImpressionSyncErrs(Map<Long, Long> map) {
        this.impressionSyncErrs = map;
    }

    public Map<Long, Long> getImpressionCountSyncErrs() {
        return this.impressionCountSyncErrs;
    }

    public void setImpressionCountSyncErrs(Map<Long, Long> map) {
        this.impressionCountSyncErrs = map;
    }

    public Map<Long, Long> getEventsSyncErrs() {
        return this.eventsSyncErrs;
    }

    public void setEventsSyncErrs(Map<Long, Long> map) {
        this.eventsSyncErrs = map;
    }

    public Map<Long, Long> getTelemetrySyncErrs() {
        return this.telemetrySyncErrs;
    }

    public void setTelemetrySyncErrs(Map<Long, Long> map) {
        this.telemetrySyncErrs = map;
    }

    public Map<Long, Long> getTokenGetErrs() {
        return this.tokenGetErrs;
    }

    public void setTokenGetErrs(Map<Long, Long> map) {
        this.tokenGetErrs = map;
    }
}
