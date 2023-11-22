package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseResults;
import java.math.BigDecimal;
import java.sql.SQLException;

/* loaded from: classes8.dex */
public class BigDecimalNumericType extends BaseDataType {
    private static final BigDecimalNumericType singleTon = new BigDecimalNumericType();

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isAppropriateId() {
        return false;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isEscapedValue() {
        return false;
    }

    public static BigDecimalNumericType getSingleton() {
        return singleTon;
    }

    private BigDecimalNumericType() {
        super(SqlType.BIG_DECIMAL);
    }

    protected BigDecimalNumericType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object parseDefaultString(FieldType fieldType, String str) throws SQLException {
        try {
            return new BigDecimal(str);
        } catch (IllegalArgumentException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Problems with field ");
            sb.append(fieldType);
            sb.append(" parsing default BigDecimal string '");
            sb.append(str);
            sb.append("'");
            throw SqlExceptionUtil.create(sb.toString(), e);
        }
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i) throws SQLException {
        return databaseResults.getBigDecimal(i);
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public Class<?> getPrimaryClass() {
        return BigDecimal.class;
    }
}
