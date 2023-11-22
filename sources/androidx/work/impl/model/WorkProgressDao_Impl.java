package androidx.work.impl.model;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.Data;

/* loaded from: classes6.dex */
public final class WorkProgressDao_Impl implements WorkProgressDao {
    private final SharedSQLiteStatement BuiltInFictitiousFunctionClassFactory;
    private final EntityInsertionAdapter<WorkProgress> MyBillsEntityDataFactory;
    private final RoomDatabase PlaceComponentResult;
    private final SharedSQLiteStatement getAuthRequestContext;

    public WorkProgressDao_Impl(RoomDatabase roomDatabase) {
        this.PlaceComponentResult = roomDatabase;
        this.MyBillsEntityDataFactory = new EntityInsertionAdapter<WorkProgress>(roomDatabase) { // from class: androidx.work.impl.model.WorkProgressDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `WorkProgress` (`work_spec_id`,`progress`) VALUES (?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public /* synthetic */ void bind(SupportSQLiteStatement supportSQLiteStatement, WorkProgress workProgress) {
                WorkProgress workProgress2 = workProgress;
                if (workProgress2.BuiltInFictitiousFunctionClassFactory == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, workProgress2.BuiltInFictitiousFunctionClassFactory);
                }
                byte[] authRequestContext = Data.getAuthRequestContext(workProgress2.KClassImpl$Data$declaredNonStaticMembers$2);
                if (authRequestContext == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindBlob(2, authRequestContext);
                }
            }
        };
        this.getAuthRequestContext = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkProgressDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE from WorkProgress where work_spec_id=?";
            }
        };
        this.BuiltInFictitiousFunctionClassFactory = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkProgressDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM WorkProgress";
            }
        };
    }

    @Override // androidx.work.impl.model.WorkProgressDao
    public final void BuiltInFictitiousFunctionClassFactory(WorkProgress workProgress) {
        this.PlaceComponentResult.assertNotSuspendingTransaction();
        this.PlaceComponentResult.beginTransaction();
        try {
            this.MyBillsEntityDataFactory.insert((EntityInsertionAdapter<WorkProgress>) workProgress);
            this.PlaceComponentResult.setTransactionSuccessful();
        } finally {
            this.PlaceComponentResult.endTransaction();
        }
    }

    @Override // androidx.work.impl.model.WorkProgressDao
    public final void PlaceComponentResult(String str) {
        this.PlaceComponentResult.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.getAuthRequestContext.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.PlaceComponentResult.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.PlaceComponentResult.setTransactionSuccessful();
        } finally {
            this.PlaceComponentResult.endTransaction();
            this.getAuthRequestContext.release(acquire);
        }
    }

    @Override // androidx.work.impl.model.WorkProgressDao
    public final void getAuthRequestContext() {
        this.PlaceComponentResult.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.BuiltInFictitiousFunctionClassFactory.acquire();
        this.PlaceComponentResult.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.PlaceComponentResult.setTransactionSuccessful();
        } finally {
            this.PlaceComponentResult.endTransaction();
            this.BuiltInFictitiousFunctionClassFactory.release(acquire);
        }
    }
}
