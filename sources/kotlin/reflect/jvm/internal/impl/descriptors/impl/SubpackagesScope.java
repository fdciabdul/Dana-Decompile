package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindExclude;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;

/* loaded from: classes.dex */
public class SubpackagesScope extends MemberScopeImpl {
    private final FqName fqName;
    private final ModuleDescriptor moduleDescriptor;

    public SubpackagesScope(ModuleDescriptor moduleDescriptor, FqName fqName) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "");
        Intrinsics.checkNotNullParameter(fqName, "");
        this.moduleDescriptor = moduleDescriptor;
        this.fqName = fqName;
    }

    protected final PackageViewDescriptor getPackage(Name name) {
        Intrinsics.checkNotNullParameter(name, "");
        if (name.isSpecial()) {
            return null;
        }
        ModuleDescriptor moduleDescriptor = this.moduleDescriptor;
        FqName child = this.fqName.child(name);
        Intrinsics.checkNotNullExpressionValue(child, "");
        PackageViewDescriptor packageViewDescriptor = moduleDescriptor.getPackage(child);
        if (packageViewDescriptor.isEmpty()) {
            return null;
        }
        return packageViewDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "");
        Intrinsics.checkNotNullParameter(function1, "");
        if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getPACKAGES_MASK())) {
            if (this.fqName.isRoot() && descriptorKindFilter.getExcludes().contains(DescriptorKindExclude.TopLevelPackages.INSTANCE)) {
                return CollectionsKt.emptyList();
            }
            Collection<FqName> subPackagesOf = this.moduleDescriptor.getSubPackagesOf(this.fqName, function1);
            ArrayList arrayList = new ArrayList(subPackagesOf.size());
            Iterator<FqName> it = subPackagesOf.iterator();
            while (it.hasNext()) {
                Name shortName = it.next().shortName();
                Intrinsics.checkNotNullExpressionValue(shortName, "");
                if (function1.invoke(shortName).booleanValue()) {
                    kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(arrayList, getPackage(shortName));
                }
            }
            return arrayList;
        }
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getClassifierNames() {
        return SetsKt.emptySet();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("subpackages of ");
        sb.append(this.fqName);
        sb.append(" from ");
        sb.append(this.moduleDescriptor);
        return sb.toString();
    }
}
