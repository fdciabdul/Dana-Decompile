package io.split.android.client.service.synchronizer;

import com.google.common.base.Preconditions;
import io.split.android.client.SplitClientConfig;
import io.split.android.client.dtos.Event;
import io.split.android.client.impressions.Impression;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.service.sseclient.feedbackchannel.BroadcastedEventListener;
import io.split.android.client.service.sseclient.feedbackchannel.DelayStatusEvent;
import io.split.android.client.service.sseclient.feedbackchannel.PushManagerEventBroadcaster;
import io.split.android.client.service.sseclient.feedbackchannel.PushStatusEvent;
import io.split.android.client.service.sseclient.reactor.MySegmentsUpdateWorker;
import io.split.android.client.service.sseclient.reactor.MySegmentsUpdateWorkerRegistry;
import io.split.android.client.service.sseclient.reactor.MySegmentsUpdateWorkerRegistryImpl;
import io.split.android.client.service.sseclient.reactor.SplitUpdatesWorker;
import io.split.android.client.service.sseclient.sseclient.BackoffCounterTimer;
import io.split.android.client.service.sseclient.sseclient.PushNotificationManager;
import io.split.android.client.shared.UserConsent;
import io.split.android.client.telemetry.TelemetrySynchronizer;
import io.split.android.client.utils.logger.Logger;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes6.dex */
public class SyncManagerImpl implements SyncManager, BroadcastedEventListener, MySegmentsUpdateWorkerRegistry {
    private final AtomicBoolean mIsPaused = new AtomicBoolean(false);
    private final AtomicBoolean mIsPollingEnabled = new AtomicBoolean(false);
    private final MySegmentsUpdateWorkerRegistry mMySegmentsUpdateWorkerRegistry;
    private final PushManagerEventBroadcaster mPushManagerEventBroadcaster;
    private final PushNotificationManager mPushNotificationManager;
    private final SplitClientConfig mSplitClientConfig;
    private final SplitUpdatesWorker mSplitUpdateWorker;
    private final BackoffCounterTimer mStreamingReconnectTimer;
    private final SyncGuardian mSyncGuardian;
    private final Synchronizer mSynchronizer;
    private final TelemetrySynchronizer mTelemetrySynchronizer;

    public SyncManagerImpl(SplitClientConfig splitClientConfig, Synchronizer synchronizer, PushNotificationManager pushNotificationManager, SplitUpdatesWorker splitUpdatesWorker, PushManagerEventBroadcaster pushManagerEventBroadcaster, BackoffCounterTimer backoffCounterTimer, SyncGuardian syncGuardian, TelemetrySynchronizer telemetrySynchronizer) {
        this.mSynchronizer = (Synchronizer) Preconditions.checkNotNull(synchronizer);
        this.mSplitClientConfig = (SplitClientConfig) Preconditions.checkNotNull(splitClientConfig);
        this.mTelemetrySynchronizer = (TelemetrySynchronizer) Preconditions.checkNotNull(telemetrySynchronizer);
        if (isSyncEnabled()) {
            this.mPushNotificationManager = pushNotificationManager;
            this.mSplitUpdateWorker = splitUpdatesWorker;
            this.mPushManagerEventBroadcaster = pushManagerEventBroadcaster;
            this.mStreamingReconnectTimer = backoffCounterTimer;
            this.mMySegmentsUpdateWorkerRegistry = new MySegmentsUpdateWorkerRegistryImpl();
            this.mSyncGuardian = syncGuardian;
            return;
        }
        this.mPushNotificationManager = null;
        this.mSplitUpdateWorker = null;
        this.mPushManagerEventBroadcaster = null;
        this.mStreamingReconnectTimer = null;
        this.mMySegmentsUpdateWorkerRegistry = null;
        this.mSyncGuardian = null;
    }

    @Override // io.split.android.client.service.synchronizer.SyncManager, io.split.android.client.service.sseclient.reactor.MySegmentsUpdateWorkerRegistry
    public void start() {
        this.mSynchronizer.loadAndSynchronizeSplits();
        this.mSynchronizer.loadMySegmentsFromCache();
        this.mSynchronizer.loadAttributesFromCache();
        this.mSynchronizer.synchronizeMySegments();
        if (this.mSplitClientConfig.userConsent() == UserConsent.GRANTED) {
            Logger.v("User consent granted. Recording started");
            this.mSynchronizer.startPeriodicRecording();
        }
        this.mTelemetrySynchronizer.synchronizeStats();
        if (isSyncEnabled()) {
            this.mIsPollingEnabled.set(!this.mSplitClientConfig.streamingEnabled());
            if (this.mSplitClientConfig.streamingEnabled()) {
                this.mPushManagerEventBroadcaster.register(this);
                this.mSplitUpdateWorker.start();
                this.mMySegmentsUpdateWorkerRegistry.start();
                this.mStreamingReconnectTimer.setTask(new SplitTask() { // from class: io.split.android.client.service.synchronizer.SyncManagerImpl.1
                    @Override // io.split.android.client.service.executor.SplitTask
                    public SplitTaskExecutionInfo execute() {
                        Logger.d("Reconnecting to streaming");
                        SyncManagerImpl.this.mPushNotificationManager.start();
                        return SplitTaskExecutionInfo.success(SplitTaskType.GENERIC_TASK);
                    }
                });
                return;
            }
            this.mSynchronizer.startPeriodicFetching();
        }
    }

    @Override // io.split.android.client.lifecycle.SplitLifecycleAware
    public void pause() {
        this.mIsPaused.set(true);
        this.mSynchronizer.pause();
        this.mTelemetrySynchronizer.flush();
        if (isSyncEnabled()) {
            if (this.mSplitClientConfig.streamingEnabled()) {
                this.mPushNotificationManager.pause();
                SyncGuardian syncGuardian = this.mSyncGuardian;
                if (syncGuardian != null) {
                    syncGuardian.initialize();
                }
            }
            if (this.mIsPollingEnabled.get()) {
                this.mSynchronizer.stopPeriodicFetching();
            }
        }
    }

    @Override // io.split.android.client.lifecycle.SplitLifecycleAware
    public void resume() {
        this.mIsPaused.set(false);
        this.mSynchronizer.resume();
        if (isSyncEnabled()) {
            if (this.mSplitClientConfig.streamingEnabled()) {
                this.mPushNotificationManager.resume();
                triggerFeatureFlagsSyncIfNeeded();
            }
            if (this.mIsPollingEnabled.get()) {
                this.mSynchronizer.startPeriodicFetching();
            }
        }
    }

    @Override // io.split.android.client.service.synchronizer.SyncManager
    public void flush() {
        this.mSynchronizer.flush();
        this.mTelemetrySynchronizer.flush();
    }

    @Override // io.split.android.client.service.synchronizer.SyncManager
    public void pushEvent(Event event) {
        this.mSynchronizer.pushEvent(event);
    }

    @Override // io.split.android.client.service.synchronizer.SyncManager
    public void pushImpression(Impression impression) {
        this.mSynchronizer.pushImpression(impression);
    }

    @Override // io.split.android.client.service.synchronizer.SyncManager, io.split.android.client.service.sseclient.reactor.MySegmentsUpdateWorkerRegistry
    public void stop() {
        if (this.mSplitClientConfig.userConsent() == UserConsent.GRANTED) {
            this.mSynchronizer.stopPeriodicRecording();
        }
        this.mSynchronizer.destroy();
        this.mTelemetrySynchronizer.destroy();
        if (isSyncEnabled()) {
            this.mPushNotificationManager.stop();
            this.mSplitUpdateWorker.stop();
            this.mMySegmentsUpdateWorkerRegistry.stop();
            this.mSynchronizer.stopPeriodicFetching();
        }
    }

    @Override // io.split.android.client.service.sseclient.feedbackchannel.BroadcastedEventListener
    public void onEvent(PushStatusEvent pushStatusEvent) {
        if (isSyncEnabled()) {
            switch (AnonymousClass2.$SwitchMap$io$split$android$client$service$sseclient$feedbackchannel$PushStatusEvent$EventType[pushStatusEvent.getMessage().ordinal()]) {
                case 1:
                    Logger.d("Push Subsystem Up event message received.");
                    this.mSynchronizer.synchronizeSplits();
                    this.mSynchronizer.synchronizeMySegments();
                    this.mSynchronizer.stopPeriodicFetching();
                    this.mStreamingReconnectTimer.cancel();
                    this.mIsPollingEnabled.set(false);
                    return;
                case 2:
                    Logger.d("Push Subsystem Down event message received.");
                    enablePolling();
                    this.mStreamingReconnectTimer.cancel();
                    return;
                case 3:
                    Logger.d("Push Subsystem recoverable error received.");
                    enablePolling();
                    if (this.mIsPaused.get()) {
                        return;
                    }
                    this.mStreamingReconnectTimer.schedule();
                    return;
                case 4:
                    Logger.d("Push Subsystem non recoverable error received.");
                    enablePolling();
                    this.mStreamingReconnectTimer.cancel();
                    this.mPushNotificationManager.stop();
                    return;
                case 5:
                    Logger.d("Push Subsystem Down event message received.");
                    enablePolling();
                    this.mStreamingReconnectTimer.cancel();
                    this.mPushNotificationManager.stop();
                    return;
                case 6:
                    Logger.d("Push Subsystem reset received.");
                    this.mPushNotificationManager.disconnect();
                    if (this.mIsPaused.get()) {
                        return;
                    }
                    this.mStreamingReconnectTimer.schedule();
                    return;
                case 7:
                    if (this.mSyncGuardian != null) {
                        Logger.v("Successful sync event received, updating last sync timestamp");
                        this.mSyncGuardian.updateLastSyncTimestamp();
                        return;
                    }
                    return;
                case 8:
                    try {
                        DelayStatusEvent delayStatusEvent = (DelayStatusEvent) pushStatusEvent;
                        if (this.mSyncGuardian != null) {
                            Logger.v("Streaming delay event received");
                            this.mSyncGuardian.setMaxSyncPeriod(delayStatusEvent.getDelay().longValue());
                            return;
                        }
                        return;
                    } catch (ClassCastException unused) {
                        Logger.w("Invalid streaming delay event received");
                        return;
                    }
                default:
                    StringBuilder sb = new StringBuilder();
                    sb.append("Invalid SSE event received: ");
                    sb.append(pushStatusEvent.getMessage());
                    Logger.e(sb.toString());
                    return;
            }
        }
    }

    /* renamed from: io.split.android.client.service.synchronizer.SyncManagerImpl$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$split$android$client$service$sseclient$feedbackchannel$PushStatusEvent$EventType;

        static {
            int[] iArr = new int[PushStatusEvent.EventType.values().length];
            $SwitchMap$io$split$android$client$service$sseclient$feedbackchannel$PushStatusEvent$EventType = iArr;
            try {
                iArr[PushStatusEvent.EventType.PUSH_SUBSYSTEM_UP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$split$android$client$service$sseclient$feedbackchannel$PushStatusEvent$EventType[PushStatusEvent.EventType.PUSH_SUBSYSTEM_DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$split$android$client$service$sseclient$feedbackchannel$PushStatusEvent$EventType[PushStatusEvent.EventType.PUSH_RETRYABLE_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$split$android$client$service$sseclient$feedbackchannel$PushStatusEvent$EventType[PushStatusEvent.EventType.PUSH_NON_RETRYABLE_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$split$android$client$service$sseclient$feedbackchannel$PushStatusEvent$EventType[PushStatusEvent.EventType.PUSH_DISABLED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$split$android$client$service$sseclient$feedbackchannel$PushStatusEvent$EventType[PushStatusEvent.EventType.PUSH_RESET.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$split$android$client$service$sseclient$feedbackchannel$PushStatusEvent$EventType[PushStatusEvent.EventType.SUCCESSFUL_SYNC.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$split$android$client$service$sseclient$feedbackchannel$PushStatusEvent$EventType[PushStatusEvent.EventType.PUSH_DELAY_RECEIVED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    @Override // io.split.android.client.service.sseclient.reactor.MySegmentsUpdateWorkerRegistry
    public void registerMySegmentsUpdateWorker(String str, MySegmentsUpdateWorker mySegmentsUpdateWorker) {
        this.mMySegmentsUpdateWorkerRegistry.registerMySegmentsUpdateWorker(str, mySegmentsUpdateWorker);
    }

    @Override // io.split.android.client.service.sseclient.reactor.MySegmentsUpdateWorkerRegistry
    public void unregisterMySegmentsUpdateWorker(String str) {
        this.mMySegmentsUpdateWorkerRegistry.unregisterMySegmentsUpdateWorker(str);
    }

    @Override // io.split.android.client.service.synchronizer.SyncManager
    public void setupUserConsent(UserConsent userConsent) {
        if (userConsent == UserConsent.GRANTED) {
            Logger.v("User consent status is granted now. Starting recorders");
            this.mSynchronizer.startPeriodicRecording();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("User consent status is ");
        sb.append(userConsent);
        sb.append(" now. Stopping recorders");
        Logger.v(sb.toString());
        this.mSynchronizer.stopPeriodicRecording();
    }

    private boolean isSyncEnabled() {
        return this.mSplitClientConfig.syncEnabled();
    }

    private void enablePolling() {
        if (isSyncEnabled() && !this.mIsPollingEnabled.get()) {
            this.mIsPollingEnabled.set(true);
            this.mSynchronizer.startPeriodicFetching();
            Logger.i("Polling enabled.");
        }
    }

    private void triggerFeatureFlagsSyncIfNeeded() {
        if (this.mPushNotificationManager.isSseClientDisconnected()) {
            if (this.mSyncGuardian.mustSync()) {
                Logger.v("Must sync, synchronizing splits");
                this.mSynchronizer.synchronizeSplits();
                return;
            }
            Logger.v("No need to sync");
            return;
        }
        Logger.v("SSE client is connected, no need to trigger sync");
    }
}
