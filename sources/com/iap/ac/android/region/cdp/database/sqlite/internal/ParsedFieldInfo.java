package com.iap.ac.android.region.cdp.database.sqlite.internal;

import android.content.ContentValues;
import android.database.Cursor;
import com.iap.ac.android.acs.minioperation.a.a;
import com.iap.ac.android.region.cdp.database.annotation.IAPDatabaseField;
import com.iap.ac.android.region.cdp.database.sqlite.internal.type.BooleanType;
import com.iap.ac.android.region.cdp.database.sqlite.internal.type.ByteArrayType;
import com.iap.ac.android.region.cdp.database.sqlite.internal.type.ByteType;
import com.iap.ac.android.region.cdp.database.sqlite.internal.type.DoubleType;
import com.iap.ac.android.region.cdp.database.sqlite.internal.type.FieldType;
import com.iap.ac.android.region.cdp.database.sqlite.internal.type.FloatType;
import com.iap.ac.android.region.cdp.database.sqlite.internal.type.IntegerType;
import com.iap.ac.android.region.cdp.database.sqlite.internal.type.LongType;
import com.iap.ac.android.region.cdp.database.sqlite.internal.type.ShortType;
import com.iap.ac.android.region.cdp.database.sqlite.internal.type.StringType;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class ParsedFieldInfo {
    public static Map<Class<?>, FieldType<?>> SUPPORTED_FIELD_TYPES;
    public String mColumnName;
    public Field mField;
    public FieldType<?> mFieldType;
    public IAPDatabaseField mIAPDatabaseField;

    static {
        HashMap hashMap = new HashMap();
        SUPPORTED_FIELD_TYPES = hashMap;
        hashMap.put(Boolean.TYPE, BooleanType.getInstance());
        SUPPORTED_FIELD_TYPES.put(Boolean.class, BooleanType.getInstance());
        SUPPORTED_FIELD_TYPES.put(Byte.TYPE, ByteType.getInstance());
        SUPPORTED_FIELD_TYPES.put(Byte.class, ByteType.getInstance());
        SUPPORTED_FIELD_TYPES.put(Short.TYPE, ShortType.getInstance());
        SUPPORTED_FIELD_TYPES.put(Short.class, ShortType.getInstance());
        SUPPORTED_FIELD_TYPES.put(Integer.TYPE, IntegerType.getInstance());
        SUPPORTED_FIELD_TYPES.put(Integer.class, IntegerType.getInstance());
        SUPPORTED_FIELD_TYPES.put(Long.TYPE, LongType.getInstance());
        SUPPORTED_FIELD_TYPES.put(Long.class, LongType.getInstance());
        SUPPORTED_FIELD_TYPES.put(Float.TYPE, FloatType.getInstance());
        SUPPORTED_FIELD_TYPES.put(Float.class, FloatType.getInstance());
        SUPPORTED_FIELD_TYPES.put(Double.TYPE, DoubleType.getInstance());
        SUPPORTED_FIELD_TYPES.put(Double.class, DoubleType.getInstance());
        SUPPORTED_FIELD_TYPES.put(String.class, StringType.getInstance());
        SUPPORTED_FIELD_TYPES.put(byte[].class, ByteArrayType.getInstance());
    }

    public ParsedFieldInfo(Field field, IAPDatabaseField iAPDatabaseField) {
        parseField(field);
        setDatabaseField(iAPDatabaseField);
    }

    private void checkFieldAccessability(Field field) {
        try {
            if (field.isAccessible()) {
                return;
            }
            field.setAccessible(true);
        } catch (SecurityException unused) {
            StringBuilder sb = new StringBuilder();
            sb.append(field);
            sb.append(" can not be accessed");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public static ParsedFieldInfo create(Field field) {
        IAPDatabaseField iAPDatabaseField = (IAPDatabaseField) field.getAnnotation(IAPDatabaseField.class);
        if (iAPDatabaseField == null) {
            return null;
        }
        return new ParsedFieldInfo(field, iAPDatabaseField);
    }

    private void parseField(Field field) {
        checkFieldAccessability(field);
        Class<?> type = field.getType();
        for (Class<?> cls : SUPPORTED_FIELD_TYPES.keySet()) {
            if (cls.isAssignableFrom(type)) {
                this.mFieldType = SUPPORTED_FIELD_TYPES.get(cls);
                this.mField = field;
                this.mColumnName = field.getName();
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Field type must be one of long, int, String, byte, byte[], short, boolean, float, double: ");
        sb.append(field);
        throw new IllegalArgumentException(sb.toString());
    }

    private void setDatabaseField(IAPDatabaseField iAPDatabaseField) {
        if (iAPDatabaseField.generatedId()) {
            FieldType<?> fieldType = this.mFieldType;
            if (!(fieldType instanceof ShortType) && !(fieldType instanceof IntegerType) && !(fieldType instanceof LongType)) {
                StringBuilder a2 = a.a("Field type not supporting @generatedId for ");
                a2.append(this.mField);
                throw new IllegalArgumentException(a2.toString());
            }
        }
        if (iAPDatabaseField.id() && iAPDatabaseField.generatedId()) {
            StringBuilder a3 = a.a("Can not set both @id and @generatedId for ");
            a3.append(this.mField);
            throw new IllegalArgumentException(a3.toString());
        }
        this.mIAPDatabaseField = iAPDatabaseField;
    }

    public void assign(Object obj, Cursor cursor) throws SQLException {
        checkFieldAccessability(this.mField);
        try {
            Object cursorValue = this.mFieldType.getCursorValue(cursor, cursor.getColumnIndexOrThrow(getColumnName()));
            if (cursorValue == null && defaultValue() != null && (this.mFieldType instanceof StringType)) {
                cursorValue = defaultValue();
            }
            this.mField.set(obj, cursorValue);
        } catch (IllegalAccessException e) {
            StringBuilder a2 = a.a("Can not set field value on ");
            a2.append(this.mField);
            a2.append(" for");
            a2.append(obj);
            throw new SQLException(a2.toString(), e);
        }
    }

    public boolean canBeNull() {
        return this.mIAPDatabaseField.canBeNull();
    }

    public String defaultValue() {
        String defaultValue = this.mIAPDatabaseField.defaultValue();
        if (defaultValue.equals(IAPDatabaseField.DEFAULT_VALUE)) {
            return null;
        }
        return "".equals(defaultValue) ? "''" : defaultValue;
    }

    public String getColumnName() {
        return this.mColumnName;
    }

    public String getName() {
        return this.mField.getName();
    }

    public String getSqlType() {
        return this.mFieldType.getSqlType();
    }

    public Object getValue(Object obj) throws SQLException {
        if (obj == null) {
            return null;
        }
        checkFieldAccessability(this.mField);
        try {
            return this.mField.get(obj);
        } catch (IllegalAccessException e) {
            StringBuilder a2 = a.a("Can not get field value on ");
            a2.append(this.mField);
            a2.append(" for ");
            a2.append(obj);
            throw new SQLException(a2.toString(), e);
        }
    }

    public boolean isGeneratedId() {
        return this.mIAPDatabaseField.generatedId();
    }

    public boolean isId() {
        return this.mIAPDatabaseField.id();
    }

    public boolean isUnique() {
        return this.mIAPDatabaseField.unique();
    }

    public boolean isUniqueCombo() {
        return this.mIAPDatabaseField.uniqueCombo();
    }

    public void put(ContentValues contentValues, Object obj, boolean z) throws SQLException {
        if (obj == null || contentValues == null) {
            return;
        }
        if (z && isGeneratedId()) {
            return;
        }
        this.mFieldType.put(contentValues, getColumnName(), getValue(obj));
    }

    public void assign(Object obj, Object obj2) throws SQLException {
        checkFieldAccessability(this.mField);
        try {
            this.mField.set(obj, obj2);
        } catch (IllegalAccessException e) {
            StringBuilder a2 = a.a("Can not set field value on ");
            a2.append(this.mField);
            a2.append(" for");
            a2.append(obj);
            throw new SQLException(a2.toString(), e);
        }
    }
}
