package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.cashier.data.repository.CashierEntityRepository;
import id.dana.cashier.domain.CashierRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideCashierRepositoryFactory implements Factory<CashierRepository> {
    private final ApplicationModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<CashierEntityRepository> getAuthRequestContext;

    private ApplicationModule_ProvideCashierRepositoryFactory(ApplicationModule applicationModule, Provider<CashierEntityRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationModule;
        this.getAuthRequestContext = provider;
    }

    public static ApplicationModule_ProvideCashierRepositoryFactory getAuthRequestContext(ApplicationModule applicationModule, Provider<CashierEntityRepository> provider) {
        return new ApplicationModule_ProvideCashierRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (CashierRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext.get()));
    }
}
