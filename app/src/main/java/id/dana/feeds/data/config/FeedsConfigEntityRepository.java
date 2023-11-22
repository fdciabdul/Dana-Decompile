package id.dana.feeds.data.config;

import dagger.Lazy;
import id.dana.data.config.source.HomeWidgetEntityData;
import id.dana.domain.social.model.FeedConfig;
import id.dana.feeds.data.config.model.FeedConfigResult;
import id.dana.feeds.data.config.model.ProfileCtaConfigResponseKt;
import id.dana.feeds.data.config.source.FeedsConfigData;
import id.dana.feeds.data.config.source.FeedsConfigDataFactory;
import id.dana.feeds.data.config.source.mapper.ReportReasonsConfigMapper;
import id.dana.feeds.data.config.source.split.SplitFeedsConfigEntityData;
import id.dana.feeds.data.storage.preferences.LocalSocialPreferencesData;
import id.dana.feeds.data.storage.preferences.SocialPreferencesData;
import id.dana.feeds.data.storage.preferences.SocialPreferencesDataFactory;
import id.dana.feeds.domain.config.FeedsConfigRepository;
import id.dana.feeds.domain.config.model.ProfileCtaConfig;
import id.dana.feeds.domain.config.model.ReportReasons;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001BA\b\u0007\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u0010\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u0010\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u001b\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0005J\u001b\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\b0\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0005J\u0013\u0010\u0007\u001a\u00020\rH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u000eJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0005R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0012R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00130\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0012R\u0013\u0010\u0004\u001a\u00020\u0014X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\u0015R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00160\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0012R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00170\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0012R\u0013\u0010\u0018\u001a\u00020\u0019X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\n\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/feeds/data/config/FeedsConfigEntityRepository;", "Lid/dana/feeds/domain/config/FeedsConfigRepository;", "Lio/reactivex/Observable;", "Lid/dana/feeds/data/config/model/FeedConfigResult;", "getAuthRequestContext", "()Lio/reactivex/Observable;", "Lid/dana/domain/social/model/FeedConfig;", "PlaceComponentResult", "", "Lid/dana/feeds/domain/config/model/ProfileCtaConfig;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/feeds/domain/config/model/ReportReasons;", "MyBillsEntityDataFactory", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "BuiltInFictitiousFunctionClassFactory", "Ldagger/Lazy;", "Lid/dana/feeds/data/config/source/FeedsConfigDataFactory;", "Ldagger/Lazy;", "Lid/dana/data/config/source/HomeWidgetEntityData;", "Lid/dana/feeds/data/storage/preferences/SocialPreferencesData;", "Lkotlin/Lazy;", "Lid/dana/feeds/data/config/source/mapper/ReportReasonsConfigMapper;", "Lid/dana/feeds/data/storage/preferences/SocialPreferencesDataFactory;", "getErrorConfigVersion", "Lid/dana/feeds/data/config/source/FeedsConfigData;", "p0", "p1", "p2", "p3", "<init>", "(Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FeedsConfigEntityRepository implements FeedsConfigRepository {
    private final Lazy<FeedsConfigDataFactory> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final kotlin.Lazy getErrorConfigVersion;
    private final Lazy<HomeWidgetEntityData> MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final kotlin.Lazy getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Lazy<ReportReasonsConfigMapper> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Lazy<SocialPreferencesDataFactory> PlaceComponentResult;

    @Inject
    public FeedsConfigEntityRepository(Lazy<FeedsConfigDataFactory> lazy, Lazy<ReportReasonsConfigMapper> lazy2, Lazy<SocialPreferencesDataFactory> lazy3, Lazy<HomeWidgetEntityData> lazy4) {
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        Intrinsics.checkNotNullParameter(lazy3, "");
        Intrinsics.checkNotNullParameter(lazy4, "");
        this.BuiltInFictitiousFunctionClassFactory = lazy;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy2;
        this.PlaceComponentResult = lazy3;
        this.MyBillsEntityDataFactory = lazy4;
        this.getErrorConfigVersion = LazyKt.lazy(new Function0<FeedsConfigData>() { // from class: id.dana.feeds.data.config.FeedsConfigEntityRepository$splitFeedsConfigEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FeedsConfigData invoke() {
                Lazy lazy5;
                lazy5 = FeedsConfigEntityRepository.this.BuiltInFictitiousFunctionClassFactory;
                return new SplitFeedsConfigEntityData(((FeedsConfigDataFactory) lazy5.get()).MyBillsEntityDataFactory);
            }
        });
        this.getAuthRequestContext = LazyKt.lazy(new Function0<SocialPreferencesData>() { // from class: id.dana.feeds.data.config.FeedsConfigEntityRepository$localSocialPreferencesData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SocialPreferencesData invoke() {
                Lazy lazy5;
                lazy5 = FeedsConfigEntityRepository.this.PlaceComponentResult;
                SocialPreferencesDataFactory socialPreferencesDataFactory = (SocialPreferencesDataFactory) lazy5.get();
                Intrinsics.checkNotNullParameter("local", "");
                return new LocalSocialPreferencesData(socialPreferencesDataFactory.PlaceComponentResult);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object PlaceComponentResult(kotlin.coroutines.Continuation<? super java.lang.Boolean> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof id.dana.feeds.data.config.FeedsConfigEntityRepository$isSocialContactSyncEnabled$1
            if (r0 == 0) goto L14
            r0 = r5
            id.dana.feeds.data.config.FeedsConfigEntityRepository$isSocialContactSyncEnabled$1 r0 = (id.dana.feeds.data.config.FeedsConfigEntityRepository$isSocialContactSyncEnabled$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 + r2
            r0.label = r5
            goto L19
        L14:
            id.dana.feeds.data.config.FeedsConfigEntityRepository$isSocialContactSyncEnabled$1 r0 = new id.dana.feeds.data.config.FeedsConfigEntityRepository$isSocialContactSyncEnabled$1
            r0.<init>(r4, r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L46
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r5)
            kotlin.Lazy r5 = r4.getErrorConfigVersion
            java.lang.Object r5 = r5.getValue()
            id.dana.feeds.data.config.source.FeedsConfigData r5 = (id.dana.feeds.data.config.source.FeedsConfigData) r5
            r0.label = r3
            java.lang.Object r5 = r5.lookAheadTest()
            if (r5 != r1) goto L46
            return r1
        L46:
            io.reactivex.Observable r5 = (io.reactivex.Observable) r5
            id.dana.feeds.data.config.FeedsConfigEntityRepository$$ExternalSyntheticLambda9 r0 = new id.dana.feeds.data.config.FeedsConfigEntityRepository$$ExternalSyntheticLambda9
            r0.<init>()
            io.reactivex.Observable r5 = r5.onErrorReturn(r0)
            java.lang.Object r5 = r5.blockingFirst()
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            if (r5 != 0) goto L5b
            r5 = 0
            goto L5f
        L5b:
            boolean r5 = r5.booleanValue()
        L5f:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.data.config.FeedsConfigEntityRepository.PlaceComponentResult(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(FeedsConfigEntityRepository feedsConfigEntityRepository, FeedConfigResult feedConfigResult) {
        Intrinsics.checkNotNullParameter(feedsConfigEntityRepository, "");
        SocialPreferencesData socialPreferencesData = (SocialPreferencesData) feedsConfigEntityRepository.getAuthRequestContext.getValue();
        Intrinsics.checkNotNullExpressionValue(feedConfigResult, "");
        socialPreferencesData.BuiltInFictitiousFunctionClassFactory(feedConfigResult);
    }

    public static /* synthetic */ void PlaceComponentResult(FeedsConfigEntityRepository feedsConfigEntityRepository, FeedConfig feedConfig) {
        Intrinsics.checkNotNullParameter(feedsConfigEntityRepository, "");
        HomeWidgetEntityData homeWidgetEntityData = feedsConfigEntityRepository.MyBillsEntityDataFactory.get();
        Intrinsics.checkNotNullExpressionValue(feedConfig, "");
        homeWidgetEntityData.saveFeedHomeConfig(feedConfig);
    }

    public static /* synthetic */ List MyBillsEntityDataFactory(FeedsConfigEntityRepository feedsConfigEntityRepository, List list) {
        Intrinsics.checkNotNullParameter(feedsConfigEntityRepository, "");
        Intrinsics.checkNotNullParameter(list, "");
        feedsConfigEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2.get();
        return ReportReasonsConfigMapper.KClassImpl$Data$declaredNonStaticMembers$2(list);
    }

    public static /* synthetic */ FeedConfig PlaceComponentResult(FeedConfigResult feedConfigResult) {
        Intrinsics.checkNotNullParameter(feedConfigResult, "");
        return feedConfigResult.toFeedConfig();
    }

    public static /* synthetic */ void getAuthRequestContext(FeedsConfigEntityRepository feedsConfigEntityRepository, FeedConfigResult feedConfigResult) {
        Intrinsics.checkNotNullParameter(feedsConfigEntityRepository, "");
        SocialPreferencesData socialPreferencesData = (SocialPreferencesData) feedsConfigEntityRepository.getAuthRequestContext.getValue();
        Intrinsics.checkNotNullExpressionValue(feedConfigResult, "");
        socialPreferencesData.BuiltInFictitiousFunctionClassFactory(feedConfigResult);
    }

    public static /* synthetic */ List MyBillsEntityDataFactory(List list) {
        Intrinsics.checkNotNullParameter(list, "");
        return ProfileCtaConfigResponseKt.toProfileCtaConfig(list);
    }

    public static /* synthetic */ Integer KClassImpl$Data$declaredNonStaticMembers$2(FeedConfig feedConfig) {
        Intrinsics.checkNotNullParameter(feedConfig, "");
        return Integer.valueOf(feedConfig.getFeedVersion());
    }

    public static /* synthetic */ Boolean KClassImpl$Data$declaredNonStaticMembers$2(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return Boolean.TRUE;
    }

    public static /* synthetic */ ObservableSource KClassImpl$Data$declaredNonStaticMembers$2(final FeedsConfigEntityRepository feedsConfigEntityRepository, Throwable th) {
        Intrinsics.checkNotNullParameter(feedsConfigEntityRepository, "");
        Intrinsics.checkNotNullParameter(th, "");
        return ((FeedsConfigData) feedsConfigEntityRepository.getErrorConfigVersion.getValue()).getAuthRequestContext().doOnNext(new Consumer() { // from class: id.dana.feeds.data.config.FeedsConfigEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeedsConfigEntityRepository.getAuthRequestContext(FeedsConfigEntityRepository.this, (FeedConfigResult) obj);
            }
        });
    }

    public static /* synthetic */ Boolean MyBillsEntityDataFactory(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return Boolean.FALSE;
    }

    public final Observable<FeedConfigResult> getAuthRequestContext() {
        Observable<FeedConfigResult> onErrorResumeNext = ((SocialPreferencesData) this.getAuthRequestContext.getValue()).BuiltInFictitiousFunctionClassFactory().onErrorResumeNext(new Function() { // from class: id.dana.feeds.data.config.FeedsConfigEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsConfigEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(FeedsConfigEntityRepository.this, (Throwable) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        return onErrorResumeNext;
    }

    @Override // id.dana.feeds.domain.config.FeedsConfigRepository
    public final Observable<FeedConfig> PlaceComponentResult() {
        Observable<FeedConfig> doOnNext = ((FeedsConfigData) this.getErrorConfigVersion.getValue()).getAuthRequestContext().doOnNext(new Consumer() { // from class: id.dana.feeds.data.config.FeedsConfigEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeedsConfigEntityRepository.MyBillsEntityDataFactory(FeedsConfigEntityRepository.this, (FeedConfigResult) obj);
            }
        }).map(new Function() { // from class: id.dana.feeds.data.config.FeedsConfigEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsConfigEntityRepository.PlaceComponentResult((FeedConfigResult) obj);
            }
        }).doOnNext(new Consumer() { // from class: id.dana.feeds.data.config.FeedsConfigEntityRepository$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeedsConfigEntityRepository.PlaceComponentResult(FeedsConfigEntityRepository.this, (FeedConfig) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(doOnNext, "");
        return doOnNext;
    }

    @Override // id.dana.feeds.domain.config.FeedsConfigRepository
    public final Observable<List<ProfileCtaConfig>> KClassImpl$Data$declaredNonStaticMembers$2() {
        Observable map = ((FeedsConfigData) this.getErrorConfigVersion.getValue()).MyBillsEntityDataFactory().map(new Function() { // from class: id.dana.feeds.data.config.FeedsConfigEntityRepository$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsConfigEntityRepository.MyBillsEntityDataFactory((List) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.feeds.domain.config.FeedsConfigRepository
    public final Observable<List<ReportReasons>> MyBillsEntityDataFactory() {
        Observable map = ((FeedsConfigData) this.getErrorConfigVersion.getValue()).NetworkUserEntityData$$ExternalSyntheticLambda0().map(new Function() { // from class: id.dana.feeds.data.config.FeedsConfigEntityRepository$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsConfigEntityRepository.MyBillsEntityDataFactory(FeedsConfigEntityRepository.this, (List) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.feeds.domain.config.FeedsConfigRepository
    public final Observable<Boolean> BuiltInFictitiousFunctionClassFactory() {
        return ((FeedsConfigData) this.getErrorConfigVersion.getValue()).getErrorConfigVersion();
    }
}
