package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.danah5.H5EntityRepository;
import id.dana.domain.danah5.H5Repository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideH5RepositoryFactory implements Factory<H5Repository> {
    private final ApplicationModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<H5EntityRepository> getAuthRequestContext;

    private ApplicationModule_ProvideH5RepositoryFactory(ApplicationModule applicationModule, Provider<H5EntityRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationModule;
        this.getAuthRequestContext = provider;
    }

    public static ApplicationModule_ProvideH5RepositoryFactory PlaceComponentResult(ApplicationModule applicationModule, Provider<H5EntityRepository> provider) {
        return new ApplicationModule_ProvideH5RepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (H5Repository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.get()));
    }
}
