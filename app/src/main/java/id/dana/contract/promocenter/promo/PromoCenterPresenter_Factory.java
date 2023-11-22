package id.dana.contract.promocenter.promo;

import dagger.internal.Factory;
import id.dana.contract.promocenter.promo.PromoCenterContract;
import id.dana.domain.promocenter.interactor.GetPromoAds;
import id.dana.domain.promocenter.interactor.GetPromoAdsConfigFeature;
import id.dana.domain.promocenter.interactor.GetPromoCategorizedList;
import id.dana.domain.promocenter.interactor.GetPromoList;
import id.dana.promocenter.mapper.PromoAdsModelMapper;
import id.dana.promocenter.mapper.PromoCategoryModelMapper;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class PromoCenterPresenter_Factory implements Factory<PromoCenterPresenter> {
    private final Provider<GetPromoAdsConfigFeature> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetPromoCategorizedList> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<PromoAdsModelMapper> MyBillsEntityDataFactory;
    private final Provider<PromoCategoryModelMapper> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<GetPromoList> PlaceComponentResult;
    private final Provider<GetPromoAds> getAuthRequestContext;
    private final Provider<PromoCenterContract.View> getErrorConfigVersion;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PromoCenterPresenter(this.getErrorConfigVersion.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.MyBillsEntityDataFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.PlaceComponentResult.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.getAuthRequestContext.get());
    }
}
