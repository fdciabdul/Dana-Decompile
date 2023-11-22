package androidx.room;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class QueryInterceptorDatabase implements SupportSQLiteDatabase {
    final RoomDatabase.QueryCallback BuiltInFictitiousFunctionClassFactory;
    private final Executor PlaceComponentResult;
    private final SupportSQLiteDatabase getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public QueryInterceptorDatabase(SupportSQLiteDatabase supportSQLiteDatabase, RoomDatabase.QueryCallback queryCallback, Executor executor) {
        this.getAuthRequestContext = supportSQLiteDatabase;
        this.BuiltInFictitiousFunctionClassFactory = queryCallback;
        this.PlaceComponentResult = executor;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final SupportSQLiteStatement compileStatement(String str) {
        return new QueryInterceptorStatement(this.getAuthRequestContext.compileStatement(str), this.BuiltInFictitiousFunctionClassFactory, str, this.PlaceComponentResult);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void beginTransaction() {
        this.PlaceComponentResult.execute(new Runnable() { // from class: androidx.room.QueryInterceptorDatabase$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                RoomDatabase.QueryCallback queryCallback = QueryInterceptorDatabase.this.BuiltInFictitiousFunctionClassFactory;
                Collections.emptyList();
            }
        });
        this.getAuthRequestContext.beginTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void beginTransactionNonExclusive() {
        this.PlaceComponentResult.execute(new Runnable() { // from class: androidx.room.QueryInterceptorDatabase$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                RoomDatabase.QueryCallback queryCallback = QueryInterceptorDatabase.this.BuiltInFictitiousFunctionClassFactory;
                Collections.emptyList();
            }
        });
        this.getAuthRequestContext.beginTransactionNonExclusive();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void endTransaction() {
        this.PlaceComponentResult.execute(new Runnable() { // from class: androidx.room.QueryInterceptorDatabase$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                RoomDatabase.QueryCallback queryCallback = QueryInterceptorDatabase.this.BuiltInFictitiousFunctionClassFactory;
                Collections.emptyList();
            }
        });
        this.getAuthRequestContext.endTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void setTransactionSuccessful() {
        this.PlaceComponentResult.execute(new Runnable() { // from class: androidx.room.QueryInterceptorDatabase$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                RoomDatabase.QueryCallback queryCallback = QueryInterceptorDatabase.this.BuiltInFictitiousFunctionClassFactory;
                Collections.emptyList();
            }
        });
        this.getAuthRequestContext.setTransactionSuccessful();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean inTransaction() {
        return this.getAuthRequestContext.inTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean isDbLockedByCurrentThread() {
        return this.getAuthRequestContext.isDbLockedByCurrentThread();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean yieldIfContendedSafely() {
        return this.getAuthRequestContext.yieldIfContendedSafely();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final int getVersion() {
        return this.getAuthRequestContext.getVersion();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void setVersion(int i) {
        this.getAuthRequestContext.setVersion(i);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final long getMaximumSize() {
        return this.getAuthRequestContext.getMaximumSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final long setMaximumSize(long j) {
        return this.getAuthRequestContext.setMaximumSize(j);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final long getPageSize() {
        return this.getAuthRequestContext.getPageSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void setPageSize(long j) {
        this.getAuthRequestContext.setPageSize(j);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final Cursor query(final String str) {
        this.PlaceComponentResult.execute(new Runnable() { // from class: androidx.room.QueryInterceptorDatabase$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                RoomDatabase.QueryCallback queryCallback = QueryInterceptorDatabase.this.BuiltInFictitiousFunctionClassFactory;
                Collections.emptyList();
            }
        });
        return this.getAuthRequestContext.query(str);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final Cursor query(final SupportSQLiteQuery supportSQLiteQuery) {
        final QueryInterceptorProgram queryInterceptorProgram = new QueryInterceptorProgram();
        supportSQLiteQuery.getAuthRequestContext(queryInterceptorProgram);
        this.PlaceComponentResult.execute(new Runnable() { // from class: androidx.room.QueryInterceptorDatabase$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase queryInterceptorDatabase = QueryInterceptorDatabase.this;
                SupportSQLiteQuery supportSQLiteQuery2 = supportSQLiteQuery;
                QueryInterceptorProgram queryInterceptorProgram2 = queryInterceptorProgram;
                RoomDatabase.QueryCallback queryCallback = queryInterceptorDatabase.BuiltInFictitiousFunctionClassFactory;
                supportSQLiteQuery2.KClassImpl$Data$declaredNonStaticMembers$2();
                List<Object> list = queryInterceptorProgram2.MyBillsEntityDataFactory;
            }
        });
        return this.getAuthRequestContext.query(supportSQLiteQuery);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final Cursor query(final SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal) {
        final QueryInterceptorProgram queryInterceptorProgram = new QueryInterceptorProgram();
        supportSQLiteQuery.getAuthRequestContext(queryInterceptorProgram);
        this.PlaceComponentResult.execute(new Runnable() { // from class: androidx.room.QueryInterceptorDatabase$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase queryInterceptorDatabase = QueryInterceptorDatabase.this;
                SupportSQLiteQuery supportSQLiteQuery2 = supportSQLiteQuery;
                QueryInterceptorProgram queryInterceptorProgram2 = queryInterceptorProgram;
                RoomDatabase.QueryCallback queryCallback = queryInterceptorDatabase.BuiltInFictitiousFunctionClassFactory;
                supportSQLiteQuery2.KClassImpl$Data$declaredNonStaticMembers$2();
                List<Object> list = queryInterceptorProgram2.MyBillsEntityDataFactory;
            }
        });
        return this.getAuthRequestContext.query(supportSQLiteQuery);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final long insert(String str, int i, ContentValues contentValues) throws SQLException {
        return this.getAuthRequestContext.insert(str, i, contentValues);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final int delete(String str, String str2, Object[] objArr) {
        return this.getAuthRequestContext.delete(str, str2, objArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final int update(String str, int i, ContentValues contentValues, String str2, Object[] objArr) {
        return this.getAuthRequestContext.update(str, i, contentValues, str2, objArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void execSQL(final String str) throws SQLException {
        this.PlaceComponentResult.execute(new Runnable() { // from class: androidx.room.QueryInterceptorDatabase$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                RoomDatabase.QueryCallback queryCallback = QueryInterceptorDatabase.this.BuiltInFictitiousFunctionClassFactory;
                new ArrayList(0);
            }
        });
        this.getAuthRequestContext.execSQL(str);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void execSQL(final String str, Object[] objArr) throws SQLException {
        final ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(objArr));
        this.PlaceComponentResult.execute(new Runnable() { // from class: androidx.room.QueryInterceptorDatabase$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
            }
        });
        this.getAuthRequestContext.execSQL(str, arrayList.toArray());
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean isReadOnly() {
        return this.getAuthRequestContext.isReadOnly();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean isOpen() {
        return this.getAuthRequestContext.isOpen();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean needUpgrade(int i) {
        return this.getAuthRequestContext.needUpgrade(i);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final String getPath() {
        return this.getAuthRequestContext.getPath();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void setLocale(Locale locale) {
        this.getAuthRequestContext.setLocale(locale);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void setMaxSqlCacheSize(int i) {
        this.getAuthRequestContext.setMaxSqlCacheSize(i);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void setForeignKeyConstraintsEnabled(boolean z) {
        this.getAuthRequestContext.setForeignKeyConstraintsEnabled(z);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean isWriteAheadLoggingEnabled() {
        return this.getAuthRequestContext.isWriteAheadLoggingEnabled();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final List<Pair<String, String>> getAttachedDbs() {
        return this.getAuthRequestContext.getAttachedDbs();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean isDatabaseIntegrityOk() {
        return this.getAuthRequestContext.isDatabaseIntegrityOk();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.getAuthRequestContext.close();
    }
}
