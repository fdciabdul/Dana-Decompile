package androidx.sqlite.db;

/* loaded from: classes3.dex */
public final class SimpleSQLiteQuery implements SupportSQLiteQuery {
    private final String KClassImpl$Data$declaredNonStaticMembers$2;
    private final Object[] MyBillsEntityDataFactory;

    public SimpleSQLiteQuery(String str, Object[] objArr) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.MyBillsEntityDataFactory = objArr;
    }

    public SimpleSQLiteQuery(String str) {
        this(str, null);
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public final String KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public final void getAuthRequestContext(SupportSQLiteProgram supportSQLiteProgram) {
        PlaceComponentResult(supportSQLiteProgram, this.MyBillsEntityDataFactory);
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public final int getAuthRequestContext() {
        Object[] objArr = this.MyBillsEntityDataFactory;
        if (objArr == null) {
            return 0;
        }
        return objArr.length;
    }

    public static void PlaceComponentResult(SupportSQLiteProgram supportSQLiteProgram, Object[] objArr) {
        if (objArr == null) {
            return;
        }
        int length = objArr.length;
        int i = 0;
        while (i < length) {
            Object obj = objArr[i];
            i++;
            if (obj == null) {
                supportSQLiteProgram.bindNull(i);
            } else if (obj instanceof byte[]) {
                supportSQLiteProgram.bindBlob(i, (byte[]) obj);
            } else if (obj instanceof Float) {
                supportSQLiteProgram.bindDouble(i, ((Float) obj).floatValue());
            } else if (obj instanceof Double) {
                supportSQLiteProgram.bindDouble(i, ((Double) obj).doubleValue());
            } else if (obj instanceof Long) {
                supportSQLiteProgram.bindLong(i, ((Long) obj).longValue());
            } else if (obj instanceof Integer) {
                supportSQLiteProgram.bindLong(i, ((Integer) obj).intValue());
            } else if (obj instanceof Short) {
                supportSQLiteProgram.bindLong(i, ((Short) obj).shortValue());
            } else if (obj instanceof Byte) {
                supportSQLiteProgram.bindLong(i, ((Byte) obj).byteValue());
            } else if (obj instanceof String) {
                supportSQLiteProgram.bindString(i, (String) obj);
            } else if (obj instanceof Boolean) {
                supportSQLiteProgram.bindLong(i, ((Boolean) obj).booleanValue() ? 1L : 0L);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Cannot bind ");
                sb.append(obj);
                sb.append(" at index ");
                sb.append(i);
                sb.append(" Supported types: null, byte[], float, double, long, int, short, byte, string");
                throw new IllegalArgumentException(sb.toString());
            }
        }
    }
}
