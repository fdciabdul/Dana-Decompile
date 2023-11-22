package id.dana.domain.nearbyme.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetNearbyWidgetVisibility_Factory implements Factory<GetNearbyWidgetVisibility> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public GetNearbyWidgetVisibility_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetNearbyWidgetVisibility get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static GetNearbyWidgetVisibility_Factory create(Provider<FeatureConfigRepository> provider) {
        return new GetNearbyWidgetVisibility_Factory(provider);
    }

    public static GetNearbyWidgetVisibility newInstance(FeatureConfigRepository featureConfigRepository) {
        return new GetNearbyWidgetVisibility(featureConfigRepository);
    }
}
