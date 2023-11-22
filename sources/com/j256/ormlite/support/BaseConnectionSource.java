package com.j256.ormlite.support;

import com.j256.ormlite.logger.Logger;
import java.sql.SQLException;

/* loaded from: classes8.dex */
public abstract class BaseConnectionSource implements ConnectionSource {
    private ThreadLocal<NestedConnection> specialConnection = new ThreadLocal<>();

    @Override // com.j256.ormlite.support.ConnectionSource
    public DatabaseConnection getSpecialConnection(String str) {
        NestedConnection nestedConnection = this.specialConnection.get();
        if (nestedConnection == null) {
            return null;
        }
        return nestedConnection.connection;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DatabaseConnection getSavedConnection() {
        NestedConnection nestedConnection = this.specialConnection.get();
        if (nestedConnection == null) {
            return null;
        }
        return nestedConnection.connection;
    }

    protected boolean isSavedConnection(DatabaseConnection databaseConnection) {
        NestedConnection nestedConnection = this.specialConnection.get();
        return nestedConnection != null && nestedConnection.connection == databaseConnection;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean saveSpecial(DatabaseConnection databaseConnection) throws SQLException {
        NestedConnection nestedConnection = this.specialConnection.get();
        if (nestedConnection == null) {
            this.specialConnection.set(new NestedConnection(databaseConnection));
            return true;
        } else if (nestedConnection.connection != databaseConnection) {
            StringBuilder sb = new StringBuilder();
            sb.append("trying to save connection ");
            sb.append(databaseConnection);
            sb.append(" but already have saved connection ");
            sb.append(nestedConnection.connection);
            throw new SQLException(sb.toString());
        } else {
            nestedConnection.increment();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean clearSpecial(DatabaseConnection databaseConnection, Logger logger) {
        NestedConnection nestedConnection = this.specialConnection.get();
        if (databaseConnection != null) {
            if (nestedConnection == null) {
                logger.error("no connection has been saved when clear() called");
            } else if (nestedConnection.connection == databaseConnection) {
                if (nestedConnection.decrementAndGet() == 0) {
                    this.specialConnection.set(null);
                }
                return true;
            } else {
                logger.error("connection saved {} is not the one being cleared {}", nestedConnection.connection, databaseConnection);
            }
        }
        return false;
    }

    protected boolean isSingleConnection(DatabaseConnection databaseConnection, DatabaseConnection databaseConnection2) throws SQLException {
        databaseConnection.setAutoCommit(true);
        databaseConnection2.setAutoCommit(true);
        try {
            databaseConnection.setAutoCommit(false);
            return !databaseConnection2.isAutoCommit();
        } finally {
            databaseConnection.setAutoCommit(true);
        }
    }

    /* loaded from: classes8.dex */
    static class NestedConnection {
        public final DatabaseConnection connection;
        private int nestedC = 1;

        public NestedConnection(DatabaseConnection databaseConnection) {
            this.connection = databaseConnection;
        }

        public void increment() {
            this.nestedC++;
        }

        public int decrementAndGet() {
            int i = this.nestedC - 1;
            this.nestedC = i;
            return i;
        }
    }
}
