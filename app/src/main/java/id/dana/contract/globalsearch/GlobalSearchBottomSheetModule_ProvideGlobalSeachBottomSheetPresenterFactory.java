package id.dana.contract.globalsearch;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.globalsearch.GlobalSearchBottomSheetContract;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GlobalSearchBottomSheetModule_ProvideGlobalSeachBottomSheetPresenterFactory implements Factory<GlobalSearchBottomSheetContract.Presenter> {
    private final Provider<GlobalSearchBottomSheetPresenter> PlaceComponentResult;
    private final GlobalSearchBottomSheetModule getAuthRequestContext;

    private GlobalSearchBottomSheetModule_ProvideGlobalSeachBottomSheetPresenterFactory(GlobalSearchBottomSheetModule globalSearchBottomSheetModule, Provider<GlobalSearchBottomSheetPresenter> provider) {
        this.getAuthRequestContext = globalSearchBottomSheetModule;
        this.PlaceComponentResult = provider;
    }

    public static GlobalSearchBottomSheetModule_ProvideGlobalSeachBottomSheetPresenterFactory PlaceComponentResult(GlobalSearchBottomSheetModule globalSearchBottomSheetModule, Provider<GlobalSearchBottomSheetPresenter> provider) {
        return new GlobalSearchBottomSheetModule_ProvideGlobalSeachBottomSheetPresenterFactory(globalSearchBottomSheetModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (GlobalSearchBottomSheetContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult.get()));
    }
}
