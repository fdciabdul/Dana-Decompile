package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract;

/* loaded from: classes4.dex */
public final class NearbyMerchantLocationSearchModule_ProvideView$app_productionReleaseFactory implements Factory<NearbyMerchantLocationSearchContract.View> {
    private final NearbyMerchantLocationSearchModule BuiltInFictitiousFunctionClassFactory;

    public static NearbyMerchantLocationSearchContract.View PlaceComponentResult(NearbyMerchantLocationSearchModule nearbyMerchantLocationSearchModule) {
        return (NearbyMerchantLocationSearchContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(nearbyMerchantLocationSearchModule.getKClassImpl$Data$declaredNonStaticMembers$2());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (NearbyMerchantLocationSearchContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.getKClassImpl$Data$declaredNonStaticMembers$2());
    }
}
