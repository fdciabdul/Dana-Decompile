package id.dana.data.recentcontact.repository.source.persistence.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import id.dana.data.recentcontact.repository.source.persistence.entity.UserContactEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes8.dex */
public final class UserContactDao_Impl implements UserContactDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<UserContactEntity> __insertionAdapterOfUserContactEntity;
    private final SharedSQLiteStatement __preparedStmtOfClearAll;
    private final SharedSQLiteStatement __preparedStmtOfResetAll;
    private final EntityDeletionOrUpdateAdapter<UserContactEntity> __updateAdapterOfUserContactEntity;

    public UserContactDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfUserContactEntity = new EntityInsertionAdapter<UserContactEntity>(roomDatabase) { // from class: id.dana.data.recentcontact.repository.source.persistence.dao.UserContactDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `UserContactEntity` (`uid`,`phoneNumber`,`rawPhoneNumber`,`name`,`updatedAt`,`createdAt`,`isDanaUser`,`displayPhoto`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public /* synthetic */ void bind(SupportSQLiteStatement supportSQLiteStatement, UserContactEntity userContactEntity) {
                UserContactEntity userContactEntity2 = userContactEntity;
                supportSQLiteStatement.bindLong(1, userContactEntity2.getUid());
                if (userContactEntity2.getPhoneNumber() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, userContactEntity2.getPhoneNumber());
                }
                if (userContactEntity2.getRawPhoneNumber() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, userContactEntity2.getRawPhoneNumber());
                }
                if (userContactEntity2.getName() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, userContactEntity2.getName());
                }
                if (userContactEntity2.getUpdatedAt() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindLong(5, userContactEntity2.getUpdatedAt().longValue());
                }
                if (userContactEntity2.getCreatedAt() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindLong(6, userContactEntity2.getCreatedAt().longValue());
                }
                if ((userContactEntity2.isDanaUser() == null ? null : Integer.valueOf(userContactEntity2.isDanaUser().booleanValue() ? 1 : 0)) == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindLong(7, r0.intValue());
                }
                if (userContactEntity2.getDisplayPhoto() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, userContactEntity2.getDisplayPhoto());
                }
            }
        };
        this.__updateAdapterOfUserContactEntity = new EntityDeletionOrUpdateAdapter<UserContactEntity>(roomDatabase) { // from class: id.dana.data.recentcontact.repository.source.persistence.dao.UserContactDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `UserContactEntity` SET `uid` = ?,`phoneNumber` = ?,`rawPhoneNumber` = ?,`name` = ?,`updatedAt` = ?,`createdAt` = ?,`isDanaUser` = ?,`displayPhoto` = ? WHERE `uid` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(SupportSQLiteStatement supportSQLiteStatement, UserContactEntity userContactEntity) {
                UserContactEntity userContactEntity2 = userContactEntity;
                supportSQLiteStatement.bindLong(1, userContactEntity2.getUid());
                if (userContactEntity2.getPhoneNumber() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, userContactEntity2.getPhoneNumber());
                }
                if (userContactEntity2.getRawPhoneNumber() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, userContactEntity2.getRawPhoneNumber());
                }
                if (userContactEntity2.getName() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, userContactEntity2.getName());
                }
                if (userContactEntity2.getUpdatedAt() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindLong(5, userContactEntity2.getUpdatedAt().longValue());
                }
                if (userContactEntity2.getCreatedAt() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindLong(6, userContactEntity2.getCreatedAt().longValue());
                }
                if ((userContactEntity2.isDanaUser() == null ? null : Integer.valueOf(userContactEntity2.isDanaUser().booleanValue() ? 1 : 0)) == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindLong(7, r0.intValue());
                }
                if (userContactEntity2.getDisplayPhoto() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, userContactEntity2.getDisplayPhoto());
                }
                supportSQLiteStatement.bindLong(9, userContactEntity2.getUid());
            }
        };
        this.__preparedStmtOfClearAll = new SharedSQLiteStatement(roomDatabase) { // from class: id.dana.data.recentcontact.repository.source.persistence.dao.UserContactDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM UserContactEntity";
            }
        };
        this.__preparedStmtOfResetAll = new SharedSQLiteStatement(roomDatabase) { // from class: id.dana.data.recentcontact.repository.source.persistence.dao.UserContactDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE UserContactEntity set isDanaUser = null";
            }
        };
    }

    @Override // id.dana.data.recentcontact.repository.source.persistence.dao.UserContactDao
    public final long[] addContacts(UserContactEntity... userContactEntityArr) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long[] insertAndReturnIdsArray = this.__insertionAdapterOfUserContactEntity.insertAndReturnIdsArray(userContactEntityArr);
            this.__db.setTransactionSuccessful();
            return insertAndReturnIdsArray;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // id.dana.data.recentcontact.repository.source.persistence.dao.UserContactDao
    public final int updateContacts(UserContactEntity... userContactEntityArr) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int authRequestContext = this.__updateAdapterOfUserContactEntity.getAuthRequestContext(userContactEntityArr);
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
            return authRequestContext + 0;
        } catch (Throwable th) {
            this.__db.endTransaction();
            throw th;
        }
    }

    @Override // id.dana.data.recentcontact.repository.source.persistence.dao.UserContactDao
    public final void clearAll() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfClearAll.acquire();
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfClearAll.release(acquire);
        }
    }

    @Override // id.dana.data.recentcontact.repository.source.persistence.dao.UserContactDao
    public final void resetAll() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfResetAll.acquire();
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfResetAll.release(acquire);
        }
    }

    @Override // id.dana.data.recentcontact.repository.source.persistence.dao.UserContactDao
    public final int getCountContacts() {
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT COUNT(uid) FROM UserContactEntity", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext, false);
        try {
            return KClassImpl$Data$declaredNonStaticMembers$2.moveToFirst() ? KClassImpl$Data$declaredNonStaticMembers$2.getInt(0) : 0;
        } finally {
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            authRequestContext.MyBillsEntityDataFactory();
        }
    }

    @Override // id.dana.data.recentcontact.repository.source.persistence.dao.UserContactDao
    public final List<UserContactEntity> getContacts(int i, int i2) {
        Boolean valueOf;
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT * FROM UserContactEntity ORDER BY LOWER(name), LOWER(phoneNumber) ASC LIMIT ? OFFSET ?", 2);
        authRequestContext.bindLong(1, i);
        authRequestContext.bindLong(2, i2);
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext, false);
        try {
            int authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "uid");
            int authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "phoneNumber");
            int authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "rawPhoneNumber");
            int authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "name");
            int authRequestContext6 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "updatedAt");
            int authRequestContext7 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "createdAt");
            int authRequestContext8 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "isDanaUser");
            int authRequestContext9 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "displayPhoto");
            ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
            while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                long j = KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext2);
                String string = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext3) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext3);
                String string2 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext4) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext4);
                String string3 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext5) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext5);
                Long valueOf2 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext6) ? null : Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext6));
                Long valueOf3 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext7) ? null : Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext7));
                Integer valueOf4 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext8) ? null : Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext8));
                if (valueOf4 == null) {
                    valueOf = null;
                } else {
                    valueOf = Boolean.valueOf(valueOf4.intValue() != 0);
                }
                arrayList.add(new UserContactEntity(j, string, string2, string3, valueOf2, valueOf3, valueOf, KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext9) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext9)));
            }
            return arrayList;
        } finally {
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            authRequestContext.MyBillsEntityDataFactory();
        }
    }

    @Override // id.dana.data.recentcontact.repository.source.persistence.dao.UserContactDao
    public final List<UserContactEntity> getContactsByType(int i, int i2, Integer num, int i3) {
        Boolean valueOf;
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT * FROM UserContactEntity WHERE isDanaUser IS ? and (0 <= ?) ORDER BY LOWER(name), LOWER(phoneNumber) ASC LIMIT ? OFFSET ?", 4);
        if (num == null) {
            authRequestContext.bindNull(1);
        } else {
            authRequestContext.bindLong(1, num.intValue());
        }
        authRequestContext.bindLong(2, i3);
        authRequestContext.bindLong(3, i);
        authRequestContext.bindLong(4, i2);
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext, false);
        try {
            int authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "uid");
            int authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "phoneNumber");
            int authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "rawPhoneNumber");
            int authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "name");
            int authRequestContext6 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "updatedAt");
            int authRequestContext7 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "createdAt");
            int authRequestContext8 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "isDanaUser");
            int authRequestContext9 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "displayPhoto");
            ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
            while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                long j = KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext2);
                String string = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext3) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext3);
                String string2 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext4) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext4);
                String string3 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext5) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext5);
                Long valueOf2 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext6) ? null : Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext6));
                Long valueOf3 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext7) ? null : Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext7));
                Integer valueOf4 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext8) ? null : Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext8));
                if (valueOf4 == null) {
                    valueOf = null;
                } else {
                    valueOf = Boolean.valueOf(valueOf4.intValue() != 0);
                }
                arrayList.add(new UserContactEntity(j, string, string2, string3, valueOf2, valueOf3, valueOf, KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext9) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext9)));
            }
            return arrayList;
        } finally {
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            authRequestContext.MyBillsEntityDataFactory();
        }
    }

    @Override // id.dana.data.recentcontact.repository.source.persistence.dao.UserContactDao
    public final void deleteContacts(List<Long> list) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder KClassImpl$Data$declaredNonStaticMembers$2 = StringUtil.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.append("DELETE FROM UserContactEntity WHERE uid in (");
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
