package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.feeds.data.activation.FeedInitEntityRepository;
import id.dana.feeds.data.synccontact.FeedsSyncContactEntityRepository;
import id.dana.feeds.domain.synccontact.SyncRunner;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvidePartialSyncRunnerFactory implements Factory<SyncRunner> {
    private final Provider<FeedInitEntityRepository> KClassImpl$Data$declaredNonStaticMembers$2;
    private final ApplicationModule PlaceComponentResult;
    private final Provider<FeedsSyncContactEntityRepository> getAuthRequestContext;

    private ApplicationModule_ProvidePartialSyncRunnerFactory(ApplicationModule applicationModule, Provider<FeedsSyncContactEntityRepository> provider, Provider<FeedInitEntityRepository> provider2) {
        this.PlaceComponentResult = applicationModule;
        this.getAuthRequestContext = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
    }

    public static ApplicationModule_ProvidePartialSyncRunnerFactory MyBillsEntityDataFactory(ApplicationModule applicationModule, Provider<FeedsSyncContactEntityRepository> provider, Provider<FeedInitEntityRepository> provider2) {
        return new ApplicationModule_ProvidePartialSyncRunnerFactory(applicationModule, provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SyncRunner) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.PlaceComponentResult(this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
