package com.j256.ormlite.dao;

import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.lang.reflect.Constructor;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class DaoManager {
    private static Map<ClassConnectionSource, Dao<?, ?>> classMap;
    private static Map<Class<?>, DatabaseTableConfig<?>> configMap;
    private static Logger logger = LoggerFactory.getLogger(DaoManager.class);
    private static Map<TableConfigConnectionSource, Dao<?, ?>> tableConfigMap;

    public static <D extends Dao<T, ?>, T> D createDao(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        Dao createDao;
        D d;
        synchronized (DaoManager.class) {
            if (connectionSource == null) {
                throw new IllegalArgumentException("connectionSource argument cannot be null");
            }
            D d2 = (D) lookupDao(new ClassConnectionSource(connectionSource, cls));
            if (d2 != null) {
                return d2;
            }
            D d3 = (D) createDaoFromConfig(connectionSource, cls);
            if (d3 != null) {
                return d3;
            }
            DatabaseTable databaseTable = (DatabaseTable) cls.getAnnotation(DatabaseTable.class);
            if (databaseTable != null && databaseTable.daoClass() != Void.class && databaseTable.daoClass() != BaseDaoImpl.class) {
                Class<?> daoClass = databaseTable.daoClass();
                Object[] objArr = {connectionSource, cls};
                Constructor<?> findConstructor = findConstructor(daoClass, objArr);
                if (findConstructor == null && (findConstructor = findConstructor(daoClass, (objArr = new Object[]{connectionSource}))) == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Could not find public constructor with ConnectionSource and optional Class parameters ");
                    sb.append(daoClass);
                    sb.append(".  Missing static on class?");
                    throw new SQLException(sb.toString());
                }
                try {
                    d = (D) findConstructor.newInstance(objArr);
                    logger.debug("created dao for class {} from constructor", cls);
                    registerDao(connectionSource, d);
                    return d;
                } catch (Exception e) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Could not call the constructor in class ");
                    sb2.append(daoClass);
                    throw SqlExceptionUtil.create(sb2.toString(), e);
                }
            }
            DatabaseTableConfig<T> extractDatabaseTableConfig = connectionSource.getDatabaseType().extractDatabaseTableConfig(connectionSource, cls);
            if (extractDatabaseTableConfig == null) {
                createDao = BaseDaoImpl.createDao(connectionSource, cls);
            } else {
                createDao = BaseDaoImpl.createDao(connectionSource, extractDatabaseTableConfig);
            }
            d = (D) createDao;
            logger.debug("created dao for class {} with reflection", cls);
            registerDao(connectionSource, d);
            return d;
        }
    }

    public static <D extends Dao<T, ?>, T> D lookupDao(ConnectionSource connectionSource, Class<T> cls) {
        D d;
        synchronized (DaoManager.class) {
            if (connectionSource == null) {
                throw new IllegalArgumentException("connectionSource argument cannot be null");
            }
            d = (D) lookupDao(new ClassConnectionSource(connectionSource, cls));
        }
        return d;
    }

    public static <D extends Dao<T, ?>, T> D createDao(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        D d;
        synchronized (DaoManager.class) {
            if (connectionSource == null) {
                throw new IllegalArgumentException("connectionSource argument cannot be null");
            }
            d = (D) doCreateDao(connectionSource, databaseTableConfig);
        }
        return d;
    }

    public static <D extends Dao<T, ?>, T> D lookupDao(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) {
        synchronized (DaoManager.class) {
            if (connectionSource == null) {
                throw new IllegalArgumentException("connectionSource argument cannot be null");
            }
            D d = (D) lookupDao(new TableConfigConnectionSource(connectionSource, databaseTableConfig));
            if (d == null) {
                return null;
            }
            return d;
        }
    }

    public static void registerDao(ConnectionSource connectionSource, Dao<?, ?> dao) {
        synchronized (DaoManager.class) {
            if (connectionSource == null) {
                throw new IllegalArgumentException("connectionSource argument cannot be null");
            }
            addDaoToClassMap(new ClassConnectionSource(connectionSource, dao.getDataClass()), dao);
        }
    }

    public static void unregisterDao(ConnectionSource connectionSource, Dao<?, ?> dao) {
        synchronized (DaoManager.class) {
            if (connectionSource == null) {
                throw new IllegalArgumentException("connectionSource argument cannot be null");
            }
            removeDaoToClassMap(new ClassConnectionSource(connectionSource, dao.getDataClass()), dao);
        }
    }

    public static void registerDaoWithTableConfig(ConnectionSource connectionSource, Dao<?, ?> dao) {
        DatabaseTableConfig tableConfig;
        synchronized (DaoManager.class) {
            if (connectionSource == null) {
                throw new IllegalArgumentException("connectionSource argument cannot be null");
            }
            if ((dao instanceof BaseDaoImpl) && (tableConfig = ((BaseDaoImpl) dao).getTableConfig()) != null) {
                addDaoToTableMap(new TableConfigConnectionSource(connectionSource, tableConfig), dao);
            } else {
                addDaoToClassMap(new ClassConnectionSource(connectionSource, dao.getDataClass()), dao);
            }
        }
    }

    public static void clearCache() {
        synchronized (DaoManager.class) {
            Map<Class<?>, DatabaseTableConfig<?>> map = configMap;
            if (map != null) {
                map.clear();
                configMap = null;
            }
            clearDaoCache();
        }
    }

    public static void clearDaoCache() {
        synchronized (DaoManager.class) {
            Map<ClassConnectionSource, Dao<?, ?>> map = classMap;
            if (map != null) {
                map.clear();
                classMap = null;
            }
            Map<TableConfigConnectionSource, Dao<?, ?>> map2 = tableConfigMap;
            if (map2 != null) {
                map2.clear();
                tableConfigMap = null;
            }
        }
    }

    public static void addCachedDatabaseConfigs(Collection<DatabaseTableConfig<?>> collection) {
        HashMap hashMap;
        synchronized (DaoManager.class) {
            if (configMap == null) {
                hashMap = new HashMap();
            } else {
                hashMap = new HashMap(configMap);
            }
            for (DatabaseTableConfig<?> databaseTableConfig : collection) {
                hashMap.put(databaseTableConfig.getDataClass(), databaseTableConfig);
                logger.info("Loaded configuration for {}", databaseTableConfig.getDataClass());
            }
            configMap = hashMap;
        }
    }

    private static void addDaoToClassMap(ClassConnectionSource classConnectionSource, Dao<?, ?> dao) {
        if (classMap == null) {
            classMap = new HashMap();
        }
        classMap.put(classConnectionSource, dao);
    }

    private static void removeDaoToClassMap(ClassConnectionSource classConnectionSource, Dao<?, ?> dao) {
        Map<ClassConnectionSource, Dao<?, ?>> map = classMap;
        if (map != null) {
            map.remove(classConnectionSource);
        }
    }

    private static void addDaoToTableMap(TableConfigConnectionSource tableConfigConnectionSource, Dao<?, ?> dao) {
        if (tableConfigMap == null) {
            tableConfigMap = new HashMap();
        }
        tableConfigMap.put(tableConfigConnectionSource, dao);
    }

    private static <T> Dao<?, ?> lookupDao(ClassConnectionSource classConnectionSource) {
        if (classMap == null) {
            classMap = new HashMap();
        }
        Dao<?, ?> dao = classMap.get(classConnectionSource);
        if (dao == null) {
            return null;
        }
        return dao;
    }

    private static <T> Dao<?, ?> lookupDao(TableConfigConnectionSource tableConfigConnectionSource) {
        if (tableConfigMap == null) {
            tableConfigMap = new HashMap();
        }
        Dao<?, ?> dao = tableConfigMap.get(tableConfigConnectionSource);
        if (dao == null) {
            return null;
        }
        return dao;
    }

    private static Constructor<?> findConstructor(Class<?> cls, Object[] objArr) {
        boolean z;
        for (Constructor<?> constructor : cls.getConstructors()) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == objArr.length) {
                int i = 0;
                while (true) {
                    if (i >= parameterTypes.length) {
                        z = true;
                        break;
                    } else if (!parameterTypes[i].isAssignableFrom(objArr[i].getClass())) {
                        z = false;
                        break;
                    } else {
                        i++;
                    }
                }
                if (z) {
                    return constructor;
                }
            }
        }
        return null;
    }

    private static <D, T> D createDaoFromConfig(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        DatabaseTableConfig<?> databaseTableConfig;
        Map<Class<?>, DatabaseTableConfig<?>> map = configMap;
        if (map == null || (databaseTableConfig = map.get(cls)) == null) {
            return null;
        }
        return (D) doCreateDao(connectionSource, databaseTableConfig);
    }

    private static <D extends Dao<T, ?>, T> D doCreateDao(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        D d;
        TableConfigConnectionSource tableConfigConnectionSource = new TableConfigConnectionSource(connectionSource, databaseTableConfig);
        D d2 = (D) lookupDao(tableConfigConnectionSource);
        if (d2 != null) {
            return d2;
        }
        Class<T> dataClass = databaseTableConfig.getDataClass();
        ClassConnectionSource classConnectionSource = new ClassConnectionSource(connectionSource, dataClass);
        D d3 = (D) lookupDao(classConnectionSource);
        if (d3 != null) {
            addDaoToTableMap(tableConfigConnectionSource, d3);
            return d3;
        }
        DatabaseTable databaseTable = (DatabaseTable) databaseTableConfig.getDataClass().getAnnotation(DatabaseTable.class);
        if (databaseTable == null || databaseTable.daoClass() == Void.class || databaseTable.daoClass() == BaseDaoImpl.class) {
            d = (D) BaseDaoImpl.createDao(connectionSource, databaseTableConfig);
        } else {
            Class<?> daoClass = databaseTable.daoClass();
            Object[] objArr = {connectionSource, databaseTableConfig};
            Constructor<?> findConstructor = findConstructor(daoClass, objArr);
            if (findConstructor == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Could not find public constructor with ConnectionSource, DatabaseTableConfig parameters in class ");
                sb.append(daoClass);
                throw new SQLException(sb.toString());
            }
            try {
                d = (D) findConstructor.newInstance(objArr);
            } catch (Exception e) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Could not call the constructor in class ");
                sb2.append(daoClass);
                throw SqlExceptionUtil.create(sb2.toString(), e);
            }
        }
        addDaoToTableMap(tableConfigConnectionSource, d);
        logger.debug("created dao for class {} from table config", dataClass);
        if (lookupDao(classConnectionSource) == null) {
            addDaoToClassMap(classConnectionSource, d);
        }
        return d;
    }

    /* loaded from: classes8.dex */
    public static class ClassConnectionSource {
        Class<?> clazz;
        ConnectionSource connectionSource;

        public ClassConnectionSource(ConnectionSource connectionSource, Class<?> cls) {
            this.connectionSource = connectionSource;
            this.clazz = cls;
        }

        public int hashCode() {
            return ((this.clazz.hashCode() + 31) * 31) + this.connectionSource.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ClassConnectionSource classConnectionSource = (ClassConnectionSource) obj;
            return this.clazz.equals(classConnectionSource.clazz) && this.connectionSource.equals(classConnectionSource.connectionSource);
        }
    }

    /* loaded from: classes8.dex */
    public static class TableConfigConnectionSource {
        ConnectionSource connectionSource;
        DatabaseTableConfig<?> tableConfig;

        public TableConfigConnectionSource(ConnectionSource connectionSource, DatabaseTableConfig<?> databaseTableConfig) {
            this.connectionSource = connectionSource;
            this.tableConfig = databaseTableConfig;
        }

        public int hashCode() {
            return ((this.tableConfig.hashCode() + 31) * 31) + this.connectionSource.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            TableConfigConnectionSource tableConfigConnectionSource = (TableConfigConnectionSource) obj;
            return this.tableConfig.equals(tableConfigConnectionSource.tableConfig) && this.connectionSource.equals(tableConfigConnectionSource.connectionSource);
        }
    }
}
