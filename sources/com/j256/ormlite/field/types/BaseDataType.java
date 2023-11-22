package com.j256.ormlite.field.types;

import com.j256.ormlite.field.BaseFieldConverter;
import com.j256.ormlite.field.DataPersister;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.lang.reflect.Field;
import java.sql.SQLException;

/* loaded from: classes8.dex */
public abstract class BaseDataType extends BaseFieldConverter implements DataPersister {
    private static final Class<?>[] NO_CLASSES = new Class[0];
    private final Class<?>[] classes;
    private final SqlType sqlType;

    @Override // com.j256.ormlite.field.DataPersister
    public Object convertIdNumber(Number number) {
        return null;
    }

    @Override // com.j256.ormlite.field.DataPersister
    public String[] getAssociatedClassNames() {
        return null;
    }

    @Override // com.j256.ormlite.field.DataPersister
    public int getDefaultWidth() {
        return 0;
    }

    @Override // com.j256.ormlite.field.DataPersister
    public String getSqlOtherType() {
        return null;
    }

    @Override // com.j256.ormlite.field.DataPersister
    public boolean isAppropriateId() {
        return true;
    }

    @Override // com.j256.ormlite.field.DataPersister
    public boolean isArgumentHolderRequired() {
        return false;
    }

    @Override // com.j256.ormlite.field.DataPersister
    public boolean isComparable() {
        return true;
    }

    @Override // com.j256.ormlite.field.DataPersister
    public boolean isEscapedValue() {
        return true;
    }

    @Override // com.j256.ormlite.field.DataPersister
    public boolean isPrimitive() {
        return false;
    }

    @Override // com.j256.ormlite.field.DataPersister
    public boolean isSelfGeneratedId() {
        return false;
    }

    @Override // com.j256.ormlite.field.DataPersister
    public boolean isValidForVersion() {
        return false;
    }

    @Override // com.j256.ormlite.field.DataPersister
    public boolean isValidGeneratedType() {
        return false;
    }

    @Override // com.j256.ormlite.field.DataPersister
    public Object makeConfigObject(FieldType fieldType) throws SQLException {
        return null;
    }

    @Override // com.j256.ormlite.field.DataPersister
    public Object moveToNextValue(Object obj) throws SQLException {
        return null;
    }

    public BaseDataType(SqlType sqlType, Class<?>[] clsArr) {
        this.sqlType = sqlType;
        this.classes = clsArr;
    }

    public BaseDataType(SqlType sqlType) {
        this.sqlType = sqlType;
        this.classes = NO_CLASSES;
    }

    @Override // com.j256.ormlite.field.DataPersister
    public boolean isValidForField(Field field) {
        Class<?>[] clsArr = this.classes;
        if (clsArr.length == 0) {
            return true;
        }
        for (Class<?> cls : clsArr) {
            if (cls.isAssignableFrom(field.getType())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.j256.ormlite.field.DataPersister
    public Class<?> getPrimaryClass() {
        Class<?>[] clsArr = this.classes;
        if (clsArr.length == 0) {
            return null;
        }
        return clsArr[0];
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public SqlType getSqlType() {
        return this.sqlType;
    }

    @Override // com.j256.ormlite.field.DataPersister
    public Class<?>[] getAssociatedClasses() {
        return this.classes;
    }

    @Override // com.j256.ormlite.field.DataPersister
    public boolean isEscapedDefaultValue() {
        return isEscapedValue();
    }

    @Override // com.j256.ormlite.field.DataPersister
    public Object generateId() {
        throw new IllegalStateException("Should not have tried to generate this type");
    }

    @Override // com.j256.ormlite.field.DataPersister
    public boolean dataIsEqual(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        } else if (obj2 == null) {
            return false;
        } else {
            return obj.equals(obj2);
        }
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object resultStringToJava(FieldType fieldType, String str, int i) throws SQLException {
        return sqlArgToJava(fieldType, parseDefaultString(fieldType, str), i);
    }
}
