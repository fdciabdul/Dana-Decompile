package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.config.source.sharedpreference.SharedPrefSplitAttributes;
import id.dana.domain.featureconfig.LocalSplitAttributesEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideLocalSplitAttributesEntityDataFactory implements Factory<LocalSplitAttributesEntityData> {
    private final ApplicationModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<SharedPrefSplitAttributes> PlaceComponentResult;

    private ApplicationModule_ProvideLocalSplitAttributesEntityDataFactory(ApplicationModule applicationModule, Provider<SharedPrefSplitAttributes> provider) {
        this.BuiltInFictitiousFunctionClassFactory = applicationModule;
        this.PlaceComponentResult = provider;
    }

    public static ApplicationModule_ProvideLocalSplitAttributesEntityDataFactory MyBillsEntityDataFactory(ApplicationModule applicationModule, Provider<SharedPrefSplitAttributes> provider) {
        return new ApplicationModule_ProvideLocalSplitAttributesEntityDataFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (LocalSplitAttributesEntityData) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult.get()));
    }
}
