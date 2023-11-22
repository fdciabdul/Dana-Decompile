package id.dana.feeds.data.timeline;

import id.dana.data.account.AccountEntity;
import id.dana.data.account.repository.source.AccountEntityData;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1Repository;
import id.dana.data.userconfig.UserConfigBizTypeConstant;
import id.dana.data.userconfig.repository.UserConfigEntityRepository;
import id.dana.domain.social.model.FeedConfig;
import id.dana.domain.social.model.ShareActivityConfig;
import id.dana.domain.userconfig.model.QueryConfig;
import id.dana.feeds.data.config.FeedsConfigEntityRepository;
import id.dana.feeds.data.config.model.FeedConfigResult;
import id.dana.feeds.data.mapper.ContactDeviceNameMapper;
import id.dana.feeds.data.mapper.CreateFeedActivityEntityMapperKt;
import id.dana.feeds.data.mapper.MyFeedResultMapperKt;
import id.dana.feeds.data.share.source.local.model.CreateFeedActivityEntity;
import id.dana.feeds.data.storage.preferences.LocalSocialPreferencesData;
import id.dana.feeds.data.storage.preferences.SocialPreferencesData;
import id.dana.feeds.data.storage.preferences.SocialPreferencesDataFactory;
import id.dana.feeds.data.timeline.source.FeedsTimelineData;
import id.dana.feeds.data.timeline.source.FeedsTimelineDataFactory;
import id.dana.feeds.data.timeline.source.network.response.FeedResult;
import id.dana.feeds.data.timeline.source.network.response.GroupedActivityResult;
import id.dana.feeds.data.timeline.source.network.response.MyFeedResult;
import id.dana.feeds.domain.timeline.FeedsTimelineRepository;
import id.dana.feeds.domain.timeline.model.SocialFeed;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002BA\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u001b\u0012\u0006\u0010\u0006\u001a\u000205\u0012\u0006\u0010\u0007\u001a\u00020\"\u0012\u0006\u0010\b\u001a\u00020\u001d\u0012\u0006\u0010\t\u001a\u000201\u0012\u0006\u0010\n\u001a\u00020 \u0012\u0006\u0010\f\u001a\u00020$¢\u0006\u0004\b8\u00109Ja\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¢\u0006\u0004\b\u0015\u0010\u0014Ja\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0016J\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0014Ji\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0018J-\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ1\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u001aR\u0014\u0010\u0013\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0019\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010!R\u0014\u0010\u0011\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010#R\u0014\u0010\u0015\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010%R\u0017\u0010)\u001a\u0006*\u00020&0&X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b'\u0010(R\u0013\u0010,\u001a\u00020*X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b+\u0010(R\u0013\u0010.\u001a\u00020-X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b,\u0010(R\u0013\u0010+\u001a\u00020-X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b.\u0010(R\u001e\u0010'\u001a\f\u0012\b\u0012\u0006*\u00020\r0\r0/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u00100R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0014\u00106\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107"}, d2 = {"Lid/dana/feeds/data/timeline/FeedsTimelineEntityRepository;", "Lid/dana/feeds/domain/timeline/FeedsTimelineRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1Repository;", "", "p0", "", "p1", "p2", "p3", "p4", "p5", "", "p6", "", "p7", "Lio/reactivex/Observable;", "Lid/dana/feeds/domain/timeline/model/SocialFeed;", "MyBillsEntityDataFactory", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Z)Lio/reactivex/Observable;", "getAuthRequestContext", "()Lio/reactivex/Observable;", "KClassImpl$Data$declaredNonStaticMembers$2", "(ILjava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/lang/String;Z)Lio/reactivex/Observable;", "p8", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;ZZ)Lio/reactivex/Observable;", "PlaceComponentResult", "(ILjava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", "Lid/dana/feeds/data/mapper/ContactDeviceNameMapper;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/feeds/data/mapper/ContactDeviceNameMapper;", "Lid/dana/feeds/data/config/FeedsConfigEntityRepository;", "Lid/dana/feeds/data/config/FeedsConfigEntityRepository;", "Lid/dana/feeds/data/timeline/source/FeedsTimelineDataFactory;", "Lid/dana/feeds/data/timeline/source/FeedsTimelineDataFactory;", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "Lid/dana/data/account/repository/source/AccountEntityData;", "getErrorConfigVersion", "Lkotlin/Lazy;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/feeds/data/storage/preferences/SocialPreferencesData;", "scheduleImpl", "moveToNextValue", "Lid/dana/feeds/data/timeline/source/FeedsTimelineData;", "lookAheadTest", "Lid/dana/domain/userconfig/model/QueryConfig;", "Lid/dana/domain/userconfig/model/QueryConfig;", "Lid/dana/feeds/data/storage/preferences/SocialPreferencesDataFactory;", "GetContactSyncConfig", "Lid/dana/feeds/data/storage/preferences/SocialPreferencesDataFactory;", "DatabaseTableConfigUtil", "Lid/dana/data/userconfig/repository/UserConfigEntityRepository;", "initRecordTimeStamp", "Lid/dana/data/userconfig/repository/UserConfigEntityRepository;", "<init>", "(Lid/dana/data/account/repository/source/AccountEntityDataFactory;Lid/dana/data/userconfig/repository/UserConfigEntityRepository;Lid/dana/feeds/data/timeline/source/FeedsTimelineDataFactory;Lid/dana/feeds/data/mapper/ContactDeviceNameMapper;Lid/dana/feeds/data/storage/preferences/SocialPreferencesDataFactory;Lid/dana/feeds/data/config/FeedsConfigEntityRepository;Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedsTimelineEntityRepository implements FeedsTimelineRepository, HoldLoginV1Repository {
    private final ContactDeviceNameMapper BuiltInFictitiousFunctionClassFactory;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final SocialPreferencesDataFactory DatabaseTableConfigUtil;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final AccountEntityDataFactory getAuthRequestContext;
    private final FeedsTimelineDataFactory MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final QueryConfig<Boolean> getErrorConfigVersion;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final HoldLoginV1EntityRepository KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final FeedsConfigEntityRepository PlaceComponentResult;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final UserConfigEntityRepository initRecordTimeStamp;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final Lazy scheduleImpl;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final Lazy lookAheadTest;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final Lazy moveToNextValue;

    @Inject
    public FeedsTimelineEntityRepository(AccountEntityDataFactory accountEntityDataFactory, UserConfigEntityRepository userConfigEntityRepository, FeedsTimelineDataFactory feedsTimelineDataFactory, ContactDeviceNameMapper contactDeviceNameMapper, SocialPreferencesDataFactory socialPreferencesDataFactory, FeedsConfigEntityRepository feedsConfigEntityRepository, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        Intrinsics.checkNotNullParameter(accountEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(userConfigEntityRepository, "");
        Intrinsics.checkNotNullParameter(feedsTimelineDataFactory, "");
        Intrinsics.checkNotNullParameter(contactDeviceNameMapper, "");
        Intrinsics.checkNotNullParameter(socialPreferencesDataFactory, "");
        Intrinsics.checkNotNullParameter(feedsConfigEntityRepository, "");
        Intrinsics.checkNotNullParameter(holdLoginV1EntityRepository, "");
        this.getAuthRequestContext = accountEntityDataFactory;
        this.initRecordTimeStamp = userConfigEntityRepository;
        this.MyBillsEntityDataFactory = feedsTimelineDataFactory;
        this.BuiltInFictitiousFunctionClassFactory = contactDeviceNameMapper;
        this.DatabaseTableConfigUtil = socialPreferencesDataFactory;
        this.PlaceComponentResult = feedsConfigEntityRepository;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = holdLoginV1EntityRepository;
        this.moveToNextValue = LazyKt.lazy(new Function0<SocialPreferencesData>() { // from class: id.dana.feeds.data.timeline.FeedsTimelineEntityRepository$localSocialPreferencesData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SocialPreferencesData invoke() {
                SocialPreferencesDataFactory socialPreferencesDataFactory2;
                socialPreferencesDataFactory2 = FeedsTimelineEntityRepository.this.DatabaseTableConfigUtil;
                Intrinsics.checkNotNullParameter("local", "");
                return new LocalSocialPreferencesData(socialPreferencesDataFactory2.PlaceComponentResult);
            }
        });
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = LazyKt.lazy(new Function0<AccountEntityData>() { // from class: id.dana.feeds.data.timeline.FeedsTimelineEntityRepository$localAccountEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AccountEntityData invoke() {
                AccountEntityDataFactory accountEntityDataFactory2;
                accountEntityDataFactory2 = FeedsTimelineEntityRepository.this.getAuthRequestContext;
                return accountEntityDataFactory2.createData2("local");
            }
        });
        this.lookAheadTest = LazyKt.lazy(new Function0<FeedsTimelineData>() { // from class: id.dana.feeds.data.timeline.FeedsTimelineEntityRepository$networkFeedsTimelineData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FeedsTimelineData invoke() {
                FeedsTimelineDataFactory feedsTimelineDataFactory2;
                feedsTimelineDataFactory2 = FeedsTimelineEntityRepository.this.MyBillsEntityDataFactory;
                return Intrinsics.areEqual("network", "local") ? feedsTimelineDataFactory2.getAuthRequestContext : feedsTimelineDataFactory2.BuiltInFictitiousFunctionClassFactory;
            }
        });
        this.scheduleImpl = LazyKt.lazy(new Function0<FeedsTimelineData>() { // from class: id.dana.feeds.data.timeline.FeedsTimelineEntityRepository$persistenceFeedsTimelineData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FeedsTimelineData invoke() {
                FeedsTimelineDataFactory feedsTimelineDataFactory2;
                feedsTimelineDataFactory2 = FeedsTimelineEntityRepository.this.MyBillsEntityDataFactory;
                return Intrinsics.areEqual("local", "local") ? feedsTimelineDataFactory2.getAuthRequestContext : feedsTimelineDataFactory2.BuiltInFictitiousFunctionClassFactory;
            }
        });
        this.getErrorConfigVersion = new QueryConfig<>(UserConfigBizTypeConstant.SHARE_FEED, Boolean.TYPE);
    }

    @Override // id.dana.feeds.domain.timeline.FeedsTimelineRepository
    public final Observable<SocialFeed> MyBillsEntityDataFactory(final String p0, final int p1, final String p2, final String p3, final String p4, final int p5, final List<String> p6, final boolean p7, boolean p8) {
        Intrinsics.checkNotNullParameter(p4, "");
        Intrinsics.checkNotNullParameter(p6, "");
        Observable<SocialFeed> MyBillsEntityDataFactory = MyBillsEntityDataFactory(p0, p1, p2, p3, p4, p5, p6, p7);
        final FeedsTimelineEntityRepository$mapPhoneNumberInActivitiesToDeviceContactName$1 feedsTimelineEntityRepository$mapPhoneNumberInActivitiesToDeviceContactName$1 = new FeedsTimelineEntityRepository$mapPhoneNumberInActivitiesToDeviceContactName$1(this);
        Observable onErrorResumeNext = MyBillsEntityDataFactory.map(new Function() { // from class: id.dana.feeds.data.timeline.FeedsTimelineEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsTimelineEntityRepository.PlaceComponentResult(Function1.this, (SocialFeed) obj);
            }
        }).doOnNext(new Consumer() { // from class: id.dana.feeds.data.timeline.FeedsTimelineEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeedsTimelineEntityRepository.PlaceComponentResult(p4, p7, this, p5, (SocialFeed) obj);
            }
        }).onErrorResumeNext(new Function() { // from class: id.dana.feeds.data.timeline.FeedsTimelineEntityRepository$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsTimelineEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(p7, this, p4, p5, p6, (Throwable) obj);
            }
        });
        if (Intrinsics.areEqual(p4, "timelineFeed") && p7 && p8) {
            onErrorResumeNext = onErrorResumeNext.startWith((ObservableSource) ((FeedsTimelineData) this.scheduleImpl.getValue()).getAuthRequestContext(p4, p5, p6));
        }
        Observable observable = onErrorResumeNext;
        if (p7) {
            observable = observable.flatMap(new Function() { // from class: id.dana.feeds.data.timeline.FeedsTimelineEntityRepository$$ExternalSyntheticLambda6
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return FeedsTimelineEntityRepository.MyBillsEntityDataFactory(FeedsTimelineEntityRepository.this, p4, p5, p6, (SocialFeed) obj);
                }
            });
        }
        Intrinsics.checkNotNullExpressionValue(observable, "");
        return observable;
    }

    @Override // id.dana.feeds.domain.timeline.FeedsTimelineRepository
    public final Observable<Integer> MyBillsEntityDataFactory() {
        Observable map = this.PlaceComponentResult.PlaceComponentResult().map(new Function() { // from class: id.dana.feeds.data.config.FeedsConfigEntityRepository$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsConfigEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2((FeedConfig) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    public static /* synthetic */ SocialFeed MyBillsEntityDataFactory(FeedResult feedResult) {
        SocialFeed BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(feedResult, "");
        BuiltInFictitiousFunctionClassFactory = MyFeedResultMapperKt.BuiltInFictitiousFunctionClassFactory(feedResult, CollectionsKt.emptyList());
        return BuiltInFictitiousFunctionClassFactory;
    }

    public static /* synthetic */ ObservableSource BuiltInFictitiousFunctionClassFactory(final FeedsTimelineEntityRepository feedsTimelineEntityRepository, final FeedResult feedResult, final AccountEntity accountEntity) {
        Intrinsics.checkNotNullParameter(feedsTimelineEntityRepository, "");
        Intrinsics.checkNotNullParameter(feedResult, "");
        Intrinsics.checkNotNullParameter(accountEntity, "");
        Observable fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.feeds.data.timeline.FeedsTimelineEntityRepository$$ExternalSyntheticLambda13
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return FeedsTimelineEntityRepository.PlaceComponentResult(FeedsTimelineEntityRepository.this, accountEntity);
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable.flatMap(new Function() { // from class: id.dana.feeds.data.timeline.FeedsTimelineEntityRepository$$ExternalSyntheticLambda16
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsTimelineEntityRepository.getAuthRequestContext(FeedsTimelineEntityRepository.this, accountEntity, feedResult, (List) obj);
            }
        });
    }

    public static /* synthetic */ void PlaceComponentResult(String str, boolean z, FeedsTimelineEntityRepository feedsTimelineEntityRepository, int i, SocialFeed socialFeed) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(feedsTimelineEntityRepository, "");
        if (Intrinsics.areEqual(str, "timelineFeed") && z && socialFeed.hasActivities()) {
            ((SocialPreferencesData) feedsTimelineEntityRepository.moveToNextValue.getValue()).MyBillsEntityDataFactory(i);
            FeedsTimelineData feedsTimelineData = (FeedsTimelineData) feedsTimelineEntityRepository.scheduleImpl.getValue();
            Intrinsics.checkNotNullExpressionValue(socialFeed, "");
            feedsTimelineData.BuiltInFictitiousFunctionClassFactory(socialFeed);
        }
    }

    public static /* synthetic */ List MyBillsEntityDataFactory(AccountEntity accountEntity, List list) {
        Intrinsics.checkNotNullParameter(accountEntity, "");
        Intrinsics.checkNotNullParameter(list, "");
        return CreateFeedActivityEntityMapperKt.MyBillsEntityDataFactory(list, accountEntity);
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(FeedsTimelineEntityRepository feedsTimelineEntityRepository, SocialFeed socialFeed) {
        Intrinsics.checkNotNullParameter(feedsTimelineEntityRepository, "");
        if (socialFeed.hasActivities()) {
            SocialPreferencesData socialPreferencesData = (SocialPreferencesData) feedsTimelineEntityRepository.moveToNextValue.getValue();
            Intrinsics.checkNotNullExpressionValue(socialFeed, "");
            socialPreferencesData.KClassImpl$Data$declaredNonStaticMembers$2(socialFeed);
        }
    }

    public static /* synthetic */ ObservableSource MyBillsEntityDataFactory(FeedsTimelineEntityRepository feedsTimelineEntityRepository, String str, int i, List list, SocialFeed socialFeed) {
        Observable<SocialFeed> just;
        Intrinsics.checkNotNullParameter(feedsTimelineEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(socialFeed, "");
        if (!socialFeed.hasActivities() && !socialFeed.getFromCache()) {
            just = ((FeedsTimelineData) feedsTimelineEntityRepository.scheduleImpl.getValue()).getAuthRequestContext(str, i, list);
        } else {
            just = Observable.just(socialFeed);
            Intrinsics.checkNotNullExpressionValue(just, "");
        }
        return just;
    }

    public static /* synthetic */ List PlaceComponentResult(FeedsTimelineEntityRepository feedsTimelineEntityRepository, AccountEntity accountEntity) {
        Intrinsics.checkNotNullParameter(feedsTimelineEntityRepository, "");
        Intrinsics.checkNotNullParameter(accountEntity, "");
        SocialPreferencesData socialPreferencesData = (SocialPreferencesData) feedsTimelineEntityRepository.moveToNextValue.getValue();
        String phoneNumber = accountEntity.getPhoneNumber();
        Intrinsics.checkNotNullExpressionValue(phoneNumber, "");
        return socialPreferencesData.lookAheadTest(phoneNumber);
    }

    public static /* synthetic */ SocialFeed PlaceComponentResult(Function1 function1, SocialFeed socialFeed) {
        Intrinsics.checkNotNullParameter(function1, "");
        return (SocialFeed) function1.invoke(socialFeed);
    }

    public static /* synthetic */ ObservableSource BuiltInFictitiousFunctionClassFactory(final FeedsTimelineEntityRepository feedsTimelineEntityRepository, final FeedResult feedResult, FeedConfigResult feedConfigResult) {
        Observable map;
        Intrinsics.checkNotNullParameter(feedsTimelineEntityRepository, "");
        Intrinsics.checkNotNullParameter(feedResult, "");
        Intrinsics.checkNotNullParameter(feedConfigResult, "");
        if (Intrinsics.areEqual(feedConfigResult.isCreateActivityEnabled(), Boolean.TRUE) && feedConfigResult.getShareActivity() != null) {
            ShareActivityConfig shareActivity = feedConfigResult.getShareActivity();
            Intrinsics.checkNotNull(shareActivity);
            if (shareActivity.getPaymentSuccess()) {
                Observable<R> flatMap = ((AccountEntityData) feedsTimelineEntityRepository.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue()).getAccount().flatMap(new Function() { // from class: id.dana.feeds.data.timeline.FeedsTimelineEntityRepository$$ExternalSyntheticLambda17
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        return FeedsTimelineEntityRepository.BuiltInFictitiousFunctionClassFactory(FeedsTimelineEntityRepository.this, feedResult, (AccountEntity) obj);
                    }
                });
                Intrinsics.checkNotNullExpressionValue(flatMap, "");
                map = flatMap.map(new Function() { // from class: id.dana.feeds.data.timeline.FeedsTimelineEntityRepository$$ExternalSyntheticLambda18
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        return FeedsTimelineEntityRepository.PlaceComponentResult(FeedResult.this, (List) obj);
                    }
                });
                Intrinsics.checkNotNullExpressionValue(map, "");
                return map;
            }
        }
        map = Observable.just(feedResult).map(new Function() { // from class: id.dana.feeds.data.timeline.FeedsTimelineEntityRepository$$ExternalSyntheticLambda19
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsTimelineEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2((FeedResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    public static /* synthetic */ ObservableSource getAuthRequestContext(final FeedsTimelineEntityRepository feedsTimelineEntityRepository, final AccountEntity accountEntity, final FeedResult feedResult, List list) {
        Intrinsics.checkNotNullParameter(feedsTimelineEntityRepository, "");
        Intrinsics.checkNotNullParameter(accountEntity, "");
        Intrinsics.checkNotNullParameter(feedResult, "");
        Intrinsics.checkNotNullParameter(list, "");
        final List mutableList = CollectionsKt.toMutableList((Collection) list);
        Observable map = Observable.fromCallable(new Callable() { // from class: id.dana.feeds.data.timeline.FeedsTimelineEntityRepository$$ExternalSyntheticLambda8
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return FeedsTimelineEntityRepository.MyBillsEntityDataFactory(mutableList, feedsTimelineEntityRepository, accountEntity, feedResult);
            }
        }).map(new Function() { // from class: id.dana.feeds.data.timeline.FeedsTimelineEntityRepository$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsTimelineEntityRepository.MyBillsEntityDataFactory(AccountEntity.this, (List) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    public static /* synthetic */ SocialFeed MyBillsEntityDataFactory(Function1 function1, SocialFeed socialFeed) {
        Intrinsics.checkNotNullParameter(function1, "");
        return (SocialFeed) function1.invoke(socialFeed);
    }

    public static /* synthetic */ ObservableSource MyBillsEntityDataFactory(String str, boolean z, final FeedsTimelineEntityRepository feedsTimelineEntityRepository, final FeedResult feedResult) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(feedsTimelineEntityRepository, "");
        Intrinsics.checkNotNullParameter(feedResult, "");
        if (Intrinsics.areEqual(str, "timelineFeed") && z) {
            return feedsTimelineEntityRepository.PlaceComponentResult.getAuthRequestContext().flatMap(new Function() { // from class: id.dana.feeds.data.timeline.FeedsTimelineEntityRepository$$ExternalSyntheticLambda14
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return FeedsTimelineEntityRepository.BuiltInFictitiousFunctionClassFactory(FeedsTimelineEntityRepository.this, feedResult, (FeedConfigResult) obj);
                }
            });
        }
        return Observable.just(feedResult).map(new Function() { // from class: id.dana.feeds.data.timeline.FeedsTimelineEntityRepository$$ExternalSyntheticLambda15
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsTimelineEntityRepository.PlaceComponentResult((FeedResult) obj);
            }
        });
    }

    public static /* synthetic */ SocialFeed BuiltInFictitiousFunctionClassFactory(MyFeedResult myFeedResult) {
        Intrinsics.checkNotNullParameter(myFeedResult, "");
        return MyFeedResultMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(myFeedResult);
    }

    public static /* synthetic */ SocialFeed getAuthRequestContext(Function1 function1, SocialFeed socialFeed) {
        Intrinsics.checkNotNullParameter(function1, "");
        return (SocialFeed) function1.invoke(socialFeed);
    }

    public static /* synthetic */ SocialFeed KClassImpl$Data$declaredNonStaticMembers$2(FeedResult feedResult) {
        SocialFeed BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(feedResult, "");
        BuiltInFictitiousFunctionClassFactory = MyFeedResultMapperKt.BuiltInFictitiousFunctionClassFactory(feedResult, CollectionsKt.emptyList());
        return BuiltInFictitiousFunctionClassFactory;
    }

    public static /* synthetic */ SocialFeed MyBillsEntityDataFactory(FeedsTimelineEntityRepository feedsTimelineEntityRepository) {
        Intrinsics.checkNotNullParameter(feedsTimelineEntityRepository, "");
        return ((SocialPreferencesData) feedsTimelineEntityRepository.moveToNextValue.getValue()).getAuthRequestContext();
    }

    public static /* synthetic */ SocialFeed PlaceComponentResult(FeedResult feedResult, List list) {
        Intrinsics.checkNotNullParameter(feedResult, "");
        Intrinsics.checkNotNullParameter(list, "");
        return MyFeedResultMapperKt.BuiltInFictitiousFunctionClassFactory(feedResult, list);
    }

    public static /* synthetic */ SocialFeed BuiltInFictitiousFunctionClassFactory(Function1 function1, SocialFeed socialFeed) {
        Intrinsics.checkNotNullParameter(function1, "");
        return (SocialFeed) function1.invoke(socialFeed);
    }

    public static /* synthetic */ ObservableSource KClassImpl$Data$declaredNonStaticMembers$2(boolean z, FeedsTimelineEntityRepository feedsTimelineEntityRepository, String str, int i, List list, Throwable th) {
        Intrinsics.checkNotNullParameter(feedsTimelineEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(th, "");
        if (z) {
            return ((FeedsTimelineData) feedsTimelineEntityRepository.scheduleImpl.getValue()).getAuthRequestContext(str, i, list);
        }
        return Observable.error(th);
    }

    public static /* synthetic */ SocialFeed PlaceComponentResult(MyFeedResult myFeedResult) {
        Intrinsics.checkNotNullParameter(myFeedResult, "");
        return MyFeedResultMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(myFeedResult);
    }

    public static /* synthetic */ SocialFeed PlaceComponentResult(FeedResult feedResult) {
        SocialFeed BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(feedResult, "");
        BuiltInFictitiousFunctionClassFactory = MyFeedResultMapperKt.BuiltInFictitiousFunctionClassFactory(feedResult, CollectionsKt.emptyList());
        return BuiltInFictitiousFunctionClassFactory;
    }

    public static /* synthetic */ List MyBillsEntityDataFactory(List list, FeedsTimelineEntityRepository feedsTimelineEntityRepository, AccountEntity accountEntity, FeedResult feedResult) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(feedsTimelineEntityRepository, "");
        Intrinsics.checkNotNullParameter(accountEntity, "");
        Intrinsics.checkNotNullParameter(feedResult, "");
        final ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CreateFeedActivityEntity createFeedActivityEntity = (CreateFeedActivityEntity) it.next();
            List<GroupedActivityResult> groupedActivities = feedResult.getGroupedActivities();
            Object obj = null;
            if (groupedActivities != null) {
                Iterator<T> it2 = groupedActivities.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Object next = it2.next();
                    if (((GroupedActivityResult) next).hasActivityWithSameShareFeedRequestId(createFeedActivityEntity.KClassImpl$Data$declaredNonStaticMembers$2.getShareFeedRequestId())) {
                        obj = next;
                        break;
                    }
                }
                obj = (GroupedActivityResult) obj;
            }
            if (obj != null) {
                arrayList.add(createFeedActivityEntity.KClassImpl$Data$declaredNonStaticMembers$2.getShareFeedRequestId());
            }
        }
        if ((!arrayList.isEmpty()) != false) {
            CollectionsKt.removeAll(list, (Function1) new Function1<CreateFeedActivityEntity, Boolean>() { // from class: id.dana.feeds.data.timeline.FeedsTimelineEntityRepository$compareAndDeleteMatchedRequestId$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(CreateFeedActivityEntity createFeedActivityEntity2) {
                    Intrinsics.checkNotNullParameter(createFeedActivityEntity2, "");
                    return Boolean.valueOf(arrayList.contains(createFeedActivityEntity2.KClassImpl$Data$declaredNonStaticMembers$2.getShareFeedRequestId()));
                }
            });
            SocialPreferencesData socialPreferencesData = (SocialPreferencesData) feedsTimelineEntityRepository.moveToNextValue.getValue();
            String phoneNumber = accountEntity.getPhoneNumber();
            Intrinsics.checkNotNullExpressionValue(phoneNumber, "");
            socialPreferencesData.BuiltInFictitiousFunctionClassFactory(phoneNumber, arrayList);
        }
        return list;
    }

    private final Observable<SocialFeed> MyBillsEntityDataFactory(String p0, int p1, String p2, String p3, final String p4, int p5, List<String> p6, final boolean p7) {
        Observable flatMap = ((FeedsTimelineData) this.lookAheadTest.getValue()).getAuthRequestContext(p0, p1, p2, p3, p4, p5, p6).flatMap(new Function() { // from class: id.dana.feeds.data.timeline.FeedsTimelineEntityRepository$$ExternalSyntheticLambda12
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsTimelineEntityRepository.MyBillsEntityDataFactory(p4, p7, this, (FeedResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    @Override // id.dana.feeds.domain.timeline.FeedsTimelineRepository
    public final Observable<Integer> getAuthRequestContext() {
        return ((SocialPreferencesData) this.moveToNextValue.getValue()).KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // id.dana.feeds.domain.timeline.FeedsTimelineRepository
    public final Observable<SocialFeed> KClassImpl$Data$declaredNonStaticMembers$2() {
        Observable just = Observable.just(((SocialPreferencesData) this.moveToNextValue.getValue()).getAuthRequestContext());
        final FeedsTimelineEntityRepository$mapPhoneNumberInActivitiesToDeviceContactName$1 feedsTimelineEntityRepository$mapPhoneNumberInActivitiesToDeviceContactName$1 = new FeedsTimelineEntityRepository$mapPhoneNumberInActivitiesToDeviceContactName$1(this);
        Observable<SocialFeed> map = just.map(new Function() { // from class: id.dana.feeds.data.timeline.FeedsTimelineEntityRepository$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsTimelineEntityRepository.BuiltInFictitiousFunctionClassFactory(Function1.this, (SocialFeed) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.feeds.domain.timeline.FeedsTimelineRepository
    public final Observable<SocialFeed> MyBillsEntityDataFactory(int i, String str, String str2, int i2, List<String> list, String str3, boolean z) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Observable<SocialFeed> doOnNext = MyBillsEntityDataFactory(null, i, str, str2, str3, i2, list, false).doOnNext(new Consumer() { // from class: id.dana.feeds.data.timeline.FeedsTimelineEntityRepository$$ExternalSyntheticLambda20
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeedsTimelineEntityRepository.MyBillsEntityDataFactory(FeedsTimelineEntityRepository.this, (SocialFeed) obj);
            }
        });
        if (z) {
            doOnNext = doOnNext.startWith(Observable.fromCallable(new Callable() { // from class: id.dana.feeds.data.timeline.FeedsTimelineEntityRepository$$ExternalSyntheticLambda21
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return FeedsTimelineEntityRepository.MyBillsEntityDataFactory(FeedsTimelineEntityRepository.this);
                }
            }));
        }
        final FeedsTimelineEntityRepository$mapPhoneNumberInActivitiesToDeviceContactName$1 feedsTimelineEntityRepository$mapPhoneNumberInActivitiesToDeviceContactName$1 = new FeedsTimelineEntityRepository$mapPhoneNumberInActivitiesToDeviceContactName$1(this);
        Observable map = doOnNext.map(new Function() { // from class: id.dana.feeds.data.timeline.FeedsTimelineEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsTimelineEntityRepository.getAuthRequestContext(Function1.this, (SocialFeed) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.feeds.domain.timeline.FeedsTimelineRepository
    public final Observable<SocialFeed> PlaceComponentResult(int p0, String p1, String p2) {
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Observable map = ((FeedsTimelineData) this.lookAheadTest.getValue()).KClassImpl$Data$declaredNonStaticMembers$2(p0, p1, p2).map(new Function() { // from class: id.dana.feeds.data.timeline.FeedsTimelineEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsTimelineEntityRepository.BuiltInFictitiousFunctionClassFactory((MyFeedResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.feeds.domain.timeline.FeedsTimelineRepository
    public final Observable<SocialFeed> MyBillsEntityDataFactory(int p0, String p1, String p2) {
        Observable map = ((FeedsTimelineData) this.lookAheadTest.getValue()).getAuthRequestContext(p0, p1, p2).map(new Function() { // from class: id.dana.feeds.data.timeline.FeedsTimelineEntityRepository$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsTimelineEntityRepository.PlaceComponentResult((MyFeedResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }
}
