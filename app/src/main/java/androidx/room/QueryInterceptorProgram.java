package androidx.room;

import androidx.sqlite.db.SupportSQLiteProgram;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class QueryInterceptorProgram implements SupportSQLiteProgram {
    List<Object> MyBillsEntityDataFactory = new ArrayList();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindNull(int i) {
        BuiltInFictitiousFunctionClassFactory(i, null);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindLong(int i, long j) {
        BuiltInFictitiousFunctionClassFactory(i, Long.valueOf(j));
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindDouble(int i, double d) {
        BuiltInFictitiousFunctionClassFactory(i, Double.valueOf(d));
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindString(int i, String str) {
        BuiltInFictitiousFunctionClassFactory(i, str);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindBlob(int i, byte[] bArr) {
        BuiltInFictitiousFunctionClassFactory(i, bArr);
    }

    private void BuiltInFictitiousFunctionClassFactory(int i, Object obj) {
        int i2 = i - 1;
        if (i2 >= this.MyBillsEntityDataFactory.size()) {
            for (int size = this.MyBillsEntityDataFactory.size(); size <= i2; size++) {
                this.MyBillsEntityDataFactory.add(null);
            }
        }
        this.MyBillsEntityDataFactory.set(i2, obj);
    }
}
