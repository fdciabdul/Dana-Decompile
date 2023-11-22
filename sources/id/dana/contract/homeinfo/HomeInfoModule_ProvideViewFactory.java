package id.dana.contract.homeinfo;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.homeinfo.HomeInfoContract;

/* loaded from: classes4.dex */
public final class HomeInfoModule_ProvideViewFactory implements Factory<HomeInfoContract.View> {
    private final HomeInfoModule KClassImpl$Data$declaredNonStaticMembers$2;

    private HomeInfoModule_ProvideViewFactory(HomeInfoModule homeInfoModule) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = homeInfoModule;
    }

    public static HomeInfoModule_ProvideViewFactory KClassImpl$Data$declaredNonStaticMembers$2(HomeInfoModule homeInfoModule) {
        return new HomeInfoModule_ProvideViewFactory(homeInfoModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (HomeInfoContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2());
    }
}
