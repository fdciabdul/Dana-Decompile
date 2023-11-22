package io.split.android.client.storage.db;

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
public final class MySegmentDao_Impl implements MySegmentDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<MySegmentEntity> __insertionAdapterOfMySegmentEntity;
    private final SharedSQLiteStatement __preparedStmtOfUpdate;

    public MySegmentDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfMySegmentEntity = new EntityInsertionAdapter<MySegmentEntity>(roomDatabase) { // from class: io.split.android.client.storage.db.MySegmentDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `my_segments` (`user_key`,`segment_list`,`updated_at`) VALUES (?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, MySegmentEntity mySegmentEntity) {
                if (mySegmentEntity.getUserKey() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, mySegmentEntity.getUserKey());
                }
                if (mySegmentEntity.getSegmentList() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, mySegmentEntity.getSegmentList());
                }
                supportSQLiteStatement.bindLong(3, mySegmentEntity.getUpdatedAt());
            }
        };
        this.__preparedStmtOfUpdate = new SharedSQLiteStatement(roomDatabase) { // from class: io.split.android.client.storage.db.MySegmentDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE my_segments SET user_key = ?, segment_list = ? WHERE user_key = ?";
            }
        };
    }

    @Override // io.split.android.client.storage.db.MySegmentDao
    public final void update(MySegmentEntity mySegmentEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfMySegmentEntity.insert((EntityInsertionAdapter<MySegmentEntity>) mySegmentEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // io.split.android.client.storage.db.MySegmentDao
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

    @Override // io.split.android.client.storage.db.MySegmentDao
    public final MySegmentEntity getByUserKey(String str) {
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT user_key, segment_list, updated_at FROM my_segments WHERE user_key = ?", 1);
        if (str == null) {
            authRequestContext.bindNull(1);
        } else {
            authRequestContext.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext, false);
        try {
            int authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "user_key");
            int authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "segment_list");
            int authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "updated_at");
            MySegmentEntity mySegmentEntity = null;
            String string = null;
            if (KClassImpl$Data$declaredNonStaticMembers$2.moveToFirst()) {
                MySegmentEntity mySegmentEntity2 = new MySegmentEntity();
                mySegmentEntity2.setUserKey(KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext2) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2));
                if (!KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext3)) {
                    string = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext3);
                }
                mySegmentEntity2.setSegmentList(string);
                mySegmentEntity2.setUpdatedAt(KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext4));
                mySegmentEntity = mySegmentEntity2;
            }
            return mySegmentEntity;
        } finally {
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            authRequestContext.MyBillsEntityDataFactory();
        }
    }

    @Override // io.split.android.client.storage.db.MySegmentDao
    public final List<MySegmentEntity> getAll() {
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT user_key, segment_list, updated_at FROM my_segments", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext, false);
        try {
            int authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "user_key");
            int authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "segment_list");
            int authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "updated_at");
            ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
            while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                MySegmentEntity mySegmentEntity = new MySegmentEntity();
                String str = null;
                mySegmentEntity.setUserKey(KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext2) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2));
                if (!KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext3)) {
                    str = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext3);
                }
                mySegmentEntity.setSegmentList(str);
                mySegmentEntity.setUpdatedAt(KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext4));
                arrayList.add(mySegmentEntity);
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
