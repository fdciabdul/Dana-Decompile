package kotlinx.coroutines.selects;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.huawei.hms.push.e;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.CompletionStateKt;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobCancellingNode;
import kotlinx.coroutines.internal.AtomicDesc;
import kotlinx.coroutines.internal.AtomicOp;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\u00060\u0006j\u0002`\u0007:\u0004NOPQB\u0015\u0012\f\u0010J\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\bL\u0010MJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0016H\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001a\u0010\u000eJ8\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001b2\u001c\u0010\u001e\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u001dH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010#\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u0016H\u0016¢\u0006\u0004\b&\u0010\u0019J \u0010)\u001a\u00020\n2\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000'H\u0016ø\u0001\u0000¢\u0006\u0004\b)\u0010*J\u000f\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b,\u0010-J\u000f\u0010/\u001a\u00020.H\u0016¢\u0006\u0004\b/\u00100J\u001b\u00103\u001a\u0004\u0018\u00010\u000f2\b\u00102\u001a\u0004\u0018\u000101H\u0016¢\u0006\u0004\b3\u00104JG\u00108\u001a\u00020\n\"\u0004\b\u0001\u00105*\b\u0012\u0004\u0012\u00028\u0001062\"\u0010\u001e\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u000f07H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b8\u00109R\u001c\u0010<\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00078WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0014\u0010C\u001a\u00020@8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\bA\u0010BR\u0014\u0010D\u001a\u00020.8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\bD\u00100R(\u0010I\u001a\u0004\u0018\u00010\b2\b\u0010E\u001a\u0004\u0018\u00010\b8C@CX\u0082\u000e¢\u0006\f\u001a\u0004\bF\u0010G\"\u0004\bH\u0010\fR\u001a\u0010J\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bJ\u0010K\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl;", "R", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/selects/SelectBuilder;", "Lkotlinx/coroutines/selects/SelectInstance;", "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/DisposableHandle;", "handle", "", "disposeOnSelect", "(Lkotlinx/coroutines/DisposableHandle;)V", "doAfterSelect", "()V", "", "getResult", "()Ljava/lang/Object;", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "", e.PlaceComponentResult, "handleBuilderException", "(Ljava/lang/Throwable;)V", "initCancellability", "", "timeMillis", "Lkotlin/Function1;", "block", "onTimeout", "(JLkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/internal/AtomicDesc;", "desc", "performAtomicTrySelect", "(Lkotlinx/coroutines/internal/AtomicDesc;)Ljava/lang/Object;", "exception", "resumeSelectWithException", "Lkotlin/Result;", "result", "resumeWith", "(Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "", "trySelect", "()Z", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "otherOp", "trySelectOther", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Ljava/lang/Object;", "Q", "Lkotlinx/coroutines/selects/SelectClause1;", "Lkotlin/Function2;", BridgeDSL.INVOKE, "(Lkotlinx/coroutines/selects/SelectClause1;Lkotlin/jvm/functions/Function2;)V", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "getCompletion", "()Lkotlin/coroutines/Continuation;", "completion", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", HummerConstants.CONTEXT, "isSelected", "value", "getParentHandle", "()Lkotlinx/coroutines/DisposableHandle;", "setParentHandle", "parentHandle", "uCont", "Lkotlin/coroutines/Continuation;", "<init>", "(Lkotlin/coroutines/Continuation;)V", "AtomicSelectOp", "DisposeNode", "PairSelectOp", "SelectOnCancelling"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SelectBuilderImpl<R> extends LockFreeLinkedListHead implements SelectBuilder<R>, SelectInstance<R>, Continuation<R>, CoroutineStackFrame {
    private volatile /* synthetic */ Object _parentHandle;
    private volatile /* synthetic */ Object _result;
    volatile /* synthetic */ Object _state = SelectKt.getNOT_SELECTED();
    private final Continuation<R> uCont;
    static final /* synthetic */ AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(SelectBuilderImpl.class, Object.class, "_state");
    private static final /* synthetic */ AtomicReferenceFieldUpdater _result$FU = AtomicReferenceFieldUpdater.newUpdater(SelectBuilderImpl.class, Object.class, "_result");

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SelectBuilderImpl(Continuation<? super R> continuation) {
        Object obj;
        this.uCont = continuation;
        obj = SelectKt.UNDECIDED;
        this._result = obj;
        this._parentHandle = null;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @JvmName(name = "getCallerFrame")
    public final CoroutineStackFrame getCallerFrame() {
        Continuation<R> continuation = this.uCont;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @JvmName(name = "getParentHandle")
    private final DisposableHandle getParentHandle() {
        return (DisposableHandle) this._parentHandle;
    }

    @JvmName(name = "setParentHandle")
    private final void setParentHandle(DisposableHandle disposableHandle) {
        this._parentHandle = disposableHandle;
    }

    @Override // kotlin.coroutines.Continuation
    @JvmName(name = "getContext")
    public final CoroutineContext getContext() {
        return this.uCont.getContext();
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    @JvmName(name = "getCompletion")
    public final Continuation<R> getCompletion() {
        return this;
    }

    public final Object getResult() {
        Object obj;
        Object obj2;
        Object obj3;
        if (!isSelected()) {
            initCancellability();
        }
        Object obj4 = this._result;
        obj = SelectKt.UNDECIDED;
        if (obj4 == obj) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _result$FU;
            obj3 = SelectKt.UNDECIDED;
            if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(atomicReferenceFieldUpdater, this, obj3, IntrinsicsKt.getCOROUTINE_SUSPENDED())) {
                return IntrinsicsKt.getCOROUTINE_SUSPENDED();
            }
            obj4 = this._result;
        }
        obj2 = SelectKt.RESUMED;
        if (obj4 == obj2) {
            throw new IllegalStateException("Already resumed");
        }
        if (obj4 instanceof CompletedExceptionally) {
            throw ((CompletedExceptionally) obj4).cause;
        }
        return obj4;
    }

    private final void initCancellability() {
        Job job = (Job) getContext().get(Job.INSTANCE);
        if (job == null) {
            return;
        }
        DisposableHandle invokeOnCompletion$default = Job.DefaultImpls.invokeOnCompletion$default(job, true, false, new SelectOnCancelling(), 2, null);
        setParentHandle(invokeOnCompletion$default);
        if (isSelected()) {
            invokeOnCompletion$default.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl$SelectOnCancelling;", "Lkotlinx/coroutines/JobCancellingNode;", "", "cause", "", BridgeDSL.INVOKE, "(Ljava/lang/Throwable;)V", "<init>", "(Lkotlinx/coroutines/selects/SelectBuilderImpl;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public final class SelectOnCancelling extends JobCancellingNode {
        public SelectOnCancelling() {
        }

        @Override // kotlin.jvm.functions.Function1
        public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke(th);
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.CompletionHandlerBase
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable cause) {
            if (SelectBuilderImpl.this.trySelect()) {
                SelectBuilderImpl.this.resumeSelectWithException(getJob().getCancellationException());
            }
        }
    }

    public final void handleBuilderException(Throwable e) {
        if (trySelect()) {
            Result.Companion companion = Result.INSTANCE;
            resumeWith(Result.m3179constructorimpl(ResultKt.createFailure(e)));
        } else if (e instanceof CancellationException) {
        } else {
            Object result = getResult();
            if (result instanceof CompletedExceptionally) {
                Throwable th = ((CompletedExceptionally) result).cause;
                if (DebugKt.getRECOVER_STACK_TRACES()) {
                    th = StackTraceRecoveryKt.unwrapImpl(th);
                }
                if (th == (!DebugKt.getRECOVER_STACK_TRACES() ? e : StackTraceRecoveryKt.unwrapImpl(e))) {
                    return;
                }
            }
            CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), e);
        }
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public final void disposeOnSelect(DisposableHandle handle) {
        DisposeNode disposeNode = new DisposeNode(handle);
        if (!isSelected()) {
            addLast(disposeNode);
            if (!isSelected()) {
                return;
            }
        }
        handle.dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doAfterSelect() {
        DisposableHandle parentHandle = getParentHandle();
        if (parentHandle != null) {
            parentHandle.dispose();
        }
        SelectBuilderImpl<R> selectBuilderImpl = this;
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) selectBuilderImpl.getNext(); !Intrinsics.areEqual(lockFreeLinkedListNode, selectBuilderImpl); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
            if (lockFreeLinkedListNode instanceof DisposeNode) {
                ((DisposeNode) lockFreeLinkedListNode).handle.dispose();
            }
        }
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public final boolean trySelect() {
        Object trySelectOther = trySelectOther(null);
        if (trySelectOther == CancellableContinuationImplKt.RESUME_TOKEN) {
            return true;
        }
        if (trySelectOther == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unexpected trySelectIdempotent result ");
        sb.append(trySelectOther);
        throw new IllegalStateException(sb.toString().toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0018\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u00068WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl$PairSelectOp;", "Lkotlinx/coroutines/internal/OpDescriptor;", "", "affected", "perform", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/AtomicOp;", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "atomicOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "<init>", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class PairSelectOp extends OpDescriptor {
        public final LockFreeLinkedListNode.PrepareOp otherOp;

        public PairSelectOp(LockFreeLinkedListNode.PrepareOp prepareOp) {
            this.otherOp = prepareOp;
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        public final Object perform(Object affected) {
            if (affected != null) {
                SelectBuilderImpl selectBuilderImpl = (SelectBuilderImpl) affected;
                this.otherOp.finishPrepare();
                Object decide = this.otherOp.getAtomicOp().decide(null);
                AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(SelectBuilderImpl._state$FU, selectBuilderImpl, this, decide == null ? this.otherOp.desc : SelectKt.getNOT_SELECTED());
                return decide;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.selects.SelectBuilderImpl<*>");
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        @JvmName(name = "getAtomicOp")
        public final AtomicOp<?> getAtomicOp() {
            return this.otherOp.getAtomicOp();
        }
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public final Object performAtomicTrySelect(AtomicDesc desc) {
        return new AtomicSelectOp(this, desc).perform(null);
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SelectInstance(state=");
        sb.append(this._state);
        sb.append(", result=");
        sb.append(this._result);
        sb.append(')');
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u001b\u0012\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u001e\u0010\u001fJ#\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\b\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u00168\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001a\u001a\u00020\u00198\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl$AtomicSelectOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "", "affected", "failure", "", "complete", "(Ljava/lang/Object;Ljava/lang/Object;)V", "completeSelect", "(Ljava/lang/Object;)V", LogConstants.Mpm.EndNodeType.PREPARE, "(Ljava/lang/Object;)Ljava/lang/Object;", "prepareSelectOp", "()Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "undoPrepare", "()V", "Lkotlinx/coroutines/internal/AtomicDesc;", "desc", "Lkotlinx/coroutines/internal/AtomicDesc;", "Lkotlinx/coroutines/selects/SelectBuilderImpl;", "impl", "Lkotlinx/coroutines/selects/SelectBuilderImpl;", "", "opSequence", "J", "getOpSequence", "()J", "<init>", "(Lkotlinx/coroutines/selects/SelectBuilderImpl;Lkotlinx/coroutines/internal/AtomicDesc;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class AtomicSelectOp extends AtomicOp<Object> {
        public final AtomicDesc desc;
        public final SelectBuilderImpl<?> impl;
        private final long opSequence;

        public AtomicSelectOp(SelectBuilderImpl<?> selectBuilderImpl, AtomicDesc atomicDesc) {
            SeqNumber seqNumber;
            this.impl = selectBuilderImpl;
            this.desc = atomicDesc;
            seqNumber = SelectKt.selectOpSequenceNumber;
            this.opSequence = seqNumber.next();
            atomicDesc.setAtomicOp(this);
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        @JvmName(name = "getOpSequence")
        public final long getOpSequence() {
            return this.opSequence;
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        public final Object prepare(Object affected) {
            Object prepareSelectOp;
            if (affected != null || (prepareSelectOp = prepareSelectOp()) == null) {
                try {
                    return this.desc.prepare(this);
                } catch (Throwable th) {
                    if (affected == null) {
                        undoPrepare();
                    }
                    throw th;
                }
            }
            return prepareSelectOp;
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        public final void complete(Object affected, Object failure) {
            completeSelect(failure);
            this.desc.complete(this, failure);
        }

        private final Object prepareSelectOp() {
            SelectBuilderImpl<?> selectBuilderImpl = this.impl;
            while (true) {
                Object obj = selectBuilderImpl._state;
                if (obj == this) {
                    return null;
                }
                if (obj instanceof OpDescriptor) {
                    ((OpDescriptor) obj).perform(this.impl);
                } else if (obj == SelectKt.getNOT_SELECTED()) {
                    if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(SelectBuilderImpl._state$FU, this.impl, SelectKt.getNOT_SELECTED(), this)) {
                        return null;
                    }
                } else {
                    return SelectKt.getALREADY_SELECTED();
                }
            }
        }

        private final void undoPrepare() {
            AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(SelectBuilderImpl._state$FU, this.impl, this, SelectKt.getNOT_SELECTED());
        }

        private final void completeSelect(Object failure) {
            boolean z = failure == null;
            if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(SelectBuilderImpl._state$FU, this.impl, this, z ? null : SelectKt.getNOT_SELECTED()) && z) {
                this.impl.doAfterSelect();
            }
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("AtomicSelectOp(sequence=");
            sb.append(getOpSequence());
            sb.append(')');
            return sb.toString();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.selects.SelectBuilder
    public final <Q> void invoke(SelectClause1<? extends Q> selectClause1, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        selectClause1.registerSelectClause1(this, function2);
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public final void onTimeout(long timeMillis, final Function1<? super Continuation<? super R>, ? extends Object> block) {
        if (timeMillis <= 0) {
            if (trySelect()) {
                UndispatchedKt.startCoroutineUnintercepted(block, getCompletion());
                return;
            }
            return;
        }
        disposeOnSelect(DelayKt.getDelay(getContext()).invokeOnTimeout(timeMillis, new Runnable() { // from class: kotlinx.coroutines.selects.SelectBuilderImpl$onTimeout$$inlined$Runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                if (SelectBuilderImpl.this.trySelect()) {
                    CancellableKt.startCoroutineCancellable(block, SelectBuilderImpl.this.getCompletion());
                }
            }
        }, getContext()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl$DisposeNode;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/DisposableHandle;", "handle", "Lkotlinx/coroutines/DisposableHandle;", "<init>", "(Lkotlinx/coroutines/DisposableHandle;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class DisposeNode extends LockFreeLinkedListNode {
        public final DisposableHandle handle;

        public DisposeNode(DisposableHandle disposableHandle) {
            this.handle = disposableHandle;
        }
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object result) {
        Object obj;
        Object obj2;
        Object obj3;
        if (DebugKt.getASSERTIONS_ENABLED() && !isSelected()) {
            throw new AssertionError();
        }
        while (true) {
            Object obj4 = this._result;
            obj = SelectKt.UNDECIDED;
            if (obj4 == obj) {
                Object state$default = CompletionStateKt.toState$default(result, null, 1, null);
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _result$FU;
                obj2 = SelectKt.UNDECIDED;
                if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(atomicReferenceFieldUpdater, this, obj2, state$default)) {
                    return;
                }
            } else if (obj4 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = _result$FU;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                obj3 = SelectKt.RESUMED;
                if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(atomicReferenceFieldUpdater2, this, coroutine_suspended, obj3)) {
                    if (Result.m3185isFailureimpl(result)) {
                        Continuation<R> continuation = this.uCont;
                        Throwable m3182exceptionOrNullimpl = Result.m3182exceptionOrNullimpl(result);
                        Intrinsics.checkNotNull(m3182exceptionOrNullimpl);
                        Result.Companion companion = Result.INSTANCE;
                        if (DebugKt.getRECOVER_STACK_TRACES() && (continuation instanceof CoroutineStackFrame)) {
                            m3182exceptionOrNullimpl = StackTraceRecoveryKt.access$recoverFromStackFrame(m3182exceptionOrNullimpl, (CoroutineStackFrame) continuation);
                        }
                        continuation.resumeWith(Result.m3179constructorimpl(ResultKt.createFailure(m3182exceptionOrNullimpl)));
                        return;
                    }
                    this.uCont.resumeWith(result);
                    return;
                }
            } else {
                throw new IllegalStateException("Already resumed");
            }
        }
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public final void resumeSelectWithException(Throwable exception) {
        Object obj;
        Object obj2;
        Object obj3;
        if (DebugKt.getASSERTIONS_ENABLED() && !isSelected()) {
            throw new AssertionError();
        }
        while (true) {
            Object obj4 = this._result;
            obj = SelectKt.UNDECIDED;
            if (obj4 == obj) {
                Continuation<R> continuation = this.uCont;
                CompletedExceptionally completedExceptionally = new CompletedExceptionally((DebugKt.getRECOVER_STACK_TRACES() && (continuation instanceof CoroutineStackFrame)) ? StackTraceRecoveryKt.access$recoverFromStackFrame(exception, (CoroutineStackFrame) continuation) : exception, false, 2, null);
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _result$FU;
                obj2 = SelectKt.UNDECIDED;
                if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(atomicReferenceFieldUpdater, this, obj2, completedExceptionally)) {
                    return;
                }
            } else if (obj4 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = _result$FU;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                obj3 = SelectKt.RESUMED;
                if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(atomicReferenceFieldUpdater2, this, coroutine_suspended, obj3)) {
                    Continuation intercepted = IntrinsicsKt.intercepted(this.uCont);
                    Result.Companion companion = Result.INSTANCE;
                    intercepted.resumeWith(Result.m3179constructorimpl(ResultKt.createFailure(exception)));
                    return;
                }
            } else {
                throw new IllegalStateException("Already resumed");
            }
        }
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    @JvmName(name = "isSelected")
    public final boolean isSelected() {
        while (true) {
            Object obj = this._state;
            if (obj == SelectKt.getNOT_SELECTED()) {
                return false;
            }
            if (!(obj instanceof OpDescriptor)) {
                return true;
            }
            ((OpDescriptor) obj).perform(this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0030, code lost:
    
        doAfterSelect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0035, code lost:
    
        return kotlinx.coroutines.CancellableContinuationImplKt.RESUME_TOKEN;
     */
    @Override // kotlinx.coroutines.selects.SelectInstance
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object trySelectOther(kotlinx.coroutines.internal.LockFreeLinkedListNode.PrepareOp r4) {
        /*
            r3 = this;
        L0:
            java.lang.Object r0 = r3._state
            java.lang.Object r1 = kotlinx.coroutines.selects.SelectKt.getNOT_SELECTED()
            r2 = 0
            if (r0 != r1) goto L36
            if (r4 != 0) goto L18
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = kotlinx.coroutines.selects.SelectBuilderImpl._state$FU
            java.lang.Object r1 = kotlinx.coroutines.selects.SelectKt.getNOT_SELECTED()
            boolean r0 = androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(r0, r3, r1, r2)
            if (r0 != 0) goto L30
            goto L0
        L18:
            kotlinx.coroutines.selects.SelectBuilderImpl$PairSelectOp r0 = new kotlinx.coroutines.selects.SelectBuilderImpl$PairSelectOp
            r0.<init>(r4)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = kotlinx.coroutines.selects.SelectBuilderImpl._state$FU
            java.lang.Object r2 = kotlinx.coroutines.selects.SelectKt.getNOT_SELECTED()
            boolean r1 = androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(r1, r3, r2, r0)
            if (r1 == 0) goto L0
            java.lang.Object r4 = r0.perform(r3)
            if (r4 == 0) goto L30
            return r4
        L30:
            r3.doAfterSelect()
            kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.CancellableContinuationImplKt.RESUME_TOKEN
            return r4
        L36:
            boolean r1 = r0 instanceof kotlinx.coroutines.internal.OpDescriptor
            if (r1 == 0) goto L6a
            if (r4 == 0) goto L64
            kotlinx.coroutines.internal.AtomicOp r1 = r4.getAtomicOp()
            boolean r2 = r1 instanceof kotlinx.coroutines.selects.SelectBuilderImpl.AtomicSelectOp
            if (r2 == 0) goto L58
            r2 = r1
            kotlinx.coroutines.selects.SelectBuilderImpl$AtomicSelectOp r2 = (kotlinx.coroutines.selects.SelectBuilderImpl.AtomicSelectOp) r2
            kotlinx.coroutines.selects.SelectBuilderImpl<?> r2 = r2.impl
            if (r2 == r3) goto L4c
            goto L58
        L4c:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "Cannot use matching select clauses on the same object"
            java.lang.String r0 = r0.toString()
            r4.<init>(r0)
            throw r4
        L58:
            r2 = r0
            kotlinx.coroutines.internal.OpDescriptor r2 = (kotlinx.coroutines.internal.OpDescriptor) r2
            boolean r1 = r1.isEarlierThan(r2)
            if (r1 == 0) goto L64
            java.lang.Object r4 = kotlinx.coroutines.internal.AtomicKt.RETRY_ATOMIC
            return r4
        L64:
            kotlinx.coroutines.internal.OpDescriptor r0 = (kotlinx.coroutines.internal.OpDescriptor) r0
            r0.perform(r3)
            goto L0
        L6a:
            if (r4 != 0) goto L6d
            return r2
        L6d:
            kotlinx.coroutines.internal.LockFreeLinkedListNode$AbstractAtomicDesc r4 = r4.desc
            if (r0 != r4) goto L74
            kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.CancellableContinuationImplKt.RESUME_TOKEN
            return r4
        L74:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.SelectBuilderImpl.trySelectOther(kotlinx.coroutines.internal.LockFreeLinkedListNode$PrepareOp):java.lang.Object");
    }
}
