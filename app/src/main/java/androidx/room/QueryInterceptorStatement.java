package androidx.room;

import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class QueryInterceptorStatement implements SupportSQLiteStatement {
    private final Executor BuiltInFictitiousFunctionClassFactory;
    private final List<Object> KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList();
    private final RoomDatabase.QueryCallback MyBillsEntityDataFactory;
    private final String PlaceComponentResult;
    private final SupportSQLiteStatement getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public QueryInterceptorStatement(SupportSQLiteStatement supportSQLiteStatement, RoomDatabase.QueryCallback queryCallback, String str, Executor executor) {
        this.getAuthRequestContext = supportSQLiteStatement;
        this.MyBillsEntityDataFactory = queryCallback;
        this.PlaceComponentResult = str;
        this.BuiltInFictitiousFunctionClassFactory = executor;
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public final void execute() {
        this.BuiltInFictitiousFunctionClassFactory.execute(new Runnable() { // from class: androidx.room.QueryInterceptorStatement$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
            }
        });
        this.getAuthRequestContext.execute();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public final int executeUpdateDelete() {
        this.BuiltInFictitiousFunctionClassFactory.execute(new Runnable() { // from class: androidx.room.QueryInterceptorStatement$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
            }
        });
        return this.getAuthRequestContext.executeUpdateDelete();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public final long executeInsert() {
        this.BuiltInFictitiousFunctionClassFactory.execute(new Runnable() { // from class: androidx.room.QueryInterceptorStatement$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
            }
        });
        return this.getAuthRequestContext.executeInsert();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public final long simpleQueryForLong() {
        this.BuiltInFictitiousFunctionClassFactory.execute(new Runnable() { // from class: androidx.room.QueryInterceptorStatement$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
            }
        });
        return this.getAuthRequestContext.simpleQueryForLong();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public final String simpleQueryForString() {
        this.BuiltInFictitiousFunctionClassFactory.execute(new Runnable() { // from class: androidx.room.QueryInterceptorStatement$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
            }
        });
        return this.getAuthRequestContext.simpleQueryForString();
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindNull(int i) {
        BuiltInFictitiousFunctionClassFactory(i, this.KClassImpl$Data$declaredNonStaticMembers$2.toArray());
        this.getAuthRequestContext.bindNull(i);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindLong(int i, long j) {
        BuiltInFictitiousFunctionClassFactory(i, Long.valueOf(j));
        this.getAuthRequestContext.bindLong(i, j);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindDouble(int i, double d) {
        BuiltInFictitiousFunctionClassFactory(i, Double.valueOf(d));
        this.getAuthRequestContext.bindDouble(i, d);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindString(int i, String str) {
        BuiltInFictitiousFunctionClassFactory(i, str);
        this.getAuthRequestContext.bindString(i, str);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindBlob(int i, byte[] bArr) {
        BuiltInFictitiousFunctionClassFactory(i, bArr);
        this.getAuthRequestContext.bindBlob(i, bArr);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.getAuthRequestContext.close();
    }

    private void BuiltInFictitiousFunctionClassFactory(int i, Object obj) {
        int i2 = i - 1;
        if (i2 >= this.KClassImpl$Data$declaredNonStaticMembers$2.size()) {
            for (int size = this.KClassImpl$Data$declaredNonStaticMembers$2.size(); size <= i2; size++) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.add(null);
            }
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.set(i2, obj);
    }
}
