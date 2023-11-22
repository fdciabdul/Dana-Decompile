package id.dana.contract.homeinfo;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.homeinfo.HomeInfoContract;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class HomeInfoModule_ProvidePresenterFactory implements Factory<HomeInfoContract.Presenter> {
    private final HomeInfoModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<HomeInfoPresenter> KClassImpl$Data$declaredNonStaticMembers$2;

    private HomeInfoModule_ProvidePresenterFactory(HomeInfoModule homeInfoModule, Provider<HomeInfoPresenter> provider) {
        this.BuiltInFictitiousFunctionClassFactory = homeInfoModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static HomeInfoModule_ProvidePresenterFactory MyBillsEntityDataFactory(HomeInfoModule homeInfoModule, Provider<HomeInfoPresenter> provider) {
        return new HomeInfoModule_ProvidePresenterFactory(homeInfoModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (HomeInfoContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
