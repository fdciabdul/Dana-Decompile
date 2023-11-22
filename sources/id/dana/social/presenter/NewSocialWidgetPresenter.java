package id.dana.social.presenter;

import android.content.Context;
import dagger.Lazy;
import id.dana.domain.DefaultObserver;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.social.model.FeedConfig;
import id.dana.feeds.domain.activation.interactor.GetFriendsFeedWithInitFeedAndFeatureCheck;
import id.dana.feeds.domain.activation.interactor.InitSocialFeed;
import id.dana.feeds.domain.activation.interactor.ObserveInitFeed;
import id.dana.feeds.domain.config.interactor.GetFeedConfig;
import id.dana.feeds.domain.share.interactor.GetShareFeedConsent;
import id.dana.feeds.domain.share.interactor.SaveShareFeedConsent;
import id.dana.feeds.domain.timeline.interactor.GetCachedFeedsForWidget;
import id.dana.feeds.domain.timeline.interactor.GetCachedTimeline;
import id.dana.feeds.domain.timeline.interactor.GetTimeline;
import id.dana.feeds.domain.timeline.model.ActivityResponse;
import id.dana.feeds.domain.timeline.model.SocialFeed;
import id.dana.social.FeedUserConfigHelper;
import id.dana.social.contract.SocialWidgetContract;
import id.dana.social.model.FeedViewHolderModel;
import id.dana.social.model.SocialFeedWrapperModel;
import id.dana.social.model.mapper.FeedMapper;
import id.dana.social.model.mapper.GroupedFeedMapper;
import id.dana.utils.ErrorUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 S2\u00020\u0001:\u0001SBÍ\u0001\b\u0007\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020<0\u001a\u0012\f\u0010>\u001a\b\u0012\u0004\u0012\u00020=0\u001a\u0012\f\u0010@\u001a\b\u0012\u0004\u0012\u00020?0\u001a\u0012\f\u0010B\u001a\b\u0012\u0004\u0012\u00020A0\u001a\u0012\f\u0010D\u001a\b\u0012\u0004\u0012\u00020C0\u001a\u0012\f\u0010F\u001a\b\u0012\u0004\u0012\u00020E0\u001a\u0012\f\u0010H\u001a\b\u0012\u0004\u0012\u00020G0\u001a\u0012\f\u0010J\u001a\b\u0012\u0004\u0012\u00020I0\u001a\u0012\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\f\u0010L\u001a\b\u0012\u0004\u0012\u00020.0\u001a\u0012\f\u0010M\u001a\b\u0012\u0004\u0012\u00020+0\u001a\u0012\f\u0010N\u001a\b\u0012\u0004\u0012\u00020)0\u001a\u0012\f\u0010O\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001a\u0012\f\u0010P\u001a\b\u0012\u0004\u0012\u00020'0\u001a¢\u0006\u0004\bQ\u0010RJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\r\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0007\u0010\fJ\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0003\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0005\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\bJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0005\u0010\u0013R\u0016\u0010\u0005\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u0012X\u0086\u0002¢\u0006\u0006\n\u0004\b\n\u0010\u0019R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0016\u0010\"\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u001e\u0010$\u001a\f\u0012\b\u0012\u0006*\u00020\u000b0\u000b0\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\u0018R\u0016\u0010&\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010!R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020'0\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001dR\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020)0\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001dR\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020+0\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010\u001dR\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020.0\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010\u001dR\u0012\u00101\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\t\u0010!R\u0012\u00102\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b&\u0010!R\u001a\u00103\u001a\b\u0012\u0004\u0012\u00020\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010\u0018R\u0012\u00104\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b*\u0010!R\u0012\u00105\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b(\u0010\u0015R\u0018\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020706X\u0086\"¢\u0006\u0006\n\u0004\b\"\u00108R\u0018\u0010;\u001a\b\u0012\u0004\u0012\u00020\u000b09X\u0086\u0002¢\u0006\u0006\n\u0004\b-\u0010:"}, d2 = {"Lid/dana/social/presenter/NewSocialWidgetPresenter;", "Lid/dana/social/presenter/SocialWidgetPresenter;", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Z)V", "MyBillsEntityDataFactory", "()V", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "", "(Ljava/lang/String;)Z", "Lid/dana/feeds/domain/timeline/model/SocialFeed;", "", "Lid/dana/social/model/FeedViewHolderModel;", "(Lid/dana/feeds/domain/timeline/model/SocialFeed;)Ljava/util/List;", "onDestroy", "Lid/dana/domain/social/model/FeedConfig;", "(Lid/dana/domain/social/model/FeedConfig;)V", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Ljava/lang/String;", "Lio/reactivex/subjects/PublishSubject;", "PlaceComponentResult", "Lio/reactivex/subjects/PublishSubject;", "Lid/dana/domain/social/model/FeedConfig;", "Ldagger/Lazy;", "Lid/dana/social/model/mapper/FeedMapper;", "NetworkUserEntityData$$ExternalSyntheticLambda6", "Ldagger/Lazy;", "Lid/dana/social/FeedUserConfigHelper;", "NetworkUserEntityData$$ExternalSyntheticLambda3", "NetworkUserEntityData$$ExternalSyntheticLambda4", "Z", "NetworkUserEntityData$$ExternalSyntheticLambda0", "FragmentBottomSheetPaymentSettingBinding", "scheduleImpl", "NetworkUserEntityData$$ExternalSyntheticLambda5", "lookAheadTest", "Lid/dana/feeds/domain/timeline/interactor/GetCachedFeedsForWidget;", "moveToNextValue", "Lid/dana/feeds/domain/timeline/interactor/GetCachedTimeline;", "getErrorConfigVersion", "Lid/dana/feeds/domain/config/interactor/GetFeedConfig;", "SubSequence", "DatabaseTableConfigUtil", "Lid/dana/social/model/mapper/GroupedFeedMapper;", "whenAvailable", "GetContactSyncConfig", "NetworkUserEntityData$$ExternalSyntheticLambda1", "NetworkUserEntityData$$ExternalSyntheticLambda2", "initRecordTimeStamp", "isLayoutRequested", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Lio/reactivex/Observable;", "", "Lio/reactivex/Observable;", "Lid/dana/domain/DefaultObserver;", "Lid/dana/domain/DefaultObserver;", "PrepareContext", "Landroid/content/Context;", "Lid/dana/feeds/domain/timeline/interactor/GetTimeline;", "p1", "Lid/dana/feeds/domain/activation/interactor/GetFriendsFeedWithInitFeedAndFeatureCheck;", "p2", "Lid/dana/feeds/domain/share/interactor/SaveShareFeedConsent;", "p3", "Lid/dana/feeds/domain/share/interactor/GetShareFeedConsent;", "p4", "Lid/dana/feeds/domain/activation/interactor/ObserveInitFeed;", "p5", "Lid/dana/feeds/domain/activation/interactor/InitSocialFeed;", "p6", "Lid/dana/social/contract/SocialWidgetContract$View;", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "<init>", "(Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewSocialWidgetPresenter extends SocialWidgetPresenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final Lazy<GetCachedFeedsForWidget> moveToNextValue;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    public DefaultObserver<String> PrepareContext;

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    private final PublishSubject<String> scheduleImpl;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public boolean NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final Lazy<GetCachedTimeline> getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public Observable<Long> NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    private final Lazy<FeedUserConfigHelper> MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    private boolean lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    private final Lazy<FeedMapper> getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final PublishSubject<Boolean> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: SubSequence  reason: from kotlin metadata */
    private final Lazy<GetFeedConfig> DatabaseTableConfigUtil;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    FeedConfig PlaceComponentResult;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    boolean isLayoutRequested;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    boolean NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    String NetworkUserEntityData$$ExternalSyntheticLambda8;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final PublishSubject<Boolean> initRecordTimeStamp;

    /* renamed from: whenAvailable  reason: from kotlin metadata */
    private final Lazy<GroupedFeedMapper> GetContactSyncConfig;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[FeedUserConfigHelper.FeedUserConfigFetchingState.values().length];
            iArr[FeedUserConfigHelper.FeedUserConfigFetchingState.FETCHED.ordinal()] = 1;
            iArr[FeedUserConfigHelper.FeedUserConfigFetchingState.ERROR_REACH_LIMIT.ordinal()] = 2;
            iArr[FeedUserConfigHelper.FeedUserConfigFetchingState.ERROR.ordinal()] = 3;
            iArr[FeedUserConfigHelper.FeedUserConfigFetchingState.LOADING.ordinal()] = 4;
            getAuthRequestContext = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NewSocialWidgetPresenter(Lazy<Context> lazy, Lazy<GetTimeline> lazy2, Lazy<GetFriendsFeedWithInitFeedAndFeatureCheck> lazy3, Lazy<SaveShareFeedConsent> lazy4, Lazy<GetShareFeedConsent> lazy5, Lazy<ObserveInitFeed> lazy6, Lazy<InitSocialFeed> lazy7, Lazy<SocialWidgetContract.View> lazy8, Lazy<FeedMapper> lazy9, Lazy<GroupedFeedMapper> lazy10, Lazy<GetFeedConfig> lazy11, Lazy<GetCachedTimeline> lazy12, Lazy<FeedUserConfigHelper> lazy13, Lazy<GetCachedFeedsForWidget> lazy14) {
        super(lazy, lazy11, lazy2, lazy3, lazy4, lazy5, lazy6, lazy7, lazy8);
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        Intrinsics.checkNotNullParameter(lazy3, "");
        Intrinsics.checkNotNullParameter(lazy4, "");
        Intrinsics.checkNotNullParameter(lazy5, "");
        Intrinsics.checkNotNullParameter(lazy6, "");
        Intrinsics.checkNotNullParameter(lazy7, "");
        Intrinsics.checkNotNullParameter(lazy8, "");
        Intrinsics.checkNotNullParameter(lazy9, "");
        Intrinsics.checkNotNullParameter(lazy10, "");
        Intrinsics.checkNotNullParameter(lazy11, "");
        Intrinsics.checkNotNullParameter(lazy12, "");
        Intrinsics.checkNotNullParameter(lazy13, "");
        Intrinsics.checkNotNullParameter(lazy14, "");
        this.getAuthRequestContext = lazy9;
        this.GetContactSyncConfig = lazy10;
        this.DatabaseTableConfigUtil = lazy11;
        this.getErrorConfigVersion = lazy12;
        this.MyBillsEntityDataFactory = lazy13;
        this.moveToNextValue = lazy14;
        PublishSubject<String> PlaceComponentResult = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        this.scheduleImpl = PlaceComponentResult;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = "";
        this.BuiltInFictitiousFunctionClassFactory = "";
        this.PrepareContext = new DefaultObserver<String>() { // from class: id.dana.social.presenter.NewSocialWidgetPresenter$timelinePublishSubjectObserver$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                String str = (String) obj;
                Intrinsics.checkNotNullParameter(str, "");
                final NewSocialWidgetPresenter newSocialWidgetPresenter = NewSocialWidgetPresenter.this;
                if (newSocialWidgetPresenter.isLayoutRequested) {
                    return;
                }
                newSocialWidgetPresenter.isLayoutRequested = true;
                GetCachedTimeline getCachedTimeline = newSocialWidgetPresenter.getErrorConfigVersion.get();
                FeedConfig feedConfig = newSocialWidgetPresenter.PlaceComponentResult;
                int activitiesPerRequest = feedConfig != null ? feedConfig.getActivitiesPerRequest() : 10;
                FeedConfig feedConfig2 = newSocialWidgetPresenter.PlaceComponentResult;
                getCachedTimeline.execute(new GetCachedTimeline.Params(activitiesPerRequest, null, str, null, feedConfig2 != null ? feedConfig2.getHomeFeedVersion() : 4, false, 8, null), new Function1<SocialFeed, Unit>() { // from class: id.dana.social.presenter.NewSocialWidgetPresenter$doFetchTimeline$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(SocialFeed socialFeed) {
                        invoke2(socialFeed);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(SocialFeed socialFeed) {
                        Intrinsics.checkNotNullParameter(socialFeed, "");
                        NewSocialWidgetPresenter.BuiltInFictitiousFunctionClassFactory(NewSocialWidgetPresenter.this, socialFeed);
                    }
                }, new Function1<Throwable, Unit>() { // from class: id.dana.social.presenter.NewSocialWidgetPresenter$doFetchTimeline$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th) {
                        Intrinsics.checkNotNullParameter(th, "");
                        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.RELATIONSHIP, ErrorUtil.MyBillsEntityDataFactory(GetCachedTimeline.class, NewSocialWidgetPresenter.this.getClass(), String.valueOf(new Exception(th).getCause())));
                        NewSocialWidgetPresenter.this.DatabaseTableConfigUtil.get().NetworkUserEntityData$$ExternalSyntheticLambda0();
                        NewSocialWidgetPresenter.this.isLayoutRequested = false;
                    }
                });
            }
        };
        PublishSubject<Boolean> PlaceComponentResult2 = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = PlaceComponentResult2;
        PublishSubject<Boolean> PlaceComponentResult3 = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult3, "");
        this.initRecordTimeStamp = PlaceComponentResult3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getAuthRequestContext(NewSocialWidgetPresenter newSocialWidgetPresenter, String str) {
        Intrinsics.checkNotNullParameter(newSocialWidgetPresenter, "");
        Intrinsics.checkNotNullParameter(str, "");
        FeedConfig feedConfig = newSocialWidgetPresenter.PlaceComponentResult;
        return (feedConfig != null ? feedConfig.isFeedEnabled() : false) && newSocialWidgetPresenter.scheduleImpl.isFinished();
    }

    @Override // id.dana.social.presenter.SocialWidgetPresenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        super.BuiltInFictitiousFunctionClassFactory();
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = "";
    }

    @Override // id.dana.social.presenter.SocialWidgetPresenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        Unit unit;
        FeedConfig feedConfig = this.PlaceComponentResult;
        if (feedConfig != null) {
            this.DatabaseTableConfigUtil.get().PlaceComponentResult(feedConfig.isFeedEnabled(), feedConfig.isFeedWidgetEnabled(), feedConfig.isMaintenance(), feedConfig.getFeedVersion());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.DatabaseTableConfigUtil.get().execute(NoParams.INSTANCE, new Function1<FeedConfig, Unit>() { // from class: id.dana.social.presenter.NewSocialWidgetPresenter$doGetHomeConfigSocialConfig$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(FeedConfig feedConfig2) {
                    invoke2(feedConfig2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(FeedConfig feedConfig2) {
                    Intrinsics.checkNotNullParameter(feedConfig2, "");
                    NewSocialWidgetPresenter.this.PlaceComponentResult = feedConfig2;
                    NewSocialWidgetPresenter.this.DatabaseTableConfigUtil.get().PlaceComponentResult(feedConfig2.isFeedEnabled(), feedConfig2.isFeedWidgetEnabled(), feedConfig2.isMaintenance(), feedConfig2.getFeedVersion());
                }
            }, new Function1<Throwable, Unit>() { // from class: id.dana.social.presenter.NewSocialWidgetPresenter$doGetHomeConfigSocialConfig$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    Intrinsics.checkNotNullParameter(th, "");
                    DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.RELATIONSHIP, ErrorUtil.MyBillsEntityDataFactory(GetFeedConfig.class, NewSocialWidgetPresenter.this.getClass(), String.valueOf(new Exception(th).getCause())));
                }
            });
        }
    }

    public final void getAuthRequestContext() {
        Unit unit;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
            return;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
        FeedConfig feedConfig = this.PlaceComponentResult;
        if (feedConfig != null) {
            BuiltInFictitiousFunctionClassFactory(feedConfig);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.DatabaseTableConfigUtil.get().execute(NoParams.INSTANCE, new Function1<FeedConfig, Unit>() { // from class: id.dana.social.presenter.NewSocialWidgetPresenter$doGetHomeConfigWidgetTimelineInInterval$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(FeedConfig feedConfig2) {
                    invoke2(feedConfig2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(FeedConfig feedConfig2) {
                    Intrinsics.checkNotNullParameter(feedConfig2, "");
                    NewSocialWidgetPresenter.this.PlaceComponentResult = feedConfig2;
                    NewSocialWidgetPresenter.this.BuiltInFictitiousFunctionClassFactory(feedConfig2);
                }
            }, new Function1<Throwable, Unit>() { // from class: id.dana.social.presenter.NewSocialWidgetPresenter$doGetHomeConfigWidgetTimelineInInterval$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    Intrinsics.checkNotNullParameter(th, "");
                    DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.RELATIONSHIP, ErrorUtil.MyBillsEntityDataFactory(GetFeedConfig.class, NewSocialWidgetPresenter.this.getClass(), String.valueOf(new Exception(th).getCause())));
                }
            });
        }
    }

    @Override // id.dana.social.presenter.SocialWidgetPresenter
    public final void MyBillsEntityDataFactory() {
        this.scheduleImpl.onNext(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void BuiltInFictitiousFunctionClassFactory(FeedConfig p0) {
        if (p0.isRealtimeFeedEnabled() && this.NetworkUserEntityData$$ExternalSyntheticLambda7 == null) {
            Observable<Long> interval = Observable.interval(p0.getInterval(), TimeUnit.MILLISECONDS);
            Intrinsics.checkNotNullExpressionValue(interval, "");
            Intrinsics.checkNotNullParameter(interval, "");
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = interval;
            if (interval == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                interval = null;
            }
            interval.subscribe(new NewSocialWidgetPresenter$createTimelineObserver$1(this));
        }
    }

    private final boolean MyBillsEntityDataFactory(String p0) {
        return (p0.length() > 0) && !Intrinsics.areEqual(p0, this.NetworkUserEntityData$$ExternalSyntheticLambda8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<FeedViewHolderModel> BuiltInFictitiousFunctionClassFactory(SocialFeed p0) {
        List<FeedViewHolderModel> BuiltInFictitiousFunctionClassFactory;
        if (p0.isFeedNotVersionTwo()) {
            if (p0.getFromCache()) {
                GroupedFeedMapper groupedFeedMapper = this.GetContactSyncConfig.get();
                Intrinsics.checkNotNullExpressionValue(groupedFeedMapper, "");
                BuiltInFictitiousFunctionClassFactory = GroupedFeedMapper.BuiltInFictitiousFunctionClassFactory(groupedFeedMapper, new Date(), p0.getGroupedActivities(), true, null, 8);
            } else {
                BuiltInFictitiousFunctionClassFactory = this.GetContactSyncConfig.get().MyBillsEntityDataFactory(new Date(), p0.getGroupedActivities(), this.BuiltInFictitiousFunctionClassFactory);
            }
        } else if (p0.getFromCache()) {
            BuiltInFictitiousFunctionClassFactory = (List) this.getAuthRequestContext.get().apply(p0.getActivities());
            if (BuiltInFictitiousFunctionClassFactory == null) {
                BuiltInFictitiousFunctionClassFactory = CollectionsKt.emptyList();
            }
        } else {
            FeedMapper feedMapper = this.getAuthRequestContext.get();
            List<ActivityResponse> activities = p0.getActivities();
            final String str = this.BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullParameter(activities, "");
            Intrinsics.checkNotNullParameter(str, "");
            BuiltInFictitiousFunctionClassFactory = feedMapper.BuiltInFictitiousFunctionClassFactory(activities, 9, new Function1<ActivityResponse, Boolean>() { // from class: id.dana.social.model.mapper.FeedMapper$mapLatestFeedByMinId$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(ActivityResponse activityResponse) {
                    Intrinsics.checkNotNullParameter(activityResponse, "");
                    return Boolean.valueOf(Intrinsics.areEqual(activityResponse.getId(), str));
                }
            });
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : BuiltInFictitiousFunctionClassFactory) {
            if (((FeedViewHolderModel) obj).getErrorConfigVersion != 1) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // id.dana.social.presenter.SocialWidgetPresenter, id.dana.social.contract.SocialWidgetContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
        if (!this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            this.MyBillsEntityDataFactory.get().KClassImpl$Data$declaredNonStaticMembers$2.subscribe(new NewSocialWidgetPresenter$createFeedStatusConfigObserver$1(this));
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
        }
        this.MyBillsEntityDataFactory.get().getAuthRequestContext(p0);
    }

    @Override // id.dana.social.presenter.SocialWidgetPresenter, id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        super.onDestroy();
        this.DatabaseTableConfigUtil.get().dispose();
        this.moveToNextValue.get().dispose();
        new NewSocialWidgetPresenter$createTimelineObserver$1(this).dispose();
        this.PrepareContext.dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = false;
        new NewSocialWidgetPresenter$createFeedStatusConfigObserver$1(this).dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
        dispose();
        this.lookAheadTest = false;
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(final NewSocialWidgetPresenter newSocialWidgetPresenter, boolean z) {
        Intrinsics.checkNotNullParameter(newSocialWidgetPresenter, "");
        if (z) {
            newSocialWidgetPresenter.BuiltInFictitiousFunctionClassFactory(true);
            if (!newSocialWidgetPresenter.lookAheadTest) {
                newSocialWidgetPresenter.scheduleImpl.debounce(1L, TimeUnit.SECONDS).subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(AndroidSchedulers.PlaceComponentResult()).filter(new Predicate() { // from class: id.dana.social.presenter.NewSocialWidgetPresenter$$ExternalSyntheticLambda0
                    @Override // io.reactivex.functions.Predicate
                    public final boolean test(Object obj) {
                        boolean authRequestContext;
                        authRequestContext = NewSocialWidgetPresenter.getAuthRequestContext(NewSocialWidgetPresenter.this, (String) obj);
                        return authRequestContext;
                    }
                }).subscribe(newSocialWidgetPresenter.PrepareContext);
                newSocialWidgetPresenter.lookAheadTest = true;
            }
            newSocialWidgetPresenter.PlaceComponentResult();
            GetCachedTimeline getCachedTimeline = newSocialWidgetPresenter.getErrorConfigVersion.get();
            String str = newSocialWidgetPresenter.NetworkUserEntityData$$ExternalSyntheticLambda8;
            FeedConfig feedConfig = newSocialWidgetPresenter.PlaceComponentResult;
            getCachedTimeline.executeJava1(new GetCachedTimeline.Params(3, null, str, null, feedConfig != null ? feedConfig.getHomeFeedVersion() : 4, true, 8, null), new Function1<SocialFeed, Unit>() { // from class: id.dana.social.presenter.NewSocialWidgetPresenter$getWidgetTimelineFirstTime$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(SocialFeed socialFeed) {
                    invoke2(socialFeed);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(SocialFeed socialFeed) {
                    List BuiltInFictitiousFunctionClassFactory;
                    Intrinsics.checkNotNullParameter(socialFeed, "");
                    if (socialFeed.getFromCache()) {
                        NewSocialWidgetPresenter.this.BuiltInFictitiousFunctionClassFactory = socialFeed.getMinId();
                    }
                    NewSocialWidgetPresenter newSocialWidgetPresenter2 = NewSocialWidgetPresenter.this;
                    String minId = socialFeed.getMinId();
                    Intrinsics.checkNotNullParameter(minId, "");
                    newSocialWidgetPresenter2.NetworkUserEntityData$$ExternalSyntheticLambda8 = minId;
                    SocialWidgetContract.View view = NewSocialWidgetPresenter.this.DatabaseTableConfigUtil.get();
                    BuiltInFictitiousFunctionClassFactory = NewSocialWidgetPresenter.this.BuiltInFictitiousFunctionClassFactory(socialFeed);
                    List list = BuiltInFictitiousFunctionClassFactory;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((FeedViewHolderModel) it.next()).BuiltInFictitiousFunctionClassFactory());
                    }
                    view.MyBillsEntityDataFactory(new SocialFeedWrapperModel(arrayList, socialFeed.getFromCache()));
                }
            }, new Function1<Throwable, String>() { // from class: id.dana.social.presenter.NewSocialWidgetPresenter$getWidgetTimelineFirstTime$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final String invoke(Throwable th) {
                    Intrinsics.checkNotNullParameter(th, "");
                    DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.RELATIONSHIP, ErrorUtil.MyBillsEntityDataFactory(GetCachedTimeline.class, NewSocialWidgetPresenter.this.getClass(), String.valueOf(new Exception(th).getCause())));
                    NewSocialWidgetPresenter.this.DatabaseTableConfigUtil.get().NetworkUserEntityData$$ExternalSyntheticLambda0();
                    return NewSocialWidgetPresenter.this.DatabaseTableConfigUtil.get().BuiltInFictitiousFunctionClassFactory();
                }
            }, "Feeds Home Widget");
        }
    }

    public static final /* synthetic */ void PlaceComponentResult(NewSocialWidgetPresenter newSocialWidgetPresenter, FeedUserConfigHelper.FeedUserConfigFetchingState feedUserConfigFetchingState) {
        int i = WhenMappings.getAuthRequestContext[feedUserConfigFetchingState.ordinal()];
        if (i == 1 || i == 2) {
            newSocialWidgetPresenter.DatabaseTableConfigUtil.get().PlaceComponentResult();
        } else if (i == 3) {
            newSocialWidgetPresenter.DatabaseTableConfigUtil.get().KClassImpl$Data$declaredNonStaticMembers$2();
        } else if (i == 4) {
            newSocialWidgetPresenter.DatabaseTableConfigUtil.get().getErrorConfigVersion();
        }
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(NewSocialWidgetPresenter newSocialWidgetPresenter, SocialFeed socialFeed) {
        if (newSocialWidgetPresenter.MyBillsEntityDataFactory(socialFeed.getMinId())) {
            newSocialWidgetPresenter.NetworkUserEntityData$$ExternalSyntheticLambda8 = socialFeed.getMinId();
            if (newSocialWidgetPresenter.NetworkUserEntityData$$ExternalSyntheticLambda2) {
                SocialWidgetContract.View view = newSocialWidgetPresenter.DatabaseTableConfigUtil.get();
                List<FeedViewHolderModel> BuiltInFictitiousFunctionClassFactory = newSocialWidgetPresenter.BuiltInFictitiousFunctionClassFactory(socialFeed);
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(BuiltInFictitiousFunctionClassFactory, 10));
                Iterator<T> it = BuiltInFictitiousFunctionClassFactory.iterator();
                while (it.hasNext()) {
                    arrayList.add(((FeedViewHolderModel) it.next()).BuiltInFictitiousFunctionClassFactory());
                }
                view.MyBillsEntityDataFactory(new SocialFeedWrapperModel(arrayList, socialFeed.getFromCache()));
            } else {
                SocialWidgetContract.View view2 = newSocialWidgetPresenter.DatabaseTableConfigUtil.get();
                List<FeedViewHolderModel> BuiltInFictitiousFunctionClassFactory2 = newSocialWidgetPresenter.BuiltInFictitiousFunctionClassFactory(socialFeed);
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(BuiltInFictitiousFunctionClassFactory2, 10));
                Iterator<T> it2 = BuiltInFictitiousFunctionClassFactory2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(((FeedViewHolderModel) it2.next()).BuiltInFictitiousFunctionClassFactory());
                }
                view2.BuiltInFictitiousFunctionClassFactory(new SocialFeedWrapperModel(arrayList2, socialFeed.getFromCache()));
            }
        }
        newSocialWidgetPresenter.isLayoutRequested = false;
    }
}
