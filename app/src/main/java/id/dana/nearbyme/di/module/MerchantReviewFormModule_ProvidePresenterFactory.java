package id.dana.nearbyme.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.nearbyme.merchantreview.MerchantReviewFormContract;
import id.dana.nearbyme.merchantreview.MerchantReviewFormPresenter;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class MerchantReviewFormModule_ProvidePresenterFactory implements Factory<MerchantReviewFormContract.Presenter> {
    private final Provider<MerchantReviewFormPresenter> KClassImpl$Data$declaredNonStaticMembers$2;
    private final MerchantReviewFormModule getAuthRequestContext;

    private MerchantReviewFormModule_ProvidePresenterFactory(MerchantReviewFormModule merchantReviewFormModule, Provider<MerchantReviewFormPresenter> provider) {
        this.getAuthRequestContext = merchantReviewFormModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static MerchantReviewFormModule_ProvidePresenterFactory PlaceComponentResult(MerchantReviewFormModule merchantReviewFormModule, Provider<MerchantReviewFormPresenter> provider) {
        return new MerchantReviewFormModule_ProvidePresenterFactory(merchantReviewFormModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MerchantReviewFormContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
