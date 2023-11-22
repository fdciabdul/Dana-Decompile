package io.split.android.client.storage.events;

import com.google.common.base.Preconditions;
import com.google.gson.JsonParseException;
import io.split.android.client.dtos.Event;
import io.split.android.client.dtos.Identifiable;
import io.split.android.client.storage.cipher.SplitCipher;
import io.split.android.client.storage.common.SqLitePersistentStorage;
import io.split.android.client.storage.db.EventDao;
import io.split.android.client.storage.db.EventEntity;
import io.split.android.client.storage.db.SplitRoomDatabase;
import io.split.android.client.utils.Json;
import io.split.android.client.utils.logger.Logger;
import java.util.List;

/* loaded from: classes6.dex */
public class SqLitePersistentEventsStorage extends SqLitePersistentStorage<EventEntity, Event> implements PersistentEventsStorage {
    private final EventDao mDao;
    private final SplitRoomDatabase mDatabase;
    private final SplitCipher mSplitCipher;

    @Override // io.split.android.client.storage.common.StoragePusher
    public /* bridge */ /* synthetic */ void push(Object obj) {
        super.push((SqLitePersistentEventsStorage) ((Identifiable) obj));
    }

    public SqLitePersistentEventsStorage(SplitRoomDatabase splitRoomDatabase, long j, SplitCipher splitCipher) {
        super(j);
        SplitRoomDatabase splitRoomDatabase2 = (SplitRoomDatabase) Preconditions.checkNotNull(splitRoomDatabase);
        this.mDatabase = splitRoomDatabase2;
        this.mDao = splitRoomDatabase2.eventDao();
        this.mSplitCipher = (SplitCipher) Preconditions.checkNotNull(splitCipher);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.split.android.client.storage.common.SqLitePersistentStorage
    public void insert(EventEntity eventEntity) {
        this.mDao.insert(eventEntity);
    }

    @Override // io.split.android.client.storage.common.SqLitePersistentStorage
    public void insert(List<EventEntity> list) {
        this.mDao.insert(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.split.android.client.storage.common.SqLitePersistentStorage
    public EventEntity entityForModel(Event event) {
        String encrypt = this.mSplitCipher.encrypt(Json.toJson(event));
        if (encrypt == null) {
            Logger.e("Error encrypting event");
            return null;
        }
        EventEntity eventEntity = new EventEntity();
        eventEntity.setBody(encrypt);
        eventEntity.setStatus(0);
        eventEntity.setCreatedAt(System.currentTimeMillis() / 1000);
        return eventEntity;
    }

    @Override // io.split.android.client.storage.common.SqLitePersistentStorage
    public int deleteByStatus(int i, long j) {
        return this.mDao.deleteByStatus(i, j, 100);
    }

    @Override // io.split.android.client.storage.common.SqLitePersistentStorage
    public void deleteOutdated(long j) {
        this.mDao.deleteOutdated(j);
    }

    @Override // io.split.android.client.storage.common.SqLitePersistentStorage
    public void deleteById(List<Long> list) {
        this.mDao.delete(list);
    }

    @Override // io.split.android.client.storage.common.SqLitePersistentStorage
    public void updateStatus(List<Long> list, int i) {
        this.mDao.updateStatus(list, i);
    }

    @Override // io.split.android.client.storage.common.SqLitePersistentStorage
    public void runInTransaction(List<EventEntity> list, int i, long j) {
        this.mDatabase.runInTransaction(new GetAndUpdate(this.mDao, list, i, j));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.split.android.client.storage.common.SqLitePersistentStorage
    public Event entityToModel(EventEntity eventEntity) throws JsonParseException {
        Event event = (Event) Json.fromJson(this.mSplitCipher.decrypt(eventEntity.getBody()), Event.class);
        event.storageId = eventEntity.getId();
        return event;
    }

    /* loaded from: classes6.dex */
    static class GetAndUpdate extends SqLitePersistentStorage.GetAndUpdateTransaction<EventEntity, Event> {
        final EventDao mDao;

        GetAndUpdate(EventDao eventDao, List<EventEntity> list, int i, long j) {
            super(list, i, j);
            this.mDao = eventDao;
        }

        @Override // io.split.android.client.storage.common.SqLitePersistentStorage.GetAndUpdateTransaction
        public List<EventEntity> getBy(long j, int i, int i2) {
            return this.mDao.getBy(j, i, i2);
        }

        @Override // io.split.android.client.storage.common.SqLitePersistentStorage.GetAndUpdateTransaction
        public void updateStatus(List<Long> list, int i) {
            this.mDao.updateStatus(list, i);
        }
    }
}
