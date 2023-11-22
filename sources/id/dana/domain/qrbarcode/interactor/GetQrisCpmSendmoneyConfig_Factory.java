package id.dana.domain.qrbarcode.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.usereducation.repository.UserEducationRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetQrisCpmSendmoneyConfig_Factory implements Factory<GetQrisCpmSendmoneyConfig> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;
    private final Provider<UserEducationRepository> userEducationRepositoryProvider;

    public GetQrisCpmSendmoneyConfig_Factory(Provider<FeatureConfigRepository> provider, Provider<UserEducationRepository> provider2) {
        this.featureConfigRepositoryProvider = provider;
        this.userEducationRepositoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final GetQrisCpmSendmoneyConfig get() {
        return newInstance(this.featureConfigRepositoryProvider.get(), this.userEducationRepositoryProvider.get());
    }

    public static GetQrisCpmSendmoneyConfig_Factory create(Provider<FeatureConfigRepository> provider, Provider<UserEducationRepository> provider2) {
        return new GetQrisCpmSendmoneyConfig_Factory(provider, provider2);
    }

    public static GetQrisCpmSendmoneyConfig newInstance(FeatureConfigRepository featureConfigRepository, UserEducationRepository userEducationRepository) {
        return new GetQrisCpmSendmoneyConfig(featureConfigRepository, userEducationRepository);
    }
}
