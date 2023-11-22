package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.savings.contract.SavingContract;
import id.dana.savings.presenter.SavingPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SavingModule_ProvideSavingPresenterFactory implements Factory<SavingContract.Presenter> {
    private final Provider<SavingPresenter> KClassImpl$Data$declaredNonStaticMembers$2;
    private final SavingModule MyBillsEntityDataFactory;

    private SavingModule_ProvideSavingPresenterFactory(SavingModule savingModule, Provider<SavingPresenter> provider) {
        this.MyBillsEntityDataFactory = savingModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static SavingModule_ProvideSavingPresenterFactory BuiltInFictitiousFunctionClassFactory(SavingModule savingModule, Provider<SavingPresenter> provider) {
        return new SavingModule_ProvideSavingPresenterFactory(savingModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SavingContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
