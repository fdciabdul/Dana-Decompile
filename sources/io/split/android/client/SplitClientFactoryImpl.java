package io.split.android.client;

import com.google.common.base.Preconditions;
import io.split.android.client.api.Key;
import io.split.android.client.attributes.AttributesManagerFactory;
import io.split.android.client.attributes.AttributesManagerFactoryImpl;
import io.split.android.client.attributes.AttributesMergerImpl;
import io.split.android.client.events.SplitEvent;
import io.split.android.client.events.SplitEventTask;
import io.split.android.client.events.SplitEventsManager;
import io.split.android.client.impressions.ImpressionListener;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.mysegments.MySegmentsTaskFactory;
import io.split.android.client.service.synchronizer.SyncManager;
import io.split.android.client.shared.SplitClientContainer;
import io.split.android.client.storage.attributes.AttributesStorage;
import io.split.android.client.storage.attributes.PersistentAttributesStorage;
import io.split.android.client.storage.common.SplitStorageContainer;
import io.split.android.client.telemetry.TelemetrySynchronizer;
import io.split.android.client.telemetry.storage.TelemetryInitProducer;
import io.split.android.client.validators.AttributesValidatorImpl;
import io.split.android.client.validators.KeyValidator;
import io.split.android.client.validators.SplitValidatorImpl;
import io.split.android.client.validators.TreatmentManagerFactory;
import io.split.android.client.validators.TreatmentManagerFactoryImpl;
import io.split.android.client.validators.ValidationMessageLogger;
import io.split.android.engine.experiments.SplitParser;

/* loaded from: classes6.dex */
public class SplitClientFactoryImpl implements SplitClientFactory {
    private final AttributesManagerFactory mAttributesManagerFactory;
    private final SplitClientContainer mClientContainer;
    private final SplitClientConfig mConfig;
    private final ImpressionListener mCustomerImpressionListener;
    private final EventsTracker mEventsTracker;
    private final SplitFactory mSplitFactory;
    private final SplitParser mSplitParser;
    private final SplitValidatorImpl mSplitValidator;
    private final SplitStorageContainer mStorageContainer;
    private final SyncManager mSyncManager;
    private final TelemetrySynchronizer mTelemetrySynchronizer;
    private final TreatmentManagerFactory mTreatmentManagerFactory;

    public SplitClientFactoryImpl(SplitFactory splitFactory, SplitClientContainer splitClientContainer, SplitClientConfig splitClientConfig, SyncManager syncManager, TelemetrySynchronizer telemetrySynchronizer, SplitStorageContainer splitStorageContainer, SplitTaskExecutor splitTaskExecutor, ValidationMessageLogger validationMessageLogger, KeyValidator keyValidator, EventsTracker eventsTracker, ImpressionListener impressionListener) {
        this.mSplitFactory = (SplitFactory) Preconditions.checkNotNull(splitFactory);
        this.mClientContainer = (SplitClientContainer) Preconditions.checkNotNull(splitClientContainer);
        this.mConfig = (SplitClientConfig) Preconditions.checkNotNull(splitClientConfig);
        this.mSyncManager = (SyncManager) Preconditions.checkNotNull(syncManager);
        SplitStorageContainer splitStorageContainer2 = (SplitStorageContainer) Preconditions.checkNotNull(splitStorageContainer);
        this.mStorageContainer = splitStorageContainer2;
        this.mTelemetrySynchronizer = (TelemetrySynchronizer) Preconditions.checkNotNull(telemetrySynchronizer);
        this.mCustomerImpressionListener = (ImpressionListener) Preconditions.checkNotNull(impressionListener);
        this.mEventsTracker = (EventsTracker) Preconditions.checkNotNull(eventsTracker);
        this.mAttributesManagerFactory = getAttributesManagerFactory(splitClientConfig.persistentAttributesEnabled(), validationMessageLogger, splitTaskExecutor, splitStorageContainer2.getPersistentAttributesStorage());
        SplitParser splitParser = new SplitParser(splitStorageContainer2.getMySegmentsStorageContainer());
        this.mSplitParser = splitParser;
        SplitValidatorImpl splitValidatorImpl = new SplitValidatorImpl();
        this.mSplitValidator = splitValidatorImpl;
        this.mTreatmentManagerFactory = new TreatmentManagerFactoryImpl(keyValidator, splitValidatorImpl, impressionListener, splitClientConfig.labelsEnabled(), new AttributesMergerImpl(), splitStorageContainer2.getTelemetryStorage(), new EvaluatorImpl(splitStorageContainer2.getSplitsStorage(), splitParser));
    }

    @Override // io.split.android.client.SplitClientFactory
    public SplitClient getClient(Key key, MySegmentsTaskFactory mySegmentsTaskFactory, SplitEventsManager splitEventsManager, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        AttributesStorage attributesStorage = this.mStorageContainer.getAttributesStorage(key.matchingKey());
        SplitClientImpl splitClientImpl = new SplitClientImpl(this.mSplitFactory, this.mClientContainer, key, this.mSplitParser, this.mCustomerImpressionListener, this.mConfig, splitEventsManager, this.mEventsTracker, this.mAttributesManagerFactory.getManager(key.matchingKey(), attributesStorage), this.mStorageContainer.getTelemetryStorage(), this.mSplitValidator, this.mTreatmentManagerFactory.getTreatmentManager(key, splitEventsManager, this.mAttributesManagerFactory.getManager(key.matchingKey(), attributesStorage)));
        splitEventsManager.getExecutorResources().setSplitClient(splitClientImpl);
        if (z) {
            registerTelemetryTasksInEventManager(splitEventsManager, this.mTelemetrySynchronizer, this.mStorageContainer.getTelemetryStorage(), currentTimeMillis, this.mConfig.shouldRecordTelemetry());
            return splitClientImpl;
        }
        return splitClientImpl;
    }

    private AttributesManagerFactory getAttributesManagerFactory(boolean z, ValidationMessageLogger validationMessageLogger, SplitTaskExecutor splitTaskExecutor, PersistentAttributesStorage persistentAttributesStorage) {
        if (z) {
            return new AttributesManagerFactoryImpl(new AttributesValidatorImpl(), validationMessageLogger, persistentAttributesStorage, splitTaskExecutor);
        }
        return new AttributesManagerFactoryImpl(new AttributesValidatorImpl(), validationMessageLogger);
    }

    private void registerTelemetryTasksInEventManager(SplitEventsManager splitEventsManager, final TelemetrySynchronizer telemetrySynchronizer, final TelemetryInitProducer telemetryInitProducer, final long j, boolean z) {
        if (z) {
            splitEventsManager.register(SplitEvent.SDK_READY_FROM_CACHE, new SplitEventTask() { // from class: io.split.android.client.SplitClientFactoryImpl.1
                @Override // io.split.android.client.events.SplitEventTask
                public void onPostExecution(SplitClient splitClient) {
                    telemetryInitProducer.recordTimeUntilReadyFromCache(System.currentTimeMillis() - j);
                }
            });
            splitEventsManager.register(SplitEvent.SDK_READY, new SplitEventTask() { // from class: io.split.android.client.SplitClientFactoryImpl.2
                @Override // io.split.android.client.events.SplitEventTask
                public void onPostExecution(SplitClient splitClient) {
                    telemetryInitProducer.recordTimeUntilReady(System.currentTimeMillis() - j);
                    telemetrySynchronizer.synchronizeConfig();
                }
            });
        }
    }
}
