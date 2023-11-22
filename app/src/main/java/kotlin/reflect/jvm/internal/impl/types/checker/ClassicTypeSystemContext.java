package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.ModalityUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedType;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
import kotlin.reflect.jvm.internal.impl.types.DynamicType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.NotNullTypeParameter;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SimpleTypeWithEnhancement;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DynamicTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.RawTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContextKt;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemInferenceExtensionContext;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariableTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* loaded from: classes.dex */
public interface ClassicTypeSystemContext extends TypeSystemCommonBackendContext, TypeSystemInferenceExtensionContext {
    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    CapturedTypeMarker asCapturedType(SimpleTypeMarker simpleTypeMarker);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    SimpleTypeMarker asSimpleType(KotlinTypeMarker kotlinTypeMarker);

    KotlinTypeMarker createFlexibleType(SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    boolean isSingleClassifierType(SimpleTypeMarker simpleTypeMarker);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    SimpleTypeMarker lowerBound(FlexibleTypeMarker flexibleTypeMarker);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    TypeConstructorMarker typeConstructor(SimpleTypeMarker simpleTypeMarker);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    SimpleTypeMarker upperBound(FlexibleTypeMarker flexibleTypeMarker);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    SimpleTypeMarker withNullability(SimpleTypeMarker simpleTypeMarker, boolean z);

    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static List<SimpleTypeMarker> fastCorrespondingSupertypes(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker typeConstructorMarker) {
            Intrinsics.checkNotNullParameter(simpleTypeMarker, "");
            Intrinsics.checkNotNullParameter(typeConstructorMarker, "");
            return TypeSystemInferenceExtensionContext.DefaultImpls.fastCorrespondingSupertypes(classicTypeSystemContext, simpleTypeMarker, typeConstructorMarker);
        }

        public static TypeArgumentMarker get(ClassicTypeSystemContext classicTypeSystemContext, TypeArgumentListMarker typeArgumentListMarker, int i) {
            Intrinsics.checkNotNullParameter(typeArgumentListMarker, "");
            return TypeSystemInferenceExtensionContext.DefaultImpls.get(classicTypeSystemContext, typeArgumentListMarker, i);
        }

        public static TypeArgumentMarker getArgumentOrNull(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker, int i) {
            Intrinsics.checkNotNullParameter(simpleTypeMarker, "");
            return TypeSystemInferenceExtensionContext.DefaultImpls.getArgumentOrNull(classicTypeSystemContext, simpleTypeMarker, i);
        }

        public static boolean hasFlexibleNullability(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "");
            return TypeSystemInferenceExtensionContext.DefaultImpls.hasFlexibleNullability(classicTypeSystemContext, kotlinTypeMarker);
        }

        public static boolean isCapturedType(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "");
            return TypeSystemInferenceExtensionContext.DefaultImpls.isCapturedType(classicTypeSystemContext, kotlinTypeMarker);
        }

        public static boolean isClassType(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker) {
            Intrinsics.checkNotNullParameter(simpleTypeMarker, "");
            return TypeSystemInferenceExtensionContext.DefaultImpls.isClassType(classicTypeSystemContext, simpleTypeMarker);
        }

        public static boolean isDefinitelyNotNullType(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "");
            return TypeSystemInferenceExtensionContext.DefaultImpls.isDefinitelyNotNullType(classicTypeSystemContext, kotlinTypeMarker);
        }

        public static boolean isDynamic(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "");
            return TypeSystemInferenceExtensionContext.DefaultImpls.isDynamic(classicTypeSystemContext, kotlinTypeMarker);
        }

        public static boolean isIntegerLiteralType(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker) {
            Intrinsics.checkNotNullParameter(simpleTypeMarker, "");
            return TypeSystemInferenceExtensionContext.DefaultImpls.isIntegerLiteralType(classicTypeSystemContext, simpleTypeMarker);
        }

        public static boolean isMarkedNullable(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "");
            return TypeSystemInferenceExtensionContext.DefaultImpls.isMarkedNullable(classicTypeSystemContext, kotlinTypeMarker);
        }

        public static boolean isNothing(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "");
            return TypeSystemInferenceExtensionContext.DefaultImpls.isNothing(classicTypeSystemContext, kotlinTypeMarker);
        }

        public static SimpleTypeMarker lowerBoundIfFlexible(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "");
            return TypeSystemInferenceExtensionContext.DefaultImpls.lowerBoundIfFlexible(classicTypeSystemContext, kotlinTypeMarker);
        }

        public static KotlinTypeMarker makeNullable(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "");
            return TypeSystemCommonBackendContext.DefaultImpls.makeNullable(classicTypeSystemContext, kotlinTypeMarker);
        }

        public static int size(ClassicTypeSystemContext classicTypeSystemContext, TypeArgumentListMarker typeArgumentListMarker) {
            Intrinsics.checkNotNullParameter(typeArgumentListMarker, "");
            return TypeSystemInferenceExtensionContext.DefaultImpls.size(classicTypeSystemContext, typeArgumentListMarker);
        }

        public static TypeConstructorMarker typeConstructor(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "");
            return TypeSystemInferenceExtensionContext.DefaultImpls.typeConstructor(classicTypeSystemContext, kotlinTypeMarker);
        }

        public static SimpleTypeMarker upperBoundIfFlexible(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "");
            return TypeSystemInferenceExtensionContext.DefaultImpls.upperBoundIfFlexible(classicTypeSystemContext, kotlinTypeMarker);
        }

        public static boolean isDenotable(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
            Intrinsics.checkNotNullParameter(typeConstructorMarker, "");
            if (typeConstructorMarker instanceof TypeConstructor) {
                return ((TypeConstructor) typeConstructorMarker).isDenotable();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(typeConstructorMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static boolean isIntegerLiteralTypeConstructor(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
            Intrinsics.checkNotNullParameter(typeConstructorMarker, "");
            if (typeConstructorMarker instanceof TypeConstructor) {
                return typeConstructorMarker instanceof IntegerLiteralTypeConstructor;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(typeConstructorMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static TypeParameterMarker getTypeParameter(ClassicTypeSystemContext classicTypeSystemContext, TypeVariableTypeConstructorMarker typeVariableTypeConstructorMarker) {
            Intrinsics.checkNotNullParameter(typeVariableTypeConstructorMarker, "");
            if (typeVariableTypeConstructorMarker instanceof NewTypeVariableConstructor) {
                return ((NewTypeVariableConstructor) typeVariableTypeConstructorMarker).getOriginalTypeParameter();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(typeVariableTypeConstructorMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(typeVariableTypeConstructorMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static Collection<KotlinTypeMarker> possibleIntegerTypes(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker) {
            Intrinsics.checkNotNullParameter(simpleTypeMarker, "");
            TypeConstructorMarker typeConstructor = classicTypeSystemContext.typeConstructor(simpleTypeMarker);
            if (typeConstructor instanceof IntegerLiteralTypeConstructor) {
                return ((IntegerLiteralTypeConstructor) typeConstructor).getPossibleTypes();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(simpleTypeMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static SimpleTypeMarker withNullability(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker, boolean z) {
            Intrinsics.checkNotNullParameter(simpleTypeMarker, "");
            if (simpleTypeMarker instanceof SimpleType) {
                return ((SimpleType) simpleTypeMarker).makeNullableAsSpecified(z);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(simpleTypeMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static boolean isError(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "");
            if (kotlinTypeMarker instanceof KotlinType) {
                return KotlinTypeKt.isError((KotlinType) kotlinTypeMarker);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(kotlinTypeMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static boolean isStubType(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker) {
            Intrinsics.checkNotNullParameter(simpleTypeMarker, "");
            if (simpleTypeMarker instanceof SimpleType) {
                return TypeUtilsKt.isStubType((KotlinType) simpleTypeMarker);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(simpleTypeMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static boolean isStubTypeForBuilderInference(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker) {
            Intrinsics.checkNotNullParameter(simpleTypeMarker, "");
            if (simpleTypeMarker instanceof SimpleType) {
                return TypeUtilsKt.isStubTypeForBuilderInference((KotlinType) simpleTypeMarker);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(simpleTypeMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static KotlinTypeMarker lowerType(ClassicTypeSystemContext classicTypeSystemContext, CapturedTypeMarker capturedTypeMarker) {
            Intrinsics.checkNotNullParameter(capturedTypeMarker, "");
            if (capturedTypeMarker instanceof NewCapturedType) {
                return ((NewCapturedType) capturedTypeMarker).getLowerType();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(capturedTypeMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(capturedTypeMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static boolean isIntersection(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
            Intrinsics.checkNotNullParameter(typeConstructorMarker, "");
            if (typeConstructorMarker instanceof TypeConstructor) {
                return typeConstructorMarker instanceof IntersectionTypeConstructor;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(typeConstructorMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static boolean identicalArguments(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
            Intrinsics.checkNotNullParameter(simpleTypeMarker, "");
            Intrinsics.checkNotNullParameter(simpleTypeMarker2, "");
            if (simpleTypeMarker instanceof SimpleType) {
                if (simpleTypeMarker2 instanceof SimpleType) {
                    return ((SimpleType) simpleTypeMarker).getArguments() == ((SimpleType) simpleTypeMarker2).getArguments();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("ClassicTypeSystemContext couldn't handle: ");
                sb.append(simpleTypeMarker2);
                sb.append(", ");
                sb.append(Reflection.getOrCreateKotlinClass(simpleTypeMarker2.getClass()));
                throw new IllegalArgumentException(sb.toString().toString());
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ClassicTypeSystemContext couldn't handle: ");
            sb2.append(simpleTypeMarker);
            sb2.append(", ");
            sb2.append(Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass()));
            throw new IllegalArgumentException(sb2.toString().toString());
        }

        public static SimpleTypeMarker asSimpleType(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "");
            if (kotlinTypeMarker instanceof KotlinType) {
                UnwrappedType unwrap = ((KotlinType) kotlinTypeMarker).unwrap();
                return unwrap instanceof SimpleType ? (SimpleType) unwrap : null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(kotlinTypeMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static FlexibleTypeMarker asFlexibleType(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "");
            if (kotlinTypeMarker instanceof KotlinType) {
                UnwrappedType unwrap = ((KotlinType) kotlinTypeMarker).unwrap();
                return unwrap instanceof FlexibleType ? (FlexibleType) unwrap : null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(kotlinTypeMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static DynamicTypeMarker asDynamicType(ClassicTypeSystemContext classicTypeSystemContext, FlexibleTypeMarker flexibleTypeMarker) {
            Intrinsics.checkNotNullParameter(flexibleTypeMarker, "");
            if (flexibleTypeMarker instanceof FlexibleType) {
                return flexibleTypeMarker instanceof DynamicType ? (DynamicType) flexibleTypeMarker : null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(flexibleTypeMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(flexibleTypeMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static RawTypeMarker asRawType(ClassicTypeSystemContext classicTypeSystemContext, FlexibleTypeMarker flexibleTypeMarker) {
            Intrinsics.checkNotNullParameter(flexibleTypeMarker, "");
            if (flexibleTypeMarker instanceof FlexibleType) {
                return flexibleTypeMarker instanceof RawType ? (RawType) flexibleTypeMarker : null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(flexibleTypeMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(flexibleTypeMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static SimpleTypeMarker upperBound(ClassicTypeSystemContext classicTypeSystemContext, FlexibleTypeMarker flexibleTypeMarker) {
            Intrinsics.checkNotNullParameter(flexibleTypeMarker, "");
            if (flexibleTypeMarker instanceof FlexibleType) {
                return ((FlexibleType) flexibleTypeMarker).getUpperBound();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(flexibleTypeMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(flexibleTypeMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static SimpleTypeMarker lowerBound(ClassicTypeSystemContext classicTypeSystemContext, FlexibleTypeMarker flexibleTypeMarker) {
            Intrinsics.checkNotNullParameter(flexibleTypeMarker, "");
            if (flexibleTypeMarker instanceof FlexibleType) {
                return ((FlexibleType) flexibleTypeMarker).getLowerBound();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(flexibleTypeMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(flexibleTypeMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static CapturedTypeMarker asCapturedType(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker) {
            Intrinsics.checkNotNullParameter(simpleTypeMarker, "");
            if (simpleTypeMarker instanceof SimpleType) {
                if (simpleTypeMarker instanceof SimpleTypeWithEnhancement) {
                    return classicTypeSystemContext.asCapturedType(((SimpleTypeWithEnhancement) simpleTypeMarker).getOrigin());
                }
                return simpleTypeMarker instanceof NewCapturedType ? (NewCapturedType) simpleTypeMarker : null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(simpleTypeMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static DefinitelyNotNullTypeMarker asDefinitelyNotNullType(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker) {
            Intrinsics.checkNotNullParameter(simpleTypeMarker, "");
            if (simpleTypeMarker instanceof SimpleType) {
                return simpleTypeMarker instanceof DefinitelyNotNullType ? (DefinitelyNotNullType) simpleTypeMarker : null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(simpleTypeMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static boolean isNotNullTypeParameter(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "");
            return kotlinTypeMarker instanceof NotNullTypeParameter;
        }

        public static boolean isMarkedNullable(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker) {
            Intrinsics.checkNotNullParameter(simpleTypeMarker, "");
            if (simpleTypeMarker instanceof SimpleType) {
                return ((SimpleType) simpleTypeMarker).isMarkedNullable();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(simpleTypeMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static TypeConstructorMarker typeConstructor(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker) {
            Intrinsics.checkNotNullParameter(simpleTypeMarker, "");
            if (simpleTypeMarker instanceof SimpleType) {
                return ((SimpleType) simpleTypeMarker).getConstructor();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(simpleTypeMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static CapturedTypeConstructorMarker typeConstructor(ClassicTypeSystemContext classicTypeSystemContext, CapturedTypeMarker capturedTypeMarker) {
            Intrinsics.checkNotNullParameter(capturedTypeMarker, "");
            if (capturedTypeMarker instanceof NewCapturedType) {
                return ((NewCapturedType) capturedTypeMarker).getConstructor();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(capturedTypeMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(capturedTypeMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static TypeArgumentMarker projection(ClassicTypeSystemContext classicTypeSystemContext, CapturedTypeConstructorMarker capturedTypeConstructorMarker) {
            Intrinsics.checkNotNullParameter(capturedTypeConstructorMarker, "");
            if (capturedTypeConstructorMarker instanceof NewCapturedTypeConstructor) {
                return ((NewCapturedTypeConstructor) capturedTypeConstructorMarker).getProjection();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(capturedTypeConstructorMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(capturedTypeConstructorMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static int argumentsCount(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "");
            if (kotlinTypeMarker instanceof KotlinType) {
                return ((KotlinType) kotlinTypeMarker).getArguments().size();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(kotlinTypeMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static TypeArgumentMarker getArgument(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker, int i) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "");
            if (kotlinTypeMarker instanceof KotlinType) {
                return ((KotlinType) kotlinTypeMarker).getArguments().get(i);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(kotlinTypeMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static List<TypeArgumentMarker> getArguments(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "");
            if (kotlinTypeMarker instanceof KotlinType) {
                return ((KotlinType) kotlinTypeMarker).getArguments();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(kotlinTypeMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static boolean isStarProjection(ClassicTypeSystemContext classicTypeSystemContext, TypeArgumentMarker typeArgumentMarker) {
            Intrinsics.checkNotNullParameter(typeArgumentMarker, "");
            if (typeArgumentMarker instanceof TypeProjection) {
                return ((TypeProjection) typeArgumentMarker).isStarProjection();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(typeArgumentMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(typeArgumentMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static TypeVariance getVariance(ClassicTypeSystemContext classicTypeSystemContext, TypeArgumentMarker typeArgumentMarker) {
            Intrinsics.checkNotNullParameter(typeArgumentMarker, "");
            if (typeArgumentMarker instanceof TypeProjection) {
                Variance projectionKind = ((TypeProjection) typeArgumentMarker).getProjectionKind();
                Intrinsics.checkNotNullExpressionValue(projectionKind, "");
                return TypeSystemContextKt.convertVariance(projectionKind);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(typeArgumentMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(typeArgumentMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static KotlinTypeMarker getType(ClassicTypeSystemContext classicTypeSystemContext, TypeArgumentMarker typeArgumentMarker) {
            Intrinsics.checkNotNullParameter(typeArgumentMarker, "");
            if (typeArgumentMarker instanceof TypeProjection) {
                return ((TypeProjection) typeArgumentMarker).getType().unwrap();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(typeArgumentMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(typeArgumentMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static int parametersCount(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
            Intrinsics.checkNotNullParameter(typeConstructorMarker, "");
            if (typeConstructorMarker instanceof TypeConstructor) {
                return ((TypeConstructor) typeConstructorMarker).getParameters().size();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(typeConstructorMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static TypeParameterMarker getParameter(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker, int i) {
            Intrinsics.checkNotNullParameter(typeConstructorMarker, "");
            if (typeConstructorMarker instanceof TypeConstructor) {
                TypeParameterDescriptor typeParameterDescriptor = ((TypeConstructor) typeConstructorMarker).getParameters().get(i);
                Intrinsics.checkNotNullExpressionValue(typeParameterDescriptor, "");
                return typeParameterDescriptor;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(typeConstructorMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static List<TypeParameterMarker> getParameters(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
            Intrinsics.checkNotNullParameter(typeConstructorMarker, "");
            if (typeConstructorMarker instanceof TypeConstructor) {
                List<TypeParameterDescriptor> parameters = ((TypeConstructor) typeConstructorMarker).getParameters();
                Intrinsics.checkNotNullExpressionValue(parameters, "");
                return parameters;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(typeConstructorMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static Collection<KotlinTypeMarker> supertypes(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
            Intrinsics.checkNotNullParameter(typeConstructorMarker, "");
            if (typeConstructorMarker instanceof TypeConstructor) {
                Collection<KotlinType> mo4442getSupertypes = ((TypeConstructor) typeConstructorMarker).mo4442getSupertypes();
                Intrinsics.checkNotNullExpressionValue(mo4442getSupertypes, "");
                return mo4442getSupertypes;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(typeConstructorMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static TypeVariance getVariance(ClassicTypeSystemContext classicTypeSystemContext, TypeParameterMarker typeParameterMarker) {
            Intrinsics.checkNotNullParameter(typeParameterMarker, "");
            if (typeParameterMarker instanceof TypeParameterDescriptor) {
                Variance variance = ((TypeParameterDescriptor) typeParameterMarker).getVariance();
                Intrinsics.checkNotNullExpressionValue(variance, "");
                return TypeSystemContextKt.convertVariance(variance);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(typeParameterMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(typeParameterMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static List<KotlinTypeMarker> getUpperBounds(ClassicTypeSystemContext classicTypeSystemContext, TypeParameterMarker typeParameterMarker) {
            Intrinsics.checkNotNullParameter(typeParameterMarker, "");
            if (typeParameterMarker instanceof TypeParameterDescriptor) {
                List<KotlinType> upperBounds = ((TypeParameterDescriptor) typeParameterMarker).getUpperBounds();
                Intrinsics.checkNotNullExpressionValue(upperBounds, "");
                return upperBounds;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(typeParameterMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(typeParameterMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static boolean hasRecursiveBounds(ClassicTypeSystemContext classicTypeSystemContext, TypeParameterMarker typeParameterMarker, TypeConstructorMarker typeConstructorMarker) {
            Intrinsics.checkNotNullParameter(typeParameterMarker, "");
            if (typeParameterMarker instanceof TypeParameterDescriptor) {
                if (typeConstructorMarker == null ? true : typeConstructorMarker instanceof TypeConstructor) {
                    return TypeUtilsKt.hasTypeParameterRecursiveBounds$default((TypeParameterDescriptor) typeParameterMarker, (TypeConstructor) typeConstructorMarker, null, 4, null);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("ClassicTypeSystemContext couldn't handle: ");
                sb.append(typeParameterMarker);
                sb.append(", ");
                sb.append(Reflection.getOrCreateKotlinClass(typeParameterMarker.getClass()));
                throw new IllegalArgumentException(sb.toString().toString());
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ClassicTypeSystemContext couldn't handle: ");
            sb2.append(typeParameterMarker);
            sb2.append(", ");
            sb2.append(Reflection.getOrCreateKotlinClass(typeParameterMarker.getClass()));
            throw new IllegalArgumentException(sb2.toString().toString());
        }

        public static boolean areEqualTypeConstructors(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker, TypeConstructorMarker typeConstructorMarker2) {
            Intrinsics.checkNotNullParameter(typeConstructorMarker, "");
            Intrinsics.checkNotNullParameter(typeConstructorMarker2, "");
            if (typeConstructorMarker instanceof TypeConstructor) {
                if (typeConstructorMarker2 instanceof TypeConstructor) {
                    return Intrinsics.areEqual(typeConstructorMarker, typeConstructorMarker2);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("ClassicTypeSystemContext couldn't handle: ");
                sb.append(typeConstructorMarker2);
                sb.append(", ");
                sb.append(Reflection.getOrCreateKotlinClass(typeConstructorMarker2.getClass()));
                throw new IllegalArgumentException(sb.toString().toString());
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ClassicTypeSystemContext couldn't handle: ");
            sb2.append(typeConstructorMarker);
            sb2.append(", ");
            sb2.append(Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass()));
            throw new IllegalArgumentException(sb2.toString().toString());
        }

        public static boolean isClassTypeConstructor(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
            Intrinsics.checkNotNullParameter(typeConstructorMarker, "");
            if (typeConstructorMarker instanceof TypeConstructor) {
                return ((TypeConstructor) typeConstructorMarker).mo4441getDeclarationDescriptor() instanceof ClassDescriptor;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(typeConstructorMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static boolean isCommonFinalClassConstructor(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
            Intrinsics.checkNotNullParameter(typeConstructorMarker, "");
            if (typeConstructorMarker instanceof TypeConstructor) {
                ClassifierDescriptor mo4441getDeclarationDescriptor = ((TypeConstructor) typeConstructorMarker).mo4441getDeclarationDescriptor();
                ClassDescriptor classDescriptor = mo4441getDeclarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) mo4441getDeclarationDescriptor : null;
                return (classDescriptor == null || !ModalityUtilsKt.isFinalClass(classDescriptor) || classDescriptor.getKind() == ClassKind.ENUM_ENTRY || classDescriptor.getKind() == ClassKind.ANNOTATION_CLASS) ? false : true;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(typeConstructorMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static TypeArgumentListMarker asArgumentList(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker) {
            Intrinsics.checkNotNullParameter(simpleTypeMarker, "");
            if (simpleTypeMarker instanceof SimpleType) {
                return (TypeArgumentListMarker) simpleTypeMarker;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(simpleTypeMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static SimpleTypeMarker captureFromArguments(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker, CaptureStatus captureStatus) {
            Intrinsics.checkNotNullParameter(simpleTypeMarker, "");
            Intrinsics.checkNotNullParameter(captureStatus, "");
            if (simpleTypeMarker instanceof SimpleType) {
                return NewCapturedTypeKt.captureFromArguments((SimpleType) simpleTypeMarker, captureStatus);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(simpleTypeMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static boolean isAnyConstructor(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
            Intrinsics.checkNotNullParameter(typeConstructorMarker, "");
            if (typeConstructorMarker instanceof TypeConstructor) {
                return KotlinBuiltIns.isTypeConstructorForGivenClass((TypeConstructor) typeConstructorMarker, StandardNames.FqNames.any);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(typeConstructorMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static boolean isNothingConstructor(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
            Intrinsics.checkNotNullParameter(typeConstructorMarker, "");
            if (typeConstructorMarker instanceof TypeConstructor) {
                return KotlinBuiltIns.isTypeConstructorForGivenClass((TypeConstructor) typeConstructorMarker, StandardNames.FqNames.nothing);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(typeConstructorMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static TypeArgumentMarker asTypeArgument(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "");
            if (kotlinTypeMarker instanceof KotlinType) {
                return TypeUtilsKt.asTypeProjection((KotlinType) kotlinTypeMarker);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(kotlinTypeMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static boolean isSingleClassifierType(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker) {
            Intrinsics.checkNotNullParameter(simpleTypeMarker, "");
            if (simpleTypeMarker instanceof SimpleType) {
                if (!KotlinTypeKt.isError((KotlinType) simpleTypeMarker)) {
                    SimpleType simpleType = (SimpleType) simpleTypeMarker;
                    if (!(simpleType.getConstructor().mo4441getDeclarationDescriptor() instanceof TypeAliasDescriptor) && (simpleType.getConstructor().mo4441getDeclarationDescriptor() != null || (simpleTypeMarker instanceof CapturedType) || (simpleTypeMarker instanceof NewCapturedType) || (simpleTypeMarker instanceof DefinitelyNotNullType) || (simpleType.getConstructor() instanceof IntegerLiteralTypeConstructor) || isSingleClassifierTypeWithEnhancement(classicTypeSystemContext, simpleTypeMarker))) {
                        return true;
                    }
                }
                return false;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(simpleTypeMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        private static boolean isSingleClassifierTypeWithEnhancement(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker) {
            return (simpleTypeMarker instanceof SimpleTypeWithEnhancement) && classicTypeSystemContext.isSingleClassifierType(((SimpleTypeWithEnhancement) simpleTypeMarker).getOrigin());
        }

        public static KotlinTypeMarker intersectTypes(ClassicTypeSystemContext classicTypeSystemContext, List<? extends KotlinTypeMarker> list) {
            Intrinsics.checkNotNullParameter(list, "");
            return IntersectionTypeKt.intersectTypes(list);
        }

        public static KotlinTypeMarker createFlexibleType(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
            Intrinsics.checkNotNullParameter(simpleTypeMarker, "");
            Intrinsics.checkNotNullParameter(simpleTypeMarker2, "");
            if (simpleTypeMarker instanceof SimpleType) {
                if (simpleTypeMarker2 instanceof SimpleType) {
                    return KotlinTypeFactory.flexibleType((SimpleType) simpleTypeMarker, (SimpleType) simpleTypeMarker2);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("ClassicTypeSystemContext couldn't handle: ");
                sb.append(classicTypeSystemContext);
                sb.append(", ");
                sb.append(Reflection.getOrCreateKotlinClass(classicTypeSystemContext.getClass()));
                throw new IllegalArgumentException(sb.toString().toString());
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ClassicTypeSystemContext couldn't handle: ");
            sb2.append(classicTypeSystemContext);
            sb2.append(", ");
            sb2.append(Reflection.getOrCreateKotlinClass(classicTypeSystemContext.getClass()));
            throw new IllegalArgumentException(sb2.toString().toString());
        }

        public static KotlinTypeMarker withNullability(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker, boolean z) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "");
            if (kotlinTypeMarker instanceof SimpleTypeMarker) {
                return classicTypeSystemContext.withNullability((SimpleTypeMarker) kotlinTypeMarker, z);
            }
            if (kotlinTypeMarker instanceof FlexibleTypeMarker) {
                FlexibleTypeMarker flexibleTypeMarker = (FlexibleTypeMarker) kotlinTypeMarker;
                return classicTypeSystemContext.createFlexibleType(classicTypeSystemContext.withNullability(classicTypeSystemContext.lowerBound(flexibleTypeMarker), z), classicTypeSystemContext.withNullability(classicTypeSystemContext.upperBound(flexibleTypeMarker), z));
            }
            throw new IllegalStateException("sealed".toString());
        }

        public static TypeCheckerState newTypeCheckerState(ClassicTypeSystemContext classicTypeSystemContext, boolean z, boolean z2) {
            return ClassicTypeCheckerStateKt.createClassicTypeCheckerState$default(z, z2, classicTypeSystemContext, null, null, 24, null);
        }

        public static KotlinTypeMarker makeDefinitelyNotNullOrNotNull(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            UnwrappedType makeDefinitelyNotNullOrNotNullInternal;
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "");
            if (kotlinTypeMarker instanceof UnwrappedType) {
                makeDefinitelyNotNullOrNotNullInternal = ClassicTypeSystemContextKt.makeDefinitelyNotNullOrNotNullInternal((UnwrappedType) kotlinTypeMarker);
                return makeDefinitelyNotNullOrNotNullInternal;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(kotlinTypeMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static boolean isProjectionNotNull(ClassicTypeSystemContext classicTypeSystemContext, CapturedTypeMarker capturedTypeMarker) {
            Intrinsics.checkNotNullParameter(capturedTypeMarker, "");
            if (capturedTypeMarker instanceof NewCapturedType) {
                return ((NewCapturedType) capturedTypeMarker).isProjectionNotNull();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(capturedTypeMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(capturedTypeMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static CaptureStatus captureStatus(ClassicTypeSystemContext classicTypeSystemContext, CapturedTypeMarker capturedTypeMarker) {
            Intrinsics.checkNotNullParameter(capturedTypeMarker, "");
            if (capturedTypeMarker instanceof NewCapturedType) {
                return ((NewCapturedType) capturedTypeMarker).getCaptureStatus();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(capturedTypeMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(capturedTypeMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static boolean isOldCapturedType(ClassicTypeSystemContext classicTypeSystemContext, CapturedTypeMarker capturedTypeMarker) {
            Intrinsics.checkNotNullParameter(capturedTypeMarker, "");
            return capturedTypeMarker instanceof CapturedType;
        }

        public static boolean isNullableType(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "");
            if (kotlinTypeMarker instanceof KotlinType) {
                return TypeUtils.isNullableType((KotlinType) kotlinTypeMarker);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(kotlinTypeMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static SimpleTypeMarker original(ClassicTypeSystemContext classicTypeSystemContext, DefinitelyNotNullTypeMarker definitelyNotNullTypeMarker) {
            Intrinsics.checkNotNullParameter(definitelyNotNullTypeMarker, "");
            if (definitelyNotNullTypeMarker instanceof DefinitelyNotNullType) {
                return ((DefinitelyNotNullType) definitelyNotNullTypeMarker).getOriginal();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(definitelyNotNullTypeMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(definitelyNotNullTypeMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static boolean isPrimitiveType(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker) {
            Intrinsics.checkNotNullParameter(simpleTypeMarker, "");
            if (simpleTypeMarker instanceof KotlinType) {
                return KotlinBuiltIns.isPrimitiveType((KotlinType) simpleTypeMarker);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(simpleTypeMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static boolean hasAnnotation(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker, FqName fqName) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "");
            Intrinsics.checkNotNullParameter(fqName, "");
            if (kotlinTypeMarker instanceof KotlinType) {
                return ((KotlinType) kotlinTypeMarker).getAnnotations().hasAnnotation(fqName);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(kotlinTypeMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static TypeParameterMarker getTypeParameterClassifier(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
            Intrinsics.checkNotNullParameter(typeConstructorMarker, "");
            if (typeConstructorMarker instanceof TypeConstructor) {
                ClassifierDescriptor mo4441getDeclarationDescriptor = ((TypeConstructor) typeConstructorMarker).mo4441getDeclarationDescriptor();
                return mo4441getDeclarationDescriptor instanceof TypeParameterDescriptor ? (TypeParameterDescriptor) mo4441getDeclarationDescriptor : null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(typeConstructorMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static boolean isInlineClass(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
            Intrinsics.checkNotNullParameter(typeConstructorMarker, "");
            if (typeConstructorMarker instanceof TypeConstructor) {
                ClassifierDescriptor mo4441getDeclarationDescriptor = ((TypeConstructor) typeConstructorMarker).mo4441getDeclarationDescriptor();
                ClassDescriptor classDescriptor = mo4441getDeclarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) mo4441getDeclarationDescriptor : null;
                return (classDescriptor != null ? classDescriptor.getValueClassRepresentation() : null) instanceof InlineClassRepresentation;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(typeConstructorMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static KotlinTypeMarker getRepresentativeUpperBound(ClassicTypeSystemContext classicTypeSystemContext, TypeParameterMarker typeParameterMarker) {
            Intrinsics.checkNotNullParameter(typeParameterMarker, "");
            if (typeParameterMarker instanceof TypeParameterDescriptor) {
                return TypeUtilsKt.getRepresentativeUpperBound((TypeParameterDescriptor) typeParameterMarker);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(typeParameterMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(typeParameterMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static KotlinTypeMarker getUnsubstitutedUnderlyingType(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "");
            if (kotlinTypeMarker instanceof KotlinType) {
                return InlineClassesUtilsKt.unsubstitutedUnderlyingType((KotlinType) kotlinTypeMarker);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(kotlinTypeMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static PrimitiveType getPrimitiveType(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
            Intrinsics.checkNotNullParameter(typeConstructorMarker, "");
            if (typeConstructorMarker instanceof TypeConstructor) {
                ClassifierDescriptor mo4441getDeclarationDescriptor = ((TypeConstructor) typeConstructorMarker).mo4441getDeclarationDescriptor();
                Intrinsics.checkNotNull(mo4441getDeclarationDescriptor);
                return KotlinBuiltIns.getPrimitiveType((ClassDescriptor) mo4441getDeclarationDescriptor);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(typeConstructorMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static PrimitiveType getPrimitiveArrayType(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
            Intrinsics.checkNotNullParameter(typeConstructorMarker, "");
            if (typeConstructorMarker instanceof TypeConstructor) {
                ClassifierDescriptor mo4441getDeclarationDescriptor = ((TypeConstructor) typeConstructorMarker).mo4441getDeclarationDescriptor();
                Intrinsics.checkNotNull(mo4441getDeclarationDescriptor);
                return KotlinBuiltIns.getPrimitiveArrayType((ClassDescriptor) mo4441getDeclarationDescriptor);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(typeConstructorMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static boolean isUnderKotlinPackage(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
            Intrinsics.checkNotNullParameter(typeConstructorMarker, "");
            if (typeConstructorMarker instanceof TypeConstructor) {
                ClassifierDescriptor mo4441getDeclarationDescriptor = ((TypeConstructor) typeConstructorMarker).mo4441getDeclarationDescriptor();
                return mo4441getDeclarationDescriptor != null && KotlinBuiltIns.isUnderKotlinPackage(mo4441getDeclarationDescriptor);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(typeConstructorMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static FqNameUnsafe getClassFqNameUnsafe(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
            Intrinsics.checkNotNullParameter(typeConstructorMarker, "");
            if (typeConstructorMarker instanceof TypeConstructor) {
                ClassifierDescriptor mo4441getDeclarationDescriptor = ((TypeConstructor) typeConstructorMarker).mo4441getDeclarationDescriptor();
                Intrinsics.checkNotNull(mo4441getDeclarationDescriptor);
                return DescriptorUtilsKt.getFqNameUnsafe((ClassDescriptor) mo4441getDeclarationDescriptor);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(typeConstructorMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static TypeCheckerState.SupertypesPolicy substitutionSupertypePolicy(final ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker) {
            Intrinsics.checkNotNullParameter(simpleTypeMarker, "");
            if (simpleTypeMarker instanceof SimpleType) {
                final TypeSubstitutor buildSubstitutor = TypeConstructorSubstitution.Companion.create((KotlinType) simpleTypeMarker).buildSubstitutor();
                return new TypeCheckerState.SupertypesPolicy.DoCustomTransform() { // from class: kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext$substitutionSupertypePolicy$2
                    @Override // kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy
                    /* renamed from: transformType */
                    public final SimpleTypeMarker mo4449transformType(TypeCheckerState typeCheckerState, KotlinTypeMarker kotlinTypeMarker) {
                        Intrinsics.checkNotNullParameter(typeCheckerState, "");
                        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "");
                        ClassicTypeSystemContext classicTypeSystemContext2 = ClassicTypeSystemContext.this;
                        TypeSubstitutor typeSubstitutor = buildSubstitutor;
                        SimpleTypeMarker lowerBoundIfFlexible = classicTypeSystemContext2.lowerBoundIfFlexible(kotlinTypeMarker);
                        Intrinsics.checkNotNull(lowerBoundIfFlexible);
                        KotlinType safeSubstitute = typeSubstitutor.safeSubstitute((KotlinType) lowerBoundIfFlexible, Variance.INVARIANT);
                        Intrinsics.checkNotNullExpressionValue(safeSubstitute, "");
                        SimpleTypeMarker asSimpleType = classicTypeSystemContext2.asSimpleType(safeSubstitute);
                        Intrinsics.checkNotNull(asSimpleType);
                        return asSimpleType;
                    }
                };
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ClassicTypeSystemContext couldn't handle: ");
            sb.append(simpleTypeMarker);
            sb.append(", ");
            sb.append(Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass()));
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public static boolean isTypeVariableType(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "");
            return (kotlinTypeMarker instanceof UnwrappedType) && (((UnwrappedType) kotlinTypeMarker).getConstructor() instanceof NewTypeVariableConstructor);
        }
    }
}
