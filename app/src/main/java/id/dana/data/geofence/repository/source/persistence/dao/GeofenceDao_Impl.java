package id.dana.data.geofence.repository.source.persistence.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import id.dana.data.geofence.repository.source.persistence.entity.RecentPoiEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes8.dex */
public final class GeofenceDao_Impl implements GeofenceDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<RecentPoiEntity> __insertionAdapterOfRecentPoiEntity;

    public GeofenceDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfRecentPoiEntity = new EntityInsertionAdapter<RecentPoiEntity>(roomDatabase) { // from class: id.dana.data.geofence.repository.source.persistence.dao.GeofenceDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `RecentPoiEntity` (`poiId`,`radius`,`longitude`,`latitude`,`lastPoiNotified`) VALUES (?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public /* synthetic */ void bind(SupportSQLiteStatement supportSQLiteStatement, RecentPoiEntity recentPoiEntity) {
                RecentPoiEntity recentPoiEntity2 = recentPoiEntity;
                if (recentPoiEntity2.getPoiId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, recentPoiEntity2.getPoiId());
                }
                supportSQLiteStatement.bindLong(2, recentPoiEntity2.getRadius());
                supportSQLiteStatement.bindDouble(3, recentPoiEntity2.getLongitude());
                supportSQLiteStatement.bindDouble(4, recentPoiEntity2.getLatitude());
                if (recentPoiEntity2.getLastPoiNotified() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindLong(5, recentPoiEntity2.getLastPoiNotified().longValue());
                }
            }
        };
    }

    @Override // id.dana.data.geofence.repository.source.persistence.dao.GeofenceDao
    public final long[] insertPois(List<RecentPoiEntity> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long[] insertAndReturnIdsArray = this.__insertionAdapterOfRecentPoiEntity.insertAndReturnIdsArray(list);
            this.__db.setTransactionSuccessful();
            return insertAndReturnIdsArray;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // id.dana.data.geofence.repository.source.persistence.dao.GeofenceDao
    public final List<RecentPoiEntity> hasNotifiedToday(String str, long j) {
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT * FROM RecentPoiEntity WHERE poiId = ? AND lastPoiNotified = ? LIMIT 1", 2);
        if (str == null) {
            authRequestContext.bindNull(1);
        } else {
            authRequestContext.bindString(1, str);
        }
        authRequestContext.bindLong(2, j);
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext, false);
        try {
            int authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "poiId");
            int authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "radius");
            int authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "longitude");
            int authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "latitude");
            int authRequestContext6 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "lastPoiNotified");
            ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
            while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                arrayList.add(new RecentPoiEntity(KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext2) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2), KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext3), KClassImpl$Data$declaredNonStaticMembers$2.getDouble(authRequestContext4), KClassImpl$Data$declaredNonStaticMembers$2.getDouble(authRequestContext5), KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext6) ? null : Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext6))));
            }
            return arrayList;
        } finally {
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            authRequestContext.MyBillsEntityDataFactory();
        }
    }

    @Override // id.dana.data.geofence.repository.source.persistence.dao.GeofenceDao
    public final List<RecentPoiEntity> getAllPois() {
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT * FROM RecentPoiEntity", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext, false);
        try {
            int authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "poiId");
            int authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "radius");
            int authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "longitude");
            int authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "latitude");
            int authRequestContext6 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "lastPoiNotified");
            ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
            while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                arrayList.add(new RecentPoiEntity(KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext2) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2), KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext3), KClassImpl$Data$declaredNonStaticMembers$2.getDouble(authRequestContext4), KClassImpl$Data$declaredNonStaticMembers$2.getDouble(authRequestContext5), KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext6) ? null : Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext6))));
            }
            return arrayList;
        } finally {
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            authRequestContext.MyBillsEntityDataFactory();
        }
    }

    @Override // id.dana.data.geofence.repository.source.persistence.dao.GeofenceDao
    public final int updateLastNotification(List<String> list, long j) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder KClassImpl$Data$declaredNonStaticMembers$2 = StringUtil.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.append("UPDATE RecentPoiEntity SET lastPoiNotified = ");
        KClassImpl$Data$declaredNonStaticMembers$2.append("?");
        KClassImpl$Data$declaredNonStaticMembers$2.append(" WHERE poiId IN (");
        StringUtil.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, list.size());
        KClassImpl$Data$declaredNonStaticMembers$2.append(")");
        SupportSQLiteStatement compileStatement = this.__db.compileStatement(KClassImpl$Data$declaredNonStaticMembers$2.toString());
        compileStatement.bindLong(1, j);
        int i = 2;
        for (String str : list) {
            if (str == null) {
                compileStatement.bindNull(i);
            } else {
                compileStatement.bindString(i, str);
            }
            i++;
        }
        this.__db.beginTransaction();
        try {
            int executeUpdateDelete = compileStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.__db.endTransaction();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
