package id.dana.data.home.repository.source.presistence.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.alipay.imobile.network.quake.transport.http.constant.HeaderConstant;
import id.dana.data.home.repository.source.presistence.entity.PromoBannerContentDaoEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes8.dex */
public final class PromoBannerContentDao_Impl implements PromoBannerContentDao {
    private final RoomDatabase KClassImpl$Data$declaredNonStaticMembers$2;
    private final SharedSQLiteStatement PlaceComponentResult;
    private final EntityInsertionAdapter<PromoBannerContentDaoEntity> getAuthRequestContext;

    public PromoBannerContentDao_Impl(RoomDatabase roomDatabase) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = roomDatabase;
        this.getAuthRequestContext = new EntityInsertionAdapter<PromoBannerContentDaoEntity>(roomDatabase) { // from class: id.dana.data.home.repository.source.presistence.dao.PromoBannerContentDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `PromoBannerContentDaoEntity` (`bizType`,`contentId`,`contentName`,`contentType`,`contentValue`,`effectiveDate`,`envType`,`expireDate`,`gmtCreate`,`gmtModified`,`language`,`priority`,`redirectUrl`,`selectRule`,`spaceCode`,`status`,`tenantId`,`extendInfo`,`orderNo`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public /* synthetic */ void bind(SupportSQLiteStatement supportSQLiteStatement, PromoBannerContentDaoEntity promoBannerContentDaoEntity) {
                PromoBannerContentDaoEntity promoBannerContentDaoEntity2 = promoBannerContentDaoEntity;
                if (promoBannerContentDaoEntity2.BuiltInFictitiousFunctionClassFactory == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, promoBannerContentDaoEntity2.BuiltInFictitiousFunctionClassFactory);
                }
                if (promoBannerContentDaoEntity2.getAuthRequestContext == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, promoBannerContentDaoEntity2.getAuthRequestContext);
                }
                if (promoBannerContentDaoEntity2.MyBillsEntityDataFactory == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, promoBannerContentDaoEntity2.MyBillsEntityDataFactory);
                }
                if (promoBannerContentDaoEntity2.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, promoBannerContentDaoEntity2.KClassImpl$Data$declaredNonStaticMembers$2);
                }
                if (promoBannerContentDaoEntity2.PlaceComponentResult == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, promoBannerContentDaoEntity2.PlaceComponentResult);
                }
                if (promoBannerContentDaoEntity2.moveToNextValue == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, promoBannerContentDaoEntity2.moveToNextValue);
                }
                if (promoBannerContentDaoEntity2.getErrorConfigVersion == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, promoBannerContentDaoEntity2.getErrorConfigVersion);
                }
                if (promoBannerContentDaoEntity2.scheduleImpl == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, promoBannerContentDaoEntity2.scheduleImpl);
                }
                if (promoBannerContentDaoEntity2.lookAheadTest == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, promoBannerContentDaoEntity2.lookAheadTest);
                }
                if (promoBannerContentDaoEntity2.NetworkUserEntityData$$ExternalSyntheticLambda1 == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, promoBannerContentDaoEntity2.NetworkUserEntityData$$ExternalSyntheticLambda1);
                }
                if (promoBannerContentDaoEntity2.DatabaseTableConfigUtil == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindString(11, promoBannerContentDaoEntity2.DatabaseTableConfigUtil);
                }
                if (promoBannerContentDaoEntity2.GetContactSyncConfig == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindLong(12, promoBannerContentDaoEntity2.GetContactSyncConfig.intValue());
                }
                if (promoBannerContentDaoEntity2.NetworkUserEntityData$$ExternalSyntheticLambda2 == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindString(13, promoBannerContentDaoEntity2.NetworkUserEntityData$$ExternalSyntheticLambda2);
                }
                if (promoBannerContentDaoEntity2.PrepareContext == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindString(14, promoBannerContentDaoEntity2.PrepareContext);
                }
                if (promoBannerContentDaoEntity2.newProxyInstance == null) {
                    supportSQLiteStatement.bindNull(15);
                } else {
                    supportSQLiteStatement.bindString(15, promoBannerContentDaoEntity2.newProxyInstance);
                }
                if (promoBannerContentDaoEntity2.isLayoutRequested == null) {
                    supportSQLiteStatement.bindNull(16);
                } else {
                    supportSQLiteStatement.bindString(16, promoBannerContentDaoEntity2.isLayoutRequested);
                }
                if (promoBannerContentDaoEntity2.NetworkUserEntityData$$ExternalSyntheticLambda8 == null) {
                    supportSQLiteStatement.bindNull(17);
                } else {
                    supportSQLiteStatement.bindString(17, promoBannerContentDaoEntity2.NetworkUserEntityData$$ExternalSyntheticLambda8);
                }
                if (promoBannerContentDaoEntity2.NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
                    supportSQLiteStatement.bindNull(18);
                } else {
                    supportSQLiteStatement.bindString(18, promoBannerContentDaoEntity2.NetworkUserEntityData$$ExternalSyntheticLambda0);
                }
                supportSQLiteStatement.bindLong(19, promoBannerContentDaoEntity2.initRecordTimeStamp);
            }
        };
        this.PlaceComponentResult = new SharedSQLiteStatement(roomDatabase) { // from class: id.dana.data.home.repository.source.presistence.dao.PromoBannerContentDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM PromoBannerContentDaoEntity";
            }
        };
    }

    @Override // id.dana.data.home.repository.source.presistence.dao.PromoBannerContentDao
    public final long[] KClassImpl$Data$declaredNonStaticMembers$2(PromoBannerContentDaoEntity... promoBannerContentDaoEntityArr) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.assertNotSuspendingTransaction();
        this.KClassImpl$Data$declaredNonStaticMembers$2.beginTransaction();
        try {
            long[] insertAndReturnIdsArray = this.getAuthRequestContext.insertAndReturnIdsArray(promoBannerContentDaoEntityArr);
            this.KClassImpl$Data$declaredNonStaticMembers$2.setTransactionSuccessful();
            return insertAndReturnIdsArray;
        } finally {
            this.KClassImpl$Data$declaredNonStaticMembers$2.endTransaction();
        }
    }

    @Override // id.dana.data.home.repository.source.presistence.dao.PromoBannerContentDao
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.PlaceComponentResult.acquire();
        this.KClassImpl$Data$declaredNonStaticMembers$2.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.KClassImpl$Data$declaredNonStaticMembers$2.setTransactionSuccessful();
        } finally {
            this.KClassImpl$Data$declaredNonStaticMembers$2.endTransaction();
            this.PlaceComponentResult.release(acquire);
        }
    }

    @Override // id.dana.data.home.repository.source.presistence.dao.PromoBannerContentDao
    public final List<PromoBannerContentDaoEntity> KClassImpl$Data$declaredNonStaticMembers$2() {
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
        RoomSQLiteQuery authRequestContext15 = RoomSQLiteQuery.getAuthRequestContext("SELECT * FROM PromoBannerContentDaoEntity ORDER BY orderNo", 0);
        this.KClassImpl$Data$declaredNonStaticMembers$2.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, authRequestContext15, false);
        try {
            authRequestContext = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "bizType");
            authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "contentId");
            authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "contentName");
            authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "contentType");
            authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "contentValue");
            authRequestContext6 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "effectiveDate");
            authRequestContext7 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "envType");
            authRequestContext8 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "expireDate");
            authRequestContext9 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "gmtCreate");
            authRequestContext10 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "gmtModified");
            authRequestContext11 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "language");
            authRequestContext12 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "priority");
            authRequestContext13 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "redirectUrl");
            authRequestContext14 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "selectRule");
            roomSQLiteQuery = authRequestContext15;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = authRequestContext15;
        }
        try {
            int authRequestContext16 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "spaceCode");
            int authRequestContext17 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "status");
            int authRequestContext18 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, HeaderConstant.HEADER_KEY_TENANT_ID);
            int authRequestContext19 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "extendInfo");
            int authRequestContext20 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "orderNo");
            int i2 = authRequestContext14;
            ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
            while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                String string2 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext);
                String string3 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext2) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2);
                String string4 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext3) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext3);
                String string5 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext4) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext4);
                String string6 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext5) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext5);
                String string7 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext6) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext6);
                String string8 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext7) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext7);
                String string9 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext8) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext8);
                String string10 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext9) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext9);
                String string11 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext10) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext10);
                String string12 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext11) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext11);
                Integer valueOf = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext12) ? null : Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext12));
                if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext13)) {
                    i = i2;
                    string = null;
                } else {
                    string = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext13);
                    i = i2;
                }
                String string13 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(i) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(i);
                int i3 = authRequestContext16;
                int i4 = authRequestContext;
                String string14 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(i3) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(i3);
                int i5 = authRequestContext17;
                String string15 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(i5) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(i5);
                int i6 = authRequestContext18;
                String string16 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(i6) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(i6);
                int i7 = authRequestContext19;
                String string17 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(i7) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(i7);
                int i8 = authRequestContext20;
                arrayList.add(new PromoBannerContentDaoEntity(string2, string3, string4, string5, string6, string7, string8, string9, string10, string11, string12, valueOf, string, string13, string14, string15, string16, string17, KClassImpl$Data$declaredNonStaticMembers$2.getInt(i8)));
                authRequestContext = i4;
                authRequestContext16 = i3;
                authRequestContext17 = i5;
                authRequestContext18 = i6;
                authRequestContext19 = i7;
                authRequestContext20 = i8;
                i2 = i;
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

    @Override // id.dana.data.home.repository.source.presistence.dao.PromoBannerContentDao
    public final void getAuthRequestContext(List<String> list) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.assertNotSuspendingTransaction();
        StringBuilder KClassImpl$Data$declaredNonStaticMembers$2 = StringUtil.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.append("DELETE FROM PromoBannerContentDaoEntity WHERE contentId in (");
        StringUtil.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, list.size());
        KClassImpl$Data$declaredNonStaticMembers$2.append(")");
        SupportSQLiteStatement compileStatement = this.KClassImpl$Data$declaredNonStaticMembers$2.compileStatement(KClassImpl$Data$declaredNonStaticMembers$2.toString());
        int i = 1;
        for (String str : list) {
            if (str == null) {
                compileStatement.bindNull(i);
            } else {
                compileStatement.bindString(i, str);
            }
            i++;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.beginTransaction();
        try {
            compileStatement.executeUpdateDelete();
            this.KClassImpl$Data$declaredNonStaticMembers$2.setTransactionSuccessful();
        } finally {
            this.KClassImpl$Data$declaredNonStaticMembers$2.endTransaction();
        }
    }

    public static List<Class<?>> getAuthRequestContext() {
        return Collections.emptyList();
    }
}
