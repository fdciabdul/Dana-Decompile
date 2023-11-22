package io.split.android.client.storage.cipher;

import com.google.common.base.Preconditions;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.storage.db.GeneralInfoDao;
import io.split.android.client.storage.db.GeneralInfoEntity;
import io.split.android.client.storage.db.SplitRoomDatabase;
import io.split.android.client.utils.logger.Logger;

/* loaded from: classes6.dex */
public class EncryptionMigrationTask implements SplitTask {
    private final String mApiKey;
    private final boolean mEncryptionEnabled;
    private final SplitRoomDatabase mSplitDatabase;
    private final SplitCipher mToCipher;

    public EncryptionMigrationTask(String str, SplitRoomDatabase splitRoomDatabase, boolean z, SplitCipher splitCipher) {
        this.mApiKey = (String) Preconditions.checkNotNull(str);
        this.mSplitDatabase = (SplitRoomDatabase) Preconditions.checkNotNull(splitRoomDatabase);
        this.mEncryptionEnabled = z;
        this.mToCipher = (SplitCipher) Preconditions.checkNotNull(splitCipher);
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        try {
            SplitEncryptionLevel fromLevel = getFromLevel(this.mSplitDatabase.generalInfoDao(), this.mEncryptionEnabled);
            SplitEncryptionLevel level = getLevel(this.mEncryptionEnabled);
            new DBCipher(this.mApiKey, this.mSplitDatabase, fromLevel, level, this.mToCipher).apply();
            updateCurrentLevel(level);
            return SplitTaskExecutionInfo.success(SplitTaskType.GENERIC_TASK);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Error while migrating encryption: ");
            sb.append(e.getMessage());
            Logger.e(sb.toString());
            return SplitTaskExecutionInfo.error(SplitTaskType.GENERIC_TASK);
        }
    }

    private void updateCurrentLevel(SplitEncryptionLevel splitEncryptionLevel) {
        this.mSplitDatabase.generalInfoDao().update(new GeneralInfoEntity(GeneralInfoEntity.DATABASE_ENCRYPTION_MODE, splitEncryptionLevel.toString()));
    }

    private static SplitEncryptionLevel getFromLevel(GeneralInfoDao generalInfoDao, boolean z) {
        GeneralInfoEntity byName = generalInfoDao.getByName(GeneralInfoEntity.DATABASE_ENCRYPTION_MODE);
        if (byName != null) {
            return SplitEncryptionLevel.fromString(byName.getStringValue());
        }
        return getLevel(z);
    }

    private static SplitEncryptionLevel getLevel(boolean z) {
        if (z) {
            return SplitEncryptionLevel.AES_128_CBC;
        }
        return SplitEncryptionLevel.NONE;
    }
}
