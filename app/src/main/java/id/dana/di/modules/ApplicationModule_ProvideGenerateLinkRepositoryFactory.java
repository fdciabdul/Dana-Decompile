package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.deeplink.repository.GenerateLinkEntityRepository;
import id.dana.domain.deeplink.repository.GenerateLinkRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideGenerateLinkRepositoryFactory implements Factory<GenerateLinkRepository> {
    private final ApplicationModule MyBillsEntityDataFactory;
    private final Provider<GenerateLinkEntityRepository> PlaceComponentResult;

    private ApplicationModule_ProvideGenerateLinkRepositoryFactory(ApplicationModule applicationModule, Provider<GenerateLinkEntityRepository> provider) {
        this.MyBillsEntityDataFactory = applicationModule;
        this.PlaceComponentResult = provider;
    }

    public static ApplicationModule_ProvideGenerateLinkRepositoryFactory PlaceComponentResult(ApplicationModule applicationModule, Provider<GenerateLinkEntityRepository> provider) {
        return new ApplicationModule_ProvideGenerateLinkRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (GenerateLinkRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.get()));
    }
}
