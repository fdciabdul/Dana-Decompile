package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.field.types.BaseDateType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

/* loaded from: classes8.dex */
public class DateStringType extends BaseDateType {
    public static int DEFAULT_WIDTH = 50;
    private static final DateStringType singleTon = new DateStringType();

    public static DateStringType getSingleton() {
        return singleTon;
    }

    private DateStringType() {
        super(SqlType.STRING);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DateStringType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DateStringType(SqlType sqlType) {
        super(sqlType);
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object parseDefaultString(FieldType fieldType, String str) throws SQLException {
        BaseDateType.DateStringFormatConfig convertDateStringConfig = convertDateStringConfig(fieldType, defaultDateFormatConfig);
        try {
            return normalizeDateString(convertDateStringConfig, str);
        } catch (ParseException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Problems with field ");
            sb.append(fieldType);
            sb.append(" parsing default date-string '");
            sb.append(str);
            sb.append("' using '");
            sb.append(convertDateStringConfig);
            sb.append("'");
            throw SqlExceptionUtil.create(sb.toString(), e);
        }
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i) throws SQLException {
        return databaseResults.getString(i);
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object sqlArgToJava(FieldType fieldType, Object obj, int i) throws SQLException {
        String str = (String) obj;
        BaseDateType.DateStringFormatConfig convertDateStringConfig = convertDateStringConfig(fieldType, defaultDateFormatConfig);
        try {
            return parseDateString(convertDateStringConfig, str);
        } catch (ParseException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Problems with column ");
            sb.append(i);
            sb.append(" parsing date-string '");
            sb.append(str);
            sb.append("' using '");
            sb.append(convertDateStringConfig);
            sb.append("'");
            throw SqlExceptionUtil.create(sb.toString(), e);
        }
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object javaToSqlArg(FieldType fieldType, Object obj) {
        return convertDateStringConfig(fieldType, defaultDateFormatConfig).getDateFormat().format((Date) obj);
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public Object makeConfigObject(FieldType fieldType) {
        String format = fieldType.getFormat();
        if (format == null) {
            return defaultDateFormatConfig;
        }
        return new BaseDateType.DateStringFormatConfig(format);
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public int getDefaultWidth() {
        return DEFAULT_WIDTH;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.FieldConverter
    public Object resultStringToJava(FieldType fieldType, String str, int i) throws SQLException {
        return sqlArgToJava(fieldType, str, i);
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public Class<?> getPrimaryClass() {
        return byte[].class;
    }
}
