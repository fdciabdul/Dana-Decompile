package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.danaviz.DanaVizPromptContract;

/* loaded from: classes4.dex */
public final class DanaVizPromptModule_ProvideView$app_productionReleaseFactory implements Factory<DanaVizPromptContract.View> {
    private final DanaVizPromptModule PlaceComponentResult;

    public static DanaVizPromptContract.View MyBillsEntityDataFactory(DanaVizPromptModule danaVizPromptModule) {
        return (DanaVizPromptContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(danaVizPromptModule.getMyBillsEntityDataFactory());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (DanaVizPromptContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getMyBillsEntityDataFactory());
    }
}
