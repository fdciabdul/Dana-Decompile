package id.dana.contract.globalsearch;

import dagger.internal.Factory;
import id.dana.contract.globalsearch.GlobalSearchBottomSheetContract;
import id.dana.domain.nearbyme.interactor.GetMerchantInfo;
import id.dana.nearbyme.merchantdetail.mapper.MerchantInfoMapper;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GlobalSearchBottomSheetPresenter_Factory implements Factory<GlobalSearchBottomSheetPresenter> {
    private final Provider<GlobalSearchBottomSheetContract.View> MyBillsEntityDataFactory;
    private final Provider<MerchantInfoMapper> PlaceComponentResult;
    private final Provider<GetMerchantInfo> getAuthRequestContext;

    private GlobalSearchBottomSheetPresenter_Factory(Provider<GlobalSearchBottomSheetContract.View> provider, Provider<GetMerchantInfo> provider2, Provider<MerchantInfoMapper> provider3) {
        this.MyBillsEntityDataFactory = provider;
        this.getAuthRequestContext = provider2;
        this.PlaceComponentResult = provider3;
    }

    public static GlobalSearchBottomSheetPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<GlobalSearchBottomSheetContract.View> provider, Provider<GetMerchantInfo> provider2, Provider<MerchantInfoMapper> provider3) {
        return new GlobalSearchBottomSheetPresenter_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GlobalSearchBottomSheetPresenter(this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get(), this.PlaceComponentResult.get());
    }
}
