package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.TableInfo;
import id.dana.cashier.view.InputCardNumberView;
import java.sql.SQLException;

/* loaded from: classes8.dex */
public class MappedUpdate<T, ID> extends BaseMappedStatement<T, ID> {
    private final FieldType versionFieldType;
    private final int versionFieldTypeIndex;

    private MappedUpdate(TableInfo<T, ID> tableInfo, String str, FieldType[] fieldTypeArr, FieldType fieldType, int i) {
        super(tableInfo, str, fieldTypeArr);
        this.versionFieldType = fieldType;
        this.versionFieldTypeIndex = i;
    }

    public static <T, ID> MappedUpdate<T, ID> build(DatabaseType databaseType, TableInfo<T, ID> tableInfo) throws SQLException {
        FieldType idField = tableInfo.getIdField();
        if (idField == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot update ");
            sb.append(tableInfo.getDataClass());
            sb.append(" because it doesn't have an id field");
            throw new SQLException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(64);
        appendTableName(databaseType, sb2, "UPDATE ", tableInfo.getTableName());
        FieldType fieldType = null;
        int i = 0;
        int i2 = -1;
        for (FieldType fieldType2 : tableInfo.getFieldTypes()) {
            if (isFieldUpdatable(fieldType2, idField)) {
                if (fieldType2.isVersion()) {
                    i2 = i;
                    fieldType = fieldType2;
                }
                i++;
            }
        }
        int i3 = i + 1;
        if (fieldType != null) {
            i3++;
        }
        FieldType[] fieldTypeArr = new FieldType[i3];
        int i4 = 0;
        boolean z = true;
        for (FieldType fieldType3 : tableInfo.getFieldTypes()) {
            if (isFieldUpdatable(fieldType3, idField)) {
                if (z) {
                    sb2.append("SET ");
                    z = false;
                } else {
                    sb2.append(", ");
                }
                appendFieldColumnName(databaseType, sb2, fieldType3, null);
                fieldTypeArr[i4] = fieldType3;
                sb2.append("= ?");
                i4++;
            }
        }
        sb2.append(InputCardNumberView.DIVIDER);
        appendWhereFieldEq(databaseType, idField, sb2, null);
        fieldTypeArr[i4] = idField;
        if (fieldType != null) {
            sb2.append(" AND ");
            appendFieldColumnName(databaseType, sb2, fieldType, null);
            sb2.append("= ?");
            fieldTypeArr[i4 + 1] = fieldType;
        }
        return new MappedUpdate<>(tableInfo, sb2.toString(), fieldTypeArr, fieldType, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int update(DatabaseConnection databaseConnection, T t, ObjectCache objectCache) throws SQLException {
        Object obj;
        try {
            if (this.argFieldTypes.length <= 1) {
                return 0;
            }
            Object[] fieldObjects = getFieldObjects(t);
            FieldType fieldType = this.versionFieldType;
            if (fieldType != null) {
                obj = this.versionFieldType.moveToNextValue(fieldType.extractJavaFieldValue(t));
                fieldObjects[this.versionFieldTypeIndex] = this.versionFieldType.convertJavaFieldToSqlArgValue(obj);
            } else {
                obj = null;
            }
            int update = databaseConnection.update(this.statement, fieldObjects, this.argFieldTypes);
            if (update > 0) {
                if (obj != null) {
                    this.versionFieldType.assignField(t, obj, false, null);
                }
                if (objectCache != 0) {
                    Object obj2 = objectCache.get(this.clazz, this.idField.extractJavaFieldValue(t));
                    if (obj2 != null && obj2 != t) {
                        for (FieldType fieldType2 : this.tableInfo.getFieldTypes()) {
                            if (fieldType2 != this.idField) {
                                fieldType2.assignField(obj2, fieldType2.extractJavaFieldValue(t), false, objectCache);
                            }
                        }
                    }
                }
            }
            logger.debug("update data with statement '{}' and {} args, changed {} rows", this.statement, Integer.valueOf(fieldObjects.length), Integer.valueOf(update));
            if (fieldObjects.length > 0) {
                logger.trace("update arguments: {}", (Object) fieldObjects);
            }
            return update;
        } catch (SQLException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to run update stmt on object ");
            sb.append(t);
            sb.append(": ");
            sb.append(this.statement);
            throw SqlExceptionUtil.create(sb.toString(), e);
        }
    }

    private static boolean isFieldUpdatable(FieldType fieldType, FieldType fieldType2) {
        return (fieldType == fieldType2 || fieldType.isForeignCollection() || fieldType.isReadOnly()) ? false : true;
    }
}
