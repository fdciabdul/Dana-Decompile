package id.dana.data.userconsent.repository;

import dagger.internal.Factory;
import id.dana.data.account.repository.AccountEntityRepository;
import id.dana.data.toggle.SplitFacade;
import id.dana.data.user.UserEntityRepository;
import id.dana.data.userconsent.repository.source.local.UserConsentPreference;
import id.dana.data.userconsent.repository.source.network.NetworkUserConsentEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class UserConsentEntityRepository_Factory implements Factory<UserConsentEntityRepository> {
    private final Provider<AccountEntityRepository> BuiltInFictitiousFunctionClassFactory;
    private final Provider<NetworkUserConsentEntityData> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<UserEntityRepository> MyBillsEntityDataFactory;
    private final Provider<UserConsentPreference> PlaceComponentResult;
    private final Provider<SplitFacade> getAuthRequestContext;

    private UserConsentEntityRepository_Factory(Provider<SplitFacade> provider, Provider<NetworkUserConsentEntityData> provider2, Provider<UserConsentPreference> provider3, Provider<AccountEntityRepository> provider4, Provider<UserEntityRepository> provider5) {
        this.getAuthRequestContext = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.PlaceComponentResult = provider3;
        this.BuiltInFictitiousFunctionClassFactory = provider4;
        this.MyBillsEntityDataFactory = provider5;
    }

    public static UserConsentEntityRepository_Factory PlaceComponentResult(Provider<SplitFacade> provider, Provider<NetworkUserConsentEntityData> provider2, Provider<UserConsentPreference> provider3, Provider<AccountEntityRepository> provider4, Provider<UserEntityRepository> provider5) {
        return new UserConsentEntityRepository_Factory(provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new UserConsentEntityRepository(this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.PlaceComponentResult.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get());
    }
}
