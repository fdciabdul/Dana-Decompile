package io.split.android.client.telemetry.model;

import com.alibaba.ariver.kernel.RVParams;
import com.google.gson.annotations.SerializedName;
import id.dana.data.foundation.logger.log.LoginTrackingConstants;
import java.util.List;

/* loaded from: classes6.dex */
public class HttpLatencies {
    @SerializedName("ev")
    private List<Long> events;
    @SerializedName("im")
    private List<Long> impressions;
    @SerializedName("ic")
    private List<Long> impressionsCount;
    @SerializedName("ms")
    private List<Long> mySegments;
    @SerializedName(RVParams.SHOW_PROGRESS)
    private List<Long> splits;
    @SerializedName("te")
    private List<Long> telemetry;
    @SerializedName(LoginTrackingConstants.LoginParam.TO)
    private List<Long> token;

    public List<Long> getSplits() {
        return this.splits;
    }

    public void setSplits(List<Long> list) {
        this.splits = list;
    }

    public List<Long> getMySegments() {
        return this.mySegments;
    }

    public void setMySegments(List<Long> list) {
        this.mySegments = list;
    }

    public List<Long> getImpressions() {
        return this.impressions;
    }

    public void setImpressions(List<Long> list) {
        this.impressions = list;
    }

    public List<Long> getImpressionsCount() {
        return this.impressionsCount;
    }

    public void setImpressionsCount(List<Long> list) {
        this.impressionsCount = list;
    }

    public List<Long> getEvents() {
        return this.events;
    }

    public void setEvents(List<Long> list) {
        this.events = list;
    }

    public List<Long> getTelemetry() {
        return this.telemetry;
    }

    public void setTelemetry(List<Long> list) {
        this.telemetry = list;
    }

    public List<Long> getToken() {
        return this.token;
    }

    public void setToken(List<Long> list) {
        this.token = list;
    }
}
