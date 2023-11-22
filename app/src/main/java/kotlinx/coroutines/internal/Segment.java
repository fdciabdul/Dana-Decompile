package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlinx.coroutines.internal.Segment;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b \u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0012\u0004\u0012\u00028\u00000\u0002B!\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u0015\u001a\u0004\u0018\u00018\u0000\u0012\u0006\u0010\u0016\u001a\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\t\u0010\u0005R\u0017\u0010\u000b\u001a\u00020\n8\u0007¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u000f8'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00038WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/internal/Segment;", "S", "Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "", "decPointers$kotlinx_coroutines_core", "()Z", "", "onSlotCleaned", "()V", "tryIncPointers$kotlinx_coroutines_core", "", "id", "J", "getId", "()J", "", "getMaxSlots", "()I", "maxSlots", "getRemoved", "removed", "prev", "pointers", "<init>", "(JLkotlinx/coroutines/internal/Segment;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public abstract class Segment<S extends Segment<S>> extends ConcurrentLinkedListNode<S> {
    private static final /* synthetic */ AtomicIntegerFieldUpdater cleanedAndPointers$FU = AtomicIntegerFieldUpdater.newUpdater(Segment.class, "cleanedAndPointers");
    private volatile /* synthetic */ int cleanedAndPointers;
    private final long id;

    @JvmName(name = "getMaxSlots")
    public abstract int getMaxSlots();

    public Segment(long j, S s, int i) {
        super(s);
        this.id = j;
        this.cleanedAndPointers = i << 16;
    }

    @JvmName(name = "getId")
    public final long getId() {
        return this.id;
    }

    @Override // kotlinx.coroutines.internal.ConcurrentLinkedListNode
    @JvmName(name = "getRemoved")
    public boolean getRemoved() {
        return this.cleanedAndPointers == getMaxSlots() && !isTail();
    }

    public final boolean decPointers$kotlinx_coroutines_core() {
        return cleanedAndPointers$FU.addAndGet(this, -65536) == getMaxSlots() && !isTail();
    }

    public final void onSlotCleaned() {
        if (cleanedAndPointers$FU.incrementAndGet(this) != getMaxSlots() || isTail()) {
            return;
        }
        remove();
    }

    public final boolean tryIncPointers$kotlinx_coroutines_core() {
        int i;
        do {
            i = this.cleanedAndPointers;
            if (!(i != getMaxSlots() || isTail())) {
                return false;
            }
        } while (!cleanedAndPointers$FU.compareAndSet(this, i, 65536 + i));
        return true;
    }
}
