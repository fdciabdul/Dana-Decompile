package androidx.sqlite.db.framework;

import androidx.sqlite.db.SupportSQLiteOpenHelper;

/* loaded from: classes3.dex */
public final class FrameworkSQLiteOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {
    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    public final SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration configuration) {
        return new FrameworkSQLiteOpenHelper(configuration.BuiltInFictitiousFunctionClassFactory, configuration.PlaceComponentResult, configuration.KClassImpl$Data$declaredNonStaticMembers$2, configuration.MyBillsEntityDataFactory);
    }
}
