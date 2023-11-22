package io.split.android.client.storage.db;

import java.util.List;

/* loaded from: classes6.dex */
public interface EventDao {
    void delete(List<Long> list);

    int deleteByStatus(int i, long j, int i2);

    void deleteOutdated(long j);

    List<EventEntity> getAll();

    List<EventEntity> getBy(long j, int i, int i2);

    void insert(EventEntity eventEntity);

    void insert(List<EventEntity> list);

    void updateStatus(List<Long> list, int i);
}
