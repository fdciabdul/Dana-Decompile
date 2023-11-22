package com.j256.ormlite.stmt.query;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.ArgumentHolder;
import id.dana.cashier.view.InputCardNumberView;
import java.sql.SQLException;
import java.util.List;

/* loaded from: classes8.dex */
abstract class BaseComparison implements Comparison {
    private static final String NUMBER_CHARACTERS = "0123456789.-+";
    protected final String columnName;
    protected final FieldType fieldType;
    private final Object value;

    @Override // com.j256.ormlite.stmt.query.Comparison
    public abstract void appendOperation(StringBuilder sb);

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseComparison(String str, FieldType fieldType, Object obj, boolean z) throws SQLException {
        if (z && fieldType != null && !fieldType.isComparable()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Field '");
            sb.append(str);
            sb.append("' is of data type ");
            sb.append(fieldType.getDataPersister());
            sb.append(" which can not be compared");
            throw new SQLException(sb.toString());
        }
        this.columnName = str;
        this.fieldType = fieldType;
        this.value = obj;
    }

    @Override // com.j256.ormlite.stmt.query.Clause
    public void appendSql(DatabaseType databaseType, String str, StringBuilder sb, List<ArgumentHolder> list) throws SQLException {
        if (str != null) {
            databaseType.appendEscapedEntityName(sb, str);
            sb.append('.');
        }
        databaseType.appendEscapedEntityName(sb, this.columnName);
        sb.append(InputCardNumberView.DIVIDER);
        appendOperation(sb);
        appendValue(databaseType, sb, list);
    }

    @Override // com.j256.ormlite.stmt.query.Comparison
    public String getColumnName() {
        return this.columnName;
    }

    @Override // com.j256.ormlite.stmt.query.Comparison
    public void appendValue(DatabaseType databaseType, StringBuilder sb, List<ArgumentHolder> list) throws SQLException {
        appendArgOrValue(databaseType, this.fieldType, sb, list, this.value);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void appendArgOrValue(com.j256.ormlite.db.DatabaseType r10, com.j256.ormlite.field.FieldType r11, java.lang.StringBuilder r12, java.util.List<com.j256.ormlite.stmt.ArgumentHolder> r13, java.lang.Object r14) throws java.sql.SQLException {
        /*
            r9 = this;
            if (r14 == 0) goto Le2
            boolean r0 = r14 instanceof com.j256.ormlite.stmt.ArgumentHolder
            r1 = 63
            r2 = 0
            if (r0 == 0) goto L18
            r12.append(r1)
            com.j256.ormlite.stmt.ArgumentHolder r14 = (com.j256.ormlite.stmt.ArgumentHolder) r14
            java.lang.String r10 = r9.columnName
            r14.setMetaInfo(r10, r11)
            r13.add(r14)
            goto Ld9
        L18:
            boolean r0 = r14 instanceof com.j256.ormlite.stmt.ColumnArg
            if (r0 == 0) goto L35
            com.j256.ormlite.stmt.ColumnArg r14 = (com.j256.ormlite.stmt.ColumnArg) r14
            java.lang.String r11 = r14.getTableName()
            if (r11 == 0) goto L2c
            r10.appendEscapedEntityName(r12, r11)
            r11 = 46
            r12.append(r11)
        L2c:
            java.lang.String r11 = r14.getColumnName()
            r10.appendEscapedEntityName(r12, r11)
            goto Ld9
        L35:
            boolean r0 = r11.isArgumentHolderRequired()
            if (r0 == 0) goto L50
            r12.append(r1)
            com.j256.ormlite.stmt.SelectArg r10 = new com.j256.ormlite.stmt.SelectArg
            r10.<init>()
            java.lang.String r0 = r9.columnName
            r10.setMetaInfo(r0, r11)
            r10.setValue(r14)
            r13.add(r10)
            goto Ld9
        L50:
            boolean r0 = r11.isForeign()
            if (r0 == 0) goto L74
            java.lang.Class r0 = r11.getType()
            java.lang.Class r1 = r14.getClass()
            boolean r0 = r0.isAssignableFrom(r1)
            if (r0 == 0) goto L74
            com.j256.ormlite.field.FieldType r5 = r11.getForeignIdField()
            java.lang.Object r8 = r5.extractJavaFieldValue(r14)
            r3 = r9
            r4 = r10
            r6 = r12
            r7 = r13
            r3.appendArgOrValue(r4, r5, r6, r7, r8)
            goto Lda
        L74:
            boolean r13 = r11.isEscapedValue()
            if (r13 == 0) goto L86
            java.lang.Object r11 = r11.convertJavaFieldToSqlArgValue(r14)
            java.lang.String r11 = r11.toString()
            r10.appendEscapedWord(r12, r11)
            goto Ld9
        L86:
            boolean r10 = r11.isForeign()
            if (r10 == 0) goto Ld2
            java.lang.Object r10 = r11.convertJavaFieldToSqlArgValue(r14)
            java.lang.String r10 = r10.toString()
            int r13 = r10.length()
            if (r13 <= 0) goto Lce
            char r13 = r10.charAt(r2)
            java.lang.String r14 = "0123456789.-+"
            int r13 = r14.indexOf(r13)
            if (r13 < 0) goto La7
            goto Lce
        La7:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "Foreign field "
            r12.append(r13)
            r12.append(r11)
            java.lang.String r11 = " does not seem to be producing a numerical value '"
            r12.append(r11)
            r12.append(r10)
            java.lang.String r10 = "'. Maybe you are passing the wrong object to comparison: "
            r12.append(r10)
            r12.append(r9)
            java.sql.SQLException r10 = new java.sql.SQLException
            java.lang.String r11 = r12.toString()
            r10.<init>(r11)
            throw r10
        Lce:
            r12.append(r10)
            goto Ld9
        Ld2:
            java.lang.Object r10 = r11.convertJavaFieldToSqlArgValue(r14)
            r12.append(r10)
        Ld9:
            r2 = 1
        Lda:
            if (r2 == 0) goto Le1
            r10 = 32
            r12.append(r10)
        Le1:
            return
        Le2:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r12 = "argument for '"
            r10.append(r12)
            java.lang.String r11 = r11.getFieldName()
            r10.append(r11)
            java.lang.String r11 = "' is null"
            r10.append(r11)
            java.sql.SQLException r11 = new java.sql.SQLException
            java.lang.String r10 = r10.toString()
            r11.<init>(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.stmt.query.BaseComparison.appendArgOrValue(com.j256.ormlite.db.DatabaseType, com.j256.ormlite.field.FieldType, java.lang.StringBuilder, java.util.List, java.lang.Object):void");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.columnName);
        sb.append(InputCardNumberView.DIVIDER);
        appendOperation(sb);
        sb.append(InputCardNumberView.DIVIDER);
        sb.append(this.value);
        return sb.toString();
    }
}
