package kotlin.jvm;

import java.lang.annotation.Annotation;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000&\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a!\u0010\u0004\u001a\u00020\u0003\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005\"'\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0006*\u00028\u00008G¢\u0006\u0006\u001a\u0004\b\b\u0010\t\"-\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00078G¢\u0006\f\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r\"&\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00028\u00008Ç\u0002¢\u0006\u0006\u001a\u0004\b\f\u0010\u0011\";\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u000b\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00078Ç\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0013\u0010\r\"+\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00078G¢\u0006\u0006\u001a\u0004\b\u0015\u0010\r\"-\u0010\u0018\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000b\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00078G¢\u0006\u0006\u001a\u0004\b\u0017\u0010\r\"+\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000b8G¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a"}, d2 = {"", "T", "", "", "isArrayOf", "([Ljava/lang/Object;)Z", "", "Lkotlin/reflect/KClass;", "getAnnotationClass", "(Ljava/lang/annotation/Annotation;)Lkotlin/reflect/KClass;", "annotationClass", "Ljava/lang/Class;", "getJavaClass", "(Lkotlin/reflect/KClass;)Ljava/lang/Class;", "getJavaClass$annotations", "(Lkotlin/reflect/KClass;)V", "java", "(Ljava/lang/Object;)Ljava/lang/Class;", "javaClass", "getRuntimeClassOfKClassInstance", "getRuntimeClassOfKClassInstance$annotations", "getJavaObjectType", "javaObjectType", "getJavaPrimitiveType", "javaPrimitiveType", "getKotlinClass", "(Ljava/lang/Class;)Lkotlin/reflect/KClass;", "kotlin"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class JvmClassMappingKt {
    public static /* synthetic */ void getJavaClass$annotations(KClass kClass) {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'java' property to get Java class corresponding to this Kotlin class or cast this instance to Any if you really want to get the runtime Java class of this implementation of KClass.", replaceWith = @ReplaceWith(expression = "(this as Any).javaClass", imports = {}))
    public static /* synthetic */ void getRuntimeClassOfKClassInstance$annotations(KClass kClass) {
    }

    @JvmName(name = "getJavaClass")
    public static final <T> Class<T> getJavaClass(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "");
        return (Class<T>) ((ClassBasedDeclarationContainer) kClass).getJClass();
    }

    @JvmName(name = "getJavaPrimitiveType")
    public static final <T> Class<T> getJavaPrimitiveType(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "");
        Class<T> cls = (Class<T>) ((ClassBasedDeclarationContainer) kClass).getJClass();
        if (cls.isPrimitive()) {
            return cls;
        }
        String name = cls.getName();
        if (name != null) {
            switch (name.hashCode()) {
                case -2056817302:
                    if (name.equals("java.lang.Integer")) {
                        return Integer.TYPE;
                    }
                    break;
                case -527879800:
                    if (name.equals("java.lang.Float")) {
                        return Float.TYPE;
                    }
                    break;
                case -515992664:
                    if (name.equals("java.lang.Short")) {
                        return Short.TYPE;
                    }
                    break;
                case 155276373:
                    if (name.equals("java.lang.Character")) {
                        return Character.TYPE;
                    }
                    break;
                case 344809556:
                    if (name.equals("java.lang.Boolean")) {
                        return Boolean.TYPE;
                    }
                    break;
                case 398507100:
                    if (name.equals("java.lang.Byte")) {
                        return Byte.TYPE;
                    }
                    break;
                case 398795216:
                    if (name.equals("java.lang.Long")) {
                        return Long.TYPE;
                    }
                    break;
                case 399092968:
                    if (name.equals("java.lang.Void")) {
                        return Void.TYPE;
                    }
                    break;
                case 761287205:
                    if (name.equals("java.lang.Double")) {
                        return Double.TYPE;
                    }
                    break;
            }
        }
        return null;
    }

    @JvmName(name = "getJavaObjectType")
    public static final <T> Class<T> getJavaObjectType(KClass<T> kClass) {
        String name;
        Intrinsics.checkNotNullParameter(kClass, "");
        Class<T> cls = (Class<T>) ((ClassBasedDeclarationContainer) kClass).getJClass();
        if (cls.isPrimitive() && (name = cls.getName()) != null) {
            switch (name.hashCode()) {
                case -1325958191:
                    return !name.equals("double") ? cls : Double.class;
                case 104431:
                    return !name.equals("int") ? cls : Integer.class;
                case 3039496:
                    return !name.equals("byte") ? cls : Byte.class;
                case 3052374:
                    return !name.equals("char") ? cls : Character.class;
                case 3327612:
                    return !name.equals("long") ? cls : Long.class;
                case 3625364:
                    return !name.equals("void") ? cls : Void.class;
                case 64711720:
                    return !name.equals("boolean") ? cls : Boolean.class;
                case 97526364:
                    return !name.equals("float") ? cls : Float.class;
                case 109413500:
                    return !name.equals("short") ? cls : Short.class;
                default:
                    return cls;
            }
        }
        return cls;
    }

    @JvmName(name = "getKotlinClass")
    public static final <T> KClass<T> getKotlinClass(Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "");
        return Reflection.getOrCreateKotlinClass(cls);
    }

    @JvmName(name = "getJavaClass")
    public static final <T> Class<T> getJavaClass(T t) {
        Intrinsics.checkNotNullParameter(t, "");
        Class<T> cls = (Class<T>) t.getClass();
        if (cls != null) {
            return cls;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaClass>>");
    }

    @JvmName(name = "getRuntimeClassOfKClassInstance")
    public static final <T> Class<KClass<T>> getRuntimeClassOfKClassInstance(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "");
        Class<KClass<T>> cls = (Class<KClass<T>>) kClass.getClass();
        if (cls != null) {
            return cls;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<kotlin.reflect.KClass<T of kotlin.jvm.JvmClassMappingKt.<get-javaClass>>>");
    }

    public static final /* synthetic */ boolean isArrayOf(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "");
        Intrinsics.reifiedOperationMarker(4, "T");
        return Object.class.isAssignableFrom(objArr.getClass().getComponentType());
    }

    @JvmName(name = "getAnnotationClass")
    public static final <T extends Annotation> KClass<? extends T> getAnnotationClass(T t) {
        Intrinsics.checkNotNullParameter(t, "");
        Class<? extends Annotation> annotationType = t.annotationType();
        Intrinsics.checkNotNullExpressionValue(annotationType, "");
        return getKotlinClass(annotationType);
    }
}
