package id.dana.domain.qriscrossborder.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetQrisCrossBorderCountries_Factory implements Factory<GetQrisCrossBorderCountries> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public GetQrisCrossBorderCountries_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetQrisCrossBorderCountries get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static GetQrisCrossBorderCountries_Factory create(Provider<FeatureConfigRepository> provider) {
        return new GetQrisCrossBorderCountries_Factory(provider);
    }

    public static GetQrisCrossBorderCountries newInstance(FeatureConfigRepository featureConfigRepository) {
        return new GetQrisCrossBorderCountries(featureConfigRepository);
    }
}
