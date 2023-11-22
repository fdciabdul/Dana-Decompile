package io.split.android.client.storage.splits;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import io.split.android.client.dtos.Split;
import io.split.android.client.service.executor.parallel.SplitParallelTaskExecutorFactory;
import io.split.android.client.service.executor.parallel.SplitParallelTaskExecutorFactoryImpl;
import io.split.android.client.storage.cipher.SplitCipher;
import io.split.android.client.storage.db.GeneralInfoEntity;
import io.split.android.client.storage.db.SplitEntity;
import io.split.android.client.storage.db.SplitRoomDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class SqLitePersistentSplitsStorage implements PersistentSplitsStorage {
    private static final int SQL_PARAM_BIND_SIZE = 20;
    private final SplitRoomDatabase mDatabase;
    private final SplitListTransformer<SplitEntity, Split> mEntityToSplitTransformer;
    private final SplitListTransformer<Split, SplitEntity> mSplitToEntityTransformer;

    @Override // io.split.android.client.storage.splits.PersistentSplitsStorage
    public void close() {
    }

    public SqLitePersistentSplitsStorage(SplitRoomDatabase splitRoomDatabase, SplitCipher splitCipher) {
        this(splitRoomDatabase, new SplitParallelTaskExecutorFactoryImpl(), splitCipher);
    }

    public SqLitePersistentSplitsStorage(SplitRoomDatabase splitRoomDatabase, SplitListTransformer<SplitEntity, Split> splitListTransformer, SplitListTransformer<Split, SplitEntity> splitListTransformer2) {
        this.mDatabase = (SplitRoomDatabase) Preconditions.checkNotNull(splitRoomDatabase);
        this.mEntityToSplitTransformer = (SplitListTransformer) Preconditions.checkNotNull(splitListTransformer);
        this.mSplitToEntityTransformer = (SplitListTransformer) Preconditions.checkNotNull(splitListTransformer2);
    }

    private SqLitePersistentSplitsStorage(SplitRoomDatabase splitRoomDatabase, SplitParallelTaskExecutorFactory splitParallelTaskExecutorFactory, SplitCipher splitCipher) {
        this(splitRoomDatabase, new SplitEntityToSplitTransformer(splitParallelTaskExecutorFactory.createForList(Split.class), splitCipher), new SplitToSplitEntityTransformer(splitParallelTaskExecutorFactory.createForList(SplitEntity.class), splitCipher));
    }

    @Override // io.split.android.client.storage.splits.PersistentSplitsStorage
    public boolean update(final ProcessedSplitChange processedSplitChange) {
        if (processedSplitChange == null) {
            return false;
        }
        final List<String> splitNameList = splitNameList(processedSplitChange.getArchivedSplits());
        final List<SplitEntity> convertSplitListToEntities = convertSplitListToEntities(processedSplitChange.getActiveSplits());
        this.mDatabase.runInTransaction(new Runnable() { // from class: io.split.android.client.storage.splits.SqLitePersistentSplitsStorage.1
            @Override // java.lang.Runnable
            public void run() {
                SqLitePersistentSplitsStorage.this.mDatabase.generalInfoDao().update(new GeneralInfoEntity(GeneralInfoEntity.CHANGE_NUMBER_INFO, processedSplitChange.getChangeNumber()));
                SqLitePersistentSplitsStorage.this.mDatabase.splitDao().insert(convertSplitListToEntities);
                SqLitePersistentSplitsStorage.this.mDatabase.splitDao().delete(splitNameList);
                SqLitePersistentSplitsStorage.this.mDatabase.generalInfoDao().update(new GeneralInfoEntity(GeneralInfoEntity.SPLITS_UPDATE_TIMESTAMP, processedSplitChange.getUpdateTimestamp()));
            }
        });
        return true;
    }

    @Override // io.split.android.client.storage.splits.PersistentSplitsStorage
    public SplitsSnapshot getSnapshot() {
        SplitsSnapshotLoader splitsSnapshotLoader = new SplitsSnapshotLoader(this.mDatabase);
        this.mDatabase.runInTransaction(splitsSnapshotLoader);
        return new SplitsSnapshot(loadSplits(), splitsSnapshotLoader.getChangeNumber().longValue(), splitsSnapshotLoader.getUpdateTimestamp().longValue(), splitsSnapshotLoader.getSplitsFilterQueryString());
    }

    @Override // io.split.android.client.storage.splits.PersistentSplitsStorage
    public void update(Split split) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(split);
        this.mDatabase.splitDao().insert(convertSplitListToEntities(arrayList));
    }

    @Override // io.split.android.client.storage.splits.PersistentSplitsStorage
    public void updateFilterQueryString(String str) {
        this.mDatabase.generalInfoDao().update(new GeneralInfoEntity(GeneralInfoEntity.SPLITS_FILTER_QUERY_STRING, str));
    }

    @Override // io.split.android.client.storage.splits.PersistentSplitsStorage
    public void delete(List<String> list) {
        Iterator it = Lists.partition(list, 20).iterator();
        while (it.hasNext()) {
            this.mDatabase.splitDao().delete((List) it.next());
        }
    }

    @Override // io.split.android.client.storage.splits.PersistentSplitsStorage
    public void clear() {
        this.mDatabase.runInTransaction(new Runnable() { // from class: io.split.android.client.storage.splits.SqLitePersistentSplitsStorage.2
            @Override // java.lang.Runnable
            public void run() {
                SqLitePersistentSplitsStorage.this.mDatabase.generalInfoDao().update(new GeneralInfoEntity(GeneralInfoEntity.CHANGE_NUMBER_INFO, -1L));
                SqLitePersistentSplitsStorage.this.mDatabase.splitDao().deleteAll();
            }
        });
    }

    @Override // io.split.android.client.storage.splits.PersistentSplitsStorage
    public List<Split> getAll() {
        return loadSplits();
    }

    @Override // io.split.android.client.storage.splits.PersistentSplitsStorage
    public String getFilterQueryString() {
        GeneralInfoEntity byName = this.mDatabase.generalInfoDao().getByName(GeneralInfoEntity.SPLITS_FILTER_QUERY_STRING);
        if (byName != null) {
            return byName.getStringValue();
        }
        return null;
    }

    private List<Split> loadSplits() {
        return this.mEntityToSplitTransformer.transform(this.mDatabase.splitDao().getAll());
    }

    private List<SplitEntity> convertSplitListToEntities(List<Split> list) {
        return this.mSplitToEntityTransformer.transform(list);
    }

    private List<String> splitNameList(List<Split> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        Iterator<Split> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().name);
        }
        return arrayList;
    }

    /* loaded from: classes6.dex */
    static class SplitsSnapshotLoader implements Runnable {
        private SplitRoomDatabase mDatabase;
        private Long mChangeNumber = -1L;
        private Long mUpdateTimestamp = 0L;
        private String mSplitsFilterQueryString = "";

        public SplitsSnapshotLoader(SplitRoomDatabase splitRoomDatabase) {
            this.mDatabase = splitRoomDatabase;
        }

        @Override // java.lang.Runnable
        public void run() {
            GeneralInfoEntity byName = this.mDatabase.generalInfoDao().getByName(GeneralInfoEntity.SPLITS_UPDATE_TIMESTAMP);
            GeneralInfoEntity byName2 = this.mDatabase.generalInfoDao().getByName(GeneralInfoEntity.CHANGE_NUMBER_INFO);
            GeneralInfoEntity byName3 = this.mDatabase.generalInfoDao().getByName(GeneralInfoEntity.SPLITS_FILTER_QUERY_STRING);
            if (byName2 != null) {
                this.mChangeNumber = Long.valueOf(byName2.getLongValue());
            }
            if (byName != null) {
                this.mUpdateTimestamp = Long.valueOf(byName.getLongValue());
            }
            if (byName3 != null) {
                this.mSplitsFilterQueryString = byName3.getStringValue();
            }
        }

        public Long getChangeNumber() {
            return this.mChangeNumber;
        }

        public Long getUpdateTimestamp() {
            return this.mUpdateTimestamp;
        }

        public String getSplitsFilterQueryString() {
            return this.mSplitsFilterQueryString;
        }
    }
}
