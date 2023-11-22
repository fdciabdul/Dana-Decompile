package id.dana.domain.featureconfig.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class IsCashierEntryPointEnabled_Factory implements Factory<IsCashierEntryPointEnabled> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public IsCashierEntryPointEnabled_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final IsCashierEntryPointEnabled get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static IsCashierEntryPointEnabled_Factory create(Provider<FeatureConfigRepository> provider) {
        return new IsCashierEntryPointEnabled_Factory(provider);
    }

    public static IsCashierEntryPointEnabled newInstance(FeatureConfigRepository featureConfigRepository) {
        return new IsCashierEntryPointEnabled(featureConfigRepository);
    }
}
