package id.dana.domain.sendmoney.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetFeatureSendMoneyCashierNative_Factory implements Factory<GetFeatureSendMoneyCashierNative> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public GetFeatureSendMoneyCashierNative_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetFeatureSendMoneyCashierNative get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static GetFeatureSendMoneyCashierNative_Factory create(Provider<FeatureConfigRepository> provider) {
        return new GetFeatureSendMoneyCashierNative_Factory(provider);
    }

    public static GetFeatureSendMoneyCashierNative newInstance(FeatureConfigRepository featureConfigRepository) {
        return new GetFeatureSendMoneyCashierNative(featureConfigRepository);
    }
}
