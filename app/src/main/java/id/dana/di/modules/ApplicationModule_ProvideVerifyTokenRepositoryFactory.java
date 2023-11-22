package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.verifytoken.VerifyTokenEntityRepository;
import id.dana.domain.verifytoken.VerifyTokenRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideVerifyTokenRepositoryFactory implements Factory<VerifyTokenRepository> {
    private final ApplicationModule PlaceComponentResult;
    private final Provider<VerifyTokenEntityRepository> getAuthRequestContext;

    private ApplicationModule_ProvideVerifyTokenRepositoryFactory(ApplicationModule applicationModule, Provider<VerifyTokenEntityRepository> provider) {
        this.PlaceComponentResult = applicationModule;
        this.getAuthRequestContext = provider;
    }

    public static ApplicationModule_ProvideVerifyTokenRepositoryFactory BuiltInFictitiousFunctionClassFactory(ApplicationModule applicationModule, Provider<VerifyTokenEntityRepository> provider) {
        return new ApplicationModule_ProvideVerifyTokenRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (VerifyTokenRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.MyBillsEntityDataFactory(this.getAuthRequestContext.get()));
    }
}
