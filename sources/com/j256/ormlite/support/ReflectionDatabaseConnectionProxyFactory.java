package com.j256.ormlite.support;

import com.j256.ormlite.misc.SqlExceptionUtil;
import java.lang.reflect.Constructor;
import java.sql.SQLException;

/* loaded from: classes8.dex */
public class ReflectionDatabaseConnectionProxyFactory implements DatabaseConnectionProxyFactory {
    private final Constructor<? extends DatabaseConnection> constructor;
    private final Class<? extends DatabaseConnection> proxyClass;

    public ReflectionDatabaseConnectionProxyFactory(Class<? extends DatabaseConnection> cls) throws IllegalArgumentException {
        this.proxyClass = cls;
        try {
            this.constructor = cls.getConstructor(DatabaseConnection.class);
        } catch (Exception unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not find constructor with DatabaseConnection argument in ");
            sb.append(cls);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnectionProxyFactory
    public DatabaseConnection createProxy(DatabaseConnection databaseConnection) throws SQLException {
        try {
            return this.constructor.newInstance(databaseConnection);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not create a new instance of ");
            sb.append(this.proxyClass);
            throw SqlExceptionUtil.create(sb.toString(), e);
        }
    }
}
