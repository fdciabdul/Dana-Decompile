package com.j256.ormlite.stmt;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.sql.SQLException;

/* loaded from: classes8.dex */
public abstract class BaseArgumentHolder implements ArgumentHolder {
    private String columnName;
    private FieldType fieldType;
    private SqlType sqlType;

    protected abstract Object getValue();

    protected abstract boolean isValueSet();

    @Override // com.j256.ormlite.stmt.ArgumentHolder
    public abstract void setValue(Object obj);

    public BaseArgumentHolder() {
        this.columnName = null;
        this.fieldType = null;
        this.sqlType = null;
    }

    public BaseArgumentHolder(String str) {
        this.fieldType = null;
        this.sqlType = null;
        this.columnName = str;
    }

    public BaseArgumentHolder(SqlType sqlType) {
        this.columnName = null;
        this.fieldType = null;
        this.sqlType = sqlType;
    }

    @Override // com.j256.ormlite.stmt.ArgumentHolder
    public String getColumnName() {
        return this.columnName;
    }

    @Override // com.j256.ormlite.stmt.ArgumentHolder
    public void setMetaInfo(String str) {
        String str2 = this.columnName;
        if (str2 != null && !str2.equals(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Column name cannot be set twice from ");
            sb.append(this.columnName);
            sb.append(" to ");
            sb.append(str);
            sb.append(".  Using a SelectArg twice in query with different columns?");
            throw new IllegalArgumentException(sb.toString());
        }
        this.columnName = str;
    }

    @Override // com.j256.ormlite.stmt.ArgumentHolder
    public void setMetaInfo(FieldType fieldType) {
        FieldType fieldType2 = this.fieldType;
        if (fieldType2 != null && fieldType2 != fieldType) {
            StringBuilder sb = new StringBuilder();
            sb.append("FieldType name cannot be set twice from ");
            sb.append(this.fieldType);
            sb.append(" to ");
            sb.append(fieldType);
            sb.append(".  Using a SelectArg twice in query with different columns?");
            throw new IllegalArgumentException(sb.toString());
        }
        this.fieldType = fieldType;
    }

    @Override // com.j256.ormlite.stmt.ArgumentHolder
    public void setMetaInfo(String str, FieldType fieldType) {
        setMetaInfo(str);
        setMetaInfo(fieldType);
    }

    @Override // com.j256.ormlite.stmt.ArgumentHolder
    public Object getSqlArgValue() throws SQLException {
        if (!isValueSet()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Column value has not been set for ");
            sb.append(this.columnName);
            throw new SQLException(sb.toString());
        }
        Object value = getValue();
        if (value == null) {
            return null;
        }
        FieldType fieldType = this.fieldType;
        if (fieldType == null) {
            return value;
        }
        if (fieldType.isForeign() && this.fieldType.getType() == value.getClass()) {
            return this.fieldType.getForeignRefField().extractJavaFieldValue(value);
        }
        return this.fieldType.convertJavaFieldToSqlArgValue(value);
    }

    @Override // com.j256.ormlite.stmt.ArgumentHolder
    public FieldType getFieldType() {
        return this.fieldType;
    }

    @Override // com.j256.ormlite.stmt.ArgumentHolder
    public SqlType getSqlType() {
        return this.sqlType;
    }

    public String toString() {
        if (isValueSet()) {
            try {
                Object sqlArgValue = getSqlArgValue();
                return sqlArgValue == null ? "[null]" : sqlArgValue.toString();
            } catch (SQLException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("[could not get value: ");
                sb.append(e);
                sb.append("]");
                return sb.toString();
            }
        }
        return "[unset]";
    }
}
