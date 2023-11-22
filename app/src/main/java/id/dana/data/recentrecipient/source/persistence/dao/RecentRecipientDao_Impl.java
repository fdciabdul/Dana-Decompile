package id.dana.data.recentrecipient.source.persistence.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.alibaba.griver.core.GriverParams;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.danah5.constant.BaseKey;
import id.dana.data.recentrecipient.source.persistence.entity.RecentRecipientEntity;
import id.dana.wallet_v3.constant.WalletConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes8.dex */
public final class RecentRecipientDao_Impl implements RecentRecipientDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<RecentRecipientEntity> __insertionAdapterOfRecentRecipientEntity;
    private final SharedSQLiteStatement __preparedStmtOfRemoveAll;
    private final SharedSQLiteStatement __preparedStmtOfRemoveAllRecentBank;
    private final SharedSQLiteStatement __preparedStmtOfRemoveRecentBank;
    private final SharedSQLiteStatement __preparedStmtOfRemoveRecentRecipient;

    public RecentRecipientDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfRecentRecipientEntity = new EntityInsertionAdapter<RecentRecipientEntity>(roomDatabase) { // from class: id.dana.data.recentrecipient.source.persistence.dao.RecentRecipientDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `RecentRecipientEntity` (`dataId`,`alias`,`id`,`imageUrl`,`instLocalName`,`lastUpdated`,`lastUpdateTime`,`name`,`number`,`recipientName`,`senderName`,`payMethod`,`payOption`,`cardIndexNo`,`prefix`,`transactionCount`,`isFavorite`,`type`,`participantCount`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public /* synthetic */ void bind(SupportSQLiteStatement supportSQLiteStatement, RecentRecipientEntity recentRecipientEntity) {
                RecentRecipientEntity recentRecipientEntity2 = recentRecipientEntity;
                if (recentRecipientEntity2.getDataId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, recentRecipientEntity2.getDataId());
                }
                if (recentRecipientEntity2.getAlias() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, recentRecipientEntity2.getAlias());
                }
                if (recentRecipientEntity2.getId() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, recentRecipientEntity2.getId());
                }
                if (recentRecipientEntity2.getImageUrl() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, recentRecipientEntity2.getImageUrl());
                }
                if (recentRecipientEntity2.getInstLocalName() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, recentRecipientEntity2.getInstLocalName());
                }
                supportSQLiteStatement.bindLong(6, recentRecipientEntity2.getLastUpdated());
                supportSQLiteStatement.bindLong(7, recentRecipientEntity2.getLastUpdateTime());
                if (recentRecipientEntity2.getName() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, recentRecipientEntity2.getName());
                }
                if (recentRecipientEntity2.getNumber() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, recentRecipientEntity2.getNumber());
                }
                if (recentRecipientEntity2.getRecipientName() == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, recentRecipientEntity2.getRecipientName());
                }
                if (recentRecipientEntity2.getSenderName() == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindString(11, recentRecipientEntity2.getSenderName());
                }
                if (recentRecipientEntity2.getPayMethod() == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindString(12, recentRecipientEntity2.getPayMethod());
                }
                if (recentRecipientEntity2.getPayOption() == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindString(13, recentRecipientEntity2.getPayOption());
                }
                if (recentRecipientEntity2.getCardIndexNo() == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindString(14, recentRecipientEntity2.getCardIndexNo());
                }
                if (recentRecipientEntity2.getPrefix() == null) {
                    supportSQLiteStatement.bindNull(15);
                } else {
                    supportSQLiteStatement.bindString(15, recentRecipientEntity2.getPrefix());
                }
                supportSQLiteStatement.bindLong(16, recentRecipientEntity2.getTransactionCount());
                supportSQLiteStatement.bindLong(17, recentRecipientEntity2.getIsFavorite() ? 1L : 0L);
                supportSQLiteStatement.bindLong(18, recentRecipientEntity2.getType());
                if (recentRecipientEntity2.getParticipantCount() == null) {
                    supportSQLiteStatement.bindNull(19);
                } else {
                    supportSQLiteStatement.bindLong(19, recentRecipientEntity2.getParticipantCount().intValue());
                }
            }
        };
        this.__preparedStmtOfRemoveRecentRecipient = new SharedSQLiteStatement(roomDatabase) { // from class: id.dana.data.recentrecipient.source.persistence.dao.RecentRecipientDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM RecentRecipientEntity WHERE id = ?";
            }
        };
        this.__preparedStmtOfRemoveRecentBank = new SharedSQLiteStatement(roomDatabase) { // from class: id.dana.data.recentrecipient.source.persistence.dao.RecentRecipientDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE from RecentRecipientEntity WHERE type = 1 AND cardIndexNo = ?";
            }
        };
        this.__preparedStmtOfRemoveAllRecentBank = new SharedSQLiteStatement(roomDatabase) { // from class: id.dana.data.recentrecipient.source.persistence.dao.RecentRecipientDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM RecentRecipientEntity WHERE type = 1";
            }
        };
        this.__preparedStmtOfRemoveAll = new SharedSQLiteStatement(roomDatabase) { // from class: id.dana.data.recentrecipient.source.persistence.dao.RecentRecipientDao_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM RecentRecipientEntity";
            }
        };
    }

    @Override // id.dana.data.recentrecipient.source.persistence.dao.RecentRecipientDao
    public final long insertOrUpdate(RecentRecipientEntity recentRecipientEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long insertAndReturnId = this.__insertionAdapterOfRecentRecipientEntity.insertAndReturnId(recentRecipientEntity);
            this.__db.setTransactionSuccessful();
            return insertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // id.dana.data.recentrecipient.source.persistence.dao.RecentRecipientDao
    public final Long[] insertOrUpdate(List<RecentRecipientEntity> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            Long[] insertAndReturnIdsArrayBox = this.__insertionAdapterOfRecentRecipientEntity.insertAndReturnIdsArrayBox(list);
            this.__db.setTransactionSuccessful();
            return insertAndReturnIdsArrayBox;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // id.dana.data.recentrecipient.source.persistence.dao.RecentRecipientDao
    public final int removeRecentRecipient(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfRemoveRecentRecipient.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfRemoveRecentRecipient.release(acquire);
        }
    }

    @Override // id.dana.data.recentrecipient.source.persistence.dao.RecentRecipientDao
    public final int removeRecentBank(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfRemoveRecentBank.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfRemoveRecentBank.release(acquire);
        }
    }

    @Override // id.dana.data.recentrecipient.source.persistence.dao.RecentRecipientDao
    public final int removeAllRecentBank() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfRemoveAllRecentBank.acquire();
        this.__db.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfRemoveAllRecentBank.release(acquire);
        }
    }

    @Override // id.dana.data.recentrecipient.source.persistence.dao.RecentRecipientDao
    public final void removeAll() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfRemoveAll.acquire();
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfRemoveAll.release(acquire);
        }
    }

    @Override // id.dana.data.recentrecipient.source.persistence.dao.RecentRecipientDao
    public final List<RecentRecipientEntity> getRecentRecipientList() {
        RoomSQLiteQuery roomSQLiteQuery;
        int authRequestContext;
        int authRequestContext2;
        int authRequestContext3;
        int authRequestContext4;
        int authRequestContext5;
        int authRequestContext6;
        int authRequestContext7;
        int authRequestContext8;
        int authRequestContext9;
        int authRequestContext10;
        int authRequestContext11;
        int authRequestContext12;
        int authRequestContext13;
        int authRequestContext14;
        String string;
        int i;
        int i2;
        boolean z;
        RoomSQLiteQuery authRequestContext15 = RoomSQLiteQuery.getAuthRequestContext("SELECT * FROM RecentRecipientEntity ORDER BY alias ASC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext15, false);
        try {
            authRequestContext = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "dataId");
            authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "alias");
            authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "id");
            authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, GriverParams.ShareParams.IMAGE_URL);
            authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "instLocalName");
            authRequestContext6 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, BaseKey.LAST_UPDATED);
            authRequestContext7 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "lastUpdateTime");
            authRequestContext8 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "name");
            authRequestContext9 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "number");
            authRequestContext10 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "recipientName");
            authRequestContext11 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "senderName");
            authRequestContext12 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "payMethod");
            authRequestContext13 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "payOption");
            authRequestContext14 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, WalletConstant.CARD_INDEX_NO);
            roomSQLiteQuery = authRequestContext15;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = authRequestContext15;
        }
        try {
            int authRequestContext16 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "prefix");
            int authRequestContext17 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "transactionCount");
            int authRequestContext18 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, TrackerKey.SendMoneyProperties.IS_FAVORITE);
            int authRequestContext19 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "type");
            int authRequestContext20 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "participantCount");
            int i3 = authRequestContext14;
            ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
            while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                String string2 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext);
                String string3 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext2) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2);
                String string4 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext3) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext3);
                String string5 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext4) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext4);
                String string6 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext5) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext5);
                long j = KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext6);
                long j2 = KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext7);
                String string7 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext8) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext8);
                String string8 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext9) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext9);
                String string9 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext10) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext10);
                String string10 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext11) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext11);
                String string11 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext12) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext12);
                if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext13)) {
                    i = i3;
                    string = null;
                } else {
                    string = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext13);
                    i = i3;
                }
                String string12 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(i) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(i);
                int i4 = authRequestContext16;
                int i5 = authRequestContext13;
                String string13 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(i4) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(i4);
                int i6 = authRequestContext17;
                int i7 = KClassImpl$Data$declaredNonStaticMembers$2.getInt(i6);
                int i8 = authRequestContext18;
                if (KClassImpl$Data$declaredNonStaticMembers$2.getInt(i8) != 0) {
                    authRequestContext18 = i8;
                    i2 = authRequestContext19;
                    z = true;
                } else {
                    authRequestContext18 = i8;
                    i2 = authRequestContext19;
                    z = false;
                }
                int i9 = KClassImpl$Data$declaredNonStaticMembers$2.getInt(i2);
                authRequestContext19 = i2;
                int i10 = authRequestContext20;
                authRequestContext20 = i10;
                arrayList.add(new RecentRecipientEntity(string2, string3, string4, string5, string6, j, j2, string7, string8, string9, string10, string11, string, string12, string13, i7, z, i9, KClassImpl$Data$declaredNonStaticMembers$2.isNull(i10) ? null : Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getInt(i10))));
                authRequestContext13 = i5;
                authRequestContext16 = i4;
                authRequestContext17 = i6;
                i3 = i;
            }
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            roomSQLiteQuery.MyBillsEntityDataFactory();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            roomSQLiteQuery.MyBillsEntityDataFactory();
            throw th;
        }
    }

    @Override // id.dana.data.recentrecipient.source.persistence.dao.RecentRecipientDao
    public final List<RecentRecipientEntity> getRecentRecipientList(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        int authRequestContext;
        int authRequestContext2;
        int authRequestContext3;
        int authRequestContext4;
        int authRequestContext5;
        int authRequestContext6;
        int authRequestContext7;
        int authRequestContext8;
        int authRequestContext9;
        int authRequestContext10;
        int authRequestContext11;
        int authRequestContext12;
        int authRequestContext13;
        int authRequestContext14;
        String string;
        int i;
        int i2;
        boolean z;
        RoomSQLiteQuery authRequestContext15 = RoomSQLiteQuery.getAuthRequestContext("SELECT * FROM RecentRecipientEntity WHERE alias LIKE '%' || ? || '%' OR instLocalName LIKE '%' || ? || '%' OR number LIKE '%' || ? || '%' OR name LIKE '%' || ? || '%' OR cardIndexNo = ? ORDER BY alias ASC", 5);
        if (str == null) {
            authRequestContext15.bindNull(1);
        } else {
            authRequestContext15.bindString(1, str);
        }
        if (str == null) {
            authRequestContext15.bindNull(2);
        } else {
            authRequestContext15.bindString(2, str);
        }
        if (str == null) {
            authRequestContext15.bindNull(3);
        } else {
            authRequestContext15.bindString(3, str);
        }
        if (str == null) {
            authRequestContext15.bindNull(4);
        } else {
            authRequestContext15.bindString(4, str);
        }
        if (str == null) {
            authRequestContext15.bindNull(5);
        } else {
            authRequestContext15.bindString(5, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext15, false);
        try {
            authRequestContext = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "dataId");
            authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "alias");
            authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "id");
            authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, GriverParams.ShareParams.IMAGE_URL);
            authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "instLocalName");
            authRequestContext6 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, BaseKey.LAST_UPDATED);
            authRequestContext7 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "lastUpdateTime");
            authRequestContext8 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "name");
            authRequestContext9 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "number");
            authRequestContext10 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "recipientName");
            authRequestContext11 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "senderName");
            authRequestContext12 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "payMethod");
            authRequestContext13 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "payOption");
            authRequestContext14 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, WalletConstant.CARD_INDEX_NO);
            roomSQLiteQuery = authRequestContext15;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = authRequestContext15;
        }
        try {
            int authRequestContext16 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "prefix");
            int authRequestContext17 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "transactionCount");
            int authRequestContext18 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, TrackerKey.SendMoneyProperties.IS_FAVORITE);
            int authRequestContext19 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "type");
            int authRequestContext20 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "participantCount");
            int i3 = authRequestContext14;
            ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
            while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                String string2 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext);
                String string3 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext2) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2);
                String string4 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext3) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext3);
                String string5 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext4) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext4);
                String string6 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext5) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext5);
                long j = KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext6);
                long j2 = KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext7);
                String string7 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext8) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext8);
                String string8 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext9) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext9);
                String string9 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext10) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext10);
                String string10 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext11) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext11);
                String string11 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext12) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext12);
                if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext13)) {
                    i = i3;
                    string = null;
                } else {
                    string = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext13);
                    i = i3;
                }
                String string12 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(i) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(i);
                int i4 = authRequestContext16;
                int i5 = authRequestContext;
                String string13 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(i4) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(i4);
                int i6 = authRequestContext17;
                int i7 = KClassImpl$Data$declaredNonStaticMembers$2.getInt(i6);
                int i8 = authRequestContext18;
                if (KClassImpl$Data$declaredNonStaticMembers$2.getInt(i8) != 0) {
                    authRequestContext18 = i8;
                    i2 = authRequestContext19;
                    z = true;
                } else {
                    authRequestContext18 = i8;
                    i2 = authRequestContext19;
                    z = false;
                }
                int i9 = KClassImpl$Data$declaredNonStaticMembers$2.getInt(i2);
                authRequestContext19 = i2;
                int i10 = authRequestContext20;
                authRequestContext20 = i10;
                arrayList.add(new RecentRecipientEntity(string2, string3, string4, string5, string6, j, j2, string7, string8, string9, string10, string11, string, string12, string13, i7, z, i9, KClassImpl$Data$declaredNonStaticMembers$2.isNull(i10) ? null : Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getInt(i10))));
                authRequestContext = i5;
                authRequestContext16 = i4;
                authRequestContext17 = i6;
                i3 = i;
            }
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            roomSQLiteQuery.MyBillsEntityDataFactory();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            roomSQLiteQuery.MyBillsEntityDataFactory();
            throw th;
        }
    }

    @Override // id.dana.data.recentrecipient.source.persistence.dao.RecentRecipientDao
    public final List<RecentRecipientEntity> getRecentBankList() {
        RoomSQLiteQuery roomSQLiteQuery;
        int authRequestContext;
        int authRequestContext2;
        int authRequestContext3;
        int authRequestContext4;
        int authRequestContext5;
        int authRequestContext6;
        int authRequestContext7;
        int authRequestContext8;
        int authRequestContext9;
        int authRequestContext10;
        int authRequestContext11;
        int authRequestContext12;
        int authRequestContext13;
        int authRequestContext14;
        String string;
        int i;
        int i2;
        boolean z;
        RoomSQLiteQuery authRequestContext15 = RoomSQLiteQuery.getAuthRequestContext("SELECT * FROM RecentRecipientEntity WHERE type = 1 ORDER BY alias ASC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext15, false);
        try {
            authRequestContext = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "dataId");
            authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "alias");
            authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "id");
            authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, GriverParams.ShareParams.IMAGE_URL);
            authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "instLocalName");
            authRequestContext6 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, BaseKey.LAST_UPDATED);
            authRequestContext7 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "lastUpdateTime");
            authRequestContext8 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "name");
            authRequestContext9 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "number");
            authRequestContext10 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "recipientName");
            authRequestContext11 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "senderName");
            authRequestContext12 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "payMethod");
            authRequestContext13 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "payOption");
            authRequestContext14 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, WalletConstant.CARD_INDEX_NO);
            roomSQLiteQuery = authRequestContext15;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = authRequestContext15;
        }
        try {
            int authRequestContext16 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "prefix");
            int authRequestContext17 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "transactionCount");
            int authRequestContext18 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, TrackerKey.SendMoneyProperties.IS_FAVORITE);
            int authRequestContext19 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "type");
            int authRequestContext20 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "participantCount");
            int i3 = authRequestContext14;
            ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
            while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                String string2 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext);
                String string3 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext2) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2);
                String string4 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext3) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext3);
                String string5 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext4) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext4);
                String string6 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext5) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext5);
                long j = KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext6);
                long j2 = KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext7);
                String string7 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext8) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext8);
                String string8 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext9) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext9);
                String string9 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext10) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext10);
                String string10 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext11) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext11);
                String string11 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext12) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext12);
                if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext13)) {
                    i = i3;
                    string = null;
                } else {
                    string = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext13);
                    i = i3;
                }
                String string12 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(i) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(i);
                int i4 = authRequestContext16;
                int i5 = authRequestContext13;
                String string13 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(i4) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(i4);
                int i6 = authRequestContext17;
                int i7 = KClassImpl$Data$declaredNonStaticMembers$2.getInt(i6);
                int i8 = authRequestContext18;
                if (KClassImpl$Data$declaredNonStaticMembers$2.getInt(i8) != 0) {
                    authRequestContext18 = i8;
                    i2 = authRequestContext19;
                    z = true;
                } else {
                    authRequestContext18 = i8;
                    i2 = authRequestContext19;
                    z = false;
                }
                int i9 = KClassImpl$Data$declaredNonStaticMembers$2.getInt(i2);
                authRequestContext19 = i2;
                int i10 = authRequestContext20;
                authRequestContext20 = i10;
                arrayList.add(new RecentRecipientEntity(string2, string3, string4, string5, string6, j, j2, string7, string8, string9, string10, string11, string, string12, string13, i7, z, i9, KClassImpl$Data$declaredNonStaticMembers$2.isNull(i10) ? null : Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getInt(i10))));
                authRequestContext13 = i5;
                authRequestContext16 = i4;
                authRequestContext17 = i6;
                i3 = i;
            }
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            roomSQLiteQuery.MyBillsEntityDataFactory();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            roomSQLiteQuery.MyBillsEntityDataFactory();
            throw th;
        }
    }

    @Override // id.dana.data.recentrecipient.source.persistence.dao.RecentRecipientDao
    public final List<RecentRecipientEntity> getRecentBankList(String str, int i) {
        RoomSQLiteQuery roomSQLiteQuery;
        int authRequestContext;
        int authRequestContext2;
        int authRequestContext3;
        int authRequestContext4;
        int authRequestContext5;
        int authRequestContext6;
        int authRequestContext7;
        int authRequestContext8;
        int authRequestContext9;
        int authRequestContext10;
        int authRequestContext11;
        int authRequestContext12;
        int authRequestContext13;
        int authRequestContext14;
        String string;
        int i2;
        int i3;
        boolean z;
        RoomSQLiteQuery authRequestContext15 = RoomSQLiteQuery.getAuthRequestContext("SELECT * FROM RecentRecipientEntity WHERE type = 1 AND alias LIKE '%' || ? || '%' OR instLocalName LIKE '%' || ? || '%' OR number LIKE '%' || ? || '%' OR name LIKE '%' || ? || '%' ORDER BY alias ASC LIMIT ?", 5);
        if (str == null) {
            authRequestContext15.bindNull(1);
        } else {
            authRequestContext15.bindString(1, str);
        }
        if (str == null) {
            authRequestContext15.bindNull(2);
        } else {
            authRequestContext15.bindString(2, str);
        }
        if (str == null) {
            authRequestContext15.bindNull(3);
        } else {
            authRequestContext15.bindString(3, str);
        }
        if (str == null) {
            authRequestContext15.bindNull(4);
        } else {
            authRequestContext15.bindString(4, str);
        }
        authRequestContext15.bindLong(5, i);
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext15, false);
        try {
            authRequestContext = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "dataId");
            authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "alias");
            authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "id");
            authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, GriverParams.ShareParams.IMAGE_URL);
            authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "instLocalName");
            authRequestContext6 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, BaseKey.LAST_UPDATED);
            authRequestContext7 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "lastUpdateTime");
            authRequestContext8 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "name");
            authRequestContext9 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "number");
            authRequestContext10 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "recipientName");
            authRequestContext11 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "senderName");
            authRequestContext12 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "payMethod");
            authRequestContext13 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "payOption");
            authRequestContext14 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, WalletConstant.CARD_INDEX_NO);
            roomSQLiteQuery = authRequestContext15;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = authRequestContext15;
        }
        try {
            int authRequestContext16 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "prefix");
            int authRequestContext17 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "transactionCount");
            int authRequestContext18 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, TrackerKey.SendMoneyProperties.IS_FAVORITE);
            int authRequestContext19 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "type");
            int authRequestContext20 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "participantCount");
            int i4 = authRequestContext14;
            ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
            while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                String string2 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext);
                String string3 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext2) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2);
                String string4 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext3) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext3);
                String string5 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext4) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext4);
                String string6 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext5) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext5);
                long j = KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext6);
                long j2 = KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext7);
                String string7 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext8) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext8);
                String string8 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext9) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext9);
                String string9 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext10) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext10);
                String string10 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext11) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext11);
                String string11 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext12) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext12);
                if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext13)) {
                    i2 = i4;
                    string = null;
                } else {
                    string = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext13);
                    i2 = i4;
                }
                String string12 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(i2) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(i2);
                int i5 = authRequestContext;
                int i6 = authRequestContext16;
                String string13 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(i6) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(i6);
                int i7 = authRequestContext17;
                int i8 = KClassImpl$Data$declaredNonStaticMembers$2.getInt(i7);
                int i9 = authRequestContext18;
                if (KClassImpl$Data$declaredNonStaticMembers$2.getInt(i9) != 0) {
                    authRequestContext18 = i9;
                    i3 = authRequestContext19;
                    z = true;
                } else {
                    authRequestContext18 = i9;
                    i3 = authRequestContext19;
                    z = false;
                }
                int i10 = KClassImpl$Data$declaredNonStaticMembers$2.getInt(i3);
                authRequestContext19 = i3;
                int i11 = authRequestContext20;
                authRequestContext20 = i11;
                arrayList.add(new RecentRecipientEntity(string2, string3, string4, string5, string6, j, j2, string7, string8, string9, string10, string11, string, string12, string13, i8, z, i10, KClassImpl$Data$declaredNonStaticMembers$2.isNull(i11) ? null : Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getInt(i11))));
                authRequestContext = i5;
                authRequestContext16 = i6;
                authRequestContext17 = i7;
                i4 = i2;
            }
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            roomSQLiteQuery.MyBillsEntityDataFactory();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            roomSQLiteQuery.MyBillsEntityDataFactory();
            throw th;
        }
    }

    @Override // id.dana.data.recentrecipient.source.persistence.dao.RecentRecipientDao
    public final List<RecentRecipientEntity> getListRecentBankByLastUpdate(boolean z) {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        int i;
        int i2;
        boolean z2;
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT * FROM RecentRecipientEntity WHERE type = 1 ORDER BY CASE WHEN ? = 1 THEN lastUpdated END ASC,CASE WHEN ? = 0 THEN lastUpdated END DESC", 2);
        long j = z ? 1L : 0L;
        authRequestContext.bindLong(1, j);
        authRequestContext.bindLong(2, j);
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext, false);
        try {
            int authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "dataId");
            int authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "alias");
            int authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "id");
            int authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, GriverParams.ShareParams.IMAGE_URL);
            int authRequestContext6 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "instLocalName");
            int authRequestContext7 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, BaseKey.LAST_UPDATED);
            int authRequestContext8 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "lastUpdateTime");
            int authRequestContext9 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "name");
            int authRequestContext10 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "number");
            int authRequestContext11 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "recipientName");
            int authRequestContext12 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "senderName");
            int authRequestContext13 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "payMethod");
            int authRequestContext14 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "payOption");
            int authRequestContext15 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, WalletConstant.CARD_INDEX_NO);
            roomSQLiteQuery = authRequestContext;
            try {
                int authRequestContext16 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "prefix");
                int authRequestContext17 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "transactionCount");
                int authRequestContext18 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, TrackerKey.SendMoneyProperties.IS_FAVORITE);
                int authRequestContext19 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "type");
                int authRequestContext20 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "participantCount");
                int i3 = authRequestContext15;
                ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
                while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                    String string2 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext2) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2);
                    String string3 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext3) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext3);
                    String string4 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext4) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext4);
                    String string5 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext5) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext5);
                    String string6 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext6) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext6);
                    long j2 = KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext7);
                    long j3 = KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext8);
                    String string7 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext9) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext9);
                    String string8 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext10) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext10);
                    String string9 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext11) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext11);
                    String string10 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext12) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext12);
                    String string11 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext13) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext13);
                    if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext14)) {
                        i = i3;
                        string = null;
                    } else {
                        string = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext14);
                        i = i3;
                    }
                    String string12 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(i) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(i);
                    int i4 = authRequestContext16;
                    int i5 = authRequestContext2;
                    String string13 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(i4) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(i4);
                    int i6 = authRequestContext17;
                    int i7 = KClassImpl$Data$declaredNonStaticMembers$2.getInt(i6);
                    int i8 = authRequestContext18;
                    if (KClassImpl$Data$declaredNonStaticMembers$2.getInt(i8) != 0) {
                        authRequestContext18 = i8;
                        i2 = authRequestContext19;
                        z2 = true;
                    } else {
                        authRequestContext18 = i8;
                        i2 = authRequestContext19;
                        z2 = false;
                    }
                    int i9 = KClassImpl$Data$declaredNonStaticMembers$2.getInt(i2);
                    authRequestContext19 = i2;
                    int i10 = authRequestContext20;
                    authRequestContext20 = i10;
                    arrayList.add(new RecentRecipientEntity(string2, string3, string4, string5, string6, j2, j3, string7, string8, string9, string10, string11, string, string12, string13, i7, z2, i9, KClassImpl$Data$declaredNonStaticMembers$2.isNull(i10) ? null : Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getInt(i10))));
                    authRequestContext2 = i5;
                    authRequestContext16 = i4;
                    authRequestContext17 = i6;
                    i3 = i;
                }
                KClassImpl$Data$declaredNonStaticMembers$2.close();
                roomSQLiteQuery.MyBillsEntityDataFactory();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                KClassImpl$Data$declaredNonStaticMembers$2.close();
                roomSQLiteQuery.MyBillsEntityDataFactory();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = authRequestContext;
        }
    }

    @Override // id.dana.data.recentrecipient.source.persistence.dao.RecentRecipientDao
    public final List<RecentRecipientEntity> getListRecentBankByTransactionCount(boolean z) {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        int i;
        int i2;
        boolean z2;
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT * from RecentRecipientEntity WHERE type = 1 ORDER BY CASE WHEN ? = 1 THEN transactionCount END ASC, CASE WHEN ? = 0 THEN transactionCount END DESC", 2);
        long j = z ? 1L : 0L;
        authRequestContext.bindLong(1, j);
        authRequestContext.bindLong(2, j);
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext, false);
        try {
            int authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "dataId");
            int authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "alias");
            int authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "id");
            int authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, GriverParams.ShareParams.IMAGE_URL);
            int authRequestContext6 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "instLocalName");
            int authRequestContext7 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, BaseKey.LAST_UPDATED);
            int authRequestContext8 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "lastUpdateTime");
            int authRequestContext9 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "name");
            int authRequestContext10 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "number");
            int authRequestContext11 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "recipientName");
            int authRequestContext12 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "senderName");
            int authRequestContext13 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "payMethod");
            int authRequestContext14 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "payOption");
            int authRequestContext15 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, WalletConstant.CARD_INDEX_NO);
            roomSQLiteQuery = authRequestContext;
            try {
                int authRequestContext16 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "prefix");
                int authRequestContext17 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "transactionCount");
                int authRequestContext18 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, TrackerKey.SendMoneyProperties.IS_FAVORITE);
                int authRequestContext19 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "type");
                int authRequestContext20 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "participantCount");
                int i3 = authRequestContext15;
                ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
                while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                    String string2 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext2) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2);
                    String string3 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext3) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext3);
                    String string4 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext4) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext4);
                    String string5 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext5) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext5);
                    String string6 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext6) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext6);
                    long j2 = KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext7);
                    long j3 = KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext8);
                    String string7 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext9) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext9);
                    String string8 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext10) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext10);
                    String string9 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext11) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext11);
                    String string10 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext12) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext12);
                    String string11 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext13) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext13);
                    if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext14)) {
                        i = i3;
                        string = null;
                    } else {
                        string = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext14);
                        i = i3;
                    }
                    String string12 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(i) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(i);
                    int i4 = authRequestContext16;
                    int i5 = authRequestContext2;
                    String string13 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(i4) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(i4);
                    int i6 = authRequestContext17;
                    int i7 = KClassImpl$Data$declaredNonStaticMembers$2.getInt(i6);
                    int i8 = authRequestContext18;
                    if (KClassImpl$Data$declaredNonStaticMembers$2.getInt(i8) != 0) {
                        authRequestContext18 = i8;
                        i2 = authRequestContext19;
                        z2 = true;
                    } else {
                        authRequestContext18 = i8;
                        i2 = authRequestContext19;
                        z2 = false;
                    }
                    int i9 = KClassImpl$Data$declaredNonStaticMembers$2.getInt(i2);
                    authRequestContext19 = i2;
                    int i10 = authRequestContext20;
                    authRequestContext20 = i10;
                    arrayList.add(new RecentRecipientEntity(string2, string3, string4, string5, string6, j2, j3, string7, string8, string9, string10, string11, string, string12, string13, i7, z2, i9, KClassImpl$Data$declaredNonStaticMembers$2.isNull(i10) ? null : Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getInt(i10))));
                    authRequestContext2 = i5;
                    authRequestContext16 = i4;
                    authRequestContext17 = i6;
                    i3 = i;
                }
                KClassImpl$Data$declaredNonStaticMembers$2.close();
                roomSQLiteQuery.MyBillsEntityDataFactory();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                KClassImpl$Data$declaredNonStaticMembers$2.close();
                roomSQLiteQuery.MyBillsEntityDataFactory();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = authRequestContext;
        }
    }

    @Override // id.dana.data.recentrecipient.source.persistence.dao.RecentRecipientDao
    public final List<RecentRecipientEntity> getRecentContactList() {
        RoomSQLiteQuery roomSQLiteQuery;
        int authRequestContext;
        int authRequestContext2;
        int authRequestContext3;
        int authRequestContext4;
        int authRequestContext5;
        int authRequestContext6;
        int authRequestContext7;
        int authRequestContext8;
        int authRequestContext9;
        int authRequestContext10;
        int authRequestContext11;
        int authRequestContext12;
        int authRequestContext13;
        int authRequestContext14;
        String string;
        int i;
        int i2;
        boolean z;
        RoomSQLiteQuery authRequestContext15 = RoomSQLiteQuery.getAuthRequestContext("SELECT * FROM RecentRecipientEntity WHERE type = 0 ORDER BY alias ASC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext15, false);
        try {
            authRequestContext = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "dataId");
            authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "alias");
            authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "id");
            authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, GriverParams.ShareParams.IMAGE_URL);
            authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "instLocalName");
            authRequestContext6 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, BaseKey.LAST_UPDATED);
            authRequestContext7 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "lastUpdateTime");
            authRequestContext8 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "name");
            authRequestContext9 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "number");
            authRequestContext10 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "recipientName");
            authRequestContext11 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "senderName");
            authRequestContext12 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "payMethod");
            authRequestContext13 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "payOption");
            authRequestContext14 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, WalletConstant.CARD_INDEX_NO);
            roomSQLiteQuery = authRequestContext15;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = authRequestContext15;
        }
        try {
            int authRequestContext16 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "prefix");
            int authRequestContext17 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "transactionCount");
            int authRequestContext18 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, TrackerKey.SendMoneyProperties.IS_FAVORITE);
            int authRequestContext19 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "type");
            int authRequestContext20 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "participantCount");
            int i3 = authRequestContext14;
            ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
            while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                String string2 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext);
                String string3 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext2) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2);
                String string4 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext3) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext3);
                String string5 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext4) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext4);
                String string6 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext5) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext5);
                long j = KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext6);
                long j2 = KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext7);
                String string7 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext8) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext8);
                String string8 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext9) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext9);
                String string9 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext10) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext10);
                String string10 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext11) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext11);
                String string11 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext12) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext12);
                if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext13)) {
                    i = i3;
                    string = null;
                } else {
                    string = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext13);
                    i = i3;
                }
                String string12 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(i) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(i);
                int i4 = authRequestContext16;
                int i5 = authRequestContext13;
                String string13 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(i4) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(i4);
                int i6 = authRequestContext17;
                int i7 = KClassImpl$Data$declaredNonStaticMembers$2.getInt(i6);
                int i8 = authRequestContext18;
                if (KClassImpl$Data$declaredNonStaticMembers$2.getInt(i8) != 0) {
                    authRequestContext18 = i8;
                    i2 = authRequestContext19;
                    z = true;
                } else {
                    authRequestContext18 = i8;
                    i2 = authRequestContext19;
                    z = false;
                }
                int i9 = KClassImpl$Data$declaredNonStaticMembers$2.getInt(i2);
                authRequestContext19 = i2;
                int i10 = authRequestContext20;
                authRequestContext20 = i10;
                arrayList.add(new RecentRecipientEntity(string2, string3, string4, string5, string6, j, j2, string7, string8, string9, string10, string11, string, string12, string13, i7, z, i9, KClassImpl$Data$declaredNonStaticMembers$2.isNull(i10) ? null : Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getInt(i10))));
                authRequestContext13 = i5;
                authRequestContext16 = i4;
                authRequestContext17 = i6;
                i3 = i;
            }
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            roomSQLiteQuery.MyBillsEntityDataFactory();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            roomSQLiteQuery.MyBillsEntityDataFactory();
            throw th;
        }
    }

    @Override // id.dana.data.recentrecipient.source.persistence.dao.RecentRecipientDao
    public final List<RecentRecipientEntity> getRecentContactList(String str, int i) {
        RoomSQLiteQuery roomSQLiteQuery;
        int authRequestContext;
        int authRequestContext2;
        int authRequestContext3;
        int authRequestContext4;
        int authRequestContext5;
        int authRequestContext6;
        int authRequestContext7;
        int authRequestContext8;
        int authRequestContext9;
        int authRequestContext10;
        int authRequestContext11;
        int authRequestContext12;
        int authRequestContext13;
        int authRequestContext14;
        String string;
        int i2;
        int i3;
        boolean z;
        RoomSQLiteQuery authRequestContext15 = RoomSQLiteQuery.getAuthRequestContext("SELECT * FROM RecentRecipientEntity WHERE type = 0 AND alias LIKE '%' || ? || '%' OR name LIKE '%' || ? || '%' OR number LIKE '%' || ? || '%' OR recipientName LIKE '%' || ? || '%' ORDER BY alias ASC LIMIT ?", 5);
        if (str == null) {
            authRequestContext15.bindNull(1);
        } else {
            authRequestContext15.bindString(1, str);
        }
        if (str == null) {
            authRequestContext15.bindNull(2);
        } else {
            authRequestContext15.bindString(2, str);
        }
        if (str == null) {
            authRequestContext15.bindNull(3);
        } else {
            authRequestContext15.bindString(3, str);
        }
        if (str == null) {
            authRequestContext15.bindNull(4);
        } else {
            authRequestContext15.bindString(4, str);
        }
        authRequestContext15.bindLong(5, i);
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext15, false);
        try {
            authRequestContext = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "dataId");
            authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "alias");
            authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "id");
            authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, GriverParams.ShareParams.IMAGE_URL);
            authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "instLocalName");
            authRequestContext6 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, BaseKey.LAST_UPDATED);
            authRequestContext7 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "lastUpdateTime");
            authRequestContext8 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "name");
            authRequestContext9 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "number");
            authRequestContext10 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "recipientName");
            authRequestContext11 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "senderName");
            authRequestContext12 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "payMethod");
            authRequestContext13 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "payOption");
            authRequestContext14 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, WalletConstant.CARD_INDEX_NO);
            roomSQLiteQuery = authRequestContext15;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = authRequestContext15;
        }
        try {
            int authRequestContext16 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "prefix");
            int authRequestContext17 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "transactionCount");
            int authRequestContext18 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, TrackerKey.SendMoneyProperties.IS_FAVORITE);
            int authRequestContext19 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "type");
            int authRequestContext20 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "participantCount");
            int i4 = authRequestContext14;
            ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
            while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                String string2 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext);
                String string3 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext2) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2);
                String string4 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext3) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext3);
                String string5 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext4) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext4);
                String string6 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext5) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext5);
                long j = KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext6);
                long j2 = KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext7);
                String string7 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext8) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext8);
                String string8 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext9) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext9);
                String string9 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext10) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext10);
                String string10 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext11) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext11);
                String string11 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext12) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext12);
                if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext13)) {
                    i2 = i4;
                    string = null;
                } else {
                    string = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext13);
                    i2 = i4;
                }
                String string12 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(i2) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(i2);
                int i5 = authRequestContext;
                int i6 = authRequestContext16;
                String string13 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(i6) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(i6);
                int i7 = authRequestContext17;
                int i8 = KClassImpl$Data$declaredNonStaticMembers$2.getInt(i7);
                int i9 = authRequestContext18;
                if (KClassImpl$Data$declaredNonStaticMembers$2.getInt(i9) != 0) {
                    authRequestContext18 = i9;
                    i3 = authRequestContext19;
                    z = true;
                } else {
                    authRequestContext18 = i9;
                    i3 = authRequestContext19;
                    z = false;
                }
                int i10 = KClassImpl$Data$declaredNonStaticMembers$2.getInt(i3);
                authRequestContext19 = i3;
                int i11 = authRequestContext20;
                authRequestContext20 = i11;
                arrayList.add(new RecentRecipientEntity(string2, string3, string4, string5, string6, j, j2, string7, string8, string9, string10, string11, string, string12, string13, i8, z, i10, KClassImpl$Data$declaredNonStaticMembers$2.isNull(i11) ? null : Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getInt(i11))));
                authRequestContext = i5;
                authRequestContext16 = i6;
                authRequestContext17 = i7;
                i4 = i2;
            }
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            roomSQLiteQuery.MyBillsEntityDataFactory();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            roomSQLiteQuery.MyBillsEntityDataFactory();
            throw th;
        }
    }

    @Override // id.dana.data.recentrecipient.source.persistence.dao.RecentRecipientDao
    public final List<RecentRecipientEntity> getRecentGroupList() {
        RoomSQLiteQuery roomSQLiteQuery;
        int authRequestContext;
        int authRequestContext2;
        int authRequestContext3;
        int authRequestContext4;
        int authRequestContext5;
        int authRequestContext6;
        int authRequestContext7;
        int authRequestContext8;
        int authRequestContext9;
        int authRequestContext10;
        int authRequestContext11;
        int authRequestContext12;
        int authRequestContext13;
        int authRequestContext14;
        String string;
        int i;
        int i2;
        boolean z;
        RoomSQLiteQuery authRequestContext15 = RoomSQLiteQuery.getAuthRequestContext("SELECT * FROM RecentRecipientEntity WHERE type = 2 OR type = 3 ORDER BY alias ASC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext15, false);
        try {
            authRequestContext = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "dataId");
            authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "alias");
            authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "id");
            authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, GriverParams.ShareParams.IMAGE_URL);
            authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "instLocalName");
            authRequestContext6 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, BaseKey.LAST_UPDATED);
            authRequestContext7 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "lastUpdateTime");
            authRequestContext8 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "name");
            authRequestContext9 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "number");
            authRequestContext10 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "recipientName");
            authRequestContext11 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "senderName");
            authRequestContext12 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "payMethod");
            authRequestContext13 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "payOption");
            authRequestContext14 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, WalletConstant.CARD_INDEX_NO);
            roomSQLiteQuery = authRequestContext15;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = authRequestContext15;
        }
        try {
            int authRequestContext16 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "prefix");
            int authRequestContext17 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "transactionCount");
            int authRequestContext18 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, TrackerKey.SendMoneyProperties.IS_FAVORITE);
            int authRequestContext19 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "type");
            int authRequestContext20 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "participantCount");
            int i3 = authRequestContext14;
            ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
            while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                String string2 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext);
                String string3 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext2) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2);
                String string4 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext3) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext3);
                String string5 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext4) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext4);
                String string6 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext5) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext5);
                long j = KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext6);
                long j2 = KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext7);
                String string7 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext8) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext8);
                String string8 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext9) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext9);
                String string9 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext10) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext10);
                String string10 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext11) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext11);
                String string11 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext12) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext12);
                if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext13)) {
                    i = i3;
                    string = null;
                } else {
                    string = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext13);
                    i = i3;
                }
                String string12 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(i) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(i);
                int i4 = authRequestContext16;
                int i5 = authRequestContext13;
                String string13 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(i4) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(i4);
                int i6 = authRequestContext17;
                int i7 = KClassImpl$Data$declaredNonStaticMembers$2.getInt(i6);
                int i8 = authRequestContext18;
                if (KClassImpl$Data$declaredNonStaticMembers$2.getInt(i8) != 0) {
                    authRequestContext18 = i8;
                    i2 = authRequestContext19;
                    z = true;
                } else {
                    authRequestContext18 = i8;
                    i2 = authRequestContext19;
                    z = false;
                }
                int i9 = KClassImpl$Data$declaredNonStaticMembers$2.getInt(i2);
                authRequestContext19 = i2;
                int i10 = authRequestContext20;
                authRequestContext20 = i10;
                arrayList.add(new RecentRecipientEntity(string2, string3, string4, string5, string6, j, j2, string7, string8, string9, string10, string11, string, string12, string13, i7, z, i9, KClassImpl$Data$declaredNonStaticMembers$2.isNull(i10) ? null : Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getInt(i10))));
                authRequestContext13 = i5;
                authRequestContext16 = i4;
                authRequestContext17 = i6;
                i3 = i;
            }
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            roomSQLiteQuery.MyBillsEntityDataFactory();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            roomSQLiteQuery.MyBillsEntityDataFactory();
            throw th;
        }
    }

    @Override // id.dana.data.recentrecipient.source.persistence.dao.RecentRecipientDao
    public final List<RecentRecipientEntity> getRecentGroupList(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        int i;
        int i2;
        boolean z;
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT * FROM RecentRecipientEntity WHERE (type = 2 OR type = 3) AND (alias LIKE '%' || ? || '%' OR name LIKE '%' || ? || '%' OR number LIKE '%' || ? || '%' OR recipientName LIKE '%' || ? || '%') ORDER BY alias ASC", 4);
        if (str == null) {
            authRequestContext.bindNull(1);
        } else {
            authRequestContext.bindString(1, str);
        }
        if (str == null) {
            authRequestContext.bindNull(2);
        } else {
            authRequestContext.bindString(2, str);
        }
        if (str == null) {
            authRequestContext.bindNull(3);
        } else {
            authRequestContext.bindString(3, str);
        }
        if (str == null) {
            authRequestContext.bindNull(4);
        } else {
            authRequestContext.bindString(4, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext, false);
        try {
            int authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "dataId");
            int authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "alias");
            int authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "id");
            int authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, GriverParams.ShareParams.IMAGE_URL);
            int authRequestContext6 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "instLocalName");
            int authRequestContext7 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, BaseKey.LAST_UPDATED);
            int authRequestContext8 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "lastUpdateTime");
            int authRequestContext9 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "name");
            int authRequestContext10 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "number");
            int authRequestContext11 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "recipientName");
            int authRequestContext12 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "senderName");
            int authRequestContext13 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "payMethod");
            int authRequestContext14 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "payOption");
            int authRequestContext15 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, WalletConstant.CARD_INDEX_NO);
            roomSQLiteQuery = authRequestContext;
            try {
                int authRequestContext16 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "prefix");
                int authRequestContext17 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "transactionCount");
                int authRequestContext18 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, TrackerKey.SendMoneyProperties.IS_FAVORITE);
                int authRequestContext19 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "type");
                int authRequestContext20 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "participantCount");
                int i3 = authRequestContext15;
                ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
                while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                    String string2 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext2) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2);
                    String string3 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext3) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext3);
                    String string4 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext4) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext4);
                    String string5 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext5) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext5);
                    String string6 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext6) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext6);
                    long j = KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext7);
                    long j2 = KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext8);
                    String string7 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext9) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext9);
                    String string8 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext10) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext10);
                    String string9 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext11) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext11);
                    String string10 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext12) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext12);
                    String string11 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext13) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext13);
                    if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext14)) {
                        i = i3;
                        string = null;
                    } else {
                        string = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext14);
                        i = i3;
                    }
                    String string12 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(i) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(i);
                    int i4 = authRequestContext16;
                    int i5 = authRequestContext2;
                    String string13 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(i4) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(i4);
                    int i6 = authRequestContext17;
                    int i7 = KClassImpl$Data$declaredNonStaticMembers$2.getInt(i6);
                    int i8 = authRequestContext18;
                    if (KClassImpl$Data$declaredNonStaticMembers$2.getInt(i8) != 0) {
                        authRequestContext18 = i8;
                        i2 = authRequestContext19;
                        z = true;
                    } else {
                        authRequestContext18 = i8;
                        i2 = authRequestContext19;
                        z = false;
                    }
                    int i9 = KClassImpl$Data$declaredNonStaticMembers$2.getInt(i2);
                    authRequestContext19 = i2;
                    int i10 = authRequestContext20;
                    authRequestContext20 = i10;
                    arrayList.add(new RecentRecipientEntity(string2, string3, string4, string5, string6, j, j2, string7, string8, string9, string10, string11, string, string12, string13, i7, z, i9, KClassImpl$Data$declaredNonStaticMembers$2.isNull(i10) ? null : Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getInt(i10))));
                    authRequestContext2 = i5;
                    authRequestContext16 = i4;
                    authRequestContext17 = i6;
                    i3 = i;
                }
                KClassImpl$Data$declaredNonStaticMembers$2.close();
                roomSQLiteQuery.MyBillsEntityDataFactory();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                KClassImpl$Data$declaredNonStaticMembers$2.close();
                roomSQLiteQuery.MyBillsEntityDataFactory();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = authRequestContext;
        }
    }

    @Override // id.dana.data.recentrecipient.source.persistence.dao.RecentRecipientDao
    public final int getRecentBankTransactionCount(String str) {
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT transactionCount FROM RecentRecipientEntity WHERE cardIndexNo = ?", 1);
        if (str == null) {
            authRequestContext.bindNull(1);
        } else {
            authRequestContext.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext, false);
        try {
            return KClassImpl$Data$declaredNonStaticMembers$2.moveToFirst() ? KClassImpl$Data$declaredNonStaticMembers$2.getInt(0) : 0;
        } finally {
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            authRequestContext.MyBillsEntityDataFactory();
        }
    }

    @Override // id.dana.data.recentrecipient.source.persistence.dao.RecentRecipientDao
    public final int getRecentTransactionTransactionCount(String str) {
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT transactionCount FROM RecentRecipientEntity WHERE dataId = ?", 1);
        if (str == null) {
            authRequestContext.bindNull(1);
        } else {
            authRequestContext.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext, false);
        try {
            return KClassImpl$Data$declaredNonStaticMembers$2.moveToFirst() ? KClassImpl$Data$declaredNonStaticMembers$2.getInt(0) : 0;
        } finally {
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            authRequestContext.MyBillsEntityDataFactory();
        }
    }

    @Override // id.dana.data.recentrecipient.source.persistence.dao.RecentRecipientDao
    public final int getFavoriteAccountCount() {
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT COUNT(id) FROM RecentRecipientEntity WHERE isFavorite = 1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext, false);
        try {
            return KClassImpl$Data$declaredNonStaticMembers$2.moveToFirst() ? KClassImpl$Data$declaredNonStaticMembers$2.getInt(0) : 0;
        } finally {
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            authRequestContext.MyBillsEntityDataFactory();
        }
    }

    @Override // id.dana.data.recentrecipient.source.persistence.dao.RecentRecipientDao
    public final RecentRecipientEntity getLeastTransactionFavoriteAccount() {
        RoomSQLiteQuery roomSQLiteQuery;
        int authRequestContext;
        int authRequestContext2;
        int authRequestContext3;
        int authRequestContext4;
        int authRequestContext5;
        int authRequestContext6;
        int authRequestContext7;
        int authRequestContext8;
        int authRequestContext9;
        int authRequestContext10;
        int authRequestContext11;
        int authRequestContext12;
        int authRequestContext13;
        int authRequestContext14;
        String string;
        int i;
        String string2;
        int i2;
        int i3;
        boolean z;
        RoomSQLiteQuery authRequestContext15 = RoomSQLiteQuery.getAuthRequestContext("SELECT * FROM RecentRecipientEntity WHERE lastUpdated = (SELECT min(lastUpdated) from RecentRecipientEntity WHERE transactionCount = (SELECT min(transactionCount) FROM RecentRecipientEntity WHERE isFavorite = 1) AND isFavorite = 1)", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext15, false);
        try {
            authRequestContext = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "dataId");
            authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "alias");
            authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "id");
            authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, GriverParams.ShareParams.IMAGE_URL);
            authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "instLocalName");
            authRequestContext6 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, BaseKey.LAST_UPDATED);
            authRequestContext7 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "lastUpdateTime");
            authRequestContext8 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "name");
            authRequestContext9 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "number");
            authRequestContext10 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "recipientName");
            authRequestContext11 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "senderName");
            authRequestContext12 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "payMethod");
            authRequestContext13 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "payOption");
            authRequestContext14 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, WalletConstant.CARD_INDEX_NO);
            roomSQLiteQuery = authRequestContext15;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = authRequestContext15;
        }
        try {
            int authRequestContext16 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "prefix");
            int authRequestContext17 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "transactionCount");
            int authRequestContext18 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, TrackerKey.SendMoneyProperties.IS_FAVORITE);
            int authRequestContext19 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "type");
            int authRequestContext20 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "participantCount");
            RecentRecipientEntity recentRecipientEntity = null;
            if (KClassImpl$Data$declaredNonStaticMembers$2.moveToFirst()) {
                String string3 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext);
                String string4 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext2) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2);
                String string5 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext3) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext3);
                String string6 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext4) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext4);
                String string7 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext5) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext5);
                long j = KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext6);
                long j2 = KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext7);
                String string8 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext8) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext8);
                String string9 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext9) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext9);
                String string10 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext10) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext10);
                String string11 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext11) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext11);
                String string12 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext12) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext12);
                String string13 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext13) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext13);
                if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext14)) {
                    i = authRequestContext16;
                    string = null;
                } else {
                    string = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext14);
                    i = authRequestContext16;
                }
                if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i)) {
                    i2 = authRequestContext17;
                    string2 = null;
                } else {
                    string2 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i);
                    i2 = authRequestContext17;
                }
                int i4 = KClassImpl$Data$declaredNonStaticMembers$2.getInt(i2);
                if (KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext18) != 0) {
                    i3 = authRequestContext19;
                    z = true;
                } else {
                    i3 = authRequestContext19;
                    z = false;
                }
                recentRecipientEntity = new RecentRecipientEntity(string3, string4, string5, string6, string7, j, j2, string8, string9, string10, string11, string12, string13, string, string2, i4, z, KClassImpl$Data$declaredNonStaticMembers$2.getInt(i3), KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext20) ? null : Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext20)));
            }
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            roomSQLiteQuery.MyBillsEntityDataFactory();
            return recentRecipientEntity;
        } catch (Throwable th2) {
            th = th2;
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            roomSQLiteQuery.MyBillsEntityDataFactory();
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
    
        if (r5.getInt(0) != 0) goto L13;
     */
    @Override // id.dana.data.recentrecipient.source.persistence.dao.RecentRecipientDao
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean getGroupFavoriteValue(java.lang.String r5) {
        /*
            r4 = this;
            r0 = 1
            java.lang.String r1 = "SELECT isFavorite FROM RecentRecipientEntity WHERE id = ?"
            androidx.room.RoomSQLiteQuery r1 = androidx.room.RoomSQLiteQuery.getAuthRequestContext(r1, r0)
            if (r5 != 0) goto Ld
            r1.bindNull(r0)
            goto L10
        Ld:
            r1.bindString(r0, r5)
        L10:
            androidx.room.RoomDatabase r5 = r4.__db
            r5.assertNotSuspendingTransaction()
            androidx.room.RoomDatabase r5 = r4.__db
            r2 = 0
            android.database.Cursor r5 = androidx.room.util.DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(r5, r1, r2)
            boolean r3 = r5.moveToFirst()     // Catch: java.lang.Throwable -> L31
            if (r3 == 0) goto L29
            int r3 = r5.getInt(r2)     // Catch: java.lang.Throwable -> L31
            if (r3 == 0) goto L29
            goto L2a
        L29:
            r0 = 0
        L2a:
            r5.close()
            r1.MyBillsEntityDataFactory()
            return r0
        L31:
            r0 = move-exception
            r5.close()
            r1.MyBillsEntityDataFactory()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.recentrecipient.source.persistence.dao.RecentRecipientDao_Impl.getGroupFavoriteValue(java.lang.String):boolean");
    }

    @Override // id.dana.data.recentrecipient.source.persistence.dao.RecentRecipientDao
    public final long getLastUpdatedTime(String str) {
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT lastUpdated FROM RecentRecipientEntity WHERE dataId = ?", 1);
        if (str == null) {
            authRequestContext.bindNull(1);
        } else {
            authRequestContext.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext, false);
        try {
            return KClassImpl$Data$declaredNonStaticMembers$2.moveToFirst() ? KClassImpl$Data$declaredNonStaticMembers$2.getLong(0) : 0L;
        } finally {
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            authRequestContext.MyBillsEntityDataFactory();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
