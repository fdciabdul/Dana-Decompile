package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.danainfo.DanaTutorialsEntityRepository;
import id.dana.domain.danainfo.repository.DanaTutorialsRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideDanaTutorialRepositoryFactory implements Factory<DanaTutorialsRepository> {
    private final ApplicationModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<DanaTutorialsEntityRepository> PlaceComponentResult;

    private ApplicationModule_ProvideDanaTutorialRepositoryFactory(ApplicationModule applicationModule, Provider<DanaTutorialsEntityRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationModule;
        this.PlaceComponentResult = provider;
    }

    public static ApplicationModule_ProvideDanaTutorialRepositoryFactory MyBillsEntityDataFactory(ApplicationModule applicationModule, Provider<DanaTutorialsEntityRepository> provider) {
        return new ApplicationModule_ProvideDanaTutorialRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (DanaTutorialsRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult.get()));
    }
}
