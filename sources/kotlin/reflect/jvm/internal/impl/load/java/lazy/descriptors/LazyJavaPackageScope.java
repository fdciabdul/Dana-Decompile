package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinderKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;

/* loaded from: classes.dex */
public final class LazyJavaPackageScope extends LazyJavaStaticScope {
    private final MemoizedFunctionToNullable<FindClassRequest, ClassDescriptor> classes;
    private final JavaPackage jPackage;
    private final NullableLazyValue<Set<String>> knownClassNamesInPackage;
    private final LazyJavaPackageFragment ownerDescriptor;

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public final void computeNonDeclaredFunctions(Collection<SimpleFunctionDescriptor> collection, Name name) {
        Intrinsics.checkNotNullParameter(collection, "");
        Intrinsics.checkNotNullParameter(name, "");
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public final LazyJavaPackageFragment getOwnerDescriptor() {
        return this.ownerDescriptor;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaPackageScope(final LazyJavaResolverContext lazyJavaResolverContext, JavaPackage javaPackage, LazyJavaPackageFragment lazyJavaPackageFragment) {
        super(lazyJavaResolverContext);
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "");
        Intrinsics.checkNotNullParameter(javaPackage, "");
        Intrinsics.checkNotNullParameter(lazyJavaPackageFragment, "");
        this.jPackage = javaPackage;
        this.ownerDescriptor = lazyJavaPackageFragment;
        this.knownClassNamesInPackage = lazyJavaResolverContext.getStorageManager().createNullableLazyValue(new Function0<Set<? extends String>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope$knownClassNamesInPackage$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Set<? extends String> invoke() {
                return LazyJavaResolverContext.this.getComponents().getFinder().knownClassNamesInPackage(this.getOwnerDescriptor().getFqName());
            }
        });
        this.classes = lazyJavaResolverContext.getStorageManager().createMemoizedFunctionWithNullableValues(new Function1<FindClassRequest, ClassDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope$classes$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ClassDescriptor invoke(LazyJavaPackageScope.FindClassRequest findClassRequest) {
                KotlinClassFinder.Result findKotlinClassOrContent;
                LazyJavaPackageScope.KotlinClassLookupResult resolveKotlinBinaryClass;
                byte[] bArr;
                Intrinsics.checkNotNullParameter(findClassRequest, "");
                ClassId classId = new ClassId(LazyJavaPackageScope.this.getOwnerDescriptor().getFqName(), findClassRequest.getName());
                if (findClassRequest.getJavaClass() != null) {
                    findKotlinClassOrContent = lazyJavaResolverContext.getComponents().getKotlinClassFinder().findKotlinClassOrContent(findClassRequest.getJavaClass());
                } else {
                    findKotlinClassOrContent = lazyJavaResolverContext.getComponents().getKotlinClassFinder().findKotlinClassOrContent(classId);
                }
                LazyJavaClassDescriptor lazyJavaClassDescriptor = null;
                KotlinJvmBinaryClass kotlinJvmBinaryClass = findKotlinClassOrContent != null ? findKotlinClassOrContent.toKotlinJvmBinaryClass() : null;
                ClassId classId2 = kotlinJvmBinaryClass != null ? kotlinJvmBinaryClass.getClassId() : null;
                if (classId2 == null || !(classId2.isNestedClass() || classId2.isLocal())) {
                    resolveKotlinBinaryClass = LazyJavaPackageScope.this.resolveKotlinBinaryClass(kotlinJvmBinaryClass);
                    if (resolveKotlinBinaryClass instanceof LazyJavaPackageScope.KotlinClassLookupResult.Found) {
                        return ((LazyJavaPackageScope.KotlinClassLookupResult.Found) resolveKotlinBinaryClass).getDescriptor();
                    }
                    if (resolveKotlinBinaryClass instanceof LazyJavaPackageScope.KotlinClassLookupResult.SyntheticClass) {
                        return null;
                    }
                    if (resolveKotlinBinaryClass instanceof LazyJavaPackageScope.KotlinClassLookupResult.NotFound) {
                        JavaClass javaClass = findClassRequest.getJavaClass();
                        if (javaClass == null) {
                            JavaClassFinder finder = lazyJavaResolverContext.getComponents().getFinder();
                            if (findKotlinClassOrContent != null) {
                                if (!(findKotlinClassOrContent instanceof KotlinClassFinder.Result.ClassFileContent)) {
                                    findKotlinClassOrContent = null;
                                }
                                KotlinClassFinder.Result.ClassFileContent classFileContent = (KotlinClassFinder.Result.ClassFileContent) findKotlinClassOrContent;
                                if (classFileContent != null) {
                                    bArr = classFileContent.getContent();
                                    javaClass = finder.findClass(new JavaClassFinder.Request(classId, bArr, null, 4, null));
                                }
                            }
                            bArr = null;
                            javaClass = finder.findClass(new JavaClassFinder.Request(classId, bArr, null, 4, null));
                        }
                        JavaClass javaClass2 = javaClass;
                        if ((javaClass2 != null ? javaClass2.getLightClassOriginKind() : null) == LightClassOriginKind.BINARY) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Couldn't find kotlin binary class for light class created by kotlin binary file\nJavaClass: ");
                            sb.append(javaClass2);
                            sb.append("\nClassId: ");
                            sb.append(classId);
                            sb.append("\nfindKotlinClass(JavaClass) = ");
                            sb.append(KotlinClassFinderKt.findKotlinClass(lazyJavaResolverContext.getComponents().getKotlinClassFinder(), javaClass2));
                            sb.append("\nfindKotlinClass(ClassId) = ");
                            sb.append(KotlinClassFinderKt.findKotlinClass(lazyJavaResolverContext.getComponents().getKotlinClassFinder(), classId));
                            sb.append('\n');
                            throw new IllegalStateException(sb.toString());
                        }
                        FqName fqName = javaClass2 != null ? javaClass2.getFqName() : null;
                        if (fqName != null && !fqName.isRoot() && Intrinsics.areEqual(fqName.parent(), LazyJavaPackageScope.this.getOwnerDescriptor().getFqName())) {
                            lazyJavaClassDescriptor = new LazyJavaClassDescriptor(lazyJavaResolverContext, LazyJavaPackageScope.this.getOwnerDescriptor(), javaClass2, null, 8, null);
                            lazyJavaResolverContext.getComponents().getJavaClassesTracker().reportClass(lazyJavaClassDescriptor);
                        }
                        return lazyJavaClassDescriptor;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return null;
            }
        });
    }

    /* loaded from: classes.dex */
    public static abstract class KotlinClassLookupResult {
        public /* synthetic */ KotlinClassLookupResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* loaded from: classes.dex */
        public static final class Found extends KotlinClassLookupResult {
            private final ClassDescriptor descriptor;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Found(ClassDescriptor classDescriptor) {
                super(null);
                Intrinsics.checkNotNullParameter(classDescriptor, "");
                this.descriptor = classDescriptor;
            }

            public final ClassDescriptor getDescriptor() {
                return this.descriptor;
            }
        }

        private KotlinClassLookupResult() {
        }

        /* loaded from: classes.dex */
        public static final class NotFound extends KotlinClassLookupResult {
            public static final NotFound INSTANCE = new NotFound();

            private NotFound() {
                super(null);
            }
        }

        /* loaded from: classes.dex */
        public static final class SyntheticClass extends KotlinClassLookupResult {
            public static final SyntheticClass INSTANCE = new SyntheticClass();

            private SyntheticClass() {
                super(null);
            }
        }
    }

    public final KotlinClassLookupResult resolveKotlinBinaryClass(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        if (kotlinJvmBinaryClass == null) {
            return KotlinClassLookupResult.NotFound.INSTANCE;
        }
        if (kotlinJvmBinaryClass.getClassHeader().getKind() == KotlinClassHeader.Kind.CLASS) {
            ClassDescriptor resolveClass = getC().getComponents().getDeserializedDescriptorResolver().resolveClass(kotlinJvmBinaryClass);
            return resolveClass != null ? new KotlinClassLookupResult.Found(resolveClass) : KotlinClassLookupResult.NotFound.INSTANCE;
        }
        return KotlinClassLookupResult.SyntheticClass.INSTANCE;
    }

    /* loaded from: classes.dex */
    public static final class FindClassRequest {
        private final JavaClass javaClass;
        private final Name name;

        public FindClassRequest(Name name, JavaClass javaClass) {
            Intrinsics.checkNotNullParameter(name, "");
            this.name = name;
            this.javaClass = javaClass;
        }

        public final JavaClass getJavaClass() {
            return this.javaClass;
        }

        public final Name getName() {
            return this.name;
        }

        public final boolean equals(Object obj) {
            return (obj instanceof FindClassRequest) && Intrinsics.areEqual(this.name, ((FindClassRequest) obj).name);
        }

        public final int hashCode() {
            return this.name.hashCode();
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* renamed from: getContributedClassifier */
    public final ClassDescriptor mo4443getContributedClassifier(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "");
        Intrinsics.checkNotNullParameter(lookupLocation, "");
        return findClassifier(name, null);
    }

    private final ClassDescriptor findClassifier(Name name, JavaClass javaClass) {
        if (SpecialNames.INSTANCE.isSafeIdentifier(name)) {
            Set<String> invoke = this.knownClassNamesInPackage.invoke();
            if (javaClass != null || invoke == null || invoke.contains(name.asString())) {
                return this.classes.invoke(new FindClassRequest(name, javaClass));
            }
            return null;
        }
        return null;
    }

    public final ClassDescriptor findClassifierByJavaClass$descriptors_jvm(JavaClass javaClass) {
        Intrinsics.checkNotNullParameter(javaClass, "");
        return findClassifier(javaClass.getName(), javaClass);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public final Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "");
        Intrinsics.checkNotNullParameter(lookupLocation, "");
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public final DeclaredMemberIndex computeMemberIndex() {
        return DeclaredMemberIndex.Empty.INSTANCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public final Set<Name> computeClassNames(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "");
        if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getNON_SINGLETON_CLASSIFIERS_MASK())) {
            Set<String> invoke = this.knownClassNamesInPackage.invoke();
            if (invoke == null) {
                JavaPackage javaPackage = this.jPackage;
                if (function1 == null) {
                    function1 = FunctionsKt.alwaysTrue();
                }
                Collection<JavaClass> classes = javaPackage.getClasses(function1);
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                for (JavaClass javaClass : classes) {
                    Name name = javaClass.getLightClassOriginKind() == LightClassOriginKind.SOURCE ? null : javaClass.getName();
                    if (name != null) {
                        linkedHashSet.add(name);
                    }
                }
                return linkedHashSet;
            }
            HashSet hashSet = new HashSet();
            Iterator<T> it = invoke.iterator();
            while (it.hasNext()) {
                hashSet.add(Name.identifier((String) it.next()));
            }
            return hashSet;
        }
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public final Set<Name> computeFunctionNames(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "");
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public final Set<Name> computePropertyNames(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "");
        return SetsKt.emptySet();
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0062 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0037 A[SYNTHETIC] */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> getContributedDescriptors(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter r6, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean> r7) {
        /*
            r5 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter$Companion r1 = kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter.Companion
            int r1 = r1.getCLASSIFIERS_MASK()
            kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter$Companion r2 = kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter.Companion
            int r2 = r2.getNON_SINGLETON_CLASSIFIERS_MASK()
            r1 = r1 | r2
            boolean r6 = r6.acceptsKinds(r1)
            if (r6 != 0) goto L22
            java.util.List r6 = kotlin.collections.CollectionsKt.emptyList()
            java.util.Collection r6 = (java.util.Collection) r6
            goto L6b
        L22:
            kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue r6 = r5.getAllDescriptors()
            java.lang.Object r6 = r6.invoke()
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r6 = r6.iterator()
        L37:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L66
            java.lang.Object r2 = r6.next()
            r3 = r2
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) r3
            boolean r4 = r3 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r4 == 0) goto L5f
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r3
            kotlin.reflect.jvm.internal.impl.name.Name r3 = r3.getName()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            java.lang.Object r3 = r7.invoke(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L5f
            r3 = 1
            goto L60
        L5f:
            r3 = 0
        L60:
            if (r3 == 0) goto L37
            r1.add(r2)
            goto L37
        L66:
            java.util.List r1 = (java.util.List) r1
            r6 = r1
            java.util.Collection r6 = (java.util.Collection) r6
        L6b:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope.getContributedDescriptors(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter, kotlin.jvm.functions.Function1):java.util.Collection");
    }
}
