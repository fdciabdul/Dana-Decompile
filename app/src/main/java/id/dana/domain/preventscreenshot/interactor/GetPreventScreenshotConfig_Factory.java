package id.dana.domain.preventscreenshot.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetPreventScreenshotConfig_Factory implements Factory<GetPreventScreenshotConfig> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public GetPreventScreenshotConfig_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetPreventScreenshotConfig get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static GetPreventScreenshotConfig_Factory create(Provider<FeatureConfigRepository> provider) {
        return new GetPreventScreenshotConfig_Factory(provider);
    }

    public static GetPreventScreenshotConfig newInstance(FeatureConfigRepository featureConfigRepository) {
        return new GetPreventScreenshotConfig(featureConfigRepository);
    }
}
