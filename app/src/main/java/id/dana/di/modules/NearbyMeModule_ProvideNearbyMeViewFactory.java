package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.nearbyme.NearbyMeContract;

/* loaded from: classes4.dex */
public final class NearbyMeModule_ProvideNearbyMeViewFactory implements Factory<NearbyMeContract.View> {
    private final NearbyMeModule BuiltInFictitiousFunctionClassFactory;

    private NearbyMeModule_ProvideNearbyMeViewFactory(NearbyMeModule nearbyMeModule) {
        this.BuiltInFictitiousFunctionClassFactory = nearbyMeModule;
    }

    public static NearbyMeModule_ProvideNearbyMeViewFactory PlaceComponentResult(NearbyMeModule nearbyMeModule) {
        return new NearbyMeModule_ProvideNearbyMeViewFactory(nearbyMeModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (NearbyMeContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory());
    }
}
