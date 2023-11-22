package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.sendmoney.confirmation.SendMoneyConfirmationContract;
import id.dana.sendmoney.confirmation.SendMoneyConfirmationPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SendMoneyConfirmationModule_ProvidePresenterFactory implements Factory<SendMoneyConfirmationContract.Presenter> {
    private final SendMoneyConfirmationModule MyBillsEntityDataFactory;
    private final Provider<SendMoneyConfirmationPresenter> PlaceComponentResult;

    private SendMoneyConfirmationModule_ProvidePresenterFactory(SendMoneyConfirmationModule sendMoneyConfirmationModule, Provider<SendMoneyConfirmationPresenter> provider) {
        this.MyBillsEntityDataFactory = sendMoneyConfirmationModule;
        this.PlaceComponentResult = provider;
    }

    public static SendMoneyConfirmationModule_ProvidePresenterFactory KClassImpl$Data$declaredNonStaticMembers$2(SendMoneyConfirmationModule sendMoneyConfirmationModule, Provider<SendMoneyConfirmationPresenter> provider) {
        return new SendMoneyConfirmationModule_ProvidePresenterFactory(sendMoneyConfirmationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SendMoneyConfirmationContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.PlaceComponentResult(this.PlaceComponentResult.get()));
    }
}
