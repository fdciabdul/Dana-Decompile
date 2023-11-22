package io.split.android.client.telemetry.storage;

import com.google.common.base.Preconditions;
import io.split.android.client.ServiceEndpoints;
import io.split.android.client.SplitClientConfig;
import io.split.android.client.service.impressions.ImpressionsMode;
import io.split.android.client.telemetry.model.Config;
import io.split.android.client.telemetry.model.RefreshRates;
import io.split.android.client.telemetry.model.UrlOverrides;

/* loaded from: classes6.dex */
public class TelemetryConfigProviderImpl implements TelemetryConfigProvider {
    private final SplitClientConfig mSplitClientConfig;
    private final TelemetryStorageConsumer mTelemetryConsumer;

    public TelemetryConfigProviderImpl(TelemetryStorageConsumer telemetryStorageConsumer, SplitClientConfig splitClientConfig) {
        this.mTelemetryConsumer = (TelemetryStorageConsumer) Preconditions.checkNotNull(telemetryStorageConsumer);
        this.mSplitClientConfig = (SplitClientConfig) Preconditions.checkNotNull(splitClientConfig);
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryConfigProvider
    public Config getConfigTelemetry() {
        Config config = new Config();
        config.setStreamingEnabled(this.mSplitClientConfig.streamingEnabled());
        config.setRefreshRates(buildRefreshRates(this.mSplitClientConfig));
        config.setTags(this.mTelemetryConsumer.popTags());
        config.setImpressionsListenerEnabled(this.mSplitClientConfig.impressionListener() != null);
        config.setTimeUntilSDKReady(this.mTelemetryConsumer.getTimeUntilReady());
        config.setTimeUntilSDKReadyFromCache(this.mTelemetryConsumer.getTimeUntilReadyFromCache());
        config.setRedundantActiveFactories(this.mTelemetryConsumer.getRedundantFactories());
        config.setActiveFactories(this.mTelemetryConsumer.getActiveFactories());
        config.setHttpProxyDetected(this.mSplitClientConfig.proxy() != null);
        config.setSDKNotReadyUsage(this.mTelemetryConsumer.getNonReadyUsage());
        config.setUrlOverrides(buildUrlOverrides(this.mSplitClientConfig));
        config.setImpressionsQueueSize(this.mSplitClientConfig.impressionsQueueSize());
        config.setEventsQueueSize(this.mSplitClientConfig.eventsQueueSize());
        config.setUserConsent(this.mSplitClientConfig.userConsent().intValue());
        if (this.mSplitClientConfig.impressionsMode() == ImpressionsMode.DEBUG) {
            config.setImpressionsMode(io.split.android.client.telemetry.model.ImpressionsMode.DEBUG.intValue());
        } else if (this.mSplitClientConfig.impressionsMode() == ImpressionsMode.OPTIMIZED) {
            config.setImpressionsMode(io.split.android.client.telemetry.model.ImpressionsMode.OPTIMIZED.intValue());
        } else {
            config.setImpressionsMode(io.split.android.client.telemetry.model.ImpressionsMode.NONE.intValue());
        }
        return config;
    }

    private RefreshRates buildRefreshRates(SplitClientConfig splitClientConfig) {
        RefreshRates refreshRates = new RefreshRates();
        refreshRates.setTelemetry(splitClientConfig.telemetryRefreshRate());
        refreshRates.setSplits(splitClientConfig.featuresRefreshRate());
        refreshRates.setMySegments(splitClientConfig.segmentsRefreshRate());
        refreshRates.setImpressions(splitClientConfig.impressionsRefreshRate());
        refreshRates.setEvents(splitClientConfig.eventFlushInterval());
        return refreshRates;
    }

    private UrlOverrides buildUrlOverrides(SplitClientConfig splitClientConfig) {
        UrlOverrides urlOverrides = new UrlOverrides();
        urlOverrides.setAuth(ServiceEndpoints.EndpointValidator.authEndpointIsOverridden(splitClientConfig.authServiceUrl()));
        urlOverrides.setSdkUrl(ServiceEndpoints.EndpointValidator.sdkEndpointIsOverridden(splitClientConfig.endpoint()));
        urlOverrides.setStream(ServiceEndpoints.EndpointValidator.streamingEndpointIsOverridden(splitClientConfig.streamingServiceUrl()));
        urlOverrides.setEvents(ServiceEndpoints.EndpointValidator.eventsEndpointIsOverridden(splitClientConfig.eventsEndpoint()));
        urlOverrides.setTelemetry(ServiceEndpoints.EndpointValidator.telemetryEndpointIsOverridden(splitClientConfig.telemetryEndpoint()));
        return urlOverrides;
    }
}
