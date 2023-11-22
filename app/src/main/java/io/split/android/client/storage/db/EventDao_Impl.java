package io.split.android.client.storage.db;

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
public final class EventDao_Impl implements EventDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<EventEntity> __insertionAdapterOfEventEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByStatus;
    private final SharedSQLiteStatement __preparedStmtOfDeleteOutdated;

    public EventDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfEventEntity = new EntityInsertionAdapter<EventEntity>(roomDatabase) { // from class: io.split.android.client.storage.db.EventDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `events` (`id`,`body`,`created_at`,`status`) VALUES (nullif(?, 0),?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, EventEntity eventEntity) {
                supportSQLiteStatement.bindLong(1, eventEntity.getId());
                if (eventEntity.getBody() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, eventEntity.getBody());
                }
                supportSQLiteStatement.bindLong(3, eventEntity.getCreatedAt());
                supportSQLiteStatement.bindLong(4, eventEntity.getStatus());
            }
        };
        this.__preparedStmtOfDeleteOutdated = new SharedSQLiteStatement(roomDatabase) { // from class: io.split.android.client.storage.db.EventDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM events WHERE created_at < ?";
            }
        };
        this.__preparedStmtOfDeleteByStatus = new SharedSQLiteStatement(roomDatabase) { // from class: io.split.android.client.storage.db.EventDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM events WHERE  status = ? AND created_at < ? AND EXISTS(SELECT 1 FROM events AS eve  WHERE eve.id = events.id LIMIT ?)";
            }
        };
    }

    @Override // io.split.android.client.storage.db.EventDao
    public final void insert(EventEntity eventEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfEventEntity.insert((EntityInsertionAdapter<EventEntity>) eventEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // io.split.android.client.storage.db.EventDao
    public final void insert(List<EventEntity> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfEventEntity.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // io.split.android.client.storage.db.EventDao
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

    @Override // io.split.android.client.storage.db.EventDao
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

    @Override // io.split.android.client.storage.db.EventDao
    public final List<EventEntity> getBy(long j, int i, int i2) {
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT id, body, created_at, status FROM events WHERE created_at >= ? AND status = ? ORDER BY created_at LIMIT ?", 3);
        authRequestContext.bindLong(1, j);
        authRequestContext.bindLong(2, i);
        authRequestContext.bindLong(3, i2);
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext, false);
        try {
            int authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "id");
            int authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "body");
            int authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "created_at");
            int authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "status");
            ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
            while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                EventEntity eventEntity = new EventEntity();
                eventEntity.setId(KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext2));
                eventEntity.setBody(KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext3) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext3));
                eventEntity.setCreatedAt(KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext4));
                eventEntity.setStatus(KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext5));
                arrayList.add(eventEntity);
            }
            return arrayList;
        } finally {
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            authRequestContext.MyBillsEntityDataFactory();
        }
    }

    @Override // io.split.android.client.storage.db.EventDao
    public final List<EventEntity> getAll() {
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT id, body, created_at, status FROM events", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext, false);
        try {
            int authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "id");
            int authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "body");
            int authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "created_at");
            int authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "status");
            ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
            while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                EventEntity eventEntity = new EventEntity();
                eventEntity.setId(KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext2));
                eventEntity.setBody(KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext3) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext3));
                eventEntity.setCreatedAt(KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext4));
                eventEntity.setStatus(KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext5));
                arrayList.add(eventEntity);
            }
            return arrayList;
        } finally {
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            authRequestContext.MyBillsEntityDataFactory();
        }
    }

    @Override // io.split.android.client.storage.db.EventDao
    public final void updateStatus(List<Long> list, int i) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder KClassImpl$Data$declaredNonStaticMembers$2 = StringUtil.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.append("UPDATE events SET status = ");
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

    @Override // io.split.android.client.storage.db.EventDao
    public final void delete(List<Long> list) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder KClassImpl$Data$declaredNonStaticMembers$2 = StringUtil.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.append("DELETE FROM events WHERE id IN (");
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
