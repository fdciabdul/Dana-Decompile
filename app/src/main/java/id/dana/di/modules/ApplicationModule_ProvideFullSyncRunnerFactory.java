package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.feeds.data.activation.FeedInitEntityRepository;
import id.dana.feeds.data.synccontact.FeedsSyncContactEntityRepository;
import id.dana.feeds.domain.synccontact.SyncRunner;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideFullSyncRunnerFactory implements Factory<SyncRunner> {
    private final ApplicationModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<FeedInitEntityRepository> PlaceComponentResult;
    private final Provider<FeedsSyncContactEntityRepository> getAuthRequestContext;

    private ApplicationModule_ProvideFullSyncRunnerFactory(ApplicationModule applicationModule, Provider<FeedsSyncContactEntityRepository> provider, Provider<FeedInitEntityRepository> provider2) {
        this.BuiltInFictitiousFunctionClassFactory = applicationModule;
        this.getAuthRequestContext = provider;
        this.PlaceComponentResult = provider2;
    }

    public static ApplicationModule_ProvideFullSyncRunnerFactory MyBillsEntityDataFactory(ApplicationModule applicationModule, Provider<FeedsSyncContactEntityRepository> provider, Provider<FeedInitEntityRepository> provider2) {
        return new ApplicationModule_ProvideFullSyncRunnerFactory(applicationModule, provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SyncRunner) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(this.getAuthRequestContext.get(), this.PlaceComponentResult.get()));
    }
}
