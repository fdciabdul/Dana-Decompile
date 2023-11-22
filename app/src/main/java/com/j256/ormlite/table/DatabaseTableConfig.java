package com.j256.ormlite.table;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.DatabaseFieldConfig;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.JavaxPersistenceConfigurer;
import com.j256.ormlite.support.ConnectionSource;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class DatabaseTableConfig<T> {
    private static JavaxPersistenceConfigurer javaxPersistenceConfigurer;
    private Constructor<T> constructor;
    private Class<T> dataClass;
    private List<DatabaseFieldConfig> fieldConfigs;
    private FieldType[] fieldTypes;
    private String tableName;

    static {
        try {
            Class.forName("javax.persistence.Entity");
            javaxPersistenceConfigurer = (JavaxPersistenceConfigurer) Class.forName("com.j256.ormlite.misc.JavaxPersistenceImpl").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            javaxPersistenceConfigurer = null;
        }
    }

    public DatabaseTableConfig() {
    }

    public DatabaseTableConfig(Class<T> cls, List<DatabaseFieldConfig> list) {
        this(cls, extractTableName(cls), list);
    }

    public DatabaseTableConfig(Class<T> cls, String str, List<DatabaseFieldConfig> list) {
        this.dataClass = cls;
        this.tableName = str;
        this.fieldConfigs = list;
    }

    private DatabaseTableConfig(Class<T> cls, String str, FieldType[] fieldTypeArr) {
        this.dataClass = cls;
        this.tableName = str;
        this.fieldTypes = fieldTypeArr;
    }

    public void initialize() {
        Class<T> cls = this.dataClass;
        if (cls == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("dataClass was never set on ");
            sb.append(getClass().getSimpleName());
            throw new IllegalStateException(sb.toString());
        } else if (this.tableName == null) {
            this.tableName = extractTableName(cls);
        }
    }

    public Class<T> getDataClass() {
        return this.dataClass;
    }

    public void setDataClass(Class<T> cls) {
        this.dataClass = cls;
    }

    public String getTableName() {
        return this.tableName;
    }

    public void setTableName(String str) {
        this.tableName = str;
    }

    public void setFieldConfigs(List<DatabaseFieldConfig> list) {
        this.fieldConfigs = list;
    }

    public void extractFieldTypes(ConnectionSource connectionSource) throws SQLException {
        if (this.fieldTypes == null) {
            List<DatabaseFieldConfig> list = this.fieldConfigs;
            if (list == null) {
                this.fieldTypes = extractFieldTypes(connectionSource, this.dataClass, this.tableName);
            } else {
                this.fieldTypes = convertFieldConfigs(connectionSource, this.tableName, list);
            }
        }
    }

    public FieldType[] getFieldTypes(DatabaseType databaseType) throws SQLException {
        FieldType[] fieldTypeArr = this.fieldTypes;
        if (fieldTypeArr != null) {
            return fieldTypeArr;
        }
        throw new SQLException("Field types have not been extracted in table config");
    }

    public List<DatabaseFieldConfig> getFieldConfigs() {
        return this.fieldConfigs;
    }

    public Constructor<T> getConstructor() {
        if (this.constructor == null) {
            this.constructor = findNoArgConstructor(this.dataClass);
        }
        return this.constructor;
    }

    public void setConstructor(Constructor<T> constructor) {
        this.constructor = constructor;
    }

    public static <T> DatabaseTableConfig<T> fromClass(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        String extractTableName = extractTableName(cls);
        DatabaseType databaseType = connectionSource.getDatabaseType();
        if (databaseType.isEntityNamesMustBeUpCase()) {
            extractTableName = databaseType.upCaseEntityName(extractTableName);
        }
        return new DatabaseTableConfig<>(cls, extractTableName, extractFieldTypes(connectionSource, cls, extractTableName));
    }

    public static <T> String extractTableName(Class<T> cls) {
        JavaxPersistenceConfigurer javaxPersistenceConfigurer2;
        DatabaseTable databaseTable = (DatabaseTable) cls.getAnnotation(DatabaseTable.class);
        String tableName = (databaseTable == null || databaseTable.tableName() == null || databaseTable.tableName().length() <= 0) ? null : databaseTable.tableName();
        if (tableName == null && (javaxPersistenceConfigurer2 = javaxPersistenceConfigurer) != null) {
            tableName = javaxPersistenceConfigurer2.getEntityName(cls);
        }
        return tableName == null ? cls.getSimpleName().toLowerCase() : tableName;
    }

    public static <T> Constructor<T> findNoArgConstructor(Class<T> cls) {
        try {
            for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
                Constructor<T> constructor2 = (Constructor<T>) constructor;
                if (constructor2.getParameterTypes().length == 0) {
                    if (!constructor2.isAccessible()) {
                        try {
                            constructor2.setAccessible(true);
                        } catch (SecurityException unused) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Could not open access to constructor for ");
                            sb.append(cls);
                            throw new IllegalArgumentException(sb.toString());
                        }
                    }
                    return constructor2;
                }
            }
            if (cls.getEnclosingClass() == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Can't find a no-arg constructor for ");
                sb2.append(cls);
                throw new IllegalArgumentException(sb2.toString());
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Can't find a no-arg constructor for ");
            sb3.append(cls);
            sb3.append(".  Missing static on inner class?");
            throw new IllegalArgumentException(sb3.toString());
        } catch (Exception e) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Can't lookup declared constructors for ");
            sb4.append(cls);
            throw new IllegalArgumentException(sb4.toString(), e);
        }
    }

    private static <T> FieldType[] extractFieldTypes(ConnectionSource connectionSource, Class<T> cls, String str) throws SQLException {
        ArrayList arrayList = new ArrayList();
        for (Class<T> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            for (Field field : cls2.getDeclaredFields()) {
                FieldType createFieldType = FieldType.createFieldType(connectionSource, str, field, cls);
                if (createFieldType != null) {
                    arrayList.add(createFieldType);
                }
            }
        }
        if (arrayList.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("No fields have a ");
            sb.append("DatabaseField");
            sb.append(" annotation in ");
            sb.append(cls);
            throw new IllegalArgumentException(sb.toString());
        }
        return (FieldType[]) arrayList.toArray(new FieldType[arrayList.size()]);
    }

    private FieldType[] convertFieldConfigs(ConnectionSource connectionSource, String str, List<DatabaseFieldConfig> list) throws SQLException {
        FieldType fieldType;
        Field declaredField;
        ArrayList arrayList = new ArrayList();
        for (DatabaseFieldConfig databaseFieldConfig : list) {
            Class<T> cls = this.dataClass;
            while (true) {
                fieldType = null;
                if (cls == null) {
                    break;
                }
                try {
                    declaredField = cls.getDeclaredField(databaseFieldConfig.getFieldName());
                } catch (NoSuchFieldException unused) {
                }
                if (declaredField == null) {
                    cls = cls.getSuperclass();
                } else {
                    fieldType = new FieldType(connectionSource, str, declaredField, databaseFieldConfig, this.dataClass);
                    break;
                }
            }
            if (fieldType == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Could not find declared field with name '");
                sb.append(databaseFieldConfig.getFieldName());
                sb.append("' for ");
                sb.append(this.dataClass);
                throw new SQLException(sb.toString());
            }
            arrayList.add(fieldType);
        }
        if (arrayList.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("No fields were configured for class ");
            sb2.append(this.dataClass);
            throw new SQLException(sb2.toString());
        }
        return (FieldType[]) arrayList.toArray(new FieldType[arrayList.size()]);
    }
}
