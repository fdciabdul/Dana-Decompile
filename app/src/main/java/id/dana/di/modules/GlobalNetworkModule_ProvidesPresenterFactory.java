package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.globalnetwork.currency.GlobalNetworkContract;
import id.dana.globalnetwork.currency.GlobalNetworkPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GlobalNetworkModule_ProvidesPresenterFactory implements Factory<GlobalNetworkContract.Presenter> {
    private final GlobalNetworkModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GlobalNetworkPresenter> MyBillsEntityDataFactory;

    private GlobalNetworkModule_ProvidesPresenterFactory(GlobalNetworkModule globalNetworkModule, Provider<GlobalNetworkPresenter> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = globalNetworkModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static GlobalNetworkModule_ProvidesPresenterFactory PlaceComponentResult(GlobalNetworkModule globalNetworkModule, Provider<GlobalNetworkPresenter> provider) {
        return new GlobalNetworkModule_ProvidesPresenterFactory(globalNetworkModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (GlobalNetworkContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.get()));
    }
}
