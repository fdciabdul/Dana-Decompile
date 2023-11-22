package id.dana.explore.domain.globalsearch.interactor;

import dagger.internal.Factory;
import id.dana.explore.domain.globalsearch.GlobalSearchRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SaveRecentSearch_Factory implements Factory<SaveRecentSearch> {
    private final Provider<GlobalSearchRepository> PlaceComponentResult;

    private SaveRecentSearch_Factory(Provider<GlobalSearchRepository> provider) {
        this.PlaceComponentResult = provider;
    }

    public static SaveRecentSearch_Factory MyBillsEntityDataFactory(Provider<GlobalSearchRepository> provider) {
        return new SaveRecentSearch_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SaveRecentSearch(this.PlaceComponentResult.get());
    }
}
