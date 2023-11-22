package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.drawable.search.NearbySearchContract;

/* loaded from: classes4.dex */
public final class NearbySearchModule_ProvideNearbySearchViewFactory implements Factory<NearbySearchContract.View> {
    private final NearbySearchModule PlaceComponentResult;

    public static NearbySearchContract.View PlaceComponentResult(NearbySearchModule nearbySearchModule) {
        return (NearbySearchContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(nearbySearchModule.getMyBillsEntityDataFactory());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (NearbySearchContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getMyBillsEntityDataFactory());
    }
}
