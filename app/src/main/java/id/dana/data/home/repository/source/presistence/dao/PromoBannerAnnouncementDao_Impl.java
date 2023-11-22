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
import id.dana.data.home.repository.source.presistence.entity.PromoBannerAnnouncementDaoEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes8.dex */
public final class PromoBannerAnnouncementDao_Impl implements PromoBannerAnnouncementDao {
    private final RoomDatabase BuiltInFictitiousFunctionClassFactory;
    private final EntityInsertionAdapter<PromoBannerAnnouncementDaoEntity> PlaceComponentResult;
    private final SharedSQLiteStatement getAuthRequestContext;

    public PromoBannerAnnouncementDao_Impl(RoomDatabase roomDatabase) {
        this.BuiltInFictitiousFunctionClassFactory = roomDatabase;
        this.PlaceComponentResult = new EntityInsertionAdapter<PromoBannerAnnouncementDaoEntity>(roomDatabase) { // from class: id.dana.data.home.repository.source.presistence.dao.PromoBannerAnnouncementDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `PromoBannerAnnouncementDaoEntity` (`subscriptionId`,`contentName`,`contentType`,`contentValue`,`redirectUrl`,`subMerchantId`,`title`,`subtitle`,`goodsName`,`goodsType`,`subscriptionDueDate`,`paymentStatus`,`totalAmount`,`iconUrl`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public /* synthetic */ void bind(SupportSQLiteStatement supportSQLiteStatement, PromoBannerAnnouncementDaoEntity promoBannerAnnouncementDaoEntity) {
                PromoBannerAnnouncementDaoEntity promoBannerAnnouncementDaoEntity2 = promoBannerAnnouncementDaoEntity;
                if (promoBannerAnnouncementDaoEntity2.initRecordTimeStamp == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, promoBannerAnnouncementDaoEntity2.initRecordTimeStamp);
                }
                if (promoBannerAnnouncementDaoEntity2.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, promoBannerAnnouncementDaoEntity2.KClassImpl$Data$declaredNonStaticMembers$2);
                }
                if (promoBannerAnnouncementDaoEntity2.MyBillsEntityDataFactory == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, promoBannerAnnouncementDaoEntity2.MyBillsEntityDataFactory);
                }
                if (promoBannerAnnouncementDaoEntity2.getAuthRequestContext == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, promoBannerAnnouncementDaoEntity2.getAuthRequestContext);
                }
                if (promoBannerAnnouncementDaoEntity2.lookAheadTest == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, promoBannerAnnouncementDaoEntity2.lookAheadTest);
                }
                if (promoBannerAnnouncementDaoEntity2.getErrorConfigVersion == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, promoBannerAnnouncementDaoEntity2.getErrorConfigVersion);
                }
                if (promoBannerAnnouncementDaoEntity2.NetworkUserEntityData$$ExternalSyntheticLambda2 == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, promoBannerAnnouncementDaoEntity2.NetworkUserEntityData$$ExternalSyntheticLambda2);
                }
                if (promoBannerAnnouncementDaoEntity2.GetContactSyncConfig == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, promoBannerAnnouncementDaoEntity2.GetContactSyncConfig);
                }
                if (promoBannerAnnouncementDaoEntity2.BuiltInFictitiousFunctionClassFactory == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, promoBannerAnnouncementDaoEntity2.BuiltInFictitiousFunctionClassFactory);
                }
                if (promoBannerAnnouncementDaoEntity2.PlaceComponentResult == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, promoBannerAnnouncementDaoEntity2.PlaceComponentResult);
                }
                if (promoBannerAnnouncementDaoEntity2.NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindString(11, promoBannerAnnouncementDaoEntity2.NetworkUserEntityData$$ExternalSyntheticLambda0);
                }
                if (promoBannerAnnouncementDaoEntity2.moveToNextValue == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindString(12, promoBannerAnnouncementDaoEntity2.moveToNextValue);
                }
                if (promoBannerAnnouncementDaoEntity2.NetworkUserEntityData$$ExternalSyntheticLambda1 == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindString(13, promoBannerAnnouncementDaoEntity2.NetworkUserEntityData$$ExternalSyntheticLambda1);
                }
                if (promoBannerAnnouncementDaoEntity2.scheduleImpl == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindString(14, promoBannerAnnouncementDaoEntity2.scheduleImpl);
                }
            }
        };
        this.getAuthRequestContext = new SharedSQLiteStatement(roomDatabase) { // from class: id.dana.data.home.repository.source.presistence.dao.PromoBannerAnnouncementDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM PromoBannerAnnouncementDaoEntity";
            }
        };
    }

    @Override // id.dana.data.home.repository.source.presistence.dao.PromoBannerAnnouncementDao
    public final long[] getAuthRequestContext(PromoBannerAnnouncementDaoEntity... promoBannerAnnouncementDaoEntityArr) {
        this.BuiltInFictitiousFunctionClassFactory.assertNotSuspendingTransaction();
        this.BuiltInFictitiousFunctionClassFactory.beginTransaction();
        try {
            long[] insertAndReturnIdsArray = this.PlaceComponentResult.insertAndReturnIdsArray(promoBannerAnnouncementDaoEntityArr);
            this.BuiltInFictitiousFunctionClassFactory.setTransactionSuccessful();
            return insertAndReturnIdsArray;
        } finally {
            this.BuiltInFictitiousFunctionClassFactory.endTransaction();
        }
    }

    @Override // id.dana.data.home.repository.source.presistence.dao.PromoBannerAnnouncementDao
    public final void getAuthRequestContext() {
        this.BuiltInFictitiousFunctionClassFactory.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.getAuthRequestContext.acquire();
        this.BuiltInFictitiousFunctionClassFactory.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.BuiltInFictitiousFunctionClassFactory.setTransactionSuccessful();
        } finally {
            this.BuiltInFictitiousFunctionClassFactory.endTransaction();
            this.getAuthRequestContext.release(acquire);
        }
    }

    @Override // id.dana.data.home.repository.source.presistence.dao.PromoBannerAnnouncementDao
    public final List<PromoBannerAnnouncementDaoEntity> PlaceComponentResult() {
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
        String string;
        int i;
        RoomSQLiteQuery authRequestContext14 = RoomSQLiteQuery.getAuthRequestContext("SELECT * FROM PromoBannerAnnouncementDaoEntity", 0);
        this.BuiltInFictitiousFunctionClassFactory.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, authRequestContext14, false);
        try {
            authRequestContext = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "subscriptionId");
            authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "contentName");
            authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "contentType");
            authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "contentValue");
            authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "redirectUrl");
            authRequestContext6 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "subMerchantId");
            authRequestContext7 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "title");
            authRequestContext8 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "subtitle");
            authRequestContext9 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "goodsName");
            authRequestContext10 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "goodsType");
            authRequestContext11 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "subscriptionDueDate");
            authRequestContext12 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "paymentStatus");
            authRequestContext13 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "totalAmount");
            roomSQLiteQuery = authRequestContext14;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = authRequestContext14;
        }
        try {
            int authRequestContext15 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "iconUrl");
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
                String string13 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext12) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext12);
                if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext13)) {
                    i = authRequestContext15;
                    string = null;
                } else {
                    string = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext13);
                    i = authRequestContext15;
                }
                int i2 = authRequestContext;
                arrayList.add(new PromoBannerAnnouncementDaoEntity(string2, string3, string4, string5, string6, string7, string8, string9, string10, string11, string12, string13, string, KClassImpl$Data$declaredNonStaticMembers$2.isNull(i) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(i)));
                authRequestContext = i2;
                authRequestContext15 = i;
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

    @Override // id.dana.data.home.repository.source.presistence.dao.PromoBannerAnnouncementDao
    public final void getAuthRequestContext(List<String> list) {
        this.BuiltInFictitiousFunctionClassFactory.assertNotSuspendingTransaction();
        StringBuilder KClassImpl$Data$declaredNonStaticMembers$2 = StringUtil.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.append("DELETE FROM PromoBannerAnnouncementDaoEntity WHERE subscriptionId in (");
        StringUtil.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, list.size());
        KClassImpl$Data$declaredNonStaticMembers$2.append(")");
        SupportSQLiteStatement compileStatement = this.BuiltInFictitiousFunctionClassFactory.compileStatement(KClassImpl$Data$declaredNonStaticMembers$2.toString());
        int i = 1;
        for (String str : list) {
            if (str == null) {
                compileStatement.bindNull(i);
            } else {
                compileStatement.bindString(i, str);
            }
            i++;
        }
        this.BuiltInFictitiousFunctionClassFactory.beginTransaction();
        try {
            compileStatement.executeUpdateDelete();
            this.BuiltInFictitiousFunctionClassFactory.setTransactionSuccessful();
        } finally {
            this.BuiltInFictitiousFunctionClassFactory.endTransaction();
        }
    }

    public static List<Class<?>> BuiltInFictitiousFunctionClassFactory() {
        return Collections.emptyList();
    }
}
