package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.BuiltInAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* loaded from: classes.dex */
public final class FunctionTypesKt {
    public static final boolean isFunctionType(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "");
        ClassifierDescriptor mo4441getDeclarationDescriptor = kotlinType.getConstructor().mo4441getDeclarationDescriptor();
        return (mo4441getDeclarationDescriptor != null ? getFunctionalClassKind(mo4441getDeclarationDescriptor) : null) == FunctionClassKind.Function;
    }

    public static final boolean isSuspendFunctionType(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "");
        ClassifierDescriptor mo4441getDeclarationDescriptor = kotlinType.getConstructor().mo4441getDeclarationDescriptor();
        return (mo4441getDeclarationDescriptor != null ? getFunctionalClassKind(mo4441getDeclarationDescriptor) : null) == FunctionClassKind.SuspendFunction;
    }

    public static final boolean isBuiltinFunctionalType(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "");
        ClassifierDescriptor mo4441getDeclarationDescriptor = kotlinType.getConstructor().mo4441getDeclarationDescriptor();
        return mo4441getDeclarationDescriptor != null && isBuiltinFunctionalClassDescriptor(mo4441getDeclarationDescriptor);
    }

    public static final boolean isBuiltinFunctionalClassDescriptor(DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "");
        FunctionClassKind functionalClassKind = getFunctionalClassKind(declarationDescriptor);
        return functionalClassKind == FunctionClassKind.Function || functionalClassKind == FunctionClassKind.SuspendFunction;
    }

    public static final boolean isBuiltinExtensionFunctionalType(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "");
        return isBuiltinFunctionalType(kotlinType) && isTypeAnnotatedWithExtensionFunctionType(kotlinType);
    }

    private static final boolean isTypeAnnotatedWithExtensionFunctionType(KotlinType kotlinType) {
        return kotlinType.getAnnotations().mo4435findAnnotation(StandardNames.FqNames.extensionFunctionType) != null;
    }

    public static final FunctionClassKind getFunctionalClassKind(DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "");
        if ((declarationDescriptor instanceof ClassDescriptor) && KotlinBuiltIns.isUnderKotlinPackage(declarationDescriptor)) {
            return getFunctionalClassKind(DescriptorUtilsKt.getFqNameUnsafe(declarationDescriptor));
        }
        return null;
    }

    private static final FunctionClassKind getFunctionalClassKind(FqNameUnsafe fqNameUnsafe) {
        if (!fqNameUnsafe.isSafe() || fqNameUnsafe.isRoot()) {
            return null;
        }
        FunctionClassKind.Companion companion = FunctionClassKind.Companion;
        String asString = fqNameUnsafe.shortName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "");
        FqName parent = fqNameUnsafe.toSafe().parent();
        Intrinsics.checkNotNullExpressionValue(parent, "");
        return companion.getFunctionalClassKind(asString, parent);
    }

    public static final int contextFunctionTypeParamsCount(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "");
        AnnotationDescriptor mo4435findAnnotation = kotlinType.getAnnotations().mo4435findAnnotation(StandardNames.FqNames.contextFunctionTypeParams);
        if (mo4435findAnnotation == null) {
            return 0;
        }
        ConstantValue constantValue = (ConstantValue) MapsKt.getValue(mo4435findAnnotation.getAllValueArguments(), StandardNames.CONTEXT_FUNCTION_TYPE_PARAMETER_COUNT_NAME);
        Intrinsics.checkNotNull(constantValue);
        return ((IntValue) constantValue).getValue().intValue();
    }

    public static final KotlinType getReceiverTypeFromFunctionType(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "");
        isBuiltinFunctionalType(kotlinType);
        if (isTypeAnnotatedWithExtensionFunctionType(kotlinType)) {
            return kotlinType.getArguments().get(contextFunctionTypeParamsCount(kotlinType)).getType();
        }
        return null;
    }

    public static final List<KotlinType> getContextReceiverTypesFromFunctionType(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "");
        isBuiltinFunctionalType(kotlinType);
        int contextFunctionTypeParamsCount = contextFunctionTypeParamsCount(kotlinType);
        if (contextFunctionTypeParamsCount == 0) {
            return CollectionsKt.emptyList();
        }
        List<TypeProjection> subList = kotlinType.getArguments().subList(0, contextFunctionTypeParamsCount);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(subList, 10));
        Iterator<T> it = subList.iterator();
        while (it.hasNext()) {
            KotlinType type = ((TypeProjection) it.next()).getType();
            Intrinsics.checkNotNullExpressionValue(type, "");
            arrayList.add(type);
        }
        return arrayList;
    }

    public static final KotlinType getReturnTypeFromFunctionType(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "");
        isBuiltinFunctionalType(kotlinType);
        KotlinType type = ((TypeProjection) CollectionsKt.last((List) kotlinType.getArguments())).getType();
        Intrinsics.checkNotNullExpressionValue(type, "");
        return type;
    }

    public static final List<TypeProjection> getValueParameterTypesFromFunctionType(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "");
        isBuiltinFunctionalType(kotlinType);
        return kotlinType.getArguments().subList(contextFunctionTypeParamsCount(kotlinType) + (isBuiltinExtensionFunctionalType(kotlinType) ? 1 : 0), r0.size() - 1);
    }

    public static final Name extractParameterNameFromFunctionTypeArgument(KotlinType kotlinType) {
        String value;
        Intrinsics.checkNotNullParameter(kotlinType, "");
        AnnotationDescriptor mo4435findAnnotation = kotlinType.getAnnotations().mo4435findAnnotation(StandardNames.FqNames.parameterName);
        if (mo4435findAnnotation == null) {
            return null;
        }
        Object singleOrNull = CollectionsKt.singleOrNull(mo4435findAnnotation.getAllValueArguments().values());
        StringValue stringValue = singleOrNull instanceof StringValue ? (StringValue) singleOrNull : null;
        if (stringValue != null && (value = stringValue.getValue()) != null) {
            if (!Name.isValidIdentifier(value)) {
                value = null;
            }
            if (value != null) {
                return Name.identifier(value);
            }
        }
        return null;
    }

    public static final List<TypeProjection> getFunctionTypeArgumentProjections(KotlinType kotlinType, List<? extends KotlinType> list, List<? extends KotlinType> list2, List<Name> list3, KotlinType kotlinType2, KotlinBuiltIns kotlinBuiltIns) {
        Name name;
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(list2, "");
        Intrinsics.checkNotNullParameter(kotlinType2, "");
        Intrinsics.checkNotNullParameter(kotlinBuiltIns, "");
        int i = 0;
        ArrayList arrayList = new ArrayList(list2.size() + list.size() + (kotlinType != null ? 1 : 0) + 1);
        List<? extends KotlinType> list4 = list;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
        Iterator<T> it = list4.iterator();
        while (it.hasNext()) {
            arrayList2.add(TypeUtilsKt.asTypeProjection((KotlinType) it.next()));
        }
        arrayList.addAll(arrayList2);
        ArrayList arrayList3 = arrayList;
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(arrayList3, kotlinType != null ? TypeUtilsKt.asTypeProjection(kotlinType) : null);
        for (Object obj : list2) {
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            KotlinType kotlinType3 = (KotlinType) obj;
            if (list3 == null || (name = list3.get(i)) == null || name.isSpecial()) {
                name = null;
            }
            if (name != null) {
                FqName fqName = StandardNames.FqNames.parameterName;
                Name identifier = Name.identifier("name");
                String asString = name.asString();
                Intrinsics.checkNotNullExpressionValue(asString, "");
                kotlinType3 = TypeUtilsKt.replaceAnnotations(kotlinType3, Annotations.Companion.create(CollectionsKt.plus(kotlinType3.getAnnotations(), new BuiltInAnnotationDescriptor(kotlinBuiltIns, fqName, MapsKt.mapOf(TuplesKt.to(identifier, new StringValue(asString)))))));
            }
            arrayList3.add(TypeUtilsKt.asTypeProjection(kotlinType3));
            i++;
        }
        arrayList.add(TypeUtilsKt.asTypeProjection(kotlinType2));
        return arrayList;
    }

    public static final SimpleType createFunctionType(KotlinBuiltIns kotlinBuiltIns, Annotations annotations, KotlinType kotlinType, List<? extends KotlinType> list, List<? extends KotlinType> list2, List<Name> list3, KotlinType kotlinType2, boolean z) {
        Intrinsics.checkNotNullParameter(kotlinBuiltIns, "");
        Intrinsics.checkNotNullParameter(annotations, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(list2, "");
        Intrinsics.checkNotNullParameter(kotlinType2, "");
        List<TypeProjection> functionTypeArgumentProjections = getFunctionTypeArgumentProjections(kotlinType, list, list2, list3, kotlinType2, kotlinBuiltIns);
        ClassDescriptor functionDescriptor = getFunctionDescriptor(kotlinBuiltIns, list2.size() + list.size() + (kotlinType == null ? 0 : 1), z);
        if (kotlinType != null) {
            annotations = withExtensionFunctionAnnotation(annotations, kotlinBuiltIns);
        }
        if ((!list.isEmpty()) != false) {
            annotations = withContextReceiversFunctionAnnotation(annotations, kotlinBuiltIns, list.size());
        }
        return KotlinTypeFactory.simpleNotNullType(TypeAttributesKt.toDefaultAttributes(annotations), functionDescriptor, functionTypeArgumentProjections);
    }

    public static final Annotations withExtensionFunctionAnnotation(Annotations annotations, KotlinBuiltIns kotlinBuiltIns) {
        Intrinsics.checkNotNullParameter(annotations, "");
        Intrinsics.checkNotNullParameter(kotlinBuiltIns, "");
        return !annotations.hasAnnotation(StandardNames.FqNames.extensionFunctionType) ? Annotations.Companion.create(CollectionsKt.plus(annotations, new BuiltInAnnotationDescriptor(kotlinBuiltIns, StandardNames.FqNames.extensionFunctionType, MapsKt.emptyMap()))) : annotations;
    }

    public static final Annotations withContextReceiversFunctionAnnotation(Annotations annotations, KotlinBuiltIns kotlinBuiltIns, int i) {
        Intrinsics.checkNotNullParameter(annotations, "");
        Intrinsics.checkNotNullParameter(kotlinBuiltIns, "");
        return !annotations.hasAnnotation(StandardNames.FqNames.contextFunctionTypeParams) ? Annotations.Companion.create(CollectionsKt.plus(annotations, new BuiltInAnnotationDescriptor(kotlinBuiltIns, StandardNames.FqNames.contextFunctionTypeParams, MapsKt.mapOf(TuplesKt.to(StandardNames.CONTEXT_FUNCTION_TYPE_PARAMETER_COUNT_NAME, new IntValue(i)))))) : annotations;
    }

    public static final ClassDescriptor getFunctionDescriptor(KotlinBuiltIns kotlinBuiltIns, int i, boolean z) {
        Intrinsics.checkNotNullParameter(kotlinBuiltIns, "");
        ClassDescriptor suspendFunction = z ? kotlinBuiltIns.getSuspendFunction(i) : kotlinBuiltIns.getFunction(i);
        Intrinsics.checkNotNullExpressionValue(suspendFunction, "");
        return suspendFunction;
    }
}
