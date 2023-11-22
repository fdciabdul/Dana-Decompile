package id.dana.contract.globalsearch;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.globalsearch.GlobalSearchBottomSheetContract;

/* loaded from: classes4.dex */
public final class GlobalSearchBottomSheetModule_ProvideGlobalSearchBottomSheetViewFactory implements Factory<GlobalSearchBottomSheetContract.View> {
    private final GlobalSearchBottomSheetModule KClassImpl$Data$declaredNonStaticMembers$2;

    private GlobalSearchBottomSheetModule_ProvideGlobalSearchBottomSheetViewFactory(GlobalSearchBottomSheetModule globalSearchBottomSheetModule) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = globalSearchBottomSheetModule;
    }

    public static GlobalSearchBottomSheetModule_ProvideGlobalSearchBottomSheetViewFactory PlaceComponentResult(GlobalSearchBottomSheetModule globalSearchBottomSheetModule) {
        return new GlobalSearchBottomSheetModule_ProvideGlobalSearchBottomSheetViewFactory(globalSearchBottomSheetModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (GlobalSearchBottomSheetContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getGetAuthRequestContext());
    }
}
