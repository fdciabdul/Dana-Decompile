package id.dana.data.loyalty.repository.source.local.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.data.loyalty.repository.source.local.entity.LoyaltyReceiptEntity;
import id.dana.lib.gcontainer.app.bridge.constant.BridgeKey;
import java.util.Collections;
import java.util.List;

/* loaded from: classes8.dex */
public final class LoyaltyReceiptDao_Impl implements LoyaltyReceiptDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<LoyaltyReceiptEntity> __insertionAdapterOfLoyaltyReceiptEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteReceipt;

    public LoyaltyReceiptDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfLoyaltyReceiptEntity = new EntityInsertionAdapter<LoyaltyReceiptEntity>(roomDatabase) { // from class: id.dana.data.loyalty.repository.source.local.dao.LoyaltyReceiptDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `LoyaltyReceiptEntity` (`userLoyaltyId`,`merchantId`,`orderId`,`merchantName`,`orderAmount`,`timestamp`,`filePath`,`rawText`) VALUES (?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public /* synthetic */ void bind(SupportSQLiteStatement supportSQLiteStatement, LoyaltyReceiptEntity loyaltyReceiptEntity) {
                LoyaltyReceiptEntity loyaltyReceiptEntity2 = loyaltyReceiptEntity;
                if (loyaltyReceiptEntity2.getUserLoyaltyId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, loyaltyReceiptEntity2.getUserLoyaltyId());
                }
                if (loyaltyReceiptEntity2.getMerchantId() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, loyaltyReceiptEntity2.getMerchantId());
                }
                if (loyaltyReceiptEntity2.getOrderId() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, loyaltyReceiptEntity2.getOrderId());
                }
                if (loyaltyReceiptEntity2.getMerchantName() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, loyaltyReceiptEntity2.getMerchantName());
                }
                if (loyaltyReceiptEntity2.getOrderAmount() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, loyaltyReceiptEntity2.getOrderAmount());
                }
                if (loyaltyReceiptEntity2.getTimestamp() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, loyaltyReceiptEntity2.getTimestamp());
                }
                if (loyaltyReceiptEntity2.getFilePath() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, loyaltyReceiptEntity2.getFilePath());
                }
                if (loyaltyReceiptEntity2.getRawText() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, loyaltyReceiptEntity2.getRawText());
                }
            }
        };
        this.__preparedStmtOfDeleteReceipt = new SharedSQLiteStatement(roomDatabase) { // from class: id.dana.data.loyalty.repository.source.local.dao.LoyaltyReceiptDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM LoyaltyReceiptEntity WHERE userLoyaltyId = ?";
            }
        };
    }

    @Override // id.dana.data.loyalty.repository.source.local.dao.LoyaltyReceiptDao
    public final long insertReceipt(LoyaltyReceiptEntity loyaltyReceiptEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long insertAndReturnId = this.__insertionAdapterOfLoyaltyReceiptEntity.insertAndReturnId(loyaltyReceiptEntity);
            this.__db.setTransactionSuccessful();
            return insertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // id.dana.data.loyalty.repository.source.local.dao.LoyaltyReceiptDao
    public final int deleteReceipt(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteReceipt.acquire();
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
            this.__preparedStmtOfDeleteReceipt.release(acquire);
        }
    }

    @Override // id.dana.data.loyalty.repository.source.local.dao.LoyaltyReceiptDao
    public final LoyaltyReceiptEntity getReceiptByUserLoyaltyId(String str) {
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT * FROM LoyaltyReceiptEntity WHERE userLoyaltyId = ?", 1);
        if (str == null) {
            authRequestContext.bindNull(1);
        } else {
            authRequestContext.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext, false);
        try {
            int authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "userLoyaltyId");
            int authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "merchantId");
            int authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "orderId");
            int authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "merchantName");
            int authRequestContext6 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, CashierKeyParams.TOTAL_AMOUNT);
            int authRequestContext7 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "timestamp");
            int authRequestContext8 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, BridgeKey.FILE_PATH);
            int authRequestContext9 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "rawText");
            LoyaltyReceiptEntity loyaltyReceiptEntity = null;
            if (KClassImpl$Data$declaredNonStaticMembers$2.moveToFirst()) {
                loyaltyReceiptEntity = new LoyaltyReceiptEntity(KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext2) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2), KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext3) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext3), KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext4) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext4), KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext5) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext5), KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext6) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext6), KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext7) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext7), KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext8) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext8), KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext9) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext9));
            }
            return loyaltyReceiptEntity;
        } finally {
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            authRequestContext.MyBillsEntityDataFactory();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
