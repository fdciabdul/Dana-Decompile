package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.feeds.data.activation.FeedInitEntityRepository;
import id.dana.feeds.data.synccontact.RecurringFeedsSyncContactRepository;
import id.dana.feeds.domain.synccontact.SyncRunner;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideRecurringFullSyncRunnerFactory implements Factory<SyncRunner> {
    private final ApplicationModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<RecurringFeedsSyncContactRepository> MyBillsEntityDataFactory;
    private final Provider<FeedInitEntityRepository> getAuthRequestContext;

    private ApplicationModule_ProvideRecurringFullSyncRunnerFactory(ApplicationModule applicationModule, Provider<RecurringFeedsSyncContactRepository> provider, Provider<FeedInitEntityRepository> provider2) {
        this.BuiltInFictitiousFunctionClassFactory = applicationModule;
        this.MyBillsEntityDataFactory = provider;
        this.getAuthRequestContext = provider2;
    }

    public static ApplicationModule_ProvideRecurringFullSyncRunnerFactory MyBillsEntityDataFactory(ApplicationModule applicationModule, Provider<RecurringFeedsSyncContactRepository> provider, Provider<FeedInitEntityRepository> provider2) {
        return new ApplicationModule_ProvideRecurringFullSyncRunnerFactory(applicationModule, provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SyncRunner) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get()));
    }
}
