package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.drawable.search.NearbySearchContract;
import id.dana.drawable.search.presenter.NearbySearchPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class NearbySearchModule_ProvideNearbySearchPresenterFactory implements Factory<NearbySearchContract.Presenter> {
    private final Provider<NearbySearchPresenter> BuiltInFictitiousFunctionClassFactory;
    private final NearbySearchModule MyBillsEntityDataFactory;

    public static NearbySearchContract.Presenter BuiltInFictitiousFunctionClassFactory(NearbySearchModule nearbySearchModule, NearbySearchPresenter nearbySearchPresenter) {
        return (NearbySearchContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(nearbySearchModule.PlaceComponentResult(nearbySearchPresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (NearbySearchContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
