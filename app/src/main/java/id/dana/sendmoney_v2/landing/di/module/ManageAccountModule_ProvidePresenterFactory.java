package id.dana.sendmoney_v2.landing.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.sendmoney_v2.landing.contract.ManageAccountContract;
import id.dana.sendmoney_v2.landing.contract.ManageAccountPresenter;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class ManageAccountModule_ProvidePresenterFactory implements Factory<ManageAccountContract.Presenter> {
    private final ManageAccountModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ManageAccountPresenter> getAuthRequestContext;

    private ManageAccountModule_ProvidePresenterFactory(ManageAccountModule manageAccountModule, Provider<ManageAccountPresenter> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = manageAccountModule;
        this.getAuthRequestContext = provider;
    }

    public static ManageAccountModule_ProvidePresenterFactory getAuthRequestContext(ManageAccountModule manageAccountModule, Provider<ManageAccountPresenter> provider) {
        return new ManageAccountModule_ProvidePresenterFactory(manageAccountModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ManageAccountContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(this.getAuthRequestContext.get()));
    }
}
