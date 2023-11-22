package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.logger.Log;
import com.j256.ormlite.misc.IOUtils;
import com.j256.ormlite.stmt.ArgumentHolder;
import com.j256.ormlite.stmt.PreparedDelete;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.PreparedUpdate;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

/* loaded from: classes8.dex */
public class MappedPreparedStmt<T, ID> extends BaseMappedQuery<T, ID> implements PreparedQuery<T>, PreparedDelete<T>, PreparedUpdate<T> {
    private final ArgumentHolder[] argHolders;
    private final boolean cacheStore;
    private final Long limit;
    private final StatementBuilder.StatementType type;

    public MappedPreparedStmt(TableInfo<T, ID> tableInfo, String str, FieldType[] fieldTypeArr, FieldType[] fieldTypeArr2, ArgumentHolder[] argumentHolderArr, Long l, StatementBuilder.StatementType statementType, boolean z) {
        super(tableInfo, str, fieldTypeArr, fieldTypeArr2);
        this.argHolders = argumentHolderArr;
        this.limit = l;
        this.type = statementType;
        this.cacheStore = z;
    }

    @Override // com.j256.ormlite.stmt.PreparedStmt
    public CompiledStatement compile(DatabaseConnection databaseConnection, StatementBuilder.StatementType statementType) throws SQLException {
        return compile(databaseConnection, statementType, -1);
    }

    @Override // com.j256.ormlite.stmt.PreparedStmt
    public CompiledStatement compile(DatabaseConnection databaseConnection, StatementBuilder.StatementType statementType, int i) throws SQLException {
        if (this.type != statementType) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not compile this ");
            sb.append(this.type);
            sb.append(" statement since the caller is expecting a ");
            sb.append(statementType);
            sb.append(" statement.  Check your QueryBuilder methods.");
            throw new SQLException(sb.toString());
        }
        return assignStatementArguments(databaseConnection.compileStatement(this.statement, statementType, this.argFieldTypes, i, this.cacheStore));
    }

    @Override // com.j256.ormlite.stmt.PreparedStmt
    public String getStatement() {
        return this.statement;
    }

    @Override // com.j256.ormlite.stmt.PreparedStmt
    public StatementBuilder.StatementType getType() {
        return this.type;
    }

    @Override // com.j256.ormlite.stmt.PreparedStmt
    public void setArgumentHolderValue(int i, Object obj) throws SQLException {
        if (i < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("argument holder index ");
            sb.append(i);
            sb.append(" must be >= 0");
            throw new SQLException(sb.toString());
        }
        ArgumentHolder[] argumentHolderArr = this.argHolders;
        if (argumentHolderArr.length <= i) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("argument holder index ");
            sb2.append(i);
            sb2.append(" is not valid, only ");
            sb2.append(this.argHolders.length);
            sb2.append(" in statement (index starts at 0)");
            throw new SQLException(sb2.toString());
        }
        argumentHolderArr[i].setValue(obj);
    }

    private CompiledStatement assignStatementArguments(CompiledStatement compiledStatement) throws SQLException {
        SqlType sqlType;
        try {
            Long l = this.limit;
            if (l != null) {
                compiledStatement.setMaxRows(l.intValue());
            }
            Object[] objArr = null;
            if (logger.isLevelEnabled(Log.Level.TRACE)) {
                ArgumentHolder[] argumentHolderArr = this.argHolders;
                if (argumentHolderArr.length > 0) {
                    objArr = new Object[argumentHolderArr.length];
                }
            }
            int i = 0;
            while (true) {
                ArgumentHolder[] argumentHolderArr2 = this.argHolders;
                if (i >= argumentHolderArr2.length) {
                    break;
                }
                Object sqlArgValue = argumentHolderArr2[i].getSqlArgValue();
                FieldType fieldType = this.argFieldTypes[i];
                if (fieldType == null) {
                    sqlType = this.argHolders[i].getSqlType();
                } else {
                    sqlType = fieldType.getSqlType();
                }
                compiledStatement.setObject(i, sqlArgValue, sqlType);
                if (objArr != null) {
                    objArr[i] = sqlArgValue;
                }
                i++;
            }
            logger.debug("prepared statement '{}' with {} args", this.statement, Integer.valueOf(this.argHolders.length));
            if (objArr != null) {
                logger.trace("prepared statement arguments: {}", (Object) objArr);
            }
            return compiledStatement;
        } catch (Throwable th) {
            IOUtils.closeThrowSqlException(compiledStatement, "statement");
            throw th;
        }
    }
}
