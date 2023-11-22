package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.savings.contract.SavingConfigContract;
import id.dana.savings.presenter.SavingConfigPresenter;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class SavingConfigModule_ProvideSavingPresenterFactory implements Factory<SavingConfigContract.Presenter> {
    private final Provider<SavingConfigPresenter> BuiltInFictitiousFunctionClassFactory;
    private final SavingConfigModule KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SavingConfigContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
