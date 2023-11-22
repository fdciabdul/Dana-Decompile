package id.dana.richview.promoclaim;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.domain.featureconfig.interactor.GetPromoClaimConfig;
import id.dana.domain.promotion.interactor.GetPromoClaimBanner;
import id.dana.mapper.LeaderboardMapper;
import id.dana.richview.promoclaim.PromoClaimContract;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class PromoClaimPresenter_Factory implements Factory<PromoClaimPresenter> {
    private final Provider<GetPromoClaimBanner> BuiltInFictitiousFunctionClassFactory;
    private final Provider<LeaderboardMapper> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<Context> MyBillsEntityDataFactory;
    private final Provider<GetPromoClaimConfig> PlaceComponentResult;
    private final Provider<PromoClaimContract.View> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PromoClaimPresenter(this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
