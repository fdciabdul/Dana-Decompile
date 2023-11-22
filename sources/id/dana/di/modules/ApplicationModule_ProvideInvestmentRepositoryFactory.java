package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.investment.repository.InvestmentEntityRepository;
import id.dana.domain.investment.InvestmentRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideInvestmentRepositoryFactory implements Factory<InvestmentRepository> {
    private final ApplicationModule MyBillsEntityDataFactory;
    private final Provider<InvestmentEntityRepository> getAuthRequestContext;

    private ApplicationModule_ProvideInvestmentRepositoryFactory(ApplicationModule applicationModule, Provider<InvestmentEntityRepository> provider) {
        this.MyBillsEntityDataFactory = applicationModule;
        this.getAuthRequestContext = provider;
    }

    public static ApplicationModule_ProvideInvestmentRepositoryFactory getAuthRequestContext(ApplicationModule applicationModule, Provider<InvestmentEntityRepository> provider) {
        return new ApplicationModule_ProvideInvestmentRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (InvestmentRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.PlaceComponentResult(this.getAuthRequestContext.get()));
    }
}
