package retrofit2;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.ResponseBody;
import okio.Buffer;

/* loaded from: classes6.dex */
public final class Utils {
    static final Type[] MyBillsEntityDataFactory = new Type[0];

    private Utils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RuntimeException BuiltInFictitiousFunctionClassFactory(Method method, String str, Object... objArr) {
        return PlaceComponentResult(method, null, str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RuntimeException PlaceComponentResult(Method method, @Nullable Throwable th, String str, Object... objArr) {
        String format = String.format(str, objArr);
        StringBuilder sb = new StringBuilder();
        sb.append(format);
        sb.append("\n    for method ");
        sb.append(method.getDeclaringClass().getSimpleName());
        sb.append(".");
        sb.append(method.getName());
        return new IllegalArgumentException(sb.toString(), th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RuntimeException PlaceComponentResult(Method method, Throwable th, int i, String str, Object... objArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" (parameter #");
        sb.append(i + 1);
        sb.append(")");
        return PlaceComponentResult(method, th, sb.toString(), objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RuntimeException BuiltInFictitiousFunctionClassFactory(Method method, int i, String str, Object... objArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" (parameter #");
        sb.append(i + 1);
        sb.append(")");
        return PlaceComponentResult(method, null, sb.toString(), objArr);
    }

    public static Class<?> BuiltInFictitiousFunctionClassFactory(Type type) {
        while (true) {
            Objects.requireNonNull(type, "type == null");
            if (type instanceof Class) {
                return (Class) type;
            }
            if (type instanceof ParameterizedType) {
                Type rawType = ((ParameterizedType) type).getRawType();
                if (!(rawType instanceof Class)) {
                    throw new IllegalArgumentException();
                }
                return (Class) rawType;
            } else if (type instanceof GenericArrayType) {
                return Array.newInstance(BuiltInFictitiousFunctionClassFactory(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
            } else {
                if (type instanceof TypeVariable) {
                    return Object.class;
                }
                if (type instanceof WildcardType) {
                    type = ((WildcardType) type).getUpperBounds()[0];
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Expected a Class, ParameterizedType, or GenericArrayType, but <");
                    sb.append(type);
                    sb.append("> is of type ");
                    sb.append(type.getClass().getName());
                    throw new IllegalArgumentException(sb.toString());
                }
            }
        }
    }

    static boolean KClassImpl$Data$declaredNonStaticMembers$2(Type type, Type type2) {
        while (type != type2) {
            if (type instanceof Class) {
                return type.equals(type2);
            }
            if (type instanceof ParameterizedType) {
                if (type2 instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) type;
                    ParameterizedType parameterizedType2 = (ParameterizedType) type2;
                    Type ownerType = parameterizedType.getOwnerType();
                    Type ownerType2 = parameterizedType2.getOwnerType();
                    return (ownerType == ownerType2 || (ownerType != null && ownerType.equals(ownerType2))) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
                }
                return false;
            } else if (type instanceof GenericArrayType) {
                if (!(type2 instanceof GenericArrayType)) {
                    return false;
                }
                type = ((GenericArrayType) type).getGenericComponentType();
                type2 = ((GenericArrayType) type2).getGenericComponentType();
            } else if (type instanceof WildcardType) {
                if (type2 instanceof WildcardType) {
                    WildcardType wildcardType = (WildcardType) type;
                    WildcardType wildcardType2 = (WildcardType) type2;
                    return Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds());
                }
                return false;
            } else if ((type instanceof TypeVariable) && (type2 instanceof TypeVariable)) {
                TypeVariable typeVariable = (TypeVariable) type;
                TypeVariable typeVariable2 = (TypeVariable) type2;
                return typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName());
            } else {
                return false;
            }
        }
        return true;
    }

    private static Type BuiltInFictitiousFunctionClassFactory(Type type, Class<?> cls, Class<?> cls2) {
        Class<?> superclass;
        Type genericSuperclass;
        while (cls2 != cls) {
            if (cls2.isInterface()) {
                Class<?>[] interfaces = cls.getInterfaces();
                int length = interfaces.length;
                for (int i = 0; i < length; i++) {
                    Class<?> cls3 = interfaces[i];
                    if (cls3 == cls2) {
                        return cls.getGenericInterfaces()[i];
                    }
                    if (cls2.isAssignableFrom(cls3)) {
                        genericSuperclass = cls.getGenericInterfaces()[i];
                        superclass = interfaces[i];
                        break;
                    }
                }
            }
            if (!cls.isInterface()) {
                while (cls != Object.class) {
                    superclass = cls.getSuperclass();
                    if (superclass == cls2) {
                        return cls.getGenericSuperclass();
                    }
                    if (cls2.isAssignableFrom(superclass)) {
                        genericSuperclass = cls.getGenericSuperclass();
                        Type type2 = genericSuperclass;
                        cls = superclass;
                        type = type2;
                    } else {
                        cls = superclass;
                    }
                }
            }
            return cls2;
        }
        return type;
    }

    static String getAuthRequestContext(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Type getAuthRequestContext(Type type, Class<?> cls, Class<?> cls2) {
        if (!cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException();
        }
        return getAuthRequestContext(type, cls, BuiltInFictitiousFunctionClassFactory(type, cls, cls2));
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r10 = r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0042 A[LOOP:0: B:2:0x0000->B:23:0x0042, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0041 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.reflect.Type getAuthRequestContext(java.lang.reflect.Type r8, java.lang.Class<?> r9, java.lang.reflect.Type r10) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit2.Utils.getAuthRequestContext(java.lang.reflect.Type, java.lang.Class, java.lang.reflect.Type):java.lang.reflect.Type");
    }

    static void PlaceComponentResult(Type type) {
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            throw new IllegalArgumentException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(Annotation[] annotationArr, Class<? extends Annotation> cls) {
        for (Annotation annotation : annotationArr) {
            if (cls.isInstance(annotation)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ResponseBody BuiltInFictitiousFunctionClassFactory(ResponseBody responseBody) throws IOException {
        Buffer buffer = new Buffer();
        responseBody.source().PlaceComponentResult(buffer);
        return ResponseBody.create(responseBody.contentType(), responseBody.contentLength(), buffer);
    }

    public static Type MyBillsEntityDataFactory(int i, ParameterizedType parameterizedType) {
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (i < 0 || i >= actualTypeArguments.length) {
            StringBuilder sb = new StringBuilder();
            sb.append("Index ");
            sb.append(i);
            sb.append(" not in range [0,");
            sb.append(actualTypeArguments.length);
            sb.append(") for ");
            sb.append(parameterizedType);
            throw new IllegalArgumentException(sb.toString());
        }
        Type type = actualTypeArguments[i];
        return type instanceof WildcardType ? ((WildcardType) type).getUpperBounds()[0] : type;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Type getAuthRequestContext(ParameterizedType parameterizedType) {
        Type type = parameterizedType.getActualTypeArguments()[0];
        return type instanceof WildcardType ? ((WildcardType) type).getLowerBounds()[0] : type;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean MyBillsEntityDataFactory(@Nullable Type type) {
        while (!(type instanceof Class)) {
            if (type instanceof ParameterizedType) {
                for (Type type2 : ((ParameterizedType) type).getActualTypeArguments()) {
                    if (MyBillsEntityDataFactory(type2)) {
                        return true;
                    }
                }
                return false;
            } else if (type instanceof GenericArrayType) {
                type = ((GenericArrayType) type).getGenericComponentType();
            } else if ((type instanceof TypeVariable) || (type instanceof WildcardType)) {
                return true;
            } else {
                String name = type == null ? "null" : type.getClass().getName();
                StringBuilder sb = new StringBuilder();
                sb.append("Expected a Class, ParameterizedType, or GenericArrayType, but <");
                sb.append(type);
                sb.append("> is of type ");
                sb.append(name);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class ParameterizedTypeImpl implements ParameterizedType {
        private final Type[] KClassImpl$Data$declaredNonStaticMembers$2;
        @Nullable
        private final Type MyBillsEntityDataFactory;
        private final Type getAuthRequestContext;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ParameterizedTypeImpl(@Nullable Type type, Type type2, Type... typeArr) {
            if (type2 instanceof Class) {
                if ((type == null) != (((Class) type2).getEnclosingClass() == null)) {
                    throw new IllegalArgumentException();
                }
            }
            for (Type type3 : typeArr) {
                Objects.requireNonNull(type3, "typeArgument == null");
                Utils.PlaceComponentResult(type3);
            }
            this.MyBillsEntityDataFactory = type;
            this.getAuthRequestContext = type2;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = (Type[]) typeArr.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public final Type[] getActualTypeArguments() {
            return (Type[]) this.KClassImpl$Data$declaredNonStaticMembers$2.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public final Type getRawType() {
            return this.getAuthRequestContext;
        }

        @Override // java.lang.reflect.ParameterizedType
        @Nullable
        public final Type getOwnerType() {
            return this.MyBillsEntityDataFactory;
        }

        public final boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && Utils.KClassImpl$Data$declaredNonStaticMembers$2(this, (ParameterizedType) obj);
        }

        public final int hashCode() {
            int hashCode = Arrays.hashCode(this.KClassImpl$Data$declaredNonStaticMembers$2);
            int hashCode2 = this.getAuthRequestContext.hashCode();
            Type type = this.MyBillsEntityDataFactory;
            return (hashCode ^ hashCode2) ^ (type != null ? type.hashCode() : 0);
        }

        public final String toString() {
            Type[] typeArr = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (typeArr.length == 0) {
                return Utils.getAuthRequestContext(this.getAuthRequestContext);
            }
            StringBuilder sb = new StringBuilder((typeArr.length + 1) * 30);
            sb.append(Utils.getAuthRequestContext(this.getAuthRequestContext));
            sb.append(SimpleComparison.LESS_THAN_OPERATION);
            sb.append(Utils.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2[0]));
            for (int i = 1; i < this.KClassImpl$Data$declaredNonStaticMembers$2.length; i++) {
                sb.append(", ");
                sb.append(Utils.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2[i]));
            }
            sb.append(SimpleComparison.GREATER_THAN_OPERATION);
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class GenericArrayTypeImpl implements GenericArrayType {
        private final Type KClassImpl$Data$declaredNonStaticMembers$2;

        GenericArrayTypeImpl(Type type) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = type;
        }

        @Override // java.lang.reflect.GenericArrayType
        public final Type getGenericComponentType() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        public final boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && Utils.KClassImpl$Data$declaredNonStaticMembers$2(this, (GenericArrayType) obj);
        }

        public final int hashCode() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Utils.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2));
            sb.append("[]");
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class WildcardTypeImpl implements WildcardType {
        @Nullable
        private final Type BuiltInFictitiousFunctionClassFactory;
        private final Type MyBillsEntityDataFactory;

        WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            if (typeArr2.length > 1) {
                throw new IllegalArgumentException();
            }
            int length = typeArr.length;
            if (typeArr2.length == 1) {
                Utils.PlaceComponentResult(typeArr2[0]);
                if (typeArr[0] != Object.class) {
                    throw new IllegalArgumentException();
                }
                this.BuiltInFictitiousFunctionClassFactory = typeArr2[0];
                this.MyBillsEntityDataFactory = Object.class;
                return;
            }
            Utils.PlaceComponentResult(typeArr[0]);
            this.BuiltInFictitiousFunctionClassFactory = null;
            this.MyBillsEntityDataFactory = typeArr[0];
        }

        @Override // java.lang.reflect.WildcardType
        public final Type[] getUpperBounds() {
            return new Type[]{this.MyBillsEntityDataFactory};
        }

        @Override // java.lang.reflect.WildcardType
        public final Type[] getLowerBounds() {
            Type type = this.BuiltInFictitiousFunctionClassFactory;
            return type != null ? new Type[]{type} : Utils.MyBillsEntityDataFactory;
        }

        public final boolean equals(Object obj) {
            return (obj instanceof WildcardType) && Utils.KClassImpl$Data$declaredNonStaticMembers$2(this, (WildcardType) obj);
        }

        public final int hashCode() {
            Type type = this.BuiltInFictitiousFunctionClassFactory;
            return (type != null ? type.hashCode() + 31 : 1) ^ (this.MyBillsEntityDataFactory.hashCode() + 31);
        }

        public final String toString() {
            if (this.BuiltInFictitiousFunctionClassFactory != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("? super ");
                sb.append(Utils.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory));
                return sb.toString();
            } else if (this.MyBillsEntityDataFactory == Object.class) {
                return "?";
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("? extends ");
                sb2.append(Utils.getAuthRequestContext(this.MyBillsEntityDataFactory));
                return sb2.toString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void getAuthRequestContext(Throwable th) {
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        }
        if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        }
        if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }
}
