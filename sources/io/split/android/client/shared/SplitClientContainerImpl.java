package io.split.android.client.shared;

import com.google.common.base.Preconditions;
import io.split.android.client.EventsTracker;
import io.split.android.client.SplitClientConfig;
import io.split.android.client.SplitClientFactory;
import io.split.android.client.SplitClientFactoryImpl;
import io.split.android.client.SplitFactoryImpl;
import io.split.android.client.api.Key;
import io.split.android.client.events.SplitEventsManager;
import io.split.android.client.impressions.ImpressionListener;
import io.split.android.client.service.SplitApiFacade;
import io.split.android.client.service.executor.SplitClientEventTaskExecutor;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskExecutionListener;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.mysegments.MySegmentsTaskFactory;
import io.split.android.client.service.mysegments.MySegmentsTaskFactoryConfiguration;
import io.split.android.client.service.mysegments.MySegmentsTaskFactoryProvider;
import io.split.android.client.service.mysegments.MySegmentsTaskFactoryProviderImpl;
import io.split.android.client.service.sseclient.sseclient.PushNotificationManager;
import io.split.android.client.service.sseclient.sseclient.PushNotificationManagerDeferredStartTask;
import io.split.android.client.service.synchronizer.SyncManager;
import io.split.android.client.service.synchronizer.mysegments.MySegmentsBackgroundSyncScheduleTask;
import io.split.android.client.service.synchronizer.mysegments.MySegmentsWorkManagerWrapper;
import io.split.android.client.storage.common.SplitStorageContainer;
import io.split.android.client.telemetry.TelemetrySynchronizer;
import io.split.android.client.validators.KeyValidator;
import io.split.android.client.validators.ValidationMessageLogger;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes6.dex */
public final class SplitClientContainerImpl extends BaseSplitClientContainer {
    private final ClientComponentsRegister mClientComponentsRegister;
    private final SplitClientConfig mConfig;
    private final AtomicBoolean mConnecting;
    private final String mDefaultMatchingKey;
    private final MySegmentsTaskFactoryProvider mMySegmentsTaskFactoryProvider;
    private final PushNotificationManager mPushNotificationManager;
    private final AtomicBoolean mSchedulingBackgroundSync;
    private final SplitTaskExecutionListener mSchedulingBackgroundSyncExecutionListener;
    private final SplitApiFacade mSplitApiFacade;
    private final SplitTaskExecutor mSplitClientEventTaskExecutor;
    private final SplitClientFactory mSplitClientFactory;
    private final SplitTaskExecutor mSplitTaskExecutor;
    private final SplitStorageContainer mStorageContainer;
    private SplitTaskExecutionListener mStreamingConnectionExecutionListener;
    private final boolean mStreamingEnabled;
    private final MySegmentsWorkManagerWrapper mWorkManagerWrapper;

    public SplitClientContainerImpl(String str, SplitFactoryImpl splitFactoryImpl, SplitClientConfig splitClientConfig, SyncManager syncManager, TelemetrySynchronizer telemetrySynchronizer, SplitStorageContainer splitStorageContainer, SplitTaskExecutor splitTaskExecutor, SplitApiFacade splitApiFacade, ValidationMessageLogger validationMessageLogger, KeyValidator keyValidator, ImpressionListener impressionListener, PushNotificationManager pushNotificationManager, ClientComponentsRegister clientComponentsRegister, MySegmentsWorkManagerWrapper mySegmentsWorkManagerWrapper, EventsTracker eventsTracker) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.mConnecting = atomicBoolean;
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
        this.mSchedulingBackgroundSync = atomicBoolean2;
        this.mDefaultMatchingKey = (String) Preconditions.checkNotNull(str);
        this.mPushNotificationManager = pushNotificationManager;
        this.mStreamingEnabled = splitClientConfig.streamingEnabled();
        this.mMySegmentsTaskFactoryProvider = new MySegmentsTaskFactoryProviderImpl(splitStorageContainer.getTelemetryStorage());
        this.mSplitApiFacade = (SplitApiFacade) Preconditions.checkNotNull(splitApiFacade);
        this.mStorageContainer = (SplitStorageContainer) Preconditions.checkNotNull(splitStorageContainer);
        this.mConfig = (SplitClientConfig) Preconditions.checkNotNull(splitClientConfig);
        this.mSplitClientFactory = new SplitClientFactoryImpl(splitFactoryImpl, this, splitClientConfig, syncManager, telemetrySynchronizer, splitStorageContainer, splitTaskExecutor, validationMessageLogger, keyValidator, eventsTracker, impressionListener);
        this.mClientComponentsRegister = (ClientComponentsRegister) Preconditions.checkNotNull(clientComponentsRegister);
        this.mSplitTaskExecutor = (SplitTaskExecutor) Preconditions.checkNotNull(splitTaskExecutor);
        this.mSchedulingBackgroundSyncExecutionListener = new WorkManagerSchedulingListener(atomicBoolean2);
        this.mWorkManagerWrapper = (MySegmentsWorkManagerWrapper) Preconditions.checkNotNull(mySegmentsWorkManagerWrapper);
        this.mSplitClientEventTaskExecutor = new SplitClientEventTaskExecutor();
        if (splitClientConfig.syncEnabled()) {
            this.mStreamingConnectionExecutionListener = new StreamingConnectionExecutionListener(atomicBoolean);
        }
    }

    public SplitClientContainerImpl(String str, PushNotificationManager pushNotificationManager, boolean z, MySegmentsTaskFactoryProvider mySegmentsTaskFactoryProvider, SplitApiFacade splitApiFacade, SplitStorageContainer splitStorageContainer, SplitTaskExecutor splitTaskExecutor, SplitClientConfig splitClientConfig, SplitClientFactory splitClientFactory, ClientComponentsRegister clientComponentsRegister, MySegmentsWorkManagerWrapper mySegmentsWorkManagerWrapper, EventsTracker eventsTracker) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.mConnecting = atomicBoolean;
        this.mSchedulingBackgroundSync = new AtomicBoolean(false);
        this.mDefaultMatchingKey = (String) Preconditions.checkNotNull(str);
        this.mPushNotificationManager = pushNotificationManager;
        this.mStreamingEnabled = z;
        this.mMySegmentsTaskFactoryProvider = (MySegmentsTaskFactoryProvider) Preconditions.checkNotNull(mySegmentsTaskFactoryProvider);
        this.mSplitApiFacade = (SplitApiFacade) Preconditions.checkNotNull(splitApiFacade);
        this.mStorageContainer = (SplitStorageContainer) Preconditions.checkNotNull(splitStorageContainer);
        this.mConfig = (SplitClientConfig) Preconditions.checkNotNull(splitClientConfig);
        this.mSplitClientFactory = (SplitClientFactory) Preconditions.checkNotNull(splitClientFactory);
        this.mClientComponentsRegister = (ClientComponentsRegister) Preconditions.checkNotNull(clientComponentsRegister);
        this.mSplitTaskExecutor = (SplitTaskExecutor) Preconditions.checkNotNull(splitTaskExecutor);
        this.mStreamingConnectionExecutionListener = new StreamingConnectionExecutionListener(atomicBoolean);
        this.mSchedulingBackgroundSyncExecutionListener = new WorkManagerSchedulingListener(atomicBoolean);
        this.mWorkManagerWrapper = (MySegmentsWorkManagerWrapper) Preconditions.checkNotNull(mySegmentsWorkManagerWrapper);
        this.mSplitClientEventTaskExecutor = new SplitClientEventTaskExecutor();
    }

    @Override // io.split.android.client.shared.BaseSplitClientContainer, io.split.android.client.shared.SplitClientContainer
    public final void remove(Key key) {
        super.remove(key);
        this.mClientComponentsRegister.unregisterComponentsForKey(key);
    }

    @Override // io.split.android.client.shared.BaseSplitClientContainer
    public final void createNewClient(Key key) {
        SplitEventsManager splitEventsManager = new SplitEventsManager(this.mConfig, this.mSplitClientEventTaskExecutor);
        MySegmentsTaskFactory mySegmentsTaskFactory = getMySegmentsTaskFactory(key, splitEventsManager);
        trackNewClient(key, this.mSplitClientFactory.getClient(key, mySegmentsTaskFactory, splitEventsManager, this.mDefaultMatchingKey.equals(key.matchingKey())));
        this.mClientComponentsRegister.registerComponents(key, mySegmentsTaskFactory, splitEventsManager);
        if (this.mConfig.syncEnabled() && this.mStreamingEnabled) {
            connectToStreaming();
        }
        if (this.mConfig.synchronizeInBackground()) {
            scheduleMySegmentsWork();
        } else {
            this.mWorkManagerWrapper.removeWork();
        }
    }

    private MySegmentsTaskFactory getMySegmentsTaskFactory(Key key, SplitEventsManager splitEventsManager) {
        return this.mMySegmentsTaskFactoryProvider.getFactory(new MySegmentsTaskFactoryConfiguration(this.mSplitApiFacade.getMySegmentsFetcher(key.matchingKey()), this.mStorageContainer.getMySegmentsStorage(key.matchingKey()), splitEventsManager));
    }

    private void connectToStreaming() {
        if (this.mConfig.syncEnabled() && !this.mConnecting.getAndSet(true)) {
            this.mSplitTaskExecutor.schedule(new PushNotificationManagerDeferredStartTask(this.mPushNotificationManager), 5L, this.mStreamingConnectionExecutionListener);
        }
    }

    private void scheduleMySegmentsWork() {
        if (this.mConfig.syncEnabled() && !this.mSchedulingBackgroundSync.getAndSet(true)) {
            this.mSplitTaskExecutor.schedule(new MySegmentsBackgroundSyncScheduleTask(this.mWorkManagerWrapper, getKeySet()), 5L, this.mSchedulingBackgroundSyncExecutionListener);
        }
    }

    /* loaded from: classes6.dex */
    static class StreamingConnectionExecutionListener implements SplitTaskExecutionListener {
        private final AtomicBoolean mConnecting;

        StreamingConnectionExecutionListener(AtomicBoolean atomicBoolean) {
            this.mConnecting = atomicBoolean;
        }

        @Override // io.split.android.client.service.executor.SplitTaskExecutionListener
        public void taskExecuted(SplitTaskExecutionInfo splitTaskExecutionInfo) {
            this.mConnecting.set(false);
        }
    }

    /* loaded from: classes6.dex */
    static class WorkManagerSchedulingListener implements SplitTaskExecutionListener {
        private final AtomicBoolean mScheduling;

        WorkManagerSchedulingListener(AtomicBoolean atomicBoolean) {
            this.mScheduling = atomicBoolean;
        }

        @Override // io.split.android.client.service.executor.SplitTaskExecutionListener
        public void taskExecuted(SplitTaskExecutionInfo splitTaskExecutionInfo) {
            this.mScheduling.set(false);
        }
    }
}
