package io.split.android.client.storage.db.impressions.unique;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes9.dex */
public final class UniqueKeysDao_Impl implements UniqueKeysDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<UniqueKeyEntity> __insertionAdapterOfUniqueKeyEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByStatus;
    private final SharedSQLiteStatement __preparedStmtOfDeleteOutdated;

    public UniqueKeysDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfUniqueKeyEntity = new EntityInsertionAdapter<UniqueKeyEntity>(roomDatabase) { // from class: io.split.android.client.storage.db.impressions.unique.UniqueKeysDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `unique_keys` (`id`,`user_key`,`feature_list`,`created_at`,`status`) VALUES (nullif(?, 0),?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, UniqueKeyEntity uniqueKeyEntity) {
                supportSQLiteStatement.bindLong(1, uniqueKeyEntity.getId());
                if (uniqueKeyEntity.getUserKey() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, uniqueKeyEntity.getUserKey());
                }
                if (uniqueKeyEntity.getFeatureList() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, uniqueKeyEntity.getFeatureList());
                }
                supportSQLiteStatement.bindLong(4, uniqueKeyEntity.getCreatedAt());
                supportSQLiteStatement.bindLong(5, uniqueKeyEntity.getStatus());
            }
        };
        this.__preparedStmtOfDeleteOutdated = new SharedSQLiteStatement(roomDatabase) { // from class: io.split.android.client.storage.db.impressions.unique.UniqueKeysDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM unique_keys WHERE created_at < ?";
            }
        };
        this.__preparedStmtOfDeleteByStatus = new SharedSQLiteStatement(roomDatabase) { // from class: io.split.android.client.storage.db.impressions.unique.UniqueKeysDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM unique_keys WHERE status = ? AND created_at < ? AND EXISTS(SELECT 1 FROM unique_keys AS imp WHERE imp.user_key = unique_keys.user_key LIMIT ?)";
            }
        };
    }

    @Override // io.split.android.client.storage.db.impressions.unique.UniqueKeysDao
    public final long insert(UniqueKeyEntity uniqueKeyEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long insertAndReturnId = this.__insertionAdapterOfUniqueKeyEntity.insertAndReturnId(uniqueKeyEntity);
            this.__db.setTransactionSuccessful();
            return insertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // io.split.android.client.storage.db.impressions.unique.UniqueKeysDao
    public final List<Long> insert(List<UniqueKeyEntity> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            List<Long> insertAndReturnIdsList = this.__insertionAdapterOfUniqueKeyEntity.insertAndReturnIdsList(list);
            this.__db.setTransactionSuccessful();
            return insertAndReturnIdsList;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // io.split.android.client.storage.db.impressions.unique.UniqueKeysDao
    public final void deleteOutdated(long j) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteOutdated.acquire();
        acquire.bindLong(1, j);
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteOutdated.release(acquire);
        }
    }

    @Override // io.split.android.client.storage.db.impressions.unique.UniqueKeysDao
    public final int deleteByStatus(int i, long j, int i2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteByStatus.acquire();
        acquire.bindLong(1, i);
        acquire.bindLong(2, j);
        acquire.bindLong(3, i2);
        this.__db.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteByStatus.release(acquire);
        }
    }

    @Override // io.split.android.client.storage.db.impressions.unique.UniqueKeysDao
    public final List<UniqueKeyEntity> getBy(long j, int i, int i2) {
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT id, user_key, feature_list, created_at, status FROM unique_keys WHERE created_at >= ? AND status = ? ORDER BY created_at LIMIT ?", 3);
        authRequestContext.bindLong(1, j);
        authRequestContext.bindLong(2, i);
        authRequestContext.bindLong(3, i2);
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext, false);
        try {
            int authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "id");
            int authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "user_key");
            int authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "feature_list");
            int authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "created_at");
            int authRequestContext6 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "status");
            ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
            while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                UniqueKeyEntity uniqueKeyEntity = new UniqueKeyEntity();
                uniqueKeyEntity.setId(KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext2));
                String str = null;
                uniqueKeyEntity.setUserKey(KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext3) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext3));
                if (!KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext4)) {
                    str = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext4);
                }
                uniqueKeyEntity.setFeatureList(str);
                uniqueKeyEntity.setCreatedAt(KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext5));
                uniqueKeyEntity.setStatus(KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext6));
                arrayList.add(uniqueKeyEntity);
            }
            return arrayList;
        } finally {
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            authRequestContext.MyBillsEntityDataFactory();
        }
    }

    @Override // io.split.android.client.storage.db.impressions.unique.UniqueKeysDao
    public final List<UniqueKeyEntity> getAll() {
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT id, user_key, feature_list, created_at, status FROM unique_keys", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext, false);
        try {
            int authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "id");
            int authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "user_key");
            int authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "feature_list");
            int authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "created_at");
            int authRequestContext6 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "status");
            ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
            while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                UniqueKeyEntity uniqueKeyEntity = new UniqueKeyEntity();
                uniqueKeyEntity.setId(KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext2));
                String str = null;
                uniqueKeyEntity.setUserKey(KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext3) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext3));
                if (!KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext4)) {
                    str = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext4);
                }
                uniqueKeyEntity.setFeatureList(str);
                uniqueKeyEntity.setCreatedAt(KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext5));
                uniqueKeyEntity.setStatus(KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext6));
                arrayList.add(uniqueKeyEntity);
            }
            return arrayList;
        } finally {
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            authRequestContext.MyBillsEntityDataFactory();
        }
    }

    @Override // io.split.android.client.storage.db.impressions.unique.UniqueKeysDao
    public final void updateStatus(List<Long> list, int i) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder KClassImpl$Data$declaredNonStaticMembers$2 = StringUtil.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.append("UPDATE unique_keys SET status = ");
        KClassImpl$Data$declaredNonStaticMembers$2.append("?");
        KClassImpl$Data$declaredNonStaticMembers$2.append("  WHERE id IN (");
        StringUtil.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, list.size());
        KClassImpl$Data$declaredNonStaticMembers$2.append(")");
        SupportSQLiteStatement compileStatement = this.__db.compileStatement(KClassImpl$Data$declaredNonStaticMembers$2.toString());
        compileStatement.bindLong(1, i);
        int i2 = 2;
        for (Long l : list) {
            if (l == null) {
                compileStatement.bindNull(i2);
            } else {
                compileStatement.bindLong(i2, l.longValue());
            }
            i2++;
        }
        this.__db.beginTransaction();
        try {
            compileStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // io.split.android.client.storage.db.impressions.unique.UniqueKeysDao
    public final void delete(List<String> list) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder KClassImpl$Data$declaredNonStaticMembers$2 = StringUtil.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.append("DELETE FROM unique_keys WHERE user_key IN (");
        StringUtil.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, list.size());
        KClassImpl$Data$declaredNonStaticMembers$2.append(")");
        SupportSQLiteStatement compileStatement = this.__db.compileStatement(KClassImpl$Data$declaredNonStaticMembers$2.toString());
        int i = 1;
        for (String str : list) {
            if (str == null) {
                compileStatement.bindNull(i);
            } else {
                compileStatement.bindString(i, str);
            }
            i++;
        }
        this.__db.beginTransaction();
        try {
            compileStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // io.split.android.client.storage.db.impressions.unique.UniqueKeysDao
    public final void deleteById(List<Long> list) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder KClassImpl$Data$declaredNonStaticMembers$2 = StringUtil.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.append("DELETE FROM unique_keys WHERE id IN (");
        StringUtil.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, list.size());
        KClassImpl$Data$declaredNonStaticMembers$2.append(")");
        SupportSQLiteStatement compileStatement = this.__db.compileStatement(KClassImpl$Data$declaredNonStaticMembers$2.toString());
        int i = 1;
        for (Long l : list) {
            if (l == null) {
                compileStatement.bindNull(i);
            } else {
                compileStatement.bindLong(i, l.longValue());
            }
            i++;
        }
        this.__db.beginTransaction();
        try {
            compileStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
