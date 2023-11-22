package id.dana.contract.globalsearch;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.globalsearch.GlobalSearchContract;

/* loaded from: classes4.dex */
public final class GlobalSearchModule_ProvideGlobalSearchViewFactory implements Factory<GlobalSearchContract.View> {
    private final GlobalSearchModule getAuthRequestContext;

    private GlobalSearchModule_ProvideGlobalSearchViewFactory(GlobalSearchModule globalSearchModule) {
        this.getAuthRequestContext = globalSearchModule;
    }

    public static GlobalSearchModule_ProvideGlobalSearchViewFactory KClassImpl$Data$declaredNonStaticMembers$2(GlobalSearchModule globalSearchModule) {
        return new GlobalSearchModule_ProvideGlobalSearchViewFactory(globalSearchModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (GlobalSearchContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getGetAuthRequestContext());
    }
}
