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
public final class WorkTagDao_Impl implements WorkTagDao {
    private final RoomDatabase KClassImpl$Data$declaredNonStaticMembers$2;
    private final EntityInsertionAdapter<WorkTag> MyBillsEntityDataFactory;

    public WorkTagDao_Impl(RoomDatabase roomDatabase) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = roomDatabase;
        this.MyBillsEntityDataFactory = new EntityInsertionAdapter<WorkTag>(roomDatabase) { // from class: androidx.work.impl.model.WorkTagDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public /* synthetic */ void bind(SupportSQLiteStatement supportSQLiteStatement, WorkTag workTag) {
                WorkTag workTag2 = workTag;
                if (workTag2.BuiltInFictitiousFunctionClassFactory == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, workTag2.BuiltInFictitiousFunctionClassFactory);
                }
                if (workTag2.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, workTag2.KClassImpl$Data$declaredNonStaticMembers$2);
                }
            }
        };
    }

    @Override // androidx.work.impl.model.WorkTagDao
    public final void KClassImpl$Data$declaredNonStaticMembers$2(WorkTag workTag) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.assertNotSuspendingTransaction();
        this.KClassImpl$Data$declaredNonStaticMembers$2.beginTransaction();
        try {
            this.MyBillsEntityDataFactory.insert((EntityInsertionAdapter<WorkTag>) workTag);
            this.KClassImpl$Data$declaredNonStaticMembers$2.setTransactionSuccessful();
        } finally {
            this.KClassImpl$Data$declaredNonStaticMembers$2.endTransaction();
        }
    }

    @Override // androidx.work.impl.model.WorkTagDao
    public final List<String> BuiltInFictitiousFunctionClassFactory(String str) {
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?", 1);
        if (str == null) {
            authRequestContext.bindNull(1);
        } else {
            authRequestContext.bindString(1, str);
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, authRequestContext, false);
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
