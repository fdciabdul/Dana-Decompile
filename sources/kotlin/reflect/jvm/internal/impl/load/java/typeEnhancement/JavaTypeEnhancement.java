package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* loaded from: classes.dex */
public final class JavaTypeEnhancement {
    private final JavaResolverSettings javaResolverSettings;

    /* loaded from: classes.dex */
    public static final class Result {
        private final int subtreeSize;
        private final KotlinType type;

        public Result(KotlinType kotlinType, int i) {
            this.type = kotlinType;
            this.subtreeSize = i;
        }

        public final int getSubtreeSize() {
            return this.subtreeSize;
        }

        public final KotlinType getType() {
            return this.type;
        }
    }

    public JavaTypeEnhancement(JavaResolverSettings javaResolverSettings) {
        Intrinsics.checkNotNullParameter(javaResolverSettings, "");
        this.javaResolverSettings = javaResolverSettings;
    }

    /* loaded from: classes.dex */
    public static final class SimpleResult {
        private final boolean forWarnings;
        private final int subtreeSize;
        private final SimpleType type;

        public SimpleResult(SimpleType simpleType, int i, boolean z) {
            this.type = simpleType;
            this.subtreeSize = i;
            this.forWarnings = z;
        }

        public final boolean getForWarnings() {
            return this.forWarnings;
        }

        public final int getSubtreeSize() {
            return this.subtreeSize;
        }

        public final SimpleType getType() {
            return this.type;
        }
    }

    public final KotlinType enhance(KotlinType kotlinType, Function1<? super Integer, JavaTypeQualifiers> function1, boolean z) {
        Intrinsics.checkNotNullParameter(kotlinType, "");
        Intrinsics.checkNotNullParameter(function1, "");
        return enhancePossiblyFlexible(kotlinType.unwrap(), function1, 0, z).getType();
    }

    /* JADX WARN: Code restructure failed: missing block: B:91:0x009b, code lost:
    
        if (r13 == null) goto L92;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement.Result enhancePossiblyFlexible(kotlin.reflect.jvm.internal.impl.types.UnwrappedType r12, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers> r13, int r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement.enhancePossiblyFlexible(kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.jvm.functions.Function1, int, boolean):kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result");
    }

    static /* synthetic */ SimpleResult enhanceInflexible$default(JavaTypeEnhancement javaTypeEnhancement, SimpleType simpleType, Function1 function1, int i, TypeComponentPosition typeComponentPosition, boolean z, boolean z2, int i2, Object obj) {
        return javaTypeEnhancement.enhanceInflexible(simpleType, function1, i, typeComponentPosition, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? false : z2);
    }

    private final SimpleResult enhanceInflexible(SimpleType simpleType, Function1<? super Integer, JavaTypeQualifiers> function1, int i, TypeComponentPosition typeComponentPosition, boolean z, boolean z2) {
        ClassifierDescriptor enhanceMutability;
        Boolean enhancedNullability;
        TypeConstructor constructor;
        EnhancedTypeAnnotations enhancedTypeAnnotations;
        EnhancedTypeAnnotations enhancedTypeAnnotations2;
        Annotations compositeAnnotationsOrSingle;
        boolean z3;
        boolean z4;
        Result result;
        TypeProjection makeStarProjection;
        boolean shouldEnhance = TypeComponentPositionKt.shouldEnhance(typeComponentPosition);
        boolean z5 = (z2 && z) ? false : true;
        KotlinType kotlinType = null;
        if (shouldEnhance || !simpleType.getArguments().isEmpty()) {
            ClassifierDescriptor mo4441getDeclarationDescriptor = simpleType.getConstructor().mo4441getDeclarationDescriptor();
            if (mo4441getDeclarationDescriptor == null) {
                return new SimpleResult(null, 1, false);
            }
            JavaTypeQualifiers invoke = function1.invoke(Integer.valueOf(i));
            enhanceMutability = TypeEnhancementKt.enhanceMutability(mo4441getDeclarationDescriptor, invoke, typeComponentPosition);
            enhancedNullability = TypeEnhancementKt.getEnhancedNullability(invoke, typeComponentPosition);
            if (enhanceMutability == null || (constructor = enhanceMutability.getTypeConstructor()) == null) {
                constructor = simpleType.getConstructor();
            }
            TypeConstructor typeConstructor = constructor;
            Intrinsics.checkNotNullExpressionValue(typeConstructor, "");
            int i2 = i + 1;
            List<TypeProjection> arguments = simpleType.getArguments();
            List<TypeParameterDescriptor> parameters = typeConstructor.getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "");
            List<TypeParameterDescriptor> list = parameters;
            Iterator<T> it = arguments.iterator();
            Iterator<T> it2 = list.iterator();
            ArrayList arrayList = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(arguments, 10), CollectionsKt.collectionSizeOrDefault(list, 10)));
            while (it.hasNext() && it2.hasNext()) {
                Object next = it.next();
                TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) it2.next();
                TypeProjection typeProjection = (TypeProjection) next;
                if (!z5) {
                    z4 = z5;
                    result = new Result(kotlinType, 0);
                } else {
                    z4 = z5;
                    if (!typeProjection.isStarProjection()) {
                        result = enhancePossiblyFlexible(typeProjection.getType().unwrap(), function1, i2, z2);
                    } else if (function1.invoke(Integer.valueOf(i2)).getNullability() == NullabilityQualifier.FORCE_FLEXIBILITY) {
                        UnwrappedType unwrap = typeProjection.getType().unwrap();
                        result = new Result(KotlinTypeFactory.flexibleType(FlexibleTypesKt.lowerIfFlexible(unwrap).makeNullableAsSpecified(false), FlexibleTypesKt.upperIfFlexible(unwrap).makeNullableAsSpecified(true)), 1);
                    } else {
                        result = new Result(null, 1);
                    }
                }
                i2 += result.getSubtreeSize();
                if (result.getType() != null) {
                    KotlinType type = result.getType();
                    Variance projectionKind = typeProjection.getProjectionKind();
                    Intrinsics.checkNotNullExpressionValue(projectionKind, "");
                    makeStarProjection = TypeUtilsKt.createProjection(type, projectionKind, typeParameterDescriptor);
                } else if (enhanceMutability == null || typeProjection.isStarProjection()) {
                    makeStarProjection = enhanceMutability != null ? TypeUtils.makeStarProjection(typeParameterDescriptor) : null;
                } else {
                    KotlinType type2 = typeProjection.getType();
                    Intrinsics.checkNotNullExpressionValue(type2, "");
                    Variance projectionKind2 = typeProjection.getProjectionKind();
                    Intrinsics.checkNotNullExpressionValue(projectionKind2, "");
                    makeStarProjection = TypeUtilsKt.createProjection(type2, projectionKind2, typeParameterDescriptor);
                }
                arrayList.add(makeStarProjection);
                z5 = z4;
                kotlinType = null;
            }
            ArrayList arrayList2 = arrayList;
            int i3 = i2 - i;
            if (enhanceMutability == null && enhancedNullability == null) {
                ArrayList arrayList3 = arrayList2;
                if (!arrayList3.isEmpty()) {
                    Iterator it3 = arrayList3.iterator();
                    while (it3.hasNext()) {
                        if (!(((TypeProjection) it3.next()) == null)) {
                            z3 = false;
                            break;
                        }
                    }
                }
                z3 = true;
                if (z3) {
                    return new SimpleResult(null, i3, false);
                }
            }
            boolean z6 = false;
            Annotations[] annotationsArr = new Annotations[3];
            annotationsArr[0] = simpleType.getAnnotations();
            enhancedTypeAnnotations = TypeEnhancementKt.ENHANCED_MUTABILITY_ANNOTATIONS;
            if (!(enhanceMutability != null)) {
                enhancedTypeAnnotations = null;
            }
            annotationsArr[1] = enhancedTypeAnnotations;
            enhancedTypeAnnotations2 = TypeEnhancementKt.ENHANCED_NULLABILITY_ANNOTATIONS;
            if (!(enhancedNullability != null)) {
                enhancedTypeAnnotations2 = null;
            }
            annotationsArr[2] = enhancedTypeAnnotations2;
            compositeAnnotationsOrSingle = TypeEnhancementKt.compositeAnnotationsOrSingle(CollectionsKt.listOfNotNull((Object[]) annotationsArr));
            TypeAttributes defaultAttributes = TypeAttributesKt.toDefaultAttributes(compositeAnnotationsOrSingle);
            ArrayList arrayList4 = arrayList2;
            List<TypeProjection> arguments2 = simpleType.getArguments();
            Iterator it4 = arrayList4.iterator();
            Iterator<T> it5 = arguments2.iterator();
            ArrayList arrayList5 = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(arrayList4, 10), CollectionsKt.collectionSizeOrDefault(arguments2, 10)));
            while (it4.hasNext() && it5.hasNext()) {
                Object next2 = it4.next();
                TypeProjection typeProjection2 = (TypeProjection) it5.next();
                TypeProjection typeProjection3 = (TypeProjection) next2;
                if (typeProjection3 != null) {
                    typeProjection2 = typeProjection3;
                }
                arrayList5.add(typeProjection2);
            }
            SimpleType simpleType$default = KotlinTypeFactory.simpleType$default(defaultAttributes, typeConstructor, arrayList5, enhancedNullability != null ? enhancedNullability.booleanValue() : simpleType.isMarkedNullable(), (KotlinTypeRefiner) null, 16, (Object) null);
            if (invoke.getDefinitelyNotNull()) {
                simpleType$default = notNullTypeParameter(simpleType$default);
            }
            if (enhancedNullability != null && invoke.isNullabilityQualifierForWarning()) {
                z6 = true;
            }
            return new SimpleResult(simpleType$default, i3, z6);
        }
        return new SimpleResult(null, 1, false);
    }

    private final SimpleType notNullTypeParameter(SimpleType simpleType) {
        if (this.javaResolverSettings.getCorrectNullabilityForNotNullTypeParameter()) {
            return SpecialTypesKt.makeSimpleTypeDefinitelyNotNullOrNotNull(simpleType, true);
        }
        return new NotNullTypeParameterImpl(simpleType);
    }
}
