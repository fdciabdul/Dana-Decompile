package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinderKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryPackageSourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;

/* loaded from: classes.dex */
public final class LazyJavaPackageFragment extends PackageFragmentDescriptorImpl {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyJavaPackageFragment.class), "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyJavaPackageFragment.class), "partToFacade", "getPartToFacade()Ljava/util/HashMap;"))};
    private final Annotations annotations;
    private final NotNullLazyValue binaryClasses$delegate;
    private final LazyJavaResolverContext c;
    private final JavaPackage jPackage;
    private final NotNullLazyValue partToFacade$delegate;
    private final JvmPackageScope scope;
    private final NotNullLazyValue<List<FqName>> subPackages;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaPackageFragment(LazyJavaResolverContext lazyJavaResolverContext, JavaPackage javaPackage) {
        super(lazyJavaResolverContext.getModule(), javaPackage.getFqName());
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "");
        Intrinsics.checkNotNullParameter(javaPackage, "");
        this.jPackage = javaPackage;
        LazyJavaResolverContext childForClassOrPackage$default = ContextKt.childForClassOrPackage$default(lazyJavaResolverContext, this, null, 0, 6, null);
        this.c = childForClassOrPackage$default;
        this.binaryClasses$delegate = childForClassOrPackage$default.getStorageManager().createLazyValue(new Function0<Map<String, ? extends KotlinJvmBinaryClass>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment$binaryClasses$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Map<String, ? extends KotlinJvmBinaryClass> invoke() {
                LazyJavaResolverContext lazyJavaResolverContext2;
                LazyJavaResolverContext lazyJavaResolverContext3;
                lazyJavaResolverContext2 = LazyJavaPackageFragment.this.c;
                PackagePartProvider packagePartProvider = lazyJavaResolverContext2.getComponents().getPackagePartProvider();
                String asString = LazyJavaPackageFragment.this.getFqName().asString();
                Intrinsics.checkNotNullExpressionValue(asString, "");
                List<String> findPackageParts = packagePartProvider.findPackageParts(asString);
                LazyJavaPackageFragment lazyJavaPackageFragment = LazyJavaPackageFragment.this;
                ArrayList arrayList = new ArrayList();
                for (String str : findPackageParts) {
                    ClassId classId = ClassId.topLevel(JvmClassName.byInternalName(str).getFqNameForTopLevelClassMaybeWithDollars());
                    Intrinsics.checkNotNullExpressionValue(classId, "");
                    lazyJavaResolverContext3 = lazyJavaPackageFragment.c;
                    KotlinJvmBinaryClass findKotlinClass = KotlinClassFinderKt.findKotlinClass(lazyJavaResolverContext3.getComponents().getKotlinClassFinder(), classId);
                    Pair pair = findKotlinClass != null ? TuplesKt.to(str, findKotlinClass) : null;
                    if (pair != null) {
                        arrayList.add(pair);
                    }
                }
                return MapsKt.toMap(arrayList);
            }
        });
        this.scope = new JvmPackageScope(childForClassOrPackage$default, javaPackage, this);
        this.subPackages = childForClassOrPackage$default.getStorageManager().createRecursionTolerantLazyValue(new Function0<List<? extends FqName>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment$subPackages$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends FqName> invoke() {
                JavaPackage javaPackage2;
                javaPackage2 = LazyJavaPackageFragment.this.jPackage;
                Collection<JavaPackage> subPackages = javaPackage2.getSubPackages();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(subPackages, 10));
                Iterator<T> it = subPackages.iterator();
                while (it.hasNext()) {
                    arrayList.add(((JavaPackage) it.next()).getFqName());
                }
                return arrayList;
            }
        }, CollectionsKt.emptyList());
        this.annotations = childForClassOrPackage$default.getComponents().getJavaTypeEnhancementState().getDisabledDefaultAnnotations() ? Annotations.Companion.getEMPTY() : LazyJavaAnnotationsKt.resolveAnnotations(childForClassOrPackage$default, javaPackage);
        this.partToFacade$delegate = childForClassOrPackage$default.getStorageManager().createLazyValue(new Function0<HashMap<JvmClassName, JvmClassName>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment$partToFacade$2

            /* loaded from: classes.dex */
            public final /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[KotlinClassHeader.Kind.values().length];
                    iArr[KotlinClassHeader.Kind.MULTIFILE_CLASS_PART.ordinal()] = 1;
                    iArr[KotlinClassHeader.Kind.FILE_FACADE.ordinal()] = 2;
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final HashMap<JvmClassName, JvmClassName> invoke() {
                HashMap<JvmClassName, JvmClassName> hashMap = new HashMap<>();
                for (Map.Entry<String, KotlinJvmBinaryClass> entry : LazyJavaPackageFragment.this.getBinaryClasses$descriptors_jvm().entrySet()) {
                    String key = entry.getKey();
                    KotlinJvmBinaryClass value = entry.getValue();
                    JvmClassName byInternalName = JvmClassName.byInternalName(key);
                    Intrinsics.checkNotNullExpressionValue(byInternalName, "");
                    KotlinClassHeader classHeader = value.getClassHeader();
                    int i = WhenMappings.$EnumSwitchMapping$0[classHeader.getKind().ordinal()];
                    if (i == 1) {
                        HashMap<JvmClassName, JvmClassName> hashMap2 = hashMap;
                        String multifileClassName = classHeader.getMultifileClassName();
                        if (multifileClassName != null) {
                            JvmClassName byInternalName2 = JvmClassName.byInternalName(multifileClassName);
                            Intrinsics.checkNotNullExpressionValue(byInternalName2, "");
                            hashMap2.put(byInternalName, byInternalName2);
                        }
                    } else if (i == 2) {
                        hashMap.put(byInternalName, byInternalName);
                    }
                }
                return hashMap;
            }
        });
    }

    public final Map<String, KotlinJvmBinaryClass> getBinaryClasses$descriptors_jvm() {
        return (Map) StorageKt.getValue(this.binaryClasses$delegate, this, $$delegatedProperties[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotatedImpl, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public final Annotations getAnnotations() {
        return this.annotations;
    }

    public final List<FqName> getSubPackageFqNames$descriptors_jvm() {
        return this.subPackages.invoke();
    }

    public final ClassDescriptor findClassifierByJavaClass$descriptors_jvm(JavaClass javaClass) {
        Intrinsics.checkNotNullParameter(javaClass, "");
        return this.scope.getJavaScope$descriptors_jvm().findClassifierByJavaClass$descriptors_jvm(javaClass);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
    public final JvmPackageScope getMemberScope() {
        return this.scope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lazy Java package fragment: ");
        sb.append(getFqName());
        sb.append(" of module ");
        sb.append(this.c.getComponents().getModule());
        return sb.toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    public final SourceElement getSource() {
        return new KotlinJvmBinaryPackageSourceElement(this);
    }
}
