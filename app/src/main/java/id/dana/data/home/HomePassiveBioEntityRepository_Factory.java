package id.dana.data.home;

import dagger.internal.Factory;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class HomePassiveBioEntityRepository_Factory implements Factory<HomePassiveBioEntityRepository> {
    private final Provider<HomePassiveBioPreference> BuiltInFictitiousFunctionClassFactory;
    private final Provider<AccountEntityDataFactory> KClassImpl$Data$declaredNonStaticMembers$2;

    private HomePassiveBioEntityRepository_Factory(Provider<HomePassiveBioPreference> provider, Provider<AccountEntityDataFactory> provider2) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
    }

    public static HomePassiveBioEntityRepository_Factory BuiltInFictitiousFunctionClassFactory(Provider<HomePassiveBioPreference> provider, Provider<AccountEntityDataFactory> provider2) {
        return new HomePassiveBioEntityRepository_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new HomePassiveBioEntityRepository(this.BuiltInFictitiousFunctionClassFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
