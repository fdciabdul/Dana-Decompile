package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.feeds.data.synccontact.FeedsSyncContactEntityRepository;
import id.dana.feeds.domain.synccontact.FeedsSyncContactRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideSocialSyncRepositoryFactory implements Factory<FeedsSyncContactRepository> {
    private final ApplicationModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<FeedsSyncContactEntityRepository> getAuthRequestContext;

    private ApplicationModule_ProvideSocialSyncRepositoryFactory(ApplicationModule applicationModule, Provider<FeedsSyncContactEntityRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = applicationModule;
        this.getAuthRequestContext = provider;
    }

    public static ApplicationModule_ProvideSocialSyncRepositoryFactory MyBillsEntityDataFactory(ApplicationModule applicationModule, Provider<FeedsSyncContactEntityRepository> provider) {
        return new ApplicationModule_ProvideSocialSyncRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FeedsSyncContactRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext.get()));
    }
}
