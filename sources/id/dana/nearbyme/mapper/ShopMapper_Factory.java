package id.dana.nearbyme.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class ShopMapper_Factory implements Factory<ShopMapper> {
    private final Provider<PromoInfoMapper> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ShopOpenHourListMapper> MyBillsEntityDataFactory;
    private final Provider<MerchantSubcategoriesMapper> PlaceComponentResult;
    private final Provider<ContactAddressMapper> getAuthRequestContext;

    private ShopMapper_Factory(Provider<ContactAddressMapper> provider, Provider<PromoInfoMapper> provider2, Provider<ShopOpenHourListMapper> provider3, Provider<MerchantSubcategoriesMapper> provider4) {
        this.getAuthRequestContext = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.MyBillsEntityDataFactory = provider3;
        this.PlaceComponentResult = provider4;
    }

    public static ShopMapper_Factory PlaceComponentResult(Provider<ContactAddressMapper> provider, Provider<PromoInfoMapper> provider2, Provider<ShopOpenHourListMapper> provider3, Provider<MerchantSubcategoriesMapper> provider4) {
        return new ShopMapper_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ShopMapper(this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get(), this.PlaceComponentResult.get());
    }
}
