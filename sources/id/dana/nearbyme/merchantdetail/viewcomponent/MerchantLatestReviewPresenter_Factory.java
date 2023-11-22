package id.dana.nearbyme.merchantdetail.viewcomponent;

import dagger.internal.Factory;
import id.dana.domain.nearbyme.interactor.GetMerchantReviews;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantLatestReviewContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class MerchantLatestReviewPresenter_Factory implements Factory<MerchantLatestReviewPresenter> {
    private final Provider<MerchantLatestReviewContract.View> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetMerchantReviews> PlaceComponentResult;

    private MerchantLatestReviewPresenter_Factory(Provider<MerchantLatestReviewContract.View> provider, Provider<GetMerchantReviews> provider2) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.PlaceComponentResult = provider2;
    }

    public static MerchantLatestReviewPresenter_Factory BuiltInFictitiousFunctionClassFactory(Provider<MerchantLatestReviewContract.View> provider, Provider<GetMerchantReviews> provider2) {
        return new MerchantLatestReviewPresenter_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MerchantLatestReviewPresenter(this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get());
    }
}
