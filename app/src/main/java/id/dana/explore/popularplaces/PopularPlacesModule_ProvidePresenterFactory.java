package id.dana.explore.popularplaces;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.explore.popularplaces.PopularPlacesContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class PopularPlacesModule_ProvidePresenterFactory implements Factory<PopularPlacesContract.Presenter> {
    private final PopularPlacesModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<PopularPlacesPresenter> KClassImpl$Data$declaredNonStaticMembers$2;

    private PopularPlacesModule_ProvidePresenterFactory(PopularPlacesModule popularPlacesModule, Provider<PopularPlacesPresenter> provider) {
        this.BuiltInFictitiousFunctionClassFactory = popularPlacesModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static PopularPlacesModule_ProvidePresenterFactory BuiltInFictitiousFunctionClassFactory(PopularPlacesModule popularPlacesModule, Provider<PopularPlacesPresenter> provider) {
        return new PopularPlacesModule_ProvidePresenterFactory(popularPlacesModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PopularPlacesContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
