package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EmptyPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.ClassTypeConstructorImpl;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* loaded from: classes.dex */
public final class NotFoundClasses {
    private final MemoizedFunctionToNotNull<ClassRequest, ClassDescriptor> classes;
    private final ModuleDescriptor module;
    private final MemoizedFunctionToNotNull<FqName, PackageFragmentDescriptor> packageFragments;
    private final StorageManager storageManager;

    public NotFoundClasses(StorageManager storageManager, ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkNotNullParameter(storageManager, "");
        Intrinsics.checkNotNullParameter(moduleDescriptor, "");
        this.storageManager = storageManager;
        this.module = moduleDescriptor;
        this.packageFragments = storageManager.createMemoizedFunction(new Function1<FqName, PackageFragmentDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses$packageFragments$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final PackageFragmentDescriptor invoke(FqName fqName) {
                ModuleDescriptor moduleDescriptor2;
                Intrinsics.checkNotNullParameter(fqName, "");
                moduleDescriptor2 = NotFoundClasses.this.module;
                return new EmptyPackageFragmentDescriptor(moduleDescriptor2, fqName);
            }
        });
        this.classes = storageManager.createMemoizedFunction(new Function1<ClassRequest, ClassDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses$classes$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ClassDescriptor invoke(NotFoundClasses.ClassRequest classRequest) {
                MemoizedFunctionToNotNull memoizedFunctionToNotNull;
                ClassDescriptor classDescriptor;
                StorageManager storageManager2;
                ClassDescriptor classDescriptor2;
                Intrinsics.checkNotNullParameter(classRequest, "");
                ClassId component1 = classRequest.component1();
                List<Integer> component2 = classRequest.component2();
                if (component1.isLocal()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unresolved local class: ");
                    sb.append(component1);
                    throw new UnsupportedOperationException(sb.toString());
                }
                ClassId outerClassId = component1.getOuterClassId();
                if (outerClassId == null || (classDescriptor2 = NotFoundClasses.this.getClass(outerClassId, CollectionsKt.drop(component2, 1))) == null) {
                    memoizedFunctionToNotNull = NotFoundClasses.this.packageFragments;
                    FqName packageFqName = component1.getPackageFqName();
                    Intrinsics.checkNotNullExpressionValue(packageFqName, "");
                    classDescriptor = (ClassOrPackageFragmentDescriptor) memoizedFunctionToNotNull.invoke(packageFqName);
                } else {
                    classDescriptor = classDescriptor2;
                }
                boolean isNestedClass = component1.isNestedClass();
                storageManager2 = NotFoundClasses.this.storageManager;
                ClassOrPackageFragmentDescriptor classOrPackageFragmentDescriptor = classDescriptor;
                Name shortClassName = component1.getShortClassName();
                Intrinsics.checkNotNullExpressionValue(shortClassName, "");
                Integer num = (Integer) CollectionsKt.firstOrNull((List) component2);
                return new NotFoundClasses.MockClassDescriptor(storageManager2, classOrPackageFragmentDescriptor, shortClassName, isNestedClass, num != null ? num.intValue() : 0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class ClassRequest {
        private final ClassId classId;
        private final List<Integer> typeParametersCount;

        public final ClassId component1() {
            return this.classId;
        }

        public final List<Integer> component2() {
            return this.typeParametersCount;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ClassRequest) {
                ClassRequest classRequest = (ClassRequest) obj;
                return Intrinsics.areEqual(this.classId, classRequest.classId) && Intrinsics.areEqual(this.typeParametersCount, classRequest.typeParametersCount);
            }
            return false;
        }

        public final int hashCode() {
            return (this.classId.hashCode() * 31) + this.typeParametersCount.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ClassRequest(classId=");
            sb.append(this.classId);
            sb.append(", typeParametersCount=");
            sb.append(this.typeParametersCount);
            sb.append(')');
            return sb.toString();
        }

        public ClassRequest(ClassId classId, List<Integer> list) {
            Intrinsics.checkNotNullParameter(classId, "");
            Intrinsics.checkNotNullParameter(list, "");
            this.classId = classId;
            this.typeParametersCount = list;
        }
    }

    /* loaded from: classes.dex */
    public static final class MockClassDescriptor extends ClassDescriptorBase {
        private final List<TypeParameterDescriptor> declaredTypeParameters;
        private final boolean isInner;
        private final ClassTypeConstructorImpl typeConstructor;

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        /* renamed from: getCompanionObjectDescriptor */
        public final ClassDescriptor mo4433getCompanionObjectDescriptor() {
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        /* renamed from: getUnsubstitutedPrimaryConstructor */
        public final ClassConstructorDescriptor mo4434getUnsubstitutedPrimaryConstructor() {
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public final ValueClassRepresentation<SimpleType> getValueClassRepresentation() {
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
        public final boolean isActual() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public final boolean isCompanionObject() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public final boolean isData() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
        public final boolean isExpect() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
        public final boolean isExternal() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public final boolean isFun() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public final boolean isInline() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public final boolean isValue() {
            return false;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MockClassDescriptor(StorageManager storageManager, DeclarationDescriptor declarationDescriptor, Name name, boolean z, int i) {
            super(storageManager, declarationDescriptor, name, SourceElement.NO_SOURCE, false);
            Intrinsics.checkNotNullParameter(storageManager, "");
            Intrinsics.checkNotNullParameter(declarationDescriptor, "");
            Intrinsics.checkNotNullParameter(name, "");
            this.isInner = z;
            IntRange until = RangesKt.until(0, i);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
            Iterator<Integer> it = until.iterator();
            while (it.hasNext()) {
                int nextInt = ((IntIterator) it).nextInt();
                Annotations empty = Annotations.Companion.getEMPTY();
                Variance variance = Variance.INVARIANT;
                StringBuilder sb = new StringBuilder();
                sb.append('T');
                sb.append(nextInt);
                arrayList.add(TypeParameterDescriptorImpl.createWithDefaultBound(this, empty, false, variance, Name.identifier(sb.toString()), nextInt, storageManager));
            }
            this.declaredTypeParameters = arrayList;
            this.typeConstructor = new ClassTypeConstructorImpl(this, TypeParameterUtilsKt.computeConstructorTypeParameters(this), SetsKt.setOf(DescriptorUtilsKt.getModule(this).getBuiltIns().getAnyType()), storageManager);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public final ClassKind getKind() {
            return ClassKind.CLASS;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
        public final Modality getModality() {
            return Modality.FINAL;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
        public final DescriptorVisibility getVisibility() {
            DescriptorVisibility descriptorVisibility = DescriptorVisibilities.PUBLIC;
            Intrinsics.checkNotNullExpressionValue(descriptorVisibility, "");
            return descriptorVisibility;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
        public final ClassTypeConstructorImpl getTypeConstructor() {
            return this.typeConstructor;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
        public final List<TypeParameterDescriptor> getDeclaredTypeParameters() {
            return this.declaredTypeParameters;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
        public final boolean isInner() {
            return this.isInner;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
        public final Annotations getAnnotations() {
            return Annotations.Companion.getEMPTY();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
        public final MemberScope.Empty getUnsubstitutedMemberScope(KotlinTypeRefiner kotlinTypeRefiner) {
            Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "");
            return MemberScope.Empty.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public final MemberScope.Empty getStaticScope() {
            return MemberScope.Empty.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public final Collection<ClassConstructorDescriptor> getConstructors() {
            return SetsKt.emptySet();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public final Collection<ClassDescriptor> getSealedSubclasses() {
            return CollectionsKt.emptyList();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("class ");
            sb.append(getName());
            sb.append(" (not found)");
            return sb.toString();
        }
    }

    public final ClassDescriptor getClass(ClassId classId, List<Integer> list) {
        Intrinsics.checkNotNullParameter(classId, "");
        Intrinsics.checkNotNullParameter(list, "");
        return this.classes.invoke(new ClassRequest(classId, list));
    }
}
