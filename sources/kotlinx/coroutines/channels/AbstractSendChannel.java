package kotlinx.coroutines.channels;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import com.alibaba.griver.beehive.lottie.player.LottieParams;
import com.alipay.android.phone.mobilesdk.socketcraft.monitor.DataflowMonitorModel;
import id.dana.cashier.view.InputCardNumberView;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.LockFreeLinkedList_commonKt;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;

@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0004bcdeB)\u0012 \u0010X\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001a\u0018\u00010 j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`W¢\u0006\u0004\ba\u0010$J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000e\u001a\u000e\u0012\u0002\b\u00030\fj\u0006\u0012\u0002\b\u0003`\r2\u0006\u0010\u000b\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00102\u0006\u0010\u000b\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u001b\u001a\u00020\u001a2\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u0018H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ#\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00028\u00002\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u0018H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001b\u0010\u001d\u001a\u00020\u00032\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u0018H\u0002¢\u0006\u0004\b\u001d\u0010\u001fJ)\u0010#\u001a\u00020\u001a2\u0018\u0010\"\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u001a0 j\u0002`!H\u0016¢\u0006\u0004\b#\u0010$J\u0019\u0010%\u001a\u00020\u001a2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00028\u0000H\u0014¢\u0006\u0004\b'\u0010(J#\u0010+\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00028\u00002\n\u0010*\u001a\u0006\u0012\u0002\b\u00030)H\u0014¢\u0006\u0004\b+\u0010,J\u0017\u0010.\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020-H\u0014¢\u0006\u0004\b.\u0010/JX\u00104\u001a\u00020\u001a\"\u0004\b\u0001\u001002\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00010)2\u0006\u0010\u000b\u001a\u00028\u00002(\u00103\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u000102\u0012\u0006\u0012\u0004\u0018\u00010\u001501H\u0002ø\u0001\u0000¢\u0006\u0004\b4\u00105J\u001b\u0010\u0014\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00028\u0000H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0014\u00106J\u001d\u00108\u001a\b\u0012\u0002\b\u0003\u0018\u0001072\u0006\u0010\u000b\u001a\u00028\u0000H\u0004¢\u0006\u0004\b8\u00109J\u001b\u0010:\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0004\b:\u00106J\u0017\u0010;\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u000107H\u0014¢\u0006\u0004\b;\u0010<J\u0011\u0010=\u001a\u0004\u0018\u00010\u0013H\u0004¢\u0006\u0004\b=\u0010>J\u000f\u0010@\u001a\u00020?H\u0016¢\u0006\u0004\b@\u0010AJ\u001e\u0010D\u001a\b\u0012\u0004\u0012\u00020\u001a0B2\u0006\u0010\u000b\u001a\u00028\u0000ø\u0001\u0001¢\u0006\u0004\bC\u0010(J+\u0010E\u001a\u00020\u001a*\u0006\u0012\u0002\b\u0003022\u0006\u0010\u000b\u001a\u00028\u00002\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u0018H\u0002¢\u0006\u0004\bE\u0010FR\u0014\u0010H\u001a\u00020?8UX\u0094\u0004¢\u0006\u0006\u001a\u0004\bG\u0010AR\u001a\u0010K\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00188EX\u0084\u0004¢\u0006\u0006\u001a\u0004\bI\u0010JR\u001a\u0010M\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00188EX\u0084\u0004¢\u0006\u0006\u001a\u0004\bL\u0010JR\u0014\u0010N\u001a\u00020\u00058%X¤\u0004¢\u0006\u0006\u001a\u0004\bN\u0010OR\u0014\u0010P\u001a\u00020\u00058%X¤\u0004¢\u0006\u0006\u001a\u0004\bP\u0010OR\u0011\u0010Q\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\bQ\u0010OR\u0014\u0010R\u001a\u00020\u00058CX\u0082\u0004¢\u0006\u0006\u001a\u0004\bR\u0010OR#\u0010V\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020S8G¢\u0006\u0006\u001a\u0004\bT\u0010UR.\u0010X\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001a\u0018\u00010 j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`W8\u0004X\u0085\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u001a\u0010[\u001a\u00020Z8\u0005X\u0085\u0004¢\u0006\f\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^R\u0014\u0010`\u001a\u00020?8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b_\u0010A\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel;", "E", "Lkotlinx/coroutines/channels/SendChannel;", "", "cause", "", "close", "(Ljava/lang/Throwable;)Z", "", "countQueueSize", "()I", LottieParams.KEY_ELEMENT_ID, "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/internal/AddLastDesc;", "describeSendBuffered", "(Ljava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/channels/AbstractSendChannel$TryOfferDesc;", "describeTryOffer", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/AbstractSendChannel$TryOfferDesc;", "Lkotlinx/coroutines/channels/Send;", DataflowMonitorModel.METHOD_NAME_SEND, "", "enqueueSend", "(Lkotlinx/coroutines/channels/Send;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/Closed;", "closed", "", "helpClose", "(Lkotlinx/coroutines/channels/Closed;)V", "helpCloseAndGetSendException", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/Closed;)Ljava/lang/Throwable;", "(Lkotlinx/coroutines/channels/Closed;)Ljava/lang/Throwable;", "Lkotlin/Function1;", "Lkotlinx/coroutines/channels/Handler;", "handler", "invokeOnClose", "(Lkotlin/jvm/functions/Function1;)V", "invokeOnCloseHandler", "(Ljava/lang/Throwable;)V", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "offerSelectInternal", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "onClosedIdempotent", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "R", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "block", "registerSelectSend", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "sendBuffered", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/ReceiveOrClosed;", "sendSuspend", "takeFirstReceiveOrPeekClosed", "()Lkotlinx/coroutines/channels/ReceiveOrClosed;", "takeFirstSendOrPeekClosed", "()Lkotlinx/coroutines/channels/Send;", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "trySend", "helpCloseAndResumeWithSendException", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;Lkotlinx/coroutines/channels/Closed;)V", "getBufferDebugString", "bufferDebugString", "getClosedForReceive", "()Lkotlinx/coroutines/channels/Closed;", "closedForReceive", "getClosedForSend", "closedForSend", "isBufferAlwaysFull", "()Z", "isBufferFull", "isClosedForSend", "isFullImpl", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "Lkotlin/jvm/functions/Function1;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", SemanticAttributes.MessagingDestinationKindValues.QUEUE, "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "getQueue", "()Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "getQueueDebugStateString", "queueDebugStateString", "<init>", "SendBuffered", "SendBufferedDesc", "SendSelect", "TryOfferDesc"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public abstract class AbstractSendChannel<E> implements SendChannel<E> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater onCloseHandler$FU = AtomicReferenceFieldUpdater.newUpdater(AbstractSendChannel.class, Object.class, "onCloseHandler");
    protected final Function1<E, Unit> onUndeliveredElement;
    private final LockFreeLinkedListHead queue = new LockFreeLinkedListHead();
    private volatile /* synthetic */ Object onCloseHandler = null;

    @JvmName(name = "getBufferDebugString")
    protected String getBufferDebugString() {
        return "";
    }

    @JvmName(name = "isBufferAlwaysFull")
    protected abstract boolean isBufferAlwaysFull();

    @JvmName(name = "isBufferFull")
    public abstract boolean isBufferFull();

    protected void onClosedIdempotent(LockFreeLinkedListNode closed) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AbstractSendChannel(Function1<? super E, Unit> function1) {
        this.onUndeliveredElement = function1;
    }

    @JvmName(name = "getQueue")
    public final LockFreeLinkedListHead getQueue() {
        return this.queue;
    }

    public Object offerInternal(E r4) {
        ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed;
        Symbol tryResumeReceive;
        do {
            takeFirstReceiveOrPeekClosed = takeFirstReceiveOrPeekClosed();
            if (takeFirstReceiveOrPeekClosed == null) {
                return AbstractChannelKt.OFFER_FAILED;
            }
            tryResumeReceive = takeFirstReceiveOrPeekClosed.tryResumeReceive(r4, null);
        } while (tryResumeReceive == null);
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(tryResumeReceive == CancellableContinuationImplKt.RESUME_TOKEN)) {
                throw new AssertionError();
            }
        }
        takeFirstReceiveOrPeekClosed.completeResumeReceive(r4);
        return takeFirstReceiveOrPeekClosed.getOfferResult();
    }

    public Object offerSelectInternal(E r3, SelectInstance<?> select) {
        TryOfferDesc<E> describeTryOffer = describeTryOffer(r3);
        Object performAtomicTrySelect = select.performAtomicTrySelect(describeTryOffer);
        if (performAtomicTrySelect != null) {
            return performAtomicTrySelect;
        }
        ReceiveOrClosed<? super E> result = describeTryOffer.getResult();
        result.completeResumeReceive(r3);
        return result.getOfferResult();
    }

    @JvmName(name = "getClosedForSend")
    public final Closed<?> getClosedForSend() {
        LockFreeLinkedListNode prevNode = this.queue.getPrevNode();
        Closed<?> closed = prevNode instanceof Closed ? (Closed) prevNode : null;
        if (closed != null) {
            helpClose(closed);
            return closed;
        }
        return null;
    }

    @JvmName(name = "getClosedForReceive")
    public final Closed<?> getClosedForReceive() {
        LockFreeLinkedListNode nextNode = this.queue.getNextNode();
        Closed<?> closed = nextNode instanceof Closed ? (Closed) nextNode : null;
        if (closed != null) {
            helpClose(closed);
            return closed;
        }
        return null;
    }

    public final Send takeFirstSendOrPeekClosed() {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        LockFreeLinkedListNode removeOrNext;
        LockFreeLinkedListHead lockFreeLinkedListHead = this.queue;
        while (true) {
            lockFreeLinkedListNode = (LockFreeLinkedListNode) lockFreeLinkedListHead.getNext();
            if (lockFreeLinkedListNode != lockFreeLinkedListHead && (lockFreeLinkedListNode instanceof Send)) {
                if (((((Send) lockFreeLinkedListNode) instanceof Closed) && !lockFreeLinkedListNode.isRemoved()) || (removeOrNext = lockFreeLinkedListNode.removeOrNext()) == null) {
                    break;
                }
                removeOrNext.helpRemovePrev();
            }
        }
        lockFreeLinkedListNode = null;
        return (Send) lockFreeLinkedListNode;
    }

    public final ReceiveOrClosed<?> sendBuffered(E r4) {
        LockFreeLinkedListNode prevNode;
        LockFreeLinkedListHead lockFreeLinkedListHead = this.queue;
        SendBuffered sendBuffered = new SendBuffered(r4);
        do {
            prevNode = lockFreeLinkedListHead.getPrevNode();
            if (prevNode instanceof ReceiveOrClosed) {
                return (ReceiveOrClosed) prevNode;
            }
        } while (!prevNode.addNext(sendBuffered, lockFreeLinkedListHead));
        return null;
    }

    public final LockFreeLinkedListNode.AddLastDesc<?> describeSendBuffered(E r3) {
        return new SendBufferedDesc(this.queue, r3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0012\u0018\u0000*\u0004\b\u0001\u0010\u00012\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00030\u0002j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0003`\u0004B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00028\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel$SendBufferedDesc;", "E", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/channels/AbstractSendChannel$SendBuffered;", "Lkotlinx/coroutines/internal/AddLastDesc;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "affected", "", "failure", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", SemanticAttributes.MessagingDestinationKindValues.QUEUE, LottieParams.KEY_ELEMENT_ID, "<init>", "(Lkotlinx/coroutines/internal/LockFreeLinkedListHead;Ljava/lang/Object;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static class SendBufferedDesc<E> extends LockFreeLinkedListNode.AddLastDesc<SendBuffered<? extends E>> {
        public SendBufferedDesc(LockFreeLinkedListHead lockFreeLinkedListHead, E e) {
            super(lockFreeLinkedListHead, new SendBuffered(e));
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public Object failure(LockFreeLinkedListNode affected) {
            if (affected instanceof Closed) {
                return affected;
            }
            if (affected instanceof ReceiveOrClosed) {
                return AbstractChannelKt.OFFER_FAILED;
            }
            return null;
        }
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @JvmName(name = "isClosedForSend")
    public final boolean isClosedForSend() {
        return getClosedForSend() != null;
    }

    @JvmName(name = "isFullImpl")
    public final boolean isFullImpl() {
        return !(this.queue.getNextNode() instanceof ReceiveOrClosed) && isBufferFull();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final Object send(E e, Continuation<? super Unit> continuation) {
        Object sendSuspend;
        return (offerInternal(e) != AbstractChannelKt.OFFER_SUCCESS && (sendSuspend = sendSuspend(e, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? sendSuspend : Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* renamed from: trySend-JP2dKIU */
    public final Object mo42trySendJP2dKIU(E r3) {
        Object offerInternal = offerInternal(r3);
        if (offerInternal == AbstractChannelKt.OFFER_SUCCESS) {
            return ChannelResult.INSTANCE.m4647successJP2dKIU(Unit.INSTANCE);
        }
        if (offerInternal == AbstractChannelKt.OFFER_FAILED) {
            Closed<?> closedForSend = getClosedForSend();
            return closedForSend == null ? ChannelResult.INSTANCE.m4646failurePtdJZtk() : ChannelResult.INSTANCE.m4645closedJP2dKIU(helpCloseAndGetSendException(closedForSend));
        } else if (offerInternal instanceof Closed) {
            return ChannelResult.INSTANCE.m4645closedJP2dKIU(helpCloseAndGetSendException((Closed) offerInternal));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("trySend returned ");
            sb.append(offerInternal);
            throw new IllegalStateException(sb.toString().toString());
        }
    }

    private final Throwable helpCloseAndGetSendException(Closed<?> closed) {
        helpClose(closed);
        return closed.getSendException();
    }

    private final Throwable helpCloseAndGetSendException(E r4, Closed<?> closed) {
        UndeliveredElementException callUndeliveredElementCatchingException$default;
        helpClose(closed);
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        if (function1 != null && (callUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, r4, null, 2, null)) != null) {
            ExceptionsKt.addSuppressed(callUndeliveredElementCatchingException$default, closed.getSendException());
            throw callUndeliveredElementCatchingException$default;
        }
        return closed.getSendException();
    }

    public final void helpCloseAndResumeWithSendException(Continuation<?> continuation, E e, Closed<?> closed) {
        UndeliveredElementException callUndeliveredElementCatchingException$default;
        helpClose(closed);
        Throwable sendException = closed.getSendException();
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        if (function1 != null && (callUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, e, null, 2, null)) != null) {
            UndeliveredElementException undeliveredElementException = callUndeliveredElementCatchingException$default;
            ExceptionsKt.addSuppressed(undeliveredElementException, sendException);
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m3179constructorimpl(ResultKt.createFailure(undeliveredElementException)));
            return;
        }
        Result.Companion companion2 = Result.INSTANCE;
        continuation.resumeWith(Result.m3179constructorimpl(ResultKt.createFailure(sendException)));
    }

    public Object enqueueSend(Send r5) {
        boolean z;
        LockFreeLinkedListNode prevNode;
        if (isBufferAlwaysFull()) {
            LockFreeLinkedListHead lockFreeLinkedListHead = this.queue;
            do {
                prevNode = lockFreeLinkedListHead.getPrevNode();
                if (prevNode instanceof ReceiveOrClosed) {
                    return prevNode;
                }
            } while (!prevNode.addNext(r5, lockFreeLinkedListHead));
            return null;
        }
        LockFreeLinkedListHead lockFreeLinkedListHead2 = this.queue;
        final Send send = r5;
        LockFreeLinkedListNode.CondAddOp condAddOp = new LockFreeLinkedListNode.CondAddOp(send) { // from class: kotlinx.coroutines.channels.AbstractSendChannel$enqueueSend$$inlined$addLastIfPrevAndIf$1
            @Override // kotlinx.coroutines.internal.AtomicOp
            public final Object prepare(LockFreeLinkedListNode affected) {
                if (this.isBufferFull()) {
                    return null;
                }
                return LockFreeLinkedListKt.getCONDITION_FALSE();
            }
        };
        while (true) {
            LockFreeLinkedListNode prevNode2 = lockFreeLinkedListHead2.getPrevNode();
            if (prevNode2 instanceof ReceiveOrClosed) {
                return prevNode2;
            }
            int tryCondAddNext = prevNode2.tryCondAddNext(send, lockFreeLinkedListHead2, condAddOp);
            z = true;
            if (tryCondAddNext == 1) {
                break;
            } else if (tryCondAddNext == 2) {
                z = false;
                break;
            }
        }
        if (z) {
            return null;
        }
        return AbstractChannelKt.ENQUEUE_FAILED;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable cause) {
        boolean z;
        Closed<?> closed = new Closed<>(cause);
        LockFreeLinkedListHead lockFreeLinkedListHead = this.queue;
        while (true) {
            LockFreeLinkedListNode prevNode = lockFreeLinkedListHead.getPrevNode();
            z = true;
            if ((!(prevNode instanceof Closed)) != true) {
                z = false;
                break;
            } else if (prevNode.addNext(closed, lockFreeLinkedListHead)) {
                break;
            }
        }
        if (!z) {
            closed = (Closed) this.queue.getPrevNode();
        }
        helpClose(closed);
        if (z) {
            invokeOnCloseHandler(cause);
        }
        return z;
    }

    private final void invokeOnCloseHandler(Throwable cause) {
        Object obj = this.onCloseHandler;
        if (obj == null || obj == AbstractChannelKt.HANDLER_INVOKED || !AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(onCloseHandler$FU, this, obj, AbstractChannelKt.HANDLER_INVOKED)) {
            return;
        }
        ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 1)).invoke(cause);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* renamed from: invokeOnClose */
    public void mo4671invokeOnClose(Function1<? super Throwable, Unit> handler) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = onCloseHandler$FU;
        if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(atomicReferenceFieldUpdater, this, null, handler)) {
            Object obj = this.onCloseHandler;
            if (obj == AbstractChannelKt.HANDLER_INVOKED) {
                throw new IllegalStateException("Another handler was already registered and successfully invoked");
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Another handler was already registered: ");
            sb.append(obj);
            throw new IllegalStateException(sb.toString());
        }
        Closed<?> closedForSend = getClosedForSend();
        if (closedForSend == null || !AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(atomicReferenceFieldUpdater, this, handler, AbstractChannelKt.HANDLER_INVOKED)) {
            return;
        }
        handler.invoke(closedForSend.closeCause);
    }

    private final void helpClose(Closed<?> closed) {
        Object m4654constructorimpl$default = InlineList.m4654constructorimpl$default(null, 1, null);
        while (true) {
            LockFreeLinkedListNode prevNode = closed.getPrevNode();
            Receive receive = prevNode instanceof Receive ? (Receive) prevNode : null;
            if (receive == null) {
                break;
            } else if (!receive.mo4660remove()) {
                receive.helpRemove();
            } else {
                m4654constructorimpl$default = InlineList.m4657plusFjFbRPM(m4654constructorimpl$default, receive);
            }
        }
        if (m4654constructorimpl$default != null) {
            if (!(m4654constructorimpl$default instanceof ArrayList)) {
                ((Receive) m4654constructorimpl$default).resumeReceiveClosed(closed);
            } else if (m4654constructorimpl$default != null) {
                ArrayList arrayList = (ArrayList) m4654constructorimpl$default;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ((Receive) arrayList.get(size)).resumeReceiveClosed(closed);
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            }
        }
        onClosedIdempotent(closed);
    }

    public ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed() {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        LockFreeLinkedListNode removeOrNext;
        LockFreeLinkedListHead lockFreeLinkedListHead = this.queue;
        while (true) {
            lockFreeLinkedListNode = (LockFreeLinkedListNode) lockFreeLinkedListHead.getNext();
            if (lockFreeLinkedListNode != lockFreeLinkedListHead && (lockFreeLinkedListNode instanceof ReceiveOrClosed)) {
                if (((((ReceiveOrClosed) lockFreeLinkedListNode) instanceof Closed) && !lockFreeLinkedListNode.isRemoved()) || (removeOrNext = lockFreeLinkedListNode.removeOrNext()) == null) {
                    break;
                }
                removeOrNext.helpRemovePrev();
            }
        }
        lockFreeLinkedListNode = null;
        return (ReceiveOrClosed) lockFreeLinkedListNode;
    }

    public final TryOfferDesc<E> describeTryOffer(E r3) {
        return new TryOfferDesc<>(r3, this.queue);
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00030\u0002j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0003`\u0004B\u0017\u0012\u0006\u0010\u000f\u001a\u00028\u0001\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\r\u001a\u0004\u0018\u00010\u00072\n\u0010\f\u001a\u00060\nj\u0002`\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00028\u00018\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel$TryOfferDesc;", "E", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "Lkotlinx/coroutines/internal/RemoveFirstDesc;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "affected", "", "failure", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "Lkotlinx/coroutines/internal/PrepareOp;", "prepareOp", "onPrepare", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Ljava/lang/Object;", LottieParams.KEY_ELEMENT_ID, "Ljava/lang/Object;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", SemanticAttributes.MessagingDestinationKindValues.QUEUE, "<init>", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListHead;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class TryOfferDesc<E> extends LockFreeLinkedListNode.RemoveFirstDesc<ReceiveOrClosed<? super E>> {
        public final E element;

        public TryOfferDesc(E e, LockFreeLinkedListHead lockFreeLinkedListHead) {
            super(lockFreeLinkedListHead);
            this.element = e;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.RemoveFirstDesc, kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final Object failure(LockFreeLinkedListNode affected) {
            if (affected instanceof Closed) {
                return affected;
            }
            if (affected instanceof ReceiveOrClosed) {
                return null;
            }
            return AbstractChannelKt.OFFER_FAILED;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final Object onPrepare(LockFreeLinkedListNode.PrepareOp prepareOp) {
            Symbol tryResumeReceive = ((ReceiveOrClosed) prepareOp.affected).tryResumeReceive(this.element, prepareOp);
            if (tryResumeReceive == null) {
                return LockFreeLinkedList_commonKt.REMOVE_PREPARED;
            }
            if (tryResumeReceive == AtomicKt.RETRY_ATOMIC) {
                return AtomicKt.RETRY_ATOMIC;
            }
            if (DebugKt.getASSERTIONS_ENABLED()) {
                if (tryResumeReceive == CancellableContinuationImplKt.RESUME_TOKEN) {
                    return null;
                }
                throw new AssertionError();
            }
            return null;
        }
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @JvmName(name = "getOnSend")
    public final SelectClause2<E, SendChannel<E>> getOnSend() {
        return (SelectClause2) ((SelectClause2<E, SendChannel<? super E>>) new SelectClause2<E, SendChannel<? super E>>(this) { // from class: kotlinx.coroutines.channels.AbstractSendChannel$onSend$1
            final /* synthetic */ AbstractSendChannel<E> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.this$0 = this;
            }

            @Override // kotlinx.coroutines.selects.SelectClause2
            public final <R> void registerSelectClause2(SelectInstance<? super R> select, E param, Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> block) {
                this.this$0.registerSelectSend(select, param, block);
            }
        });
    }

    public final <R> void registerSelectSend(SelectInstance<? super R> select, E r4, Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> block) {
        while (!select.isSelected()) {
            if (isFullImpl()) {
                SendSelect sendSelect = new SendSelect(r4, this, select, block);
                Object enqueueSend = enqueueSend(sendSelect);
                if (enqueueSend == null) {
                    select.disposeOnSelect(sendSelect);
                    return;
                } else if (enqueueSend instanceof Closed) {
                    throw StackTraceRecoveryKt.recoverStackTrace(helpCloseAndGetSendException(r4, (Closed) enqueueSend));
                } else {
                    if (enqueueSend != AbstractChannelKt.ENQUEUE_FAILED && !(enqueueSend instanceof Receive)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("enqueueSend returned ");
                        sb.append(enqueueSend);
                        sb.append(InputCardNumberView.DIVIDER);
                        throw new IllegalStateException(sb.toString().toString());
                    }
                }
            }
            Object offerSelectInternal = offerSelectInternal(r4, select);
            if (offerSelectInternal == SelectKt.getALREADY_SELECTED()) {
                return;
            }
            if (offerSelectInternal != AbstractChannelKt.OFFER_FAILED && offerSelectInternal != AtomicKt.RETRY_ATOMIC) {
                if (offerSelectInternal == AbstractChannelKt.OFFER_SUCCESS) {
                    UndispatchedKt.startCoroutineUnintercepted(block, this, select.getCompletion());
                    return;
                } else if (offerSelectInternal instanceof Closed) {
                    throw StackTraceRecoveryKt.recoverStackTrace(helpCloseAndGetSendException(r4, (Closed) offerSelectInternal));
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("offerSelectInternal returned ");
                    sb2.append(offerSelectInternal);
                    throw new IllegalStateException(sb2.toString().toString());
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DebugStringsKt.getClassSimpleName(this));
        sb.append('@');
        sb.append(DebugStringsKt.getHexAddress(this));
        sb.append('{');
        sb.append(getQueueDebugStateString());
        sb.append('}');
        sb.append(getBufferDebugString());
        return sb.toString();
    }

    @JvmName(name = "getQueueDebugStateString")
    private final String getQueueDebugStateString() {
        String obj;
        LockFreeLinkedListNode nextNode = this.queue.getNextNode();
        if (nextNode == this.queue) {
            return "EmptyQueue";
        }
        if (nextNode instanceof Closed) {
            obj = nextNode.toString();
        } else if (nextNode instanceof Receive) {
            obj = "ReceiveQueued";
        } else if (nextNode instanceof Send) {
            obj = "SendQueued";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("UNEXPECTED:");
            sb.append(nextNode);
            obj = sb.toString();
        }
        LockFreeLinkedListNode prevNode = this.queue.getPrevNode();
        if (prevNode != nextNode) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(obj);
            sb2.append(",queueSize=");
            sb2.append(countQueueSize());
            String obj2 = sb2.toString();
            if (prevNode instanceof Closed) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(obj2);
                sb3.append(",closedForSend=");
                sb3.append(prevNode);
                return sb3.toString();
            }
            return obj2;
        }
        return obj;
    }

    private final int countQueueSize() {
        LockFreeLinkedListHead lockFreeLinkedListHead = this.queue;
        int i = 0;
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) lockFreeLinkedListHead.getNext(); !Intrinsics.areEqual(lockFreeLinkedListNode, lockFreeLinkedListHead); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
            if (lockFreeLinkedListNode instanceof LockFreeLinkedListNode) {
                i++;
            }
        }
        return i;
    }

    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u0001*\u0004\b\u0002\u0010\u00022\u00020\u00032\u00020\u0004BX\u0012\u0006\u0010\u001f\u001a\u00028\u0001\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00010\u001c\u0012\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00020#\u0012(\u0010\u001a\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0016ø\u0001\u0000¢\u0006\u0004\b&\u0010'J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u001b\u0010\u000b\u001a\u00020\u00052\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u0007R6\u0010\u001a\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00168\u0006ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00010\u001c8\u0006¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00028\u00018\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00020#8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b$\u0010%\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel$SendSelect;", "E", "R", "Lkotlinx/coroutines/channels/Send;", "Lkotlinx/coroutines/DisposableHandle;", "", "completeResumeSend", "()V", "dispose", "Lkotlinx/coroutines/channels/Closed;", "closed", "resumeSendClosed", "(Lkotlinx/coroutines/channels/Closed;)V", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "otherOp", "Lkotlinx/coroutines/internal/Symbol;", "tryResumeSend", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "undeliveredElement", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlin/coroutines/Continuation;", "", "block", "Lkotlin/jvm/functions/Function2;", "Lkotlinx/coroutines/channels/AbstractSendChannel;", "channel", "Lkotlinx/coroutines/channels/AbstractSendChannel;", "pollResult", "Ljava/lang/Object;", "getPollResult", "()Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "<init>", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/AbstractSendChannel;Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class SendSelect<E, R> extends Send implements DisposableHandle {
        public final Function2<SendChannel<? super E>, Continuation<? super R>, Object> block;
        public final AbstractSendChannel<E> channel;
        private final E pollResult;
        public final SelectInstance<R> select;

        @Override // kotlinx.coroutines.channels.Send
        @JvmName(name = "getPollResult")
        /* renamed from: getPollResult */
        public final E getElement() {
            return this.pollResult;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public SendSelect(E e, AbstractSendChannel<E> abstractSendChannel, SelectInstance<? super R> selectInstance, Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> function2) {
            this.pollResult = e;
            this.channel = abstractSendChannel;
            this.select = selectInstance;
            this.block = function2;
        }

        @Override // kotlinx.coroutines.channels.Send
        public final Symbol tryResumeSend(LockFreeLinkedListNode.PrepareOp otherOp) {
            return (Symbol) this.select.trySelectOther(otherOp);
        }

        @Override // kotlinx.coroutines.channels.Send
        public final void completeResumeSend() {
            CancellableKt.startCoroutineCancellable$default(this.block, this.channel, this.select.getCompletion(), null, 4, null);
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public final void dispose() {
            if (mo4660remove()) {
                undeliveredElement();
            }
        }

        @Override // kotlinx.coroutines.channels.Send
        public final void resumeSendClosed(Closed<?> closed) {
            if (this.select.trySelect()) {
                this.select.resumeSelectWithException(closed.getSendException());
            }
        }

        @Override // kotlinx.coroutines.channels.Send
        public final void undeliveredElement() {
            Function1<E, Unit> function1 = this.channel.onUndeliveredElement;
            if (function1 != null) {
                OnUndeliveredElementKt.callUndeliveredElement(function1, getElement(), this.select.getCompletion().get$context());
            }
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("SendSelect@");
            sb.append(DebugStringsKt.getHexAddress(this));
            sb.append('(');
            sb.append(getElement());
            sb.append(")[");
            sb.append(this.channel);
            sb.append(", ");
            sb.append(this.select);
            sb.append(']');
            return sb.toString();
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0012\u001a\u00028\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00032\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00028\u00018\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00148WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel$SendBuffered;", "E", "Lkotlinx/coroutines/channels/Send;", "", "completeResumeSend", "()V", "Lkotlinx/coroutines/channels/Closed;", "closed", "resumeSendClosed", "(Lkotlinx/coroutines/channels/Closed;)V", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "otherOp", "Lkotlinx/coroutines/internal/Symbol;", "tryResumeSend", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", LottieParams.KEY_ELEMENT_ID, "Ljava/lang/Object;", "", "getPollResult", "()Ljava/lang/Object;", "pollResult", "<init>", "(Ljava/lang/Object;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class SendBuffered<E> extends Send {
        public final E element;

        @Override // kotlinx.coroutines.channels.Send
        public final void completeResumeSend() {
        }

        public SendBuffered(E e) {
            this.element = e;
        }

        @Override // kotlinx.coroutines.channels.Send
        @JvmName(name = "getPollResult")
        /* renamed from: getPollResult  reason: from getter */
        public final Object getElement() {
            return this.element;
        }

        @Override // kotlinx.coroutines.channels.Send
        public final Symbol tryResumeSend(LockFreeLinkedListNode.PrepareOp otherOp) {
            Symbol symbol = CancellableContinuationImplKt.RESUME_TOKEN;
            if (otherOp != null) {
                otherOp.finishPrepare();
            }
            return symbol;
        }

        @Override // kotlinx.coroutines.channels.Send
        public final void resumeSendClosed(Closed<?> closed) {
            if (DebugKt.getASSERTIONS_ENABLED()) {
                throw new AssertionError();
            }
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("SendBuffered@");
            sb.append(DebugStringsKt.getHexAddress(this));
            sb.append('(');
            sb.append(this.element);
            sb.append(')');
            return sb.toString();
        }
    }

    private final Object sendSuspend(E e, Continuation<? super Unit> continuation) {
        SendElementWithUndeliveredHandler sendElementWithUndeliveredHandler;
        CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(continuation));
        CancellableContinuationImpl cancellableContinuationImpl = orCreateCancellableContinuation;
        while (true) {
            if (isFullImpl()) {
                if (this.onUndeliveredElement == null) {
                    sendElementWithUndeliveredHandler = new SendElement(e, cancellableContinuationImpl);
                } else {
                    sendElementWithUndeliveredHandler = new SendElementWithUndeliveredHandler(e, cancellableContinuationImpl, this.onUndeliveredElement);
                }
                Object enqueueSend = enqueueSend(sendElementWithUndeliveredHandler);
                if (enqueueSend == null) {
                    CancellableContinuationKt.removeOnCancellation(cancellableContinuationImpl, sendElementWithUndeliveredHandler);
                    break;
                } else if (enqueueSend instanceof Closed) {
                    helpCloseAndResumeWithSendException(cancellableContinuationImpl, e, (Closed) enqueueSend);
                    break;
                } else if (enqueueSend != AbstractChannelKt.ENQUEUE_FAILED && !(enqueueSend instanceof Receive)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("enqueueSend returned ");
                    sb.append(enqueueSend);
                    throw new IllegalStateException(sb.toString().toString());
                }
            }
            Object offerInternal = offerInternal(e);
            if (offerInternal == AbstractChannelKt.OFFER_SUCCESS) {
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m3179constructorimpl(Unit.INSTANCE));
                break;
            } else if (offerInternal != AbstractChannelKt.OFFER_FAILED) {
                if (offerInternal instanceof Closed) {
                    helpCloseAndResumeWithSendException(cancellableContinuationImpl, e, (Closed) offerInternal);
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("offerInternal returned ");
                    sb2.append(offerInternal);
                    throw new IllegalStateException(sb2.toString().toString());
                }
            }
        }
        Object result = orCreateCancellableContinuation.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }
}
