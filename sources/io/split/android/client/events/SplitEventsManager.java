package io.split.android.client.events;

import com.google.common.base.Preconditions;
import io.split.android.client.SplitClientConfig;
import io.split.android.client.events.executors.SplitEventExecutor;
import io.split.android.client.events.executors.SplitEventExecutorFactory;
import io.split.android.client.events.executors.SplitEventExecutorResources;
import io.split.android.client.events.executors.SplitEventExecutorResourcesImpl;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.utils.logger.Logger;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class SplitEventsManager extends BaseEventsManager implements ISplitEventsManager, ListenableEventsManager, Runnable {
    private final SplitTaskExecutor mSplitTaskExecutor;
    private final Map<SplitEvent, List<SplitEventTask>> mSubscriptions = new ConcurrentHashMap();
    private final Map<SplitEvent, Integer> mExecutionTimes = new ConcurrentHashMap();
    private SplitEventExecutorResources mResources = new SplitEventExecutorResourcesImpl();

    public SplitEventsManager(final SplitClientConfig splitClientConfig, SplitTaskExecutor splitTaskExecutor) {
        this.mSplitTaskExecutor = splitTaskExecutor;
        registerMaxAllowedExecutionTimesPerEvent();
        new Thread(new Runnable() { // from class: io.split.android.client.events.SplitEventsManager.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (splitClientConfig.blockUntilReady() > 0) {
                        Thread.sleep(splitClientConfig.blockUntilReady());
                        SplitEventsManager.this.notifyInternalEvent(SplitInternalEvent.SDK_READY_TIMEOUT_REACHED);
                    }
                } catch (InterruptedException e) {
                    Logger.d("Waiting before to check if SDK is READY has been interrupted", e.getMessage());
                    SplitEventsManager.this.notifyInternalEvent(SplitInternalEvent.SDK_READY_TIMEOUT_REACHED);
                } catch (Throwable th) {
                    Logger.d("Waiting before to check if SDK is READY interrupted ", th.getMessage());
                    SplitEventsManager.this.notifyInternalEvent(SplitInternalEvent.SDK_READY_TIMEOUT_REACHED);
                }
            }
        }).start();
    }

    public void setExecutionResources(SplitEventExecutorResources splitEventExecutorResources) {
        this.mResources = splitEventExecutorResources;
    }

    private void registerMaxAllowedExecutionTimesPerEvent() {
        this.mExecutionTimes.put(SplitEvent.SDK_READY, 1);
        this.mExecutionTimes.put(SplitEvent.SDK_READY_TIMED_OUT, 1);
        this.mExecutionTimes.put(SplitEvent.SDK_READY_FROM_CACHE, 1);
        this.mExecutionTimes.put(SplitEvent.SDK_UPDATE, -1);
    }

    @Override // io.split.android.client.events.ListenableEventsManager
    public SplitEventExecutorResources getExecutorResources() {
        return this.mResources;
    }

    @Override // io.split.android.client.events.BaseEventsManager, io.split.android.client.events.ISplitEventsManager
    public void notifyInternalEvent(SplitInternalEvent splitInternalEvent) {
        Preconditions.checkNotNull(splitInternalEvent);
        if ((splitInternalEvent == SplitInternalEvent.SPLITS_FETCHED || splitInternalEvent == SplitInternalEvent.MY_SEGMENTS_FETCHED) && isTriggered(SplitEvent.SDK_READY)) {
            return;
        }
        try {
            this.mQueue.add(splitInternalEvent);
        } catch (IllegalStateException unused) {
            Logger.d("Internal events queue is full");
        }
    }

    @Override // io.split.android.client.events.ListenableEventsManager
    public void register(SplitEvent splitEvent, SplitEventTask splitEventTask) {
        Preconditions.checkNotNull(splitEvent);
        Preconditions.checkNotNull(splitEventTask);
        if (this.mExecutionTimes.containsKey(splitEvent) && this.mExecutionTimes.get(splitEvent).intValue() == 0) {
            executeTask(splitEvent, splitEventTask);
            return;
        }
        if (!this.mSubscriptions.containsKey(splitEvent)) {
            this.mSubscriptions.put(splitEvent, new ArrayList());
        }
        this.mSubscriptions.get(splitEvent).add(splitEventTask);
    }

    @Override // io.split.android.client.events.ListenableEventsManager
    public boolean eventAlreadyTriggered(SplitEvent splitEvent) {
        return isTriggered(splitEvent);
    }

    private boolean wasTriggered(SplitInternalEvent splitInternalEvent) {
        return this.mTriggered.contains(splitInternalEvent);
    }

    @Override // io.split.android.client.events.BaseEventsManager
    protected void triggerEventsWhenAreAvailable() {
        try {
            SplitInternalEvent take = this.mQueue.take();
            this.mTriggered.add(take);
            switch (AnonymousClass2.$SwitchMap$io$split$android$client$events$SplitInternalEvent[take.ordinal()]) {
                case 1:
                case 2:
                    if (isTriggered(SplitEvent.SDK_READY)) {
                        trigger(SplitEvent.SDK_UPDATE);
                        return;
                    } else {
                        triggerSdkReadyIfNeeded();
                        return;
                    }
                case 3:
                case 4:
                    if (isTriggered(SplitEvent.SDK_READY)) {
                        return;
                    }
                    triggerSdkReadyIfNeeded();
                    return;
                case 5:
                case 6:
                case 7:
                case 8:
                    if (wasTriggered(SplitInternalEvent.SPLITS_LOADED_FROM_STORAGE) && wasTriggered(SplitInternalEvent.MY_SEGMENTS_LOADED_FROM_STORAGE) && wasTriggered(SplitInternalEvent.ATTRIBUTES_LOADED_FROM_STORAGE) && wasTriggered(SplitInternalEvent.ENCRYPTION_MIGRATION_DONE)) {
                        trigger(SplitEvent.SDK_READY_FROM_CACHE);
                        return;
                    }
                    return;
                case 9:
                    if (isTriggered(SplitEvent.SDK_READY)) {
                        trigger(SplitEvent.SDK_UPDATE);
                        return;
                    }
                    return;
                case 10:
                    if (isTriggered(SplitEvent.SDK_READY)) {
                        return;
                    }
                    trigger(SplitEvent.SDK_READY_TIMED_OUT);
                    return;
                default:
                    return;
            }
        } catch (InterruptedException e) {
            Logger.d(e.getMessage());
        }
    }

    /* renamed from: io.split.android.client.events.SplitEventsManager$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$split$android$client$events$SplitInternalEvent;

        static {
            int[] iArr = new int[SplitInternalEvent.values().length];
            $SwitchMap$io$split$android$client$events$SplitInternalEvent = iArr;
            try {
                iArr[SplitInternalEvent.SPLITS_UPDATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$split$android$client$events$SplitInternalEvent[SplitInternalEvent.MY_SEGMENTS_UPDATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$split$android$client$events$SplitInternalEvent[SplitInternalEvent.SPLITS_FETCHED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$split$android$client$events$SplitInternalEvent[SplitInternalEvent.MY_SEGMENTS_FETCHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$split$android$client$events$SplitInternalEvent[SplitInternalEvent.SPLITS_LOADED_FROM_STORAGE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$split$android$client$events$SplitInternalEvent[SplitInternalEvent.MY_SEGMENTS_LOADED_FROM_STORAGE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$split$android$client$events$SplitInternalEvent[SplitInternalEvent.ATTRIBUTES_LOADED_FROM_STORAGE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$split$android$client$events$SplitInternalEvent[SplitInternalEvent.ENCRYPTION_MIGRATION_DONE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$split$android$client$events$SplitInternalEvent[SplitInternalEvent.SPLIT_KILLED_NOTIFICATION.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$split$android$client$events$SplitInternalEvent[SplitInternalEvent.SDK_READY_TIMEOUT_REACHED.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    private boolean isTriggered(SplitEvent splitEvent) {
        Integer num = this.mExecutionTimes.get(splitEvent);
        return num != null && num.intValue() == 0;
    }

    private void triggerSdkReadyIfNeeded() {
        if (wasTriggered(SplitInternalEvent.MY_SEGMENTS_UPDATED) || wasTriggered(SplitInternalEvent.MY_SEGMENTS_FETCHED)) {
            if ((wasTriggered(SplitInternalEvent.SPLITS_UPDATED) || wasTriggered(SplitInternalEvent.SPLITS_FETCHED)) && !isTriggered(SplitEvent.SDK_READY)) {
                trigger(SplitEvent.SDK_READY);
            }
        }
    }

    private void trigger(SplitEvent splitEvent) {
        if (this.mExecutionTimes.get(splitEvent).intValue() == 0) {
            return;
        }
        if (this.mExecutionTimes.get(splitEvent).intValue() > 0) {
            this.mExecutionTimes.put(splitEvent, Integer.valueOf(r0.get(splitEvent).intValue() - 1));
        }
        if (this.mSubscriptions.containsKey(splitEvent)) {
            Iterator<SplitEventTask> it = this.mSubscriptions.get(splitEvent).iterator();
            while (it.hasNext()) {
                executeTask(splitEvent, it.next());
            }
        }
    }

    private void executeTask(SplitEvent splitEvent, SplitEventTask splitEventTask) {
        SplitEventExecutor factory;
        if (splitEventTask == null || (factory = SplitEventExecutorFactory.factory(this.mSplitTaskExecutor, splitEvent, splitEventTask, this.mResources)) == null) {
            return;
        }
        factory.execute();
    }
}
