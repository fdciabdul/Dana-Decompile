package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Log;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.GeneratedKeyHolder;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

/* loaded from: classes8.dex */
public class MappedCreate<T, ID> extends BaseMappedStatement<T, ID> {
    private String dataClassName;
    private final String queryNextSequenceStmt;
    private int versionFieldTypeIndex;

    private MappedCreate(TableInfo<T, ID> tableInfo, String str, FieldType[] fieldTypeArr, String str2, int i) {
        super(tableInfo, str, fieldTypeArr);
        this.dataClassName = tableInfo.getDataClass().getSimpleName();
        this.queryNextSequenceStmt = str2;
        this.versionFieldTypeIndex = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0066 A[Catch: SQLException -> 0x0138, TryCatch #1 {SQLException -> 0x0138, blocks: (B:27:0x005e, B:29:0x0066, B:31:0x0070, B:39:0x008c, B:34:0x0079, B:36:0x007f, B:38:0x0089, B:40:0x008f, B:42:0x0097, B:44:0x009b, B:48:0x00b7, B:50:0x00cc, B:53:0x00d5, B:55:0x00e0, B:57:0x00e6, B:59:0x00f0, B:60:0x00f6, B:61:0x00fd, B:62:0x00fe, B:63:0x0105, B:65:0x0108, B:67:0x0114, B:70:0x0121, B:72:0x0132, B:73:0x0137, B:47:0x00af), top: B:80:0x005e, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00cc A[Catch: SQLException -> 0x0138, TryCatch #1 {SQLException -> 0x0138, blocks: (B:27:0x005e, B:29:0x0066, B:31:0x0070, B:39:0x008c, B:34:0x0079, B:36:0x007f, B:38:0x0089, B:40:0x008f, B:42:0x0097, B:44:0x009b, B:48:0x00b7, B:50:0x00cc, B:53:0x00d5, B:55:0x00e0, B:57:0x00e6, B:59:0x00f0, B:60:0x00f6, B:61:0x00fd, B:62:0x00fe, B:63:0x0105, B:65:0x0108, B:67:0x0114, B:70:0x0121, B:72:0x0132, B:73:0x0137, B:47:0x00af), top: B:80:0x005e, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int insert(com.j256.ormlite.db.DatabaseType r11, com.j256.ormlite.support.DatabaseConnection r12, T r13, com.j256.ormlite.dao.ObjectCache r14) throws java.sql.SQLException {
        /*
            Method dump skipped, instructions count: 347
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.stmt.mapped.MappedCreate.insert(com.j256.ormlite.db.DatabaseType, com.j256.ormlite.support.DatabaseConnection, java.lang.Object, com.j256.ormlite.dao.ObjectCache):int");
    }

    public static <T, ID> MappedCreate<T, ID> build(DatabaseType databaseType, TableInfo<T, ID> tableInfo) {
        StringBuilder sb = new StringBuilder(128);
        appendTableName(databaseType, sb, "INSERT INTO ", tableInfo.getTableName());
        int i = 0;
        int i2 = -1;
        for (FieldType fieldType : tableInfo.getFieldTypes()) {
            if (isFieldCreatable(databaseType, fieldType)) {
                if (fieldType.isVersion()) {
                    i2 = i;
                }
                i++;
            }
        }
        FieldType[] fieldTypeArr = new FieldType[i];
        if (i == 0) {
            databaseType.appendInsertNoColumns(sb);
        } else {
            sb.append('(');
            boolean z = true;
            boolean z2 = true;
            int i3 = 0;
            for (FieldType fieldType2 : tableInfo.getFieldTypes()) {
                if (isFieldCreatable(databaseType, fieldType2)) {
                    if (z2) {
                        z2 = false;
                    } else {
                        sb.append(',');
                    }
                    appendFieldColumnName(databaseType, sb, fieldType2, null);
                    fieldTypeArr[i3] = fieldType2;
                    i3++;
                }
            }
            sb.append(") VALUES (");
            for (FieldType fieldType3 : tableInfo.getFieldTypes()) {
                if (isFieldCreatable(databaseType, fieldType3)) {
                    if (z) {
                        z = false;
                    } else {
                        sb.append(',');
                    }
                    sb.append('?');
                }
            }
            sb.append(')');
        }
        return new MappedCreate<>(tableInfo, sb.toString(), fieldTypeArr, buildQueryNextSequence(databaseType, tableInfo.getIdField()), i2);
    }

    private boolean foreignCollectionsAreAssigned(FieldType[] fieldTypeArr, Object obj) throws SQLException {
        for (FieldType fieldType : fieldTypeArr) {
            if (fieldType.extractJavaFieldValue(obj) == null) {
                return false;
            }
        }
        return true;
    }

    private static boolean isFieldCreatable(DatabaseType databaseType, FieldType fieldType) {
        if (fieldType.isForeignCollection() || fieldType.isReadOnly()) {
            return false;
        }
        return (databaseType.isIdSequenceNeeded() && databaseType.isSelectSequenceBeforeInsert()) || !fieldType.isGeneratedId() || fieldType.isSelfGeneratedId() || fieldType.isAllowGeneratedIdInsert();
    }

    private static String buildQueryNextSequence(DatabaseType databaseType, FieldType fieldType) {
        String generatedIdSequence;
        if (fieldType == null || (generatedIdSequence = fieldType.getGeneratedIdSequence()) == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(64);
        databaseType.appendSelectNextValFromSequence(sb, generatedIdSequence);
        return sb.toString();
    }

    private void assignSequenceId(DatabaseConnection databaseConnection, T t, ObjectCache objectCache) throws SQLException {
        long queryForLong = databaseConnection.queryForLong(this.queryNextSequenceStmt);
        logger.debug("queried for sequence {} using stmt: {}", Long.valueOf(queryForLong), this.queryNextSequenceStmt);
        if (queryForLong == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Should not have returned 0 for stmt: ");
            sb.append(this.queryNextSequenceStmt);
            throw new SQLException(sb.toString());
        }
        assignIdValue(t, Long.valueOf(queryForLong), "sequence", objectCache);
    }

    private void assignIdValue(T t, Number number, String str, ObjectCache objectCache) throws SQLException {
        this.idField.assignIdValue(t, number, objectCache);
        if (logger.isLevelEnabled(Log.Level.DEBUG)) {
            logger.debug("assigned id '{}' from {} to '{}' in {} object", new Object[]{number, str, this.idField.getFieldName(), this.dataClassName});
        }
    }

    /* loaded from: classes8.dex */
    static class KeyHolder implements GeneratedKeyHolder {
        Number key;

        private KeyHolder() {
        }

        public Number getKey() {
            return this.key;
        }

        @Override // com.j256.ormlite.support.GeneratedKeyHolder
        public void addKey(Number number) throws SQLException {
            if (this.key == null) {
                this.key = number;
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("generated key has already been set to ");
            sb.append(this.key);
            sb.append(", now set to ");
            sb.append(number);
            throw new SQLException(sb.toString());
        }
    }
}
