package androidx.room;

import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class SQLiteCopyOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {
    private final File BuiltInFictitiousFunctionClassFactory;
    private final String KClassImpl$Data$declaredNonStaticMembers$2;
    private final Callable<InputStream> MyBillsEntityDataFactory;
    private final SupportSQLiteOpenHelper.Factory PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SQLiteCopyOpenHelperFactory(String str, File file, Callable<InputStream> callable, SupportSQLiteOpenHelper.Factory factory) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.BuiltInFictitiousFunctionClassFactory = file;
        this.MyBillsEntityDataFactory = callable;
        this.PlaceComponentResult = factory;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration configuration) {
        return new SQLiteCopyOpenHelper(configuration.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2, this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory, configuration.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult.create(configuration));
    }
}
