package id.dana.nearbyme.merchantdetail.viewcomponent;

import dagger.internal.Factory;
import id.dana.domain.nearbyme.interactor.CreateDanaDealsVoucherOrder;
import id.dana.domain.nearbyme.interactor.GetMerchantDanaDeals;
import id.dana.domain.nearbyme.interactor.GetShopPromoAndDeals;
import id.dana.nearbyme.NearbyPromoModelMapper;
import id.dana.nearbyme.mapper.DanaDealsOrderRequestMapper;
import id.dana.nearbyme.merchantdetail.mapper.CreateProductVoucherOrderMapper;
import id.dana.nearbyme.merchantdetail.mapper.MerchantDanaDealsMapper;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDanaDealsContract;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class MerchantDanaDealsPresenter_Factory implements Factory<MerchantDanaDealsPresenter> {
    private final Provider<MerchantDanaDealsMapper> BuiltInFictitiousFunctionClassFactory;
    private final Provider<CreateDanaDealsVoucherOrder> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetMerchantDanaDeals> MyBillsEntityDataFactory;
    private final Provider<CreateProductVoucherOrderMapper> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<DanaDealsOrderRequestMapper> PlaceComponentResult;
    private final Provider<GetShopPromoAndDeals> getAuthRequestContext;
    private final Provider<MerchantDanaDealsContract.View> moveToNextValue;
    private final Provider<NearbyPromoModelMapper> scheduleImpl;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MerchantDanaDealsPresenter(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.getAuthRequestContext.get(), this.MyBillsEntityDataFactory.get(), this.moveToNextValue.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.scheduleImpl.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.PlaceComponentResult.get());
    }
}
