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
import id.dana.data.home.repository.source.presistence.entity.MoreForYouDaoEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes8.dex */
public final class MoreForYouDao_Impl implements MoreForYouDao {
    private final EntityInsertionAdapter<MoreForYouDaoEntity> BuiltInFictitiousFunctionClassFactory;
    private final SharedSQLiteStatement MyBillsEntityDataFactory;
    private final RoomDatabase getAuthRequestContext;

    public MoreForYouDao_Impl(RoomDatabase roomDatabase) {
        this.getAuthRequestContext = roomDatabase;
        this.BuiltInFictitiousFunctionClassFactory = new EntityInsertionAdapter<MoreForYouDaoEntity>(roomDatabase) { // from class: id.dana.data.home.repository.source.presistence.dao.MoreForYouDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `MoreForYouDaoEntity` (`contentId`,`clientId`,`scopes`,`redirectType`,`icon`,`title`,`subtitle`,`redirectUrl`,`contentName`,`contentType`,`spaceCode`,`priority`,`createdDate`,`bizScenario`,`localIconId`,`expireDate`,`orderNo`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public /* synthetic */ void bind(SupportSQLiteStatement supportSQLiteStatement, MoreForYouDaoEntity moreForYouDaoEntity) {
                MoreForYouDaoEntity moreForYouDaoEntity2 = moreForYouDaoEntity;
                if (moreForYouDaoEntity2.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, moreForYouDaoEntity2.KClassImpl$Data$declaredNonStaticMembers$2);
                }
                if (moreForYouDaoEntity2.BuiltInFictitiousFunctionClassFactory == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, moreForYouDaoEntity2.BuiltInFictitiousFunctionClassFactory);
                }
                if (moreForYouDaoEntity2.GetContactSyncConfig == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, moreForYouDaoEntity2.GetContactSyncConfig);
                }
                if (moreForYouDaoEntity2.DatabaseTableConfigUtil == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, moreForYouDaoEntity2.DatabaseTableConfigUtil);
                }
                if (moreForYouDaoEntity2.NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, moreForYouDaoEntity2.NetworkUserEntityData$$ExternalSyntheticLambda0);
                }
                if (moreForYouDaoEntity2.NetworkUserEntityData$$ExternalSyntheticLambda8 == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, moreForYouDaoEntity2.NetworkUserEntityData$$ExternalSyntheticLambda8);
                }
                if (moreForYouDaoEntity2.PrepareContext == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, moreForYouDaoEntity2.PrepareContext);
                }
                if (moreForYouDaoEntity2.NetworkUserEntityData$$ExternalSyntheticLambda1 == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, moreForYouDaoEntity2.NetworkUserEntityData$$ExternalSyntheticLambda1);
                }
                if (moreForYouDaoEntity2.MyBillsEntityDataFactory == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, moreForYouDaoEntity2.MyBillsEntityDataFactory);
                }
                if (moreForYouDaoEntity2.getAuthRequestContext == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, moreForYouDaoEntity2.getAuthRequestContext);
                }
                if (moreForYouDaoEntity2.NetworkUserEntityData$$ExternalSyntheticLambda2 == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindString(11, moreForYouDaoEntity2.NetworkUserEntityData$$ExternalSyntheticLambda2);
                }
                if (moreForYouDaoEntity2.initRecordTimeStamp == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindLong(12, moreForYouDaoEntity2.initRecordTimeStamp.intValue());
                }
                if (moreForYouDaoEntity2.getErrorConfigVersion == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindLong(13, moreForYouDaoEntity2.getErrorConfigVersion.intValue());
                }
                if (moreForYouDaoEntity2.PlaceComponentResult == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindString(14, moreForYouDaoEntity2.PlaceComponentResult);
                }
                if (moreForYouDaoEntity2.moveToNextValue == null) {
                    supportSQLiteStatement.bindNull(15);
                } else {
                    supportSQLiteStatement.bindLong(15, moreForYouDaoEntity2.moveToNextValue.intValue());
                }
                if (moreForYouDaoEntity2.scheduleImpl == null) {
                    supportSQLiteStatement.bindNull(16);
                } else {
                    supportSQLiteStatement.bindString(16, moreForYouDaoEntity2.scheduleImpl);
                }
                supportSQLiteStatement.bindLong(17, moreForYouDaoEntity2.lookAheadTest);
            }
        };
        this.MyBillsEntityDataFactory = new SharedSQLiteStatement(roomDatabase) { // from class: id.dana.data.home.repository.source.presistence.dao.MoreForYouDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM MoreForYouDaoEntity";
            }
        };
    }

    @Override // id.dana.data.home.repository.source.presistence.dao.MoreForYouDao
    public final long[] MyBillsEntityDataFactory(MoreForYouDaoEntity... moreForYouDaoEntityArr) {
        this.getAuthRequestContext.assertNotSuspendingTransaction();
        this.getAuthRequestContext.beginTransaction();
        try {
            long[] insertAndReturnIdsArray = this.BuiltInFictitiousFunctionClassFactory.insertAndReturnIdsArray(moreForYouDaoEntityArr);
            this.getAuthRequestContext.setTransactionSuccessful();
            return insertAndReturnIdsArray;
        } finally {
            this.getAuthRequestContext.endTransaction();
        }
    }

    @Override // id.dana.data.home.repository.source.presistence.dao.MoreForYouDao
    public final List<MoreForYouDaoEntity> PlaceComponentResult() {
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
        Integer valueOf;
        int i;
        RoomSQLiteQuery authRequestContext15 = RoomSQLiteQuery.getAuthRequestContext("SELECT * FROM MoreForYouDaoEntity ORDER BY orderNo", 0);
        this.getAuthRequestContext.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, authRequestContext15, false);
        try {
            authRequestContext = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "contentId");
            authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "clientId");
            authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "scopes");
            authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "redirectType");
            authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "icon");
            authRequestContext6 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "title");
            authRequestContext7 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "subtitle");
            authRequestContext8 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "redirectUrl");
            authRequestContext9 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "contentName");
            authRequestContext10 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "contentType");
            authRequestContext11 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "spaceCode");
            authRequestContext12 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "priority");
            authRequestContext13 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "createdDate");
            authRequestContext14 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "bizScenario");
            roomSQLiteQuery = authRequestContext15;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = authRequestContext15;
        }
        try {
            int authRequestContext16 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "localIconId");
            int authRequestContext17 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "expireDate");
            int authRequestContext18 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "orderNo");
            int i2 = authRequestContext14;
            ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
            while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                String string = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext);
                String string2 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext2) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2);
                String string3 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext3) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext3);
                String string4 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext4) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext4);
                String string5 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext5) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext5);
                String string6 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext6) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext6);
                String string7 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext7) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext7);
                String string8 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext8) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext8);
                String string9 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext9) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext9);
                String string10 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext10) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext10);
                String string11 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext11) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext11);
                Integer valueOf2 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext12) ? null : Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext12));
                if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext13)) {
                    i = i2;
                    valueOf = null;
                } else {
                    valueOf = Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext13));
                    i = i2;
                }
                String string12 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(i) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(i);
                int i3 = authRequestContext16;
                int i4 = authRequestContext;
                Integer valueOf3 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(i3) ? null : Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getInt(i3));
                int i5 = authRequestContext17;
                String string13 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(i5) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(i5);
                int i6 = authRequestContext18;
                arrayList.add(new MoreForYouDaoEntity(string, string2, string3, string4, string5, string6, string7, string8, string9, string10, string11, valueOf2, valueOf, string12, valueOf3, string13, KClassImpl$Data$declaredNonStaticMembers$2.getInt(i6)));
                authRequestContext = i4;
                authRequestContext16 = i3;
                authRequestContext17 = i5;
                authRequestContext18 = i6;
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

    @Override // id.dana.data.home.repository.source.presistence.dao.MoreForYouDao
    public final void KClassImpl$Data$declaredNonStaticMembers$2(List<String> list) {
        this.getAuthRequestContext.assertNotSuspendingTransaction();
        StringBuilder KClassImpl$Data$declaredNonStaticMembers$2 = StringUtil.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.append("DELETE FROM MoreForYouDaoEntity WHERE contentId in (");
        StringUtil.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, list.size());
        KClassImpl$Data$declaredNonStaticMembers$2.append(")");
        SupportSQLiteStatement compileStatement = this.getAuthRequestContext.compileStatement(KClassImpl$Data$declaredNonStaticMembers$2.toString());
        int i = 1;
        for (String str : list) {
            if (str == null) {
                compileStatement.bindNull(i);
            } else {
                compileStatement.bindString(i, str);
            }
            i++;
        }
        this.getAuthRequestContext.beginTransaction();
        try {
            compileStatement.executeUpdateDelete();
            this.getAuthRequestContext.setTransactionSuccessful();
        } finally {
            this.getAuthRequestContext.endTransaction();
        }
    }

    public static List<Class<?>> BuiltInFictitiousFunctionClassFactory() {
        return Collections.emptyList();
    }
}
