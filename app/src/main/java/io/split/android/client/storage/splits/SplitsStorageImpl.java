package io.split.android.client.storage.splits;

import com.google.common.base.Preconditions;
import io.split.android.client.dtos.Split;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class SplitsStorageImpl implements SplitsStorage {
    private long mChangeNumber;
    private final PersistentSplitsStorage mPersistentStorage;
    private String mSplitsFilterQueryString;
    private long mUpdateTimestamp;
    private final Map<String, Split> mInMemorySplits = new ConcurrentHashMap();
    private final Map<String, Integer> mTrafficTypes = new ConcurrentHashMap();

    public SplitsStorageImpl(PersistentSplitsStorage persistentSplitsStorage) {
        this.mPersistentStorage = (PersistentSplitsStorage) Preconditions.checkNotNull(persistentSplitsStorage);
    }

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public void loadLocal() {
        SplitsSnapshot snapshot = this.mPersistentStorage.getSnapshot();
        List<Split> splits = snapshot.getSplits();
        this.mChangeNumber = snapshot.getChangeNumber();
        this.mUpdateTimestamp = snapshot.getUpdateTimestamp();
        this.mSplitsFilterQueryString = snapshot.getSplitsFilterQueryString();
        for (Split split : splits) {
            this.mInMemorySplits.put(split.name, split);
            increaseTrafficTypeCount(split.trafficTypeName);
        }
    }

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public Split get(String str) {
        return this.mInMemorySplits.get(str);
    }

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public Map<String, Split> getMany(List<String> list) {
        HashMap hashMap = new HashMap();
        if (list == null || list.isEmpty()) {
            hashMap.putAll(this.mInMemorySplits);
            return hashMap;
        }
        for (String str : list) {
            Split split = this.mInMemorySplits.get(str);
            if (split != null) {
                hashMap.put(str, split);
            }
        }
        return hashMap;
    }

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public Map<String, Split> getAll() {
        return getMany(null);
    }

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public void update(ProcessedSplitChange processedSplitChange) {
        if (processedSplitChange == null) {
            return;
        }
        List<Split> activeSplits = processedSplitChange.getActiveSplits();
        List<Split> archivedSplits = processedSplitChange.getArchivedSplits();
        if (activeSplits != null) {
            for (Split split : activeSplits) {
                Split split2 = this.mInMemorySplits.get(split.name);
                if (split2 != null && split2.trafficTypeName != null) {
                    decreaseTrafficTypeCount(split2.trafficTypeName);
                }
                increaseTrafficTypeCount(split.trafficTypeName);
                this.mInMemorySplits.put(split.name, split);
            }
        }
        if (archivedSplits != null) {
            for (Split split3 : archivedSplits) {
                if (this.mInMemorySplits.remove(split3.name) != null) {
                    decreaseTrafficTypeCount(split3.trafficTypeName);
                }
            }
        }
        this.mChangeNumber = processedSplitChange.getChangeNumber();
        this.mUpdateTimestamp = processedSplitChange.getUpdateTimestamp();
        this.mPersistentStorage.update(processedSplitChange);
    }

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public void updateWithoutChecks(Split split) {
        this.mInMemorySplits.put(split.name, split);
        this.mPersistentStorage.update(split);
    }

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public long getTill() {
        return this.mChangeNumber;
    }

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public long getUpdateTimestamp() {
        return this.mUpdateTimestamp;
    }

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public String getSplitsFilterQueryString() {
        return this.mSplitsFilterQueryString;
    }

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public void updateSplitsFilterQueryString(String str) {
        this.mPersistentStorage.updateFilterQueryString(str);
    }

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public void clear() {
        this.mInMemorySplits.clear();
        this.mChangeNumber = -1L;
        this.mPersistentStorage.clear();
    }

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public boolean isValidTrafficType(String str) {
        return (str == null || this.mTrafficTypes.get(str.toLowerCase()) == null) ? false : true;
    }

    private void increaseTrafficTypeCount(String str) {
        if (str == null) {
            return;
        }
        String lowerCase = str.toLowerCase();
        this.mTrafficTypes.put(lowerCase, Integer.valueOf(countForTrafficType(lowerCase) + 1));
    }

    private void decreaseTrafficTypeCount(String str) {
        if (str == null) {
            return;
        }
        String lowerCase = str.toLowerCase();
        int countForTrafficType = countForTrafficType(lowerCase);
        if (countForTrafficType > 1) {
            this.mTrafficTypes.put(lowerCase, Integer.valueOf(countForTrafficType - 1));
        } else {
            this.mTrafficTypes.remove(lowerCase);
        }
    }

    private int countForTrafficType(String str) {
        Integer num = this.mTrafficTypes.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }
}
