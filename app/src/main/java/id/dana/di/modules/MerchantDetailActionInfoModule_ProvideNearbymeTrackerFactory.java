package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.nearbyme.tracker.NearbyAnalyticTracker;
import id.dana.nearbyme.tracker.NearbyDefaultTracker;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class MerchantDetailActionInfoModule_ProvideNearbymeTrackerFactory implements Factory<NearbyAnalyticTracker> {
    private final MerchantDetailActionInfoModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<NearbyDefaultTracker> getAuthRequestContext;

    private MerchantDetailActionInfoModule_ProvideNearbymeTrackerFactory(MerchantDetailActionInfoModule merchantDetailActionInfoModule, Provider<NearbyDefaultTracker> provider) {
        this.BuiltInFictitiousFunctionClassFactory = merchantDetailActionInfoModule;
        this.getAuthRequestContext = provider;
    }

    public static MerchantDetailActionInfoModule_ProvideNearbymeTrackerFactory PlaceComponentResult(MerchantDetailActionInfoModule merchantDetailActionInfoModule, Provider<NearbyDefaultTracker> provider) {
        return new MerchantDetailActionInfoModule_ProvideNearbymeTrackerFactory(merchantDetailActionInfoModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (NearbyAnalyticTracker) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(this.getAuthRequestContext.get()));
    }
}
