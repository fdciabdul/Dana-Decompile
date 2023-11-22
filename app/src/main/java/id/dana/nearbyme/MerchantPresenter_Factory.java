package id.dana.nearbyme;

import dagger.internal.Factory;
import id.dana.domain.merchant.interactor.CheckMerchantCategoriesFeature;
import id.dana.domain.merchant.interactor.GetMerchantCategories;
import id.dana.domain.merchant.interactor.GetNewMerchantCategories;
import id.dana.domain.merchant.interactor.InitNewMerchantCategories;
import id.dana.nearbyme.MerchantContract;
import id.dana.nearbyme.mapper.MerchantCategoriesMapper;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class MerchantPresenter_Factory implements Factory<MerchantPresenter> {
    private final Provider<CheckMerchantCategoriesFeature> BuiltInFictitiousFunctionClassFactory;
    private final Provider<InitNewMerchantCategories> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetMerchantCategories> MyBillsEntityDataFactory;
    private final Provider<MerchantCategoriesMapper> PlaceComponentResult;
    private final Provider<GetNewMerchantCategories> getAuthRequestContext;
    private final Provider<MerchantContract.View> scheduleImpl;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MerchantPresenter(this.scheduleImpl.get(), this.MyBillsEntityDataFactory.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.getAuthRequestContext.get(), this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
