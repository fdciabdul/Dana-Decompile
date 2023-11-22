package id.dana.electronicmoney.bank.mandiri;

import dagger.internal.Factory;
import id.dana.domain.electronicmoney.interactor.ConfirmUpdateBalanceEmoney;
import id.dana.domain.electronicmoney.interactor.GenerateEmoneyTransId;
import id.dana.domain.electronicmoney.interactor.GetEmoneyReversal;
import id.dana.domain.electronicmoney.interactor.GetTopUpCommandEmoney;
import id.dana.domain.electronicmoney.interactor.InquireBalanceEmoney;
import id.dana.electronicmoney.tracker.ElectronicMoneyAnalyticTracker;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class MandiriEmoneyManager_Factory implements Factory<MandiriEmoneyManager> {
    private final Provider<GenerateEmoneyTransId> BuiltInFictitiousFunctionClassFactory;
    private final Provider<ElectronicMoneyAnalyticTracker> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ConfirmUpdateBalanceEmoney> MyBillsEntityDataFactory;
    private final Provider<InquireBalanceEmoney> PlaceComponentResult;
    private final Provider<GetEmoneyReversal> getAuthRequestContext;
    private final Provider<GetTopUpCommandEmoney> lookAheadTest;

    private MandiriEmoneyManager_Factory(Provider<InquireBalanceEmoney> provider, Provider<GenerateEmoneyTransId> provider2, Provider<GetEmoneyReversal> provider3, Provider<GetTopUpCommandEmoney> provider4, Provider<ConfirmUpdateBalanceEmoney> provider5, Provider<ElectronicMoneyAnalyticTracker> provider6) {
        this.PlaceComponentResult = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
        this.getAuthRequestContext = provider3;
        this.lookAheadTest = provider4;
        this.MyBillsEntityDataFactory = provider5;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider6;
    }

    public static MandiriEmoneyManager_Factory BuiltInFictitiousFunctionClassFactory(Provider<InquireBalanceEmoney> provider, Provider<GenerateEmoneyTransId> provider2, Provider<GetEmoneyReversal> provider3, Provider<GetTopUpCommandEmoney> provider4, Provider<ConfirmUpdateBalanceEmoney> provider5, Provider<ElectronicMoneyAnalyticTracker> provider6) {
        return new MandiriEmoneyManager_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        MandiriEmoneyManager mandiriEmoneyManager = new MandiriEmoneyManager(this.PlaceComponentResult.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.getAuthRequestContext.get(), this.lookAheadTest.get(), this.MyBillsEntityDataFactory.get());
        MandiriEmoneyManager_MembersInjector.getAuthRequestContext(mandiriEmoneyManager, this.KClassImpl$Data$declaredNonStaticMembers$2.get());
        return mandiriEmoneyManager;
    }
}
