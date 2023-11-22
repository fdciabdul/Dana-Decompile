package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.sendmoney.confirmation.SendMoneyConfirmationBankContract;

/* loaded from: classes4.dex */
public final class SendMoneyConfirmationModule_ProvideViewConfirmBankFactory implements Factory<SendMoneyConfirmationBankContract.View> {
    private final SendMoneyConfirmationModule PlaceComponentResult;

    private SendMoneyConfirmationModule_ProvideViewConfirmBankFactory(SendMoneyConfirmationModule sendMoneyConfirmationModule) {
        this.PlaceComponentResult = sendMoneyConfirmationModule;
    }

    public static SendMoneyConfirmationModule_ProvideViewConfirmBankFactory PlaceComponentResult(SendMoneyConfirmationModule sendMoneyConfirmationModule) {
        return new SendMoneyConfirmationModule_ProvideViewConfirmBankFactory(sendMoneyConfirmationModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SendMoneyConfirmationBankContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory());
    }
}
