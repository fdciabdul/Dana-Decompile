package id.dana.domain.featureconfig.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CheckFeedHighlight_Factory implements Factory<CheckFeedHighlight> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public CheckFeedHighlight_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CheckFeedHighlight get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static CheckFeedHighlight_Factory create(Provider<FeatureConfigRepository> provider) {
        return new CheckFeedHighlight_Factory(provider);
    }

    public static CheckFeedHighlight newInstance(FeatureConfigRepository featureConfigRepository) {
        return new CheckFeedHighlight(featureConfigRepository);
    }
}
