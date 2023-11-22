package com.apiguard3.internal;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import kotlin.text.Typography;

/* loaded from: classes7.dex */
public final class setForceDarkAllowed {
    private static int getSharedInstance = 1;
    private static int valueOf = 108;
    static final Type[] values = new Type[0];

    private static ParameterizedType getSharedInstance(Type type, Type type2, Type... typeArr) {
        valueOf valueof = new valueOf(type, type2, typeArr);
        int i = getSharedInstance + 69;
        valueOf = i % 128;
        if (i % 2 == 0) {
            return valueof;
        }
        throw new ArithmeticException();
    }

    private static GenericArrayType getRequestHeaders(Type type) {
        values valuesVar = new values(type);
        int i = getSharedInstance + 65;
        valueOf = i % 128;
        if (i % 2 != 0) {
            throw new NullPointerException();
        }
        return valuesVar;
    }

    private static WildcardType analyzeResponse(Type type) {
        Type[] upperBounds;
        if ((type instanceof WildcardType ? '6' : 'V') != '6') {
            upperBounds = new Type[]{type};
        } else {
            int i = getSharedInstance + 101;
            valueOf = i % 128;
            WildcardType wildcardType = (WildcardType) type;
            if (i % 2 != 0) {
                wildcardType.getUpperBounds();
                throw null;
            }
            upperBounds = wildcardType.getUpperBounds();
        }
        APIGuard aPIGuard = new APIGuard(upperBounds, values);
        valueOf = (getSharedInstance + 91) % 128;
        return aPIGuard;
    }

    private static WildcardType initialize(Type type) {
        getSharedInstance = (valueOf + 27) % 128;
        APIGuard aPIGuard = new APIGuard(new Type[]{Object.class}, (type instanceof WildcardType ? 'I' : '^') != '^' ? ((WildcardType) type).getLowerBounds() : new Type[]{type});
        valueOf = (getSharedInstance + 15) % 128;
        return aPIGuard;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [com.apiguard3.internal.setForceDarkAllowed$values] */
    public static Type getSharedInstance(Type type) {
        int i = getSharedInstance + 9;
        valueOf = i % 128;
        if ((i % 2 != 0 ? ']' : 'U') == 'U') {
            if ((!(type instanceof Class)) != true) {
                Class cls = (Class) type;
                if (cls.isArray()) {
                    cls = new values(getSharedInstance(cls.getComponentType()));
                }
                Class cls2 = cls;
                int i2 = getSharedInstance + 17;
                valueOf = i2 % 128;
                if (i2 % 2 != 0) {
                    throw null;
                }
                return cls2;
            } else if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                return new valueOf(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
            } else if (type instanceof GenericArrayType) {
                return new values(((GenericArrayType) type).getGenericComponentType());
            } else {
                if (type instanceof WildcardType) {
                    WildcardType wildcardType = (WildcardType) type;
                    return new APIGuard(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
                }
                return type;
            }
        }
        throw new ArithmeticException();
    }

    public static Class<?> AGState(Type type) {
        while (true) {
            if ((type instanceof Class ? '?' : '(') != '(') {
                return (Class) type;
            }
            if (type instanceof ParameterizedType) {
                Type rawType = ((ParameterizedType) type).getRawType();
                setBottom.getSharedInstance(rawType instanceof Class);
                return (Class) rawType;
            } else if (!(type instanceof GenericArrayType)) {
                if (!(type instanceof TypeVariable)) {
                    if ((!(type instanceof WildcardType)) == false) {
                        int i = getSharedInstance + 41;
                        valueOf = i % 128;
                        type = i % 2 != 0 ? ((WildcardType) type).getUpperBounds()[1] : ((WildcardType) type).getUpperBounds()[0];
                    } else {
                        String name = (type == null ? 'T' : ':') != ':' ? "null" : type.getClass().getName();
                        StringBuilder sb = new StringBuilder("Expected a Class, ParameterizedType, or GenericArrayType, but <");
                        sb.append(type);
                        sb.append("> is of type ");
                        sb.append(name);
                        throw new IllegalArgumentException(sb.toString());
                    }
                } else {
                    int i2 = valueOf;
                    getSharedInstance = (i2 + 107) % 128;
                    getSharedInstance = (i2 + 97) % 128;
                    return Object.class;
                }
            } else {
                int i3 = getSharedInstance + 33;
                valueOf = i3 % 128;
                return (i3 % 2 != 0 ? Array.newInstance(AGState(((GenericArrayType) type).getGenericComponentType()), 1) : Array.newInstance(AGState(((GenericArrayType) type).getGenericComponentType()), 0)).getClass();
            }
        }
    }

    private static boolean getSharedInstance(Object obj, Object obj2) {
        int i = valueOf + 37;
        getSharedInstance = i % 128;
        if (!(i % 2 != 0)) {
            throw new NullPointerException();
        }
        if (obj != obj2) {
            if ((obj == null) || (!obj.equals(obj2)) != false) {
                int i2 = getSharedInstance + 77;
                valueOf = i2 % 128;
                if (i2 % 2 == 0) {
                    return false;
                }
                throw new NullPointerException();
            }
        }
        return true;
    }

    public static boolean AGState(Type type, Type type2) {
        while (true) {
            if ((type == type2 ? '1' : 'N') != 'N') {
                valueOf = (getSharedInstance + 15) % 128;
                return true;
            } else if (type instanceof Class) {
                boolean equals = type.equals(type2);
                int i = valueOf + 83;
                getSharedInstance = i % 128;
                if ((i % 2 == 0 ? (char) 20 : (char) 31) == 31) {
                    return equals;
                }
                throw null;
            } else if (type instanceof ParameterizedType) {
                if (type2 instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) type;
                    ParameterizedType parameterizedType2 = (ParameterizedType) type2;
                    if (getSharedInstance(parameterizedType.getOwnerType(), parameterizedType2.getOwnerType()) && parameterizedType.getRawType().equals(parameterizedType2.getRawType())) {
                        int i2 = valueOf + 17;
                        getSharedInstance = i2 % 128;
                        if (i2 % 2 == 0) {
                            Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
                            throw null;
                        } else if (Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments())) {
                            int i3 = valueOf + 33;
                            getSharedInstance = i3 % 128;
                            return i3 % 2 != 0;
                        }
                    }
                    return false;
                }
                return false;
            } else {
                if ((type instanceof GenericArrayType ? 'P' : Typography.less) != 'P') {
                    if ((type instanceof WildcardType ? 'I' : '8') == 'I') {
                        int i4 = getSharedInstance + 65;
                        int i5 = i4 % 128;
                        valueOf = i5;
                        if (i4 % 2 != 0) {
                            throw new ArithmeticException();
                        } else if ((!(type2 instanceof WildcardType)) == true) {
                            int i6 = i5 + 31;
                            getSharedInstance = i6 % 128;
                            return !(i6 % 2 != 0);
                        } else {
                            WildcardType wildcardType = (WildcardType) type;
                            WildcardType wildcardType2 = (WildcardType) type2;
                            return Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds());
                        }
                    } else if (type instanceof TypeVariable) {
                        int i7 = valueOf + 49;
                        getSharedInstance = i7 % 128;
                        if ((i7 % 2 == 0 ? '%' : (char) 15) != 15) {
                            throw null;
                        } else if (type2 instanceof TypeVariable) {
                            TypeVariable typeVariable = (TypeVariable) type;
                            TypeVariable typeVariable2 = (TypeVariable) type2;
                            if (typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration()) {
                                getSharedInstance = (valueOf + 125) % 128;
                                if (typeVariable.getName().equals(typeVariable2.getName())) {
                                    return true;
                                }
                            }
                            return false;
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
                getSharedInstance = (valueOf + 1) % 128;
                if (!(type2 instanceof GenericArrayType)) {
                    return false;
                }
                type = ((GenericArrayType) type).getGenericComponentType();
                type2 = ((GenericArrayType) type2).getGenericComponentType();
            }
        }
    }

    static int values(Object obj) {
        if (!(obj == null)) {
            getSharedInstance = (valueOf + 123) % 128;
            int hashCode = obj.hashCode();
            int i = getSharedInstance + 3;
            valueOf = i % 128;
            if ((i % 2 != 0 ? (char) 20 : '\n') != 20) {
                return hashCode;
            }
            throw new ArithmeticException();
        }
        return 0;
    }

    public static String values(Type type) {
        if (!(type instanceof Class)) {
            String obj = type.toString();
            getSharedInstance = (valueOf + 27) % 128;
            return obj;
        }
        int i = valueOf + 111;
        getSharedInstance = i % 128;
        Class cls = (Class) type;
        if (i % 2 != 0) {
            return cls.getName();
        }
        throw null;
    }

    private static Type values(Type type, Class<?> cls, Class<?> cls2) {
        Class<?> superclass;
        Type genericSuperclass;
        loop0: while (cls2 != cls) {
            if (cls2.isInterface()) {
                Class<?>[] interfaces = cls.getInterfaces();
                int length = interfaces.length;
                for (int i = 0; i < length; i++) {
                    int i2 = getSharedInstance + 43;
                    valueOf = i2 % 128;
                    if (!(i2 % 2 == 0)) {
                        Class<?> cls3 = interfaces[i];
                        throw null;
                    }
                    Class<?> cls4 = interfaces[i];
                    if (!(cls4 != cls2)) {
                        return cls.getGenericInterfaces()[i];
                    }
                    if (cls2.isAssignableFrom(cls4)) {
                        int i3 = valueOf + 33;
                        getSharedInstance = i3 % 128;
                        if (i3 % 2 == 0) {
                            Type type2 = cls.getGenericInterfaces()[i];
                            Class<?> cls5 = interfaces[i];
                            throw new NullPointerException();
                        }
                        genericSuperclass = cls.getGenericInterfaces()[i];
                        superclass = interfaces[i];
                        Type type3 = genericSuperclass;
                        cls = superclass;
                        type = type3;
                    }
                }
            }
            if (!cls.isInterface()) {
                while (true) {
                    if ((cls != Object.class ? 'N' : '@') == '@') {
                        break loop0;
                    }
                    superclass = cls.getSuperclass();
                    if (!(superclass != cls2)) {
                        return cls.getGenericSuperclass();
                    }
                    if (cls2.isAssignableFrom(superclass)) {
                        int i4 = getSharedInstance + 71;
                        valueOf = i4 % 128;
                        if (i4 % 2 != 0) {
                            throw new NullPointerException();
                        }
                        genericSuperclass = cls.getGenericSuperclass();
                    } else {
                        cls = superclass;
                    }
                }
            }
            return cls2;
        }
        return type;
    }

    private static Type getSharedInstance(Type type, Class<?> cls, Class<?> cls2) {
        if (type instanceof WildcardType) {
            type = ((WildcardType) type).getUpperBounds()[0];
            valueOf = (getSharedInstance + 45) % 128;
        }
        setBottom.getSharedInstance(cls2.isAssignableFrom(cls));
        Type values2 = values(type, cls, values(type, cls, cls2));
        getSharedInstance = (valueOf + 111) % 128;
        return values2;
    }

    public static Type valueOf(Type type) {
        if (type instanceof GenericArrayType) {
            getSharedInstance = (valueOf + 43) % 128;
            Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
            getSharedInstance = (valueOf + 15) % 128;
            return genericComponentType;
        }
        return ((Class) type).getComponentType();
    }

    public static Type values(Type type, Class<?> cls) {
        valueOf = (getSharedInstance + 61) % 128;
        Type sharedInstance = getSharedInstance(type, cls, Collection.class);
        if ((!(sharedInstance instanceof WildcardType)) == false) {
            sharedInstance = ((WildcardType) sharedInstance).getUpperBounds()[0];
            getSharedInstance = (valueOf + 63) % 128;
        }
        if ((sharedInstance instanceof ParameterizedType ? Typography.amp : '!') == '&') {
            valueOf = (getSharedInstance + 1) % 128;
            return ((ParameterizedType) sharedInstance).getActualTypeArguments()[0];
        }
        return Object.class;
    }

    public static Type[] AGState(Type type, Class<?> cls) {
        if (type == Properties.class) {
            int i = getSharedInstance + 75;
            valueOf = i % 128;
            if (i % 2 != 0) {
                Type[] typeArr = new Type[4];
                typeArr[1] = String.class;
                typeArr[1] = String.class;
                return typeArr;
            }
            return new Type[]{String.class, String.class};
        }
        Type sharedInstance = getSharedInstance(type, cls, Map.class);
        if ((!(sharedInstance instanceof ParameterizedType)) != true) {
            int i2 = getSharedInstance + 67;
            valueOf = i2 % 128;
            if (!(i2 % 2 != 0)) {
                Type[] actualTypeArguments = ((ParameterizedType) sharedInstance).getActualTypeArguments();
                valueOf = (getSharedInstance + 13) % 128;
                return actualTypeArguments;
            }
            ((ParameterizedType) sharedInstance).getActualTypeArguments();
            throw null;
        }
        return new Type[]{Object.class, Object.class};
    }

    public static Type values(Type type, Class<?> cls, Type type2) {
        Type values2 = values(type, cls, type2, new HashMap());
        int i = valueOf + 47;
        getSharedInstance = i % 128;
        if (!(i % 2 == 0)) {
            return values2;
        }
        throw new ArithmeticException();
    }

    /* JADX WARN: Code restructure failed: missing block: B:90:0x0162, code lost:
    
        if (r0 == null) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0164, code lost:
    
        r15.put(r0, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0167, code lost:
    
        return r14;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r14v1, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v13, types: [java.lang.reflect.Type, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v15, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r14v2, types: [java.lang.reflect.WildcardType] */
    /* JADX WARN: Type inference failed for: r14v3, types: [java.lang.reflect.WildcardType] */
    /* JADX WARN: Type inference failed for: r14v5, types: [java.lang.reflect.WildcardType] */
    /* JADX WARN: Type inference failed for: r14v6, types: [java.lang.reflect.ParameterizedType] */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r14v8, types: [java.lang.reflect.GenericArrayType] */
    /* JADX WARN: Type inference failed for: r15v0, types: [java.util.Map<java.lang.reflect.TypeVariable<?>, java.lang.reflect.Type>, java.util.Map] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.reflect.Type values(java.lang.reflect.Type r12, java.lang.Class<?> r13, java.lang.reflect.Type r14, java.util.Map<java.lang.reflect.TypeVariable<?>, java.lang.reflect.Type> r15) {
        /*
            Method dump skipped, instructions count: 370
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.setForceDarkAllowed.values(java.lang.reflect.Type, java.lang.Class, java.lang.reflect.Type, java.util.Map):java.lang.reflect.Type");
    }

    private static Type values(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        int i = getSharedInstance + 65;
        valueOf = i % 128;
        if ((i % 2 != 0 ? '\b' : 'T') != '\b') {
            Class<?> valueOf2 = valueOf(typeVariable);
            if ((valueOf2 == null ? '\t' : 'G') != 'G') {
                return typeVariable;
            }
            Type values2 = values(type, cls, valueOf2);
            if (values2 instanceof ParameterizedType) {
                Type type2 = ((ParameterizedType) values2).getActualTypeArguments()[valueOf(valueOf2.getTypeParameters(), typeVariable)];
                int i2 = valueOf + 67;
                getSharedInstance = i2 % 128;
                if (i2 % 2 != 0) {
                    return type2;
                }
                throw new NullPointerException();
            }
            return typeVariable;
        }
        valueOf(typeVariable);
        throw new NullPointerException();
    }

    private static int valueOf(Object[] objArr, Object obj) {
        int length = objArr.length;
        valueOf = (getSharedInstance + 55) % 128;
        int i = 0;
        while (true) {
            if (!(i < length)) {
                throw new NoSuchElementException();
            }
            if ((!obj.equals(objArr[i])) != true) {
                int i2 = getSharedInstance + 27;
                int i3 = i2 % 128;
                valueOf = i3;
                if ((i2 % 2 == 0 ? '`' : (char) 0) != '`') {
                    throw new ArithmeticException();
                }
                int i4 = i3 + 47;
                getSharedInstance = i4 % 128;
                if (i4 % 2 != 0) {
                    return i;
                }
                throw new NullPointerException();
            }
            i++;
        }
    }

    private static Class<?> valueOf(TypeVariable<?> typeVariable) {
        int i = valueOf + 47;
        getSharedInstance = i % 128;
        if (!(i % 2 == 0)) {
            Object genericDeclaration = typeVariable.getGenericDeclaration();
            if ((genericDeclaration instanceof Class ? 'b' : '3') == '3') {
                getSharedInstance = (valueOf + 53) % 128;
                return null;
            }
            return (Class) genericDeclaration;
        }
        typeVariable.getGenericDeclaration();
        throw new ArithmeticException();
    }

    static void APIGuard(Type type) {
        boolean z;
        int i = getSharedInstance + 45;
        valueOf = i % 128;
        if ((i % 2 != 0 ? 'c' : '\b') != '\b') {
            throw null;
        }
        if (type instanceof Class) {
            if ((!((Class) type).isPrimitive() ? '1' : (char) 5) == 5) {
                z = false;
                valueOf = (getSharedInstance + 63) % 128;
                setBottom.getSharedInstance(z);
            }
        }
        z = true;
        setBottom.getSharedInstance(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class valueOf implements Serializable, ParameterizedType {
        private static int getSharedInstance = 0;
        private static final long serialVersionUID = 0;
        private static int values = 1;
        private final Type ownerType;
        private final Type rawType;
        private final Type[] typeArguments;

        public valueOf(Type type, Type type2, Type... typeArr) {
            if (type2 instanceof Class) {
                Class cls = (Class) type2;
                boolean z = true;
                boolean z2 = Modifier.isStatic(cls.getModifiers()) || cls.getEnclosingClass() == null;
                if (type == null && !z2) {
                    z = false;
                }
                setBottom.getSharedInstance(z);
            }
            this.ownerType = type == null ? null : setForceDarkAllowed.getSharedInstance(type);
            this.rawType = setForceDarkAllowed.getSharedInstance(type2);
            Type[] typeArr2 = (Type[]) typeArr.clone();
            this.typeArguments = typeArr2;
            int length = typeArr2.length;
            for (int i = 0; i < length; i++) {
                setBottom.getSharedInstance(this.typeArguments[i]);
                setForceDarkAllowed.APIGuard(this.typeArguments[i]);
                Type[] typeArr3 = this.typeArguments;
                typeArr3[i] = setForceDarkAllowed.getSharedInstance(typeArr3[i]);
            }
        }

        @Override // java.lang.reflect.ParameterizedType
        public final Type[] getActualTypeArguments() {
            int i = values + 37;
            getSharedInstance = i % 128;
            if (!(i % 2 == 0)) {
                Type[] typeArr = (Type[]) this.typeArguments.clone();
                throw null;
            }
            Type[] typeArr2 = (Type[]) this.typeArguments.clone();
            int i2 = values + 29;
            getSharedInstance = i2 % 128;
            if (!(i2 % 2 != 0)) {
                return typeArr2;
            }
            throw new ArithmeticException();
        }

        @Override // java.lang.reflect.ParameterizedType
        public final Type getRawType() {
            int i = getSharedInstance + 107;
            values = i % 128;
            if ((i % 2 == 0 ? '7' : '\\') == '\\') {
                return this.rawType;
            }
            throw null;
        }

        @Override // java.lang.reflect.ParameterizedType
        public final Type getOwnerType() {
            int i = (values + 51) % 128;
            getSharedInstance = i;
            Type type = this.ownerType;
            values = (i + 123) % 128;
            return type;
        }

        public final boolean equals(Object obj) {
            int i = values;
            getSharedInstance = (i + 109) % 128;
            if (obj instanceof ParameterizedType) {
                getSharedInstance = (i + 43) % 128;
                return !(setForceDarkAllowed.AGState(this, (ParameterizedType) obj) ^ true);
            }
            return false;
        }

        public final int hashCode() {
            int i = values + 99;
            getSharedInstance = i % 128;
            if (!(i % 2 == 0)) {
                return Arrays.hashCode(this.typeArguments) | this.rawType.hashCode() | setForceDarkAllowed.values((Object) this.ownerType);
            }
            return (Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode()) ^ setForceDarkAllowed.values((Object) this.ownerType);
        }

        public final String toString() {
            String values2;
            int i;
            int length = this.typeArguments.length;
            if (length == 0) {
                values2 = setForceDarkAllowed.values(this.rawType);
                i = values + 79;
            } else {
                StringBuilder sb = new StringBuilder((length + 1) * 30);
                sb.append(setForceDarkAllowed.values(this.rawType));
                sb.append(SimpleComparison.LESS_THAN_OPERATION);
                sb.append(setForceDarkAllowed.values(this.typeArguments[0]));
                int i2 = 1;
                while (true) {
                    if (!(i2 < length)) {
                        break;
                    }
                    sb.append(", ");
                    sb.append(setForceDarkAllowed.values(this.typeArguments[i2]));
                    i2++;
                }
                sb.append(SimpleComparison.GREATER_THAN_OPERATION);
                values2 = sb.toString();
                i = values + 87;
            }
            getSharedInstance = i % 128;
            return values2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class values implements Serializable, GenericArrayType {
        private static final long serialVersionUID = 0;
        private static int valueOf = 0;
        private static int values = 1;
        private final Type componentType;

        public values(Type type) {
            this.componentType = setForceDarkAllowed.getSharedInstance(type);
        }

        @Override // java.lang.reflect.GenericArrayType
        public final Type getGenericComponentType() {
            int i = (values + 105) % 128;
            valueOf = i;
            Type type = this.componentType;
            values = (i + 7) % 128;
            return type;
        }

        public final boolean equals(Object obj) {
            int i = values + 3;
            int i2 = i % 128;
            valueOf = i2;
            if (i % 2 != 0) {
                throw new NullPointerException();
            } else if (obj instanceof GenericArrayType) {
                values = (i2 + 21) % 128;
                return !(setForceDarkAllowed.AGState(this, (GenericArrayType) obj) ^ true);
            } else {
                return false;
            }
        }

        public final int hashCode() {
            int i = values + 93;
            valueOf = i % 128;
            if ((i % 2 != 0 ? ':' : 'c') != ':') {
                return this.componentType.hashCode();
            }
            this.componentType.hashCode();
            throw new ArithmeticException();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(setForceDarkAllowed.values(this.componentType));
            sb.append("[]");
            String obj = sb.toString();
            int i = valueOf + 67;
            values = i % 128;
            if ((i % 2 == 0 ? 'L' : 'W') != 'L') {
                return obj;
            }
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class APIGuard implements Serializable, WildcardType {
        private static int AGState = 1;
        private static int getSharedInstance;
        private static final long serialVersionUID = 0;
        private final Type lowerBound;
        private final Type upperBound;

        public APIGuard(Type[] typeArr, Type[] typeArr2) {
            setBottom.getSharedInstance(typeArr2.length <= 1);
            setBottom.getSharedInstance(typeArr.length == 1);
            if (typeArr2.length == 1) {
                setBottom.getSharedInstance(typeArr2[0]);
                setForceDarkAllowed.APIGuard(typeArr2[0]);
                setBottom.getSharedInstance(typeArr[0] == Object.class);
                this.lowerBound = setForceDarkAllowed.getSharedInstance(typeArr2[0]);
                this.upperBound = Object.class;
                return;
            }
            setBottom.getSharedInstance(typeArr[0]);
            setForceDarkAllowed.APIGuard(typeArr[0]);
            this.lowerBound = null;
            this.upperBound = setForceDarkAllowed.getSharedInstance(typeArr[0]);
        }

        @Override // java.lang.reflect.WildcardType
        public final Type[] getUpperBounds() {
            Type[] typeArr;
            int i = AGState + 9;
            int i2 = i % 128;
            getSharedInstance = i2;
            if (!(i % 2 != 0)) {
                typeArr = new Type[]{this.upperBound};
            } else {
                typeArr = new Type[0];
                typeArr[1] = this.upperBound;
            }
            int i3 = i2 + 65;
            AGState = i3 % 128;
            if (!(i3 % 2 == 0)) {
                return typeArr;
            }
            throw new ArithmeticException();
        }

        @Override // java.lang.reflect.WildcardType
        public final Type[] getLowerBounds() {
            AGState = (getSharedInstance + 5) % 128;
            Type type = this.lowerBound;
            if (!(type == null)) {
                return new Type[]{type};
            }
            Type[] typeArr = setForceDarkAllowed.values;
            getSharedInstance = (AGState + 51) % 128;
            return typeArr;
        }

        public final boolean equals(Object obj) {
            int i = AGState + 61;
            getSharedInstance = i % 128;
            if (i % 2 == 0) {
                if ((!(obj instanceof WildcardType)) == true || !setForceDarkAllowed.AGState(this, (WildcardType) obj)) {
                    getSharedInstance = (AGState + 37) % 128;
                    return false;
                }
                return true;
            }
            throw new NullPointerException();
        }

        public final int hashCode() {
            int hashCode;
            int i = getSharedInstance;
            int i2 = i + 29;
            AGState = i2 % 128;
            if (i2 % 2 == 0) {
                throw new ArithmeticException();
            }
            if ((this.lowerBound != null ? (char) 6 : (char) 4) != 6) {
                AGState = (i + 81) % 128;
                hashCode = 1;
            } else {
                hashCode = this.lowerBound.hashCode() + 31;
            }
            return hashCode ^ (this.upperBound.hashCode() + 31);
        }

        public final String toString() {
            int i = getSharedInstance + 65;
            int i2 = i % 128;
            AGState = i2;
            if (i % 2 == 0) {
                throw new ArithmeticException();
            } else if (this.lowerBound != null) {
                StringBuilder sb = new StringBuilder("? super ");
                sb.append(setForceDarkAllowed.values(this.lowerBound));
                return sb.toString();
            } else if (this.upperBound != Object.class) {
                StringBuilder sb2 = new StringBuilder("? extends ");
                sb2.append(setForceDarkAllowed.values(this.upperBound));
                return sb2.toString();
            } else {
                int i3 = i2 + 89;
                getSharedInstance = i3 % 128;
                if ((i3 % 2 != 0 ? '#' : '^') != '#') {
                    return "?";
                }
                throw new ArithmeticException();
            }
        }
    }
}
