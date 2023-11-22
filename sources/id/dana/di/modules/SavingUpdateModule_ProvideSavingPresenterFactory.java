package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.savings.contract.SavingUpdateContract;
import id.dana.savings.presenter.SavingUpdatePresenter;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class SavingUpdateModule_ProvideSavingPresenterFactory implements Factory<SavingUpdateContract.Presenter> {
    private final Provider<SavingUpdatePresenter> BuiltInFictitiousFunctionClassFactory;
    private final SavingUpdateModule PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SavingUpdateContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
