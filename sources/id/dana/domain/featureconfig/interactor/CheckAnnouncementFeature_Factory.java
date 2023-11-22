package id.dana.domain.featureconfig.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CheckAnnouncementFeature_Factory implements Factory<CheckAnnouncementFeature> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public CheckAnnouncementFeature_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CheckAnnouncementFeature get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static CheckAnnouncementFeature_Factory create(Provider<FeatureConfigRepository> provider) {
        return new CheckAnnouncementFeature_Factory(provider);
    }

    public static CheckAnnouncementFeature newInstance(FeatureConfigRepository featureConfigRepository) {
        return new CheckAnnouncementFeature(featureConfigRepository);
    }
}
