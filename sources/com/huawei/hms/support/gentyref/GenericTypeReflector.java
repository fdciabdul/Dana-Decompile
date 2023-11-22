package com.huawei.hms.support.gentyref;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* loaded from: classes8.dex */
public final class GenericTypeReflector {
    public static Class<?> getType(Type type) {
        while (!(type instanceof Class)) {
            if (type instanceof ParameterizedType) {
                return (Class) ((ParameterizedType) type).getRawType();
            }
            if (type instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) type;
                if (typeVariable.getBounds().length == 0) {
                    return Object.class;
                }
                type = typeVariable.getBounds()[0];
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("not supported: ");
                sb.append(type.getClass());
                throw new IllegalArgumentException(sb.toString());
            }
        }
        return (Class) type;
    }
}
