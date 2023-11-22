package io.split.android.client.storage.db.attributes;

import java.util.List;

/* loaded from: classes6.dex */
public interface AttributesDao {
    void deleteAll(String str);

    List<AttributesEntity> getAll();

    AttributesEntity getByUserKey(String str);

    void update(AttributesEntity attributesEntity);

    void update(String str, String str2, String str3);
}
