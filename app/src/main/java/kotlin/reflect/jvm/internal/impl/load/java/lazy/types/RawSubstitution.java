package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.text.Typography;

/* loaded from: classes.dex */
public final class RawSubstitution extends TypeSubstitution {
    public static final Companion Companion = new Companion(null);
    private static final JavaTypeAttributes lowerTypeAttr = JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, false, null, 3, null).withFlexibility(JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND);
    private static final JavaTypeAttributes upperTypeAttr = JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, false, null, 3, null).withFlexibility(JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND);
    private final TypeParameterUpperBoundEraser typeParameterUpperBoundEraser;

    /* loaded from: classes.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[JavaTypeFlexibility.values().length];
            iArr[JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND.ordinal()] = 1;
            iArr[JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND.ordinal()] = 2;
            iArr[JavaTypeFlexibility.INFLEXIBLE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.reflect.jvm.internal.impl.load.java.lazy.types.TypeParameterUpperBoundEraser, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public RawSubstitution() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawSubstitution.<init>():void");
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public final boolean isEmpty() {
        return false;
    }

    public RawSubstitution(TypeParameterUpperBoundEraser typeParameterUpperBoundEraser) {
        this.typeParameterUpperBoundEraser = typeParameterUpperBoundEraser == null ? new TypeParameterUpperBoundEraser(this) : typeParameterUpperBoundEraser;
    }

    public /* synthetic */ RawSubstitution(TypeParameterUpperBoundEraser typeParameterUpperBoundEraser, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : typeParameterUpperBoundEraser);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    /* renamed from: get */
    public final TypeProjectionImpl mo4450get(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "");
        return new TypeProjectionImpl(eraseType$default(this, kotlinType, null, 2, null));
    }

    static /* synthetic */ KotlinType eraseType$default(RawSubstitution rawSubstitution, KotlinType kotlinType, JavaTypeAttributes javaTypeAttributes, int i, Object obj) {
        if ((i & 2) != 0) {
            javaTypeAttributes = new JavaTypeAttributes(TypeUsage.COMMON, null, false, null, null, 30, null);
        }
        return rawSubstitution.eraseType(kotlinType, javaTypeAttributes);
    }

    private final KotlinType eraseType(KotlinType kotlinType, JavaTypeAttributes javaTypeAttributes) {
        RawTypeImpl rawTypeImpl;
        ClassifierDescriptor mo4441getDeclarationDescriptor = kotlinType.getConstructor().mo4441getDeclarationDescriptor();
        if (mo4441getDeclarationDescriptor instanceof TypeParameterDescriptor) {
            KotlinType erasedUpperBound$descriptors_jvm = this.typeParameterUpperBoundEraser.getErasedUpperBound$descriptors_jvm((TypeParameterDescriptor) mo4441getDeclarationDescriptor, true, javaTypeAttributes);
            Intrinsics.checkNotNullExpressionValue(erasedUpperBound$descriptors_jvm, "");
            return eraseType(erasedUpperBound$descriptors_jvm, javaTypeAttributes);
        } else if (mo4441getDeclarationDescriptor instanceof ClassDescriptor) {
            ClassifierDescriptor mo4441getDeclarationDescriptor2 = FlexibleTypesKt.upperIfFlexible(kotlinType).getConstructor().mo4441getDeclarationDescriptor();
            if (!(mo4441getDeclarationDescriptor2 instanceof ClassDescriptor)) {
                StringBuilder sb = new StringBuilder();
                sb.append("For some reason declaration for upper bound is not a class but \"");
                sb.append(mo4441getDeclarationDescriptor2);
                sb.append("\" while for lower it's \"");
                sb.append(mo4441getDeclarationDescriptor);
                sb.append(Typography.quote);
                throw new IllegalStateException(sb.toString().toString());
            }
            Pair<SimpleType, Boolean> eraseInflexibleBasedOnClassDescriptor = eraseInflexibleBasedOnClassDescriptor(FlexibleTypesKt.lowerIfFlexible(kotlinType), (ClassDescriptor) mo4441getDeclarationDescriptor, lowerTypeAttr);
            SimpleType component1 = eraseInflexibleBasedOnClassDescriptor.component1();
            boolean booleanValue = eraseInflexibleBasedOnClassDescriptor.component2().booleanValue();
            Pair<SimpleType, Boolean> eraseInflexibleBasedOnClassDescriptor2 = eraseInflexibleBasedOnClassDescriptor(FlexibleTypesKt.upperIfFlexible(kotlinType), (ClassDescriptor) mo4441getDeclarationDescriptor2, upperTypeAttr);
            SimpleType component12 = eraseInflexibleBasedOnClassDescriptor2.component1();
            boolean booleanValue2 = eraseInflexibleBasedOnClassDescriptor2.component2().booleanValue();
            if (booleanValue || booleanValue2) {
                rawTypeImpl = new RawTypeImpl(component1, component12);
            } else {
                rawTypeImpl = KotlinTypeFactory.flexibleType(component1, component12);
            }
            return rawTypeImpl;
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unexpected declaration kind: ");
            sb2.append(mo4441getDeclarationDescriptor);
            throw new IllegalStateException(sb2.toString().toString());
        }
    }

    public final Pair<SimpleType, Boolean> eraseInflexibleBasedOnClassDescriptor(final SimpleType simpleType, final ClassDescriptor classDescriptor, final JavaTypeAttributes javaTypeAttributes) {
        boolean isEmpty = simpleType.getConstructor().getParameters().isEmpty();
        Boolean bool = Boolean.FALSE;
        if (isEmpty) {
            return TuplesKt.to(simpleType, bool);
        }
        SimpleType simpleType2 = simpleType;
        if (KotlinBuiltIns.isArray(simpleType2)) {
            TypeProjection typeProjection = simpleType.getArguments().get(0);
            Variance projectionKind = typeProjection.getProjectionKind();
            KotlinType type = typeProjection.getType();
            Intrinsics.checkNotNullExpressionValue(type, "");
            return TuplesKt.to(KotlinTypeFactory.simpleType$default(simpleType.getAttributes(), simpleType.getConstructor(), CollectionsKt.listOf(new TypeProjectionImpl(projectionKind, eraseType(type, javaTypeAttributes))), simpleType.isMarkedNullable(), (KotlinTypeRefiner) null, 16, (Object) null), bool);
        } else if (KotlinTypeKt.isError(simpleType2)) {
            return TuplesKt.to(ErrorUtils.createErrorType(ErrorTypeKind.ERROR_RAW_TYPE, simpleType.getConstructor().toString()), bool);
        } else {
            MemberScope memberScope = classDescriptor.getMemberScope(this);
            Intrinsics.checkNotNullExpressionValue(memberScope, "");
            TypeAttributes attributes = simpleType.getAttributes();
            TypeConstructor typeConstructor = classDescriptor.getTypeConstructor();
            Intrinsics.checkNotNullExpressionValue(typeConstructor, "");
            List<TypeParameterDescriptor> parameters = classDescriptor.getTypeConstructor().getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "");
            List<TypeParameterDescriptor> list = parameters;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (TypeParameterDescriptor typeParameterDescriptor : list) {
                Intrinsics.checkNotNullExpressionValue(typeParameterDescriptor, "");
                arrayList.add(computeProjection$default(this, typeParameterDescriptor, javaTypeAttributes, null, 4, null));
            }
            return TuplesKt.to(KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(attributes, typeConstructor, arrayList, simpleType.isMarkedNullable(), memberScope, new Function1<KotlinTypeRefiner, SimpleType>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawSubstitution$eraseInflexibleBasedOnClassDescriptor$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final SimpleType invoke(KotlinTypeRefiner kotlinTypeRefiner) {
                    ClassId classId;
                    ClassDescriptor findClassAcrossModuleDependencies;
                    Pair eraseInflexibleBasedOnClassDescriptor;
                    Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "");
                    ClassDescriptor classDescriptor2 = ClassDescriptor.this;
                    if (!(classDescriptor2 instanceof ClassDescriptor)) {
                        classDescriptor2 = null;
                    }
                    if (classDescriptor2 == null || (classId = DescriptorUtilsKt.getClassId(classDescriptor2)) == null || (findClassAcrossModuleDependencies = kotlinTypeRefiner.findClassAcrossModuleDependencies(classId)) == null || Intrinsics.areEqual(findClassAcrossModuleDependencies, ClassDescriptor.this)) {
                        return null;
                    }
                    eraseInflexibleBasedOnClassDescriptor = this.eraseInflexibleBasedOnClassDescriptor(simpleType, findClassAcrossModuleDependencies, javaTypeAttributes);
                    return (SimpleType) eraseInflexibleBasedOnClassDescriptor.getFirst();
                }
            }), Boolean.TRUE);
        }
    }

    public static /* synthetic */ TypeProjection computeProjection$default(RawSubstitution rawSubstitution, TypeParameterDescriptor typeParameterDescriptor, JavaTypeAttributes javaTypeAttributes, KotlinType kotlinType, int i, Object obj) {
        if ((i & 4) != 0) {
            kotlinType = rawSubstitution.typeParameterUpperBoundEraser.getErasedUpperBound$descriptors_jvm(typeParameterDescriptor, true, javaTypeAttributes);
            Intrinsics.checkNotNullExpressionValue(kotlinType, "");
        }
        return rawSubstitution.computeProjection(typeParameterDescriptor, javaTypeAttributes, kotlinType);
    }

    public final TypeProjection computeProjection(TypeParameterDescriptor typeParameterDescriptor, JavaTypeAttributes javaTypeAttributes, KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "");
        Intrinsics.checkNotNullParameter(javaTypeAttributes, "");
        Intrinsics.checkNotNullParameter(kotlinType, "");
        int i = WhenMappings.$EnumSwitchMapping$0[javaTypeAttributes.getFlexibility().ordinal()];
        if (i != 1) {
            if (i == 2 || i == 3) {
                if (!typeParameterDescriptor.getVariance().getAllowsOutPosition()) {
                    return new TypeProjectionImpl(Variance.INVARIANT, DescriptorUtilsKt.getBuiltIns(typeParameterDescriptor).getNothingType());
                }
                Intrinsics.checkNotNullExpressionValue(kotlinType.getConstructor().getParameters(), "");
                if ((!r1.isEmpty()) != false) {
                    return new TypeProjectionImpl(Variance.OUT_VARIANCE, kotlinType);
                }
                return JavaTypeResolverKt.makeStarProjection(typeParameterDescriptor, javaTypeAttributes);
            }
            throw new NoWhenBranchMatchedException();
        }
        return new TypeProjectionImpl(Variance.INVARIANT, kotlinType);
    }

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
