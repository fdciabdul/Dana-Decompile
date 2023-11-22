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
import id.dana.data.splitbill.repository.source.persistence.entity.SplitBillHistoryEntity;
import id.dana.domain.qrbarcode.DecodedScanBizInfoKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes8.dex */
public final class SplitBillHistoryDao_Impl implements SplitBillHistoryDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<SplitBillHistoryEntity> __insertionAdapterOfSplitBillHistoryEntity;
    private final SharedSQLiteStatement __preparedStmtOfClearAll;
    private final SharedSQLiteStatement __preparedStmtOfDeleteOldSplitBillHistories;
    private final EntityDeletionOrUpdateAdapter<SplitBillHistoryEntity> __updateAdapterOfSplitBillHistoryEntity;

    public SplitBillHistoryDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfSplitBillHistoryEntity = new EntityInsertionAdapter<SplitBillHistoryEntity>(roomDatabase) { // from class: id.dana.data.splitbill.repository.source.persistence.dao.SplitBillHistoryDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR ABORT INTO `SplitBillHistoryEntity` (`uid`,`comment`,`deepLinkUrl`,`payers`,`lastUpdated`,`splitBillId`,`createdDate`,`status`,`totalAmount`,`payeeIndex`,`payerIndex`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public /* synthetic */ void bind(SupportSQLiteStatement supportSQLiteStatement, SplitBillHistoryEntity splitBillHistoryEntity) {
                SplitBillHistoryEntity splitBillHistoryEntity2 = splitBillHistoryEntity;
                supportSQLiteStatement.bindLong(1, splitBillHistoryEntity2.getUid());
                if (splitBillHistoryEntity2.getComment() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, splitBillHistoryEntity2.getComment());
                }
                if (splitBillHistoryEntity2.getDeepLinkUrl() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, splitBillHistoryEntity2.getDeepLinkUrl());
                }
                if (splitBillHistoryEntity2.getPayers() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, splitBillHistoryEntity2.getPayers());
                }
                supportSQLiteStatement.bindLong(5, splitBillHistoryEntity2.getLastUpdated());
                if (splitBillHistoryEntity2.getSplitBillId() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, splitBillHistoryEntity2.getSplitBillId());
                }
                supportSQLiteStatement.bindLong(7, splitBillHistoryEntity2.getCreatedDate());
                if (splitBillHistoryEntity2.getStatus() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, splitBillHistoryEntity2.getStatus());
                }
                if (splitBillHistoryEntity2.getTotalAmount() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, splitBillHistoryEntity2.getTotalAmount());
                }
                supportSQLiteStatement.bindLong(10, splitBillHistoryEntity2.getPayeeIndex());
                supportSQLiteStatement.bindLong(11, splitBillHistoryEntity2.getPayerIndex());
            }
        };
        this.__updateAdapterOfSplitBillHistoryEntity = new EntityDeletionOrUpdateAdapter<SplitBillHistoryEntity>(roomDatabase) { // from class: id.dana.data.splitbill.repository.source.persistence.dao.SplitBillHistoryDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `SplitBillHistoryEntity` SET `uid` = ?,`comment` = ?,`deepLinkUrl` = ?,`payers` = ?,`lastUpdated` = ?,`splitBillId` = ?,`createdDate` = ?,`status` = ?,`totalAmount` = ?,`payeeIndex` = ?,`payerIndex` = ? WHERE `uid` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(SupportSQLiteStatement supportSQLiteStatement, SplitBillHistoryEntity splitBillHistoryEntity) {
                SplitBillHistoryEntity splitBillHistoryEntity2 = splitBillHistoryEntity;
                supportSQLiteStatement.bindLong(1, splitBillHistoryEntity2.getUid());
                if (splitBillHistoryEntity2.getComment() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, splitBillHistoryEntity2.getComment());
                }
                if (splitBillHistoryEntity2.getDeepLinkUrl() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, splitBillHistoryEntity2.getDeepLinkUrl());
                }
                if (splitBillHistoryEntity2.getPayers() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, splitBillHistoryEntity2.getPayers());
                }
                supportSQLiteStatement.bindLong(5, splitBillHistoryEntity2.getLastUpdated());
                if (splitBillHistoryEntity2.getSplitBillId() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, splitBillHistoryEntity2.getSplitBillId());
                }
                supportSQLiteStatement.bindLong(7, splitBillHistoryEntity2.getCreatedDate());
                if (splitBillHistoryEntity2.getStatus() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, splitBillHistoryEntity2.getStatus());
                }
                if (splitBillHistoryEntity2.getTotalAmount() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, splitBillHistoryEntity2.getTotalAmount());
                }
                supportSQLiteStatement.bindLong(10, splitBillHistoryEntity2.getPayeeIndex());
                supportSQLiteStatement.bindLong(11, splitBillHistoryEntity2.getPayerIndex());
                supportSQLiteStatement.bindLong(12, splitBillHistoryEntity2.getUid());
            }
        };
        this.__preparedStmtOfDeleteOldSplitBillHistories = new SharedSQLiteStatement(roomDatabase) { // from class: id.dana.data.splitbill.repository.source.persistence.dao.SplitBillHistoryDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM SplitBillHistoryEntity where uid NOT IN (SELECT uid from SplitBillHistoryEntity ORDER BY uid DESC LIMIT 10)";
            }
        };
        this.__preparedStmtOfClearAll = new SharedSQLiteStatement(roomDatabase) { // from class: id.dana.data.splitbill.repository.source.persistence.dao.SplitBillHistoryDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM SplitBillHistoryEntity";
            }
        };
    }

    @Override // id.dana.data.splitbill.repository.source.persistence.dao.SplitBillHistoryDao
    public final Long saveSplitBillHistory(SplitBillHistoryEntity splitBillHistoryEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long insertAndReturnId = this.__insertionAdapterOfSplitBillHistoryEntity.insertAndReturnId(splitBillHistoryEntity);
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
            return Long.valueOf(insertAndReturnId);
        } catch (Throwable th) {
            this.__db.endTransaction();
            throw th;
        }
    }

    @Override // id.dana.data.splitbill.repository.source.persistence.dao.SplitBillHistoryDao
    public final int updateSplitBillHistoryEntity(SplitBillHistoryEntity splitBillHistoryEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int BuiltInFictitiousFunctionClassFactory = this.__updateAdapterOfSplitBillHistoryEntity.BuiltInFictitiousFunctionClassFactory(splitBillHistoryEntity);
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
            return BuiltInFictitiousFunctionClassFactory + 0;
        } catch (Throwable th) {
            this.__db.endTransaction();
            throw th;
        }
    }

    @Override // id.dana.data.splitbill.repository.source.persistence.dao.SplitBillHistoryDao
    public final void deleteOldSplitBillHistories() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteOldSplitBillHistories.acquire();
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteOldSplitBillHistories.release(acquire);
        }
    }

    @Override // id.dana.data.splitbill.repository.source.persistence.dao.SplitBillHistoryDao
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

    @Override // id.dana.data.splitbill.repository.source.persistence.dao.SplitBillHistoryDao
    public final List<SplitBillHistoryEntity> getSplitBillHistories() {
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT * FROM SplitBillHistoryEntity ORDER BY lastUpdated DESC LIMIT 10 ", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext, false);
        try {
            int authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "uid");
            int authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, DecodedScanBizInfoKey.COMMENT);
            int authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "deepLinkUrl");
            int authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "payers");
            int authRequestContext6 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, BaseKey.LAST_UPDATED);
            int authRequestContext7 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, DecodedScanBizInfoKey.SPLIT_BILL_ID);
            int authRequestContext8 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "createdDate");
            int authRequestContext9 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "status");
            int authRequestContext10 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "totalAmount");
            int authRequestContext11 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, DecodedScanBizInfoKey.PAYEE_INDEX);
            int authRequestContext12 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, DecodedScanBizInfoKey.PAYER_INDEX);
            ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
            while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                SplitBillHistoryEntity splitBillHistoryEntity = new SplitBillHistoryEntity();
                splitBillHistoryEntity.setUid(KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext2));
                splitBillHistoryEntity.setComment(KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext3) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext3));
                splitBillHistoryEntity.setDeepLinkUrl(KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext4) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext4));
                splitBillHistoryEntity.setPayers(KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext5) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext5));
                int i = authRequestContext2;
                splitBillHistoryEntity.setLastUpdated(KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext6));
                splitBillHistoryEntity.setSplitBillId(KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext7) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext7));
                splitBillHistoryEntity.setCreatedDate(KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext8));
                splitBillHistoryEntity.setStatus(KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext9) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext9));
                splitBillHistoryEntity.setTotalAmount(KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext10) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext10));
                splitBillHistoryEntity.setPayeeIndex(KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext11));
                splitBillHistoryEntity.setPayerIndex(KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext12));
                arrayList.add(splitBillHistoryEntity);
                authRequestContext2 = i;
            }
            return arrayList;
        } finally {
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            authRequestContext.MyBillsEntityDataFactory();
        }
    }

    @Override // id.dana.data.splitbill.repository.source.persistence.dao.SplitBillHistoryDao
    public final SplitBillHistoryEntity getHistoryById(String str) {
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT * FROM SplitBillHistoryEntity WHERE splitBillId = ?", 1);
        if (str == null) {
            authRequestContext.bindNull(1);
        } else {
            authRequestContext.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext, false);
        try {
            int authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "uid");
            int authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, DecodedScanBizInfoKey.COMMENT);
            int authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "deepLinkUrl");
            int authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "payers");
            int authRequestContext6 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, BaseKey.LAST_UPDATED);
            int authRequestContext7 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, DecodedScanBizInfoKey.SPLIT_BILL_ID);
            int authRequestContext8 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "createdDate");
            int authRequestContext9 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "status");
            int authRequestContext10 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "totalAmount");
            int authRequestContext11 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, DecodedScanBizInfoKey.PAYEE_INDEX);
            int authRequestContext12 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, DecodedScanBizInfoKey.PAYER_INDEX);
            SplitBillHistoryEntity splitBillHistoryEntity = null;
            String string = null;
            if (KClassImpl$Data$declaredNonStaticMembers$2.moveToFirst()) {
                SplitBillHistoryEntity splitBillHistoryEntity2 = new SplitBillHistoryEntity();
                splitBillHistoryEntity2.setUid(KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext2));
                splitBillHistoryEntity2.setComment(KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext3) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext3));
                splitBillHistoryEntity2.setDeepLinkUrl(KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext4) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext4));
                splitBillHistoryEntity2.setPayers(KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext5) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext5));
                splitBillHistoryEntity2.setLastUpdated(KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext6));
                splitBillHistoryEntity2.setSplitBillId(KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext7) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext7));
                splitBillHistoryEntity2.setCreatedDate(KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext8));
                splitBillHistoryEntity2.setStatus(KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext9) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext9));
                if (!KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext10)) {
                    string = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext10);
                }
                splitBillHistoryEntity2.setTotalAmount(string);
                splitBillHistoryEntity2.setPayeeIndex(KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext11));
                splitBillHistoryEntity2.setPayerIndex(KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext12));
                splitBillHistoryEntity = splitBillHistoryEntity2;
            }
            return splitBillHistoryEntity;
        } finally {
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            authRequestContext.MyBillsEntityDataFactory();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
