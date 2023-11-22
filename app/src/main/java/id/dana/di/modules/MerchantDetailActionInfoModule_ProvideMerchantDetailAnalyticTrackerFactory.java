package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.nearbyme.merchantdetail.tracker.MerchantDetailAnalyticTracker;
import id.dana.nearbyme.merchantdetail.tracker.MerchantDetailMixpanelTrackers;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class MerchantDetailActionInfoModule_ProvideMerchantDetailAnalyticTrackerFactory implements Factory<MerchantDetailAnalyticTracker> {
    private final Provider<MerchantDetailMixpanelTrackers> KClassImpl$Data$declaredNonStaticMembers$2;
    private final MerchantDetailActionInfoModule PlaceComponentResult;

    private MerchantDetailActionInfoModule_ProvideMerchantDetailAnalyticTrackerFactory(MerchantDetailActionInfoModule merchantDetailActionInfoModule, Provider<MerchantDetailMixpanelTrackers> provider) {
        this.PlaceComponentResult = merchantDetailActionInfoModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static MerchantDetailActionInfoModule_ProvideMerchantDetailAnalyticTrackerFactory MyBillsEntityDataFactory(MerchantDetailActionInfoModule merchantDetailActionInfoModule, Provider<MerchantDetailMixpanelTrackers> provider) {
        return new MerchantDetailActionInfoModule_ProvideMerchantDetailAnalyticTrackerFactory(merchantDetailActionInfoModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MerchantDetailAnalyticTracker) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
