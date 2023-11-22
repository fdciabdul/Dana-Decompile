package io.split.android.client.storage.db;

import java.util.List;

/* loaded from: classes6.dex */
public interface ImpressionsCountDao {
    void delete(List<Long> list);

    int deleteByStatus(int i, long j, int i2);

    void deleteOutdated(long j);

    List<ImpressionsCountEntity> getAll();

    List<ImpressionsCountEntity> getBy(long j, int i, int i2);

    void insert(ImpressionsCountEntity impressionsCountEntity);

    void insert(List<ImpressionsCountEntity> list);

    void updateStatus(List<Long> list, int i);
}
