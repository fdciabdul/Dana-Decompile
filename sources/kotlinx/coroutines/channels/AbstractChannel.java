package kotlinx.coroutines.channels;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.ap.zoloz.hummer.biz.HummerConstants;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BeforeResumeCancelHandler;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.LockFreeLinkedList_commonKt;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;

@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0007\\]^_`abB)\u0012 \u0010Y\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0018\u00010Wj\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`X¢\u0006\u0004\bZ\u0010[J\u001d\u0010\b\u001a\u00020\u00072\u000e\u0010\u0006\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0013\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0015\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0014¢\u0006\u0004\b\u0015\u0010\u0014JT\u0010\u001f\u001a\u00020\u000b\"\u0004\b\u0001\u0010\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u00172$\u0010\u001c\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u00192\u0006\u0010\u001e\u001a\u00020\u001dH\u0002ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000!H\u0086\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u000bH\u0014¢\u0006\u0004\b%\u0010&J,\u0010.\u001a\u00020\u00072\f\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'2\n\u0010+\u001a\u0006\u0012\u0002\b\u00030*H\u0014ø\u0001\u0001¢\u0006\u0004\b,\u0010-J\u000f\u0010/\u001a\u00020\u0007H\u0014¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0007H\u0014¢\u0006\u0004\b1\u00100J\u0011\u00102\u001a\u0004\u0018\u00010\u001aH\u0014¢\u0006\u0004\b2\u00103J\u001d\u00104\u001a\u0004\u0018\u00010\u001a2\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0017H\u0014¢\u0006\u0004\b4\u00105J\u0019\u00109\u001a\b\u0012\u0004\u0012\u00028\u000006H\u0086@ø\u0001\u0001¢\u0006\u0004\b7\u00108J!\u0010:\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00162\u0006\u0010\u001e\u001a\u00020\u001dH\u0082@ø\u0001\u0000¢\u0006\u0004\b:\u0010;JT\u0010<\u001a\u00020\u0007\"\u0004\b\u0001\u0010\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u00172\u0006\u0010\u001e\u001a\u00020\u001d2$\u0010\u001c\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019H\u0002ø\u0001\u0000¢\u0006\u0004\b<\u0010=J'\u0010@\u001a\u00020\u00072\n\u0010?\u001a\u0006\u0012\u0002\b\u00030>2\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0011H\u0002¢\u0006\u0004\b@\u0010AJ\u0017\u0010C\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010BH\u0014¢\u0006\u0004\bC\u0010DJ\u0016\u0010F\u001a\b\u0012\u0004\u0012\u00028\u000006ø\u0001\u0001¢\u0006\u0004\bE\u00103JZ\u0010H\u001a\u00020\u0007\"\u0004\b\u0001\u0010\u0016* \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u00192\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u00172\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010G\u001a\u0004\u0018\u00010\u001aH\u0002ø\u0001\u0000¢\u0006\u0004\bH\u0010IR\u0014\u0010L\u001a\u00020\u000b8EX\u0084\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u0014\u0010M\u001a\u00020\u000b8%X¤\u0004¢\u0006\u0006\u001a\u0004\bM\u0010KR\u0014\u0010N\u001a\u00020\u000b8%X¤\u0004¢\u0006\u0006\u001a\u0004\bN\u0010KR\u0014\u0010O\u001a\u00020\u000b8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\bO\u0010KR\u0014\u0010P\u001a\u00020\u000b8EX\u0084\u0004¢\u0006\u0006\u001a\u0004\bP\u0010KR\u0017\u0010T\u001a\b\u0012\u0004\u0012\u00028\u00000Q8G¢\u0006\u0006\u001a\u0004\bR\u0010SR \u0010V\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u0000060Q8Gø\u0001\u0000¢\u0006\u0006\u001a\u0004\bU\u0010S\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel;", "E", "Lkotlinx/coroutines/channels/AbstractSendChannel;", "Lkotlinx/coroutines/channels/Channel;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "", "cancel", "(Ljava/util/concurrent/CancellationException;)V", "", "", "cancelInternal$kotlinx_coroutines_core", "(Ljava/lang/Throwable;)Z", "Lkotlinx/coroutines/channels/AbstractChannel$TryPollDesc;", "describeTryPoll", "()Lkotlinx/coroutines/channels/AbstractChannel$TryPollDesc;", "Lkotlinx/coroutines/channels/Receive;", "receive", "enqueueReceive", "(Lkotlinx/coroutines/channels/Receive;)Z", "enqueueReceiveInternal", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/Function2;", "", "Lkotlin/coroutines/Continuation;", "block", "", "receiveMode", "enqueueReceiveSelect", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;I)Z", "Lkotlinx/coroutines/channels/ChannelIterator;", "iterator", "()Lkotlinx/coroutines/channels/ChannelIterator;", "wasClosed", "onCancelIdempotent", "(Z)V", "Lkotlinx/coroutines/internal/InlineList;", "Lkotlinx/coroutines/channels/Send;", "list", "Lkotlinx/coroutines/channels/Closed;", "closed", "onCancelIdempotentList-w-w6eGU", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/Closed;)V", "onCancelIdempotentList", "onReceiveDequeued", "()V", "onReceiveEnqueued", "pollInternal", "()Ljava/lang/Object;", "pollSelectInternal", "(Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ChannelResult;", "receiveCatching-JP2dKIU", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveCatching", "receiveSuspend", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerSelectReceiveMode", "(Lkotlinx/coroutines/selects/SelectInstance;ILkotlin/jvm/functions/Function2;)V", "Lkotlinx/coroutines/CancellableContinuation;", "cont", "removeReceiveOnCancel", "(Lkotlinx/coroutines/CancellableContinuation;Lkotlinx/coroutines/channels/Receive;)V", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "takeFirstReceiveOrPeekClosed", "()Lkotlinx/coroutines/channels/ReceiveOrClosed;", "tryReceive-PtdJZtk", "tryReceive", "value", "tryStartBlockUnintercepted", "(Lkotlin/jvm/functions/Function2;Lkotlinx/coroutines/selects/SelectInstance;ILjava/lang/Object;)V", "getHasReceiveOrClosed", "()Z", "hasReceiveOrClosed", "isBufferAlwaysEmpty", "isBufferEmpty", "isClosedForReceive", "isEmptyImpl", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceive", "getOnReceiveCatching", "onReceiveCatching", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "Itr", "ReceiveElement", "ReceiveElementWithUndeliveredHandler", "ReceiveHasNext", "ReceiveSelect", "RemoveReceiveOnCancel", "TryPollDesc"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public abstract class AbstractChannel<E> extends AbstractSendChannel<E> implements Channel<E> {
    @JvmName(name = "isBufferAlwaysEmpty")
    protected abstract boolean isBufferAlwaysEmpty();

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "isBufferEmpty")
    public abstract boolean isBufferEmpty();

    protected void onReceiveDequeued() {
    }

    protected void onReceiveEnqueued() {
    }

    public AbstractChannel(Function1<? super E, Unit> function1) {
        super(function1);
    }

    protected Object pollInternal() {
        while (true) {
            Send takeFirstSendOrPeekClosed = takeFirstSendOrPeekClosed();
            if (takeFirstSendOrPeekClosed == null) {
                return AbstractChannelKt.POLL_FAILED;
            }
            Symbol tryResumeSend = takeFirstSendOrPeekClosed.tryResumeSend(null);
            if (tryResumeSend != null) {
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    if (!(tryResumeSend == CancellableContinuationImplKt.RESUME_TOKEN)) {
                        throw new AssertionError();
                    }
                }
                takeFirstSendOrPeekClosed.completeResumeSend();
                return takeFirstSendOrPeekClosed.getElement();
            }
            takeFirstSendOrPeekClosed.undeliveredElement();
        }
    }

    protected Object pollSelectInternal(SelectInstance<?> select) {
        TryPollDesc<E> describeTryPoll = describeTryPoll();
        Object performAtomicTrySelect = select.performAtomicTrySelect(describeTryPoll);
        if (performAtomicTrySelect != null) {
            return performAtomicTrySelect;
        }
        describeTryPoll.getResult().completeResumeSend();
        return describeTryPoll.getResult().getElement();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "getHasReceiveOrClosed")
    public final boolean getHasReceiveOrClosed() {
        return getQueue().getNextNode() instanceof ReceiveOrClosed;
    }

    @JvmName(name = "isClosedForReceive")
    public boolean isClosedForReceive() {
        return getClosedForReceive() != null && isBufferEmpty();
    }

    @JvmName(name = "isEmptyImpl")
    protected final boolean isEmptyImpl() {
        return !(getQueue().getNextNode() instanceof Send) && isBufferEmpty();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean enqueueReceiveInternal(Receive<? super E> receive) {
        int tryCondAddNext;
        LockFreeLinkedListNode prevNode;
        if (isBufferAlwaysEmpty()) {
            LockFreeLinkedListHead queue = getQueue();
            do {
                prevNode = queue.getPrevNode();
                if ((!(prevNode instanceof Send)) == false) {
                    return false;
                }
            } while (!prevNode.addNext(receive, queue));
        } else {
            LockFreeLinkedListHead queue2 = getQueue();
            final Receive<? super E> receive2 = receive;
            LockFreeLinkedListNode.CondAddOp condAddOp = new LockFreeLinkedListNode.CondAddOp(receive2) { // from class: kotlinx.coroutines.channels.AbstractChannel$enqueueReceiveInternal$$inlined$addLastIfPrevAndIf$1
                @Override // kotlinx.coroutines.internal.AtomicOp
                public final Object prepare(LockFreeLinkedListNode affected) {
                    if (this.isBufferEmpty()) {
                        return null;
                    }
                    return LockFreeLinkedListKt.getCONDITION_FALSE();
                }
            };
            do {
                LockFreeLinkedListNode prevNode2 = queue2.getPrevNode();
                if ((!(prevNode2 instanceof Send)) != true) {
                    return false;
                }
                tryCondAddNext = prevNode2.tryCondAddNext(receive2, queue2, condAddOp);
                if (tryCondAddNext != 1) {
                }
            } while (tryCondAddNext != 2);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean enqueueReceive(Receive<? super E> receive) {
        boolean enqueueReceiveInternal = enqueueReceiveInternal(receive);
        if (enqueueReceiveInternal) {
            onReceiveEnqueued();
        }
        return enqueueReceiveInternal;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* renamed from: receiveCatching-JP2dKIU  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object mo4632receiveCatchingJP2dKIU(kotlin.coroutines.Continuation<? super kotlinx.coroutines.channels.ChannelResult<? extends E>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1
            if (r0 == 0) goto L14
            r0 = r5
            kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1 r0 = (kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 + r2
            r0.label = r5
            goto L19
        L14:
            kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1 r0 = new kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1
            r0.<init>(r4, r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L5c
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r5)
            java.lang.Object r5 = r4.pollInternal()
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED
            if (r5 == r2) goto L53
            boolean r0 = r5 instanceof kotlinx.coroutines.channels.Closed
            if (r0 == 0) goto L4c
            kotlinx.coroutines.channels.ChannelResult$Companion r0 = kotlinx.coroutines.channels.ChannelResult.INSTANCE
            kotlinx.coroutines.channels.Closed r5 = (kotlinx.coroutines.channels.Closed) r5
            java.lang.Throwable r5 = r5.closeCause
            java.lang.Object r5 = r0.m4645closedJP2dKIU(r5)
            goto L52
        L4c:
            kotlinx.coroutines.channels.ChannelResult$Companion r0 = kotlinx.coroutines.channels.ChannelResult.INSTANCE
            java.lang.Object r5 = r0.m4647successJP2dKIU(r5)
        L52:
            return r5
        L53:
            r0.label = r3
            java.lang.Object r5 = r4.receiveSuspend(r3, r0)
            if (r5 != r1) goto L5c
            return r1
        L5c:
            kotlinx.coroutines.channels.ChannelResult r5 = (kotlinx.coroutines.channels.ChannelResult) r5
            java.lang.Object r5 = r5.getHolder()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.AbstractChannel.mo4632receiveCatchingJP2dKIU(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* renamed from: tryReceive-PtdJZtk  reason: not valid java name */
    public final Object mo4633tryReceivePtdJZtk() {
        Object pollInternal = pollInternal();
        return pollInternal == AbstractChannelKt.POLL_FAILED ? ChannelResult.INSTANCE.m4646failurePtdJZtk() : pollInternal instanceof Closed ? ChannelResult.INSTANCE.m4645closedJP2dKIU(((Closed) pollInternal).closeCause) : ChannelResult.INSTANCE.m4647successJP2dKIU(pollInternal);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel(CancellationException cause) {
        if (isClosedForReceive()) {
            return;
        }
        if (cause == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(DebugStringsKt.getClassSimpleName(this));
            sb.append(" was cancelled");
            cause = new CancellationException(sb.toString());
        }
        cancelInternal$kotlinx_coroutines_core(cause);
    }

    public final boolean cancelInternal$kotlinx_coroutines_core(Throwable cause) {
        boolean close = close(cause);
        onCancelIdempotent(close);
        return close;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onCancelIdempotent(boolean wasClosed) {
        Closed<?> closedForSend = getClosedForSend();
        if (closedForSend == null) {
            throw new IllegalStateException("Cannot happen".toString());
        }
        Object m4654constructorimpl$default = InlineList.m4654constructorimpl$default(null, 1, null);
        while (true) {
            LockFreeLinkedListNode prevNode = closedForSend.getPrevNode();
            if (!(prevNode instanceof LockFreeLinkedListHead)) {
                if (DebugKt.getASSERTIONS_ENABLED() && !(prevNode instanceof Send)) {
                    throw new AssertionError();
                }
                if (!prevNode.mo4660remove()) {
                    prevNode.helpRemove();
                } else {
                    m4654constructorimpl$default = InlineList.m4657plusFjFbRPM(m4654constructorimpl$default, (Send) prevNode);
                }
            } else {
                mo4631onCancelIdempotentListww6eGU(m4654constructorimpl$default, closedForSend);
                return;
            }
        }
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final ChannelIterator<E> iterator() {
        return new Itr(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final TryPollDesc<E> describeTryPoll() {
        return new TryPollDesc<>(getQueue());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\r\u001a\u0004\u0018\u00010\u00072\n\u0010\f\u001a\u00060\nj\u0002`\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$TryPollDesc;", "E", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "Lkotlinx/coroutines/channels/Send;", "Lkotlinx/coroutines/internal/RemoveFirstDesc;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "affected", "", "failure", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "Lkotlinx/coroutines/internal/PrepareOp;", "prepareOp", "onPrepare", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Ljava/lang/Object;", "", "onRemoved", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", SemanticAttributes.MessagingDestinationKindValues.QUEUE, "<init>", "(Lkotlinx/coroutines/internal/LockFreeLinkedListHead;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class TryPollDesc<E> extends LockFreeLinkedListNode.RemoveFirstDesc<Send> {
        public TryPollDesc(LockFreeLinkedListHead lockFreeLinkedListHead) {
            super(lockFreeLinkedListHead);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.RemoveFirstDesc, kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final Object failure(LockFreeLinkedListNode affected) {
            if (affected instanceof Closed) {
                return affected;
            }
            if (affected instanceof Send) {
                return null;
            }
            return AbstractChannelKt.POLL_FAILED;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final Object onPrepare(LockFreeLinkedListNode.PrepareOp prepareOp) {
            Symbol tryResumeSend = ((Send) prepareOp.affected).tryResumeSend(prepareOp);
            if (tryResumeSend == null) {
                return LockFreeLinkedList_commonKt.REMOVE_PREPARED;
            }
            if (tryResumeSend == AtomicKt.RETRY_ATOMIC) {
                return AtomicKt.RETRY_ATOMIC;
            }
            if (DebugKt.getASSERTIONS_ENABLED()) {
                if (tryResumeSend == CancellableContinuationImplKt.RESUME_TOKEN) {
                    return null;
                }
                throw new AssertionError();
            }
            return null;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final void onRemoved(LockFreeLinkedListNode affected) {
            ((Send) affected).undeliveredElement();
        }
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @JvmName(name = "getOnReceive")
    public final SelectClause1<E> getOnReceive() {
        return new SelectClause1<E>(this) { // from class: kotlinx.coroutines.channels.AbstractChannel$onReceive$1
            final /* synthetic */ AbstractChannel<E> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.this$0 = this;
            }

            @Override // kotlinx.coroutines.selects.SelectClause1
            public final <R> void registerSelectClause1(SelectInstance<? super R> select, Function2<? super E, ? super Continuation<? super R>, ? extends Object> block) {
                this.this$0.registerSelectReceiveMode(select, 0, block);
            }
        };
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @JvmName(name = "getOnReceiveCatching")
    public final SelectClause1<ChannelResult<E>> getOnReceiveCatching() {
        return (SelectClause1) ((SelectClause1<ChannelResult<? extends E>>) new SelectClause1<ChannelResult<? extends E>>(this) { // from class: kotlinx.coroutines.channels.AbstractChannel$onReceiveCatching$1
            final /* synthetic */ AbstractChannel<E> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.this$0 = this;
            }

            @Override // kotlinx.coroutines.selects.SelectClause1
            public final <R> void registerSelectClause1(SelectInstance<? super R> select, Function2<? super ChannelResult<? extends E>, ? super Continuation<? super R>, ? extends Object> block) {
                this.this$0.registerSelectReceiveMode(select, 1, block);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <R> void registerSelectReceiveMode(SelectInstance<? super R> select, int receiveMode, Function2<Object, ? super Continuation<? super R>, ? extends Object> block) {
        while (!select.isSelected()) {
            if (isEmptyImpl()) {
                if (enqueueReceiveSelect(select, block, receiveMode)) {
                    return;
                }
            } else {
                Object pollSelectInternal = pollSelectInternal(select);
                if (pollSelectInternal == SelectKt.getALREADY_SELECTED()) {
                    return;
                }
                if (pollSelectInternal != AbstractChannelKt.POLL_FAILED && pollSelectInternal != AtomicKt.RETRY_ATOMIC) {
                    tryStartBlockUnintercepted(block, select, receiveMode, pollSelectInternal);
                }
            }
        }
    }

    private final <R> void tryStartBlockUnintercepted(Function2<Object, ? super Continuation<? super R>, ? extends Object> function2, SelectInstance<? super R> selectInstance, int i, Object obj) {
        boolean z = obj instanceof Closed;
        if (!z) {
            if (i == 1) {
                ChannelResult.Companion companion = ChannelResult.INSTANCE;
                obj = ChannelResult.m4634boximpl(z ? companion.m4645closedJP2dKIU(((Closed) obj).closeCause) : companion.m4647successJP2dKIU(obj));
            }
            UndispatchedKt.startCoroutineUnintercepted(function2, obj, selectInstance.getCompletion());
        } else if (i == 0) {
            throw StackTraceRecoveryKt.recoverStackTrace(((Closed) obj).getReceiveException());
        } else {
            if (i == 1 && selectInstance.trySelect()) {
                UndispatchedKt.startCoroutineUnintercepted(function2, ChannelResult.m4634boximpl(ChannelResult.INSTANCE.m4645closedJP2dKIU(((Closed) obj).closeCause)), selectInstance.getCompletion());
            }
        }
    }

    private final <R> boolean enqueueReceiveSelect(SelectInstance<? super R> select, Function2<Object, ? super Continuation<? super R>, ? extends Object> block, int receiveMode) {
        ReceiveSelect receiveSelect = new ReceiveSelect(this, select, block, receiveMode);
        boolean enqueueReceive = enqueueReceive(receiveSelect);
        if (enqueueReceive) {
            select.disposeOnSelect(receiveSelect);
        }
        return enqueueReceive;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed() {
        ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed = super.takeFirstReceiveOrPeekClosed();
        if (takeFirstReceiveOrPeekClosed != null && !(takeFirstReceiveOrPeekClosed instanceof Closed)) {
            onReceiveDequeued();
        }
        return takeFirstReceiveOrPeekClosed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeReceiveOnCancel(CancellableContinuation<?> cont, Receive<?> receive) {
        cont.invokeOnCancellation(new RemoveReceiveOnCancel(receive));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\n¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$RemoveReceiveOnCancel;", "Lkotlinx/coroutines/BeforeResumeCancelHandler;", "", "cause", "", BridgeDSL.INVOKE, "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/channels/Receive;", "receive", "Lkotlinx/coroutines/channels/Receive;", "<init>", "(Lkotlinx/coroutines/channels/AbstractChannel;Lkotlinx/coroutines/channels/Receive;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public final class RemoveReceiveOnCancel extends BeforeResumeCancelHandler {
        private final Receive<?> receive;

        public RemoveReceiveOnCancel(Receive<?> receive) {
            this.receive = receive;
        }

        @Override // kotlin.jvm.functions.Function1
        public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke(th);
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.CancelHandlerBase
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable cause) {
            if (this.receive.mo4660remove()) {
                AbstractChannel.this.onReceiveDequeued();
            }
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("RemoveReceiveOnCancel[");
            sb.append(this.receive);
            sb.append(']');
            return sb.toString();
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u0015\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\r¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0004\u001a\u00020\u0003H\u0096Bø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u0003H\u0082@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u0005J\u0010\u0010\u000b\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\r8\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006@\u0007X\u0086\n¢\u0006\f\n\u0004\b\u0007\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$Itr;", "E", "Lkotlinx/coroutines/channels/ChannelIterator;", "", "hasNext", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "result", "hasNextResult", "(Ljava/lang/Object;)Z", "hasNextSuspend", HummerConstants.HUMMER_NEXT, "()Ljava/lang/Object;", "Lkotlinx/coroutines/channels/AbstractChannel;", "channel", "Lkotlinx/coroutines/channels/AbstractChannel;", "Ljava/lang/Object;", "setResult", "(Ljava/lang/Object;)V", "<init>", "(Lkotlinx/coroutines/channels/AbstractChannel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    static final class Itr<E> implements ChannelIterator<E> {
        public final AbstractChannel<E> channel;
        private Object result = AbstractChannelKt.POLL_FAILED;

        public Itr(AbstractChannel<E> abstractChannel) {
            this.channel = abstractChannel;
        }

        @JvmName(name = "setResult")
        public final void setResult(Object obj) {
            this.result = obj;
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public final Object hasNext(Continuation<? super Boolean> continuation) {
            if (this.result != AbstractChannelKt.POLL_FAILED) {
                return Boxing.boxBoolean(hasNextResult(this.result));
            }
            Object pollInternal = this.channel.pollInternal();
            this.result = pollInternal;
            return pollInternal != AbstractChannelKt.POLL_FAILED ? Boxing.boxBoolean(hasNextResult(this.result)) : hasNextSuspend(continuation);
        }

        private final boolean hasNextResult(Object result) {
            if (result instanceof Closed) {
                Closed closed = (Closed) result;
                if (closed.closeCause == null) {
                    return false;
                }
                throw StackTraceRecoveryKt.recoverStackTrace(closed.getReceiveException());
            }
            return true;
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public final E next() {
            E e = (E) this.result;
            if (e instanceof Closed) {
                throw StackTraceRecoveryKt.recoverStackTrace(((Closed) e).getReceiveException());
            }
            if (e != AbstractChannelKt.POLL_FAILED) {
                this.result = AbstractChannelKt.POLL_FAILED;
                return e;
            }
            throw new IllegalStateException("'hasNext' should be called prior to 'next' invocation");
        }

        private final Object hasNextSuspend(Continuation<? super Boolean> continuation) {
            CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(continuation));
            CancellableContinuationImpl cancellableContinuationImpl = orCreateCancellableContinuation;
            ReceiveHasNext receiveHasNext = new ReceiveHasNext(this, cancellableContinuationImpl);
            while (true) {
                ReceiveHasNext receiveHasNext2 = receiveHasNext;
                if (this.channel.enqueueReceive(receiveHasNext2)) {
                    this.channel.removeReceiveOnCancel(cancellableContinuationImpl, receiveHasNext2);
                    break;
                }
                Object pollInternal = this.channel.pollInternal();
                setResult(pollInternal);
                if (pollInternal instanceof Closed) {
                    Closed closed = (Closed) pollInternal;
                    if (closed.closeCause == null) {
                        Result.Companion companion = Result.INSTANCE;
                        cancellableContinuationImpl.resumeWith(Result.m3179constructorimpl(Boxing.boxBoolean(false)));
                    } else {
                        Result.Companion companion2 = Result.INSTANCE;
                        cancellableContinuationImpl.resumeWith(Result.m3179constructorimpl(ResultKt.createFailure(closed.getReceiveException())));
                    }
                } else if (pollInternal != AbstractChannelKt.POLL_FAILED) {
                    Boolean boxBoolean = Boxing.boxBoolean(true);
                    Function1<E, Unit> function1 = this.channel.onUndeliveredElement;
                    cancellableContinuationImpl.resume(boxBoolean, function1 != null ? OnUndeliveredElementKt.bindCancellationFun(function1, pollInternal, cancellableContinuationImpl.getContext()) : null);
                }
            }
            Object result = orCreateCancellableContinuation.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0012\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00010\u0002B\u001f\u0012\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\t\u001a\u00020\u00042\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0003\u001a\u00028\u00012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00168\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0011\u0010\u001a\u001a\u00020\u00198\u0006¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveElement;", "E", "Lkotlinx/coroutines/channels/Receive;", "value", "", "completeResumeReceive", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/channels/Closed;", "closed", "resumeReceiveClosed", "(Lkotlinx/coroutines/channels/Closed;)V", "", "resumeValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "otherOp", "Lkotlinx/coroutines/internal/Symbol;", "tryResumeReceive", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "Lkotlinx/coroutines/CancellableContinuation;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "receiveMode", "I", "<init>", "(Lkotlinx/coroutines/CancellableContinuation;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static class ReceiveElement<E> extends Receive<E> {
        public final CancellableContinuation<Object> cont;
        public final int receiveMode;

        public ReceiveElement(CancellableContinuation<Object> cancellableContinuation, int i) {
            this.cont = cancellableContinuation;
            this.receiveMode = i;
        }

        public final Object resumeValue(E value) {
            return this.receiveMode == 1 ? ChannelResult.m4634boximpl(ChannelResult.INSTANCE.m4647successJP2dKIU(value)) : value;
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public Symbol tryResumeReceive(E value, LockFreeLinkedListNode.PrepareOp otherOp) {
            Object tryResume = this.cont.tryResume(resumeValue(value), otherOp != null ? otherOp.desc : null, resumeOnCancellationFun(value));
            if (tryResume == null) {
                return null;
            }
            if (DebugKt.getASSERTIONS_ENABLED()) {
                if (!(tryResume == CancellableContinuationImplKt.RESUME_TOKEN)) {
                    throw new AssertionError();
                }
            }
            if (otherOp != null) {
                otherOp.finishPrepare();
            }
            return CancellableContinuationImplKt.RESUME_TOKEN;
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public void completeResumeReceive(E value) {
            this.cont.completeResume(CancellableContinuationImplKt.RESUME_TOKEN);
        }

        @Override // kotlinx.coroutines.channels.Receive
        public void resumeReceiveClosed(Closed<?> closed) {
            if (this.receiveMode != 1) {
                CancellableContinuation<Object> cancellableContinuation = this.cont;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m3179constructorimpl(ResultKt.createFailure(closed.getReceiveException())));
                return;
            }
            CancellableContinuation<Object> cancellableContinuation2 = this.cont;
            ChannelResult m4634boximpl = ChannelResult.m4634boximpl(ChannelResult.INSTANCE.m4645closedJP2dKIU(closed.closeCause));
            Result.Companion companion2 = Result.INSTANCE;
            cancellableContinuation2.resumeWith(Result.m3179constructorimpl(m4634boximpl));
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ReceiveElement@");
            sb.append(DebugStringsKt.getHexAddress(this));
            sb.append("[receiveMode=");
            sb.append(this.receiveMode);
            sb.append(']');
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00010\u0002B=\u0012\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00060\u0004j\b\u0012\u0004\u0012\u00028\u0001`\t¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0007\u0010\bR'\u0010\n\u001a\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00060\u0004j\b\u0012\u0004\u0012\u00028\u0001`\t8\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveElementWithUndeliveredHandler;", "E", "Lkotlinx/coroutines/channels/AbstractChannel$ReceiveElement;", "value", "Lkotlin/Function1;", "", "", "resumeOnCancellationFun", "(Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "Lkotlin/jvm/functions/Function1;", "Lkotlinx/coroutines/CancellableContinuation;", "", "cont", "", "receiveMode", "<init>", "(Lkotlinx/coroutines/CancellableContinuation;ILkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class ReceiveElementWithUndeliveredHandler<E> extends ReceiveElement<E> {
        public final Function1<E, Unit> onUndeliveredElement;

        /* JADX WARN: Multi-variable type inference failed */
        public ReceiveElementWithUndeliveredHandler(CancellableContinuation<Object> cancellableContinuation, int i, Function1<? super E, Unit> function1) {
            super(cancellableContinuation, i);
            this.onUndeliveredElement = function1;
        }

        @Override // kotlinx.coroutines.channels.Receive
        public final Function1<Throwable, Unit> resumeOnCancellationFun(E value) {
            return OnUndeliveredElementKt.bindCancellationFun(this.onUndeliveredElement, value, this.cont.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0012\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B#\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u001b\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\r\u001a\u00020\u00042\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0003\u001a\u00028\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u001b8\u0006¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveHasNext;", "E", "Lkotlinx/coroutines/channels/Receive;", "value", "", "completeResumeReceive", "(Ljava/lang/Object;)V", "Lkotlin/Function1;", "", "resumeOnCancellationFun", "(Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "Lkotlinx/coroutines/channels/Closed;", "closed", "resumeReceiveClosed", "(Lkotlinx/coroutines/channels/Closed;)V", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "otherOp", "Lkotlinx/coroutines/internal/Symbol;", "tryResumeReceive", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "Lkotlinx/coroutines/CancellableContinuation;", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "Lkotlinx/coroutines/channels/AbstractChannel$Itr;", "iterator", "Lkotlinx/coroutines/channels/AbstractChannel$Itr;", "<init>", "(Lkotlinx/coroutines/channels/AbstractChannel$Itr;Lkotlinx/coroutines/CancellableContinuation;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static class ReceiveHasNext<E> extends Receive<E> {
        public final CancellableContinuation<Boolean> cont;
        public final Itr<E> iterator;

        /* JADX WARN: Multi-variable type inference failed */
        public ReceiveHasNext(Itr<E> itr, CancellableContinuation<? super Boolean> cancellableContinuation) {
            this.iterator = itr;
            this.cont = cancellableContinuation;
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public Symbol tryResumeReceive(E value, LockFreeLinkedListNode.PrepareOp otherOp) {
            Object tryResume = this.cont.tryResume(Boolean.TRUE, otherOp != null ? otherOp.desc : null, resumeOnCancellationFun(value));
            if (tryResume == null) {
                return null;
            }
            if (DebugKt.getASSERTIONS_ENABLED()) {
                if (!(tryResume == CancellableContinuationImplKt.RESUME_TOKEN)) {
                    throw new AssertionError();
                }
            }
            if (otherOp != null) {
                otherOp.finishPrepare();
            }
            return CancellableContinuationImplKt.RESUME_TOKEN;
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public void completeResumeReceive(E value) {
            this.iterator.setResult(value);
            this.cont.completeResume(CancellableContinuationImplKt.RESUME_TOKEN);
        }

        @Override // kotlinx.coroutines.channels.Receive
        public void resumeReceiveClosed(Closed<?> closed) {
            Object tryResumeWithException;
            if (closed.closeCause == null) {
                tryResumeWithException = CancellableContinuation.DefaultImpls.tryResume$default(this.cont, Boolean.FALSE, null, 2, null);
            } else {
                tryResumeWithException = this.cont.tryResumeWithException(closed.getReceiveException());
            }
            if (tryResumeWithException != null) {
                this.iterator.setResult(closed);
                this.cont.completeResume(tryResumeWithException);
            }
        }

        @Override // kotlinx.coroutines.channels.Receive
        public Function1<Throwable, Unit> resumeOnCancellationFun(E value) {
            Function1<E, Unit> function1 = this.iterator.channel.onUndeliveredElement;
            if (function1 != null) {
                return OnUndeliveredElementKt.bindCancellationFun(function1, value, this.cont.getContext());
            }
            return null;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ReceiveHasNext@");
            sb.append(DebugStringsKt.getHexAddress(this));
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u0001*\u0004\b\u0002\u0010\u00022\b\u0012\u0004\u0012\u00028\u00020\u00032\u00020\u0004BT\u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00020 \u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00010&\u0012$\u0010\u001e\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001b\u0012\u0006\u0010$\u001a\u00020#ø\u0001\u0000¢\u0006\u0004\b)\u0010*J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ%\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00028\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0011\u001a\u00020\u00062\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0005\u001a\u00028\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR2\u0010\u001e\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001b8\u0006ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00020 8\u0006¢\u0006\u0006\n\u0004\b!\u0010\"R\u0011\u0010$\u001a\u00020#8\u0006¢\u0006\u0006\n\u0004\b$\u0010%R\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00010&8\u0006¢\u0006\u0006\n\u0004\b'\u0010(\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveSelect;", "R", "E", "Lkotlinx/coroutines/channels/Receive;", "Lkotlinx/coroutines/DisposableHandle;", "value", "", "completeResumeReceive", "(Ljava/lang/Object;)V", "dispose", "()V", "Lkotlin/Function1;", "", "resumeOnCancellationFun", "(Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "Lkotlinx/coroutines/channels/Closed;", "closed", "resumeReceiveClosed", "(Lkotlinx/coroutines/channels/Closed;)V", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "otherOp", "Lkotlinx/coroutines/internal/Symbol;", "tryResumeReceive", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "Lkotlin/Function2;", "", "Lkotlin/coroutines/Continuation;", "block", "Lkotlin/jvm/functions/Function2;", "Lkotlinx/coroutines/channels/AbstractChannel;", "channel", "Lkotlinx/coroutines/channels/AbstractChannel;", "", "receiveMode", "I", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "<init>", "(Lkotlinx/coroutines/channels/AbstractChannel;Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class ReceiveSelect<R, E> extends Receive<E> implements DisposableHandle {
        public final Function2<Object, Continuation<? super R>, Object> block;
        public final AbstractChannel<E> channel;
        public final int receiveMode;
        public final SelectInstance<R> select;

        /* JADX WARN: Multi-variable type inference failed */
        public ReceiveSelect(AbstractChannel<E> abstractChannel, SelectInstance<? super R> selectInstance, Function2<Object, ? super Continuation<? super R>, ? extends Object> function2, int i) {
            this.channel = abstractChannel;
            this.select = selectInstance;
            this.block = function2;
            this.receiveMode = i;
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public final Symbol tryResumeReceive(E value, LockFreeLinkedListNode.PrepareOp otherOp) {
            return (Symbol) this.select.trySelectOther(otherOp);
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public final void completeResumeReceive(E value) {
            CancellableKt.startCoroutineCancellable(this.block, this.receiveMode == 1 ? ChannelResult.m4634boximpl(ChannelResult.INSTANCE.m4647successJP2dKIU(value)) : value, this.select.getCompletion(), resumeOnCancellationFun(value));
        }

        @Override // kotlinx.coroutines.channels.Receive
        public final void resumeReceiveClosed(Closed<?> closed) {
            if (this.select.trySelect()) {
                int i = this.receiveMode;
                if (i == 0) {
                    this.select.resumeSelectWithException(closed.getReceiveException());
                } else if (i == 1) {
                    CancellableKt.startCoroutineCancellable$default(this.block, ChannelResult.m4634boximpl(ChannelResult.INSTANCE.m4645closedJP2dKIU(closed.closeCause)), this.select.getCompletion(), null, 4, null);
                }
            }
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public final void dispose() {
            if (mo4660remove()) {
                this.channel.onReceiveDequeued();
            }
        }

        @Override // kotlinx.coroutines.channels.Receive
        public final Function1<Throwable, Unit> resumeOnCancellationFun(E value) {
            Function1<E, Unit> function1 = this.channel.onUndeliveredElement;
            if (function1 != null) {
                return OnUndeliveredElementKt.bindCancellationFun(function1, value, this.select.getCompletion().getContext());
            }
            return null;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ReceiveSelect@");
            sb.append(DebugStringsKt.getHexAddress(this));
            sb.append('[');
            sb.append(this.select);
            sb.append(",receiveMode=");
            sb.append(this.receiveMode);
            sb.append(']');
            return sb.toString();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [kotlinx.coroutines.channels.AbstractChannel$ReceiveElement] */
    private final <R> Object receiveSuspend(int i, Continuation<? super R> continuation) {
        ReceiveElementWithUndeliveredHandler receiveElementWithUndeliveredHandler;
        CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(continuation));
        CancellableContinuationImpl cancellableContinuationImpl = orCreateCancellableContinuation;
        if (this.onUndeliveredElement == null) {
            receiveElementWithUndeliveredHandler = new ReceiveElement(cancellableContinuationImpl, i);
        } else {
            receiveElementWithUndeliveredHandler = new ReceiveElementWithUndeliveredHandler(cancellableContinuationImpl, i, this.onUndeliveredElement);
        }
        while (true) {
            ReceiveElementWithUndeliveredHandler receiveElementWithUndeliveredHandler2 = receiveElementWithUndeliveredHandler;
            if (enqueueReceive(receiveElementWithUndeliveredHandler2)) {
                removeReceiveOnCancel(cancellableContinuationImpl, receiveElementWithUndeliveredHandler2);
                break;
            }
            Object pollInternal = pollInternal();
            if (pollInternal instanceof Closed) {
                receiveElementWithUndeliveredHandler.resumeReceiveClosed((Closed) pollInternal);
                break;
            } else if (pollInternal != AbstractChannelKt.POLL_FAILED) {
                cancellableContinuationImpl.resume(receiveElementWithUndeliveredHandler.resumeValue(pollInternal), receiveElementWithUndeliveredHandler.resumeOnCancellationFun(pollInternal));
                break;
            }
        }
        Object result = orCreateCancellableContinuation.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* renamed from: onCancelIdempotentList-w-w6eGU  reason: not valid java name */
    protected void mo4631onCancelIdempotentListww6eGU(Object list, Closed<?> closed) {
        if (list != null) {
            if (!(list instanceof ArrayList)) {
                ((Send) list).resumeSendClosed(closed);
            } else if (list != null) {
                ArrayList arrayList = (ArrayList) list;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ((Send) arrayList.get(size)).resumeSendClosed(closed);
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            }
        }
    }
}
