package kotlin.reflect.jvm.internal.impl.types;

import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;

/* loaded from: classes.dex */
public final class ExpandedTypeUtilsKt {
    public static final KotlinTypeMarker computeExpandedTypeForInlineClass(TypeSystemCommonBackendContext typeSystemCommonBackendContext, KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(typeSystemCommonBackendContext, "");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "");
        return computeExpandedTypeInner(typeSystemCommonBackendContext, kotlinTypeMarker, new HashSet());
    }

    private static final KotlinTypeMarker computeExpandedTypeInner(TypeSystemCommonBackendContext typeSystemCommonBackendContext, KotlinTypeMarker kotlinTypeMarker, HashSet<TypeConstructorMarker> hashSet) {
        KotlinTypeMarker computeExpandedTypeInner;
        KotlinTypeMarker makeNullable;
        TypeConstructorMarker typeConstructor = typeSystemCommonBackendContext.typeConstructor(kotlinTypeMarker);
        if (hashSet.add(typeConstructor)) {
            TypeParameterMarker typeParameterClassifier = typeSystemCommonBackendContext.getTypeParameterClassifier(typeConstructor);
            if (typeParameterClassifier != null) {
                KotlinTypeMarker representativeUpperBound = typeSystemCommonBackendContext.getRepresentativeUpperBound(typeParameterClassifier);
                computeExpandedTypeInner = computeExpandedTypeInner(typeSystemCommonBackendContext, representativeUpperBound, hashSet);
                if (computeExpandedTypeInner != null) {
                    boolean z = typeSystemCommonBackendContext.isInlineClass(typeSystemCommonBackendContext.typeConstructor(representativeUpperBound)) || ((representativeUpperBound instanceof SimpleTypeMarker) && typeSystemCommonBackendContext.isPrimitiveType((SimpleTypeMarker) representativeUpperBound));
                    if ((computeExpandedTypeInner instanceof SimpleTypeMarker) && typeSystemCommonBackendContext.isPrimitiveType((SimpleTypeMarker) computeExpandedTypeInner) && typeSystemCommonBackendContext.isNullableType(kotlinTypeMarker) && z) {
                        makeNullable = typeSystemCommonBackendContext.makeNullable(representativeUpperBound);
                    } else if (!typeSystemCommonBackendContext.isNullableType(computeExpandedTypeInner) && typeSystemCommonBackendContext.isMarkedNullable(kotlinTypeMarker)) {
                        makeNullable = typeSystemCommonBackendContext.makeNullable(computeExpandedTypeInner);
                    }
                    return makeNullable;
                }
                return null;
            } else if (!typeSystemCommonBackendContext.isInlineClass(typeConstructor)) {
                return kotlinTypeMarker;
            } else {
                KotlinTypeMarker unsubstitutedUnderlyingType = typeSystemCommonBackendContext.getUnsubstitutedUnderlyingType(kotlinTypeMarker);
                if (unsubstitutedUnderlyingType == null || (computeExpandedTypeInner = computeExpandedTypeInner(typeSystemCommonBackendContext, unsubstitutedUnderlyingType, hashSet)) == null) {
                    return null;
                }
                if (typeSystemCommonBackendContext.isNullableType(kotlinTypeMarker)) {
                    return typeSystemCommonBackendContext.isNullableType(computeExpandedTypeInner) ? kotlinTypeMarker : ((computeExpandedTypeInner instanceof SimpleTypeMarker) && typeSystemCommonBackendContext.isPrimitiveType((SimpleTypeMarker) computeExpandedTypeInner)) ? kotlinTypeMarker : typeSystemCommonBackendContext.makeNullable(computeExpandedTypeInner);
                }
            }
            return computeExpandedTypeInner;
        }
        return null;
    }
}
