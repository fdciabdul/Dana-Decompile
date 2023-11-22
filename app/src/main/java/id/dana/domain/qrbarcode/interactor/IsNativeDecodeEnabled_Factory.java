package id.dana.domain.qrbarcode.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class IsNativeDecodeEnabled_Factory implements Factory<IsNativeDecodeEnabled> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public IsNativeDecodeEnabled_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final IsNativeDecodeEnabled get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static IsNativeDecodeEnabled_Factory create(Provider<FeatureConfigRepository> provider) {
        return new IsNativeDecodeEnabled_Factory(provider);
    }

    public static IsNativeDecodeEnabled newInstance(FeatureConfigRepository featureConfigRepository) {
        return new IsNativeDecodeEnabled(featureConfigRepository);
    }
}
