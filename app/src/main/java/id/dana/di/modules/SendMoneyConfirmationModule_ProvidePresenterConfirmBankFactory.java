package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.sendmoney.confirmation.SendMoneyConfirmationBankContract;
import id.dana.sendmoney.confirmation.SendMoneyConfirmationBankPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SendMoneyConfirmationModule_ProvidePresenterConfirmBankFactory implements Factory<SendMoneyConfirmationBankContract.Presenter> {
    private final Provider<SendMoneyConfirmationBankPresenter> BuiltInFictitiousFunctionClassFactory;
    private final SendMoneyConfirmationModule MyBillsEntityDataFactory;

    private SendMoneyConfirmationModule_ProvidePresenterConfirmBankFactory(SendMoneyConfirmationModule sendMoneyConfirmationModule, Provider<SendMoneyConfirmationBankPresenter> provider) {
        this.MyBillsEntityDataFactory = sendMoneyConfirmationModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static SendMoneyConfirmationModule_ProvidePresenterConfirmBankFactory MyBillsEntityDataFactory(SendMoneyConfirmationModule sendMoneyConfirmationModule, Provider<SendMoneyConfirmationBankPresenter> provider) {
        return new SendMoneyConfirmationModule_ProvidePresenterConfirmBankFactory(sendMoneyConfirmationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SendMoneyConfirmationBankContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
