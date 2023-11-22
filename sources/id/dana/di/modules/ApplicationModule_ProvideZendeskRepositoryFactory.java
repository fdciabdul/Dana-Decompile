package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.zendesk.repository.ZendeskEntityRepository;
import id.dana.domain.zendesk.ZendeskRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideZendeskRepositoryFactory implements Factory<ZendeskRepository> {
    private final ApplicationModule MyBillsEntityDataFactory;
    private final Provider<ZendeskEntityRepository> getAuthRequestContext;

    private ApplicationModule_ProvideZendeskRepositoryFactory(ApplicationModule applicationModule, Provider<ZendeskEntityRepository> provider) {
        this.MyBillsEntityDataFactory = applicationModule;
        this.getAuthRequestContext = provider;
    }

    public static ApplicationModule_ProvideZendeskRepositoryFactory KClassImpl$Data$declaredNonStaticMembers$2(ApplicationModule applicationModule, Provider<ZendeskEntityRepository> provider) {
        return new ApplicationModule_ProvideZendeskRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ZendeskRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.get()));
    }
}
