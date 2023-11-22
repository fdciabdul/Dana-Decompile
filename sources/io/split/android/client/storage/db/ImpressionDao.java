package io.split.android.client.storage.db;

import java.util.List;

/* loaded from: classes6.dex */
public interface ImpressionDao {
    void delete(List<Long> list);

    int deleteByStatus(int i, long j, int i2);

    void deleteOutdated(long j);

    List<ImpressionEntity> getAll();

    List<ImpressionEntity> getBy(long j, int i, int i2);

    void insert(ImpressionEntity impressionEntity);

    void insert(List<ImpressionEntity> list);

    void updateStatus(List<Long> list, int i);
}
