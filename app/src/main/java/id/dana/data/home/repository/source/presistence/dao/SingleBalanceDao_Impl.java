package id.dana.data.home.repository.source.presistence.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.google.firebase.analytics.FirebaseAnalytics;
import id.dana.data.home.repository.source.presistence.entity.SingleBalanceDaoEntity;
import java.util.Collections;
import java.util.List;

/* loaded from: classes8.dex */
public final class SingleBalanceDao_Impl implements SingleBalanceDao {
    private final EntityInsertionAdapter<SingleBalanceDaoEntity> KClassImpl$Data$declaredNonStaticMembers$2;
    private final RoomDatabase PlaceComponentResult;
    private final SharedSQLiteStatement getAuthRequestContext;

    public SingleBalanceDao_Impl(RoomDatabase roomDatabase) {
        this.PlaceComponentResult = roomDatabase;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new EntityInsertionAdapter<SingleBalanceDaoEntity>(roomDatabase) { // from class: id.dana.data.home.repository.source.presistence.dao.SingleBalanceDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `SingleBalanceDaoEntity` (`userId`,`amount`,`currency`,`placeholder`) VALUES (?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public /* synthetic */ void bind(SupportSQLiteStatement supportSQLiteStatement, SingleBalanceDaoEntity singleBalanceDaoEntity) {
                SingleBalanceDaoEntity singleBalanceDaoEntity2 = singleBalanceDaoEntity;
                if (singleBalanceDaoEntity2.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, singleBalanceDaoEntity2.KClassImpl$Data$declaredNonStaticMembers$2);
                }
                if (singleBalanceDaoEntity2.MyBillsEntityDataFactory == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, singleBalanceDaoEntity2.MyBillsEntityDataFactory);
                }
                if (singleBalanceDaoEntity2.PlaceComponentResult == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, singleBalanceDaoEntity2.PlaceComponentResult);
                }
                supportSQLiteStatement.bindLong(4, singleBalanceDaoEntity2.getGetAuthRequestContext() ? 1L : 0L);
            }
        };
        this.getAuthRequestContext = new SharedSQLiteStatement(roomDatabase) { // from class: id.dana.data.home.repository.source.presistence.dao.SingleBalanceDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM SingleBalanceDaoEntity";
            }
        };
    }

    @Override // id.dana.data.home.repository.source.presistence.dao.SingleBalanceDao
    public final long[] MyBillsEntityDataFactory(SingleBalanceDaoEntity... singleBalanceDaoEntityArr) {
        this.PlaceComponentResult.assertNotSuspendingTransaction();
        this.PlaceComponentResult.beginTransaction();
        try {
            long[] insertAndReturnIdsArray = this.KClassImpl$Data$declaredNonStaticMembers$2.insertAndReturnIdsArray(singleBalanceDaoEntityArr);
            this.PlaceComponentResult.setTransactionSuccessful();
            return insertAndReturnIdsArray;
        } finally {
            this.PlaceComponentResult.endTransaction();
        }
    }

    @Override // id.dana.data.home.repository.source.presistence.dao.SingleBalanceDao
    public final void PlaceComponentResult() {
        this.PlaceComponentResult.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.getAuthRequestContext.acquire();
        this.PlaceComponentResult.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.PlaceComponentResult.setTransactionSuccessful();
        } finally {
            this.PlaceComponentResult.endTransaction();
            this.getAuthRequestContext.release(acquire);
        }
    }

    @Override // id.dana.data.home.repository.source.presistence.dao.SingleBalanceDao
    public final SingleBalanceDaoEntity MyBillsEntityDataFactory(String str) {
        boolean z = true;
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT * FROM SingleBalanceDaoEntity WHERE userId = ? LIMIT 1", 1);
        if (str == null) {
            authRequestContext.bindNull(1);
        } else {
            authRequestContext.bindString(1, str);
        }
        this.PlaceComponentResult.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, authRequestContext, false);
        try {
            int authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "userId");
            int authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "amount");
            int authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, FirebaseAnalytics.Param.CURRENCY);
            int authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "placeholder");
            SingleBalanceDaoEntity singleBalanceDaoEntity = null;
            String string = null;
            if (KClassImpl$Data$declaredNonStaticMembers$2.moveToFirst()) {
                String string2 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext2) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2);
                String string3 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext3) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext3);
                if (!KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext4)) {
                    string = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext4);
                }
                if (KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext5) == 0) {
                    z = false;
                }
                singleBalanceDaoEntity = new SingleBalanceDaoEntity(string2, string3, string, z);
            }
            return singleBalanceDaoEntity;
        } finally {
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            authRequestContext.MyBillsEntityDataFactory();
        }
    }

    public static List<Class<?>> getAuthRequestContext() {
        return Collections.emptyList();
    }
}
