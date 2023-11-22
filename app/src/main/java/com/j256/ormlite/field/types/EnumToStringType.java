package com.j256.ormlite.field.types;

import com.j256.ormlite.field.SqlType;

/* loaded from: classes8.dex */
public class EnumToStringType extends EnumStringType {
    private static final EnumToStringType singleTon = new EnumToStringType();

    public static EnumToStringType getSingleton() {
        return singleTon;
    }

    private EnumToStringType() {
        super(SqlType.STRING, new Class[]{Enum.class});
    }

    protected EnumToStringType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    @Override // com.j256.ormlite.field.types.EnumStringType
    protected String getEnumName(Enum<?> r1) {
        return r1.toString();
    }
}
