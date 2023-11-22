package com.j256.ormlite.field.types;

import com.j256.ormlite.field.SqlType;

/* loaded from: classes8.dex */
public class LongType extends LongObjectType {
    private static final LongType singleTon = new LongType();

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isPrimitive() {
        return true;
    }

    public static LongType getSingleton() {
        return singleTon;
    }

    private LongType() {
        super(SqlType.LONG, new Class[]{Long.TYPE});
    }

    protected LongType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }
}
