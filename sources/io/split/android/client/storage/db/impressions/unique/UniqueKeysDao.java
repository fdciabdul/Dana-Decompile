package io.split.android.client.storage.db.impressions.unique;

import java.util.List;

/* loaded from: classes6.dex */
public interface UniqueKeysDao {
    void delete(List<String> list);

    void deleteById(List<Long> list);

    int deleteByStatus(int i, long j, int i2);

    void deleteOutdated(long j);

    List<UniqueKeyEntity> getAll();

    List<UniqueKeyEntity> getBy(long j, int i, int i2);

    long insert(UniqueKeyEntity uniqueKeyEntity);

    List<Long> insert(List<UniqueKeyEntity> list);

    void updateStatus(List<Long> list, int i);
}
