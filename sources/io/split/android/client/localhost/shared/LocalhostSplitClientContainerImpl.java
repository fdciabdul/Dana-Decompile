package io.split.android.client.localhost.shared;

import io.split.android.client.SplitClientConfig;
import io.split.android.client.api.Key;
import io.split.android.client.attributes.AttributesManagerFactory;
import io.split.android.client.attributes.AttributesMerger;
import io.split.android.client.events.EventsManagerCoordinator;
import io.split.android.client.events.SplitEventsManager;
import io.split.android.client.events.SplitInternalEvent;
import io.split.android.client.localhost.LocalhostSplitClient;
import io.split.android.client.localhost.LocalhostSplitFactory;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.shared.BaseSplitClientContainer;
import io.split.android.client.storage.attributes.AttributesStorageImpl;
import io.split.android.client.storage.splits.SplitsStorage;
import io.split.android.client.telemetry.storage.TelemetryStorageProducer;
import io.split.android.engine.experiments.SplitParser;

/* loaded from: classes6.dex */
public class LocalhostSplitClientContainerImpl extends BaseSplitClientContainer {
    private final AttributesManagerFactory mAttributesManagerFactory;
    private final AttributesMerger mAttributesMerger;
    private final SplitClientConfig mConfig;
    private final EventsManagerCoordinator mEventsManagerCoordinator;
    private final LocalhostSplitFactory mSplitFactory;
    private final SplitParser mSplitParser;
    private final SplitsStorage mSplitStorage;
    private final SplitTaskExecutor mSplitTaskExecutor;
    private final TelemetryStorageProducer mTelemetryStorageProducer;

    public LocalhostSplitClientContainerImpl(LocalhostSplitFactory localhostSplitFactory, SplitClientConfig splitClientConfig, SplitsStorage splitsStorage, SplitParser splitParser, AttributesManagerFactory attributesManagerFactory, AttributesMerger attributesMerger, TelemetryStorageProducer telemetryStorageProducer, EventsManagerCoordinator eventsManagerCoordinator, SplitTaskExecutor splitTaskExecutor) {
        this.mSplitFactory = localhostSplitFactory;
        this.mConfig = splitClientConfig;
        this.mSplitStorage = splitsStorage;
        this.mSplitParser = splitParser;
        this.mAttributesManagerFactory = attributesManagerFactory;
        this.mAttributesMerger = attributesMerger;
        this.mTelemetryStorageProducer = telemetryStorageProducer;
        this.mEventsManagerCoordinator = eventsManagerCoordinator;
        this.mSplitTaskExecutor = splitTaskExecutor;
    }

    @Override // io.split.android.client.shared.BaseSplitClientContainer
    public void createNewClient(Key key) {
        SplitEventsManager splitEventsManager = new SplitEventsManager(this.mConfig, this.mSplitTaskExecutor);
        splitEventsManager.notifyInternalEvent(SplitInternalEvent.MY_SEGMENTS_LOADED_FROM_STORAGE);
        splitEventsManager.notifyInternalEvent(SplitInternalEvent.MY_SEGMENTS_FETCHED);
        splitEventsManager.notifyInternalEvent(SplitInternalEvent.MY_SEGMENTS_UPDATED);
        LocalhostSplitClient localhostSplitClient = new LocalhostSplitClient(this.mSplitFactory, this, this.mConfig, key, this.mSplitStorage, splitEventsManager, this.mSplitParser, this.mAttributesManagerFactory.getManager(key.matchingKey(), new AttributesStorageImpl()), this.mAttributesMerger, this.mTelemetryStorageProducer);
        splitEventsManager.getExecutorResources().setSplitClient(localhostSplitClient);
        trackNewClient(key, localhostSplitClient);
        this.mEventsManagerCoordinator.registerEventsManager(key, splitEventsManager);
    }
}
