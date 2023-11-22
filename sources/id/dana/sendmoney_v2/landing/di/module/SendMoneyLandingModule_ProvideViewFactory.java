package id.dana.sendmoney_v2.landing.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.sendmoney_v2.landing.contract.KycAndDebitPayOptionContract;

/* loaded from: classes5.dex */
public final class SendMoneyLandingModule_ProvideViewFactory implements Factory<KycAndDebitPayOptionContract.View> {
    private final SendMoneyLandingModule PlaceComponentResult;

    private SendMoneyLandingModule_ProvideViewFactory(SendMoneyLandingModule sendMoneyLandingModule) {
        this.PlaceComponentResult = sendMoneyLandingModule;
    }

    public static SendMoneyLandingModule_ProvideViewFactory BuiltInFictitiousFunctionClassFactory(SendMoneyLandingModule sendMoneyLandingModule) {
        return new SendMoneyLandingModule_ProvideViewFactory(sendMoneyLandingModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (KycAndDebitPayOptionContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getMyBillsEntityDataFactory());
    }
}
