package id.dana.analytics.tracker;

import com.fullstory.instrumentation.InstrumentInjector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0011\b\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\u0007\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000b\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/analytics/tracker/EventTrackerQueue;", "", "Lkotlinx/coroutines/CoroutineScope;", "BuiltInFictitiousFunctionClassFactory", "Lkotlinx/coroutines/CoroutineScope;", "getAuthRequestContext", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "PlaceComponentResult", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/util/concurrent/locks/ReentrantLock;", "MyBillsEntityDataFactory", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/CompletableJob;", "getErrorConfigVersion", "Lkotlinx/coroutines/CompletableJob;", "Ljava/util/concurrent/BlockingQueue;", "Lid/dana/analytics/tracker/EventStrategy;", "moveToNextValue", "Ljava/util/concurrent/BlockingQueue;", "Lkotlinx/coroutines/Job;", "scheduleImpl", "Lkotlinx/coroutines/Job;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "", "p0", "<init>", "(I)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EventTrackerQueue {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final TimeUnit KClassImpl$Data$declaredNonStaticMembers$2 = TimeUnit.MILLISECONDS;
    private static EventTrackerQueue getAuthRequestContext;

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final CoroutineScope getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final ReentrantLock PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final CoroutineExceptionHandler KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final CompletableJob MyBillsEntityDataFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final BlockingQueue<EventStrategy> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private Job NetworkUserEntityData$$ExternalSyntheticLambda0;

    public /* synthetic */ EventTrackerQueue(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }

    private EventTrackerQueue(int i) {
        this.BuiltInFictitiousFunctionClassFactory = new ArrayBlockingQueue(i);
        this.PlaceComponentResult = new ReentrantLock();
        CompletableJob Job$default = JobKt.Job$default(null, 1, null);
        this.MyBillsEntityDataFactory = Job$default;
        EventTrackerQueue$special$$inlined$CoroutineExceptionHandler$1 eventTrackerQueue$special$$inlined$CoroutineExceptionHandler$1 = new EventTrackerQueue$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = eventTrackerQueue$special$$inlined$CoroutineExceptionHandler$1;
        this.getAuthRequestContext = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(Job$default).plus(eventTrackerQueue$special$$inlined$CoroutineExceptionHandler$1));
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\nH\u0007J!\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u0012\"\u00020\u0013H\u0007¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lid/dana/analytics/tracker/EventTrackerQueue$Companion;", "", "()V", "DELAY", "", "DELAY_TIMEUNIT", "Ljava/util/concurrent/TimeUnit;", "INSTANCE", "Lid/dana/analytics/tracker/EventTrackerQueue;", "MAX_CAPACITY", "", "TAG", "", "getInstance", "maxCapacityQueue", "track", "", "eventStrategies", "", "Lid/dana/analytics/tracker/EventStrategy;", "([Lid/dana/analytics/tracker/EventStrategy;)V", "core-analytics_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public static EventTrackerQueue BuiltInFictitiousFunctionClassFactory() {
            EventTrackerQueue eventTrackerQueue;
            synchronized (Reflection.getOrCreateKotlinClass(EventTrackerQueue.class)) {
                if (EventTrackerQueue.getAuthRequestContext == null) {
                    Companion companion = EventTrackerQueue.INSTANCE;
                    EventTrackerQueue.getAuthRequestContext = new EventTrackerQueue(100, null);
                }
                eventTrackerQueue = EventTrackerQueue.getAuthRequestContext;
                Intrinsics.checkNotNull(eventTrackerQueue);
            }
            return eventTrackerQueue;
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(final EventTrackerQueue eventTrackerQueue, EventStrategy[] eventStrategyArr) {
        TimeUnit timeUnit = KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullParameter(eventStrategyArr, "");
        Intrinsics.checkNotNullParameter(timeUnit, "");
        CollectionsKt.addAll(eventTrackerQueue.BuiltInFictitiousFunctionClassFactory, eventStrategyArr);
        Runnable runnable = new Runnable() { // from class: id.dana.analytics.tracker.EventTrackerQueue$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                EventTrackerQueue.MyBillsEntityDataFactory(EventTrackerQueue.this);
            }
        };
        ReentrantLock reentrantLock = eventTrackerQueue.PlaceComponentResult;
        reentrantLock.lock();
        try {
            Job job = eventTrackerQueue.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (job != null && job.isActive()) {
                return;
            }
            eventTrackerQueue.NetworkUserEntityData$$ExternalSyntheticLambda0 = BuildersKt.launch$default(eventTrackerQueue.getAuthRequestContext, null, null, new EventTrackerQueue$schedule$1$1(500L, timeUnit, runnable, null), 3, null);
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(EventTrackerQueue eventTrackerQueue) {
        Intrinsics.checkNotNullParameter(eventTrackerQueue, "");
        while (!eventTrackerQueue.BuiltInFictitiousFunctionClassFactory.isEmpty()) {
            try {
                EventStrategy take = eventTrackerQueue.BuiltInFictitiousFunctionClassFactory.take();
                if (take != null) {
                    take.PlaceComponentResult();
                }
            } catch (InterruptedException e) {
                InstrumentInjector.log_d("EventTrackerQueue", e.getMessage(), e);
                return;
            }
        }
    }
}
