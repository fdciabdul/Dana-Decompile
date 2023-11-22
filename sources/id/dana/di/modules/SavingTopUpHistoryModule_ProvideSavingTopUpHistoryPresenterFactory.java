package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.savings.contract.SavingTopUpHistoryContract;
import id.dana.savings.presenter.SavingTopUpHistoryPresenter;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class SavingTopUpHistoryModule_ProvideSavingTopUpHistoryPresenterFactory implements Factory<SavingTopUpHistoryContract.Presenter> {
    private final Provider<SavingTopUpHistoryPresenter> PlaceComponentResult;
    private final SavingTopUpHistoryModule getAuthRequestContext;

    private SavingTopUpHistoryModule_ProvideSavingTopUpHistoryPresenterFactory(SavingTopUpHistoryModule savingTopUpHistoryModule, Provider<SavingTopUpHistoryPresenter> provider) {
        this.getAuthRequestContext = savingTopUpHistoryModule;
        this.PlaceComponentResult = provider;
    }

    public static SavingTopUpHistoryModule_ProvideSavingTopUpHistoryPresenterFactory PlaceComponentResult(SavingTopUpHistoryModule savingTopUpHistoryModule, Provider<SavingTopUpHistoryPresenter> provider) {
        return new SavingTopUpHistoryModule_ProvideSavingTopUpHistoryPresenterFactory(savingTopUpHistoryModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SavingTopUpHistoryContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.get()));
    }
}
