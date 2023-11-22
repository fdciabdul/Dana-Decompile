package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.requestmoney.RequestMoneyEntityRepository;
import id.dana.domain.requestmoney.RequestMoneyRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideRequestMoneyRepositoryFactory implements Factory<RequestMoneyRepository> {
    private final ApplicationModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<RequestMoneyEntityRepository> getAuthRequestContext;

    private ApplicationModule_ProvideRequestMoneyRepositoryFactory(ApplicationModule applicationModule, Provider<RequestMoneyEntityRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = applicationModule;
        this.getAuthRequestContext = provider;
    }

    public static ApplicationModule_ProvideRequestMoneyRepositoryFactory PlaceComponentResult(ApplicationModule applicationModule, Provider<RequestMoneyEntityRepository> provider) {
        return new ApplicationModule_ProvideRequestMoneyRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (RequestMoneyRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(this.getAuthRequestContext.get()));
    }
}
