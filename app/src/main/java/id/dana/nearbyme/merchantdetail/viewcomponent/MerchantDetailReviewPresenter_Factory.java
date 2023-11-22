package id.dana.nearbyme.merchantdetail.viewcomponent;

import dagger.internal.Factory;
import id.dana.domain.nearbyme.interactor.GetMerchantReviews;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDetailReviewContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class MerchantDetailReviewPresenter_Factory implements Factory<MerchantDetailReviewPresenter> {
    private final Provider<GetMerchantReviews> MyBillsEntityDataFactory;
    private final Provider<MerchantDetailReviewContract.View> getAuthRequestContext;

    private MerchantDetailReviewPresenter_Factory(Provider<MerchantDetailReviewContract.View> provider, Provider<GetMerchantReviews> provider2) {
        this.getAuthRequestContext = provider;
        this.MyBillsEntityDataFactory = provider2;
    }

    public static MerchantDetailReviewPresenter_Factory MyBillsEntityDataFactory(Provider<MerchantDetailReviewContract.View> provider, Provider<GetMerchantReviews> provider2) {
        return new MerchantDetailReviewPresenter_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MerchantDetailReviewPresenter(this.getAuthRequestContext.get(), this.MyBillsEntityDataFactory.get());
    }
}
