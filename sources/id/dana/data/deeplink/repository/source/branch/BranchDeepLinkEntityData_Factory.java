package id.dana.data.deeplink.repository.source.branch;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.deeplink.repository.source.branch.mapper.BranchIoDeepLinkEntityMapper;
import io.branch.referral.Branch;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class BranchDeepLinkEntityData_Factory implements Factory<BranchDeepLinkEntityData> {
    private final Provider<BranchIoDeepLinkEntityMapper> branchIoDeepLinkEntityMapperProvider;
    private final Provider<Branch> branchProvider;
    private final Provider<Context> contextProvider;

    public BranchDeepLinkEntityData_Factory(Provider<Context> provider, Provider<Branch> provider2, Provider<BranchIoDeepLinkEntityMapper> provider3) {
        this.contextProvider = provider;
        this.branchProvider = provider2;
        this.branchIoDeepLinkEntityMapperProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final BranchDeepLinkEntityData get() {
        return newInstance(this.contextProvider.get(), this.branchProvider.get(), this.branchIoDeepLinkEntityMapperProvider.get());
    }

    public static BranchDeepLinkEntityData_Factory create(Provider<Context> provider, Provider<Branch> provider2, Provider<BranchIoDeepLinkEntityMapper> provider3) {
        return new BranchDeepLinkEntityData_Factory(provider, provider2, provider3);
    }

    public static BranchDeepLinkEntityData newInstance(Context context, Branch branch, BranchIoDeepLinkEntityMapper branchIoDeepLinkEntityMapper) {
        return new BranchDeepLinkEntityData(context, branch, branchIoDeepLinkEntityMapper);
    }
}
