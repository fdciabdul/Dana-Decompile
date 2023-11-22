package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u000e\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0011\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b$\u0010%J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u000b\u001a\u00020\u00052\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00028\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u00008WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00008WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010!\u001a\u00020\u00178G¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0011\u0010#\u001a\u00020\u00178G¢\u0006\u0006\u001a\u0004\b\"\u0010 "}, d2 = {"Lkotlinx/coroutines/channels/Closed;", "E", "Lkotlinx/coroutines/channels/Send;", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "value", "", "completeResumeReceive", "(Ljava/lang/Object;)V", "completeResumeSend", "()V", "closed", "resumeSendClosed", "(Lkotlinx/coroutines/channels/Closed;)V", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "otherOp", "Lkotlinx/coroutines/internal/Symbol;", "tryResumeReceive", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "tryResumeSend", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "", "closeCause", "Ljava/lang/Throwable;", "getOfferResult", "()Lkotlinx/coroutines/channels/Closed;", "offerResult", "getPollResult", "pollResult", "getReceiveException", "()Ljava/lang/Throwable;", "receiveException", "getSendException", "sendException", "<init>", "(Ljava/lang/Throwable;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class Closed<E> extends Send implements ReceiveOrClosed<E> {
    public final Throwable closeCause;

    @Override // kotlinx.coroutines.channels.ReceiveOrClosed
    public final void completeResumeReceive(E value) {
    }

    @Override // kotlinx.coroutines.channels.Send
    public final void completeResumeSend() {
    }

    @Override // kotlinx.coroutines.channels.ReceiveOrClosed
    @JvmName(name = "getOfferResult")
    public final Closed<E> getOfferResult() {
        return this;
    }

    @Override // kotlinx.coroutines.channels.Send
    @JvmName(name = "getPollResult")
    public final Closed<E> getPollResult() {
        return this;
    }

    public Closed(Throwable th) {
        this.closeCause = th;
    }

    @JvmName(name = "getSendException")
    public final Throwable getSendException() {
        Throwable th = this.closeCause;
        return th == null ? new ClosedSendChannelException("Channel was closed") : th;
    }

    @JvmName(name = "getReceiveException")
    public final Throwable getReceiveException() {
        Throwable th = this.closeCause;
        return th == null ? new ClosedReceiveChannelException("Channel was closed") : th;
    }

    @Override // kotlinx.coroutines.channels.Send
    public final Symbol tryResumeSend(LockFreeLinkedListNode.PrepareOp otherOp) {
        Symbol symbol = CancellableContinuationImplKt.RESUME_TOKEN;
        if (otherOp != null) {
            otherOp.finishPrepare();
        }
        return symbol;
    }

    @Override // kotlinx.coroutines.channels.ReceiveOrClosed
    public final Symbol tryResumeReceive(E value, LockFreeLinkedListNode.PrepareOp otherOp) {
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
        sb.append("Closed@");
        sb.append(DebugStringsKt.getHexAddress(this));
        sb.append('[');
        sb.append(this.closeCause);
        sb.append(']');
        return sb.toString();
    }
}
