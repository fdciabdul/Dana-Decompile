package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

/* loaded from: classes8.dex */
public class DoubleObjectType extends BaseDataType {
    private static final DoubleObjectType singleTon = new DoubleObjectType();

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isEscapedValue() {
        return false;
    }

    public static DoubleObjectType getSingleton() {
        return singleTon;
    }

    private DoubleObjectType() {
        super(SqlType.DOUBLE, new Class[]{Double.class});
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DoubleObjectType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object parseDefaultString(FieldType fieldType, String str) {
        return Double.valueOf(Double.parseDouble(str));
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i) throws SQLException {
        return Double.valueOf(databaseResults.getDouble(i));
    }
}
