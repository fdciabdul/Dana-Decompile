package id.dana.social.presenter;

import android.content.Context;
import dagger.Lazy;
import id.dana.base.BasePresenter;
import id.dana.data.userconfig.BiztypeNotFoundException;
import id.dana.domain.DefaultObserver;
import id.dana.domain.core.usecase.BaseUseCaseWithAnalytics;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.social.InitStatus;
import id.dana.domain.social.core.SingleUseCase;
import id.dana.domain.social.model.FeedConfig;
import id.dana.domain.social.model.InitFeed;
import id.dana.feeds.domain.activation.interactor.GetFriendsFeedWithInitFeedAndFeatureCheck;
import id.dana.feeds.domain.activation.interactor.InitSocialFeed;
import id.dana.feeds.domain.activation.interactor.ObserveInitFeed;
import id.dana.feeds.domain.config.interactor.GetFeedConfig;
import id.dana.feeds.domain.share.interactor.GetShareFeedConsent;
import id.dana.feeds.domain.share.interactor.SaveShareFeedConsent;
import id.dana.feeds.domain.timeline.interactor.GetTimeline;
import id.dana.feeds.domain.timeline.model.ActivityResponse;
import id.dana.feeds.domain.timeline.model.SocialFeed;
import id.dana.social.contract.SocialWidgetContract;
import id.dana.social.mapper.ActivityResponseListMapperKt;
import id.dana.social.model.SocialFeedWrapperModel;
import id.dana.social.presenter.SocialWidgetPresenter;
import id.dana.utils.ErrorUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u0000 82\u00020\u00012\u00020\u0002:\u00018B\u0087\u0001\b\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00140\r\u0012\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001c0\r\u0012\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00170\r\u0012\f\u00101\u001a\b\u0012\u0004\u0012\u00020*0\r\u0012\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u001a0\r\u0012\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00180\r\u0012\f\u00104\u001a\b\u0012\u0004\u0012\u00020#0\r\u0012\f\u00105\u001a\b\u0012\u0004\u0012\u00020+0\r¢\u0006\u0004\b6\u00107J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0005J\u001b\u0010\u0006\u001a\u00020\u00032\n\u0010\u000b\u001a\u00060\tj\u0002`\nH\u0002¢\u0006\u0004\b\u0006\u0010\fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u0011X\u0080\u0002¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00170\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0010R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00180\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0010R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0010R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001c0\rX\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0010R\u0012\u0010\"\u001a\u00020\u001fX\u0096\u0002¢\u0006\u0006\n\u0004\b \u0010!R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020#0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010\u0010R\u0018\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030&X\u0096\u0002¢\u0006\u0006\n\u0004\b'\u0010(R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020*0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0010R\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020+0\rX\u0006¢\u0006\u0006\n\u0004\b,\u0010\u0010"}, d2 = {"Lid/dana/social/presenter/SocialWidgetPresenter;", "Lid/dana/base/BasePresenter;", "Lid/dana/social/contract/SocialWidgetContract$Presenter;", "", "MyBillsEntityDataFactory", "()V", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "onDestroy", "Ljava/lang/Exception;", "Lkotlin/Exception;", "p0", "(Ljava/lang/Exception;)V", "Ldagger/Lazy;", "Landroid/content/Context;", "initRecordTimeStamp", "Ldagger/Lazy;", "Lid/dana/domain/social/model/FeedConfig;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/domain/social/model/FeedConfig;", "Lid/dana/feeds/domain/config/interactor/GetFeedConfig;", "getAuthRequestContext", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/feeds/domain/activation/interactor/GetFriendsFeedWithInitFeedAndFeatureCheck;", "Lid/dana/feeds/domain/activation/interactor/ObserveInitFeed;", "GetContactSyncConfig", "Lid/dana/feeds/domain/share/interactor/GetShareFeedConsent;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/feeds/domain/timeline/interactor/GetTimeline;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "moveToNextValue", "Lid/dana/domain/social/model/InitFeed;", "newProxyInstance", "Lid/dana/domain/social/model/InitFeed;", "scheduleImpl", "Lid/dana/feeds/domain/activation/interactor/InitSocialFeed;", "PrepareContext", "lookAheadTest", "Lkotlin/Function0;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Lkotlin/jvm/functions/Function0;", "getErrorConfigVersion", "Lid/dana/feeds/domain/share/interactor/SaveShareFeedConsent;", "Lid/dana/social/contract/SocialWidgetContract$View;", "isLayoutRequested", "DatabaseTableConfigUtil", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "<init>", "(Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public class SocialWidgetPresenter extends BasePresenter implements SocialWidgetContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Lazy<GetFriendsFeedWithInitFeedAndFeatureCheck> MyBillsEntityDataFactory;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    public final Lazy<ObserveInitFeed> getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Lazy<GetShareFeedConsent> NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    FeedConfig KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    protected final Lazy<GetTimeline> moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    Function0<Unit> getErrorConfigVersion;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Lazy<SaveShareFeedConsent> NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    public final Lazy<InitSocialFeed> lookAheadTest;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Lazy<GetFeedConfig> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    final Lazy<Context> PlaceComponentResult;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    final Lazy<SocialWidgetContract.View> DatabaseTableConfigUtil;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    InitFeed scheduleImpl;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] PlaceComponentResult;

        static {
            int[] iArr = new int[InitStatus.values().length];
            iArr[InitStatus.FINISH.ordinal()] = 1;
            iArr[InitStatus.ERROR.ordinal()] = 2;
            iArr[InitStatus.INIT.ordinal()] = 3;
            iArr[InitStatus.NOT_ACTIVATED.ordinal()] = 4;
            PlaceComponentResult = iArr;
        }
    }

    public /* synthetic */ void BuiltInFictitiousFunctionClassFactory() {
        SocialWidgetContract.Presenter.CC.PlaceComponentResult();
    }

    public /* synthetic */ void BuiltInFictitiousFunctionClassFactory(boolean z) {
        SocialWidgetContract.Presenter.CC.BuiltInFictitiousFunctionClassFactory();
    }

    @Inject
    public SocialWidgetPresenter(Lazy<Context> lazy, Lazy<GetFeedConfig> lazy2, Lazy<GetTimeline> lazy3, Lazy<GetFriendsFeedWithInitFeedAndFeatureCheck> lazy4, Lazy<SaveShareFeedConsent> lazy5, Lazy<GetShareFeedConsent> lazy6, Lazy<ObserveInitFeed> lazy7, Lazy<InitSocialFeed> lazy8, Lazy<SocialWidgetContract.View> lazy9) {
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        Intrinsics.checkNotNullParameter(lazy3, "");
        Intrinsics.checkNotNullParameter(lazy4, "");
        Intrinsics.checkNotNullParameter(lazy5, "");
        Intrinsics.checkNotNullParameter(lazy6, "");
        Intrinsics.checkNotNullParameter(lazy7, "");
        Intrinsics.checkNotNullParameter(lazy8, "");
        Intrinsics.checkNotNullParameter(lazy9, "");
        this.PlaceComponentResult = lazy;
        this.BuiltInFictitiousFunctionClassFactory = lazy2;
        this.moveToNextValue = lazy3;
        this.MyBillsEntityDataFactory = lazy4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = lazy5;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = lazy6;
        this.getAuthRequestContext = lazy7;
        this.lookAheadTest = lazy8;
        this.DatabaseTableConfigUtil = lazy9;
        this.getErrorConfigVersion = new Function0<Unit>() { // from class: id.dana.social.presenter.SocialWidgetPresenter$onFeedInitializing$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        };
        this.scheduleImpl = new InitFeed(InitStatus.NOT_ACTIVATED, 0, null, false, 14, null);
    }

    public void KClassImpl$Data$declaredNonStaticMembers$2() {
        Unit unit;
        FeedConfig feedConfig = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (feedConfig != null) {
            this.DatabaseTableConfigUtil.get().PlaceComponentResult(feedConfig.isFeedEnabled(), feedConfig.isFeedWidgetEnabled(), feedConfig.isMaintenance(), feedConfig.getFeedVersion());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.BuiltInFictitiousFunctionClassFactory.get().execute(NoParams.INSTANCE, new Function1<FeedConfig, Unit>() { // from class: id.dana.social.presenter.SocialWidgetPresenter$getSocialConfig$2
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
                    SocialWidgetPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2 = feedConfig2;
                    SocialWidgetPresenter.this.DatabaseTableConfigUtil.get().PlaceComponentResult(feedConfig2.isFeedEnabled(), feedConfig2.isFeedWidgetEnabled(), feedConfig2.isMaintenance(), feedConfig2.getFeedVersion());
                }
            }, new Function1<Throwable, Unit>() { // from class: id.dana.social.presenter.SocialWidgetPresenter$getSocialConfig$3
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
                    DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.RELATIONSHIP, ErrorUtil.MyBillsEntityDataFactory(GetFeedConfig.class, SocialWidgetPresenter.this.getClass(), String.valueOf(new Exception(th).getCause())));
                }
            });
        }
    }

    public void MyBillsEntityDataFactory() {
        GetTimeline getTimeline = this.moveToNextValue.get();
        Intrinsics.checkNotNullExpressionValue(getTimeline, "");
        BaseUseCaseWithAnalytics.executeJava1$default(getTimeline, new GetTimeline.Params(3, null, 2, CollectionsKt.emptyList()), new Function1<SocialFeed, Unit>() { // from class: id.dana.social.presenter.SocialWidgetPresenter$getLatestWidgetTimeline$1
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
                List<ActivityResponse> activities = socialFeed.getActivities();
                SocialWidgetPresenter socialWidgetPresenter = SocialWidgetPresenter.this;
                SocialWidgetContract.View view = socialWidgetPresenter.DatabaseTableConfigUtil.get();
                Context context = socialWidgetPresenter.PlaceComponentResult.get();
                Intrinsics.checkNotNullExpressionValue(context, "");
                view.BuiltInFictitiousFunctionClassFactory(new SocialFeedWrapperModel(ActivityResponseListMapperKt.PlaceComponentResult(activities, context), socialFeed.getFromCache()));
            }
        }, new Function1<Throwable, String>() { // from class: id.dana.social.presenter.SocialWidgetPresenter$getLatestWidgetTimeline$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.RELATIONSHIP, ErrorUtil.MyBillsEntityDataFactory(GetTimeline.class, SocialWidgetPresenter.this.getClass(), String.valueOf(new Exception(th).getCause())));
                SocialWidgetPresenter.this.DatabaseTableConfigUtil.get().NetworkUserEntityData$$ExternalSyntheticLambda0();
                return SocialWidgetPresenter.this.DatabaseTableConfigUtil.get().BuiltInFictitiousFunctionClassFactory();
            }
        }, null, 8, null);
    }

    public final void PlaceComponentResult() {
        GetShareFeedConsent getShareFeedConsent = this.NetworkUserEntityData$$ExternalSyntheticLambda0.get();
        Intrinsics.checkNotNullExpressionValue(getShareFeedConsent, "");
        SingleUseCase.execute$default(getShareFeedConsent, Unit.INSTANCE, null, new Function1<Exception, Unit>() { // from class: id.dana.social.presenter.SocialWidgetPresenter$getShareFeedConsent$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                invoke2(exc);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Exception exc) {
                Intrinsics.checkNotNullParameter(exc, "");
                if (exc.getCause() instanceof BiztypeNotFoundException) {
                    SocialWidgetPresenter.BuiltInFictitiousFunctionClassFactory(SocialWidgetPresenter.this);
                }
            }
        }, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void PlaceComponentResult(Exception p0) {
        InitFeed initFeed = new InitFeed(InitStatus.ERROR, 0, null, false, 14, null);
        Intrinsics.checkNotNullParameter(initFeed, "");
        this.scheduleImpl = initFeed;
        this.getAuthRequestContext.get().dispose();
        this.DatabaseTableConfigUtil.get().getAuthRequestContext();
        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.RELATIONSHIP, ErrorUtil.MyBillsEntityDataFactory(InitSocialFeed.class, getClass(), String.valueOf(p0.getCause())));
    }

    public void onDestroy() {
        this.BuiltInFictitiousFunctionClassFactory.get().dispose();
        this.moveToNextValue.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().dispose();
        this.getAuthRequestContext.get().dispose();
        this.lookAheadTest.get().dispose();
    }

    public static final /* synthetic */ DefaultObserver KClassImpl$Data$declaredNonStaticMembers$2(final SocialWidgetPresenter socialWidgetPresenter) {
        return new DefaultObserver<InitFeed>() { // from class: id.dana.social.presenter.SocialWidgetPresenter$initFeedObservable$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                InitFeed initFeed = (InitFeed) obj;
                Intrinsics.checkNotNullParameter(initFeed, "");
                SocialWidgetPresenter socialWidgetPresenter2 = SocialWidgetPresenter.this;
                Intrinsics.checkNotNullParameter(initFeed, "");
                Intrinsics.checkNotNullParameter(initFeed, "");
                socialWidgetPresenter2.scheduleImpl = initFeed;
                int i = SocialWidgetPresenter.WhenMappings.PlaceComponentResult[initFeed.getStatus().ordinal()];
                if (i == 1) {
                    socialWidgetPresenter2.getErrorConfigVersion.invoke();
                    socialWidgetPresenter2.DatabaseTableConfigUtil.get().MyBillsEntityDataFactory();
                } else if (i == 2) {
                    socialWidgetPresenter2.PlaceComponentResult(initFeed.getError());
                } else if (i == 3) {
                    socialWidgetPresenter2.DatabaseTableConfigUtil.get().scheduleImpl();
                } else if (i == 4) {
                    socialWidgetPresenter2.DatabaseTableConfigUtil.get().moveToNextValue();
                }
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                SocialWidgetPresenter.this.PlaceComponentResult(new Exception(p0));
            }
        };
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(final SocialWidgetPresenter socialWidgetPresenter) {
        SaveShareFeedConsent saveShareFeedConsent = socialWidgetPresenter.NetworkUserEntityData$$ExternalSyntheticLambda1.get();
        Intrinsics.checkNotNullExpressionValue(saveShareFeedConsent, "");
        SingleUseCase.execute$default(saveShareFeedConsent, Boolean.TRUE, null, new Function1<Exception, Unit>() { // from class: id.dana.social.presenter.SocialWidgetPresenter$setShareFeedConfigToTrue$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                invoke2(exc);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Exception exc) {
                Intrinsics.checkNotNullParameter(exc, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.RELATIONSHIP, ErrorUtil.MyBillsEntityDataFactory(SaveShareFeedConsent.class, SocialWidgetPresenter.this.getClass(), String.valueOf(exc.getCause())));
            }
        }, 2, null);
    }
}
