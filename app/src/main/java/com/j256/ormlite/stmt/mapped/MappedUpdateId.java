package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

/* loaded from: classes8.dex */
public class MappedUpdateId<T, ID> extends BaseMappedStatement<T, ID> {
    private MappedUpdateId(TableInfo<T, ID> tableInfo, String str, FieldType[] fieldTypeArr) {
        super(tableInfo, str, fieldTypeArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int execute(DatabaseConnection databaseConnection, T t, ID id2, ObjectCache objectCache) throws SQLException {
        Object updateId;
        try {
            Object[] objArr = {convertIdToFieldObject(id2), extractIdToFieldObject(t)};
            int update = databaseConnection.update(this.statement, objArr, this.argFieldTypes);
            if (update > 0) {
                if (objectCache != 0 && (updateId = objectCache.updateId(this.clazz, this.idField.extractJavaFieldValue(t), id2)) != null && updateId != t) {
                    this.idField.assignField(updateId, id2, false, objectCache);
                }
                this.idField.assignField(t, id2, false, objectCache);
            }
            logger.debug("updating-id with statement '{}' and {} args, changed {} rows", (Object) this.statement, (Object) 2, (Object) Integer.valueOf(update));
            logger.trace("updating-id arguments: {}", (Object) objArr);
            return update;
        } catch (SQLException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to run update-id stmt on object ");
            sb.append(t);
            sb.append(": ");
            sb.append(this.statement);
            throw SqlExceptionUtil.create(sb.toString(), e);
        }
    }

    public static <T, ID> MappedUpdateId<T, ID> build(DatabaseType databaseType, TableInfo<T, ID> tableInfo) throws SQLException {
        FieldType idField = tableInfo.getIdField();
        if (idField == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot update-id in ");
            sb.append(tableInfo.getDataClass());
            sb.append(" because it doesn't have an id field");
            throw new SQLException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(64);
        appendTableName(databaseType, sb2, "UPDATE ", tableInfo.getTableName());
        sb2.append("SET ");
        appendFieldColumnName(databaseType, sb2, idField, null);
        sb2.append("= ? ");
        appendWhereFieldEq(databaseType, idField, sb2, null);
        return new MappedUpdateId<>(tableInfo, sb2.toString(), new FieldType[]{idField, idField});
    }

    private Object extractIdToFieldObject(T t) throws SQLException {
        return this.idField.extractJavaFieldToSqlArgValue(t);
    }
}
