package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.nearbyme.merchantdetail.tracker.MerchantDetailAnalyticTracker;
import id.dana.nearbyme.merchantdetail.tracker.MerchantDetailMixpanelTrackers;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class MerchantDetailReviewModule_ProvideMerchantDetailAnalyticTrackerFactory implements Factory<MerchantDetailAnalyticTracker> {
    private final MerchantDetailReviewModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<MerchantDetailMixpanelTrackers> PlaceComponentResult;

    private MerchantDetailReviewModule_ProvideMerchantDetailAnalyticTrackerFactory(MerchantDetailReviewModule merchantDetailReviewModule, Provider<MerchantDetailMixpanelTrackers> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = merchantDetailReviewModule;
        this.PlaceComponentResult = provider;
    }

    public static MerchantDetailReviewModule_ProvideMerchantDetailAnalyticTrackerFactory PlaceComponentResult(MerchantDetailReviewModule merchantDetailReviewModule, Provider<MerchantDetailMixpanelTrackers> provider) {
        return new MerchantDetailReviewModule_ProvideMerchantDetailAnalyticTrackerFactory(merchantDetailReviewModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MerchantDetailAnalyticTracker) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(this.PlaceComponentResult.get()));
    }
}
