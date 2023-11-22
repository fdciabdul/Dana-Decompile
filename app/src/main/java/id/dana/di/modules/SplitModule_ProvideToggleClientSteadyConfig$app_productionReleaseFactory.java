package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.lib.toggle.ToggleClientConfig;

/* loaded from: classes2.dex */
public final class SplitModule_ProvideToggleClientSteadyConfig$app_productionReleaseFactory implements Factory<ToggleClientConfig.Builder> {
    private final SplitModule PlaceComponentResult;

    private SplitModule_ProvideToggleClientSteadyConfig$app_productionReleaseFactory(SplitModule splitModule) {
        this.PlaceComponentResult = splitModule;
    }

    public static SplitModule_ProvideToggleClientSteadyConfig$app_productionReleaseFactory BuiltInFictitiousFunctionClassFactory(SplitModule splitModule) {
        return new SplitModule_ProvideToggleClientSteadyConfig$app_productionReleaseFactory(splitModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ToggleClientConfig.Builder) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.PlaceComponentResult());
    }
}
