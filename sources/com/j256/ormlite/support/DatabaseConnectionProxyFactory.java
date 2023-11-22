package com.j256.ormlite.support;

import java.sql.SQLException;

/* loaded from: classes8.dex */
public interface DatabaseConnectionProxyFactory {
    DatabaseConnection createProxy(DatabaseConnection databaseConnection) throws SQLException;
}
