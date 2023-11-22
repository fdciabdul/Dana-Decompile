package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionInterfacePackageFragment;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.text.StringsKt;

/* loaded from: classes.dex */
public final class BuiltInFictitiousFunctionClassFactory implements ClassDescriptorFactory {
    private final ModuleDescriptor module;
    private final StorageManager storageManager;

    public BuiltInFictitiousFunctionClassFactory(StorageManager storageManager, ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkNotNullParameter(storageManager, "");
        Intrinsics.checkNotNullParameter(moduleDescriptor, "");
        this.storageManager = storageManager;
        this.module = moduleDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public final boolean shouldCreateClass(FqName fqName, Name name) {
        Intrinsics.checkNotNullParameter(fqName, "");
        Intrinsics.checkNotNullParameter(name, "");
        String asString = name.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "");
        return (StringsKt.startsWith$default(asString, "Function", false, 2, (Object) null) || StringsKt.startsWith$default(asString, "KFunction", false, 2, (Object) null) || StringsKt.startsWith$default(asString, "SuspendFunction", false, 2, (Object) null) || StringsKt.startsWith$default(asString, "KSuspendFunction", false, 2, (Object) null)) && FunctionClassKind.Companion.parseClassName(asString, fqName) != null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public final ClassDescriptor createClass(ClassId classId) {
        Intrinsics.checkNotNullParameter(classId, "");
        if (classId.isLocal() || classId.isNestedClass()) {
            return null;
        }
        String asString = classId.getRelativeClassName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "");
        if (StringsKt.contains$default((CharSequence) asString, (CharSequence) "Function", false, 2, (Object) null)) {
            FqName packageFqName = classId.getPackageFqName();
            Intrinsics.checkNotNullExpressionValue(packageFqName, "");
            FunctionClassKind.Companion.KindWithArity parseClassName = FunctionClassKind.Companion.parseClassName(asString, packageFqName);
            if (parseClassName == null) {
                return null;
            }
            FunctionClassKind component1 = parseClassName.component1();
            int component2 = parseClassName.component2();
            List<PackageFragmentDescriptor> fragments = this.module.getPackage(packageFqName).getFragments();
            ArrayList arrayList = new ArrayList();
            for (Object obj : fragments) {
                if (obj instanceof BuiltInsPackageFragment) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : arrayList2) {
                if (obj2 instanceof FunctionInterfacePackageFragment) {
                    arrayList3.add(obj2);
                }
            }
            Object obj3 = (FunctionInterfacePackageFragment) CollectionsKt.firstOrNull((List) arrayList3);
            if (obj3 == null) {
                obj3 = CollectionsKt.first((List<? extends Object>) arrayList2);
            }
            return new FunctionClassDescriptor(this.storageManager, (BuiltInsPackageFragment) obj3, component1, component2);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public final Collection<ClassDescriptor> getAllContributedClassesIfPossible(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "");
        return SetsKt.emptySet();
    }
}
