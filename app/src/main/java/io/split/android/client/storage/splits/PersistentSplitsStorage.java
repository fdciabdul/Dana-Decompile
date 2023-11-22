package io.split.android.client.storage.splits;

import io.split.android.client.dtos.Split;
import java.util.List;

/* loaded from: classes6.dex */
public interface PersistentSplitsStorage {
    void clear();

    void close();

    void delete(List<String> list);

    List<Split> getAll();

    String getFilterQueryString();

    SplitsSnapshot getSnapshot();

    void update(Split split);

    boolean update(ProcessedSplitChange processedSplitChange);

    void updateFilterQueryString(String str);
}
