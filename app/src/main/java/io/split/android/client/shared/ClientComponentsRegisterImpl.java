package io.split.android.client.shared;

import com.google.common.base.Preconditions;
import io.split.android.client.SplitClientConfig;
import io.split.android.client.api.Key;
import io.split.android.client.events.EventsManagerRegistry;
import io.split.android.client.events.SplitEventsManager;
import io.split.android.client.service.attributes.AttributeTaskFactoryImpl;
import io.split.android.client.service.mysegments.MySegmentsTaskFactory;
import io.split.android.client.service.sseclient.notifications.MySegmentChangeNotification;
import io.split.android.client.service.sseclient.notifications.MySegmentsV2PayloadDecoder;
import io.split.android.client.service.sseclient.notifications.mysegments.MySegmentsNotificationProcessor;
import io.split.android.client.service.sseclient.notifications.mysegments.MySegmentsNotificationProcessorConfiguration;
import io.split.android.client.service.sseclient.notifications.mysegments.MySegmentsNotificationProcessorFactory;
import io.split.android.client.service.sseclient.notifications.mysegments.MySegmentsNotificationProcessorRegistry;
import io.split.android.client.service.sseclient.reactor.MySegmentsUpdateWorker;
import io.split.android.client.service.sseclient.reactor.MySegmentsUpdateWorkerRegistry;
import io.split.android.client.service.sseclient.sseclient.SseAuthenticator;
import io.split.android.client.service.synchronizer.attributes.AttributesSynchronizerFactory;
import io.split.android.client.service.synchronizer.attributes.AttributesSynchronizerRegistry;
import io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizer;
import io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizerFactory;
import io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizerRegistry;
import io.split.android.client.storage.common.SplitStorageContainer;
import java.util.concurrent.LinkedBlockingDeque;

/* loaded from: classes6.dex */
public class ClientComponentsRegisterImpl implements ClientComponentsRegister {
    private final AttributesSynchronizerFactory mAttributesSynchronizerFactory;
    private final AttributesSynchronizerRegistry mAttributesSynchronizerRegistry;
    private final EventsManagerRegistry mEventsManagerRegistry;
    private final MySegmentsNotificationProcessorFactory mMySegmentsNotificationProcessorFactory;
    private final MySegmentsNotificationProcessorRegistry mMySegmentsNotificationProcessorRegistry;
    private final MySegmentsSynchronizerFactory mMySegmentsSynchronizerFactory;
    private final MySegmentsSynchronizerRegistry mMySegmentsSynchronizerRegistry;
    private final MySegmentsUpdateWorkerRegistry mMySegmentsUpdateWorkerRegistry;
    private final MySegmentsV2PayloadDecoder mMySegmentsV2PayloadDecoder;
    private final SplitClientConfig mSplitConfig;
    private final SseAuthenticator mSseAuthenticator;
    private final SplitStorageContainer mStorageContainer;

    public ClientComponentsRegisterImpl(SplitClientConfig splitClientConfig, MySegmentsSynchronizerFactory mySegmentsSynchronizerFactory, SplitStorageContainer splitStorageContainer, AttributesSynchronizerFactory attributesSynchronizerFactory, AttributesSynchronizerRegistry attributesSynchronizerRegistry, MySegmentsSynchronizerRegistry mySegmentsSynchronizerRegistry, MySegmentsUpdateWorkerRegistry mySegmentsUpdateWorkerRegistry, EventsManagerRegistry eventsManagerRegistry, SseAuthenticator sseAuthenticator, MySegmentsNotificationProcessorRegistry mySegmentsNotificationProcessorRegistry, MySegmentsNotificationProcessorFactory mySegmentsNotificationProcessorFactory, MySegmentsV2PayloadDecoder mySegmentsV2PayloadDecoder) {
        this.mSplitConfig = splitClientConfig;
        this.mMySegmentsSynchronizerFactory = (MySegmentsSynchronizerFactory) Preconditions.checkNotNull(mySegmentsSynchronizerFactory);
        this.mStorageContainer = (SplitStorageContainer) Preconditions.checkNotNull(splitStorageContainer);
        this.mAttributesSynchronizerFactory = (AttributesSynchronizerFactory) Preconditions.checkNotNull(attributesSynchronizerFactory);
        this.mAttributesSynchronizerRegistry = (AttributesSynchronizerRegistry) Preconditions.checkNotNull(attributesSynchronizerRegistry);
        this.mEventsManagerRegistry = (EventsManagerRegistry) Preconditions.checkNotNull(eventsManagerRegistry);
        this.mMySegmentsSynchronizerRegistry = (MySegmentsSynchronizerRegistry) Preconditions.checkNotNull(mySegmentsSynchronizerRegistry);
        this.mMySegmentsNotificationProcessorRegistry = mySegmentsNotificationProcessorRegistry;
        this.mMySegmentsUpdateWorkerRegistry = mySegmentsUpdateWorkerRegistry;
        this.mSseAuthenticator = sseAuthenticator;
        this.mMySegmentsNotificationProcessorFactory = mySegmentsNotificationProcessorFactory;
        this.mMySegmentsV2PayloadDecoder = mySegmentsV2PayloadDecoder;
    }

    @Override // io.split.android.client.shared.ClientComponentsRegister
    public void registerComponents(Key key, MySegmentsTaskFactory mySegmentsTaskFactory, SplitEventsManager splitEventsManager) {
        registerEventsManager(key, splitEventsManager);
        MySegmentsSynchronizer synchronizer = this.mMySegmentsSynchronizerFactory.getSynchronizer(mySegmentsTaskFactory, splitEventsManager);
        registerMySegmentsSynchronizer(key, synchronizer);
        registerAttributesSynchronizer(key, splitEventsManager);
        if (isSyncEnabled()) {
            registerKeyInSeeAuthenticator(key);
            LinkedBlockingDeque<MySegmentChangeNotification> linkedBlockingDeque = new LinkedBlockingDeque<>();
            registerMySegmentsNotificationProcessor(key, mySegmentsTaskFactory, linkedBlockingDeque);
            registerMySegmentsUpdateWorker(key, synchronizer, linkedBlockingDeque);
        }
    }

    @Override // io.split.android.client.shared.ClientComponentsRegister
    public void unregisterComponentsForKey(Key key) {
        this.mAttributesSynchronizerRegistry.unregisterAttributesSynchronizer(key.matchingKey());
        this.mMySegmentsSynchronizerRegistry.unregisterMySegmentsSynchronizer(key.matchingKey());
        this.mEventsManagerRegistry.unregisterEventsManager(key);
        if (isSyncEnabled()) {
            this.mSseAuthenticator.unregisterKey(key.matchingKey());
            this.mMySegmentsUpdateWorkerRegistry.unregisterMySegmentsUpdateWorker(key.matchingKey());
            this.mMySegmentsNotificationProcessorRegistry.unregisterMySegmentsProcessor(key.matchingKey());
        }
    }

    private void registerAttributesSynchronizer(Key key, SplitEventsManager splitEventsManager) {
        this.mAttributesSynchronizerRegistry.registerAttributesSynchronizer(key.matchingKey(), this.mAttributesSynchronizerFactory.getSynchronizer(new AttributeTaskFactoryImpl(key.matchingKey(), this.mStorageContainer.getAttributesStorage(key.matchingKey())), splitEventsManager));
    }

    private void registerMySegmentsSynchronizer(Key key, MySegmentsSynchronizer mySegmentsSynchronizer) {
        this.mMySegmentsSynchronizerRegistry.registerMySegmentsSynchronizer(key.matchingKey(), mySegmentsSynchronizer);
    }

    private void registerMySegmentsUpdateWorker(Key key, MySegmentsSynchronizer mySegmentsSynchronizer, LinkedBlockingDeque<MySegmentChangeNotification> linkedBlockingDeque) {
        this.mMySegmentsUpdateWorkerRegistry.registerMySegmentsUpdateWorker(key.matchingKey(), new MySegmentsUpdateWorker(mySegmentsSynchronizer, linkedBlockingDeque));
    }

    private void registerEventsManager(Key key, SplitEventsManager splitEventsManager) {
        this.mEventsManagerRegistry.registerEventsManager(key, splitEventsManager);
    }

    private void registerKeyInSeeAuthenticator(Key key) {
        this.mSseAuthenticator.registerKey(key.matchingKey());
    }

    private void registerMySegmentsNotificationProcessor(Key key, MySegmentsTaskFactory mySegmentsTaskFactory, LinkedBlockingDeque<MySegmentChangeNotification> linkedBlockingDeque) {
        this.mMySegmentsNotificationProcessorRegistry.registerMySegmentsProcessor(key.matchingKey(), getMySegmentsNotificationProcessor(key, mySegmentsTaskFactory, linkedBlockingDeque));
    }

    private MySegmentsNotificationProcessor getMySegmentsNotificationProcessor(Key key, MySegmentsTaskFactory mySegmentsTaskFactory, LinkedBlockingDeque<MySegmentChangeNotification> linkedBlockingDeque) {
        return this.mMySegmentsNotificationProcessorFactory.getProcessor(new MySegmentsNotificationProcessorConfiguration(mySegmentsTaskFactory, linkedBlockingDeque, this.mMySegmentsV2PayloadDecoder.hashKey(key.matchingKey())));
    }

    private boolean isSyncEnabled() {
        return this.mSplitConfig.syncEnabled();
    }
}
