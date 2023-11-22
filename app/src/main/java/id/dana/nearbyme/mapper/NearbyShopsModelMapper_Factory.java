package id.dana.nearbyme.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class NearbyShopsModelMapper_Factory implements Factory<NearbyShopsModelMapper> {
    private final Provider<ShopOpenHourListMapper> MyBillsEntityDataFactory;
    private final Provider<MerchantSubcategoriesMapper> getAuthRequestContext;

    private NearbyShopsModelMapper_Factory(Provider<MerchantSubcategoriesMapper> provider, Provider<ShopOpenHourListMapper> provider2) {
        this.getAuthRequestContext = provider;
        this.MyBillsEntityDataFactory = provider2;
    }

    public static NearbyShopsModelMapper_Factory BuiltInFictitiousFunctionClassFactory(Provider<MerchantSubcategoriesMapper> provider, Provider<ShopOpenHourListMapper> provider2) {
        return new NearbyShopsModelMapper_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new NearbyShopsModelMapper(this.getAuthRequestContext.get(), this.MyBillsEntityDataFactory.get());
    }
}
