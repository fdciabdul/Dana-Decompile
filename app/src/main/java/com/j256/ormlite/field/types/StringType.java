package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

/* loaded from: classes8.dex */
public class StringType extends BaseDataType {
    public static int DEFAULT_WIDTH = 255;
    private static final StringType singleTon = new StringType();

    @Override // com.j256.ormlite.field.FieldConverter
    public Object parseDefaultString(FieldType fieldType, String str) {
        return str;
    }

    public static StringType getSingleton() {
        return singleTon;
    }

    private StringType() {
        super(SqlType.STRING, new Class[]{String.class});
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public StringType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public StringType(SqlType sqlType) {
        super(sqlType);
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i) throws SQLException {
        return databaseResults.getString(i);
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public int getDefaultWidth() {
        return DEFAULT_WIDTH;
    }
}
