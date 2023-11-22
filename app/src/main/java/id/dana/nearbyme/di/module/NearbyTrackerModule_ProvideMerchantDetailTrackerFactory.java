package id.dana.nearbyme.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.nearbyme.merchantdetail.tracker.MerchantDetailAnalyticTracker;
import id.dana.nearbyme.merchantdetail.tracker.MerchantDetailMixpanelTrackers;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class NearbyTrackerModule_ProvideMerchantDetailTrackerFactory implements Factory<MerchantDetailAnalyticTracker> {
    private final Provider<MerchantDetailMixpanelTrackers> MyBillsEntityDataFactory;
    private final NearbyTrackerModule PlaceComponentResult;

    private NearbyTrackerModule_ProvideMerchantDetailTrackerFactory(NearbyTrackerModule nearbyTrackerModule, Provider<MerchantDetailMixpanelTrackers> provider) {
        this.PlaceComponentResult = nearbyTrackerModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static NearbyTrackerModule_ProvideMerchantDetailTrackerFactory getAuthRequestContext(NearbyTrackerModule nearbyTrackerModule, Provider<MerchantDetailMixpanelTrackers> provider) {
        return new NearbyTrackerModule_ProvideMerchantDetailTrackerFactory(nearbyTrackerModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MerchantDetailAnalyticTracker) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getAuthRequestContext(this.MyBillsEntityDataFactory.get()));
    }
}
