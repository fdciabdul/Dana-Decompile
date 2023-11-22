package kotlinx.coroutines;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.ocr.model.SnapReceiptBroadcastData;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0010\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\u00060\u0004j\u0002`\u0005B\u001d\u0012\f\u0010p\u001a\b\u0012\u0004\u0012\u00028\u00000o\u0012\u0006\u0010N\u001a\u00020%¢\u0006\u0004\b{\u0010|J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0010\u0010\u0011J8\u0010\u0010\u001a\u00020\u000f2\u001d\u0010\f\u001a\u0019\u0012\u000b\u0012\t\u0018\u00010\r¢\u0006\u0002\b\u0013\u0012\u0004\u0012\u00020\u000f0\u0012j\u0002`\u00142\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0015J0\u0010\u0017\u001a\u00020\u000f2\u0019\u0010\u0016\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\r¢\u0006\u0002\b\u0013\u0012\u0004\u0012\u00020\u000f0\u00122\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0017\u0010\u0015J\u0019\u0010\u0019\u001a\u00020\u00182\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001c\u001a\u00020\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0010¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001e\u0010\u001aJ\u0017\u0010 \u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u000fH\u0002¢\u0006\u0004\b$\u0010#J\u0017\u0010'\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\r2\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b+\u0010,J\u001b\u0010.\u001a\u0004\u0018\u00010\r2\b\u0010-\u001a\u0004\u0018\u00010\u0006H\u0010¢\u0006\u0004\b.\u0010/J\u0011\u00100\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0004\b0\u00101J\u0017\u00104\u001a\n\u0018\u000102j\u0004\u0018\u0001`3H\u0016¢\u0006\u0004\b4\u00105J\u001f\u00106\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010-\u001a\u0004\u0018\u00010\u0006H\u0010¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\u000fH\u0016¢\u0006\u0004\b8\u0010#J\u0011\u0010:\u001a\u0004\u0018\u000109H\u0002¢\u0006\u0004\b:\u0010;J.\u0010<\u001a\u00020\u000f2\u001d\u0010\f\u001a\u0019\u0012\u000b\u0012\t\u0018\u00010\r¢\u0006\u0002\b\u0013\u0012\u0004\u0012\u00020\u000f0\u0012j\u0002`\u0014H\u0016¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\u0018H\u0002¢\u0006\u0004\b>\u0010?J.\u0010@\u001a\u00020\u000b2\u001d\u0010\f\u001a\u0019\u0012\u000b\u0012\t\u0018\u00010\r¢\u0006\u0002\b\u0013\u0012\u0004\u0012\u00020\u000f0\u0012j\u0002`\u0014H\u0002¢\u0006\u0004\b@\u0010AJ8\u0010B\u001a\u00020\u000f2\u001d\u0010\f\u001a\u0019\u0012\u000b\u0012\t\u0018\u00010\r¢\u0006\u0002\b\u0013\u0012\u0004\u0012\u00020\u000f0\u0012j\u0002`\u00142\b\u0010-\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\bB\u0010CJ\u000f\u0010E\u001a\u00020DH\u0014¢\u0006\u0004\bE\u0010FJ\u0017\u0010G\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\bG\u0010HJ\u000f\u0010I\u001a\u00020\u000fH\u0002¢\u0006\u0004\bI\u0010#J\u000f\u0010J\u001a\u00020\u0018H\u0000¢\u0006\u0004\bJ\u0010?J4\u0010L\u001a\u00020\u000f2\u0006\u0010K\u001a\u00028\u00002\u001b\u0010\u0016\u001a\u0017\u0012\u000b\u0012\t\u0018\u00010\r¢\u0006\u0002\b\u0013\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0012H\u0016¢\u0006\u0004\bL\u0010MJ@\u0010O\u001a\u00020\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010N\u001a\u00020%2\u001d\b\u0002\u0010\u0016\u001a\u0017\u0012\u000b\u0012\t\u0018\u00010\r¢\u0006\u0002\b\u0013\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0012H\u0002¢\u0006\u0004\bO\u0010PJ \u0010S\u001a\u00020\u000f2\f\u0010R\u001a\b\u0012\u0004\u0012\u00028\u00000QH\u0016ø\u0001\u0000¢\u0006\u0004\bS\u0010!JR\u0010V\u001a\u0004\u0018\u00010\u00062\u0006\u0010-\u001a\u00020T2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010N\u001a\u00020%2\u001b\u0010\u0016\u001a\u0017\u0012\u000b\u0012\t\u0018\u00010\r¢\u0006\u0002\b\u0013\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00122\b\u0010U\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\bV\u0010WJ\u0011\u0010X\u001a\u0004\u0018\u00010\u0006H\u0010¢\u0006\u0004\bX\u00101J\u000f\u0010Y\u001a\u00020DH\u0016¢\u0006\u0004\bY\u0010FJ\u000f\u0010Z\u001a\u00020\u0018H\u0002¢\u0006\u0004\bZ\u0010?J#\u0010Z\u001a\u0004\u0018\u00010\u00062\u0006\u0010K\u001a\u00028\u00002\b\u0010U\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\bZ\u0010[J@\u0010Z\u001a\u0004\u0018\u00010\u00062\u0006\u0010K\u001a\u00028\u00002\b\u0010U\u001a\u0004\u0018\u00010\u00062\u001b\u0010\u0016\u001a\u0017\u0012\u000b\u0012\t\u0018\u00010\r¢\u0006\u0002\b\u0013\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0012H\u0016¢\u0006\u0004\bZ\u0010\\JB\u0010^\u001a\u0004\u0018\u00010]2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010U\u001a\u0004\u0018\u00010\u00062\u001b\u0010\u0016\u001a\u0017\u0012\u000b\u0012\t\u0018\u00010\r¢\u0006\u0002\b\u0013\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0012H\u0002¢\u0006\u0004\b^\u0010_J\u0019\u0010a\u001a\u0004\u0018\u00010\u00062\u0006\u0010`\u001a\u00020\rH\u0016¢\u0006\u0004\ba\u0010bJ\u000f\u0010c\u001a\u00020\u0018H\u0002¢\u0006\u0004\bc\u0010?J\u001b\u0010e\u001a\u00020\u000f*\u00020d2\u0006\u0010K\u001a\u00028\u0000H\u0016¢\u0006\u0004\be\u0010fR\u001c\u0010i\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058WX\u0096\u0004¢\u0006\u0006\u001a\u0004\bg\u0010hR\u001a\u0010k\u001a\u00020j8\u0017X\u0097\u0004¢\u0006\f\n\u0004\bk\u0010l\u001a\u0004\bm\u0010nR \u0010p\u001a\b\u0012\u0004\u0012\u00028\u00000o8\u0001X\u0081\u0004¢\u0006\f\n\u0004\bp\u0010q\u001a\u0004\br\u0010sR\u0014\u0010t\u001a\u00020\u00188WX\u0096\u0004¢\u0006\u0006\u001a\u0004\bt\u0010?R\u0014\u0010u\u001a\u00020\u00188WX\u0096\u0004¢\u0006\u0006\u001a\u0004\bu\u0010?R\u0018\u0010v\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bv\u0010wR\u0016\u0010-\u001a\u0004\u0018\u00010\u00068AX\u0080\u0004¢\u0006\u0006\u001a\u0004\bx\u00101R\u0014\u0010z\u001a\u00020D8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\by\u0010F\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lkotlinx/coroutines/CancellableContinuationImpl;", "T", "Lkotlinx/coroutines/DispatchedTask;", "Lkotlinx/coroutines/CancellableContinuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "", "proposedUpdate", "", "alreadyResumedError", "(Ljava/lang/Object;)Ljava/lang/Void;", "Lkotlinx/coroutines/CancelHandler;", "handler", "", "cause", "", "callCancelHandler", "(Lkotlinx/coroutines/CancelHandler;Ljava/lang/Throwable;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "Lkotlinx/coroutines/CompletionHandler;", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Throwable;)V", "onCancellation", "callOnCancellation", "", "cancel", "(Ljava/lang/Throwable;)Z", "takenState", "cancelCompletedResult$kotlinx_coroutines_core", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "cancelLater", "token", "completeResume", "(Ljava/lang/Object;)V", "detachChild$kotlinx_coroutines_core", "()V", "detachChildIfNonResuable", "", "mode", "dispatchResume", "(I)V", "Lkotlinx/coroutines/Job;", "parent", "getContinuationCancellationCause", "(Lkotlinx/coroutines/Job;)Ljava/lang/Throwable;", "state", "getExceptionalResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "getResult", "()Ljava/lang/Object;", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "initCancellability", "Lkotlinx/coroutines/DisposableHandle;", "installParentHandle", "()Lkotlinx/coroutines/DisposableHandle;", "invokeOnCancellation", "(Lkotlin/jvm/functions/Function1;)V", "isReusable", "()Z", "makeCancelHandler", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/CancelHandler;", "multipleHandlersError", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V", "", "nameString", "()Ljava/lang/String;", "parentCancelled$kotlinx_coroutines_core", "(Ljava/lang/Throwable;)V", "releaseClaimedReusableContinuation", "resetStateReusable", "value", "resume", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "resumeMode", "resumeImpl", "(Ljava/lang/Object;ILkotlin/jvm/functions/Function1;)V", "Lkotlin/Result;", "result", "resumeWith", "Lkotlinx/coroutines/NotCompleted;", "idempotent", "resumedState", "(Lkotlinx/coroutines/NotCompleted;Ljava/lang/Object;ILkotlin/jvm/functions/Function1;Ljava/lang/Object;)Ljava/lang/Object;", "takeState$kotlinx_coroutines_core", "toString", "tryResume", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/Symbol;", "tryResumeImpl", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/internal/Symbol;", "exception", "tryResumeWithException", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "trySuspend", "Lkotlinx/coroutines/CoroutineDispatcher;", "resumeUndispatched", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "Lkotlin/coroutines/CoroutineContext;", HummerConstants.CONTEXT, "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/Continuation;", "delegate", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "isActive", "isCompleted", "parentHandle", "Lkotlinx/coroutines/DisposableHandle;", "getState$kotlinx_coroutines_core", "getStateDebugRepresentation", "stateDebugRepresentation", "<init>", "(Lkotlin/coroutines/Continuation;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public class CancellableContinuationImpl<T> extends DispatchedTask<T> implements CancellableContinuation<T>, CoroutineStackFrame {
    private static final /* synthetic */ AtomicIntegerFieldUpdater _decision$FU = AtomicIntegerFieldUpdater.newUpdater(CancellableContinuationImpl.class, "_decision");
    private static final /* synthetic */ AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuationImpl.class, Object.class, "_state");
    private volatile /* synthetic */ int _decision;
    private volatile /* synthetic */ Object _state;
    private final CoroutineContext context;
    private final Continuation<T> delegate;
    private DisposableHandle parentHandle;

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    protected String nameString() {
        return "CancellableContinuation";
    }

    @Override // kotlinx.coroutines.DispatchedTask
    @JvmName(name = "getDelegate$kotlinx_coroutines_core")
    public final Continuation<T> getDelegate$kotlinx_coroutines_core() {
        return this.delegate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CancellableContinuationImpl(Continuation<? super T> continuation, int i) {
        super(i);
        this.delegate = continuation;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(i != -1)) {
                throw new AssertionError();
            }
        }
        this.context = continuation.getContext();
        this._decision = 0;
        this._state = Active.INSTANCE;
    }

    @Override // kotlin.coroutines.Continuation
    @JvmName(name = "getContext")
    public CoroutineContext getContext() {
        return this.context;
    }

    @JvmName(name = "getState$kotlinx_coroutines_core")
    /* renamed from: getState$kotlinx_coroutines_core  reason: from getter */
    public final Object get_state() {
        return this._state;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    @JvmName(name = "isActive")
    public boolean isActive() {
        return get_state() instanceof NotCompleted;
    }

    @JvmName(name = "isCompleted")
    public boolean isCompleted() {
        return !(get_state() instanceof NotCompleted);
    }

    @JvmName(name = "getStateDebugRepresentation")
    private final String getStateDebugRepresentation() {
        Object obj = get_state();
        return obj instanceof NotCompleted ? "Active" : obj instanceof CancelledContinuation ? "Cancelled" : SnapReceiptBroadcastData.Status.Completed;
    }

    public void initCancellability() {
        DisposableHandle installParentHandle = installParentHandle();
        if (installParentHandle != null && isCompleted()) {
            installParentHandle.dispose();
            this.parentHandle = NonDisposableHandle.INSTANCE;
        }
    }

    private final boolean isReusable() {
        return DispatchedTaskKt.isReusableMode(this.resumeMode) && ((DispatchedContinuation) this.delegate).isReusable();
    }

    public final boolean resetStateReusable() {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(this.resumeMode == 2)) {
                throw new AssertionError();
            }
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(this.parentHandle != NonDisposableHandle.INSTANCE)) {
                throw new AssertionError();
            }
        }
        Object obj = this._state;
        if (!DebugKt.getASSERTIONS_ENABLED() || (!(obj instanceof NotCompleted)) == true) {
            if ((obj instanceof CompletedContinuation) && ((CompletedContinuation) obj).idempotentResume != null) {
                detachChild$kotlinx_coroutines_core();
                return false;
            }
            this._decision = 0;
            this._state = Active.INSTANCE;
            return true;
        }
        throw new AssertionError();
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @JvmName(name = "getCallerFrame")
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.delegate;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Object takeState$kotlinx_coroutines_core() {
        return get_state();
    }

    private final boolean cancelLater(Throwable cause) {
        if (isReusable()) {
            return ((DispatchedContinuation) this.delegate).postponeCancellation(cause);
        }
        return false;
    }

    public final void parentCancelled$kotlinx_coroutines_core(Throwable cause) {
        if (cancelLater(cause)) {
            return;
        }
        cancel(cause);
        detachChildIfNonResuable();
    }

    public final void callCancelHandler(CancelHandler handler, Throwable cause) {
        try {
            handler.invoke(cause);
        } catch (Throwable th) {
            CoroutineContext context = getContext();
            StringBuilder sb = new StringBuilder();
            sb.append("Exception in invokeOnCancellation handler for ");
            sb.append(this);
            CoroutineExceptionHandlerKt.handleCoroutineException(context, new CompletionHandlerException(sb.toString(), th));
        }
    }

    public final void callOnCancellation(Function1<? super Throwable, Unit> onCancellation, Throwable cause) {
        try {
            onCancellation.invoke(cause);
        } catch (Throwable th) {
            CoroutineContext context = getContext();
            StringBuilder sb = new StringBuilder();
            sb.append("Exception in resume onCancellation handler for ");
            sb.append(this);
            CoroutineExceptionHandlerKt.handleCoroutineException(context, new CompletionHandlerException(sb.toString(), th));
        }
    }

    public Throwable getContinuationCancellationCause(Job parent) {
        return parent.getCancellationException();
    }

    public final Object getResult() {
        Job job;
        Throwable recoverFromStackFrame;
        Throwable recoverFromStackFrame2;
        boolean isReusable = isReusable();
        if (trySuspend()) {
            if (this.parentHandle == null) {
                installParentHandle();
            }
            if (isReusable) {
                releaseClaimedReusableContinuation();
            }
            return IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        if (isReusable) {
            releaseClaimedReusableContinuation();
        }
        Object obj = get_state();
        if (!(obj instanceof CompletedExceptionally)) {
            if (DispatchedTaskKt.isCancellableMode(this.resumeMode) && (job = (Job) getContext().get(Job.INSTANCE)) != null && !job.isActive()) {
                CancellationException cancellationException = job.getCancellationException();
                cancelCompletedResult$kotlinx_coroutines_core(obj, cancellationException);
                if (DebugKt.getRECOVER_STACK_TRACES()) {
                    recoverFromStackFrame = StackTraceRecoveryKt.recoverFromStackFrame(cancellationException, this);
                    throw recoverFromStackFrame;
                }
                throw cancellationException;
            }
            return getSuccessfulResult$kotlinx_coroutines_core(obj);
        }
        Throwable th = ((CompletedExceptionally) obj).cause;
        if (DebugKt.getRECOVER_STACK_TRACES()) {
            recoverFromStackFrame2 = StackTraceRecoveryKt.recoverFromStackFrame(th, this);
            throw recoverFromStackFrame2;
        }
        throw th;
    }

    private final DisposableHandle installParentHandle() {
        Job job = (Job) getContext().get(Job.INSTANCE);
        if (job == null) {
            return null;
        }
        DisposableHandle invokeOnCompletion$default = Job.DefaultImpls.invokeOnCompletion$default(job, true, false, new ChildContinuation(this), 2, null);
        this.parentHandle = invokeOnCompletion$default;
        return invokeOnCompletion$default;
    }

    private final void releaseClaimedReusableContinuation() {
        Throwable tryReleaseClaimedContinuation;
        Continuation<T> continuation = this.delegate;
        DispatchedContinuation dispatchedContinuation = continuation instanceof DispatchedContinuation ? (DispatchedContinuation) continuation : null;
        if (dispatchedContinuation == null || (tryReleaseClaimedContinuation = dispatchedContinuation.tryReleaseClaimedContinuation(this)) == null) {
            return;
        }
        detachChild$kotlinx_coroutines_core();
        cancel(tryReleaseClaimedContinuation);
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object result) {
        resumeImpl$default(this, CompletionStateKt.toState(result, this), this.resumeMode, null, 4, null);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void resume(T value, Function1<? super Throwable, Unit> onCancellation) {
        resumeImpl(value, this.resumeMode, onCancellation);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void invokeOnCancellation(Function1<? super Throwable, Unit> handler) {
        CancelHandler makeCancelHandler = makeCancelHandler(handler);
        while (true) {
            Object obj = this._state;
            if (obj instanceof Active) {
                if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(_state$FU, this, obj, makeCancelHandler)) {
                    return;
                }
            } else if (obj instanceof CancelHandler) {
                multipleHandlersError(handler, obj);
            } else {
                boolean z = obj instanceof CompletedExceptionally;
                if (z) {
                    CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
                    if (!completedExceptionally.makeHandled()) {
                        multipleHandlersError(handler, obj);
                    }
                    if (obj instanceof CancelledContinuation) {
                        if (!z) {
                            completedExceptionally = null;
                        }
                        callCancelHandler(handler, completedExceptionally != null ? completedExceptionally.cause : null);
                        return;
                    }
                    return;
                } else if (obj instanceof CompletedContinuation) {
                    CompletedContinuation completedContinuation = (CompletedContinuation) obj;
                    if (completedContinuation.cancelHandler != null) {
                        multipleHandlersError(handler, obj);
                    }
                    if (makeCancelHandler instanceof BeforeResumeCancelHandler) {
                        return;
                    }
                    if (completedContinuation.getCancelled()) {
                        callCancelHandler(handler, completedContinuation.cancelCause);
                        return;
                    } else {
                        if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(_state$FU, this, obj, CompletedContinuation.copy$default(completedContinuation, null, makeCancelHandler, null, null, null, 29, null))) {
                            return;
                        }
                    }
                } else if (makeCancelHandler instanceof BeforeResumeCancelHandler) {
                    return;
                } else {
                    if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(_state$FU, this, obj, new CompletedContinuation(obj, makeCancelHandler, null, null, null, 28, null))) {
                        return;
                    }
                }
            }
        }
    }

    private final void multipleHandlersError(Function1<? super Throwable, Unit> handler, Object state) {
        StringBuilder sb = new StringBuilder();
        sb.append("It's prohibited to register multiple handlers, tried to register ");
        sb.append(handler);
        sb.append(", already has ");
        sb.append(state);
        throw new IllegalStateException(sb.toString().toString());
    }

    private final CancelHandler makeCancelHandler(Function1<? super Throwable, Unit> handler) {
        return handler instanceof CancelHandler ? (CancelHandler) handler : new InvokeOnCancel(handler);
    }

    private final void dispatchResume(int mode) {
        if (tryResume()) {
            return;
        }
        DispatchedTaskKt.dispatch(this, mode);
    }

    private final Object resumedState(NotCompleted state, Object proposedUpdate, int resumeMode, Function1<? super Throwable, Unit> onCancellation, Object idempotent) {
        if (proposedUpdate instanceof CompletedExceptionally) {
            if (DebugKt.getASSERTIONS_ENABLED()) {
                if (!(idempotent == null)) {
                    throw new AssertionError();
                }
            }
            if (DebugKt.getASSERTIONS_ENABLED()) {
                if (onCancellation == null) {
                    return proposedUpdate;
                }
                throw new AssertionError();
            }
            return proposedUpdate;
        } else if (DispatchedTaskKt.isCancellableMode(resumeMode) || idempotent != null) {
            if (onCancellation != null || (((state instanceof CancelHandler) && !(state instanceof BeforeResumeCancelHandler)) || idempotent != null)) {
                return new CompletedContinuation(proposedUpdate, state instanceof CancelHandler ? (CancelHandler) state : null, onCancellation, idempotent, null, 16, null);
            }
            return proposedUpdate;
        } else {
            return proposedUpdate;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void resumeImpl$default(CancellableContinuationImpl cancellableContinuationImpl, Object obj, int i, Function1 function1, int i2, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
        }
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        cancellableContinuationImpl.resumeImpl(obj, i, function1);
    }

    private final Void alreadyResumedError(Object proposedUpdate) {
        StringBuilder sb = new StringBuilder();
        sb.append("Already resumed, but proposed with update ");
        sb.append(proposedUpdate);
        throw new IllegalStateException(sb.toString().toString());
    }

    private final void detachChildIfNonResuable() {
        if (isReusable()) {
            return;
        }
        detachChild$kotlinx_coroutines_core();
    }

    public final void detachChild$kotlinx_coroutines_core() {
        DisposableHandle disposableHandle = this.parentHandle;
        if (disposableHandle == null) {
            return;
        }
        disposableHandle.dispose();
        this.parentHandle = NonDisposableHandle.INSTANCE;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public Object tryResume(T value, Object idempotent) {
        return tryResumeImpl(value, idempotent, null);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public Object tryResume(T value, Object idempotent, Function1<? super Throwable, Unit> onCancellation) {
        return tryResumeImpl(value, idempotent, onCancellation);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public Object tryResumeWithException(Throwable exception) {
        return tryResumeImpl(new CompletedExceptionally(exception, false, 2, null), null, null);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void completeResume(Object token) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(token == CancellableContinuationImplKt.RESUME_TOKEN)) {
                throw new AssertionError();
            }
        }
        dispatchResume(this.resumeMode);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void resumeUndispatched(CoroutineDispatcher coroutineDispatcher, T t) {
        Continuation<T> continuation = this.delegate;
        DispatchedContinuation dispatchedContinuation = continuation instanceof DispatchedContinuation ? (DispatchedContinuation) continuation : null;
        resumeImpl$default(this, t, (dispatchedContinuation != null ? dispatchedContinuation.dispatcher : null) == coroutineDispatcher ? 4 : this.resumeMode, null, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.DispatchedTask
    public <T> T getSuccessfulResult$kotlinx_coroutines_core(Object state) {
        return state instanceof CompletedContinuation ? (T) ((CompletedContinuation) state).result : state;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Throwable getExceptionalResult$kotlinx_coroutines_core(Object state) {
        Throwable recoverFromStackFrame;
        Throwable exceptionalResult$kotlinx_coroutines_core = super.getExceptionalResult$kotlinx_coroutines_core(state);
        if (exceptionalResult$kotlinx_coroutines_core != null) {
            Continuation<T> continuation = this.delegate;
            if (DebugKt.getRECOVER_STACK_TRACES() && (continuation instanceof CoroutineStackFrame)) {
                recoverFromStackFrame = StackTraceRecoveryKt.recoverFromStackFrame(exceptionalResult$kotlinx_coroutines_core, (CoroutineStackFrame) continuation);
                return recoverFromStackFrame;
            }
            return exceptionalResult$kotlinx_coroutines_core;
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nameString());
        sb.append('(');
        sb.append(DebugStringsKt.toDebugString(this.delegate));
        sb.append("){");
        sb.append(getStateDebugRepresentation());
        sb.append("}@");
        sb.append(DebugStringsKt.getHexAddress(this));
        return sb.toString();
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public void cancelCompletedResult$kotlinx_coroutines_core(Object takenState, Throwable cause) {
        while (true) {
            Object obj = this._state;
            if (obj instanceof NotCompleted) {
                throw new IllegalStateException("Not completed".toString());
            }
            if (obj instanceof CompletedExceptionally) {
                return;
            }
            if (obj instanceof CompletedContinuation) {
                CompletedContinuation completedContinuation = (CompletedContinuation) obj;
                if ((!completedContinuation.getCancelled()) == false) {
                    throw new IllegalStateException("Must be called at most once".toString());
                }
                if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(_state$FU, this, obj, CompletedContinuation.copy$default(completedContinuation, null, null, null, null, cause, 15, null))) {
                    completedContinuation.invokeHandlers(this, cause);
                    return;
                }
            } else if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(_state$FU, this, obj, new CompletedContinuation(obj, null, null, null, cause, 14, null))) {
                return;
            }
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean cancel(Throwable cause) {
        Object obj;
        boolean z;
        do {
            obj = this._state;
            if (!(obj instanceof NotCompleted)) {
                return false;
            }
            z = obj instanceof CancelHandler;
        } while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(_state$FU, this, obj, new CancelledContinuation(this, cause, z)));
        CancelHandler cancelHandler = z ? (CancelHandler) obj : null;
        if (cancelHandler != null) {
            callCancelHandler(cancelHandler, cause);
        }
        detachChildIfNonResuable();
        dispatchResume(this.resumeMode);
        return true;
    }

    private final void callCancelHandler(Function1<? super Throwable, Unit> handler, Throwable cause) {
        try {
            handler.invoke(cause);
        } catch (Throwable th) {
            CoroutineContext context = getContext();
            StringBuilder sb = new StringBuilder();
            sb.append("Exception in invokeOnCancellation handler for ");
            sb.append(this);
            CoroutineExceptionHandlerKt.handleCoroutineException(context, new CompletionHandlerException(sb.toString(), th));
        }
    }

    private final boolean trySuspend() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!_decision$FU.compareAndSet(this, 0, 1));
        return true;
    }

    private final boolean tryResume() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!_decision$FU.compareAndSet(this, 0, 2));
        return true;
    }

    private final void resumeImpl(Object proposedUpdate, int resumeMode, Function1<? super Throwable, Unit> onCancellation) {
        Object obj;
        do {
            obj = this._state;
            if (obj instanceof NotCompleted) {
            } else {
                if (obj instanceof CancelledContinuation) {
                    CancelledContinuation cancelledContinuation = (CancelledContinuation) obj;
                    if (cancelledContinuation.makeResumed()) {
                        if (onCancellation != null) {
                            callOnCancellation(onCancellation, cancelledContinuation.cause);
                            return;
                        }
                        return;
                    }
                }
                alreadyResumedError(proposedUpdate);
                throw new KotlinNothingValueException();
            }
        } while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(_state$FU, this, obj, resumedState((NotCompleted) obj, proposedUpdate, resumeMode, onCancellation, null)));
        detachChildIfNonResuable();
        dispatchResume(resumeMode);
    }

    private final Symbol tryResumeImpl(Object proposedUpdate, Object idempotent, Function1<? super Throwable, Unit> onCancellation) {
        Object obj;
        do {
            obj = this._state;
            if (obj instanceof NotCompleted) {
            } else if (!(obj instanceof CompletedContinuation) || idempotent == null) {
                return null;
            } else {
                CompletedContinuation completedContinuation = (CompletedContinuation) obj;
                if (completedContinuation.idempotentResume == idempotent) {
                    if (!DebugKt.getASSERTIONS_ENABLED() || Intrinsics.areEqual(completedContinuation.result, proposedUpdate)) {
                        return CancellableContinuationImplKt.RESUME_TOKEN;
                    }
                    throw new AssertionError();
                }
                return null;
            }
        } while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(_state$FU, this, obj, resumedState((NotCompleted) obj, proposedUpdate, this.resumeMode, onCancellation, idempotent)));
        detachChildIfNonResuable();
        return CancellableContinuationImplKt.RESUME_TOKEN;
    }
}
