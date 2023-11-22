package com.google.common.reflect;

import com.google.common.collect.Sets;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
@ElementTypesAreNonnullByDefault
/* loaded from: classes7.dex */
public abstract class TypeVisitor {
    private final Set<Type> visited = Sets.newHashSet();

    void visitClass(Class<?> cls) {
    }

    void visitGenericArrayType(GenericArrayType genericArrayType) {
    }

    void visitParameterizedType(ParameterizedType parameterizedType) {
    }

    void visitTypeVariable(TypeVariable<?> typeVariable) {
    }

    void visitWildcardType(WildcardType wildcardType) {
    }

    public final void visit(Type... typeArr) {
        for (Type type : typeArr) {
            if (type != null && this.visited.add(type)) {
                if (type instanceof TypeVariable) {
                    try {
                        visitTypeVariable((TypeVariable) type);
                    } catch (Throwable th) {
                        this.visited.remove(type);
                        throw th;
                    }
                } else if (type instanceof WildcardType) {
                    visitWildcardType((WildcardType) type);
                } else if (type instanceof ParameterizedType) {
                    visitParameterizedType((ParameterizedType) type);
                } else if (type instanceof Class) {
                    visitClass((Class) type);
                } else if (type instanceof GenericArrayType) {
                    visitGenericArrayType((GenericArrayType) type);
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unknown type: ");
                    sb.append(type);
                    throw new AssertionError(sb.toString());
                }
            }
        }
    }
}
