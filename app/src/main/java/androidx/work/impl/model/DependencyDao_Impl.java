package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public final class DependencyDao_Impl implements DependencyDao {
    private final EntityInsertionAdapter<Dependency> KClassImpl$Data$declaredNonStaticMembers$2;
    private final RoomDatabase getAuthRequestContext;

    public DependencyDao_Impl(RoomDatabase roomDatabase) {
        this.getAuthRequestContext = roomDatabase;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new EntityInsertionAdapter<Dependency>(roomDatabase) { // from class: androidx.work.impl.model.DependencyDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `Dependency` (`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public /* synthetic */ void bind(SupportSQLiteStatement supportSQLiteStatement, Dependency dependency) {
                Dependency dependency2 = dependency;
                if (dependency2.MyBillsEntityDataFactory == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, dependency2.MyBillsEntityDataFactory);
                }
                if (dependency2.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, dependency2.KClassImpl$Data$declaredNonStaticMembers$2);
                }
            }
        };
    }

    @Override // androidx.work.impl.model.DependencyDao
    public final void PlaceComponentResult(Dependency dependency) {
        this.getAuthRequestContext.assertNotSuspendingTransaction();
        this.getAuthRequestContext.beginTransaction();
        try {
            this.KClassImpl$Data$declaredNonStaticMembers$2.insert((EntityInsertionAdapter<Dependency>) dependency);
            this.getAuthRequestContext.setTransactionSuccessful();
        } finally {
            this.getAuthRequestContext.endTransaction();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
    
        if (r5.getInt(0) != 0) goto L13;
     */
    @Override // androidx.work.impl.model.DependencyDao
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean MyBillsEntityDataFactory(java.lang.String r5) {
        /*
            r4 = this;
            r0 = 1
            java.lang.String r1 = "SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)"
            androidx.room.RoomSQLiteQuery r1 = androidx.room.RoomSQLiteQuery.getAuthRequestContext(r1, r0)
            if (r5 != 0) goto Ld
            r1.bindNull(r0)
            goto L10
        Ld:
            r1.bindString(r0, r5)
        L10:
            androidx.room.RoomDatabase r5 = r4.getAuthRequestContext
            r5.assertNotSuspendingTransaction()
            androidx.room.RoomDatabase r5 = r4.getAuthRequestContext
            r2 = 0
            android.database.Cursor r5 = androidx.room.util.DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(r5, r1, r2)
            boolean r3 = r5.moveToFirst()     // Catch: java.lang.Throwable -> L31
            if (r3 == 0) goto L29
            int r3 = r5.getInt(r2)     // Catch: java.lang.Throwable -> L31
            if (r3 == 0) goto L29
            goto L2a
        L29:
            r0 = 0
        L2a:
            r5.close()
            r1.MyBillsEntityDataFactory()
            return r0
        L31:
            r0 = move-exception
            r5.close()
            r1.MyBillsEntityDataFactory()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.DependencyDao_Impl.MyBillsEntityDataFactory(java.lang.String):boolean");
    }

    @Override // androidx.work.impl.model.DependencyDao
    public final List<String> getAuthRequestContext(String str) {
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT work_spec_id FROM dependency WHERE prerequisite_id=?", 1);
        if (str == null) {
            authRequestContext.bindNull(1);
        } else {
            authRequestContext.bindString(1, str);
        }
        this.getAuthRequestContext.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, authRequestContext, false);
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

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
    
        if (r5.getInt(0) != 0) goto L13;
     */
    @Override // androidx.work.impl.model.DependencyDao
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean PlaceComponentResult(java.lang.String r5) {
        /*
            r4 = this;
            r0 = 1
            java.lang.String r1 = "SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?"
            androidx.room.RoomSQLiteQuery r1 = androidx.room.RoomSQLiteQuery.getAuthRequestContext(r1, r0)
            if (r5 != 0) goto Ld
            r1.bindNull(r0)
            goto L10
        Ld:
            r1.bindString(r0, r5)
        L10:
            androidx.room.RoomDatabase r5 = r4.getAuthRequestContext
            r5.assertNotSuspendingTransaction()
            androidx.room.RoomDatabase r5 = r4.getAuthRequestContext
            r2 = 0
            android.database.Cursor r5 = androidx.room.util.DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(r5, r1, r2)
            boolean r3 = r5.moveToFirst()     // Catch: java.lang.Throwable -> L31
            if (r3 == 0) goto L29
            int r3 = r5.getInt(r2)     // Catch: java.lang.Throwable -> L31
            if (r3 == 0) goto L29
            goto L2a
        L29:
            r0 = 0
        L2a:
            r5.close()
            r1.MyBillsEntityDataFactory()
            return r0
        L31:
            r0 = move-exception
            r5.close()
            r1.MyBillsEntityDataFactory()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.DependencyDao_Impl.PlaceComponentResult(java.lang.String):boolean");
    }
}
