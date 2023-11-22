package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.lang.reflect.Field;
import java.sql.SQLException;

/* loaded from: classes8.dex */
public abstract class BaseEnumType extends BaseDataType {
    /* JADX INFO: Access modifiers changed from: protected */
    public BaseEnumType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseEnumType(SqlType sqlType) {
        super(sqlType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Enum<?> enumVal(FieldType fieldType, Object obj, Enum<?> r2, Enum<?> r3) throws SQLException {
        if (r2 != null) {
            return r2;
        }
        if (r3 != null) {
            return r3;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot get enum value of '");
        sb.append(obj);
        sb.append("' for field ");
        sb.append(fieldType);
        throw new SQLException(sb.toString());
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isValidForField(Field field) {
        return field.getType().isEnum();
    }
}
