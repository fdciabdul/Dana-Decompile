package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.shortener.repository.ShortenerEntityRepository;
import id.dana.domain.shortener.repository.ShortenerRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideShortenerRepositoryFactory implements Factory<ShortenerRepository> {
    private final ApplicationModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<ShortenerEntityRepository> KClassImpl$Data$declaredNonStaticMembers$2;

    private ApplicationModule_ProvideShortenerRepositoryFactory(ApplicationModule applicationModule, Provider<ShortenerEntityRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = applicationModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static ApplicationModule_ProvideShortenerRepositoryFactory KClassImpl$Data$declaredNonStaticMembers$2(ApplicationModule applicationModule, Provider<ShortenerEntityRepository> provider) {
        return new ApplicationModule_ProvideShortenerRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ShortenerRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
