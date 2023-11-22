package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract;
import id.dana.contract.nearbyme.NearbyMerchantLocationSearchPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class NearbyMerchantLocationSearchModule_ProvidePresenter$app_productionReleaseFactory implements Factory<NearbyMerchantLocationSearchContract.Presenter> {
    private final Provider<NearbyMerchantLocationSearchPresenter> MyBillsEntityDataFactory;
    private final NearbyMerchantLocationSearchModule getAuthRequestContext;

    public static NearbyMerchantLocationSearchContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2(NearbyMerchantLocationSearchModule nearbyMerchantLocationSearchModule, NearbyMerchantLocationSearchPresenter nearbyMerchantLocationSearchPresenter) {
        return (NearbyMerchantLocationSearchContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(nearbyMerchantLocationSearchModule.getAuthRequestContext(nearbyMerchantLocationSearchPresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (NearbyMerchantLocationSearchContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getAuthRequestContext(this.MyBillsEntityDataFactory.get()));
    }
}
