package io.split.android.client.storage.mysegments;

import java.util.List;

/* loaded from: classes6.dex */
public interface PersistentMySegmentsStorage {
    void close();

    List<String> getSnapshot(String str);

    void set(String str, List<String> list);
}
