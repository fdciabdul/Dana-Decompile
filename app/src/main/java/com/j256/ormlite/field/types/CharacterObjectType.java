package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

/* loaded from: classes8.dex */
public class CharacterObjectType extends BaseDataType {
    private static final CharacterObjectType singleTon = new CharacterObjectType();

    public static CharacterObjectType getSingleton() {
        return singleTon;
    }

    private CharacterObjectType() {
        super(SqlType.CHAR, new Class[]{Character.class});
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CharacterObjectType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object parseDefaultString(FieldType fieldType, String str) throws SQLException {
        if (str.length() != 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("Problems with field ");
            sb.append(fieldType);
            sb.append(", default string to long for Character: '");
            sb.append(str);
            sb.append("'");
            throw new SQLException(sb.toString());
        }
        return Character.valueOf(str.charAt(0));
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i) throws SQLException {
        return Character.valueOf(databaseResults.getChar(i));
    }
}
