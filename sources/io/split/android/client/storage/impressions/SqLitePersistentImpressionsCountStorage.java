package io.split.android.client.storage.impressions;

import com.google.common.base.Preconditions;
import com.google.gson.JsonParseException;
import io.split.android.client.dtos.Identifiable;
import io.split.android.client.service.impressions.ImpressionsCountPerFeature;
import io.split.android.client.storage.cipher.SplitCipher;
import io.split.android.client.storage.common.SqLitePersistentStorage;
import io.split.android.client.storage.db.ImpressionsCountDao;
import io.split.android.client.storage.db.ImpressionsCountEntity;
import io.split.android.client.storage.db.SplitRoomDatabase;
import io.split.android.client.utils.Json;
import io.split.android.client.utils.logger.Logger;
import java.util.List;

/* loaded from: classes6.dex */
public class SqLitePersistentImpressionsCountStorage extends SqLitePersistentStorage<ImpressionsCountEntity, ImpressionsCountPerFeature> implements PersistentImpressionsCountStorage {
    private final ImpressionsCountDao mDao;
    private final SplitRoomDatabase mDatabase;
    private final SplitCipher mSplitCipher;

    @Override // io.split.android.client.storage.common.StoragePusher
    public /* bridge */ /* synthetic */ void push(Object obj) {
        super.push((SqLitePersistentImpressionsCountStorage) ((Identifiable) obj));
    }

    public SqLitePersistentImpressionsCountStorage(SplitRoomDatabase splitRoomDatabase, long j, SplitCipher splitCipher) {
        super(j);
        SplitRoomDatabase splitRoomDatabase2 = (SplitRoomDatabase) Preconditions.checkNotNull(splitRoomDatabase);
        this.mDatabase = splitRoomDatabase2;
        this.mDao = splitRoomDatabase2.impressionsCountDao();
        this.mSplitCipher = (SplitCipher) Preconditions.checkNotNull(splitCipher);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.split.android.client.storage.common.SqLitePersistentStorage
    public void insert(ImpressionsCountEntity impressionsCountEntity) {
        this.mDao.insert(impressionsCountEntity);
    }

    @Override // io.split.android.client.storage.common.SqLitePersistentStorage
    public void insert(List<ImpressionsCountEntity> list) {
        this.mDao.insert(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.split.android.client.storage.common.SqLitePersistentStorage
    public ImpressionsCountEntity entityForModel(ImpressionsCountPerFeature impressionsCountPerFeature) {
        String encrypt = this.mSplitCipher.encrypt(Json.toJson(impressionsCountPerFeature));
        if (encrypt == null) {
            Logger.e("Error encrypting impression count");
            return null;
        }
        ImpressionsCountEntity impressionsCountEntity = new ImpressionsCountEntity();
        impressionsCountEntity.setBody(encrypt);
        impressionsCountEntity.setStatus(0);
        impressionsCountEntity.setCreatedAt(System.currentTimeMillis() / 1000);
        return impressionsCountEntity;
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
    public void runInTransaction(List<ImpressionsCountEntity> list, int i, long j) {
        this.mDatabase.runInTransaction(new GetAndUpdate(this.mDao, list, i, j));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.split.android.client.storage.common.SqLitePersistentStorage
    public ImpressionsCountPerFeature entityToModel(ImpressionsCountEntity impressionsCountEntity) throws JsonParseException {
        ImpressionsCountPerFeature impressionsCountPerFeature = (ImpressionsCountPerFeature) Json.fromJson(this.mSplitCipher.decrypt(impressionsCountEntity.getBody()), ImpressionsCountPerFeature.class);
        impressionsCountPerFeature.storageId = impressionsCountEntity.getId();
        return impressionsCountPerFeature;
    }

    /* loaded from: classes6.dex */
    static class GetAndUpdate extends SqLitePersistentStorage.GetAndUpdateTransaction<ImpressionsCountEntity, ImpressionsCountPerFeature> {
        final ImpressionsCountDao mDao;

        public GetAndUpdate(ImpressionsCountDao impressionsCountDao, List<ImpressionsCountEntity> list, int i, long j) {
            super(list, i, j);
            this.mDao = impressionsCountDao;
        }

        @Override // io.split.android.client.storage.common.SqLitePersistentStorage.GetAndUpdateTransaction
        public List<ImpressionsCountEntity> getBy(long j, int i, int i2) {
            return this.mDao.getBy(j, i, i2);
        }

        @Override // io.split.android.client.storage.common.SqLitePersistentStorage.GetAndUpdateTransaction
        public void updateStatus(List<Long> list, int i) {
            this.mDao.updateStatus(list, i);
        }
    }
}
