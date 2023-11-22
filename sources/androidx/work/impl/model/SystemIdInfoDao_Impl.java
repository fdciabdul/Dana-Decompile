package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public final class SystemIdInfoDao_Impl implements SystemIdInfoDao {
    private final EntityInsertionAdapter<SystemIdInfo> BuiltInFictitiousFunctionClassFactory;
    private final SharedSQLiteStatement KClassImpl$Data$declaredNonStaticMembers$2;
    private final RoomDatabase MyBillsEntityDataFactory;

    public SystemIdInfoDao_Impl(RoomDatabase roomDatabase) {
        this.MyBillsEntityDataFactory = roomDatabase;
        this.BuiltInFictitiousFunctionClassFactory = new EntityInsertionAdapter<SystemIdInfo>(roomDatabase) { // from class: androidx.work.impl.model.SystemIdInfoDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`system_id`) VALUES (?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public /* synthetic */ void bind(SupportSQLiteStatement supportSQLiteStatement, SystemIdInfo systemIdInfo) {
                SystemIdInfo systemIdInfo2 = systemIdInfo;
                if (systemIdInfo2.BuiltInFictitiousFunctionClassFactory == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, systemIdInfo2.BuiltInFictitiousFunctionClassFactory);
                }
                supportSQLiteStatement.bindLong(2, systemIdInfo2.KClassImpl$Data$declaredNonStaticMembers$2);
            }
        };
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.SystemIdInfoDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM SystemIdInfo where work_spec_id=?";
            }
        };
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public final void MyBillsEntityDataFactory(SystemIdInfo systemIdInfo) {
        this.MyBillsEntityDataFactory.assertNotSuspendingTransaction();
        this.MyBillsEntityDataFactory.beginTransaction();
        try {
            this.BuiltInFictitiousFunctionClassFactory.insert((EntityInsertionAdapter<SystemIdInfo>) systemIdInfo);
            this.MyBillsEntityDataFactory.setTransactionSuccessful();
        } finally {
            this.MyBillsEntityDataFactory.endTransaction();
        }
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public final void MyBillsEntityDataFactory(String str) {
        this.MyBillsEntityDataFactory.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.KClassImpl$Data$declaredNonStaticMembers$2.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.MyBillsEntityDataFactory.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.MyBillsEntityDataFactory.setTransactionSuccessful();
        } finally {
            this.MyBillsEntityDataFactory.endTransaction();
            this.KClassImpl$Data$declaredNonStaticMembers$2.release(acquire);
        }
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public final SystemIdInfo getAuthRequestContext(String str) {
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT `SystemIdInfo`.`work_spec_id` AS `work_spec_id`, `SystemIdInfo`.`system_id` AS `system_id` FROM SystemIdInfo WHERE work_spec_id=?", 1);
        if (str == null) {
            authRequestContext.bindNull(1);
        } else {
            authRequestContext.bindString(1, str);
        }
        this.MyBillsEntityDataFactory.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, authRequestContext, false);
        try {
            return KClassImpl$Data$declaredNonStaticMembers$2.moveToFirst() ? new SystemIdInfo(KClassImpl$Data$declaredNonStaticMembers$2.getString(CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "work_spec_id")), KClassImpl$Data$declaredNonStaticMembers$2.getInt(CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "system_id"))) : null;
        } finally {
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            authRequestContext.MyBillsEntityDataFactory();
        }
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public final List<String> PlaceComponentResult() {
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT DISTINCT work_spec_id FROM SystemIdInfo", 0);
        this.MyBillsEntityDataFactory.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, authRequestContext, false);
        try {
            ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
            while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                arrayList.add(KClassImpl$Data$declaredNonStaticMembers$2.getString(0));
            }
            return arrayList;
        } finally {
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            authRequestContext.MyBillsEntityDataFactory();
        }
    }
}
