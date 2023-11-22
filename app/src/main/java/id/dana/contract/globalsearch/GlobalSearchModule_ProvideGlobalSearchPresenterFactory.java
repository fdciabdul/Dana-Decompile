package id.dana.contract.globalsearch;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.globalsearch.GlobalSearchContract;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GlobalSearchModule_ProvideGlobalSearchPresenterFactory implements Factory<GlobalSearchContract.Presenter> {
    private final Provider<GlobalSearchPresenter> BuiltInFictitiousFunctionClassFactory;
    private final GlobalSearchModule PlaceComponentResult;

    private GlobalSearchModule_ProvideGlobalSearchPresenterFactory(GlobalSearchModule globalSearchModule, Provider<GlobalSearchPresenter> provider) {
        this.PlaceComponentResult = globalSearchModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static GlobalSearchModule_ProvideGlobalSearchPresenterFactory getAuthRequestContext(GlobalSearchModule globalSearchModule, Provider<GlobalSearchPresenter> provider) {
        return new GlobalSearchModule_ProvideGlobalSearchPresenterFactory(globalSearchModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (GlobalSearchContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
