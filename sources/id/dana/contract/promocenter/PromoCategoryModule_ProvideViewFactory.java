package id.dana.contract.promocenter;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.promocenter.PromoCategoryContract;

/* loaded from: classes4.dex */
public final class PromoCategoryModule_ProvideViewFactory implements Factory<PromoCategoryContract.View> {
    private final PromoCategoryModule PlaceComponentResult;

    private PromoCategoryModule_ProvideViewFactory(PromoCategoryModule promoCategoryModule) {
        this.PlaceComponentResult = promoCategoryModule;
    }

    public static PromoCategoryModule_ProvideViewFactory BuiltInFictitiousFunctionClassFactory(PromoCategoryModule promoCategoryModule) {
        return new PromoCategoryModule_ProvideViewFactory(promoCategoryModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PromoCategoryContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2());
    }
}
