package io.split.android.client.storage.events;

import com.google.common.base.Preconditions;
import io.split.android.client.dtos.Event;
import io.split.android.client.storage.common.Storage;
import io.split.android.client.storage.common.StoragePusher;
import io.split.android.client.utils.logger.Logger;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes6.dex */
public class EventsStorage implements Storage<Event>, StoragePusher<Event> {
    private final AbstractQueue<Event> mEvents = new ConcurrentLinkedQueue();
    private final AtomicBoolean mIsPersistenceEnabled;
    private final PersistentEventsStorage mPersistentStorage;

    public EventsStorage(PersistentEventsStorage persistentEventsStorage, boolean z) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        this.mIsPersistenceEnabled = atomicBoolean;
        this.mPersistentStorage = (PersistentEventsStorage) Preconditions.checkNotNull(persistentEventsStorage);
        atomicBoolean.set(z);
    }

    @Override // io.split.android.client.storage.common.Storage
    public void enablePersistence(boolean z) {
        this.mIsPersistenceEnabled.set(z);
        if (z) {
            Logger.v("Persisting in memory events");
            ArrayList arrayList = new ArrayList(this.mEvents);
            this.mEvents.removeAll(arrayList);
            this.mPersistentStorage.pushMany(arrayList);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Persistence for events has been ");
        sb.append(z ? "enabled" : "disabled");
        Logger.d(sb.toString());
    }

    @Override // io.split.android.client.storage.common.Storage, io.split.android.client.storage.common.StoragePusher
    public void push(Event event) {
        if (event == null) {
            return;
        }
        if (this.mIsPersistenceEnabled.get()) {
            Logger.v("Pushing events to persistent storage");
            this.mPersistentStorage.push(event);
            return;
        }
        Logger.v("Pushing events to in memory storage");
        this.mEvents.add(event);
    }

    @Override // io.split.android.client.storage.common.Storage
    public void clearInMemory() {
        this.mEvents.clear();
    }
}
