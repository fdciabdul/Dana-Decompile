package androidx.room;

import androidx.arch.core.util.Function;
import androidx.room.AutoClosingRoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;

/* loaded from: classes6.dex */
public final /* synthetic */ class AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$$ExternalSyntheticLambda2 implements Function {
    public final /* synthetic */ Function MyBillsEntityDataFactory;
    public final /* synthetic */ AutoClosingRoomOpenHelper.AutoClosingSupportSqliteStatement PlaceComponentResult;

    public /* synthetic */ AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$$ExternalSyntheticLambda2(AutoClosingRoomOpenHelper.AutoClosingSupportSqliteStatement autoClosingSupportSqliteStatement, Function function) {
        this.PlaceComponentResult = autoClosingSupportSqliteStatement;
        this.MyBillsEntityDataFactory = function;
    }

    @Override // androidx.arch.core.util.Function
    public final Object getAuthRequestContext(Object obj) {
        AutoClosingRoomOpenHelper.AutoClosingSupportSqliteStatement autoClosingSupportSqliteStatement = this.PlaceComponentResult;
        Function function = this.MyBillsEntityDataFactory;
        SupportSQLiteStatement compileStatement = ((SupportSQLiteDatabase) obj).compileStatement(autoClosingSupportSqliteStatement.PlaceComponentResult);
        int i = 0;
        while (i < autoClosingSupportSqliteStatement.getAuthRequestContext.size()) {
            int i2 = i + 1;
            Object obj2 = autoClosingSupportSqliteStatement.getAuthRequestContext.get(i);
            if (obj2 == null) {
                compileStatement.bindNull(i2);
            } else if (obj2 instanceof Long) {
                compileStatement.bindLong(i2, ((Long) obj2).longValue());
            } else if (obj2 instanceof Double) {
                compileStatement.bindDouble(i2, ((Double) obj2).doubleValue());
            } else if (obj2 instanceof String) {
                compileStatement.bindString(i2, (String) obj2);
            } else if (obj2 instanceof byte[]) {
                compileStatement.bindBlob(i2, (byte[]) obj2);
            }
            i = i2;
        }
        return function.getAuthRequestContext(compileStatement);
    }
}
