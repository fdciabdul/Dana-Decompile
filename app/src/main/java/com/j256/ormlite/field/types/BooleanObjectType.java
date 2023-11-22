package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

/* loaded from: classes8.dex */
public class BooleanObjectType extends BaseDataType {
    private static final BooleanObjectType singleTon = new BooleanObjectType();

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isAppropriateId() {
        return false;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isEscapedValue() {
        return false;
    }

    public static BooleanObjectType getSingleton() {
        return singleTon;
    }

    private BooleanObjectType() {
        super(SqlType.BOOLEAN, new Class[]{Boolean.class});
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BooleanObjectType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BooleanObjectType(SqlType sqlType) {
        super(sqlType);
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object parseDefaultString(FieldType fieldType, String str) {
        return Boolean.valueOf(Boolean.parseBoolean(str));
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i) throws SQLException {
        return Boolean.valueOf(databaseResults.getBoolean(i));
    }
}
