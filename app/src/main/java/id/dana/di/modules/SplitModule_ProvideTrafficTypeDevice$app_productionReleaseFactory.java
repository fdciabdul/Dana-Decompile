package id.dana.di.modules;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.toggle.traffictype.BaseTrafficType;
import id.dana.data.tracker.MixpanelEntityRepository;
import id.dana.lib.toggle.ToggleClientConfig;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SplitModule_ProvideTrafficTypeDevice$app_productionReleaseFactory implements Factory<BaseTrafficType> {
    private final SplitModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<ToggleClientConfig.Builder> MyBillsEntityDataFactory;
    private final Provider<MixpanelEntityRepository> PlaceComponentResult;
    private final Provider<Context> getAuthRequestContext;

    private SplitModule_ProvideTrafficTypeDevice$app_productionReleaseFactory(SplitModule splitModule, Provider<Context> provider, Provider<ToggleClientConfig.Builder> provider2, Provider<MixpanelEntityRepository> provider3) {
        this.BuiltInFictitiousFunctionClassFactory = splitModule;
        this.getAuthRequestContext = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.PlaceComponentResult = provider3;
    }

    public static SplitModule_ProvideTrafficTypeDevice$app_productionReleaseFactory KClassImpl$Data$declaredNonStaticMembers$2(SplitModule splitModule, Provider<Context> provider, Provider<ToggleClientConfig.Builder> provider2, Provider<MixpanelEntityRepository> provider3) {
        return new SplitModule_ProvideTrafficTypeDevice$app_productionReleaseFactory(splitModule, provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (BaseTrafficType) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext.get(), this.MyBillsEntityDataFactory.get(), this.PlaceComponentResult.get()));
    }
}
