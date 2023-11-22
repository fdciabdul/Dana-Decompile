package io.split.android.client.storage.mysegments;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import io.split.android.client.storage.cipher.SplitCipher;
import io.split.android.client.storage.db.MySegmentEntity;
import io.split.android.client.storage.db.SplitRoomDatabase;
import io.split.android.client.utils.StringHelper;
import io.split.android.client.utils.logger.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes6.dex */
public class SqLitePersistentMySegmentsStorage implements PersistentMySegmentsStorage {
    private final SplitRoomDatabase mDatabase;
    private final SplitCipher mSplitCipher;
    private final StringHelper mStringHelper = new StringHelper();

    @Override // io.split.android.client.storage.mysegments.PersistentMySegmentsStorage
    public void close() {
    }

    public SqLitePersistentMySegmentsStorage(SplitRoomDatabase splitRoomDatabase, SplitCipher splitCipher) {
        this.mDatabase = (SplitRoomDatabase) Preconditions.checkNotNull(splitRoomDatabase);
        this.mSplitCipher = (SplitCipher) Preconditions.checkNotNull(splitCipher);
    }

    @Override // io.split.android.client.storage.mysegments.PersistentMySegmentsStorage
    public void set(String str, List<String> list) {
        if (list == null) {
            return;
        }
        String encrypt = this.mSplitCipher.encrypt(str);
        String encrypt2 = this.mSplitCipher.encrypt(this.mStringHelper.join(",", list));
        if (encrypt == null || encrypt2 == null) {
            Logger.e("Error encrypting my segments");
            return;
        }
        MySegmentEntity mySegmentEntity = new MySegmentEntity();
        mySegmentEntity.setUserKey(encrypt);
        mySegmentEntity.setSegmentList(encrypt2);
        mySegmentEntity.setUpdatedAt(System.currentTimeMillis() / 1000);
        this.mDatabase.mySegmentDao().update(mySegmentEntity);
    }

    @Override // io.split.android.client.storage.mysegments.PersistentMySegmentsStorage
    public List<String> getSnapshot(String str) {
        return getMySegmentsFromEntity(this.mDatabase.mySegmentDao().getByUserKey(this.mSplitCipher.encrypt(str)));
    }

    private List<String> getMySegmentsFromEntity(MySegmentEntity mySegmentEntity) {
        if (mySegmentEntity == null || Strings.isNullOrEmpty(mySegmentEntity.getSegmentList())) {
            return new ArrayList();
        }
        String decrypt = this.mSplitCipher.decrypt(mySegmentEntity.getSegmentList());
        if (decrypt == null) {
            return new ArrayList();
        }
        return Arrays.asList(decrypt.split(","));
    }
}
