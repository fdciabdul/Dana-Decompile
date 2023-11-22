package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.nearbyme.NearbyMeContract;
import id.dana.contract.nearbyme.NearbyPresenter;
import id.dana.di.PerActivity;
import id.dana.nearbyme.tracker.NearbyAnalyticTracker;
import id.dana.nearbyme.tracker.NearbyDefaultTracker;

@Module
/* loaded from: classes4.dex */
public class NearbyMeModule {
    private final NearbyMeContract.View PlaceComponentResult;

    @Provides
    @PerActivity
    public NearbyAnalyticTracker PlaceComponentResult(NearbyDefaultTracker nearbyDefaultTracker) {
        return nearbyDefaultTracker;
    }

    @Provides
    @PerActivity
    public NearbyMeContract.Presenter getAuthRequestContext(NearbyPresenter nearbyPresenter) {
        return nearbyPresenter;
    }

    public NearbyMeModule(NearbyMeContract.View view) {
        this.PlaceComponentResult = view;
    }

    @Provides
    @PerActivity
    public NearbyMeContract.View BuiltInFictitiousFunctionClassFactory() {
        return this.PlaceComponentResult;
    }
}
