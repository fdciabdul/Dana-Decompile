package id.dana.sendmoney_v2.landing.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.sendmoney_v2.landing.contract.KycAndDebitPayOptionContract;
import id.dana.sendmoney_v2.landing.contract.SendMoneyHomePresenter;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SendMoneyLandingModule_ProvidePresenterFactory implements Factory<KycAndDebitPayOptionContract.Presenter> {
    private final Provider<SendMoneyHomePresenter> PlaceComponentResult;
    private final SendMoneyLandingModule getAuthRequestContext;

    private SendMoneyLandingModule_ProvidePresenterFactory(SendMoneyLandingModule sendMoneyLandingModule, Provider<SendMoneyHomePresenter> provider) {
        this.getAuthRequestContext = sendMoneyLandingModule;
        this.PlaceComponentResult = provider;
    }

    public static SendMoneyLandingModule_ProvidePresenterFactory KClassImpl$Data$declaredNonStaticMembers$2(SendMoneyLandingModule sendMoneyLandingModule, Provider<SendMoneyHomePresenter> provider) {
        return new SendMoneyLandingModule_ProvidePresenterFactory(sendMoneyLandingModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (KycAndDebitPayOptionContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.PlaceComponentResult(this.PlaceComponentResult.get()));
    }
}
