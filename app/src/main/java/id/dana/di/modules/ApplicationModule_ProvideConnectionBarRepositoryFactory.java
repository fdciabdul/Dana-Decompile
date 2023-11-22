package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.connectionbar.repository.ConnectionBarEntityRepository;
import id.dana.domain.connectionbar.ConnectionBarRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideConnectionBarRepositoryFactory implements Factory<ConnectionBarRepository> {
    private final Provider<ConnectionBarEntityRepository> MyBillsEntityDataFactory;
    private final ApplicationModule getAuthRequestContext;

    private ApplicationModule_ProvideConnectionBarRepositoryFactory(ApplicationModule applicationModule, Provider<ConnectionBarEntityRepository> provider) {
        this.getAuthRequestContext = applicationModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static ApplicationModule_ProvideConnectionBarRepositoryFactory BuiltInFictitiousFunctionClassFactory(ApplicationModule applicationModule, Provider<ConnectionBarEntityRepository> provider) {
        return new ApplicationModule_ProvideConnectionBarRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ConnectionBarRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory.get()));
    }
}
