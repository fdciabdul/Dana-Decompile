package id.dana.contract.homeinfo;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.homeinfo.HomeRevampContract;

/* loaded from: classes4.dex */
public final class HomeRevampModule_ProvideViewFactory implements Factory<HomeRevampContract.View> {
    private final HomeRevampModule getAuthRequestContext;

    private HomeRevampModule_ProvideViewFactory(HomeRevampModule homeRevampModule) {
        this.getAuthRequestContext = homeRevampModule;
    }

    public static HomeRevampModule_ProvideViewFactory PlaceComponentResult(HomeRevampModule homeRevampModule) {
        return new HomeRevampModule_ProvideViewFactory(homeRevampModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (HomeRevampContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getGetAuthRequestContext());
    }
}
