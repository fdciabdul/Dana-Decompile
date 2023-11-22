package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.miniprogram.source.MiniProgramEntityRepository;
import id.dana.domain.miniprogram.MiniProgramRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideMiniProgramRepositoryFactory implements Factory<MiniProgramRepository> {
    private final ApplicationModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<MiniProgramEntityRepository> PlaceComponentResult;

    private ApplicationModule_ProvideMiniProgramRepositoryFactory(ApplicationModule applicationModule, Provider<MiniProgramEntityRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationModule;
        this.PlaceComponentResult = provider;
    }

    public static ApplicationModule_ProvideMiniProgramRepositoryFactory PlaceComponentResult(ApplicationModule applicationModule, Provider<MiniProgramEntityRepository> provider) {
        return new ApplicationModule_ProvideMiniProgramRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MiniProgramRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(this.PlaceComponentResult.get()));
    }
}
