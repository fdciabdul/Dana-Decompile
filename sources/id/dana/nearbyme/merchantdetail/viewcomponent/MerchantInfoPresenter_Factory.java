package id.dana.nearbyme.merchantdetail.viewcomponent;

import dagger.internal.Factory;
import id.dana.domain.nearbyme.interactor.GetMerchantInfo;
import id.dana.domain.nearbyme.interactor.GetNearbyShopsPromo;
import id.dana.nearbyme.NearbyPromoModelMapper;
import id.dana.nearbyme.merchantdetail.mapper.MerchantInfoMapper;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantInfoContract;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class MerchantInfoPresenter_Factory implements Factory<MerchantInfoPresenter> {
    private final Provider<MerchantInfoMapper> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetMerchantInfo> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetNearbyShopsPromo> MyBillsEntityDataFactory;
    private final Provider<MerchantInfoContract.View> PlaceComponentResult;
    private final Provider<NearbyPromoModelMapper> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MerchantInfoPresenter(this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
