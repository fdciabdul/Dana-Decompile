package id.dana.data.wallet_v3.repository.source.persistence.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import id.dana.data.base.MapConverter;
import id.dana.data.wallet_v3.repository.source.persistence.entity.KtpDaoEntity;
import id.dana.domain.qrbarcode.DecodedScanBizInfoKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes8.dex */
public final class UserIdentityAssetsDao_Impl implements UserIdentityAssetsDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<KtpDaoEntity> __insertionAdapterOfKtpDaoEntity;
    private final MapConverter __mapConverter = new MapConverter();
    private final SharedSQLiteStatement __preparedStmtOfClearUserIdentityAssets;

    public UserIdentityAssetsDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfKtpDaoEntity = new EntityInsertionAdapter<KtpDaoEntity>(roomDatabase) { // from class: id.dana.data.wallet_v3.repository.source.persistence.dao.UserIdentityAssetsDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `KtpDaoEntity` (`pocketId`,`pocketStatus`,`pocketType`,`backgroundUrl`,`createdDate`,`iconUrl`,`logoUrl`,`extendInfo`,`cardTitle`) VALUES (?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public /* synthetic */ void bind(SupportSQLiteStatement supportSQLiteStatement, KtpDaoEntity ktpDaoEntity) {
                KtpDaoEntity ktpDaoEntity2 = ktpDaoEntity;
                if (ktpDaoEntity2.getPocketId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, ktpDaoEntity2.getPocketId());
                }
                if (ktpDaoEntity2.getPocketStatus() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, ktpDaoEntity2.getPocketStatus());
                }
                if (ktpDaoEntity2.getPocketType() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, ktpDaoEntity2.getPocketType());
                }
                if (ktpDaoEntity2.getBackgroundUrl() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, ktpDaoEntity2.getBackgroundUrl());
                }
                if (ktpDaoEntity2.getCreatedDate() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindLong(5, ktpDaoEntity2.getCreatedDate().longValue());
                }
                if (ktpDaoEntity2.getIconUrl() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, ktpDaoEntity2.getIconUrl());
                }
                if (ktpDaoEntity2.getLogoUrl() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, ktpDaoEntity2.getLogoUrl());
                }
                String fromStringMap = UserIdentityAssetsDao_Impl.this.__mapConverter.fromStringMap(ktpDaoEntity2.getExtendInfo());
                if (fromStringMap == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, fromStringMap);
                }
                if (ktpDaoEntity2.getCardTitle() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, ktpDaoEntity2.getCardTitle());
                }
            }
        };
        this.__preparedStmtOfClearUserIdentityAssets = new SharedSQLiteStatement(roomDatabase) { // from class: id.dana.data.wallet_v3.repository.source.persistence.dao.UserIdentityAssetsDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM KtpDaoEntity";
            }
        };
    }

    @Override // id.dana.data.wallet_v3.repository.source.persistence.dao.UserIdentityAssetsDao
    public final long[] saveUserKtpAssets(KtpDaoEntity... ktpDaoEntityArr) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long[] insertAndReturnIdsArray = this.__insertionAdapterOfKtpDaoEntity.insertAndReturnIdsArray(ktpDaoEntityArr);
            this.__db.setTransactionSuccessful();
            return insertAndReturnIdsArray;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // id.dana.data.wallet_v3.repository.source.persistence.dao.UserIdentityAssetsDao
    public final void clearUserIdentityAssets() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfClearUserIdentityAssets.acquire();
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfClearUserIdentityAssets.release(acquire);
        }
    }

    @Override // id.dana.data.wallet_v3.repository.source.persistence.dao.UserIdentityAssetsDao
    public final List<KtpDaoEntity> getUserKtpAssets() {
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT * FROM KtpDaoEntity", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext, false);
        try {
            int authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "pocketId");
            int authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "pocketStatus");
            int authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "pocketType");
            int authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "backgroundUrl");
            int authRequestContext6 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "createdDate");
            int authRequestContext7 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "iconUrl");
            int authRequestContext8 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, DecodedScanBizInfoKey.LOGO_URL);
            int authRequestContext9 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "extendInfo");
            int authRequestContext10 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "cardTitle");
            ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
            while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                arrayList.add(new KtpDaoEntity(KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext2) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2), KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext3) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext3), KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext4) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext4), KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext5) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext5), KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext6) ? null : Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext6)), KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext7) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext7), KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext8) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext8), this.__mapConverter.fromString(KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext9) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext9)), KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext10) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext10)));
            }
            return arrayList;
        } finally {
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            authRequestContext.MyBillsEntityDataFactory();
        }
    }

    @Override // id.dana.data.wallet_v3.repository.source.persistence.dao.UserIdentityAssetsDao
    public final List<KtpDaoEntity> searchUserIdentityAssets(String str) {
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT * FROM KtpDaoEntity WHERE cardTitle LIKE '%' || ? || '%'", 1);
        if (str == null) {
            authRequestContext.bindNull(1);
        } else {
            authRequestContext.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext, false);
        try {
            int authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "pocketId");
            int authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "pocketStatus");
            int authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "pocketType");
            int authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "backgroundUrl");
            int authRequestContext6 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "createdDate");
            int authRequestContext7 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "iconUrl");
            int authRequestContext8 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, DecodedScanBizInfoKey.LOGO_URL);
            int authRequestContext9 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "extendInfo");
            int authRequestContext10 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "cardTitle");
            ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
            while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                arrayList.add(new KtpDaoEntity(KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext2) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2), KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext3) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext3), KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext4) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext4), KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext5) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext5), KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext6) ? null : Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext6)), KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext7) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext7), KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext8) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext8), this.__mapConverter.fromString(KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext9) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext9)), KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext10) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext10)));
            }
            return arrayList;
        } finally {
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            authRequestContext.MyBillsEntityDataFactory();
        }
    }

    @Override // id.dana.data.wallet_v3.repository.source.persistence.dao.UserIdentityAssetsDao
    public final List<String> getSavedAssetTypes() {
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT pocketType FROM KtpDaoEntity", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext, false);
        try {
            ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
            while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                arrayList.add(KClassImpl$Data$declaredNonStaticMembers$2.isNull(0) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(0));
            }
            return arrayList;
        } finally {
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            authRequestContext.MyBillsEntityDataFactory();
        }
    }

    @Override // id.dana.data.wallet_v3.repository.source.persistence.dao.UserIdentityAssetsDao
    public final List<String> getUserIdentityViaQuery(SupportSQLiteQuery supportSQLiteQuery) {
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, supportSQLiteQuery, false);
        try {
            ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
            while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                arrayList.add(KClassImpl$Data$declaredNonStaticMembers$2.isNull(0) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(0));
            }
            return arrayList;
        } finally {
            KClassImpl$Data$declaredNonStaticMembers$2.close();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
