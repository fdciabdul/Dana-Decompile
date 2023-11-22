package kotlinx.coroutines.internal;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import com.ap.zoloz.hummer.biz.HummerConstants;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0014\b \u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u00020\u0002B\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u0004\u0018\u00018\u00008CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0011\u001a\u0004\u0018\u00018\u00008G¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00028CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0016\u001a\u0004\u0018\u00018\u00008G¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000eR\u0014\u0010\u0018\u001a\u00020\b8'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\fR\u0014\u0010\u001a\u001a\u00028\u00008CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u000e"}, d2 = {"Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "N", "", "", "cleanPrev", "()V", "remove", "value", "", "trySetNext", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)Z", "isTail", "()Z", "getLeftmostAliveNode", "()Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "leftmostAliveNode", "getNext", HummerConstants.HUMMER_NEXT, "getNextOrClosed", "()Ljava/lang/Object;", "nextOrClosed", "getPrev", "prev", "getRemoved", "removed", "getRightmostAliveNode", "rightmostAliveNode", "<init>", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public abstract class ConcurrentLinkedListNode<N extends ConcurrentLinkedListNode<N>> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater _next$FU = AtomicReferenceFieldUpdater.newUpdater(ConcurrentLinkedListNode.class, Object.class, "_next");
    private static final /* synthetic */ AtomicReferenceFieldUpdater _prev$FU = AtomicReferenceFieldUpdater.newUpdater(ConcurrentLinkedListNode.class, Object.class, "_prev");
    private volatile /* synthetic */ Object _next = null;
    private volatile /* synthetic */ Object _prev;

    @JvmName(name = "getRemoved")
    public abstract boolean getRemoved();

    public ConcurrentLinkedListNode(N n) {
        this._prev = n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmName(name = "getNextOrClosed")
    /* renamed from: getNextOrClosed  reason: from getter */
    public final Object get_next() {
        return this._next;
    }

    public final boolean trySetNext(N value) {
        return AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(_next$FU, this, null, value);
    }

    @JvmName(name = "isTail")
    public final boolean isTail() {
        return getNext() == null;
    }

    @JvmName(name = "getPrev")
    public final N getPrev() {
        return (N) this._prev;
    }

    public final void cleanPrev() {
        _prev$FU.lazySet(this, null);
    }

    public final void remove() {
        if (DebugKt.getASSERTIONS_ENABLED() && !getRemoved()) {
            throw new AssertionError();
        }
        if (DebugKt.getASSERTIONS_ENABLED() && (!isTail()) != true) {
            throw new AssertionError();
        }
        while (true) {
            N leftmostAliveNode = getLeftmostAliveNode();
            N rightmostAliveNode = getRightmostAliveNode();
            rightmostAliveNode._prev = leftmostAliveNode;
            if (leftmostAliveNode != null) {
                leftmostAliveNode._next = rightmostAliveNode;
            }
            if (!rightmostAliveNode.getRemoved() && (leftmostAliveNode == null || !leftmostAliveNode.getRemoved())) {
                return;
            }
        }
    }

    @JvmName(name = "getLeftmostAliveNode")
    private final N getLeftmostAliveNode() {
        N prev = getPrev();
        while (prev != null && prev.getRemoved()) {
            prev = (N) prev._prev;
        }
        return prev;
    }

    @JvmName(name = "getRightmostAliveNode")
    private final N getRightmostAliveNode() {
        if (!DebugKt.getASSERTIONS_ENABLED() || (!isTail()) == true) {
            N next = getNext();
            Intrinsics.checkNotNull(next);
            while (next.getRemoved()) {
                next = (N) next.getNext();
                Intrinsics.checkNotNull(next);
            }
            return next;
        }
        throw new AssertionError();
    }

    @JvmName(name = "getNext")
    public final N getNext() {
        Symbol symbol;
        Object obj = get_next();
        symbol = ConcurrentLinkedListKt.CLOSED;
        if (obj == symbol) {
            return null;
        }
        return (N) obj;
    }
}
