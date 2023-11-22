package id.dana.nearbyme.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.nearbyme.homeshopping.tnc.HomeShoppingTncContract;
import id.dana.nearbyme.homeshopping.tnc.HomeShoppingTncPresenter;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class HomeShoppingTncModule_ProvidePresenterFactory implements Factory<HomeShoppingTncContract.Presenter> {
    private final Provider<HomeShoppingTncPresenter> PlaceComponentResult;
    private final HomeShoppingTncModule getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (HomeShoppingTncContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.get()));
    }
}
