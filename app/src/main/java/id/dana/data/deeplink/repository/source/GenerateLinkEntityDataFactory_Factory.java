package id.dana.data.deeplink.repository.source;

import dagger.internal.Factory;
import id.dana.data.deeplink.repository.source.branch.BranchGenerateLinkEntityData;
import id.dana.data.deeplink.repository.source.local.PreferencesGenerateLinkEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class GenerateLinkEntityDataFactory_Factory implements Factory<GenerateLinkEntityDataFactory> {
    private final Provider<BranchGenerateLinkEntityData> branchGenerateLinkEntityDataProvider;
    private final Provider<PreferencesGenerateLinkEntityData> preferencesGenerateLinkEntityDataProvider;

    public GenerateLinkEntityDataFactory_Factory(Provider<BranchGenerateLinkEntityData> provider, Provider<PreferencesGenerateLinkEntityData> provider2) {
        this.branchGenerateLinkEntityDataProvider = provider;
        this.preferencesGenerateLinkEntityDataProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final GenerateLinkEntityDataFactory get() {
        return newInstance(this.branchGenerateLinkEntityDataProvider.get(), this.preferencesGenerateLinkEntityDataProvider.get());
    }

    public static GenerateLinkEntityDataFactory_Factory create(Provider<BranchGenerateLinkEntityData> provider, Provider<PreferencesGenerateLinkEntityData> provider2) {
        return new GenerateLinkEntityDataFactory_Factory(provider, provider2);
    }

    public static GenerateLinkEntityDataFactory newInstance(BranchGenerateLinkEntityData branchGenerateLinkEntityData, PreferencesGenerateLinkEntityData preferencesGenerateLinkEntityData) {
        return new GenerateLinkEntityDataFactory(branchGenerateLinkEntityData, preferencesGenerateLinkEntityData);
    }
}
