package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.config.source.sharedpreference.SharedPrefStartupConfig;
import id.dana.domain.featureconfig.StartupConfigEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideStartupConfigEntityDataFactory implements Factory<StartupConfigEntityData> {
    private final ApplicationModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<SharedPrefStartupConfig> PlaceComponentResult;

    private ApplicationModule_ProvideStartupConfigEntityDataFactory(ApplicationModule applicationModule, Provider<SharedPrefStartupConfig> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationModule;
        this.PlaceComponentResult = provider;
    }

    public static ApplicationModule_ProvideStartupConfigEntityDataFactory getAuthRequestContext(ApplicationModule applicationModule, Provider<SharedPrefStartupConfig> provider) {
        return new ApplicationModule_ProvideStartupConfigEntityDataFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (StartupConfigEntityData) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult.get()));
    }
}
