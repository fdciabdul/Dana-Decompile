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
public final class WorkNameDao_Impl implements WorkNameDao {
    private final RoomDatabase MyBillsEntityDataFactory;
    private final EntityInsertionAdapter<WorkName> PlaceComponentResult;

    public WorkNameDao_Impl(RoomDatabase roomDatabase) {
        this.MyBillsEntityDataFactory = roomDatabase;
        this.PlaceComponentResult = new EntityInsertionAdapter<WorkName>(roomDatabase) { // from class: androidx.work.impl.model.WorkNameDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `WorkName` (`name`,`work_spec_id`) VALUES (?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public /* synthetic */ void bind(SupportSQLiteStatement supportSQLiteStatement, WorkName workName) {
                WorkName workName2 = workName;
                if (workName2.getAuthRequestContext == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, workName2.getAuthRequestContext);
                }
                if (workName2.MyBillsEntityDataFactory == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, workName2.MyBillsEntityDataFactory);
                }
            }
        };
    }

    @Override // androidx.work.impl.model.WorkNameDao
    public final void KClassImpl$Data$declaredNonStaticMembers$2(WorkName workName) {
        this.MyBillsEntityDataFactory.assertNotSuspendingTransaction();
        this.MyBillsEntityDataFactory.beginTransaction();
        try {
            this.PlaceComponentResult.insert((EntityInsertionAdapter<WorkName>) workName);
            this.MyBillsEntityDataFactory.setTransactionSuccessful();
        } finally {
            this.MyBillsEntityDataFactory.endTransaction();
        }
    }

    @Override // androidx.work.impl.model.WorkNameDao
    public final List<String> getAuthRequestContext(String str) {
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT name FROM workname WHERE work_spec_id=?", 1);
        if (str == null) {
            authRequestContext.bindNull(1);
        } else {
            authRequestContext.bindString(1, str);
        }
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
