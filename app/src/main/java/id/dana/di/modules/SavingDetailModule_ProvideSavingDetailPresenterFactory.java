package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.savings.contract.SavingDetailContract;
import id.dana.savings.presenter.SavingDetailPresenter;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class SavingDetailModule_ProvideSavingDetailPresenterFactory implements Factory<SavingDetailContract.Presenter> {
    private final SavingDetailModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<SavingDetailPresenter> MyBillsEntityDataFactory;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SavingDetailContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.get()));
    }
}
