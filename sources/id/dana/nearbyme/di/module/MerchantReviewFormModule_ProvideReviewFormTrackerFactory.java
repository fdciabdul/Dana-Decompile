package id.dana.nearbyme.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.nearbyme.merchantreview.tracker.MerchantReviewFormAnalyticTracker;
import id.dana.nearbyme.merchantreview.tracker.MerchantReviewFormMixpanelTracker;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class MerchantReviewFormModule_ProvideReviewFormTrackerFactory implements Factory<MerchantReviewFormAnalyticTracker> {
    private final MerchantReviewFormModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<MerchantReviewFormMixpanelTracker> MyBillsEntityDataFactory;

    private MerchantReviewFormModule_ProvideReviewFormTrackerFactory(MerchantReviewFormModule merchantReviewFormModule, Provider<MerchantReviewFormMixpanelTracker> provider) {
        this.BuiltInFictitiousFunctionClassFactory = merchantReviewFormModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static MerchantReviewFormModule_ProvideReviewFormTrackerFactory MyBillsEntityDataFactory(MerchantReviewFormModule merchantReviewFormModule, Provider<MerchantReviewFormMixpanelTracker> provider) {
        return new MerchantReviewFormModule_ProvideReviewFormTrackerFactory(merchantReviewFormModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MerchantReviewFormAnalyticTracker) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(this.MyBillsEntityDataFactory.get()));
    }
}
