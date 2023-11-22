package com.j256.ormlite.field;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.BaseForeignCollection;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.EagerForeignCollection;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.dao.LazyForeignCollection;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.types.VoidType;
import com.j256.ormlite.logger.Log;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.stmt.mapped.MappedQueryForFieldEq;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.DatabaseTableConfig;
import com.j256.ormlite.table.TableInfo;
import id.dana.cashier.view.InputCardNumberView;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes8.dex */
public class FieldType {
    private static boolean DEFAULT_VALUE_BOOLEAN = false;
    private static byte DEFAULT_VALUE_BYTE = 0;
    private static char DEFAULT_VALUE_CHAR = 0;
    private static double DEFAULT_VALUE_DOUBLE = 0.0d;
    private static float DEFAULT_VALUE_FLOAT = 0.0f;
    private static int DEFAULT_VALUE_INT = 0;
    private static long DEFAULT_VALUE_LONG = 0;
    private static short DEFAULT_VALUE_SHORT = 0;
    public static final String FOREIGN_ID_FIELD_SUFFIX = "_id";
    private final String columnName;
    private final ConnectionSource connectionSource;
    private DataPersister dataPersister;
    private Object dataTypeConfigObj;
    private Object defaultValue;
    private final Field field;
    private final DatabaseFieldConfig fieldConfig;
    private FieldConverter fieldConverter;
    private final Method fieldGetMethod;
    private final Method fieldSetMethod;
    private BaseDaoImpl<?, ?> foreignDao;
    private FieldType foreignFieldType;
    private FieldType foreignIdField;
    private FieldType foreignRefField;
    private TableInfo<?, ?> foreignTableInfo;
    private final String generatedIdSequence;
    private final boolean isGeneratedId;
    private final boolean isId;
    private MappedQueryForFieldEq<Object, Object> mappedQueryForForeignField;
    private final Class<?> parentClass;
    private final String tableName;
    private static final ThreadLocal<LevelCounters> threadLevelCounters = new ThreadLocal<>();
    private static final Logger logger = LoggerFactory.getLogger(FieldType.class);

    public FieldType(ConnectionSource connectionSource, String str, Field field, DatabaseFieldConfig databaseFieldConfig, Class<?> cls) throws SQLException {
        DataPersister dataPersister;
        String obj;
        this.connectionSource = connectionSource;
        this.tableName = str;
        DatabaseType databaseType = connectionSource.getDatabaseType();
        this.field = field;
        this.parentClass = cls;
        databaseFieldConfig.postProcess();
        Class<?> type = field.getType();
        if (databaseFieldConfig.getDataPersister() == null) {
            Class<? extends DataPersister> persisterClass = databaseFieldConfig.getPersisterClass();
            if (persisterClass == null || persisterClass == VoidType.class) {
                dataPersister = DataPersisterManager.lookupForField(field);
            } else {
                try {
                    try {
                        Object invoke = persisterClass.getDeclaredMethod("getSingleton", new Class[0]).invoke(null, new Object[0]);
                        if (invoke == null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Static getSingleton method should not return null on class ");
                            sb.append(persisterClass);
                            throw new SQLException(sb.toString());
                        }
                        try {
                            dataPersister = (DataPersister) invoke;
                        } catch (Exception e) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Could not cast result of static getSingleton method to DataPersister from class ");
                            sb2.append(persisterClass);
                            throw SqlExceptionUtil.create(sb2.toString(), e);
                        }
                    } catch (InvocationTargetException e2) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Could not run getSingleton method on class ");
                        sb3.append(persisterClass);
                        throw SqlExceptionUtil.create(sb3.toString(), e2.getTargetException());
                    } catch (Exception e3) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Could not run getSingleton method on class ");
                        sb4.append(persisterClass);
                        throw SqlExceptionUtil.create(sb4.toString(), e3);
                    }
                } catch (Exception e4) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("Could not find getSingleton static method on class ");
                    sb5.append(persisterClass);
                    throw SqlExceptionUtil.create(sb5.toString(), e4);
                }
            }
        } else {
            dataPersister = databaseFieldConfig.getDataPersister();
            if (!dataPersister.isValidForField(field)) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("Field class ");
                sb6.append(type.getName());
                sb6.append(" for field ");
                sb6.append(this);
                sb6.append(" is not valid for type ");
                sb6.append(dataPersister);
                Class<?> primaryClass = dataPersister.getPrimaryClass();
                if (primaryClass != null) {
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(", maybe should be ");
                    sb7.append(primaryClass);
                    sb6.append(sb7.toString());
                }
                throw new IllegalArgumentException(sb6.toString());
            }
        }
        String foreignColumnName = databaseFieldConfig.getForeignColumnName();
        String name = field.getName();
        if (databaseFieldConfig.isForeign() || databaseFieldConfig.isForeignAutoRefresh() || foreignColumnName != null) {
            if (dataPersister != null && dataPersister.isPrimitive()) {
                StringBuilder sb8 = new StringBuilder();
                sb8.append("Field ");
                sb8.append(this);
                sb8.append(" is a primitive class ");
                sb8.append(type);
                sb8.append(" but marked as foreign");
                throw new IllegalArgumentException(sb8.toString());
            }
            if (foreignColumnName == null) {
                StringBuilder sb9 = new StringBuilder();
                sb9.append(name);
                sb9.append(FOREIGN_ID_FIELD_SUFFIX);
                obj = sb9.toString();
            } else {
                StringBuilder sb10 = new StringBuilder();
                sb10.append(name);
                sb10.append("_");
                sb10.append(foreignColumnName);
                obj = sb10.toString();
            }
            name = obj;
            if (ForeignCollection.class.isAssignableFrom(type)) {
                StringBuilder sb11 = new StringBuilder();
                sb11.append("Field '");
                sb11.append(field.getName());
                sb11.append("' in class ");
                sb11.append(type);
                sb11.append("' should use the @");
                sb11.append("ForeignCollectionField");
                sb11.append(" annotation not foreign=true");
                throw new SQLException(sb11.toString());
            }
        } else if (databaseFieldConfig.isForeignCollection()) {
            if (type != Collection.class && !ForeignCollection.class.isAssignableFrom(type)) {
                StringBuilder sb12 = new StringBuilder();
                sb12.append("Field class for '");
                sb12.append(field.getName());
                sb12.append("' must be of class ");
                sb12.append("ForeignCollection");
                sb12.append(" or Collection.");
                throw new SQLException(sb12.toString());
            }
            Type genericType = field.getGenericType();
            if (!(genericType instanceof ParameterizedType)) {
                StringBuilder sb13 = new StringBuilder();
                sb13.append("Field class for '");
                sb13.append(field.getName());
                sb13.append("' must be a parameterized Collection.");
                throw new SQLException(sb13.toString());
            } else if (((ParameterizedType) genericType).getActualTypeArguments().length == 0) {
                StringBuilder sb14 = new StringBuilder();
                sb14.append("Field class for '");
                sb14.append(field.getName());
                sb14.append("' must be a parameterized Collection with at least 1 type.");
                throw new SQLException(sb14.toString());
            }
        } else if (dataPersister == null && !databaseFieldConfig.isForeignCollection()) {
            if (byte[].class.isAssignableFrom(type)) {
                StringBuilder sb15 = new StringBuilder();
                sb15.append("ORMLite does not know how to store ");
                sb15.append(type);
                sb15.append(" for field '");
                sb15.append(field.getName());
                sb15.append("'. byte[] fields must specify dataType=DataType.BYTE_ARRAY or SERIALIZABLE");
                throw new SQLException(sb15.toString());
            } else if (Serializable.class.isAssignableFrom(type)) {
                StringBuilder sb16 = new StringBuilder();
                sb16.append("ORMLite does not know how to store ");
                sb16.append(type);
                sb16.append(" for field '");
                sb16.append(field.getName());
                sb16.append("'.  Use another class, custom persister, or to serialize it use ");
                sb16.append("dataType=DataType.SERIALIZABLE");
                throw new SQLException(sb16.toString());
            } else {
                StringBuilder sb17 = new StringBuilder();
                sb17.append("ORMLite does not know how to store ");
                sb17.append(type);
                sb17.append(" for field ");
                sb17.append(field.getName());
                sb17.append(". Use another class or a custom persister.");
                throw new IllegalArgumentException(sb17.toString());
            }
        }
        if (databaseFieldConfig.getColumnName() == null) {
            this.columnName = name;
        } else {
            this.columnName = databaseFieldConfig.getColumnName();
        }
        this.fieldConfig = databaseFieldConfig;
        if (databaseFieldConfig.isId()) {
            if (databaseFieldConfig.isGeneratedId() || databaseFieldConfig.getGeneratedIdSequence() != null) {
                StringBuilder sb18 = new StringBuilder();
                sb18.append("Must specify one of id, generatedId, and generatedIdSequence with ");
                sb18.append(field.getName());
                throw new IllegalArgumentException(sb18.toString());
            }
            this.isId = true;
            this.isGeneratedId = false;
            this.generatedIdSequence = null;
        } else if (databaseFieldConfig.isGeneratedId()) {
            if (databaseFieldConfig.getGeneratedIdSequence() != null) {
                StringBuilder sb19 = new StringBuilder();
                sb19.append("Must specify one of id, generatedId, and generatedIdSequence with ");
                sb19.append(field.getName());
                throw new IllegalArgumentException(sb19.toString());
            }
            this.isId = true;
            this.isGeneratedId = true;
            if (databaseType.isIdSequenceNeeded()) {
                this.generatedIdSequence = databaseType.generateIdSequenceName(str, this);
            } else {
                this.generatedIdSequence = null;
            }
        } else if (databaseFieldConfig.getGeneratedIdSequence() != null) {
            this.isId = true;
            this.isGeneratedId = true;
            String generatedIdSequence = databaseFieldConfig.getGeneratedIdSequence();
            this.generatedIdSequence = databaseType.isEntityNamesMustBeUpCase() ? databaseType.upCaseEntityName(generatedIdSequence) : generatedIdSequence;
        } else {
            this.isId = false;
            this.isGeneratedId = false;
            this.generatedIdSequence = null;
        }
        if (this.isId && (databaseFieldConfig.isForeign() || databaseFieldConfig.isForeignAutoRefresh())) {
            StringBuilder sb20 = new StringBuilder();
            sb20.append("Id field ");
            sb20.append(field.getName());
            sb20.append(" cannot also be a foreign object");
            throw new IllegalArgumentException(sb20.toString());
        }
        if (databaseFieldConfig.isUseGetSet()) {
            this.fieldGetMethod = DatabaseFieldConfig.findGetMethod(field, true);
            this.fieldSetMethod = DatabaseFieldConfig.findSetMethod(field, true);
        } else {
            if (!field.isAccessible()) {
                try {
                    field.setAccessible(true);
                } catch (SecurityException unused) {
                    StringBuilder sb21 = new StringBuilder();
                    sb21.append("Could not open access to field ");
                    sb21.append(field.getName());
                    sb21.append(".  You may have to set useGetSet=true to fix.");
                    throw new IllegalArgumentException(sb21.toString());
                }
            }
            this.fieldGetMethod = null;
            this.fieldSetMethod = null;
        }
        if (databaseFieldConfig.isAllowGeneratedIdInsert() && !databaseFieldConfig.isGeneratedId()) {
            StringBuilder sb22 = new StringBuilder();
            sb22.append("Field ");
            sb22.append(field.getName());
            sb22.append(" must be a generated-id if allowGeneratedIdInsert = true");
            throw new IllegalArgumentException(sb22.toString());
        } else if (databaseFieldConfig.isForeignAutoRefresh() && !databaseFieldConfig.isForeign()) {
            StringBuilder sb23 = new StringBuilder();
            sb23.append("Field ");
            sb23.append(field.getName());
            sb23.append(" must have foreign = true if foreignAutoRefresh = true");
            throw new IllegalArgumentException(sb23.toString());
        } else if (databaseFieldConfig.isForeignAutoCreate() && !databaseFieldConfig.isForeign()) {
            StringBuilder sb24 = new StringBuilder();
            sb24.append("Field ");
            sb24.append(field.getName());
            sb24.append(" must have foreign = true if foreignAutoCreate = true");
            throw new IllegalArgumentException(sb24.toString());
        } else if (databaseFieldConfig.getForeignColumnName() != null && !databaseFieldConfig.isForeign()) {
            StringBuilder sb25 = new StringBuilder();
            sb25.append("Field ");
            sb25.append(field.getName());
            sb25.append(" must have foreign = true if foreignColumnName is set");
            throw new IllegalArgumentException(sb25.toString());
        } else if (databaseFieldConfig.isVersion() && (dataPersister == null || !dataPersister.isValidForVersion())) {
            StringBuilder sb26 = new StringBuilder();
            sb26.append("Field ");
            sb26.append(field.getName());
            sb26.append(" is not a valid type to be a version field");
            throw new IllegalArgumentException(sb26.toString());
        } else {
            assignDataType(databaseType, dataPersister);
        }
    }

    public void configDaoInformation(ConnectionSource connectionSource, Class<?> cls) throws SQLException {
        BaseDaoImpl<?, ?> baseDaoImpl;
        TableInfo<?, ?> tableInfo;
        FieldType idField;
        FieldType fieldTypeByColumnName;
        FieldType fieldType;
        FieldType fieldType2;
        Class<?> type = this.field.getType();
        DatabaseType databaseType = connectionSource.getDatabaseType();
        String foreignColumnName = this.fieldConfig.getForeignColumnName();
        MappedQueryForFieldEq<Object, Object> mappedQueryForFieldEq = null;
        if (this.fieldConfig.isForeignAutoRefresh() || foreignColumnName != null) {
            DatabaseTableConfig<?> foreignTableConfig = this.fieldConfig.getForeignTableConfig();
            if (foreignTableConfig == null) {
                baseDaoImpl = (BaseDaoImpl) DaoManager.createDao(connectionSource, type);
                tableInfo = baseDaoImpl.getTableInfo();
            } else {
                foreignTableConfig.extractFieldTypes(connectionSource);
                baseDaoImpl = (BaseDaoImpl) DaoManager.createDao(connectionSource, foreignTableConfig);
                tableInfo = baseDaoImpl.getTableInfo();
            }
            idField = tableInfo.getIdField();
            if (idField == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Foreign field ");
                sb.append(type);
                sb.append(" does not have id field");
                throw new IllegalArgumentException(sb.toString());
            }
            if (foreignColumnName == null) {
                fieldTypeByColumnName = idField;
            } else {
                fieldTypeByColumnName = tableInfo.getFieldTypeByColumnName(foreignColumnName);
                if (fieldTypeByColumnName == null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Foreign field ");
                    sb2.append(type);
                    sb2.append(" does not have field named '");
                    sb2.append(foreignColumnName);
                    sb2.append("'");
                    throw new IllegalArgumentException(sb2.toString());
                }
            }
            mappedQueryForFieldEq = MappedQueryForFieldEq.build(databaseType, tableInfo, fieldTypeByColumnName);
            fieldType = null;
        } else if (this.fieldConfig.isForeign()) {
            DataPersister dataPersister = this.dataPersister;
            if (dataPersister != null && dataPersister.isPrimitive()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Field ");
                sb3.append(this);
                sb3.append(" is a primitive class ");
                sb3.append(type);
                sb3.append(" but marked as foreign");
                throw new IllegalArgumentException(sb3.toString());
            }
            DatabaseTableConfig<?> foreignTableConfig2 = this.fieldConfig.getForeignTableConfig();
            if (foreignTableConfig2 != null) {
                foreignTableConfig2.extractFieldTypes(connectionSource);
                baseDaoImpl = (BaseDaoImpl) DaoManager.createDao(connectionSource, foreignTableConfig2);
            } else {
                baseDaoImpl = (BaseDaoImpl) DaoManager.createDao(connectionSource, type);
            }
            tableInfo = baseDaoImpl.getTableInfo();
            idField = tableInfo.getIdField();
            if (idField == null) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Foreign field ");
                sb4.append(type);
                sb4.append(" does not have id field");
                throw new IllegalArgumentException(sb4.toString());
            } else if (isForeignAutoCreate() && !idField.isGeneratedId()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Field ");
                sb5.append(this.field.getName());
                sb5.append(", if foreignAutoCreate = true then class ");
                sb5.append(type.getSimpleName());
                sb5.append(" must have id field with generatedId = true");
                throw new IllegalArgumentException(sb5.toString());
            } else {
                fieldTypeByColumnName = idField;
                fieldType = null;
            }
        } else {
            if (!this.fieldConfig.isForeignCollection()) {
                baseDaoImpl = null;
                fieldType2 = null;
            } else if (type != Collection.class && !ForeignCollection.class.isAssignableFrom(type)) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("Field class for '");
                sb6.append(this.field.getName());
                sb6.append("' must be of class ");
                sb6.append("ForeignCollection");
                sb6.append(" or Collection.");
                throw new SQLException(sb6.toString());
            } else {
                Type genericType = this.field.getGenericType();
                if (!(genericType instanceof ParameterizedType)) {
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("Field class for '");
                    sb7.append(this.field.getName());
                    sb7.append("' must be a parameterized Collection.");
                    throw new SQLException(sb7.toString());
                }
                Type[] actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments();
                if (actualTypeArguments.length == 0) {
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append("Field class for '");
                    sb8.append(this.field.getName());
                    sb8.append("' must be a parameterized Collection with at least 1 type.");
                    throw new SQLException(sb8.toString());
                }
                if (actualTypeArguments[0] instanceof TypeVariable) {
                    actualTypeArguments = ((ParameterizedType) cls.getGenericSuperclass()).getActualTypeArguments();
                }
                Type type2 = actualTypeArguments[0];
                if (!(type2 instanceof Class)) {
                    StringBuilder sb9 = new StringBuilder();
                    sb9.append("Field class for '");
                    sb9.append(this.field.getName());
                    sb9.append("' must be a parameterized Collection whose generic argument is an entity class not: ");
                    sb9.append(actualTypeArguments[0]);
                    throw new SQLException(sb9.toString());
                }
                Class<?> cls2 = (Class) type2;
                DatabaseTableConfig<?> foreignTableConfig3 = this.fieldConfig.getForeignTableConfig();
                if (foreignTableConfig3 == null) {
                    baseDaoImpl = (BaseDaoImpl) DaoManager.createDao(connectionSource, cls2);
                } else {
                    baseDaoImpl = (BaseDaoImpl) DaoManager.createDao(connectionSource, foreignTableConfig3);
                }
                fieldType2 = findForeignFieldType(cls2, cls, baseDaoImpl);
            }
            fieldType = fieldType2;
            tableInfo = null;
            idField = null;
            fieldTypeByColumnName = null;
        }
        this.mappedQueryForForeignField = mappedQueryForFieldEq;
        this.foreignTableInfo = tableInfo;
        this.foreignFieldType = fieldType;
        this.foreignDao = baseDaoImpl;
        this.foreignIdField = idField;
        this.foreignRefField = fieldTypeByColumnName;
        if (fieldTypeByColumnName != null) {
            assignDataType(databaseType, fieldTypeByColumnName.getDataPersister());
        }
    }

    public Field getField() {
        return this.field;
    }

    public String getTableName() {
        return this.tableName;
    }

    public String getFieldName() {
        return this.field.getName();
    }

    public Class<?> getType() {
        return this.field.getType();
    }

    public Type getGenericType() {
        return this.field.getGenericType();
    }

    public String getColumnName() {
        return this.columnName;
    }

    public DataPersister getDataPersister() {
        return this.dataPersister;
    }

    public Object getDataTypeConfigObj() {
        return this.dataTypeConfigObj;
    }

    public SqlType getSqlType() {
        return this.fieldConverter.getSqlType();
    }

    public Object getDefaultValue() {
        return this.defaultValue;
    }

    public int getWidth() {
        return this.fieldConfig.getWidth();
    }

    public boolean isCanBeNull() {
        return this.fieldConfig.isCanBeNull();
    }

    public boolean isId() {
        return this.isId;
    }

    public boolean isGeneratedId() {
        return this.isGeneratedId;
    }

    public boolean isGeneratedIdSequence() {
        return this.generatedIdSequence != null;
    }

    public String getGeneratedIdSequence() {
        return this.generatedIdSequence;
    }

    public boolean isForeign() {
        return this.fieldConfig.isForeign();
    }

    public void assignField(Object obj, Object obj2, boolean z, ObjectCache objectCache) throws SQLException {
        Logger logger2 = logger;
        if (logger2.isLevelEnabled(Log.Level.TRACE)) {
            logger2.trace("assiging from data {}, val {}: {}", obj == null ? "null" : obj.getClass(), obj2 != null ? obj2.getClass() : "null", obj2);
        }
        if (this.foreignRefField != null && obj2 != null) {
            Object extractJavaFieldValue = extractJavaFieldValue(obj);
            if (extractJavaFieldValue != null && extractJavaFieldValue.equals(obj2)) {
                return;
            }
            ObjectCache objectCache2 = this.foreignDao.getObjectCache();
            Object obj3 = objectCache2 == null ? null : objectCache2.get(getType(), obj2);
            if (obj3 != null) {
                obj2 = obj3;
            } else if (!z) {
                obj2 = createForeignObject(obj2, objectCache);
            }
        }
        Method method = this.fieldSetMethod;
        if (method == null) {
            try {
                this.field.set(obj, obj2);
                return;
            } catch (IllegalAccessException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Could not assign object '");
                sb.append(obj2);
                sb.append("' of type ");
                sb.append(obj2.getClass());
                sb.append("' to field ");
                sb.append(this);
                throw SqlExceptionUtil.create(sb.toString(), e);
            } catch (IllegalArgumentException e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Could not assign object '");
                sb2.append(obj2);
                sb2.append("' of type ");
                sb2.append(obj2.getClass());
                sb2.append(" to field ");
                sb2.append(this);
                throw SqlExceptionUtil.create(sb2.toString(), e2);
            }
        }
        try {
            method.invoke(obj, obj2);
        } catch (Exception e3) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Could not call ");
            sb3.append(this.fieldSetMethod);
            sb3.append(" on object with '");
            sb3.append(obj2);
            sb3.append("' for ");
            sb3.append(this);
            throw SqlExceptionUtil.create(sb3.toString(), e3);
        }
    }

    public Object assignIdValue(Object obj, Number number, ObjectCache objectCache) throws SQLException {
        Object convertIdNumber = this.dataPersister.convertIdNumber(number);
        if (convertIdNumber == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid class ");
            sb.append(this.dataPersister);
            sb.append(" for sequence-id ");
            sb.append(this);
            throw new SQLException(sb.toString());
        }
        assignField(obj, convertIdNumber, false, objectCache);
        return convertIdNumber;
    }

    public <FV> FV extractRawJavaFieldValue(Object obj) throws SQLException {
        Method method = this.fieldGetMethod;
        if (method == null) {
            try {
                return (FV) this.field.get(obj);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Could not get field value for ");
                sb.append(this);
                throw SqlExceptionUtil.create(sb.toString(), e);
            }
        }
        try {
            return (FV) method.invoke(obj, new Object[0]);
        } catch (Exception e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Could not call ");
            sb2.append(this.fieldGetMethod);
            sb2.append(" for ");
            sb2.append(this);
            throw SqlExceptionUtil.create(sb2.toString(), e2);
        }
    }

    public Object extractJavaFieldValue(Object obj) throws SQLException {
        Object extractRawJavaFieldValue = extractRawJavaFieldValue(obj);
        FieldType fieldType = this.foreignRefField;
        return (fieldType == null || extractRawJavaFieldValue == null) ? extractRawJavaFieldValue : fieldType.extractRawJavaFieldValue(extractRawJavaFieldValue);
    }

    public Object extractJavaFieldToSqlArgValue(Object obj) throws SQLException {
        return convertJavaFieldToSqlArgValue(extractJavaFieldValue(obj));
    }

    public Object convertJavaFieldToSqlArgValue(Object obj) throws SQLException {
        if (obj == null) {
            return null;
        }
        return this.fieldConverter.javaToSqlArg(this, obj);
    }

    public Object convertStringToJavaField(String str, int i) throws SQLException {
        if (str == null) {
            return null;
        }
        return this.fieldConverter.resultStringToJava(this, str, i);
    }

    public Object moveToNextValue(Object obj) throws SQLException {
        DataPersister dataPersister = this.dataPersister;
        if (dataPersister == null) {
            return null;
        }
        return dataPersister.moveToNextValue(obj);
    }

    public FieldType getForeignIdField() {
        return this.foreignIdField;
    }

    public FieldType getForeignRefField() {
        return this.foreignRefField;
    }

    public boolean isEscapedValue() {
        return this.dataPersister.isEscapedValue();
    }

    public Enum<?> getUnknownEnumVal() {
        return this.fieldConfig.getUnknownEnumValue();
    }

    public String getFormat() {
        return this.fieldConfig.getFormat();
    }

    public boolean isUnique() {
        return this.fieldConfig.isUnique();
    }

    public boolean isUniqueCombo() {
        return this.fieldConfig.isUniqueCombo();
    }

    public String getIndexName() {
        return this.fieldConfig.getIndexName(this.tableName);
    }

    public String getUniqueIndexName() {
        return this.fieldConfig.getUniqueIndexName(this.tableName);
    }

    public boolean isEscapedDefaultValue() {
        return this.dataPersister.isEscapedDefaultValue();
    }

    public boolean isComparable() throws SQLException {
        if (this.fieldConfig.isForeignCollection()) {
            return false;
        }
        DataPersister dataPersister = this.dataPersister;
        if (dataPersister == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Internal error.  Data-persister is not configured for field.  Please post _full_ exception with associated data objects to mailing list: ");
            sb.append(this);
            throw new SQLException(sb.toString());
        }
        return dataPersister.isComparable();
    }

    public boolean isArgumentHolderRequired() {
        return this.dataPersister.isArgumentHolderRequired();
    }

    public boolean isForeignCollection() {
        return this.fieldConfig.isForeignCollection();
    }

    public <FT, FID> BaseForeignCollection<FT, FID> buildForeignCollection(Object obj, FID fid) throws SQLException {
        if (this.foreignFieldType == null) {
            return null;
        }
        BaseDaoImpl<?, ?> baseDaoImpl = this.foreignDao;
        if (!this.fieldConfig.isForeignCollectionEager()) {
            return new LazyForeignCollection(baseDaoImpl, obj, fid, this.foreignFieldType, this.fieldConfig.getForeignCollectionOrderColumnName(), this.fieldConfig.isForeignCollectionOrderAscending());
        }
        ThreadLocal<LevelCounters> threadLocal = threadLevelCounters;
        LevelCounters levelCounters = threadLocal.get();
        if (levelCounters == null) {
            if (this.fieldConfig.getForeignCollectionMaxEagerLevel() == 0) {
                return new LazyForeignCollection(baseDaoImpl, obj, fid, this.foreignFieldType, this.fieldConfig.getForeignCollectionOrderColumnName(), this.fieldConfig.isForeignCollectionOrderAscending());
            }
            levelCounters = new LevelCounters();
            threadLocal.set(levelCounters);
        }
        LevelCounters levelCounters2 = levelCounters;
        if (levelCounters2.foreignCollectionLevel == 0) {
            levelCounters2.foreignCollectionLevelMax = this.fieldConfig.getForeignCollectionMaxEagerLevel();
        }
        if (levelCounters2.foreignCollectionLevel >= levelCounters2.foreignCollectionLevelMax) {
            return new LazyForeignCollection(baseDaoImpl, obj, fid, this.foreignFieldType, this.fieldConfig.getForeignCollectionOrderColumnName(), this.fieldConfig.isForeignCollectionOrderAscending());
        }
        levelCounters2.foreignCollectionLevel++;
        try {
            return new EagerForeignCollection(baseDaoImpl, obj, fid, this.foreignFieldType, this.fieldConfig.getForeignCollectionOrderColumnName(), this.fieldConfig.isForeignCollectionOrderAscending());
        } finally {
            levelCounters2.foreignCollectionLevel--;
        }
    }

    public <T> T resultToJava(DatabaseResults databaseResults, Map<String, Integer> map) throws SQLException {
        Integer num = map.get(this.columnName);
        if (num == null) {
            num = Integer.valueOf(databaseResults.findColumn(this.columnName));
            map.put(this.columnName, num);
        }
        T t = (T) this.fieldConverter.resultToJava(this, databaseResults, num.intValue());
        if (this.fieldConfig.isForeign()) {
            if (databaseResults.wasNull(num.intValue())) {
                return null;
            }
        } else if (this.dataPersister.isPrimitive()) {
            if (this.fieldConfig.isThrowIfNull() && databaseResults.wasNull(num.intValue())) {
                StringBuilder sb = new StringBuilder();
                sb.append("Results value for primitive field '");
                sb.append(this.field.getName());
                sb.append("' was an invalid null value");
                throw new SQLException(sb.toString());
            }
        } else if (!this.fieldConverter.isStreamType() && databaseResults.wasNull(num.intValue())) {
            return null;
        }
        return t;
    }

    public boolean isSelfGeneratedId() {
        return this.dataPersister.isSelfGeneratedId();
    }

    public boolean isAllowGeneratedIdInsert() {
        return this.fieldConfig.isAllowGeneratedIdInsert();
    }

    public String getColumnDefinition() {
        return this.fieldConfig.getColumnDefinition();
    }

    public boolean isForeignAutoCreate() {
        return this.fieldConfig.isForeignAutoCreate();
    }

    public boolean isVersion() {
        return this.fieldConfig.isVersion();
    }

    public Object generateId() {
        return this.dataPersister.generateId();
    }

    public boolean isReadOnly() {
        return this.fieldConfig.isReadOnly();
    }

    public <FV> FV getFieldValueIfNotDefault(Object obj) throws SQLException {
        FV fv = (FV) extractJavaFieldValue(obj);
        if (isFieldValueDefault(fv)) {
            return null;
        }
        return fv;
    }

    public boolean isObjectsFieldValueDefault(Object obj) throws SQLException {
        return isFieldValueDefault(extractJavaFieldValue(obj));
    }

    public Object getJavaDefaultValueDefault() {
        if (this.field.getType() == Boolean.TYPE) {
            return Boolean.valueOf(DEFAULT_VALUE_BOOLEAN);
        }
        if (this.field.getType() == Byte.TYPE || this.field.getType() == Byte.class) {
            return Byte.valueOf(DEFAULT_VALUE_BYTE);
        }
        if (this.field.getType() == Character.TYPE || this.field.getType() == Character.class) {
            return Character.valueOf(DEFAULT_VALUE_CHAR);
        }
        if (this.field.getType() == Short.TYPE || this.field.getType() == Short.class) {
            return Short.valueOf(DEFAULT_VALUE_SHORT);
        }
        if (this.field.getType() == Integer.TYPE || this.field.getType() == Integer.class) {
            return Integer.valueOf(DEFAULT_VALUE_INT);
        }
        if (this.field.getType() == Long.TYPE || this.field.getType() == Long.class) {
            return Long.valueOf(DEFAULT_VALUE_LONG);
        }
        if (this.field.getType() == Float.TYPE || this.field.getType() == Float.class) {
            return Float.valueOf(DEFAULT_VALUE_FLOAT);
        }
        if (this.field.getType() == Double.TYPE || this.field.getType() == Double.class) {
            return Double.valueOf(DEFAULT_VALUE_DOUBLE);
        }
        return null;
    }

    public <T> int createWithForeignDao(T t) throws SQLException {
        return this.foreignDao.create((BaseDaoImpl<?, ?>) t);
    }

    public static FieldType createFieldType(ConnectionSource connectionSource, String str, Field field, Class<?> cls) throws SQLException {
        DatabaseFieldConfig fromField = DatabaseFieldConfig.fromField(connectionSource.getDatabaseType(), str, field);
        if (fromField == null) {
            return null;
        }
        return new FieldType(connectionSource, str, field, fromField, cls);
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        FieldType fieldType = (FieldType) obj;
        if (this.field.equals(fieldType.field)) {
            Class<?> cls = this.parentClass;
            Class<?> cls2 = fieldType.parentClass;
            if (cls == null) {
                if (cls2 != null) {
                    return false;
                }
            } else if (!cls.equals(cls2)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.field.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(":name=");
        sb.append(this.field.getName());
        sb.append(",class=");
        sb.append(this.field.getDeclaringClass().getSimpleName());
        return sb.toString();
    }

    private Object createForeignObject(Object obj, ObjectCache objectCache) throws SQLException {
        ThreadLocal<LevelCounters> threadLocal = threadLevelCounters;
        LevelCounters levelCounters = threadLocal.get();
        if (levelCounters == null) {
            if (!this.fieldConfig.isForeignAutoRefresh()) {
                return createForeignShell(obj, objectCache);
            }
            levelCounters = new LevelCounters();
            threadLocal.set(levelCounters);
        }
        if (levelCounters.autoRefreshLevel == 0) {
            if (!this.fieldConfig.isForeignAutoRefresh()) {
                return createForeignShell(obj, objectCache);
            }
            levelCounters.autoRefreshLevelMax = this.fieldConfig.getMaxForeignAutoRefreshLevel();
        }
        if (levelCounters.autoRefreshLevel >= levelCounters.autoRefreshLevelMax) {
            return createForeignShell(obj, objectCache);
        }
        if (this.mappedQueryForForeignField == null) {
            this.mappedQueryForForeignField = MappedQueryForFieldEq.build(this.connectionSource.getDatabaseType(), this.foreignDao.getTableInfo(), this.foreignIdField);
        }
        levelCounters.autoRefreshLevel++;
        try {
            DatabaseConnection readOnlyConnection = this.connectionSource.getReadOnlyConnection(this.tableName);
            try {
                Object execute = this.mappedQueryForForeignField.execute(readOnlyConnection, obj, objectCache);
                levelCounters.autoRefreshLevel--;
                if (levelCounters.autoRefreshLevel <= 0) {
                    threadLocal.remove();
                }
                return execute;
            } finally {
                this.connectionSource.releaseConnection(readOnlyConnection);
            }
        } catch (Throwable th) {
            levelCounters.autoRefreshLevel--;
            if (levelCounters.autoRefreshLevel <= 0) {
                threadLevelCounters.remove();
            }
            throw th;
        }
    }

    private Object createForeignShell(Object obj, ObjectCache objectCache) throws SQLException {
        Object createObject = this.foreignTableInfo.createObject();
        this.foreignIdField.assignField(createObject, obj, false, objectCache);
        return createObject;
    }

    private boolean isFieldValueDefault(Object obj) {
        if (obj == null) {
            return true;
        }
        return obj.equals(getJavaDefaultValueDefault());
    }

    private FieldType findForeignFieldType(Class<?> cls, Class<?> cls2, BaseDaoImpl<?, ?> baseDaoImpl) throws SQLException {
        String foreignCollectionForeignFieldName = this.fieldConfig.getForeignCollectionForeignFieldName();
        for (FieldType fieldType : baseDaoImpl.getTableInfo().getFieldTypes()) {
            if (fieldType.getType() == cls2 && (foreignCollectionForeignFieldName == null || fieldType.getField().getName().equals(foreignCollectionForeignFieldName))) {
                if (fieldType.fieldConfig.isForeign() || fieldType.fieldConfig.isForeignAutoRefresh()) {
                    return fieldType;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Foreign collection object ");
                sb.append(cls);
                sb.append(" for field '");
                sb.append(this.field.getName());
                sb.append("' contains a field of class ");
                sb.append(cls2);
                sb.append(" but it's not foreign");
                throw new SQLException(sb.toString());
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Foreign collection class ");
        sb2.append(cls.getName());
        sb2.append(" for field '");
        sb2.append(this.field.getName());
        sb2.append("' column-name does not contain a foreign field");
        if (foreignCollectionForeignFieldName != null) {
            sb2.append(" named '");
            sb2.append(foreignCollectionForeignFieldName);
            sb2.append('\'');
        }
        sb2.append(" of class ");
        sb2.append(cls2.getName());
        throw new SQLException(sb2.toString());
    }

    private void assignDataType(DatabaseType databaseType, DataPersister dataPersister) throws SQLException {
        DataPersister dataPersister2 = databaseType.getDataPersister(dataPersister, this);
        this.dataPersister = dataPersister2;
        if (dataPersister2 == null) {
            if (this.fieldConfig.isForeign() || this.fieldConfig.isForeignCollection()) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Data persister for field ");
            sb.append(this);
            sb.append(" is null but the field is not a foreign or foreignCollection");
            throw new SQLException(sb.toString());
        }
        this.fieldConverter = databaseType.getFieldConverter(dataPersister2, this);
        if (this.isGeneratedId && !dataPersister2.isValidGeneratedType()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Generated-id field '");
            sb2.append(this.field.getName());
            sb2.append("' in ");
            sb2.append(this.field.getDeclaringClass().getSimpleName());
            sb2.append(" can't be type ");
            sb2.append(dataPersister2.getSqlType());
            sb2.append(".  Must be one of: ");
            for (DataType dataType : DataType.values()) {
                DataPersister dataPersister3 = dataType.getDataPersister();
                if (dataPersister3 != null && dataPersister3.isValidGeneratedType()) {
                    sb2.append(dataType);
                    sb2.append(InputCardNumberView.DIVIDER);
                }
            }
            throw new IllegalArgumentException(sb2.toString());
        } else if (this.fieldConfig.isThrowIfNull() && !dataPersister2.isPrimitive()) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Field ");
            sb3.append(this.field.getName());
            sb3.append(" must be a primitive if set with throwIfNull");
            throw new SQLException(sb3.toString());
        } else if (this.isId && !dataPersister2.isAppropriateId()) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Field '");
            sb4.append(this.field.getName());
            sb4.append("' is of data type ");
            sb4.append(dataPersister2);
            sb4.append(" which cannot be the ID field");
            throw new SQLException(sb4.toString());
        } else {
            this.dataTypeConfigObj = dataPersister2.makeConfigObject(this);
            String defaultValue = this.fieldConfig.getDefaultValue();
            if (defaultValue == null) {
                this.defaultValue = null;
            } else if (this.isGeneratedId) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Field '");
                sb5.append(this.field.getName());
                sb5.append("' cannot be a generatedId and have a default value '");
                sb5.append(defaultValue);
                sb5.append("'");
                throw new SQLException(sb5.toString());
            } else {
                this.defaultValue = this.fieldConverter.parseDefaultString(this, defaultValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class LevelCounters {
        int autoRefreshLevel;
        int autoRefreshLevelMax;
        int foreignCollectionLevel;
        int foreignCollectionLevelMax;

        private LevelCounters() {
        }
    }
}
