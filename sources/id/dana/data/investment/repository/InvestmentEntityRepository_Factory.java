package id.dana.data.investment.repository;

import dagger.internal.Factory;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.investment.repository.source.InvestmentEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class InvestmentEntityRepository_Factory implements Factory<InvestmentEntityRepository> {
    private final Provider<HoldLoginV1EntityRepository> BuiltInFictitiousFunctionClassFactory;
    private final Provider<InvestmentEntityDataFactory> MyBillsEntityDataFactory;
    private final Provider<AccountEntityDataFactory> getAuthRequestContext;

    private InvestmentEntityRepository_Factory(Provider<AccountEntityDataFactory> provider, Provider<InvestmentEntityDataFactory> provider2, Provider<HoldLoginV1EntityRepository> provider3) {
        this.getAuthRequestContext = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
    }

    public static InvestmentEntityRepository_Factory PlaceComponentResult(Provider<AccountEntityDataFactory> provider, Provider<InvestmentEntityDataFactory> provider2, Provider<HoldLoginV1EntityRepository> provider3) {
        return new InvestmentEntityRepository_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new InvestmentEntityRepository(this.getAuthRequestContext.get(), this.MyBillsEntityDataFactory.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
