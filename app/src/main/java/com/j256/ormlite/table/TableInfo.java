package com.j256.ormlite.table;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.BaseDaoEnabled;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.ConnectionSource;
import id.dana.cashier.view.InputCardNumberView;
import java.lang.reflect.Constructor;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class TableInfo<T, ID> {
    private static final FieldType[] NO_FOREIGN_COLLECTIONS = new FieldType[0];
    private final BaseDaoImpl<T, ID> baseDaoImpl;
    private final Constructor<T> constructor;
    private final Class<T> dataClass;
    private Map<String, FieldType> fieldNameMap;
    private final FieldType[] fieldTypes;
    private final boolean foreignAutoCreate;
    private final FieldType[] foreignCollections;
    private final FieldType idField;
    private final String tableName;

    public TableInfo(ConnectionSource connectionSource, BaseDaoImpl<T, ID> baseDaoImpl, Class<T> cls) throws SQLException {
        this(connectionSource.getDatabaseType(), baseDaoImpl, DatabaseTableConfig.fromClass(connectionSource, cls));
    }

    public TableInfo(DatabaseType databaseType, BaseDaoImpl<T, ID> baseDaoImpl, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        this.baseDaoImpl = baseDaoImpl;
        this.dataClass = databaseTableConfig.getDataClass();
        this.tableName = databaseTableConfig.getTableName();
        FieldType[] fieldTypes = databaseTableConfig.getFieldTypes(databaseType);
        this.fieldTypes = fieldTypes;
        FieldType fieldType = null;
        boolean z = false;
        int i = 0;
        for (FieldType fieldType2 : fieldTypes) {
            if (fieldType2.isId() || fieldType2.isGeneratedId() || fieldType2.isGeneratedIdSequence()) {
                if (fieldType != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("More than 1 idField configured for class ");
                    sb.append(this.dataClass);
                    sb.append(" (");
                    sb.append(fieldType);
                    sb.append(",");
                    sb.append(fieldType2);
                    sb.append(")");
                    throw new SQLException(sb.toString());
                }
                fieldType = fieldType2;
            }
            z = fieldType2.isForeignAutoCreate() ? true : z;
            if (fieldType2.isForeignCollection()) {
                i++;
            }
        }
        this.idField = fieldType;
        this.constructor = databaseTableConfig.getConstructor();
        this.foreignAutoCreate = z;
        if (i == 0) {
            this.foreignCollections = NO_FOREIGN_COLLECTIONS;
            return;
        }
        this.foreignCollections = new FieldType[i];
        int i2 = 0;
        for (FieldType fieldType3 : this.fieldTypes) {
            if (fieldType3.isForeignCollection()) {
                this.foreignCollections[i2] = fieldType3;
                i2++;
            }
        }
    }

    public Class<T> getDataClass() {
        return this.dataClass;
    }

    public String getTableName() {
        return this.tableName;
    }

    public FieldType[] getFieldTypes() {
        return this.fieldTypes;
    }

    public FieldType getFieldTypeByColumnName(String str) {
        if (this.fieldNameMap == null) {
            HashMap hashMap = new HashMap();
            for (FieldType fieldType : this.fieldTypes) {
                hashMap.put(fieldType.getColumnName().toLowerCase(), fieldType);
            }
            this.fieldNameMap = hashMap;
        }
        FieldType fieldType2 = this.fieldNameMap.get(str.toLowerCase());
        if (fieldType2 != null) {
            return fieldType2;
        }
        for (FieldType fieldType3 : this.fieldTypes) {
            if (fieldType3.getFieldName().equals(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append("You should use columnName '");
                sb.append(fieldType3.getColumnName());
                sb.append("' for table ");
                sb.append(this.tableName);
                sb.append(" instead of fieldName '");
                sb.append(fieldType3.getFieldName());
                sb.append("'");
                throw new IllegalArgumentException(sb.toString());
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Unknown column name '");
        sb2.append(str);
        sb2.append("' in table ");
        sb2.append(this.tableName);
        throw new IllegalArgumentException(sb2.toString());
    }

    public FieldType getIdField() {
        return this.idField;
    }

    public Constructor<T> getConstructor() {
        return this.constructor;
    }

    public String objectToString(T t) {
        StringBuilder sb = new StringBuilder(64);
        sb.append(t.getClass().getSimpleName());
        for (FieldType fieldType : this.fieldTypes) {
            sb.append(InputCardNumberView.DIVIDER);
            sb.append(fieldType.getColumnName());
            sb.append('=');
            try {
                sb.append(fieldType.extractJavaFieldValue(t));
            } catch (Exception e) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Could not generate toString of field ");
                sb2.append(fieldType);
                throw new IllegalStateException(sb2.toString(), e);
            }
        }
        return sb.toString();
    }

    public T createObject() throws SQLException {
        T createObject;
        try {
            BaseDaoImpl<T, ID> baseDaoImpl = this.baseDaoImpl;
            ObjectFactory<T> objectFactory = baseDaoImpl != null ? baseDaoImpl.getObjectFactory() : null;
            if (objectFactory == null) {
                createObject = this.constructor.newInstance(new Object[0]);
            } else {
                createObject = objectFactory.createObject(this.constructor, this.baseDaoImpl.getDataClass());
            }
            wireNewInstance(this.baseDaoImpl, createObject);
            return createObject;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not create object for ");
            sb.append(this.constructor.getDeclaringClass());
            throw SqlExceptionUtil.create(sb.toString(), e);
        }
    }

    public boolean isUpdatable() {
        return this.idField != null && this.fieldTypes.length > 1;
    }

    public boolean isForeignAutoCreate() {
        return this.foreignAutoCreate;
    }

    public FieldType[] getForeignCollections() {
        return this.foreignCollections;
    }

    public boolean hasColumnName(String str) {
        for (FieldType fieldType : this.fieldTypes) {
            if (fieldType.getColumnName().equals(str)) {
                return true;
            }
        }
        return false;
    }

    private static <T, ID> void wireNewInstance(BaseDaoImpl<T, ID> baseDaoImpl, T t) {
        if (t instanceof BaseDaoEnabled) {
            ((BaseDaoEnabled) t).setDao(baseDaoImpl);
        }
    }
}
