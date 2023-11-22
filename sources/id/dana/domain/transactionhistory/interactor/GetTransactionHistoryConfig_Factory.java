package id.dana.domain.transactionhistory.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetTransactionHistoryConfig_Factory implements Factory<GetTransactionHistoryConfig> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public GetTransactionHistoryConfig_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetTransactionHistoryConfig get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static GetTransactionHistoryConfig_Factory create(Provider<FeatureConfigRepository> provider) {
        return new GetTransactionHistoryConfig_Factory(provider);
    }

    public static GetTransactionHistoryConfig newInstance(FeatureConfigRepository featureConfigRepository) {
        return new GetTransactionHistoryConfig(featureConfigRepository);
    }
}
