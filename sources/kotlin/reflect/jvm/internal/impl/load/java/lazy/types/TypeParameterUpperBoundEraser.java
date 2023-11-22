package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.TypeParameterUpperBoundEraser;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* loaded from: classes.dex */
public final class TypeParameterUpperBoundEraser {
    private final Lazy erroneousErasedBound$delegate;
    private final MemoizedFunctionToNotNull<DataToEraseUpperBound, KotlinType> getErasedUpperBound;
    private final RawSubstitution rawSubstitution;
    private final LockBasedStorageManager storage;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawSubstitution, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public TypeParameterUpperBoundEraser() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.TypeParameterUpperBoundEraser.<init>():void");
    }

    public TypeParameterUpperBoundEraser(RawSubstitution rawSubstitution) {
        LockBasedStorageManager lockBasedStorageManager = new LockBasedStorageManager("Type parameter upper bound erasion results");
        this.storage = lockBasedStorageManager;
        this.erroneousErasedBound$delegate = LazyKt.lazy(new Function0<ErrorType>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.TypeParameterUpperBoundEraser$erroneousErasedBound$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ErrorType invoke() {
                return ErrorUtils.createErrorType(ErrorTypeKind.CANNOT_COMPUTE_ERASED_BOUND, TypeParameterUpperBoundEraser.this.toString());
            }
        });
        this.rawSubstitution = rawSubstitution == null ? new RawSubstitution(this) : rawSubstitution;
        MemoizedFunctionToNotNull<DataToEraseUpperBound, KotlinType> createMemoizedFunction = lockBasedStorageManager.createMemoizedFunction(new Function1<DataToEraseUpperBound, KotlinType>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.TypeParameterUpperBoundEraser$getErasedUpperBound$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final KotlinType invoke(TypeParameterUpperBoundEraser.DataToEraseUpperBound dataToEraseUpperBound) {
                KotlinType erasedUpperBoundInternal;
                erasedUpperBoundInternal = TypeParameterUpperBoundEraser.this.getErasedUpperBoundInternal(dataToEraseUpperBound.getTypeParameter(), dataToEraseUpperBound.isRaw(), dataToEraseUpperBound.getTypeAttr());
                return erasedUpperBoundInternal;
            }
        });
        Intrinsics.checkNotNullExpressionValue(createMemoizedFunction, "");
        this.getErasedUpperBound = createMemoizedFunction;
    }

    public /* synthetic */ TypeParameterUpperBoundEraser(RawSubstitution rawSubstitution, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : rawSubstitution);
    }

    private final ErrorType getErroneousErasedBound() {
        return (ErrorType) this.erroneousErasedBound$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class DataToEraseUpperBound {
        private final boolean isRaw;
        private final JavaTypeAttributes typeAttr;
        private final TypeParameterDescriptor typeParameter;

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("DataToEraseUpperBound(typeParameter=");
            sb.append(this.typeParameter);
            sb.append(", isRaw=");
            sb.append(this.isRaw);
            sb.append(", typeAttr=");
            sb.append(this.typeAttr);
            sb.append(')');
            return sb.toString();
        }

        public DataToEraseUpperBound(TypeParameterDescriptor typeParameterDescriptor, boolean z, JavaTypeAttributes javaTypeAttributes) {
            Intrinsics.checkNotNullParameter(typeParameterDescriptor, "");
            Intrinsics.checkNotNullParameter(javaTypeAttributes, "");
            this.typeParameter = typeParameterDescriptor;
            this.isRaw = z;
            this.typeAttr = javaTypeAttributes;
        }

        public final TypeParameterDescriptor getTypeParameter() {
            return this.typeParameter;
        }

        public final boolean isRaw() {
            return this.isRaw;
        }

        public final JavaTypeAttributes getTypeAttr() {
            return this.typeAttr;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof DataToEraseUpperBound) {
                DataToEraseUpperBound dataToEraseUpperBound = (DataToEraseUpperBound) obj;
                return Intrinsics.areEqual(dataToEraseUpperBound.typeParameter, this.typeParameter) && dataToEraseUpperBound.isRaw == this.isRaw && dataToEraseUpperBound.typeAttr.getFlexibility() == this.typeAttr.getFlexibility() && dataToEraseUpperBound.typeAttr.getHowThisTypeIsUsed() == this.typeAttr.getHowThisTypeIsUsed() && dataToEraseUpperBound.typeAttr.isForAnnotationParameter() == this.typeAttr.isForAnnotationParameter() && Intrinsics.areEqual(dataToEraseUpperBound.typeAttr.getDefaultType(), this.typeAttr.getDefaultType());
            }
            return false;
        }

        public final int hashCode() {
            int hashCode = this.typeParameter.hashCode();
            int i = hashCode + (hashCode * 31) + (this.isRaw ? 1 : 0);
            int hashCode2 = i + (i * 31) + this.typeAttr.getFlexibility().hashCode();
            int hashCode3 = hashCode2 + (hashCode2 * 31) + this.typeAttr.getHowThisTypeIsUsed().hashCode();
            int i2 = hashCode3 + (hashCode3 * 31) + (this.typeAttr.isForAnnotationParameter() ? 1 : 0);
            SimpleType defaultType = this.typeAttr.getDefaultType();
            return i2 + (i2 * 31) + (defaultType != null ? defaultType.hashCode() : 0);
        }
    }

    public final KotlinType getErasedUpperBound$descriptors_jvm(TypeParameterDescriptor typeParameterDescriptor, boolean z, JavaTypeAttributes javaTypeAttributes) {
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "");
        Intrinsics.checkNotNullParameter(javaTypeAttributes, "");
        return this.getErasedUpperBound.invoke(new DataToEraseUpperBound(typeParameterDescriptor, z, javaTypeAttributes));
    }

    private final KotlinType getDefaultType(JavaTypeAttributes javaTypeAttributes) {
        KotlinType replaceArgumentsWithStarProjections;
        SimpleType defaultType = javaTypeAttributes.getDefaultType();
        return (defaultType == null || (replaceArgumentsWithStarProjections = TypeUtilsKt.replaceArgumentsWithStarProjections(defaultType)) == null) ? getErroneousErasedBound() : replaceArgumentsWithStarProjections;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final KotlinType getErasedUpperBoundInternal(TypeParameterDescriptor typeParameterDescriptor, boolean z, JavaTypeAttributes javaTypeAttributes) {
        TypeProjection computeProjection;
        Set<TypeParameterDescriptor> visitedTypeParameters = javaTypeAttributes.getVisitedTypeParameters();
        if (visitedTypeParameters != null && visitedTypeParameters.contains(typeParameterDescriptor.getOriginal())) {
            return getDefaultType(javaTypeAttributes);
        }
        SimpleType defaultType = typeParameterDescriptor.getDefaultType();
        Intrinsics.checkNotNullExpressionValue(defaultType, "");
        Set<TypeParameterDescriptor> extractTypeParametersFromUpperBounds = TypeUtilsKt.extractTypeParametersFromUpperBounds(defaultType, visitedTypeParameters);
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(extractTypeParametersFromUpperBounds, 10)), 16));
        for (TypeParameterDescriptor typeParameterDescriptor2 : extractTypeParametersFromUpperBounds) {
            if (visitedTypeParameters == null || !visitedTypeParameters.contains(typeParameterDescriptor2)) {
                RawSubstitution rawSubstitution = this.rawSubstitution;
                JavaTypeAttributes withFlexibility = z ? javaTypeAttributes : javaTypeAttributes.withFlexibility(JavaTypeFlexibility.INFLEXIBLE);
                KotlinType erasedUpperBound$descriptors_jvm = getErasedUpperBound$descriptors_jvm(typeParameterDescriptor2, z, javaTypeAttributes.withNewVisitedTypeParameter(typeParameterDescriptor));
                Intrinsics.checkNotNullExpressionValue(erasedUpperBound$descriptors_jvm, "");
                computeProjection = rawSubstitution.computeProjection(typeParameterDescriptor2, withFlexibility, erasedUpperBound$descriptors_jvm);
            } else {
                computeProjection = JavaTypeResolverKt.makeStarProjection(typeParameterDescriptor2, javaTypeAttributes);
            }
            Pair pair = TuplesKt.to(typeParameterDescriptor2.getTypeConstructor(), computeProjection);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        TypeSubstitutor create = TypeSubstitutor.create(TypeConstructorSubstitution.Companion.createByConstructorsMap$default(TypeConstructorSubstitution.Companion, linkedHashMap, false, 2, null));
        Intrinsics.checkNotNullExpressionValue(create, "");
        List<KotlinType> upperBounds = typeParameterDescriptor.getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(upperBounds, "");
        KotlinType kotlinType = (KotlinType) CollectionsKt.first((List) upperBounds);
        if (kotlinType.getConstructor().mo4441getDeclarationDescriptor() instanceof ClassDescriptor) {
            Intrinsics.checkNotNullExpressionValue(kotlinType, "");
            return TypeUtilsKt.replaceArgumentsWithStarProjectionOrMapped(kotlinType, create, linkedHashMap, Variance.OUT_VARIANCE, javaTypeAttributes.getVisitedTypeParameters());
        }
        Set<TypeParameterDescriptor> visitedTypeParameters2 = javaTypeAttributes.getVisitedTypeParameters();
        if (visitedTypeParameters2 == null) {
            visitedTypeParameters2 = SetsKt.setOf(this);
        }
        ClassifierDescriptor mo4441getDeclarationDescriptor = kotlinType.getConstructor().mo4441getDeclarationDescriptor();
        Intrinsics.checkNotNull(mo4441getDeclarationDescriptor);
        while (true) {
            TypeParameterDescriptor typeParameterDescriptor3 = (TypeParameterDescriptor) mo4441getDeclarationDescriptor;
            if (!visitedTypeParameters2.contains(typeParameterDescriptor3)) {
                List<KotlinType> upperBounds2 = typeParameterDescriptor3.getUpperBounds();
                Intrinsics.checkNotNullExpressionValue(upperBounds2, "");
                KotlinType kotlinType2 = (KotlinType) CollectionsKt.first((List) upperBounds2);
                if (kotlinType2.getConstructor().mo4441getDeclarationDescriptor() instanceof ClassDescriptor) {
                    Intrinsics.checkNotNullExpressionValue(kotlinType2, "");
                    return TypeUtilsKt.replaceArgumentsWithStarProjectionOrMapped(kotlinType2, create, linkedHashMap, Variance.OUT_VARIANCE, javaTypeAttributes.getVisitedTypeParameters());
                }
                mo4441getDeclarationDescriptor = kotlinType2.getConstructor().mo4441getDeclarationDescriptor();
                Intrinsics.checkNotNull(mo4441getDeclarationDescriptor);
            } else {
                return getDefaultType(javaTypeAttributes);
            }
        }
    }
}
