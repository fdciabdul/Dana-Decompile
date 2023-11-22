package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.sendmoney.external.SendMoneyExternalContract;
import id.dana.sendmoney.external.SendMoneyExternalPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SendMoneyExternalModule_ProvidePresenterFactory implements Factory<SendMoneyExternalContract.Presenter> {
    private final Provider<SendMoneyExternalPresenter> KClassImpl$Data$declaredNonStaticMembers$2;
    private final SendMoneyExternalModule PlaceComponentResult;

    private SendMoneyExternalModule_ProvidePresenterFactory(SendMoneyExternalModule sendMoneyExternalModule, Provider<SendMoneyExternalPresenter> provider) {
        this.PlaceComponentResult = sendMoneyExternalModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static SendMoneyExternalModule_ProvidePresenterFactory MyBillsEntityDataFactory(SendMoneyExternalModule sendMoneyExternalModule, Provider<SendMoneyExternalPresenter> provider) {
        return new SendMoneyExternalModule_ProvidePresenterFactory(sendMoneyExternalModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SendMoneyExternalContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
