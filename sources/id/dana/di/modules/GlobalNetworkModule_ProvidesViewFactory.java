package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.globalnetwork.currency.GlobalNetworkContract;

/* loaded from: classes4.dex */
public final class GlobalNetworkModule_ProvidesViewFactory implements Factory<GlobalNetworkContract.View> {
    private final GlobalNetworkModule PlaceComponentResult;

    private GlobalNetworkModule_ProvidesViewFactory(GlobalNetworkModule globalNetworkModule) {
        this.PlaceComponentResult = globalNetworkModule;
    }

    public static GlobalNetworkModule_ProvidesViewFactory MyBillsEntityDataFactory(GlobalNetworkModule globalNetworkModule) {
        return new GlobalNetworkModule_ProvidesViewFactory(globalNetworkModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (GlobalNetworkContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.PlaceComponentResult());
    }
}
