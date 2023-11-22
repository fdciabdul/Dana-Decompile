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
public final class FeedsSyncContactEntityRepository_Factory implements Factory<FeedsSyncContactEntityRepository> {
    private final Provider<AccountEntityDataFactory> BuiltInFictitiousFunctionClassFactory;
    private final Provider<FeedsLocalSyncEntityDataFactory> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<FeedInitEntityDataFactory> MyBillsEntityDataFactory;
    private final Provider<FeedsContactProvider> PlaceComponentResult;
    private final Provider<FeedsConfigEntityRepository> getAuthRequestContext;
    private final Provider<SplitConfigEntityData> getErrorConfigVersion;
    private final Provider<FeedsSyncProcessEntityDataFactory> lookAheadTest;

    private FeedsSyncContactEntityRepository_Factory(Provider<FeedsContactProvider> provider, Provider<SplitConfigEntityData> provider2, Provider<AccountEntityDataFactory> provider3, Provider<FeedsLocalSyncEntityDataFactory> provider4, Provider<FeedsSyncProcessEntityDataFactory> provider5, Provider<FeedInitEntityDataFactory> provider6, Provider<FeedsConfigEntityRepository> provider7) {
        this.PlaceComponentResult = provider;
        this.getErrorConfigVersion = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider4;
        this.lookAheadTest = provider5;
        this.MyBillsEntityDataFactory = provider6;
        this.getAuthRequestContext = provider7;
    }

    public static FeedsSyncContactEntityRepository_Factory PlaceComponentResult(Provider<FeedsContactProvider> provider, Provider<SplitConfigEntityData> provider2, Provider<AccountEntityDataFactory> provider3, Provider<FeedsLocalSyncEntityDataFactory> provider4, Provider<FeedsSyncProcessEntityDataFactory> provider5, Provider<FeedInitEntityDataFactory> provider6, Provider<FeedsConfigEntityRepository> provider7) {
        return new FeedsSyncContactEntityRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FeedsSyncContactEntityRepository(this.PlaceComponentResult.get(), DoubleCheck.MyBillsEntityDataFactory(this.getErrorConfigVersion), this.BuiltInFictitiousFunctionClassFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.lookAheadTest.get(), this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get());
    }
}
