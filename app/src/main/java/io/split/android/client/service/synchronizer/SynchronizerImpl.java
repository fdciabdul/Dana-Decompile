package io.split.android.client.service.synchronizer;

import com.google.common.base.Preconditions;
import io.split.android.client.RetryBackoffCounterTimerFactory;
import io.split.android.client.SplitClientConfig;
import io.split.android.client.dtos.Event;
import io.split.android.client.events.ISplitEventsManager;
import io.split.android.client.impressions.Impression;
import io.split.android.client.service.ServiceConstants;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskExecutionListener;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.executor.SplitTaskFactory;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.service.impressions.ImpressionManager;
import io.split.android.client.service.sseclient.feedbackchannel.PushManagerEventBroadcaster;
import io.split.android.client.service.sseclient.sseclient.RetryBackoffCounterTimer;
import io.split.android.client.service.synchronizer.attributes.AttributesSynchronizer;
import io.split.android.client.service.synchronizer.attributes.AttributesSynchronizerRegistry;
import io.split.android.client.service.synchronizer.attributes.AttributesSynchronizerRegistryImpl;
import io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizer;
import io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizerRegistry;
import io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizerRegistryImpl;
import io.split.android.client.shared.UserConsent;
import io.split.android.client.storage.common.StoragePusher;
import io.split.android.client.telemetry.model.EventsDataRecordsEnum;
import io.split.android.client.telemetry.model.streaming.SyncModeUpdateStreamingEvent;
import io.split.android.client.telemetry.storage.TelemetryRuntimeProducer;
import io.split.android.client.utils.logger.Logger;

/* loaded from: classes6.dex */
public class SynchronizerImpl implements Synchronizer, SplitTaskExecutionListener, MySegmentsSynchronizerRegistry, AttributesSynchronizerRegistry {
    private final AttributesSynchronizerRegistryImpl mAttributesSynchronizerRegistry;
    private String mEventsRecorderTaskId;
    private final RetryBackoffCounterTimer mEventsRecorderUpdateRetryTimer;
    private final StoragePusher<Event> mEventsStorage;
    private RecorderSyncHelper<Event> mEventsSyncHelper;
    private final FeatureFlagsSynchronizer mFeatureFlagsSynchronizer;
    private final ImpressionManager mImpressionManager;
    private final MySegmentsSynchronizerRegistryImpl mMySegmentsSynchronizerRegistry;
    private final SplitTaskExecutor mSingleThreadTaskExecutor;
    private final SplitClientConfig mSplitClientConfig;
    private final SplitTaskFactory mSplitTaskFactory;
    private final SplitTaskExecutor mTaskExecutor;
    private final TelemetryRuntimeProducer mTelemetryRuntimeProducer;

    public SynchronizerImpl(SplitClientConfig splitClientConfig, SplitTaskExecutor splitTaskExecutor, SplitTaskExecutor splitTaskExecutor2, SplitTaskFactory splitTaskFactory, WorkManagerWrapper workManagerWrapper, RetryBackoffCounterTimerFactory retryBackoffCounterTimerFactory, TelemetryRuntimeProducer telemetryRuntimeProducer, AttributesSynchronizerRegistryImpl attributesSynchronizerRegistryImpl, MySegmentsSynchronizerRegistryImpl mySegmentsSynchronizerRegistryImpl, ImpressionManager impressionManager, StoragePusher<Event> storagePusher, ISplitEventsManager iSplitEventsManager, PushManagerEventBroadcaster pushManagerEventBroadcaster) {
        this(splitClientConfig, splitTaskExecutor, splitTaskExecutor2, splitTaskFactory, workManagerWrapper, retryBackoffCounterTimerFactory, telemetryRuntimeProducer, attributesSynchronizerRegistryImpl, mySegmentsSynchronizerRegistryImpl, impressionManager, new FeatureFlagsSynchronizerImpl(splitClientConfig, splitTaskExecutor, splitTaskExecutor2, splitTaskFactory, iSplitEventsManager, retryBackoffCounterTimerFactory, pushManagerEventBroadcaster), storagePusher);
    }

    public SynchronizerImpl(SplitClientConfig splitClientConfig, SplitTaskExecutor splitTaskExecutor, SplitTaskExecutor splitTaskExecutor2, SplitTaskFactory splitTaskFactory, WorkManagerWrapper workManagerWrapper, RetryBackoffCounterTimerFactory retryBackoffCounterTimerFactory, TelemetryRuntimeProducer telemetryRuntimeProducer, AttributesSynchronizerRegistryImpl attributesSynchronizerRegistryImpl, MySegmentsSynchronizerRegistryImpl mySegmentsSynchronizerRegistryImpl, ImpressionManager impressionManager, FeatureFlagsSynchronizer featureFlagsSynchronizer, StoragePusher<Event> storagePusher) {
        this.mTaskExecutor = (SplitTaskExecutor) Preconditions.checkNotNull(splitTaskExecutor);
        SplitTaskExecutor splitTaskExecutor3 = (SplitTaskExecutor) Preconditions.checkNotNull(splitTaskExecutor2);
        this.mSingleThreadTaskExecutor = splitTaskExecutor3;
        this.mEventsStorage = (StoragePusher) Preconditions.checkNotNull(storagePusher);
        SplitClientConfig splitClientConfig2 = (SplitClientConfig) Preconditions.checkNotNull(splitClientConfig);
        this.mSplitClientConfig = splitClientConfig2;
        this.mSplitTaskFactory = (SplitTaskFactory) Preconditions.checkNotNull(splitTaskFactory);
        this.mFeatureFlagsSynchronizer = (FeatureFlagsSynchronizer) Preconditions.checkNotNull(featureFlagsSynchronizer);
        this.mAttributesSynchronizerRegistry = attributesSynchronizerRegistryImpl;
        this.mEventsRecorderUpdateRetryTimer = retryBackoffCounterTimerFactory.createWithFixedInterval(splitTaskExecutor3, 1, 3);
        this.mTelemetryRuntimeProducer = (TelemetryRuntimeProducer) Preconditions.checkNotNull(telemetryRuntimeProducer);
        this.mMySegmentsSynchronizerRegistry = (MySegmentsSynchronizerRegistryImpl) Preconditions.checkNotNull(mySegmentsSynchronizerRegistryImpl);
        this.mImpressionManager = (ImpressionManager) Preconditions.checkNotNull(impressionManager);
        setupListeners();
        if (splitClientConfig2.synchronizeInBackground()) {
            workManagerWrapper.setFetcherExecutionListener(this);
            workManagerWrapper.scheduleWork();
            return;
        }
        workManagerWrapper.removeWork();
    }

    @Override // io.split.android.client.service.synchronizer.Synchronizer
    public void loadSplitsFromCache() {
        this.mFeatureFlagsSynchronizer.loadFromCache();
    }

    @Override // io.split.android.client.service.synchronizer.Synchronizer
    public void loadMySegmentsFromCache() {
        this.mMySegmentsSynchronizerRegistry.loadMySegmentsFromCache();
    }

    @Override // io.split.android.client.service.synchronizer.Synchronizer
    public void loadAttributesFromCache() {
        this.mAttributesSynchronizerRegistry.loadAttributesFromCache();
    }

    @Override // io.split.android.client.service.synchronizer.Synchronizer
    public void loadAndSynchronizeSplits() {
        this.mFeatureFlagsSynchronizer.loadAndSynchronize();
    }

    @Override // io.split.android.client.service.synchronizer.Synchronizer
    public void synchronizeSplits(long j) {
        this.mFeatureFlagsSynchronizer.synchronize(j);
    }

    @Override // io.split.android.client.service.synchronizer.Synchronizer
    public void synchronizeSplits() {
        this.mFeatureFlagsSynchronizer.synchronize();
    }

    @Override // io.split.android.client.service.synchronizer.Synchronizer
    public void synchronizeMySegments() {
        this.mMySegmentsSynchronizerRegistry.synchronizeMySegments();
    }

    @Override // io.split.android.client.service.synchronizer.Synchronizer
    public void forceMySegmentsSync() {
        this.mMySegmentsSynchronizerRegistry.forceMySegmentsSync();
    }

    @Override // io.split.android.client.service.synchronizer.Synchronizer
    public void startPeriodicFetching() {
        synchronized (this) {
            this.mFeatureFlagsSynchronizer.startPeriodicFetching();
            scheduleMySegmentsFetcherTask();
            this.mTelemetryRuntimeProducer.recordStreamingEvents(new SyncModeUpdateStreamingEvent(SyncModeUpdateStreamingEvent.Mode.POLLING, System.currentTimeMillis()));
            Logger.i("Periodic fetcher tasks scheduled");
        }
    }

    @Override // io.split.android.client.service.synchronizer.Synchronizer
    public void stopPeriodicFetching() {
        synchronized (this) {
            this.mFeatureFlagsSynchronizer.stopPeriodicFetching();
            this.mMySegmentsSynchronizerRegistry.stopPeriodicFetching();
        }
    }

    @Override // io.split.android.client.service.synchronizer.Synchronizer
    public void startPeriodicRecording() {
        scheduleEventsRecorderTask();
        this.mImpressionManager.startPeriodicRecording();
        Logger.i("Periodic recording tasks scheduled");
    }

    @Override // io.split.android.client.service.synchronizer.Synchronizer
    public void stopPeriodicRecording() {
        this.mTaskExecutor.stopTask(this.mEventsRecorderTaskId);
        this.mImpressionManager.stopPeriodicRecording();
        this.mEventsRecorderTaskId = null;
    }

    private void setupListeners() {
        this.mEventsSyncHelper = new RecorderSyncHelperImpl(SplitTaskType.EVENTS_RECORDER, this.mEventsStorage, this.mSplitClientConfig.eventsQueueSize(), ServiceConstants.MAX_EVENTS_SIZE_BYTES, this.mTaskExecutor);
    }

    @Override // io.split.android.client.lifecycle.SplitLifecycleAware
    public void pause() {
        stopPeriodicRecording();
        stopPeriodicFetching();
        this.mTaskExecutor.pause();
        this.mSingleThreadTaskExecutor.pause();
    }

    @Override // io.split.android.client.lifecycle.SplitLifecycleAware
    public void resume() {
        this.mTaskExecutor.resume();
        this.mSingleThreadTaskExecutor.resume();
        if (this.mSplitClientConfig.userConsent() == UserConsent.GRANTED) {
            startPeriodicRecording();
        }
    }

    @Override // io.split.android.client.service.synchronizer.Synchronizer
    public void destroy() {
        this.mFeatureFlagsSynchronizer.stopSynchronization();
        this.mMySegmentsSynchronizerRegistry.destroy();
        flush();
    }

    @Override // io.split.android.client.service.synchronizer.Synchronizer
    public void flush() {
        if (this.mSplitClientConfig.userConsent() == UserConsent.GRANTED) {
            this.mEventsRecorderUpdateRetryTimer.setTask(this.mSplitTaskFactory.createEventsRecorderTask());
            this.mEventsRecorderUpdateRetryTimer.start();
            this.mImpressionManager.flush();
        }
    }

    @Override // io.split.android.client.service.synchronizer.Synchronizer
    public void pushEvent(Event event) {
        if (this.mEventsSyncHelper.pushAndCheckIfFlushNeeded(event)) {
            this.mTaskExecutor.submit(this.mSplitTaskFactory.createEventsRecorderTask(), this.mEventsSyncHelper);
        }
        this.mTelemetryRuntimeProducer.recordEventStats(EventsDataRecordsEnum.EVENTS_QUEUED, 1L);
    }

    @Override // io.split.android.client.service.synchronizer.Synchronizer
    public void pushImpression(Impression impression) {
        this.mImpressionManager.pushImpression(impression);
    }

    @Override // io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizerRegistry
    public void registerMySegmentsSynchronizer(String str, MySegmentsSynchronizer mySegmentsSynchronizer) {
        this.mMySegmentsSynchronizerRegistry.registerMySegmentsSynchronizer(str, mySegmentsSynchronizer);
    }

    @Override // io.split.android.client.service.synchronizer.mysegments.MySegmentsSynchronizerRegistry
    public void unregisterMySegmentsSynchronizer(String str) {
        this.mMySegmentsSynchronizerRegistry.unregisterMySegmentsSynchronizer(str);
    }

    @Override // io.split.android.client.service.synchronizer.attributes.AttributesSynchronizerRegistry
    public void registerAttributesSynchronizer(String str, AttributesSynchronizer attributesSynchronizer) {
        this.mAttributesSynchronizerRegistry.registerAttributesSynchronizer(str, attributesSynchronizer);
    }

    @Override // io.split.android.client.service.synchronizer.attributes.AttributesSynchronizerRegistry
    public void unregisterAttributesSynchronizer(String str) {
        this.mAttributesSynchronizerRegistry.unregisterAttributesSynchronizer(str);
    }

    private void scheduleMySegmentsFetcherTask() {
        this.mMySegmentsSynchronizerRegistry.scheduleSegmentsSyncTask();
    }

    private void scheduleEventsRecorderTask() {
        this.mEventsRecorderTaskId = this.mTaskExecutor.schedule(this.mSplitTaskFactory.createEventsRecorderTask(), 0L, this.mSplitClientConfig.eventFlushInterval(), this.mEventsSyncHelper);
    }

    /* renamed from: io.split.android.client.service.synchronizer.SynchronizerImpl$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$split$android$client$service$executor$SplitTaskType;

        static {
            int[] iArr = new int[SplitTaskType.values().length];
            $SwitchMap$io$split$android$client$service$executor$SplitTaskType = iArr;
            try {
                iArr[SplitTaskType.SPLITS_SYNC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$split$android$client$service$executor$SplitTaskType[SplitTaskType.MY_SEGMENTS_SYNC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // io.split.android.client.service.executor.SplitTaskExecutionListener
    public void taskExecuted(SplitTaskExecutionInfo splitTaskExecutionInfo) {
        int i = AnonymousClass1.$SwitchMap$io$split$android$client$service$executor$SplitTaskType[splitTaskExecutionInfo.getTaskType().ordinal()];
        if (i == 1) {
            this.mFeatureFlagsSynchronizer.submitLoadingTask(null);
        } else if (i == 2) {
            Logger.d("Loading my segments updated in background");
            this.mMySegmentsSynchronizerRegistry.submitMySegmentsLoadingTask();
        }
    }
}
