package com.iap.ac.android.common.json.type;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* loaded from: classes3.dex */
public class ParameterizedTypeImpl implements ParameterizedType {
    public final Type[] args;
    public final Class raw;

    public ParameterizedTypeImpl(Class cls, Type[] typeArr) {
        this.raw = cls;
        this.args = typeArr == null ? new Type[0] : typeArr;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type[] getActualTypeArguments() {
        return this.args;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getOwnerType() {
        return null;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getRawType() {
        return this.raw;
    }
}
