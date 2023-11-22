package io.split.android.client.storage.db;

import java.util.List;

/* loaded from: classes6.dex */
public interface MySegmentDao {
    List<MySegmentEntity> getAll();

    MySegmentEntity getByUserKey(String str);

    void update(MySegmentEntity mySegmentEntity);

    void update(String str, String str2, String str3);
}
