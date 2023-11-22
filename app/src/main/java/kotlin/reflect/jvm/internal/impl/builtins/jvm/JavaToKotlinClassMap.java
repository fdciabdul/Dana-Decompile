package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.FqNamesUtilKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.name.StandardClassIds;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.text.StringsKt;

/* loaded from: classes.dex */
public final class JavaToKotlinClassMap {
    private static final ClassId CLASS_CLASS_ID;
    private static final ClassId FUNCTION_N_CLASS_ID;
    private static final FqName FUNCTION_N_FQ_NAME;
    public static final JavaToKotlinClassMap INSTANCE;
    private static final ClassId K_CLASS_CLASS_ID;
    private static final ClassId K_FUNCTION_CLASS_ID;
    private static final String NUMBERED_FUNCTION_PREFIX;
    private static final String NUMBERED_K_FUNCTION_PREFIX;
    private static final String NUMBERED_K_SUSPEND_FUNCTION_PREFIX;
    private static final String NUMBERED_SUSPEND_FUNCTION_PREFIX;
    private static final HashMap<FqNameUnsafe, ClassId> javaToKotlin;
    private static final HashMap<FqNameUnsafe, ClassId> kotlinToJava;
    private static final List<PlatformMutabilityMapping> mutabilityMappings;
    private static final HashMap<FqNameUnsafe, FqName> mutableToReadOnly;
    private static final HashMap<ClassId, ClassId> mutableToReadOnlyClassId;
    private static final HashMap<FqNameUnsafe, FqName> readOnlyToMutable;
    private static final HashMap<ClassId, ClassId> readOnlyToMutableClassId;

    private JavaToKotlinClassMap() {
    }

    static {
        JavaToKotlinClassMap javaToKotlinClassMap = new JavaToKotlinClassMap();
        INSTANCE = javaToKotlinClassMap;
        StringBuilder sb = new StringBuilder();
        sb.append(FunctionClassKind.Function.getPackageFqName().toString());
        sb.append('.');
        sb.append(FunctionClassKind.Function.getClassNamePrefix());
        NUMBERED_FUNCTION_PREFIX = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(FunctionClassKind.KFunction.getPackageFqName().toString());
        sb2.append('.');
        sb2.append(FunctionClassKind.KFunction.getClassNamePrefix());
        NUMBERED_K_FUNCTION_PREFIX = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(FunctionClassKind.SuspendFunction.getPackageFqName().toString());
        sb3.append('.');
        sb3.append(FunctionClassKind.SuspendFunction.getClassNamePrefix());
        NUMBERED_SUSPEND_FUNCTION_PREFIX = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        sb4.append(FunctionClassKind.KSuspendFunction.getPackageFqName().toString());
        sb4.append('.');
        sb4.append(FunctionClassKind.KSuspendFunction.getClassNamePrefix());
        NUMBERED_K_SUSPEND_FUNCTION_PREFIX = sb4.toString();
        ClassId classId = ClassId.topLevel(new FqName("kotlin.jvm.functions.FunctionN"));
        Intrinsics.checkNotNullExpressionValue(classId, "");
        FUNCTION_N_CLASS_ID = classId;
        FqName asSingleFqName = classId.asSingleFqName();
        Intrinsics.checkNotNullExpressionValue(asSingleFqName, "");
        FUNCTION_N_FQ_NAME = asSingleFqName;
        K_FUNCTION_CLASS_ID = StandardClassIds.INSTANCE.getKFunction();
        K_CLASS_CLASS_ID = StandardClassIds.INSTANCE.getKClass();
        CLASS_CLASS_ID = javaToKotlinClassMap.classId(Class.class);
        javaToKotlin = new HashMap<>();
        kotlinToJava = new HashMap<>();
        mutableToReadOnly = new HashMap<>();
        readOnlyToMutable = new HashMap<>();
        mutableToReadOnlyClassId = new HashMap<>();
        readOnlyToMutableClassId = new HashMap<>();
        ClassId classId2 = ClassId.topLevel(StandardNames.FqNames.iterable);
        Intrinsics.checkNotNullExpressionValue(classId2, "");
        FqName fqName = StandardNames.FqNames.mutableIterable;
        FqName packageFqName = classId2.getPackageFqName();
        FqName packageFqName2 = classId2.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(packageFqName2, "");
        ClassId classId3 = new ClassId(packageFqName, FqNamesUtilKt.tail(fqName, packageFqName2), false);
        ClassId classId4 = ClassId.topLevel(StandardNames.FqNames.iterator);
        Intrinsics.checkNotNullExpressionValue(classId4, "");
        FqName fqName2 = StandardNames.FqNames.mutableIterator;
        FqName packageFqName3 = classId4.getPackageFqName();
        FqName packageFqName4 = classId4.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(packageFqName4, "");
        ClassId classId5 = new ClassId(packageFqName3, FqNamesUtilKt.tail(fqName2, packageFqName4), false);
        ClassId classId6 = ClassId.topLevel(StandardNames.FqNames.collection);
        Intrinsics.checkNotNullExpressionValue(classId6, "");
        FqName fqName3 = StandardNames.FqNames.mutableCollection;
        FqName packageFqName5 = classId6.getPackageFqName();
        FqName packageFqName6 = classId6.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(packageFqName6, "");
        ClassId classId7 = new ClassId(packageFqName5, FqNamesUtilKt.tail(fqName3, packageFqName6), false);
        ClassId classId8 = ClassId.topLevel(StandardNames.FqNames.list);
        Intrinsics.checkNotNullExpressionValue(classId8, "");
        FqName fqName4 = StandardNames.FqNames.mutableList;
        FqName packageFqName7 = classId8.getPackageFqName();
        FqName packageFqName8 = classId8.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(packageFqName8, "");
        ClassId classId9 = new ClassId(packageFqName7, FqNamesUtilKt.tail(fqName4, packageFqName8), false);
        ClassId classId10 = ClassId.topLevel(StandardNames.FqNames.set);
        Intrinsics.checkNotNullExpressionValue(classId10, "");
        FqName fqName5 = StandardNames.FqNames.mutableSet;
        FqName packageFqName9 = classId10.getPackageFqName();
        FqName packageFqName10 = classId10.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(packageFqName10, "");
        ClassId classId11 = new ClassId(packageFqName9, FqNamesUtilKt.tail(fqName5, packageFqName10), false);
        ClassId classId12 = ClassId.topLevel(StandardNames.FqNames.listIterator);
        Intrinsics.checkNotNullExpressionValue(classId12, "");
        FqName fqName6 = StandardNames.FqNames.mutableListIterator;
        FqName packageFqName11 = classId12.getPackageFqName();
        FqName packageFqName12 = classId12.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(packageFqName12, "");
        ClassId classId13 = new ClassId(packageFqName11, FqNamesUtilKt.tail(fqName6, packageFqName12), false);
        ClassId classId14 = ClassId.topLevel(StandardNames.FqNames.map);
        Intrinsics.checkNotNullExpressionValue(classId14, "");
        FqName fqName7 = StandardNames.FqNames.mutableMap;
        FqName packageFqName13 = classId14.getPackageFqName();
        FqName packageFqName14 = classId14.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(packageFqName14, "");
        ClassId classId15 = new ClassId(packageFqName13, FqNamesUtilKt.tail(fqName7, packageFqName14), false);
        ClassId createNestedClassId = ClassId.topLevel(StandardNames.FqNames.map).createNestedClassId(StandardNames.FqNames.mapEntry.shortName());
        Intrinsics.checkNotNullExpressionValue(createNestedClassId, "");
        FqName fqName8 = StandardNames.FqNames.mutableMapEntry;
        FqName packageFqName15 = createNestedClassId.getPackageFqName();
        FqName packageFqName16 = createNestedClassId.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(packageFqName16, "");
        List<PlatformMutabilityMapping> listOf = CollectionsKt.listOf((Object[]) new PlatformMutabilityMapping[]{new PlatformMutabilityMapping(javaToKotlinClassMap.classId(Iterable.class), classId2, classId3), new PlatformMutabilityMapping(javaToKotlinClassMap.classId(Iterator.class), classId4, classId5), new PlatformMutabilityMapping(javaToKotlinClassMap.classId(Collection.class), classId6, classId7), new PlatformMutabilityMapping(javaToKotlinClassMap.classId(List.class), classId8, classId9), new PlatformMutabilityMapping(javaToKotlinClassMap.classId(Set.class), classId10, classId11), new PlatformMutabilityMapping(javaToKotlinClassMap.classId(ListIterator.class), classId12, classId13), new PlatformMutabilityMapping(javaToKotlinClassMap.classId(Map.class), classId14, classId15), new PlatformMutabilityMapping(javaToKotlinClassMap.classId(Map.Entry.class), createNestedClassId, new ClassId(packageFqName15, FqNamesUtilKt.tail(fqName8, packageFqName16), false))});
        mutabilityMappings = listOf;
        javaToKotlinClassMap.addTopLevel(Object.class, StandardNames.FqNames.any);
        javaToKotlinClassMap.addTopLevel(String.class, StandardNames.FqNames.string);
        javaToKotlinClassMap.addTopLevel(CharSequence.class, StandardNames.FqNames.charSequence);
        javaToKotlinClassMap.addTopLevel(Throwable.class, StandardNames.FqNames.throwable);
        javaToKotlinClassMap.addTopLevel(Cloneable.class, StandardNames.FqNames.cloneable);
        javaToKotlinClassMap.addTopLevel(Number.class, StandardNames.FqNames.number);
        javaToKotlinClassMap.addTopLevel(Comparable.class, StandardNames.FqNames.comparable);
        javaToKotlinClassMap.addTopLevel(Enum.class, StandardNames.FqNames._enum);
        javaToKotlinClassMap.addTopLevel(Annotation.class, StandardNames.FqNames.annotation);
        Iterator<PlatformMutabilityMapping> it = listOf.iterator();
        while (it.hasNext()) {
            INSTANCE.addMapping(it.next());
        }
        for (JvmPrimitiveType jvmPrimitiveType : JvmPrimitiveType.values()) {
            JavaToKotlinClassMap javaToKotlinClassMap2 = INSTANCE;
            ClassId classId16 = ClassId.topLevel(jvmPrimitiveType.getWrapperFqName());
            Intrinsics.checkNotNullExpressionValue(classId16, "");
            PrimitiveType primitiveType = jvmPrimitiveType.getPrimitiveType();
            Intrinsics.checkNotNullExpressionValue(primitiveType, "");
            ClassId classId17 = ClassId.topLevel(StandardNames.getPrimitiveFqName(primitiveType));
            Intrinsics.checkNotNullExpressionValue(classId17, "");
            javaToKotlinClassMap2.add(classId16, classId17);
        }
        for (ClassId classId18 : CompanionObjectMapping.INSTANCE.allClassesWithIntrinsicCompanions()) {
            JavaToKotlinClassMap javaToKotlinClassMap3 = INSTANCE;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("kotlin.jvm.internal.");
            sb5.append(classId18.getShortClassName().asString());
            sb5.append("CompanionObject");
            ClassId classId19 = ClassId.topLevel(new FqName(sb5.toString()));
            Intrinsics.checkNotNullExpressionValue(classId19, "");
            ClassId createNestedClassId2 = classId18.createNestedClassId(SpecialNames.DEFAULT_NAME_FOR_COMPANION_OBJECT);
            Intrinsics.checkNotNullExpressionValue(createNestedClassId2, "");
            javaToKotlinClassMap3.add(classId19, createNestedClassId2);
        }
        for (int i = 0; i < 23; i++) {
            JavaToKotlinClassMap javaToKotlinClassMap4 = INSTANCE;
            StringBuilder sb6 = new StringBuilder();
            sb6.append("kotlin.jvm.functions.Function");
            sb6.append(i);
            ClassId classId20 = ClassId.topLevel(new FqName(sb6.toString()));
            Intrinsics.checkNotNullExpressionValue(classId20, "");
            javaToKotlinClassMap4.add(classId20, StandardNames.getFunctionClassId(i));
            StringBuilder sb7 = new StringBuilder();
            sb7.append(NUMBERED_K_FUNCTION_PREFIX);
            sb7.append(i);
            javaToKotlinClassMap4.addKotlinToJava(new FqName(sb7.toString()), K_FUNCTION_CLASS_ID);
        }
        for (int i2 = 0; i2 < 22; i2++) {
            FunctionClassKind functionClassKind = FunctionClassKind.KSuspendFunction;
            StringBuilder sb8 = new StringBuilder();
            sb8.append(functionClassKind.getPackageFqName().toString());
            sb8.append('.');
            sb8.append(functionClassKind.getClassNamePrefix());
            String obj = sb8.toString();
            JavaToKotlinClassMap javaToKotlinClassMap5 = INSTANCE;
            StringBuilder sb9 = new StringBuilder();
            sb9.append(obj);
            sb9.append(i2);
            javaToKotlinClassMap5.addKotlinToJava(new FqName(sb9.toString()), K_FUNCTION_CLASS_ID);
        }
        JavaToKotlinClassMap javaToKotlinClassMap6 = INSTANCE;
        FqName safe = StandardNames.FqNames.nothing.toSafe();
        Intrinsics.checkNotNullExpressionValue(safe, "");
        javaToKotlinClassMap6.addKotlinToJava(safe, javaToKotlinClassMap6.classId(Void.class));
    }

    public final FqName getFUNCTION_N_FQ_NAME() {
        return FUNCTION_N_FQ_NAME;
    }

    /* loaded from: classes.dex */
    public static final class PlatformMutabilityMapping {
        private final ClassId javaClass;
        private final ClassId kotlinMutable;
        private final ClassId kotlinReadOnly;

        public final ClassId component1() {
            return this.javaClass;
        }

        public final ClassId component2() {
            return this.kotlinReadOnly;
        }

        public final ClassId component3() {
            return this.kotlinMutable;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PlatformMutabilityMapping) {
                PlatformMutabilityMapping platformMutabilityMapping = (PlatformMutabilityMapping) obj;
                return Intrinsics.areEqual(this.javaClass, platformMutabilityMapping.javaClass) && Intrinsics.areEqual(this.kotlinReadOnly, platformMutabilityMapping.kotlinReadOnly) && Intrinsics.areEqual(this.kotlinMutable, platformMutabilityMapping.kotlinMutable);
            }
            return false;
        }

        public final int hashCode() {
            return (((this.javaClass.hashCode() * 31) + this.kotlinReadOnly.hashCode()) * 31) + this.kotlinMutable.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PlatformMutabilityMapping(javaClass=");
            sb.append(this.javaClass);
            sb.append(", kotlinReadOnly=");
            sb.append(this.kotlinReadOnly);
            sb.append(", kotlinMutable=");
            sb.append(this.kotlinMutable);
            sb.append(')');
            return sb.toString();
        }

        public PlatformMutabilityMapping(ClassId classId, ClassId classId2, ClassId classId3) {
            Intrinsics.checkNotNullParameter(classId, "");
            Intrinsics.checkNotNullParameter(classId2, "");
            Intrinsics.checkNotNullParameter(classId3, "");
            this.javaClass = classId;
            this.kotlinReadOnly = classId2;
            this.kotlinMutable = classId3;
        }

        public final ClassId getJavaClass() {
            return this.javaClass;
        }
    }

    public final List<PlatformMutabilityMapping> getMutabilityMappings() {
        return mutabilityMappings;
    }

    public final ClassId mapJavaToKotlin(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "");
        return javaToKotlin.get(fqName.toUnsafe());
    }

    public final ClassId mapKotlinToJava(FqNameUnsafe fqNameUnsafe) {
        Intrinsics.checkNotNullParameter(fqNameUnsafe, "");
        if (!isKotlinFunctionWithBigArity(fqNameUnsafe, NUMBERED_FUNCTION_PREFIX) && !isKotlinFunctionWithBigArity(fqNameUnsafe, NUMBERED_SUSPEND_FUNCTION_PREFIX)) {
            if (!isKotlinFunctionWithBigArity(fqNameUnsafe, NUMBERED_K_FUNCTION_PREFIX) && !isKotlinFunctionWithBigArity(fqNameUnsafe, NUMBERED_K_SUSPEND_FUNCTION_PREFIX)) {
                return kotlinToJava.get(fqNameUnsafe);
            }
            return K_FUNCTION_CLASS_ID;
        }
        return FUNCTION_N_CLASS_ID;
    }

    private final boolean isKotlinFunctionWithBigArity(FqNameUnsafe fqNameUnsafe, String str) {
        Integer intOrNull;
        String asString = fqNameUnsafe.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "");
        String substringAfter = StringsKt.substringAfter(asString, str, "");
        String str2 = substringAfter;
        return (str2.length() > 0) && !StringsKt.startsWith$default((CharSequence) str2, '0', false, 2, (Object) null) && (intOrNull = StringsKt.toIntOrNull(substringAfter)) != null && intOrNull.intValue() >= 23;
    }

    private final void addMapping(PlatformMutabilityMapping platformMutabilityMapping) {
        ClassId component1 = platformMutabilityMapping.component1();
        ClassId component2 = platformMutabilityMapping.component2();
        ClassId component3 = platformMutabilityMapping.component3();
        add(component1, component2);
        FqName asSingleFqName = component3.asSingleFqName();
        Intrinsics.checkNotNullExpressionValue(asSingleFqName, "");
        addKotlinToJava(asSingleFqName, component1);
        mutableToReadOnlyClassId.put(component3, component2);
        readOnlyToMutableClassId.put(component2, component3);
        FqName asSingleFqName2 = component2.asSingleFqName();
        Intrinsics.checkNotNullExpressionValue(asSingleFqName2, "");
        FqName asSingleFqName3 = component3.asSingleFqName();
        Intrinsics.checkNotNullExpressionValue(asSingleFqName3, "");
        HashMap<FqNameUnsafe, FqName> hashMap = mutableToReadOnly;
        FqNameUnsafe unsafe = component3.asSingleFqName().toUnsafe();
        Intrinsics.checkNotNullExpressionValue(unsafe, "");
        hashMap.put(unsafe, asSingleFqName2);
        HashMap<FqNameUnsafe, FqName> hashMap2 = readOnlyToMutable;
        FqNameUnsafe unsafe2 = asSingleFqName2.toUnsafe();
        Intrinsics.checkNotNullExpressionValue(unsafe2, "");
        hashMap2.put(unsafe2, asSingleFqName3);
    }

    private final void add(ClassId classId, ClassId classId2) {
        addJavaToKotlin(classId, classId2);
        FqName asSingleFqName = classId2.asSingleFqName();
        Intrinsics.checkNotNullExpressionValue(asSingleFqName, "");
        addKotlinToJava(asSingleFqName, classId);
    }

    private final void addTopLevel(Class<?> cls, FqNameUnsafe fqNameUnsafe) {
        FqName safe = fqNameUnsafe.toSafe();
        Intrinsics.checkNotNullExpressionValue(safe, "");
        addTopLevel(cls, safe);
    }

    private final void addTopLevel(Class<?> cls, FqName fqName) {
        ClassId classId = classId(cls);
        ClassId classId2 = ClassId.topLevel(fqName);
        Intrinsics.checkNotNullExpressionValue(classId2, "");
        add(classId, classId2);
    }

    private final void addJavaToKotlin(ClassId classId, ClassId classId2) {
        HashMap<FqNameUnsafe, ClassId> hashMap = javaToKotlin;
        FqNameUnsafe unsafe = classId.asSingleFqName().toUnsafe();
        Intrinsics.checkNotNullExpressionValue(unsafe, "");
        hashMap.put(unsafe, classId2);
    }

    private final void addKotlinToJava(FqName fqName, ClassId classId) {
        HashMap<FqNameUnsafe, ClassId> hashMap = kotlinToJava;
        FqNameUnsafe unsafe = fqName.toUnsafe();
        Intrinsics.checkNotNullExpressionValue(unsafe, "");
        hashMap.put(unsafe, classId);
    }

    public final FqName mutableToReadOnly(FqNameUnsafe fqNameUnsafe) {
        return mutableToReadOnly.get(fqNameUnsafe);
    }

    public final FqName readOnlyToMutable(FqNameUnsafe fqNameUnsafe) {
        return readOnlyToMutable.get(fqNameUnsafe);
    }

    public final boolean isMutable(FqNameUnsafe fqNameUnsafe) {
        return mutableToReadOnly.containsKey(fqNameUnsafe);
    }

    public final boolean isReadOnly(FqNameUnsafe fqNameUnsafe) {
        return readOnlyToMutable.containsKey(fqNameUnsafe);
    }

    private final ClassId classId(Class<?> cls) {
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            ClassId classId = ClassId.topLevel(new FqName(cls.getCanonicalName()));
            Intrinsics.checkNotNullExpressionValue(classId, "");
            return classId;
        }
        ClassId createNestedClassId = classId(declaringClass).createNestedClassId(Name.identifier(cls.getSimpleName()));
        Intrinsics.checkNotNullExpressionValue(createNestedClassId, "");
        return createNestedClassId;
    }
}
