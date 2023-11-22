package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.oauth.repository.OauthEntityRepository;
import id.dana.domain.oauth.repository.OauthRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideOauthRepositoryFactory implements Factory<OauthRepository> {
    private final ApplicationModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<OauthEntityRepository> PlaceComponentResult;

    private ApplicationModule_ProvideOauthRepositoryFactory(ApplicationModule applicationModule, Provider<OauthEntityRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = applicationModule;
        this.PlaceComponentResult = provider;
    }

    public static ApplicationModule_ProvideOauthRepositoryFactory getAuthRequestContext(ApplicationModule applicationModule, Provider<OauthEntityRepository> provider) {
        return new ApplicationModule_ProvideOauthRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (OauthRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.get()));
    }
}
