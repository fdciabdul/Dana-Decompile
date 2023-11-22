package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes8.dex */
public class MappedDeleteCollection<T, ID> extends BaseMappedStatement<T, ID> {
    private MappedDeleteCollection(TableInfo<T, ID> tableInfo, String str, FieldType[] fieldTypeArr) {
        super(tableInfo, str, fieldTypeArr);
    }

    public static <T, ID> int deleteObjects(DatabaseType databaseType, TableInfo<T, ID> tableInfo, DatabaseConnection databaseConnection, Collection<T> collection, ObjectCache objectCache) throws SQLException {
        MappedDeleteCollection build = build(databaseType, tableInfo, collection.size());
        Object[] objArr = new Object[collection.size()];
        FieldType idField = tableInfo.getIdField();
        Iterator<T> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            objArr[i] = idField.extractJavaFieldToSqlArgValue(it.next());
            i++;
        }
        return updateRows(databaseConnection, tableInfo.getDataClass(), build, objArr, objectCache);
    }

    public static <T, ID> int deleteIds(DatabaseType databaseType, TableInfo<T, ID> tableInfo, DatabaseConnection databaseConnection, Collection<ID> collection, ObjectCache objectCache) throws SQLException {
        MappedDeleteCollection build = build(databaseType, tableInfo, collection.size());
        Object[] objArr = new Object[collection.size()];
        FieldType idField = tableInfo.getIdField();
        Iterator<ID> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            objArr[i] = idField.convertJavaFieldToSqlArgValue(it.next());
            i++;
        }
        return updateRows(databaseConnection, tableInfo.getDataClass(), build, objArr, objectCache);
    }

    private static <T, ID> MappedDeleteCollection<T, ID> build(DatabaseType databaseType, TableInfo<T, ID> tableInfo, int i) throws SQLException {
        FieldType idField = tableInfo.getIdField();
        if (idField == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot delete ");
            sb.append(tableInfo.getDataClass());
            sb.append(" because it doesn't have an id field defined");
            throw new SQLException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(128);
        appendTableName(databaseType, sb2, "DELETE FROM ", tableInfo.getTableName());
        FieldType[] fieldTypeArr = new FieldType[i];
        appendWhereIds(databaseType, idField, sb2, i, fieldTypeArr);
        return new MappedDeleteCollection<>(tableInfo, sb2.toString(), fieldTypeArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T, ID> int updateRows(DatabaseConnection databaseConnection, Class<T> cls, MappedDeleteCollection<T, ID> mappedDeleteCollection, Object[] objArr, ObjectCache objectCache) throws SQLException {
        try {
            int delete = databaseConnection.delete(mappedDeleteCollection.statement, objArr, mappedDeleteCollection.argFieldTypes);
            if (delete > 0 && objectCache != 0) {
                for (Object obj : objArr) {
                    objectCache.remove(cls, obj);
                }
            }
            logger.debug("delete-collection with statement '{}' and {} args, changed {} rows", mappedDeleteCollection.statement, Integer.valueOf(objArr.length), Integer.valueOf(delete));
            if (objArr.length > 0) {
                logger.trace("delete-collection arguments: {}", (Object) objArr);
            }
            return delete;
        } catch (SQLException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to run delete collection stmt: ");
            sb.append(mappedDeleteCollection.statement);
            throw SqlExceptionUtil.create(sb.toString(), e);
        }
    }

    private static void appendWhereIds(DatabaseType databaseType, FieldType fieldType, StringBuilder sb, int i, FieldType[] fieldTypeArr) {
        sb.append("WHERE ");
        databaseType.appendEscapedEntityName(sb, fieldType.getColumnName());
        sb.append(" IN (");
        boolean z = true;
        for (int i2 = 0; i2 < i; i2++) {
            if (z) {
                z = false;
            } else {
                sb.append(',');
            }
            sb.append('?');
            if (fieldTypeArr != null) {
                fieldTypeArr[i2] = fieldType;
            }
        }
        sb.append(") ");
    }
}
