package io.split.android.client.storage.attributes;

import com.google.common.base.Preconditions;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import io.split.android.client.storage.cipher.SplitCipher;
import io.split.android.client.storage.db.attributes.AttributesDao;
import io.split.android.client.storage.db.attributes.AttributesEntity;
import io.split.android.client.utils.Json;
import io.split.android.client.utils.logger.Logger;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class SqLitePersistentAttributesStorage implements PersistentAttributesStorage {
    private static final Type ATTRIBUTES_MAP_TYPE = new TypeToken<Map<String, Object>>() { // from class: io.split.android.client.storage.attributes.SqLitePersistentAttributesStorage.1
    }.getType();
    private final AttributesDao mAttributesDao;
    private final SplitCipher mSplitCipher;

    public SqLitePersistentAttributesStorage(AttributesDao attributesDao, SplitCipher splitCipher) {
        this.mAttributesDao = (AttributesDao) Preconditions.checkNotNull(attributesDao);
        this.mSplitCipher = (SplitCipher) Preconditions.checkNotNull(splitCipher);
    }

    @Override // io.split.android.client.storage.attributes.PersistentAttributesStorage
    public void set(String str, Map<String, Object> map) {
        if (map == null) {
            return;
        }
        String encrypt = this.mSplitCipher.encrypt(str);
        String encrypt2 = this.mSplitCipher.encrypt(Json.toJson(map));
        if (encrypt2 != null) {
            this.mAttributesDao.update(new AttributesEntity(encrypt, encrypt2, System.currentTimeMillis() / 1000));
        } else {
            Logger.e("Error encrypting attributes");
        }
    }

    @Override // io.split.android.client.storage.attributes.PersistentAttributesStorage
    public Map<String, Object> getAll(String str) {
        return getAttributesMapFromEntity(this.mAttributesDao.getByUserKey(this.mSplitCipher.encrypt(str)));
    }

    @Override // io.split.android.client.storage.attributes.PersistentAttributesStorage
    public void clear(String str) {
        this.mAttributesDao.deleteAll(str);
    }

    private Map<String, Object> getAttributesMapFromEntity(AttributesEntity attributesEntity) {
        HashMap hashMap = new HashMap();
        if (attributesEntity != null) {
            try {
                return Json.genericValueMapFromJson(this.mSplitCipher.decrypt(attributesEntity.getAttributes()), ATTRIBUTES_MAP_TYPE);
            } catch (JsonSyntaxException e) {
                Logger.e(e);
                return hashMap;
            }
        }
        return hashMap;
    }
}
