package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.sendmoney.recipienthome.SendMoneyScenariosContract;

/* loaded from: classes4.dex */
public final class SendMoneyScenarioModule_ProvideViewFactory implements Factory<SendMoneyScenariosContract.View> {
    private final SendMoneyScenarioModule KClassImpl$Data$declaredNonStaticMembers$2;

    private SendMoneyScenarioModule_ProvideViewFactory(SendMoneyScenarioModule sendMoneyScenarioModule) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = sendMoneyScenarioModule;
    }

    public static SendMoneyScenarioModule_ProvideViewFactory getAuthRequestContext(SendMoneyScenarioModule sendMoneyScenarioModule) {
        return new SendMoneyScenarioModule_ProvideViewFactory(sendMoneyScenarioModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SendMoneyScenariosContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext());
    }
}
