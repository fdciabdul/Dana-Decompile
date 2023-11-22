package androidx.room;

import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.concurrent.Executor;

/* loaded from: classes6.dex */
final class QueryInterceptorOpenHelper implements SupportSQLiteOpenHelper, DelegatingOpenHelper {
    private final RoomDatabase.QueryCallback MyBillsEntityDataFactory;
    private final SupportSQLiteOpenHelper PlaceComponentResult;
    private final Executor getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public QueryInterceptorOpenHelper(SupportSQLiteOpenHelper supportSQLiteOpenHelper, RoomDatabase.QueryCallback queryCallback, Executor executor) {
        this.PlaceComponentResult = supportSQLiteOpenHelper;
        this.MyBillsEntityDataFactory = queryCallback;
        this.getAuthRequestContext = executor;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public final String getDatabaseName() {
        return this.PlaceComponentResult.getDatabaseName();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public final void setWriteAheadLoggingEnabled(boolean z) {
        this.PlaceComponentResult.setWriteAheadLoggingEnabled(z);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public final SupportSQLiteDatabase getWritableDatabase() {
        return new QueryInterceptorDatabase(this.PlaceComponentResult.getWritableDatabase(), this.MyBillsEntityDataFactory, this.getAuthRequestContext);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public final SupportSQLiteDatabase getReadableDatabase() {
        return new QueryInterceptorDatabase(this.PlaceComponentResult.getReadableDatabase(), this.MyBillsEntityDataFactory, this.getAuthRequestContext);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.PlaceComponentResult.close();
    }

    @Override // androidx.room.DelegatingOpenHelper
    public final SupportSQLiteOpenHelper PlaceComponentResult() {
        return this.PlaceComponentResult;
    }
}
