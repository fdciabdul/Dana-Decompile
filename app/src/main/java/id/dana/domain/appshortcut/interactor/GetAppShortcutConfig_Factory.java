package id.dana.domain.appshortcut.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetAppShortcutConfig_Factory implements Factory<GetAppShortcutConfig> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public GetAppShortcutConfig_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetAppShortcutConfig get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static GetAppShortcutConfig_Factory create(Provider<FeatureConfigRepository> provider) {
        return new GetAppShortcutConfig_Factory(provider);
    }

    public static GetAppShortcutConfig newInstance(FeatureConfigRepository featureConfigRepository) {
        return new GetAppShortcutConfig(featureConfigRepository);
    }
}
