package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSONAware;
import com.alibaba.fastjson.annotation.JSONField;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* loaded from: classes3.dex */
public class FieldInfo implements Comparable<FieldInfo> {
    public final String[] alternateNames;
    public final Class<?> declaringClass;
    public final Field field;
    public final boolean fieldAccess;
    private final JSONField fieldAnnotation;
    public final Class<?> fieldClass;
    public final boolean fieldTransient;
    public final Type fieldType;
    public final String format;
    public final boolean getOnly;
    public final boolean isEnum;
    public final Method method;
    private final JSONField methodAnnotation;
    public final String name;
    public final long nameHashCode;
    private int ordinal;
    public final int serialzeFeatures;

    public FieldInfo(String str, Class<?> cls, Class<?> cls2, Type type, Field field, int i, int i2) {
        this.name = str;
        this.declaringClass = cls;
        this.fieldClass = cls2;
        this.fieldType = type;
        this.method = null;
        this.field = field;
        this.ordinal = i;
        this.serialzeFeatures = i2;
        this.isEnum = cls2.isEnum() && !JSONAware.class.isAssignableFrom(cls2);
        this.fieldAnnotation = null;
        this.methodAnnotation = null;
        if (field != null) {
            int modifiers = field.getModifiers();
            this.fieldAccess = true;
            this.fieldTransient = Modifier.isTransient(modifiers);
        } else {
            this.fieldAccess = false;
            this.fieldTransient = false;
        }
        this.getOnly = false;
        long j = -3750763034362895579L;
        for (int i3 = 0; i3 < str.length(); i3++) {
            j = (j ^ str.charAt(i3)) * 1099511628211L;
        }
        this.nameHashCode = j;
        this.format = null;
        this.alternateNames = new String[0];
    }

    /* JADX WARN: Code restructure failed: missing block: B:81:0x012d, code lost:
    
        r14 = r4.declaringClass.getTypeParameters();
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0135, code lost:
    
        if (r0 >= r14.length) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x013d, code lost:
    
        if (r6.equals(r14[r0]) == false) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x013f, code lost:
    
        r11 = r13[r0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0142, code lost:
    
        r0 = r0 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public FieldInfo(java.lang.String r5, java.lang.reflect.Method r6, java.lang.reflect.Field r7, java.lang.Class<?> r8, java.lang.reflect.Type r9, int r10, int r11, com.alibaba.fastjson.annotation.JSONField r12, com.alibaba.fastjson.annotation.JSONField r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 412
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.FieldInfo.<init>(java.lang.String, java.lang.reflect.Method, java.lang.reflect.Field, java.lang.Class, java.lang.reflect.Type, int, int, com.alibaba.fastjson.annotation.JSONField, com.alibaba.fastjson.annotation.JSONField, boolean):void");
    }

    public static Type getFieldType(Class<?> cls, Type type, Type type2) {
        TypeVariable<Class<? super Object>>[] typeVariableArr;
        ParameterizedType parameterizedType;
        if (cls != null && type != null) {
            if (type2 instanceof GenericArrayType) {
                Type genericComponentType = ((GenericArrayType) type2).getGenericComponentType();
                Type fieldType = getFieldType(cls, type, genericComponentType);
                return genericComponentType != fieldType ? Array.newInstance(TypeUtils.getClass(fieldType), 0).getClass() : type2;
            } else if (!TypeUtils.isGenericParamType(type)) {
                return type2;
            } else {
                if (type2 instanceof TypeVariable) {
                    ParameterizedType parameterizedType2 = (ParameterizedType) TypeUtils.getGenericParamType(type);
                    Class<?> cls2 = TypeUtils.getClass(parameterizedType2);
                    TypeVariable typeVariable = (TypeVariable) type2;
                    for (int i = 0; i < cls2.getTypeParameters().length; i++) {
                        if (cls2.getTypeParameters()[i].getName().equals(typeVariable.getName())) {
                            return parameterizedType2.getActualTypeArguments()[i];
                        }
                    }
                }
                if (type2 instanceof ParameterizedType) {
                    ParameterizedType parameterizedType3 = (ParameterizedType) type2;
                    Type[] actualTypeArguments = parameterizedType3.getActualTypeArguments();
                    Type[] typeArr = null;
                    if (type instanceof ParameterizedType) {
                        parameterizedType = (ParameterizedType) type;
                        typeVariableArr = cls.getTypeParameters();
                    } else if (cls.getGenericSuperclass() instanceof ParameterizedType) {
                        parameterizedType = (ParameterizedType) cls.getGenericSuperclass();
                        typeVariableArr = cls.getSuperclass().getTypeParameters();
                    } else {
                        typeVariableArr = null;
                        parameterizedType = null;
                    }
                    boolean z = false;
                    for (int i2 = 0; i2 < actualTypeArguments.length && parameterizedType != null; i2++) {
                        Type type3 = actualTypeArguments[i2];
                        if (type3 instanceof TypeVariable) {
                            TypeVariable typeVariable2 = (TypeVariable) type3;
                            for (int i3 = 0; i3 < typeVariableArr.length; i3++) {
                                if (typeVariableArr[i3].getName().equals(typeVariable2.getName())) {
                                    if (typeArr == null) {
                                        typeArr = parameterizedType.getActualTypeArguments();
                                    }
                                    actualTypeArguments[i2] = typeArr[i3];
                                    z = true;
                                }
                            }
                        }
                    }
                    if (z) {
                        return new ParameterizedTypeImpl(actualTypeArguments, parameterizedType3.getOwnerType(), parameterizedType3.getRawType());
                    }
                }
            }
        }
        return type2;
    }

    public String toString() {
        return this.name;
    }

    @Override // java.lang.Comparable
    public int compareTo(FieldInfo fieldInfo) {
        int i = this.ordinal;
        int i2 = fieldInfo.ordinal;
        if (i < i2) {
            return -1;
        }
        if (i > i2) {
            return 1;
        }
        return this.name.compareTo(fieldInfo.name);
    }

    public boolean equals(FieldInfo fieldInfo) {
        return fieldInfo == this || compareTo(fieldInfo) == 0;
    }

    public JSONField getAnnotation() {
        JSONField jSONField = this.fieldAnnotation;
        return jSONField != null ? jSONField : this.methodAnnotation;
    }

    public Object get(Object obj) throws IllegalAccessException, InvocationTargetException {
        if (this.fieldAccess) {
            return this.field.get(obj);
        }
        return this.method.invoke(obj, new Object[0]);
    }

    public void set(Object obj, Object obj2) throws IllegalAccessException, InvocationTargetException {
        Method method = this.method;
        if (method != null) {
            method.invoke(obj, obj2);
        } else {
            this.field.set(obj, obj2);
        }
    }
}
