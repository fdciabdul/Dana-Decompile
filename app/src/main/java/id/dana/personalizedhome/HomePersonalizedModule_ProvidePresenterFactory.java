package id.dana.personalizedhome;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.personalizedhome.HomePersonalizationContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class HomePersonalizedModule_ProvidePresenterFactory implements Factory<HomePersonalizationContract.Presenter> {
    private final Provider<HomePersonalizationPresenter> BuiltInFictitiousFunctionClassFactory;
    private final HomePersonalizedModule PlaceComponentResult;

    private HomePersonalizedModule_ProvidePresenterFactory(HomePersonalizedModule homePersonalizedModule, Provider<HomePersonalizationPresenter> provider) {
        this.PlaceComponentResult = homePersonalizedModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static HomePersonalizedModule_ProvidePresenterFactory PlaceComponentResult(HomePersonalizedModule homePersonalizedModule, Provider<HomePersonalizationPresenter> provider) {
        return new HomePersonalizedModule_ProvidePresenterFactory(homePersonalizedModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (HomePersonalizationContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
