package id.dana.feeds.data.activation;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.config.source.HomeWidgetEntityData;
import id.dana.data.config.source.split.SplitConfigEntityData;
import id.dana.data.userconfig.repository.UserConfigEntityRepository;
import id.dana.feeds.data.activation.source.FeedInitEntityDataFactory;
import id.dana.feeds.data.storage.persistence.PersistenceRelationshipEntityData;
import id.dana.feeds.data.storage.preferences.SocialPreferences;
import id.dana.feeds.data.storage.preferences.SocialPreferencesDataFactory;
import id.dana.feeds.data.synccontact.FeedsContactProvider;
import id.dana.feeds.data.timeline.source.persistence.PersistenceFeedsTimelineEntityData;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* loaded from: classes2.dex */
public final class FeedInitEntityRepository_Factory implements Factory<FeedInitEntityRepository> {
    private final Provider<FeedInitEntityDataFactory> BuiltInFictitiousFunctionClassFactory;
    private final Provider<PersistenceFeedsTimelineEntityData> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<HomeWidgetEntityData> MyBillsEntityDataFactory;
    private final Provider<SocialPreferencesDataFactory> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<FeedsContactProvider> PlaceComponentResult;
    private final Provider<AccountEntityDataFactory> getAuthRequestContext;
    private final Provider<SplitConfigEntityData> getErrorConfigVersion;
    private final Provider<UserConfigEntityRepository> initRecordTimeStamp;
    private final Provider<CoroutineDispatcher> lookAheadTest;
    private final Provider<SocialPreferences> moveToNextValue;
    private final Provider<PersistenceRelationshipEntityData> scheduleImpl;

    private FeedInitEntityRepository_Factory(Provider<FeedsContactProvider> provider, Provider<SplitConfigEntityData> provider2, Provider<AccountEntityDataFactory> provider3, Provider<SocialPreferences> provider4, Provider<SocialPreferencesDataFactory> provider5, Provider<UserConfigEntityRepository> provider6, Provider<FeedInitEntityDataFactory> provider7, Provider<CoroutineDispatcher> provider8, Provider<HomeWidgetEntityData> provider9, Provider<PersistenceRelationshipEntityData> provider10, Provider<PersistenceFeedsTimelineEntityData> provider11) {
        this.PlaceComponentResult = provider;
        this.getErrorConfigVersion = provider2;
        this.getAuthRequestContext = provider3;
        this.moveToNextValue = provider4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider5;
        this.initRecordTimeStamp = provider6;
        this.BuiltInFictitiousFunctionClassFactory = provider7;
        this.lookAheadTest = provider8;
        this.MyBillsEntityDataFactory = provider9;
        this.scheduleImpl = provider10;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider11;
    }

    public static FeedInitEntityRepository_Factory MyBillsEntityDataFactory(Provider<FeedsContactProvider> provider, Provider<SplitConfigEntityData> provider2, Provider<AccountEntityDataFactory> provider3, Provider<SocialPreferences> provider4, Provider<SocialPreferencesDataFactory> provider5, Provider<UserConfigEntityRepository> provider6, Provider<FeedInitEntityDataFactory> provider7, Provider<CoroutineDispatcher> provider8, Provider<HomeWidgetEntityData> provider9, Provider<PersistenceRelationshipEntityData> provider10, Provider<PersistenceFeedsTimelineEntityData> provider11) {
        return new FeedInitEntityRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FeedInitEntityRepository(DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), DoubleCheck.MyBillsEntityDataFactory(this.getErrorConfigVersion), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.moveToNextValue), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0), DoubleCheck.MyBillsEntityDataFactory(this.initRecordTimeStamp), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), this.lookAheadTest.get(), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.scheduleImpl), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
    }
}
