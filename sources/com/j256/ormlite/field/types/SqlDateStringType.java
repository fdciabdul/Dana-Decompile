package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.lang.reflect.Field;
import java.sql.Date;
import java.sql.SQLException;

/* loaded from: classes8.dex */
public class SqlDateStringType extends DateStringType {
    private static final SqlDateStringType singleTon = new SqlDateStringType();

    public static SqlDateStringType getSingleton() {
        return singleTon;
    }

    private SqlDateStringType() {
        super(SqlType.STRING);
    }

    protected SqlDateStringType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    @Override // com.j256.ormlite.field.types.DateStringType, com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object sqlArgToJava(FieldType fieldType, Object obj, int i) throws SQLException {
        return new Date(((java.util.Date) super.sqlArgToJava(fieldType, obj, i)).getTime());
    }

    @Override // com.j256.ormlite.field.types.DateStringType, com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object javaToSqlArg(FieldType fieldType, Object obj) {
        return super.javaToSqlArg(fieldType, new java.util.Date(((Date) obj).getTime()));
    }

    @Override // com.j256.ormlite.field.types.BaseDateType, com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isValidForField(Field field) {
        return field.getType() == Date.class;
    }
}
