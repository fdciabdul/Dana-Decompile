package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.sendmoney.SendMoneyContract;
import id.dana.contract.sendmoney.SendMoneyPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SendMoneyModule_ProvidePresenterFactory implements Factory<SendMoneyContract.Presenter> {
    private final SendMoneyModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<SendMoneyPresenter> getAuthRequestContext;

    private SendMoneyModule_ProvidePresenterFactory(SendMoneyModule sendMoneyModule, Provider<SendMoneyPresenter> provider) {
        this.BuiltInFictitiousFunctionClassFactory = sendMoneyModule;
        this.getAuthRequestContext = provider;
    }

    public static SendMoneyModule_ProvidePresenterFactory MyBillsEntityDataFactory(SendMoneyModule sendMoneyModule, Provider<SendMoneyPresenter> provider) {
        return new SendMoneyModule_ProvidePresenterFactory(sendMoneyModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SendMoneyContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(this.getAuthRequestContext.get()));
    }
}
