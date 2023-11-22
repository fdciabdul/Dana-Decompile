package androidx.sqlite.db.framework;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Pair;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
class FrameworkSQLiteOpenHelper implements SupportSQLiteOpenHelper {
    private final String BuiltInFictitiousFunctionClassFactory;
    private final Context KClassImpl$Data$declaredNonStaticMembers$2;
    private final Object MyBillsEntityDataFactory = new Object();
    private final SupportSQLiteOpenHelper.Callback PlaceComponentResult;
    private OpenHelper getAuthRequestContext;
    private final boolean getErrorConfigVersion;
    private boolean lookAheadTest;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FrameworkSQLiteOpenHelper(Context context, String str, SupportSQLiteOpenHelper.Callback callback, boolean z) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.PlaceComponentResult = callback;
        this.getErrorConfigVersion = z;
    }

    private OpenHelper PlaceComponentResult() {
        OpenHelper openHelper;
        synchronized (this.MyBillsEntityDataFactory) {
            if (this.getAuthRequestContext == null) {
                FrameworkSQLiteDatabase[] frameworkSQLiteDatabaseArr = new FrameworkSQLiteDatabase[1];
                if (Build.VERSION.SDK_INT >= 23 && this.BuiltInFictitiousFunctionClassFactory != null && this.getErrorConfigVersion) {
                    this.getAuthRequestContext = new OpenHelper(this.KClassImpl$Data$declaredNonStaticMembers$2, new File(SupportSQLiteCompat.Api21Impl.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), this.BuiltInFictitiousFunctionClassFactory).getAbsolutePath(), frameworkSQLiteDatabaseArr, this.PlaceComponentResult);
                } else {
                    this.getAuthRequestContext = new OpenHelper(this.KClassImpl$Data$declaredNonStaticMembers$2, this.BuiltInFictitiousFunctionClassFactory, frameworkSQLiteDatabaseArr, this.PlaceComponentResult);
                }
                if (Build.VERSION.SDK_INT >= 16) {
                    SupportSQLiteCompat.Api16Impl.getAuthRequestContext(this.getAuthRequestContext, this.lookAheadTest);
                }
            }
            openHelper = this.getAuthRequestContext;
        }
        return openHelper;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public void setWriteAheadLoggingEnabled(boolean z) {
        synchronized (this.MyBillsEntityDataFactory) {
            OpenHelper openHelper = this.getAuthRequestContext;
            if (openHelper != null) {
                SupportSQLiteCompat.Api16Impl.getAuthRequestContext(openHelper, z);
            }
            this.lookAheadTest = z;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getWritableDatabase() {
        return PlaceComponentResult().PlaceComponentResult();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getReadableDatabase() {
        return PlaceComponentResult().BuiltInFictitiousFunctionClassFactory();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        PlaceComponentResult().close();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class OpenHelper extends SQLiteOpenHelper {
        private boolean KClassImpl$Data$declaredNonStaticMembers$2;
        final SupportSQLiteOpenHelper.Callback MyBillsEntityDataFactory;
        final FrameworkSQLiteDatabase[] getAuthRequestContext;

        OpenHelper(Context context, String str, final FrameworkSQLiteDatabase[] frameworkSQLiteDatabaseArr, final SupportSQLiteOpenHelper.Callback callback) {
            super(context, str, null, callback.KClassImpl$Data$declaredNonStaticMembers$2, new DatabaseErrorHandler() { // from class: androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.1
                @Override // android.database.DatabaseErrorHandler
                public void onCorruption(SQLiteDatabase sQLiteDatabase) {
                    FrameworkSQLiteDatabase PlaceComponentResult = OpenHelper.PlaceComponentResult(frameworkSQLiteDatabaseArr, sQLiteDatabase);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Corruption reported by sqlite on database: ");
                    sb.append(PlaceComponentResult.getPath());
                    InstrumentInjector.log_e("SupportSQLite", sb.toString());
                    if (!PlaceComponentResult.isOpen()) {
                        SupportSQLiteOpenHelper.Callback.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.getPath());
                        return;
                    }
                    List<Pair<String, String>> list = null;
                    try {
                        try {
                            list = PlaceComponentResult.getAttachedDbs();
                        } catch (SQLiteException unused) {
                        }
                        try {
                            PlaceComponentResult.close();
                        } catch (IOException unused2) {
                        }
                    } finally {
                        if (list != null) {
                            Iterator<Pair<String, String>> it = list.iterator();
                            while (it.hasNext()) {
                                SupportSQLiteOpenHelper.Callback.KClassImpl$Data$declaredNonStaticMembers$2((String) it.next().second);
                            }
                        } else {
                            SupportSQLiteOpenHelper.Callback.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.getPath());
                        }
                    }
                }
            });
            this.MyBillsEntityDataFactory = callback;
            this.getAuthRequestContext = frameworkSQLiteDatabaseArr;
        }

        final SupportSQLiteDatabase PlaceComponentResult() {
            synchronized (this) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
                SQLiteDatabase writableDatabase = super.getWritableDatabase();
                if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                    close();
                    return PlaceComponentResult();
                }
                return KClassImpl$Data$declaredNonStaticMembers$2(writableDatabase);
            }
        }

        final SupportSQLiteDatabase BuiltInFictitiousFunctionClassFactory() {
            synchronized (this) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
                SQLiteDatabase readableDatabase = super.getReadableDatabase();
                if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                    close();
                    return BuiltInFictitiousFunctionClassFactory();
                }
                FrameworkSQLiteDatabase[] frameworkSQLiteDatabaseArr = this.getAuthRequestContext;
                FrameworkSQLiteDatabase frameworkSQLiteDatabase = frameworkSQLiteDatabaseArr[0];
                if (frameworkSQLiteDatabase == null || !frameworkSQLiteDatabase.BuiltInFictitiousFunctionClassFactory(readableDatabase)) {
                    frameworkSQLiteDatabaseArr[0] = new FrameworkSQLiteDatabase(readableDatabase);
                }
                return frameworkSQLiteDatabaseArr[0];
            }
        }

        private FrameworkSQLiteDatabase KClassImpl$Data$declaredNonStaticMembers$2(SQLiteDatabase sQLiteDatabase) {
            FrameworkSQLiteDatabase[] frameworkSQLiteDatabaseArr = this.getAuthRequestContext;
            FrameworkSQLiteDatabase frameworkSQLiteDatabase = frameworkSQLiteDatabaseArr[0];
            if (frameworkSQLiteDatabase == null || !frameworkSQLiteDatabase.BuiltInFictitiousFunctionClassFactory(sQLiteDatabase)) {
                frameworkSQLiteDatabaseArr[0] = new FrameworkSQLiteDatabase(sQLiteDatabase);
            }
            return frameworkSQLiteDatabaseArr[0];
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            this.MyBillsEntityDataFactory.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2(sQLiteDatabase), i, i2);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            KClassImpl$Data$declaredNonStaticMembers$2(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2(sQLiteDatabase), i, i2);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                return;
            }
            this.MyBillsEntityDataFactory.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public void close() {
            synchronized (this) {
                super.close();
                this.getAuthRequestContext[0] = null;
            }
        }

        static FrameworkSQLiteDatabase PlaceComponentResult(FrameworkSQLiteDatabase[] frameworkSQLiteDatabaseArr, SQLiteDatabase sQLiteDatabase) {
            FrameworkSQLiteDatabase frameworkSQLiteDatabase = frameworkSQLiteDatabaseArr[0];
            if (frameworkSQLiteDatabase == null || !frameworkSQLiteDatabase.BuiltInFictitiousFunctionClassFactory(sQLiteDatabase)) {
                frameworkSQLiteDatabaseArr[0] = new FrameworkSQLiteDatabase(sQLiteDatabase);
            }
            return frameworkSQLiteDatabaseArr[0];
        }
    }
}
