package id.dana.social.contract;

import id.dana.danah5.share.ShareToFeedBridge;
import id.dana.domain.DefaultObserver;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.featureconfig.interactor.CheckFeedHighlight;
import id.dana.domain.notificationcenter.interactor.MarkNotificationAsRead;
import id.dana.domain.notificationcenter.model.MarkNotificationResponse;
import id.dana.feeds.domain.notification.interactor.GetGlobalNotification;
import id.dana.feeds.domain.timeline.interactor.GetMyFeeds;
import id.dana.feeds.domain.timeline.model.ActivityResponse;
import id.dana.feeds.domain.timeline.model.SocialFeed;
import id.dana.kyb.domain.interactor.IsKybNativeEnabled;
import id.dana.social.contract.MyFeedsContract;
import id.dana.social.model.FeedModel;
import id.dana.social.model.FeedViewHolderModel;
import id.dana.social.model.MyFeedHighlightModel;
import id.dana.social.model.mapper.FeedMapper;
import id.dana.social.model.mapper.FeedMapper$map$1;
import id.dana.social.state.MyFeedHighlightState;
import id.dana.social.utils.FeedsContentAction;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 82\u00020\u0001:\u00018BI\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020,\u0012\u0006\u0010\t\u001a\u00020!\u0012\u0006\u00100\u001a\u00020\u0018\u0012\u0006\u00101\u001a\u00020\u001a\u0012\u0006\u00102\u001a\u00020(\u0012\u0006\u00103\u001a\u00020\u001d\u0012\u0006\u00104\u001a\u00020\u0016\u0012\u0006\u00105\u001a\u00020%¢\u0006\u0004\b6\u00107J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bJ7\u0010\u000e\u001a\u00020\u00022&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\fj\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005`\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u000e\u0010\u0011J\u0019\u0010\u0003\u001a\u00020\u00102\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u0003\u0010\u0012J\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\n\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0019R\u0014\u0010\u000e\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\n\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0012\u0010\u001b\u001a\u00020\u0010X\u0086\u0002¢\u0006\u0006\n\u0004\b \u0010$R\u0014\u0010\"\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010&\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010)\u001a\u0004\u0018\u00010\u0005X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010+R\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u0005X\u0086\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010+R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010."}, d2 = {"Lid/dana/social/contract/MyFeedsPresenter;", "Lid/dana/social/contract/MyFeedsContract$Presenter;", "", "getAuthRequestContext", "()V", "", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)V", "p1", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/lang/String;)V", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/util/HashMap;)V", "", "()Z", "(Ljava/lang/String;)Z", "Lid/dana/social/model/FeedViewHolderModel;", "(Lid/dana/social/model/FeedViewHolderModel;)V", "onDestroy", "Lid/dana/domain/featureconfig/interactor/CheckFeedHighlight;", "Lid/dana/domain/featureconfig/interactor/CheckFeedHighlight;", "Lid/dana/social/model/mapper/FeedMapper;", "Lid/dana/social/model/mapper/FeedMapper;", "Lid/dana/social/utils/FeedsContentAction;", "lookAheadTest", "Lid/dana/social/utils/FeedsContentAction;", "Lid/dana/feeds/domain/notification/interactor/GetGlobalNotification;", "getErrorConfigVersion", "Lid/dana/feeds/domain/notification/interactor/GetGlobalNotification;", "PlaceComponentResult", "Lid/dana/feeds/domain/timeline/interactor/GetMyFeeds;", "scheduleImpl", "Lid/dana/feeds/domain/timeline/interactor/GetMyFeeds;", "Z", "Lid/dana/kyb/domain/interactor/IsKybNativeEnabled;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/kyb/domain/interactor/IsKybNativeEnabled;", "Lid/dana/domain/notificationcenter/interactor/MarkNotificationAsRead;", "moveToNextValue", "Lid/dana/domain/notificationcenter/interactor/MarkNotificationAsRead;", "Ljava/lang/String;", "Lid/dana/social/contract/MyFeedsContract$View;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/social/contract/MyFeedsContract$View;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "p2", "p3", "p4", "p5", "p6", "p7", "<init>", "(Lid/dana/social/contract/MyFeedsContract$View;Lid/dana/feeds/domain/timeline/interactor/GetMyFeeds;Lid/dana/social/model/mapper/FeedMapper;Lid/dana/social/utils/FeedsContentAction;Lid/dana/domain/notificationcenter/interactor/MarkNotificationAsRead;Lid/dana/feeds/domain/notification/interactor/GetGlobalNotification;Lid/dana/domain/featureconfig/interactor/CheckFeedHighlight;Lid/dana/kyb/domain/interactor/IsKybNativeEnabled;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MyFeedsPresenter implements MyFeedsContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public String getErrorConfigVersion;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    String moveToNextValue;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final CheckFeedHighlight KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final IsKybNativeEnabled scheduleImpl;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final MyFeedsContract.View NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    boolean lookAheadTest;
    private final FeedMapper getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final GetGlobalNotification PlaceComponentResult;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final FeedsContentAction BuiltInFictitiousFunctionClassFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final MarkNotificationAsRead NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final GetMyFeeds MyBillsEntityDataFactory;

    @Inject
    public MyFeedsPresenter(MyFeedsContract.View view, GetMyFeeds getMyFeeds, FeedMapper feedMapper, FeedsContentAction feedsContentAction, MarkNotificationAsRead markNotificationAsRead, GetGlobalNotification getGlobalNotification, CheckFeedHighlight checkFeedHighlight, IsKybNativeEnabled isKybNativeEnabled) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getMyFeeds, "");
        Intrinsics.checkNotNullParameter(feedMapper, "");
        Intrinsics.checkNotNullParameter(feedsContentAction, "");
        Intrinsics.checkNotNullParameter(markNotificationAsRead, "");
        Intrinsics.checkNotNullParameter(getGlobalNotification, "");
        Intrinsics.checkNotNullParameter(checkFeedHighlight, "");
        Intrinsics.checkNotNullParameter(isKybNativeEnabled, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = view;
        this.MyBillsEntityDataFactory = getMyFeeds;
        this.getAuthRequestContext = feedMapper;
        this.BuiltInFictitiousFunctionClassFactory = feedsContentAction;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = markNotificationAsRead;
        this.PlaceComponentResult = getGlobalNotification;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = checkFeedHighlight;
        this.scheduleImpl = isKybNativeEnabled;
        this.lookAheadTest = true;
    }

    @Override // id.dana.social.contract.MyFeedsContract.Presenter
    public final void MyBillsEntityDataFactory(final FeedViewHolderModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        MarkNotificationAsRead markNotificationAsRead = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        DefaultObserver<MarkNotificationResponse> defaultObserver = new DefaultObserver<MarkNotificationResponse>() { // from class: id.dana.social.contract.MyFeedsPresenter$markAsRead$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                MyFeedsContract.View view;
                MarkNotificationResponse markNotificationResponse = (MarkNotificationResponse) obj;
                Intrinsics.checkNotNullParameter(markNotificationResponse, "");
                if (markNotificationResponse.isSuccess()) {
                    FeedModel feedModel = FeedViewHolderModel.this.MyBillsEntityDataFactory;
                    if (feedModel != null) {
                        feedModel.newProxyInstance = true;
                    }
                    view = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    view.KClassImpl$Data$declaredNonStaticMembers$2(FeedViewHolderModel.this);
                }
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p02) {
                Intrinsics.checkNotNullParameter(p02, "");
                super.onError(p02);
                StringBuilder sb = new StringBuilder();
                sb.append("onError: ");
                sb.append(p02.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.RELATIONSHIP, sb.toString());
            }
        };
        FeedModel feedModel = p0.MyBillsEntityDataFactory;
        markNotificationAsRead.execute(defaultObserver, MarkNotificationAsRead.Params.forMarkNotificationAsRead(feedModel != null ? feedModel.NetworkUserEntityData$$ExternalSyntheticLambda1 : null));
    }

    @Override // id.dana.social.contract.MyFeedsContract.Presenter
    public final void getAuthRequestContext() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.execute(NoParams.INSTANCE, new MyFeedsPresenter$checkFeedHighlightEnable$1(this.NetworkUserEntityData$$ExternalSyntheticLambda1), new Function1<Throwable, Unit>() { // from class: id.dana.social.contract.MyFeedsPresenter$checkFeedHighlightEnable$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                StringBuilder sb = new StringBuilder();
                sb.append("onError: ");
                sb.append(th.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.RELATIONSHIP, sb.toString());
            }
        });
    }

    @Override // id.dana.social.contract.BaseSocialFeedContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(final HashMap<String, String> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (getAuthRequestContext(p0.get(ShareToFeedBridge.REDIRECT_VALUE))) {
            this.scheduleImpl.execute(NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.social.contract.MyFeedsPresenter$doFeedsContentAction$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z) {
                    FeedsContentAction feedsContentAction;
                    if (z) {
                        feedsContentAction = MyFeedsPresenter.this.BuiltInFictitiousFunctionClassFactory;
                        feedsContentAction.getAuthRequestContext("https://link.dana.id/kybpage");
                        return;
                    }
                    MyFeedsPresenter.this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(p0);
                }
            }, new Function1<Throwable, Unit>() { // from class: id.dana.social.contract.MyFeedsPresenter$doFeedsContentAction$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    StringBuilder sb = new StringBuilder();
                    sb.append("onError: ");
                    sb.append(th.getMessage());
                    DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.RELATIONSHIP, sb.toString());
                    MyFeedsPresenter.this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(p0);
                }
            });
        } else {
            this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(p0);
        }
    }

    @Override // id.dana.social.contract.BaseSocialFeedContract.Presenter
    public final void MyBillsEntityDataFactory(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(p0, p1);
    }

    @Override // id.dana.social.contract.MyFeedsContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.MyBillsEntityDataFactory.executeJava1(new GetMyFeeds.Params(this.moveToNextValue), new Function1<SocialFeed, Unit>() { // from class: id.dana.social.contract.MyFeedsPresenter$getMyFeeds$1
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
                MyFeedsContract.View view;
                FeedMapper feedMapper;
                List<FeedViewHolderModel> BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkNotNullParameter(socialFeed, "");
                MyFeedsPresenter.this.lookAheadTest = socialFeed.getHasMore();
                if (socialFeed.getHasMore() || MyFeedsPresenter.this.moveToNextValue == null) {
                    MyFeedsPresenter.this.moveToNextValue = socialFeed.getMaxId();
                }
                MyFeedsPresenter.getAuthRequestContext(MyFeedsPresenter.this, socialFeed.getActivities());
                view = MyFeedsPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                feedMapper = MyFeedsPresenter.this.getAuthRequestContext;
                List<ActivityResponse> activities = socialFeed.getActivities();
                Intrinsics.checkNotNullParameter(activities, "");
                BuiltInFictitiousFunctionClassFactory = feedMapper.BuiltInFictitiousFunctionClassFactory(activities, 5, FeedMapper$map$1.INSTANCE);
                view.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
            }
        }, new Function1<Throwable, String>() { // from class: id.dana.social.contract.MyFeedsPresenter$getMyFeeds$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Throwable th) {
                MyFeedsContract.View view;
                MyFeedsContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                StringBuilder sb = new StringBuilder();
                sb.append("onError: ");
                sb.append(th.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.RELATIONSHIP, sb.toString());
                view = MyFeedsPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                view.PlaceComponentResult();
                view2 = MyFeedsPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                return view2.BuiltInFictitiousFunctionClassFactory();
            }
        }, "Inbox");
    }

    @Override // id.dana.social.contract.MyFeedsContract.Presenter
    public final void MyBillsEntityDataFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.PlaceComponentResult.executeJava1(new GetGlobalNotification.Params(p0, ""), new Function1<SocialFeed, Unit>() { // from class: id.dana.social.contract.MyFeedsPresenter$getGlobalNotifications$1
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
                MyFeedsContract.View view;
                Intrinsics.checkNotNullParameter(socialFeed, "");
                view = MyFeedsPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                MyFeedHighlightModel.Companion companion = MyFeedHighlightModel.INSTANCE;
                view.PlaceComponentResult(MyFeedHighlightModel.Companion.PlaceComponentResult(socialFeed));
            }
        }, new Function1<Throwable, String>() { // from class: id.dana.social.contract.MyFeedsPresenter$getGlobalNotifications$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Throwable th) {
                MyFeedsContract.View view;
                MyFeedsContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                StringBuilder sb = new StringBuilder();
                sb.append("onError: ");
                sb.append(th.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.RELATIONSHIP, sb.toString());
                view = MyFeedsPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                view.PlaceComponentResult(new MyFeedHighlightModel(MyFeedHighlightState.Error.INSTANCE, false, null, false, null, 30, null));
                view2 = MyFeedsPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                return view2.BuiltInFictitiousFunctionClassFactory();
            }
        }, "Inbox");
    }

    @Override // id.dana.social.contract.MyFeedsContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.moveToNextValue = null;
        this.getErrorConfigVersion = null;
        this.lookAheadTest = true;
        this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory = "";
        MyBillsEntityDataFactory();
    }

    @Override // id.dana.social.contract.BaseSocialFeedContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(p0);
    }

    private static boolean getAuthRequestContext(String p0) {
        return p0 != null && StringsKt.contains$default((CharSequence) p0, (CharSequence) "directTo=native", false, 2, (Object) null);
    }

    @Override // id.dana.social.contract.BaseSocialFeedContract.Presenter
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final boolean getNetworkUserEntityData$$ExternalSyntheticLambda4() {
        return this.lookAheadTest;
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        FeedsContentAction feedsContentAction = this.BuiltInFictitiousFunctionClassFactory;
        feedsContentAction.NetworkUserEntityData$$ExternalSyntheticLambda0.get().dispose();
        feedsContentAction.scheduleImpl.get().dispose();
        this.MyBillsEntityDataFactory.dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.dispose();
        this.PlaceComponentResult.dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        this.scheduleImpl.dispose();
    }

    public static final /* synthetic */ void getAuthRequestContext(MyFeedsPresenter myFeedsPresenter, List list) {
        if (myFeedsPresenter.getErrorConfigVersion == null && list != null && (!list.isEmpty()) == true) {
            myFeedsPresenter.getErrorConfigVersion = ((ActivityResponse) list.get(0)).getId();
        }
    }
}
