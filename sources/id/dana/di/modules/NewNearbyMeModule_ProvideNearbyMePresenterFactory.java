package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.nearbyme.NewNearbyMeContract;
import id.dana.contract.nearbyme.NewNearbyPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class NewNearbyMeModule_ProvideNearbyMePresenterFactory implements Factory<NewNearbyMeContract.Presenter> {
    private final Provider<NewNearbyPresenter> BuiltInFictitiousFunctionClassFactory;
    private final NewNearbyMeModule KClassImpl$Data$declaredNonStaticMembers$2;

    private NewNearbyMeModule_ProvideNearbyMePresenterFactory(NewNearbyMeModule newNearbyMeModule, Provider<NewNearbyPresenter> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = newNearbyMeModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static NewNearbyMeModule_ProvideNearbyMePresenterFactory PlaceComponentResult(NewNearbyMeModule newNearbyMeModule, Provider<NewNearbyPresenter> provider) {
        return new NewNearbyMeModule_ProvideNearbyMePresenterFactory(newNearbyMeModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (NewNearbyMeContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
