package io.split.android.client.storage.mysegments;

import java.util.List;
import java.util.Set;

/* loaded from: classes6.dex */
public interface MySegmentsStorage {
    void clear();

    Set<String> getAll();

    void loadLocal();

    void set(List<String> list);
}
