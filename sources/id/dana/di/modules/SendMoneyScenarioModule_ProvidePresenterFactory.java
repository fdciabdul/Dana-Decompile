package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.sendmoney.recipienthome.SendMoneyScenariosContract;
import id.dana.sendmoney.recipienthome.SendMoneyScenariosPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SendMoneyScenarioModule_ProvidePresenterFactory implements Factory<SendMoneyScenariosContract.Presenter> {
    private final SendMoneyScenarioModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<SendMoneyScenariosPresenter> PlaceComponentResult;

    private SendMoneyScenarioModule_ProvidePresenterFactory(SendMoneyScenarioModule sendMoneyScenarioModule, Provider<SendMoneyScenariosPresenter> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = sendMoneyScenarioModule;
        this.PlaceComponentResult = provider;
    }

    public static SendMoneyScenarioModule_ProvidePresenterFactory PlaceComponentResult(SendMoneyScenarioModule sendMoneyScenarioModule, Provider<SendMoneyScenariosPresenter> provider) {
        return new SendMoneyScenarioModule_ProvidePresenterFactory(sendMoneyScenarioModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SendMoneyScenariosContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult.get()));
    }
}
