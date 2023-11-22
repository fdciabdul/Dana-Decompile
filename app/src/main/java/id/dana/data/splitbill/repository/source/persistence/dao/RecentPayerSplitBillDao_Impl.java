package id.dana.data.splitbill.repository.source.persistence.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import id.dana.danah5.constant.BaseKey;
import id.dana.data.splitbill.repository.source.persistence.entity.RecentPayerSplitBillEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes8.dex */
public final class RecentPayerSplitBillDao_Impl implements RecentPayerSplitBillDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<RecentPayerSplitBillEntity> __insertionAdapterOfRecentPayerSplitBillEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteOldRecentPayer;
    private final SharedSQLiteStatement __preparedStmtOfRemoveAllRecentContact;
    private final EntityDeletionOrUpdateAdapter<RecentPayerSplitBillEntity> __updateAdapterOfRecentPayerSplitBillEntity;

    public RecentPayerSplitBillDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfRecentPayerSplitBillEntity = new EntityInsertionAdapter<RecentPayerSplitBillEntity>(roomDatabase) { // from class: id.dana.data.splitbill.repository.source.persistence.dao.RecentPayerSplitBillDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR ABORT INTO `RecentPayerSplitBillEntity` (`uid`,`userId`,`userPhoneNumber`,`userNickname`,`avatar`,`lastUpdated`,`shownName`,`shownNumber`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public /* synthetic */ void bind(SupportSQLiteStatement supportSQLiteStatement, RecentPayerSplitBillEntity recentPayerSplitBillEntity) {
                RecentPayerSplitBillEntity recentPayerSplitBillEntity2 = recentPayerSplitBillEntity;
                supportSQLiteStatement.bindLong(1, recentPayerSplitBillEntity2.getUid());
                if (recentPayerSplitBillEntity2.getUserId() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, recentPayerSplitBillEntity2.getUserId());
                }
                if (recentPayerSplitBillEntity2.getUserPhoneNumber() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, recentPayerSplitBillEntity2.getUserPhoneNumber());
                }
                if (recentPayerSplitBillEntity2.getUserNickname() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, recentPayerSplitBillEntity2.getUserNickname());
                }
                if (recentPayerSplitBillEntity2.getAvatar() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, recentPayerSplitBillEntity2.getAvatar());
                }
                supportSQLiteStatement.bindLong(6, recentPayerSplitBillEntity2.getLastUpdated());
                if (recentPayerSplitBillEntity2.getShownName() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, recentPayerSplitBillEntity2.getShownName());
                }
                if (recentPayerSplitBillEntity2.getShownNumber() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, recentPayerSplitBillEntity2.getShownNumber());
                }
            }
        };
        this.__updateAdapterOfRecentPayerSplitBillEntity = new EntityDeletionOrUpdateAdapter<RecentPayerSplitBillEntity>(roomDatabase) { // from class: id.dana.data.splitbill.repository.source.persistence.dao.RecentPayerSplitBillDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `RecentPayerSplitBillEntity` SET `uid` = ?,`userId` = ?,`userPhoneNumber` = ?,`userNickname` = ?,`avatar` = ?,`lastUpdated` = ?,`shownName` = ?,`shownNumber` = ? WHERE `uid` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(SupportSQLiteStatement supportSQLiteStatement, RecentPayerSplitBillEntity recentPayerSplitBillEntity) {
                RecentPayerSplitBillEntity recentPayerSplitBillEntity2 = recentPayerSplitBillEntity;
                supportSQLiteStatement.bindLong(1, recentPayerSplitBillEntity2.getUid());
                if (recentPayerSplitBillEntity2.getUserId() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, recentPayerSplitBillEntity2.getUserId());
                }
                if (recentPayerSplitBillEntity2.getUserPhoneNumber() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, recentPayerSplitBillEntity2.getUserPhoneNumber());
                }
                if (recentPayerSplitBillEntity2.getUserNickname() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, recentPayerSplitBillEntity2.getUserNickname());
                }
                if (recentPayerSplitBillEntity2.getAvatar() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, recentPayerSplitBillEntity2.getAvatar());
                }
                supportSQLiteStatement.bindLong(6, recentPayerSplitBillEntity2.getLastUpdated());
                if (recentPayerSplitBillEntity2.getShownName() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, recentPayerSplitBillEntity2.getShownName());
                }
                if (recentPayerSplitBillEntity2.getShownNumber() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, recentPayerSplitBillEntity2.getShownNumber());
                }
                supportSQLiteStatement.bindLong(9, recentPayerSplitBillEntity2.getUid());
            }
        };
        this.__preparedStmtOfDeleteOldRecentPayer = new SharedSQLiteStatement(roomDatabase) { // from class: id.dana.data.splitbill.repository.source.persistence.dao.RecentPayerSplitBillDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM RecentPayerSplitBillEntity where uid NOT IN (SELECT uid from RecentPayerSplitBillEntity ORDER BY lastUpdated DESC LIMIT 10)";
            }
        };
        this.__preparedStmtOfRemoveAllRecentContact = new SharedSQLiteStatement(roomDatabase) { // from class: id.dana.data.splitbill.repository.source.persistence.dao.RecentPayerSplitBillDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM RecentPayerSplitBillEntity";
            }
        };
    }

    @Override // id.dana.data.splitbill.repository.source.persistence.dao.RecentPayerSplitBillDao
    public final Long saveRecentContactSplitBill(RecentPayerSplitBillEntity recentPayerSplitBillEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long insertAndReturnId = this.__insertionAdapterOfRecentPayerSplitBillEntity.insertAndReturnId(recentPayerSplitBillEntity);
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
            return Long.valueOf(insertAndReturnId);
        } catch (Throwable th) {
            this.__db.endTransaction();
            throw th;
        }
    }

    @Override // id.dana.data.splitbill.repository.source.persistence.dao.RecentPayerSplitBillDao
    public final int updateRecentContact(RecentPayerSplitBillEntity recentPayerSplitBillEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int BuiltInFictitiousFunctionClassFactory = this.__updateAdapterOfRecentPayerSplitBillEntity.BuiltInFictitiousFunctionClassFactory(recentPayerSplitBillEntity);
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
            return BuiltInFictitiousFunctionClassFactory + 0;
        } catch (Throwable th) {
            this.__db.endTransaction();
            throw th;
        }
    }

    @Override // id.dana.data.splitbill.repository.source.persistence.dao.RecentPayerSplitBillDao
    public final void deleteOldRecentPayer() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteOldRecentPayer.acquire();
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteOldRecentPayer.release(acquire);
        }
    }

    @Override // id.dana.data.splitbill.repository.source.persistence.dao.RecentPayerSplitBillDao
    public final void removeAllRecentContact() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfRemoveAllRecentContact.acquire();
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfRemoveAllRecentContact.release(acquire);
        }
    }

    @Override // id.dana.data.splitbill.repository.source.persistence.dao.RecentPayerSplitBillDao
    public final RecentPayerSplitBillEntity getRecentContactByPhoneNumber(String str) {
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT * FROM RecentPayerSplitBillEntity WHERE userPhoneNumber = ?", 1);
        if (str == null) {
            authRequestContext.bindNull(1);
        } else {
            authRequestContext.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext, false);
        try {
            int authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "uid");
            int authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "userId");
            int authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "userPhoneNumber");
            int authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "userNickname");
            int authRequestContext6 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "avatar");
            int authRequestContext7 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, BaseKey.LAST_UPDATED);
            int authRequestContext8 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "shownName");
            int authRequestContext9 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "shownNumber");
            RecentPayerSplitBillEntity recentPayerSplitBillEntity = null;
            String string = null;
            if (KClassImpl$Data$declaredNonStaticMembers$2.moveToFirst()) {
                RecentPayerSplitBillEntity recentPayerSplitBillEntity2 = new RecentPayerSplitBillEntity();
                recentPayerSplitBillEntity2.setUid(KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext2));
                recentPayerSplitBillEntity2.setUserId(KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext3) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext3));
                recentPayerSplitBillEntity2.setUserPhoneNumber(KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext4) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext4));
                recentPayerSplitBillEntity2.setUserNickname(KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext5) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext5));
                recentPayerSplitBillEntity2.setAvatar(KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext6) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext6));
                recentPayerSplitBillEntity2.setLastUpdated(KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext7));
                recentPayerSplitBillEntity2.setShownName(KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext8) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext8));
                if (!KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext9)) {
                    string = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext9);
                }
                recentPayerSplitBillEntity2.setShownNumber(string);
                recentPayerSplitBillEntity = recentPayerSplitBillEntity2;
            }
            return recentPayerSplitBillEntity;
        } finally {
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            authRequestContext.MyBillsEntityDataFactory();
        }
    }

    @Override // id.dana.data.splitbill.repository.source.persistence.dao.RecentPayerSplitBillDao
    public final RecentPayerSplitBillEntity getRecentContactByUserId(String str) {
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT * FROM RecentPayerSplitBillEntity WHERE userId = ?", 1);
        if (str == null) {
            authRequestContext.bindNull(1);
        } else {
            authRequestContext.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext, false);
        try {
            int authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "uid");
            int authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "userId");
            int authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "userPhoneNumber");
            int authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "userNickname");
            int authRequestContext6 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "avatar");
            int authRequestContext7 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, BaseKey.LAST_UPDATED);
            int authRequestContext8 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "shownName");
            int authRequestContext9 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "shownNumber");
            RecentPayerSplitBillEntity recentPayerSplitBillEntity = null;
            String string = null;
            if (KClassImpl$Data$declaredNonStaticMembers$2.moveToFirst()) {
                RecentPayerSplitBillEntity recentPayerSplitBillEntity2 = new RecentPayerSplitBillEntity();
                recentPayerSplitBillEntity2.setUid(KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext2));
                recentPayerSplitBillEntity2.setUserId(KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext3) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext3));
                recentPayerSplitBillEntity2.setUserPhoneNumber(KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext4) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext4));
                recentPayerSplitBillEntity2.setUserNickname(KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext5) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext5));
                recentPayerSplitBillEntity2.setAvatar(KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext6) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext6));
                recentPayerSplitBillEntity2.setLastUpdated(KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext7));
                recentPayerSplitBillEntity2.setShownName(KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext8) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext8));
                if (!KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext9)) {
                    string = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext9);
                }
                recentPayerSplitBillEntity2.setShownNumber(string);
                recentPayerSplitBillEntity = recentPayerSplitBillEntity2;
            }
            return recentPayerSplitBillEntity;
        } finally {
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            authRequestContext.MyBillsEntityDataFactory();
        }
    }

    @Override // id.dana.data.splitbill.repository.source.persistence.dao.RecentPayerSplitBillDao
    public final List<RecentPayerSplitBillEntity> getSomeRecentPayer(int i) {
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT * FROM RecentPayerSplitBillEntity ORDER BY lastUpdated DESC LIMIT ?", 1);
        authRequestContext.bindLong(1, i);
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext, false);
        try {
            int authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "uid");
            int authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "userId");
            int authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "userPhoneNumber");
            int authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "userNickname");
            int authRequestContext6 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "avatar");
            int authRequestContext7 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, BaseKey.LAST_UPDATED);
            int authRequestContext8 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "shownName");
            int authRequestContext9 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "shownNumber");
            ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
            while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                RecentPayerSplitBillEntity recentPayerSplitBillEntity = new RecentPayerSplitBillEntity();
                recentPayerSplitBillEntity.setUid(KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext2));
                recentPayerSplitBillEntity.setUserId(KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext3) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext3));
                recentPayerSplitBillEntity.setUserPhoneNumber(KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext4) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext4));
                recentPayerSplitBillEntity.setUserNickname(KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext5) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext5));
                recentPayerSplitBillEntity.setAvatar(KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext6) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext6));
                recentPayerSplitBillEntity.setLastUpdated(KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext7));
                recentPayerSplitBillEntity.setShownName(KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext8) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext8));
                recentPayerSplitBillEntity.setShownNumber(KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext9) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext9));
                arrayList.add(recentPayerSplitBillEntity);
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
