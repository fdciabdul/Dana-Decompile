package io.split.android.client.storage.splits;

import io.split.android.client.dtos.Split;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public interface SplitsStorage {
    void clear();

    Split get(String str);

    Map<String, Split> getAll();

    Map<String, Split> getMany(List<String> list);

    String getSplitsFilterQueryString();

    long getTill();

    long getUpdateTimestamp();

    boolean isValidTrafficType(String str);

    void loadLocal();

    void update(ProcessedSplitChange processedSplitChange);

    void updateSplitsFilterQueryString(String str);

    void updateWithoutChecks(Split split);
}
