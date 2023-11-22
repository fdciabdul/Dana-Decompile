package kotlinx.coroutines.sync;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import com.google.common.util.concurrent.Striped$SmallLazyStriped$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u0003\u001a\u00020\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u0002H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\b*\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\nR \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lkotlinx/coroutines/sync/SemaphoreImpl;", "Lkotlinx/coroutines/sync/Semaphore;", "", "acquire", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "acquireSlowPath", "Lkotlinx/coroutines/CancellableContinuation;", "cont", "", "addAcquireToQueue", "(Lkotlinx/coroutines/CancellableContinuation;)Z", "release", "()V", "tryResumeNextFromQueue", "()Z", "tryResumeAcquire", "Lkotlin/Function1;", "", "onCancellationRelease", "Lkotlin/jvm/functions/Function1;", "", "permits", "I", "acquiredPermits", "<init>", "(II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SemaphoreImpl implements Semaphore {
    volatile /* synthetic */ int _availablePermits;
    private volatile /* synthetic */ long deqIdx = 0;
    private volatile /* synthetic */ long enqIdx = 0;
    private volatile /* synthetic */ Object head;
    private final Function1<Throwable, Unit> onCancellationRelease;
    private final int permits;
    private volatile /* synthetic */ Object tail;
    private static final /* synthetic */ AtomicReferenceFieldUpdater head$FU = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "head");
    private static final /* synthetic */ AtomicLongFieldUpdater deqIdx$FU = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "deqIdx");
    private static final /* synthetic */ AtomicReferenceFieldUpdater tail$FU = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "tail");
    private static final /* synthetic */ AtomicLongFieldUpdater enqIdx$FU = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "enqIdx");
    static final /* synthetic */ AtomicIntegerFieldUpdater _availablePermits$FU = AtomicIntegerFieldUpdater.newUpdater(SemaphoreImpl.class, "_availablePermits");

    public SemaphoreImpl(int i, int i2) {
        this.permits = i;
        if (!(i > 0)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Semaphore should have at least 1 permit, but had ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString().toString());
        }
        if (!(i2 >= 0 && i2 <= i)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("The number of acquired permits should be in 0..");
            sb2.append(i);
            throw new IllegalArgumentException(sb2.toString().toString());
        }
        SemaphoreSegment semaphoreSegment = new SemaphoreSegment(0L, null, 2);
        this.head = semaphoreSegment;
        this.tail = semaphoreSegment;
        this._availablePermits = i - i2;
        this.onCancellationRelease = new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.sync.SemaphoreImpl$onCancellationRelease$1
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
                SemaphoreImpl.this.release();
            }
        };
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public final Object acquire(Continuation<? super Unit> continuation) {
        if (_availablePermits$FU.getAndDecrement(this) > 0) {
            return Unit.INSTANCE;
        }
        Object acquireSlowPath = acquireSlowPath(continuation);
        return acquireSlowPath == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? acquireSlowPath : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v6 */
    public final boolean addAcquireToQueue(CancellableContinuation<? super Unit> cont) {
        int i;
        Symbol symbol;
        Symbol symbol2;
        Object m4663constructorimpl;
        SemaphoreSegment createSegment;
        int i2;
        Symbol symbol3;
        Symbol symbol4;
        Symbol symbol5;
        boolean z;
        SemaphoreSegment semaphoreSegment = (SemaphoreSegment) this.tail;
        long andIncrement = enqIdx$FU.getAndIncrement(this);
        i = SemaphoreKt.SEGMENT_SIZE;
        long j = andIncrement / i;
        do {
            SemaphoreSegment semaphoreSegment2 = semaphoreSegment;
            while (true) {
                if (semaphoreSegment2.getId() < j || semaphoreSegment2.getRemoved()) {
                    Object obj = semaphoreSegment2.get_next();
                    symbol = ConcurrentLinkedListKt.CLOSED;
                    if (obj == symbol) {
                        symbol2 = ConcurrentLinkedListKt.CLOSED;
                        m4663constructorimpl = SegmentOrClosed.m4663constructorimpl(symbol2);
                        break;
                    }
                    SemaphoreSegment semaphoreSegment3 = (Segment) ((ConcurrentLinkedListNode) obj);
                    if (semaphoreSegment3 == null) {
                        createSegment = SemaphoreKt.createSegment(semaphoreSegment2.getId() + 1, semaphoreSegment2);
                        semaphoreSegment3 = createSegment;
                        if (semaphoreSegment2.trySetNext(semaphoreSegment3)) {
                            if (semaphoreSegment2.getRemoved()) {
                                semaphoreSegment2.remove();
                            }
                        }
                    }
                    semaphoreSegment2 = semaphoreSegment3;
                } else {
                    m4663constructorimpl = SegmentOrClosed.m4663constructorimpl(semaphoreSegment2);
                    break;
                }
            }
            if (SegmentOrClosed.m4667isClosedimpl(m4663constructorimpl)) {
                break;
            }
            Segment m4665getSegmentimpl = SegmentOrClosed.m4665getSegmentimpl(m4663constructorimpl);
            while (true) {
                Segment segment = (Segment) this.tail;
                if (segment.getId() >= m4665getSegmentimpl.getId()) {
                    break;
                } else if (!m4665getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                    z = false;
                    break;
                } else if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(tail$FU, this, segment, m4665getSegmentimpl)) {
                    if (segment.decPointers$kotlinx_coroutines_core()) {
                        segment.remove();
                    }
                } else if (m4665getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                    m4665getSegmentimpl.remove();
                }
            }
            z = true;
        } while (!z);
        SemaphoreSegment semaphoreSegment4 = (SemaphoreSegment) SegmentOrClosed.m4665getSegmentimpl(m4663constructorimpl);
        i2 = SemaphoreKt.SEGMENT_SIZE;
        int i3 = (int) (andIncrement % i2);
        if (!Striped$SmallLazyStriped$$ExternalSyntheticBackportWithForwarding0.m(semaphoreSegment4.acquirers, i3, null, cont)) {
            symbol3 = SemaphoreKt.PERMIT;
            symbol4 = SemaphoreKt.TAKEN;
            if (Striped$SmallLazyStriped$$ExternalSyntheticBackportWithForwarding0.m(semaphoreSegment4.acquirers, i3, symbol3, symbol4)) {
                cont.resume(Unit.INSTANCE, this.onCancellationRelease);
                return true;
            }
            if (DebugKt.getASSERTIONS_ENABLED()) {
                Object obj2 = semaphoreSegment4.acquirers.get(i3);
                symbol5 = SemaphoreKt.BROKEN;
                if (!(obj2 == symbol5)) {
                    throw new AssertionError();
                }
            }
            return false;
        }
        cont.invokeOnCancellation(new CancelSemaphoreAcquisitionHandler(semaphoreSegment4, i3));
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0072, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean tryResumeNextFromQueue() {
        /*
            Method dump skipped, instructions count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.SemaphoreImpl.tryResumeNextFromQueue():boolean");
    }

    private final boolean tryResumeAcquire(CancellableContinuation<? super Unit> cancellableContinuation) {
        Object tryResume = cancellableContinuation.tryResume(Unit.INSTANCE, null, this.onCancellationRelease);
        if (tryResume == null) {
            return false;
        }
        cancellableContinuation.completeResume(tryResume);
        return true;
    }

    private final Object acquireSlowPath(Continuation<? super Unit> continuation) {
        CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(continuation));
        CancellableContinuationImpl cancellableContinuationImpl = orCreateCancellableContinuation;
        while (true) {
            if (addAcquireToQueue(cancellableContinuationImpl)) {
                break;
            } else if (_availablePermits$FU.getAndDecrement(this) > 0) {
                cancellableContinuationImpl.resume(Unit.INSTANCE, this.onCancellationRelease);
                break;
            }
        }
        Object result = orCreateCancellableContinuation.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public final void release() {
        while (true) {
            int i = this._availablePermits;
            if (!(i < this.permits)) {
                StringBuilder sb = new StringBuilder();
                sb.append("The number of released permits cannot be greater than ");
                sb.append(this.permits);
                throw new IllegalStateException(sb.toString().toString());
            } else if (_availablePermits$FU.compareAndSet(this, i, i + 1) && (i >= 0 || tryResumeNextFromQueue())) {
                return;
            }
        }
    }
}
