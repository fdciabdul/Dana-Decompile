package io.split.android.client.storage.db.attributes;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes9.dex */
public final class AttributesDao_Impl implements AttributesDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<AttributesEntity> __insertionAdapterOfAttributesEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final SharedSQLiteStatement __preparedStmtOfUpdate;

    public AttributesDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfAttributesEntity = new EntityInsertionAdapter<AttributesEntity>(roomDatabase) { // from class: io.split.android.client.storage.db.attributes.AttributesDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `attributes` (`user_key`,`attributes`,`updated_at`) VALUES (?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, AttributesEntity attributesEntity) {
                if (attributesEntity.getUserKey() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, attributesEntity.getUserKey());
                }
                if (attributesEntity.getAttributes() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, attributesEntity.getAttributes());
                }
                supportSQLiteStatement.bindLong(3, attributesEntity.getUpdatedAt());
            }
        };
        this.__preparedStmtOfUpdate = new SharedSQLiteStatement(roomDatabase) { // from class: io.split.android.client.storage.db.attributes.AttributesDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE attributes SET user_key = ?, attributes = ? WHERE user_key = ?";
            }
        };
        this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(roomDatabase) { // from class: io.split.android.client.storage.db.attributes.AttributesDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM attributes WHERE user_key = ?";
            }
        };
    }

    @Override // io.split.android.client.storage.db.attributes.AttributesDao
    public final void update(AttributesEntity attributesEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfAttributesEntity.insert((EntityInsertionAdapter<AttributesEntity>) attributesEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // io.split.android.client.storage.db.attributes.AttributesDao
    public final void update(String str, String str2, String str3) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfUpdate.acquire();
        if (str2 == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str2);
        }
        if (str3 == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str3);
        }
        if (str == null) {
            acquire.bindNull(3);
        } else {
            acquire.bindString(3, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfUpdate.release(acquire);
        }
    }

    @Override // io.split.android.client.storage.db.attributes.AttributesDao
    public final void deleteAll(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteAll.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAll.release(acquire);
        }
    }

    @Override // io.split.android.client.storage.db.attributes.AttributesDao
    public final AttributesEntity getByUserKey(String str) {
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT user_key, attributes, updated_at FROM attributes WHERE user_key = ?", 1);
        if (str == null) {
            authRequestContext.bindNull(1);
        } else {
            authRequestContext.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext, false);
        try {
            int authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "user_key");
            int authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "attributes");
            int authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "updated_at");
            AttributesEntity attributesEntity = null;
            String string = null;
            if (KClassImpl$Data$declaredNonStaticMembers$2.moveToFirst()) {
                AttributesEntity attributesEntity2 = new AttributesEntity();
                attributesEntity2.setUserKey(KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext2) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2));
                if (!KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext3)) {
                    string = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext3);
                }
                attributesEntity2.setAttributes(string);
                attributesEntity2.setUpdatedAt(KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext4));
                attributesEntity = attributesEntity2;
            }
            return attributesEntity;
        } finally {
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            authRequestContext.MyBillsEntityDataFactory();
        }
    }

    @Override // io.split.android.client.storage.db.attributes.AttributesDao
    public final List<AttributesEntity> getAll() {
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT user_key, attributes, updated_at FROM attributes", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext, false);
        try {
            int authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "user_key");
            int authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "attributes");
            int authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "updated_at");
            ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
            while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                AttributesEntity attributesEntity = new AttributesEntity();
                String str = null;
                attributesEntity.setUserKey(KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext2) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2));
                if (!KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext3)) {
                    str = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext3);
                }
                attributesEntity.setAttributes(str);
                attributesEntity.setUpdatedAt(KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext4));
                arrayList.add(attributesEntity);
            }
            return arrayList;
        } finally {
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            authRequestContext.MyBillsEntityDataFactory();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
