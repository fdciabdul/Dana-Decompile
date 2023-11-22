package androidx.paging;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.paging.DataSource;
import androidx.paging.PagedList;
import androidx.paging.RxPagedListBuilder;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.functions.Cancellable;
import java.util.concurrent.Executor;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.rx2.RxSchedulerKt;
import kotlinx.coroutines.rx2.SchedulerCoroutineDispatcher;

@Deprecated(message = "PagedList is deprecated and has been replaced by PagingData")
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001:\u0001$B%\b\u0017\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0011\u0012\u0006\u0010!\u001a\u00020\r¢\u0006\u0004\b\"\u0010#J!\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tR\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\"\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0012R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0015R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0015R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0017R(\u0010\u001f\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001e\u0018\u00010\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 "}, d2 = {"Landroidx/paging/RxPagedListBuilder;", "", "Key", "Value", "Lio/reactivex/BackpressureStrategy;", "p0", "Lio/reactivex/Flowable;", "Landroidx/paging/PagedList;", "BuiltInFictitiousFunctionClassFactory", "(Lio/reactivex/BackpressureStrategy;)Lio/reactivex/Flowable;", "Landroidx/paging/PagedList$BoundaryCallback;", "Landroidx/paging/PagedList$BoundaryCallback;", "MyBillsEntityDataFactory", "Landroidx/paging/PagedList$Config;", "getAuthRequestContext", "Landroidx/paging/PagedList$Config;", "PlaceComponentResult", "Landroidx/paging/DataSource$Factory;", "Landroidx/paging/DataSource$Factory;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlinx/coroutines/rx2/SchedulerCoroutineDispatcher;", "Lkotlinx/coroutines/rx2/SchedulerCoroutineDispatcher;", "Lio/reactivex/Scheduler;", "Lio/reactivex/Scheduler;", "lookAheadTest", "Ljava/lang/Object;", "moveToNextValue", "NetworkUserEntityData$$ExternalSyntheticLambda0", "scheduleImpl", "Lkotlin/Function0;", "Landroidx/paging/PagingSource;", "getErrorConfigVersion", "Lkotlin/jvm/functions/Function0;", "p1", "<init>", "(Landroidx/paging/DataSource$Factory;Landroidx/paging/PagedList$Config;)V", "PagingObservableOnSubscribe"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class RxPagedListBuilder<Key, Value> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private PagedList.BoundaryCallback<Value> MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private Scheduler BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final DataSource.Factory<Key, Value> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private Scheduler scheduleImpl;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private SchedulerCoroutineDispatcher getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final PagedList.Config PlaceComponentResult;
    private final Function0<PagingSource<Key, Value>> getErrorConfigVersion;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private Key moveToNextValue;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private SchedulerCoroutineDispatcher NetworkUserEntityData$$ExternalSyntheticLambda0;

    @Deprecated(message = "PagedList is deprecated and has been replaced by PagingData", replaceWith = @ReplaceWith(expression = "Pager(\n                config = PagingConfig(\n                    config.pageSize,\n                    config.prefetchDistance,\n                    config.enablePlaceholders,\n                    config.initialLoadSizeHint,\n                    config.maxSize\n                ),\n                initialKey = null,\n                pagingSourceFactory = dataSourceFactory.asPagingSourceFactory(Dispatchers.IO)\n            ).flowable", imports = {"androidx.paging.PagingConfig", "androidx.paging.Pager", "androidx.paging.rxjava2.getFlowable", "kotlinx.coroutines.Dispatchers"}))
    public RxPagedListBuilder(DataSource.Factory<Key, Value> factory, PagedList.Config config) {
        Intrinsics.checkNotNullParameter(factory, "");
        Intrinsics.checkNotNullParameter(config, "");
        this.getErrorConfigVersion = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = factory;
        this.PlaceComponentResult = config;
    }

    @Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u0001*\b\b\u0003\u0010\u0003*\u00020\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u00050\u00042\u00020\u0006BS\u0012\b\u0010\u000b\u001a\u0004\u0018\u00018\u0002\u0012\u0006\u0010,\u001a\u00020\u0017\u0012\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u0011\u0012\u0018\u0010.\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030'0\u0014\u0012\u0006\u0010/\u001a\u00020 \u0012\u0006\u00100\u001a\u00020 ¢\u0006\u0004\b1\u00102J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ#\u0010\u000f\u001a\u00020\u00072\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u00050\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u00118\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u00148\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00030\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u001aR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001dR\"\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u00050\u000e8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020 8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010&\u001a\u00020 8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b&\u0010\"R&\u0010!\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030'0\u00148\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b%\u0010\u0015R\u0014\u0010+\u001a\u00020(8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b)\u0010*"}, d2 = {"Landroidx/paging/RxPagedListBuilder$PagingObservableOnSubscribe;", "", "Key", "Value", "Lio/reactivex/ObservableOnSubscribe;", "Landroidx/paging/PagedList;", "Lio/reactivex/functions/Cancellable;", "", "cancel", "()V", "", "p0", "getAuthRequestContext", "(Z)V", "Lio/reactivex/ObservableEmitter;", "subscribe", "(Lio/reactivex/ObservableEmitter;)V", "Landroidx/paging/PagedList$BoundaryCallback;", "PlaceComponentResult", "Landroidx/paging/PagedList$BoundaryCallback;", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/paging/PagedList$Config;", "MyBillsEntityDataFactory", "Landroidx/paging/PagedList$Config;", "Landroidx/paging/PagedList;", "BuiltInFictitiousFunctionClassFactory", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/Job;", "lookAheadTest", "Lio/reactivex/ObservableEmitter;", "Lkotlinx/coroutines/CoroutineDispatcher;", "moveToNextValue", "Lkotlinx/coroutines/CoroutineDispatcher;", "getErrorConfigVersion", "Z", "scheduleImpl", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Landroidx/paging/PagingSource;", "Ljava/lang/Runnable;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Ljava/lang/Runnable;", "GetContactSyncConfig", "p1", "p2", "p3", "p4", "p5", "<init>", "(Ljava/lang/Object;Landroidx/paging/PagedList$Config;Landroidx/paging/PagedList$BoundaryCallback;Lkotlin/jvm/functions/Function0;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class PagingObservableOnSubscribe<Key, Value> implements ObservableOnSubscribe<PagedList<Value>>, Cancellable {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        private Job PlaceComponentResult;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        private PagedList<Value> BuiltInFictitiousFunctionClassFactory;
        private final PagedList.Config MyBillsEntityDataFactory;
        private final CoroutineDispatcher NetworkUserEntityData$$ExternalSyntheticLambda0;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
        private final Runnable GetContactSyncConfig;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        private final PagedList.BoundaryCallback<Value> getAuthRequestContext;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        private final Function0<Unit> KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
        private boolean scheduleImpl;
        private ObservableEmitter<PagedList<Value>> lookAheadTest;

        /* renamed from: moveToNextValue  reason: from kotlin metadata */
        private final CoroutineDispatcher getErrorConfigVersion;

        /* renamed from: scheduleImpl  reason: from kotlin metadata */
        private final Function0<PagingSource<Key, Value>> moveToNextValue;

        /* JADX WARN: Multi-variable type inference failed */
        public PagingObservableOnSubscribe(Key key, PagedList.Config config, PagedList.BoundaryCallback<Value> boundaryCallback, Function0<? extends PagingSource<Key, Value>> function0, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2) {
            Intrinsics.checkNotNullParameter(config, "");
            Intrinsics.checkNotNullParameter(function0, "");
            Intrinsics.checkNotNullParameter(coroutineDispatcher, "");
            Intrinsics.checkNotNullParameter(coroutineDispatcher2, "");
            this.MyBillsEntityDataFactory = config;
            this.getAuthRequestContext = boundaryCallback;
            this.moveToNextValue = function0;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = coroutineDispatcher;
            this.getErrorConfigVersion = coroutineDispatcher2;
            this.scheduleImpl = true;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new Function0<Unit>(this) { // from class: androidx.paging.RxPagedListBuilder$PagingObservableOnSubscribe$callback$1
                final /* synthetic */ RxPagedListBuilder.PagingObservableOnSubscribe<Key, Value> this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    this.this$0.getAuthRequestContext(true);
                }
            };
            Runnable runnable = new Runnable(this) { // from class: androidx.paging.RxPagedListBuilder$PagingObservableOnSubscribe$refreshRetryCallback$1
                final /* synthetic */ RxPagedListBuilder.PagingObservableOnSubscribe<Key, Value> MyBillsEntityDataFactory;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.MyBillsEntityDataFactory = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.MyBillsEntityDataFactory.getAuthRequestContext(true);
                }
            };
            this.GetContactSyncConfig = runnable;
            InitialPagedList initialPagedList = new InitialPagedList(GlobalScope.INSTANCE, coroutineDispatcher, coroutineDispatcher2, config, key);
            this.BuiltInFictitiousFunctionClassFactory = initialPagedList;
            initialPagedList.scheduleImpl = runnable;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<PagedList<Value>> p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            this.lookAheadTest = p0;
            p0.setCancellable(this);
            if (this.scheduleImpl) {
                p0.onNext(this.BuiltInFictitiousFunctionClassFactory);
                this.scheduleImpl = false;
            }
            getAuthRequestContext(false);
        }

        @Override // io.reactivex.functions.Cancellable
        public final void cancel() {
            PagingSource<?, Value> MyBillsEntityDataFactory = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory();
            Function0<Unit> function0 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullParameter(function0, "");
            MyBillsEntityDataFactory.MyBillsEntityDataFactory.MyBillsEntityDataFactory(function0);
        }

        public final void getAuthRequestContext(boolean p0) {
            Job launch$default;
            Job job = this.PlaceComponentResult;
            if (job == null || p0) {
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, null, 1, null);
                }
                launch$default = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, this.getErrorConfigVersion, null, new RxPagedListBuilder$PagingObservableOnSubscribe$invalidate$1(this, null), 2, null);
                this.PlaceComponentResult = launch$default;
            }
        }

        public static final /* synthetic */ void getAuthRequestContext(PagingObservableOnSubscribe pagingObservableOnSubscribe, PagedList pagedList, PagedList pagedList2) {
            pagedList.scheduleImpl = null;
            pagedList2.scheduleImpl = pagingObservableOnSubscribe.GetContactSyncConfig;
        }
    }

    public final Flowable<PagedList<Value>> BuiltInFictitiousFunctionClassFactory(BackpressureStrategy p0) {
        Executor executor;
        Intrinsics.checkNotNullParameter(p0, "");
        ScheduledExecutor scheduledExecutor = this.scheduleImpl;
        if (scheduledExecutor == null) {
            executor = ArchTaskExecutor.getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(executor, "");
            scheduledExecutor = new ScheduledExecutor(executor);
        }
        SchedulerCoroutineDispatcher schedulerCoroutineDispatcher = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (schedulerCoroutineDispatcher == null) {
            schedulerCoroutineDispatcher = RxSchedulerKt.asCoroutineDispatcher(scheduledExecutor);
        }
        ScheduledExecutor scheduledExecutor2 = this.BuiltInFictitiousFunctionClassFactory;
        if (scheduledExecutor2 == null) {
            Executor authRequestContext = ArchTaskExecutor.getAuthRequestContext();
            Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
            scheduledExecutor2 = new ScheduledExecutor(authRequestContext);
        }
        SchedulerCoroutineDispatcher schedulerCoroutineDispatcher2 = this.getAuthRequestContext;
        if (schedulerCoroutineDispatcher2 == null) {
            schedulerCoroutineDispatcher2 = RxSchedulerKt.asCoroutineDispatcher(scheduledExecutor2);
        }
        SuspendingPagingSourceFactory suspendingPagingSourceFactory = this.getErrorConfigVersion;
        if (suspendingPagingSourceFactory == null) {
            final DataSource.Factory<Key, Value> factory = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (factory == null) {
                suspendingPagingSourceFactory = null;
            } else {
                final SchedulerCoroutineDispatcher schedulerCoroutineDispatcher3 = schedulerCoroutineDispatcher2;
                Intrinsics.checkNotNullParameter(schedulerCoroutineDispatcher3, "");
                suspendingPagingSourceFactory = new SuspendingPagingSourceFactory(schedulerCoroutineDispatcher3, new Function0<PagingSource<Key, Value>>() { // from class: androidx.paging.DataSource$Factory$asPagingSourceFactory$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final PagingSource<Key, Value> invoke() {
                        return new LegacyPagingSource(CoroutineDispatcher.this, factory.BuiltInFictitiousFunctionClassFactory());
                    }
                });
            }
        }
        Function0<PagingSource<Key, Value>> function0 = suspendingPagingSourceFactory;
        if (!(function0 != null)) {
            throw new IllegalStateException("RxPagedList cannot be built without a PagingSourceFactory or DataSource.Factory".toString());
        }
        Observable subscribeOn = Observable.create(new PagingObservableOnSubscribe(this.moveToNextValue, this.PlaceComponentResult, this.MyBillsEntityDataFactory, function0, schedulerCoroutineDispatcher, schedulerCoroutineDispatcher2)).observeOn(scheduledExecutor).subscribeOn(scheduledExecutor2);
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "");
        Flowable<PagedList<Value>> flowable = subscribeOn.toFlowable(p0);
        Intrinsics.checkNotNullExpressionValue(flowable, "");
        return flowable;
    }
}
