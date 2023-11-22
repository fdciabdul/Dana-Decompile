package io.split.android.client.telemetry.model;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.google.gson.annotations.SerializedName;
import io.split.android.client.telemetry.model.streaming.StreamingEvent;
import java.util.List;

/* loaded from: classes6.dex */
public class Stats {
    @SerializedName("aR")
    private long authRejections;
    @SerializedName("eD")
    private long eventsDropped;
    @SerializedName("eQ")
    private long eventsQueued;
    @SerializedName("hE")
    private HttpErrors httpErrors;
    @SerializedName("hL")
    private HttpLatencies httpLatencies;
    @SerializedName("iDe")
    private long impressionsDeduped;
    @SerializedName("iDr")
    private long impressionsDropped;
    @SerializedName("iQ")
    private long impressionsQueued;
    @SerializedName("lS")
    private LastSync lastSynchronizations;
    @SerializedName("mE")
    private MethodExceptions methodExceptions;
    @SerializedName("mL")
    private MethodLatencies methodLatencies;
    @SerializedName("seC")
    private long segmentCount;
    @SerializedName("skC")
    private final long segmentKeyCount = 1;
    @SerializedName("sL")
    private long sessionLengthMs;
    @SerializedName("spC")
    private long splitCount;
    @SerializedName("sE")
    private List<StreamingEvent> streamingEvents;
    @SerializedName(SecurityConstants.KEY_TEXT)
    private List<String> tags;
    @SerializedName("tR")
    private long tokenRefreshes;
    @SerializedName("ufs")
    private UpdatesFromSSE updatesFromSSE;

    public void setLastSynchronizations(LastSync lastSync) {
        this.lastSynchronizations = lastSync;
    }

    public void setMethodLatencies(MethodLatencies methodLatencies) {
        this.methodLatencies = methodLatencies;
    }

    public void setMethodExceptions(MethodExceptions methodExceptions) {
        this.methodExceptions = methodExceptions;
    }

    public void setHttpErrors(HttpErrors httpErrors) {
        this.httpErrors = httpErrors;
    }

    public void setHttpLatencies(HttpLatencies httpLatencies) {
        this.httpLatencies = httpLatencies;
    }

    public void setTokenRefreshes(long j) {
        this.tokenRefreshes = j;
    }

    public void setAuthRejections(long j) {
        this.authRejections = j;
    }

    public void setImpressionsQueued(long j) {
        this.impressionsQueued = j;
    }

    public void setImpressionsDeduped(long j) {
        this.impressionsDeduped = j;
    }

    public void setImpressionsDropped(long j) {
        this.impressionsDropped = j;
    }

    public void setSplitCount(long j) {
        this.splitCount = j;
    }

    public void setSegmentCount(long j) {
        this.segmentCount = j;
    }

    public void setSessionLengthMs(long j) {
        this.sessionLengthMs = j;
    }

    public void setEventsQueued(long j) {
        this.eventsQueued = j;
    }

    public void setEventsDropped(long j) {
        this.eventsDropped = j;
    }

    public void setStreamingEvents(List<StreamingEvent> list) {
        this.streamingEvents = list;
    }

    public void setTags(List<String> list) {
        this.tags = list;
    }

    public void setUpdatesFromSSE(UpdatesFromSSE updatesFromSSE) {
        this.updatesFromSSE = updatesFromSSE;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public UpdatesFromSSE getUpdatesFromSSE() {
        return this.updatesFromSSE;
    }

    public LastSync getLastSynchronizations() {
        return this.lastSynchronizations;
    }

    public MethodLatencies getMethodLatencies() {
        return this.methodLatencies;
    }

    public MethodExceptions getMethodExceptions() {
        return this.methodExceptions;
    }

    public HttpErrors getHttpErrors() {
        return this.httpErrors;
    }

    public HttpLatencies getHttpLatencies() {
        return this.httpLatencies;
    }

    public long getTokenRefreshes() {
        return this.tokenRefreshes;
    }

    public long getAuthRejections() {
        return this.authRejections;
    }

    public long getImpressionsQueued() {
        return this.impressionsQueued;
    }

    public long getImpressionsDeduped() {
        return this.impressionsDeduped;
    }

    public long getImpressionsDropped() {
        return this.impressionsDropped;
    }

    public long getSplitCount() {
        return this.splitCount;
    }

    public long getSegmentCount() {
        return this.segmentCount;
    }

    public long getSessionLengthMs() {
        return this.sessionLengthMs;
    }

    public long getEventsQueued() {
        return this.eventsQueued;
    }

    public long getEventsDropped() {
        return this.eventsDropped;
    }

    public List<StreamingEvent> getStreamingEvents() {
        return this.streamingEvents;
    }
}
