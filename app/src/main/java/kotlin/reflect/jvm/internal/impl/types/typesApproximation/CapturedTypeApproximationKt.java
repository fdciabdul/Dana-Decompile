package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* loaded from: classes.dex */
public final class CapturedTypeApproximationKt {

    /* loaded from: classes.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Variance.values().length];
            iArr[Variance.INVARIANT.ordinal()] = 1;
            iArr[Variance.IN_VARIANCE.ordinal()] = 2;
            iArr[Variance.OUT_VARIANCE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final TypeProjection toTypeProjection(TypeArgument typeArgument) {
        typeArgument.isConsistent();
        if (Intrinsics.areEqual(typeArgument.getInProjection(), typeArgument.getOutProjection()) || typeArgument.getTypeParameter().getVariance() == Variance.IN_VARIANCE) {
            return new TypeProjectionImpl(typeArgument.getInProjection());
        }
        if (!KotlinBuiltIns.isNothing(typeArgument.getInProjection()) || typeArgument.getTypeParameter().getVariance() == Variance.IN_VARIANCE) {
            return KotlinBuiltIns.isNullableAny(typeArgument.getOutProjection()) ? new TypeProjectionImpl(toTypeProjection$removeProjectionIfRedundant(typeArgument, Variance.IN_VARIANCE), typeArgument.getInProjection()) : new TypeProjectionImpl(toTypeProjection$removeProjectionIfRedundant(typeArgument, Variance.OUT_VARIANCE), typeArgument.getOutProjection());
        }
        return new TypeProjectionImpl(toTypeProjection$removeProjectionIfRedundant(typeArgument, Variance.OUT_VARIANCE), typeArgument.getOutProjection());
    }

    private static final Variance toTypeProjection$removeProjectionIfRedundant(TypeArgument typeArgument, Variance variance) {
        return variance == typeArgument.getTypeParameter().getVariance() ? Variance.INVARIANT : variance;
    }

    private static final TypeArgument toTypeArgument(TypeProjection typeProjection, TypeParameterDescriptor typeParameterDescriptor) {
        int i = WhenMappings.$EnumSwitchMapping$0[TypeSubstitutor.combine(typeParameterDescriptor.getVariance(), typeProjection).ordinal()];
        if (i == 1) {
            KotlinType type = typeProjection.getType();
            Intrinsics.checkNotNullExpressionValue(type, "");
            KotlinType type2 = typeProjection.getType();
            Intrinsics.checkNotNullExpressionValue(type2, "");
            return new TypeArgument(typeParameterDescriptor, type, type2);
        } else if (i == 2) {
            KotlinType type3 = typeProjection.getType();
            Intrinsics.checkNotNullExpressionValue(type3, "");
            SimpleType nullableAnyType = DescriptorUtilsKt.getBuiltIns(typeParameterDescriptor).getNullableAnyType();
            Intrinsics.checkNotNullExpressionValue(nullableAnyType, "");
            return new TypeArgument(typeParameterDescriptor, type3, nullableAnyType);
        } else if (i == 3) {
            SimpleType nothingType = DescriptorUtilsKt.getBuiltIns(typeParameterDescriptor).getNothingType();
            Intrinsics.checkNotNullExpressionValue(nothingType, "");
            KotlinType type4 = typeProjection.getType();
            Intrinsics.checkNotNullExpressionValue(type4, "");
            return new TypeArgument(typeParameterDescriptor, nothingType, type4);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final TypeProjection approximateCapturedTypesIfNecessary(TypeProjection typeProjection, boolean z) {
        if (typeProjection == null) {
            return null;
        }
        if (typeProjection.isStarProjection()) {
            return typeProjection;
        }
        KotlinType type = typeProjection.getType();
        Intrinsics.checkNotNullExpressionValue(type, "");
        if (TypeUtils.contains(type, new Function1<UnwrappedType, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt$approximateCapturedTypesIfNecessary$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(UnwrappedType unwrappedType) {
                Intrinsics.checkNotNullExpressionValue(unwrappedType, "");
                return Boolean.valueOf(CapturedTypeConstructorKt.isCaptured(unwrappedType));
            }
        })) {
            Variance projectionKind = typeProjection.getProjectionKind();
            Intrinsics.checkNotNullExpressionValue(projectionKind, "");
            if (projectionKind == Variance.OUT_VARIANCE) {
                return new TypeProjectionImpl(projectionKind, approximateCapturedTypes(type).getUpper());
            }
            if (z) {
                return new TypeProjectionImpl(projectionKind, approximateCapturedTypes(type).getLower());
            }
            return substituteCapturedTypesWithProjections(typeProjection);
        }
        return typeProjection;
    }

    private static final TypeProjection substituteCapturedTypesWithProjections(TypeProjection typeProjection) {
        TypeSubstitutor create = TypeSubstitutor.create(new TypeConstructorSubstitution() { // from class: kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt$substituteCapturedTypesWithProjections$typeSubstitutor$1
            @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution
            public final TypeProjection get(TypeConstructor typeConstructor) {
                Intrinsics.checkNotNullParameter(typeConstructor, "");
                CapturedTypeConstructor capturedTypeConstructor = typeConstructor instanceof CapturedTypeConstructor ? (CapturedTypeConstructor) typeConstructor : null;
                if (capturedTypeConstructor == null) {
                    return null;
                }
                if (capturedTypeConstructor.getProjection().isStarProjection()) {
                    return new TypeProjectionImpl(Variance.OUT_VARIANCE, capturedTypeConstructor.getProjection().getType());
                }
                return capturedTypeConstructor.getProjection();
            }
        });
        Intrinsics.checkNotNullExpressionValue(create, "");
        return create.substituteWithoutApproximation(typeProjection);
    }

    public static final ApproximationBounds<KotlinType> approximateCapturedTypes(KotlinType kotlinType) {
        SimpleType replaceTypeArguments;
        Intrinsics.checkNotNullParameter(kotlinType, "");
        if (FlexibleTypesKt.isFlexible(kotlinType)) {
            ApproximationBounds<KotlinType> approximateCapturedTypes = approximateCapturedTypes(FlexibleTypesKt.lowerIfFlexible(kotlinType));
            ApproximationBounds<KotlinType> approximateCapturedTypes2 = approximateCapturedTypes(FlexibleTypesKt.upperIfFlexible(kotlinType));
            return new ApproximationBounds<>(TypeWithEnhancementKt.inheritEnhancement(KotlinTypeFactory.flexibleType(FlexibleTypesKt.lowerIfFlexible(approximateCapturedTypes.getLower()), FlexibleTypesKt.upperIfFlexible(approximateCapturedTypes2.getLower())), kotlinType), TypeWithEnhancementKt.inheritEnhancement(KotlinTypeFactory.flexibleType(FlexibleTypesKt.lowerIfFlexible(approximateCapturedTypes.getUpper()), FlexibleTypesKt.upperIfFlexible(approximateCapturedTypes2.getUpper())), kotlinType));
        }
        TypeConstructor constructor = kotlinType.getConstructor();
        if (CapturedTypeConstructorKt.isCaptured(kotlinType)) {
            Intrinsics.checkNotNull(constructor);
            TypeProjection projection = ((CapturedTypeConstructor) constructor).getProjection();
            KotlinType type = projection.getType();
            Intrinsics.checkNotNullExpressionValue(type, "");
            KotlinType approximateCapturedTypes$makeNullableIfNeeded = approximateCapturedTypes$makeNullableIfNeeded(type, kotlinType);
            int i = WhenMappings.$EnumSwitchMapping$0[projection.getProjectionKind().ordinal()];
            if (i == 2) {
                SimpleType nullableAnyType = TypeUtilsKt.getBuiltIns(kotlinType).getNullableAnyType();
                Intrinsics.checkNotNullExpressionValue(nullableAnyType, "");
                return new ApproximationBounds<>(approximateCapturedTypes$makeNullableIfNeeded, nullableAnyType);
            } else if (i == 3) {
                SimpleType nothingType = TypeUtilsKt.getBuiltIns(kotlinType).getNothingType();
                Intrinsics.checkNotNullExpressionValue(nothingType, "");
                return new ApproximationBounds<>(approximateCapturedTypes$makeNullableIfNeeded(nothingType, kotlinType), approximateCapturedTypes$makeNullableIfNeeded);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Only nontrivial projections should have been captured, not: ");
                sb.append(projection);
                throw new AssertionError(sb.toString());
            }
        } else if (kotlinType.getArguments().isEmpty() || kotlinType.getArguments().size() != constructor.getParameters().size()) {
            return new ApproximationBounds<>(kotlinType, kotlinType);
        } else {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            List<TypeProjection> arguments = kotlinType.getArguments();
            List<TypeParameterDescriptor> parameters = constructor.getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "");
            for (Pair pair : CollectionsKt.zip(arguments, parameters)) {
                TypeProjection typeProjection = (TypeProjection) pair.component1();
                TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) pair.component2();
                Intrinsics.checkNotNullExpressionValue(typeParameterDescriptor, "");
                TypeArgument typeArgument = toTypeArgument(typeProjection, typeParameterDescriptor);
                if (typeProjection.isStarProjection()) {
                    arrayList.add(typeArgument);
                    arrayList2.add(typeArgument);
                } else {
                    ApproximationBounds<TypeArgument> approximateProjection = approximateProjection(typeArgument);
                    TypeArgument component1 = approximateProjection.component1();
                    TypeArgument component2 = approximateProjection.component2();
                    arrayList.add(component1);
                    arrayList2.add(component2);
                }
            }
            ArrayList arrayList3 = arrayList;
            boolean z = true;
            if (!arrayList3.isEmpty()) {
                Iterator it = arrayList3.iterator();
                while (it.hasNext()) {
                    if ((!((TypeArgument) it.next()).isConsistent()) != false) {
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                SimpleType nothingType2 = TypeUtilsKt.getBuiltIns(kotlinType).getNothingType();
                Intrinsics.checkNotNullExpressionValue(nothingType2, "");
                replaceTypeArguments = nothingType2;
            } else {
                replaceTypeArguments = replaceTypeArguments(kotlinType, arrayList);
            }
            return new ApproximationBounds<>(replaceTypeArguments, replaceTypeArguments(kotlinType, arrayList2));
        }
    }

    private static final KotlinType approximateCapturedTypes$makeNullableIfNeeded(KotlinType kotlinType, KotlinType kotlinType2) {
        KotlinType makeNullableIfNeeded = TypeUtils.makeNullableIfNeeded(kotlinType, kotlinType2.isMarkedNullable());
        Intrinsics.checkNotNullExpressionValue(makeNullableIfNeeded, "");
        return makeNullableIfNeeded;
    }

    private static final KotlinType replaceTypeArguments(KotlinType kotlinType, List<TypeArgument> list) {
        kotlinType.getArguments().size();
        list.size();
        List<TypeArgument> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toTypeProjection((TypeArgument) it.next()));
        }
        return TypeSubstitutionKt.replace$default(kotlinType, arrayList, null, null, 6, null);
    }

    private static final ApproximationBounds<TypeArgument> approximateProjection(TypeArgument typeArgument) {
        ApproximationBounds<KotlinType> approximateCapturedTypes = approximateCapturedTypes(typeArgument.getInProjection());
        KotlinType component1 = approximateCapturedTypes.component1();
        KotlinType component2 = approximateCapturedTypes.component2();
        ApproximationBounds<KotlinType> approximateCapturedTypes2 = approximateCapturedTypes(typeArgument.getOutProjection());
        return new ApproximationBounds<>(new TypeArgument(typeArgument.getTypeParameter(), component2, approximateCapturedTypes2.component1()), new TypeArgument(typeArgument.getTypeParameter(), component1, approximateCapturedTypes2.component2()));
    }
}
