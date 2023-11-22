package id.dana.explore.domain.globalsearch.interactor;

import dagger.internal.Factory;
import id.dana.explore.domain.globalsearch.GlobalSearchRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SaveLocationPermissionSuggestionState_Factory implements Factory<SaveLocationPermissionSuggestionState> {
    private final Provider<GlobalSearchRepository> KClassImpl$Data$declaredNonStaticMembers$2;

    private SaveLocationPermissionSuggestionState_Factory(Provider<GlobalSearchRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static SaveLocationPermissionSuggestionState_Factory PlaceComponentResult(Provider<GlobalSearchRepository> provider) {
        return new SaveLocationPermissionSuggestionState_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SaveLocationPermissionSuggestionState(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
