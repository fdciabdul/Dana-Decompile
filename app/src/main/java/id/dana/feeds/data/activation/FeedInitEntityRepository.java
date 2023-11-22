package id.dana.feeds.data.activation;

import dagger.Lazy;
import id.dana.data.account.AccountEntity;
import id.dana.data.account.repository.source.AccountEntityData;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.config.source.HomeWidgetEntityData;
import id.dana.data.config.source.split.SplitConfigEntityData;
import id.dana.data.social.repository.source.persistence.entity.FollowerEntity;
import id.dana.data.social.repository.source.persistence.entity.FollowingEntity;
import id.dana.data.userconfig.BiztypeNotFoundException;
import id.dana.data.userconfig.UserConfigBizTypeConstant;
import id.dana.data.userconfig.repository.UserConfigEntityRepository;
import id.dana.domain.social.InitStatus;
import id.dana.domain.social.model.FeedInit;
import id.dana.domain.social.model.FeedStatus;
import id.dana.domain.social.model.InitFeed;
import id.dana.domain.userconfig.model.QueryConfig;
import id.dana.feeds.data.activation.source.FeedInitEntityData;
import id.dana.feeds.data.activation.source.FeedInitEntityDataFactory;
import id.dana.feeds.data.activation.source.network.request.FeedsStatusConfig;
import id.dana.feeds.data.activation.source.network.request.FeedsStatusStoreConfig;
import id.dana.feeds.data.storage.persistence.PersistenceRelationshipEntityData;
import id.dana.feeds.data.storage.preferences.LocalSocialPreferencesData;
import id.dana.feeds.data.storage.preferences.SocialPreferences;
import id.dana.feeds.data.storage.preferences.SocialPreferencesData;
import id.dana.feeds.data.storage.preferences.SocialPreferencesDataFactory;
import id.dana.feeds.data.synccontact.FeedsContactProvider;
import id.dana.feeds.data.timeline.source.persistence.PersistenceFeedsTimelineEntityData;
import id.dana.feeds.domain.activation.FeedInitRepository;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.BehaviorSubject;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Job;

@Singleton
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0017\u0018\u00002\u00020\u0001B\u009d\u0001\b\u0007\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020$0!\u0012\f\u0010<\u001a\b\u0012\u0004\u0012\u0002080!\u0012\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\"0!\u0012\f\u0010>\u001a\b\u0012\u0004\u0012\u0002050!\u0012\f\u0010?\u001a\b\u0012\u0004\u0012\u0002060!\u0012\f\u0010@\u001a\b\u0012\u0004\u0012\u00020:0!\u0012\f\u0010A\u001a\b\u0012\u0004\u0012\u00020&0!\u0012\u0006\u0010B\u001a\u00020+\u0012\f\u0010C\u001a\b\u0012\u0004\u0012\u00020)0!\u0012\f\u0010D\u001a\b\u0012\u0004\u0012\u0002040!\u0012\f\u0010E\u001a\b\u0012\u0004\u0012\u00020'0!¢\u0006\u0004\bF\u0010GJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b\u0005\u0010\tJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\tJ\u0011\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\tJ\u0019\u0010\u0011\u001a\f\u0012\b\u0012\u0006*\u00020\u00020\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010H\u0016¢\u0006\u0004\b\u0016\u0010\u0012J\u0013\u0010\u0017\u001a\u0006*\u00020\f0\fH\u0002¢\u0006\u0004\b\u0017\u0010\u000eJ\u0015\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0007H\u0016¢\u0006\u0004\b\u0019\u0010\tJ\u001b\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u001aH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u001bJ\u0013\u0010\u000b\u001a\u00020\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u0004H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001cJ\u0013\u0010\u000f\u001a\u00020\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u001cJ\u0013\u0010\u0005\u001a\u00020\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0016¢\u0006\u0004\b \u0010\tR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010#R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020$0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010#R$\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048W@WX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001f\"\u0004\b\u001d\u0010%R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020&0!8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010#R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020'0!8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010#R\u0012\u0010\u0011\u001a\u00020\fX\u0095@¢\u0006\u0006\n\u0004\b\u000f\u0010(R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020)0!8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010#R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010*R\u0014\u0010 \u001a\u00020+8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010,R\u0017\u0010\u0016\u001a\u0006*\u00020-0-X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b \u0010.R\u0013\u00100\u001a\u00020/X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\r\u0010.R\u0013\u00102\u001a\u000201X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\u0017\u0010.R\u0013\u0010\u001e\u001a\u00020/X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b3\u0010.R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002040!8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010#R\u001a\u00103\u001a\b\u0012\u0004\u0012\u0002050!8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b0\u0010#R\u001a\u00107\u001a\b\u0012\u0004\u0012\u0002060!8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b2\u0010#R\u001a\u00109\u001a\b\u0012\u0004\u0012\u0002080!8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b9\u0010#R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u00020:0!8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b7\u0010#\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/feeds/data/activation/FeedInitEntityRepository;", "Lid/dana/feeds/domain/activation/FeedInitRepository;", "Lid/dana/domain/social/model/InitFeed;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/domain/social/model/InitFeed;)Z", "Lio/reactivex/Observable;", "", "()Lio/reactivex/Observable;", "Lid/dana/domain/social/model/FeedStatus;", "getAuthRequestContext", "", "getErrorConfigVersion", "()Ljava/lang/String;", "MyBillsEntityDataFactory", "Lio/reactivex/subjects/BehaviorSubject;", "lookAheadTest", "()Lio/reactivex/subjects/BehaviorSubject;", "Lkotlinx/coroutines/Job;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lkotlinx/coroutines/Job;", "moveToNextValue", "DatabaseTableConfigUtil", "Lid/dana/domain/social/model/FeedInit;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "PlaceComponentResult", "NetworkUserEntityData$$ExternalSyntheticLambda2", "()Z", "scheduleImpl", "Ldagger/Lazy;", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", "Ldagger/Lazy;", "Lid/dana/feeds/data/synccontact/FeedsContactProvider;", "(Z)V", "Lid/dana/feeds/data/activation/source/FeedInitEntityDataFactory;", "Lid/dana/feeds/data/timeline/source/persistence/PersistenceFeedsTimelineEntityData;", "Ljava/lang/String;", "Lid/dana/data/config/source/HomeWidgetEntityData;", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lid/dana/data/account/repository/source/AccountEntityData;", "Lkotlin/Lazy;", "Lid/dana/feeds/data/activation/source/FeedInitEntityData;", "GetContactSyncConfig", "Lid/dana/feeds/data/storage/preferences/SocialPreferencesData;", "initRecordTimeStamp", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/feeds/data/storage/persistence/PersistenceRelationshipEntityData;", "Lid/dana/feeds/data/storage/preferences/SocialPreferences;", "Lid/dana/feeds/data/storage/preferences/SocialPreferencesDataFactory;", "PrepareContext", "Lid/dana/data/config/source/split/SplitConfigEntityData;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Lid/dana/data/userconfig/repository/UserConfigEntityRepository;", "newProxyInstance", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "<init>", "(Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Lkotlinx/coroutines/CoroutineDispatcher;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public class FeedInitEntityRepository implements FeedInitRepository {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Lazy<AccountEntityDataFactory> MyBillsEntityDataFactory;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final kotlin.Lazy initRecordTimeStamp;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final Lazy<SocialPreferences> NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Lazy<FeedInitEntityDataFactory> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    protected final String lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final CoroutineDispatcher scheduleImpl;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final kotlin.Lazy NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final Lazy<PersistenceRelationshipEntityData> DatabaseTableConfigUtil;
    private final Lazy<SplitConfigEntityData> NetworkUserEntityData$$ExternalSyntheticLambda8;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Lazy<PersistenceFeedsTimelineEntityData> getAuthRequestContext;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private final Lazy<UserConfigEntityRepository> newProxyInstance;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Lazy<FeedsContactProvider> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final kotlin.Lazy GetContactSyncConfig;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final Lazy<SocialPreferencesDataFactory> PrepareContext;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final Lazy<HomeWidgetEntityData> getErrorConfigVersion;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private Job NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final kotlin.Lazy moveToNextValue;

    @Override // id.dana.feeds.domain.activation.FeedInitRepository
    public final Object MyBillsEntityDataFactory(Continuation<? super InitFeed> continuation) {
        return MyBillsEntityDataFactory(this, continuation);
    }

    @Override // id.dana.feeds.domain.activation.FeedInitRepository
    public final Object PlaceComponentResult(Continuation<? super Boolean> continuation) {
        return getAuthRequestContext(this, continuation);
    }

    @Override // id.dana.feeds.domain.activation.FeedInitRepository
    public final Object getAuthRequestContext(Continuation<? super InitFeed> continuation) {
        return PlaceComponentResult(this, continuation);
    }

    @Inject
    public FeedInitEntityRepository(Lazy<FeedsContactProvider> lazy, Lazy<SplitConfigEntityData> lazy2, Lazy<AccountEntityDataFactory> lazy3, Lazy<SocialPreferences> lazy4, Lazy<SocialPreferencesDataFactory> lazy5, Lazy<UserConfigEntityRepository> lazy6, Lazy<FeedInitEntityDataFactory> lazy7, CoroutineDispatcher coroutineDispatcher, Lazy<HomeWidgetEntityData> lazy8, Lazy<PersistenceRelationshipEntityData> lazy9, Lazy<PersistenceFeedsTimelineEntityData> lazy10) {
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        Intrinsics.checkNotNullParameter(lazy3, "");
        Intrinsics.checkNotNullParameter(lazy4, "");
        Intrinsics.checkNotNullParameter(lazy5, "");
        Intrinsics.checkNotNullParameter(lazy6, "");
        Intrinsics.checkNotNullParameter(lazy7, "");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "");
        Intrinsics.checkNotNullParameter(lazy8, "");
        Intrinsics.checkNotNullParameter(lazy9, "");
        Intrinsics.checkNotNullParameter(lazy10, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = lazy2;
        this.MyBillsEntityDataFactory = lazy3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = lazy4;
        this.PrepareContext = lazy5;
        this.newProxyInstance = lazy6;
        this.BuiltInFictitiousFunctionClassFactory = lazy7;
        this.scheduleImpl = coroutineDispatcher;
        this.getErrorConfigVersion = lazy8;
        this.DatabaseTableConfigUtil = lazy9;
        this.getAuthRequestContext = lazy10;
        this.lookAheadTest = "first_time_init_feed";
        this.GetContactSyncConfig = LazyKt.lazy(new Function0<FeedInitEntityData>() { // from class: id.dana.feeds.data.activation.FeedInitEntityRepository$localFeedInitEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FeedInitEntityData invoke() {
                Lazy lazy11;
                lazy11 = FeedInitEntityRepository.this.BuiltInFictitiousFunctionClassFactory;
                return ((FeedInitEntityDataFactory) lazy11.get()).createData2("local");
            }
        });
        this.initRecordTimeStamp = LazyKt.lazy(new Function0<SocialPreferencesData>() { // from class: id.dana.feeds.data.activation.FeedInitEntityRepository$localSocialPreference$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SocialPreferencesData invoke() {
                Lazy lazy11;
                lazy11 = FeedInitEntityRepository.this.PrepareContext;
                SocialPreferencesDataFactory socialPreferencesDataFactory = (SocialPreferencesDataFactory) lazy11.get();
                Intrinsics.checkNotNullParameter("local", "");
                return new LocalSocialPreferencesData(socialPreferencesDataFactory.PlaceComponentResult);
            }
        });
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = LazyKt.lazy(new Function0<FeedInitEntityData>() { // from class: id.dana.feeds.data.activation.FeedInitEntityRepository$networkFeedInitEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FeedInitEntityData invoke() {
                Lazy lazy11;
                lazy11 = FeedInitEntityRepository.this.BuiltInFictitiousFunctionClassFactory;
                return ((FeedInitEntityDataFactory) lazy11.get()).createData2("network");
            }
        });
        this.moveToNextValue = LazyKt.lazy(new Function0<AccountEntityData>() { // from class: id.dana.feeds.data.activation.FeedInitEntityRepository$localAccountEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AccountEntityData invoke() {
                Lazy lazy11;
                lazy11 = FeedInitEntityRepository.this.MyBillsEntityDataFactory;
                return ((AccountEntityDataFactory) lazy11.get()).createData2("local");
            }
        });
    }

    @Override // id.dana.feeds.domain.activation.FeedInitRepository
    @JvmName(name = "PlaceComponentResult")
    public final boolean PlaceComponentResult() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1.get().PlaceComponentResult();
    }

    @Override // id.dana.feeds.domain.activation.FeedInitRepository
    @JvmName(name = "PlaceComponentResult")
    public final void PlaceComponentResult(boolean z) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.get().MyBillsEntityDataFactory.saveData("device_Feed_feature_switch", Boolean.valueOf(z));
        lookAheadTest().onNext(new InitFeed(InitStatus.NOT_ACTIVATED, 0, null, false, 14, null));
    }

    @Override // id.dana.feeds.domain.activation.FeedInitRepository
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final Job getNetworkUserEntityData$$ExternalSyntheticLambda0() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x003f  */
    /* JADX WARN: Type inference failed for: r4v3, types: [T, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object getAuthRequestContext(id.dana.feeds.data.activation.FeedInitEntityRepository r10, kotlin.coroutines.Continuation r11) {
        /*
            boolean r0 = r11 instanceof id.dana.feeds.data.activation.FeedInitEntityRepository$initFeedPeriodically$1
            if (r0 == 0) goto L14
            r0 = r11
            id.dana.feeds.data.activation.FeedInitEntityRepository$initFeedPeriodically$1 r0 = (id.dana.feeds.data.activation.FeedInitEntityRepository$initFeedPeriodically$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 + r2
            r0.label = r11
            goto L19
        L14:
            id.dana.feeds.data.activation.FeedInitEntityRepository$initFeedPeriodically$1 r0 = new id.dana.feeds.data.activation.FeedInitEntityRepository$initFeedPeriodically$1
            r0.<init>(r10, r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r10 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            java.lang.Object r1 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            java.lang.Object r0 = r0.L$0
            id.dana.feeds.data.activation.FeedInitEntityRepository r0 = (id.dana.feeds.data.activation.FeedInitEntityRepository) r0
            kotlin.ResultKt.throwOnFailure(r11)
            goto Lb1
        L37:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3f:
            kotlin.ResultKt.throwOnFailure(r11)
            kotlin.jvm.internal.Ref$ObjectRef r11 = new kotlin.jvm.internal.Ref$ObjectRef
            r11.<init>()
            kotlin.Lazy r2 = r10.initRecordTimeStamp
            java.lang.Object r2 = r2.getValue()
            id.dana.feeds.data.storage.preferences.SocialPreferencesData r2 = (id.dana.feeds.data.storage.preferences.SocialPreferencesData) r2
            java.lang.String r4 = r10.DatabaseTableConfigUtil()
            java.lang.String r5 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            io.reactivex.Observable r2 = r2.BuiltInFictitiousFunctionClassFactory(r4)
            id.dana.domain.social.model.FeedInit r4 = new id.dana.domain.social.model.FeedInit
            id.dana.domain.social.InitStatus r6 = id.dana.domain.social.InitStatus.NOT_ACTIVATED
            r7 = 0
            r4.<init>(r7, r6)
            java.lang.Object r2 = r2.blockingSingle(r4)
            id.dana.domain.social.model.FeedInit r2 = (id.dana.domain.social.model.FeedInit) r2
            id.dana.domain.social.model.InitFeed r2 = r2.toInitFeed()
            id.dana.domain.social.InitStatus r4 = r2.getStatus()
            id.dana.domain.social.InitStatus r6 = id.dana.domain.social.InitStatus.NOT_ACTIVATED
            if (r4 != r6) goto L93
            id.dana.domain.social.model.FeedInit r2 = new id.dana.domain.social.model.FeedInit
            id.dana.domain.social.InitStatus r4 = id.dana.domain.social.InitStatus.INIT
            r2.<init>(r7, r4)
            kotlin.Lazy r4 = r10.initRecordTimeStamp
            java.lang.Object r4 = r4.getValue()
            id.dana.feeds.data.storage.preferences.SocialPreferencesData r4 = (id.dana.feeds.data.storage.preferences.SocialPreferencesData) r4
            java.lang.String r6 = r10.DatabaseTableConfigUtil()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r5)
            r4.PlaceComponentResult(r6, r2)
            id.dana.domain.social.model.InitFeed r2 = r2.toInitFeed()
        L93:
            r11.element = r2
            io.reactivex.subjects.BehaviorSubject r2 = r10.lookAheadTest()
            T r4 = r11.element
            r2.onNext(r4)
            r0.L$0 = r10
            r0.L$1 = r11
            r0.L$2 = r11
            r0.label = r3
            java.lang.Object r0 = MyBillsEntityDataFactory(r10, r0)
            if (r0 != r1) goto Lad
            return r1
        Lad:
            r1 = r11
            r11 = r0
            r0 = r10
            r10 = r1
        Lb1:
            r10.element = r11
            kotlinx.coroutines.CoroutineDispatcher r10 = r0.scheduleImpl
            kotlin.coroutines.CoroutineContext r10 = (kotlin.coroutines.CoroutineContext) r10
            kotlinx.coroutines.CoroutineScope r4 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r10)
            r5 = 0
            r6 = 0
            id.dana.feeds.data.activation.FeedInitEntityRepository$initFeedPeriodically$2 r10 = new id.dana.feeds.data.activation.FeedInitEntityRepository$initFeedPeriodically$2
            r11 = 0
            r10.<init>(r0, r1, r11)
            r7 = r10
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r8 = 3
            r9 = 0
            kotlinx.coroutines.Job r10 = kotlinx.coroutines.BuildersKt.launch$default(r4, r5, r6, r7, r8, r9)
            r0.NetworkUserEntityData$$ExternalSyntheticLambda0 = r10
            java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.data.activation.FeedInitEntityRepository.getAuthRequestContext(id.dana.feeds.data.activation.FeedInitEntityRepository, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0036  */
    /* JADX WARN: Type inference failed for: r8v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object MyBillsEntityDataFactory(id.dana.feeds.data.activation.FeedInitEntityRepository r7, kotlin.coroutines.Continuation r8) {
        /*
            boolean r0 = r8 instanceof id.dana.feeds.data.activation.FeedInitEntityRepository$initFeedWithPublishErrorFallback$1
            if (r0 == 0) goto L14
            r0 = r8
            id.dana.feeds.data.activation.FeedInitEntityRepository$initFeedWithPublishErrorFallback$1 r0 = (id.dana.feeds.data.activation.FeedInitEntityRepository$initFeedWithPublishErrorFallback$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 + r2
            r0.label = r8
            goto L19
        L14:
            id.dana.feeds.data.activation.FeedInitEntityRepository$initFeedWithPublishErrorFallback$1 r0 = new id.dana.feeds.data.activation.FeedInitEntityRepository$initFeedWithPublishErrorFallback$1
            r0.<init>(r7, r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r7 = r0.L$0
            id.dana.feeds.data.activation.FeedInitEntityRepository r7 = (id.dana.feeds.data.activation.FeedInitEntityRepository) r7
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Exception -> L51
            goto L44
        L2e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L36:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r7     // Catch: java.lang.Exception -> L51
            r0.label = r3     // Catch: java.lang.Exception -> L51
            java.lang.Object r8 = PlaceComponentResult(r7, r0)     // Catch: java.lang.Exception -> L51
            if (r8 != r1) goto L44
            return r1
        L44:
            r0 = r8
            id.dana.domain.social.model.InitFeed r0 = (id.dana.domain.social.model.InitFeed) r0     // Catch: java.lang.Exception -> L51
            io.reactivex.subjects.BehaviorSubject r1 = r7.lookAheadTest()     // Catch: java.lang.Exception -> L51
            r1.onNext(r0)     // Catch: java.lang.Exception -> L51
            id.dana.domain.social.model.InitFeed r8 = (id.dana.domain.social.model.InitFeed) r8     // Catch: java.lang.Exception -> L51
            goto L67
        L51:
            r8 = move-exception
            r3 = r8
            id.dana.domain.social.model.InitFeed r8 = new id.dana.domain.social.model.InitFeed
            id.dana.domain.social.InitStatus r1 = id.dana.domain.social.InitStatus.ERROR
            r2 = 0
            r4 = 0
            r5 = 10
            r6 = 0
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6)
            io.reactivex.subjects.BehaviorSubject r7 = r7.lookAheadTest()
            r7.onNext(r8)
        L67:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.data.activation.FeedInitEntityRepository.MyBillsEntityDataFactory(id.dana.feeds.data.activation.FeedInitEntityRepository, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // id.dana.feeds.domain.activation.FeedInitRepository
    public final BehaviorSubject<InitFeed> moveToNextValue() {
        return lookAheadTest();
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(InitFeed p0) {
        if (!p0.isFinished() && !p0.isError()) {
            BehaviorSubject behaviorSubject = (BehaviorSubject) this.NetworkUserEntityData$$ExternalSyntheticLambda1.get().PlaceComponentResult.getValue();
            Intrinsics.checkNotNullExpressionValue(behaviorSubject, "");
            if (behaviorSubject.PlaceComponentResult()) {
                return true;
            }
        }
        return false;
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda2() {
        return lookAheadTest().PlaceComponentResult();
    }

    private final BehaviorSubject<InitFeed> lookAheadTest() {
        BehaviorSubject<InitFeed> behaviorSubject = (BehaviorSubject) this.NetworkUserEntityData$$ExternalSyntheticLambda1.get().PlaceComponentResult.getValue();
        Intrinsics.checkNotNullExpressionValue(behaviorSubject, "");
        return behaviorSubject;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object PlaceComponentResult(id.dana.feeds.data.activation.FeedInitEntityRepository r10, kotlin.coroutines.Continuation r11) {
        /*
            boolean r0 = r11 instanceof id.dana.feeds.data.activation.FeedInitEntityRepository$initFeedFirstTime$1
            if (r0 == 0) goto L14
            r0 = r11
            id.dana.feeds.data.activation.FeedInitEntityRepository$initFeedFirstTime$1 r0 = (id.dana.feeds.data.activation.FeedInitEntityRepository$initFeedFirstTime$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 + r2
            r0.label = r11
            goto L19
        L14:
            id.dana.feeds.data.activation.FeedInitEntityRepository$initFeedFirstTime$1 r0 = new id.dana.feeds.data.activation.FeedInitEntityRepository$initFeedFirstTime$1
            r0.<init>(r10, r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r10 = r0.L$0
            id.dana.feeds.data.activation.FeedInitEntityRepository r10 = (id.dana.feeds.data.activation.FeedInitEntityRepository) r10
            kotlin.ResultKt.throwOnFailure(r11)
            goto L72
        L2e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L36:
            kotlin.ResultKt.throwOnFailure(r11)
            dagger.Lazy<id.dana.feeds.data.synccontact.FeedsContactProvider> r11 = r10.KClassImpl$Data$declaredNonStaticMembers$2
            java.lang.Object r11 = r11.get()
            id.dana.feeds.data.synccontact.FeedsContactProvider r11 = (id.dana.feeds.data.synccontact.FeedsContactProvider) r11
            java.lang.String r2 = "contact_id"
            java.lang.String[] r6 = new java.lang.String[]{r2}
            java.lang.String r2 = "vnd.android.cursor.item/phone_v2"
            java.lang.String r4 = "628%"
            java.lang.String r5 = "+628%"
            java.lang.String r7 = "08%"
            java.lang.String[] r8 = new java.lang.String[]{r2, r4, r5, r7}
            android.content.ContentResolver r4 = r11.PlaceComponentResult
            android.net.Uri r5 = android.provider.ContactsContract.Data.CONTENT_URI
            java.lang.String r7 = "mimetype = ? AND (data1 LIKE ? OR data1 LIKE ? OR data1 LIKE ?)"
            java.lang.String r9 = ""
            android.database.Cursor r11 = r4.query(r5, r6, r7, r8, r9)
            if (r11 == 0) goto L66
            int r11 = r11.getCount()
            goto L67
        L66:
            r11 = 0
        L67:
            r0.L$0 = r10
            r0.label = r3
            java.lang.Object r11 = r10.KClassImpl$Data$declaredNonStaticMembers$2(r11, r0)
            if (r11 != r1) goto L72
            return r1
        L72:
            r0 = r11
            id.dana.domain.social.model.InitFeed r0 = (id.dana.domain.social.model.InitFeed) r0
            io.reactivex.subjects.BehaviorSubject r10 = r10.lookAheadTest()
            r10.onNext(r0)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.data.activation.FeedInitEntityRepository.PlaceComponentResult(id.dana.feeds.data.activation.FeedInitEntityRepository, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object KClassImpl$Data$declaredNonStaticMembers$2(int r5, kotlin.coroutines.Continuation<? super id.dana.domain.social.model.InitFeed> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof id.dana.feeds.data.activation.FeedInitEntityRepository$initFeed$1
            if (r0 == 0) goto L14
            r0 = r6
            id.dana.feeds.data.activation.FeedInitEntityRepository$initFeed$1 r0 = (id.dana.feeds.data.activation.FeedInitEntityRepository$initFeed$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 + r2
            r0.label = r6
            goto L19
        L14:
            id.dana.feeds.data.activation.FeedInitEntityRepository$initFeed$1 r0 = new id.dana.feeds.data.activation.FeedInitEntityRepository$initFeed$1
            r0.<init>(r4, r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r5 = r0.L$0
            id.dana.feeds.data.activation.FeedInitEntityRepository r5 = (id.dana.feeds.data.activation.FeedInitEntityRepository) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4d
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Lazy r6 = r4.NetworkUserEntityData$$ExternalSyntheticLambda2
            java.lang.Object r6 = r6.getValue()
            id.dana.feeds.data.activation.source.FeedInitEntityData r6 = (id.dana.feeds.data.activation.source.FeedInitEntityData) r6
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r6.PlaceComponentResult(r5, r0)
            if (r6 != r1) goto L4c
            return r1
        L4c:
            r5 = r4
        L4d:
            id.dana.feeds.data.activation.source.network.response.InitFeedResponse r6 = (id.dana.feeds.data.activation.source.network.response.InitFeedResponse) r6
            boolean r0 = r6.success
            if (r0 == 0) goto L8b
            kotlin.Lazy r0 = r5.initRecordTimeStamp
            java.lang.Object r0 = r0.getValue()
            id.dana.feeds.data.storage.preferences.SocialPreferencesData r0 = (id.dana.feeds.data.storage.preferences.SocialPreferencesData) r0
            java.lang.String r1 = r5.DatabaseTableConfigUtil()
            java.lang.String r2 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            id.dana.domain.social.model.FeedInit r3 = id.dana.feeds.domain.activation.mapper.FeedInitMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(r6)
            r0.PlaceComponentResult(r1, r3)
            kotlin.Lazy r0 = r5.GetContactSyncConfig
            java.lang.Object r0 = r0.getValue()
            id.dana.feeds.data.activation.source.FeedInitEntityData r0 = (id.dana.feeds.data.activation.source.FeedInitEntityData) r0
            java.lang.String r1 = r5.DatabaseTableConfigUtil()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.String r2 = r5.lookAheadTest
            r0.MyBillsEntityDataFactory(r1, r2)
            id.dana.domain.social.model.InitFeed r6 = id.dana.feeds.data.activation.mapper.InitFeedMapperKt.BuiltInFictitiousFunctionClassFactory(r6)
            io.reactivex.Observable r5 = r5.scheduleImpl()
            r5.blockingFirst()
            return r6
        L8b:
            id.dana.network.exception.NetworkException r5 = new id.dana.network.exception.NetworkException
            com.alipayplus.mobile.component.domain.model.result.BaseRpcResult r6 = (com.alipayplus.mobile.component.domain.model.result.BaseRpcResult) r6
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.data.activation.FeedInitEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // id.dana.feeds.domain.activation.FeedInitRepository
    public final Observable<Boolean> scheduleImpl() {
        Observable<Boolean> onErrorReturnItem = this.newProxyInstance.get().saveUserSpecificConfigBackendFirst(new FeedsStatusStoreConfig(new FeedsStatusConfig(getErrorConfigVersion(), Boolean.valueOf(PlaceComponentResult())))).onErrorReturnItem(Boolean.TRUE);
        Intrinsics.checkNotNullExpressionValue(onErrorReturnItem, "");
        return onErrorReturnItem;
    }

    private final String getErrorConfigVersion() {
        SocialPreferences socialPreferences = this.NetworkUserEntityData$$ExternalSyntheticLambda1.get();
        String str = (String) ((AccountEntityData) this.moveToNextValue.getValue()).getAccount().map(new FeedInitEntityRepository$$ExternalSyntheticLambda11()).blockingFirst();
        Intrinsics.checkNotNullExpressionValue(str, "");
        FeedInit PlaceComponentResult = socialPreferences.PlaceComponentResult(str);
        if (PlaceComponentResult.getStatus() == InitStatus.NOT_ACTIVATED) {
            return null;
        }
        return PlaceComponentResult.getStatus().getStatus();
    }

    @Override // id.dana.feeds.domain.activation.FeedInitRepository
    public final Observable<FeedStatus> getAuthRequestContext() {
        Observable<FeedStatus> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.feeds.data.activation.FeedInitEntityRepository$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return FeedInitEntityRepository.getAuthRequestContext(FeedInitEntityRepository.this);
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    @Override // id.dana.feeds.domain.activation.FeedInitRepository
    public final Observable<Unit> BuiltInFictitiousFunctionClassFactory() {
        Observable<Unit> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.feeds.data.activation.FeedInitEntityRepository$$ExternalSyntheticLambda12
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return FeedInitEntityRepository.PlaceComponentResult(FeedInitEntityRepository.this);
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    public static /* synthetic */ FeedStatus getAuthRequestContext(FeedInitEntityRepository feedInitEntityRepository) {
        Intrinsics.checkNotNullParameter(feedInitEntityRepository, "");
        return new FeedStatus(feedInitEntityRepository.getErrorConfigVersion(), feedInitEntityRepository.PlaceComponentResult());
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [id.dana.data.social.repository.source.persistence.entity.PaginatorEntity, java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    public static /* synthetic */ Unit PlaceComponentResult(FeedInitEntityRepository feedInitEntityRepository) {
        Intrinsics.checkNotNullParameter(feedInitEntityRepository, "");
        SocialPreferences socialPreferences = feedInitEntityRepository.NetworkUserEntityData$$ExternalSyntheticLambda1.get();
        ((BehaviorSubject) socialPreferences.PlaceComponentResult.getValue()).onNext(new InitFeed(InitStatus.NOT_ACTIVATED, 0, null, false, 14, null));
        socialPreferences.MyBillsEntityDataFactory.clearData("follower_full_sync_last_page");
        socialPreferences.MyBillsEntityDataFactory.clearData("follower_full_sync_finished");
        socialPreferences.MyBillsEntityDataFactory.clearData("follower_partial_sync_modified_time");
        socialPreferences.MyBillsEntityDataFactory.clearData("follower_partial_sync_last_page");
        socialPreferences.MyBillsEntityDataFactory.clearData("following_full_sync_last_page");
        socialPreferences.MyBillsEntityDataFactory.clearData("following_full_sync_finished");
        socialPreferences.MyBillsEntityDataFactory.clearData("following_partial_sync_modified_time");
        socialPreferences.MyBillsEntityDataFactory.clearData("following_partial_sync_last_page");
        socialPreferences.MyBillsEntityDataFactory.clearData("cached_timeline_key");
        socialPreferences.MyBillsEntityDataFactory.clearData("feed_config");
        socialPreferences.MyBillsEntityDataFactory.clearData("feed_timeline_version");
        PersistenceRelationshipEntityData persistenceRelationshipEntityData = feedInitEntityRepository.DatabaseTableConfigUtil.get();
        int i = 3;
        ?? r4 = 0;
        persistenceRelationshipEntityData.MyBillsEntityDataFactory.onNext(new FollowerEntity(r4, r4, i, r4));
        persistenceRelationshipEntityData.BuiltInFictitiousFunctionClassFactory.onNext(new FollowerEntity(r4, r4, i, r4));
        persistenceRelationshipEntityData.PlaceComponentResult.onNext(new FollowingEntity(r4, r4, i, r4));
        persistenceRelationshipEntityData.KClassImpl$Data$declaredNonStaticMembers$2.onNext(new FollowingEntity(r4, r4, i, r4));
        persistenceRelationshipEntityData.getDb().followerDao().clearFollower();
        persistenceRelationshipEntityData.getDb().followingDao().clearFollowing();
        feedInitEntityRepository.getAuthRequestContext.get().getDb().activityDao().clearActivities();
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(FeedInitEntityRepository feedInitEntityRepository, FeedInit feedInit) {
        Intrinsics.checkNotNullParameter(feedInitEntityRepository, "");
        feedInitEntityRepository.getErrorConfigVersion.get().saveFeedInitState(feedInit.getStatus());
    }

    public static /* synthetic */ String KClassImpl$Data$declaredNonStaticMembers$2(AccountEntity accountEntity) {
        Intrinsics.checkNotNullParameter(accountEntity, "");
        return accountEntity.getPhoneNumber();
    }

    public static /* synthetic */ ObservableSource KClassImpl$Data$declaredNonStaticMembers$2(final FeedInitEntityRepository feedInitEntityRepository, Ref.BooleanRef booleanRef, final FeedsStatusConfig feedsStatusConfig) {
        Intrinsics.checkNotNullParameter(feedInitEntityRepository, "");
        Intrinsics.checkNotNullParameter(booleanRef, "");
        Intrinsics.checkNotNullParameter(feedsStatusConfig, "");
        final boolean z = booleanRef.element;
        Observable fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.feeds.data.activation.FeedInitEntityRepository$$ExternalSyntheticLambda5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return FeedInitEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(FeedInitEntityRepository.this);
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable.flatMap(new Function() { // from class: id.dana.feeds.data.activation.FeedInitEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedInitEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(z, feedInitEntityRepository, feedsStatusConfig, (FeedsStatusConfig) obj);
            }
        });
    }

    public static /* synthetic */ ObservableSource MyBillsEntityDataFactory(FeedInitEntityRepository feedInitEntityRepository, Boolean bool) {
        Observable just;
        Intrinsics.checkNotNullParameter(feedInitEntityRepository, "");
        Intrinsics.checkNotNullParameter(bool, "");
        if (bool.booleanValue()) {
            just = Observable.just(bool);
            Intrinsics.checkNotNullExpressionValue(just, "");
        } else {
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            just = feedInitEntityRepository.newProxyInstance.get().getUserSpecificConfig(new QueryConfig(UserConfigBizTypeConstant.CONFIG_FRIENDSHIP_STATUS, FeedsStatusConfig.class)).onErrorResumeNext(new Function() { // from class: id.dana.feeds.data.activation.FeedInitEntityRepository$$ExternalSyntheticLambda8
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return FeedInitEntityRepository.MyBillsEntityDataFactory(Ref.BooleanRef.this, (Throwable) obj);
                }
            }).flatMap(new Function() { // from class: id.dana.feeds.data.activation.FeedInitEntityRepository$$ExternalSyntheticLambda9
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return FeedInitEntityRepository.PlaceComponentResult(FeedInitEntityRepository.this, (FeedsStatusConfig) obj);
                }
            }).flatMap(new Function() { // from class: id.dana.feeds.data.activation.FeedInitEntityRepository$$ExternalSyntheticLambda10
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return FeedInitEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(FeedInitEntityRepository.this, booleanRef, (FeedsStatusConfig) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(just, "");
        }
        return just;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.Boolean, java.lang.String] */
    public static /* synthetic */ ObservableSource MyBillsEntityDataFactory(Ref.BooleanRef booleanRef, Throwable th) {
        Intrinsics.checkNotNullParameter(booleanRef, "");
        Intrinsics.checkNotNullParameter(th, "");
        if (th instanceof BiztypeNotFoundException) {
            booleanRef.element = true;
            ?? r0 = 0;
            return Observable.just(new FeedsStatusConfig(r0, r0, 3, r0));
        }
        return Observable.error(th);
    }

    public static /* synthetic */ FeedsStatusConfig KClassImpl$Data$declaredNonStaticMembers$2(FeedInitEntityRepository feedInitEntityRepository) {
        Intrinsics.checkNotNullParameter(feedInitEntityRepository, "");
        return new FeedsStatusConfig(feedInitEntityRepository.getErrorConfigVersion(), Boolean.valueOf(feedInitEntityRepository.PlaceComponentResult()));
    }

    public static /* synthetic */ ObservableSource BuiltInFictitiousFunctionClassFactory(FeedInitEntityRepository feedInitEntityRepository, String str) {
        Observable<Boolean> PlaceComponentResult;
        Intrinsics.checkNotNullParameter(feedInitEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        if (str.length() == 0) {
            PlaceComponentResult = Observable.error(new Exception("Phone number is null"));
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        } else {
            PlaceComponentResult = ((SocialPreferencesData) feedInitEntityRepository.initRecordTimeStamp.getValue()).PlaceComponentResult(str);
        }
        return PlaceComponentResult;
    }

    public static /* synthetic */ Boolean PlaceComponentResult(FeedsStatusConfig feedsStatusConfig, FeedInitEntityRepository feedInitEntityRepository) {
        InitStatus initStatus;
        Intrinsics.checkNotNullParameter(feedsStatusConfig, "");
        Intrinsics.checkNotNullParameter(feedInitEntityRepository, "");
        if (feedsStatusConfig.getFeedStatus() != null && feedsStatusConfig.getInitStatus() != null) {
            SocialPreferences socialPreferences = feedInitEntityRepository.NetworkUserEntityData$$ExternalSyntheticLambda1.get();
            Boolean feedStatus = feedsStatusConfig.getFeedStatus();
            Intrinsics.checkNotNull(feedStatus);
            socialPreferences.MyBillsEntityDataFactory.saveData("device_Feed_feature_switch", Boolean.valueOf(feedStatus.booleanValue()));
            SocialPreferences socialPreferences2 = feedInitEntityRepository.NetworkUserEntityData$$ExternalSyntheticLambda1.get();
            String str = (String) ((AccountEntityData) feedInitEntityRepository.moveToNextValue.getValue()).getAccount().map(new FeedInitEntityRepository$$ExternalSyntheticLambda11()).blockingFirst();
            Intrinsics.checkNotNullExpressionValue(str, "");
            String initStatus2 = feedsStatusConfig.getInitStatus();
            Intrinsics.checkNotNull(initStatus2);
            if (Intrinsics.areEqual(initStatus2, InitStatus.INIT.getStatus())) {
                initStatus = InitStatus.INIT;
            } else {
                initStatus = Intrinsics.areEqual(initStatus2, InitStatus.FINISH.getStatus()) ? InitStatus.FINISH : InitStatus.NOT_ACTIVATED;
            }
            socialPreferences2.PlaceComponentResult(str, new FeedInit(0, initStatus, 1, null));
        }
        return Boolean.TRUE;
    }

    public static /* synthetic */ ObservableSource PlaceComponentResult(FeedInitEntityRepository feedInitEntityRepository, FeedsStatusConfig feedsStatusConfig) {
        Intrinsics.checkNotNullParameter(feedInitEntityRepository, "");
        Intrinsics.checkNotNullParameter(feedsStatusConfig, "");
        SocialPreferencesData socialPreferencesData = (SocialPreferencesData) feedInitEntityRepository.initRecordTimeStamp.getValue();
        String str = (String) ((AccountEntityData) feedInitEntityRepository.moveToNextValue.getValue()).getAccount().map(new FeedInitEntityRepository$$ExternalSyntheticLambda11()).blockingFirst();
        Intrinsics.checkNotNullExpressionValue(str, "");
        socialPreferencesData.getErrorConfigVersion(str);
        return Observable.just(feedsStatusConfig);
    }

    public static /* synthetic */ ObservableSource KClassImpl$Data$declaredNonStaticMembers$2(boolean z, final FeedInitEntityRepository feedInitEntityRepository, final FeedsStatusConfig feedsStatusConfig, FeedsStatusConfig feedsStatusConfig2) {
        Observable<Boolean> just;
        Intrinsics.checkNotNullParameter(feedInitEntityRepository, "");
        Intrinsics.checkNotNullParameter(feedsStatusConfig, "");
        Intrinsics.checkNotNullParameter(feedsStatusConfig2, "");
        if (z && feedsStatusConfig2.getInitStatus() != null) {
            just = feedInitEntityRepository.newProxyInstance.get().saveUserSpecificConfigBackendFirst(new FeedsStatusStoreConfig(new FeedsStatusConfig(feedsStatusConfig2.getInitStatus(), feedsStatusConfig2.getFeedStatus()))).onErrorReturnItem(Boolean.TRUE);
        } else if (z || feedsStatusConfig2.getInitStatus() != null) {
            just = Observable.just(Boolean.TRUE);
        } else {
            just = Observable.fromCallable(new Callable() { // from class: id.dana.feeds.data.activation.FeedInitEntityRepository$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return FeedInitEntityRepository.PlaceComponentResult(FeedsStatusConfig.this, feedInitEntityRepository);
                }
            });
            Intrinsics.checkNotNullExpressionValue(just, "");
        }
        return just;
    }

    public static /* synthetic */ String PlaceComponentResult(AccountEntity accountEntity) {
        Intrinsics.checkNotNullParameter(accountEntity, "");
        String phoneNumber = accountEntity.getPhoneNumber();
        return phoneNumber == null ? "" : phoneNumber;
    }

    private final String DatabaseTableConfigUtil() {
        return (String) ((AccountEntityData) this.moveToNextValue.getValue()).getAccount().map(new FeedInitEntityRepository$$ExternalSyntheticLambda11()).blockingFirst();
    }

    @Override // id.dana.feeds.domain.activation.FeedInitRepository
    public final Observable<Boolean> MyBillsEntityDataFactory() {
        Observable<R> map = ((AccountEntityData) this.moveToNextValue.getValue()).getAccount().map(new Function() { // from class: id.dana.feeds.data.activation.FeedInitEntityRepository$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedInitEntityRepository.PlaceComponentResult((AccountEntity) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        Observable<Boolean> flatMap = map.flatMap(new Function() { // from class: id.dana.feeds.data.activation.FeedInitEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedInitEntityRepository.BuiltInFictitiousFunctionClassFactory(FeedInitEntityRepository.this, (String) obj);
            }
        }).flatMap(new Function() { // from class: id.dana.feeds.data.activation.FeedInitEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedInitEntityRepository.MyBillsEntityDataFactory(FeedInitEntityRepository.this, (Boolean) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    @Override // id.dana.feeds.domain.activation.FeedInitRepository
    public final Observable<FeedInit> NetworkUserEntityData$$ExternalSyntheticLambda0() {
        SocialPreferencesData socialPreferencesData = (SocialPreferencesData) this.initRecordTimeStamp.getValue();
        String DatabaseTableConfigUtil = DatabaseTableConfigUtil();
        Intrinsics.checkNotNullExpressionValue(DatabaseTableConfigUtil, "");
        Observable<FeedInit> doOnNext = socialPreferencesData.BuiltInFictitiousFunctionClassFactory(DatabaseTableConfigUtil).doOnNext(new Consumer() { // from class: id.dana.feeds.data.activation.FeedInitEntityRepository$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeedInitEntityRepository.MyBillsEntityDataFactory(FeedInitEntityRepository.this, (FeedInit) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(doOnNext, "");
        return doOnNext;
    }

    @Override // id.dana.feeds.domain.activation.FeedInitRepository
    public final Object BuiltInFictitiousFunctionClassFactory(Continuation<? super InitFeed> continuation) {
        return KClassImpl$Data$declaredNonStaticMembers$2(0, continuation);
    }
}
