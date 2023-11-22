package id.dana.domain.featureconfig.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CheckFaceLoginFeature_Factory implements Factory<CheckFaceLoginFeature> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public CheckFaceLoginFeature_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CheckFaceLoginFeature get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static CheckFaceLoginFeature_Factory create(Provider<FeatureConfigRepository> provider) {
        return new CheckFaceLoginFeature_Factory(provider);
    }

    public static CheckFaceLoginFeature newInstance(FeatureConfigRepository featureConfigRepository) {
        return new CheckFaceLoginFeature(featureConfigRepository);
    }
}
