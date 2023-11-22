package com.j256.ormlite.field.types;

import com.j256.ormlite.field.SqlType;

/* loaded from: classes8.dex */
public class BooleanType extends BooleanObjectType {
    private static final BooleanType singleTon = new BooleanType();

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isPrimitive() {
        return true;
    }

    public static BooleanType getSingleton() {
        return singleTon;
    }

    private BooleanType() {
        super(SqlType.BOOLEAN, new Class[]{Boolean.TYPE});
    }

    protected BooleanType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BooleanType(SqlType sqlType) {
        super(sqlType);
    }
}
