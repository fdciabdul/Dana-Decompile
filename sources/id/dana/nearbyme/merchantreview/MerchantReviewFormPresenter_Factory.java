package id.dana.nearbyme.merchantreview;

import dagger.internal.Factory;
import id.dana.domain.nearbyme.interactor.merchantreview.GetUGCBannerConfig;
import id.dana.domain.nearbyme.interactor.merchantreview.SaveDismissedMerchantReviewForm;
import id.dana.domain.nearbyme.interactor.merchantreview.SaveLastTimeMerchantReviewFormShown;
import id.dana.feeds.domain.activation.interactor.GetFeedStatus;
import id.dana.feeds.domain.share.interactor.SaveShareFeedConsent;
import id.dana.nearbyme.merchantreview.MerchantReviewFormContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class MerchantReviewFormPresenter_Factory implements Factory<MerchantReviewFormPresenter> {
    private final Provider<SaveDismissedMerchantReviewForm> BuiltInFictitiousFunctionClassFactory;
    private final Provider<SaveShareFeedConsent> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetUGCBannerConfig> MyBillsEntityDataFactory;
    private final Provider<GetFeedStatus> PlaceComponentResult;
    private final Provider<SaveLastTimeMerchantReviewFormShown> getAuthRequestContext;
    private final Provider<MerchantReviewFormContract.View> lookAheadTest;

    private MerchantReviewFormPresenter_Factory(Provider<MerchantReviewFormContract.View> provider, Provider<SaveLastTimeMerchantReviewFormShown> provider2, Provider<SaveDismissedMerchantReviewForm> provider3, Provider<SaveShareFeedConsent> provider4, Provider<GetFeedStatus> provider5, Provider<GetUGCBannerConfig> provider6) {
        this.lookAheadTest = provider;
        this.getAuthRequestContext = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider4;
        this.PlaceComponentResult = provider5;
        this.MyBillsEntityDataFactory = provider6;
    }

    public static MerchantReviewFormPresenter_Factory BuiltInFictitiousFunctionClassFactory(Provider<MerchantReviewFormContract.View> provider, Provider<SaveLastTimeMerchantReviewFormShown> provider2, Provider<SaveDismissedMerchantReviewForm> provider3, Provider<SaveShareFeedConsent> provider4, Provider<GetFeedStatus> provider5, Provider<GetUGCBannerConfig> provider6) {
        return new MerchantReviewFormPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MerchantReviewFormPresenter(this.lookAheadTest.get(), this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.PlaceComponentResult.get(), this.MyBillsEntityDataFactory.get());
    }
}
