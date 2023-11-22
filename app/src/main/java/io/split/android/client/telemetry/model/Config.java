package io.split.android.client.telemetry.model;

import com.alibaba.ariver.kernel.RVParams;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.opendevice.i;
import java.util.List;

/* loaded from: classes6.dex */
public class Config {
    @SerializedName("nR")
    private long SDKNotReadyUsage;
    @SerializedName("aF")
    private long activeFactories;
    @SerializedName("eQ")
    private long eventsQueueSize;
    @SerializedName("hP")
    private boolean httpProxyDetected;
    @SerializedName("iL")
    private boolean impressionsListenerEnabled;
    @SerializedName("iM")
    private int impressionsMode;
    @SerializedName("iQ")
    private long impressionsQueueSize;
    @SerializedName(i.MyBillsEntityDataFactory)
    private List<String> integrations;
    @SerializedName("rF")
    private long redundantActiveFactories;
    @SerializedName("rR")
    private RefreshRates refreshRates;
    @SerializedName("sE")
    private boolean streamingEnabled;
    @SerializedName(SecurityConstants.KEY_TEXT)
    private List<String> tags;
    @SerializedName("tR")
    private long timeUntilSDKReady;
    @SerializedName("tC")
    private long timeUntilSDKReadyFromCache;
    @SerializedName("uO")
    private UrlOverrides urlOverrides;
    @SerializedName("uC")
    private long userConsent;
    @SerializedName("oM")
    private final int operationMode = OperationMode.STANDALONE.getNumericValue();
    @SerializedName(RVParams.SHOW_TITLEBAR)
    private final String storage = "memory";

    public String getStorage() {
        return "memory";
    }

    public int getOperationMode() {
        return this.operationMode;
    }

    public boolean isStreamingEnabled() {
        return this.streamingEnabled;
    }

    public void setStreamingEnabled(boolean z) {
        this.streamingEnabled = z;
    }

    public RefreshRates getRefreshRates() {
        return this.refreshRates;
    }

    public void setRefreshRates(RefreshRates refreshRates) {
        this.refreshRates = refreshRates;
    }

    public UrlOverrides getUrlOverrides() {
        return this.urlOverrides;
    }

    public void setUrlOverrides(UrlOverrides urlOverrides) {
        this.urlOverrides = urlOverrides;
    }

    public long getImpressionsQueueSize() {
        return this.impressionsQueueSize;
    }

    public void setImpressionsQueueSize(long j) {
        this.impressionsQueueSize = j;
    }

    public long getEventsQueueSize() {
        return this.eventsQueueSize;
    }

    public void setEventsQueueSize(long j) {
        this.eventsQueueSize = j;
    }

    public int getImpressionsMode() {
        return this.impressionsMode;
    }

    public void setImpressionsMode(int i) {
        this.impressionsMode = i;
    }

    public boolean isImpressionsListenerEnabled() {
        return this.impressionsListenerEnabled;
    }

    public void setImpressionsListenerEnabled(boolean z) {
        this.impressionsListenerEnabled = z;
    }

    public boolean isHttpProxyDetected() {
        return this.httpProxyDetected;
    }

    public void setHttpProxyDetected(boolean z) {
        this.httpProxyDetected = z;
    }

    public long getActiveFactories() {
        return this.activeFactories;
    }

    public void setActiveFactories(long j) {
        this.activeFactories = j;
    }

    public long getRedundantActiveFactories() {
        return this.redundantActiveFactories;
    }

    public void setRedundantActiveFactories(long j) {
        this.redundantActiveFactories = j;
    }

    public long getTimeUntilSDKReady() {
        return this.timeUntilSDKReady;
    }

    public void setTimeUntilSDKReady(long j) {
        this.timeUntilSDKReady = j;
    }

    public long getTimeUntilSDKReadyFromCache() {
        return this.timeUntilSDKReadyFromCache;
    }

    public void setTimeUntilSDKReadyFromCache(long j) {
        this.timeUntilSDKReadyFromCache = j;
    }

    public long getSDKNotReadyUsage() {
        return this.SDKNotReadyUsage;
    }

    public long getUserConsent() {
        return this.userConsent;
    }

    public void setUserConsent(long j) {
        this.userConsent = j;
    }

    public void setSDKNotReadyUsage(long j) {
        this.SDKNotReadyUsage = j;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public void setTags(List<String> list) {
        this.tags = list;
    }

    public List<String> getIntegrations() {
        return this.integrations;
    }

    public void setIntegrations(List<String> list) {
        this.integrations = list;
    }
}
