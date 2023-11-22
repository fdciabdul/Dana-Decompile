package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.lib.toggle.ToggleClientConfig;

/* loaded from: classes8.dex */
public final class SplitModule_ProvideToggleClientQuickConfig$app_productionReleaseFactory implements Factory<ToggleClientConfig.Builder> {
    private final SplitModule PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ToggleClientConfig.Builder) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.MyBillsEntityDataFactory());
    }
}
