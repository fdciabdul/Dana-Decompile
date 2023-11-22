package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.savings.contract.SavingCreateContract;
import id.dana.savings.presenter.SavingCreatePresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SavingCreateModule_ProvideSavingPresenterFactory implements Factory<SavingCreateContract.Presenter> {
    private final Provider<SavingCreatePresenter> BuiltInFictitiousFunctionClassFactory;
    private final SavingCreateModule KClassImpl$Data$declaredNonStaticMembers$2;

    private SavingCreateModule_ProvideSavingPresenterFactory(SavingCreateModule savingCreateModule, Provider<SavingCreatePresenter> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = savingCreateModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static SavingCreateModule_ProvideSavingPresenterFactory getAuthRequestContext(SavingCreateModule savingCreateModule, Provider<SavingCreatePresenter> provider) {
        return new SavingCreateModule_ProvideSavingPresenterFactory(savingCreateModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SavingCreateContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
