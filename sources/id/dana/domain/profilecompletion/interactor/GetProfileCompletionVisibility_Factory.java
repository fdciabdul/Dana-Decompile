package id.dana.domain.profilecompletion.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetProfileCompletionVisibility_Factory implements Factory<GetProfileCompletionVisibility> {
    private final Provider<FeatureConfigRepository> featureConfigEntityRepoProvider;

    public GetProfileCompletionVisibility_Factory(Provider<FeatureConfigRepository> provider) {
        this.featureConfigEntityRepoProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetProfileCompletionVisibility get() {
        return newInstance(this.featureConfigEntityRepoProvider.get());
    }

    public static GetProfileCompletionVisibility_Factory create(Provider<FeatureConfigRepository> provider) {
        return new GetProfileCompletionVisibility_Factory(provider);
    }

    public static GetProfileCompletionVisibility newInstance(FeatureConfigRepository featureConfigRepository) {
        return new GetProfileCompletionVisibility(featureConfigRepository);
    }
}
