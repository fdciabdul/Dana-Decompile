package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* loaded from: classes.dex */
public final class TypeParameterUtilsKt {
    public static final List<TypeParameterDescriptor> computeConstructorTypeParameters(ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters) {
        List<TypeParameterDescriptor> list;
        DeclarationDescriptor declarationDescriptor;
        TypeConstructor typeConstructor;
        Intrinsics.checkNotNullParameter(classifierDescriptorWithTypeParameters, "");
        List<TypeParameterDescriptor> declaredTypeParameters = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(declaredTypeParameters, "");
        if (classifierDescriptorWithTypeParameters.isInner() || (classifierDescriptorWithTypeParameters.getContainingDeclaration() instanceof CallableDescriptor)) {
            ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters2 = classifierDescriptorWithTypeParameters;
            List list2 = SequencesKt.toList(SequencesKt.flatMap(SequencesKt.filter(SequencesKt.takeWhile(DescriptorUtilsKt.getParents(classifierDescriptorWithTypeParameters2), new Function1<DeclarationDescriptor, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(DeclarationDescriptor declarationDescriptor2) {
                    Intrinsics.checkNotNullParameter(declarationDescriptor2, "");
                    return Boolean.valueOf(declarationDescriptor2 instanceof CallableDescriptor);
                }
            }), new Function1<DeclarationDescriptor, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$2
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(DeclarationDescriptor declarationDescriptor2) {
                    Intrinsics.checkNotNullParameter(declarationDescriptor2, "");
                    return Boolean.valueOf(!(declarationDescriptor2 instanceof ConstructorDescriptor));
                }
            }), new Function1<DeclarationDescriptor, Sequence<? extends TypeParameterDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$3
                @Override // kotlin.jvm.functions.Function1
                public final Sequence<TypeParameterDescriptor> invoke(DeclarationDescriptor declarationDescriptor2) {
                    Intrinsics.checkNotNullParameter(declarationDescriptor2, "");
                    List<TypeParameterDescriptor> typeParameters = ((CallableDescriptor) declarationDescriptor2).getTypeParameters();
                    Intrinsics.checkNotNullExpressionValue(typeParameters, "");
                    return CollectionsKt.asSequence(typeParameters);
                }
            }));
            Iterator<DeclarationDescriptor> it = DescriptorUtilsKt.getParents(classifierDescriptorWithTypeParameters2).iterator();
            while (true) {
                list = null;
                if (!it.hasNext()) {
                    declarationDescriptor = null;
                    break;
                }
                declarationDescriptor = it.next();
                if (declarationDescriptor instanceof ClassDescriptor) {
                    break;
                }
            }
            ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
            if (classDescriptor != null && (typeConstructor = classDescriptor.getTypeConstructor()) != null) {
                list = typeConstructor.getParameters();
            }
            if (list == null) {
                list = CollectionsKt.emptyList();
            }
            if (list2.isEmpty() && list.isEmpty()) {
                List<TypeParameterDescriptor> declaredTypeParameters2 = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters();
                Intrinsics.checkNotNullExpressionValue(declaredTypeParameters2, "");
                return declaredTypeParameters2;
            }
            List<TypeParameterDescriptor> plus = CollectionsKt.plus((Collection) list2, (Iterable) list);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(plus, 10));
            for (TypeParameterDescriptor typeParameterDescriptor : plus) {
                Intrinsics.checkNotNullExpressionValue(typeParameterDescriptor, "");
                arrayList.add(capturedCopyForInnerDeclaration(typeParameterDescriptor, classifierDescriptorWithTypeParameters2, declaredTypeParameters.size()));
            }
            return CollectionsKt.plus((Collection) declaredTypeParameters, (Iterable) arrayList);
        }
        return declaredTypeParameters;
    }

    private static final CapturedTypeParameterDescriptor capturedCopyForInnerDeclaration(TypeParameterDescriptor typeParameterDescriptor, DeclarationDescriptor declarationDescriptor, int i) {
        return new CapturedTypeParameterDescriptor(typeParameterDescriptor, declarationDescriptor, i);
    }

    public static final PossiblyInnerType buildPossiblyInnerType(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "");
        ClassifierDescriptor mo4441getDeclarationDescriptor = kotlinType.getConstructor().mo4441getDeclarationDescriptor();
        return buildPossiblyInnerType(kotlinType, mo4441getDeclarationDescriptor instanceof ClassifierDescriptorWithTypeParameters ? (ClassifierDescriptorWithTypeParameters) mo4441getDeclarationDescriptor : null, 0);
    }

    private static final PossiblyInnerType buildPossiblyInnerType(KotlinType kotlinType, ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters, int i) {
        if (classifierDescriptorWithTypeParameters != null) {
            ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters2 = classifierDescriptorWithTypeParameters;
            if (ErrorUtils.isError(classifierDescriptorWithTypeParameters2)) {
                return null;
            }
            int size = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters().size() + i;
            if (!classifierDescriptorWithTypeParameters.isInner()) {
                if (size != kotlinType.getArguments().size()) {
                    DescriptorUtils.isLocal(classifierDescriptorWithTypeParameters2);
                }
                return new PossiblyInnerType(classifierDescriptorWithTypeParameters, kotlinType.getArguments().subList(i, kotlinType.getArguments().size()), null);
            }
            List<TypeProjection> subList = kotlinType.getArguments().subList(i, size);
            DeclarationDescriptor containingDeclaration = classifierDescriptorWithTypeParameters.getContainingDeclaration();
            return new PossiblyInnerType(classifierDescriptorWithTypeParameters, subList, buildPossiblyInnerType(kotlinType, containingDeclaration instanceof ClassifierDescriptorWithTypeParameters ? (ClassifierDescriptorWithTypeParameters) containingDeclaration : null, size));
        }
        return null;
    }
}
