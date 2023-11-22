package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.recentcontact.repository.RecentContactEntityRepository;
import id.dana.domain.recentcontact.repository.RecentContactRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideRecentContactRepositoryFactory implements Factory<RecentContactRepository> {
    private final ApplicationModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<RecentContactEntityRepository> MyBillsEntityDataFactory;

    private ApplicationModule_ProvideRecentContactRepositoryFactory(ApplicationModule applicationModule, Provider<RecentContactEntityRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = applicationModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static ApplicationModule_ProvideRecentContactRepositoryFactory BuiltInFictitiousFunctionClassFactory(ApplicationModule applicationModule, Provider<RecentContactEntityRepository> provider) {
        return new ApplicationModule_ProvideRecentContactRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (RecentContactRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(this.MyBillsEntityDataFactory.get()));
    }
}
