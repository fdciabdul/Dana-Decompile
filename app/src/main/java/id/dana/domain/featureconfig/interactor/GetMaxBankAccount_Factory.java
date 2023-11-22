package id.dana.domain.featureconfig.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetMaxBankAccount_Factory implements Factory<GetMaxBankAccount> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public GetMaxBankAccount_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetMaxBankAccount get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static GetMaxBankAccount_Factory create(Provider<FeatureConfigRepository> provider) {
        return new GetMaxBankAccount_Factory(provider);
    }

    public static GetMaxBankAccount newInstance(FeatureConfigRepository featureConfigRepository) {
        return new GetMaxBankAccount(featureConfigRepository);
    }
}
