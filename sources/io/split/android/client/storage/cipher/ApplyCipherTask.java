package io.split.android.client.storage.cipher;

import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.storage.db.EventDao;
import io.split.android.client.storage.db.EventEntity;
import io.split.android.client.storage.db.ImpressionDao;
import io.split.android.client.storage.db.ImpressionEntity;
import io.split.android.client.storage.db.ImpressionsCountDao;
import io.split.android.client.storage.db.ImpressionsCountEntity;
import io.split.android.client.storage.db.MySegmentDao;
import io.split.android.client.storage.db.MySegmentEntity;
import io.split.android.client.storage.db.SplitDao;
import io.split.android.client.storage.db.SplitEntity;
import io.split.android.client.storage.db.SplitRoomDatabase;
import io.split.android.client.storage.db.attributes.AttributesDao;
import io.split.android.client.storage.db.attributes.AttributesEntity;
import io.split.android.client.storage.db.impressions.unique.UniqueKeyEntity;
import io.split.android.client.storage.db.impressions.unique.UniqueKeysDao;
import io.split.android.client.utils.logger.Logger;

/* loaded from: classes6.dex */
public class ApplyCipherTask implements SplitTask {
    private final SplitCipher mFromCipher;
    private final SplitRoomDatabase mSplitDatabase;
    private final SplitCipher mToCipher;

    public ApplyCipherTask(SplitRoomDatabase splitRoomDatabase, SplitCipher splitCipher, SplitCipher splitCipher2) {
        this.mSplitDatabase = splitRoomDatabase;
        this.mFromCipher = splitCipher;
        this.mToCipher = splitCipher2;
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        try {
            this.mSplitDatabase.runInTransaction(new Runnable() { // from class: io.split.android.client.storage.cipher.ApplyCipherTask.1
                {
                    ApplyCipherTask.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    ApplyCipherTask applyCipherTask = ApplyCipherTask.this;
                    applyCipherTask.updateSplits(applyCipherTask.mSplitDatabase.splitDao());
                    ApplyCipherTask applyCipherTask2 = ApplyCipherTask.this;
                    applyCipherTask2.updateSegments(applyCipherTask2.mSplitDatabase.mySegmentDao());
                    ApplyCipherTask applyCipherTask3 = ApplyCipherTask.this;
                    applyCipherTask3.updateImpressions(applyCipherTask3.mSplitDatabase.impressionDao());
                    ApplyCipherTask applyCipherTask4 = ApplyCipherTask.this;
                    applyCipherTask4.updateEvents(applyCipherTask4.mSplitDatabase.eventDao());
                    ApplyCipherTask applyCipherTask5 = ApplyCipherTask.this;
                    applyCipherTask5.updateImpressionsCount(applyCipherTask5.mSplitDatabase.impressionsCountDao());
                    ApplyCipherTask applyCipherTask6 = ApplyCipherTask.this;
                    applyCipherTask6.updateUniqueKeys(applyCipherTask6.mSplitDatabase.uniqueKeysDao());
                    ApplyCipherTask applyCipherTask7 = ApplyCipherTask.this;
                    applyCipherTask7.updateAttributes(applyCipherTask7.mSplitDatabase.attributesDao());
                }
            });
            return SplitTaskExecutionInfo.success(SplitTaskType.GENERIC_TASK);
        } catch (Exception unused) {
            return SplitTaskExecutionInfo.error(SplitTaskType.GENERIC_TASK);
        }
    }

    public void updateAttributes(AttributesDao attributesDao) {
        for (AttributesEntity attributesEntity : attributesDao.getAll()) {
            String userKey = attributesEntity.getUserKey();
            String decrypt = this.mFromCipher.decrypt(userKey);
            String decrypt2 = this.mFromCipher.decrypt(attributesEntity.getAttributes());
            String encrypt = this.mToCipher.encrypt(decrypt);
            String encrypt2 = this.mToCipher.encrypt(decrypt2);
            if (encrypt != null && encrypt2 != null) {
                attributesDao.update(userKey, encrypt, encrypt2);
            } else {
                Logger.e("Error applying cipher to attributes storage");
            }
        }
    }

    public void updateUniqueKeys(UniqueKeysDao uniqueKeysDao) {
        for (UniqueKeyEntity uniqueKeyEntity : uniqueKeysDao.getAll()) {
            String decrypt = this.mFromCipher.decrypt(uniqueKeyEntity.getUserKey());
            String decrypt2 = this.mFromCipher.decrypt(uniqueKeyEntity.getFeatureList());
            String encrypt = this.mToCipher.encrypt(decrypt);
            String encrypt2 = this.mToCipher.encrypt(decrypt2);
            if (encrypt2 != null) {
                uniqueKeyEntity.setUserKey(encrypt);
                uniqueKeyEntity.setFeatureList(encrypt2);
                uniqueKeysDao.insert(uniqueKeyEntity);
            } else {
                Logger.e("Error applying cipher to unique keys storage");
            }
        }
    }

    public void updateImpressionsCount(ImpressionsCountDao impressionsCountDao) {
        for (ImpressionsCountEntity impressionsCountEntity : impressionsCountDao.getAll()) {
            String encrypt = this.mToCipher.encrypt(this.mFromCipher.decrypt(impressionsCountEntity.getBody()));
            if (encrypt != null) {
                impressionsCountEntity.setBody(encrypt);
                impressionsCountDao.insert(impressionsCountEntity);
            } else {
                Logger.e("Error applying cipher to impression count storage");
            }
        }
    }

    public void updateImpressions(ImpressionDao impressionDao) {
        for (ImpressionEntity impressionEntity : impressionDao.getAll()) {
            String decrypt = this.mFromCipher.decrypt(impressionEntity.getTestName());
            String decrypt2 = this.mFromCipher.decrypt(impressionEntity.getBody());
            String encrypt = this.mToCipher.encrypt(decrypt);
            String encrypt2 = this.mToCipher.encrypt(decrypt2);
            if (encrypt != null && encrypt2 != null) {
                impressionEntity.setTestName(encrypt);
                impressionEntity.setBody(encrypt2);
                impressionDao.insert(impressionEntity);
            } else {
                Logger.e("Error applying cipher to impression storage");
            }
        }
    }

    public void updateSegments(MySegmentDao mySegmentDao) {
        for (MySegmentEntity mySegmentEntity : mySegmentDao.getAll()) {
            String userKey = mySegmentEntity.getUserKey();
            String decrypt = this.mFromCipher.decrypt(userKey);
            String decrypt2 = this.mFromCipher.decrypt(mySegmentEntity.getSegmentList());
            String encrypt = this.mToCipher.encrypt(decrypt);
            String encrypt2 = this.mToCipher.encrypt(decrypt2);
            if (encrypt != null && encrypt2 != null) {
                mySegmentDao.update(userKey, encrypt, encrypt2);
            } else {
                Logger.e("Error applying cipher to my segment");
            }
        }
    }

    public void updateEvents(EventDao eventDao) {
        for (EventEntity eventEntity : eventDao.getAll()) {
            String encrypt = this.mToCipher.encrypt(this.mFromCipher.decrypt(eventEntity.getBody()));
            if (encrypt != null) {
                eventEntity.setBody(encrypt);
                eventDao.insert(eventEntity);
            } else {
                Logger.e("Error applying cipher to event");
            }
        }
    }

    public void updateSplits(SplitDao splitDao) {
        for (SplitEntity splitEntity : splitDao.getAll()) {
            String name = splitEntity.getName();
            String decrypt = this.mFromCipher.decrypt(name);
            String decrypt2 = this.mFromCipher.decrypt(splitEntity.getBody());
            String encrypt = this.mToCipher.encrypt(decrypt);
            String encrypt2 = this.mToCipher.encrypt(decrypt2);
            if (encrypt != null && encrypt2 != null) {
                splitDao.update(name, encrypt, encrypt2);
            } else {
                Logger.e("Error applying cipher to split storage");
            }
        }
    }
}
