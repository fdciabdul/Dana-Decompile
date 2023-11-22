package id.dana.mapper;

import dagger.internal.Factory;
import id.dana.base.BaseResponseMapper;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class HomeInfoMapper_Factory implements Factory<HomeInfoMapper> {
    private final Provider<BaseResponseMapper> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ThirdPartyServicesMapper> MyBillsEntityDataFactory;
    private final Provider<CurrencyAmountModelMapper> getAuthRequestContext;

    private HomeInfoMapper_Factory(Provider<BaseResponseMapper> provider, Provider<CurrencyAmountModelMapper> provider2, Provider<ThirdPartyServicesMapper> provider3) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.getAuthRequestContext = provider2;
        this.MyBillsEntityDataFactory = provider3;
    }

    public static HomeInfoMapper_Factory PlaceComponentResult(Provider<BaseResponseMapper> provider, Provider<CurrencyAmountModelMapper> provider2, Provider<ThirdPartyServicesMapper> provider3) {
        return new HomeInfoMapper_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new HomeInfoMapper(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.getAuthRequestContext.get(), this.MyBillsEntityDataFactory.get());
    }
}
