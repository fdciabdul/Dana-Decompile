package id.dana.explore.domain.userpersonalization.interactor;

import dagger.internal.Factory;
import id.dana.domain.account.AccountRepository;
import id.dana.explore.domain.globalsearch.GlobalSearchRepository;
import id.dana.explore.domain.userpersonalization.UserPersonalizationRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class CheckShouldShowUserPersonalization_Factory implements Factory<CheckShouldShowUserPersonalization> {
    private final Provider<GlobalSearchRepository> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<UserPersonalizationRepository> PlaceComponentResult;
    private final Provider<AccountRepository> getAuthRequestContext;

    private CheckShouldShowUserPersonalization_Factory(Provider<UserPersonalizationRepository> provider, Provider<AccountRepository> provider2, Provider<GlobalSearchRepository> provider3) {
        this.PlaceComponentResult = provider;
        this.getAuthRequestContext = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
    }

    public static CheckShouldShowUserPersonalization_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<UserPersonalizationRepository> provider, Provider<AccountRepository> provider2, Provider<GlobalSearchRepository> provider3) {
        return new CheckShouldShowUserPersonalization_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CheckShouldShowUserPersonalization(this.PlaceComponentResult.get(), this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
