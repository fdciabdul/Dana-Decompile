package kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 T2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001TB\u0013\u0012\n\u00102\u001a\u0006\u0012\u0002\b\u000301¢\u0006\u0004\bR\u0010SJ\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0007J\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R \u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00190\u00188WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001d\u001a\u00020\u00058WX\u0096\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010!\u001a\u00020\u00058WX\u0096\u0004¢\u0006\f\u0012\u0004\b\"\u0010 \u001a\u0004\b!\u0010\u001eR\u001a\u0010#\u001a\u00020\u00058WX\u0096\u0004¢\u0006\f\u0012\u0004\b$\u0010 \u001a\u0004\b#\u0010\u001eR\u001a\u0010%\u001a\u00020\u00058WX\u0096\u0004¢\u0006\f\u0012\u0004\b&\u0010 \u001a\u0004\b%\u0010\u001eR\u001a\u0010'\u001a\u00020\u00058WX\u0096\u0004¢\u0006\f\u0012\u0004\b(\u0010 \u001a\u0004\b'\u0010\u001eR\u001a\u0010)\u001a\u00020\u00058WX\u0096\u0004¢\u0006\f\u0012\u0004\b*\u0010 \u001a\u0004\b)\u0010\u001eR\u001a\u0010+\u001a\u00020\u00058WX\u0096\u0004¢\u0006\f\u0012\u0004\b,\u0010 \u001a\u0004\b+\u0010\u001eR\u001a\u0010-\u001a\u00020\u00058WX\u0096\u0004¢\u0006\f\u0012\u0004\b.\u0010 \u001a\u0004\b-\u0010\u001eR\u001a\u0010/\u001a\u00020\u00058WX\u0096\u0004¢\u0006\f\u0012\u0004\b0\u0010 \u001a\u0004\b/\u0010\u001eR\u001e\u00102\u001a\u0006\u0012\u0002\b\u0003018\u0017X\u0097\u0004¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001e\u00108\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003060\u00188WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\u001bR\u001e\u0010:\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u00188WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b9\u0010\u001bR\u0016\u0010=\u001a\u0004\u0018\u00010\u00028WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0016\u0010?\u001a\u0004\u0018\u00010\u00108WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u0010\u0012R(\u0010B\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00010\u00138WX\u0096\u0004¢\u0006\f\u0012\u0004\bA\u0010 \u001a\u0004\b@\u0010\u0016R\u0016\u0010D\u001a\u0004\u0018\u00010\u00108WX\u0096\u0004¢\u0006\u0006\u001a\u0004\bC\u0010\u0012R \u0010H\u001a\b\u0012\u0004\u0012\u00020E0\u00138WX\u0096\u0004¢\u0006\f\u0012\u0004\bG\u0010 \u001a\u0004\bF\u0010\u0016R \u0010L\u001a\b\u0012\u0004\u0012\u00020I0\u00138WX\u0096\u0004¢\u0006\f\u0012\u0004\bK\u0010 \u001a\u0004\bJ\u0010\u0016R\u001c\u0010Q\u001a\u0004\u0018\u00010M8WX\u0096\u0004¢\u0006\f\u0012\u0004\bP\u0010 \u001a\u0004\bN\u0010O"}, d2 = {"Lkotlin/jvm/internal/ClassReference;", "Lkotlin/reflect/KClass;", "", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "error", "()Ljava/lang/Void;", "", "hashCode", "()I", "value", "isInstance", "", "toString", "()Ljava/lang/String;", "", "", "getAnnotations", "()Ljava/util/List;", "annotations", "", "Lkotlin/reflect/KFunction;", "getConstructors", "()Ljava/util/Collection;", "constructors", "isAbstract", "()Z", "isAbstract$annotations", "()V", "isCompanion", "isCompanion$annotations", "isData", "isData$annotations", "isFinal", "isFinal$annotations", "isFun", "isFun$annotations", "isInner", "isInner$annotations", "isOpen", "isOpen$annotations", "isSealed", "isSealed$annotations", "isValue", "isValue$annotations", "Ljava/lang/Class;", "jClass", "Ljava/lang/Class;", "getJClass", "()Ljava/lang/Class;", "Lkotlin/reflect/KCallable;", "getMembers", "members", "getNestedClasses", "nestedClasses", "getObjectInstance", "()Ljava/lang/Object;", "objectInstance", "getQualifiedName", "qualifiedName", "getSealedSubclasses", "getSealedSubclasses$annotations", "sealedSubclasses", "getSimpleName", "simpleName", "Lkotlin/reflect/KType;", "getSupertypes", "getSupertypes$annotations", "supertypes", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "getTypeParameters$annotations", "typeParameters", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "getVisibility$annotations", "visibility", "<init>", "(Ljava/lang/Class;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ClassReference implements KClass<Object>, ClassBasedDeclarationContainer {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<Class<? extends Function<?>>, Integer> FUNCTION_CLASSES;
    private static final HashMap<String, String> classFqNames;
    private static final HashMap<String, String> primitiveFqNames;
    private static final HashMap<String, String> primitiveWrapperFqNames;
    private static final Map<String, String> simpleNames;
    private final Class<?> jClass;

    public static /* synthetic */ void getSealedSubclasses$annotations() {
    }

    public static /* synthetic */ void getSupertypes$annotations() {
    }

    public static /* synthetic */ void getTypeParameters$annotations() {
    }

    public static /* synthetic */ void getVisibility$annotations() {
    }

    public static /* synthetic */ void isAbstract$annotations() {
    }

    public static /* synthetic */ void isCompanion$annotations() {
    }

    public static /* synthetic */ void isData$annotations() {
    }

    public static /* synthetic */ void isFinal$annotations() {
    }

    public static /* synthetic */ void isFun$annotations() {
    }

    public static /* synthetic */ void isInner$annotations() {
    }

    public static /* synthetic */ void isOpen$annotations() {
    }

    public static /* synthetic */ void isSealed$annotations() {
    }

    public static /* synthetic */ void isValue$annotations() {
    }

    public ClassReference(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "");
        this.jClass = cls;
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    @JvmName(name = "getJClass")
    public final Class<?> getJClass() {
        return this.jClass;
    }

    @Override // kotlin.reflect.KClass
    @JvmName(name = "getSimpleName")
    public final String getSimpleName() {
        return INSTANCE.getClassSimpleName(getJClass());
    }

    @Override // kotlin.reflect.KClass
    @JvmName(name = "getQualifiedName")
    public final String getQualifiedName() {
        return INSTANCE.getClassQualifiedName(getJClass());
    }

    @Override // kotlin.reflect.KClass, kotlin.reflect.KDeclarationContainer
    @JvmName(name = "getMembers")
    public final Collection<KCallable<?>> getMembers() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    @JvmName(name = "getConstructors")
    public final Collection<KFunction<Object>> getConstructors() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    @JvmName(name = "getNestedClasses")
    public final Collection<KClass<?>> getNestedClasses() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KAnnotatedElement
    @JvmName(name = "getAnnotations")
    public final List<Annotation> getAnnotations() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    @JvmName(name = "getObjectInstance")
    public final Object getObjectInstance() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public final boolean isInstance(Object value) {
        return INSTANCE.isInstance(value, getJClass());
    }

    @Override // kotlin.reflect.KClass
    @JvmName(name = "getTypeParameters")
    public final List<KTypeParameter> getTypeParameters() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    @JvmName(name = "getSupertypes")
    public final List<KType> getSupertypes() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    @JvmName(name = "getSealedSubclasses")
    public final List<KClass<? extends Object>> getSealedSubclasses() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    @JvmName(name = "getVisibility")
    public final KVisibility getVisibility() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    @JvmName(name = "isFinal")
    public final boolean isFinal() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    @JvmName(name = "isOpen")
    public final boolean isOpen() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    @JvmName(name = "isAbstract")
    public final boolean isAbstract() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    @JvmName(name = "isSealed")
    public final boolean isSealed() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    @JvmName(name = "isData")
    public final boolean isData() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    @JvmName(name = "isInner")
    public final boolean isInner() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    @JvmName(name = "isCompanion")
    public final boolean isCompanion() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    @JvmName(name = "isFun")
    public final boolean isFun() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    @JvmName(name = "isValue")
    public final boolean isValue() {
        error();
        throw new KotlinNothingValueException();
    }

    private final Void error() {
        throw new KotlinReflectionNotSupportedError();
    }

    @Override // kotlin.reflect.KClass
    public final boolean equals(Object other) {
        return (other instanceof ClassReference) && Intrinsics.areEqual(JvmClassMappingKt.getJavaObjectType(this), JvmClassMappingKt.getJavaObjectType((KClass) other));
    }

    @Override // kotlin.reflect.KClass
    public final int hashCode() {
        return JvmClassMappingKt.getJavaObjectType(this).hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getJClass().toString());
        sb.append(" (Kotlin reflection is not available)");
        return sb.toString();
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0007\u0010\u0006J#\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\n\u0010\u000bR,\u0010\u000f\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\r0\u0002\u0012\u0004\u0012\u00020\u000e0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R0\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0011j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R0\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0011j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R0\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0011j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0010"}, d2 = {"Lkotlin/jvm/internal/ClassReference$Companion;", "", "Ljava/lang/Class;", "jClass", "", "getClassQualifiedName", "(Ljava/lang/Class;)Ljava/lang/String;", "getClassSimpleName", "value", "", "isInstance", "(Ljava/lang/Object;Ljava/lang/Class;)Z", "", "Lkotlin/Function;", "", "FUNCTION_CLASSES", "Ljava/util/Map;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "classFqNames", "Ljava/util/HashMap;", "primitiveFqNames", "primitiveWrapperFqNames", "simpleNames", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getClassSimpleName(Class<?> jClass) {
            String str;
            Intrinsics.checkNotNullParameter(jClass, "");
            String str2 = null;
            if (!jClass.isAnonymousClass()) {
                if (jClass.isLocalClass()) {
                    String simpleName = jClass.getSimpleName();
                    Method enclosingMethod = jClass.getEnclosingMethod();
                    if (enclosingMethod != null) {
                        Intrinsics.checkNotNullExpressionValue(simpleName, "");
                        StringBuilder sb = new StringBuilder();
                        sb.append(enclosingMethod.getName());
                        sb.append(Typography.dollar);
                        String substringAfter$default = StringsKt.substringAfter$default(simpleName, sb.toString(), (String) null, 2, (Object) null);
                        if (substringAfter$default != null) {
                            return substringAfter$default;
                        }
                    }
                    Constructor<?> enclosingConstructor = jClass.getEnclosingConstructor();
                    if (enclosingConstructor == null) {
                        Intrinsics.checkNotNullExpressionValue(simpleName, "");
                        return StringsKt.substringAfter$default(simpleName, (char) Typography.dollar, (String) null, 2, (Object) null);
                    }
                    Intrinsics.checkNotNullExpressionValue(simpleName, "");
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(enclosingConstructor.getName());
                    sb2.append(Typography.dollar);
                    return StringsKt.substringAfter$default(simpleName, sb2.toString(), (String) null, 2, (Object) null);
                } else if (!jClass.isArray()) {
                    String str3 = (String) ClassReference.simpleNames.get(jClass.getName());
                    return str3 == null ? jClass.getSimpleName() : str3;
                } else {
                    Class<?> componentType = jClass.getComponentType();
                    if (componentType.isPrimitive() && (str = (String) ClassReference.simpleNames.get(componentType.getName())) != null) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(str);
                        sb3.append("Array");
                        str2 = sb3.toString();
                    }
                    if (str2 == null) {
                        return "Array";
                    }
                }
            }
            return str2;
        }

        public final String getClassQualifiedName(Class<?> jClass) {
            String str;
            Intrinsics.checkNotNullParameter(jClass, "");
            String str2 = null;
            if (jClass.isAnonymousClass() || jClass.isLocalClass()) {
                return null;
            }
            if (!jClass.isArray()) {
                String str3 = (String) ClassReference.classFqNames.get(jClass.getName());
                return str3 == null ? jClass.getCanonicalName() : str3;
            }
            Class<?> componentType = jClass.getComponentType();
            if (componentType.isPrimitive() && (str = (String) ClassReference.classFqNames.get(componentType.getName())) != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("Array");
                str2 = sb.toString();
            }
            return str2 == null ? "kotlin.Array" : str2;
        }

        public final boolean isInstance(Object value, Class<?> jClass) {
            Intrinsics.checkNotNullParameter(jClass, "");
            Integer num = (Integer) ClassReference.FUNCTION_CLASSES.get(jClass);
            if (num != null) {
                return TypeIntrinsics.isFunctionOfArity(value, num.intValue());
            }
            if (jClass.isPrimitive()) {
                jClass = JvmClassMappingKt.getJavaObjectType(JvmClassMappingKt.getKotlinClass(jClass));
            }
            return jClass.isInstance(value);
        }
    }

    static {
        int i = 0;
        List listOf = CollectionsKt.listOf((Object[]) new Class[]{Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class});
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listOf, 10));
        for (Object obj : listOf) {
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(TuplesKt.to((Class) obj, Integer.valueOf(i)));
            i++;
        }
        FUNCTION_CLASSES = MapsKt.toMap(arrayList);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("boolean", "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put("int", "kotlin.Int");
        hashMap.put("float", "kotlin.Float");
        hashMap.put("long", "kotlin.Long");
        hashMap.put("double", "kotlin.Double");
        primitiveFqNames = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        primitiveWrapperFqNames = hashMap2;
        HashMap<String, String> hashMap3 = new HashMap<>();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(hashMap);
        hashMap3.putAll(hashMap2);
        Collection<String> values = hashMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "");
        for (String str : values) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            Intrinsics.checkNotNullExpressionValue(str, "");
            sb.append(StringsKt.substringAfterLast$default(str, '.', (String) null, 2, (Object) null));
            sb.append("CompanionObject");
            String obj2 = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(".Companion");
            Pair pair = TuplesKt.to(obj2, sb2.toString());
            hashMap3.put(pair.getFirst(), pair.getSecond());
        }
        HashMap<String, String> hashMap4 = hashMap3;
        for (Map.Entry<Class<? extends Function<?>>, Integer> entry : FUNCTION_CLASSES.entrySet()) {
            Class<? extends Function<?>> key = entry.getKey();
            int intValue = entry.getValue().intValue();
            String name = key.getName();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("kotlin.Function");
            sb3.append(intValue);
            hashMap3.put(name, sb3.toString());
        }
        classFqNames = hashMap3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(hashMap4.size()));
        Iterator<T> it = hashMap4.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it.next();
            linkedHashMap.put(entry2.getKey(), StringsKt.substringAfterLast$default((String) entry2.getValue(), '.', (String) null, 2, (Object) null));
        }
        simpleNames = linkedHashMap;
    }
}
