package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifier;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypesKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* loaded from: classes.dex */
public final class JavaTypeResolver {
    private final LazyJavaResolverContext c;
    private final RawSubstitution rawSubstitution;
    private final TypeParameterResolver typeParameterResolver;
    private final TypeParameterUpperBoundEraser typeParameterUpperBoundEraser;

    /* JADX WARN: Type inference failed for: r3v1, types: [kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawSubstitution, kotlin.jvm.internal.DefaultConstructorMarker] */
    public JavaTypeResolver(LazyJavaResolverContext lazyJavaResolverContext, TypeParameterResolver typeParameterResolver) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "");
        Intrinsics.checkNotNullParameter(typeParameterResolver, "");
        this.c = lazyJavaResolverContext;
        this.typeParameterResolver = typeParameterResolver;
        ?? r3 = 0;
        TypeParameterUpperBoundEraser typeParameterUpperBoundEraser = new TypeParameterUpperBoundEraser(r3, 1, r3);
        this.typeParameterUpperBoundEraser = typeParameterUpperBoundEraser;
        this.rawSubstitution = new RawSubstitution(typeParameterUpperBoundEraser);
    }

    public final KotlinType transformJavaType(JavaType javaType, JavaTypeAttributes javaTypeAttributes) {
        KotlinType transformJavaType;
        SimpleType unitType;
        Intrinsics.checkNotNullParameter(javaTypeAttributes, "");
        if (javaType instanceof JavaPrimitiveType) {
            PrimitiveType type = ((JavaPrimitiveType) javaType).getType();
            if (type != null) {
                unitType = this.c.getModule().getBuiltIns().getPrimitiveKotlinType(type);
            } else {
                unitType = this.c.getModule().getBuiltIns().getUnitType();
            }
            Intrinsics.checkNotNullExpressionValue(unitType, "");
            return unitType;
        } else if (javaType instanceof JavaClassifierType) {
            return transformJavaClassifierType((JavaClassifierType) javaType, javaTypeAttributes);
        } else {
            if (javaType instanceof JavaArrayType) {
                return transformArrayType$default(this, (JavaArrayType) javaType, javaTypeAttributes, false, 4, null);
            }
            if (javaType instanceof JavaWildcardType) {
                JavaType bound = ((JavaWildcardType) javaType).getBound();
                if (bound == null || (transformJavaType = transformJavaType(bound, javaTypeAttributes)) == null) {
                    SimpleType defaultBound = this.c.getModule().getBuiltIns().getDefaultBound();
                    Intrinsics.checkNotNullExpressionValue(defaultBound, "");
                    return defaultBound;
                }
                return transformJavaType;
            } else if (javaType == null) {
                SimpleType defaultBound2 = this.c.getModule().getBuiltIns().getDefaultBound();
                Intrinsics.checkNotNullExpressionValue(defaultBound2, "");
                return defaultBound2;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Unsupported type: ");
                sb.append(javaType);
                throw new UnsupportedOperationException(sb.toString());
            }
        }
    }

    public static /* synthetic */ KotlinType transformArrayType$default(JavaTypeResolver javaTypeResolver, JavaArrayType javaArrayType, JavaTypeAttributes javaTypeAttributes, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return javaTypeResolver.transformArrayType(javaArrayType, javaTypeAttributes, z);
    }

    public final KotlinType transformArrayType(JavaArrayType javaArrayType, JavaTypeAttributes javaTypeAttributes, boolean z) {
        Intrinsics.checkNotNullParameter(javaArrayType, "");
        Intrinsics.checkNotNullParameter(javaTypeAttributes, "");
        JavaType componentType = javaArrayType.getComponentType();
        JavaPrimitiveType javaPrimitiveType = componentType instanceof JavaPrimitiveType ? (JavaPrimitiveType) componentType : null;
        PrimitiveType type = javaPrimitiveType != null ? javaPrimitiveType.getType() : null;
        LazyJavaAnnotations lazyJavaAnnotations = new LazyJavaAnnotations(this.c, javaArrayType, true);
        if (type != null) {
            SimpleType primitiveArrayKotlinType = this.c.getModule().getBuiltIns().getPrimitiveArrayKotlinType(type);
            Intrinsics.checkNotNullExpressionValue(primitiveArrayKotlinType, "");
            SimpleType simpleType = primitiveArrayKotlinType;
            TypeUtilsKt.replaceAnnotations(simpleType, Annotations.Companion.create(CollectionsKt.plus((Iterable) lazyJavaAnnotations, (Iterable) primitiveArrayKotlinType.getAnnotations())));
            return !javaTypeAttributes.isForAnnotationParameter() ? KotlinTypeFactory.flexibleType(primitiveArrayKotlinType, primitiveArrayKotlinType.makeNullableAsSpecified(true)) : simpleType;
        }
        KotlinType transformJavaType = transformJavaType(componentType, JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, javaTypeAttributes.isForAnnotationParameter(), null, 2, null));
        if (javaTypeAttributes.isForAnnotationParameter()) {
            SimpleType arrayType = this.c.getModule().getBuiltIns().getArrayType(z ? Variance.OUT_VARIANCE : Variance.INVARIANT, transformJavaType, lazyJavaAnnotations);
            Intrinsics.checkNotNullExpressionValue(arrayType, "");
            return arrayType;
        }
        LazyJavaAnnotations lazyJavaAnnotations2 = lazyJavaAnnotations;
        SimpleType arrayType2 = this.c.getModule().getBuiltIns().getArrayType(Variance.INVARIANT, transformJavaType, lazyJavaAnnotations2);
        Intrinsics.checkNotNullExpressionValue(arrayType2, "");
        return KotlinTypeFactory.flexibleType(arrayType2, this.c.getModule().getBuiltIns().getArrayType(Variance.OUT_VARIANCE, transformJavaType, lazyJavaAnnotations2).makeNullableAsSpecified(true));
    }

    private static final ErrorType transformJavaClassifierType$errorType(JavaClassifierType javaClassifierType) {
        return ErrorUtils.createErrorType(ErrorTypeKind.UNRESOLVED_JAVA_CLASS, javaClassifierType.getPresentableText());
    }

    private final KotlinType transformJavaClassifierType(JavaClassifierType javaClassifierType, JavaTypeAttributes javaTypeAttributes) {
        boolean z = (javaTypeAttributes.isForAnnotationParameter() || javaTypeAttributes.getHowThisTypeIsUsed() == TypeUsage.SUPERTYPE) ? false : true;
        boolean isRaw = javaClassifierType.isRaw();
        if (!isRaw && !z) {
            SimpleType computeSimpleJavaClassifierType = computeSimpleJavaClassifierType(javaClassifierType, javaTypeAttributes, null);
            return computeSimpleJavaClassifierType != null ? computeSimpleJavaClassifierType : transformJavaClassifierType$errorType(javaClassifierType);
        }
        SimpleType computeSimpleJavaClassifierType2 = computeSimpleJavaClassifierType(javaClassifierType, javaTypeAttributes.withFlexibility(JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND), null);
        if (computeSimpleJavaClassifierType2 == null) {
            return transformJavaClassifierType$errorType(javaClassifierType);
        }
        SimpleType computeSimpleJavaClassifierType3 = computeSimpleJavaClassifierType(javaClassifierType, javaTypeAttributes.withFlexibility(JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND), computeSimpleJavaClassifierType2);
        if (computeSimpleJavaClassifierType3 == null) {
            return transformJavaClassifierType$errorType(javaClassifierType);
        }
        if (isRaw) {
            return new RawTypeImpl(computeSimpleJavaClassifierType2, computeSimpleJavaClassifierType3);
        }
        return KotlinTypeFactory.flexibleType(computeSimpleJavaClassifierType2, computeSimpleJavaClassifierType3);
    }

    private final SimpleType computeSimpleJavaClassifierType(JavaClassifierType javaClassifierType, JavaTypeAttributes javaTypeAttributes, SimpleType simpleType) {
        TypeAttributes defaultAttributes;
        if (simpleType == null || (defaultAttributes = simpleType.getAttributes()) == null) {
            defaultAttributes = TypeAttributesKt.toDefaultAttributes(new LazyJavaAnnotations(this.c, javaClassifierType, false, 4, null));
        }
        TypeAttributes typeAttributes = defaultAttributes;
        TypeConstructor computeTypeConstructor = computeTypeConstructor(javaClassifierType, javaTypeAttributes);
        if (computeTypeConstructor == null) {
            return null;
        }
        boolean isNullable = isNullable(javaTypeAttributes);
        if (Intrinsics.areEqual(simpleType != null ? simpleType.getConstructor() : null, computeTypeConstructor) && !javaClassifierType.isRaw() && isNullable) {
            return simpleType.makeNullableAsSpecified(true);
        }
        return KotlinTypeFactory.simpleType$default(typeAttributes, computeTypeConstructor, computeArguments(javaClassifierType, javaTypeAttributes, computeTypeConstructor), isNullable, (KotlinTypeRefiner) null, 16, (Object) null);
    }

    private final TypeConstructor computeTypeConstructor(JavaClassifierType javaClassifierType, JavaTypeAttributes javaTypeAttributes) {
        TypeConstructor typeConstructor;
        JavaClassifier classifier = javaClassifierType.getClassifier();
        if (classifier == null) {
            return createNotFoundClass(javaClassifierType);
        }
        if (classifier instanceof JavaClass) {
            JavaClass javaClass = (JavaClass) classifier;
            FqName fqName = javaClass.getFqName();
            if (fqName == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Class type should have a FQ name: ");
                sb.append(classifier);
                throw new AssertionError(sb.toString());
            }
            ClassDescriptor mapKotlinClass = mapKotlinClass(javaClassifierType, javaTypeAttributes, fqName);
            if (mapKotlinClass == null) {
                mapKotlinClass = this.c.getComponents().getModuleClassResolver().resolveClass(javaClass);
            }
            return (mapKotlinClass == null || (typeConstructor = mapKotlinClass.getTypeConstructor()) == null) ? createNotFoundClass(javaClassifierType) : typeConstructor;
        } else if (classifier instanceof JavaTypeParameter) {
            TypeParameterDescriptor resolveTypeParameter = this.typeParameterResolver.resolveTypeParameter((JavaTypeParameter) classifier);
            if (resolveTypeParameter != null) {
                return resolveTypeParameter.getTypeConstructor();
            }
            return null;
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unknown classifier kind: ");
            sb2.append(classifier);
            throw new IllegalStateException(sb2.toString());
        }
    }

    private final TypeConstructor createNotFoundClass(JavaClassifierType javaClassifierType) {
        ClassId classId = ClassId.topLevel(new FqName(javaClassifierType.getClassifierQualifiedName()));
        Intrinsics.checkNotNullExpressionValue(classId, "");
        TypeConstructor typeConstructor = this.c.getComponents().getDeserializedDescriptorResolver().getComponents().getNotFoundClasses().getClass(classId, CollectionsKt.listOf(0)).getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor, "");
        return typeConstructor;
    }

    private final ClassDescriptor mapKotlinClass(JavaClassifierType javaClassifierType, JavaTypeAttributes javaTypeAttributes, FqName fqName) {
        FqName fqName2;
        if (javaTypeAttributes.isForAnnotationParameter()) {
            fqName2 = JavaTypeResolverKt.JAVA_LANG_CLASS_FQ_NAME;
            if (Intrinsics.areEqual(fqName, fqName2)) {
                return this.c.getComponents().getReflectionTypes().getKClass();
            }
        }
        JavaToKotlinClassMapper javaToKotlinClassMapper = JavaToKotlinClassMapper.INSTANCE;
        ClassDescriptor mapJavaToKotlin$default = JavaToKotlinClassMapper.mapJavaToKotlin$default(javaToKotlinClassMapper, fqName, this.c.getModule().getBuiltIns(), null, 4, null);
        if (mapJavaToKotlin$default == null) {
            return null;
        }
        return (javaToKotlinClassMapper.isReadOnly(mapJavaToKotlin$default) && (javaTypeAttributes.getFlexibility() == JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND || javaTypeAttributes.getHowThisTypeIsUsed() == TypeUsage.SUPERTYPE || argumentsMakeSenseOnlyForMutableContainer(javaClassifierType, mapJavaToKotlin$default))) ? javaToKotlinClassMapper.convertReadOnlyToMutable(mapJavaToKotlin$default) : mapJavaToKotlin$default;
    }

    private final boolean argumentsMakeSenseOnlyForMutableContainer(JavaClassifierType javaClassifierType, ClassDescriptor classDescriptor) {
        Variance variance;
        if (JavaTypesKt.isSuperWildcard((JavaType) CollectionsKt.lastOrNull((List) javaClassifierType.getTypeArguments()))) {
            List<TypeParameterDescriptor> parameters = JavaToKotlinClassMapper.INSTANCE.convertReadOnlyToMutable(classDescriptor).getTypeConstructor().getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "");
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) CollectionsKt.lastOrNull((List) parameters);
            return (typeParameterDescriptor == null || (variance = typeParameterDescriptor.getVariance()) == null || variance == Variance.OUT_VARIANCE) ? false : true;
        }
        return false;
    }

    private final List<TypeProjection> computeRawTypeArguments(final JavaClassifierType javaClassifierType, List<? extends TypeParameterDescriptor> list, final TypeConstructor typeConstructor, final JavaTypeAttributes javaTypeAttributes) {
        TypeProjection computeProjection;
        List<? extends TypeParameterDescriptor> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (final TypeParameterDescriptor typeParameterDescriptor : list2) {
            if (TypeUtilsKt.hasTypeParameterRecursiveBounds(typeParameterDescriptor, null, javaTypeAttributes.getVisitedTypeParameters())) {
                computeProjection = JavaTypeResolverKt.makeStarProjection(typeParameterDescriptor, javaTypeAttributes);
            } else {
                computeProjection = this.rawSubstitution.computeProjection(typeParameterDescriptor, javaClassifierType.isRaw() ? javaTypeAttributes : javaTypeAttributes.withFlexibility(JavaTypeFlexibility.INFLEXIBLE), new LazyWrappedType(this.c.getStorageManager(), new Function0<KotlinType>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver$computeRawTypeArguments$1$erasedUpperBound$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        JavaTypeResolver.this = this;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final KotlinType invoke() {
                        TypeParameterUpperBoundEraser typeParameterUpperBoundEraser;
                        typeParameterUpperBoundEraser = JavaTypeResolver.this.typeParameterUpperBoundEraser;
                        TypeParameterDescriptor typeParameterDescriptor2 = typeParameterDescriptor;
                        boolean isRaw = javaClassifierType.isRaw();
                        JavaTypeAttributes javaTypeAttributes2 = javaTypeAttributes;
                        ClassifierDescriptor mo4441getDeclarationDescriptor = typeConstructor.mo4441getDeclarationDescriptor();
                        KotlinType erasedUpperBound$descriptors_jvm = typeParameterUpperBoundEraser.getErasedUpperBound$descriptors_jvm(typeParameterDescriptor2, isRaw, javaTypeAttributes2.withDefaultType(mo4441getDeclarationDescriptor != null ? mo4441getDeclarationDescriptor.getDefaultType() : null));
                        Intrinsics.checkNotNullExpressionValue(erasedUpperBound$descriptors_jvm, "");
                        return erasedUpperBound$descriptors_jvm;
                    }
                }));
            }
            arrayList.add(computeProjection);
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:127:0x0022, code lost:
    
        if ((!r0.isEmpty()) == false) goto L128;
     */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.List<kotlin.reflect.jvm.internal.impl.types.TypeProjection> computeArguments(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType r8, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes r9, kotlin.reflect.jvm.internal.impl.types.TypeConstructor r10) {
        /*
            r7 = this;
            boolean r0 = r8.isRaw()
            r1 = 0
            r2 = 1
            java.lang.String r3 = ""
            if (r0 != 0) goto L26
            java.util.List r0 = r8.getTypeArguments()
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L24
            java.util.List r0 = r10.getParameters()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r2
            if (r0 != 0) goto L26
        L24:
            r0 = 0
            goto L27
        L26:
            r0 = 1
        L27:
            java.util.List r4 = r10.getParameters()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r3)
            if (r0 == 0) goto L35
            java.util.List r8 = r7.computeRawTypeArguments(r8, r4, r10, r9)
            return r8
        L35:
            int r9 = r4.size()
            java.util.List r10 = r8.getTypeArguments()
            int r10 = r10.size()
            r0 = 10
            if (r9 == r10) goto L8b
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.ArrayList r8 = new java.util.ArrayList
            int r9 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r4, r0)
            r8.<init>(r9)
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r9 = r4.iterator()
        L56:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L82
            java.lang.Object r10 = r9.next()
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r10 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r10
            kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind r0 = kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind.MISSED_TYPE_ARGUMENT_FOR_TYPE_PARAMETER
            java.lang.String[] r4 = new java.lang.String[r2]
            kotlin.reflect.jvm.internal.impl.name.Name r10 = r10.getName()
            java.lang.String r10 = r10.asString()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r3)
            r4[r1] = r10
            kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl r10 = new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl
            kotlin.reflect.jvm.internal.impl.types.error.ErrorType r0 = kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.createErrorType(r0, r4)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r0
            r10.<init>(r0)
            r8.add(r10)
            goto L56
        L82:
            java.util.List r8 = (java.util.List) r8
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.List r8 = kotlin.collections.CollectionsKt.toList(r8)
            return r8
        L8b:
            java.util.List r8 = r8.getTypeArguments()
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.lang.Iterable r8 = kotlin.collections.CollectionsKt.withIndex(r8)
            java.util.ArrayList r9 = new java.util.ArrayList
            int r10 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r8, r0)
            r9.<init>(r10)
            java.util.Collection r9 = (java.util.Collection) r9
            java.util.Iterator r8 = r8.iterator()
        La4:
            boolean r10 = r8.hasNext()
            if (r10 == 0) goto Ld6
            java.lang.Object r10 = r8.next()
            kotlin.collections.IndexedValue r10 = (kotlin.collections.IndexedValue) r10
            int r0 = r10.getIndex()
            java.lang.Object r10 = r10.component2()
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType r10 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType) r10
            r4.size()
            java.lang.Object r0 = r4.get(r0)
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r0
            kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage r2 = kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage.COMMON
            r5 = 3
            r6 = 0
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes r2 = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt.toAttributes$default(r2, r1, r6, r5, r6)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r10 = r7.transformToTypeProjection(r10, r2, r0)
            r9.add(r10)
            goto La4
        Ld6:
            java.util.List r9 = (java.util.List) r9
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.List r8 = kotlin.collections.CollectionsKt.toList(r9)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver.computeArguments(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes, kotlin.reflect.jvm.internal.impl.types.TypeConstructor):java.util.List");
    }

    private final TypeProjection transformToTypeProjection(JavaType javaType, JavaTypeAttributes javaTypeAttributes, TypeParameterDescriptor typeParameterDescriptor) {
        if (javaType instanceof JavaWildcardType) {
            JavaWildcardType javaWildcardType = (JavaWildcardType) javaType;
            JavaType bound = javaWildcardType.getBound();
            Variance variance = javaWildcardType.isExtends() ? Variance.OUT_VARIANCE : Variance.IN_VARIANCE;
            if (bound == null || isConflictingArgumentFor(variance, typeParameterDescriptor)) {
                return JavaTypeResolverKt.makeStarProjection(typeParameterDescriptor, javaTypeAttributes);
            }
            return TypeUtilsKt.createProjection(transformJavaType(bound, JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, false, null, 3, null)), variance, typeParameterDescriptor);
        }
        return new TypeProjectionImpl(Variance.INVARIANT, transformJavaType(javaType, javaTypeAttributes));
    }

    private final boolean isConflictingArgumentFor(Variance variance, TypeParameterDescriptor typeParameterDescriptor) {
        return (typeParameterDescriptor.getVariance() == Variance.INVARIANT || variance == typeParameterDescriptor.getVariance()) ? false : true;
    }

    private final boolean isNullable(JavaTypeAttributes javaTypeAttributes) {
        return (javaTypeAttributes.getFlexibility() == JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND || javaTypeAttributes.isForAnnotationParameter() || javaTypeAttributes.getHowThisTypeIsUsed() == TypeUsage.SUPERTYPE) ? false : true;
    }
}
