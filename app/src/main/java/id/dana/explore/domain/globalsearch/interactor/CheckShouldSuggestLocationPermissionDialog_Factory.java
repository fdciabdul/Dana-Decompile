package id.dana.explore.domain.globalsearch.interactor;

import dagger.internal.Factory;
import id.dana.explore.domain.globalsearch.GlobalSearchRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class CheckShouldSuggestLocationPermissionDialog_Factory implements Factory<CheckShouldSuggestLocationPermissionDialog> {
    private final Provider<GlobalSearchRepository> getAuthRequestContext;

    private CheckShouldSuggestLocationPermissionDialog_Factory(Provider<GlobalSearchRepository> provider) {
        this.getAuthRequestContext = provider;
    }

    public static CheckShouldSuggestLocationPermissionDialog_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<GlobalSearchRepository> provider) {
        return new CheckShouldSuggestLocationPermissionDialog_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CheckShouldSuggestLocationPermissionDialog(this.getAuthRequestContext.get());
    }
}
