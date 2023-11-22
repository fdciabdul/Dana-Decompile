package id.dana.onlinemerchant.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.onlinemerchant.OnlineMerchantContract;

/* loaded from: classes5.dex */
public final class OnlineMerchantModule_ProvideView$app_productionReleaseFactory implements Factory<OnlineMerchantContract.View> {
    private final OnlineMerchantModule PlaceComponentResult;

    public static OnlineMerchantContract.View KClassImpl$Data$declaredNonStaticMembers$2(OnlineMerchantModule onlineMerchantModule) {
        return (OnlineMerchantContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(onlineMerchantModule.getPlaceComponentResult());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (OnlineMerchantContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getPlaceComponentResult());
    }
}
