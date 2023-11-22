package id.dana.data.deeplink.repository.source;

import dagger.internal.Factory;
import id.dana.data.deeplink.repository.source.branch.BranchDeepLinkEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DeepLinkEntityDataFactory_Factory implements Factory<DeepLinkEntityDataFactory> {
    private final Provider<BranchDeepLinkEntityData> branchDeepLinkEntityDataProvider;

    public DeepLinkEntityDataFactory_Factory(Provider<BranchDeepLinkEntityData> provider) {
        this.branchDeepLinkEntityDataProvider = provider;
    }

    @Override // javax.inject.Provider
    public final DeepLinkEntityDataFactory get() {
        return newInstance(this.branchDeepLinkEntityDataProvider.get());
    }

    public static DeepLinkEntityDataFactory_Factory create(Provider<BranchDeepLinkEntityData> provider) {
        return new DeepLinkEntityDataFactory_Factory(provider);
    }

    public static DeepLinkEntityDataFactory newInstance(BranchDeepLinkEntityData branchDeepLinkEntityData) {
        return new DeepLinkEntityDataFactory(branchDeepLinkEntityData);
    }
}
