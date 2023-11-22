package id.dana.drawable.search.presenter;

import dagger.internal.Factory;
import id.dana.domain.nearbysearch.interactor.GetNearbyTrendingKeyword;
import id.dana.drawable.search.NearbySearchContract;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class NearbySearchPresenter_Factory implements Factory<NearbySearchPresenter> {
    private final Provider<GetNearbyTrendingKeyword> BuiltInFictitiousFunctionClassFactory;
    private final Provider<NearbySearchContract.View> PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new NearbySearchPresenter(this.PlaceComponentResult.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
