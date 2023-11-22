package id.dana.contract.nearbyme;

import dagger.internal.Factory;
import id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.domain.miniprogram.interactor.GetReverseGeocodeByLocation;
import id.dana.domain.nearbyme.interactor.GetNearbyRankingConfig;
import id.dana.domain.nearbyme.interactor.GetNearbyShopsPromo;
import id.dana.domain.nearbyme.interactor.GetNearbyShopsWithPagination;
import id.dana.domain.nearbyplaces.interactor.GetChainQueryResult;
import id.dana.domain.nearbyplaces.interactor.GetListNearbyLocation;
import id.dana.drawable.ShopRankingCalculator;
import id.dana.nearbyme.NearbyPromoModelMapper;
import id.dana.nearbyme.mapper.NearbyShopsModelMapper;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class NearbyMerchantLocationSearchPresenter_Factory implements Factory<NearbyMerchantLocationSearchPresenter> {
    private final Provider<GetChainQueryResult> BuiltInFictitiousFunctionClassFactory;
    private final Provider<NearbyMerchantLocationSearchContract.View> GetContactSyncConfig;
    private final Provider<DeviceInformationProvider> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetNearbyShopsPromo> MyBillsEntityDataFactory;
    private final Provider<NearbyShopsModelMapper> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<GetNearbyRankingConfig> PlaceComponentResult;
    private final Provider<GetListNearbyLocation> getAuthRequestContext;
    private final Provider<GetNearbyShopsWithPagination> getErrorConfigVersion;
    private final Provider<GetReverseGeocodeByLocation> lookAheadTest;
    private final Provider<NearbyPromoModelMapper> moveToNextValue;
    private final Provider<ShopRankingCalculator> scheduleImpl;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new NearbyMerchantLocationSearchPresenter(this.GetContactSyncConfig.get(), this.getAuthRequestContext.get(), this.getErrorConfigVersion.get(), this.MyBillsEntityDataFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.lookAheadTest.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.moveToNextValue.get(), this.PlaceComponentResult.get(), this.scheduleImpl.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
