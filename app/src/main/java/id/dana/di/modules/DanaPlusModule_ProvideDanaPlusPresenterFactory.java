package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.investment.contract.DanaPlusContract;
import id.dana.investment.presenter.DanaPlusPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DanaPlusModule_ProvideDanaPlusPresenterFactory implements Factory<DanaPlusContract.Presenter> {
    private final DanaPlusModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<DanaPlusPresenter> getAuthRequestContext;

    private DanaPlusModule_ProvideDanaPlusPresenterFactory(DanaPlusModule danaPlusModule, Provider<DanaPlusPresenter> provider) {
        this.BuiltInFictitiousFunctionClassFactory = danaPlusModule;
        this.getAuthRequestContext = provider;
    }

    public static DanaPlusModule_ProvideDanaPlusPresenterFactory KClassImpl$Data$declaredNonStaticMembers$2(DanaPlusModule danaPlusModule, Provider<DanaPlusPresenter> provider) {
        return new DanaPlusModule_ProvideDanaPlusPresenterFactory(danaPlusModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (DanaPlusContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext.get()));
    }
}
