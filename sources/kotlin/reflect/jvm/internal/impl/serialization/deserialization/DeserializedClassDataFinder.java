package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* loaded from: classes.dex */
public final class DeserializedClassDataFinder implements ClassDataFinder {
    private final PackageFragmentProvider packageFragmentProvider;

    public DeserializedClassDataFinder(PackageFragmentProvider packageFragmentProvider) {
        Intrinsics.checkNotNullParameter(packageFragmentProvider, "");
        this.packageFragmentProvider = packageFragmentProvider;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder
    public final ClassData findClassData(ClassId classId) {
        ClassData findClassData;
        Intrinsics.checkNotNullParameter(classId, "");
        PackageFragmentProvider packageFragmentProvider = this.packageFragmentProvider;
        FqName packageFqName = classId.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(packageFqName, "");
        for (PackageFragmentDescriptor packageFragmentDescriptor : PackageFragmentProviderKt.packageFragments(packageFragmentProvider, packageFqName)) {
            if ((packageFragmentDescriptor instanceof DeserializedPackageFragment) && (findClassData = ((DeserializedPackageFragment) packageFragmentDescriptor).getClassDataFinder().findClassData(classId)) != null) {
                return findClassData;
            }
        }
        return null;
    }
}
