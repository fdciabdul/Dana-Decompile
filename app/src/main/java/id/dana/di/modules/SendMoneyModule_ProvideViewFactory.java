package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.sendmoney.SendMoneyContract;

/* loaded from: classes4.dex */
public final class SendMoneyModule_ProvideViewFactory implements Factory<SendMoneyContract.View> {
    private final SendMoneyModule MyBillsEntityDataFactory;

    private SendMoneyModule_ProvideViewFactory(SendMoneyModule sendMoneyModule) {
        this.MyBillsEntityDataFactory = sendMoneyModule;
    }

    public static SendMoneyModule_ProvideViewFactory BuiltInFictitiousFunctionClassFactory(SendMoneyModule sendMoneyModule) {
        return new SendMoneyModule_ProvideViewFactory(sendMoneyModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SendMoneyContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2());
    }
}
