package id.dana.domain.featureconfig.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CheckFeedInboxTabFeature_Factory implements Factory<CheckFeedInboxTabFeature> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public CheckFeedInboxTabFeature_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CheckFeedInboxTabFeature get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static CheckFeedInboxTabFeature_Factory create(Provider<FeatureConfigRepository> provider) {
        return new CheckFeedInboxTabFeature_Factory(provider);
    }

    public static CheckFeedInboxTabFeature newInstance(FeatureConfigRepository featureConfigRepository) {
        return new CheckFeedInboxTabFeature(featureConfigRepository);
    }
}
