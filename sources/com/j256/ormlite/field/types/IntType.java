package com.j256.ormlite.field.types;

import com.j256.ormlite.field.SqlType;

/* loaded from: classes8.dex */
public class IntType extends IntegerObjectType {
    private static final IntType singleTon = new IntType();

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isPrimitive() {
        return true;
    }

    public static IntType getSingleton() {
        return singleTon;
    }

    private IntType() {
        super(SqlType.INTEGER, new Class[]{Integer.TYPE});
    }

    protected IntType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }
}
