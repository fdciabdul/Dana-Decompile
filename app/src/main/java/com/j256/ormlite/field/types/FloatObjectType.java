package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

/* loaded from: classes8.dex */
public class FloatObjectType extends BaseDataType {
    private static final FloatObjectType singleTon = new FloatObjectType();

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isEscapedValue() {
        return false;
    }

    public static FloatObjectType getSingleton() {
        return singleTon;
    }

    private FloatObjectType() {
        super(SqlType.FLOAT, new Class[]{Float.class});
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FloatObjectType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i) throws SQLException {
        return Float.valueOf(databaseResults.getFloat(i));
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object parseDefaultString(FieldType fieldType, String str) {
        return Float.valueOf(Float.parseFloat(str));
    }
}
