package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* loaded from: classes.dex */
public final class JvmBuiltInClassDescriptorFactory implements ClassDescriptorFactory {
    private static final ClassId CLONEABLE_CLASS_ID;
    private static final Name CLONEABLE_NAME;
    private final NotNullLazyValue cloneable$delegate;
    private final Function1<ModuleDescriptor, DeclarationDescriptor> computeContainingDeclaration;
    private final ModuleDescriptor moduleDescriptor;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JvmBuiltInClassDescriptorFactory.class), "cloneable", "getCloneable()Lorg/jetbrains/kotlin/descriptors/impl/ClassDescriptorImpl;"))};
    public static final Companion Companion = new Companion(null);
    private static final FqName KOTLIN_FQ_NAME = StandardNames.BUILT_INS_PACKAGE_FQ_NAME;

    /* JADX WARN: Multi-variable type inference failed */
    public JvmBuiltInClassDescriptorFactory(final StorageManager storageManager, ModuleDescriptor moduleDescriptor, Function1<? super ModuleDescriptor, ? extends DeclarationDescriptor> function1) {
        Intrinsics.checkNotNullParameter(storageManager, "");
        Intrinsics.checkNotNullParameter(moduleDescriptor, "");
        Intrinsics.checkNotNullParameter(function1, "");
        this.moduleDescriptor = moduleDescriptor;
        this.computeContainingDeclaration = function1;
        this.cloneable$delegate = storageManager.createLazyValue(new Function0<ClassDescriptorImpl>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInClassDescriptorFactory$cloneable$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ClassDescriptorImpl invoke() {
                Function1 function12;
                ModuleDescriptor moduleDescriptor2;
                Name name;
                ModuleDescriptor moduleDescriptor3;
                function12 = JvmBuiltInClassDescriptorFactory.this.computeContainingDeclaration;
                moduleDescriptor2 = JvmBuiltInClassDescriptorFactory.this.moduleDescriptor;
                DeclarationDescriptor declarationDescriptor = (DeclarationDescriptor) function12.invoke(moduleDescriptor2);
                name = JvmBuiltInClassDescriptorFactory.CLONEABLE_NAME;
                Modality modality = Modality.ABSTRACT;
                ClassKind classKind = ClassKind.INTERFACE;
                moduleDescriptor3 = JvmBuiltInClassDescriptorFactory.this.moduleDescriptor;
                ClassDescriptorImpl classDescriptorImpl = new ClassDescriptorImpl(declarationDescriptor, name, modality, classKind, CollectionsKt.listOf(moduleDescriptor3.getBuiltIns().getAnyType()), SourceElement.NO_SOURCE, false, storageManager);
                classDescriptorImpl.initialize(new CloneableClassScope(storageManager, classDescriptorImpl), SetsKt.emptySet(), null);
                return classDescriptorImpl;
            }
        });
    }

    public /* synthetic */ JvmBuiltInClassDescriptorFactory(StorageManager storageManager, ModuleDescriptor moduleDescriptor, AnonymousClass1 anonymousClass1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storageManager, moduleDescriptor, (i & 4) != 0 ? new Function1<ModuleDescriptor, BuiltInsPackageFragment>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInClassDescriptorFactory.1
            @Override // kotlin.jvm.functions.Function1
            public final BuiltInsPackageFragment invoke(ModuleDescriptor moduleDescriptor2) {
                Intrinsics.checkNotNullParameter(moduleDescriptor2, "");
                List<PackageFragmentDescriptor> fragments = moduleDescriptor2.getPackage(JvmBuiltInClassDescriptorFactory.KOTLIN_FQ_NAME).getFragments();
                ArrayList arrayList = new ArrayList();
                for (Object obj : fragments) {
                    if (obj instanceof BuiltInsPackageFragment) {
                        arrayList.add(obj);
                    }
                }
                return (BuiltInsPackageFragment) CollectionsKt.first((List) arrayList);
            }
        } : anonymousClass1);
    }

    static {
        Name shortName = StandardNames.FqNames.cloneable.shortName();
        Intrinsics.checkNotNullExpressionValue(shortName, "");
        CLONEABLE_NAME = shortName;
        ClassId classId = ClassId.topLevel(StandardNames.FqNames.cloneable.toSafe());
        Intrinsics.checkNotNullExpressionValue(classId, "");
        CLONEABLE_CLASS_ID = classId;
    }

    private final ClassDescriptorImpl getCloneable() {
        return (ClassDescriptorImpl) StorageKt.getValue(this.cloneable$delegate, this, $$delegatedProperties[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public final boolean shouldCreateClass(FqName fqName, Name name) {
        Intrinsics.checkNotNullParameter(fqName, "");
        Intrinsics.checkNotNullParameter(name, "");
        return Intrinsics.areEqual(name, CLONEABLE_NAME) && Intrinsics.areEqual(fqName, KOTLIN_FQ_NAME);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public final ClassDescriptor createClass(ClassId classId) {
        Intrinsics.checkNotNullParameter(classId, "");
        if (Intrinsics.areEqual(classId, CLONEABLE_CLASS_ID)) {
            return getCloneable();
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public final Collection<ClassDescriptor> getAllContributedClassesIfPossible(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "");
        return Intrinsics.areEqual(fqName, KOTLIN_FQ_NAME) ? SetsKt.setOf(getCloneable()) : SetsKt.emptySet();
    }

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ClassId getCLONEABLE_CLASS_ID() {
            return JvmBuiltInClassDescriptorFactory.CLONEABLE_CLASS_ID;
        }
    }
}
