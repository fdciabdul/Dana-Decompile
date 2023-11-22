package io.split.android.client.events;

import com.google.common.base.Preconditions;
import io.split.android.client.api.Key;
import io.split.android.client.utils.logger.Logger;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes6.dex */
public class EventsManagerCoordinator extends BaseEventsManager implements ISplitEventsManager, EventsManagerRegistry {
    private final ConcurrentMap<Key, ISplitEventsManager> mChildren = new ConcurrentHashMap();
    private final Object mEventLock = new Object();

    @Override // io.split.android.client.events.BaseEventsManager, io.split.android.client.events.ISplitEventsManager
    public void notifyInternalEvent(SplitInternalEvent splitInternalEvent) {
        Preconditions.checkNotNull(splitInternalEvent);
        try {
            this.mQueue.add(splitInternalEvent);
        } catch (IllegalStateException unused) {
            Logger.d("Internal events queue is full");
        }
    }

    @Override // io.split.android.client.events.BaseEventsManager
    protected void triggerEventsWhenAreAvailable() {
        try {
            SplitInternalEvent take = this.mQueue.take();
            synchronized (this.mEventLock) {
                this.mTriggered.add(take);
                int i = AnonymousClass1.$SwitchMap$io$split$android$client$events$SplitInternalEvent[take.ordinal()];
                if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5) {
                    Iterator<ISplitEventsManager> it = this.mChildren.values().iterator();
                    while (it.hasNext()) {
                        it.next().notifyInternalEvent(take);
                    }
                }
            }
        } catch (InterruptedException e) {
            Logger.d(e.getMessage());
        }
    }

    /* renamed from: io.split.android.client.events.EventsManagerCoordinator$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$split$android$client$events$SplitInternalEvent;

        static {
            int[] iArr = new int[SplitInternalEvent.values().length];
            $SwitchMap$io$split$android$client$events$SplitInternalEvent = iArr;
            try {
                iArr[SplitInternalEvent.SPLITS_UPDATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$split$android$client$events$SplitInternalEvent[SplitInternalEvent.SPLITS_FETCHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$split$android$client$events$SplitInternalEvent[SplitInternalEvent.SPLITS_LOADED_FROM_STORAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$split$android$client$events$SplitInternalEvent[SplitInternalEvent.SPLIT_KILLED_NOTIFICATION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$split$android$client$events$SplitInternalEvent[SplitInternalEvent.ENCRYPTION_MIGRATION_DONE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    @Override // io.split.android.client.events.EventsManagerRegistry
    public void registerEventsManager(Key key, ISplitEventsManager iSplitEventsManager) {
        this.mChildren.put(key, iSplitEventsManager);
        propagateTriggeredEvents(iSplitEventsManager);
    }

    @Override // io.split.android.client.events.EventsManagerRegistry
    public void unregisterEventsManager(Key key) {
        this.mChildren.remove(key);
    }

    private void propagateTriggeredEvents(ISplitEventsManager iSplitEventsManager) {
        synchronized (this.mEventLock) {
            Iterator<SplitInternalEvent> it = this.mTriggered.iterator();
            while (it.hasNext()) {
                iSplitEventsManager.notifyInternalEvent(it.next());
            }
        }
    }
}
