package id.dana.domain.qriscrossborder.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetQrisCrossBorderContent_Factory implements Factory<GetQrisCrossBorderContent> {
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;

    public GetQrisCrossBorderContent_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetQrisCrossBorderContent get() {
        return newInstance(this.featureConfigRepositoryProvider.get());
    }

    public static GetQrisCrossBorderContent_Factory create(Provider<FeatureConfigRepository> provider) {
        return new GetQrisCrossBorderContent_Factory(provider);
    }

    public static GetQrisCrossBorderContent newInstance(FeatureConfigRepository featureConfigRepository) {
        return new GetQrisCrossBorderContent(featureConfigRepository);
    }
}
