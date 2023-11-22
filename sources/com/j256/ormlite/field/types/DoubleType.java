package com.j256.ormlite.field.types;

import com.j256.ormlite.field.SqlType;

/* loaded from: classes8.dex */
public class DoubleType extends DoubleObjectType {
    private static final DoubleType singleTon = new DoubleType();

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isPrimitive() {
        return true;
    }

    public static DoubleType getSingleton() {
        return singleTon;
    }

    private DoubleType() {
        super(SqlType.DOUBLE, new Class[]{Double.TYPE});
    }

    protected DoubleType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }
}
