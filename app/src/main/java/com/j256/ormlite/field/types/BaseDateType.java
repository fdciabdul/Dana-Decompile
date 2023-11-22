package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes8.dex */
public abstract class BaseDateType extends BaseDataType {
    protected static final DateStringFormatConfig defaultDateFormatConfig = new DateStringFormatConfig("yyyy-MM-dd HH:mm:ss.SSSSSS");

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isValidForVersion() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseDateType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseDateType(SqlType sqlType) {
        super(sqlType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static DateStringFormatConfig convertDateStringConfig(FieldType fieldType, DateStringFormatConfig dateStringFormatConfig) {
        DateStringFormatConfig dateStringFormatConfig2;
        return (fieldType == null || (dateStringFormatConfig2 = (DateStringFormatConfig) fieldType.getDataTypeConfigObj()) == null) ? dateStringFormatConfig : dateStringFormatConfig2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Date parseDateString(DateStringFormatConfig dateStringFormatConfig, String str) throws ParseException {
        return dateStringFormatConfig.getDateFormat().parse(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String normalizeDateString(DateStringFormatConfig dateStringFormatConfig, String str) throws ParseException {
        DateFormat dateFormat = dateStringFormatConfig.getDateFormat();
        return dateFormat.format(dateFormat.parse(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes8.dex */
    public static class DateStringFormatConfig {
        final String dateFormatStr;
        private final ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>() { // from class: com.j256.ormlite.field.types.BaseDateType.DateStringFormatConfig.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.lang.ThreadLocal
            public DateFormat initialValue() {
                return new SimpleDateFormat(DateStringFormatConfig.this.dateFormatStr);
            }
        };

        public DateStringFormatConfig(String str) {
            this.dateFormatStr = str;
        }

        public DateFormat getDateFormat() {
            return this.threadLocal.get();
        }

        public String toString() {
            return this.dateFormatStr;
        }
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public Object moveToNextValue(Object obj) {
        long currentTimeMillis = System.currentTimeMillis();
        if (obj == null) {
            return new Date(currentTimeMillis);
        }
        if (currentTimeMillis == ((Date) obj).getTime()) {
            return new Date(currentTimeMillis + 1);
        }
        return new Date(currentTimeMillis);
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isValidForField(Field field) {
        return field.getType() == Date.class;
    }
}
