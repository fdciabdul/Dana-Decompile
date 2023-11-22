package io.split.android.client.storage.cipher;

import com.google.common.base.Preconditions;
import io.split.android.client.storage.db.SplitRoomDatabase;
import io.split.android.client.utils.logger.Logger;

/* loaded from: classes6.dex */
public class DBCipher {
    private SplitCipher mFromCipher;
    private final boolean mMustApply;
    private SplitRoomDatabase mSplitDatabase;
    private TaskProvider mTaskProvider;
    private SplitCipher mToCipher;

    public DBCipher(String str, SplitRoomDatabase splitRoomDatabase, SplitEncryptionLevel splitEncryptionLevel, SplitEncryptionLevel splitEncryptionLevel2, SplitCipher splitCipher) {
        this(splitRoomDatabase, str, splitCipher, splitEncryptionLevel, splitEncryptionLevel2, new TaskProvider());
    }

    public DBCipher(SplitRoomDatabase splitRoomDatabase, String str, SplitCipher splitCipher, SplitEncryptionLevel splitEncryptionLevel, SplitEncryptionLevel splitEncryptionLevel2, TaskProvider taskProvider) {
        boolean z = splitEncryptionLevel != splitEncryptionLevel2;
        this.mMustApply = z;
        if (z) {
            this.mFromCipher = SplitCipherFactory.create(str, splitEncryptionLevel);
            this.mToCipher = (SplitCipher) Preconditions.checkNotNull(splitCipher);
            this.mSplitDatabase = (SplitRoomDatabase) Preconditions.checkNotNull(splitRoomDatabase);
            this.mTaskProvider = (TaskProvider) Preconditions.checkNotNull(taskProvider);
        }
    }

    public void apply() {
        if (this.mMustApply) {
            Logger.d("Migrating encryption mode");
            this.mTaskProvider.get(this.mSplitDatabase, this.mFromCipher, this.mToCipher).execute();
            Logger.d("Encryption mode migration done");
            return;
        }
        Logger.d("No need to migrate encryption mode");
    }

    /* loaded from: classes6.dex */
    static class TaskProvider {
        TaskProvider() {
        }

        public ApplyCipherTask get(SplitRoomDatabase splitRoomDatabase, SplitCipher splitCipher, SplitCipher splitCipher2) {
            return new ApplyCipherTask(splitRoomDatabase, splitCipher, splitCipher2);
        }
    }
}
