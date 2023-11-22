package id.dana.social;

import dagger.Lazy;
import id.dana.data.login.LoginLogoutSubject;
import id.dana.domain.DefaultObserver;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.social.InitStatus;
import id.dana.domain.social.core.SingleUseCase;
import id.dana.domain.social.model.InitFeed;
import id.dana.feeds.domain.activation.interactor.GetHasFetchedUserConfig;
import id.dana.feeds.domain.activation.interactor.ObserveInitFeed;
import id.dana.nearbyme.NearbyMeActivity;
import id.dana.social.FeedUserConfigHelper;
import id.dana.toggle.userloginlogout.ILoginLogoutObserver;
import id.dana.toggle.userloginlogout.LoginLogoutObserver;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000  2\u00020\u0001:\u0002 !B3\b\u0007\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\t\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\t¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0012\u0010\u0010\u001a\u00020\u000eX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\u000fR\u0012\u0010\u0013\u001a\u00020\u0011X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u001c\u0010\u0007\u001a\f\u0012\b\u0012\u0006*\u00020\u00150\u00150\u0014X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\u0016R\u001c\u0010\u0003\u001a\f\u0012\b\u0012\u0006*\u00020\u000e0\u000e0\u0014X\u0086\u0002¢\u0006\u0006\n\u0004\b\r\u0010\u0016R\u0012\u0010\u0018\u001a\u00020\u0015X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\u0017R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\fR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u001b0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\f"}, d2 = {"Lid/dana/social/FeedUserConfigHelper;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "p0", "", "getAuthRequestContext", "(Z)V", "Ldagger/Lazy;", "Lid/dana/feeds/domain/activation/interactor/GetHasFetchedUserConfig;", "lookAheadTest", "Ldagger/Lazy;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/social/FeedUserConfigHelper$FeedUserConfigFetchingState;", "Lid/dana/social/FeedUserConfigHelper$FeedUserConfigFetchingState;", "MyBillsEntityDataFactory", "", "I", "PlaceComponentResult", "Lio/reactivex/subjects/BehaviorSubject;", "Lid/dana/domain/social/model/InitFeed;", "Lio/reactivex/subjects/BehaviorSubject;", "Lid/dana/domain/social/model/InitFeed;", "scheduleImpl", "Lid/dana/toggle/userloginlogout/LoginLogoutObserver;", "moveToNextValue", "Lid/dana/feeds/domain/activation/interactor/ObserveInitFeed;", "p1", "p2", "<init>", "(Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V", "Companion", "FeedUserConfigFetchingState"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FeedUserConfigHelper {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public BehaviorSubject<FeedUserConfigFetchingState> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    int PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public BehaviorSubject<InitFeed> getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public InitFeed scheduleImpl;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public FeedUserConfigFetchingState MyBillsEntityDataFactory;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final Lazy<GetHasFetchedUserConfig> BuiltInFictitiousFunctionClassFactory;
    private final Lazy<LoginLogoutObserver> moveToNextValue;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final Lazy<ObserveInitFeed> lookAheadTest;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b"}, d2 = {"Lid/dana/social/FeedUserConfigHelper$FeedUserConfigFetchingState;", "", "<init>", "(Ljava/lang/String;I)V", "INIT", "LOADING", "ERROR_REACH_LIMIT", "ERROR", NearbyMeActivity.RefreshCondition.FETCHED}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public enum FeedUserConfigFetchingState {
        INIT,
        LOADING,
        ERROR_REACH_LIMIT,
        ERROR,
        FETCHED
    }

    @Inject
    public FeedUserConfigHelper(Lazy<GetHasFetchedUserConfig> lazy, Lazy<LoginLogoutObserver> lazy2, Lazy<ObserveInitFeed> lazy3) {
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        Intrinsics.checkNotNullParameter(lazy3, "");
        this.BuiltInFictitiousFunctionClassFactory = lazy;
        this.moveToNextValue = lazy2;
        this.lookAheadTest = lazy3;
        this.MyBillsEntityDataFactory = FeedUserConfigFetchingState.INIT;
        BehaviorSubject<FeedUserConfigFetchingState> BuiltInFictitiousFunctionClassFactory = BehaviorSubject.BuiltInFictitiousFunctionClassFactory();
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory;
        BehaviorSubject<InitFeed> BuiltInFictitiousFunctionClassFactory2 = BehaviorSubject.BuiltInFictitiousFunctionClassFactory();
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory2, "");
        this.getAuthRequestContext = BuiltInFictitiousFunctionClassFactory2;
        this.scheduleImpl = new InitFeed(InitStatus.NOT_ACTIVATED, 0, null, false, 14, null);
        lazy2.get().KClassImpl$Data$declaredNonStaticMembers$2(new ILoginLogoutObserver() { // from class: id.dana.social.FeedUserConfigHelper.1
            {
                FeedUserConfigHelper.this = this;
            }

            @Override // id.dana.toggle.userloginlogout.ILoginLogoutObserver
            public final void PlaceComponentResult(LoginLogoutSubject.UserLogin p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                FeedUserConfigHelper.getAuthRequestContext(FeedUserConfigHelper.this, FeedUserConfigFetchingState.INIT);
                FeedUserConfigHelper.this.PlaceComponentResult = 0;
            }
        });
    }

    public final void getAuthRequestContext(boolean p0) {
        if (p0) {
            FeedUserConfigFetchingState feedUserConfigFetchingState = FeedUserConfigFetchingState.INIT;
            this.MyBillsEntityDataFactory = feedUserConfigFetchingState;
            this.KClassImpl$Data$declaredNonStaticMembers$2.onNext(feedUserConfigFetchingState);
        }
        if (this.MyBillsEntityDataFactory != FeedUserConfigFetchingState.INIT) {
            return;
        }
        FeedUserConfigFetchingState feedUserConfigFetchingState2 = FeedUserConfigFetchingState.LOADING;
        this.MyBillsEntityDataFactory = feedUserConfigFetchingState2;
        this.KClassImpl$Data$declaredNonStaticMembers$2.onNext(feedUserConfigFetchingState2);
        this.BuiltInFictitiousFunctionClassFactory.get().execute(NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.social.FeedUserConfigHelper$migrateFeedStatus$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                Lazy lazy;
                FeedUserConfigHelper.getAuthRequestContext(FeedUserConfigHelper.this, FeedUserConfigHelper.FeedUserConfigFetchingState.FETCHED);
                lazy = FeedUserConfigHelper.this.lookAheadTest;
                Object obj = lazy.get();
                Intrinsics.checkNotNullExpressionValue(obj, "");
                Unit unit = Unit.INSTANCE;
                final FeedUserConfigHelper feedUserConfigHelper = FeedUserConfigHelper.this;
                SingleUseCase.execute$default((SingleUseCase) obj, unit, new Function1<Observable<InitFeed>, Unit>() { // from class: id.dana.social.FeedUserConfigHelper$migrateFeedStatus$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Observable<InitFeed> observable) {
                        invoke2(observable);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Observable<InitFeed> observable) {
                        Intrinsics.checkNotNullParameter(observable, "");
                        observable.subscribe(FeedUserConfigHelper.BuiltInFictitiousFunctionClassFactory(FeedUserConfigHelper.this));
                    }
                }, null, 4, null);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.social.FeedUserConfigHelper$migrateFeedStatus$2
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
                boolean KClassImpl$Data$declaredNonStaticMembers$2;
                Intrinsics.checkNotNullParameter(th, "");
                FeedUserConfigHelper.PlaceComponentResult(FeedUserConfigHelper.this);
                KClassImpl$Data$declaredNonStaticMembers$2 = FeedUserConfigHelper.this.KClassImpl$Data$declaredNonStaticMembers$2();
                if (!KClassImpl$Data$declaredNonStaticMembers$2) {
                    FeedUserConfigHelper.getAuthRequestContext(FeedUserConfigHelper.this, FeedUserConfigHelper.FeedUserConfigFetchingState.ERROR);
                } else {
                    FeedUserConfigHelper.getAuthRequestContext(FeedUserConfigHelper.this, FeedUserConfigHelper.FeedUserConfigFetchingState.ERROR_REACH_LIMIT);
                }
            }
        });
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult > 3;
    }

    public static final /* synthetic */ DefaultObserver BuiltInFictitiousFunctionClassFactory(FeedUserConfigHelper feedUserConfigHelper) {
        return new DefaultObserver<InitFeed>() { // from class: id.dana.social.FeedUserConfigHelper$initFeedObservable$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                InitFeed initFeed = (InitFeed) obj;
                Intrinsics.checkNotNullParameter(initFeed, "");
                FeedUserConfigHelper feedUserConfigHelper2 = FeedUserConfigHelper.this;
                Intrinsics.checkNotNullParameter(initFeed, "");
                feedUserConfigHelper2.scheduleImpl = initFeed;
                feedUserConfigHelper2.getAuthRequestContext.onNext(initFeed);
            }
        };
    }

    public static final /* synthetic */ void PlaceComponentResult(FeedUserConfigHelper feedUserConfigHelper) {
        feedUserConfigHelper.PlaceComponentResult++;
    }

    public static final /* synthetic */ void getAuthRequestContext(FeedUserConfigHelper feedUserConfigHelper, FeedUserConfigFetchingState feedUserConfigFetchingState) {
        feedUserConfigHelper.MyBillsEntityDataFactory = feedUserConfigFetchingState;
        feedUserConfigHelper.KClassImpl$Data$declaredNonStaticMembers$2.onNext(feedUserConfigFetchingState);
    }
}
