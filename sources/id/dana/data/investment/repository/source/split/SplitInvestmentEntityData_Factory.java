package id.dana.data.investment.repository.source.split;

import dagger.internal.Factory;
import id.dana.data.toggle.SplitFacade;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SplitInvestmentEntityData_Factory implements Factory<SplitInvestmentEntityData> {
    private final Provider<SplitFacade> KClassImpl$Data$declaredNonStaticMembers$2;

    private SplitInvestmentEntityData_Factory(Provider<SplitFacade> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static SplitInvestmentEntityData_Factory MyBillsEntityDataFactory(Provider<SplitFacade> provider) {
        return new SplitInvestmentEntityData_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SplitInvestmentEntityData(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
