package id.dana.feeds.domain.activation.interactor;

import id.dana.domain.core.usecase.BaseUseCaseWithAnalytics;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.social.model.InitFeed;
import id.dana.domain.tracker.MixpanelRepository;
import id.dana.feeds.domain.activation.FeedInitRepository;
import id.dana.feeds.domain.config.FeedsConfigRepository;
import id.dana.feeds.domain.timeline.FeedsTimelineRepository;
import id.dana.feeds.domain.timeline.model.SocialFeed;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0019B)\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\b\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/feeds/domain/activation/interactor/GetFriendsFeedWithInitFeedAndFeatureCheck;", "Lid/dana/domain/core/usecase/BaseUseCaseWithAnalytics;", "Lid/dana/feeds/domain/timeline/model/SocialFeed;", "Lid/dana/domain/core/usecase/NoParams;", "", "getOperationType", "()Ljava/lang/String;", "Lid/dana/feeds/domain/activation/FeedInitRepository;", "MyBillsEntityDataFactory", "Lid/dana/feeds/domain/activation/FeedInitRepository;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/feeds/domain/config/FeedsConfigRepository;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/feeds/domain/config/FeedsConfigRepository;", "getAuthRequestContext", "Lid/dana/feeds/domain/timeline/FeedsTimelineRepository;", "PlaceComponentResult", "Lid/dana/feeds/domain/timeline/FeedsTimelineRepository;", "Lid/dana/domain/tracker/MixpanelRepository;", "p0", "p1", "p2", "p3", "<init>", "(Lid/dana/domain/tracker/MixpanelRepository;Lid/dana/feeds/domain/config/FeedsConfigRepository;Lid/dana/feeds/domain/timeline/FeedsTimelineRepository;Lid/dana/feeds/domain/activation/FeedInitRepository;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetFriendsFeedWithInitFeedAndFeatureCheck extends BaseUseCaseWithAnalytics<SocialFeed, NoParams> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final FeedsConfigRepository getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final FeedInitRepository KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final FeedsTimelineRepository MyBillsEntityDataFactory;

    @Override // id.dana.domain.core.usecase.BaseUseCaseWithAnalytics
    public final String getOperationType() {
        return "id.dana.feedengine.socialmedia.fetchFeed";
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable buildUseCase(Object obj) {
        Intrinsics.checkNotNullParameter((NoParams) obj, "");
        Observable<Boolean> filter = this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory().filter(new Predicate() { // from class: id.dana.feeds.domain.activation.interactor.GetFriendsFeedWithInitFeedAndFeatureCheck$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj2) {
                boolean BuiltInFictitiousFunctionClassFactory;
                BuiltInFictitiousFunctionClassFactory = GetFriendsFeedWithInitFeedAndFeatureCheck.BuiltInFictitiousFunctionClassFactory((Boolean) obj2);
                return BuiltInFictitiousFunctionClassFactory;
            }
        });
        final Function1<Boolean, InitFeed> function1 = new Function1<Boolean, InitFeed>() { // from class: id.dana.feeds.domain.activation.interactor.GetFriendsFeedWithInitFeedAndFeatureCheck$checkInitFeedStatus$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lid/dana/domain/social/model/InitFeed;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
            @DebugMetadata(c = "id.dana.feeds.domain.activation.interactor.GetFriendsFeedWithInitFeedAndFeatureCheck$checkInitFeedStatus$1$1", f = "GetFriendsFeedWithInitFeedAndFeatureCheck.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: id.dana.feeds.domain.activation.interactor.GetFriendsFeedWithInitFeedAndFeatureCheck$checkInitFeedStatus$1$1  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super InitFeed>, Object> {
                int label;
                final /* synthetic */ GetFriendsFeedWithInitFeedAndFeatureCheck this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(GetFriendsFeedWithInitFeedAndFeatureCheck getFriendsFeedWithInitFeedAndFeatureCheck, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = getFriendsFeedWithInitFeedAndFeatureCheck;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super InitFeed> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    FeedInitRepository feedInitRepository;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        feedInitRepository = this.this$0.KClassImpl$Data$declaredNonStaticMembers$2;
                        this.label = 1;
                        obj = feedInitRepository.getAuthRequestContext(this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        ResultKt.throwOnFailure(obj);
                    }
                    return obj;
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ InitFeed invoke(Boolean bool) {
                return invoke(bool.booleanValue());
            }

            public final InitFeed invoke(boolean z) {
                Object runBlocking$default;
                runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass1(GetFriendsFeedWithInitFeedAndFeatureCheck.this, null), 1, null);
                return (InitFeed) runBlocking$default;
            }
        };
        Observable<R> map = filter.map(new Function() { // from class: id.dana.feeds.domain.activation.interactor.GetFriendsFeedWithInitFeedAndFeatureCheck$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj2) {
                return GetFriendsFeedWithInitFeedAndFeatureCheck.KClassImpl$Data$declaredNonStaticMembers$2(Function1.this, (Boolean) obj2);
            }
        });
        final GetFriendsFeedWithInitFeedAndFeatureCheck$isInitFeedFinished$1 getFriendsFeedWithInitFeedAndFeatureCheck$isInitFeedFinished$1 = new Function1<InitFeed, Boolean>() { // from class: id.dana.feeds.domain.activation.interactor.GetFriendsFeedWithInitFeedAndFeatureCheck$isInitFeedFinished$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(InitFeed initFeed) {
                Intrinsics.checkNotNullParameter(initFeed, "");
                return Boolean.valueOf(initFeed.isFinished());
            }
        };
        Observable filter2 = map.filter(new Predicate() { // from class: id.dana.feeds.domain.activation.interactor.GetFriendsFeedWithInitFeedAndFeatureCheck$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj2) {
                boolean MyBillsEntityDataFactory;
                MyBillsEntityDataFactory = GetFriendsFeedWithInitFeedAndFeatureCheck.MyBillsEntityDataFactory(Function1.this, (InitFeed) obj2);
                return MyBillsEntityDataFactory;
            }
        });
        final Function1<InitFeed, Observable<SocialFeed>> function12 = new Function1<InitFeed, Observable<SocialFeed>>() { // from class: id.dana.feeds.domain.activation.interactor.GetFriendsFeedWithInitFeedAndFeatureCheck$getFriendsFeed$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Observable<SocialFeed> invoke(InitFeed initFeed) {
                FeedsTimelineRepository feedsTimelineRepository;
                Observable<SocialFeed> MyBillsEntityDataFactory;
                Intrinsics.checkNotNullParameter(initFeed, "");
                feedsTimelineRepository = GetFriendsFeedWithInitFeedAndFeatureCheck.this.MyBillsEntityDataFactory;
                MyBillsEntityDataFactory = feedsTimelineRepository.MyBillsEntityDataFactory(null, 3, null, null, "timelineFeed", 2, CollectionsKt.emptyList(), false, false);
                return MyBillsEntityDataFactory;
            }
        };
        Observable flatMap = filter2.flatMap(new Function() { // from class: id.dana.feeds.domain.activation.interactor.GetFriendsFeedWithInitFeedAndFeatureCheck$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj2) {
                return GetFriendsFeedWithInitFeedAndFeatureCheck.PlaceComponentResult(Function1.this, (InitFeed) obj2);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public GetFriendsFeedWithInitFeedAndFeatureCheck(MixpanelRepository mixpanelRepository, FeedsConfigRepository feedsConfigRepository, FeedsTimelineRepository feedsTimelineRepository, FeedInitRepository feedInitRepository) {
        super(mixpanelRepository);
        Intrinsics.checkNotNullParameter(mixpanelRepository, "");
        Intrinsics.checkNotNullParameter(feedsConfigRepository, "");
        Intrinsics.checkNotNullParameter(feedsTimelineRepository, "");
        Intrinsics.checkNotNullParameter(feedInitRepository, "");
        this.getAuthRequestContext = feedsConfigRepository;
        this.MyBillsEntityDataFactory = feedsTimelineRepository;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = feedInitRepository;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean MyBillsEntityDataFactory(Function1 function1, InitFeed initFeed) {
        Intrinsics.checkNotNullParameter(function1, "");
        return ((Boolean) function1.invoke(initFeed)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean BuiltInFictitiousFunctionClassFactory(Boolean bool) {
        Intrinsics.checkNotNullParameter(bool, "");
        return bool.booleanValue();
    }

    public static /* synthetic */ InitFeed KClassImpl$Data$declaredNonStaticMembers$2(Function1 function1, Boolean bool) {
        Intrinsics.checkNotNullParameter(function1, "");
        return (InitFeed) function1.invoke(bool);
    }

    public static /* synthetic */ ObservableSource PlaceComponentResult(Function1 function1, InitFeed initFeed) {
        Intrinsics.checkNotNullParameter(function1, "");
        return (ObservableSource) function1.invoke(initFeed);
    }
}
