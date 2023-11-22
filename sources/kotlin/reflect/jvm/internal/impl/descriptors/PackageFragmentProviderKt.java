package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* loaded from: classes.dex */
public final class PackageFragmentProviderKt {
    public static final List<PackageFragmentDescriptor> packageFragments(PackageFragmentProvider packageFragmentProvider, FqName fqName) {
        Intrinsics.checkNotNullParameter(packageFragmentProvider, "");
        Intrinsics.checkNotNullParameter(fqName, "");
        ArrayList arrayList = new ArrayList();
        collectPackageFragmentsOptimizedIfPossible(packageFragmentProvider, fqName, arrayList);
        return arrayList;
    }

    public static final boolean isEmpty(PackageFragmentProvider packageFragmentProvider, FqName fqName) {
        Intrinsics.checkNotNullParameter(packageFragmentProvider, "");
        Intrinsics.checkNotNullParameter(fqName, "");
        return packageFragmentProvider instanceof PackageFragmentProviderOptimized ? ((PackageFragmentProviderOptimized) packageFragmentProvider).isEmpty(fqName) : packageFragments(packageFragmentProvider, fqName).isEmpty();
    }

    public static final void collectPackageFragmentsOptimizedIfPossible(PackageFragmentProvider packageFragmentProvider, FqName fqName, Collection<PackageFragmentDescriptor> collection) {
        Intrinsics.checkNotNullParameter(packageFragmentProvider, "");
        Intrinsics.checkNotNullParameter(fqName, "");
        Intrinsics.checkNotNullParameter(collection, "");
        if (packageFragmentProvider instanceof PackageFragmentProviderOptimized) {
            ((PackageFragmentProviderOptimized) packageFragmentProvider).collectPackageFragments(fqName, collection);
        } else {
            collection.addAll(packageFragmentProvider.getPackageFragments(fqName));
        }
    }
}
