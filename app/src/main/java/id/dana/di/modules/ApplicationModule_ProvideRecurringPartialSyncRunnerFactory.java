package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.feeds.data.activation.FeedInitEntityRepository;
import id.dana.feeds.data.synccontact.RecurringFeedsSyncContactRepository;
import id.dana.feeds.domain.synccontact.SyncRunner;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideRecurringPartialSyncRunnerFactory implements Factory<SyncRunner> {
    private final Provider<FeedInitEntityRepository> BuiltInFictitiousFunctionClassFactory;
    private final Provider<RecurringFeedsSyncContactRepository> MyBillsEntityDataFactory;
    private final ApplicationModule PlaceComponentResult;

    private ApplicationModule_ProvideRecurringPartialSyncRunnerFactory(ApplicationModule applicationModule, Provider<RecurringFeedsSyncContactRepository> provider, Provider<FeedInitEntityRepository> provider2) {
        this.PlaceComponentResult = applicationModule;
        this.MyBillsEntityDataFactory = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
    }

    public static ApplicationModule_ProvideRecurringPartialSyncRunnerFactory PlaceComponentResult(ApplicationModule applicationModule, Provider<RecurringFeedsSyncContactRepository> provider, Provider<FeedInitEntityRepository> provider2) {
        return new ApplicationModule_ProvideRecurringPartialSyncRunnerFactory(applicationModule, provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SyncRunner) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.PlaceComponentResult(this.MyBillsEntityDataFactory.get(), this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
