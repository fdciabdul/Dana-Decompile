package id.dana.nearbyme.merchantdetail;

import dagger.internal.Factory;
import id.dana.domain.nearbyme.interactor.GetMerchantInfo;
import id.dana.nearbyme.merchantdetail.MerchantDetailContract;
import id.dana.nearbyme.merchantdetail.mapper.MerchantDetailMapper;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class MerchantDetailPresenter_Factory implements Factory<MerchantDetailPresenter> {
    private final Provider<MerchantDetailContract.View> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetMerchantInfo> MyBillsEntityDataFactory;
    private final Provider<MerchantDetailMapper> getAuthRequestContext;

    private MerchantDetailPresenter_Factory(Provider<MerchantDetailContract.View> provider, Provider<GetMerchantInfo> provider2, Provider<MerchantDetailMapper> provider3) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.getAuthRequestContext = provider3;
    }

    public static MerchantDetailPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<MerchantDetailContract.View> provider, Provider<GetMerchantInfo> provider2, Provider<MerchantDetailMapper> provider3) {
        return new MerchantDetailPresenter_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MerchantDetailPresenter(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get());
    }
}
