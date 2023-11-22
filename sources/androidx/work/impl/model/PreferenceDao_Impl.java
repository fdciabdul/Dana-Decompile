package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.concurrent.Callable;

/* loaded from: classes6.dex */
public final class PreferenceDao_Impl implements PreferenceDao {
    private final RoomDatabase MyBillsEntityDataFactory;
    private final EntityInsertionAdapter<Preference> PlaceComponentResult;

    public PreferenceDao_Impl(RoomDatabase roomDatabase) {
        this.MyBillsEntityDataFactory = roomDatabase;
        this.PlaceComponentResult = new EntityInsertionAdapter<Preference>(roomDatabase) { // from class: androidx.work.impl.model.PreferenceDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public /* synthetic */ void bind(SupportSQLiteStatement supportSQLiteStatement, Preference preference) {
                Preference preference2 = preference;
                if (preference2.BuiltInFictitiousFunctionClassFactory == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, preference2.BuiltInFictitiousFunctionClassFactory);
                }
                if (preference2.MyBillsEntityDataFactory == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindLong(2, preference2.MyBillsEntityDataFactory.longValue());
                }
            }
        };
    }

    @Override // androidx.work.impl.model.PreferenceDao
    public final void MyBillsEntityDataFactory(Preference preference) {
        this.MyBillsEntityDataFactory.assertNotSuspendingTransaction();
        this.MyBillsEntityDataFactory.beginTransaction();
        try {
            this.PlaceComponentResult.insert((EntityInsertionAdapter<Preference>) preference);
            this.MyBillsEntityDataFactory.setTransactionSuccessful();
        } finally {
            this.MyBillsEntityDataFactory.endTransaction();
        }
    }

    @Override // androidx.work.impl.model.PreferenceDao
    public final Long KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT long_value FROM Preference where `key`=?", 1);
        if (str == null) {
            authRequestContext.bindNull(1);
        } else {
            authRequestContext.bindString(1, str);
        }
        this.MyBillsEntityDataFactory.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, authRequestContext, false);
        try {
            Long l = null;
            if (KClassImpl$Data$declaredNonStaticMembers$2.moveToFirst() && !KClassImpl$Data$declaredNonStaticMembers$2.isNull(0)) {
                l = Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getLong(0));
            }
            return l;
        } finally {
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            authRequestContext.MyBillsEntityDataFactory();
        }
    }

    /* renamed from: androidx.work.impl.model.PreferenceDao_Impl$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass2 implements Callable<Long> {
        final /* synthetic */ RoomSQLiteQuery MyBillsEntityDataFactory;
        final /* synthetic */ PreferenceDao_Impl getAuthRequestContext;

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: merged with bridge method [inline-methods] */
        public Long call() throws Exception {
            Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext.MyBillsEntityDataFactory, this.MyBillsEntityDataFactory, false);
            try {
                Long l = null;
                if (KClassImpl$Data$declaredNonStaticMembers$2.moveToFirst() && !KClassImpl$Data$declaredNonStaticMembers$2.isNull(0)) {
                    l = Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getLong(0));
                }
                return l;
            } finally {
                KClassImpl$Data$declaredNonStaticMembers$2.close();
            }
        }

        protected void finalize() {
            this.MyBillsEntityDataFactory.MyBillsEntityDataFactory();
        }
    }
}
