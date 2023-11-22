package io.split.android.client.storage.db;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Collections;
import java.util.List;

/* loaded from: classes9.dex */
public final class GeneralInfoDao_Impl implements GeneralInfoDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<GeneralInfoEntity> __insertionAdapterOfGeneralInfoEntity;

    public GeneralInfoDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfGeneralInfoEntity = new EntityInsertionAdapter<GeneralInfoEntity>(roomDatabase) { // from class: io.split.android.client.storage.db.GeneralInfoDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `general_info` (`name`,`stringValue`,`longValue`,`updated_at`) VALUES (?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, GeneralInfoEntity generalInfoEntity) {
                if (generalInfoEntity.getName() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, generalInfoEntity.getName());
                }
                if (generalInfoEntity.getStringValue() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, generalInfoEntity.getStringValue());
                }
                supportSQLiteStatement.bindLong(3, generalInfoEntity.getLongValue());
                supportSQLiteStatement.bindLong(4, generalInfoEntity.getUpdatedAt());
            }
        };
    }

    @Override // io.split.android.client.storage.db.GeneralInfoDao
    public final void update(GeneralInfoEntity generalInfoEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfGeneralInfoEntity.insert((EntityInsertionAdapter<GeneralInfoEntity>) generalInfoEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // io.split.android.client.storage.db.GeneralInfoDao
    public final GeneralInfoEntity getByName(String str) {
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT name, stringValue, longValue, updated_at FROM general_info WHERE name = ?", 1);
        if (str == null) {
            authRequestContext.bindNull(1);
        } else {
            authRequestContext.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext, false);
        try {
            int authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "name");
            int authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "stringValue");
            int authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "longValue");
            int authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "updated_at");
            GeneralInfoEntity generalInfoEntity = null;
            String string = null;
            if (KClassImpl$Data$declaredNonStaticMembers$2.moveToFirst()) {
                GeneralInfoEntity generalInfoEntity2 = new GeneralInfoEntity();
                generalInfoEntity2.setName(KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext2) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2));
                if (!KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext3)) {
                    string = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext3);
                }
                generalInfoEntity2.setStringValue(string);
                generalInfoEntity2.setLongValue(KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext4));
                generalInfoEntity2.setUpdatedAt(KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext5));
                generalInfoEntity = generalInfoEntity2;
            }
            return generalInfoEntity;
        } finally {
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            authRequestContext.MyBillsEntityDataFactory();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
