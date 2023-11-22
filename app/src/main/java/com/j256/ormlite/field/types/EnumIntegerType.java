package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class EnumIntegerType extends BaseEnumType {
    private static final EnumIntegerType singleTon = new EnumIntegerType();

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isEscapedValue() {
        return false;
    }

    public static EnumIntegerType getSingleton() {
        return singleTon;
    }

    private EnumIntegerType() {
        super(SqlType.INTEGER);
    }

    protected EnumIntegerType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object parseDefaultString(FieldType fieldType, String str) {
        return Integer.valueOf(Integer.parseInt(str));
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i) throws SQLException {
        return Integer.valueOf(databaseResults.getInt(i));
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object sqlArgToJava(FieldType fieldType, Object obj, int i) throws SQLException {
        if (fieldType == null) {
            return obj;
        }
        Integer num = (Integer) obj;
        Map map = (Map) fieldType.getDataTypeConfigObj();
        if (map == null) {
            return enumVal(fieldType, num, null, fieldType.getUnknownEnumVal());
        }
        return enumVal(fieldType, num, (Enum) map.get(num), fieldType.getUnknownEnumVal());
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object javaToSqlArg(FieldType fieldType, Object obj) {
        return Integer.valueOf(((Enum) obj).ordinal());
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public Object makeConfigObject(FieldType fieldType) throws SQLException {
        HashMap hashMap = new HashMap();
        Enum[] enumArr = (Enum[]) fieldType.getType().getEnumConstants();
        if (enumArr == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Field ");
            sb.append(fieldType);
            sb.append(" improperly configured as type ");
            sb.append(this);
            throw new SQLException(sb.toString());
        }
        for (Enum r3 : enumArr) {
            hashMap.put(Integer.valueOf(r3.ordinal()), r3);
        }
        return hashMap;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public Class<?> getPrimaryClass() {
        return Integer.TYPE;
    }
}
