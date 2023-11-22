package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

/* loaded from: classes8.dex */
public class BooleanIntegerType extends BooleanType {
    private static final Integer TRUE_VALUE = 1;
    private static final Integer FALSE_VALUE = 0;
    private static final BooleanIntegerType singleTon = new BooleanIntegerType();

    public static BooleanIntegerType getSingleton() {
        return singleTon;
    }

    public BooleanIntegerType() {
        super(SqlType.INTEGER);
    }

    @Override // com.j256.ormlite.field.types.BooleanObjectType, com.j256.ormlite.field.FieldConverter
    public Object parseDefaultString(FieldType fieldType, String str) {
        return javaToSqlArg(fieldType, Boolean.valueOf(Boolean.parseBoolean(str)));
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object javaToSqlArg(FieldType fieldType, Object obj) {
        return ((Boolean) obj).booleanValue() ? TRUE_VALUE : FALSE_VALUE;
    }

    @Override // com.j256.ormlite.field.types.BooleanObjectType, com.j256.ormlite.field.FieldConverter
    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i) throws SQLException {
        return Integer.valueOf(databaseResults.getInt(i));
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object sqlArgToJava(FieldType fieldType, Object obj, int i) {
        return ((Integer) obj).intValue() == 0 ? Boolean.FALSE : Boolean.TRUE;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.FieldConverter
    public Object resultStringToJava(FieldType fieldType, String str, int i) {
        if (str.length() == 0) {
            return Boolean.FALSE;
        }
        return sqlArgToJava(fieldType, Integer.valueOf(Integer.parseInt(str)), i);
    }
}
