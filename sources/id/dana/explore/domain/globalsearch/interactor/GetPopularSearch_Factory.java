package id.dana.explore.domain.globalsearch.interactor;

import dagger.internal.Factory;
import id.dana.explore.domain.globalsearch.GlobalSearchRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetPopularSearch_Factory implements Factory<GetPopularSearch> {
    private final Provider<GlobalSearchRepository> KClassImpl$Data$declaredNonStaticMembers$2;

    private GetPopularSearch_Factory(Provider<GlobalSearchRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static GetPopularSearch_Factory PlaceComponentResult(Provider<GlobalSearchRepository> provider) {
        return new GetPopularSearch_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetPopularSearch(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
