package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

/* loaded from: classes8.dex */
public class ByteObjectType extends BaseDataType {
    private static final ByteObjectType singleTon = new ByteObjectType();

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isEscapedValue() {
        return false;
    }

    public static ByteObjectType getSingleton() {
        return singleTon;
    }

    private ByteObjectType() {
        super(SqlType.BYTE, new Class[]{Byte.class});
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ByteObjectType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object parseDefaultString(FieldType fieldType, String str) {
        return Byte.valueOf(Byte.parseByte(str));
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i) throws SQLException {
        return Byte.valueOf(databaseResults.getByte(i));
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public Object convertIdNumber(Number number) {
        return Byte.valueOf(number.byteValue());
    }
}
