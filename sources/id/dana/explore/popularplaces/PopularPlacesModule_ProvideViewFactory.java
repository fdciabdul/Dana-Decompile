package id.dana.explore.popularplaces;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.explore.popularplaces.PopularPlacesContract;

/* loaded from: classes5.dex */
public final class PopularPlacesModule_ProvideViewFactory implements Factory<PopularPlacesContract.View> {
    private final PopularPlacesModule MyBillsEntityDataFactory;

    private PopularPlacesModule_ProvideViewFactory(PopularPlacesModule popularPlacesModule) {
        this.MyBillsEntityDataFactory = popularPlacesModule;
    }

    public static PopularPlacesModule_ProvideViewFactory PlaceComponentResult(PopularPlacesModule popularPlacesModule) {
        return new PopularPlacesModule_ProvideViewFactory(popularPlacesModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PopularPlacesContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getBuiltInFictitiousFunctionClassFactory());
    }
}
