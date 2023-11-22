package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementUtilsKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;

/* loaded from: classes.dex */
public final class TypeSignatureMappingKt {
    public static final <T> T boxTypeIfNeeded(JvmTypeFactory<T> jvmTypeFactory, T t, boolean z) {
        Intrinsics.checkNotNullParameter(jvmTypeFactory, "");
        Intrinsics.checkNotNullParameter(t, "");
        return z ? jvmTypeFactory.boxType(t) : t;
    }

    public static final <T> T mapBuiltInType(TypeSystemCommonBackendContext typeSystemCommonBackendContext, KotlinTypeMarker kotlinTypeMarker, JvmTypeFactory<T> jvmTypeFactory, TypeMappingMode typeMappingMode) {
        Intrinsics.checkNotNullParameter(typeSystemCommonBackendContext, "");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "");
        Intrinsics.checkNotNullParameter(jvmTypeFactory, "");
        Intrinsics.checkNotNullParameter(typeMappingMode, "");
        TypeConstructorMarker typeConstructor = typeSystemCommonBackendContext.typeConstructor(kotlinTypeMarker);
        if (typeSystemCommonBackendContext.isClassTypeConstructor(typeConstructor)) {
            PrimitiveType primitiveType = typeSystemCommonBackendContext.getPrimitiveType(typeConstructor);
            if (primitiveType != null) {
                return (T) boxTypeIfNeeded(jvmTypeFactory, jvmTypeFactory.createPrimitiveType(primitiveType), typeSystemCommonBackendContext.isNullableType(kotlinTypeMarker) || TypeEnhancementUtilsKt.hasEnhancedNullability(typeSystemCommonBackendContext, kotlinTypeMarker));
            }
            PrimitiveType primitiveArrayType = typeSystemCommonBackendContext.getPrimitiveArrayType(typeConstructor);
            if (primitiveArrayType != null) {
                StringBuilder sb = new StringBuilder();
                sb.append('[');
                sb.append(JvmPrimitiveType.get(primitiveArrayType).getDesc());
                return jvmTypeFactory.createFromString(sb.toString());
            }
            if (typeSystemCommonBackendContext.isUnderKotlinPackage(typeConstructor)) {
                FqNameUnsafe classFqNameUnsafe = typeSystemCommonBackendContext.getClassFqNameUnsafe(typeConstructor);
                ClassId mapKotlinToJava = classFqNameUnsafe != null ? JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(classFqNameUnsafe) : null;
                if (mapKotlinToJava != null) {
                    if (!typeMappingMode.getKotlinCollectionsToJavaCollections()) {
                        List<JavaToKotlinClassMap.PlatformMutabilityMapping> mutabilityMappings = JavaToKotlinClassMap.INSTANCE.getMutabilityMappings();
                        if (!(mutabilityMappings instanceof Collection) || !mutabilityMappings.isEmpty()) {
                            Iterator<T> it = mutabilityMappings.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                } else if (Intrinsics.areEqual(((JavaToKotlinClassMap.PlatformMutabilityMapping) it.next()).getJavaClass(), mapKotlinToJava)) {
                                    r4 = true;
                                    break;
                                }
                            }
                        }
                        if (r4) {
                            return null;
                        }
                    }
                    String internalName = JvmClassName.byClassId(mapKotlinToJava).getInternalName();
                    Intrinsics.checkNotNullExpressionValue(internalName, "");
                    return jvmTypeFactory.createObjectType(internalName);
                }
            }
            return null;
        }
        return null;
    }
}
