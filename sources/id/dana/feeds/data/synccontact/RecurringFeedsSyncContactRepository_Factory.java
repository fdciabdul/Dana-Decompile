package id.dana.feeds.data.synccontact;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.config.source.split.SplitConfigEntityData;
import id.dana.feeds.data.activation.source.FeedInitEntityDataFactory;
import id.dana.feeds.data.config.FeedsConfigEntityRepository;
import id.dana.feeds.data.synccontact.source.FeedsLocalSyncEntityDataFactory;
import id.dana.feeds.data.synccontact.source.FeedsSyncProcessEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class RecurringFeedsSyncContactRepository_Factory implements Factory<RecurringFeedsSyncContactRepository> {
    private final Provider<FeedsContactProvider> BuiltInFictitiousFunctionClassFactory;
    private final Provider<FeedInitEntityDataFactory> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<FeedsLocalSyncEntityDataFactory> MyBillsEntityDataFactory;
    private final Provider<FeedsConfigEntityRepository> PlaceComponentResult;
    private final Provider<AccountEntityDataFactory> getAuthRequestContext;
    private final Provider<FeedsSyncProcessEntityDataFactory> lookAheadTest;
    private final Provider<SplitConfigEntityData> scheduleImpl;

    private RecurringFeedsSyncContactRepository_Factory(Provider<FeedsContactProvider> provider, Provider<SplitConfigEntityData> provider2, Provider<AccountEntityDataFactory> provider3, Provider<FeedsLocalSyncEntityDataFactory> provider4, Provider<FeedsSyncProcessEntityDataFactory> provider5, Provider<FeedInitEntityDataFactory> provider6, Provider<FeedsConfigEntityRepository> provider7) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.scheduleImpl = provider2;
        this.getAuthRequestContext = provider3;
        this.MyBillsEntityDataFactory = provider4;
        this.lookAheadTest = provider5;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider6;
        this.PlaceComponentResult = provider7;
    }

    public static RecurringFeedsSyncContactRepository_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<FeedsContactProvider> provider, Provider<SplitConfigEntityData> provider2, Provider<AccountEntityDataFactory> provider3, Provider<FeedsLocalSyncEntityDataFactory> provider4, Provider<FeedsSyncProcessEntityDataFactory> provider5, Provider<FeedInitEntityDataFactory> provider6, Provider<FeedsConfigEntityRepository> provider7) {
        return new RecurringFeedsSyncContactRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new RecurringFeedsSyncContactRepository(this.BuiltInFictitiousFunctionClassFactory.get(), DoubleCheck.MyBillsEntityDataFactory(this.scheduleImpl), this.getAuthRequestContext.get(), this.MyBillsEntityDataFactory.get(), this.lookAheadTest.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.PlaceComponentResult.get());
    }
}
