package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.nearbyme.NearbyMeContract;
import id.dana.contract.nearbyme.NearbyPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class NearbyMeModule_ProvideNearbyMePresenterFactory implements Factory<NearbyMeContract.Presenter> {
    private final Provider<NearbyPresenter> BuiltInFictitiousFunctionClassFactory;
    private final NearbyMeModule PlaceComponentResult;

    private NearbyMeModule_ProvideNearbyMePresenterFactory(NearbyMeModule nearbyMeModule, Provider<NearbyPresenter> provider) {
        this.PlaceComponentResult = nearbyMeModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static NearbyMeModule_ProvideNearbyMePresenterFactory getAuthRequestContext(NearbyMeModule nearbyMeModule, Provider<NearbyPresenter> provider) {
        return new NearbyMeModule_ProvideNearbyMePresenterFactory(nearbyMeModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (NearbyMeContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
