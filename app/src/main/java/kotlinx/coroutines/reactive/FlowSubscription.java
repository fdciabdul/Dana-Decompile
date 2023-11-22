package kotlinx.coroutines.reactive;

import com.ap.zoloz.hummer.biz.HummerConstants;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.LongCompanionObject;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.intrinsics.CancellableKt;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B-\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012\u000e\u0010\u0018\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u0007\u001a\u00020\u0004H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\f\u001a\u00020\u0004H\u0082@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\bJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00148\u0006¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0018\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00178\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lkotlinx/coroutines/reactive/FlowSubscription;", "T", "Lorg/reactivestreams/Subscription;", "Lkotlinx/coroutines/AbstractCoroutine;", "", "cancel", "()V", "consumeFlow", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/Continuation;", "createInitialContinuation", "()Lkotlin/coroutines/Continuation;", "flowProcessing", "", "n", "request", "(J)V", "", "cancellationRequested", "Z", "Lkotlinx/coroutines/flow/Flow;", "flow", "Lkotlinx/coroutines/flow/Flow;", "Lorg/reactivestreams/Subscriber;", "subscriber", "Lorg/reactivestreams/Subscriber;", "Lkotlin/coroutines/CoroutineContext;", HummerConstants.CONTEXT, "<init>", "(Lkotlinx/coroutines/flow/Flow;Lorg/reactivestreams/Subscriber;Lkotlin/coroutines/CoroutineContext;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class FlowSubscription<T> extends AbstractCoroutine<Unit> implements Subscription {
    private volatile boolean cancellationRequested;
    public final Flow<T> flow;
    volatile /* synthetic */ Object producer;
    volatile /* synthetic */ long requested;
    public final Subscriber<? super T> subscriber;
    static final /* synthetic */ AtomicLongFieldUpdater requested$FU = AtomicLongFieldUpdater.newUpdater(FlowSubscription.class, "requested");
    static final /* synthetic */ AtomicReferenceFieldUpdater producer$FU = AtomicReferenceFieldUpdater.newUpdater(FlowSubscription.class, Object.class, "producer");

    /* JADX WARN: Multi-variable type inference failed */
    public FlowSubscription(Flow<? extends T> flow, Subscriber<? super T> subscriber, CoroutineContext coroutineContext) {
        super(coroutineContext, false, true);
        this.flow = flow;
        this.subscriber = subscriber;
        this.requested = 0L;
        this.producer = createInitialContinuation();
    }

    private final Continuation<Unit> createInitialContinuation() {
        final CoroutineContext placeComponentResult = getPlaceComponentResult();
        return new Continuation<Unit>() { // from class: kotlinx.coroutines.reactive.FlowSubscription$createInitialContinuation$$inlined$Continuation$1
            @Override // kotlin.coroutines.Continuation
            @JvmName(name = "getContext")
            /* renamed from: getContext  reason: from getter */
            public final CoroutineContext get$context() {
                return CoroutineContext.this;
            }

            @Override // kotlin.coroutines.Continuation
            public final void resumeWith(Object result) {
                CancellableKt.startCoroutineCancellable(new FlowSubscription$createInitialContinuation$1$1(this), this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(2:3|(7:5|6|(1:(3:9|10|11)(2:39|40))(4:41|42|43|(1:45)(1:46))|12|13|14|15))|50|6|(0)(0)|12|13|14|15|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004d, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004e, code lost:
    
        kotlinx.coroutines.CoroutineExceptionHandlerKt.handleCoroutineException(r0.getPlaceComponentResult(), r5);
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object flowProcessing(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof kotlinx.coroutines.reactive.FlowSubscription$flowProcessing$1
            if (r0 == 0) goto L14
            r0 = r5
            kotlinx.coroutines.reactive.FlowSubscription$flowProcessing$1 r0 = (kotlinx.coroutines.reactive.FlowSubscription$flowProcessing$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 + r2
            r0.label = r5
            goto L19
        L14:
            kotlinx.coroutines.reactive.FlowSubscription$flowProcessing$1 r0 = new kotlinx.coroutines.reactive.FlowSubscription$flowProcessing$1
            r0.<init>(r4, r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.reactive.FlowSubscription r0 = (kotlinx.coroutines.reactive.FlowSubscription) r0
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Throwable -> L2e
            goto L47
        L2e:
            r5 = move-exception
            goto L5a
        L30:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L38:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L58
            r0.label = r3     // Catch: java.lang.Throwable -> L58
            java.lang.Object r5 = r4.consumeFlow(r0)     // Catch: java.lang.Throwable -> L58
            if (r5 != r1) goto L46
            return r1
        L46:
            r0 = r4
        L47:
            org.reactivestreams.Subscriber<? super T> r5 = r0.subscriber     // Catch: java.lang.Throwable -> L4d
            r5.onComplete()     // Catch: java.lang.Throwable -> L4d
            goto L55
        L4d:
            r5 = move-exception
            kotlin.coroutines.CoroutineContext r0 = r0.getPlaceComponentResult()
            kotlinx.coroutines.CoroutineExceptionHandlerKt.handleCoroutineException(r0, r5)
        L55:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L58:
            r5 = move-exception
            r0 = r4
        L5a:
            boolean r1 = kotlinx.coroutines.DebugKt.getRECOVER_STACK_TRACES()
            if (r1 != 0) goto L62
            r1 = r5
            goto L66
        L62:
            java.lang.Throwable r1 = kotlinx.coroutines.internal.StackTraceRecoveryKt.unwrapImpl(r5)
        L66:
            boolean r2 = r0.cancellationRequested
            if (r2 == 0) goto L76
            boolean r2 = r0.isActive()
            if (r2 != 0) goto L76
            java.util.concurrent.CancellationException r2 = r0.getCancellationException()
            if (r1 == r2) goto L87
        L76:
            org.reactivestreams.Subscriber<? super T> r1 = r0.subscriber     // Catch: java.lang.Throwable -> L7c
            r1.onError(r5)     // Catch: java.lang.Throwable -> L7c
            goto L87
        L7c:
            r1 = move-exception
            kotlin.ExceptionsKt.addSuppressed(r5, r1)
            kotlin.coroutines.CoroutineContext r0 = r0.getPlaceComponentResult()
            kotlinx.coroutines.CoroutineExceptionHandlerKt.handleCoroutineException(r0, r5)
        L87:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.reactive.FlowSubscription.flowProcessing(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Object consumeFlow(Continuation<? super Unit> continuation) {
        Object collect = this.flow.collect(new FlowCollector(this) { // from class: kotlinx.coroutines.reactive.FlowSubscription$consumeFlow$2
            final /* synthetic */ FlowSubscription<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.this$0 = this;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(T t, Continuation<? super Unit> continuation2) {
                this.this$0.subscriber.onNext(t);
                if (FlowSubscription.requested$FU.decrementAndGet(this.this$0) <= 0) {
                    FlowSubscription<T> flowSubscription = this.this$0;
                    CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation2), 1);
                    cancellableContinuationImpl.initCancellability();
                    flowSubscription.producer = cancellableContinuationImpl;
                    Object result = cancellableContinuationImpl.getResult();
                    if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(continuation2);
                    }
                    return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
                }
                JobKt.ensureActive(this.this$0.getPlaceComponentResult());
                return Unit.INSTANCE;
            }
        }, continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void cancel() {
        this.cancellationRequested = true;
        cancel(null);
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long n) {
        long j;
        long j2;
        Continuation continuation;
        if (n <= 0) {
            return;
        }
        do {
            j = this.requested;
            j2 = j + n;
            if (j2 <= 0) {
                j2 = LongCompanionObject.MAX_VALUE;
            }
        } while (!requested$FU.compareAndSet(this, j, j2));
        if (j > 0) {
            return;
        }
        do {
            continuation = (Continuation) producer$FU.getAndSet(this, null);
        } while (continuation == null);
        Result.Companion companion = Result.INSTANCE;
        continuation.resumeWith(Result.m3179constructorimpl(Unit.INSTANCE));
    }
}
