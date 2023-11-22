package id.dana.feeds.data.share;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import dagger.Lazy;
import id.dana.data.account.repository.source.AccountEntityData;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1Repository;
import id.dana.data.userconfig.BiztypeNotFoundException;
import id.dana.data.userconfig.repository.UserConfigEntityRepository;
import id.dana.domain.social.ExtendInfoUtilKt;
import id.dana.domain.social.model.ShareActivityConfig;
import id.dana.feeds.data.config.FeedsConfigEntityRepository;
import id.dana.feeds.data.config.model.FeedConfigResult;
import id.dana.feeds.data.mapper.PreviewActivityMapperKt;
import id.dana.feeds.data.share.source.FeedsShareData;
import id.dana.feeds.data.share.source.FeedsShareDataFactory;
import id.dana.feeds.data.share.source.local.model.CreateFeedActivityEntity;
import id.dana.feeds.data.share.source.network.NetworkFeedsShareEntityData;
import id.dana.feeds.data.share.source.network.request.CreateActivityRequest;
import id.dana.feeds.data.share.source.network.request.CreateActivityRequestMapperKt;
import id.dana.feeds.data.share.source.network.request.FetchShareableActivitiesRequest;
import id.dana.feeds.data.share.source.network.request.QueryShareFeedConfig;
import id.dana.feeds.data.share.source.network.request.StoreFeedShareConfig;
import id.dana.feeds.data.share.source.network.request.UserConfigFeedShareContent;
import id.dana.feeds.data.share.source.network.response.FetchShareableActivitiesResponse;
import id.dana.feeds.data.share.source.network.response.PreviewActivityResult;
import id.dana.feeds.data.storage.preferences.LocalSocialPreferencesData;
import id.dana.feeds.data.storage.preferences.SocialPreferencesData;
import id.dana.feeds.data.storage.preferences.SocialPreferencesDataFactory;
import id.dana.feeds.data.timeline.source.FeedsTimelineData;
import id.dana.feeds.data.timeline.source.FeedsTimelineDataFactory;
import id.dana.feeds.domain.share.FeedsShareRepository;
import id.dana.feeds.domain.share.interactor.CreateFeedActivity;
import id.dana.feeds.domain.share.model.PreviewActivityData;
import id.dana.feeds.domain.share.model.ShareFeedActivity;
import id.dana.feeds.domain.share.model.ShareableActivities;
import id.dana.feeds.domain.timeline.enums.FeedActivityState;
import id.dana.feeds.domain.timeline.model.ActivityResponse;
import id.dana.utils.foundation.logger.log.DanaLog;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002Be\b\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020'0&\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020*0&\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002080&\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020)0&\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002090&\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020+0&\u0012\u0006\u0010<\u001a\u00020,¢\u0006\u0004\b=\u0010>J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\u0006\u0010\b\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0005\u0010\u000eJ\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\u0006\u0010\b\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00100\u0003H\u0016¢\u0006\u0004\b\n\u0010\u0006J\u001f\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u000f\u0010\u0013J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0003H\u0016¢\u0006\u0004\b\u0015\u0010\u0006J\u000f\u0010\u000f\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u000f\u0010\u0016J\u0017\u0010\u0005\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0005\u0010\u0018JS\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00032\u0006\u0010\b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\f2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001d\u001a\u00020\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0015\u0010 J\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\u0006\u0010\b\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010!J\u0017\u0010\u000f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u000f\u0010\"J\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\u0006\u0010\b\u001a\u00020\fH\u0016¢\u0006\u0004\b#\u0010\u000eJ\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\u0006\u0010\b\u001a\u00020\u001fH\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0015\u0010%R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020'0&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010(R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020)0&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010(R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020*0&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010(R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020+0&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010(R\u0014\u0010\u0015\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010-R\u0017\u0010/\u001a\u0006*\u00020.0.X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b/\u00100R\u0013\u00103\u001a\u000201X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b2\u00100R\u0013\u00102\u001a\u000204X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b5\u00100R\u0013\u00107\u001a\u000206X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b7\u00100R\u001a\u00105\u001a\b\u0012\u0004\u0012\u0002080&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u0010(R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u0002090&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010("}, d2 = {"Lid/dana/feeds/data/share/FeedsShareEntityRepository;", "Lid/dana/feeds/domain/share/FeedsShareRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1Repository;", "Lio/reactivex/Observable;", "Lid/dana/feeds/domain/share/model/ShareFeedActivity;", "MyBillsEntityDataFactory", "()Lio/reactivex/Observable;", "Lid/dana/feeds/domain/share/interactor/CreateFeedActivity$Params;", "p0", "Lid/dana/feeds/domain/timeline/model/ActivityResponse;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/feeds/domain/share/interactor/CreateFeedActivity$Params;)Lio/reactivex/Observable;", "", "", "(Ljava/lang/String;)Lio/reactivex/Observable;", "PlaceComponentResult", "Lid/dana/feeds/domain/share/model/ShareableActivities;", "", "p1", "(Ljava/lang/String;I)Lid/dana/feeds/domain/share/model/ShareableActivities;", "", "getAuthRequestContext", "()Z", "Lid/dana/feeds/data/config/model/FeedConfigResult;", "(Lid/dana/feeds/data/config/model/FeedConfigResult;)Z", "p2", "", "", "p3", "p4", "p5", "Lid/dana/feeds/domain/share/model/PreviewActivityData;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;ILjava/lang/String;)Lio/reactivex/Observable;", "(Z)Lio/reactivex/Observable;", "(Z)V", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/feeds/domain/share/model/PreviewActivityData;)Lio/reactivex/Observable;", "(Ljava/lang/String;)Z", "Ldagger/Lazy;", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", "Ldagger/Lazy;", "Lid/dana/feeds/data/config/FeedsConfigEntityRepository;", "Lid/dana/feeds/data/share/source/FeedsShareDataFactory;", "Lid/dana/feeds/data/timeline/source/FeedsTimelineDataFactory;", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "Lid/dana/data/account/repository/source/AccountEntityData;", "lookAheadTest", "Lkotlin/Lazy;", "Lid/dana/feeds/data/storage/preferences/SocialPreferencesData;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "scheduleImpl", "Lid/dana/feeds/data/share/source/FeedsShareData;", "getErrorConfigVersion", "Lid/dana/feeds/data/timeline/source/FeedsTimelineData;", "moveToNextValue", "Lid/dana/feeds/data/storage/preferences/SocialPreferencesDataFactory;", "Lid/dana/data/userconfig/repository/UserConfigEntityRepository;", "DatabaseTableConfigUtil", "NetworkUserEntityData$$ExternalSyntheticLambda1", "p6", "<init>", "(Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FeedsShareEntityRepository implements FeedsShareRepository, HoldLoginV1Repository {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Lazy<AccountEntityDataFactory> MyBillsEntityDataFactory;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final Lazy<UserConfigEntityRepository> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Lazy<FeedsTimelineDataFactory> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Lazy<FeedsShareDataFactory> PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final kotlin.Lazy scheduleImpl;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Lazy<FeedsConfigEntityRepository> BuiltInFictitiousFunctionClassFactory;
    private final HoldLoginV1EntityRepository getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final kotlin.Lazy NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final kotlin.Lazy lookAheadTest;
    private final kotlin.Lazy moveToNextValue;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final Lazy<SocialPreferencesDataFactory> getErrorConfigVersion;

    @Inject
    public FeedsShareEntityRepository(Lazy<AccountEntityDataFactory> lazy, Lazy<FeedsShareDataFactory> lazy2, Lazy<SocialPreferencesDataFactory> lazy3, Lazy<FeedsConfigEntityRepository> lazy4, Lazy<UserConfigEntityRepository> lazy5, Lazy<FeedsTimelineDataFactory> lazy6, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        Intrinsics.checkNotNullParameter(lazy3, "");
        Intrinsics.checkNotNullParameter(lazy4, "");
        Intrinsics.checkNotNullParameter(lazy5, "");
        Intrinsics.checkNotNullParameter(lazy6, "");
        Intrinsics.checkNotNullParameter(holdLoginV1EntityRepository, "");
        this.MyBillsEntityDataFactory = lazy;
        this.PlaceComponentResult = lazy2;
        this.getErrorConfigVersion = lazy3;
        this.BuiltInFictitiousFunctionClassFactory = lazy4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = lazy5;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy6;
        this.getAuthRequestContext = holdLoginV1EntityRepository;
        this.lookAheadTest = LazyKt.lazy(new Function0<AccountEntityData>() { // from class: id.dana.feeds.data.share.FeedsShareEntityRepository$localAccountEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AccountEntityData invoke() {
                Lazy lazy7;
                lazy7 = FeedsShareEntityRepository.this.MyBillsEntityDataFactory;
                return ((AccountEntityDataFactory) lazy7.get()).createData2("local");
            }
        });
        this.scheduleImpl = LazyKt.lazy(new Function0<SocialPreferencesData>() { // from class: id.dana.feeds.data.share.FeedsShareEntityRepository$localSocialPreferencesData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SocialPreferencesData invoke() {
                Lazy lazy7;
                lazy7 = FeedsShareEntityRepository.this.getErrorConfigVersion;
                SocialPreferencesDataFactory socialPreferencesDataFactory = (SocialPreferencesDataFactory) lazy7.get();
                Intrinsics.checkNotNullParameter("local", "");
                return new LocalSocialPreferencesData(socialPreferencesDataFactory.PlaceComponentResult);
            }
        });
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = LazyKt.lazy(new Function0<FeedsShareData>() { // from class: id.dana.feeds.data.share.FeedsShareEntityRepository$networkFeedsShareData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FeedsShareData invoke() {
                Lazy lazy7;
                lazy7 = FeedsShareEntityRepository.this.PlaceComponentResult;
                FeedsShareDataFactory feedsShareDataFactory = (FeedsShareDataFactory) lazy7.get();
                return new NetworkFeedsShareEntityData(feedsShareDataFactory.PlaceComponentResult, feedsShareDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, feedsShareDataFactory.MyBillsEntityDataFactory, feedsShareDataFactory.BuiltInFictitiousFunctionClassFactory);
            }
        });
        this.moveToNextValue = LazyKt.lazy(new Function0<FeedsTimelineData>() { // from class: id.dana.feeds.data.share.FeedsShareEntityRepository$persistenceFeedsData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FeedsTimelineData invoke() {
                Lazy lazy7;
                lazy7 = FeedsShareEntityRepository.this.KClassImpl$Data$declaredNonStaticMembers$2;
                FeedsTimelineDataFactory feedsTimelineDataFactory = (FeedsTimelineDataFactory) lazy7.get();
                return Intrinsics.areEqual("local", "local") ? feedsTimelineDataFactory.getAuthRequestContext : feedsTimelineDataFactory.BuiltInFictitiousFunctionClassFactory;
            }
        });
    }

    @Override // id.dana.feeds.domain.share.FeedsShareRepository
    public final Observable<ActivityResponse> BuiltInFictitiousFunctionClassFactory(final CreateFeedActivity.Params p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        Observable flatMap = ((AccountEntityData) this.lookAheadTest.getValue()).getPhoneNumber().flatMap(new Function() { // from class: id.dana.feeds.data.share.FeedsShareEntityRepository$$ExternalSyntheticLambda14
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsShareEntityRepository.MyBillsEntityDataFactory(CreateFeedActivity.Params.this, this, booleanRef, (String) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    @Override // id.dana.feeds.domain.share.FeedsShareRepository
    public final boolean PlaceComponentResult() {
        try {
            return ((UserConfigFeedShareContent) this.NetworkUserEntityData$$ExternalSyntheticLambda1.get().getUserSpecificConfig(new QueryShareFeedConfig()).blockingSingle()).getShareFeed();
        } catch (Exception e) {
            if (e.getCause() instanceof BiztypeNotFoundException) {
                throw new BiztypeNotFoundException();
            }
            return false;
        }
    }

    @Override // id.dana.feeds.domain.share.FeedsShareRepository
    public final void PlaceComponentResult(boolean p0) {
        try {
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.get().saveUserSpecificConfigBackendFirst(new StoreFeedShareConfig(new UserConfigFeedShareContent(p0))).blockingFirst();
        } catch (Exception e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(getClass().getSimpleName(), e.getMessage());
        }
    }

    private static boolean MyBillsEntityDataFactory(FeedConfigResult p0) {
        if (Intrinsics.areEqual(p0.isCreateActivityEnabled(), Boolean.TRUE) && p0.getShareActivity() != null) {
            ShareActivityConfig shareActivity = p0.getShareActivity();
            Intrinsics.checkNotNull(shareActivity);
            if (shareActivity.getPaymentSuccess()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String, id.dana.feeds.domain.share.model.PreviewActivityData] */
    public static /* synthetic */ ObservableSource PlaceComponentResult(final FeedsShareEntityRepository feedsShareEntityRepository, FeedConfigResult feedConfigResult) {
        Observable just;
        Intrinsics.checkNotNullParameter(feedsShareEntityRepository, "");
        Intrinsics.checkNotNullParameter(feedConfigResult, "");
        if (!MyBillsEntityDataFactory(feedConfigResult)) {
            ?? r1 = 0;
            just = Observable.just(new ShareFeedActivity(r1, r1, 3, r1));
            Intrinsics.checkNotNullExpressionValue(just, "");
        } else {
            just = ((AccountEntityData) feedsShareEntityRepository.lookAheadTest.getValue()).getPhoneNumber().flatMap(new Function() { // from class: id.dana.feeds.data.share.FeedsShareEntityRepository$$ExternalSyntheticLambda6
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return FeedsShareEntityRepository.PlaceComponentResult(FeedsShareEntityRepository.this, (String) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(just, "");
        }
        return just;
    }

    public static /* synthetic */ ObservableSource PlaceComponentResult(final FeedsShareEntityRepository feedsShareEntityRepository, final String str, final String str2) {
        Intrinsics.checkNotNullParameter(feedsShareEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        return Observable.fromCallable(new Callable() { // from class: id.dana.feeds.data.share.FeedsShareEntityRepository$$ExternalSyntheticLambda11
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return FeedsShareEntityRepository.BuiltInFictitiousFunctionClassFactory(FeedsShareEntityRepository.this, str2, str);
            }
        });
    }

    public static /* synthetic */ ShareableActivities MyBillsEntityDataFactory(int i, FeedsShareEntityRepository feedsShareEntityRepository, String str, int i2, FetchShareableActivitiesResponse fetchShareableActivitiesResponse) {
        Intrinsics.checkNotNullParameter(feedsShareEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(fetchShareableActivitiesResponse, "");
        ShareableActivities KClassImpl$Data$declaredNonStaticMembers$2 = PreviewActivityMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(fetchShareableActivitiesResponse);
        List<PreviewActivityData> shareableActivities = KClassImpl$Data$declaredNonStaticMembers$2.getShareableActivities();
        List<PreviewActivityData> mutableList = shareableActivities != null ? CollectionsKt.toMutableList((Collection) shareableActivities) : null;
        if (i < 5) {
            String maxId = fetchShareableActivitiesResponse.getMaxId();
            if (maxId != null) {
                ((SocialPreferencesData) feedsShareEntityRepository.scheduleImpl.getValue()).getErrorConfigVersion(str, maxId);
            }
            List<PreviewActivityData> list = mutableList;
            if (list == null || list.isEmpty()) {
                return feedsShareEntityRepository.PlaceComponentResult(str, i);
            }
            List mutableList2 = CollectionsKt.toMutableList((Collection) ((SocialPreferencesData) feedsShareEntityRepository.scheduleImpl.getValue()).getAuthRequestContext(str));
            List list2 = mutableList2;
            if (true ^ list2.isEmpty()) {
                for (final PreviewActivityData previewActivityData : mutableList) {
                    CollectionsKt.removeAll(mutableList2, (Function1) new Function1<PreviewActivityData, Boolean>() { // from class: id.dana.feeds.data.share.FeedsShareEntityRepository$removeSameBizTypeActivity$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(PreviewActivityData previewActivityData2) {
                            Intrinsics.checkNotNullParameter(previewActivityData2, "");
                            HashMap<String, String> extendInfo = previewActivityData2.getExtendInfo();
                            String contentCode = extendInfo != null ? ExtendInfoUtilKt.getContentCode(extendInfo) : null;
                            HashMap<String, String> extendInfo2 = PreviewActivityData.this.getExtendInfo();
                            return Boolean.valueOf(Intrinsics.areEqual(contentCode, extendInfo2 != null ? ExtendInfoUtilKt.getContentCode(extendInfo2) : null));
                        }
                    });
                }
                List list3 = mutableList2;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                Iterator it = list3.iterator();
                while (it.hasNext()) {
                    ((PreviewActivityData) it.next()).setSkip(false);
                    arrayList.add(Unit.INSTANCE);
                }
                mutableList.addAll(list2);
            }
            ((SocialPreferencesData) feedsShareEntityRepository.scheduleImpl.getValue()).MyBillsEntityDataFactory(str, mutableList);
        }
        KClassImpl$Data$declaredNonStaticMembers$2.setShareableActivities(mutableList != null ? CollectionsKt.take(mutableList, i2) : null);
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public static /* synthetic */ ObservableSource MyBillsEntityDataFactory(final FeedsShareEntityRepository feedsShareEntityRepository, final String str, final String str2) {
        Intrinsics.checkNotNullParameter(feedsShareEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        return Observable.fromCallable(new Callable() { // from class: id.dana.feeds.data.share.FeedsShareEntityRepository$$ExternalSyntheticLambda8
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return FeedsShareEntityRepository.getAuthRequestContext(FeedsShareEntityRepository.this, str2, str);
            }
        });
    }

    public static /* synthetic */ Unit getAuthRequestContext(FeedsShareEntityRepository feedsShareEntityRepository, String str, String str2) {
        Intrinsics.checkNotNullParameter(feedsShareEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        ((SocialPreferencesData) feedsShareEntityRepository.scheduleImpl.getValue()).moveToNextValue(str, str2);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ ObservableSource MyBillsEntityDataFactory(final CreateFeedActivity.Params params, final FeedsShareEntityRepository feedsShareEntityRepository, final Ref.BooleanRef booleanRef, final String str) {
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(feedsShareEntityRepository, "");
        Intrinsics.checkNotNullParameter(booleanRef, "");
        Intrinsics.checkNotNullParameter(str, "");
        final CreateActivityRequest createActivityRequest = CreateActivityRequestMapperKt.toCreateActivityRequest(params);
        SocialPreferencesData socialPreferencesData = (SocialPreferencesData) feedsShareEntityRepository.scheduleImpl.getValue();
        socialPreferencesData.PlaceComponentResult(str, new CreateFeedActivityEntity(createActivityRequest, params.getAuthRequestContext, null, 4, null));
        socialPreferencesData.KClassImpl$Data$declaredNonStaticMembers$2(str, params.moveToNextValue);
        socialPreferencesData.getAuthRequestContext(str, params.moveToNextValue);
        return ((FeedsShareData) feedsShareEntityRepository.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue()).PlaceComponentResult(createActivityRequest).doOnError(new Consumer() { // from class: id.dana.feeds.data.share.FeedsShareEntityRepository$$ExternalSyntheticLambda16
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                Throwable th = (Throwable) obj;
                FeedsShareEntityRepository.getAuthRequestContext(FeedsShareEntityRepository.this, str, createActivityRequest, booleanRef, params);
            }
        }).doOnNext(new Consumer() { // from class: id.dana.feeds.data.share.FeedsShareEntityRepository$$ExternalSyntheticLambda17
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeedsShareEntityRepository.PlaceComponentResult(Ref.BooleanRef.this, feedsShareEntityRepository, params, str, createActivityRequest, (BaseRpcResult) obj);
            }
        }).map(new Function() { // from class: id.dana.feeds.data.share.FeedsShareEntityRepository$$ExternalSyntheticLambda18
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsShareEntityRepository.PlaceComponentResult(CreateFeedActivity.Params.this, booleanRef, (BaseRpcResult) obj);
            }
        });
    }

    public static /* synthetic */ ObservableSource KClassImpl$Data$declaredNonStaticMembers$2(final FeedsShareEntityRepository feedsShareEntityRepository, final String str, final String str2) {
        Intrinsics.checkNotNullParameter(feedsShareEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        return Observable.fromCallable(new Callable() { // from class: id.dana.feeds.data.share.FeedsShareEntityRepository$$ExternalSyntheticLambda13
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return FeedsShareEntityRepository.lookAheadTest(FeedsShareEntityRepository.this, str2, str);
            }
        });
    }

    public static /* synthetic */ ActivityResponse PlaceComponentResult(CreateFeedActivity.Params params, Ref.BooleanRef booleanRef, BaseRpcResult baseRpcResult) {
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(booleanRef, "");
        Intrinsics.checkNotNullParameter(baseRpcResult, "");
        return ActivityResponse.INSTANCE.createShareFeedActivityResponse(baseRpcResult.success, params.moveToNextValue, System.currentTimeMillis(), booleanRef.element);
    }

    public static /* synthetic */ ObservableSource BuiltInFictitiousFunctionClassFactory(final int i, final FeedsShareEntityRepository feedsShareEntityRepository, final int i2, final String str) {
        Intrinsics.checkNotNullParameter(feedsShareEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        String MyBillsEntityDataFactory = i < 5 ? ((SocialPreferencesData) feedsShareEntityRepository.scheduleImpl.getValue()).MyBillsEntityDataFactory(str) : "";
        return ((FeedsShareData) feedsShareEntityRepository.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue()).BuiltInFictitiousFunctionClassFactory(new FetchShareableActivitiesRequest(i2, MyBillsEntityDataFactory != null ? MyBillsEntityDataFactory : "", i)).map(new Function() { // from class: id.dana.feeds.data.share.FeedsShareEntityRepository$$ExternalSyntheticLambda12
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsShareEntityRepository.MyBillsEntityDataFactory(i, feedsShareEntityRepository, str, i2, (FetchShareableActivitiesResponse) obj);
            }
        }).onErrorResumeNext(Observable.just(feedsShareEntityRepository.PlaceComponentResult(str, i)));
    }

    public static /* synthetic */ void getAuthRequestContext(FeedsShareEntityRepository feedsShareEntityRepository, String str, CreateActivityRequest createActivityRequest, Ref.BooleanRef booleanRef, CreateFeedActivity.Params params) {
        Intrinsics.checkNotNullParameter(feedsShareEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(createActivityRequest, "");
        Intrinsics.checkNotNullParameter(booleanRef, "");
        Intrinsics.checkNotNullParameter(params, "");
        ((SocialPreferencesData) feedsShareEntityRepository.scheduleImpl.getValue()).MyBillsEntityDataFactory(str, createActivityRequest.getShareFeedRequestId(), FeedActivityState.ERROR);
        booleanRef.element = feedsShareEntityRepository.getAuthRequestContext(params.moveToNextValue);
    }

    public static /* synthetic */ void getAuthRequestContext(FeedsShareEntityRepository feedsShareEntityRepository, String str, String str2, PreviewActivityResult previewActivityResult) {
        Intrinsics.checkNotNullParameter(feedsShareEntityRepository, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Boolean shareable = previewActivityResult.getShareable();
        if (shareable == null || !shareable.booleanValue()) {
            return;
        }
        SocialPreferencesData socialPreferencesData = (SocialPreferencesData) feedsShareEntityRepository.scheduleImpl.getValue();
        Intrinsics.checkNotNullExpressionValue(str, "");
        Intrinsics.checkNotNullExpressionValue(previewActivityResult, "");
        socialPreferencesData.MyBillsEntityDataFactory(str, str2, PreviewActivityMapperKt.BuiltInFictitiousFunctionClassFactory(previewActivityResult));
    }

    public static /* synthetic */ ObservableSource BuiltInFictitiousFunctionClassFactory(final FeedsShareEntityRepository feedsShareEntityRepository, FeedConfigResult feedConfigResult) {
        Intrinsics.checkNotNullParameter(feedsShareEntityRepository, "");
        Intrinsics.checkNotNullParameter(feedConfigResult, "");
        ShareActivityConfig shareActivity = feedConfigResult.getShareActivity();
        final int bannerLimit = shareActivity != null ? shareActivity.getBannerLimit() : 8;
        Integer feedVersion = feedConfigResult.getFeedVersion();
        final int intValue = feedVersion != null ? feedVersion.intValue() : 5;
        ObservableSource flatMap = ((AccountEntityData) feedsShareEntityRepository.lookAheadTest.getValue()).getUserId().flatMap(new Function() { // from class: id.dana.feeds.data.share.FeedsShareEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsShareEntityRepository.BuiltInFictitiousFunctionClassFactory(intValue, feedsShareEntityRepository, bannerLimit, (String) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    public static /* synthetic */ Unit BuiltInFictitiousFunctionClassFactory(FeedsShareEntityRepository feedsShareEntityRepository, String str, String str2) {
        Intrinsics.checkNotNullParameter(feedsShareEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        ((SocialPreferencesData) feedsShareEntityRepository.scheduleImpl.getValue()).PlaceComponentResult(str, str2);
        ((FeedsTimelineData) feedsShareEntityRepository.moveToNextValue.getValue()).getAuthRequestContext(str2);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void PlaceComponentResult(Ref.BooleanRef booleanRef, FeedsShareEntityRepository feedsShareEntityRepository, CreateFeedActivity.Params params, String str, CreateActivityRequest createActivityRequest, BaseRpcResult baseRpcResult) {
        Intrinsics.checkNotNullParameter(booleanRef, "");
        Intrinsics.checkNotNullParameter(feedsShareEntityRepository, "");
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(createActivityRequest, "");
        booleanRef.element = feedsShareEntityRepository.getAuthRequestContext(params.moveToNextValue);
        ((SocialPreferencesData) feedsShareEntityRepository.scheduleImpl.getValue()).MyBillsEntityDataFactory(str, createActivityRequest.getShareFeedRequestId(), baseRpcResult.success ? FeedActivityState.SUCCESS : FeedActivityState.ERROR);
    }

    public static /* synthetic */ ObservableSource KClassImpl$Data$declaredNonStaticMembers$2(FeedsShareEntityRepository feedsShareEntityRepository, PreviewActivityData previewActivityData, String str) {
        Intrinsics.checkNotNullParameter(feedsShareEntityRepository, "");
        Intrinsics.checkNotNullParameter(previewActivityData, "");
        Intrinsics.checkNotNullParameter(str, "");
        return Observable.just(Boolean.valueOf(((SocialPreferencesData) feedsShareEntityRepository.scheduleImpl.getValue()).scheduleImpl(str, previewActivityData.getShareFeedRequestId())));
    }

    public static /* synthetic */ PreviewActivityData BuiltInFictitiousFunctionClassFactory(PreviewActivityResult previewActivityResult) {
        Intrinsics.checkNotNullParameter(previewActivityResult, "");
        return PreviewActivityMapperKt.BuiltInFictitiousFunctionClassFactory(previewActivityResult);
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String, id.dana.feeds.domain.share.model.PreviewActivityData] */
    public static /* synthetic */ ShareFeedActivity KClassImpl$Data$declaredNonStaticMembers$2(FeedsShareEntityRepository feedsShareEntityRepository, String str) {
        Intrinsics.checkNotNullParameter(feedsShareEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        String KClassImpl$Data$declaredNonStaticMembers$2 = ((SocialPreferencesData) feedsShareEntityRepository.scheduleImpl.getValue()).KClassImpl$Data$declaredNonStaticMembers$2(str);
        String str2 = KClassImpl$Data$declaredNonStaticMembers$2;
        if (!(str2 == null || str2.length() == 0)) {
            return new ShareFeedActivity(((SocialPreferencesData) feedsShareEntityRepository.scheduleImpl.getValue()).MyBillsEntityDataFactory(str, KClassImpl$Data$declaredNonStaticMembers$2), KClassImpl$Data$declaredNonStaticMembers$2);
        }
        ?? r0 = 0;
        return new ShareFeedActivity(r0, r0, 3, r0);
    }

    public static /* synthetic */ ObservableSource PlaceComponentResult(final FeedsShareEntityRepository feedsShareEntityRepository, final String str) {
        Intrinsics.checkNotNullParameter(feedsShareEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        return Observable.fromCallable(new Callable() { // from class: id.dana.feeds.data.share.FeedsShareEntityRepository$$ExternalSyntheticLambda4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return FeedsShareEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(FeedsShareEntityRepository.this, str);
            }
        });
    }

    public static /* synthetic */ Unit lookAheadTest(FeedsShareEntityRepository feedsShareEntityRepository, String str, String str2) {
        Intrinsics.checkNotNullParameter(feedsShareEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        SocialPreferencesData socialPreferencesData = (SocialPreferencesData) feedsShareEntityRepository.scheduleImpl.getValue();
        socialPreferencesData.KClassImpl$Data$declaredNonStaticMembers$2(str, str2);
        socialPreferencesData.getAuthRequestContext(str, str2);
        return Unit.INSTANCE;
    }

    private final ShareableActivities PlaceComponentResult(String p0, int p1) {
        if (p1 < 5) {
            List<PreviewActivityData> authRequestContext = ((SocialPreferencesData) this.scheduleImpl.getValue()).getAuthRequestContext(p0);
            ArrayList arrayList = new ArrayList();
            for (Object obj : authRequestContext) {
                if ((!((PreviewActivityData) obj).isSkip()) != false) {
                    arrayList.add(obj);
                }
            }
            return new ShareableActivities(null, null, arrayList, 3, null);
        }
        return new ShareableActivities(null, null, CollectionsKt.emptyList(), 3, null);
    }

    private final boolean getAuthRequestContext(final String p0) {
        boolean z;
        Integer feedVersion = this.BuiltInFictitiousFunctionClassFactory.get().getAuthRequestContext().blockingFirst().getFeedVersion();
        int intValue = feedVersion != null ? feedVersion.intValue() : 5;
        String blockingFirst = ((AccountEntityData) this.lookAheadTest.getValue()).getUserId().blockingFirst();
        SocialPreferencesData socialPreferencesData = (SocialPreferencesData) this.scheduleImpl.getValue();
        Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
        List<PreviewActivityData> mutableList = CollectionsKt.toMutableList((Collection) socialPreferencesData.getAuthRequestContext(blockingFirst));
        if (intValue >= 5) {
            return true;
        }
        List<PreviewActivityData> list = mutableList;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(p0, ((PreviewActivityData) it.next()).getShareFeedRequestId())) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (z) {
            CollectionsKt.removeAll((List) mutableList, (Function1) new Function1<PreviewActivityData, Boolean>() { // from class: id.dana.feeds.data.share.FeedsShareEntityRepository$updateShareableActivity$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(PreviewActivityData previewActivityData) {
                    Intrinsics.checkNotNullParameter(previewActivityData, "");
                    return Boolean.valueOf(Intrinsics.areEqual(p0, previewActivityData.getShareFeedRequestId()));
                }
            });
            ((SocialPreferencesData) this.scheduleImpl.getValue()).PlaceComponentResult(blockingFirst, mutableList);
            return true;
        }
        return false;
    }

    @Override // id.dana.feeds.domain.share.FeedsShareRepository
    public final Observable<ShareFeedActivity> MyBillsEntityDataFactory() {
        Observable flatMap = this.BuiltInFictitiousFunctionClassFactory.get().getAuthRequestContext().flatMap(new Function() { // from class: id.dana.feeds.data.share.FeedsShareEntityRepository$$ExternalSyntheticLambda15
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsShareEntityRepository.PlaceComponentResult(FeedsShareEntityRepository.this, (FeedConfigResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    @Override // id.dana.feeds.domain.share.FeedsShareRepository
    public final Observable<Unit> MyBillsEntityDataFactory(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable flatMap = ((AccountEntityData) this.lookAheadTest.getValue()).getPhoneNumber().flatMap(new Function() { // from class: id.dana.feeds.data.share.FeedsShareEntityRepository$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsShareEntityRepository.PlaceComponentResult(FeedsShareEntityRepository.this, p0, (String) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    @Override // id.dana.feeds.domain.share.FeedsShareRepository
    public final Observable<Unit> PlaceComponentResult(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable flatMap = ((AccountEntityData) this.lookAheadTest.getValue()).getPhoneNumber().flatMap(new Function() { // from class: id.dana.feeds.data.share.FeedsShareEntityRepository$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsShareEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(FeedsShareEntityRepository.this, p0, (String) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    @Override // id.dana.feeds.domain.share.FeedsShareRepository
    public final Observable<ShareableActivities> BuiltInFictitiousFunctionClassFactory() {
        Observable flatMap = this.BuiltInFictitiousFunctionClassFactory.get().getAuthRequestContext().flatMap(new Function() { // from class: id.dana.feeds.data.share.FeedsShareEntityRepository$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsShareEntityRepository.BuiltInFictitiousFunctionClassFactory(FeedsShareEntityRepository.this, (FeedConfigResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    @Override // id.dana.feeds.domain.share.FeedsShareRepository
    public final Observable<Boolean> getAuthRequestContext() {
        return ((SocialPreferencesData) this.scheduleImpl.getValue()).MyBillsEntityDataFactory();
    }

    @Override // id.dana.feeds.domain.share.FeedsShareRepository
    public final Observable<PreviewActivityData> getAuthRequestContext(final String p0, String p1, String p2, Map<String, ? extends Object> p3, int p4, String p5) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        final String blockingFirst = ((AccountEntityData) this.lookAheadTest.getValue()).getPhoneNumber().blockingFirst();
        Observable map = ((FeedsShareData) this.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue()).KClassImpl$Data$declaredNonStaticMembers$2(p0, p1, p2, p3, p4, p5).doOnNext(new Consumer() { // from class: id.dana.feeds.data.share.FeedsShareEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeedsShareEntityRepository.getAuthRequestContext(FeedsShareEntityRepository.this, blockingFirst, p0, (PreviewActivityResult) obj);
            }
        }).map(new Function() { // from class: id.dana.feeds.data.share.FeedsShareEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsShareEntityRepository.BuiltInFictitiousFunctionClassFactory((PreviewActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.feeds.domain.share.FeedsShareRepository
    public final Observable<Boolean> getAuthRequestContext(boolean p0) {
        return ((SocialPreferencesData) this.scheduleImpl.getValue()).PlaceComponentResult(p0);
    }

    @Override // id.dana.feeds.domain.share.FeedsShareRepository
    public final Observable<Unit> KClassImpl$Data$declaredNonStaticMembers$2(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable flatMap = ((AccountEntityData) this.lookAheadTest.getValue()).getPhoneNumber().flatMap(new Function() { // from class: id.dana.feeds.data.share.FeedsShareEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsShareEntityRepository.MyBillsEntityDataFactory(FeedsShareEntityRepository.this, p0, (String) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    @Override // id.dana.feeds.domain.share.FeedsShareRepository
    public final Observable<Boolean> KClassImpl$Data$declaredNonStaticMembers$2(final PreviewActivityData p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable flatMap = ((AccountEntityData) this.lookAheadTest.getValue()).getUserId().flatMap(new Function() { // from class: id.dana.feeds.data.share.FeedsShareEntityRepository$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsShareEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(FeedsShareEntityRepository.this, p0, (String) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }
}
