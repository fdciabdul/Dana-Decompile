package id.dana.nearbyme.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.nearbyme.merchantreview.MerchantReviewFormContract;

/* loaded from: classes5.dex */
public final class MerchantReviewFormModule_ProvideViewFactory implements Factory<MerchantReviewFormContract.View> {
    private final MerchantReviewFormModule PlaceComponentResult;

    private MerchantReviewFormModule_ProvideViewFactory(MerchantReviewFormModule merchantReviewFormModule) {
        this.PlaceComponentResult = merchantReviewFormModule;
    }

    public static MerchantReviewFormModule_ProvideViewFactory getAuthRequestContext(MerchantReviewFormModule merchantReviewFormModule) {
        return new MerchantReviewFormModule_ProvideViewFactory(merchantReviewFormModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MerchantReviewFormContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getPlaceComponentResult());
    }
}
