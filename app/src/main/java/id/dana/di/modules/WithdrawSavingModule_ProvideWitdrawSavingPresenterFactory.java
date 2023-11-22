package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.savings.WithdrawSavingPresenter;
import id.dana.savings.contract.WithdrawSavingContract;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class WithdrawSavingModule_ProvideWitdrawSavingPresenterFactory implements Factory<WithdrawSavingContract.Presenter> {
    private final WithdrawSavingModule PlaceComponentResult;
    private final Provider<WithdrawSavingPresenter> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (WithdrawSavingContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.MyBillsEntityDataFactory(this.getAuthRequestContext.get()));
    }
}
