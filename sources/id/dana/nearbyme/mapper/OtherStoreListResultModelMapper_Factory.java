package id.dana.nearbyme.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class OtherStoreListResultModelMapper_Factory implements Factory<OtherStoreListResultModelMapper> {
    private final Provider<MerchantSubcategoriesMapper> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ContactAddressMapper> MyBillsEntityDataFactory;
    private final Provider<ShopOpenHourListMapper> PlaceComponentResult;
    private final Provider<PromoInfoMapper> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new OtherStoreListResultModelMapper(this.PlaceComponentResult.get(), this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
