package id.dana.explore.domain.globalsearch.interactor;

import dagger.internal.Factory;
import id.dana.explore.domain.globalsearch.GlobalSearchRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetHintSwipeVisibilityState_Factory implements Factory<GetHintSwipeVisibilityState> {
    private final Provider<GlobalSearchRepository> PlaceComponentResult;

    private GetHintSwipeVisibilityState_Factory(Provider<GlobalSearchRepository> provider) {
        this.PlaceComponentResult = provider;
    }

    public static GetHintSwipeVisibilityState_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<GlobalSearchRepository> provider) {
        return new GetHintSwipeVisibilityState_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetHintSwipeVisibilityState(this.PlaceComponentResult.get());
    }
}
