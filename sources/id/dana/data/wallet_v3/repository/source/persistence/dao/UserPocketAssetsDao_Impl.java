package id.dana.data.wallet_v3.repository.source.persistence.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.google.firebase.messaging.Constants;
import id.dana.data.base.MapConverter;
import id.dana.data.wallet_v3.repository.source.persistence.entity.UserPocketAssetsDaoEntity;
import id.dana.domain.qrbarcode.DecodedScanBizInfoKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public final class UserPocketAssetsDao_Impl implements UserPocketAssetsDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<UserPocketAssetsDaoEntity> __insertionAdapterOfUserPocketAssetsDaoEntity;
    private final MapConverter __mapConverter = new MapConverter();
    private final SharedSQLiteStatement __preparedStmtOfClearUserPocketAssets;
    private final SharedSQLiteStatement __preparedStmtOfDeleteUserPocketAssets;

    public UserPocketAssetsDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfUserPocketAssetsDaoEntity = new EntityInsertionAdapter<UserPocketAssetsDaoEntity>(roomDatabase) { // from class: id.dana.data.wallet_v3.repository.source.persistence.dao.UserPocketAssetsDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `UserPocketAssetsDaoEntity` (`pocketId`,`pocketStatus`,`iconUrl`,`backgroundUrl`,`pocketType`,`userPocketStatus`,`activateDate`,`howTo`,`merchantId`,`label`,`subLabel`,`logoUrl`,`usable`,`shareable`,`goodsId`,`tcUrl`,`expirationDate`,`createdDate`,`shareableRpcInfoReceiverInfo`,`shareableRpcInfoReceiverUserId`,`shareableRpcInfoSharedDate`,`extendInfo`,`primaryCTA`,`backgroundColor`,`fontColor`,`minimumTransaction`,`categoryIconUrl`,`bizInfo`,`cacheTimestamp`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public /* synthetic */ void bind(SupportSQLiteStatement supportSQLiteStatement, UserPocketAssetsDaoEntity userPocketAssetsDaoEntity) {
                UserPocketAssetsDaoEntity userPocketAssetsDaoEntity2 = userPocketAssetsDaoEntity;
                if (userPocketAssetsDaoEntity2.getPocketId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, userPocketAssetsDaoEntity2.getPocketId());
                }
                if (userPocketAssetsDaoEntity2.getPocketStatus() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, userPocketAssetsDaoEntity2.getPocketStatus());
                }
                if (userPocketAssetsDaoEntity2.getIconUrl() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, userPocketAssetsDaoEntity2.getIconUrl());
                }
                if (userPocketAssetsDaoEntity2.getBackgroundUrl() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, userPocketAssetsDaoEntity2.getBackgroundUrl());
                }
                if (userPocketAssetsDaoEntity2.getPocketType() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, userPocketAssetsDaoEntity2.getPocketType());
                }
                if (userPocketAssetsDaoEntity2.getUserPocketStatus() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, userPocketAssetsDaoEntity2.getUserPocketStatus());
                }
                if (userPocketAssetsDaoEntity2.getActivateDate() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindLong(7, userPocketAssetsDaoEntity2.getActivateDate().longValue());
                }
                if (userPocketAssetsDaoEntity2.getHowTo() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, userPocketAssetsDaoEntity2.getHowTo());
                }
                if (userPocketAssetsDaoEntity2.getMerchantId() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, userPocketAssetsDaoEntity2.getMerchantId());
                }
                if (userPocketAssetsDaoEntity2.getLabel() == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, userPocketAssetsDaoEntity2.getLabel());
                }
                if (userPocketAssetsDaoEntity2.getSubLabel() == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindString(11, userPocketAssetsDaoEntity2.getSubLabel());
                }
                if (userPocketAssetsDaoEntity2.getLogoUrl() == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindString(12, userPocketAssetsDaoEntity2.getLogoUrl());
                }
                if ((userPocketAssetsDaoEntity2.getUsable() == null ? null : Integer.valueOf(userPocketAssetsDaoEntity2.getUsable().booleanValue() ? 1 : 0)) == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindLong(13, r0.intValue());
                }
                if ((userPocketAssetsDaoEntity2.getShareable() != null ? Integer.valueOf(userPocketAssetsDaoEntity2.getShareable().booleanValue() ? 1 : 0) : null) == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindLong(14, r1.intValue());
                }
                if (userPocketAssetsDaoEntity2.getGoodsId() == null) {
                    supportSQLiteStatement.bindNull(15);
                } else {
                    supportSQLiteStatement.bindString(15, userPocketAssetsDaoEntity2.getGoodsId());
                }
                if (userPocketAssetsDaoEntity2.getTcUrl() == null) {
                    supportSQLiteStatement.bindNull(16);
                } else {
                    supportSQLiteStatement.bindString(16, userPocketAssetsDaoEntity2.getTcUrl());
                }
                if (userPocketAssetsDaoEntity2.getExpirationDate() == null) {
                    supportSQLiteStatement.bindNull(17);
                } else {
                    supportSQLiteStatement.bindLong(17, userPocketAssetsDaoEntity2.getExpirationDate().longValue());
                }
                if (userPocketAssetsDaoEntity2.getCreatedDate() == null) {
                    supportSQLiteStatement.bindNull(18);
                } else {
                    supportSQLiteStatement.bindString(18, userPocketAssetsDaoEntity2.getCreatedDate());
                }
                if (userPocketAssetsDaoEntity2.getShareableRpcInfoReceiverInfo() == null) {
                    supportSQLiteStatement.bindNull(19);
                } else {
                    supportSQLiteStatement.bindString(19, userPocketAssetsDaoEntity2.getShareableRpcInfoReceiverInfo());
                }
                if (userPocketAssetsDaoEntity2.getShareableRpcInfoReceiverUserId() == null) {
                    supportSQLiteStatement.bindNull(20);
                } else {
                    supportSQLiteStatement.bindString(20, userPocketAssetsDaoEntity2.getShareableRpcInfoReceiverUserId());
                }
                if (userPocketAssetsDaoEntity2.getShareableRpcInfoSharedDate() == null) {
                    supportSQLiteStatement.bindNull(21);
                } else {
                    supportSQLiteStatement.bindLong(21, userPocketAssetsDaoEntity2.getShareableRpcInfoSharedDate().longValue());
                }
                String fromAnyMap = UserPocketAssetsDao_Impl.this.__mapConverter.fromAnyMap(userPocketAssetsDaoEntity2.getExtendInfo());
                if (fromAnyMap == null) {
                    supportSQLiteStatement.bindNull(22);
                } else {
                    supportSQLiteStatement.bindString(22, fromAnyMap);
                }
                if (userPocketAssetsDaoEntity2.getPrimaryCTA() == null) {
                    supportSQLiteStatement.bindNull(23);
                } else {
                    supportSQLiteStatement.bindString(23, userPocketAssetsDaoEntity2.getPrimaryCTA());
                }
                if (userPocketAssetsDaoEntity2.getBackgroundColor() == null) {
                    supportSQLiteStatement.bindNull(24);
                } else {
                    supportSQLiteStatement.bindString(24, userPocketAssetsDaoEntity2.getBackgroundColor());
                }
                if (userPocketAssetsDaoEntity2.getFontColor() == null) {
                    supportSQLiteStatement.bindNull(25);
                } else {
                    supportSQLiteStatement.bindString(25, userPocketAssetsDaoEntity2.getFontColor());
                }
                if (userPocketAssetsDaoEntity2.getMinTransaction() == null) {
                    supportSQLiteStatement.bindNull(26);
                } else {
                    supportSQLiteStatement.bindString(26, userPocketAssetsDaoEntity2.getMinTransaction());
                }
                if (userPocketAssetsDaoEntity2.getCategoryIconUrl() == null) {
                    supportSQLiteStatement.bindNull(27);
                } else {
                    supportSQLiteStatement.bindString(27, userPocketAssetsDaoEntity2.getCategoryIconUrl());
                }
                String fromAnyMap2 = UserPocketAssetsDao_Impl.this.__mapConverter.fromAnyMap(userPocketAssetsDaoEntity2.getBizInfo());
                if (fromAnyMap2 == null) {
                    supportSQLiteStatement.bindNull(28);
                } else {
                    supportSQLiteStatement.bindString(28, fromAnyMap2);
                }
                if (userPocketAssetsDaoEntity2.getCacheTimestamp() == null) {
                    supportSQLiteStatement.bindNull(29);
                } else {
                    supportSQLiteStatement.bindLong(29, userPocketAssetsDaoEntity2.getCacheTimestamp().longValue());
                }
            }
        };
        this.__preparedStmtOfDeleteUserPocketAssets = new SharedSQLiteStatement(roomDatabase) { // from class: id.dana.data.wallet_v3.repository.source.persistence.dao.UserPocketAssetsDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM UserPocketAssetsDaoEntity WHERE pocketId = ?";
            }
        };
        this.__preparedStmtOfClearUserPocketAssets = new SharedSQLiteStatement(roomDatabase) { // from class: id.dana.data.wallet_v3.repository.source.persistence.dao.UserPocketAssetsDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM UserPocketAssetsDaoEntity";
            }
        };
    }

    @Override // id.dana.data.wallet_v3.repository.source.persistence.dao.UserPocketAssetsDao
    public final long[] saveUserPocketAssets(UserPocketAssetsDaoEntity... userPocketAssetsDaoEntityArr) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long[] insertAndReturnIdsArray = this.__insertionAdapterOfUserPocketAssetsDaoEntity.insertAndReturnIdsArray(userPocketAssetsDaoEntityArr);
            this.__db.setTransactionSuccessful();
            return insertAndReturnIdsArray;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // id.dana.data.wallet_v3.repository.source.persistence.dao.UserPocketAssetsDao
    public final int deleteUserPocketAssets(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteUserPocketAssets.acquire();
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
            this.__preparedStmtOfDeleteUserPocketAssets.release(acquire);
        }
    }

    @Override // id.dana.data.wallet_v3.repository.source.persistence.dao.UserPocketAssetsDao
    public final void clearUserPocketAssets() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfClearUserPocketAssets.acquire();
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfClearUserPocketAssets.release(acquire);
        }
    }

    @Override // id.dana.data.wallet_v3.repository.source.persistence.dao.UserPocketAssetsDao
    public final List<UserPocketAssetsDaoEntity> getAllUserPocketAssets(List<String> list, List<String> list2) {
        RoomSQLiteQuery roomSQLiteQuery;
        Boolean valueOf;
        int i;
        Boolean valueOf2;
        int i2;
        int i3;
        String string;
        int i4;
        String string2;
        int i5;
        String string3;
        int i6;
        String string4;
        int i7;
        String string5;
        int i8;
        String string6;
        int i9;
        String string7;
        StringBuilder KClassImpl$Data$declaredNonStaticMembers$2 = StringUtil.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.append("SELECT * FROM UserPocketAssetsDaoEntity WHERE pocketType IN (");
        int size = list.size();
        StringUtil.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, size);
        KClassImpl$Data$declaredNonStaticMembers$2.append(")AND pocketStatus IN (");
        int size2 = list2.size();
        StringUtil.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, size2);
        KClassImpl$Data$declaredNonStaticMembers$2.append(")");
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2.toString(), size + 0 + size2);
        int i10 = 1;
        for (String str : list) {
            if (str == null) {
                authRequestContext.bindNull(i10);
            } else {
                authRequestContext.bindString(i10, str);
            }
            i10++;
        }
        int i11 = size + 1;
        for (String str2 : list2) {
            if (str2 == null) {
                authRequestContext.bindNull(i11);
            } else {
                authRequestContext.bindString(i11, str2);
            }
            i11++;
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$22 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext, false);
        try {
            int authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "pocketId");
            int authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "pocketStatus");
            int authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "iconUrl");
            int authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "backgroundUrl");
            int authRequestContext6 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "pocketType");
            int authRequestContext7 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "userPocketStatus");
            int authRequestContext8 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "activateDate");
            int authRequestContext9 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "howTo");
            int authRequestContext10 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "merchantId");
            int authRequestContext11 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, Constants.ScionAnalytics.PARAM_LABEL);
            int authRequestContext12 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "subLabel");
            int authRequestContext13 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, DecodedScanBizInfoKey.LOGO_URL);
            int authRequestContext14 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "usable");
            roomSQLiteQuery = authRequestContext;
            try {
                int authRequestContext15 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "shareable");
                try {
                    int authRequestContext16 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "goodsId");
                    int authRequestContext17 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "tcUrl");
                    int authRequestContext18 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "expirationDate");
                    int authRequestContext19 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "createdDate");
                    int authRequestContext20 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "shareableRpcInfoReceiverInfo");
                    int authRequestContext21 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "shareableRpcInfoReceiverUserId");
                    int authRequestContext22 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "shareableRpcInfoSharedDate");
                    int authRequestContext23 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "extendInfo");
                    int authRequestContext24 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "primaryCTA");
                    int authRequestContext25 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "backgroundColor");
                    int authRequestContext26 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "fontColor");
                    int authRequestContext27 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "minimumTransaction");
                    int authRequestContext28 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "categoryIconUrl");
                    int authRequestContext29 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "bizInfo");
                    int authRequestContext30 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "cacheTimestamp");
                    int i12 = authRequestContext15;
                    ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$22.getCount());
                    while (KClassImpl$Data$declaredNonStaticMembers$22.moveToNext()) {
                        String string8 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext2) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext2);
                        String string9 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext3) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext3);
                        String string10 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext4) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext4);
                        String string11 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext5) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext5);
                        String string12 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext6) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext6);
                        String string13 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext7) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext7);
                        Long valueOf3 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext8) ? null : Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getLong(authRequestContext8));
                        String string14 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext9) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext9);
                        String string15 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext10) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext10);
                        String string16 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext11) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext11);
                        String string17 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext12) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext12);
                        String string18 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext13) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext13);
                        Integer valueOf4 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext14) ? null : Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getInt(authRequestContext14));
                        if (valueOf4 == null) {
                            i = i12;
                            valueOf = null;
                        } else {
                            valueOf = Boolean.valueOf(valueOf4.intValue() != 0);
                            i = i12;
                        }
                        Integer valueOf5 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(i) ? null : Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getInt(i));
                        if (valueOf5 == null) {
                            valueOf2 = null;
                        } else {
                            valueOf2 = Boolean.valueOf(valueOf5.intValue() != 0);
                        }
                        int i13 = authRequestContext2;
                        int i14 = authRequestContext16;
                        String string19 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(i14) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(i14);
                        int i15 = authRequestContext17;
                        String string20 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(i15) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(i15);
                        int i16 = authRequestContext18;
                        Long valueOf6 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(i16) ? null : Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getLong(i16));
                        int i17 = authRequestContext19;
                        String string21 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(i17) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(i17);
                        int i18 = authRequestContext20;
                        String string22 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(i18) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(i18);
                        int i19 = authRequestContext21;
                        String string23 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(i19) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(i19);
                        int i20 = authRequestContext22;
                        Long valueOf7 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(i20) ? null : Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getLong(i20));
                        int i21 = authRequestContext23;
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i21)) {
                            i2 = i21;
                            i4 = authRequestContext13;
                            i3 = i;
                            string = null;
                        } else {
                            i2 = i21;
                            i3 = i;
                            string = KClassImpl$Data$declaredNonStaticMembers$22.getString(i21);
                            i4 = authRequestContext13;
                        }
                        try {
                            Map<String, Object> fromStringToAny = this.__mapConverter.fromStringToAny(string);
                            int i22 = authRequestContext24;
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i22)) {
                                i5 = authRequestContext25;
                                string2 = null;
                            } else {
                                string2 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i22);
                                i5 = authRequestContext25;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i5)) {
                                authRequestContext24 = i22;
                                i6 = authRequestContext26;
                                string3 = null;
                            } else {
                                string3 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i5);
                                authRequestContext24 = i22;
                                i6 = authRequestContext26;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i6)) {
                                authRequestContext26 = i6;
                                i7 = authRequestContext27;
                                string4 = null;
                            } else {
                                authRequestContext26 = i6;
                                string4 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i6);
                                i7 = authRequestContext27;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i7)) {
                                authRequestContext27 = i7;
                                i8 = authRequestContext28;
                                string5 = null;
                            } else {
                                authRequestContext27 = i7;
                                string5 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i7);
                                i8 = authRequestContext28;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i8)) {
                                authRequestContext28 = i8;
                                i9 = authRequestContext29;
                                string6 = null;
                            } else {
                                authRequestContext28 = i8;
                                string6 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i8);
                                i9 = authRequestContext29;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i9)) {
                                authRequestContext29 = i9;
                                authRequestContext25 = i5;
                                string7 = null;
                            } else {
                                authRequestContext29 = i9;
                                string7 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i9);
                                authRequestContext25 = i5;
                            }
                            Map<String, Object> fromStringToAny2 = this.__mapConverter.fromStringToAny(string7);
                            int i23 = authRequestContext30;
                            arrayList.add(new UserPocketAssetsDaoEntity(string8, string9, string10, string11, string12, string13, valueOf3, string14, string15, string16, string17, string18, valueOf, valueOf2, string19, string20, valueOf6, string21, string22, string23, valueOf7, fromStringToAny, string2, string3, string4, string5, string6, fromStringToAny2, KClassImpl$Data$declaredNonStaticMembers$22.isNull(i23) ? null : Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getLong(i23))));
                            authRequestContext30 = i23;
                            authRequestContext13 = i4;
                            i12 = i3;
                            authRequestContext2 = i13;
                            authRequestContext16 = i14;
                            authRequestContext17 = i15;
                            authRequestContext18 = i16;
                            authRequestContext19 = i17;
                            authRequestContext20 = i18;
                            authRequestContext21 = i19;
                            authRequestContext22 = i20;
                            authRequestContext23 = i2;
                        } catch (Throwable th) {
                            th = th;
                            KClassImpl$Data$declaredNonStaticMembers$22.close();
                            roomSQLiteQuery.MyBillsEntityDataFactory();
                            throw th;
                        }
                    }
                    KClassImpl$Data$declaredNonStaticMembers$22.close();
                    roomSQLiteQuery.MyBillsEntityDataFactory();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            roomSQLiteQuery = authRequestContext;
        }
    }

    @Override // id.dana.data.wallet_v3.repository.source.persistence.dao.UserPocketAssetsDao
    public final List<UserPocketAssetsDaoEntity> getFilteredUserPocketAssets(List<String> list, String str, List<String> list2) {
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
        Boolean valueOf;
        int i;
        Boolean valueOf2;
        String string;
        int i2;
        int i3;
        String str2;
        Long valueOf3;
        int i4;
        String string2;
        int i5;
        String string3;
        int i6;
        String string4;
        int i7;
        Long valueOf4;
        int i8;
        int i9;
        int i10;
        String string5;
        int i11;
        String string6;
        int i12;
        String string7;
        int i13;
        String string8;
        int i14;
        String string9;
        int i15;
        String string10;
        int i16;
        String string11;
        StringBuilder KClassImpl$Data$declaredNonStaticMembers$2 = StringUtil.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.append("SELECT * FROM (SELECT * FROM UserPocketAssetsDaoEntity WHERE pocketType in (");
        int size = list.size();
        StringUtil.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, size);
        KClassImpl$Data$declaredNonStaticMembers$2.append(") AND pocketStatus IN (");
        int size2 = list2.size();
        StringUtil.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, size2);
        KClassImpl$Data$declaredNonStaticMembers$2.append(")) WHERE pocketType LIKE '%' || ");
        KClassImpl$Data$declaredNonStaticMembers$2.append("?");
        KClassImpl$Data$declaredNonStaticMembers$2.append(" || '%'OR label LIKE '%' || ");
        KClassImpl$Data$declaredNonStaticMembers$2.append("?");
        KClassImpl$Data$declaredNonStaticMembers$2.append(" || '%'");
        int i17 = size + 2 + size2;
        RoomSQLiteQuery authRequestContext14 = RoomSQLiteQuery.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2.toString(), i17);
        int i18 = 1;
        for (String str3 : list) {
            if (str3 == null) {
                authRequestContext14.bindNull(i18);
            } else {
                authRequestContext14.bindString(i18, str3);
            }
            i18++;
        }
        int i19 = size + 1;
        int i20 = i19;
        for (String str4 : list2) {
            if (str4 == null) {
                authRequestContext14.bindNull(i20);
            } else {
                authRequestContext14.bindString(i20, str4);
            }
            i20++;
        }
        int i21 = i19 + size2;
        if (str == null) {
            authRequestContext14.bindNull(i21);
        } else {
            authRequestContext14.bindString(i21, str);
        }
        if (str == null) {
            authRequestContext14.bindNull(i17);
        } else {
            authRequestContext14.bindString(i17, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$22 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext14, false);
        try {
            authRequestContext = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "pocketId");
            authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "pocketStatus");
            authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "iconUrl");
            authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "backgroundUrl");
            authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "pocketType");
            authRequestContext6 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "userPocketStatus");
            authRequestContext7 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "activateDate");
            authRequestContext8 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "howTo");
            authRequestContext9 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "merchantId");
            authRequestContext10 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, Constants.ScionAnalytics.PARAM_LABEL);
            authRequestContext11 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "subLabel");
            authRequestContext12 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, DecodedScanBizInfoKey.LOGO_URL);
            authRequestContext13 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "usable");
            roomSQLiteQuery = authRequestContext14;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = authRequestContext14;
        }
        try {
            int authRequestContext15 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "shareable");
            try {
                int authRequestContext16 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "goodsId");
                int authRequestContext17 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "tcUrl");
                int authRequestContext18 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "expirationDate");
                int authRequestContext19 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "createdDate");
                int authRequestContext20 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "shareableRpcInfoReceiverInfo");
                int authRequestContext21 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "shareableRpcInfoReceiverUserId");
                int authRequestContext22 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "shareableRpcInfoSharedDate");
                int authRequestContext23 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "extendInfo");
                int authRequestContext24 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "primaryCTA");
                int authRequestContext25 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "backgroundColor");
                int authRequestContext26 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "fontColor");
                int authRequestContext27 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "minimumTransaction");
                int authRequestContext28 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "categoryIconUrl");
                int authRequestContext29 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "bizInfo");
                int authRequestContext30 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "cacheTimestamp");
                int i22 = authRequestContext15;
                ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$22.getCount());
                while (KClassImpl$Data$declaredNonStaticMembers$22.moveToNext()) {
                    String string12 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext);
                    String string13 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext2) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext2);
                    String string14 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext3) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext3);
                    String string15 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext4) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext4);
                    String string16 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext5) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext5);
                    String string17 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext6) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext6);
                    Long valueOf5 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext7) ? null : Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getLong(authRequestContext7));
                    String string18 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext8) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext8);
                    String string19 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext9) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext9);
                    String string20 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext10) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext10);
                    String string21 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext11) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext11);
                    String string22 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext12) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext12);
                    Integer valueOf6 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext13) ? null : Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getInt(authRequestContext13));
                    if (valueOf6 == null) {
                        i = i22;
                        valueOf = null;
                    } else {
                        valueOf = Boolean.valueOf(valueOf6.intValue() != 0);
                        i = i22;
                    }
                    Integer valueOf7 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(i) ? null : Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getInt(i));
                    if (valueOf7 == null) {
                        valueOf2 = null;
                    } else {
                        valueOf2 = Boolean.valueOf(valueOf7.intValue() != 0);
                    }
                    int i23 = authRequestContext;
                    int i24 = authRequestContext16;
                    if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i24)) {
                        i2 = i24;
                        string = null;
                    } else {
                        string = KClassImpl$Data$declaredNonStaticMembers$22.getString(i24);
                        i2 = i24;
                    }
                    int i25 = authRequestContext17;
                    if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i25)) {
                        authRequestContext17 = i25;
                        i3 = authRequestContext18;
                        str2 = null;
                    } else {
                        String string23 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i25);
                        authRequestContext17 = i25;
                        i3 = authRequestContext18;
                        str2 = string23;
                    }
                    if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i3)) {
                        authRequestContext18 = i3;
                        i4 = authRequestContext19;
                        valueOf3 = null;
                    } else {
                        valueOf3 = Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getLong(i3));
                        authRequestContext18 = i3;
                        i4 = authRequestContext19;
                    }
                    if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i4)) {
                        authRequestContext19 = i4;
                        i5 = authRequestContext20;
                        string2 = null;
                    } else {
                        string2 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i4);
                        authRequestContext19 = i4;
                        i5 = authRequestContext20;
                    }
                    if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i5)) {
                        authRequestContext20 = i5;
                        i6 = authRequestContext21;
                        string3 = null;
                    } else {
                        string3 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i5);
                        authRequestContext20 = i5;
                        i6 = authRequestContext21;
                    }
                    if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i6)) {
                        authRequestContext21 = i6;
                        i7 = authRequestContext22;
                        string4 = null;
                    } else {
                        string4 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i6);
                        authRequestContext21 = i6;
                        i7 = authRequestContext22;
                    }
                    if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i7)) {
                        authRequestContext22 = i7;
                        i8 = authRequestContext23;
                        valueOf4 = null;
                    } else {
                        valueOf4 = Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getLong(i7));
                        authRequestContext22 = i7;
                        i8 = authRequestContext23;
                    }
                    if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i8)) {
                        i9 = i8;
                        i11 = i;
                        i10 = authRequestContext12;
                        string5 = null;
                    } else {
                        i9 = i8;
                        i10 = authRequestContext12;
                        string5 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i8);
                        i11 = i;
                    }
                    try {
                        Map<String, Object> fromStringToAny = this.__mapConverter.fromStringToAny(string5);
                        int i26 = authRequestContext24;
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i26)) {
                            i12 = authRequestContext25;
                            string6 = null;
                        } else {
                            string6 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i26);
                            i12 = authRequestContext25;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i12)) {
                            authRequestContext24 = i26;
                            i13 = authRequestContext26;
                            string7 = null;
                        } else {
                            string7 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i12);
                            authRequestContext24 = i26;
                            i13 = authRequestContext26;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i13)) {
                            authRequestContext26 = i13;
                            i14 = authRequestContext27;
                            string8 = null;
                        } else {
                            authRequestContext26 = i13;
                            string8 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i13);
                            i14 = authRequestContext27;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i14)) {
                            authRequestContext27 = i14;
                            i15 = authRequestContext28;
                            string9 = null;
                        } else {
                            authRequestContext27 = i14;
                            string9 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i14);
                            i15 = authRequestContext28;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i15)) {
                            authRequestContext28 = i15;
                            i16 = authRequestContext29;
                            string10 = null;
                        } else {
                            authRequestContext28 = i15;
                            string10 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i15);
                            i16 = authRequestContext29;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i16)) {
                            authRequestContext29 = i16;
                            authRequestContext25 = i12;
                            string11 = null;
                        } else {
                            authRequestContext29 = i16;
                            string11 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i16);
                            authRequestContext25 = i12;
                        }
                        Map<String, Object> fromStringToAny2 = this.__mapConverter.fromStringToAny(string11);
                        int i27 = authRequestContext30;
                        arrayList.add(new UserPocketAssetsDaoEntity(string12, string13, string14, string15, string16, string17, valueOf5, string18, string19, string20, string21, string22, valueOf, valueOf2, string, str2, valueOf3, string2, string3, string4, valueOf4, fromStringToAny, string6, string7, string8, string9, string10, fromStringToAny2, KClassImpl$Data$declaredNonStaticMembers$22.isNull(i27) ? null : Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getLong(i27))));
                        authRequestContext30 = i27;
                        authRequestContext12 = i10;
                        authRequestContext = i23;
                        authRequestContext16 = i2;
                        i22 = i11;
                        authRequestContext23 = i9;
                    } catch (Throwable th2) {
                        th = th2;
                        KClassImpl$Data$declaredNonStaticMembers$22.close();
                        roomSQLiteQuery.MyBillsEntityDataFactory();
                        throw th;
                    }
                }
                KClassImpl$Data$declaredNonStaticMembers$22.close();
                roomSQLiteQuery.MyBillsEntityDataFactory();
                return arrayList;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            KClassImpl$Data$declaredNonStaticMembers$22.close();
            roomSQLiteQuery.MyBillsEntityDataFactory();
            throw th;
        }
    }

    @Override // id.dana.data.wallet_v3.repository.source.persistence.dao.UserPocketAssetsDao
    public final List<UserPocketAssetsDaoEntity> searchUserPocketAssets(String str, List<String> list, List<String> list2) {
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
        Boolean valueOf;
        int i;
        Boolean valueOf2;
        int i2;
        int i3;
        String string;
        String string2;
        int i4;
        String string3;
        int i5;
        String string4;
        int i6;
        String string5;
        int i7;
        String string6;
        int i8;
        String string7;
        StringBuilder KClassImpl$Data$declaredNonStaticMembers$2 = StringUtil.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.append("SELECT * FROM UserPocketAssetsDaoEntity WHERE pocketType IN (");
        int size = list.size();
        StringUtil.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, size);
        KClassImpl$Data$declaredNonStaticMembers$2.append(")AND label LIKE '%' || ");
        KClassImpl$Data$declaredNonStaticMembers$2.append("?");
        KClassImpl$Data$declaredNonStaticMembers$2.append(" || '%' AND pocketStatus IN (");
        int size2 = list2.size();
        StringUtil.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, size2);
        KClassImpl$Data$declaredNonStaticMembers$2.append(")");
        int i9 = size + 1;
        RoomSQLiteQuery authRequestContext14 = RoomSQLiteQuery.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2.toString(), size2 + i9);
        int i10 = 1;
        for (String str2 : list) {
            if (str2 == null) {
                authRequestContext14.bindNull(i10);
            } else {
                authRequestContext14.bindString(i10, str2);
            }
            i10++;
        }
        if (str == null) {
            authRequestContext14.bindNull(i9);
        } else {
            authRequestContext14.bindString(i9, str);
        }
        int i11 = size + 2;
        for (String str3 : list2) {
            if (str3 == null) {
                authRequestContext14.bindNull(i11);
            } else {
                authRequestContext14.bindString(i11, str3);
            }
            i11++;
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$22 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext14, false);
        try {
            authRequestContext = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "pocketId");
            authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "pocketStatus");
            authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "iconUrl");
            authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "backgroundUrl");
            authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "pocketType");
            authRequestContext6 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "userPocketStatus");
            authRequestContext7 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "activateDate");
            authRequestContext8 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "howTo");
            authRequestContext9 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "merchantId");
            authRequestContext10 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, Constants.ScionAnalytics.PARAM_LABEL);
            authRequestContext11 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "subLabel");
            authRequestContext12 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, DecodedScanBizInfoKey.LOGO_URL);
            authRequestContext13 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "usable");
            roomSQLiteQuery = authRequestContext14;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = authRequestContext14;
        }
        try {
            int authRequestContext15 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "shareable");
            try {
                int authRequestContext16 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "goodsId");
                int authRequestContext17 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "tcUrl");
                int authRequestContext18 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "expirationDate");
                int authRequestContext19 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "createdDate");
                int authRequestContext20 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "shareableRpcInfoReceiverInfo");
                int authRequestContext21 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "shareableRpcInfoReceiverUserId");
                int authRequestContext22 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "shareableRpcInfoSharedDate");
                int authRequestContext23 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "extendInfo");
                int authRequestContext24 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "primaryCTA");
                int authRequestContext25 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "backgroundColor");
                int authRequestContext26 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "fontColor");
                int authRequestContext27 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "minimumTransaction");
                int authRequestContext28 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "categoryIconUrl");
                int authRequestContext29 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "bizInfo");
                int authRequestContext30 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "cacheTimestamp");
                int i12 = authRequestContext15;
                ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$22.getCount());
                while (KClassImpl$Data$declaredNonStaticMembers$22.moveToNext()) {
                    String string8 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext);
                    String string9 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext2) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext2);
                    String string10 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext3) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext3);
                    String string11 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext4) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext4);
                    String string12 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext5) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext5);
                    String string13 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext6) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext6);
                    Long valueOf3 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext7) ? null : Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getLong(authRequestContext7));
                    String string14 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext8) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext8);
                    String string15 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext9) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext9);
                    String string16 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext10) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext10);
                    String string17 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext11) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext11);
                    String string18 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext12) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext12);
                    Integer valueOf4 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext13) ? null : Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getInt(authRequestContext13));
                    if (valueOf4 == null) {
                        i = i12;
                        valueOf = null;
                    } else {
                        valueOf = Boolean.valueOf(valueOf4.intValue() != 0);
                        i = i12;
                    }
                    Integer valueOf5 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(i) ? null : Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getInt(i));
                    if (valueOf5 == null) {
                        valueOf2 = null;
                    } else {
                        valueOf2 = Boolean.valueOf(valueOf5.intValue() != 0);
                    }
                    int i13 = authRequestContext;
                    int i14 = authRequestContext16;
                    String string19 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(i14) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(i14);
                    int i15 = authRequestContext17;
                    String string20 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(i15) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(i15);
                    int i16 = authRequestContext18;
                    Long valueOf6 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(i16) ? null : Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getLong(i16));
                    int i17 = authRequestContext19;
                    String string21 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(i17) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(i17);
                    int i18 = authRequestContext20;
                    String string22 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(i18) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(i18);
                    int i19 = authRequestContext21;
                    String string23 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(i19) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(i19);
                    int i20 = authRequestContext22;
                    Long valueOf7 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(i20) ? null : Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getLong(i20));
                    int i21 = authRequestContext23;
                    if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i21)) {
                        i2 = i21;
                        i12 = i;
                        i3 = authRequestContext12;
                        string = null;
                    } else {
                        i2 = i21;
                        i3 = authRequestContext12;
                        string = KClassImpl$Data$declaredNonStaticMembers$22.getString(i21);
                        i12 = i;
                    }
                    try {
                        Map<String, Object> fromStringToAny = this.__mapConverter.fromStringToAny(string);
                        int i22 = authRequestContext24;
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i22)) {
                            i4 = authRequestContext25;
                            string2 = null;
                        } else {
                            string2 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i22);
                            i4 = authRequestContext25;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i4)) {
                            authRequestContext24 = i22;
                            i5 = authRequestContext26;
                            string3 = null;
                        } else {
                            string3 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i4);
                            authRequestContext24 = i22;
                            i5 = authRequestContext26;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i5)) {
                            authRequestContext26 = i5;
                            i6 = authRequestContext27;
                            string4 = null;
                        } else {
                            authRequestContext26 = i5;
                            string4 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i5);
                            i6 = authRequestContext27;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i6)) {
                            authRequestContext27 = i6;
                            i7 = authRequestContext28;
                            string5 = null;
                        } else {
                            authRequestContext27 = i6;
                            string5 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i6);
                            i7 = authRequestContext28;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i7)) {
                            authRequestContext28 = i7;
                            i8 = authRequestContext29;
                            string6 = null;
                        } else {
                            authRequestContext28 = i7;
                            string6 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i7);
                            i8 = authRequestContext29;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i8)) {
                            authRequestContext29 = i8;
                            authRequestContext25 = i4;
                            string7 = null;
                        } else {
                            authRequestContext29 = i8;
                            string7 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i8);
                            authRequestContext25 = i4;
                        }
                        Map<String, Object> fromStringToAny2 = this.__mapConverter.fromStringToAny(string7);
                        int i23 = authRequestContext30;
                        arrayList.add(new UserPocketAssetsDaoEntity(string8, string9, string10, string11, string12, string13, valueOf3, string14, string15, string16, string17, string18, valueOf, valueOf2, string19, string20, valueOf6, string21, string22, string23, valueOf7, fromStringToAny, string2, string3, string4, string5, string6, fromStringToAny2, KClassImpl$Data$declaredNonStaticMembers$22.isNull(i23) ? null : Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getLong(i23))));
                        authRequestContext30 = i23;
                        authRequestContext12 = i3;
                        authRequestContext = i13;
                        authRequestContext16 = i14;
                        authRequestContext17 = i15;
                        authRequestContext18 = i16;
                        authRequestContext19 = i17;
                        authRequestContext20 = i18;
                        authRequestContext21 = i19;
                        authRequestContext22 = i20;
                        authRequestContext23 = i2;
                    } catch (Throwable th2) {
                        th = th2;
                        KClassImpl$Data$declaredNonStaticMembers$22.close();
                        roomSQLiteQuery.MyBillsEntityDataFactory();
                        throw th;
                    }
                }
                KClassImpl$Data$declaredNonStaticMembers$22.close();
                roomSQLiteQuery.MyBillsEntityDataFactory();
                return arrayList;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            KClassImpl$Data$declaredNonStaticMembers$22.close();
            roomSQLiteQuery.MyBillsEntityDataFactory();
            throw th;
        }
    }

    @Override // id.dana.data.wallet_v3.repository.source.persistence.dao.UserPocketAssetsDao
    public final List<String> getSavedAssetTypes(List<String> list) {
        StringBuilder KClassImpl$Data$declaredNonStaticMembers$2 = StringUtil.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.append("SELECT DISTINCT pocketType FROM UserPocketAssetsDaoEntity WHERE pocketStatus IN (");
        int size = list.size();
        StringUtil.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, size);
        KClassImpl$Data$declaredNonStaticMembers$2.append(") ");
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2.toString(), size + 0);
        int i = 1;
        for (String str : list) {
            if (str == null) {
                authRequestContext.bindNull(i);
            } else {
                authRequestContext.bindString(i, str);
            }
            i++;
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$22 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext, false);
        try {
            ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$22.getCount());
            while (KClassImpl$Data$declaredNonStaticMembers$22.moveToNext()) {
                arrayList.add(KClassImpl$Data$declaredNonStaticMembers$22.isNull(0) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(0));
            }
            return arrayList;
        } finally {
            KClassImpl$Data$declaredNonStaticMembers$22.close();
            authRequestContext.MyBillsEntityDataFactory();
        }
    }

    @Override // id.dana.data.wallet_v3.repository.source.persistence.dao.UserPocketAssetsDao
    public final List<String> getUserPocketViaQuery(SupportSQLiteQuery supportSQLiteQuery) {
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
