package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

/* loaded from: classes.dex */
public class TypeUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final SimpleType DONT_CARE = ErrorUtils.createErrorType(ErrorTypeKind.DONT_CARE, new String[0]);
    public static final SimpleType CANNOT_INFER_FUNCTION_PARAM_TYPE = ErrorUtils.createErrorType(ErrorTypeKind.UNINFERRED_LAMBDA_PARAMETER_TYPE, new String[0]);
    public static final SimpleType NO_EXPECTED_TYPE = new SpecialType("NO_EXPECTED_TYPE");
    public static final SimpleType UNIT_EXPECTED_TYPE = new SpecialType("UNIT_EXPECTED_TYPE");

    /* JADX WARN: Removed duplicated region for block: B:165:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x01c1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:262:0x01da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static /* synthetic */ void $$$reportNull$$$0(int r24) {
        /*
            Method dump skipped, instructions count: 776
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.TypeUtils.$$$reportNull$$$0(int):void");
    }

    /* loaded from: classes.dex */
    public static class SpecialType extends DelegatingSimpleType {
        private final String name;

        /* JADX WARN: Removed duplicated region for block: B:64:0x0036  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x003e  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x0044  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static /* synthetic */ void $$$reportNull$$$0(int r9) {
            /*
                r0 = 4
                r1 = 1
                if (r9 == r1) goto L9
                if (r9 == r0) goto L9
                java.lang.String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
                goto Lb
            L9:
                java.lang.String r2 = "@NotNull method %s.%s must not return null"
            Lb:
                r3 = 3
                r4 = 2
                if (r9 == r1) goto L13
                if (r9 == r0) goto L13
                r5 = 3
                goto L14
            L13:
                r5 = 2
            L14:
                java.lang.Object[] r5 = new java.lang.Object[r5]
                java.lang.String r6 = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType"
                r7 = 0
                if (r9 == r1) goto L30
                if (r9 == r4) goto L2b
                if (r9 == r3) goto L26
                if (r9 == r0) goto L30
                java.lang.String r8 = "newAttributes"
                r5[r7] = r8
                goto L32
            L26:
                java.lang.String r8 = "kotlinTypeRefiner"
                r5[r7] = r8
                goto L32
            L2b:
                java.lang.String r8 = "delegate"
                r5[r7] = r8
                goto L32
            L30:
                r5[r7] = r6
            L32:
                java.lang.String r7 = "refine"
                if (r9 == r1) goto L3e
                if (r9 == r0) goto L3b
                r5[r1] = r6
                goto L42
            L3b:
                r5[r1] = r7
                goto L42
            L3e:
                java.lang.String r6 = "toString"
                r5[r1] = r6
            L42:
                if (r9 == r1) goto L56
                if (r9 == r4) goto L52
                if (r9 == r3) goto L4f
                if (r9 == r0) goto L56
                java.lang.String r3 = "replaceAttributes"
                r5[r4] = r3
                goto L56
            L4f:
                r5[r4] = r7
                goto L56
            L52:
                java.lang.String r3 = "replaceDelegate"
                r5[r4] = r3
            L56:
                java.lang.String r2 = java.lang.String.format(r2, r5)
                if (r9 == r1) goto L64
                if (r9 == r0) goto L64
                java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
                r9.<init>(r2)
                goto L69
            L64:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                r9.<init>(r2)
            L69:
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.TypeUtils.SpecialType.$$$reportNull$$$0(int):void");
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
        public SpecialType refine(KotlinTypeRefiner kotlinTypeRefiner) {
            if (kotlinTypeRefiner == null) {
                $$$reportNull$$$0(3);
            }
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
        public /* bridge */ /* synthetic */ UnwrappedType makeNullableAsSpecified(boolean z) {
            return makeNullableAsSpecified(z);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
        public /* bridge */ /* synthetic */ UnwrappedType replaceAttributes(TypeAttributes typeAttributes) {
            return replaceAttributes(typeAttributes);
        }

        public SpecialType(String str) {
            this.name = str;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
        protected SimpleType getDelegate() {
            throw new IllegalStateException(this.name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType
        public SimpleType replaceAttributes(TypeAttributes typeAttributes) {
            if (typeAttributes == null) {
                $$$reportNull$$$0(0);
            }
            throw new IllegalStateException(this.name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType
        public SimpleType makeNullableAsSpecified(boolean z) {
            throw new IllegalStateException(this.name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType
        public String toString() {
            String str = this.name;
            if (str == null) {
                $$$reportNull$$$0(1);
            }
            return str;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
        public DelegatingSimpleType replaceDelegate(SimpleType simpleType) {
            if (simpleType == null) {
                $$$reportNull$$$0(2);
            }
            throw new IllegalStateException(this.name);
        }
    }

    public static boolean noExpectedType(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(0);
        }
        return kotlinType == NO_EXPECTED_TYPE || kotlinType == UNIT_EXPECTED_TYPE;
    }

    public static boolean isDontCarePlaceholder(KotlinType kotlinType) {
        return kotlinType != null && kotlinType.getConstructor() == DONT_CARE.getConstructor();
    }

    public static KotlinType makeNullable(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(1);
        }
        return makeNullableAsSpecified(kotlinType, true);
    }

    public static KotlinType makeNotNullable(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(2);
        }
        return makeNullableAsSpecified(kotlinType, false);
    }

    public static KotlinType makeNullableAsSpecified(KotlinType kotlinType, boolean z) {
        if (kotlinType == null) {
            $$$reportNull$$$0(3);
        }
        UnwrappedType makeNullableAsSpecified = kotlinType.unwrap().makeNullableAsSpecified(z);
        if (makeNullableAsSpecified == null) {
            $$$reportNull$$$0(4);
        }
        return makeNullableAsSpecified;
    }

    public static SimpleType makeNullableIfNeeded(SimpleType simpleType, boolean z) {
        if (simpleType == null) {
            $$$reportNull$$$0(5);
        }
        if (!z) {
            if (simpleType == null) {
                $$$reportNull$$$0(7);
            }
            return simpleType;
        }
        SimpleType makeNullableAsSpecified = simpleType.makeNullableAsSpecified(true);
        if (makeNullableAsSpecified == null) {
            $$$reportNull$$$0(6);
        }
        return makeNullableAsSpecified;
    }

    public static KotlinType makeNullableIfNeeded(KotlinType kotlinType, boolean z) {
        if (kotlinType == null) {
            $$$reportNull$$$0(8);
        }
        if (z) {
            return makeNullable(kotlinType);
        }
        if (kotlinType == null) {
            $$$reportNull$$$0(9);
        }
        return kotlinType;
    }

    public static SimpleType makeUnsubstitutedType(ClassifierDescriptor classifierDescriptor, MemberScope memberScope, Function1<KotlinTypeRefiner, SimpleType> function1) {
        if (ErrorUtils.isError(classifierDescriptor)) {
            ErrorType createErrorType = ErrorUtils.createErrorType(ErrorTypeKind.UNABLE_TO_SUBSTITUTE_TYPE, classifierDescriptor.toString());
            if (createErrorType == null) {
                $$$reportNull$$$0(11);
            }
            return createErrorType;
        }
        return makeUnsubstitutedType(classifierDescriptor.getTypeConstructor(), memberScope, function1);
    }

    public static SimpleType makeUnsubstitutedType(TypeConstructor typeConstructor, MemberScope memberScope, Function1<KotlinTypeRefiner, SimpleType> function1) {
        if (typeConstructor == null) {
            $$$reportNull$$$0(12);
        }
        if (memberScope == null) {
            $$$reportNull$$$0(13);
        }
        if (function1 == null) {
            $$$reportNull$$$0(14);
        }
        SimpleType simpleTypeWithNonTrivialMemberScope = KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(TypeAttributes.Companion.getEmpty(), typeConstructor, getDefaultTypeProjections(typeConstructor.getParameters()), false, memberScope, function1);
        if (simpleTypeWithNonTrivialMemberScope == null) {
            $$$reportNull$$$0(15);
        }
        return simpleTypeWithNonTrivialMemberScope;
    }

    public static List<TypeProjection> getDefaultTypeProjections(List<TypeParameterDescriptor> list) {
        if (list == null) {
            $$$reportNull$$$0(16);
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<TypeParameterDescriptor> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new TypeProjectionImpl(it.next().getDefaultType()));
        }
        List<TypeProjection> list2 = CollectionsKt.toList(arrayList);
        if (list2 == null) {
            $$$reportNull$$$0(17);
        }
        return list2;
    }

    public static List<KotlinType> getImmediateSupertypes(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(18);
        }
        TypeSubstitutor create = TypeSubstitutor.create(kotlinType);
        Collection<KotlinType> mo4442getSupertypes = kotlinType.getConstructor().mo4442getSupertypes();
        ArrayList arrayList = new ArrayList(mo4442getSupertypes.size());
        Iterator<KotlinType> it = mo4442getSupertypes.iterator();
        while (it.hasNext()) {
            KotlinType createSubstitutedSupertype = createSubstitutedSupertype(kotlinType, it.next(), create);
            if (createSubstitutedSupertype != null) {
                arrayList.add(createSubstitutedSupertype);
            }
        }
        return arrayList;
    }

    public static KotlinType createSubstitutedSupertype(KotlinType kotlinType, KotlinType kotlinType2, TypeSubstitutor typeSubstitutor) {
        if (kotlinType == null) {
            $$$reportNull$$$0(20);
        }
        if (kotlinType2 == null) {
            $$$reportNull$$$0(21);
        }
        if (typeSubstitutor == null) {
            $$$reportNull$$$0(22);
        }
        KotlinType substitute = typeSubstitutor.substitute(kotlinType2, Variance.INVARIANT);
        if (substitute != null) {
            return makeNullableIfNeeded(substitute, kotlinType.isMarkedNullable());
        }
        return null;
    }

    public static boolean isNullableType(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(27);
        }
        if (kotlinType.isMarkedNullable()) {
            return true;
        }
        if (FlexibleTypesKt.isFlexible(kotlinType) && isNullableType(FlexibleTypesKt.asFlexibleType(kotlinType).getUpperBound())) {
            return true;
        }
        if (SpecialTypesKt.isDefinitelyNotNullType(kotlinType)) {
            return false;
        }
        if (isTypeParameter(kotlinType)) {
            return hasNullableSuperType(kotlinType);
        }
        if (kotlinType instanceof AbstractStubType) {
            TypeParameterDescriptor originalTypeParameter = ((AbstractStubType) kotlinType).getOriginalTypeVariable().getOriginalTypeParameter();
            return originalTypeParameter == null || hasNullableSuperType(originalTypeParameter.getDefaultType());
        }
        TypeConstructor constructor = kotlinType.getConstructor();
        if (constructor instanceof IntersectionTypeConstructor) {
            Iterator<KotlinType> it = constructor.mo4442getSupertypes().iterator();
            while (it.hasNext()) {
                if (isNullableType(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean acceptsNullable(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(28);
        }
        if (kotlinType.isMarkedNullable()) {
            return true;
        }
        return FlexibleTypesKt.isFlexible(kotlinType) && acceptsNullable(FlexibleTypesKt.asFlexibleType(kotlinType).getUpperBound());
    }

    public static boolean hasNullableSuperType(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(29);
        }
        if (kotlinType.getConstructor().mo4441getDeclarationDescriptor() instanceof ClassDescriptor) {
            return false;
        }
        Iterator<KotlinType> it = getImmediateSupertypes(kotlinType).iterator();
        while (it.hasNext()) {
            if (isNullableType(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static ClassDescriptor getClassDescriptor(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(30);
        }
        ClassifierDescriptor mo4441getDeclarationDescriptor = kotlinType.getConstructor().mo4441getDeclarationDescriptor();
        if (mo4441getDeclarationDescriptor instanceof ClassDescriptor) {
            return (ClassDescriptor) mo4441getDeclarationDescriptor;
        }
        return null;
    }

    public static boolean contains(KotlinType kotlinType, Function1<UnwrappedType, Boolean> function1) {
        if (function1 == null) {
            $$$reportNull$$$0(43);
        }
        return contains(kotlinType, function1, null);
    }

    private static boolean contains(KotlinType kotlinType, Function1<UnwrappedType, Boolean> function1, SmartSet<KotlinType> smartSet) {
        if (function1 == null) {
            $$$reportNull$$$0(44);
        }
        if (kotlinType == null) {
            return false;
        }
        UnwrappedType unwrap = kotlinType.unwrap();
        if (noExpectedType(kotlinType)) {
            return function1.invoke(unwrap).booleanValue();
        }
        if (smartSet == null || !smartSet.contains(kotlinType)) {
            if (function1.invoke(unwrap).booleanValue()) {
                return true;
            }
            if (smartSet == null) {
                smartSet = SmartSet.create();
            }
            smartSet.add(kotlinType);
            FlexibleType flexibleType = unwrap instanceof FlexibleType ? (FlexibleType) unwrap : null;
            if (flexibleType == null || !(contains(flexibleType.getLowerBound(), function1, smartSet) || contains(flexibleType.getUpperBound(), function1, smartSet))) {
                if ((unwrap instanceof DefinitelyNotNullType) && contains(((DefinitelyNotNullType) unwrap).getOriginal(), function1, smartSet)) {
                    return true;
                }
                TypeConstructor constructor = kotlinType.getConstructor();
                if (constructor instanceof IntersectionTypeConstructor) {
                    Iterator<KotlinType> it = ((IntersectionTypeConstructor) constructor).mo4442getSupertypes().iterator();
                    while (it.hasNext()) {
                        if (contains(it.next(), function1, smartSet)) {
                            return true;
                        }
                    }
                    return false;
                }
                for (TypeProjection typeProjection : kotlinType.getArguments()) {
                    if (!typeProjection.isStarProjection()) {
                        if (contains(typeProjection.getType(), function1, smartSet)) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return true;
        }
        return false;
    }

    public static TypeProjection makeStarProjection(TypeParameterDescriptor typeParameterDescriptor) {
        if (typeParameterDescriptor == null) {
            $$$reportNull$$$0(45);
        }
        return new StarProjectionImpl(typeParameterDescriptor);
    }

    public static boolean isTypeParameter(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(59);
        }
        return getTypeParameterDescriptorOrNull(kotlinType) != null || (kotlinType.getConstructor() instanceof NewTypeVariableConstructor);
    }

    public static TypeParameterDescriptor getTypeParameterDescriptorOrNull(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(62);
        }
        if (kotlinType.getConstructor().mo4441getDeclarationDescriptor() instanceof TypeParameterDescriptor) {
            return (TypeParameterDescriptor) kotlinType.getConstructor().mo4441getDeclarationDescriptor();
        }
        return null;
    }
}
