package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.sendmoney.confirmation.SendMoneyConfirmationContract;

/* loaded from: classes4.dex */
public final class SendMoneyConfirmationModule_ProvideViewFactory implements Factory<SendMoneyConfirmationContract.View> {
    private final SendMoneyConfirmationModule MyBillsEntityDataFactory;

    private SendMoneyConfirmationModule_ProvideViewFactory(SendMoneyConfirmationModule sendMoneyConfirmationModule) {
        this.MyBillsEntityDataFactory = sendMoneyConfirmationModule;
    }

    public static SendMoneyConfirmationModule_ProvideViewFactory MyBillsEntityDataFactory(SendMoneyConfirmationModule sendMoneyConfirmationModule) {
        return new SendMoneyConfirmationModule_ProvideViewFactory(sendMoneyConfirmationModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SendMoneyConfirmationContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2());
    }
}
