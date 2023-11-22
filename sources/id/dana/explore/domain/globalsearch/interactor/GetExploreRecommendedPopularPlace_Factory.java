package id.dana.explore.domain.globalsearch.interactor;

import dagger.internal.Factory;
import id.dana.explore.domain.globalsearch.GlobalSearchRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetExploreRecommendedPopularPlace_Factory implements Factory<GetExploreRecommendedPopularPlace> {
    private final Provider<GlobalSearchRepository> getAuthRequestContext;

    private GetExploreRecommendedPopularPlace_Factory(Provider<GlobalSearchRepository> provider) {
        this.getAuthRequestContext = provider;
    }

    public static GetExploreRecommendedPopularPlace_Factory getAuthRequestContext(Provider<GlobalSearchRepository> provider) {
        return new GetExploreRecommendedPopularPlace_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetExploreRecommendedPopularPlace(this.getAuthRequestContext.get());
    }
}
