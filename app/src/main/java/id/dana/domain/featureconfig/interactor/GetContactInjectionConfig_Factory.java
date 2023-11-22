package id.dana.domain.featureconfig.interactor;

import dagger.internal.Factory;
import id.dana.domain.contactinjection.ContactInjectionRepository;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetContactInjectionConfig_Factory implements Factory<GetContactInjectionConfig> {
    private final Provider<ContactInjectionRepository> contactInjectionRepositoryProvider;
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public GetContactInjectionConfig_Factory(Provider<FeatureConfigRepository> provider, Provider<ContactInjectionRepository> provider2) {
        this.featureConfigRepositoryProvider = provider;
        this.contactInjectionRepositoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final GetContactInjectionConfig get() {
        return newInstance(this.featureConfigRepositoryProvider.get(), this.contactInjectionRepositoryProvider.get());
    }

    public static GetContactInjectionConfig_Factory create(Provider<FeatureConfigRepository> provider, Provider<ContactInjectionRepository> provider2) {
        return new GetContactInjectionConfig_Factory(provider, provider2);
    }

    public static GetContactInjectionConfig newInstance(FeatureConfigRepository featureConfigRepository, ContactInjectionRepository contactInjectionRepository) {
        return new GetContactInjectionConfig(featureConfigRepository, contactInjectionRepository);
    }
}
