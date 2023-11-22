package id.dana.domain.featureconfig.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CheckResendWhatsAppEnable_Factory implements Factory<CheckResendWhatsAppEnable> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public CheckResendWhatsAppEnable_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CheckResendWhatsAppEnable get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static CheckResendWhatsAppEnable_Factory create(Provider<FeatureConfigRepository> provider) {
        return new CheckResendWhatsAppEnable_Factory(provider);
    }

    public static CheckResendWhatsAppEnable newInstance(FeatureConfigRepository featureConfigRepository) {
        return new CheckResendWhatsAppEnable(featureConfigRepository);
    }
}
