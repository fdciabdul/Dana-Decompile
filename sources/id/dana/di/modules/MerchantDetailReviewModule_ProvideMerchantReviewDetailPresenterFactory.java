package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDetailReviewContract;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDetailReviewPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class MerchantDetailReviewModule_ProvideMerchantReviewDetailPresenterFactory implements Factory<MerchantDetailReviewContract.Presenter> {
    private final MerchantDetailReviewModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<MerchantDetailReviewPresenter> getAuthRequestContext;

    private MerchantDetailReviewModule_ProvideMerchantReviewDetailPresenterFactory(MerchantDetailReviewModule merchantDetailReviewModule, Provider<MerchantDetailReviewPresenter> provider) {
        this.BuiltInFictitiousFunctionClassFactory = merchantDetailReviewModule;
        this.getAuthRequestContext = provider;
    }

    public static MerchantDetailReviewModule_ProvideMerchantReviewDetailPresenterFactory PlaceComponentResult(MerchantDetailReviewModule merchantDetailReviewModule, Provider<MerchantDetailReviewPresenter> provider) {
        return new MerchantDetailReviewModule_ProvideMerchantReviewDetailPresenterFactory(merchantDetailReviewModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MerchantDetailReviewContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.get()));
    }
}
