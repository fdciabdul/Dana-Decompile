package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.savings.contract.SavingTopUpContract;
import id.dana.savings.presenter.SavingTopUpPresenter;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class SavingTopUpModule_ProvideSavingPresenterFactory implements Factory<SavingTopUpContract.Presenter> {
    private final Provider<SavingTopUpPresenter> BuiltInFictitiousFunctionClassFactory;
    private final SavingTopUpModule MyBillsEntityDataFactory;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SavingTopUpContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
