package kotlinx.coroutines.sync;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.AtomicDesc;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.AtomicOp;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u00012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00010\u0002:\u0006\u001c\u001d\u001e\u001f !B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\b\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0082@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0007JT\u0010\u000f\u001a\u00020\u0005\"\u0004\b\u0000\u0010\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0006\u0012\u0004\u0018\u00010\u00030\fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0015\u001a\u00020\u00142\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0017\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl;", "Lkotlinx/coroutines/sync/Mutex;", "Lkotlinx/coroutines/selects/SelectClause2;", "", "owner", "", "lock", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lockSuspend", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "block", "registerSelectClause2", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "", "toString", "()Ljava/lang/String;", "", "tryLock", "(Ljava/lang/Object;)Z", "unlock", "(Ljava/lang/Object;)V", "locked", "<init>", "(Z)V", "LockCont", "LockSelect", "LockWaiter", "LockedQueue", "TryLockDesc", "UnlockOp"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MutexImpl implements Mutex, SelectClause2<Object, Mutex> {
    static final /* synthetic */ AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "_state");
    volatile /* synthetic */ Object _state;

    public MutexImpl(boolean z) {
        this._state = z ? MutexKt.EMPTY_LOCKED : MutexKt.EMPTY_UNLOCKED;
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public final Object lock(Object obj, Continuation<? super Unit> continuation) {
        Object lockSuspend;
        return (!tryLock(obj) && (lockSuspend = lockSuspend(obj, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? lockSuspend : Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.selects.SelectClause2
    public final <R> void registerSelectClause2(SelectInstance<? super R> select, Object owner, Function2<? super Mutex, ? super Continuation<? super R>, ? extends Object> block) {
        Symbol symbol;
        Symbol symbol2;
        while (!select.isSelected()) {
            Object obj = this._state;
            if (obj instanceof Empty) {
                Empty empty = (Empty) obj;
                Object obj2 = empty.locked;
                symbol = MutexKt.UNLOCKED;
                if (obj2 != symbol) {
                    AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(_state$FU, this, obj, new LockedQueue(empty.locked));
                } else {
                    Object performAtomicTrySelect = select.performAtomicTrySelect(new TryLockDesc(this, owner));
                    if (performAtomicTrySelect == null) {
                        UndispatchedKt.startCoroutineUnintercepted(block, this, select.getCompletion());
                        return;
                    } else if (performAtomicTrySelect == SelectKt.getALREADY_SELECTED()) {
                        return;
                    } else {
                        symbol2 = MutexKt.LOCK_FAIL;
                        if (performAtomicTrySelect != symbol2 && performAtomicTrySelect != AtomicKt.RETRY_ATOMIC) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("performAtomicTrySelect(TryLockDesc) returned ");
                            sb.append(performAtomicTrySelect);
                            throw new IllegalStateException(sb.toString().toString());
                        }
                    }
                }
            } else if (obj instanceof LockedQueue) {
                LockedQueue lockedQueue = (LockedQueue) obj;
                if (!(lockedQueue.owner != owner)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Already locked by ");
                    sb2.append(owner);
                    throw new IllegalStateException(sb2.toString().toString());
                }
                LockSelect lockSelect = new LockSelect(owner, select, block);
                lockedQueue.addLast(lockSelect);
                if (this._state == obj || !lockSelect.take()) {
                    select.disposeOnSelect(lockSelect);
                    return;
                }
            } else if (!(obj instanceof OpDescriptor)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Illegal state ");
                sb3.append(obj);
                throw new IllegalStateException(sb3.toString().toString());
            } else {
                ((OpDescriptor) obj).perform(this);
            }
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\u0019\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\t\u001a\u0004\u0018\u00010\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$TryLockDesc;", "Lkotlinx/coroutines/internal/AtomicDesc;", "Lkotlinx/coroutines/internal/AtomicOp;", "op", "", "failure", "", "complete", "(Lkotlinx/coroutines/internal/AtomicOp;Ljava/lang/Object;)V", LogConstants.Mpm.EndNodeType.PREPARE, "(Lkotlinx/coroutines/internal/AtomicOp;)Ljava/lang/Object;", "Lkotlinx/coroutines/sync/MutexImpl;", "mutex", "Lkotlinx/coroutines/sync/MutexImpl;", "owner", "Ljava/lang/Object;", "<init>", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;)V", "PrepareOp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    static final class TryLockDesc extends AtomicDesc {
        public final MutexImpl mutex;
        public final Object owner;

        public TryLockDesc(MutexImpl mutexImpl, Object obj) {
            this.mutex = mutexImpl;
            this.owner = obj;
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u001e\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00068\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$TryLockDesc$PrepareOp;", "Lkotlinx/coroutines/internal/OpDescriptor;", "", "affected", "perform", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/AtomicOp;", "atomicOp", "Lkotlinx/coroutines/internal/AtomicOp;", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "<init>", "(Lkotlinx/coroutines/sync/MutexImpl$TryLockDesc;Lkotlinx/coroutines/internal/AtomicOp;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes9.dex */
        final class PrepareOp extends OpDescriptor {
            private final AtomicOp<?> atomicOp;

            public PrepareOp(AtomicOp<?> atomicOp) {
                this.atomicOp = atomicOp;
            }

            @Override // kotlinx.coroutines.internal.OpDescriptor
            @JvmName(name = "getAtomicOp")
            public final AtomicOp<?> getAtomicOp() {
                return this.atomicOp;
            }

            @Override // kotlinx.coroutines.internal.OpDescriptor
            public final Object perform(Object affected) {
                Object atomicOp = getAtomicOp().isDecided() ? MutexKt.EMPTY_UNLOCKED : getAtomicOp();
                if (affected != null) {
                    AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(MutexImpl._state$FU, (MutexImpl) affected, this, atomicOp);
                    return null;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.sync.MutexImpl");
            }
        }

        @Override // kotlinx.coroutines.internal.AtomicDesc
        public final Object prepare(AtomicOp<?> op) {
            Empty empty;
            Symbol symbol;
            PrepareOp prepareOp = new PrepareOp(op);
            MutexImpl mutexImpl = this.mutex;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = MutexImpl._state$FU;
            empty = MutexKt.EMPTY_UNLOCKED;
            if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(atomicReferenceFieldUpdater, mutexImpl, empty, prepareOp)) {
                symbol = MutexKt.LOCK_FAIL;
                return symbol;
            }
            return prepareOp.perform(this.mutex);
        }

        @Override // kotlinx.coroutines.internal.AtomicDesc
        public final void complete(AtomicOp<?> op, Object failure) {
            Empty empty;
            if (failure != null) {
                empty = MutexKt.EMPTY_UNLOCKED;
            } else {
                Object obj = this.owner;
                empty = obj == null ? MutexKt.EMPTY_LOCKED : new Empty(obj);
            }
            AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(MutexImpl._state$FU, this.mutex, op, empty);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "", "toString", "()Ljava/lang/String;", "", "owner", "Ljava/lang/Object;", "<init>", "(Ljava/lang/Object;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class LockedQueue extends LockFreeLinkedListHead {
        public volatile Object owner;

        public LockedQueue(Object obj) {
            this.owner = obj;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("LockedQueue[");
            sb.append(this.owner);
            sb.append(']');
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\b¢\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\tR\u0013\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockWaiter;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/DisposableHandle;", "", "completeResumeLockWaiter", "()V", "dispose", "", "take", "()Z", "tryResumeLockWaiter", "", "owner", "Ljava/lang/Object;", "<init>", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public abstract class LockWaiter extends LockFreeLinkedListNode implements DisposableHandle {
        private static final /* synthetic */ AtomicIntegerFieldUpdater isTaken$FU = AtomicIntegerFieldUpdater.newUpdater(LockWaiter.class, "isTaken");
        private volatile /* synthetic */ int isTaken = 0;
        public final Object owner;

        public abstract void completeResumeLockWaiter();

        public abstract boolean tryResumeLockWaiter();

        public LockWaiter(Object obj) {
            this.owner = obj;
        }

        public final boolean take() {
            return isTaken$FU.compareAndSet(this, 0, 1);
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public final void dispose() {
            mo4660remove();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u001f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\f¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockCont;", "Lkotlinx/coroutines/sync/MutexImpl$LockWaiter;", "Lkotlinx/coroutines/sync/MutexImpl;", "", "completeResumeLockWaiter", "()V", "", "toString", "()Ljava/lang/String;", "", "tryResumeLockWaiter", "()Z", "Lkotlinx/coroutines/CancellableContinuation;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "owner", "<init>", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public final class LockCont extends LockWaiter {
        private final CancellableContinuation<Unit> cont;

        /* JADX WARN: Multi-variable type inference failed */
        public LockCont(Object obj, CancellableContinuation<? super Unit> cancellableContinuation) {
            super(obj);
            this.cont = cancellableContinuation;
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.LockWaiter
        public final boolean tryResumeLockWaiter() {
            if (take()) {
                CancellableContinuation<Unit> cancellableContinuation = this.cont;
                Unit unit = Unit.INSTANCE;
                final MutexImpl mutexImpl = MutexImpl.this;
                return cancellableContinuation.tryResume(unit, null, new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.sync.MutexImpl$LockCont$tryResumeLockWaiter$1
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
                        MutexImpl.this.unlock(this.owner);
                    }
                }) != null;
            }
            return false;
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.LockWaiter
        public final void completeResumeLockWaiter() {
            this.cont.completeResume(CancellableContinuationImplKt.RESUME_TOKEN);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("LockCont[");
            sb.append(this.owner);
            sb.append(", ");
            sb.append(this.cont);
            sb.append("] for ");
            sb.append(MutexImpl.this);
            return sb.toString();
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00060\u0002R\u00020\u0003BF\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0010\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013\u0012\"\u0010\u0011\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\rø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR0\u0010\u0011\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\r8\u0006ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00138\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockSelect;", "R", "Lkotlinx/coroutines/sync/MutexImpl$LockWaiter;", "Lkotlinx/coroutines/sync/MutexImpl;", "", "completeResumeLockWaiter", "()V", "", "toString", "()Ljava/lang/String;", "", "tryResumeLockWaiter", "()Z", "Lkotlin/Function2;", "Lkotlinx/coroutines/sync/Mutex;", "Lkotlin/coroutines/Continuation;", "", "block", "Lkotlin/jvm/functions/Function2;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "owner", "<init>", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    final class LockSelect<R> extends LockWaiter {
        public final Function2<Mutex, Continuation<? super R>, Object> block;
        public final SelectInstance<R> select;

        /* JADX WARN: Multi-variable type inference failed */
        public LockSelect(Object obj, SelectInstance<? super R> selectInstance, Function2<? super Mutex, ? super Continuation<? super R>, ? extends Object> function2) {
            super(obj);
            this.select = selectInstance;
            this.block = function2;
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.LockWaiter
        public final boolean tryResumeLockWaiter() {
            return take() && this.select.trySelect();
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.LockWaiter
        public final void completeResumeLockWaiter() {
            Function2<Mutex, Continuation<? super R>, Object> function2 = this.block;
            MutexImpl mutexImpl = MutexImpl.this;
            Continuation<R> completion = this.select.getCompletion();
            final MutexImpl mutexImpl2 = MutexImpl.this;
            CancellableKt.startCoroutineCancellable(function2, mutexImpl, completion, new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.sync.MutexImpl$LockSelect$completeResumeLockWaiter$1
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
                    MutexImpl.this.unlock(this.owner);
                }
            });
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("LockSelect[");
            sb.append(this.owner);
            sb.append(", ");
            sb.append(this.select);
            sb.append("] for ");
            sb.append(MutexImpl.this);
            return sb.toString();
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$UnlockOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "Lkotlinx/coroutines/sync/MutexImpl;", "affected", "", "failure", "", "complete", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;)V", LogConstants.Mpm.EndNodeType.PREPARE, "(Lkotlinx/coroutines/sync/MutexImpl;)Ljava/lang/Object;", "Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;", SemanticAttributes.MessagingDestinationKindValues.QUEUE, "Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;", "<init>", "(Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    static final class UnlockOp extends AtomicOp<MutexImpl> {
        public final LockedQueue queue;

        public UnlockOp(LockedQueue lockedQueue) {
            this.queue = lockedQueue;
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        public final Object prepare(MutexImpl affected) {
            Symbol symbol;
            if (this.queue.isEmpty()) {
                return null;
            }
            symbol = MutexKt.UNLOCK_FAIL;
            return symbol;
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        public final void complete(MutexImpl affected, Object failure) {
            AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(MutexImpl._state$FU, affected, this, failure == null ? MutexKt.EMPTY_UNLOCKED : this.queue);
        }
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public final boolean tryLock(Object owner) {
        Symbol symbol;
        while (true) {
            Object obj = this._state;
            if (obj instanceof Empty) {
                Object obj2 = ((Empty) obj).locked;
                symbol = MutexKt.UNLOCKED;
                if (obj2 != symbol) {
                    return false;
                }
                if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(_state$FU, this, obj, owner == null ? MutexKt.EMPTY_LOCKED : new Empty(owner))) {
                    return true;
                }
            } else if (obj instanceof LockedQueue) {
                if (((LockedQueue) obj).owner != owner) {
                    return false;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Already locked by ");
                sb.append(owner);
                throw new IllegalStateException(sb.toString().toString());
            } else if (!(obj instanceof OpDescriptor)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Illegal state ");
                sb2.append(obj);
                throw new IllegalStateException(sb2.toString().toString());
            } else {
                ((OpDescriptor) obj).perform(this);
            }
        }
    }

    private final Object lockSuspend(final Object obj, Continuation<? super Unit> continuation) {
        Symbol symbol;
        LockCont lockCont;
        CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(continuation));
        CancellableContinuationImpl cancellableContinuationImpl = orCreateCancellableContinuation;
        LockCont lockCont2 = new LockCont(obj, cancellableContinuationImpl);
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof Empty) {
                Empty empty = (Empty) obj2;
                Object obj3 = empty.locked;
                symbol = MutexKt.UNLOCKED;
                if (obj3 != symbol) {
                    AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(_state$FU, this, obj2, new LockedQueue(empty.locked));
                } else {
                    if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(_state$FU, this, obj2, obj == null ? MutexKt.EMPTY_LOCKED : new Empty(obj))) {
                        cancellableContinuationImpl.resume(Unit.INSTANCE, new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.sync.MutexImpl$lockSuspend$2$1$1
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
                                MutexImpl.this.unlock(obj);
                            }
                        });
                        break;
                    }
                }
            } else if (obj2 instanceof LockedQueue) {
                LockedQueue lockedQueue = (LockedQueue) obj2;
                if (!(lockedQueue.owner != obj)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Already locked by ");
                    sb.append(obj);
                    throw new IllegalStateException(sb.toString().toString());
                }
                lockCont = lockCont2;
                lockedQueue.addLast(lockCont);
                if (this._state == obj2 || !lockCont2.take()) {
                    break;
                }
                lockCont2 = new LockCont(obj, cancellableContinuationImpl);
            } else if (!(obj2 instanceof OpDescriptor)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Illegal state ");
                sb2.append(obj2);
                throw new IllegalStateException(sb2.toString().toString());
            } else {
                ((OpDescriptor) obj2).perform(this);
            }
        }
        CancellableContinuationKt.removeOnCancellation(cancellableContinuationImpl, lockCont);
        Object result = orCreateCancellableContinuation.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public final void unlock(Object owner) {
        Empty empty;
        Symbol symbol;
        while (true) {
            Object obj = this._state;
            if (obj instanceof Empty) {
                if (owner == null) {
                    Object obj2 = ((Empty) obj).locked;
                    symbol = MutexKt.UNLOCKED;
                    if (!(obj2 != symbol)) {
                        throw new IllegalStateException("Mutex is not locked".toString());
                    }
                } else {
                    Empty empty2 = (Empty) obj;
                    if (!(empty2.locked == owner)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Mutex is locked by ");
                        sb.append(empty2.locked);
                        sb.append(" but expected ");
                        sb.append(owner);
                        throw new IllegalStateException(sb.toString().toString());
                    }
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
                empty = MutexKt.EMPTY_UNLOCKED;
                if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(atomicReferenceFieldUpdater, this, obj, empty)) {
                    return;
                }
            } else if (obj instanceof OpDescriptor) {
                ((OpDescriptor) obj).perform(this);
            } else if (obj instanceof LockedQueue) {
                if (owner != null) {
                    LockedQueue lockedQueue = (LockedQueue) obj;
                    if (!(lockedQueue.owner == owner)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Mutex is locked by ");
                        sb2.append(lockedQueue.owner);
                        sb2.append(" but expected ");
                        sb2.append(owner);
                        throw new IllegalStateException(sb2.toString().toString());
                    }
                }
                LockedQueue lockedQueue2 = (LockedQueue) obj;
                LockFreeLinkedListNode removeFirstOrNull = lockedQueue2.removeFirstOrNull();
                if (removeFirstOrNull == null) {
                    UnlockOp unlockOp = new UnlockOp(lockedQueue2);
                    if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(_state$FU, this, obj, unlockOp) && unlockOp.perform(this) == null) {
                        return;
                    }
                } else {
                    LockWaiter lockWaiter = (LockWaiter) removeFirstOrNull;
                    if (lockWaiter.tryResumeLockWaiter()) {
                        Object obj3 = lockWaiter.owner;
                        if (obj3 == null) {
                            obj3 = MutexKt.LOCKED;
                        }
                        lockedQueue2.owner = obj3;
                        lockWaiter.completeResumeLockWaiter();
                        return;
                    }
                }
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Illegal state ");
                sb3.append(obj);
                throw new IllegalStateException(sb3.toString().toString());
            }
        }
    }

    public final String toString() {
        while (true) {
            Object obj = this._state;
            if (obj instanceof Empty) {
                StringBuilder sb = new StringBuilder();
                sb.append("Mutex[");
                sb.append(((Empty) obj).locked);
                sb.append(']');
                return sb.toString();
            } else if (!(obj instanceof OpDescriptor)) {
                if (!(obj instanceof LockedQueue)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Illegal state ");
                    sb2.append(obj);
                    throw new IllegalStateException(sb2.toString().toString());
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Mutex[");
                sb3.append(((LockedQueue) obj).owner);
                sb3.append(']');
                return sb3.toString();
            } else {
                ((OpDescriptor) obj).perform(this);
            }
        }
    }
}
