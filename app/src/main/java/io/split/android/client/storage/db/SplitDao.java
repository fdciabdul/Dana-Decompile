package io.split.android.client.storage.db;

import java.util.List;

/* loaded from: classes6.dex */
public interface SplitDao {
    void delete(List<String> list);

    void deleteAll();

    List<SplitEntity> getAll();

    void insert(SplitEntity splitEntity);

    void insert(List<SplitEntity> list);

    void update(String str, String str2, String str3);
}
