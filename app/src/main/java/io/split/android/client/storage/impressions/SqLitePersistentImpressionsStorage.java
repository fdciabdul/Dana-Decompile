package io.split.android.client.storage.impressions;

import com.google.common.base.Preconditions;
import com.google.gson.JsonParseException;
import io.split.android.client.dtos.DeprecatedKeyImpression;
import io.split.android.client.dtos.Identifiable;
import io.split.android.client.dtos.KeyImpression;
import io.split.android.client.storage.cipher.SplitCipher;
import io.split.android.client.storage.common.SqLitePersistentStorage;
import io.split.android.client.storage.db.ImpressionDao;
import io.split.android.client.storage.db.ImpressionEntity;
import io.split.android.client.storage.db.SplitRoomDatabase;
import io.split.android.client.utils.Json;
import io.split.android.client.utils.logger.Logger;
import java.util.List;

/* loaded from: classes6.dex */
public class SqLitePersistentImpressionsStorage extends SqLitePersistentStorage<ImpressionEntity, KeyImpression> implements PersistentImpressionsStorage {
    private final ImpressionDao mDao;
    private final SplitRoomDatabase mDatabase;
    private final SplitCipher mSplitCipher;

    @Override // io.split.android.client.storage.common.StoragePusher
    public /* bridge */ /* synthetic */ void push(Object obj) {
        super.push((SqLitePersistentImpressionsStorage) ((Identifiable) obj));
    }

    public SqLitePersistentImpressionsStorage(SplitRoomDatabase splitRoomDatabase, long j, SplitCipher splitCipher) {
        super(j);
        SplitRoomDatabase splitRoomDatabase2 = (SplitRoomDatabase) Preconditions.checkNotNull(splitRoomDatabase);
        this.mDatabase = splitRoomDatabase2;
        this.mDao = splitRoomDatabase2.impressionDao();
        this.mSplitCipher = (SplitCipher) Preconditions.checkNotNull(splitCipher);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.split.android.client.storage.common.SqLitePersistentStorage
    public void insert(ImpressionEntity impressionEntity) {
        this.mDao.insert(impressionEntity);
    }

    @Override // io.split.android.client.storage.common.SqLitePersistentStorage
    public void insert(List<ImpressionEntity> list) {
        this.mDao.insert(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.split.android.client.storage.common.SqLitePersistentStorage
    public ImpressionEntity entityForModel(KeyImpression keyImpression) {
        ImpressionEntity impressionEntity = new ImpressionEntity();
        try {
            String encrypt = this.mSplitCipher.encrypt(Json.toJson(keyImpression));
            String encrypt2 = this.mSplitCipher.encrypt(keyImpression.feature);
            if (encrypt2 == null || encrypt == null) {
                Logger.e("Error encrypting impression");
                return null;
            }
            impressionEntity.setStatus(0);
            impressionEntity.setBody(encrypt);
            impressionEntity.setTestName(encrypt2);
            impressionEntity.setCreatedAt(System.currentTimeMillis() / 1000);
            return impressionEntity;
        } catch (JsonParseException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Error parsing impression: ");
            sb.append(e.getMessage());
            Logger.e(sb.toString());
            return null;
        }
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
    public void runInTransaction(List<ImpressionEntity> list, int i, long j) {
        this.mDatabase.runInTransaction(new GetAndUpdate(this.mDao, list, i, j));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.split.android.client.storage.common.SqLitePersistentStorage
    public KeyImpression entityToModel(ImpressionEntity impressionEntity) throws JsonParseException {
        KeyImpression updateImpression;
        try {
            String testName = impressionEntity.getTestName();
            String body = impressionEntity.getBody();
            String decrypt = this.mSplitCipher.decrypt(testName);
            String decrypt2 = this.mSplitCipher.decrypt(body);
            if (decrypt == null || decrypt2 == null) {
                updateImpression = null;
            } else {
                updateImpression = (KeyImpression) Json.fromJson(decrypt2, KeyImpression.class);
                updateImpression.feature = decrypt;
            }
        } catch (JsonParseException unused) {
            String testName2 = impressionEntity.getTestName();
            String body2 = impressionEntity.getBody();
            String decrypt3 = this.mSplitCipher.decrypt(testName2);
            DeprecatedKeyImpression deprecatedKeyImpression = (DeprecatedKeyImpression) Json.fromJson(this.mSplitCipher.decrypt(body2), DeprecatedKeyImpression.class);
            deprecatedKeyImpression.feature = decrypt3;
            updateImpression = updateImpression(deprecatedKeyImpression);
        }
        if (updateImpression == null) {
            throw new JsonParseException("Error parsing stored impression");
        }
        updateImpression.storageId = impressionEntity.getId();
        return updateImpression;
    }

    private KeyImpression updateImpression(DeprecatedKeyImpression deprecatedKeyImpression) {
        KeyImpression keyImpression = new KeyImpression();
        keyImpression.feature = deprecatedKeyImpression.feature;
        keyImpression.bucketingKey = deprecatedKeyImpression.bucketingKey;
        keyImpression.changeNumber = deprecatedKeyImpression.changeNumber;
        keyImpression.keyName = deprecatedKeyImpression.keyName;
        keyImpression.label = deprecatedKeyImpression.label;
        keyImpression.time = deprecatedKeyImpression.time;
        keyImpression.treatment = deprecatedKeyImpression.treatment;
        return keyImpression;
    }

    /* loaded from: classes6.dex */
    static class GetAndUpdate extends SqLitePersistentStorage.GetAndUpdateTransaction<ImpressionEntity, KeyImpression> {
        final ImpressionDao mDao;

        public GetAndUpdate(ImpressionDao impressionDao, List<ImpressionEntity> list, int i, long j) {
            super(list, i, j);
            this.mDao = impressionDao;
        }

        @Override // io.split.android.client.storage.common.SqLitePersistentStorage.GetAndUpdateTransaction
        public List<ImpressionEntity> getBy(long j, int i, int i2) {
            return this.mDao.getBy(j, i, i2);
        }

        @Override // io.split.android.client.storage.common.SqLitePersistentStorage.GetAndUpdateTransaction
        public void updateStatus(List<Long> list, int i) {
            this.mDao.updateStatus(list, i);
        }
    }
}
