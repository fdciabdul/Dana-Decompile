package id.dana.contract.homeinfo;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.homeinfo.HomeRevampContract;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class HomeRevampModule_ProvidePresenterFactory implements Factory<HomeRevampContract.Presenter> {
    private final Provider<HomeRevampPresenter> KClassImpl$Data$declaredNonStaticMembers$2;
    private final HomeRevampModule MyBillsEntityDataFactory;

    private HomeRevampModule_ProvidePresenterFactory(HomeRevampModule homeRevampModule, Provider<HomeRevampPresenter> provider) {
        this.MyBillsEntityDataFactory = homeRevampModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static HomeRevampModule_ProvidePresenterFactory getAuthRequestContext(HomeRevampModule homeRevampModule, Provider<HomeRevampPresenter> provider) {
        return new HomeRevampModule_ProvidePresenterFactory(homeRevampModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (HomeRevampContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
