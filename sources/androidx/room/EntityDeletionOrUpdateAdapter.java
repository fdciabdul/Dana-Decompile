package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;

/* loaded from: classes6.dex */
public abstract class EntityDeletionOrUpdateAdapter<T> extends SharedSQLiteStatement {
    protected abstract void BuiltInFictitiousFunctionClassFactory(SupportSQLiteStatement supportSQLiteStatement, T t);

    @Override // androidx.room.SharedSQLiteStatement
    protected abstract String createQuery();

    public EntityDeletionOrUpdateAdapter(RoomDatabase roomDatabase) {
        super(roomDatabase);
    }

    public final int BuiltInFictitiousFunctionClassFactory(T t) {
        SupportSQLiteStatement acquire = acquire();
        try {
            BuiltInFictitiousFunctionClassFactory(acquire, t);
            return acquire.executeUpdateDelete();
        } finally {
            release(acquire);
        }
    }

    public final int getAuthRequestContext(T[] tArr) {
        SupportSQLiteStatement acquire = acquire();
        try {
            int i = 0;
            for (T t : tArr) {
                BuiltInFictitiousFunctionClassFactory(acquire, t);
                i += acquire.executeUpdateDelete();
            }
            return i;
        } finally {
            release(acquire);
        }
    }
}
