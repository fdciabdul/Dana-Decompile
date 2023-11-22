package id.dana.domain.qrpay.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class IsQrisEnable_Factory implements Factory<IsQrisEnable> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public IsQrisEnable_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final IsQrisEnable get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static IsQrisEnable_Factory create(Provider<FeatureConfigRepository> provider) {
        return new IsQrisEnable_Factory(provider);
    }

    public static IsQrisEnable newInstance(FeatureConfigRepository featureConfigRepository) {
        return new IsQrisEnable(featureConfigRepository);
    }
}
