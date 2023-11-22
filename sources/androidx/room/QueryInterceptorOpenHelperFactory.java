package androidx.room;

import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class QueryInterceptorOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {
    private final Executor KClassImpl$Data$declaredNonStaticMembers$2;
    private final RoomDatabase.QueryCallback PlaceComponentResult;
    private final SupportSQLiteOpenHelper.Factory getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public QueryInterceptorOpenHelperFactory(SupportSQLiteOpenHelper.Factory factory, RoomDatabase.QueryCallback queryCallback, Executor executor) {
        this.getAuthRequestContext = factory;
        this.PlaceComponentResult = queryCallback;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = executor;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    public final SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration configuration) {
        return new QueryInterceptorOpenHelper(this.getAuthRequestContext.create(configuration), this.PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2);
    }
}
