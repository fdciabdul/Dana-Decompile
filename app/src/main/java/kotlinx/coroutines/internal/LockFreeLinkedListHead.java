package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0006\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0007"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "", "remove", "()Ljava/lang/Void;", "", "isEmpty", "()Z", "isRemoved", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public class LockFreeLinkedListHead extends LockFreeLinkedListNode {
    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    @JvmName(name = "isRemoved")
    public boolean isRemoved() {
        return false;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    /* renamed from: remove  reason: collision with other method in class */
    public /* synthetic */ boolean mo4660remove() {
        return ((Boolean) remove()).booleanValue();
    }

    @JvmName(name = "isEmpty")
    public final boolean isEmpty() {
        return getNext() == this;
    }

    public final Void remove() {
        throw new IllegalStateException("head cannot be removed".toString());
    }
}
