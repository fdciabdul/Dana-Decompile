package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* loaded from: classes.dex */
public final class DescriptorEquivalenceForOverrides {
    public static final DescriptorEquivalenceForOverrides INSTANCE = new DescriptorEquivalenceForOverrides();

    public final boolean areTypeParametersEquivalent(TypeParameterDescriptor typeParameterDescriptor, TypeParameterDescriptor typeParameterDescriptor2, boolean z) {
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "");
        Intrinsics.checkNotNullParameter(typeParameterDescriptor2, "");
        return areTypeParametersEquivalent$default(this, typeParameterDescriptor, typeParameterDescriptor2, z, null, 8, null);
    }

    private DescriptorEquivalenceForOverrides() {
    }

    public static /* synthetic */ boolean areEquivalent$default(DescriptorEquivalenceForOverrides descriptorEquivalenceForOverrides, DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2, boolean z, boolean z2, int i, Object obj) {
        if ((i & 8) != 0) {
            z2 = true;
        }
        return descriptorEquivalenceForOverrides.areEquivalent(declarationDescriptor, declarationDescriptor2, z, z2);
    }

    public final boolean areEquivalent(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2, boolean z, boolean z2) {
        if ((declarationDescriptor instanceof ClassDescriptor) && (declarationDescriptor2 instanceof ClassDescriptor)) {
            return areClassesEquivalent((ClassDescriptor) declarationDescriptor, (ClassDescriptor) declarationDescriptor2);
        }
        if ((declarationDescriptor instanceof TypeParameterDescriptor) && (declarationDescriptor2 instanceof TypeParameterDescriptor)) {
            return areTypeParametersEquivalent$default(this, (TypeParameterDescriptor) declarationDescriptor, (TypeParameterDescriptor) declarationDescriptor2, z, null, 8, null);
        }
        if ((declarationDescriptor instanceof CallableDescriptor) && (declarationDescriptor2 instanceof CallableDescriptor)) {
            return areCallableDescriptorsEquivalent$default(this, (CallableDescriptor) declarationDescriptor, (CallableDescriptor) declarationDescriptor2, z, z2, false, KotlinTypeRefiner.Default.INSTANCE, 16, null);
        }
        return ((declarationDescriptor instanceof PackageFragmentDescriptor) && (declarationDescriptor2 instanceof PackageFragmentDescriptor)) ? Intrinsics.areEqual(((PackageFragmentDescriptor) declarationDescriptor).getFqName(), ((PackageFragmentDescriptor) declarationDescriptor2).getFqName()) : Intrinsics.areEqual(declarationDescriptor, declarationDescriptor2);
    }

    private final boolean areClassesEquivalent(ClassDescriptor classDescriptor, ClassDescriptor classDescriptor2) {
        return Intrinsics.areEqual(classDescriptor.getTypeConstructor(), classDescriptor2.getTypeConstructor());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean areTypeParametersEquivalent$default(DescriptorEquivalenceForOverrides descriptorEquivalenceForOverrides, TypeParameterDescriptor typeParameterDescriptor, TypeParameterDescriptor typeParameterDescriptor2, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 8) != 0) {
            function2 = new Function2<DeclarationDescriptor, DeclarationDescriptor, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides$areTypeParametersEquivalent$1
                @Override // kotlin.jvm.functions.Function2
                public final Boolean invoke(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
                    return Boolean.FALSE;
                }
            };
        }
        return descriptorEquivalenceForOverrides.areTypeParametersEquivalent(typeParameterDescriptor, typeParameterDescriptor2, z, function2);
    }

    public final boolean areTypeParametersEquivalent(TypeParameterDescriptor typeParameterDescriptor, TypeParameterDescriptor typeParameterDescriptor2, boolean z, Function2<? super DeclarationDescriptor, ? super DeclarationDescriptor, Boolean> function2) {
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "");
        Intrinsics.checkNotNullParameter(typeParameterDescriptor2, "");
        Intrinsics.checkNotNullParameter(function2, "");
        if (Intrinsics.areEqual(typeParameterDescriptor, typeParameterDescriptor2)) {
            return true;
        }
        return !Intrinsics.areEqual(typeParameterDescriptor.getContainingDeclaration(), typeParameterDescriptor2.getContainingDeclaration()) && ownersEquivalent(typeParameterDescriptor, typeParameterDescriptor2, function2, z) && typeParameterDescriptor.getIndex() == typeParameterDescriptor2.getIndex();
    }

    private final SourceElement singleSource(CallableDescriptor callableDescriptor) {
        while (callableDescriptor instanceof CallableMemberDescriptor) {
            CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) callableDescriptor;
            if (callableMemberDescriptor.getKind() != CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
                break;
            }
            Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
            Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "");
            CallableMemberDescriptor callableMemberDescriptor2 = (CallableMemberDescriptor) CollectionsKt.singleOrNull(overriddenDescriptors);
            if (callableMemberDescriptor2 == null) {
                return null;
            }
            callableDescriptor = callableMemberDescriptor2;
        }
        return callableDescriptor.getSource();
    }

    public static /* synthetic */ boolean areCallableDescriptorsEquivalent$default(DescriptorEquivalenceForOverrides descriptorEquivalenceForOverrides, CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, boolean z, boolean z2, boolean z3, KotlinTypeRefiner kotlinTypeRefiner, int i, Object obj) {
        return descriptorEquivalenceForOverrides.areCallableDescriptorsEquivalent(callableDescriptor, callableDescriptor2, z, (i & 8) != 0 ? true : z2, (i & 16) != 0 ? false : z3, kotlinTypeRefiner);
    }

    public final boolean areCallableDescriptorsEquivalent(final CallableDescriptor callableDescriptor, final CallableDescriptor callableDescriptor2, final boolean z, boolean z2, boolean z3, KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(callableDescriptor, "");
        Intrinsics.checkNotNullParameter(callableDescriptor2, "");
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "");
        if (Intrinsics.areEqual(callableDescriptor, callableDescriptor2)) {
            return true;
        }
        if (Intrinsics.areEqual(callableDescriptor.getName(), callableDescriptor2.getName())) {
            if (z2 && (callableDescriptor instanceof MemberDescriptor) && (callableDescriptor2 instanceof MemberDescriptor) && ((MemberDescriptor) callableDescriptor).isExpect() != ((MemberDescriptor) callableDescriptor2).isExpect()) {
                return false;
            }
            if (!Intrinsics.areEqual(callableDescriptor.getContainingDeclaration(), callableDescriptor2.getContainingDeclaration()) || (z && Intrinsics.areEqual(singleSource(callableDescriptor), singleSource(callableDescriptor2)))) {
                CallableDescriptor callableDescriptor3 = callableDescriptor;
                if (!DescriptorUtils.isLocal(callableDescriptor3)) {
                    CallableDescriptor callableDescriptor4 = callableDescriptor2;
                    if (DescriptorUtils.isLocal(callableDescriptor4) || !ownersEquivalent(callableDescriptor3, callableDescriptor4, new Function2<DeclarationDescriptor, DeclarationDescriptor, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$1
                        @Override // kotlin.jvm.functions.Function2
                        public final Boolean invoke(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
                            return Boolean.FALSE;
                        }
                    }, z)) {
                        return false;
                    }
                    OverridingUtil create = OverridingUtil.create(kotlinTypeRefiner, new KotlinTypeChecker.TypeConstructorEquality() { // from class: kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$overridingUtil$1
                        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.TypeConstructorEquality
                        public final boolean equals(TypeConstructor typeConstructor, TypeConstructor typeConstructor2) {
                            Intrinsics.checkNotNullParameter(typeConstructor, "");
                            Intrinsics.checkNotNullParameter(typeConstructor2, "");
                            if (Intrinsics.areEqual(typeConstructor, typeConstructor2)) {
                                return true;
                            }
                            ClassifierDescriptor mo4441getDeclarationDescriptor = typeConstructor.mo4441getDeclarationDescriptor();
                            ClassifierDescriptor mo4441getDeclarationDescriptor2 = typeConstructor2.mo4441getDeclarationDescriptor();
                            if ((mo4441getDeclarationDescriptor instanceof TypeParameterDescriptor) && (mo4441getDeclarationDescriptor2 instanceof TypeParameterDescriptor)) {
                                boolean z4 = z;
                                final CallableDescriptor callableDescriptor5 = callableDescriptor;
                                final CallableDescriptor callableDescriptor6 = callableDescriptor2;
                                return DescriptorEquivalenceForOverrides.INSTANCE.areTypeParametersEquivalent((TypeParameterDescriptor) mo4441getDeclarationDescriptor, (TypeParameterDescriptor) mo4441getDeclarationDescriptor2, z4, new Function2<DeclarationDescriptor, DeclarationDescriptor, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$overridingUtil$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Boolean invoke(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
                                        return Boolean.valueOf(Intrinsics.areEqual(declarationDescriptor, CallableDescriptor.this) && Intrinsics.areEqual(declarationDescriptor2, callableDescriptor6));
                                    }
                                });
                            }
                            return false;
                        }
                    });
                    Intrinsics.checkNotNullExpressionValue(create, "");
                    boolean z4 = !z3;
                    return create.isOverridableBy(callableDescriptor, callableDescriptor2, null, z4).getResult() == OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE && create.isOverridableBy(callableDescriptor2, callableDescriptor, null, z4).getResult() == OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    private final boolean ownersEquivalent(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2, Function2<? super DeclarationDescriptor, ? super DeclarationDescriptor, Boolean> function2, boolean z) {
        DeclarationDescriptor containingDeclaration = declarationDescriptor.getContainingDeclaration();
        DeclarationDescriptor containingDeclaration2 = declarationDescriptor2.getContainingDeclaration();
        if ((containingDeclaration instanceof CallableMemberDescriptor) || (containingDeclaration2 instanceof CallableMemberDescriptor)) {
            return function2.invoke(containingDeclaration, containingDeclaration2).booleanValue();
        }
        return areEquivalent$default(this, containingDeclaration, containingDeclaration2, z, false, 8, null);
    }
}
