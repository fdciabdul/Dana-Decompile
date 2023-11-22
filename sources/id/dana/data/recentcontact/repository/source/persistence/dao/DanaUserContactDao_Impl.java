package id.dana.data.recentcontact.repository.source.persistence.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import id.dana.danah5.constant.BaseKey;
import id.dana.data.recentcontact.repository.source.persistence.entity.DanaUserContactEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes8.dex */
public final class DanaUserContactDao_Impl implements DanaUserContactDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<DanaUserContactEntity> __insertionAdapterOfDanaUserContactEntity;
    private final EntityDeletionOrUpdateAdapter<DanaUserContactEntity> __updateAdapterOfDanaUserContactEntity;

    public DanaUserContactDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfDanaUserContactEntity = new EntityInsertionAdapter<DanaUserContactEntity>(roomDatabase) { // from class: id.dana.data.recentcontact.repository.source.persistence.dao.DanaUserContactDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR ABORT INTO `DanaUserContactEntity` (`lastUpdated`,`phoneNumber`,`uid`,`userId`) VALUES (?,?,nullif(?, 0),?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public /* synthetic */ void bind(SupportSQLiteStatement supportSQLiteStatement, DanaUserContactEntity danaUserContactEntity) {
                DanaUserContactEntity danaUserContactEntity2 = danaUserContactEntity;
                supportSQLiteStatement.bindLong(1, danaUserContactEntity2.getLastUpdated());
                if (danaUserContactEntity2.getPhoneNumber() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, danaUserContactEntity2.getPhoneNumber());
                }
                supportSQLiteStatement.bindLong(3, danaUserContactEntity2.getUid());
                if (danaUserContactEntity2.getUserId() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, danaUserContactEntity2.getUserId());
                }
            }
        };
        this.__updateAdapterOfDanaUserContactEntity = new EntityDeletionOrUpdateAdapter<DanaUserContactEntity>(roomDatabase) { // from class: id.dana.data.recentcontact.repository.source.persistence.dao.DanaUserContactDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `DanaUserContactEntity` SET `lastUpdated` = ?,`phoneNumber` = ?,`uid` = ?,`userId` = ? WHERE `uid` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(SupportSQLiteStatement supportSQLiteStatement, DanaUserContactEntity danaUserContactEntity) {
                DanaUserContactEntity danaUserContactEntity2 = danaUserContactEntity;
                supportSQLiteStatement.bindLong(1, danaUserContactEntity2.getLastUpdated());
                if (danaUserContactEntity2.getPhoneNumber() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, danaUserContactEntity2.getPhoneNumber());
                }
                supportSQLiteStatement.bindLong(3, danaUserContactEntity2.getUid());
                if (danaUserContactEntity2.getUserId() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, danaUserContactEntity2.getUserId());
                }
                supportSQLiteStatement.bindLong(5, danaUserContactEntity2.getUid());
            }
        };
    }

    @Override // id.dana.data.recentcontact.repository.source.persistence.dao.DanaUserContactDao
    public final Long insertDanaUserContact(DanaUserContactEntity danaUserContactEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long insertAndReturnId = this.__insertionAdapterOfDanaUserContactEntity.insertAndReturnId(danaUserContactEntity);
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
            return Long.valueOf(insertAndReturnId);
        } catch (Throwable th) {
            this.__db.endTransaction();
            throw th;
        }
    }

    @Override // id.dana.data.recentcontact.repository.source.persistence.dao.DanaUserContactDao
    public final int updateDanaUserContact(DanaUserContactEntity danaUserContactEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int BuiltInFictitiousFunctionClassFactory = this.__updateAdapterOfDanaUserContactEntity.BuiltInFictitiousFunctionClassFactory(danaUserContactEntity);
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
            return BuiltInFictitiousFunctionClassFactory + 0;
        } catch (Throwable th) {
            this.__db.endTransaction();
            throw th;
        }
    }

    @Override // id.dana.data.recentcontact.repository.source.persistence.dao.DanaUserContactDao
    public final DanaUserContactEntity getDanaUserContactEntity(String str) {
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT * FROM DanaUserContactEntity WHERE phoneNumber = ?", 1);
        if (str == null) {
            authRequestContext.bindNull(1);
        } else {
            authRequestContext.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext, false);
        try {
            int authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, BaseKey.LAST_UPDATED);
            int authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "phoneNumber");
            int authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "uid");
            int authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "userId");
            DanaUserContactEntity danaUserContactEntity = null;
            String string = null;
            if (KClassImpl$Data$declaredNonStaticMembers$2.moveToFirst()) {
                DanaUserContactEntity danaUserContactEntity2 = new DanaUserContactEntity();
                danaUserContactEntity2.setLastUpdated(KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext2));
                danaUserContactEntity2.setPhoneNumber(KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext3) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext3));
                danaUserContactEntity2.setUid(KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext4));
                if (!KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext5)) {
                    string = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext5);
                }
                danaUserContactEntity2.setUserId(string);
                danaUserContactEntity = danaUserContactEntity2;
            }
            return danaUserContactEntity;
        } finally {
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            authRequestContext.MyBillsEntityDataFactory();
        }
    }

    @Override // id.dana.data.recentcontact.repository.source.persistence.dao.DanaUserContactDao
    public final List<String> getDanaUserPhoneNumber() {
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT phoneNumber FROM DanaUserContactEntity", 0);
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

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
