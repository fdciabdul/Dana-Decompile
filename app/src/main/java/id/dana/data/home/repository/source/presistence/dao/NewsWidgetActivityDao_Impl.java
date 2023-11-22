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
import com.alibaba.griver.core.GriverParams;
import com.alipay.mobile.zebra.data.ZebraData;
import id.dana.data.home.repository.source.presistence.entity.NewsWidgetActivityDaoEntity;
import id.dana.domain.social.ExtendInfoUtilKt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes8.dex */
public final class NewsWidgetActivityDao_Impl implements NewsWidgetActivityDao {
    private final RoomDatabase BuiltInFictitiousFunctionClassFactory;
    private final EntityInsertionAdapter<NewsWidgetActivityDaoEntity> MyBillsEntityDataFactory;
    private final SharedSQLiteStatement PlaceComponentResult;

    public NewsWidgetActivityDao_Impl(RoomDatabase roomDatabase) {
        this.BuiltInFictitiousFunctionClassFactory = roomDatabase;
        this.MyBillsEntityDataFactory = new EntityInsertionAdapter<NewsWidgetActivityDaoEntity>(roomDatabase) { // from class: id.dana.data.home.repository.source.presistence.dao.NewsWidgetActivityDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `NewsWidgetActivityDaoEntity` (`activityId`,`activityContent`,`activityTitle`,`actorAvatar`,`actorNickname`,`bizType`,`clickable`,`content`,`createdTime`,`feedType`,`imageUrl`,`redirectUrl`,`targetNickname`,`verb`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public /* synthetic */ void bind(SupportSQLiteStatement supportSQLiteStatement, NewsWidgetActivityDaoEntity newsWidgetActivityDaoEntity) {
                NewsWidgetActivityDaoEntity newsWidgetActivityDaoEntity2 = newsWidgetActivityDaoEntity;
                if (newsWidgetActivityDaoEntity2.MyBillsEntityDataFactory == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, newsWidgetActivityDaoEntity2.MyBillsEntityDataFactory);
                }
                if (newsWidgetActivityDaoEntity2.BuiltInFictitiousFunctionClassFactory == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, newsWidgetActivityDaoEntity2.BuiltInFictitiousFunctionClassFactory);
                }
                if (newsWidgetActivityDaoEntity2.PlaceComponentResult == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, newsWidgetActivityDaoEntity2.PlaceComponentResult);
                }
                if (newsWidgetActivityDaoEntity2.getAuthRequestContext == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, newsWidgetActivityDaoEntity2.getAuthRequestContext);
                }
                if (newsWidgetActivityDaoEntity2.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, newsWidgetActivityDaoEntity2.KClassImpl$Data$declaredNonStaticMembers$2);
                }
                if (newsWidgetActivityDaoEntity2.scheduleImpl == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, newsWidgetActivityDaoEntity2.scheduleImpl);
                }
                supportSQLiteStatement.bindLong(7, newsWidgetActivityDaoEntity2.getGetErrorConfigVersion() ? 1L : 0L);
                if (newsWidgetActivityDaoEntity2.NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, newsWidgetActivityDaoEntity2.NetworkUserEntityData$$ExternalSyntheticLambda0);
                }
                if (newsWidgetActivityDaoEntity2.moveToNextValue == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindLong(9, newsWidgetActivityDaoEntity2.moveToNextValue.longValue());
                }
                if (newsWidgetActivityDaoEntity2.lookAheadTest == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, newsWidgetActivityDaoEntity2.lookAheadTest);
                }
                if (newsWidgetActivityDaoEntity2.initRecordTimeStamp == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindString(11, newsWidgetActivityDaoEntity2.initRecordTimeStamp);
                }
                if (newsWidgetActivityDaoEntity2.DatabaseTableConfigUtil == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindString(12, newsWidgetActivityDaoEntity2.DatabaseTableConfigUtil);
                }
                if (newsWidgetActivityDaoEntity2.NetworkUserEntityData$$ExternalSyntheticLambda2 == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindString(13, newsWidgetActivityDaoEntity2.NetworkUserEntityData$$ExternalSyntheticLambda2);
                }
                if (newsWidgetActivityDaoEntity2.NetworkUserEntityData$$ExternalSyntheticLambda1 == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindString(14, newsWidgetActivityDaoEntity2.NetworkUserEntityData$$ExternalSyntheticLambda1);
                }
            }
        };
        this.PlaceComponentResult = new SharedSQLiteStatement(roomDatabase) { // from class: id.dana.data.home.repository.source.presistence.dao.NewsWidgetActivityDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM NewsWidgetActivityDaoEntity";
            }
        };
    }

    @Override // id.dana.data.home.repository.source.presistence.dao.NewsWidgetActivityDao
    public final long[] MyBillsEntityDataFactory(NewsWidgetActivityDaoEntity... newsWidgetActivityDaoEntityArr) {
        this.BuiltInFictitiousFunctionClassFactory.assertNotSuspendingTransaction();
        this.BuiltInFictitiousFunctionClassFactory.beginTransaction();
        try {
            long[] insertAndReturnIdsArray = this.MyBillsEntityDataFactory.insertAndReturnIdsArray(newsWidgetActivityDaoEntityArr);
            this.BuiltInFictitiousFunctionClassFactory.setTransactionSuccessful();
            return insertAndReturnIdsArray;
        } finally {
            this.BuiltInFictitiousFunctionClassFactory.endTransaction();
        }
    }

    @Override // id.dana.data.home.repository.source.presistence.dao.NewsWidgetActivityDao
    public final void PlaceComponentResult() {
        this.BuiltInFictitiousFunctionClassFactory.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.PlaceComponentResult.acquire();
        this.BuiltInFictitiousFunctionClassFactory.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.BuiltInFictitiousFunctionClassFactory.setTransactionSuccessful();
        } finally {
            this.BuiltInFictitiousFunctionClassFactory.endTransaction();
            this.PlaceComponentResult.release(acquire);
        }
    }

    @Override // id.dana.data.home.repository.source.presistence.dao.NewsWidgetActivityDao
    public final List<NewsWidgetActivityDaoEntity> BuiltInFictitiousFunctionClassFactory() {
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
        RoomSQLiteQuery authRequestContext14 = RoomSQLiteQuery.getAuthRequestContext("SELECT * FROM NewsWidgetActivityDaoEntity", 0);
        this.BuiltInFictitiousFunctionClassFactory.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, authRequestContext14, false);
        try {
            authRequestContext = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, ExtendInfoUtilKt.EXTEND_INFO_ACTIVITY_ID);
            authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "activityContent");
            authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "activityTitle");
            authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "actorAvatar");
            authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "actorNickname");
            authRequestContext6 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "bizType");
            authRequestContext7 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, ZebraData.ATTR_CLICKABLE);
            authRequestContext8 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "content");
            authRequestContext9 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "createdTime");
            authRequestContext10 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "feedType");
            authRequestContext11 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, GriverParams.ShareParams.IMAGE_URL);
            authRequestContext12 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "redirectUrl");
            authRequestContext13 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "targetNickname");
            roomSQLiteQuery = authRequestContext14;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = authRequestContext14;
        }
        try {
            int authRequestContext15 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "verb");
            ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
            while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                String string2 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext);
                String string3 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext2) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2);
                String string4 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext3) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext3);
                String string5 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext4) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext4);
                String string6 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext5) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext5);
                String string7 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext6) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext6);
                boolean z = KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext7) != 0;
                String string8 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext8) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext8);
                Long valueOf = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext9) ? null : Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext9));
                String string9 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext10) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext10);
                String string10 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext11) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext11);
                String string11 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext12) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext12);
                if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext13)) {
                    i = authRequestContext15;
                    string = null;
                } else {
                    string = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext13);
                    i = authRequestContext15;
                }
                int i2 = authRequestContext13;
                arrayList.add(new NewsWidgetActivityDaoEntity(string2, string3, string4, string5, string6, string7, z, string8, valueOf, string9, string10, string11, string, KClassImpl$Data$declaredNonStaticMembers$2.isNull(i) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(i)));
                authRequestContext13 = i2;
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

    @Override // id.dana.data.home.repository.source.presistence.dao.NewsWidgetActivityDao
    public final void PlaceComponentResult(List<String> list) {
        this.BuiltInFictitiousFunctionClassFactory.assertNotSuspendingTransaction();
        StringBuilder KClassImpl$Data$declaredNonStaticMembers$2 = StringUtil.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.append("DELETE FROM NewsWidgetActivityDaoEntity WHERE activityId in (");
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

    public static List<Class<?>> getAuthRequestContext() {
        return Collections.emptyList();
    }
}
