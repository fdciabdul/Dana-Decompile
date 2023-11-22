package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.expresspurchase.ExpressPurchaseEntityRepository;
import id.dana.domain.expresspurchase.repository.ExpressPurchaseRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideExpressPurchaseEntityRepositoryFactory implements Factory<ExpressPurchaseRepository> {
    private final ApplicationModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<ExpressPurchaseEntityRepository> getAuthRequestContext;

    private ApplicationModule_ProvideExpressPurchaseEntityRepositoryFactory(ApplicationModule applicationModule, Provider<ExpressPurchaseEntityRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = applicationModule;
        this.getAuthRequestContext = provider;
    }

    public static ApplicationModule_ProvideExpressPurchaseEntityRepositoryFactory KClassImpl$Data$declaredNonStaticMembers$2(ApplicationModule applicationModule, Provider<ExpressPurchaseEntityRepository> provider) {
        return new ApplicationModule_ProvideExpressPurchaseEntityRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ExpressPurchaseRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(this.getAuthRequestContext.get()));
    }
}
