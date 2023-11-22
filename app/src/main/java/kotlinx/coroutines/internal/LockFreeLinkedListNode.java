package kotlinx.coroutines.internal;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0016\u0018\u00002\u00020\u0001:\u000501234B\u0007¢\u0006\u0004\b/\u0010\u0016J\u0019\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u00060\u0000j\u0002`\u0002¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\t\u001a\u00020\b2\n\u0010\u0003\u001a\u00060\u0000j\u0002`\u00022\n\u0010\u0007\u001a\u00060\u0000j\u0002`\u0002H\u0000¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u00020\b2\n\u0010\u0003\u001a\u00060\u0000j\u0002`\u0002¢\u0006\u0004\b\u000b\u0010\fJ\"\u0010\u000f\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0082\u0010¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0012\u001a\u00060\u0000j\u0002`\u00022\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u0002H\u0082\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0014\u001a\u00020\u00042\n\u0010\u0007\u001a\u00060\u0000j\u0002`\u0002H\u0002¢\u0006\u0004\b\u0014\u0010\u0006J\r\u0010\u0015\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0017\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001a\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0002H\u0000¢\u0006\u0004\b\u001c\u0010\u001bJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J/\u0010&\u001a\u00020%2\n\u0010\u0003\u001a\u00060\u0000j\u0002`\u00022\n\u0010\u0007\u001a\u00060\u0000j\u0002`\u00022\u0006\u0010$\u001a\u00020#H\u0000¢\u0006\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020\b8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\u00018G¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0015\u0010,\u001a\u00060\u0000j\u0002`\u00028G¢\u0006\u0006\u001a\u0004\b+\u0010\u001bR\u0015\u0010.\u001a\u00060\u0000j\u0002`\u00028G¢\u0006\u0006\u001a\u0004\b-\u0010\u001b"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "", "Lkotlinx/coroutines/internal/Node;", "node", "", "addLast", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", HummerConstants.HUMMER_NEXT, "", "addNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "addOneIfEmpty", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "Lkotlinx/coroutines/internal/OpDescriptor;", "op", "correctPrev", "(Lkotlinx/coroutines/internal/OpDescriptor;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "current", "findPrevNonRemoved", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "finishAdd", "helpRemove", "()V", "helpRemovePrev", "remove", "()Z", "removeFirstOrNull", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "removeOrNext", "Lkotlinx/coroutines/internal/Removed;", "removed", "()Lkotlinx/coroutines/internal/Removed;", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "condAdd", "", "tryCondAddNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;)I", "isRemoved", "getNext", "()Ljava/lang/Object;", "getNextNode", "nextNode", "getPrevNode", "prevNode", "<init>", "AbstractAtomicDesc", "AddLastDesc", "CondAddOp", "PrepareOp", "RemoveFirstDesc"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public class LockFreeLinkedListNode {
    static final /* synthetic */ AtomicReferenceFieldUpdater _next$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_next");
    static final /* synthetic */ AtomicReferenceFieldUpdater _prev$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_prev");
    private static final /* synthetic */ AtomicReferenceFieldUpdater _removedRef$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_removedRef");
    volatile /* synthetic */ Object _next = this;
    volatile /* synthetic */ Object _prev = this;
    private volatile /* synthetic */ Object _removedRef = null;

    /* JADX INFO: Access modifiers changed from: private */
    public final Removed removed() {
        Removed removed = (Removed) this._removedRef;
        if (removed == null) {
            Removed removed2 = new Removed(this);
            _removedRef$FU.lazySet(this, removed2);
            return removed2;
        }
        return removed;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b \u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B\u0013\u0012\n\u0010\n\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0015\u0010\n\u001a\u00060\u0002j\u0002`\u00038\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u000b"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "affected", "", "failure", "", "complete", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Ljava/lang/Object;)V", "newNode", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "oldNext", "<init>", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static abstract class CondAddOp extends AtomicOp<LockFreeLinkedListNode> {
        public final LockFreeLinkedListNode newNode;
        public LockFreeLinkedListNode oldNext;

        public CondAddOp(LockFreeLinkedListNode lockFreeLinkedListNode) {
            this.newNode = lockFreeLinkedListNode;
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        public void complete(LockFreeLinkedListNode affected, Object failure) {
            boolean z = failure == null;
            LockFreeLinkedListNode lockFreeLinkedListNode = z ? this.newNode : this.oldNext;
            if (lockFreeLinkedListNode != null && AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(LockFreeLinkedListNode._next$FU, affected, this, lockFreeLinkedListNode) && z) {
                LockFreeLinkedListNode lockFreeLinkedListNode2 = this.newNode;
                LockFreeLinkedListNode lockFreeLinkedListNode3 = this.oldNext;
                Intrinsics.checkNotNull(lockFreeLinkedListNode3);
                lockFreeLinkedListNode2.finishAdd(lockFreeLinkedListNode3);
            }
        }
    }

    @JvmName(name = "isRemoved")
    public boolean isRemoved() {
        return getNext() instanceof Removed;
    }

    @JvmName(name = "getNextNode")
    public final LockFreeLinkedListNode getNextNode() {
        return LockFreeLinkedListKt.unwrap(getNext());
    }

    @JvmName(name = "getPrevNode")
    public final LockFreeLinkedListNode getPrevNode() {
        LockFreeLinkedListNode correctPrev = correctPrev(null);
        return correctPrev == null ? findPrevNonRemoved((LockFreeLinkedListNode) this._prev) : correctPrev;
    }

    private final LockFreeLinkedListNode findPrevNonRemoved(LockFreeLinkedListNode current) {
        while (current.isRemoved()) {
            current = (LockFreeLinkedListNode) current._prev;
        }
        return current;
    }

    public final boolean addOneIfEmpty(LockFreeLinkedListNode node) {
        _prev$FU.lazySet(node, this);
        _next$FU.lazySet(node, this);
        while (getNext() == this) {
            if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(_next$FU, this, this, node)) {
                node.finishAdd(this);
                return true;
            }
        }
        return false;
    }

    public final void addLast(LockFreeLinkedListNode node) {
        do {
        } while (!getPrevNode().addNext(node, this));
    }

    public final boolean addNext(LockFreeLinkedListNode node, LockFreeLinkedListNode next) {
        _prev$FU.lazySet(node, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _next$FU;
        atomicReferenceFieldUpdater.lazySet(node, next);
        if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(atomicReferenceFieldUpdater, this, next, node)) {
            node.finishAdd(next);
            return true;
        }
        return false;
    }

    public final int tryCondAddNext(LockFreeLinkedListNode node, LockFreeLinkedListNode next, CondAddOp condAdd) {
        _prev$FU.lazySet(node, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _next$FU;
        atomicReferenceFieldUpdater.lazySet(node, next);
        condAdd.oldNext = next;
        if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(atomicReferenceFieldUpdater, this, next, condAdd)) {
            return condAdd.perform(this) == null ? 1 : 2;
        }
        return 0;
    }

    /* renamed from: remove */
    public boolean mo4660remove() {
        return removeOrNext() == null;
    }

    public final LockFreeLinkedListNode removeOrNext() {
        Object next;
        LockFreeLinkedListNode lockFreeLinkedListNode;
        do {
            next = getNext();
            if (next instanceof Removed) {
                return ((Removed) next).ref;
            }
            if (next == this) {
                return (LockFreeLinkedListNode) next;
            }
            lockFreeLinkedListNode = (LockFreeLinkedListNode) next;
        } while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(_next$FU, this, next, lockFreeLinkedListNode.removed()));
        lockFreeLinkedListNode.correctPrev(null);
        return null;
    }

    public final void helpRemove() {
        ((Removed) getNext()).ref.helpRemovePrev();
    }

    public final void helpRemovePrev() {
        LockFreeLinkedListNode lockFreeLinkedListNode = this;
        while (true) {
            Object next = lockFreeLinkedListNode.getNext();
            if (next instanceof Removed) {
                lockFreeLinkedListNode = ((Removed) next).ref;
            } else {
                lockFreeLinkedListNode.correctPrev(null);
                return;
            }
        }
    }

    public final LockFreeLinkedListNode removeFirstOrNull() {
        while (true) {
            LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) getNext();
            if (lockFreeLinkedListNode == this) {
                return null;
            }
            if (lockFreeLinkedListNode.mo4660remove()) {
                return lockFreeLinkedListNode;
            }
            lockFreeLinkedListNode.helpRemove();
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u0000*\f\b\u0000\u0010\u0003*\u00060\u0001j\u0002`\u00022\u00020\u0004B\u001b\u0012\n\u0010\u001f\u001a\u00060\u0001j\u0002`\u0002\u0012\u0006\u0010\u001b\u001a\u00028\u0000¢\u0006\u0004\b \u0010\tJ'\u0010\b\u001a\u00020\u00072\n\u0010\u0005\u001a\u00060\u0001j\u0002`\u00022\n\u0010\u0006\u001a\u00060\u0001j\u0002`\u0002H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0010\u001a\u00020\u000f2\n\u0010\u0005\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0006\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0004¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u0016\u001a\u00020\u000e2\n\u0010\u0005\u001a\u00060\u0001j\u0002`\u00022\n\u0010\u0006\u001a\u00060\u0001j\u0002`\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001a\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00028EX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00028\u00008\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001e\u001a\u00060\u0001j\u0002`\u00028EX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0019R\u0018\u0010\u001f\u001a\u00060\u0001j\u0002`\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001c"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "T", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "affected", HummerConstants.HUMMER_NEXT, "", "finishOnSuccess", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "prepareOp", "finishPrepare", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)V", "", "", "retry", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/internal/OpDescriptor;", "op", "takeAffectedNode", "(Lkotlinx/coroutines/internal/OpDescriptor;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "updatedNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "getAffectedNode", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "affectedNode", "node", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "getOriginalNext", "originalNext", SemanticAttributes.MessagingDestinationKindValues.QUEUE, "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static class AddLastDesc<T extends LockFreeLinkedListNode> extends AbstractAtomicDesc {
        private static final /* synthetic */ AtomicReferenceFieldUpdater _affectedNode$FU = AtomicReferenceFieldUpdater.newUpdater(AddLastDesc.class, Object.class, "_affectedNode");
        private volatile /* synthetic */ Object _affectedNode;
        public final T node;
        public final LockFreeLinkedListNode queue;

        public AddLastDesc(LockFreeLinkedListNode lockFreeLinkedListNode, T t) {
            this.queue = lockFreeLinkedListNode;
            this.node = t;
            if (DebugKt.getASSERTIONS_ENABLED()) {
                if (!(t._next == t && t._prev == t)) {
                    throw new AssertionError();
                }
            }
            this._affectedNode = null;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected final LockFreeLinkedListNode takeAffectedNode(OpDescriptor op) {
            return this.queue.correctPrev(op);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        @JvmName(name = "getAffectedNode")
        protected final LockFreeLinkedListNode getAffectedNode() {
            return (LockFreeLinkedListNode) this._affectedNode;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        @JvmName(name = "getOriginalNext")
        /* renamed from: getOriginalNext  reason: from getter */
        protected final LockFreeLinkedListNode getQueue() {
            return this.queue;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected boolean retry(LockFreeLinkedListNode affected, Object next) {
            return next != this.queue;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public void finishPrepare(PrepareOp prepareOp) {
            AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(_affectedNode$FU, this, null, prepareOp.affected);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public Object updatedNext(LockFreeLinkedListNode affected, LockFreeLinkedListNode next) {
            AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(LockFreeLinkedListNode._prev$FU, this.node, this.node, affected);
            AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(LockFreeLinkedListNode._next$FU, this.node, this.node, this.queue);
            return this.node;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected void finishOnSuccess(LockFreeLinkedListNode affected, LockFreeLinkedListNode next) {
            this.node.finishAdd(this.queue);
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\n\u0010\u001f\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b$\u0010%J\u001d\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000b\u001a\u00020\n2\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u00042\n\u0010\t\u001a\u00060\u0003j\u0002`\u0004H\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0012\u001a\u00020\u00112\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0004¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u0018\u001a\u00020\u00062\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u00042\n\u0010\t\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001c\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048EX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001e\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048EX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001bR\u0018\u0010\u001f\u001a\u00060\u0003j\u0002`\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0011\u0010#\u001a\u00028\u00008G¢\u0006\u0006\u001a\u0004\b!\u0010\""}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "T", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "affected", "", "failure", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", HummerConstants.HUMMER_NEXT, "", "finishOnSuccess", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "prepareOp", "finishPrepare", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)V", "", "retry", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/internal/OpDescriptor;", "op", "takeAffectedNode", "(Lkotlinx/coroutines/internal/OpDescriptor;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "updatedNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "getAffectedNode", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "affectedNode", "getOriginalNext", "originalNext", SemanticAttributes.MessagingDestinationKindValues.QUEUE, "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "getResult", "()Ljava/lang/Object;", "result", "<init>", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static class RemoveFirstDesc<T> extends AbstractAtomicDesc {
        private static final /* synthetic */ AtomicReferenceFieldUpdater _affectedNode$FU = AtomicReferenceFieldUpdater.newUpdater(RemoveFirstDesc.class, Object.class, "_affectedNode");
        private static final /* synthetic */ AtomicReferenceFieldUpdater _originalNext$FU = AtomicReferenceFieldUpdater.newUpdater(RemoveFirstDesc.class, Object.class, "_originalNext");
        private volatile /* synthetic */ Object _affectedNode = null;
        private volatile /* synthetic */ Object _originalNext = null;
        public final LockFreeLinkedListNode queue;

        public RemoveFirstDesc(LockFreeLinkedListNode lockFreeLinkedListNode) {
            this.queue = lockFreeLinkedListNode;
        }

        @JvmName(name = "getResult")
        public final T getResult() {
            LockFreeLinkedListNode affectedNode = getAffectedNode();
            Intrinsics.checkNotNull(affectedNode);
            return (T) affectedNode;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected final LockFreeLinkedListNode takeAffectedNode(OpDescriptor op) {
            LockFreeLinkedListNode lockFreeLinkedListNode = this.queue;
            while (true) {
                Object obj = lockFreeLinkedListNode._next;
                if (obj instanceof OpDescriptor) {
                    OpDescriptor opDescriptor = (OpDescriptor) obj;
                    if (op.isEarlierThan(opDescriptor)) {
                        return null;
                    }
                    opDescriptor.perform(this.queue);
                } else {
                    return (LockFreeLinkedListNode) obj;
                }
            }
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        @JvmName(name = "getAffectedNode")
        protected final LockFreeLinkedListNode getAffectedNode() {
            return (LockFreeLinkedListNode) this._affectedNode;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        @JvmName(name = "getOriginalNext")
        /* renamed from: getOriginalNext */
        protected final LockFreeLinkedListNode getQueue() {
            return (LockFreeLinkedListNode) this._originalNext;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected Object failure(LockFreeLinkedListNode affected) {
            if (affected == this.queue) {
                return LockFreeLinkedListKt.getLIST_EMPTY();
            }
            return null;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected final boolean retry(LockFreeLinkedListNode affected, Object next) {
            if (next instanceof Removed) {
                ((Removed) next).ref.helpRemovePrev();
                return true;
            }
            return false;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public void finishPrepare(PrepareOp prepareOp) {
            AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(_affectedNode$FU, this, null, prepareOp.affected);
            AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(_originalNext$FU, this, null, prepareOp.next);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final Object updatedNext(LockFreeLinkedListNode affected, LockFreeLinkedListNode next) {
            return next.removed();
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected final void finishOnSuccess(LockFreeLinkedListNode affected, LockFreeLinkedListNode next) {
            next.correctPrev(null);
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\u0012\n\u0010\u0006\u001a\u00060\fj\u0002`\r\u0012\n\u0010\u0016\u001a\u00060\fj\u0002`\r\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0015\u0010\u0006\u001a\u00060\fj\u0002`\r8\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u000eR\u0018\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u000f8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0016\u001a\u00060\fj\u0002`\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u000e"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "Lkotlinx/coroutines/internal/OpDescriptor;", "", "finishPrepare", "()V", "", "affected", "perform", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/AtomicOp;", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "atomicOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "desc", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", HummerConstants.HUMMER_NEXT, "<init>", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class PrepareOp extends OpDescriptor {
        public final LockFreeLinkedListNode affected;
        public final AbstractAtomicDesc desc;
        public final LockFreeLinkedListNode next;

        public PrepareOp(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2, AbstractAtomicDesc abstractAtomicDesc) {
            this.affected = lockFreeLinkedListNode;
            this.next = lockFreeLinkedListNode2;
            this.desc = abstractAtomicDesc;
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        @JvmName(name = "getAtomicOp")
        public final AtomicOp<?> getAtomicOp() {
            return this.desc.getAtomicOp();
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        public final Object perform(Object affected) {
            Object obj;
            Object obj2;
            if (DebugKt.getASSERTIONS_ENABLED()) {
                if (!(affected == this.affected)) {
                    throw new AssertionError();
                }
            }
            if (affected != null) {
                LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) affected;
                Object onPrepare = this.desc.onPrepare(this);
                if (onPrepare == LockFreeLinkedList_commonKt.REMOVE_PREPARED) {
                    LockFreeLinkedListNode lockFreeLinkedListNode2 = this.next;
                    if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(LockFreeLinkedListNode._next$FU, lockFreeLinkedListNode, this, lockFreeLinkedListNode2.removed())) {
                        this.desc.onRemoved(lockFreeLinkedListNode);
                        lockFreeLinkedListNode2.correctPrev(null);
                    }
                    return LockFreeLinkedList_commonKt.REMOVE_PREPARED;
                }
                if (onPrepare != null) {
                    obj = getAtomicOp().decide(onPrepare);
                } else {
                    obj = getAtomicOp().get_consensus();
                }
                if (obj == AtomicKt.NO_DECISION) {
                    obj2 = getAtomicOp();
                } else if (obj == null) {
                    obj2 = this.desc.updatedNext(lockFreeLinkedListNode, this.next);
                } else {
                    obj2 = this.next;
                }
                AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(LockFreeLinkedListNode._next$FU, lockFreeLinkedListNode, this, obj2);
                return null;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        }

        public final void finishPrepare() {
            this.desc.finishPrepare(this);
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PrepareOp(op=");
            sb.append(getAtomicOp());
            sb.append(')');
            return sb.toString();
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b'\u0010(J#\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\u0010\u000b\u001a\u00060\tj\u0002`\nH\u0014¢\u0006\u0004\b\u0005\u0010\fJ'\u0010\u000e\u001a\u00020\u00062\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\n\u0010\r\u001a\u00060\tj\u0002`\nH$¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0016\u001a\u00020\u00062\n\u0010\u000b\u001a\u00060\tj\u0002`\nH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0018\u0010\u0019J#\u0010\u001b\u001a\u00020\u001a2\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\u0006\u0010\r\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001e\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n2\u0006\u0010\u0003\u001a\u00020\u001dH\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ'\u0010 \u001a\u00020\u00042\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\n\u0010\r\u001a\u00060\tj\u0002`\nH&¢\u0006\u0004\b \u0010!R\u001c\u0010$\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8%X¤\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u001c\u0010&\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8%X¤\u0004¢\u0006\u0006\u001a\u0004\b%\u0010#"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "Lkotlinx/coroutines/internal/AtomicDesc;", "Lkotlinx/coroutines/internal/AtomicOp;", "op", "", "failure", "", "complete", "(Lkotlinx/coroutines/internal/AtomicOp;Ljava/lang/Object;)V", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "affected", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", HummerConstants.HUMMER_NEXT, "finishOnSuccess", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "prepareOp", "finishPrepare", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)V", "onPrepare", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Ljava/lang/Object;", "onRemoved", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", LogConstants.Mpm.EndNodeType.PREPARE, "(Lkotlinx/coroutines/internal/AtomicOp;)Ljava/lang/Object;", "", "retry", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/internal/OpDescriptor;", "takeAffectedNode", "(Lkotlinx/coroutines/internal/OpDescriptor;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "updatedNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "getAffectedNode", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "affectedNode", "getOriginalNext", "originalNext", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static abstract class AbstractAtomicDesc extends AtomicDesc {
        protected Object failure(LockFreeLinkedListNode affected) {
            return null;
        }

        protected abstract void finishOnSuccess(LockFreeLinkedListNode affected, LockFreeLinkedListNode next);

        public abstract void finishPrepare(PrepareOp prepareOp);

        @JvmName(name = "getAffectedNode")
        protected abstract LockFreeLinkedListNode getAffectedNode();

        @JvmName(name = "getOriginalNext")
        /* renamed from: getOriginalNext */
        protected abstract LockFreeLinkedListNode getQueue();

        public void onRemoved(LockFreeLinkedListNode affected) {
        }

        protected boolean retry(LockFreeLinkedListNode affected, Object next) {
            return false;
        }

        public abstract Object updatedNext(LockFreeLinkedListNode affected, LockFreeLinkedListNode next);

        protected LockFreeLinkedListNode takeAffectedNode(OpDescriptor op) {
            LockFreeLinkedListNode affectedNode = getAffectedNode();
            Intrinsics.checkNotNull(affectedNode);
            return affectedNode;
        }

        public Object onPrepare(PrepareOp prepareOp) {
            finishPrepare(prepareOp);
            return null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x0055, code lost:
        
            if (kotlinx.coroutines.DebugKt.getASSERTIONS_ENABLED() == false) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0057, code lost:
        
            if (r4 != null) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0059, code lost:
        
            r7 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x005b, code lost:
        
            r7 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x005c, code lost:
        
            if (r7 == false) goto L35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0064, code lost:
        
            throw new java.lang.AssertionError();
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0065, code lost:
        
            return null;
         */
        @Override // kotlinx.coroutines.internal.AtomicDesc
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object prepare(kotlinx.coroutines.internal.AtomicOp<?> r7) {
            /*
                r6 = this;
            L0:
                r0 = r7
                kotlinx.coroutines.internal.OpDescriptor r0 = (kotlinx.coroutines.internal.OpDescriptor) r0
                kotlinx.coroutines.internal.LockFreeLinkedListNode r0 = r6.takeAffectedNode(r0)
                if (r0 != 0) goto Lc
                java.lang.Object r7 = kotlinx.coroutines.internal.AtomicKt.RETRY_ATOMIC
                return r7
            Lc:
                java.lang.Object r1 = r0._next
                r2 = 0
                if (r1 != r7) goto L12
                return r2
            L12:
                boolean r3 = r7.isDecided()
                if (r3 == 0) goto L19
                return r2
            L19:
                boolean r3 = r1 instanceof kotlinx.coroutines.internal.OpDescriptor
                if (r3 == 0) goto L2c
                kotlinx.coroutines.internal.OpDescriptor r1 = (kotlinx.coroutines.internal.OpDescriptor) r1
                boolean r2 = r7.isEarlierThan(r1)
                if (r2 == 0) goto L28
                java.lang.Object r7 = kotlinx.coroutines.internal.AtomicKt.RETRY_ATOMIC
                return r7
            L28:
                r1.perform(r0)
                goto L0
            L2c:
                java.lang.Object r3 = r6.failure(r0)
                if (r3 == 0) goto L33
                return r3
            L33:
                boolean r3 = r6.retry(r0, r1)
                if (r3 != 0) goto L0
                kotlinx.coroutines.internal.LockFreeLinkedListNode$PrepareOp r3 = new kotlinx.coroutines.internal.LockFreeLinkedListNode$PrepareOp
                r4 = r1
                kotlinx.coroutines.internal.LockFreeLinkedListNode r4 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r4
                r3.<init>(r0, r4, r6)
                java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = kotlinx.coroutines.internal.LockFreeLinkedListNode._next$FU
                boolean r4 = androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(r4, r0, r1, r3)
                if (r4 == 0) goto L0
                java.lang.Object r4 = r3.perform(r0)     // Catch: java.lang.Throwable -> L66
                java.lang.Object r5 = kotlinx.coroutines.internal.LockFreeLinkedList_commonKt.REMOVE_PREPARED     // Catch: java.lang.Throwable -> L66
                if (r4 == r5) goto L0
                boolean r7 = kotlinx.coroutines.DebugKt.getASSERTIONS_ENABLED()     // Catch: java.lang.Throwable -> L66
                if (r7 == 0) goto L65
                if (r4 != 0) goto L5b
                r7 = 1
                goto L5c
            L5b:
                r7 = 0
            L5c:
                if (r7 == 0) goto L5f
                goto L65
            L5f:
                java.lang.AssertionError r7 = new java.lang.AssertionError     // Catch: java.lang.Throwable -> L66
                r7.<init>()     // Catch: java.lang.Throwable -> L66
                throw r7     // Catch: java.lang.Throwable -> L66
            L65:
                return r2
            L66:
                r7 = move-exception
                java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = kotlinx.coroutines.internal.LockFreeLinkedListNode._next$FU
                androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(r2, r0, r3, r1)
                goto L6e
            L6d:
                throw r7
            L6e:
                goto L6d
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc.prepare(kotlinx.coroutines.internal.AtomicOp):java.lang.Object");
        }

        @Override // kotlinx.coroutines.internal.AtomicDesc
        public final void complete(AtomicOp<?> op, Object failure) {
            boolean z = failure == null;
            LockFreeLinkedListNode affectedNode = getAffectedNode();
            if (affectedNode == null) {
                if (DebugKt.getASSERTIONS_ENABLED() && (!z) != true) {
                    throw new AssertionError();
                }
                return;
            }
            LockFreeLinkedListNode queue = getQueue();
            if (queue == null) {
                if (DebugKt.getASSERTIONS_ENABLED() && (!z) != true) {
                    throw new AssertionError();
                }
                return;
            }
            if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(LockFreeLinkedListNode._next$FU, affectedNode, op, z ? updatedNext(affectedNode, queue) : queue) && z) {
                finishOnSuccess(affectedNode, queue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0047, code lost:
    
        if (androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(kotlinx.coroutines.internal.LockFreeLinkedListNode._next$FU, r3, r1, ((kotlinx.coroutines.internal.Removed) r4).ref) == false) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final kotlinx.coroutines.internal.LockFreeLinkedListNode correctPrev(kotlinx.coroutines.internal.OpDescriptor r8) {
        /*
            r7 = this;
        L0:
            java.lang.Object r0 = r7._prev
            kotlinx.coroutines.internal.LockFreeLinkedListNode r0 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r0
            r1 = r0
        L5:
            r2 = 0
            r3 = r2
        L7:
            java.lang.Object r4 = r1._next
            if (r4 != r7) goto L17
            if (r0 != r1) goto Le
            return r1
        Le:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = kotlinx.coroutines.internal.LockFreeLinkedListNode._prev$FU
            boolean r0 = androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(r2, r7, r0, r1)
            if (r0 == 0) goto L0
            return r1
        L17:
            boolean r5 = r7.isRemoved()
            if (r5 == 0) goto L1e
            return r2
        L1e:
            if (r4 != r8) goto L21
            return r1
        L21:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.OpDescriptor
            if (r5 == 0) goto L37
            if (r8 == 0) goto L31
            r0 = r4
            kotlinx.coroutines.internal.OpDescriptor r0 = (kotlinx.coroutines.internal.OpDescriptor) r0
            boolean r0 = r8.isEarlierThan(r0)
            if (r0 == 0) goto L31
            return r2
        L31:
            kotlinx.coroutines.internal.OpDescriptor r4 = (kotlinx.coroutines.internal.OpDescriptor) r4
            r4.perform(r1)
            goto L0
        L37:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.Removed
            if (r5 == 0) goto L50
            if (r3 == 0) goto L4b
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = kotlinx.coroutines.internal.LockFreeLinkedListNode._next$FU
            kotlinx.coroutines.internal.Removed r4 = (kotlinx.coroutines.internal.Removed) r4
            kotlinx.coroutines.internal.LockFreeLinkedListNode r4 = r4.ref
            boolean r1 = androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(r2, r3, r1, r4)
            if (r1 == 0) goto L0
            r1 = r3
            goto L5
        L4b:
            java.lang.Object r1 = r1._prev
            kotlinx.coroutines.internal.LockFreeLinkedListNode r1 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r1
            goto L7
        L50:
            r3 = r4
            kotlinx.coroutines.internal.LockFreeLinkedListNode r3 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r3
            r6 = r3
            r3 = r1
            r1 = r6
            goto L7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.LockFreeLinkedListNode.correctPrev(kotlinx.coroutines.internal.OpDescriptor):kotlinx.coroutines.internal.LockFreeLinkedListNode");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(new PropertyReference0Impl(this) { // from class: kotlinx.coroutines.internal.LockFreeLinkedListNode$toString$1
            @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
            public final Object get() {
                return DebugStringsKt.getClassSimpleName(this.receiver);
            }
        });
        sb.append('@');
        sb.append(DebugStringsKt.getHexAddress(this));
        return sb.toString();
    }

    @JvmName(name = "getNext")
    public final Object getNext() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof OpDescriptor)) {
                return obj;
            }
            ((OpDescriptor) obj).perform(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finishAdd(LockFreeLinkedListNode next) {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        do {
            lockFreeLinkedListNode = (LockFreeLinkedListNode) next._prev;
            if (getNext() != next) {
                return;
            }
        } while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.MyBillsEntityDataFactory(_prev$FU, next, lockFreeLinkedListNode, this));
        if (isRemoved()) {
            next.correctPrev(null);
        }
    }
}
