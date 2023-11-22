package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0015\u001a\u00028\u0000\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00032\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00128\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00028\u00008\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018"}, d2 = {"Lkotlinx/coroutines/channels/SendElement;", "E", "Lkotlinx/coroutines/channels/Send;", "", "completeResumeSend", "()V", "Lkotlinx/coroutines/channels/Closed;", "closed", "resumeSendClosed", "(Lkotlinx/coroutines/channels/Closed;)V", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "otherOp", "Lkotlinx/coroutines/internal/Symbol;", "tryResumeSend", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "Lkotlinx/coroutines/CancellableContinuation;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "pollResult", "Ljava/lang/Object;", "getPollResult", "()Ljava/lang/Object;", "<init>", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public class SendElement<E> extends Send {
    public final CancellableContinuation<Unit> cont;
    private final E pollResult;

    @Override // kotlinx.coroutines.channels.Send
    @JvmName(name = "getPollResult")
    public E getPollResult() {
        return this.pollResult;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SendElement(E e, CancellableContinuation<? super Unit> cancellableContinuation) {
        this.pollResult = e;
        this.cont = cancellableContinuation;
    }

    @Override // kotlinx.coroutines.channels.Send
    public Symbol tryResumeSend(LockFreeLinkedListNode.PrepareOp otherOp) {
        Object tryResume = this.cont.tryResume(Unit.INSTANCE, otherOp != null ? otherOp.desc : null);
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

    @Override // kotlinx.coroutines.channels.Send
    public void completeResumeSend() {
        this.cont.completeResume(CancellableContinuationImplKt.RESUME_TOKEN);
    }

    @Override // kotlinx.coroutines.channels.Send
    public void resumeSendClosed(Closed<?> closed) {
        CancellableContinuation<Unit> cancellableContinuation = this.cont;
        Result.Companion companion = Result.INSTANCE;
        cancellableContinuation.resumeWith(Result.m3179constructorimpl(ResultKt.createFailure(closed.getSendException())));
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DebugStringsKt.getClassSimpleName(this));
        sb.append('@');
        sb.append(DebugStringsKt.getHexAddress(this));
        sb.append('(');
        sb.append(getPollResult());
        sb.append(')');
        return sb.toString();
    }
}
