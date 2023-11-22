package io.split.android.client.storage.impressions;

import com.google.common.base.Preconditions;
import com.google.gson.JsonParseException;
import io.split.android.client.dtos.Identifiable;
import io.split.android.client.service.impressions.unique.UniqueKey;
import io.split.android.client.storage.cipher.SplitCipher;
import io.split.android.client.storage.common.SqLitePersistentStorage;
import io.split.android.client.storage.db.SplitRoomDatabase;
import io.split.android.client.storage.db.impressions.unique.UniqueKeyEntity;
import io.split.android.client.storage.db.impressions.unique.UniqueKeysDao;
import io.split.android.client.utils.Json;
import io.split.android.client.utils.logger.Logger;
import java.util.List;
import java.util.Set;

/* loaded from: classes6.dex */
public class SqlitePersistentUniqueStorage extends SqLitePersistentStorage<UniqueKeyEntity, UniqueKey> implements PersistentImpressionsUniqueStorage {
    private final UniqueKeysDao mDao;
    private final SplitRoomDatabase mDatabase;
    private final SplitCipher mSplitCipher;

    @Override // io.split.android.client.storage.common.StoragePusher
    public /* bridge */ /* synthetic */ void push(Object obj) {
        super.push((SqlitePersistentUniqueStorage) ((Identifiable) obj));
    }

    public SqlitePersistentUniqueStorage(SplitRoomDatabase splitRoomDatabase, long j, SplitCipher splitCipher) {
        super(j);
        SplitRoomDatabase splitRoomDatabase2 = (SplitRoomDatabase) Preconditions.checkNotNull(splitRoomDatabase);
        this.mDatabase = splitRoomDatabase2;
        this.mDao = splitRoomDatabase2.uniqueKeysDao();
        this.mSplitCipher = (SplitCipher) Preconditions.checkNotNull(splitCipher);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.split.android.client.storage.common.SqLitePersistentStorage
    public void insert(UniqueKeyEntity uniqueKeyEntity) {
        this.mDao.insert(uniqueKeyEntity);
    }

    @Override // io.split.android.client.storage.common.SqLitePersistentStorage
    public void insert(List<UniqueKeyEntity> list) {
        this.mDao.insert(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.split.android.client.storage.common.SqLitePersistentStorage
    public UniqueKeyEntity entityForModel(UniqueKey uniqueKey) {
        String encrypt = this.mSplitCipher.encrypt(uniqueKey.getKey());
        String encrypt2 = this.mSplitCipher.encrypt(Json.toJson(uniqueKey.getFeatures()));
        if (encrypt == null || encrypt2 == null) {
            Logger.e("Error encrypting unique key");
            return null;
        }
        return new UniqueKeyEntity(encrypt, encrypt2, System.currentTimeMillis() / 1000, 0);
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
        this.mDao.deleteById(list);
    }

    @Override // io.split.android.client.storage.common.SqLitePersistentStorage
    public void updateStatus(List<Long> list, int i) {
        this.mDao.updateStatus(list, i);
    }

    @Override // io.split.android.client.storage.common.SqLitePersistentStorage
    public void runInTransaction(List<UniqueKeyEntity> list, int i, long j) {
        this.mDatabase.runInTransaction(new GetAndUpdate(this.mDao, list, i, j));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.split.android.client.storage.common.SqLitePersistentStorage
    public UniqueKey entityToModel(UniqueKeyEntity uniqueKeyEntity) throws JsonParseException {
        UniqueKey uniqueKey = new UniqueKey(this.mSplitCipher.decrypt(uniqueKeyEntity.getUserKey()), (Set) Json.fromJson(this.mSplitCipher.decrypt(uniqueKeyEntity.getFeatureList()), Set.class));
        uniqueKey.setStorageId(uniqueKeyEntity.getId());
        return uniqueKey;
    }

    /* loaded from: classes6.dex */
    static class GetAndUpdate extends SqLitePersistentStorage.GetAndUpdateTransaction<UniqueKeyEntity, UniqueKey> {
        private final UniqueKeysDao mDao;

        public GetAndUpdate(UniqueKeysDao uniqueKeysDao, List<UniqueKeyEntity> list, int i, long j) {
            super(list, i, j);
            this.mDao = uniqueKeysDao;
        }

        @Override // io.split.android.client.storage.common.SqLitePersistentStorage.GetAndUpdateTransaction
        public List<UniqueKeyEntity> getBy(long j, int i, int i2) {
            return this.mDao.getBy(j, i, i2);
        }

        @Override // io.split.android.client.storage.common.SqLitePersistentStorage.GetAndUpdateTransaction
        public void updateStatus(List<Long> list, int i) {
            this.mDao.updateStatus(list, i);
        }
    }
}
