package androidx.room.migration;

import androidx.sqlite.db.SupportSQLiteDatabase;

/* loaded from: classes3.dex */
public abstract class Migration {
    public final int BuiltInFictitiousFunctionClassFactory;
    public final int MyBillsEntityDataFactory;

    public abstract void MyBillsEntityDataFactory(SupportSQLiteDatabase supportSQLiteDatabase);

    public Migration(int i, int i2) {
        this.BuiltInFictitiousFunctionClassFactory = i;
        this.MyBillsEntityDataFactory = i2;
    }
}
