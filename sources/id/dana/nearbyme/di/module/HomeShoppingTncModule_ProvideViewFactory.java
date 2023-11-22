package id.dana.nearbyme.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.nearbyme.homeshopping.tnc.HomeShoppingTncContract;

/* loaded from: classes5.dex */
public final class HomeShoppingTncModule_ProvideViewFactory implements Factory<HomeShoppingTncContract.View> {
    private final HomeShoppingTncModule BuiltInFictitiousFunctionClassFactory;

    public static HomeShoppingTncContract.View getAuthRequestContext(HomeShoppingTncModule homeShoppingTncModule) {
        return (HomeShoppingTncContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(homeShoppingTncModule.getPlaceComponentResult());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (HomeShoppingTncContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.getPlaceComponentResult());
    }
}
