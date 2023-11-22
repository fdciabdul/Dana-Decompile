package com.j256.ormlite.field.types;

import com.j256.ormlite.field.SqlType;

/* loaded from: classes8.dex */
public class LongStringType extends StringType {
    private static final LongStringType singleTon = new LongStringType();

    @Override // com.j256.ormlite.field.types.StringType, com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public int getDefaultWidth() {
        return 0;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isAppropriateId() {
        return false;
    }

    public static LongStringType getSingleton() {
        return singleTon;
    }

    private LongStringType() {
        super(SqlType.LONG_STRING);
    }

    protected LongStringType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public Class<?> getPrimaryClass() {
        return String.class;
    }
}
