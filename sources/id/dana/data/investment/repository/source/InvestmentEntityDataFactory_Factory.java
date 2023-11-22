package id.dana.data.investment.repository.source;

import dagger.internal.Factory;
import id.dana.data.investment.repository.source.network.NetworkInvestmentEntityData;
import id.dana.data.investment.repository.source.split.SplitInvestmentEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class InvestmentEntityDataFactory_Factory implements Factory<InvestmentEntityDataFactory> {
    private final Provider<NetworkInvestmentEntityData> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<SplitInvestmentEntityData> MyBillsEntityDataFactory;

    private InvestmentEntityDataFactory_Factory(Provider<NetworkInvestmentEntityData> provider, Provider<SplitInvestmentEntityData> provider2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.MyBillsEntityDataFactory = provider2;
    }

    public static InvestmentEntityDataFactory_Factory BuiltInFictitiousFunctionClassFactory(Provider<NetworkInvestmentEntityData> provider, Provider<SplitInvestmentEntityData> provider2) {
        return new InvestmentEntityDataFactory_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new InvestmentEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get());
    }
}
